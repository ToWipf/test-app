package io.github.towipf;

import android.app.Activity;
import android.content.Intent;
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

import java.util.Timer;
import java.util.TimerTask;

import io.github.towipf.loader.R;

public class WipfMenue extends Activity {

	private String url;
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		saveCookies();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menue);
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		url = "file:///android_asset/index.html";
		//url = "http:///192.168.2.11:8080/index.html";

		// Create reference to UI elements
		View wbutton = findViewById(R.id.wipfbutton);
		View wUrl = findViewById(R.id.editTextTextPersonName);
		if (wbutton.isActivated()) {
			wUrl.setTextDirection(134);
		}

		CookieManager.setAcceptFileSchemeCookies(true);

		restoreCookies();

		/* Periodically saves cookies to variables */
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				saveCookies();
			}
		}, 0, 10000);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/* method to save cookies in app memory */
	private void saveCookies() {
		String cookies = CookieManager.getInstance().getCookie(url);
		// Saving cookies to MyPrefs
		SharedPreferences sp=getSharedPreferences("MyPrefs",MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = sp.edit();
		prefsEditor.putString("cookies", cookies);
		prefsEditor.commit();
	}
	
	/* restoring cookies from app memory */
	private void restoreCookies() {
		SharedPreferences sp=getSharedPreferences("MyPrefs",MODE_PRIVATE);
		String cookies = sp.getString("cookies", "");
		CookieManager.getInstance().setCookie(url,cookies);
	}
    @Override
    public void onBackPressed() {

    }

    private class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if (url.startsWith("mailto:")) {
				url = url.replaceFirst("mailto:", "");
				url = url.trim();
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("plain/text").putExtra(Intent.EXTRA_EMAIL,
						new String[] { url });
				startActivity(i);
				return true;
			}
			view.loadUrl(url);
			return true;
		}

	}
}
