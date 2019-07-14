package com.example.alcchallenge;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {

    private WebView webViewAlc;
    Activity activity ;
    private ProgressDialog progDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activity = this;
        progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
        progDailog.setCancelable(false);

        webViewAlc = (WebView) findViewById(R.id.webviewAlc);

        webViewAlc.getSettings().setJavaScriptEnabled(true);
        webViewAlc.getSettings().setLoadWithOverviewMode(true);
        webViewAlc.getSettings().setUseWideViewPort(true);

        webViewAlc.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }
        });

        webViewAlc.loadUrl("https://andela.com/alc");



    }

    @Override
    public void onBackPressed() {

        if (webViewAlc.canGoBack()){
            webViewAlc.goBack();
        }else{
            super.onBackPressed();
        }

    }
}
