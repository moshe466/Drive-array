package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import w3.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final o f7088a;

    /* renamed from: b, reason: collision with root package name */
    private final z3.g f7089b;

    /* renamed from: c, reason: collision with root package name */
    private final e4.c f7090c;

    /* renamed from: d, reason: collision with root package name */
    private final v3.b f7091d;

    /* renamed from: e, reason: collision with root package name */
    private final i0 f7092e;

    g0(o oVar, z3.g gVar, e4.c cVar, v3.b bVar, i0 i0Var) {
        this.f7088a = oVar;
        this.f7089b = gVar;
        this.f7090c = cVar;
        this.f7091d = bVar;
        this.f7092e = i0Var;
    }

    public static g0 b(Context context, x xVar, z3.h hVar, b bVar, v3.b bVar2, i0 i0Var, i4.d dVar, f4.e eVar) {
        return new g0(new o(context, xVar, bVar, dVar), new z3.g(new File(hVar.a()), eVar), e4.c.a(context), bVar2, i0Var);
    }

    private static List<v.b> e(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(v.b.a().b(entry.getKey()).c(entry.getValue()).a());
        }
        Collections.sort(arrayList, f0.a());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(z2.l<p> lVar) {
        if (!lVar.p()) {
            s3.b.f().c("Crashlytics report could not be enqueued to DataTransport", lVar.k());
            return false;
        }
        p l10 = lVar.l();
        s3.b.f().b("Crashlytics report successfully enqueued to DataTransport: " + l10.c());
        this.f7089b.h(l10.c());
        return true;
    }

    private void i(Throwable th, Thread thread, String str, String str2, long j10, boolean z10) {
        boolean equals = str2.equals("crash");
        v.d.AbstractC0312d b10 = this.f7088a.b(th, thread, str2, j10, 4, 8, z10);
        v.d.AbstractC0312d.b g10 = b10.g();
        String d10 = this.f7091d.d();
        if (d10 != null) {
            g10.d(v.d.AbstractC0312d.AbstractC0323d.a().b(d10).a());
        } else {
            s3.b.f().b("No log data to include with this event.");
        }
        List<v.b> e10 = e(this.f7092e.a());
        if (!e10.isEmpty()) {
            g10.b(b10.b().f().c(w3.w.c(e10)).a());
        }
        this.f7089b.A(g10.a(), str, equals);
    }

    public void c(String str, List<b0> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<b0> it = list.iterator();
        while (it.hasNext()) {
            v.c.b c10 = it.next().c();
            if (c10 != null) {
                arrayList.add(c10);
            }
        }
        this.f7089b.j(str, v.c.a().b(w3.w.c(arrayList)).a());
    }

    public void d(long j10, String str) {
        this.f7089b.i(str, j10);
    }

    public void g(String str, long j10) {
        this.f7089b.B(this.f7088a.c(str, j10));
    }

    public void j(Throwable th, Thread thread, String str, long j10) {
        s3.b.f().b("Persisting fatal event for session " + str);
        i(th, thread, str, "crash", j10, true);
    }

    public void k(String str) {
        String b10 = this.f7092e.b();
        if (b10 == null) {
            s3.b.f().b("Could not persist user ID; no user ID available");
        } else {
            this.f7089b.C(b10, str);
        }
    }

    public void l() {
        this.f7089b.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z2.l<Void> m(Executor executor, t tVar) {
        if (tVar == t.NONE) {
            s3.b.f().b("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f7089b.g();
            return z2.o.e(null);
        }
        List<p> x10 = this.f7089b.x();
        ArrayList arrayList = new ArrayList();
        for (p pVar : x10) {
            if (pVar.b().k() != v.e.NATIVE || tVar == t.ALL) {
                arrayList.add(this.f7090c.e(pVar).h(executor, e0.b(this)));
            } else {
                s3.b.f().b("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f7089b.h(pVar.c());
            }
        }
        return z2.o.f(arrayList);
    }
}
