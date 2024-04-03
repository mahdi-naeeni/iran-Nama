package com.mmc.irannama;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TouristAttractions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        setContentView(R.layout.activity_tourist_attractions);
        TextView t=findViewById(R.id.actionbar_text);
        String provienceName;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            provienceName= extras.getString("ProvienceName");
            ArrayList<ProvienceModel> oslst=new ArrayList<ProvienceModel>();
            for (int i=0;i<StaticLists.ProviencList.size();i++)
            {
                if(StaticLists.ProviencList.get(i).Provience.equals(provienceName))
                {
                    oslst.add(StaticLists.ProviencList.get(i));
                }
            }
            if(oslst.size()>0) {
                UpdateUI(oslst);
                t.setText(oslst.get(0).Provience);
            }
        }
         }
    Button[] btnWord ;
    LinearLayout linear;

    private void UpdateUI(ArrayList<ProvienceModel> lst) {
        linear = (LinearLayout) findViewById(R.id.linear);
        btnWord = new Button[lst.size()];
        for (int i = 0; i < btnWord.length; i++) {
            btnWord[i] = new Button(this);
            btnWord[i].setHeight(50);
            btnWord[i].setWidth(50);
            btnWord[i].setScaleX((float) .9);
            btnWord[i].setTextSize(30);
            btnWord[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));

            if (i == 0){
                btnWord[i].setTranslationY(160);
            }
            if (i == 1){
                btnWord[i].setTranslationY(260);
            }
            if (i == 2){
                btnWord[i].setTranslationY(360);
            }
            if (i == 3){
                btnWord[i].setTranslationY(460);
            }
            if (i == 4){
                btnWord[i].setTranslationY(560);
            }
            btnWord[i].setTextColor(Color.WHITE);
            btnWord[i].setTag(lst.get(i).Provience+"-"+lst.get(i).Name);
            btnWord[i].setText(lst.get(i).Name);
            btnWord[i].setOnClickListener(btnClicked);
            linear.addView(btnWord[i]);
        }



    }

    View.OnClickListener btnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tag = (String)v.getTag();
            GOContent(tag);
        }

        private void GOContent(String tag) {
            Intent intent = new Intent(TouristAttractions.this, Content.class);

            Bundle b = new Bundle();
            b.putString("Name", tag); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
        }
    };
}
