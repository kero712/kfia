package com.example.kerobeeh.nerby_places;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kerobeeh.nerby_places.Adapters.FavPlacesAdapter;
import com.example.kerobeeh.nerby_places.Place_model.PlaceModel;

import java.util.ArrayList;



public class Favourite extends Fragment {


PlaceModel[] PlaceModelS;


        View view;
        ListView favorite;
    FragmentManager FragmentManager;

    FavPlacesAdapter favPlacesAdapter;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favourite, container, false);


/*


        FavPlacesAdapter favPlacesAdapter = new FavPlacesAdapter(getContext(),PlaceModelS);
        favorite.setAdapter(favPlacesAdapter);
        favorite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(search.this, placeModels[i].getName(), Toast.LENGTH_SHORT).show();
                FragmentManager.beginTransaction().replace(R.id.framCont, new PlaceDetailsActivity(), "PlaceDetailsActivity").commit();
            }
        });
*/
        return view;
    }



}
