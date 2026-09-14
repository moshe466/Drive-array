package com.groboot.mdaemergency;

import a6.h;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Arrays;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7539a = true;

    /* renamed from: b, reason: collision with root package name */
    static InterfaceC0096a f7540b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f7541c;

    /* renamed from: com.groboot.mdaemergency.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096a {
        void a(c cVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str);

        void b();

        void c(String str);
    }

    /* loaded from: classes.dex */
    public enum c {
        ALLOWED,
        DENIED,
        NEVER_AGAIN
    }

    /* loaded from: classes.dex */
    public enum d {
        noPermission,
        asking,
        hasPermission
    }

    public static boolean A(Activity activity, Fragment fragment, InterfaceC0096a interfaceC0096a) {
        x(interfaceC0096a);
        return B(activity, fragment, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, R.string.no_permition_location);
    }

    public static boolean B(Activity activity, Fragment fragment, String[] strArr, int i10) {
        LockPatternActivity.B();
        for (String str : strArr) {
            if (n(activity, str)) {
                return true;
            }
            if ((fragment != null && fragment.O1(str)) || (activity != null && androidx.core.app.b.o(activity, str))) {
                androidx.core.app.b.n(activity, new String[]{str}, 114);
            } else {
                if (androidx.core.content.a.a(activity, str) == 0) {
                    return true;
                }
                h.l(activity, i10);
            }
        }
        return false;
    }

    public static boolean C(Activity activity, Fragment fragment) {
        return B(activity, fragment, new String[]{"android.permission.READ_PHONE_STATE"}, R.string.no_permission_phone);
    }

    public static boolean D(Activity activity, Fragment fragment) {
        return B(activity, fragment, new String[]{"android.permission.RECORD_AUDIO"}, R.string.no_permition_video);
    }

    public static boolean E(Activity activity, Fragment fragment) {
        return B(activity, fragment, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, R.string.no_permition_storage);
    }

    public static d b(Activity activity) {
        if (m(activity)) {
            return d.hasPermission;
        }
        if (androidx.core.app.b.o(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            return d.noPermission;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
        if (Build.VERSION.SDK_INT >= 29) {
            arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        androidx.core.app.b.n(activity, (String[]) arrayList.toArray(), 112);
        return d.asking;
    }

    public static d c(Activity activity, InterfaceC0096a interfaceC0096a) {
        x(interfaceC0096a);
        return b(activity);
    }

    public static void d(Activity activity, boolean z10, InterfaceC0096a interfaceC0096a) {
        x(interfaceC0096a);
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_PHONE_STATE");
        if (z10) {
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            if (Build.VERSION.SDK_INT >= 29) {
                arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                arrayList.add("android.permission.ACTIVITY_RECOGNITION");
            }
        }
        arrayList.addAll(Arrays.asList("android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO", "android.permission.READ_CALENDAR"));
        androidx.core.app.b.n(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 111);
    }

    public static void e(Activity activity, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        androidx.core.app.b.n(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 111);
    }

    public static d f(Activity activity) {
        if (p(activity)) {
            return d.hasPermission;
        }
        if (androidx.core.app.b.o(activity, "android.permission.READ_CALENDAR")) {
            return d.noPermission;
        }
        androidx.core.app.b.n(activity, new String[]{"android.permission.READ_CALENDAR"}, 116);
        return d.asking;
    }

    public static d g(Activity activity, InterfaceC0096a interfaceC0096a) {
        x(interfaceC0096a);
        return f(activity);
    }

    public static d h(Activity activity) {
        if (q(activity)) {
            return d.hasPermission;
        }
        if (androidx.core.app.b.o(activity, "android.permission.ACTIVITY_RECOGNITION")) {
            return d.noPermission;
        }
        androidx.core.app.b.n(activity, new String[]{"android.permission.ACTIVITY_RECOGNITION"}, 118);
        return d.asking;
    }

    public static d i(Activity activity, InterfaceC0096a interfaceC0096a) {
        x(interfaceC0096a);
        return h(activity);
    }

    public static d j(Activity activity) {
        if (s(activity)) {
            return d.hasPermission;
        }
        if (androidx.core.app.b.o(activity, "android.permission.READ_EXTERNAL_STORAGE")) {
            return d.noPermission;
        }
        androidx.core.app.b.n(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 113);
        return d.asking;
    }

    public static boolean k(Context context) {
        if (Build.VERSION.SDK_INT > 22) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    public static boolean l(Context context) {
        return !t() || androidx.core.content.a.a(context, "android.permission.CAMERA") == 0;
    }

    public static boolean m(Context context) {
        return !t() || androidx.core.content.a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.content.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean n(Context context, String str) {
        return !t() || androidx.core.content.a.a(context, str) == 0;
    }

    public static boolean o(Context context) {
        return !t() || androidx.core.content.a.a(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean p(Context context) {
        return !t() || androidx.core.content.a.a(context, "android.permission.READ_CALENDAR") == 0;
    }

    public static boolean q(Context context) {
        return Build.VERSION.SDK_INT < 29 || androidx.core.content.a.a(context, "android.permission.ACTIVITY_RECOGNITION") == 0;
    }

    public static boolean r(Context context) {
        return !t() || androidx.core.content.a.a(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static boolean s(Context context) {
        if (t()) {
            return androidx.core.content.a.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0 && androidx.core.content.a.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return true;
    }

    public static boolean t() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(int i10, b.a aVar) {
        f7541c = false;
        if (aVar == null || !aVar.f7614b) {
            return;
        }
        m.X(i10);
        if (i10 == 3) {
            s5.d.j().t();
        }
    }

    public static void v(Activity activity, int i10, String[] strArr, int[] iArr, b bVar) {
        c cVar;
        int i11;
        if (strArr.length == 0) {
            return;
        }
        String str = strArr[0];
        if (androidx.core.app.b.o(activity, str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("denied - ");
            sb2.append(str);
            cVar = c.DENIED;
        } else if (androidx.core.content.a.a(activity, str) == 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("allowed - ");
            sb3.append(str);
            cVar = c.ALLOWED;
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("set to never ask again - ");
            sb4.append(str);
            cVar = c.NEVER_AGAIN;
        }
        switch (i10) {
            case 111:
                if (cVar != c.DENIED) {
                    if (cVar != c.ALLOWED) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("set to never ask again - ");
                        sb5.append(str);
                        bVar.a(l0.Z(R.string.message_permission_request_read_phone_state__never));
                        break;
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("allowed - ");
                        sb6.append(str);
                        break;
                    }
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("denied - ");
                    sb7.append(str);
                    bVar.c(l0.Z(R.string.message_permission_request_read_phone_state));
                    break;
                }
            case 112:
                i11 = R.string.message_permission_request_location;
                bVar.c(l0.Z(i11));
                bVar.b();
                break;
            case 113:
                i11 = R.string.message_permission_request_storage;
                bVar.c(l0.Z(i11));
                bVar.b();
                break;
            case 114:
                i11 = R.string.message_permission_request_camera;
                bVar.c(l0.Z(i11));
                bVar.b();
                break;
            case 115:
                i11 = R.string.message_permission_request_record_audio;
                bVar.c(l0.Z(i11));
                bVar.b();
                break;
        }
        InterfaceC0096a interfaceC0096a = f7540b;
        if (interfaceC0096a == null || cVar == null) {
            return;
        }
        interfaceC0096a.a(cVar);
    }

    private static void w(final int i10) {
        com.groboot.mdaemergency.async.d.v().Y(i10, new b.InterfaceC0098b() { // from class: g5.f
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                com.groboot.mdaemergency.a.u(i10, aVar);
            }
        });
    }

    public static void x(InterfaceC0096a interfaceC0096a) {
        f7540b = interfaceC0096a;
    }

    public static boolean y(Activity activity, Fragment fragment) {
        return B(activity, fragment, new String[]{"android.permission.CAMERA"}, R.string.no_permition_camera);
    }

    public static void z(Activity activity) {
        int i10;
        try {
            i10 = Settings.Secure.getInt(activity.getContentResolver(), "location_mode");
        } catch (Settings.SettingNotFoundException e10) {
            e10.printStackTrace();
            i10 = -1;
        }
        boolean z10 = i10 != 0 && i10 == 3;
        if (f7541c) {
            if (m.e() != i10) {
                w(i10);
            }
        } else if (!z10) {
            f7541c = true;
        } else if (m.e() != i10) {
            w(i10);
        }
    }
}
