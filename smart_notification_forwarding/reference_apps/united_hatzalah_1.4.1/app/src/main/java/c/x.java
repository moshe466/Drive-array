package c;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0304n;
import androidx.lifecycle.InterfaceC0309t;
import java.util.Iterator;
import java.util.ListIterator;
import t2.C0704f;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f3856a;

    /* renamed from: b, reason: collision with root package name */
    public final C0704f f3857b = new C0704f();

    /* renamed from: c, reason: collision with root package name */
    public p f3858c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f3859d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f3860e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3861f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3862g;

    public x(Runnable runnable) {
        OnBackInvokedCallback sVar;
        this.f3856a = runnable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                sVar = new t(new q(this, 0), new q(this, 1), new r(this, 0), new r(this, 1));
            } else {
                sVar = new s(new r(this, 2), 0);
            }
            this.f3859d = sVar;
        }
    }

    public final void a(InterfaceC0309t interfaceC0309t, p onBackPressedCallback) {
        kotlin.jvm.internal.j.e(onBackPressedCallback, "onBackPressedCallback");
        AbstractC0305o lifecycle = interfaceC0309t.getLifecycle();
        if (((C0311v) lifecycle).f3618c == EnumC0304n.f3607a) {
            return;
        }
        onBackPressedCallback.addCancellable(new u(this, lifecycle, onBackPressedCallback));
        e();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new w(0, this, x.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void b() {
        p pVar;
        p pVar2 = this.f3858c;
        if (pVar2 == null) {
            C0704f c0704f = this.f3857b;
            ListIterator listIterator = c0704f.listIterator(c0704f.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    pVar = listIterator.previous();
                    if (((p) pVar).isEnabled()) {
                        break;
                    }
                } else {
                    pVar = 0;
                    break;
                }
            }
            pVar2 = pVar;
        }
        this.f3858c = null;
        if (pVar2 != null) {
            pVar2.handleOnBackCancelled();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void c() {
        p pVar;
        p pVar2 = this.f3858c;
        if (pVar2 == null) {
            C0704f c0704f = this.f3857b;
            ListIterator listIterator = c0704f.listIterator(c0704f.g());
            while (true) {
                if (listIterator.hasPrevious()) {
                    pVar = listIterator.previous();
                    if (((p) pVar).isEnabled()) {
                        break;
                    }
                } else {
                    pVar = 0;
                    break;
                }
            }
            pVar2 = pVar;
        }
        this.f3858c = null;
        if (pVar2 != null) {
            pVar2.handleOnBackPressed();
        } else {
            this.f3856a.run();
        }
    }

    public final void d(boolean z3) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f3860e;
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f3859d) != null) {
            if (z3 && !this.f3861f) {
                F.b.e(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f3861f = true;
            } else if (!z3 && this.f3861f) {
                F.b.f(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f3861f = false;
            }
        }
    }

    public final void e() {
        boolean z3 = this.f3862g;
        boolean z4 = false;
        C0704f c0704f = this.f3857b;
        if (c0704f == null || !c0704f.isEmpty()) {
            Iterator it = c0704f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((p) it.next()).isEnabled()) {
                    z4 = true;
                    break;
                }
            }
        }
        this.f3862g = z4;
        if (z4 != z3 && Build.VERSION.SDK_INT >= 33) {
            d(z4);
        }
    }
}
