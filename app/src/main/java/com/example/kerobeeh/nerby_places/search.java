package com.example.kerobeeh.nerby_places;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kerobeeh.nerby_places.Place_model.PlaceModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;


public class search extends Fragment implements   SearchView.OnQueryTextListener {

    ImageView imgfavo ,imgOut;
    SearchView Search;
    ListView listfav, listnear;
    View view;
    ProgressDialog progressDialog;
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

        
        Search = (SearchView) view.findViewById(R.id.SearchView);
        Search.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
         Search.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type="+Search.getText().tostring"&keyword=cruise&key=AIzaSyA9VWRXeMF5iK0FYhXWChN9Lq7_PkefjGg";

             }
         });
        class GetPlaces extends AsyncTask<String , Void ,PlaceModel[] > {

            protected void onPreExecute() {

                progressDialog =new ProgressDialog(PlaceSearch.this);
                progressDialog.setMessage("loading.....");
                progressDialog.show();
            }
            OkHttpClient client = new OkHttpClient();

            String run(String url) throws IOException {
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                Response response = client.newCall(request).execute();

                return response.body().string();
            }

            protected PlaceModel[] doInBackground(String... url) {
                try {
                    String s = run(url[0]);
                    Log.d("hesham", s);
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");

                    placemodels = gson.fromJson(jsonArray.toString(), PlaceModel[].class);
                    Log.d("zamel", "doInBackground: "+placemodels.length);
                    return placemodels;

                }
                catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            protected void onPostExecute(PlaceModel[]placesModels) {
                progressDialog.dismiss();
                if(placesModels!=null) {
                    PlaceAdapter    placesadapter2 = new PlaceAdapter(PlaceSearch.this, placemodels);
                    lstplaces.setAdapter(placesadapter2);
                    lstplaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent =new Intent(PlaceSearch.this,row_details.class);
                            intent.putExtra("placemodels",(Serializable) placemodels[i]);
                            startActivity(intent);

                        }
                    });

                }
            }
        }




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




