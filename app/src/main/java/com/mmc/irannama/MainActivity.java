package com.mmc.irannama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        WebView wv=(WebView) findViewById(R.id.webView);
        //TextView tv=findViewById(R.id.textView2);
        wv.getSettings().setBuiltInZoomControls(true);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.addJavascriptInterface(new WebAppInterface(this), "Android");
        wv.loadUrl("file:///android_asset/map.html");
        StaticLists s=new StaticLists();
        addItemsOnSpinner();
    }



    public void GoToItemPage(String ostan)
    {
        Intent intent = new Intent(this,TouristAttractions.class );

        Bundle b = new Bundle();
        b.putString("ProvienceName", ostan); //Your id
        intent.putExtras(b); //Put your id to your next Intent

        startActivity(intent);
    }

    String selectName="استان راانتخاب کنید...";
    public void addItemsOnSpinner() {

        final Spinner spinner = (Spinner) findViewById(R.id.prlist);
        ArrayList<String> oslist=new ArrayList<String>();
        oslist.add(selectName);
        for (ProvienceModel p :StaticLists.ProviencList)
            if(oslist.contains(p.Provience)==false)
                oslist.add(p.Provience);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, oslist);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), list.get(position), Toast.LENGTH_SHORT).show();
                if(selectName!=spinner.getSelectedItem().toString())
                GoToItemPage(spinner.getSelectedItem().toString());


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

}

