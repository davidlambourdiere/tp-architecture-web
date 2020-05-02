package TrackerResident;


//import com.google.gson.JsonParser;
//import com.google.gson.stream.JsonReader;

//import org.json.JSONArray;

import com.lifetech.domain.dao.PositionDAO;
import com.lifetech.domain.dao.StrapDAO;
import com.lifetech.domain.model.Position;
import com.lifetech.domain.model.Strap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class Tracking {
    Map<String, List<Coordinate>> map = new HashMap<>();




    public Map<String, List<Coordinate>> parseMapJson() throws Exception {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File filePath = new File(currentDirectory.getCanonicalPath() + "/src/main/java/TrackerResident/json/map.json");

        Object parse = new JSONParser().parse(new FileReader(filePath));
        JSONObject obj = (JSONObject) parse;

        System.out.println();
        JSONArray arr = (JSONArray) obj.get("features");


        for (int i = 0; i < arr.size(); i++) {
            JSONObject o = (JSONObject) arr.get(i);
            JSONObject g = (JSONObject) o.get("geometry");
            String t = (String) g.get("type");
            //JSONObject  = (JSONObject) arr.get(i);
            if (t.equals("Polygon")) {
                JSONArray coordinates = (JSONArray) g.get("coordinates");
                JSONObject properties = (JSONObject) o.get("properties");
                System.out.println(properties);
                String cp1 = properties.get("type").toString();
                String cp2 = properties.get("num").toString();
                System.out.println(t);
                System.out.println(cp2);
                String cle = cp1.concat(cp2);
                List<Coordinate> coords = new ArrayList<>();
                JSONArray jArray = (JSONArray) coordinates.get(0);
                for (int j = 0; j < jArray.size(); j++) {
                    JSONArray array = (JSONArray) coordinates.get(0);
                    JSONArray test = (JSONArray) array.get(j);
                    Coordinate coor = new Coordinate((Double) test.get(0), (Double) test.get(1));
                    coords.add(coor);
                }
                map.put(cle, coords);
            }
        }
        return map;
    }

    public Map<String, List<Coordinate>> parseWallsJson() throws Exception {
        Map<String, List<Coordinate>> allWalls = new HashMap<>();;
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File filePath = new File(currentDirectory.getCanonicalPath() + "/src/main/java/TrackerResident/json/walls.json");

        Object parse = new JSONParser().parse(new FileReader(filePath));
        JSONObject obj = (JSONObject) parse;
        JSONArray arr = (JSONArray) obj.get("walls");
        for (int i = 0; i < arr.size(); i++) {
            List<Coordinate> roomCoordsList = new ArrayList<>();
            JSONObject wall = (JSONObject) arr.get(i);
            String room = wall.get("room").toString();
            JSONArray roomCoords = (JSONArray) wall.get("coordinates");
            for (int j = 0; j < roomCoords.size(); j++) {
                JSONArray aCoordinate = (JSONArray) roomCoords.get(j);
                Coordinate coor = new Coordinate((Double) aCoordinate.get(0), (Double) aCoordinate.get(1));
                roomCoordsList.add(coor);
            }

            allWalls.put(room, roomCoordsList);
        }

        return allWalls;
    }

   /* public void simulatePosition (long idRoom) throws Exception {
        /**
         * etape 1  definir limite chambre
         * etape 2 place le vieux sur poin random dans la chambre
         * etape 3 definir salle a manger
         * etape 4 sortir de la chambre def mur couloir

        parseJson();
        map.get("chambre3");
        List<Coordinate> coords = map.get("chambre3");
        List<Coordinate> murSortie = new ArrayList<>();
        murSortie.add(new Coordinate(coords.get(0).getLatitude(),coords.get(0).getLongitude()));
        murSortie.add(new Coordinate(coords.get(1).getLatitude(),coords.get(1).getLongitude()));
        Random x = new Random();
        Random y = new Random();
        Double lat = x.doubles((Double)coords.get(0).getLatitude(),((Double)coords.get(2).getLatitude())).findFirst().getAsDouble();
        Double longi = y.doubles((Double)coords.get(0).getLongitude(),((Double)coords.get(3).getLongitude())).findFirst().getAsDouble();
        System.out.println(lat + "," + longi);

        List<Coordinate> coordsam = map.get("salle à manger1");
        List<Coordinate> murSortieSam = new ArrayList<>();
        murSortieSam.add(new Coordinate(coords.get(2).getLatitude(),coords.get(2).getLongitude()));
        murSortieSam.add(new Coordinate(coords.get(3).getLatitude(),coords.get(3).getLongitude()));
        Coordinate coor = new Coordinate(lat, longi);
        int mooveY = 0;
        Double moove =  0.00001;
        Date d = new Date();
        System.out.println(d);
        while(!isInTheLivingRoom(coor)){
            Thread.sleep(1600);
            if(mooveY < 25){
                coor.setLongitude(coor.getLongitude()- moove);
                mooveY++;
            }
            coor.setLatitude(coor.getLatitude() - moove);
            System.out.println(strapDAO);
            Optional<Strap> strap2 = strapDAO.findById(1L);
            Position p = new Position(new Date(), Float.parseFloat(coor.getLatitude().toString()), Float.parseFloat(coor.getLongitude().toString()));
            p.setStrap(strap2.get());
            this.positionDAO.save(p);
            System.out.println(coor.toString());
        }
        Date d2 = new Date();
        System.out.println(d2);
    } */

    public boolean isInTheLivingRoom(Coordinate coor) {
        List<Coordinate> coordsam = map.get("salle à manger1");
        List<Coordinate> murSortieSam = new ArrayList<>();
        murSortieSam.add(new Coordinate(coordsam.get(2).getLatitude(),coordsam.get(2).getLongitude()));
        murSortieSam.add(new Coordinate(coordsam.get(3).getLatitude(),coordsam.get(3).getLongitude()));
        return (coor.getLatitude() > coordsam.get(2).getLatitude() && coor.getLatitude() < coordsam.get(0).getLatitude());
    }
}


