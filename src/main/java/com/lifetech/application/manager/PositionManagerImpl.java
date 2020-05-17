package com.lifetech.application.manager;

import TrackerResident.Coordinate;
import TrackerResident.Tracking;
import com.lifetech.application.dto.PositionDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PositionDAO;
import com.lifetech.domain.dao.StrapDAO;
import com.lifetech.domain.model.Position;
import com.lifetech.domain.model.Strap;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import net.sf.geographiclib.GeodesicLine;
import net.sf.geographiclib.GeodesicMask;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PositionManagerImpl implements PositionManager {
    private final PositionDAO positionDAO;
    private final OrikaBeanMapper orikaBeanMapper;
    private final StrapDAO strapDAO;


    public PositionManagerImpl(PositionDAO positionDAO, OrikaBeanMapper orikaBeanMapper, StrapDAO strapDAO, EntityManager em) {
        this.positionDAO = positionDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.strapDAO = strapDAO;
    }

    /**
     * trouve la position d'un bracelet.
     * @param strapId id du bracelet
     * @return PositionDTO
     */
    @Override
    public PositionDTO findPositionByStrap(long strapId) {
        Position p = positionDAO.findPositionByStrap(strapId);
        return orikaBeanMapper.map(p, PositionDTO.class);
    }

    /**
     * récupère tous les bracelets, crée pour chaque bracelet et simule sa position.
     */
    public void insertPositionRunnerStrap() {
        List<Strap> straps = strapDAO.findAll();
        for (Strap strap : straps) {
            new Thread(() -> {
                try {
                    this.simulatePosition(strap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    /**
     * Génère une nouvelle position.
     * @param strap
     * @throws Exception Exception
     */
    public void simulatePosition(Strap strap) throws Exception {
        Tracking tracking = new Tracking();
        Map<String, List<Coordinate>> map = tracking.parseMapJson();
        List<Coordinate> chemin = map.get("chemin-" + strap.getId());
        if (chemin != null) {
            Geodesic geod = Geodesic.WGS84;
            double lat1 = 0, lon1 = 0, lat2 = 0, lon2 = 0;
            for (int j = 0; j < chemin.size() - 1; j++) {
                lat1 = chemin.get(j).getLatitude();
                lon1 = chemin.get(j).getLongitude(); // JFK
                lat2 = chemin.get(j + 1).getLatitude();
                lon2 = chemin.get(j + 1).getLongitude(); // SIN
                GeodesicLine line = geod.InverseLine(lat1, lon1, lat2, lon2,
                        GeodesicMask.DISTANCE_IN |
                                GeodesicMask.LATITUDE |
                                GeodesicMask.LONGITUDE);
                double ds0 = 1;     // Nominal distance between points = 500 km
                // The number of intervals
                int num = (int) (Math.ceil(line.Distance() / ds0));
                {
                    // Use intervals of equal length
                    double ds = line.Distance() / num;
                    for (int i = 0; i <= num; ++i) {
                        GeodesicData g = line.Position(i * ds,
                                GeodesicMask.LATITUDE |
                                        GeodesicMask.LONGITUDE);
                        this.saveData(g.lat2, g.lon2, strap);
                        Thread.sleep(750);
                    }
                }
            }
        }
    }

    /**
     * Enregistre les positions d'un bracelet.
     * @param lat latitude du bracelet
     * @param lon longitude du bracelet
     * @param strap
     */
    public void saveData(Double lat, Double lon, Strap strap) {
        try {
            Position p = new Position();
            p.setDate(new Date());
            p.setLongitude(lon);
            p.setLatitude(lat);
            p.setStrap(strap);
            this.positionDAO.save(p);

        } catch (Exception n) {
            System.out.println(n.getMessage());
        }
    }

    /**
     * Retourne les 30 dernières d'un bracelet.
     * @param strapId id du bracelet
     * @return List<PositionDTO>
     */
    @Override
    public List<PositionDTO> positionHistory(long strapId) {
        List<PositionDTO> positions = orikaBeanMapper.mapAsList(positionDAO.positionHistory(strapId), PositionDTO.class);
        return positions.stream().sorted((p1, p2) -> p1.getDate().compareTo(p2.getDate())).collect(Collectors.toList());
    }

}
