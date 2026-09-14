package com.google.android.gms.common.api.internal;

import a2.a;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class d1 implements v1, l3 {

    /* renamed from: a, reason: collision with root package name */
    private final Lock f4812a;

    /* renamed from: b, reason: collision with root package name */
    private final Condition f4813b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f4814c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.gms.common.c f4815d;

    /* renamed from: e, reason: collision with root package name */
    private final c1 f4816e;

    /* renamed from: f, reason: collision with root package name */
    final Map f4817f;

    /* renamed from: g, reason: collision with root package name */
    final Map f4818g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    final b2.e f4819h;

    /* renamed from: i, reason: collision with root package name */
    final Map f4820i;

    /* renamed from: j, reason: collision with root package name */
    final a.AbstractC0006a f4821j;

    /* renamed from: k, reason: collision with root package name */
    private volatile a1 f4822k;

    /* renamed from: l, reason: collision with root package name */
    int f4823l;

    /* renamed from: m, reason: collision with root package name */
    final z0 f4824m;

    /* renamed from: n, reason: collision with root package name */
    final t1 f4825n;

    public d1(Context context, z0 z0Var, Lock lock, Looper looper, com.google.android.gms.common.c cVar, Map map, b2.e eVar, Map map2, a.AbstractC0006a abstractC0006a, ArrayList arrayList, t1 t1Var) {
        this.f4814c = context;
        this.f4812a = lock;
        this.f4815d = cVar;
        this.f4817f = map;
        this.f4819h = eVar;
        this.f4820i = map2;
        this.f4821j = abstractC0006a;
        this.f4824m = z0Var;
        this.f4825n = t1Var;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((k3) arrayList.get(i10)).a(this);
        }
        this.f4816e = new c1(this, looper);
        this.f4813b = lock.newCondition();
        this.f4822k = new v0(this);
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final void a() {
        if (this.f4822k instanceof h0) {
            ((h0) this.f4822k).i();
        }
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final void b() {
        this.f4822k.e();
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final void c() {
        if (this.f4822k.f()) {
            this.f4818g.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f4822k);
        for (a2.a aVar : this.f4820i.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) aVar.d()).println(":");
            ((a.f) b2.p.k((a.f) this.f4817f.get(aVar.b()))).e(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final boolean e() {
        return this.f4822k instanceof h0;
    }

    @Override // com.google.android.gms.common.api.internal.v1
    public final d f(d dVar) {
        dVar.l();
        return this.f4822k.g(dVar);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i(int i10) {
        this.f4812a.lock();
        try {
            this.f4822k.b(i10);
        } finally {
            this.f4812a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        this.f4812a.lock();
        try {
            this.f4824m.s();
            this.f4822k = new h0(this);
            this.f4822k.c();
            this.f4813b.signalAll();
        } finally {
            this.f4812a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k() {
        this.f4812a.lock();
        try {
            this.f4822k = new u0(this, this.f4819h, this.f4820i, this.f4815d, this.f4821j, this.f4812a, this.f4814c);
            this.f4822k.c();
            this.f4813b.signalAll();
        } finally {
            this.f4812a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(com.google.android.gms.common.a aVar) {
        this.f4812a.lock();
        try {
            this.f4822k = new v0(this);
            this.f4822k.c();
            this.f4813b.signalAll();
        } finally {
            this.f4812a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(b1 b1Var) {
        this.f4816e.sendMessage(this.f4816e.obtainMessage(1, b1Var));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(RuntimeException runtimeException) {
        this.f4816e.sendMessage(this.f4816e.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void p(Bundle bundle) {
        this.f4812a.lock();
        try {
            this.f4822k.a(bundle);
        } finally {
            this.f4812a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.l3
    public final void z(com.google.android.gms.common.a aVar, a2.a aVar2, boolean z10) {
        this.f4812a.lock();
        try {
            this.f4822k.d(aVar, aVar2, z10);
        } finally {
            this.f4812a.unlock();
        }
    }
}
