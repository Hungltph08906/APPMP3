package vn.edu.poly.appmp3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.poly.appmp3.Activity.PlaynhacActivity;
import vn.edu.poly.appmp3.Adapter.PlaynhacAdapter;
import vn.edu.poly.appmp3.R;

public class Fragment_Playdanhsachbaihat extends Fragment {


    View view;
    RecyclerView recyclerViewPlaynhac;
    PlaynhacAdapter playnhacAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playdanhsachcacbaihat,container,false);
        recyclerViewPlaynhac = view.findViewById(R.id.recyclerViewPlaybaihat);
        if (PlaynhacActivity.mangbaihat.size()>0){
            playnhacAdapter = new PlaynhacAdapter(getActivity(), PlaynhacActivity.mangbaihat);

            recyclerViewPlaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewPlaynhac.setAdapter(playnhacAdapter);
        }


        return view;
    }
}
