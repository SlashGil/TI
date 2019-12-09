package com.chava.ti.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.chava.ti.R;

public class FbActivity extends AppCompatActivity implements View.OnClickListener {
    private WebView browser;
    Toolbar toolbar;
    ImageView home, upaep, login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
        browser = (WebView) findViewById(R.id.Webpage);
        toolbar = findViewById(R.id.toolbar);
        home = toolbar.findViewById(R.id.home);
        upaep = toolbar.findViewById(R.id.upaep);
        login = toolbar.findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        home.setOnClickListener(this);
        login.setOnClickListener(this);
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
        browser.loadUrl("https://www.facebook.com/profile.php?id=100014826879612");
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.home: {
                finish();
            } break;
            case R.id.login_toolbar: {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            } break;
        }
    }
}
