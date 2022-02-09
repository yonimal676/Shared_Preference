package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    SharedPreferences sp;

    Button btnSave;

    EditText etFname,etLname;

    TextView tvDisplay;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        btnSave=(Button)findViewById(R.id.btnSubmit);

        btnSave.setOnClickListener(this);

        etFname=(EditText)findViewById(R.id.etFname);

        etLname=(EditText)findViewById(R.id.etLname);

        sp=getSharedPreferences("details1",0);

        tvDisplay=(TextView)findViewById(R.id.tvDisplay);

        String strfname = sp.getString("fname",null);

        String strlname=sp.getString("lname",null);

        if(strlname!=null&&strfname!=null)

        {

            tvDisplay.setText("welcome " + strfname + " " + strlname);

        }

    }



    @Override

    public void onClick(View v) {



        if(btnSave==v)

        {

            SharedPreferences.Editor editor=sp.edit();

            editor.putString("fname",etFname.getText().toString());

            editor.putString("lname",etLname.getText().toString());

            editor.commit();

        }




    }

}