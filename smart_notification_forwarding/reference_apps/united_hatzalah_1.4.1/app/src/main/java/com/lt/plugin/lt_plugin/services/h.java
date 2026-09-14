package com.lt.plugin.lt_plugin.services;

import android.content.Context;
import com.lt.plugin.lt_plugin.services.LocationService;
import java.util.HashMap;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4391a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4392b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4393c;

    public /* synthetic */ h(Context context, String str) {
        this.f4393c = context;
        this.f4392b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4391a) {
            case 0:
                LocationService.AnonymousClass1.a(this.f4392b, (HashMap) this.f4393c);
                return;
            default:
                ActiveDispatchRefresh.a((Context) this.f4393c, this.f4392b);
                return;
        }
    }

    public /* synthetic */ h(String str, HashMap hashMap) {
        this.f4392b = str;
        this.f4393c = hashMap;
    }
}
