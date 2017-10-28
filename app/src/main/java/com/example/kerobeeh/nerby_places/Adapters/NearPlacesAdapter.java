package com.example.kerobeeh.nerby_places.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kerobeeh.nerby_places.Place_model.PlaceModel;
import com.example.kerobeeh.nerby_places.R;

/**
 * Created by pc on 28/10/2017.
 */

public class NearPlacesAdapter extends ArrayAdapter<PlaceModel> {


public NearPlacesAdapter(@NonNull Context context, PlaceModel[] resource) {
        super(context,0, resource);


        }



@Override
public View getView(final int position, View view, @NonNull ViewGroup parent) {
    
    
    if (view ==null) {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.near_row, parent, false);

    }

        PlaceModel placeModel=getItem(position);

        ImageView maps2 = (ImageView) view.findViewById(R.id.imagemaps2);
        ImageView img2 = (ImageView) view.findViewById(R.id.imgview2);
        TextView title2 = (TextView) view.findViewById(R.id.titleview2);
        TextView desc2 = (TextView) view.findViewById(R.id.descview2);

        title2.setText(placeModel.getName());



        return view;
        }

        }

