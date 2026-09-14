package k0;

import J.S;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* renamed from: k0.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0474E implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f5169a;

    /* renamed from: b, reason: collision with root package name */
    public int f5170b;

    /* renamed from: c, reason: collision with root package name */
    public OverScroller f5171c;

    /* renamed from: d, reason: collision with root package name */
    public Interpolator f5172d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5173e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5174f;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f5175j;

    public RunnableC0474E(RecyclerView recyclerView) {
        this.f5175j = recyclerView;
        o oVar = RecyclerView.f3674n0;
        this.f5172d = oVar;
        this.f5173e = false;
        this.f5174f = false;
        this.f5171c = new OverScroller(recyclerView.getContext(), oVar);
    }

    public final void a() {
        if (this.f5173e) {
            this.f5174f = true;
            return;
        }
        RecyclerView recyclerView = this.f5175j;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = S.f954a;
        recyclerView.postOnAnimation(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i3;
        boolean awakenScrollBars;
        boolean z3;
        boolean z4;
        boolean z5;
        RecyclerView recyclerView = this.f5175j;
        if (recyclerView.f3716l == null) {
            recyclerView.removeCallbacks(this);
            this.f5171c.abortAnimation();
            return;
        }
        this.f5174f = false;
        this.f5173e = true;
        recyclerView.d();
        OverScroller overScroller = this.f5171c;
        recyclerView.f3716l.getClass();
        if (overScroller.computeScrollOffset()) {
            int[] iArr = recyclerView.f3710g0;
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i4 = currX - this.f5169a;
            int i5 = currY - this.f5170b;
            this.f5169a = currX;
            this.f5170b = currY;
            if (recyclerView.f(i4, i5, iArr, null, 1)) {
                i = i4 - iArr[0];
                i3 = i5 - iArr[1];
            } else {
                i = i4;
                i3 = i5;
            }
            if (!recyclerView.f3717m.isEmpty()) {
                recyclerView.invalidate();
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.c(i, i3);
            }
            recyclerView.g(0, 0, 0, 0, null, 1);
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            if (i3 != 0 && recyclerView.f3716l.c() && i3 == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (i != 0 && recyclerView.f3716l.b() && i == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((i != 0 || i3 != 0) && !z4 && !z3) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (!overScroller.isFinished() && (z5 || recyclerView.k(1))) {
                a();
                RunnableC0485i runnableC0485i = recyclerView.f3696V;
                if (runnableC0485i != null) {
                    runnableC0485i.a(recyclerView, i, i3);
                }
            } else {
                recyclerView.setScrollState(0);
                C0483g c0483g = recyclerView.f3697W;
                c0483g.getClass();
                c0483g.f5241c = 0;
                recyclerView.s(1);
            }
        }
        this.f5173e = false;
        if (this.f5174f) {
            a();
        }
    }
}
