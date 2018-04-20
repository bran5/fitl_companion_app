package fitl.com.fire_in_the_lake;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;

import Model.TinyDB;
import Model.mapLocations;

public class location_data_activity extends AppCompatActivity implements View.OnClickListener {

    String location;
    String controlStatus;
    String supportStatus;

    ImageButton coinControl;
    ImageButton nvaControl;
    ImageButton unControlled;
    ImageButton terrorMarker;
    boolean terrorStatus;

    ImageButton passiveSupport;
    ImageButton passiveOppose;
    ImageButton activeSupport;
    ImageButton activeOppose;
    ImageButton neutralSupport;


    //US variables
    TextView usTroopsNum;
    TextView usBaseNum;
    TextView usSFuNum;
    TextView usSFaNum;

    ImageButton usTroopsBtn;
    ImageButton usBaseBtn;
    ImageButton usSFuBtn;
    ImageButton usSFaBtn;

    //ARVN Variables
    TextView arvnTroopsNum;
    TextView arvnPoliceNum;
    TextView arvnBaseNum;
    TextView arvnRangersUNum;
    TextView arvnRangersANum;

    ImageButton arvnTroopsBtn;
    ImageButton arvnPolicesBtn;
    ImageButton arvnBaseBtn;
    ImageButton arvnRangersUBtn;
    ImageButton arvnRangersABtn;

    //NVA Variables
    TextView nvaTroopsNum;
    TextView nvaBasesNum;
    TextView nvaGuerrillasUNum;
    TextView nvaGuerrillasANum;

    ImageButton nvaTroopsBtn;
    ImageButton nvaBasesBtn;
    ImageButton nvaGuerrillasUBtn;
    ImageButton nvaGuerrillasABtn;

    //VC Variables
    TextView vcGuerrillasUNum;
    TextView vcGuerrillasANum;
    TextView vcBasesNum;
    TextView vcTBasesNum;

    ImageButton vcGuerrillasUBtn;
    ImageButton vcGuerrillasABtn;
    ImageButton vcBasesBtn;
    ImageButton vcTBasesBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_data);


        coinControl = (ImageButton) findViewById(R.id.coinControlImageID);
        nvaControl = (ImageButton) findViewById(R.id.nvaControlImageID);
        unControlled = (ImageButton) findViewById(R.id.unControlImageID);
        terrorMarker = (ImageButton) findViewById(R.id.terrorMarkerImageBtnID);

        passiveSupport = (ImageButton) findViewById(R.id.passiveSupportBtnID);
        passiveOppose = (ImageButton) findViewById(R.id.passiveOpposeBtnID);
        activeSupport = (ImageButton) findViewById(R.id.activeSupportBtnID);
        activeOppose = (ImageButton) findViewById(R.id.activeOpposeBtnID);
        neutralSupport = (ImageButton) findViewById(R.id.nuetralSupportBtnID);

        // US Data and Image Button Assignment
        usTroopsNum = (TextView) findViewById(R.id.usTroopValueID);
        usTroopsBtn = (ImageButton) findViewById(R.id.usTroopBtnID);
        usBaseNum = (TextView) findViewById(R.id.usBaseTextID);
        usBaseBtn = (ImageButton) findViewById(R.id.usBaseBtnID);
        usSFuBtn = (ImageButton) findViewById(R.id.usSFuBtnID);
        usSFuNum = (TextView) findViewById(R.id.usSFUValTextID);
        usSFaBtn = (ImageButton) findViewById(R.id.usSFaBtnID);
        usSFaNum = (TextView) findViewById(R.id.usSFAValTextID);


        // ARVN Data and Image Button Assignment
        arvnTroopsNum = (TextView) findViewById(R.id.arvnTroopValueID);
        arvnTroopsBtn = (ImageButton) findViewById(R.id.arvnTroopBtnID);
        arvnPoliceNum = (TextView) findViewById(R.id.arvnPoliceValueID);
        arvnPolicesBtn = (ImageButton) findViewById(R.id.arvnPoliceBtnID);
        arvnBaseNum = (TextView) findViewById(R.id.arvnBaseTextID);
        arvnBaseBtn = (ImageButton) findViewById(R.id.arvnBaseBtnID);
        arvnRangersUNum = (TextView) findViewById(R.id.arvnRangersUTextID);
        arvnRangersUBtn = (ImageButton) findViewById(R.id.arvnRangersUBtnID);
        arvnRangersANum = (TextView) findViewById(R.id.arvnRangersATextID);
        arvnRangersABtn = (ImageButton) findViewById(R.id.arvnRangersABtnID);

        // NVA Data and Image Button Assignment
        nvaTroopsNum = (TextView) findViewById(R.id.nvaTroopValueID);
        nvaTroopsBtn = (ImageButton) findViewById(R.id.nvaTroopBtnID);
        nvaBasesNum = (TextView) findViewById(R.id.nvaBaseTextID);
        nvaBasesBtn = (ImageButton) findViewById(R.id.nvaBaseBtnID);
        nvaGuerrillasUNum = (TextView) findViewById(R.id.nvaGuerrillasUTextID);
        nvaGuerrillasUBtn = (ImageButton) findViewById(R.id.nvaGurrillasUBtnID);
        nvaGuerrillasANum = (TextView) findViewById(R.id.nvaGuerrillasATextID);
        nvaGuerrillasABtn = (ImageButton) findViewById(R.id.nvaGurrillasABtnID);

        // VC Data and Image Button Assignments
        vcBasesNum = (TextView) findViewById(R.id.vcBaseTextID);
        vcBasesBtn = (ImageButton) findViewById(R.id.vcBaseBtnID);
        vcTBasesNum = (TextView) findViewById(R.id.vcBaseTnlTextID);
        vcTBasesBtn = (ImageButton) findViewById(R.id.vcBaseTnlBtnID);
        vcGuerrillasUNum = (TextView) findViewById(R.id.vcGuerrillasUTextID);
        vcGuerrillasUBtn = (ImageButton) findViewById(R.id.vcGuerrillasUBtnID);
        vcGuerrillasANum = (TextView) findViewById(R.id.vcGuerrillasATextID);
        vcGuerrillasABtn = (ImageButton) findViewById(R.id.vcGuerrillasABtnID);


        // Set Button and Dragging Listeners
        coinControl.setOnClickListener(this);
        nvaControl.setOnClickListener(this);
        unControlled.setOnClickListener(this);
        terrorMarker.setOnClickListener(this);

        // US Faction Button Listeners
        usTroopsBtn.setOnClickListener(this);
        usTroopsBtn.setOnLongClickListener(longClickListener);
        usTroopsNum.setOnDragListener(new MyDragListener());
        usBaseBtn.setOnClickListener(this);
        usBaseBtn.setOnLongClickListener(longClickListener);
        usBaseNum.setOnDragListener(new MyDragListener());
        usSFaBtn.setOnClickListener(this);
        usSFaBtn.setOnLongClickListener(longClickListener);
        usSFaNum.setOnDragListener(new MyDragListener());
        usSFuBtn.setOnClickListener(this);
        usSFuBtn.setOnLongClickListener(longClickListener);
        usSFuNum.setOnDragListener(new MyDragListener());

        // ARVN Faction Button Listeners
        arvnTroopsBtn.setOnClickListener(this);
        arvnTroopsBtn.setOnLongClickListener(longClickListener);
        arvnTroopsNum.setOnDragListener(new MyDragListener());
        arvnBaseBtn.setOnClickListener(this);
        arvnBaseBtn.setOnLongClickListener(longClickListener);
        arvnBaseNum.setOnDragListener(new MyDragListener());
        arvnRangersABtn.setOnClickListener(this);
        arvnRangersABtn.setOnLongClickListener(longClickListener);
        arvnRangersANum.setOnDragListener(new MyDragListener());
        arvnRangersUBtn.setOnClickListener(this);
        arvnRangersUBtn.setOnLongClickListener(longClickListener);
        arvnRangersUNum.setOnDragListener(new MyDragListener());
        arvnPolicesBtn.setOnClickListener(this);
        arvnPolicesBtn.setOnLongClickListener(longClickListener);
        arvnPoliceNum.setOnDragListener(new MyDragListener());

        // NVA Faction Button Listeners
        nvaTroopsBtn.setOnClickListener(this);
        nvaTroopsBtn.setOnLongClickListener(longClickListener);
        nvaTroopsNum.setOnDragListener(new MyDragListener());
        nvaBasesBtn.setOnClickListener(this);
        nvaBasesBtn.setOnLongClickListener(longClickListener);
        nvaBasesNum.setOnDragListener(new MyDragListener());
        nvaGuerrillasABtn.setOnClickListener(this);
        nvaGuerrillasABtn.setOnLongClickListener(longClickListener);
        nvaGuerrillasANum.setOnDragListener(new MyDragListener());
        nvaGuerrillasUBtn.setOnClickListener(this);
        nvaGuerrillasUBtn.setOnLongClickListener(longClickListener);
        nvaGuerrillasUNum.setOnDragListener(new MyDragListener());

        //VC Faction Button Listerns
        vcBasesBtn.setOnClickListener(this);
        vcBasesBtn.setOnLongClickListener(longClickListener);
        vcBasesNum.setOnDragListener(new MyDragListener());
        vcTBasesBtn.setOnClickListener(this);
        vcTBasesBtn.setOnLongClickListener(longClickListener);
        vcTBasesNum.setOnDragListener(new MyDragListener());
        vcGuerrillasABtn.setOnClickListener(this);
        vcGuerrillasABtn.setOnLongClickListener(longClickListener);
        vcGuerrillasANum.setOnDragListener(new MyDragListener());
        vcGuerrillasUBtn.setOnClickListener(this);
        vcGuerrillasUBtn.setOnLongClickListener(longClickListener);
        vcGuerrillasUNum.setOnDragListener(new MyDragListener());

        // Call function to set values
        getLocationValues();

    }

    @Override
    public void onClick(View v) {
        mapLocations space = (new mapLocations(location_data_activity.this));
        TinyDB tinydb = (new TinyDB(location_data_activity.this));

        String message = null;

        // Available Variables
        // US
        int usTroopValue;
        int usTroopsAvail;
        int usBaseValue;
        int usBaseAvail;
        int usSFaValue;
        int usSFuValue;
        int usSFAvail;

        //ARVN
        int arvnTroopValue;
        int arvnTroopsAvail;
        int arvnPoliceValue;
        int arvnPoliceAvail;
        int arvnRangersAvail;
        int arvnRangersAValue;
        int arvnRangersUValue;
        int arvnBaseValue;
        int arvnBaseAvail;

        // NVA
        int nvaTroopsAvail;
        int nvaTroopsValue;
        int nvaGuerrillasAvail;
        int nvaGuerrillasAValue;
        int nvaGuerrillasUValue;
        int nvaBasesAvail;
        int nvaBasesValue;

        // VC
        int vcGuerrillasAvail;
        int vcGuerrillasAValue;
        int vcGuerrillasUValue;
        int vcBasesAvail;
        int vcBasesValue;
        int vcTBasesValue;


        // Control Buttons*****************************************************************************************
        switch(v.getId()) {
            case R.id.coinControlImageID:
                space.setControl(location, "coin control");
                unControlled.setBackground(getResources().getDrawable(R.drawable.uncontrolled_greyed));
                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control_greyed));
                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control));

                break;
            case R.id.nvaControlImageID:
                space.setControl(location, "nva control");
                unControlled.setBackground(getResources().getDrawable(R.drawable.uncontrolled_greyed));
                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control));
                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control_greyed));

                break;
            case R.id.unControlImageID:
                space.setControl(location, "uncontrolled");
                unControlled.setBackground(getResources().getDrawable(R.drawable.uncontrolled));
                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control_greyed));
                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control_greyed));

                break;
        }

        // Troop Buttons*****************************************************************************************
        switch(v.getId()) {
            case R.id.usTroopBtnID:
                // Get the available number of troops
                usTroopsAvail = tinydb.getInt("usTroopsAvail");
                usTroopValue = space.getUsTroopsNum(location);

                // Each time the Button is pushed subtract 1 from available force pool
                // Bound lower end of number of troops

                // Each time the Button is pushed add 1 troop cube to current location number
                // and store it.
                if (usTroopsAvail > 0) {
                    usTroopsAvail = usTroopsAvail - 1;
                    usTroopValue = usTroopValue + 1;
                }
                // Store the Available Troops
                tinydb.putInt("usTroopsAvail", usTroopsAvail);
                space.setUsTroopsNum(location, usTroopValue);

                usTroopsNum.setText(String.valueOf(usTroopValue));

                message = "US Troops Available: " + String.valueOf(usTroopsAvail);
                break;

            case R.id.arvnTroopBtnID:
                // Get the available number of troops
                arvnTroopsAvail = tinydb.getInt("arvnTroopsAvail");
                arvnTroopValue = space.getArvnTroopsNum(location);

                // Each time the Button is pushed subtract 1 from available force pool
                // Bound lower end of number of troops

                // Each time the Button is pushed add 1 troop cube to current location number
                // and store it.
                if (arvnTroopsAvail > 0) {
                    arvnTroopsAvail = arvnTroopsAvail - 1;
                    arvnTroopValue = arvnTroopValue + 1;
                }

                // Store the Available Troops
                tinydb.putInt("arvnTroopsAvail", arvnTroopsAvail);
                space.setArvnTroopsNum(location, arvnTroopValue);

                arvnTroopsNum.setText(String.valueOf(arvnTroopValue));

                message = "ARVN Troops Available: " + String.valueOf(arvnTroopsAvail);
                break;

            case R.id.arvnPoliceBtnID:
                arvnPoliceAvail = tinydb.getInt("arvnPoliceAvail");
                arvnPoliceValue = space.getArvnPoliceNum(location);

                // Each time the Button is pushed subtract 1 from available force pool
                // Bound lower end of number of troops

                // Each time the Button is pushed add 1 troop cube to current location number
                // and store it.

                if (arvnPoliceAvail > 0) {
                    arvnPoliceAvail = arvnPoliceAvail - 1;
                    arvnPoliceValue = arvnPoliceValue + 1;
                }

                // Store the values
                tinydb.putInt("arvnPoliceAvail",arvnPoliceAvail );
                space.setArvnPoliceNum(location,arvnPoliceValue);

                arvnPoliceNum.setText(String.valueOf(arvnPoliceValue));

                message = "ARVN Police Available: " +  String.valueOf(arvnPoliceAvail);
                break;

            case R.id.nvaTroopBtnID:
                nvaTroopsAvail = tinydb.getInt("nvaTroopsAvail");
                nvaTroopsValue = space.getNvaTroopsNum(location);

                if (nvaTroopsAvail > 0) {
                    nvaTroopsAvail = nvaTroopsAvail - 1;
                    nvaTroopsValue = nvaTroopsValue + 1;
                }

                tinydb.putInt("nvaTroopsAvail", nvaTroopsAvail);
                space.setNvaTroopsNum(location,nvaTroopsValue);

                nvaTroopsNum.setText(String.valueOf(nvaTroopsValue));

                message = "NVA Troops Available: " + String.valueOf(nvaTroopsAvail);
                break;

            //Special Forces/Rangers/Guerrillas Buttons********************************************************
            //********************************U.S.**************************************************
            case R.id.usSFaBtnID:
                usSFAvail = tinydb.getInt("usSFAvail");
                usSFaValue = space.getUsSFaNum(location);

                if (usSFAvail > 0) {
                    usSFAvail = usSFAvail - 1;
                    usSFaValue = usSFaValue + 1;
                }

                tinydb.putInt("usSFAvail", usSFAvail);
                space.setUsSFaNum(location,usSFaValue);

                usSFaNum.setText(String.valueOf(usSFaValue));

                message = "U.S. Special Forces Available: " + String.valueOf(usSFAvail);
                break;

            case R.id.usSFuBtnID:
                usSFAvail = tinydb.getInt("usSFAvail");
                usSFuValue = space.getUsSFuNum(location);

                if (usSFAvail > 0) {
                    usSFAvail = usSFAvail - 1;
                    usSFuValue = usSFuValue + 1;
                }

                tinydb.putInt("usSFAvail", usSFAvail);
                space.setUsSFaNum(location,usSFuValue);

                usSFaNum.setText(String.valueOf(usSFuValue));

                message = "U.S. Special Forces Available: " + String.valueOf(usSFAvail);
                break;

            //********************************ARVN**************************************************
            case R.id.arvnRangersABtnID:
                arvnRangersAvail = tinydb.getInt("arvnRangersAvail");
                arvnRangersAValue = space.getArvnRangersANum(location);

                if (arvnRangersAvail > 0) {
                    arvnRangersAvail = arvnRangersAvail - 1;
                    arvnRangersAValue = arvnRangersAValue + 1;
                }

                tinydb.putInt("arvnRangersAvail", arvnRangersAvail);
                space.setArvnRangersANum(location,arvnRangersAValue);

                arvnRangersANum.setText(String.valueOf(arvnRangersAValue));

                message = "ARVN Rangers Available: " + String.valueOf(arvnRangersAvail);
                break;

            case R.id.arvnRangersUBtnID:
                arvnRangersAvail = tinydb.getInt("arvnRangersAvail");
                arvnRangersUValue = space.getArvnRangersUNum(location);

                if (arvnRangersAvail > 0) {
                    arvnRangersAvail = arvnRangersAvail - 1;
                    arvnRangersUValue = arvnRangersUValue + 1;
                }

                tinydb.putInt("arvnRangersAvail", arvnRangersAvail);
                space.setArvnRangersUNum(location,arvnRangersUValue);

                arvnRangersUNum.setText(String.valueOf(arvnRangersUValue));

                message = "ARVN Rangers Available: " + String.valueOf(arvnRangersAvail);
                break;

            //*********************************NVA**************************************************
            case R.id.nvaGurrillasABtnID:
                nvaGuerrillasAvail = tinydb.getInt("nvaGuerrillasAvail");
                nvaGuerrillasAValue = space.getNvaGuerrillasANum(location);

                if (nvaGuerrillasAvail > 0) {
                    nvaGuerrillasAvail = nvaGuerrillasAvail - 1;
                    nvaGuerrillasAValue = nvaGuerrillasAValue + 1;
                }

                tinydb.putInt("nvaGuerrillasAvail",nvaGuerrillasAvail);
                space.setNvaGuerrillasANum(location,nvaGuerrillasAValue);

                nvaGuerrillasANum.setText(String.valueOf(nvaGuerrillasAValue));

                message = "NVA Guerrillas Available: " + String.valueOf(nvaGuerrillasAvail);
                break;

            case R.id.nvaGurrillasUBtnID:
                nvaGuerrillasAvail = tinydb.getInt("nvaGuerrillasAvail");
                nvaGuerrillasUValue = space.getNvaGuerrillasUNum(location);

                if (nvaGuerrillasAvail > 0) {
                    nvaGuerrillasAvail = nvaGuerrillasAvail - 1;
                    nvaGuerrillasUValue = nvaGuerrillasUValue + 1;
                }

                tinydb.putInt("nvaGuerrillasAvail",nvaGuerrillasAvail);
                space.setNvaGuerrillasUNum(location,nvaGuerrillasUValue);

                nvaGuerrillasUNum.setText(String.valueOf(nvaGuerrillasUValue));

                message = "NVA Guerrillas Available: " + String.valueOf(nvaGuerrillasAvail);
                break;

            //*********************************VC**************************************************
            case R.id.vcGuerrillasABtnID:
                vcGuerrillasAvail = tinydb.getInt("vcGuerrillasAvail");
                vcGuerrillasAValue = space.getVcGuerrillasANum(location);

                if (vcGuerrillasAvail > 0) {
                    vcGuerrillasAvail = vcGuerrillasAvail - 1;
                    vcGuerrillasAValue = vcGuerrillasAValue + 1;
                }

                tinydb.putInt("vcGuerrillasAvail",vcGuerrillasAvail);
                space.setVcGuerrillasANum(location,vcGuerrillasAValue);

                vcGuerrillasANum.setText(String.valueOf(vcGuerrillasAValue));

                message = "VC Guerrillas Available: " + String.valueOf(vcGuerrillasAvail);
                break;

            case R.id.vcGuerrillasUBtnID:
                vcGuerrillasAvail = tinydb.getInt("vcGuerrillasAvail");
                vcGuerrillasUValue = space.getVcGuerrillasUNum(location);

                if (vcGuerrillasAvail > 0) {
                    vcGuerrillasAvail = vcGuerrillasAvail - 1;
                    vcGuerrillasUValue = vcGuerrillasUValue + 1;
                }

                tinydb.putInt("vcGuerrillasAvail",vcGuerrillasAvail);
                space.setVcGuerrillasUNum(location,vcGuerrillasUValue);

                vcGuerrillasUNum.setText(String.valueOf(vcGuerrillasUValue));

                message = "VC Guerrillas Available: " + String.valueOf(vcGuerrillasAvail);
                break;

            //****************************FACTION BASES********************************************************
            //********************************U.S.**************************************************
            case R.id.usBaseBtnID:
                usBaseAvail = tinydb.getInt("usBaseAvail");
                usBaseValue = space.getUsBaseNum(location);

                if (usBaseAvail > 0) {
                    usBaseAvail = usBaseAvail - 1;
                    usBaseValue = usBaseValue + 1;
                }

                tinydb.putInt("usBaseAvail", usBaseAvail);
                space.setUsBaseNum(location,usBaseValue);

                usBaseNum.setText(String.valueOf(usBaseValue));

                message = "US Bases Available: " + String.valueOf(usBaseAvail);
                break;

            //********************************ARVN**************************************************
            case R.id.arvnBaseBtnID:
                arvnBaseAvail = tinydb.getInt("arvnBaseAvail");
                arvnBaseValue = space.getArvnBaseNum(location);

                if (arvnBaseAvail > 0) {
                    arvnBaseAvail = arvnBaseAvail - 1;
                    arvnBaseValue = arvnBaseValue + 1;
                }

                tinydb.putInt("arvnBaseAvail", arvnBaseAvail);
                space.setArvnBaseNum(location,arvnBaseValue);

                arvnBaseNum.setText(String.valueOf(arvnBaseValue));

                message = "ARVN Bases Available: " + String.valueOf(arvnBaseAvail);
                break;

            //********************************NVA**************************************************
            case R.id.nvaBaseBtnID:
                nvaBasesAvail = tinydb.getInt("nvaBasesAvail");
                nvaBasesValue = space.getNvaBasesNum(location);

                if (nvaBasesAvail > 0) {
                    nvaBasesAvail = nvaBasesAvail - 1;
                    nvaBasesValue = nvaBasesValue + 1;
                }

                tinydb.putInt("nvaBasesAvail", nvaBasesAvail);
                space.setNvaBasesNum(location,nvaBasesValue);

                nvaBasesNum.setText(String.valueOf(nvaBasesValue));

                message = "NVA Bases Available: " + String.valueOf(nvaBasesAvail);
                break;

            //********************************NVA**************************************************
            case R.id.vcBaseBtnID:
                vcBasesAvail = tinydb.getInt("vcBasesAvail");
                vcBasesValue = space.getVcBasesNum(location);

                if (vcBasesAvail > 0) {
                    vcBasesAvail = vcBasesAvail - 1;
                    vcBasesValue = vcBasesValue + 1;
                }

                tinydb.putInt("vcBasesAvail", vcBasesAvail);
                space.setVcBasesNum(location,vcBasesValue);

                vcBasesNum.setText(String.valueOf(vcBasesValue));

                message = "VC Bases Available: " + String.valueOf(vcBasesAvail);
                break;

            case R.id.vcBaseTnlBtnID:
                vcBasesAvail = tinydb.getInt("vcBasesAvail");
                vcTBasesValue = space.getVcTBasesNum(location);

                if (vcBasesAvail > 0) {
                    vcBasesAvail = vcBasesAvail - 1;
                    vcTBasesValue = vcTBasesValue + 1;
                }

                tinydb.putInt("vcBasesAvail", vcBasesAvail);
                space.setVcTBasesNum(location,vcTBasesValue);

                vcTBasesNum.setText(String.valueOf(vcTBasesValue));

                message = "VC Bases Available: " + String.valueOf(vcBasesAvail);
                break;

        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    // Drag and Drop Buttons***********************************************************************************
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return true;
        }
    };

    public class MyDragListener implements View.OnDragListener {
        mapLocations space = (new mapLocations(location_data_activity.this));
        TinyDB tinydb = (new TinyDB(location_data_activity.this));

        String message = null;

        // Available Variables
        // US
        int usTroopValue;
        int usTroopsAvail;
        int usBaseAvail;
        int usBaseValue;
        int usSFaValue;
        int usSFuValue;
        int usSFAvail;

        //ARVN
        int arvnTroopValue;
        int arvnTroopsAvail;
        int arvnPoliceValue;
        int arvnPoliceAvail;
        int arvnRangersAvail;
        int arvnRangersAValue;
        int arvnRangersUValue;
        int arvnBaseAvail;
        int arvnBaseValue;

        // NVA
        int nvaTroopsAvail;
        int nvaTroopsValue;
        int nvaGuerrillasAvail;
        int nvaGuerrillasAValue;
        int nvaGuerrillasUValue;
        int nvaBasesAvail;
        int nvaBasesValue;

        // VC
        int vcGuerrillasAvail;
        int vcGuerrillasAValue;
        int vcGuerrillasUValue;
        int vcBasesAvail;
        int vcBasesValue;
        int vcTBasesValue;

        @Override
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("drag: ", "Drag Started");


                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("drag: ", "Drag Entered");
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("drag: ", "Drag Exited");
                    // do nothing
                    break;
                case DragEvent.ACTION_DROP:
                    Log.d("drag: ", "Drag Drop");

                    switch(v.getId()) {
                        // Troop Buttons*****************************************************************************************
                        case R.id.usTroopValueID:

                            // Get the available number of troops
                            usTroopsAvail = tinydb.getInt("usTroopsAvail");
                            usTroopValue = space.getUsTroopsNum(location);

                            // Each time the Button is pushed subtract 1 from available force pool
                            // Bound lower end of number of troops

                            // Each time the Button is pushed add 1 troop cube to current location number
                            // and store it.
                            if (usTroopValue > 0) {
                                usTroopsAvail = usTroopsAvail + 1;
                                usTroopValue = usTroopValue - 1;
                            }
                            // Store the Available Troops
                            tinydb.putInt("usTroopsAvail", usTroopsAvail);
                            space.setUsTroopsNum(location, usTroopValue);

                            usTroopsNum.setText(String.valueOf(usTroopValue));

                            message = "Troops Available: " + String.valueOf(usTroopsAvail);
                            break;

                        case R.id.arvnTroopValueID:

                            // Get the available number of troops
                            arvnTroopsAvail = tinydb.getInt("arvnTroopsAvail");
                            arvnTroopValue = space.getArvnTroopsNum(location);

                            // Each time the Button is pushed subtract 1 from available force pool
                            // Bound lower end of number of troops

                            // Each time the Button is pushed add 1 troop cube to current location number
                            // and store it.
                            if (arvnTroopValue > 0) {
                                arvnTroopsAvail = arvnTroopsAvail + 1;
                                arvnTroopValue = arvnTroopValue - 1;
                            }

                            // Store the Available Troops
                            tinydb.putInt("arvnTroopsAvail", arvnTroopsAvail);
                            space.setArvnTroopsNum(location, arvnTroopValue);

                            arvnTroopsNum.setText(String.valueOf(arvnTroopValue));

                            message = "Troops Available: " + String.valueOf(arvnTroopsAvail);
                            break;

                        case R.id.arvnPoliceValueID:

                            arvnPoliceAvail = tinydb.getInt("arvnPoliceAvail");
                            arvnPoliceValue = space.getArvnPoliceNum(location);

                            // Each time the Button is pushed subtract 1 from available force pool
                            // Bound lower end of number of troops

                            // Each time the Button is pushed add 1 troop cube to current location number
                            // and store it.

                            if (arvnPoliceValue > 0) {
                                arvnPoliceAvail = arvnPoliceAvail + 1;
                                arvnPoliceValue = arvnPoliceValue - 1;
                            }

                            // Store the values
                            tinydb.putInt("arvnPoliceAvail",arvnPoliceAvail );
                            space.setArvnPoliceNum(location,arvnPoliceValue);

                            arvnPoliceNum.setText(String.valueOf(arvnPoliceValue));

                            message = "ARVN Police Available: " +  String.valueOf(arvnPoliceAvail);
                            break;

                        case R.id.nvaTroopValueID:

                            nvaTroopsAvail = tinydb.getInt("nvaTroopsAvail");
                            nvaTroopsValue = space.getNvaTroopsNum(location);

                            if (nvaTroopsValue > 0) {
                                nvaTroopsAvail = nvaTroopsAvail + 1;
                                nvaTroopsValue = nvaTroopsValue - 1;
                            }

                            tinydb.putInt("nvaTroopsAvail", nvaTroopsAvail);
                            space.setNvaTroopsNum(location,nvaTroopsValue);

                            nvaTroopsNum.setText(String.valueOf(nvaTroopsValue));

                            message = "NVA Troops Available: " + String.valueOf(nvaTroopsAvail);
                            break;

                        //Special Forces/Rangers/Guerrillas Buttons********************************************************

                        //***********************U.S.***********************************************
                        case R.id.usSFAValTextID:
                            usSFAvail = tinydb.getInt("usSFAvail");
                            usSFaValue = space.getUsSFaNum(location);

                            if (usSFaValue > 0) {
                                usSFAvail = usSFAvail + 1;
                                usSFaValue = usSFaValue - 1;
                            }

                            tinydb.putInt("usSFAvail", usSFAvail);
                            space.setUsSFaNum(location,usSFaValue);

                            usSFaNum.setText(String.valueOf(usSFaValue));

                            message = "U.S. Special Forces Available: " + String.valueOf(usSFAvail);
                            break;

                        case R.id.usSFUValTextID:
                            usSFAvail = tinydb.getInt("usSFAvail");
                            usSFuValue = space.getUsSFaNum(location);

                            if (usSFuValue > 0) {
                                usSFAvail = usSFAvail + 1;
                                usSFuValue = usSFuValue - 1;
                            }

                            tinydb.putInt("usSFAvail", usSFAvail);
                            space.setUsSFaNum(location,usSFuValue);

                            usSFaNum.setText(String.valueOf(usSFuValue));

                            message = "U.S. Special Forces Available: " + String.valueOf(usSFAvail);
                            break;
                        //*************************ARVN*********************************************
                        case R.id.arvnRangersUTextID:
                            arvnRangersAvail = tinydb.getInt("arvnRangersAvail");
                            arvnRangersUValue = space.getArvnRangersUNum(location);

                            if (arvnRangersUValue > 0) {
                                arvnRangersAvail = arvnRangersAvail + 1;
                                arvnRangersUValue = arvnRangersUValue - 1;
                            }

                            tinydb.putInt("arvnRangersAvail", arvnRangersAvail);
                            space.setArvnRangersUNum(location,arvnRangersUValue);

                            arvnRangersUNum.setText(String.valueOf(arvnRangersAValue));

                            message = "ARVN Rangers Available: " + String.valueOf(arvnRangersAvail);
                            break;


                        case R.id.arvnRangersATextID:
                            arvnRangersAvail = tinydb.getInt("arvnRangersAvail");
                            arvnRangersAValue = space.getArvnRangersANum(location);

                            if (arvnRangersAValue > 0) {
                                arvnRangersAvail = arvnRangersAvail + 1;
                                arvnRangersAValue = arvnRangersAValue - 1;
                            }

                            tinydb.putInt("arvnRangersAvail", arvnRangersAvail);
                            space.setArvnRangersANum(location,arvnRangersAValue);

                            arvnRangersANum.setText(String.valueOf(arvnRangersAValue));

                            message = "ARVN Rangers Available: " + String.valueOf(arvnRangersAvail);
                            break;

                        //***********************NVA************************************************
                        case R.id.nvaGuerrillasUTextID:
                            nvaGuerrillasAvail = tinydb.getInt("nvaGuerrillasAvail");
                            nvaGuerrillasUValue = space.getNvaGuerrillasUNum(location);

                            if (nvaGuerrillasUValue > 0) {
                                nvaGuerrillasAvail = nvaGuerrillasAvail + 1;
                                nvaGuerrillasUValue = nvaGuerrillasUValue - 1;
                            }

                            tinydb.putInt("nvaGuerrillasAvail", nvaGuerrillasAvail);
                            space.setNvaGuerrillasUNum(location,nvaGuerrillasUValue);

                            nvaGuerrillasUNum.setText(String.valueOf(nvaGuerrillasUValue));

                            message = "NVA Guerrillas Available: " + String.valueOf(nvaGuerrillasAvail);
                            break;

                        case R.id.nvaGuerrillasATextID:
                            nvaGuerrillasAvail = tinydb.getInt("nvaGuerrillasAvail");
                            nvaGuerrillasAValue = space.getNvaGuerrillasANum(location);

                            if (nvaGuerrillasAValue > 0) {
                                nvaGuerrillasAvail = nvaGuerrillasAvail + 1;
                                nvaGuerrillasAValue = nvaGuerrillasAValue - 1;
                            }

                            tinydb.putInt("nvaGuerrillasAvail", nvaGuerrillasAvail);
                            space.setNvaGuerrillasANum(location,nvaGuerrillasAValue);

                            nvaGuerrillasANum.setText(String.valueOf(nvaGuerrillasAValue));

                            message = "NVA Guerrillas Available: " + String.valueOf(nvaGuerrillasAvail);
                            break;

                        //***********************VC************************************************
                        case R.id.vcGuerrillasUTextID:
                            vcGuerrillasAvail = tinydb.getInt("vcGuerrillasAvail");
                            vcGuerrillasUValue = space.getVcGuerrillasUNum(location);

                            if (vcGuerrillasUValue > 0) {
                                vcGuerrillasAvail = vcGuerrillasAvail + 1;
                                vcGuerrillasUValue = vcGuerrillasUValue - 1;
                            }

                            tinydb.putInt("vcGuerrillasAvail", vcGuerrillasAvail);
                            space.setVcGuerrillasUNum(location,vcGuerrillasUValue);

                            vcGuerrillasUNum.setText(String.valueOf(vcGuerrillasUValue));

                            message = "VC Guerrillas Available: " + String.valueOf(vcGuerrillasAvail);
                            break;

                        case R.id.vcGuerrillasATextID:
                            vcGuerrillasAvail = tinydb.getInt("vcGuerrillasAvail");
                            vcGuerrillasAValue = space.getVcGuerrillasANum(location);

                            if (vcGuerrillasAValue > 0) {
                                vcGuerrillasAvail = vcGuerrillasAvail + 1;
                                vcGuerrillasAValue = vcGuerrillasAValue - 1;
                            }

                            tinydb.putInt("vcGuerrillasAvail", vcGuerrillasAvail);
                            space.setVcGuerrillasANum(location,vcGuerrillasAValue);

                            vcGuerrillasANum.setText(String.valueOf(vcGuerrillasAValue));

                            message = "VC Guerrillas Available: " + String.valueOf(vcGuerrillasAvail);
                            break;

                        //*********************Faction Bases********************************************************

                        //***********************U.S.***********************************************
                        case R.id.usBaseTextID:
                            usBaseAvail = tinydb.getInt("usBaseAvail");
                            usBaseValue = space.getUsBaseNum(location);

                            if (usBaseValue > 0) {
                                usBaseAvail = usBaseAvail + 1;
                                usBaseValue = usBaseValue - 1;
                            }

                            tinydb.putInt("usBaseAvail", usBaseAvail);
                            space.setUsBaseNum(location,usBaseValue);

                            usBaseNum.setText(String.valueOf(usBaseValue));

                            message = "U.S. Bases Available: " + String.valueOf(usBaseAvail);
                            break;

                        //***********************ARVN***********************************************
                        case R.id.arvnBaseTextID:
                            arvnBaseAvail = tinydb.getInt("arvnBaseAvail");
                            arvnBaseValue = space.getArvnBaseNum(location);

                            if (arvnBaseValue > 0) {
                                arvnBaseAvail = arvnBaseAvail + 1;
                                arvnBaseValue = arvnBaseValue - 1;
                            }

                            tinydb.putInt("arvnBaseAvail", arvnBaseAvail);
                            space.setArvnBaseNum(location,arvnBaseValue);

                            arvnBaseNum.setText(String.valueOf(arvnBaseValue));

                            message = "ARVN Bases Available: " + String.valueOf(arvnBaseAvail);
                            break;

                        //***********************NVA***********************************************
                        case R.id.nvaBaseTextID:
                            nvaBasesAvail = tinydb.getInt("nvaBasesAvail");
                            nvaBasesValue = space.getNvaBasesNum(location);

                            if (nvaBasesValue > 0) {
                                nvaBasesAvail = nvaBasesAvail + 1;
                                nvaBasesValue = nvaBasesValue - 1;
                            }

                            tinydb.putInt("nvaBasesAvail", nvaBasesAvail);
                            space.setNvaBasesNum(location,nvaBasesValue);

                            nvaBasesNum.setText(String.valueOf(nvaBasesValue));

                            message = "NVA Bases Available: " + String.valueOf(nvaBasesAvail);
                            break;

                        //***********************VC***********************************************
                        case R.id.vcBaseTextID:
                            vcBasesAvail = tinydb.getInt("vcBasesAvail");
                            vcBasesValue = space.getVcBasesNum(location);

                            if (vcBasesValue > 0) {
                                vcBasesAvail = vcBasesAvail + 1;
                                vcBasesValue = vcBasesValue - 1;
                            }

                            tinydb.putInt("vcBasesAvail", vcBasesAvail);
                            space.setVcBasesNum(location,vcBasesValue);

                            vcBasesNum.setText(String.valueOf(vcBasesValue));

                            message = "VC Bases Available: " + String.valueOf(vcBasesAvail);
                            break;

                        case R.id.vcBaseTnlTextID:
                            vcBasesAvail = tinydb.getInt("vcBasesAvail");
                            vcTBasesValue = space.getVcTBasesNum(location);

                            if (vcTBasesValue > 0) {
                                vcBasesAvail = vcBasesAvail + 1;
                                vcTBasesValue = vcTBasesValue - 1;
                            }

                            tinydb.putInt("vcBasesAvail", vcBasesAvail);
                            space.setVcTBasesNum(location,vcTBasesValue);

                            vcTBasesNum.setText(String.valueOf(vcTBasesValue));

                            message = "VC Bases Available: " + String.valueOf(vcBasesAvail);
                            break;


                    }

                    Toast.makeText(location_data_activity.this, message, Toast.LENGTH_SHORT).show();
                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                default:
                    break;
            }
            return true;
        }


    }


    //Function to retrieve location and display information about that location
    public void getLocationValues(){

        TextView textLocationName = findViewById(R.id.locationNameID);
        mapLocations space = (new mapLocations(location_data_activity.this));

        int usPieces = 0;
        int arvnPieces = 0;
        int nvaPieces = 0;
        int vcPieces = 0;

        //If Intent has something extra to get, then get Extra or else
        // App will crash if it tries to get something that is not there.
        if(getIntent().hasExtra("location")) {


            // Get location passed from RVAdapter and Set the Name Title
            // This will get all the data for that location
            location = getIntent().getStringExtra("location");
            textLocationName.setText(location);

            // Get the control status for this location
            controlStatus = space.getControl(location);
            supportStatus = space.getSupport(location);
            terrorStatus = space.isTerrorState(location);

            usPieces = space.getUsTroopsNum(location)+space.getUsBaseNum(location)+space.getUsSFaNum(location)+space.getUsSFuNum(location);
            arvnPieces = space.getArvnTroopsNum(location)+space.getArvnBaseNum(location)+space.getArvnPoliceNum(location)+space.getArvnRangersUNum(location)+space.getArvnRangersANum(location);
            nvaPieces = space.getNvaTroopsNum(location)+space.getNvaBasesNum(location)+space.getNvaGuerrillasUNum(location)+space.getNvaGuerrillasANum(location);
            vcPieces = space.getVcGuerrillasANum(location)+space.getVcGuerrillasUNum(location)+space.getVcBasesNum(location)+space.getVcTBasesNum(location);

            if (Integer.compare((usPieces+arvnPieces), (nvaPieces+vcPieces)) < 0) {

                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control));
                unControlled.setBackground(getResources().getDrawable(R.drawable.uncontrolled_greyed));
                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control_greyed));
                space.setControl(location,"nva control");

            } else if (Integer.compare((usPieces+arvnPieces), (nvaPieces+vcPieces)) > 0) {

                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control_greyed));
                unControlled.setBackground(getResources().getDrawable(R.drawable.uncontrolled_greyed));
                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control));
                space.setControl(location, "coin control");

            } else {

                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control_greyed));
                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control_greyed));
                space.setControl(location,"uncontrolled");

            }



            // set control status of each location
           /* if (Objects.equals(controlStatus, new String("nva control"))) {

                unControlled.setBackground(getResources().getDrawable(R.drawable.uncontrolled_greyed));
                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control_greyed));

            } else if (Objects.equals(controlStatus, new String("coin control"))) {

                unControlled.setBackground(getResources().getDrawable(R.drawable.uncontrolled_greyed));
                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control_greyed));

            } else if (Objects.equals(controlStatus, new String("uncontrolled"))) {

                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control_greyed));
                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control_greyed));

            } else {

                coinControl.setBackground(getResources().getDrawable(R.drawable.coin_control_greyed));
                nvaControl.setBackground(getResources().getDrawable(R.drawable.nva_control_greyed));

            }
            */

            //set support status
            if (Objects.equals(supportStatus, new String("passive support"))) {

                activeOppose.setBackground(getResources().getDrawable(R.drawable.active_oppose_greyed));
                activeSupport.setBackground(getResources().getDrawable(R.drawable.active_support_greyed));
                passiveOppose.setBackground(getResources().getDrawable(R.drawable.passive_oppose_greyed));
                neutralSupport.setBackground(getResources().getDrawable(R.drawable.nuetral_support_greyed));

            } else if (Objects.equals(supportStatus, new String("passive opposition"))) {

                activeOppose.setBackground(getResources().getDrawable(R.drawable.active_oppose_greyed));
                activeSupport.setBackground(getResources().getDrawable(R.drawable.active_support_greyed));
                passiveSupport.setBackground(getResources().getDrawable(R.drawable.passive_oppose_greyed));
                neutralSupport.setBackground(getResources().getDrawable(R.drawable.nuetral_support_greyed));

            } else if (Objects.equals(supportStatus, new String("active support"))) {

                activeOppose.setBackground(getResources().getDrawable(R.drawable.active_oppose_greyed));
                passiveOppose.setBackground(getResources().getDrawable(R.drawable.active_support_greyed));
                passiveSupport.setBackground(getResources().getDrawable(R.drawable.passive_oppose_greyed));
                neutralSupport.setBackground(getResources().getDrawable(R.drawable.nuetral_support_greyed));

            } else if (Objects.equals(supportStatus, new String("active opposition"))) {

                passiveOppose.setBackground(getResources().getDrawable(R.drawable.active_oppose_greyed));
                activeSupport.setBackground(getResources().getDrawable(R.drawable.active_support_greyed));
                passiveSupport.setBackground(getResources().getDrawable(R.drawable.passive_oppose_greyed));
                neutralSupport.setBackground(getResources().getDrawable(R.drawable.nuetral_support_greyed));

            } else if (Objects.equals(supportStatus, new String("neutral support"))) {

                activeOppose.setBackground(getResources().getDrawable(R.drawable.active_oppose_greyed));
                activeSupport.setBackground(getResources().getDrawable(R.drawable.active_support_greyed));
                passiveSupport.setBackground(getResources().getDrawable(R.drawable.passive_oppose_greyed));
                passiveOppose.setBackground(getResources().getDrawable(R.drawable.nuetral_support_greyed));

            } else {

                activeOppose.setBackground(getResources().getDrawable(R.drawable.active_oppose_greyed));
                activeSupport.setBackground(getResources().getDrawable(R.drawable.active_support_greyed));
                passiveSupport.setBackground(getResources().getDrawable(R.drawable.passive_oppose_greyed));
                passiveOppose.setBackground(getResources().getDrawable(R.drawable.nuetral_support_greyed));

            }

            //Set Terror status
            if (terrorStatus) {
                terrorMarker.setBackground(getResources().getDrawable(R.drawable.terror_marker));
            } else
                terrorMarker.setBackground(getResources().getDrawable(R.drawable.terror_marker_greyed));


            // Set Faction Cube Data
            // Set US Values
            usTroopsNum.setText(String.valueOf(space.getUsTroopsNum(location)));
            usBaseNum.setText(String.valueOf(space.getUsBaseNum(location)));
            usSFaNum.setText(String.valueOf(space.getUsSFaNum(location)));
            usSFuNum.setText(String.valueOf(space.getUsSFuNum(location)));


            // Set ARVN Values
            arvnTroopsNum.setText(String.valueOf(space.getArvnTroopsNum(location)));
            arvnPoliceNum.setText(String.valueOf(space.getArvnPoliceNum(location)));
            arvnBaseNum.setText(String.valueOf(space.getArvnBaseNum(location)));
            arvnRangersANum.setText(String.valueOf(space.getArvnRangersANum(location)));
            arvnRangersUNum.setText(String.valueOf(space.getArvnRangersUNum(location)));

            // Set NVA Values
            nvaTroopsNum.setText(String.valueOf(space.getNvaTroopsNum(location)));
            nvaBasesNum.setText(String.valueOf(space.getNvaBasesNum(location)));
            nvaGuerrillasANum.setText(String.valueOf(space.getNvaGuerrillasANum(location)));
            nvaGuerrillasUNum.setText(String.valueOf(space.getNvaGuerrillasUNum(location)));

            // Set VC Values
            vcBasesNum.setText(String.valueOf(space.getVcBasesNum(location)));
            vcTBasesNum.setText(String.valueOf(space.getVcTBasesNum(location)));
            vcGuerrillasANum.setText(String.valueOf(space.getVcGuerrillasANum(location)));
            vcGuerrillasUNum.setText(String.valueOf(space.getVcGuerrillasUNum(location)));


        } //end of if (intent....
    } //end of get intent function....



}
