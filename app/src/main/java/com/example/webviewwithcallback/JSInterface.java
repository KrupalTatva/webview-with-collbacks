package com.example.webviewwithcallback;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class JSInterface {

    @JavascriptInterface
    public void showJsonResponse(String text) {
        Log.i("Response",text);
    }
}
