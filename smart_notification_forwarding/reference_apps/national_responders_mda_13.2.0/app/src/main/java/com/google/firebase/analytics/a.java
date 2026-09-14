package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.h;
import java.util.List;
import java.util.Map;
import v2.m;

/* loaded from: classes.dex */
final class a implements m {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ h f7049a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(h hVar) {
        this.f7049a = hVar;
    }

    @Override // v2.m
    public final String a() {
        return this.f7049a.N();
    }

    @Override // v2.m
    public final String b() {
        return this.f7049a.H();
    }

    @Override // v2.m
    public final String c() {
        return this.f7049a.C();
    }

    @Override // v2.m
    public final long d() {
        return this.f7049a.I();
    }

    @Override // v2.m
    public final void e(String str) {
        this.f7049a.y(str);
    }

    @Override // v2.m
    public final void f(Bundle bundle) {
        this.f7049a.i(bundle);
    }

    @Override // v2.m
    public final List<Bundle> g(String str, String str2) {
        return this.f7049a.w(str, str2);
    }

    @Override // v2.m
    public final int h(String str) {
        return this.f7049a.G(str);
    }

    @Override // v2.m
    public final void i(String str) {
        this.f7049a.D(str);
    }

    @Override // v2.m
    public final Map<String, Object> j(String str, String str2, boolean z10) {
        return this.f7049a.e(str, str2, z10);
    }

    @Override // v2.m
    public final void k(String str, String str2, Bundle bundle) {
        this.f7049a.z(str, str2, bundle);
    }

    @Override // v2.m
    public final void l(String str, String str2, Bundle bundle) {
        this.f7049a.n(str, str2, bundle);
    }

    @Override // v2.m
    public final String zza() {
        return this.f7049a.L();
    }
}
