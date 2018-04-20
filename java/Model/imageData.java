package Model;

import android.content.Context;

import java.util.Objects;

import fitl.com.fire_in_the_lake.R;

import static Model.mapLocations.SmapLocations;

/**
 * Created by Brandon on 3/12/2018.
 */

public class imageData {

    public static int[] locationImages = new int[] {R.drawable.an_loc, R.drawable.ba_xuyen, R.drawable.binh_dinh, R.drawable. binh_tuy_binh_thuan,  R.drawable.cam_ranh,
            R.drawable.can_tho, R.drawable.central_laos, R.drawable.da_nang, R.drawable.hue, R.drawable.khanh_hoa, R.drawable.kien_giang_an_xuyen, R.drawable.kien_hoa_vinh_binh,
            R.drawable.kien_phong, R.drawable.kontum, R.drawable.north_vietnam, R.drawable.northeast_cambodia, R.drawable.phu_bon_phu_yen, R.drawable.phuoc_long, R.drawable.pleiku_darlac,
            R.drawable.quang_duc_long_khanh, R.drawable.quang_nam, R.drawable.quang_tin_quang_ngai, R.drawable.quang_tri_thiua_thien,  R.drawable.qui_nhon,  R.drawable.saigon,
            R.drawable.sihanoukville,  R.drawable.southern_laos, R.drawable.tay_ninh, R.drawable.the_fishhook, R.drawable.the_parrots_beak};

    public static int[] cubeImages = new int[] {R.drawable.us_troops, R.drawable.arvn_troops, R.drawable.arvn_police, R.drawable.nva_troops};

    public static int[] guerrillas = new int[] {R.drawable.nva_guerrillas_a, R.drawable.nva_guerrillas_u, R.drawable.arvn_ranger_a, R.drawable.arvn_ranger_u,
            R.drawable.us_sf_a, R.drawable.us_sf_u, R.drawable.vc_guerrillas_a, R.drawable.vc_guerrillas_u};

    public static int[] supportImages = new int[] {R.drawable.active_oppose, R.drawable.active_support, R.drawable.passive_oppose, R.drawable.passive_support, R.drawable.nuetral_support};

    public static int[] controlImages = new int[] {R.drawable.coin_control, R.drawable.nva_control, R.drawable.uncontrolled};

    public static int[] resourceImages = new int[] {R.drawable.arvn_resources, R.drawable.nva_resources, R.drawable.vc_resources};

    public static int[] baseImages = new int[] {R.drawable.us_base, R.drawable.arvn_base, R.drawable.nva_base, R.drawable.vc_base};

    //Set control image for each location by writing the appropriate string
    public static int setControlImages(String controlStatus) {

        if (Objects.equals(controlStatus, new String("nva control"))) {
            return R.drawable.nva_control;
        } else if (Objects.equals(controlStatus, new String("coin control"))) {
            return R.drawable.coin_control;
        } else if (Objects.equals(controlStatus, new String("uncontrolled"))) {
            return  R.drawable.uncontrolled;
        } else {
            return  R.drawable.uncontrolled;
        }
    }

    //Set control image for each location by writing the appropriate string
    public static int setSupportImages(String supportStatus) {

        if (Objects.equals(supportStatus, new String("active opposition"))) {
            return R.drawable.active_oppose;
        } else if (Objects.equals(supportStatus, new String("active support"))) {
            return R.drawable.active_support;
        } else if (Objects.equals(supportStatus, new String("passive opposition"))) {
            return  R.drawable.passive_oppose;
        } else if (Objects.equals(supportStatus, new String("passive support"))) {
            return  R.drawable.passive_support;
        } else if (Objects.equals(supportStatus, new String("neutral support"))) {
            return R.drawable.nuetral_support;
        } else {
            return R.drawable.nuetral_support;
        }

    }



}