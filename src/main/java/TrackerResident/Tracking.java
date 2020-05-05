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

import java.io.*;
import java.util.*;

@Service
public class Tracking {
    Map<String, List<Coordinate>> map = new HashMap<>();

    /**
     *
     * @return Coordonnées de chaque pièce
     * @throws Exception Ex
     */
    public Map<String, List<Coordinate>> parseMapJson() throws Exception {
        /*File currentDirectory = new File(new File(".").getAbsolutePath());
        File filePath = new File(currentDirectory.getCanonicalPath() + "/src/main/java/TrackerResident/json/map_correcte.json");

        Object parse = new JSONParser().parse(new FileReader(filePath));
        JSONObject obj = (JSONObject) parse;

        JSONArray arr = (JSONArray) obj.get("features");*/
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        InputStream inputStream = null;
        inputStream = getClass().getClassLoader()
                .getResourceAsStream("json/map_correcte.json");
        if (inputStream != null) {
            BufferedReader streamReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            obj = (JSONObject) parser.parse(responseStrBuilder.toString());
        }

        JSONArray arr = (JSONArray) obj.get("features");

        for (int i = 0; i < arr.size(); i++) {
            JSONObject o = (JSONObject) arr.get(i);
            JSONObject g = (JSONObject) o.get("geometry");
            String t = (String) g.get("type");
            //JSONObject  = (JSONObject) arr.get(i);
            if (t.equals("Polygon")) {
                JSONArray coordinates = (JSONArray) g.get("coordinates");
                JSONObject properties = (JSONObject) o.get("properties");
                String cp1 = properties.get("roomType").toString();
                String cp2 = properties.get("num").toString();
                String cle = cp1.concat(cp2);
                List<Coordinate> coords = new ArrayList<>();
                JSONArray jArray = (JSONArray) coordinates.get(0);
                for (int j = 0; j < jArray.size(); j++) {
                    JSONArray array = (JSONArray) coordinates.get(0);
                    JSONArray test = (JSONArray) array.get(j);
                    Coordinate coor = new Coordinate(Double.parseDouble(test.get(1).toString()), Double.parseDouble(test.get(0).toString()));
                    coords.add(coor);
                }
                map.put(cle, coords);
            }
        }
        return map;
    }

    public Map<String, List<Coordinate>> parseWallsJson() throws Exception {
        Map<String, List<Coordinate>> allWalls = new HashMap<>();;
       /* File currentDirectory = new File(new File(".").getAbsolutePath());
        File filePath = new File(currentDirectory.getCanonicalPath() + "/src/main/java/TrackerResident/json/walls.json");

        Object parse = new JSONParser().parse(new FileReader(filePath));
        JSONObject obj = (JSONObject) parse;
        JSONArray arr = (JSONArray) obj.get("walls");*/

        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        InputStream inputStream = null;
        inputStream = getClass().getClassLoader()
                .getResourceAsStream("json/walls.json");
        if (inputStream != null) {
            BufferedReader streamReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            obj = (JSONObject) parser.parse(responseStrBuilder.toString());
        }

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


    public boolean isInTheLivingRoom(Coordinate coor) {
        List<Coordinate> coordsam = map.get("salleAManger1");
        return (coor.getLongitude() > coordsam.get(3).getLongitude() && coor.getLongitude() < coordsam.get(1).getLongitude()
        && coor.getLatitude() > coordsam.get(2).getLatitude() && coor.getLatitude() < coordsam.get(0).getLatitude());
    }

    public boolean isInTheRoom(Coordinate coordinate) {
        List<Coordinate> coordsam = map.get("chambre3");

        return (coordinate.getLatitude() > coordsam.get(2).getLatitude() && coordinate.getLatitude() < coordsam.get(0).getLatitude() &&
                 coordinate.getLongitude() > coordsam.get(3).getLongitude() && coordinate.getLongitude() < coordsam.get(1).getLongitude());

    }


}


