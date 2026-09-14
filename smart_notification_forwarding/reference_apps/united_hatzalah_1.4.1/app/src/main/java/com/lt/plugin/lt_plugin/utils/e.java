package com.lt.plugin.lt_plugin.utils;

import com.lt.plugin.lt_plugin.utils.SessionPreferencesHelper;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4404a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4405b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4406c;

    public /* synthetic */ e(String str, int i, int i3) {
        this.f4404a = i3;
        this.f4405b = str;
        this.f4406c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4404a) {
            case 0:
                SessionPreferencesHelper.AnonymousClass1.a(this.f4406c, this.f4405b);
                return;
            default:
                SessionPreferencesHelper.a(this.f4406c, this.f4405b);
                return;
        }
    }
}
