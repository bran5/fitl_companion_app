package Model;

import android.content.Context;
import android.content.ContextWrapper;

/**
 * Created by Brandon on 2/19/2018.
 */


public class mapLocations extends ContextWrapper {

        TinyDB tinydb = new TinyDB(getApplicationContext());

        String locationName = "locationName";
        int usTroopsNum;
        int arvnTroopsNum;
        int arvnPoliceNum;
        int nvaTroopsNum;

        int usSFuNum;
        int usSFaNum;
        int arvnRangersUNum;
        int arvnRangersANum;
        int vcGuerrillasUNum;
        int vcGuerrillasANum;
        int nvaGuerrillasUNum;
        int nvaGuerrillasANum;

        int usBaseNum;
        int arvnBaseNum;
        int nvaBasesNum;
        int vcBasesNum;
        int vcTBasesNum;

        String controlState = "uncontrolled";
        String supportState = "neutral";
        boolean terrorState = false;
        int popValue = 0;
        String locType = "locType";
        String landType = "landType";

    public static String[] SmapLocations = new String[]{"An Loc", "Ba Xuyen", "Binh Dinh", "Binh Tuy", "Cam Ranh", "Can Tho", "Central Laos", "Da Nang", "Hue",
            "Khanh Hoa", "Kien Giang", "Kien Hoa", "Kien Phong", "Kontum", "North Vietnam", "Northeast Cambodia", "Phu Bon", "Phuoc Long",
            "Pleiku", "Quang Duc", "Quang Nam", "Quang Tin", "Quang Tri", "Qui Nhon", "Saigon", "Sihanoukville", "Southern Laos",
            "Tay Ninh", "The Fishhook", "The Parrot's Beak"};

    public mapLocations(Context base) {
        super(base);
    }


    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getUsTroopsNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "usTroopsNum");
    }

    public void setUsTroopsNum(String locationName, int usTroopsNum) {
        this.locationName = locationName;
        this.usTroopsNum = usTroopsNum;
        tinydb.putInt(locationName + "usTroopsNum", usTroopsNum);
    }

    public int getArvnTroopsNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "arvnTroopsNum");
    }

    public void setArvnTroopsNum(String locationName, int arvnTroopsNum) {
        this.locationName = locationName;
        this.arvnTroopsNum = arvnTroopsNum;
        tinydb.putInt(locationName + "arvnTroopsNum", arvnTroopsNum);
    }

    public int getArvnPoliceNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "arvnPoliceNum");
    }

    public void setArvnPoliceNum(String locationName, int arvnPoliceNum) {
        this.locationName = locationName;
        this.arvnTroopsNum = arvnPoliceNum;
        tinydb.putInt(locationName + "arvnPoliceNum", arvnPoliceNum);
    }

    public int getNvaTroopsNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "nvaTroopsNum");
    }

    public void setNvaTroopsNum(String locationName, int nvaTroopsNum) {
        this.locationName = locationName;
        this.nvaTroopsNum = nvaTroopsNum;
        tinydb.putInt(locationName + "nvaTroopsNum", nvaTroopsNum);
    }

    public int getUsSFuNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "usSFuNum");
    }

    public void setUsSFuNum(String locationName, int usSFuNum) {
        this.locationName = locationName;
        this.usSFuNum = usSFuNum;
        tinydb.putInt(locationName + "usSFuNum", usSFuNum);
    }

    public int getUsSFaNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "usSFaNum");
    }

    public void setUsSFaNum(String locationName, int usSFaNum) {
        this.locationName = locationName;
        this.usSFuNum = usSFaNum;
        tinydb.putInt(locationName + "usSFaNum", usSFaNum);
    }

    public int getArvnRangersUNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "arvnRangersUNum");
    }

    public void setArvnRangersUNum(String locationName, int arvnRangersUNum) {
        this.locationName = locationName;
        this.arvnRangersUNum = arvnRangersUNum;
        tinydb.putInt(locationName + "arvnRangersUNum", arvnRangersUNum);

    }

    public int getArvnRangersANum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "arvnRangersANum");
    }

    public void setArvnRangersANum(String locationName, int arvnRangersANum) {
        this.locationName = locationName;
        this.arvnRangersANum = arvnRangersANum;
        tinydb.putInt(locationName + "arvnRangersANum", arvnRangersANum);
    }

    public int getVcGuerrillasUNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "vcGuerrillasUNum");
    }

    public void setVcGuerrillasUNum(String locationName, int vcGuerrillasUNum) {
        this.locationName = locationName;
        this.vcGuerrillasUNum = vcGuerrillasUNum;
        tinydb.putInt(locationName + "vcGuerrillasUNum", vcGuerrillasUNum);
    }

    public int getVcGuerrillasANum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "vcGuerrillasANum");
    }

    public void setVcGuerrillasANum(String locationName, int vcGuerrillasANum) {
        this.locationName = locationName;
        this.vcGuerrillasANum = vcGuerrillasANum;
        tinydb.putInt(locationName + "vcGuerrillasANum", vcGuerrillasANum);
    }

    public int getNvaGuerrillasUNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "nvaGuerrillasUNum");
    }

    public void setNvaGuerrillasUNum(String locationName, int nvaGuerrillasUNum) {
        this.locationName = locationName;
        this.nvaGuerrillasUNum = nvaGuerrillasUNum;
        tinydb.putInt(locationName + "nvaGuerrillasUNum", nvaGuerrillasUNum);
    }

    public int getNvaGuerrillasANum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "nvaGuerrillasANum");
    }

    public void setNvaGuerrillasANum(String locationName, int nvaGuerrillasANum) {
        this.locationName = locationName;
        this.nvaGuerrillasANum = nvaGuerrillasANum;
        tinydb.putInt(locationName + "nvaGuerrillasANum", nvaGuerrillasANum);
    }

    public int getUsBaseNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "usBaseNum");
    }

    public void setUsBaseNum(String locationName, int usBaseNum) {
        this.locationName = locationName;
        this.usBaseNum = usBaseNum;
        tinydb.putInt(locationName + "usBaseNum", usBaseNum);
    }

    public int getArvnBaseNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "arvnBaseNum");
    }

    public void setArvnBaseNum(String locationName, int arvnBaseNum) {
        this.locationName = locationName;
        this.arvnBaseNum = arvnBaseNum;
        tinydb.putInt(locationName + "arvnBaseNum", arvnBaseNum);
    }


    public int getNvaBasesNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "nvaBasesNum");
    }

    public void setNvaBasesNum(String locationName, int nvaBasesNum) {
        this.locationName = locationName;
        this.nvaBasesNum = nvaBasesNum;
        tinydb.putInt(locationName + "nvaBasesNum", nvaBasesNum);
    }

    public int getVcBasesNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "vcBasesNum");
    }

    public void setVcBasesNum(String locationName, int vcBasesNum) {
        this.locationName = locationName;
        this.vcBasesNum = vcBasesNum;
        tinydb.putInt(locationName + "vcBasesNum", vcBasesNum);
    }

    public int getVcTBasesNum(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "vcTBasesNum");
    }

    public void setVcTBasesNum(String locationName, int vcTBasesNum) {
        this.locationName = locationName;
        this.vcTBasesNum = vcTBasesNum;
        tinydb.putInt(locationName + "vcTBasesNum", vcTBasesNum);
    }

    public boolean isTerrorState(String locationName) {
        this.locationName = locationName;
        return tinydb.getBoolean(locationName + "terrorState");
    }

    public void setTerrorState(String locationName, boolean terrorState) {
        this.locationName = locationName;
        this.terrorState = terrorState;
        tinydb.putBoolean(locationName + "terrorState", terrorState);
    }

    public int getPopValue(String locationName) {
        this.locationName = locationName;
        return tinydb.getInt(locationName + "popValue");
    }

    public void setPopValue(String locationName, int popValue) {
        this.locationName = locationName;
        this.popValue = popValue;
        tinydb.putInt(locationName + "popValue", popValue);
    }

    public String getLocType(String locationName) {
        this.locationName = locationName;
        return tinydb.getString(locationName + "getLocType");
    }

    public void setLocType(String locationName, String locType) {
        this.locationName = locationName;
        this.locType = locType;
        tinydb.putString(locationName + "locType", locType);
    }

    public String getLandType(String locationName) {
        this.locationName = locationName;
        return tinydb.getString(locationName + "landType");
    }

    public void setLandType(String locationName, String landType) {
        this.locationName = locationName;
        this.landType = landType;
        tinydb.putString(locationName + "landType", landType);
    }

    public void setControl(String locationName, String controlState) {
        this.controlState = controlState;
        this.locationName = locationName;
        tinydb.putString(locationName + "control", controlState);
    }

    public String getControl(String locationName) {
        this.locationName = locationName;
        return tinydb.getString(locationName + "control");
    }

    public void setSupport(String locationName, String supportState) {
        this.supportState = supportState;
        tinydb.putString(locationName + "support", supportState);
    }

    public String getSupport(String locationName) {
        this.locationName = locationName;
        return tinydb.getString(locationName + "support");
    }

    public void initMapLocations(String locationName, String controlState, String supportState,
                                 int usBaseNum, int usTroopsNum, int usSFuNum, int usSFaNum,
                                 int arvnBaseNum, int arvnTroopsNum, int arvnPoliceNum, int arvnRangersUNum, int arvnRangersANum,
                                 int nvaBasesNum, int nvaTroopsNum, int nvaGuerrillasUNum, int nvaGuerrillasANum,
                                 int vcBasesNum, int vcTBasesNum, int vcGuerrillasUNum, int vcGuerrillasANum,
                                 boolean terrorState, int popValue, String locType, String landType) {
        this.locationName = locationName;
        this.usTroopsNum = usTroopsNum;
        this.arvnTroopsNum = arvnTroopsNum;
        this.arvnPoliceNum = arvnPoliceNum;
        this.nvaTroopsNum = nvaTroopsNum;
        this.usSFuNum = usSFuNum;
        this.usSFaNum = usSFaNum;
        this.arvnRangersUNum = arvnRangersUNum;
        this.arvnRangersANum = arvnRangersANum;
        this.vcGuerrillasUNum = vcGuerrillasUNum;
        this.vcGuerrillasANum = vcGuerrillasANum;
        this.nvaGuerrillasUNum = nvaGuerrillasUNum;
        this.nvaGuerrillasANum = nvaGuerrillasANum;
        this.usBaseNum = usBaseNum;
        this.arvnBaseNum = arvnBaseNum;
        this.nvaBasesNum = nvaBasesNum;
        this.vcBasesNum = vcBasesNum;
        this.vcTBasesNum = vcTBasesNum;
        this.controlState = controlState;
        this.supportState = supportState;
        this.terrorState = terrorState;
        this.popValue = popValue;
        this.locType = locType;
        this.landType = landType;


        tinydb.putInt(locationName + "usTroopsNum", usTroopsNum);
        tinydb.putInt(locationName + "arvnTroopsNum", arvnTroopsNum);
        tinydb.putInt(locationName + "arvnPoliceNum", arvnPoliceNum);
        tinydb.putInt(locationName + "nvaTroopsNum", nvaTroopsNum);
        tinydb.putInt(locationName + "usSFuNum", usSFuNum);
        tinydb.putInt(locationName + "usSFaNum", usSFaNum);
        tinydb.putInt(locationName + "arvnRangersUNum", arvnRangersUNum);
        tinydb.putInt(locationName + "arvnRangersANum", arvnRangersANum);
        tinydb.putInt(locationName + "vcGuerrillasUNum", vcGuerrillasUNum);
        tinydb.putInt(locationName + "vcGuerrillasANum", vcGuerrillasANum);
        tinydb.putInt(locationName + "nvaGuerrillasUNum", nvaGuerrillasUNum);
        tinydb.putInt(locationName + "nvaGuerrillasANum", nvaGuerrillasANum);
        tinydb.putInt(locationName + "usBaseNum", usBaseNum);
        tinydb.putInt(locationName + "arvnBaseNum", arvnBaseNum);
        tinydb.putInt(locationName + "nvaBasesNum", nvaBasesNum);
        tinydb.putInt(locationName + "vcBasesNum", vcBasesNum);
        tinydb.putInt(locationName + "vcTBasesNum", vcTBasesNum);
        tinydb.putString(locationName + "control", controlState);
        tinydb.putString(locationName + "support", supportState);
        tinydb.putBoolean(locationName + "terrorState", terrorState);
        tinydb.putInt(locationName + "popValue", popValue);
        tinydb.putString(locationName + "locType", locType);


/*
        setUsTroopsNum(locationName, usTroopsNum);
        setArvnTroopsNum(locationName, arvnTroopsNum);
        setArvnPoliceNum(locationName, arvnPoliceNum);
        setNvaTroopsNum(locationName, nvaTroopsNum);
        setUsSFuNum( locationName,usSFuNum);
        setUsSFaNum( locationName,usSFaNum);
        setArvnRangersUNum( locationName, arvnRangersUNum);
        setArvnRangersANum( locationName, arvnRangersANum);
        setVcGuerrillasUNum( locationName, vcGuerrillasUNum);
        setVcGuerrillasANum( locationName,vcGuerrillasANum);
        setNvaGuerrillasUNum( locationName,nvaGuerrillasUNum);
        setNvaGuerrillasANum( locationName,nvaGuerrillasANum);
        setArvnBaseNum( locationName,arvnBaseNum);
        setUsBaseNum( locationName, usBaseNum);
        setNvaBasesNum( locationName, nvaBasesNum);
        setVcBasesNum( locationName,vcBasesNum);
        setVcTBasesNum( locationName,vcTBasesNum);
        setTerrorState( locationName,terrorState);
        setPopValue( locationName,popValue);
        setLocType( locationName,locType);
        setLandType( locationName,landType);
        setSupport( locationName, supportState);
        setControl(locationName, controlState);
*/

    }

}