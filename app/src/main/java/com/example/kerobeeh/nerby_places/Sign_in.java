package com.example.kerobeeh.nerby_places;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Sign_in extends Fragment {

    TextView txtnea,txtacc,txtsign;
    EditText txtuser , txtpassword;
    Button signin;
    FragmentManager fragmentManager;
    View view;

     //DB sql =new DB(this);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sing_in,container,false);

        fragmentManager=getFragmentManager();


         txtnea = view.findViewById(R.id.txtNea);
         txtacc = view.findViewById(R.id.txtView);
        txtsign = view.findViewById(R.id.txtsignup);

         txtuser = view.findViewById(R.id.txtUser);
        txtpassword = view.findViewById(R.id.txtpass);

         signin =view.findViewById(R.id.btnsign);

        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
fragmentManager.beginTransaction().replace(R.id.framCont,new search(), "search").commit();

                /*



               boolean result=sql.ch(txtuser.getText().toString(),txtpassword.getText().toString());
                if(result){
                   // Toast.makeText(getApplicationContext(), "Login successful, redirecting to Home Page.", Toast.LENGTH_LONG).show();
                    fragmentManager.beginTransaction().replace(R.id.framCont,new search(),"search").commit();


                } else {
                    Toast.makeText(getActivity(), "Invalid credentials, please try again.", Toast.LENGTH_LONG).show();
                }

                */
            }
        });


        txtsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.framCont, new Sign_UP(), " Sign_UP")
                        .commit();
            }
        });


















        return view;
    }
}

