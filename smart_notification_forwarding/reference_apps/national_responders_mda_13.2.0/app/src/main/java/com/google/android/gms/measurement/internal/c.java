package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.bc;
import com.google.android.gms.internal.measurement.wb;
import com.google.android.gms.internal.measurement.zd;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class c extends r5 {

    /* renamed from: b, reason: collision with root package name */
    private Boolean f5884b;

    /* renamed from: c, reason: collision with root package name */
    private d f5885c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f5886d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(t4 t4Var) {
        super(t4Var);
        this.f5885c = b.f5823a;
    }

    public static long P() {
        return s.D.a(null).longValue();
    }

    public static long Q() {
        return s.f6398d.a(null).longValue();
    }

    private final Bundle U() {
        try {
            if (i().getPackageManager() == null) {
                h().F().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo c10 = i2.c.a(i()).c(i().getPackageName(), 128);
            if (c10 != null) {
                return c10.metaData;
            }
            h().F().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            h().F().b("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    private final String g(String str, String str2) {
        t3 F;
        String str3;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e10) {
            e = e10;
            F = h().F();
            str3 = "Could not find SystemProperties class";
            F.b(str3, e);
            return str2;
        } catch (IllegalAccessException e11) {
            e = e11;
            F = h().F();
            str3 = "Could not access SystemProperties.get()";
            F.b(str3, e);
            return str2;
        } catch (NoSuchMethodException e12) {
            e = e12;
            F = h().F();
            str3 = "Could not find SystemProperties.get() method";
            F.b(str3, e);
            return str2;
        } catch (InvocationTargetException e13) {
            e = e13;
            F = h().F();
            str3 = "SystemProperties.get() threw an exception";
            F.b(str3, e);
            return str2;
        }
    }

    private final int p(String str, l3<Integer> l3Var, int i10, int i11) {
        return Math.max(Math.min(v(str, l3Var), i11), i10);
    }

    public final boolean A(String str, l3<Boolean> l3Var) {
        Boolean a10;
        if (str != null) {
            String g10 = this.f5885c.g(str, l3Var.b());
            if (!TextUtils.isEmpty(g10)) {
                a10 = l3Var.a(Boolean.valueOf(Boolean.parseBoolean(g10)));
                return a10.booleanValue();
            }
        }
        a10 = l3Var.a(null);
        return a10.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long B(String str) {
        return q(str, s.f6394b);
    }

    public final boolean C() {
        if (this.f5886d == null) {
            synchronized (this) {
                if (this.f5886d == null) {
                    ApplicationInfo applicationInfo = i().getApplicationInfo();
                    String a10 = g2.m.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f5886d = Boolean.valueOf(str != null && str.equals(a10));
                    }
                    if (this.f5886d == null) {
                        this.f5886d = Boolean.TRUE;
                        h().F().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f5886d.booleanValue();
    }

    public final boolean D(String str, l3<Boolean> l3Var) {
        return A(str, l3Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean E(String str) {
        b2.p.g(str);
        Bundle U = U();
        if (U == null) {
            h().F().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (U.containsKey(str)) {
            return Boolean.valueOf(U.getBoolean(str));
        }
        return null;
    }

    public final boolean F() {
        Boolean E = E("firebase_analytics_collection_deactivated");
        return E != null && E.booleanValue();
    }

    public final Boolean G() {
        Boolean E = E("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(E == null || E.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> H(java.lang.String r4) {
        /*
            r3 = this;
            b2.p.g(r4)
            android.os.Bundle r0 = r3.U()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.r3 r4 = r3.h()
            com.google.android.gms.measurement.internal.t3 r4 = r4.F()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.i()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.r3 r0 = r3.h()
            com.google.android.gms.measurement.internal.t3 r0 = r0.F()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.c.H(java.lang.String):java.util.List");
    }

    public final Boolean I() {
        if (!zd.a() || !t(s.f6433u0)) {
            return Boolean.TRUE;
        }
        Boolean E = E("google_analytics_automatic_screen_reporting_enabled");
        return Boolean.valueOf(E == null || E.booleanValue());
    }

    public final boolean J(String str) {
        return "1".equals(this.f5885c.g(str, "gaia_collection_enabled"));
    }

    public final Boolean K() {
        if (bc.a() && t(s.I0)) {
            return E("google_analytics_default_allow_ad_storage");
        }
        return null;
    }

    public final boolean L(String str) {
        return "1".equals(this.f5885c.g(str, "measurement.event_sampling_enabled"));
    }

    public final Boolean M() {
        if (bc.a() && t(s.I0)) {
            return E("google_analytics_default_allow_analytics_storage");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean N(String str) {
        return A(str, s.K);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String O(String str) {
        l3<String> l3Var = s.L;
        return l3Var.a(str == null ? null : this.f5885c.g(str, l3Var.b()));
    }

    public final String R() {
        return g("debug.firebase.analytics.app", "");
    }

    public final String S() {
        return g("debug.deferred.deeplink", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean T() {
        if (this.f5884b == null) {
            Boolean E = E("app_measurement_lite");
            this.f5884b = E;
            if (E == null) {
                this.f5884b = Boolean.FALSE;
            }
        }
        return this.f5884b.booleanValue() || !this.f6381a.N();
    }

    public final int o(String str) {
        return p(str, s.I, 25, 100);
    }

    public final long q(String str, l3<Long> l3Var) {
        if (str != null) {
            String g10 = this.f5885c.g(str, l3Var.b());
            if (!TextUtils.isEmpty(g10)) {
                try {
                    return l3Var.a(Long.valueOf(Long.parseLong(g10))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l3Var.a(null).longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String r(com.google.android.gms.measurement.internal.b4 r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.A()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
            boolean r1 = com.google.android.gms.internal.measurement.md.a()
            if (r1 == 0) goto L2f
            com.google.android.gms.measurement.internal.c r1 = r5.m()
            java.lang.String r2 = r6.t()
            com.google.android.gms.measurement.internal.l3<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.s.f6411j0
            boolean r1 = r1.A(r2, r3)
            if (r1 == 0) goto L2f
            java.lang.String r1 = r6.G()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
        L2f:
            java.lang.String r1 = r6.D()
        L33:
            com.google.android.gms.measurement.internal.l3<java.lang.String> r2 = com.google.android.gms.measurement.internal.s.f6400e
            r3 = 0
            java.lang.Object r2 = r2.a(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.l3<java.lang.String> r4 = com.google.android.gms.measurement.internal.s.f6402f
            java.lang.Object r3 = r4.a(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L5d
            java.lang.String r1 = r3.concat(r1)
            goto L62
        L5d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L62:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.x()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            java.lang.String r1 = "gmp_version"
            java.lang.String r2 = "33025"
            r6.appendQueryParameter(r1, r2)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.c.r(com.google.android.gms.measurement.internal.b4):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(d dVar) {
        this.f5885c = dVar;
    }

    public final boolean t(l3<Boolean> l3Var) {
        return A(null, l3Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int u(String str) {
        if (wb.a() && A(null, s.f6437w0)) {
            return p(str, s.H, 500, 2000);
        }
        return 500;
    }

    public final int v(String str, l3<Integer> l3Var) {
        if (str != null) {
            String g10 = this.f5885c.g(str, l3Var.b());
            if (!TextUtils.isEmpty(g10)) {
                try {
                    return l3Var.a(Integer.valueOf(Integer.parseInt(g10))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l3Var.a(null).intValue();
    }

    public final double w(String str, l3<Double> l3Var) {
        if (str != null) {
            String g10 = this.f5885c.g(str, l3Var.b());
            if (!TextUtils.isEmpty(g10)) {
                try {
                    return l3Var.a(Double.valueOf(Double.parseDouble(g10))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l3Var.a(null).doubleValue();
    }

    public final int x(String str) {
        return v(str, s.f6420o);
    }

    public final int y() {
        if (wb.a() && m().A(null, s.f6439x0)) {
            o9 k10 = k();
            Boolean a02 = k10.f6381a.P().a0();
            if (k10.K0() >= 201500 || !(a02 == null || a02.booleanValue())) {
                return 100;
            }
        }
        return 25;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int z(String str) {
        if (wb.a() && A(null, s.f6437w0)) {
            return p(str, s.G, 25, 100);
        }
        return 25;
    }
}
