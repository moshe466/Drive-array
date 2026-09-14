package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.oc;

/* loaded from: classes.dex */
final class o4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.l2 f6281f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ ServiceConnection f6282g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ m4 f6283h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o4(m4 m4Var, com.google.android.gms.internal.measurement.l2 l2Var, ServiceConnection serviceConnection) {
        this.f6283h = m4Var;
        this.f6281f = l2Var;
        this.f6282g = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        t3 F;
        String str2;
        m4 m4Var = this.f6283h;
        n4 n4Var = m4Var.f6222b;
        str = m4Var.f6221a;
        com.google.android.gms.internal.measurement.l2 l2Var = this.f6281f;
        ServiceConnection serviceConnection = this.f6282g;
        Bundle a10 = n4Var.a(str, l2Var);
        n4Var.f6248a.e().c();
        if (a10 != null) {
            long j10 = a10.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j10 == 0) {
                F = n4Var.f6248a.h().I();
                str2 = "Service response is missing Install Referrer install timestamp";
            } else {
                String string = a10.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    F = n4Var.f6248a.h().F();
                    str2 = "No referrer defined in Install Referrer response";
                } else {
                    n4Var.f6248a.h().N().b("InstallReferrer API result", string);
                    Bundle B = n4Var.f6248a.G().B(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                    if (B == null) {
                        F = n4Var.f6248a.h().F();
                        str2 = "No campaign params defined in Install Referrer result";
                    } else {
                        String string2 = B.getString("medium");
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j11 = a10.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j11 == 0) {
                                F = n4Var.f6248a.h().F();
                                str2 = "Install Referrer is missing click timestamp for ad campaign";
                            } else {
                                B.putLong("click_timestamp", j11);
                            }
                        }
                        if (j10 == n4Var.f6248a.x().f5964k.a()) {
                            F = n4Var.f6248a.h().N();
                            str2 = "Install Referrer campaign has already been logged";
                        } else if (!oc.a() || !n4Var.f6248a.a().t(s.f6431t0) || n4Var.f6248a.p()) {
                            n4Var.f6248a.x().f5964k.b(j10);
                            n4Var.f6248a.h().N().b("Logging Install Referrer campaign from sdk with ", "referrer API");
                            B.putString("_cis", "referrer API");
                            n4Var.f6248a.F().R("auto", "_cmp", B);
                        }
                    }
                }
            }
            F.a(str2);
        }
        if (serviceConnection != null) {
            f2.a.b().c(n4Var.f6248a.i(), serviceConnection);
        }
    }
}
