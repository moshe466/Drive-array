package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.g0;
import androidx.core.view.h0;
import androidx.core.view.i0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f807c;

    /* renamed from: d, reason: collision with root package name */
    h0 f808d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f809e;

    /* renamed from: b, reason: collision with root package name */
    private long f806b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final i0 f810f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<g0> f805a = new ArrayList<>();

    /* loaded from: classes.dex */
    class a extends i0 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f811a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f812b = 0;

        a() {
        }

        @Override // androidx.core.view.h0
        public void b(View view) {
            int i10 = this.f812b + 1;
            this.f812b = i10;
            if (i10 == h.this.f805a.size()) {
                h0 h0Var = h.this.f808d;
                if (h0Var != null) {
                    h0Var.b(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.i0, androidx.core.view.h0
        public void c(View view) {
            if (this.f811a) {
                return;
            }
            this.f811a = true;
            h0 h0Var = h.this.f808d;
            if (h0Var != null) {
                h0Var.c(null);
            }
        }

        void d() {
            this.f812b = 0;
            this.f811a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f809e) {
            Iterator<g0> it = this.f805a.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f809e = false;
        }
    }

    void b() {
        this.f809e = false;
    }

    public h c(g0 g0Var) {
        if (!this.f809e) {
            this.f805a.add(g0Var);
        }
        return this;
    }

    public h d(g0 g0Var, g0 g0Var2) {
        this.f805a.add(g0Var);
        g0Var2.j(g0Var.d());
        this.f805a.add(g0Var2);
        return this;
    }

    public h e(long j10) {
        if (!this.f809e) {
            this.f806b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f809e) {
            this.f807c = interpolator;
        }
        return this;
    }

    public h g(h0 h0Var) {
        if (!this.f809e) {
            this.f808d = h0Var;
        }
        return this;
    }

    public void h() {
        if (this.f809e) {
            return;
        }
        Iterator<g0> it = this.f805a.iterator();
        while (it.hasNext()) {
            g0 next = it.next();
            long j10 = this.f806b;
            if (j10 >= 0) {
                next.f(j10);
            }
            Interpolator interpolator = this.f807c;
            if (interpolator != null) {
                next.g(interpolator);
            }
            if (this.f808d != null) {
                next.h(this.f810f);
            }
            next.l();
        }
        this.f809e = true;
    }
}
