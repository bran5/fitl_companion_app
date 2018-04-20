package fitl.com.fire_in_the_lake;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import Adapter.RVAdapter;
import Model.TinyDB;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public LocationsFragment newInstance() {
        // Required empty public constructor
        return new LocationsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_locations,null);
        recyclerView = rootView.findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RVAdapter adapter = new RVAdapter();
        recyclerView.setAdapter(adapter);

        return rootView;

    }

}
