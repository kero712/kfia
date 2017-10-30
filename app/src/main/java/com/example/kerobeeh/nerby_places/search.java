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
import android.widget.Toast;

import com.example.kerobeeh.nerby_places.Adapters.FavPlacesAdapter;
import com.example.kerobeeh.nerby_places.Adapters.NearPlacesAdapter;
import com.example.kerobeeh.nerby_places.Place_model.PlaceModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.attr.data;


public class search extends Fragment  {


    ImageView imgfavo, imgOut;
    SearchView Search;
    ListView listfav, listnear;
    View view;
    ProgressDialog progressDialog;

//    Array_adapter array_adapter_favourate, array_adapter_nearbay;


    FragmentManager FragmentManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search, container, false);
//----------------------------------------------

        FragmentManager = getFragmentManager();
        imgfavo = (ImageView) view.findViewById(R.id.imgfav);
        imgOut = (ImageView) view.findViewById(R.id.imgout);
        listnear=(ListView)view.findViewById(R.id.listnearby) ;




        imgfavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager.beginTransaction().replace(R.id.framCont,new Favourite(),"Favourite").commit();


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

        Search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type="+query+"&key=AIzaSyCyw7cfzROdyhpUO6Z3eQwymNHdjU9j2tU";
                Log.d("kero", "onQueryTextSubmit: "+url);
                GetPlacesFromWeb getPlacesFromWeb=new GetPlacesFromWeb();
                getPlacesFromWeb.execute(url);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });








        return view;
    }
    private   class GetPlacesFromWeb extends AsyncTask<String, Void, PlaceModel[]> {
        @Override
        protected void onPreExecute() {
            progressDialog=new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading ... ");
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



        @Override
        protected void onPostExecute(final PlaceModel[] placeModels) {
            FragmentManager = getFragmentManager();
            progressDialog.dismiss();
            if (placeModels != null) {

                NearPlacesAdapter nearPlacesAdapter = new NearPlacesAdapter(getActivity(), placeModels);
                listnear.setAdapter(nearPlacesAdapter);
                listnear.setOnItemClickListener(new AdapterView.OnItemClickListener() {




                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                      /*  String selectData =data.get(i);
                        Infromation infromation = new Infromation();
                        Bundle bundle = new Bundle();
                        bundle.putString("selectData", selectData);
                        infromation.setArguments(bundle);
*/

                        // Toast.makeText(search.this, placeModels[i].getName(), Toast.LENGTH_SHORT).show();
                        FragmentManager.beginTransaction().replace(R.id.framCont, new Infromation(), "Infromation").commit();
                    }
                });
           /*     FavPlacesAdapter favPlacesAdapter = new FavPlacesAdapter(getActivity(), placeModels);
                listfav.setAdapter(nearPlacesAdapter);
                listfav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        // Toast.makeText(search.this, placeModels[i].getName(), Toast.LENGTH_SHORT).show();
                        FragmentManager.beginTransaction().replace(R.id.framCont, new Infromation(), "Infromation").commit();
                    }
                });
                */

            }
        }




        @Override
        protected PlaceModel[] doInBackground(String... url) {
            try {
                String s = run(url[0]);
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                final PlaceModel[] placeModels;
                placeModels = new Gson().fromJson(jsonArray.toString(), PlaceModel[].class);
                return placeModels;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }







}




