package E1;

import F0.C0035g2;
import F1.q;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: e, reason: collision with root package name */
    public static final C0035g2 f145e = new C0035g2("AppUpdateService");

    /* renamed from: f, reason: collision with root package name */
    public static final Intent f146f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* renamed from: a, reason: collision with root package name */
    public final q f147a;

    /* renamed from: b, reason: collision with root package name */
    public final String f148b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f149c;

    /* renamed from: d, reason: collision with root package name */
    public final l f150d;

    public k(Context context, l lVar) {
        String str;
        this.f148b = context.getPackageName();
        this.f149c = context;
        this.f150d = lVar;
        C0035g2 c0035g2 = F1.a.f732a;
        try {
            if (context.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures;
                if (signatureArr != null && (signatureArr.length) != 0) {
                    for (Signature signature : signatureArr) {
                        byte[] byteArray = signature.toByteArray();
                        try {
                            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                            messageDigest.update(byteArray);
                            str = Base64.encodeToString(messageDigest.digest(), 11);
                        } catch (NoSuchAlgorithmException unused) {
                            str = "";
                        }
                        if (!"8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(str)) {
                            String str2 = Build.TAGS;
                            if ((!str2.contains("dev-keys") && !str2.contains("test-keys")) || !"GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(str)) {
                            }
                        }
                        Context applicationContext = context.getApplicationContext();
                        this.f147a = new q(applicationContext != null ? applicationContext : context, f145e, f146f);
                        return;
                    }
                    return;
                }
                C0035g2 c0035g22 = F1.a.f732a;
                Object[] objArr = new Object[0];
                c0035g22.getClass();
                if (Log.isLoggable("PlayCore", 5)) {
                    C0035g2.z((String) c0035g22.f526b, "Phonesky package is not signed -- possibly self-built package. Could not verify.", objArr);
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    public static Bundle a(k kVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(b());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(kVar.f149c.getPackageManager().getPackageInfo(kVar.f149c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            Object[] objArr = new Object[0];
            C0035g2 c0035g2 = f145e;
            c0035g2.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", C0035g2.z((String) c0035g2.f526b, "The current version of the app could not be retrieved", objArr));
            }
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    public static Bundle b() {
        Map map;
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        HashMap hashMap = F1.j.f739a;
        synchronized (F1.j.class) {
            try {
                HashMap hashMap2 = F1.j.f739a;
                if (!hashMap2.containsKey("app_update")) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("java", 11004);
                    hashMap2.put("app_update", hashMap3);
                }
                map = (Map) hashMap2.get("app_update");
            } catch (Throwable th) {
                throw th;
            }
        }
        bundle2.putInt("playcore_version_code", ((Integer) map.get("java")).intValue());
        if (map.containsKey("native")) {
            bundle2.putInt("playcore_native_version", ((Integer) map.get("native")).intValue());
        }
        if (map.containsKey("unity")) {
            bundle2.putInt("playcore_unity_version", ((Integer) map.get("unity")).intValue());
        }
        bundle.putAll(bundle2);
        bundle.putInt("playcore.version.code", 11004);
        return bundle;
    }
}
