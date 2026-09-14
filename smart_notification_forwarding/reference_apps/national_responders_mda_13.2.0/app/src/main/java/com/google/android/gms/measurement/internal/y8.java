package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ic;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y8 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p8 f6644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y8(p8 p8Var) {
        this.f6644a = p8Var;
    }

    private final void c(long j10, boolean z10) {
        this.f6644a.c();
        if (this.f6644a.f6381a.p()) {
            this.f6644a.l().f5974u.b(j10);
            this.f6644a.h().N().b("Session started, time", Long.valueOf(this.f6644a.f().b()));
            Long valueOf = Long.valueOf(j10 / 1000);
            this.f6644a.p().U("auto", "_sid", valueOf, j10);
            this.f6644a.l().f5971r.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.f6644a.m().t(s.f6413k0) && z10) {
                bundle.putLong("_aib", 1L);
            }
            this.f6644a.p().O("auto", "_s", j10, bundle);
            if (ic.a() && this.f6644a.m().t(s.f6423p0)) {
                String a10 = this.f6644a.l().f5979z.a();
                if (TextUtils.isEmpty(a10)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a10);
                this.f6644a.p().O("auto", "_ssr", j10, bundle2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f6644a.c();
        if (this.f6644a.l().y(this.f6644a.f().a())) {
            this.f6644a.l().f5971r.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f6644a.h().N().a("Detected application was in foreground");
                c(this.f6644a.f().a(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j10, boolean z10) {
        this.f6644a.c();
        this.f6644a.F();
        if (this.f6644a.l().y(j10)) {
            this.f6644a.l().f5971r.a(true);
        }
        this.f6644a.l().f5974u.b(j10);
        if (this.f6644a.l().f5971r.b()) {
            c(j10, z10);
        }
    }
}
