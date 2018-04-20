package Model;

import android.content.Context;
import android.content.ContextWrapper;

import java.util.Objects;

/**
 * Created by Brandon on 3/17/2018.
 */

public class mapData extends ContextWrapper {

    TinyDB tinydb = new TinyDB(getApplicationContext());
    mapLocations locations = new mapLocations(getApplicationContext());

    //TODO: need to find bug in usTroopsAvail for "Short Scenario", displays only have 12 available, but should be 14
    int usTroopsAvail = 40;
    int usSFAvail = 6;
    int usBaseAvail = 6;

    int arvnTroopsAvail = 30;
    int arvnPoliceAvail = 30;
    int arvnRangersAvail = 6;
    int arvnBaseAvail = 3;

    int nvaTroopsAvail = 40;
    int nvaGuerrillasAvail = 20;
    int nvaBasesAvail = 9;

    int vcGuerrillasAvail = 30;
    int vcBasesAvail = 9;

    // Out of Play variables
    int usTroopsOutOfPlay = 0;
    int usBasesOutOfPlay = 0;
    int arvnTroopsOutOfPlay = 0;
    int arvnRangersOutOfPlay = 0;
    int arvnBasesOutOfPlay = 0;


    String scenario;


    public mapData(Context base) {
        super(base);
    }


    public void initGameScenario() {
        scenario = tinydb.getString("gameScenario");

        if (Objects.equals(scenario, new String("Short Game"))) {
            locations.initMapLocations("Da Nang","coin control", "active support",0,3,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Kontum","coin control", "active support",0,3,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1,"city","na");
            locations.initMapLocations("Saigon","coin control", "active support",1,3,0,0,0,4,2,1,0,0,0,0,0,0,0,0,0,false, 6,"city","na");
            locations.initMapLocations("Can Tho","coin control", "active support",1,3,0,0,0,4,2,1,0,0,0,0,0,0,0,0,0,false, 1,"city","na");
            locations.initMapLocations("Quang Tri","nva control", "active opposition",0,0,0,0,1,2,0,0,0,1,0,4,0,0,0,0,0,false, 2,"province", "lowland");
            locations.initMapLocations("Quang Nam","coin control", "neutral",0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0, false, 1,"province", "highland");
            locations.initMapLocations("Quang Tin","coin control", "neutral",0,2,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0, false, 2,"province", "lowland");
            locations.initMapLocations("Binh Dinh", "coin control", "passive support",1,4,1,0,0,2,1,0,0,0,0,0,0,1,0,2,0,false, 2, "province", "highland" );
            locations.initMapLocations("Pleiku","uncontrolled", "neutral",1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,2,0,false, 1, "province", "highland");
            locations.initMapLocations("Khanh Hoa","coin control", "neutral",0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,false, 1, "province", "highland");
            locations.initMapLocations("Hue","coin control", "neutral",0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,false, 2, "city","na");
            locations.initMapLocations("Kien Hoa","coin control", "neutral",0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,false, 2, "province", "lowland");
            locations.initMapLocations("Ba Xuyen","coin control", "neutral",0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,false, 1, "province", "lowland");
            locations.initMapLocations("An Loc","coin control", "passive support",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1, "city","na");
            locations.initMapLocations("Qui Nhon","coin control", "passive support",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1, "city","na");
            locations.initMapLocations("Cam Ranh","coin control", "passive support",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1, "city","na");
            locations.initMapLocations("Binh Tuy","uncontrolled", "passive support",0,2,0,0,0,0,1,0,0,0,0,0,0,1,0,2,0,false, 1, "province", "jungle");
            locations.initMapLocations("Quang Duc","uncontrolled", "active opposition",0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,2,0,false, 1, "province", "jungle");
            locations.initMapLocations("Tay Ninh","uncontrolled", "active opposition",0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,2,0,false, 2, "province", "jungle");
            locations.initMapLocations("Kien Phong", "uncontrolled", "active opposition", 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,false, 2,"province", "lowland");
            locations.initMapLocations("Kien Giang", "uncontrolled", "active opposition", 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,false, 2,"province", "lowland");
            locations.initMapLocations("North Vietnam", "nva control", "neutral", 0,0,0,0,0,0,0,0,0,2,6,1,0,0,0,0,0,false, 0,"province", "jungle");
            locations.initMapLocations("Southern Laos", "nva control", "neutral", 0,0,0,0,0,0,0,0,0,2,6,1,0,0,0,0,0,false, 0,"province", "jungle");
            locations.initMapLocations("Central Laos", "nva control", "neutral", 0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0,false, 0,"province", "jungle");
            locations.initMapLocations("The Fishhook", "nva control", "neutral", 0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0,false, 0,"province", "jungle");
            locations.initMapLocations("The Parrot's Beak", "nva control", "neutral", 0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0,false, 0,"province", "jungle");

            usTroopsOutOfPlay = 6;
            arvnTroopsOutOfPlay = 10;
            arvnRangersOutOfPlay = 3;

        } else if (Objects.equals(scenario, new String("Medium Game"))) {
            locations.initMapLocations("North Vietnam", "nva control", "neutral", 0,0,0,0,0,0,0,0,0,1,9,1,0,0,0,0,0,false, 0,"province", "highland");
            locations.initMapLocations("Central Laos", "nva control", "neutral", 0,0,0,0,0,0,0,0,0,1,9,1,0,0,0,0,0,false, 0,"province", "jungle");
            locations.initMapLocations("Quang Tri", "coin control", "passive support", 1,4,1,0,0,3,0,0,0,1,0,3,0,0,0,0,0,false, 2,"province", "highland");
            locations.initMapLocations("Quang Nam", "uncontrolled", "active opposition", 0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,0,false, 1,"province", "highland");
            locations.initMapLocations("Hue", "coin control", "passive support", 0,1,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,false, 2,"city", "na");
            locations.initMapLocations("Da Nang", "coin control", "passive support", 0,1,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,false, 1,"city","na");
            locations.initMapLocations("Qui Nhon", "coin control", "passive support", 0,1,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Cam Ranh", "coin control", "passive support", 0,1,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Quang Tin", "coin control", "passive support", 1,2,0,0,0,2,1,0,0,0,0,0,0,0,0,0,0,false, 2,"province", "lowland");
            locations.initMapLocations("Kontum", "coin control", "passive support", 1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Binh Dinh", "coin control", "active support", 0,2,1,0,0,0,1,0,0,0,0,0,0,1,0,2,0,false, 2,"province", "highland");
            locations.initMapLocations("Pleiku", "coin control", "active support", 0,2,1,0,0,0,1,0,0,0,0,0,0,1,0,2,0,false, 1,"province", "highland");
            locations.initMapLocations("Khanh Hoa", "coin control", "active support", 0,2,1,0,0,0,1,0,0,0,0,0,0,1,0,2,0,false, 1,"province", "highland");
            locations.initMapLocations("Phu Bon", "coin control", "passive support", 0,3,0,0,0,2,2,0,0,0,0,0,0,0,0,2,0,false,1,"province", "lowland");
            locations.initMapLocations("Binh Tuy", "coin control", "neutral",1,2,0,0,0,3,1,0,0,0,0,0,0,1,0,2,0,false,1,"province", "jungle");
            locations.initMapLocations("Saigon", "coin control", "active support",1,2,0,0,0,1,4,1,0,0,0,0,0,1,0,1,0,false,6,"city", "na");
            locations.initMapLocations("Quang Duc", "coin control", "neutral",0,0,0,0,0,2,1,0,0,0,0,0,0,0,0,1,0,false,1,"province", "jungle");
            locations.initMapLocations("Phuoc Long", "uncontrolled", "neutral",0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,2,0,false,0,"province", "jungle");
            locations.initMapLocations("Tay Ninh", "coin control", "active opposition",1,3,0,0,0,2,0,1,0,0,0,2,0,0,1,3,0,false,2,"province", "jungle");
            locations.initMapLocations("An Loc", "coin control", "neutral",0,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,false,1,"city", "na");
            locations.initMapLocations("Can Tho", "coin control", "passive support",0,3,1,0,0,2,1,0,0,0,0,0,0,0,0,0,0,false,1,"city", "na");
            locations.initMapLocations("Kien Phong", "uncontrolled", "passive opposition",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,false,2,"province", "lowland");
            locations.initMapLocations("Kien Hoa", "uncontrolled", "passive opposition",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,false,2,"province", "lowland");
            locations.initMapLocations("Ba Xuyen", "uncontrolled", "passive opposition",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,false,1,"province", "lowland");
            locations.initMapLocations("Kien Giang", "coin control", "active opposition",0,0,0,0,1,2,0,1,0,0,0,0,0,0,0,1,0,false,2,"province", "lowland");
            locations.initMapLocations("Southern Laos", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0,false,0,"province", "jungle");
            locations.initMapLocations("Northeast Cambodia", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0,false,0,"province", "jungle");
            locations.initMapLocations("The Fishhook", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0,false,0,"province", "jungle");
            locations.initMapLocations("The Parrot's Beak", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0,false,0,"province", "jungle");
            locations.initMapLocations("Sihanoukville", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0,false,0,"province", "jungle");

            usTroopsOutOfPlay = 5;
            arvnTroopsOutOfPlay = 10;
            arvnRangersOutOfPlay = 3;

        } else if (Objects.equals(scenario, new String("Full Game"))) {
            scenario = "Full Game";
            locations.initMapLocations("Saigon", "coin control", "passive support",1,2,0,0,0,2,3,0,0,0,0,0,0,0,0,0,0,false, 6, "city", "na");
            locations.initMapLocations("Hue", "coin control", "neutral",0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,false, 2,"city", "na");
            locations.initMapLocations("Qui Nhon", "coin control", "passive support",0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Cam Ranh", "coin control", "passive support",0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("An Loc", "coin control", "passive support",0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Can Tho", "coin control", "passive support",0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Da Nang", "coin control", "neutral",0,2,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Kontum", "coin control", "neutral",0,2,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1,"city", "na");
            locations.initMapLocations("Quang Tri", "uncontrolled", "neutral",0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,2,0,false, 2,"province", "highland");
            locations.initMapLocations("Binh Dinh", "uncontrolled", "neutral",0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,2,0,false, 2,"province", "highland");
            locations.initMapLocations("Quang Nam", "coin control", "neutral",0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,false, 1,"province", "highland");
            locations.initMapLocations("Pleiku", "uncontrolled", "neutral",1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,2,0,false, 1,"province", "highland");
            locations.initMapLocations("Quang Tin", "uncontrolled", "active opposition",0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,0,false, 2,"province", "lowland");
            locations.initMapLocations("Quang Duc", "uncontrolled", "active opposition",0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,0,false, 1,"province", "jungle");
            locations.initMapLocations("Binh Tuy", "uncontrolled", "active opposition",0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,0,false, 1,"province", "jungle");
            locations.initMapLocations("Tay Ninh", "uncontrolled", "active opposition",0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,false, 2,"province", "jungle");
            locations.initMapLocations("Phu Bon", "coin control", "passive support",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1,"province", "lowland");
            locations.initMapLocations("Khanh Hoa", "coin control", "passive support",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1,"province", "highland");
            locations.initMapLocations("Kien Hoa", "coin control", "passive support",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 2,"province", "lowland");
            locations.initMapLocations("Ba Xuyen", "coin control", "passive support",0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,false, 1,"province", "lowland");
            locations.initMapLocations("Kien Phong", "uncontrolled", "active opposition",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,false, 2,"province", "lowland");
            locations.initMapLocations("Kien Giang", "uncontrolled", "active opposition",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,false, 2,"province", "lowland");
            locations.initMapLocations("North Vietnam", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,3,0,0,0,0,0,false, 0,"province", "highland");
            locations.initMapLocations("Central Laos", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,3,0,0,0,0,0,false, 0,"province", "jungle");
            locations.initMapLocations("Southern Laos", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,3,0,0,0,0,0,false, 0,"province", "jungle");
            locations.initMapLocations("The Parrot's Beak", "nva control", "neutral",0,0,0,0,0,0,0,0,0,1,0,3,0,0,0,0,0,false, 0,"province", "jungle");

            usTroopsOutOfPlay = 10;
            usBasesOutOfPlay = 2;
            arvnTroopsOutOfPlay = 10;
            arvnRangersOutOfPlay = 3;
            arvnBasesOutOfPlay = 2;

        } else {

        }

        setAvailbleForces();


    }

    private void setAvailbleForces() {

        for (int i = 0; i <locations.SmapLocations.length; i++) {
            // US Available Forces
            usTroopsAvail = usTroopsAvail - locations.getUsTroopsNum(locations.SmapLocations[i]);
            usSFAvail = usSFAvail - (locations.getUsSFuNum(locations.SmapLocations[i]) + locations.getUsSFaNum(locations.SmapLocations[i]));
            usBaseAvail = usBaseAvail - locations.getUsBaseNum(locations.SmapLocations[i]);

            // ARVN Available Forces
            arvnTroopsAvail = arvnTroopsAvail - locations.getArvnTroopsNum(locations.SmapLocations[i]);
            arvnPoliceAvail = arvnPoliceAvail - locations.getArvnPoliceNum(locations.SmapLocations[i]);
            arvnRangersAvail = arvnRangersAvail - (locations.getArvnRangersANum(locations.SmapLocations[i]) + locations.getArvnRangersUNum(locations.SmapLocations[i]));
            arvnBaseAvail = arvnBaseAvail - locations.getArvnBaseNum(locations.SmapLocations[i]);

            // NVA Available Forces
            nvaTroopsAvail = nvaTroopsAvail - locations.getNvaTroopsNum(locations.SmapLocations[i]);
            nvaGuerrillasAvail = nvaGuerrillasAvail - (locations.getNvaGuerrillasANum(locations.SmapLocations[i]) + locations.getNvaGuerrillasUNum(locations.SmapLocations[i]));
            nvaBasesAvail = nvaBasesAvail - locations.getNvaBasesNum(locations.SmapLocations[i]);

            // VC Available Forces
            vcGuerrillasAvail = vcGuerrillasAvail - (locations.getVcGuerrillasANum(locations.SmapLocations[i]) + locations.getVcGuerrillasUNum(locations.SmapLocations[i]));
            vcBasesAvail = vcBasesAvail - (locations.getVcBasesNum(locations.SmapLocations[i]) + locations.getVcTBasesNum(locations.SmapLocations[i]));

        } // end of for loop

        //Set Out of Play
        usTroopsAvail = usTroopsAvail - usTroopsOutOfPlay;
        usBaseAvail = usBaseAvail - usBasesOutOfPlay;
        arvnTroopsAvail = arvnTroopsAvail - arvnTroopsOutOfPlay;
        arvnRangersAvail = arvnRangersAvail - arvnRangersOutOfPlay;
        arvnBaseAvail = arvnBaseAvail - arvnBasesOutOfPlay;


        // Store US Available Forces
        tinydb.putInt("usTroopsAvail",usTroopsAvail);
        tinydb.putInt("usSFAvail",usSFAvail);
        tinydb.putInt("usBaseAvail",usBaseAvail);

        // Store ARVN Available Forces
        tinydb.putInt("arvnTroopsAvail",arvnTroopsAvail);
        tinydb.putInt("arvnPoliceAvail",arvnPoliceAvail);
        tinydb.putInt("arvnRangersAvail",arvnRangersAvail);
        tinydb.putInt("arvnBaseAvail",arvnBaseAvail);

        // Store NVA Available Forces
        tinydb.putInt("nvaTroopsAvail",nvaTroopsAvail);
        tinydb.putInt("nvaGuerrillasAvail",nvaGuerrillasAvail);
        tinydb.putInt("nvaBasesAvail",nvaBasesAvail);

        // Store VC Available Forces
        tinydb.putInt("vcGuerrillasAvail",vcGuerrillasAvail);
        tinydb.putInt("vcBasesAvail",vcBasesAvail);

    } // end of setAvailableForces function



}
