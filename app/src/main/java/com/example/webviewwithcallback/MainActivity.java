package com.example.webviewwithcallback;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String content =
        "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>API Call Example</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <button onclick=\"makeAPICall()\">Make API Call</button>\n" +
                "\n" +
                "    <script>\n" +
                "      function makeAPICall() {\n" +

                "const headers = new Headers();\n" +
                "        headers.append(\"Access-Control-Allow-Origin\", \"*\");\n" +
                "        headers.append(\"Content-Type\", \"application/json\");\n" +
                "        fetch(\"https://jsonplaceholder.typicode.com/posts\", {\n" +
                "          method: \"GET\",\n" +
                "          headers: headers,\n" +
                "        })"+

                "          .then(response => {\n" +
                "Android.showJsonResponse(`Error: ${response}`);"+
                "            if (response.status !== 200) {\n" +
                "              Android.showJsonResponse(`Error: ${response.status}`);\n" +
                "              return;\n" +
                "            }\n" +
                "            return response.json();\n" +
                "          })\n" +
                "          .then(data => Android.showJsonResponse(data))\n" +
                "          .catch(error => Android.showJsonResponse(\"error : \"+error));\n" +
                "      }\n" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>";

        WebView webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadData(content,"text/html; charset=utf-8", "UTF-8");
        webView.addJavascriptInterface(new JSInterface(), "Android");

    }
}