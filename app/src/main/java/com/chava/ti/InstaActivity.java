package com.chava.ti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InstaActivity extends AppCompatActivity {
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insta);
        browser = (WebView) findViewById(R.id.Webpage);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setDisplayZoomControls(false);
        browser.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        browser.setWebChromeClient(new WebChromeClient());
        browser.loadUrl("https://www.instagram.com/facultadti/?hl=es-la");
    }

    @Override
    public void onBackPressed(){
        if(browser.canGoBack()){
            browser.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}
