package l5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.location.Location;
import android.os.Build;
import android.os.Debug;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l5.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0245a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f11785a;

        C0245a(boolean z10) {
            this.f11785a = z10;
        }

        boolean a() {
            return this.f11785a;
        }
    }

    private static C0245a a() {
        Context b10 = MdaEmergencyApplication.b();
        ApplicationInfo applicationInfo = (ApplicationInfo) Class.forName("android.content.pm.PackageInfo").getMethod("getApplicationInfo", new Class[0]).invoke(b10.getPackageManager().getPackageInfo(b10.getPackageName(), 0), new Object[0]);
        Field declaredField = Class.forName("android.content.pm.ApplicationInfo").getDeclaredField("debuggable");
        declaredField.setAccessible(true);
        Boolean bool = (Boolean) declaredField.get(applicationInfo);
        if (bool == null) {
            return null;
        }
        return new C0245a(bool.booleanValue());
    }

    public static boolean b() {
        boolean isDebuggerConnected = Debug.isDebuggerConnected();
        try {
            C0245a a10 = a();
            return a10 != null ? a10.a() : isDebuggerConnected;
        } catch (Exception unused) {
            return isDebuggerConnected;
        }
    }

    public static boolean c() {
        String str = Build.PRODUCT;
        if (str != null && (str.equals("sdk") || str.contains("_sdk") || str.contains("sdk_"))) {
            return true;
        }
        String str2 = Build.MODEL;
        if (str2 != null && str2.equals("google_sdk")) {
            return true;
        }
        String str3 = Build.BRAND;
        if (str3 != null && str3.equals("generic")) {
            return true;
        }
        String str4 = Build.DEVICE;
        return str4 != null && str4.equals("generic");
    }

    public static boolean e(Context context) {
        return false;
    }

    public static boolean d(Location location) {
        return false;
    }
}
