package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class n extends RecyclerView.r {

    /* renamed from: a, reason: collision with root package name */
    RecyclerView f3643a;

    /* renamed from: b, reason: collision with root package name */
    private Scroller f3644b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView.t f3645c = new a();

    /* loaded from: classes.dex */
    class a extends RecyclerView.t {

        /* renamed from: a, reason: collision with root package name */
        boolean f3646a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
            if (i10 == 0 && this.f3646a) {
                this.f3646a = false;
                n.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            this.f3646a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        protected void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            n nVar = n.this;
            RecyclerView recyclerView = nVar.f3643a;
            if (recyclerView == null) {
                return;
            }
            int[] c10 = nVar.c(recyclerView.getLayoutManager(), view);
            int i10 = c10[0];
            int i11 = c10[1];
            int t10 = t(Math.max(Math.abs(i10), Math.abs(i11)));
            if (t10 > 0) {
                aVar.d(i10, i11, t10, this.f3629j);
            }
        }

        @Override // androidx.recyclerview.widget.g
        protected float s(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    private void g() {
        this.f3643a.a1(this.f3645c);
        this.f3643a.setOnFlingListener(null);
    }

    private void j() {
        if (this.f3643a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f3643a.l(this.f3645c);
        this.f3643a.setOnFlingListener(this);
    }

    private boolean k(RecyclerView.o oVar, int i10, int i11) {
        RecyclerView.z e10;
        int i12;
        if (!(oVar instanceof RecyclerView.z.b) || (e10 = e(oVar)) == null || (i12 = i(oVar, i10, i11)) == -1) {
            return false;
        }
        e10.p(i12);
        oVar.I1(e10);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i10, int i11) {
        RecyclerView.o layoutManager = this.f3643a.getLayoutManager();
        if (layoutManager == null || this.f3643a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f3643a.getMinFlingVelocity();
        return (Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && k(layoutManager, i10, i11);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3643a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            g();
        }
        this.f3643a = recyclerView;
        if (recyclerView != null) {
            j();
            this.f3644b = new Scroller(this.f3643a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public int[] d(int i10, int i11) {
        this.f3644b.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f3644b.getFinalX(), this.f3644b.getFinalY()};
    }

    protected RecyclerView.z e(RecyclerView.o oVar) {
        return f(oVar);
    }

    @Deprecated
    protected g f(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new b(this.f3643a.getContext());
        }
        return null;
    }

    public abstract View h(RecyclerView.o oVar);

    public abstract int i(RecyclerView.o oVar, int i10, int i11);

    void l() {
        RecyclerView.o layoutManager;
        View h10;
        RecyclerView recyclerView = this.f3643a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (h10 = h(layoutManager)) == null) {
            return;
        }
        int[] c10 = c(layoutManager, h10);
        if (c10[0] == 0 && c10[1] == 0) {
            return;
        }
        this.f3643a.m1(c10[0], c10[1]);
    }
}
