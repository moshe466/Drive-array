package u0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: d, reason: collision with root package name */
    public static final HashSet f6577d = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f6578a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6579b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6580c;

    public x(int i, String str, String str2) {
        this.f6580c = i;
        this.f6578a = str;
        this.f6579b = str2;
        f6577d.add(this);
    }

    public final boolean a(Context context) {
        boolean containsKey;
        if (!b()) {
            PackageInfo b4 = t0.y.b(context);
            Bundle bundle = null;
            if (b4 != null) {
                ComponentName componentName = new ComponentName(b4.packageName, "org.chromium.android_webview.services.StartupFeatureMetadataHolder");
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        bundle = m.a(context.getPackageManager(), componentName, m.b(640L)).metaData;
                    } else {
                        bundle = context.getPackageManager().getServiceInfo(componentName, 640).metaData;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            if (bundle == null) {
                containsKey = false;
            } else {
                containsKey = bundle.containsKey(this.f6579b);
            }
            if (!containsKey) {
                return false;
            }
        }
        return true;
    }

    public final boolean b() {
        switch (this.f6580c) {
            case 0:
                return false;
            default:
                if (Build.VERSION.SDK_INT >= 28) {
                    return true;
                }
                return false;
        }
    }
}
