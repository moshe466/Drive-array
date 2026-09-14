package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC0057b f3517a;

    /* renamed from: b, reason: collision with root package name */
    final a f3518b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List<View> f3519c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f3520a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f3521b;

        a() {
        }

        private void c() {
            if (this.f3521b == null) {
                this.f3521b = new a();
            }
        }

        void a(int i10) {
            if (i10 < 64) {
                this.f3520a &= ~(1 << i10);
                return;
            }
            a aVar = this.f3521b;
            if (aVar != null) {
                aVar.a(i10 - 64);
            }
        }

        int b(int i10) {
            a aVar = this.f3521b;
            return aVar == null ? i10 >= 64 ? Long.bitCount(this.f3520a) : Long.bitCount(this.f3520a & ((1 << i10) - 1)) : i10 < 64 ? Long.bitCount(this.f3520a & ((1 << i10) - 1)) : aVar.b(i10 - 64) + Long.bitCount(this.f3520a);
        }

        boolean d(int i10) {
            if (i10 < 64) {
                return (this.f3520a & (1 << i10)) != 0;
            }
            c();
            return this.f3521b.d(i10 - 64);
        }

        void e(int i10, boolean z10) {
            if (i10 >= 64) {
                c();
                this.f3521b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f3520a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f3520a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f3521b != null) {
                c();
                this.f3521b.e(0, z11);
            }
        }

        boolean f(int i10) {
            if (i10 >= 64) {
                c();
                return this.f3521b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f3520a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.f3520a = j12;
            long j13 = j10 - 1;
            this.f3520a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f3521b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f3521b.f(0);
            }
            return z10;
        }

        void g() {
            this.f3520a = 0L;
            a aVar = this.f3521b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i10) {
            if (i10 < 64) {
                this.f3520a |= 1 << i10;
            } else {
                c();
                this.f3521b.h(i10 - 64);
            }
        }

        public String toString() {
            if (this.f3521b == null) {
                return Long.toBinaryString(this.f3520a);
            }
            return this.f3521b.toString() + "xx" + Long.toBinaryString(this.f3520a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057b {
        View a(int i10);

        void b(View view);

        RecyclerView.d0 c(View view);

        void d(int i10);

        void e(View view);

        void f(View view, int i10);

        int g();

        void h(int i10);

        void i();

        void j(View view, int i10, ViewGroup.LayoutParams layoutParams);

        int k(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InterfaceC0057b interfaceC0057b) {
        this.f3517a = interfaceC0057b;
    }

    private int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int g10 = this.f3517a.g();
        int i11 = i10;
        while (i11 < g10) {
            int b10 = i10 - (i11 - this.f3518b.b(i11));
            if (b10 == 0) {
                while (this.f3518b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += b10;
        }
        return -1;
    }

    private void l(View view) {
        this.f3519c.add(view);
        this.f3517a.b(view);
    }

    private boolean t(View view) {
        if (!this.f3519c.remove(view)) {
            return false;
        }
        this.f3517a.e(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i10, boolean z10) {
        int g10 = i10 < 0 ? this.f3517a.g() : h(i10);
        this.f3518b.e(g10, z10);
        if (z10) {
            l(view);
        }
        this.f3517a.f(view, g10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int g10 = i10 < 0 ? this.f3517a.g() : h(i10);
        this.f3518b.e(g10, z10);
        if (z10) {
            l(view);
        }
        this.f3517a.j(view, g10, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i10) {
        int h10 = h(i10);
        this.f3518b.f(h10);
        this.f3517a.d(h10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i10) {
        int size = this.f3519c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f3519c.get(i11);
            RecyclerView.d0 c10 = this.f3517a.c(view);
            if (c10.m() == i10 && !c10.s() && !c10.u()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i10) {
        return this.f3517a.a(h(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f3517a.g() - this.f3519c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i10) {
        return this.f3517a.a(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f3517a.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int k10 = this.f3517a.k(view);
        if (k10 >= 0) {
            this.f3518b.h(k10);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int k10 = this.f3517a.k(view);
        if (k10 == -1 || this.f3518b.d(k10)) {
            return -1;
        }
        return k10 - this.f3518b.b(k10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f3519c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f3518b.g();
        for (int size = this.f3519c.size() - 1; size >= 0; size--) {
            this.f3517a.e(this.f3519c.get(size));
            this.f3519c.remove(size);
        }
        this.f3517a.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int k10 = this.f3517a.k(view);
        if (k10 < 0) {
            return;
        }
        if (this.f3518b.f(k10)) {
            t(view);
        }
        this.f3517a.h(k10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i10) {
        int h10 = h(i10);
        View a10 = this.f3517a.a(h10);
        if (a10 == null) {
            return;
        }
        if (this.f3518b.f(h10)) {
            t(a10);
        }
        this.f3517a.h(h10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int k10 = this.f3517a.k(view);
        if (k10 == -1) {
            t(view);
            return true;
        }
        if (!this.f3518b.d(k10)) {
            return false;
        }
        this.f3518b.f(k10);
        t(view);
        this.f3517a.h(k10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int k10 = this.f3517a.k(view);
        if (k10 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f3518b.d(k10)) {
            this.f3518b.a(k10);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f3518b.toString() + ", hidden list:" + this.f3519c.size();
    }
}
