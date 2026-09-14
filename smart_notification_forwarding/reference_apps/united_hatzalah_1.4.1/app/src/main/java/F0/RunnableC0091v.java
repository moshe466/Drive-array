package F0;

import P2.C0143b0;
import P2.C0163m;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import java.lang.reflect.Method;
import q.C0601A;
import s2.C0684i;
import w2.C0769j;

/* renamed from: F0.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0091v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f689a;

    /* renamed from: b, reason: collision with root package name */
    public Object f690b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f691c;

    public /* synthetic */ RunnableC0091v(int i, Object obj, Object obj2) {
        this.f689a = i;
        this.f690b = obj;
        this.f691c = obj2;
    }

    /* JADX WARN: Type inference failed for: r1v21, types: [q.t, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f689a) {
            case 0:
                r3 r3Var = (r3) this.f690b;
                C0017c0 c0017c0 = r3Var.f628a;
                Context context = (Context) this.f691c;
                c0017c0.a(context);
                r3Var.f629b.B(context);
                r3Var.f631d.Q(context);
                I i = r3Var.f646u;
                if (i != null) {
                    i.b(((KeyguardManager) i.f224c.f218b).isDeviceSecure());
                }
                r3Var.f636j.A(context);
                r3Var.f638l.A(context);
                r3Var.f637k.a(context);
                r3Var.f639m.B(context);
                r3Var.f642q.a(context);
                r3Var.f643r.a(context);
                r3Var.f644s.E(context);
                return;
            case 1:
                G1 g12 = (G1) this.f690b;
                Typeface typeface = (Typeface) this.f691c;
                T0.a aVar = (T0.a) g12.f218b;
                if (aVar != null) {
                    aVar.b(typeface);
                    return;
                }
                return;
            case 2:
                ((G.f) this.f690b).accept(this.f691c);
                return;
            case 3:
                ((C0163m) this.f691c).A((C0143b0) this.f690b, C0684i.f6340a);
                return;
            case 4:
                ((C0163m) this.f690b).A((Q2.e) this.f691c, C0684i.f6340a);
                return;
            case 5:
                U2.h hVar = (U2.h) this.f691c;
                P2.A a2 = hVar.f2355c;
                int i3 = 0;
                while (true) {
                    try {
                        ((Runnable) this.f690b).run();
                    } catch (Throwable th) {
                        P2.G.n(th, C0769j.f6733a);
                    }
                    Runnable f4 = hVar.f();
                    if (f4 != null) {
                        this.f690b = f4;
                        i3++;
                        if (i3 >= 16 && a2.e()) {
                            a2.d(hVar, this);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                break;
            case 6:
                C0601A c0601a = ((q.p) this.f691c).f6036b;
                if (c0601a.f5991c == null) {
                    c0601a.f5991c = new Object();
                }
                c0601a.f5991c.onAuthenticationSucceeded((q.u) this.f690b);
                return;
            case 7:
                ((w.c) this.f690b).f6622a = this.f691c;
                return;
            case 8:
                ((Application) this.f690b).unregisterActivityLifecycleCallbacks((w.c) this.f691c);
                return;
            default:
                Object obj = this.f690b;
                try {
                    Method method = w.d.f6631d;
                    Object obj2 = this.f691c;
                    if (method != null) {
                        method.invoke(obj, obj2, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        w.d.f6632e.invoke(obj, obj2, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e4) {
                    if (e4.getClass() == RuntimeException.class && e4.getMessage() != null && e4.getMessage().startsWith("Unable to stop")) {
                        throw e4;
                    }
                    return;
                } catch (Throwable th2) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
                    return;
                }
        }
    }

    public /* synthetic */ RunnableC0091v(Object obj, Object obj2, int i, boolean z3) {
        this.f689a = i;
        this.f691c = obj;
        this.f690b = obj2;
    }
}
