package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.w;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f3090a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final w f3091b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final w.k f3092a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f3093b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(w wVar) {
        this.f3091b = wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z10) {
        this.f3091b.u0().j();
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().b(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().d(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().e(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().f(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z10) {
        this.f3091b.u0().j();
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().g(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().i(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().k(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().l(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3091b.x0();
        if (x02 != null) {
            x02.S().w0().n(fragment, true);
        }
        Iterator<a> it = this.f3090a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3093b) {
                w.k kVar = next.f3092a;
                throw null;
            }
        }
    }
}
