package com.example.sxy.myapplication_6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class Main2Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        Intent intent=getIntent();
        Uri data=intent.getData();
        URL url=null;
        try {
            url=new URL(data.getScheme(),data.getHost(),data.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        startBrowser(url);
    }
    private void startBrowser(URL url){
        WebView webView = findViewById(R.id.webview);
        webView.loadUrl(url.toString());
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
