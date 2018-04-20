package Adapter;

import android.content.Context;
import android.content.Intent;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import Model.TinyDB;
import Model.imageData;
import Model.mapData;
import Model.mapLocations;
import fitl.com.fire_in_the_lake.R;
import fitl.com.fire_in_the_lake.location_data_activity;

import static Model.mapLocations.SmapLocations;
import static java.security.AccessController.getContext;

/**
 * Created by Brandon on 2/19/2018.
 */


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.LocationViewHolder> {


    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_locations,viewGroup,false);
        LocationViewHolder pvh = new LocationViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder LocationViewHolder, int position) {
        ((LocationViewHolder) LocationViewHolder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return imageData.locationImages.length;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Context context;
        CardView cvID;

        mapLocations locations;
        mapData data;

        TextView titleName;
        ImageView locImage;

        //US variables
        TextView usTroopsText;
        TextView usBaseNum;
        TextView usSFuNum;
        TextView usSFaNum;

        ImageView usTroopsImage;
        ImageView usBaseImage;
        ImageView usSFuImage;
        ImageView usSFaImage;

        //ARVN Variables
        TextView arvnTroopsNum;
        TextView arvnPoliceNum;
        TextView arvnBaseNum;
        TextView arvnRangersUNum;
        TextView arvnRangersANum;

        ImageView arvnTroopsImage;
        ImageView arvnPoliceImage;
        ImageView arvnBaseImage;
        ImageView arvnRangersUImage;
        ImageView arvnRangersAImage;

        //NVA Variables
        TextView nvaTroopNum;
        TextView nvaBasesNum;
        TextView nvaGuerrillasUNum;
        TextView nvaGuerrillasANum;

        ImageView nvaTroopsImage;
        ImageView nvaBasesImage;
        ImageView nvaGuerrillasUImage;
        ImageView nvaGuerrillasAImage;

        //VC Variables
        TextView vcGuerrillasUNum;
        TextView vcGuerrillasANum;
        TextView vcBasesNum;
        TextView vcTBasesNum;

        ImageView vcGuerrillasUImage;
        ImageView vcGuerrillasAImage;
        ImageView vcBasesImage;
        ImageView vcTBasesImage;

        ImageView controlImage;
        ImageView supportImage;
        ImageView terrorImage;

        String controlStatus;
        String supportStatus;
        boolean terrorStatus;


        LocationViewHolder(View itemView) {

            super(itemView);

            context = (Context) itemView.getContext();

            cvID = (CardView) itemView.findViewById(R.id.cvID);
            titleName = (TextView) itemView.findViewById(R.id.nameId);
            locImage = (ImageView) itemView.findViewById(R.id.locImageID);

            //US TextView Values
            usTroopsText = (TextView) itemView.findViewById(R.id.usTroopValueID);
            usBaseNum = (TextView) itemView.findViewById(R.id.usBaseValueID);
            usSFuNum = (TextView) itemView.findViewById(R.id.usSFUValueID);
            usSFaNum = (TextView) itemView.findViewById(R.id.usSFAValueID);

            //US Images
            usTroopsImage = (ImageView) itemView.findViewById(R.id.usCubeImageID);
            usBaseImage = (ImageView) itemView.findViewById(R.id.usBaseImageID);
            usSFuImage = (ImageView) itemView.findViewById(R.id.usSFUImageID);
            usSFaImage = (ImageView) itemView.findViewById(R.id.usSFAImageID);


            //ARVN TextView Values
            arvnTroopsNum = (TextView) itemView.findViewById(R.id.arvnTValueID);
            arvnPoliceNum = (TextView) itemView.findViewById(R.id.arvnPValueID);
            arvnBaseNum = (TextView) itemView.findViewById(R.id.arvnBaseValueID);
            arvnRangersUNum = (TextView) itemView.findViewById(R.id.arvnRangersUValueID);
            arvnRangersANum = (TextView) itemView.findViewById(R.id.arvnRangersAValueID);

            //ARVN Images
            arvnTroopsImage = (ImageView) itemView.findViewById(R.id.arvnTCubeImageID);
            arvnPoliceImage = (ImageView) itemView.findViewById(R.id.arvnPCubeImageID);
            arvnBaseImage = (ImageView) itemView.findViewById(R.id.arvnBaseImageID);
            arvnRangersUImage = (ImageView) itemView.findViewById(R.id.arvnRangersUImageID);
            arvnRangersAImage = (ImageView) itemView.findViewById(R.id.arvnRangersAImageID);

            //NVA TextView Values
            nvaTroopNum = (TextView) itemView.findViewById(R.id.nvaValueID);
            nvaBasesNum = (TextView) itemView.findViewById(R.id.nvaBaseValueID);
            nvaGuerrillasUNum = (TextView) itemView.findViewById(R.id.nvaGuerrillasUValueID);
            nvaGuerrillasANum = (TextView) itemView.findViewById(R.id.nvaGuerrillasAValueID);

            //NVA Images
            nvaTroopsImage = (ImageView) itemView.findViewById(R.id.nvaCubeImageID);
            nvaBasesImage = (ImageView) itemView.findViewById(R.id.nvaBaseImageID);
            nvaGuerrillasUImage = (ImageView) itemView.findViewById(R.id.nvaGuerrillasUImageID);
            nvaGuerrillasAImage = (ImageView) itemView.findViewById(R.id.nvaGuerrillasAImageID);

            //VC TextView Values
            vcGuerrillasUNum = (TextView) itemView.findViewById(R.id.vcGuerrillasUValueID);
            vcGuerrillasANum = (TextView) itemView.findViewById(R.id.vcGuerrillasAValueID);
            vcBasesNum = (TextView) itemView.findViewById(R.id.vcBaseValueID);
            vcTBasesNum = (TextView) itemView.findViewById(R.id.vcTBaseValueID);

            vcGuerrillasUImage = (ImageView) itemView.findViewById(R.id.vcGuerrillasUImageID);
            vcGuerrillasAImage = (ImageView) itemView.findViewById(R.id.vcGuerrillasAImageID);
            vcBasesImage = (ImageView) itemView.findViewById(R.id.vcBaseImageID);
            vcTBasesImage = (ImageView) itemView.findViewById(R.id.vcTBaseImageID);

            //Location status
            controlImage = (ImageView) itemView.findViewById(R.id.controlImageID);
            supportImage = (ImageView) itemView.findViewById(R.id.supportImageID);
            terrorImage = (ImageView) itemView.findViewById(R.id.terrorImageID);

            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            populateView(position);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            //Open up new activity to display location data
            //Pass in location name to obtain data for that location
            Intent intent = new Intent(this.context, location_data_activity.class);
            intent.putExtra("location",SmapLocations[position]);
            this.context.startActivity(intent);

        }

        public void populateView (int position){

            mapLocations locations = (new mapLocations(context));
            //mapData data = (new mapData(context));

            //Set location image and title name
            locImage.setBackgroundResource(imageData.locationImages[position]);
            titleName.setText(mapLocations.SmapLocations[position]);


            ///////////////////////////////////////////////////////////////////////////////////////////////////////
            // Set US Values
            if ( locations.getUsTroopsNum(SmapLocations[position]) != 0) {
                usTroopsImage.setVisibility(View.VISIBLE);
                usTroopsText.setVisibility(View.VISIBLE);
                usTroopsText.setText(String.valueOf(locations.getUsTroopsNum(SmapLocations[position])));
            } else {
                usTroopsImage.setVisibility(View.INVISIBLE);
                usTroopsText.setVisibility(View.INVISIBLE);

            }

            if (locations.getUsBaseNum(SmapLocations[position]) != 0) {
                usBaseNum.setVisibility(View.VISIBLE);
                usBaseImage.setVisibility(View.VISIBLE);
                usBaseNum.setText(String.valueOf(locations.getUsBaseNum(SmapLocations[position])));
            } else {
                usBaseNum.setVisibility(View.INVISIBLE);
                usBaseImage.setVisibility(View.INVISIBLE);
            }

            if (locations.getUsSFuNum(SmapLocations[position]) != 0) {
                usSFuNum.setVisibility(View.VISIBLE);
                usSFuImage.setVisibility(View.VISIBLE);
                usSFuNum.setText(String.valueOf(locations.getUsSFuNum(SmapLocations[position])));
            } else {
                usSFuNum.setVisibility(View.INVISIBLE);
                usSFuImage.setVisibility(View.INVISIBLE);
            }

            if (locations.getUsSFaNum(SmapLocations[position]) != 0) {
                usSFaNum.setVisibility(View.VISIBLE);
                usSFaImage.setVisibility(View.VISIBLE);
                usSFaNum.setText(String.valueOf(locations.getUsSFaNum(SmapLocations[position])));
            } else {
                usSFaNum.setVisibility(View.INVISIBLE);
                usSFaImage.setVisibility(View.INVISIBLE);
            }


            ///////////////////////////////////////////////////////////////////////////////////////////////////////
            // Set ARVN Values
            if (locations.getArvnTroopsNum(SmapLocations[position]) != 0) {
                arvnTroopsImage.setVisibility(View.VISIBLE);
                arvnTroopsNum.setVisibility(View.VISIBLE);
                arvnTroopsNum.setText(String.valueOf(locations.getArvnTroopsNum(SmapLocations[position])));
            } else {
                arvnTroopsImage.setVisibility(View.INVISIBLE);
                arvnTroopsNum.setVisibility(View.INVISIBLE);
            }

            if (locations.getArvnPoliceNum(SmapLocations[position]) != 0) {
                arvnPoliceImage.setVisibility(View.VISIBLE);
                arvnPoliceNum.setVisibility(View.VISIBLE);
                arvnPoliceNum.setText(String.valueOf(locations.getArvnPoliceNum(SmapLocations[position])));
            } else {
                arvnPoliceImage.setVisibility(View.INVISIBLE);
                arvnPoliceNum.setVisibility(View.INVISIBLE);
            }

            if (locations.getArvnBaseNum(SmapLocations[position]) != 0) {
                arvnBaseImage.setVisibility(View.VISIBLE);
                arvnBaseNum.setVisibility(View.VISIBLE);
                arvnBaseNum.setText(String.valueOf(locations.getArvnBaseNum(SmapLocations[position])));
            } else {
                arvnBaseImage.setVisibility(View.INVISIBLE);
                arvnBaseNum.setVisibility(View.INVISIBLE);
            }

            if (locations.getArvnRangersUNum(SmapLocations[position]) != 0) {
                arvnRangersUImage.setVisibility(View.VISIBLE);
                arvnRangersUNum.setVisibility(View.VISIBLE);
                arvnRangersUNum.setText(String.valueOf(locations.getArvnRangersUNum(SmapLocations[position])));
            } else {
                arvnRangersUImage.setVisibility(View.INVISIBLE);
                arvnRangersUNum.setVisibility(View.INVISIBLE);
            }

            if (locations.getArvnRangersANum(SmapLocations[position]) != 0) {
                arvnRangersAImage.setVisibility(View.VISIBLE);
                arvnRangersANum.setVisibility(View.VISIBLE);
                arvnRangersANum.setText(String.valueOf(locations.getArvnRangersANum(SmapLocations[position])));
            } else {
                arvnRangersAImage.setVisibility(View.INVISIBLE);
                arvnRangersANum.setVisibility(View.INVISIBLE);
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////////

            //Set NVA Values
            if (locations.getNvaTroopsNum(SmapLocations[position]) != 0) {
                nvaTroopsImage.setVisibility(View.VISIBLE);
                nvaTroopNum.setVisibility(View.VISIBLE);
                nvaTroopNum.setText(String.valueOf(locations.getNvaTroopsNum(SmapLocations[position])));
            } else {
                nvaTroopsImage.setVisibility(View.INVISIBLE);
                nvaTroopNum.setVisibility(View.INVISIBLE);
            }

            if (locations.getNvaBasesNum(SmapLocations[position]) != 0) {
                nvaBasesImage.setVisibility(View.VISIBLE);
                nvaBasesNum.setVisibility(View.VISIBLE);
                nvaBasesNum.setText(String.valueOf(locations.getNvaBasesNum(SmapLocations[position])));
            } else {
                nvaBasesImage.setVisibility(View.INVISIBLE);
                nvaBasesNum.setVisibility(View.INVISIBLE);
            }

            if (locations.getNvaGuerrillasUNum(SmapLocations[position]) != 0) {
                nvaGuerrillasUImage.setVisibility(View.VISIBLE);
                nvaGuerrillasUNum.setVisibility(View.VISIBLE);
                nvaGuerrillasUNum.setText(String.valueOf(locations.getNvaGuerrillasUNum(SmapLocations[position])));
            } else {
                nvaGuerrillasUImage.setVisibility(View.INVISIBLE);
                nvaGuerrillasUNum.setVisibility(View.INVISIBLE);
            }

            if (locations.getNvaGuerrillasANum(SmapLocations[position]) != 0) {
                nvaGuerrillasAImage.setVisibility(View.VISIBLE);
                nvaGuerrillasANum.setVisibility(View.VISIBLE);
                nvaGuerrillasANum.setText(String.valueOf(locations.getNvaGuerrillasANum(SmapLocations[position])));
            } else {
                nvaGuerrillasAImage.setVisibility(View.INVISIBLE);
                nvaGuerrillasANum.setVisibility(View.INVISIBLE);
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////////

            //Set VC Values
            if (locations.getVcBasesNum(SmapLocations[position]) != 0) {
                vcBasesImage.setVisibility(View.VISIBLE);
                vcBasesNum.setVisibility(View.VISIBLE);
                vcBasesNum.setText(String.valueOf(locations.getVcBasesNum(SmapLocations[position])));
            } else {
                vcBasesImage.setVisibility(View.INVISIBLE);
                vcBasesNum.setVisibility(View.INVISIBLE);
            }


            if (locations.getVcTBasesNum(SmapLocations[position]) != 0) {
                vcTBasesImage.setVisibility(View.VISIBLE);
                vcTBasesNum.setVisibility(View.VISIBLE);
                vcTBasesNum.setText(String.valueOf(locations.getVcTBasesNum(SmapLocations[position])));
            } else {
                vcTBasesImage.setVisibility(View.INVISIBLE);
                vcTBasesNum.setVisibility(View.INVISIBLE);
            }


            if (locations.getVcGuerrillasUNum(SmapLocations[position]) != 0) {
                vcGuerrillasUImage.setVisibility(View.VISIBLE);
                vcGuerrillasUNum.setVisibility(View.VISIBLE);
                vcGuerrillasUNum.setText(String.valueOf(locations.getVcGuerrillasUNum(SmapLocations[position])));
            } else {
                vcGuerrillasUImage.setVisibility(View.INVISIBLE);
                vcGuerrillasUNum.setVisibility(View.INVISIBLE);
            }

            if (locations.getVcGuerrillasANum(SmapLocations[position]) != 0) {
                vcGuerrillasAImage.setVisibility(View.VISIBLE);
                vcGuerrillasANum.setVisibility(View.VISIBLE);
                vcGuerrillasANum.setText(String.valueOf(locations.getVcGuerrillasANum(SmapLocations[position])));
            } else {
                vcGuerrillasAImage.setVisibility(View.INVISIBLE);
                vcGuerrillasANum.setVisibility(View.INVISIBLE);
            }



            // get control status of each location
            controlStatus = locations.getControl(SmapLocations[position]);
            supportStatus = locations.getSupport(SmapLocations[position]);
            terrorStatus = locations.isTerrorState(SmapLocations[position]);


            // set control status of each location
            if (Objects.equals(controlStatus, new String("nva control"))) {
                controlImage.setImageResource( imageData.setControlImages("nva control"));
            } else if (Objects.equals(controlStatus, new String("coin control"))) {
                controlImage.setImageResource( imageData.setControlImages("coin control"));
            } else if (Objects.equals(controlStatus, new String("uncontrolled"))) {
                controlImage.setImageResource( imageData.setControlImages("uncontrolled"));
            } else {
                controlImage.setImageResource( imageData.setControlImages("uncontrolled"));
            }

            //set support status
            if (Objects.equals(supportStatus, new String("passive support"))) {
                supportImage.setImageResource(imageData.setSupportImages("passive support"));
            } else if (Objects.equals(supportStatus, new String("passive opposition"))) {
                supportImage.setImageResource(imageData.setSupportImages("passive opposition"));
            } else if (Objects.equals(supportStatus, new String("active support"))) {
                supportImage.setImageResource(imageData.setSupportImages("active support"));
            } else if (Objects.equals(supportStatus, new String("active opposition"))) {
                supportImage.setImageResource(imageData.setSupportImages("active opposition"));
            } else if (Objects.equals(supportStatus, new String("neutral support"))) {
                supportImage.setImageResource(imageData.setSupportImages("neutral support"));
            } else {
                supportImage.setImageResource(imageData.setSupportImages("neutral support"));
            }

            //Set Terror status
            if (terrorStatus) {
                terrorImage.setVisibility(View.VISIBLE);
            } else
                terrorImage.setVisibility(View.INVISIBLE);



        }




        }
    }