package com.google.android.gms.common.api.internal;

import a2.a;
import a2.f;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes.dex */
public final class l1 implements f.b, f.c, l3 {

    /* renamed from: b */
    private final a.f f4900b;

    /* renamed from: c */
    private final b f4901c;

    /* renamed from: d */
    private final b0 f4902d;

    /* renamed from: g */
    private final int f4905g;

    /* renamed from: h */
    private final m2 f4906h;

    /* renamed from: i */
    private boolean f4907i;

    /* renamed from: m */
    final /* synthetic */ g f4911m;

    /* renamed from: a */
    private final Queue f4899a = new LinkedList();

    /* renamed from: e */
    private final Set f4903e = new HashSet();

    /* renamed from: f */
    private final Map f4904f = new HashMap();

    /* renamed from: j */
    private final List f4908j = new ArrayList();

    /* renamed from: k */
    private com.google.android.gms.common.a f4909k = null;

    /* renamed from: l */
    private int f4910l = 0;

    public l1(g gVar, a2.e eVar) {
        Handler handler;
        Context context;
        Handler handler2;
        this.f4911m = gVar;
        handler = gVar.f4858p;
        a.f t10 = eVar.t(handler.getLooper(), this);
        this.f4900b = t10;
        this.f4901c = eVar.p();
        this.f4902d = new b0();
        this.f4905g = eVar.s();
        if (!t10.r()) {
            this.f4906h = null;
            return;
        }
        context = gVar.f4849g;
        handler2 = gVar.f4858p;
        this.f4906h = eVar.u(context, handler2);
    }

    public static /* bridge */ /* synthetic */ void C(l1 l1Var, n1 n1Var) {
        if (l1Var.f4908j.contains(n1Var) && !l1Var.f4907i) {
            if (l1Var.f4900b.a()) {
                l1Var.f();
            } else {
                l1Var.F();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void D(l1 l1Var, n1 n1Var) {
        Handler handler;
        Handler handler2;
        z1.c cVar;
        z1.c[] g10;
        if (l1Var.f4908j.remove(n1Var)) {
            handler = l1Var.f4911m.f4858p;
            handler.removeMessages(15, n1Var);
            handler2 = l1Var.f4911m.f4858p;
            handler2.removeMessages(16, n1Var);
            cVar = n1Var.f4936b;
            ArrayList arrayList = new ArrayList(l1Var.f4899a.size());
            for (z2 z2Var : l1Var.f4899a) {
                if ((z2Var instanceof u1) && (g10 = ((u1) z2Var).g(l1Var)) != null && g2.b.c(g10, cVar)) {
                    arrayList.add(z2Var);
                }
            }
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                z2 z2Var2 = (z2) arrayList.get(i10);
                l1Var.f4899a.remove(z2Var2);
                z2Var2.b(new a2.o(cVar));
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean O(l1 l1Var, boolean z10) {
        return l1Var.q(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final z1.c b(z1.c[] cVarArr) {
        if (cVarArr != null && cVarArr.length != 0) {
            z1.c[] j10 = this.f4900b.j();
            if (j10 == null) {
                j10 = new z1.c[0];
            }
            l.a aVar = new l.a(j10.length);
            for (z1.c cVar : j10) {
                aVar.put(cVar.g(), Long.valueOf(cVar.j()));
            }
            for (z1.c cVar2 : cVarArr) {
                Long l10 = (Long) aVar.get(cVar2.g());
                if (l10 == null || l10.longValue() < cVar2.j()) {
                    return cVar2;
                }
            }
        }
        return null;
    }

    private final void c(com.google.android.gms.common.a aVar) {
        Iterator it = this.f4903e.iterator();
        while (it.hasNext()) {
            ((c3) it.next()).b(this.f4901c, aVar, b2.o.a(aVar, com.google.android.gms.common.a.f4739j) ? this.f4900b.k() : null);
        }
        this.f4903e.clear();
    }

    public final void d(Status status) {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        e(status, null, false);
    }

    private final void e(Status status, Exception exc, boolean z10) {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f4899a.iterator();
        while (it.hasNext()) {
            z2 z2Var = (z2) it.next();
            if (!z10 || z2Var.f5089a == 2) {
                if (status != null) {
                    z2Var.a(status);
                } else {
                    z2Var.b(exc);
                }
                it.remove();
            }
        }
    }

    private final void f() {
        ArrayList arrayList = new ArrayList(this.f4899a);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            z2 z2Var = (z2) arrayList.get(i10);
            if (!this.f4900b.a()) {
                return;
            }
            if (m(z2Var)) {
                this.f4899a.remove(z2Var);
            }
        }
    }

    public final void g() {
        E();
        c(com.google.android.gms.common.a.f4739j);
        l();
        Iterator it = this.f4904f.values().iterator();
        while (it.hasNext()) {
            c2 c2Var = (c2) it.next();
            if (b(c2Var.f4800a.c()) == null) {
                try {
                    c2Var.f4800a.d(this.f4900b, new z2.m<>());
                } catch (DeadObjectException unused) {
                    i(3);
                    this.f4900b.f("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                }
            }
            it.remove();
        }
        f();
        j();
    }

    public final void h(int i10) {
        Handler handler;
        Handler handler2;
        long j10;
        Handler handler3;
        Handler handler4;
        long j11;
        b2.j0 j0Var;
        E();
        this.f4907i = true;
        this.f4902d.e(i10, this.f4900b.m());
        g gVar = this.f4911m;
        handler = gVar.f4858p;
        handler2 = gVar.f4858p;
        Message obtain = Message.obtain(handler2, 9, this.f4901c);
        j10 = this.f4911m.f4843a;
        handler.sendMessageDelayed(obtain, j10);
        g gVar2 = this.f4911m;
        handler3 = gVar2.f4858p;
        handler4 = gVar2.f4858p;
        Message obtain2 = Message.obtain(handler4, 11, this.f4901c);
        j11 = this.f4911m.f4844b;
        handler3.sendMessageDelayed(obtain2, j11);
        j0Var = this.f4911m.f4851i;
        j0Var.c();
        Iterator it = this.f4904f.values().iterator();
        while (it.hasNext()) {
            ((c2) it.next()).f4802c.run();
        }
    }

    private final void j() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        long j10;
        handler = this.f4911m.f4858p;
        handler.removeMessages(12, this.f4901c);
        g gVar = this.f4911m;
        handler2 = gVar.f4858p;
        handler3 = gVar.f4858p;
        Message obtainMessage = handler3.obtainMessage(12, this.f4901c);
        j10 = this.f4911m.f4845c;
        handler2.sendMessageDelayed(obtainMessage, j10);
    }

    private final void k(z2 z2Var) {
        z2Var.d(this.f4902d, Q());
        try {
            z2Var.c(this);
        } catch (DeadObjectException unused) {
            i(1);
            this.f4900b.f("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void l() {
        Handler handler;
        Handler handler2;
        if (this.f4907i) {
            handler = this.f4911m.f4858p;
            handler.removeMessages(11, this.f4901c);
            handler2 = this.f4911m.f4858p;
            handler2.removeMessages(9, this.f4901c);
            this.f4907i = false;
        }
    }

    private final boolean m(z2 z2Var) {
        boolean z10;
        Handler handler;
        Handler handler2;
        long j10;
        Handler handler3;
        Handler handler4;
        long j11;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        long j12;
        if (!(z2Var instanceof u1)) {
            k(z2Var);
            return true;
        }
        u1 u1Var = (u1) z2Var;
        z1.c b10 = b(u1Var.g(this));
        if (b10 == null) {
            k(z2Var);
            return true;
        }
        String name = this.f4900b.getClass().getName();
        String g10 = b10.g();
        long j13 = b10.j();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(name);
        sb2.append(" could not execute call because it requires feature (");
        sb2.append(g10);
        sb2.append(", ");
        sb2.append(j13);
        sb2.append(").");
        z10 = this.f4911m.f4859q;
        if (!z10 || !u1Var.f(this)) {
            u1Var.b(new a2.o(b10));
            return true;
        }
        n1 n1Var = new n1(this.f4901c, b10, null);
        int indexOf = this.f4908j.indexOf(n1Var);
        if (indexOf >= 0) {
            n1 n1Var2 = (n1) this.f4908j.get(indexOf);
            handler5 = this.f4911m.f4858p;
            handler5.removeMessages(15, n1Var2);
            g gVar = this.f4911m;
            handler6 = gVar.f4858p;
            handler7 = gVar.f4858p;
            Message obtain = Message.obtain(handler7, 15, n1Var2);
            j12 = this.f4911m.f4843a;
            handler6.sendMessageDelayed(obtain, j12);
            return false;
        }
        this.f4908j.add(n1Var);
        g gVar2 = this.f4911m;
        handler = gVar2.f4858p;
        handler2 = gVar2.f4858p;
        Message obtain2 = Message.obtain(handler2, 15, n1Var);
        j10 = this.f4911m.f4843a;
        handler.sendMessageDelayed(obtain2, j10);
        g gVar3 = this.f4911m;
        handler3 = gVar3.f4858p;
        handler4 = gVar3.f4858p;
        Message obtain3 = Message.obtain(handler4, 16, n1Var);
        j11 = this.f4911m.f4844b;
        handler3.sendMessageDelayed(obtain3, j11);
        com.google.android.gms.common.a aVar = new com.google.android.gms.common.a(2, null);
        if (o(aVar)) {
            return false;
        }
        this.f4911m.g(aVar, this.f4905g);
        return false;
    }

    private final boolean o(com.google.android.gms.common.a aVar) {
        Object obj;
        c0 c0Var;
        Set set;
        c0 c0Var2;
        obj = g.f4841t;
        synchronized (obj) {
            g gVar = this.f4911m;
            c0Var = gVar.f4855m;
            if (c0Var != null) {
                set = gVar.f4856n;
                if (set.contains(this.f4901c)) {
                    c0Var2 = this.f4911m.f4855m;
                    c0Var2.s(aVar, this.f4905g);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean q(boolean z10) {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        if (!this.f4900b.a() || this.f4904f.size() != 0) {
            return false;
        }
        if (!this.f4902d.g()) {
            this.f4900b.f("Timing out service connection.");
            return true;
        }
        if (z10) {
            j();
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ b w(l1 l1Var) {
        return l1Var.f4901c;
    }

    public static /* bridge */ /* synthetic */ void y(l1 l1Var, Status status) {
        l1Var.d(status);
    }

    public final void E() {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        this.f4909k = null;
    }

    public final void F() {
        Handler handler;
        com.google.android.gms.common.a aVar;
        b2.j0 j0Var;
        Context context;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        if (this.f4900b.a() || this.f4900b.i()) {
            return;
        }
        try {
            g gVar = this.f4911m;
            j0Var = gVar.f4851i;
            context = gVar.f4849g;
            int b10 = j0Var.b(context, this.f4900b);
            if (b10 != 0) {
                com.google.android.gms.common.a aVar2 = new com.google.android.gms.common.a(b10, null);
                String name = this.f4900b.getClass().getName();
                String obj = aVar2.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The service for ");
                sb2.append(name);
                sb2.append(" is not available: ");
                sb2.append(obj);
                I(aVar2, null);
                return;
            }
            g gVar2 = this.f4911m;
            a.f fVar = this.f4900b;
            p1 p1Var = new p1(gVar2, fVar, this.f4901c);
            if (fVar.r()) {
                ((m2) b2.p.k(this.f4906h)).A0(p1Var);
            }
            try {
                this.f4900b.t(p1Var);
            } catch (SecurityException e10) {
                e = e10;
                aVar = new com.google.android.gms.common.a(10);
                I(aVar, e);
            }
        } catch (IllegalStateException e11) {
            e = e11;
            aVar = new com.google.android.gms.common.a(10);
        }
    }

    public final void G(z2 z2Var) {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        if (this.f4900b.a()) {
            if (m(z2Var)) {
                j();
                return;
            } else {
                this.f4899a.add(z2Var);
                return;
            }
        }
        this.f4899a.add(z2Var);
        com.google.android.gms.common.a aVar = this.f4909k;
        if (aVar == null || !aVar.s()) {
            F();
        } else {
            I(this.f4909k, null);
        }
    }

    public final void H() {
        this.f4910l++;
    }

    public final void I(com.google.android.gms.common.a aVar, Exception exc) {
        Handler handler;
        b2.j0 j0Var;
        boolean z10;
        Status h10;
        Status h11;
        Status h12;
        Handler handler2;
        Handler handler3;
        long j10;
        Handler handler4;
        Status status;
        Handler handler5;
        Handler handler6;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        m2 m2Var = this.f4906h;
        if (m2Var != null) {
            m2Var.B0();
        }
        E();
        j0Var = this.f4911m.f4851i;
        j0Var.c();
        c(aVar);
        if ((this.f4900b instanceof d2.e) && aVar.g() != 24) {
            this.f4911m.f4846d = true;
            g gVar = this.f4911m;
            handler5 = gVar.f4858p;
            handler6 = gVar.f4858p;
            handler5.sendMessageDelayed(handler6.obtainMessage(19), 300000L);
        }
        if (aVar.g() == 4) {
            status = g.f4840s;
            d(status);
            return;
        }
        if (this.f4899a.isEmpty()) {
            this.f4909k = aVar;
            return;
        }
        if (exc != null) {
            handler4 = this.f4911m.f4858p;
            b2.p.d(handler4);
            e(null, exc, false);
            return;
        }
        z10 = this.f4911m.f4859q;
        if (!z10) {
            h10 = g.h(this.f4901c, aVar);
            d(h10);
            return;
        }
        h11 = g.h(this.f4901c, aVar);
        e(h11, null, true);
        if (this.f4899a.isEmpty() || o(aVar) || this.f4911m.g(aVar, this.f4905g)) {
            return;
        }
        if (aVar.g() == 18) {
            this.f4907i = true;
        }
        if (!this.f4907i) {
            h12 = g.h(this.f4901c, aVar);
            d(h12);
            return;
        }
        g gVar2 = this.f4911m;
        handler2 = gVar2.f4858p;
        handler3 = gVar2.f4858p;
        Message obtain = Message.obtain(handler3, 9, this.f4901c);
        j10 = this.f4911m.f4843a;
        handler2.sendMessageDelayed(obtain, j10);
    }

    public final void J(com.google.android.gms.common.a aVar) {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        a.f fVar = this.f4900b;
        fVar.f("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(aVar));
        I(aVar, null);
    }

    public final void K(c3 c3Var) {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        this.f4903e.add(c3Var);
    }

    public final void L() {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        if (this.f4907i) {
            F();
        }
    }

    public final void M() {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        d(g.f4839r);
        this.f4902d.f();
        for (l.a aVar : (l.a[]) this.f4904f.keySet().toArray(new l.a[0])) {
            G(new y2(aVar, new z2.m()));
        }
        c(new com.google.android.gms.common.a(4));
        if (this.f4900b.a()) {
            this.f4900b.o(new k1(this));
        }
    }

    public final void N() {
        Handler handler;
        com.google.android.gms.common.b bVar;
        Context context;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        if (this.f4907i) {
            l();
            g gVar = this.f4911m;
            bVar = gVar.f4850h;
            context = gVar.f4849g;
            d(bVar.i(context) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f4900b.f("Timing out connection while resuming.");
        }
    }

    public final boolean P() {
        return this.f4900b.a();
    }

    public final boolean Q() {
        return this.f4900b.r();
    }

    public final boolean a() {
        return q(true);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i(int i10) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f4911m.f4858p;
        if (myLooper == handler.getLooper()) {
            h(i10);
        } else {
            handler2 = this.f4911m.f4858p;
            handler2.post(new i1(this, i10));
        }
    }

    @Override // com.google.android.gms.common.api.internal.o
    public final void n(com.google.android.gms.common.a aVar) {
        I(aVar, null);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void p(Bundle bundle) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f4911m.f4858p;
        if (myLooper == handler.getLooper()) {
            g();
        } else {
            handler2 = this.f4911m.f4858p;
            handler2.post(new h1(this));
        }
    }

    public final int r() {
        return this.f4905g;
    }

    public final int s() {
        return this.f4910l;
    }

    public final com.google.android.gms.common.a t() {
        Handler handler;
        handler = this.f4911m.f4858p;
        b2.p.d(handler);
        return this.f4909k;
    }

    public final a.f v() {
        return this.f4900b;
    }

    public final Map x() {
        return this.f4904f;
    }

    @Override // com.google.android.gms.common.api.internal.l3
    public final void z(com.google.android.gms.common.a aVar, a2.a aVar2, boolean z10) {
        throw null;
    }
}
