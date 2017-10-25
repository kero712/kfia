package com.example.kerobeeh.nerby_places;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;


public class search extends Fragment implements   SearchView.OnQueryTextListener {

    ImageView imgfavo ,imgOut;
    SearchView Search;
    ListView listfav, listnear;
    View view;
    static ArrayList<ListItem> favourate, nearbay;
    Array_adapter array_adapter_favourate, array_adapter_nearbay;


          FragmentManager FragmentManager;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search, container, false);
//----------------------------------------------


        imgfavo = (ImageView) view.findViewById(R.id.imgfav);
        imgOut = (ImageView) view.findViewById(R.id.imgout);


        imgfavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Main.FA();


            }
        });
        imgOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Main.bC();



            }
        });


        //------------------------------------

        
      //  Search = (SearchView) view.findViewById(R.id.SearchView);
        //Search.setOnQueryTextListener((SearchView.OnQueryTextListener) this);





  //-----------------------------------
        favourate = new ArrayList<ListItem>();
        array_adapter_favourate = new Array_adapter(getActivity(), R.layout.fav_row);
        listfav = (ListView) view.findViewById(R.id.listfavorate);
        favourate.add(new ListItem("hello"));
        listfav.setAdapter(array_adapter_favourate);

        //----------------------------------


        nearbay = new ArrayList<ListItem>();
        array_adapter_nearbay = new Array_adapter(getActivity(), R.layout.near_row);
        listnear = (ListView) view.findViewById(R.id.listnearby);
        nearbay.add(new ListItem(" yarb tt3ml"));
        listnear.setAdapter(array_adapter_nearbay);


        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {





        return false;
    }




    public static class Array_adapter extends ArrayAdapter {


        public Array_adapter(@NonNull Context context, @LayoutRes int resource) {
            super(context, resource);


        }

        @Override
        public int getCount() {
            return favourate.size();
        }

        @Override
        public Object getItem(int position) {
            return favourate.get(position).Name;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(final int position, View view, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final View v = inflater.inflate(R.layout.fav_row, parent, false);

            ImageView maps = (ImageView) v.findViewById(R.id.imagemaps);
            ImageView img = (ImageView) v.findViewById(R.id.imgview);
            TextView title = (TextView) v.findViewById(R.id.titleview);
            TextView desc = (TextView) v.findViewById(R.id.descview);

            title.setText(favourate.get(position).Name);

           //--------------------------------------


            final View v2 = inflater.inflate(R.layout.near_row, parent, false);

            ImageView maps2 = (ImageView) v2.findViewById(R.id.imagemaps2);
            ImageView img2 = (ImageView) v2.findViewById(R.id.imgview2);
            TextView title2 = (TextView) v2.findViewById(R.id.titleview2);
            TextView desc2 = (TextView) v2.findViewById(R.id.descview2);

            title.setText(nearbay.get(position).Name);



            return v2;
        }

    }


}




