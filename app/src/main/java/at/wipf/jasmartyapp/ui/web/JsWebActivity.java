package at.wipf.jasmartyapp.ui.web;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import at.wipf.jasmartyapp.R;

public class JsWebActivity extends Activity {

    private WebView webView;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsweb);
        SharedPreferences sp = getSharedPreferences("jss", MODE_PRIVATE);

        // Create reference to UI elements
        webView = (WebView) findViewById(R.id.webview_component);

        webView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        webView.setLongClickable(false);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                android.util.Log.d("WebView", consoleMessage.message());
                return true;
            }
        });

        CookieManager.setAcceptFileSchemeCookies(true);

        if (savedInstanceState == null) {
            this.addCookiesFromSave();
            webView.loadUrl(sp.getString("jsUrl", null));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state of the WebView
        webView.saveState(outState);;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore the state of the WebView
        webView.restoreState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();// if there is previous page open it
        } else {
            super.onBackPressed();//if there is no previous page, close app
        }
    }

    private void addCookiesFromSave() {
        SharedPreferences sp = getSharedPreferences("jss", MODE_PRIVATE);
        CookieManager.getInstance().setCookie(sp.getString("jsUrl", null), sp.getString("cookie1Key", null) + "=" + sp.getString("cookie1Val", null) + "; ");
        CookieManager.getInstance().setCookie(sp.getString("jsUrl", null), sp.getString("cookie2Key", null) + "=" + sp.getString("cookie2Val", null) + "; ");
    }
}
