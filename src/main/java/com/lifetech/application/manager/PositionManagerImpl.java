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

    /**
     * Génère une nouvelle position
     * @throws Exception Exception
     */
    public void simulatePosition() throws Exception {
        /**
         * etape 1  definir limite chambre
         * etape 2 place le vieux sur poin random dans la chambre
         * etape 3 definir salle a manger
         * etape 4 sortir de la chambre def mur couloir
         */

        Tracking tracking = new Tracking();
        Map<String, List<Coordinate>> map = tracking.parseMapJson();
        Map<String, List<Coordinate>> walls = tracking.parseWallsJson();

        map.get("chambre3");
        List<Coordinate> coords = map.get("chambre3");
        Random x = new Random();
        Random y = new Random();
        Double longi = x.doubles((Double) coords.get(0).getLongitude() + 0.00001, ((Double) coords.get(2).getLongitude())).findFirst().getAsDouble();
        Double lat = y.doubles((Double) coords.get(2).getLatitude(), ((Double) coords.get(0).getLatitude())).findFirst().getAsDouble();


        Coordinate coor = new Coordinate(lat, longi);
        System.out.println(coords);
        Double move = 0.00001;
        Coordinate exitMinDoor = new Coordinate(walls.get("chambre3").get(0).getLongitude(), walls.get("chambre3").get(1).getLatitude());
        Coordinate exitMaxDoor = new Coordinate(walls.get("chambre3").get(1).getLongitude(), walls.get("chambre3").get(0).getLatitude());
        System.out.println("coor debut : " + coor);
        Strap strap2 = strapDAO.findById(Long.parseLong("1")).orElse(null);
        while (tracking.isInTheRoom(coor)) {
            Position p = new Position();
            p.setDate(new Date());
            p.setLongitude(Float.parseFloat(coor.getLongitude().toString()));
            p.setLatitude(Float.parseFloat(coor.getLatitude().toString()));
            p.setStrap(strap2);
            this.positionDAO.save(p);
            if (coor.getLongitude() < exitMinDoor.getLongitude()) {
                coor.setLongitude(coor.getLongitude() + move);
            }
            coor.setLatitude(coor.getLatitude() - move);
            System.out.println("pos : " + p);
            Thread.sleep(3000);
        }
        System.out.println("fin");
        System.out.println("coor fin : " + coor);
        int i = 0;

        while (!tracking.isInTheLivingRoom(coor)) {
            Thread.sleep(1600);
            if (isNextFootStepPossible(coor, walls)) {
                if (i < 2) {
                    coor.setLongitude(coor.getLongitude() - move);
                    i++;
                    Position p = new Position();
                    p.setDate(new Date());
                    p.setLongitude(Float.parseFloat(coor.getLongitude().toString()));
                    p.setLatitude(Float.parseFloat(coor.getLatitude().toString()));
                    p.setStrap(strap2);
                    this.positionDAO.save(p);
                } else {
                    coor.setLatitude(coor.getLatitude() - move);
                    Position p = new Position();
                    p.setDate(new Date());
                    p.setLongitude(Float.parseFloat(coor.getLongitude().toString()));
                    p.setLatitude(Float.parseFloat(coor.getLatitude().toString()));
                    p.setStrap(strap2);
                    this.positionDAO.save(p);

                    i = 0;
                }
            } else {
                System.out.println("Toujours dans le bloc sa mèwe");
                coor.setLatitude(coor.getLatitude() + move);
                coor.setLongitude(coor.getLongitude() - move);
                Position p = new Position();
                p.setDate(new Date());
                p.setLongitude(Float.parseFloat(coor.getLongitude().toString()));
                p.setLatitude(Float.parseFloat(coor.getLatitude().toString()));
                p.setStrap(strap2);
                this.positionDAO.save(p);

            }
            System.out.println("hello");
        }
        this.simulatePosition();

    }


    /**
     * Retourne vrai si le prochain pas est possible
     * @param coordinate Coordonnée
     * @param walls Murs de la maison de retraite
     * @return boolean
     */
    public boolean isNextFootStepPossible(Coordinate coordinate, Map<String, List<Coordinate>> walls) {
        Coordinate forbiddenWall2 = new Coordinate(walls.get("couloir").get(1).getLongitude(), walls.get("couloir").get(1).getLatitude());
        System.out.println(coordinate.getLongitude() + "--------------------------------------");
        System.out.println(forbiddenWall2.getLongitude() + "--------------------------------------");
        return (coordinate.getLongitude() > forbiddenWall2.getLongitude());
    }
}
