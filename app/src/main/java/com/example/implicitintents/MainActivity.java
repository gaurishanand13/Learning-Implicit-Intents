package com.example.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);

        //explicit intents help us to find whether the app which we are aiming to open are there or not.
        //if the app is present it will open it.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //In this we will ask the intent to search for an app in the phone through which we can dial a number.
                //if more than one app is present like for calling dialer and truecaller is there. Therefore when we click on the button we will get 2 options
                //i.e which app to open. Here we are getting only 2 option of dialing i.e dialer and truecaller. But what if we too want to make an app which is considered as a dialing app.
                //Therefore we created an false dailer app which we will get as option when we look to dial a number.
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                //therefore the above statements will open any dialer which is present in your app.
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Now if we want to the dialer to open with a particular number of choice. just pass an extra argument in the above intent.
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9210678804"));
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here too we are searching if there is an application which can help us open this webpage.
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/gaurishanand13?tab=repositories"));
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Here it will search for an app in the phone which can geologically represent this location i.e basically it will seach for the map.
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=155 State Way, Welcon, Free State"));
                startActivity(intent);
            }
        });
    }
}
