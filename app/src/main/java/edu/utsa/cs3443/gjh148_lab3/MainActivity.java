package edu.utsa.cs3443.gjh148_lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example_android_app.R;

public class MainActivity extends AppCompatActivity{
    Button btnEnterprise, btnVoyager, btnDefiant;
    //naming button

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnterprise = findViewByID(R.id.btnEnterprise);
        btnVoyager = findViewByID(R.id.btnVoyager);
        btnDefiant = findViewByID(R.id.btnDefiant);



    }
}