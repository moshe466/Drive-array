package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class g extends RecyclerView.z {

    /* renamed from: k, reason: collision with root package name */
    private final float f3630k;

    /* renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f3628i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f3629j = new DecelerateInterpolator();

    /* renamed from: l, reason: collision with root package name */
    protected int f3631l = 0;

    /* renamed from: m, reason: collision with root package name */
    protected int f3632m = 0;

    public g(Context context) {
        this.f3630k = s(context.getResources().getDisplayMetrics());
    }

    private int v(int i10, int i11) {
        int i12 = i10 - i11;
        if (i10 * i12 <= 0) {
            return 0;
        }
        return i12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void l(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f3631l = v(this.f3631l, i10);
        int v10 = v(this.f3632m, i11);
        this.f3632m = v10;
        if (this.f3631l == 0 && v10 == 0) {
            w(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void n() {
        this.f3632m = 0;
        this.f3631l = 0;
    }

    protected float s(DisplayMetrics displayMetrics) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int t(int i10) {
        return (int) Math.ceil(u(i10) / 0.3356d);
    }

    protected int u(int i10) {
        return (int) Math.ceil(Math.abs(i10) * this.f3630k);
    }

    protected void w(RecyclerView.z.a aVar) {
        PointF a10 = a(f());
        if (a10 == null || (a10.x == 0.0f && a10.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(a10);
        this.f3631l = (int) (a10.x * 10000.0f);
        this.f3632m = (int) (a10.y * 10000.0f);
        aVar.d((int) (this.f3631l * 1.2f), (int) (this.f3632m * 1.2f), (int) (u(10000) * 1.2f), this.f3628i);
    }
}
