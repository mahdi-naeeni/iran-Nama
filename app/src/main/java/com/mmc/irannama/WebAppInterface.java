package com.mmc.irannama;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;


public class WebAppInterface {
    private MainActivity _mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(MainActivity c) {
        _mContext = c;
        wv=_mContext.findViewById(R.id.webView);
    }
    private WebView wv;
    /** Show a toast from the web page */
    @JavascriptInterface
    public void Go(String ostan) {
        //_mContext.GoToItemPage(ostan);
      Toast.makeText(_mContext, ostan, Toast.LENGTH_SHORT).show();
        //wv.loadUrl("file:///android_asset/map.html");
        _mContext.GoToItemPage(ostan);

    }
}
