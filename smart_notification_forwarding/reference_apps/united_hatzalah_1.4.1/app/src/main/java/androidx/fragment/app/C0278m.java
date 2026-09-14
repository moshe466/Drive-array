package androidx.fragment.app;

import F0.C0068p;
import F0.C0084t0;
import a.AbstractC0228a;
import android.view.ViewGroup;
import e1.C0360a;
import e1.C0362c;
import e1.C0363d;
import i1.AbstractC0449a;
import s2.C0680e;
import s2.C0681f;
import s2.C0682g;
import s2.C0684i;

/* renamed from: androidx.fragment.app.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0278m extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3436a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3437b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3438c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3439d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0278m(C0084t0 c0084t0, C0068p c0068p, C0068p c0068p2) {
        super(0);
        androidx.lifecycle.N n4 = c1.b.f3867a;
        this.f3437b = c0084t0;
        this.f3438c = c0068p;
        this.f3439d = c0068p2;
    }

    @Override // F2.a
    public final Object invoke() {
        Object g3;
        int i = this.f3436a;
        C0684i c0684i = C0684i.f6340a;
        Object obj = this.f3439d;
        Object obj2 = this.f3438c;
        Object obj3 = this.f3437b;
        switch (i) {
            case 0:
                ((C0279n) obj3).f3457f.c((ViewGroup) obj2, obj);
                return c0684i;
            default:
                Object obj4 = ((C0681f) ((C0682g) ((C0084t0) obj3).f664b).a()).f6335a;
                if (!(obj4 instanceof C0680e)) {
                    androidx.lifecycle.N n4 = c1.b.f3867a;
                    R1.n nVar = ((c1.g) obj4).f3880b;
                    try {
                        g3 = new c1.a(nVar.e().r(), ((C0362c) ((C0682g) nVar.f2005d).a()).f4451j, ((C0360a) ((C0682g) nVar.f2006e).a()).f4448j, ((C0363d) ((C0682g) nVar.f2007f).a()).f4452j);
                    } catch (Throwable th) {
                        g3 = AbstractC0228a.g(th);
                    }
                    obj4 = new C0681f(g3);
                }
                Object n5 = m3.b.n(obj4);
                C0068p c0068p = (C0068p) obj2;
                Throwable a2 = C0681f.a(n5);
                if (a2 == null) {
                    c0068p.invoke(n5);
                } else {
                    ((C0068p) obj).invoke(AbstractC0449a.f4971a);
                    E1.b.l(a2);
                }
                return c0684i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0278m(C0279n c0279n, ViewGroup viewGroup, Object obj) {
        super(0);
        this.f3437b = c0279n;
        this.f3438c = viewGroup;
        this.f3439d = obj;
    }
}
