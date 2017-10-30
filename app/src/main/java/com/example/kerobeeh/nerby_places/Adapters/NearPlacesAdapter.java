package com.example.kerobeeh.nerby_places.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kerobeeh.nerby_places.MapsActivity;
import com.example.kerobeeh.nerby_places.Place_model.PlaceModel;
import com.example.kerobeeh.nerby_places.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

/**
 * Created by pc on 28/10/2017.
 */

public class NearPlacesAdapter extends ArrayAdapter<PlaceModel> {


View v;
public NearPlacesAdapter(@NonNull Context context, PlaceModel[] resource) {
        super(context,0, resource);


        }



@Override
public View getView(final int position, View view, @NonNull ViewGroup parent) {
    
    
    if (view ==null) {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.near_row, parent, false);

    }

        final PlaceModel placeModel=getItem(position);

        ImageView maps2 = (ImageView) v.findViewById(R.id.imagemaps2);
        maps2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getContext(),MapsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("placeModel", (Serializable) placeModel);
            getContext().startActivity(intent);
        }
    });



        ImageView img2 = (ImageView) v.findViewById(R.id.imgview2);

    Picasso.with(getContext()).load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&" +
            "photoreference=" +placeModel.getPhotos().get(0).getPhotoReference()+
            "&key=AIzaSyCyw7cfzROdyhpUO6Z3eQwymNHdjU9j2tU").into(img2);


        TextView title2 = (TextView) v.findViewById(R.id.titleview2);
        TextView desc2 = (TextView) v.findViewById(R.id.descview2);

        desc2.setText( placeModel.getTypes().get(0)+"");

        title2.setText(placeModel.getName());


        return view;
        }

        }

