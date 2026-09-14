package atlow.chemi.mymada.fragments;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import java.util.Locale;

/* loaded from: classes.dex */
public class BlsProtocoles extends Fragment {
    private ProgressBar spinner;
    private WebView webview;
    private String BLS = "https://firebasestorage.googleapis.com/v0/b/project-3918384647339420127.appspot.com/o/bls%5B1%5D.pdf?alt=media&token=7da40564-fe83-4254-a929-f8b2ec67ca41";
    private String ALS = "https://firebasestorage.googleapis.com/v0/b/project-3918384647339420127.appspot.com/o/als%5B1%5D.pdf?alt=media&token=49d9e5f1-03d5-49d5-a951-b58dce094ca6";
    private String Dead = "https://firebasestorage.googleapis.com/v0/b/project-3918384647339420127.appspot.com/o/kuntres.pdf?alt=media&token=2b7c5ce5-e5e5-4fae-9b27-fb2ba4d7e826";
    private String[] strings = {this.BLS, this.ALS, this.Dead};
    private boolean isConnected = true;
    private int current = 0;

    /* loaded from: classes.dex */
    private class CustomWebViewClient extends WebViewClient {
        private CustomWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Log.e("TRACK_URL", "ended");
            BlsProtocoles.this.spinner.setVisibility(8);
            webView.setVisibility(0);
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Log.e("TRACK_URL", "started");
            if (BlsProtocoles.this.spinner.getVisibility() == 8) {
                webView.setVisibility(8);
                BlsProtocoles.this.spinner.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Log.e("TRACK_URL", "error");
            String str3 = "file:///android_asset/err.html";
            if (Locale.getDefault().getLanguage().equals("en")) {
                str3 = "file:///android_asset/err.html?lng=en";
            }
            BlsProtocoles.this.spinner.setVisibility(8);
            webView.setVisibility(0);
            webView.loadUrl(str3);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (BlsProtocoles.this.isConnected) {
                return false;
            }
            String str2 = "file:///android_asset/err.html";
            if (Locale.getDefault().getLanguage().equals("en")) {
                str2 = "file:///android_asset/err.html?lng=en";
            }
            webView.loadUrl(str2);
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.button_p);
            ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                    this.isConnected = false;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_protocole_bls, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.webview = (WebView) view.findViewById(R.id.webview);
        this.spinner = (ProgressBar) view.findViewById(R.id.progressBar2);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.setWebViewClient(new CustomWebViewClient());
        Log.e("TRACK_URL:", "current is:" + this.current + " url: " + this.strings[this.current]);
        WebView webView = this.webview;
        StringBuilder sb = new StringBuilder();
        sb.append("http://drive.google.com/viewerng/viewer?embedded=true&url=");
        sb.append(this.strings[this.current]);
        webView.loadUrl(sb.toString());
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setCurrentPage(int i) {
        this.current = i;
        WebView webView = this.webview;
        if (webView != null) {
            webView.setVisibility(8);
            this.spinner.setVisibility(0);
            this.webview.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + this.strings[this.current]);
            Log.e("TRACK_URL", "Request New URL");
        }
    }
}
