package w4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import o4.c;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f15102a;

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f15103b;

    /* renamed from: c, reason: collision with root package name */
    private final c f15104c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f15105d;

    public a(Context context, String str, c cVar) {
        Context a10 = a(context);
        this.f15102a = a10;
        this.f15103b = a10.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f15104c = cVar;
        this.f15105d = c();
    }

    private static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : androidx.core.content.a.b(context);
    }

    private boolean c() {
        return this.f15103b.contains("firebase_data_collection_default_enabled") ? this.f15103b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f15102a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f15102a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.f15105d;
    }
}
