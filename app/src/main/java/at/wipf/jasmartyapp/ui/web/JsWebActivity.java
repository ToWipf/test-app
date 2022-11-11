package at.wipf.jasmartyapp.ui.web;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import at.wipf.jasmartyapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import at.wipf.jasmartyapp.SaveSettings;
import at.wipf.jasmartyapp.data.model.JsSettings;

public class JsWebActivity extends Activity {

    private WebView webView;
    private final SaveSettings settings = new SaveSettings();
    //private String url;

    @Override
    protected void onStop() {
        super.onStop();
        //saveCookies();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsweb);

        JsSettings jsLoad = null;
        try {
            jsLoad = new JsSettings(new JSONObject(settings.read()));
        } catch (JSONException e) {
            e.printStackTrace();
            finish();
        }
        if (jsLoad.getsUrl() == null) {
            finish();
        }

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //url = "file:///android_asset/index.html";
        //url = "http:///192.168.2.11:8080/index.html";

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

        //restoreCookies(jsLoad.getsUrl());
        if (savedInstanceState == null) {
            this.addCookiesFromSave(jsLoad);
            webView.loadUrl(jsLoad.getsUrl());
        }

        //saveCookies(jsLoad.getsUrl());
        /* Periodically saves cookies to variables */
        //new Timer().scheduleAtFixedRate(new TimerTask() {
        //    @Override
        //    public void run() {
        //        saveCookies();
        //    }
        //}, 0, 10000);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state of the WebView
        webView.saveState(outState);
        //saveCookies();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore the state of the WebView
        webView.restoreState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    /* method to save cookies in app memory */
    private void saveCookies(String sUrl) {
        String cookies = CookieManager.getInstance().getCookie(sUrl);
        // Saving cookies to MyPrefs
        SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sp.edit();
        prefsEditor.putString("cookies", cookies); // a=bbbb; ddddddddd=ddddd
        prefsEditor.commit();
    }

    /* restoring cookies from app memory */
    private void restoreCookies(String sUrl) {
        SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String cookies = sp.getString("cookies", "");
        CookieManager.getInstance().setCookie(sUrl, cookies);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();// if there is previous page open it
            //saveCookies();
        } else {
            //saveCookies();
            super.onBackPressed();//if there is no previous page, close app
        }
    }

    private void addCookiesFromSave(JsSettings jss) {
        //String cookiesStr = jss.getsCo1_key() + "=" + jss.getsCo1_val() + "; " + jss.getsCo2_key() + "=" + jss.getsCo2_val() + " ;testetest=jaja";
        //SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        //SharedPreferences.Editor prefsEditor = sp.edit();
        //prefsEditor.putString("cookies", cookieStr); // a=bbbb; ddddddddd=ddddd
        //prefsEditor.commit();
        CookieManager.getInstance().setCookie(jss.getsUrl(), jss.getsCo1_key() + "=" + jss.getsCo1_val() + "; ");
        CookieManager.getInstance().setCookie(jss.getsUrl(), jss.getsCo2_key() + "=" + jss.getsCo2_val() + "; ");
    }
}
