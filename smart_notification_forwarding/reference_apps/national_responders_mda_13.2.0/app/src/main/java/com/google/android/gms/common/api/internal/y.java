package com.google.android.gms.common.api.internal;

import a2.a;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class y implements v1 {

    /* renamed from: a */
    private final Context f5043a;

    /* renamed from: b */
    private final z0 f5044b;

    /* renamed from: c */
    private final d1 f5045c;

    /* renamed from: d */
    private final d1 f5046d;

    /* renamed from: e */
    private final Map f5047e;

    /* renamed from: g */
    private final a.f f5049g;

    /* renamed from: h */
    private Bundle f5050h;

    /* renamed from: l */
    private final Lock f5054l;

    /* renamed from: f */
    private final Set f5048f = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: i */
    private com.google.android.gms.common.a f5051i = null;

    /* renamed from: j */
    private com.google.android.gms.common.a f5052j = null;

    /* renamed from: k */
    private boolean f5053k = false;

    /* renamed from: m */
    private int f5055m = 0;

    private y(Context context, z0 z0Var, Lock lock, Looper looper, com.google.android.gms.common.c cVar, Map map, Map map2, b2.e eVar, a.AbstractC0006a abstractC0006a, a.f fVar, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.f5043a = context;
        this.f5044b = z0Var;
        this.f5054l = lock;
        this.f5049g = fVar;
        this.f5045c = new d1(context, z0Var, lock, looper, cVar, map2, null, map4, null, arrayList2, new n3(this, null));
        this.f5046d = new d1(context, z0Var, lock, looper, cVar, map, eVar, map3, abstractC0006a, arrayList, new p3(this, null));
        l.a aVar = new l.a();
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            aVar.put((a.c) it.next(), this.f5045c);
        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            aVar.put((a.c) it2.next(), this.f5046d);
        }
        this.f5047e = Collections.unmodifiableMap(aVar);
    }

    private final void g(com.google.android.gms.common.a aVar) {
        int i10 = this.f5055m;
        if (i10 != 1) {
            if (i10 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f5055m = 0;
            }
            this.f5044b.c(aVar);
        }
        h();
        this.f5055m = 0;
    }

    private final void h() {
        Iterator it = this.f5048f.iterator();
        while (it.hasNext()) {
            ((s) it.next()).b();
        }
        this.f5048f.clear();
    }

    private final boolean i() {
        com.google.android.gms.common.a aVar = this.f5052j;
        return aVar != null && aVar.g() == 4;
    }

    private final boolean j(d dVar) {
        d1 d1Var = (d1) this.f5047e.get(dVar.r());
        b2.p.l(d1Var, "GoogleApiClient is not configured to use the API required for this call.");
        return d1Var.equals(this.f5046d);
    }

    private static boolean k(com.google.android.gms.common.a aVar) {
        return aVar != null && aVar.t();
    }

    public static y m(Context context, z0 z0Var, Lock lock, Looper looper, com.google.android.gms.common.c cVar, Map map, b2.e eVar, Map map2, a.AbstractC0006a abstractC0006a, ArrayList arrayList) {
        l.a aVar = new l.a();
        l.a aVar2 = new l.a();
        a.f fVar = null;
        for (Map.Entry entry : map.entrySet()) {
            a.f fVar2 = (a.f) entry.getValue();
            if (true == fVar2.b()) {
                fVar = fVar2;
            }
            boolean r10 = fVar2.r();
            a.c cVar2 = (a.c) entry.getKey();
            if (r10) {
                aVar.put(cVar2, fVar2);
            } else {
                aVar2.put(cVar2, fVar2);
            }
        }
        b2.p.o(!aVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        l.a aVar3 = new l.a();
        l.a aVar4 = new l.a();
        for (a2.a aVar5 : map2.keySet()) {
            a.c b10 = aVar5.b();
            if (aVar.containsKey(b10)) {
                aVar3.put(aVar5, (Boolean) map2.get(aVar5));
            } else {
                if (!aVar2.containsKey(b10)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                aVar4.put(aVar5, (Boolean) map2.get(aVar5));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            k3 k3Var = (k3) arrayList.get(i10);
            if (aVar3.containsKey(k3Var.f4890a)) {
                arrayList2.add(k3Var);
            } else {
                if (!aVar4.containsKey(k3Var.f4890a)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(k3Var);
            }
        }
        return new y(context, z0Var, lock, looper, cVar, aVar, aVar2, eVar, abstractC0006a, fVar, arrayList2, arrayList3, aVar3, aVar4);
    }

    public static /* bridge */ /* synthetic */ void t(y yVar, int i10, boolean z10) {
        yVar.f5044b.b(i10, z10);
        yVar.f5052j = null;
        yVar.f5051i = null;
    }

    public static /* bridge */ /* synthetic */ void u(y yVar, Bundle bundle) {
        Bundle bundle2 = yVar.f5050h;
        if (bundle2 == null) {
            yVar.f5050h = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public static /* bridge */ /* synthetic */ void v(y yVar) {
        com.google.android.gms.common.a aVar;
        if (!k(yVar.f5051i)) {
            if (yVar.f5051i != null && k(yVar.f5052j)) {
                yVar.f5046d.c();
                yVar.g((com.google.android.gms.common.a) b2.p.k(yVar.f5051i));
                return;
            }
            com.google.android.gms.common.a aVar2 = yVar.f5051i;
            if (aVar2 == null || (aVar = yVar.f5052j) == null) {
                return;
            }
            if (yVar.f5046d.f4823l < yVar.f5045c.f4823l) {
                aVar2 = aVar;
            }
            yVar.g(aVar2);
            return;
        }
        if (!k(yVar.f5052j) && !yVar.i()) {
            com.google.android.gms.common.a aVar3 = yVar.f5052j;
            if (aVar3 != null) {
                if (yVar.f5055m == 1) {
                    yVar.h();
                    return;
                } else {
                    yVar.g(aVar3);
                    yVar.f5045c.c();
                    return;
                }
            }
            return;
        }
        int i10 = yVar.f5055m;
        if (i10 != 1) {
            if (i10 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                yVar.f5055m = 0;
            }
            ((z0) b2.p.k(yVar.f5044b)).a(yVar.f5050h);
        }
        yVar.h();
        yVar.f5055m = 0;
    }

    private final PendingIntent x() {
        if (this.f5049g == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f5043a, System.identityHashCode(this.f5044b), this.f5049g.q(), m2.i.f12014a | 134217728);
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final void a() {
        this.f5045c.a();
        this.f5046d.a();
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final void b() {
        this.f5055m = 2;
        this.f5053k = false;
        this.f5052j = null;
        this.f5051i = null;
        this.f5045c.b();
        this.f5046d.b();
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final void c() {
        this.f5052j = null;
        this.f5051i = null;
        this.f5055m = 0;
        this.f5045c.c();
        this.f5046d.c();
        h();
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f5046d.d(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f5045c.d(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r3.f5055m == 1) goto L30;
     */
    @Override // com.google.android.gms.common.api.internal.v1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.f5054l
            r0.lock()
            com.google.android.gms.common.api.internal.d1 r0 = r3.f5045c     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.e()     // Catch: java.lang.Throwable -> L28
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L22
            com.google.android.gms.common.api.internal.d1 r0 = r3.f5046d     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.e()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L21
            boolean r0 = r3.i()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L21
            int r0 = r3.f5055m     // Catch: java.lang.Throwable -> L28
            if (r0 != r2) goto L22
        L21:
            r1 = 1
        L22:
            java.util.concurrent.locks.Lock r0 = r3.f5054l
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r3.f5054l
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.y.e():boolean");
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final d f(d dVar) {
        if (!j(dVar)) {
            return this.f5045c.f(dVar);
        }
        if (!i()) {
            return this.f5046d.f(dVar);
        }
        dVar.v(new Status(4, (String) null, x()));
        return dVar;
    }
}
