package fitl.com.fire_in_the_lake;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import Model.TinyDB;
import Model.mapData;
import Model.mapLocations;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    CheckBox CBshortGame,CBmediumGame,CBlongGame;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_home,null);

        CBshortGame = (CheckBox) rootView.findViewById(R.id.CBshortGameID);
        CBshortGame.setOnClickListener(this);
        CBmediumGame = (CheckBox) rootView.findViewById(R.id.CBmediumGameID);
        CBmediumGame.setOnClickListener(this);
        CBlongGame = (CheckBox) rootView.findViewById(R.id.CBlongGameID);
        CBlongGame.setOnClickListener(this);


        return rootView;

    }

    @Override
    public void onClick(View v) {

        TinyDB tinydb = new TinyDB(getContext());
        mapData data = new mapData(getContext());

        switch (v.getId()) {
            case R.id.CBshortGameID:
                if (CBshortGame.isChecked())
                    Toast.makeText(getContext(),"Short Game", Toast.LENGTH_SHORT).show();
                    tinydb.clear();
                    CBmediumGame.setChecked(false);
                    CBlongGame.setChecked(false);
                    tinydb.putString("gameScenario", "Short Game");
                    data.initGameScenario();

                break;
            case R.id.CBmediumGameID:
                if (CBmediumGame.isChecked())
                    Toast.makeText(getContext(),"Medium Game", Toast.LENGTH_SHORT).show();
                    tinydb.clear();
                    CBshortGame.setChecked(false);
                    CBlongGame.setChecked(false);
                    tinydb.putString("gameScenario", "Medium Game");
                    data.initGameScenario();

                break;
            case R.id.CBlongGameID:
                if (CBlongGame.isChecked())
                    Toast.makeText(getContext(),"Long Game", Toast.LENGTH_SHORT).show();
                    tinydb.clear();
                    CBshortGame.setChecked(false);
                    CBmediumGame.setChecked(false);
                    tinydb.putString("gameScenario", "Full Game");
                    data.initGameScenario();

                break;
        }

    }
}
