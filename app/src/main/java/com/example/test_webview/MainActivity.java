package com.example.test_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView wvMain;
    //private String stUrl="https://www.naver.com";
    private String stUrl="https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wvMain = (WebView) findViewById(R.id.wvMain);
        wvMain.getSettings().setJavaScriptEnabled(true);
        wvMain.loadUrl(stUrl);
        wvMain.setWebChromeClient(new WebChromeClient());
        wvMain.setWebViewClient(new WebViewClientClass());

    }

    //ctrl+o
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wvMain.canGoBack()) {
            wvMain.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //현재 페이지를 읽는것
            view.loadUrl(url);
            return true;
        }
    }
}