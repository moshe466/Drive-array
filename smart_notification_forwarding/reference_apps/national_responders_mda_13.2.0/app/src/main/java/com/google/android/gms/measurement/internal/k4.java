package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class k4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6155a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6156b;

    /* renamed from: c, reason: collision with root package name */
    private String f6157c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ e4 f6158d;

    public k4(e4 e4Var, String str, String str2) {
        this.f6158d = e4Var;
        b2.p.g(str);
        this.f6155a = str;
    }

    public final String a() {
        if (!this.f6156b) {
            this.f6156b = true;
            this.f6157c = this.f6158d.E().getString(this.f6155a, null);
        }
        return this.f6157c;
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f6158d.E().edit();
        edit.putString(this.f6155a, str);
        edit.apply();
        this.f6157c = str;
    }
}
