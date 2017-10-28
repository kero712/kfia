package com.example.kerobeeh.nerby_places;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class Favourite extends Fragment implements  SearchView.OnQueryTextListener {
    View view;
    ListView listfavourite;
//    static ArrayList<ListItem> favourate;
//    search.Array_adapter array_adapter_favourate;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search, container, false);


//        class Array_adapter extends ArrayAdapter {
//
//
//            public Array_adapter(@NonNull Context context, @LayoutRes int resource) {
//                super(context, resource);
//
//
//            }
//
//            @Override
//            public int getCount() {
//                return favourate.size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return favourate.get(position).Name;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//
//            @Override
//            public View getView(final int position, View view, @NonNull ViewGroup parent) {
//                LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//                final View v = inflater.inflate(R.layout.fav_row, parent, false);
//
//                ImageView maps = (ImageView) v.findViewById(R.id.imagemaps);
//                ImageView img = (ImageView) v.findViewById(R.id.imgview);
//                TextView title = (TextView) v.findViewById(R.id.titleview);
//                TextView desc = (TextView) v.findViewById(R.id.descview);
//
//                title.setText(favourate.get(position).Name);
//
//                //--------------------------------------
//
//                return view;
//            }
//
//        }
//
//        favourate = new ArrayList<ListItem>();
//        array_adapter_favourate = new search.Array_adapter(getActivity(), R.layout.fav_row);
//        listfavourite = (ListView) view.findViewById(R.id.favorite);
//        favourate.add(new ListItem("hello"));
//        listfavourite.setAdapter(array_adapter_favourate);
//

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


//    final class Array_adapter extends ArrayAdapter {
//
//
//        public Array_adapter(@NonNull Context context, @LayoutRes int resource) {
//            super(context, resource);
//
//
//        }
//
//
//        @Override
//        public int getCount() {
//            return search.favourate.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return search.favourate.get(position).Name;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//
//        @Override
//        public View getView(final int position, View view, @NonNull ViewGroup parent) {
//            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            final View v = inflater.inflate(R.layout.fav_row, parent, false);
//
//            ImageView maps = (ImageView) v.findViewById(R.id.imagemaps);
//            ImageView img = (ImageView) v.findViewById(R.id.imgview);
//            TextView title = (TextView) v.findViewById(R.id.titleview);
//            TextView desc = (TextView) v.findViewById(R.id.descview);
//            title.setText(search.favourate.get(position).Name);
//            return view;
//        }
//
//    }
}
