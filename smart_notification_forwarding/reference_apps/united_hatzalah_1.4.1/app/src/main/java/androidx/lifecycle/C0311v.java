package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import l0.C0511a;
import n.C0590a;
import o.C0596a;

/* renamed from: androidx.lifecycle.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0311v extends AbstractC0305o {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3616a;

    /* renamed from: b, reason: collision with root package name */
    public C0596a f3617b;

    /* renamed from: c, reason: collision with root package name */
    public EnumC0304n f3618c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f3619d;

    /* renamed from: e, reason: collision with root package name */
    public int f3620e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3621f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3622g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3623h;
    public final S2.y i;

    public C0311v(InterfaceC0309t interfaceC0309t) {
        new AtomicReference(null);
        this.f3616a = true;
        this.f3617b = new C0596a();
        EnumC0304n enumC0304n = EnumC0304n.f3608b;
        this.f3618c = enumC0304n;
        this.f3623h = new ArrayList();
        this.f3619d = new WeakReference(interfaceC0309t);
        this.i = new S2.y(enumC0304n);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.lifecycle.u, java.lang.Object] */
    @Override // androidx.lifecycle.AbstractC0305o
    public final void a(InterfaceC0308s observer) {
        r c0296f;
        Object obj;
        InterfaceC0309t interfaceC0309t;
        EnumC0303m enumC0303m;
        kotlin.jvm.internal.j.e(observer, "observer");
        d("addObserver");
        EnumC0304n enumC0304n = this.f3618c;
        EnumC0304n enumC0304n2 = EnumC0304n.f3607a;
        if (enumC0304n != enumC0304n2) {
            enumC0304n2 = EnumC0304n.f3608b;
        }
        ?? obj2 = new Object();
        HashMap hashMap = AbstractC0312w.f3624a;
        boolean z3 = observer instanceof r;
        boolean z4 = observer instanceof DefaultLifecycleObserver;
        boolean z5 = false;
        int i = 1;
        if (z3 && z4) {
            c0296f = new C0296f((DefaultLifecycleObserver) observer, (r) observer);
        } else if (z4) {
            c0296f = new C0296f((DefaultLifecycleObserver) observer, (r) null);
        } else if (z3) {
            c0296f = (r) observer;
        } else {
            Class<?> cls = observer.getClass();
            if (AbstractC0312w.b(cls) == 2) {
                Object obj3 = AbstractC0312w.f3625b.get(cls);
                kotlin.jvm.internal.j.b(obj3);
                List list = (List) obj3;
                if (list.size() != 1) {
                    int size = list.size();
                    InterfaceC0298h[] interfaceC0298hArr = new InterfaceC0298h[size];
                    if (size <= 0) {
                        c0296f = new C0511a(interfaceC0298hArr, i);
                    } else {
                        AbstractC0312w.a((Constructor) list.get(0), observer);
                        throw null;
                    }
                } else {
                    AbstractC0312w.a((Constructor) list.get(0), observer);
                    throw null;
                }
            } else {
                c0296f = new C0296f(observer);
            }
        }
        obj2.f3615b = c0296f;
        obj2.f3614a = enumC0304n2;
        C0596a c0596a = this.f3617b;
        o.c d2 = c0596a.d(observer);
        if (d2 != null) {
            obj = d2.f5900b;
        } else {
            HashMap hashMap2 = c0596a.f5895e;
            o.c cVar = new o.c(observer, obj2);
            c0596a.f5909d++;
            o.c cVar2 = c0596a.f5907b;
            if (cVar2 == null) {
                c0596a.f5906a = cVar;
                c0596a.f5907b = cVar;
            } else {
                cVar2.f5901c = cVar;
                cVar.f5902d = cVar2;
                c0596a.f5907b = cVar;
            }
            hashMap2.put(observer, cVar);
            obj = null;
        }
        if (((C0310u) obj) != null || (interfaceC0309t = (InterfaceC0309t) this.f3619d.get()) == null) {
            return;
        }
        if (this.f3620e != 0 || this.f3621f) {
            z5 = true;
        }
        EnumC0304n c4 = c(observer);
        this.f3620e++;
        while (obj2.f3614a.compareTo(c4) < 0 && this.f3617b.f5895e.containsKey(observer)) {
            EnumC0304n enumC0304n3 = obj2.f3614a;
            ArrayList arrayList = this.f3623h;
            arrayList.add(enumC0304n3);
            C0301k c0301k = EnumC0303m.Companion;
            EnumC0304n state = obj2.f3614a;
            c0301k.getClass();
            kotlin.jvm.internal.j.e(state, "state");
            int ordinal = state.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        enumC0303m = null;
                    } else {
                        enumC0303m = EnumC0303m.ON_RESUME;
                    }
                } else {
                    enumC0303m = EnumC0303m.ON_START;
                }
            } else {
                enumC0303m = EnumC0303m.ON_CREATE;
            }
            if (enumC0303m != null) {
                obj2.a(interfaceC0309t, enumC0303m);
                arrayList.remove(arrayList.size() - 1);
                c4 = c(observer);
            } else {
                throw new IllegalStateException("no event up from " + obj2.f3614a);
            }
        }
        if (!z5) {
            h();
        }
        this.f3620e--;
    }

    @Override // androidx.lifecycle.AbstractC0305o
    public final void b(InterfaceC0308s observer) {
        kotlin.jvm.internal.j.e(observer, "observer");
        d("removeObserver");
        this.f3617b.g(observer);
    }

    public final EnumC0304n c(InterfaceC0308s interfaceC0308s) {
        o.c cVar;
        EnumC0304n enumC0304n;
        C0310u c0310u;
        HashMap hashMap = this.f3617b.f5895e;
        EnumC0304n enumC0304n2 = null;
        if (hashMap.containsKey(interfaceC0308s)) {
            cVar = ((o.c) hashMap.get(interfaceC0308s)).f5902d;
        } else {
            cVar = null;
        }
        if (cVar != null && (c0310u = (C0310u) cVar.f5900b) != null) {
            enumC0304n = c0310u.f3614a;
        } else {
            enumC0304n = null;
        }
        ArrayList arrayList = this.f3623h;
        if (!arrayList.isEmpty()) {
            enumC0304n2 = (EnumC0304n) arrayList.get(arrayList.size() - 1);
        }
        EnumC0304n state1 = this.f3618c;
        kotlin.jvm.internal.j.e(state1, "state1");
        if (enumC0304n == null || enumC0304n.compareTo(state1) >= 0) {
            enumC0304n = state1;
        }
        if (enumC0304n2 != null && enumC0304n2.compareTo(enumC0304n) < 0) {
            return enumC0304n2;
        }
        return enumC0304n;
    }

    public final void d(String str) {
        if (this.f3616a) {
            C0590a.B().f5875b.getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            } else {
                throw new IllegalStateException(e0.a.e("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void e(EnumC0303m event) {
        kotlin.jvm.internal.j.e(event, "event");
        d("handleLifecycleEvent");
        f(event.a());
    }

    public final void f(EnumC0304n enumC0304n) {
        EnumC0304n enumC0304n2 = this.f3618c;
        if (enumC0304n2 != enumC0304n) {
            EnumC0304n enumC0304n3 = EnumC0304n.f3608b;
            EnumC0304n enumC0304n4 = EnumC0304n.f3607a;
            if (enumC0304n2 == enumC0304n3 && enumC0304n == enumC0304n4) {
                throw new IllegalStateException(("State must be at least CREATED to move to " + enumC0304n + ", but was " + this.f3618c + " in component " + this.f3619d.get()).toString());
            }
            this.f3618c = enumC0304n;
            if (!this.f3621f && this.f3620e == 0) {
                this.f3621f = true;
                h();
                this.f3621f = false;
                if (this.f3618c == enumC0304n4) {
                    this.f3617b = new C0596a();
                    return;
                }
                return;
            }
            this.f3622g = true;
        }
    }

    public final void g() {
        d("setCurrentState");
        f(EnumC0304n.f3609c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        r12.f3622g = false;
        r0 = r12.f3618c;
        r1 = r12.i;
        r1.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        r0 = T2.j.f2291a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        r1.b(null, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.C0311v.h():void");
    }
}
