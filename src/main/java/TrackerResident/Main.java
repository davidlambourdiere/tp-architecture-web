package TrackerResident;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        Tracking t = new Tracking();

        try {
            t.simulatePosition(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
