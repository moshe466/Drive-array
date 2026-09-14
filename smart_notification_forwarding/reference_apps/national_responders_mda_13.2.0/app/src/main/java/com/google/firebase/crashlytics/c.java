package com.google.firebase.crashlytics;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.m;
import com.google.firebase.crashlytics.internal.common.s;
import com.google.firebase.crashlytics.internal.common.v;
import com.google.firebase.crashlytics.internal.common.x;
import com.google.firebase.installations.g;
import f4.d;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p3.a;
import s3.e;
import t3.f;
import z2.o;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final m f7056a;

    /* loaded from: classes.dex */
    class a implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f7057a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExecutorService f7058b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f7059c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f7060d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f7061e;

        a(e eVar, ExecutorService executorService, d dVar, boolean z10, m mVar) {
            this.f7057a = eVar;
            this.f7058b = executorService;
            this.f7059c = dVar;
            this.f7060d = z10;
            this.f7061e = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            this.f7057a.c(this.f7058b, this.f7059c);
            if (!this.f7060d) {
                return null;
            }
            this.f7061e.g(this.f7059c);
            return null;
        }
    }

    private c(m mVar) {
        this.f7056a = mVar;
    }

    public static c a() {
        c cVar = (c) o3.c.h().f(c.class);
        Objects.requireNonNull(cVar, "FirebaseCrashlytics component is not present.");
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [t3.d, t3.b] */
    /* JADX WARN: Type inference failed for: r1v8, types: [t3.e] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.firebase.crashlytics.a] */
    /* JADX WARN: Type inference failed for: r6v2, types: [t3.c, t3.b] */
    public static c b(o3.c cVar, g gVar, s3.a aVar, p3.a aVar2) {
        f fVar;
        u3.c cVar2;
        Context g10 = cVar.g();
        x xVar = new x(g10, g10.getPackageName(), gVar);
        s sVar = new s(cVar);
        s3.a cVar3 = aVar == null ? new s3.c() : aVar;
        e eVar = new e(cVar, g10, xVar, sVar);
        if (aVar2 != null) {
            s3.b.f().b("Firebase Analytics is available.");
            ?? eVar2 = new t3.e(aVar2);
            ?? aVar3 = new com.google.firebase.crashlytics.a();
            if (d(aVar2, aVar3) != null) {
                s3.b.f().b("Firebase Analytics listener registered successfully.");
                ?? dVar = new t3.d();
                ?? cVar4 = new t3.c(eVar2, 500, TimeUnit.MILLISECONDS);
                aVar3.d(dVar);
                aVar3.e(cVar4);
                fVar = cVar4;
                cVar2 = dVar;
            } else {
                s3.b.f().b("Firebase Analytics listener registration failed.");
                cVar2 = new u3.c();
                fVar = eVar2;
            }
        } else {
            s3.b.f().b("Firebase Analytics is unavailable.");
            cVar2 = new u3.c();
            fVar = new f();
        }
        m mVar = new m(cVar, xVar, cVar3, sVar, cVar2, fVar, v.c("Crashlytics Exception Handler"));
        if (!eVar.h()) {
            s3.b.f().d("Unable to start Crashlytics.");
            return null;
        }
        ExecutorService c10 = v.c("com.google.firebase.crashlytics.startup");
        d l10 = eVar.l(g10, cVar, c10);
        o.c(c10, new a(eVar, c10, l10, mVar.n(l10), mVar));
        return new c(mVar);
    }

    private static a.InterfaceC0268a d(p3.a aVar, com.google.firebase.crashlytics.a aVar2) {
        a.InterfaceC0268a a10 = aVar.a("clx", aVar2);
        if (a10 == null) {
            s3.b.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            a10 = aVar.a("crash", aVar2);
            if (a10 != null) {
                s3.b.f().i("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return a10;
    }

    public void c(String str) {
        this.f7056a.o(str);
    }
}
