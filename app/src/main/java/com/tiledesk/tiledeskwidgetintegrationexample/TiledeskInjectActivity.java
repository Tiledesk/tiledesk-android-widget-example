package com.tiledesk.tiledeskwidgetintegrationexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class TiledeskInjectActivity extends AppCompatActivity {

    public static final int REQUEST_SELECT_FILE = 100;
    public ValueCallback<Uri[]> uploadMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiledeskinject);

        WebView myWebView = (WebView) findViewById(R.id.tiledesk);
        myWebView.setWebChromeClient(new FileChooserWebChromeClient(this) {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d("TiledeskInjectActivity", consoleMessage.message() + " -- From line "
                        + consoleMessage.lineNumber() + " of "
                        + consoleMessage.sourceId());
                return super.onConsoleMessage(consoleMessage);
            }
        });

        // Enable JavaScript
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Enable DOM storage API (localStorage/sessionStorage)
        webSettings.setDomStorageEnabled(true);

        //allow to snap photos
        webSettings.setAllowFileAccess(true);

        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        //Inject widget HTML script
        myWebView.loadUrl("file:///android_asset/index.html");

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_FILE) {
            if (uploadMessage == null) return;
            uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, data));
            uploadMessage = null;
        }
    }


    public class FileChooserWebChromeClient extends WebChromeClient {

        private Activity myActivity;

        public FileChooserWebChromeClient(TiledeskInjectActivity myActivity) {
            this.myActivity = myActivity;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            uploadMessage = filePathCallback;

            Intent intent = fileChooserParams.createIntent();
            try {
                myActivity.startActivityForResult(intent, REQUEST_SELECT_FILE);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(myActivity, "Cannot open file chooser", Toast.LENGTH_LONG).show();
                return false;
            }

            return true;
        }
    }
}
