package me.volframv.silver_tide.FragmentActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.volframv.silver_tide.R;

/**
 * Created by PRIME-USER-X10423 on 11/11/2016.
 */

public class VocFragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        ViewGroup viewGroup=(ViewGroup) inflater.inflate(R.layout.list_item, container,false);
        return viewGroup;
    }
}
