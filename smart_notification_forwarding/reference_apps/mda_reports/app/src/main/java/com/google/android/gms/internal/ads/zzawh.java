package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;

@TargetApi(16)
/* loaded from: classes.dex */
public class zzawh {
    private zzawh() {
    }

    public static boolean zza(zzbdi zzbdiVar) {
        if (zzbdiVar == null) {
            return false;
        }
        zzbdiVar.onPause();
        return true;
    }

    public static boolean zzb(zzbdi zzbdiVar) {
        if (zzbdiVar == null) {
            return false;
        }
        zzbdiVar.onResume();
        return true;
    }

    public static zzawh zzcr(int i) {
        return i >= 28 ? new zzawo() : i >= 26 ? new zzawp() : i >= 24 ? new zzawm() : i >= 21 ? new zzawn() : i >= 19 ? new zzawk() : i >= 18 ? new zzawl() : i >= 17 ? new zzawi() : new zzawh();
    }

    public static boolean zzwq() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public int zza(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    public zzbdl zza(zzbdi zzbdiVar, zzsm zzsmVar, boolean z) {
        return new zzbek(zzbdiVar, zzsmVar, z);
    }

    public zzte zza(Context context, TelephonyManager telephonyManager) {
        return zzte.ENUM_UNKNOWN;
    }

    public boolean zza(Activity activity, Configuration configuration) {
        return false;
    }

    public boolean zza(final Context context, final WebSettings webSettings) {
        zzayc.zza(context, new Callable(context, webSettings) { // from class: com.google.android.gms.internal.ads.zzawg
            private final Context zzcri;
            private final WebSettings zzdsx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
                this.zzdsx = webSettings;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = this.zzcri;
                WebSettings webSettings2 = this.zzdsx;
                if (context2.getCacheDir() != null) {
                    webSettings2.setAppCachePath(context2.getCacheDir().getAbsolutePath());
                    webSettings2.setAppCacheMaxSize(0L);
                    webSettings2.setAppCacheEnabled(true);
                }
                webSettings2.setDatabasePath(context2.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings2.setDatabaseEnabled(true);
                webSettings2.setDomStorageEnabled(true);
                webSettings2.setDisplayZoomControls(false);
                webSettings2.setBuiltInZoomControls(true);
                webSettings2.setSupportZoom(true);
                webSettings2.setAllowContentAccess(false);
                return true;
            }
        });
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public int zzb(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public void zzbc(Context context) {
    }

    public CookieManager zzbd(Context context) {
        if (zzwq()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzayu.zzc("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzq.zzku().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public void zzg(Activity activity) {
    }

    public int zzwo() {
        return 5;
    }

    public ViewGroup.LayoutParams zzwp() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public int zzwr() {
        return 1;
    }

    public long zzws() {
        return -1L;
    }
}
