package com.example.davegan.qualitylaboratory30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewKU extends AppCompatActivity {

    WebView webViewku;
    WebSettings webSettingsku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_ku);

        webViewku = (WebView) findViewById(R.id.WebView1);
        webSettingsku = webViewku.getSettings();
        webViewku.setWebViewClient(new WebViewClient());
        webViewku.loadUrl("http://192.168.42.62/askiServer/index.php");
    }
}
