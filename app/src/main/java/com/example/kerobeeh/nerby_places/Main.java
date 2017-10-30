package com.example.kerobeeh.nerby_places;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;


public class Main extends Activity {

    static FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fragmentManager = getFragmentManager();

        if (savedInstanceState == null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.framCont, new Sign_in(), "sign_in")
                    .commit();
        }
    }




        public static void bC(){

        fragmentManager
                .beginTransaction()
                .replace(R.id.framCont,new Sign_in(),"sign_in")
                .commit();
    }




    }


