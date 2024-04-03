package com.mmc.irannama;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView t=findViewById(R.id.actionbar_text);
        Bundle b = getIntent().getExtras();
        String value =""; // or other values
        justifiedTextview text =findViewById(R.id.Description);
        text.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(),b_nazanin.ttf));
        if(b != null)
            value = b.getString("Name");
        //TextView os =findViewById(R.id.tabBar);
        ProvienceModel pvmodel=null;
        for (int i=0;i<StaticLists.ProviencList.size();i++)
        {
            if((StaticLists.ProviencList.get(i).Provience + "-" + StaticLists.ProviencList.get(i).Name).equals(value))
            {
                pvmodel = StaticLists.ProviencList.get(i);
                break;
            }
        }

        //os.setText(pvmodel.Provience+">"+pvmodel.Name);
        ImageView iv=findViewById(R.id.LocationImage);
        // load image
        t.setText(pvmodel.Provience+">"+pvmodel.Name);
        try {
            // get input stream
            InputStream ims = getAssets().open(pvmodel.Imagepath);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            iv.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;


        }
        TextView ds =findViewById(R.id.Description);
        ds.setText(getStringResourceByName(pvmodel.Textpath));
    }

    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }


}


