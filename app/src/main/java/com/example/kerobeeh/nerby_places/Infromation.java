package com.example.kerobeeh.nerby_places;

import android.app.Fragment;
import android.content.pm.SharedLibraryInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kerobeeh.nerby_places.Place_model.PlaceModel;

/**
 * Created by kero beeh on 10/29/2017.
 */

public class Infromation extends Fragment {
  View view;

    PlaceModel[] PlaceModelS;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.information, container, false);

     //   Bundle bundle = this.getArguments();
       //  PlaceModelS;
     //   bundle.getString("title",  PlaceModelS[i].getName());





        return view;
    }
}
