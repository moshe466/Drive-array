package com.lt.plugin.lt_plugin.utils;

import A1.l;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import io.flutter.plugin.common.MethodChannel;
import java.util.Objects;
import t1.k;
import z1.g;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4399a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4400b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4401c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4402d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f4403e;

    public /* synthetic */ d(Object obj, Object obj2, int i, Object obj3, int i3) {
        this.f4399a = i3;
        this.f4401c = obj;
        this.f4402d = obj2;
        this.f4400b = i;
        this.f4403e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4399a) {
            case 0:
                SessionPreferencesHelper.lambda$invokeOnFlutterWithRetry$1((MethodChannel) this.f4401c, (String) this.f4402d, this.f4400b, (Handler) this.f4403e);
                return;
            default:
                final g gVar = (g) this.f4401c;
                final k kVar = (k) this.f4402d;
                final int i = this.f4400b;
                Runnable runnable = (Runnable) this.f4403e;
                B1.b bVar = gVar.f6862f;
                try {
                    try {
                        A1.d dVar = gVar.f6859c;
                        Objects.requireNonNull(dVar);
                        ((l) bVar).f(new J0.d(dVar, 28));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) gVar.f6857a.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            gVar.a(kVar, i);
                        } else {
                            ((l) bVar).f(new B1.a() { // from class: z1.f
                                @Override // B1.a
                                public final Object a() {
                                    g.this.f6860d.a(kVar, i + 1, false);
                                    return null;
                                }
                            });
                        }
                    } catch (SynchronizationException unused) {
                        gVar.f6860d.a(kVar, i + 1, false);
                    }
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    runnable.run();
                    throw th;
                }
        }
    }
}
