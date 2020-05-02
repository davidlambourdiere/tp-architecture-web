package com.lifetech.application.manager;

import TrackerResident.Coordinate;
import TrackerResident.Tracking;
import com.lifetech.application.dto.PositionDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PositionDAO;
import com.lifetech.domain.dao.StrapDAO;
import com.lifetech.domain.model.Position;
import com.lifetech.domain.model.Strap;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PositionManagerImpl implements PositionManager {
    private final PositionDAO positionDAO;
    private final OrikaBeanMapper orikaBeanMapper;
    private final StrapDAO strapDAO;

    public PositionManagerImpl(PositionDAO positionDAO, OrikaBeanMapper orikaBeanMapper, StrapDAO strapDAO) {
        this.positionDAO = positionDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.strapDAO = strapDAO;
    }

    public PositionDAO getPositionDAO() {
        return positionDAO;
    }

    public StrapDAO getStrapDAO() {
        return strapDAO;
    }

    @Override
    public PositionDTO findPositionByStrap(long strapId) {
        Position p = positionDAO.findPositionByStrap(strapId);
        return orikaBeanMapper.map(p, PositionDTO.class);
    }

    public void simulatePosition(long idRoom) throws Exception {
        /**
         * etape 1  definir limite chambre
         * etape 2 place le vieux sur poin random dans la chambre
         * etape 3 definir salle a manger
         * etape 4 sortir de la chambre def mur couloir
         */

        // Comment faire pour distinguer la salle à manger d'une chambre en sachant que l'on seulement l'id de la room ?


        Tracking tracking = new Tracking();
        Map<String, List<Coordinate>> map = tracking.parseMapJson();
        Map<String, List<Coordinate>> walls = tracking.parseWallsJson();

        map.get("chambre3");
        List<Coordinate> coords = map.get("chambre3");
        List<Coordinate> murSortie = new ArrayList<>();
        murSortie.add(new Coordinate(coords.get(0).getLatitude(), coords.get(0).getLongitude()));
        murSortie.add(new Coordinate(coords.get(1).getLatitude(), coords.get(1).getLongitude()));
        Random x = new Random();
        Random y = new Random();
        Double lat = x.doubles((Double) coords.get(0).getLatitude(), ((Double) coords.get(2).getLatitude())).findFirst().getAsDouble();
        Double longi = y.doubles((Double) coords.get(0).getLongitude(), ((Double) coords.get(3).getLongitude())).findFirst().getAsDouble();
        System.out.println(lat + "," + longi);

        List<Coordinate> coordsam = map.get("salle à manger1");
        List<Coordinate> murSortieSam = new ArrayList<>();
        murSortieSam.add(new Coordinate(coords.get(2).getLatitude(), coords.get(2).getLongitude()));
        murSortieSam.add(new Coordinate(coords.get(3).getLatitude(), coords.get(3).getLongitude()));
        Coordinate coor = new Coordinate(lat, longi);
        int mooveY = 0;
        Double moove = 0.00001;
        Date d = new Date();
        System.out.println(d);
        while (!tracking.isInTheLivingRoom(coor)) {
            Thread.sleep(1600);
           /* if (mooveY < 25) {
                coor.setLongitude(coor.getLongitude() - moove);
                mooveY++;
            }
            coor.setLatitude(coor.getLatitude() - moove);
            System.out.println(strapDAO);
            Optional<Strap> strap2 = strapDAO.findById(1L);
            Position p = new Position();
            p.setDate(new Date());
            p.setLatitude(Float.parseFloat(coor.getLatitude().toString()));
            p.setLongitude(Float.parseFloat(coor.getLongitude().toString()));
            p.setStrap(strap2.get());
            System.out.println(p);
            this.positionDAO.save(p);
            System.out.println(coor.toString());*/
        }
        Date d2 = new Date();
        System.out.println(d2);
    }
}
