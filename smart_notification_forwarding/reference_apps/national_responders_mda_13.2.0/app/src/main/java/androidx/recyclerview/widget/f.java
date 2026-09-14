package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class f {

    /* renamed from: b, reason: collision with root package name */
    int f3620b;

    /* renamed from: c, reason: collision with root package name */
    int f3621c;

    /* renamed from: d, reason: collision with root package name */
    int f3622d;

    /* renamed from: e, reason: collision with root package name */
    int f3623e;

    /* renamed from: h, reason: collision with root package name */
    boolean f3626h;

    /* renamed from: i, reason: collision with root package name */
    boolean f3627i;

    /* renamed from: a, reason: collision with root package name */
    boolean f3619a = true;

    /* renamed from: f, reason: collision with root package name */
    int f3624f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f3625g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.a0 a0Var) {
        int i10 = this.f3621c;
        return i10 >= 0 && i10 < a0Var.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.v vVar) {
        View o10 = vVar.o(this.f3621c);
        this.f3621c += this.f3622d;
        return o10;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3620b + ", mCurrentPosition=" + this.f3621c + ", mItemDirection=" + this.f3622d + ", mLayoutDirection=" + this.f3623e + ", mStartLine=" + this.f3624f + ", mEndLine=" + this.f3625g + '}';
    }
}
