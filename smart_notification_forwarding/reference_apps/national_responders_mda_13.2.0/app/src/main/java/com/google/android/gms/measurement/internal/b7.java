package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.bd;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class b7 extends z4 {

    /* renamed from: c, reason: collision with root package name */
    private volatile c7 f5857c;

    /* renamed from: d, reason: collision with root package name */
    private c7 f5858d;

    /* renamed from: e, reason: collision with root package name */
    protected c7 f5859e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Activity, c7> f5860f;

    /* renamed from: g, reason: collision with root package name */
    private Activity f5861g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f5862h;

    /* renamed from: i, reason: collision with root package name */
    private volatile c7 f5863i;

    /* renamed from: j, reason: collision with root package name */
    private c7 f5864j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5865k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f5866l;

    /* renamed from: m, reason: collision with root package name */
    private String f5867m;

    public b7(t4 t4Var) {
        super(t4Var);
        this.f5866l = new Object();
        this.f5860f = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ c7 C(b7 b7Var, c7 c7Var) {
        b7Var.f5864j = null;
        return null;
    }

    private static String E(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final void H(Activity activity, c7 c7Var, boolean z10) {
        c7 c7Var2;
        c7 c7Var3 = this.f5857c == null ? this.f5858d : this.f5857c;
        if (c7Var.f5902b == null) {
            c7Var2 = new c7(c7Var.f5901a, activity != null ? E(activity.getClass().getCanonicalName()) : null, c7Var.f5903c, c7Var.f5905e, c7Var.f5906f);
        } else {
            c7Var2 = c7Var;
        }
        this.f5858d = this.f5857c;
        this.f5857c = c7Var2;
        e().z(new d7(this, c7Var2, c7Var3, f().b(), z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(Bundle bundle, c7 c7Var, c7 c7Var2, long j10) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        P(c7Var, c7Var2, j10, true, k().D(null, "screen_view", bundle, null, true, true));
    }

    public static void O(c7 c7Var, Bundle bundle, boolean z10) {
        if (bundle == null || c7Var == null || (bundle.containsKey("_sc") && !z10)) {
            if (bundle != null && c7Var == null && z10) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = c7Var.f5901a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = c7Var.f5902b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", c7Var.f5903c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(c7 c7Var, c7 c7Var2, long j10, boolean z10, Bundle bundle) {
        boolean z11;
        c7 c7Var3;
        long j11;
        c();
        if (m().t(s.T)) {
            z11 = z10 && this.f5859e != null;
            if (z11) {
                Q(this.f5859e, true, j10);
            }
        } else {
            if (z10 && (c7Var3 = this.f5859e) != null) {
                Q(c7Var3, true, j10);
            }
            z11 = false;
        }
        if ((c7Var2 != null && c7Var2.f5903c == c7Var.f5903c && o9.B0(c7Var2.f5902b, c7Var.f5902b) && o9.B0(c7Var2.f5901a, c7Var.f5901a)) ? false : true) {
            Bundle bundle2 = new Bundle();
            if (m().t(s.f6435v0)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            Bundle bundle3 = bundle2;
            O(c7Var, bundle3, true);
            if (c7Var2 != null) {
                String str = c7Var2.f5901a;
                if (str != null) {
                    bundle3.putString("_pn", str);
                }
                String str2 = c7Var2.f5902b;
                if (str2 != null) {
                    bundle3.putString("_pc", str2);
                }
                bundle3.putLong("_pi", c7Var2.f5903c);
            }
            if (m().t(s.T) && z11) {
                long B = (bd.a() && m().t(s.V)) ? u().B(j10) : u().f6326e.e();
                if (B > 0) {
                    k().L(bundle3, B);
                }
            }
            String str3 = "auto";
            if (m().t(s.f6435v0)) {
                if (!m().I().booleanValue()) {
                    bundle3.putLong("_mst", 1L);
                }
                if (c7Var.f5905e) {
                    str3 = "app";
                }
            }
            String str4 = str3;
            if (m().t(s.f6435v0)) {
                long a10 = f().a();
                if (c7Var.f5905e) {
                    long j12 = c7Var.f5906f;
                    if (j12 != 0) {
                        j11 = j12;
                        p().O(str4, "_vs", j11, bundle3);
                    }
                }
                j11 = a10;
                p().O(str4, "_vs", j11, bundle3);
            } else {
                p().r0(str4, "_vs", bundle3);
            }
        }
        this.f5859e = c7Var;
        if (m().t(s.f6435v0) && c7Var.f5905e) {
            this.f5864j = c7Var;
        }
        r().K(c7Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(c7 c7Var, boolean z10, long j10) {
        o().v(f().b());
        if (!u().E(c7Var != null && c7Var.f5904d, z10, j10) || c7Var == null) {
            return;
        }
        c7Var.f5904d = false;
    }

    private final c7 W(Activity activity) {
        b2.p.k(activity);
        c7 c7Var = this.f5860f.get(activity);
        if (c7Var == null) {
            c7 c7Var2 = new c7(null, E(activity.getClass().getCanonicalName()), k().E0());
            this.f5860f.put(activity, c7Var2);
            c7Var = c7Var2;
        }
        return (m().t(s.f6435v0) && this.f5863i != null) ? this.f5863i : c7Var;
    }

    public final c7 D(boolean z10) {
        w();
        c();
        if (!m().t(s.f6435v0) || !z10) {
            return this.f5859e;
        }
        c7 c7Var = this.f5859e;
        return c7Var != null ? c7Var : this.f5864j;
    }

    public final void F(Activity activity) {
        if (m().t(s.f6435v0)) {
            synchronized (this.f5866l) {
                this.f5865k = true;
                if (activity != this.f5861g) {
                    synchronized (this.f5866l) {
                        this.f5861g = activity;
                        this.f5862h = false;
                    }
                    if (m().t(s.f6433u0) && m().I().booleanValue()) {
                        this.f5863i = null;
                        e().z(new h7(this));
                    }
                }
            }
        }
        if (m().t(s.f6433u0) && !m().I().booleanValue()) {
            this.f5857c = this.f5863i;
            e().z(new g7(this));
        } else {
            H(activity, W(activity), false);
            a o10 = o();
            o10.e().z(new c3(o10, o10.f().b()));
        }
    }

    public final void G(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!m().I().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f5860f.put(activity, new c7(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    @Deprecated
    public final void I(Activity activity, String str, String str2) {
        if (!m().I().booleanValue()) {
            h().K().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        if (this.f5857c == null) {
            h().K().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f5860f.get(activity) == null) {
            h().K().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = E(activity.getClass().getCanonicalName());
        }
        boolean B0 = o9.B0(this.f5857c.f5902b, str2);
        boolean B02 = o9.B0(this.f5857c.f5901a, str);
        if (B0 && B02) {
            h().K().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            h().K().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            h().K().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        h().N().c("Setting current screen to name, class", str == null ? "null" : str, str2);
        c7 c7Var = new c7(str, str2, k().E0());
        this.f5860f.put(activity, c7Var);
        H(activity, c7Var, true);
    }

    public final void J(Bundle bundle, long j10) {
        String str;
        if (!m().t(s.f6435v0)) {
            h().K().a("Manual screen reporting is disabled.");
            return;
        }
        synchronized (this.f5866l) {
            if (!this.f5865k) {
                h().K().a("Cannot log screen view event when the app is in the background.");
                return;
            }
            String str2 = null;
            if (bundle != null) {
                String string = bundle.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > 100)) {
                    h().K().b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString("screen_class");
                if (string2 != null && (string2.length() <= 0 || string2.length() > 100)) {
                    h().K().b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    str2 = string2;
                }
            } else {
                str = null;
            }
            if (str2 == null) {
                Activity activity = this.f5861g;
                str2 = activity != null ? E(activity.getClass().getCanonicalName()) : "Activity";
            }
            String str3 = str2;
            if (this.f5862h && this.f5857c != null) {
                this.f5862h = false;
                boolean B0 = o9.B0(this.f5857c.f5902b, str3);
                boolean B02 = o9.B0(this.f5857c.f5901a, str);
                if (B0 && B02) {
                    h().K().a("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            h().N().c("Logging screen view with name, class", str == null ? "null" : str, str3 == null ? "null" : str3);
            c7 c7Var = this.f5857c == null ? this.f5858d : this.f5857c;
            c7 c7Var2 = new c7(str, str3, k().E0(), true, j10);
            this.f5857c = c7Var2;
            this.f5858d = c7Var;
            this.f5863i = c7Var2;
            e().z(new e7(this, bundle, c7Var2, c7Var, f().b()));
        }
    }

    public final void R(String str, c7 c7Var) {
        c();
        synchronized (this) {
            String str2 = this.f5867m;
            if (str2 == null || str2.equals(str) || c7Var != null) {
                this.f5867m = str;
            }
        }
    }

    public final c7 S() {
        return this.f5857c;
    }

    public final void T(Activity activity) {
        if (m().t(s.f6435v0)) {
            synchronized (this.f5866l) {
                this.f5865k = false;
                this.f5862h = true;
            }
        }
        long b10 = f().b();
        if (m().t(s.f6433u0) && !m().I().booleanValue()) {
            this.f5857c = null;
            e().z(new f7(this, b10));
        } else {
            c7 W = W(activity);
            this.f5858d = this.f5857c;
            this.f5857c = null;
            e().z(new i7(this, W, b10));
        }
    }

    public final void U(Activity activity, Bundle bundle) {
        c7 c7Var;
        if (!m().I().booleanValue() || bundle == null || (c7Var = this.f5860f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", c7Var.f5903c);
        bundle2.putString("name", c7Var.f5901a);
        bundle2.putString("referrer_name", c7Var.f5902b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void V(Activity activity) {
        synchronized (this.f5866l) {
            if (activity == this.f5861g) {
                this.f5861g = null;
            }
        }
        if (m().I().booleanValue()) {
            this.f5860f.remove(activity);
        }
    }

    @Override // com.google.android.gms.measurement.internal.z4
    protected final boolean z() {
        return false;
    }
}
