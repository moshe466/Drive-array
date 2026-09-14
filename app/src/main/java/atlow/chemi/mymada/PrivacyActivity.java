package atlow.chemi.mymada;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import atlow.chemi.mymada.helpers.LocalHelper;
import com.crashlytics.android.Crashlytics;
import java.util.Locale;

/* loaded from: classes.dex */
public class PrivacyActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private MenuItem Detect;
    private String ShowOrHideWebViewInitialUse = "show";
    private boolean isConnected = true;
    private ProgressBar spinner;
    private WebView webview;

    /* loaded from: classes.dex */
    private class CustomWebViewClient extends WebViewClient {
        private CustomWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            PrivacyActivity.this.ShowOrHideWebViewInitialUse = "hide";
            PrivacyActivity.this.spinner.setVisibility(8);
            webView.setVisibility(0);
            SharedPreferences.Editor edit = PrivacyActivity.this.getSharedPreferences("Settings", 0).edit();
            edit.putBoolean("privacy", true);
            edit.apply();
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (PrivacyActivity.this.ShowOrHideWebViewInitialUse.equals("show")) {
                webView.setVisibility(4);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            String str3 = "file:///android_asset/err.html";
            if (Locale.getDefault().getLanguage().equals("en")) {
                str3 = "file:///android_asset/err.html?lng=en";
            }
            webView.loadUrl(str3);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.startsWith("file:///android_asset/")) {
                return false;
            }
            if (PrivacyActivity.this.isConnected) {
                return false;
            }
            String str2 = "file:///android_asset/err.html";
            if (Locale.getDefault().getLanguage().toLowerCase().contains("en")) {
                str2 = "file:///android_asset/err.html?lng=en";
            }
            webView.loadUrl(str2);
            return true;
        }
    }

    private boolean isCallable(Intent intent) {
        try {
            return getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            Crashlytics.logException(e);
            return false;
        }
    }

    private void resetTitle() {
        try {
            int i = getPackageManager().getActivityInfo(getComponentName(), 128).labelRes;
            if (i != 0) {
                setTitle(i);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Crashlytics.logException(e);
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    public /* synthetic */ void b(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    public /* synthetic */ void c(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        NetworkInfo activeNetworkInfo;
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_privacy);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager != null && ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting())) {
            this.isConnected = false;
        }
        this.webview = (WebView) findViewById(R.id.webview);
        this.spinner = (ProgressBar) findViewById(R.id.progressBar1);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.setWebViewClient(new CustomWebViewClient());
        this.webview.clearHistory();
        this.webview.loadUrl("file:///android_asset/privacy.html");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        int i = sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off;
        this.Detect = menu.findItem(R.id.one);
        menu.findItem(R.id.one).setCheckable(true).setChecked(sharedPreferences.getBoolean("Mapp", false)).setIcon(i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        if (r2.contains(r3) == false) goto L19;
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.action_settings) {
            startActivity(new Intent(this, (Class<?>) SettingsPage.class));
            return true;
        }
        if (itemId == R.id.one) {
            SharedPreferences sp = getSharedPreferences("Settings", 0);
            boolean newState = !sp.getBoolean("Mapp", false);
            sp.edit().putBoolean("Mapp", newState).apply();
            menuItem.setChecked(newState);
            menuItem.setIcon(newState ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        if (this.Detect != null) {
            this.Detect.setIcon(sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
        }
    }
}
