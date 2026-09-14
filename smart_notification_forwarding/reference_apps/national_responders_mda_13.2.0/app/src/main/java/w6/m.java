package w6;

import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.enums.a;
import com.groboot.mdaemergency.models.Address;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.Patient;
import com.groboot.mdaemergency.models.ReportEvent;
import com.groboot.mdaemergency.models.Settings;
import com.groboot.mdaemergency.models.ShortcutButtonsLocally;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    static Integer f15214a;

    /* renamed from: b, reason: collision with root package name */
    static com.groboot.mdaemergency.enums.a f15215b;

    /* renamed from: c, reason: collision with root package name */
    static AppUser f15216c;

    /* renamed from: d, reason: collision with root package name */
    static Settings f15217d;

    /* renamed from: e, reason: collision with root package name */
    static ShortcutButtonsLocally f15218e;

    /* renamed from: f, reason: collision with root package name */
    static Boolean f15219f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.f15216c != null) {
                a0.a().k("app_user", new com.google.gson.e().r(m.f15216c));
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.f15217d != null) {
                String str = null;
                try {
                    str = new com.google.gson.e().r(m.f15217d);
                } catch (Exception unused) {
                }
                if (str != null) {
                    a0.a().k("settings", str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends e5.a<ArrayList<String>> {
        c() {
        }
    }

    /* loaded from: classes.dex */
    class d extends e5.a<ShortcutButtonsLocally<com.groboot.mdaemergency.ptt.a>> {
        d() {
        }
    }

    /* loaded from: classes.dex */
    class e extends e5.a<ArrayList<Address>> {
        e() {
        }
    }

    public static boolean A() {
        return a0.a().c("playPushTeamSound", true);
    }

    public static void A0(String str) {
        a0.a().k("serverURL", str);
    }

    public static int B() {
        if (f15214a == null) {
            f15214a = Integer.valueOf(a0.a().d("PTT_FLOAT_VIEW_DELAY", 60));
        }
        return f15214a.intValue();
    }

    public static void B0(boolean z10) {
        a0.a().h("shabbatMode", z10);
    }

    public static String C() {
        return l0.a0(a0.a().f("PTT_FLOAT_VIEW", "2"));
    }

    public static void C0(final List<String> list) {
        if (list != null) {
            new Thread(new Runnable() { // from class: w6.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.S(list);
                }
            }).start();
        } else {
            a0.a().k("shortcutButtons", "");
        }
    }

    public static String D() {
        return a0.a().f("PTT_STATUS", "1");
    }

    public static void D0(boolean z10) {
        a0.a().h("shortcutButtonsEdited", z10);
    }

    public static boolean E() {
        return a0.a().c("PttVibrate", true);
    }

    public static void E0(final ShortcutButtonsLocally shortcutButtonsLocally) {
        if (shortcutButtonsLocally != null) {
            f15218e = (ShortcutButtonsLocally) shortcutButtonsLocally.clone();
            new Thread(new Runnable() { // from class: w6.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.T(ShortcutButtonsLocally.this);
                }
            }).start();
        } else {
            f15218e = null;
            a0.a().k("shortcutButtonsLocally", "");
        }
    }

    public static float F() {
        return (float) a0.a().e("pttVolumeSession", 10L);
    }

    public static void F0(String str) {
        a0.a().k("userName", str);
    }

    public static String G() {
        return a0.a().f("PTT_VOLUME", "-1");
    }

    public static void G0(String str) {
        a0.a().k("versionCode", str);
    }

    public static d.v H() {
        int ordinal = d.v.getDefault().ordinal();
        int d10 = a0.a().d("serverType", ordinal);
        d.v[] values = d.v.values();
        if (d10 < values.length) {
            ordinal = d10;
        }
        return values[ordinal];
    }

    public static void H0(int i10) {
        a0.a().i("vlfs", i10);
    }

    public static String I() {
        return a0.a().f("serverURL", com.groboot.mdaemergency.async.d.s());
    }

    public static void I0(String str) {
        a0.a().k("versionNumber", str);
    }

    public static Settings J() {
        if (f15217d == null) {
            com.google.gson.e eVar = new com.google.gson.e();
            String f10 = a0.a().f("settings", "");
            if (f10 == null) {
                f15217d = new Settings();
            } else {
                try {
                    f15217d = (Settings) eVar.i(f10, Settings.class);
                } catch (Exception unused) {
                }
            }
            if (f15217d == null) {
                f15217d = new Settings();
            }
            f15217d.init();
        }
        return f15217d;
    }

    public static void J0(ReportEvent reportEvent) {
        a0.a().l("currentevent", reportEvent);
    }

    public static boolean K() {
        return a0.a().c("shabbatMode", false);
    }

    public static void K0(Patient patient) {
        a0.a().l("patient", patient);
    }

    public static List<String> L() {
        try {
            return (ArrayList) new com.google.gson.e().j(a0.a().f("shortcutButtons", ""), new c().e());
        } catch (Exception unused) {
            return null;
        }
    }

    public static void L0(String str) {
        a0.a().k("access_token", str);
    }

    public static ShortcutButtonsLocally<com.groboot.mdaemergency.ptt.a> M() {
        ShortcutButtonsLocally shortcutButtonsLocally = f15218e;
        if (shortcutButtonsLocally == null || shortcutButtonsLocally.isEmpty()) {
            com.google.gson.e eVar = new com.google.gson.e();
            String f10 = a0.a().f("shortcutButtonsLocally", "");
            if (f10 == null || f10.isEmpty()) {
                f15218e = new ShortcutButtonsLocally();
            } else {
                try {
                    f15218e = (ShortcutButtonsLocally) eVar.j(f10, new d().e());
                } catch (Exception unused) {
                }
            }
            if (f15218e == null) {
                f15218e = new ShortcutButtonsLocally();
            }
        }
        return f15218e;
    }

    public static int N() {
        if (L() == null) {
            return 5;
        }
        return L().size();
    }

    public static com.groboot.mdaemergency.enums.b O() {
        if (k() == null || k().getLocation() == null || k().getLocation().getStatusAvailability() == null) {
            return null;
        }
        return k().getLocation().getStatusAvailability();
    }

    public static String P() {
        return a0.a().f("versionCode", "");
    }

    public static int Q() {
        return a0.a().d("vlfs", 0);
    }

    public static Boolean R() {
        if (f15219f == null) {
            f15219f = Boolean.valueOf(a0.a().c("PttActiveOnCall", false));
        }
        return f15219f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(List list) {
        if (list != null) {
            String str = null;
            try {
                str = new com.google.gson.e().r(list);
            } catch (Exception unused) {
            }
            if (str != null) {
                a0.a().k("shortcutButtons", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(ShortcutButtonsLocally shortcutButtonsLocally) {
        ShortcutButtonsLocally shortcutButtonsLocally2 = (ShortcutButtonsLocally) shortcutButtonsLocally.clone();
        f15218e = shortcutButtonsLocally2;
        if (shortcutButtonsLocally2 != null) {
            String str = null;
            try {
                str = new com.google.gson.e().r(f15218e);
            } catch (Exception unused) {
            }
            if (str != null) {
                a0.a().k("shortcutButtonsLocally", str);
            }
        }
    }

    public static void U(AppUser appUser) {
        if (appUser != null) {
            f15216c = appUser;
            new Thread(new a()).start();
        } else {
            f15216c = null;
            a0.a().k("app_user", "");
        }
    }

    public static void V(Settings settings) {
        if (settings != null) {
            f15217d = settings;
            new Thread(new b()).start();
        } else {
            f15217d = null;
            a0.a().k("settings", "");
        }
    }

    public static void W(List<Feature> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() >= 10) {
            list = list.subList(0, 10);
        }
        for (Feature feature : list) {
            if (feature != null) {
                arrayList.add(feature.FeatureID);
            }
        }
        C0(arrayList);
    }

    public static void X(int i10) {
        a0.a().i("AccuracyMode", i10);
    }

    public static void Y(boolean z10) {
        a0.a().h("ADV_GEO_TRACKING", z10);
    }

    public static void Z(String str) {
        a0.a().k("alertKonanVolume", str);
    }

    public static void a0(String str) {
        a0.a().k("alertTeamVolume", str);
    }

    public static void b0(boolean z10) {
        a0.a().h("allowedPrintScreen", z10);
    }

    public static void c() {
        L0("");
        J0(null);
        U(null);
        K0(null);
        f0(false);
        h0(false);
        Boolean bool = Boolean.TRUE;
        i0(bool);
        v0(bool);
        B0(false);
        z0(d.v.getDefault());
    }

    public static void c0(com.groboot.mdaemergency.enums.a aVar) {
        f15215b = aVar;
    }

    public static String d() {
        return a0.a().f("access_token", "");
    }

    public static void d0(List<Address> list) {
        if (list != null) {
            String str = null;
            try {
                str = new com.google.gson.e().r(list);
            } catch (Exception unused) {
            }
            if (str != null) {
                a0.a().k("BikeLocation", str);
            }
        }
    }

    public static int e() {
        return a0.a().d("AccuracyMode", -1);
    }

    public static void e0(int i10) {
        a0.a().i("calendarId", i10);
    }

    public static boolean f() {
        boolean z10 = false;
        if (k() == null) {
            return false;
        }
        if ((m() == com.groboot.mdaemergency.enums.a.MADA || m() == com.groboot.mdaemergency.enums.a.CREW) && k().getType() == 1) {
            z10 = true;
        }
        return a0.a().c("ADV_GEO_TRACKING", z10);
    }

    public static void f0(boolean z10) {
        a0.a().h("is_dev_user", z10);
    }

    public static String g() {
        return a0.a().f("alertKonanVolume", "-1");
    }

    public static void g0(boolean z10) {
        a0.a().h("IS_DisplayStatus", z10);
    }

    public static String h() {
        return a0.a().f("alertTeamVolume", "-1");
    }

    public static void h0(boolean z10) {
        a0.a().h("IS_PTT_PERMISSION", z10);
    }

    public static boolean i() {
        return a0.a().c("allowedPrintScreen", false);
    }

    public static void i0(Boolean bool) {
        a0.a().h("IsPttActive", bool.booleanValue());
    }

    public static int j() {
        return m() == null ? R.drawable.icon_notifications : m().icon();
    }

    public static void j0(Boolean bool) {
        f15219f = bool;
        a0.a().h("PttActiveOnCall", bool.booleanValue());
    }

    public static AppUser k() {
        if (f15216c == null) {
            f15216c = (AppUser) new com.google.gson.e().i(a0.a().f("app_user", ""), AppUser.class);
        }
        return f15216c;
    }

    public static void k0(boolean z10) {
        a0.a().h("is_tracking", z10);
    }

    public static int l() {
        return m() == null ? R.string.app_name : m().name();
    }

    public static void l0(com.groboot.mdaemergency.enums.e eVar) {
        a0.a().k("language", eVar.toString());
    }

    public static com.groboot.mdaemergency.enums.a m() {
        return f15215b;
    }

    public static void m0(boolean z10) {
        a0.a().h("locationServiceShouldRun", z10);
    }

    public static List<Address> n() {
        try {
            return (List) new com.google.gson.e().j(a0.a().f("BikeLocation", ""), new e().e());
        } catch (Exception unused) {
            return null;
        }
    }

    public static void n0(String str) {
        a0.a().k("messageDataToShow", str);
    }

    public static int o() {
        return a0.a().d("calendarId", -1);
    }

    public static void o0(String str) {
        a0.a().k("messageIdToShow", str);
    }

    public static a.d p() {
        return (m() == null ? com.groboot.mdaemergency.enums.a.MADA : m()).getColors();
    }

    public static void p0(int i10) {
        a0.a().i("messageTypeToShow", i10);
    }

    public static boolean q() {
        if (a0.a() == null) {
            return false;
        }
        return a0.a().c("is_dev_user", false);
    }

    public static void q0(long j10) {
        a0.a().j("NOTIFICATION_VIEW_DELAY", j10);
    }

    public static boolean r() {
        return a0.a().c("IS_PTT_PERMISSION", false);
    }

    public static void r0(boolean z10) {
        a0.a().h("playPushTeamSound", z10);
    }

    public static boolean s() {
        return a0.a().c("IsPttActive", true);
    }

    public static void s0(int i10) {
        f15214a = Integer.valueOf(i10);
        a0.a().i("PTT_FLOAT_VIEW_DELAY", i10);
    }

    public static boolean t() {
        return a0.a().c("is_tracking", false);
    }

    public static void t0(String str) {
        a0.a().k("PTT_FLOAT_VIEW", str);
    }

    public static com.groboot.mdaemergency.enums.e u() {
        a0 a10 = a0.a();
        com.groboot.mdaemergency.enums.e eVar = com.groboot.mdaemergency.enums.e.Hebrew;
        com.groboot.mdaemergency.enums.e languageType = com.groboot.mdaemergency.enums.e.toLanguageType(a10.f("language", eVar.toString()));
        return (m() == com.groboot.mdaemergency.enums.a.PHILIPINE && languageType == eVar) ? com.groboot.mdaemergency.enums.e.English : languageType;
    }

    public static void u0(String str) {
        a0.a().k("PTT_STATUS", str);
    }

    public static Boolean v() {
        return Boolean.valueOf(a0.a().c("locationServiceShouldRun", false));
    }

    public static void v0(Boolean bool) {
        a0.a().h("PttVibrate", bool.booleanValue());
    }

    public static String w() {
        return a0.a().f("messageDataToShow", "");
    }

    public static void w0(float f10) {
        a0.a().k("PTT_VOLUME_V", f10 + "");
    }

    public static String x() {
        return a0.a().f("messageIdToShow", "");
    }

    public static void x0(float f10) {
        a0.a().j("pttVolumeSession", f10);
    }

    public static int y() {
        return a0.a().d("messageTypeToShow", -1);
    }

    public static void y0(String str) {
        a0.a().k("PTT_VOLUME", str);
    }

    public static long z() {
        return a0.a().e("NOTIFICATION_VIEW_DELAY", Long.valueOf(TimeUnit.MINUTES.toMillis(1L)));
    }

    public static void z0(d.v vVar) {
        a0.a().i("serverType", vVar.ordinal());
    }
}
