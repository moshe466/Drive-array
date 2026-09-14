package h6;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class d extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    private final int f10479a;

    /* renamed from: b, reason: collision with root package name */
    private final int f10480b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10481c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f10482d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f10483e;

    public d(int i10, int i11, int i12, int i13, int i14) {
        Paint paint = new Paint();
        this.f10482d = paint;
        Paint paint2 = new Paint();
        this.f10483e = paint2;
        float f10 = Resources.getSystem().getDisplayMetrics().density * 1.0f;
        this.f10481c = i10;
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(f10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(i13);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(f10);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setColor(i14);
        this.f10480b = i11;
        this.f10479a = i12;
    }

    private void j(Canvas canvas, float f10, float f11, int i10) {
        int i11 = this.f10481c;
        canvas.drawCircle(f10 + i11 + (((i11 * 2) + this.f10480b) * i10), f11, i11, this.f10483e);
    }

    private void k(Canvas canvas, float f10, float f11, int i10) {
        int i11 = this.f10481c;
        float f12 = (i11 * 2) + this.f10480b;
        float f13 = f10 + i11;
        for (int i12 = 0; i12 < i10; i12++) {
            canvas.drawCircle(f13, f11, this.f10481c, this.f10482d);
            f13 += f12;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void e(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        super.e(rect, view, recyclerView, a0Var);
        rect.bottom = this.f10479a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        LinearLayoutManager linearLayoutManager;
        super.i(canvas, recyclerView, a0Var);
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        float width = (recyclerView.getWidth() - (((this.f10481c * 2) * r7) + (Math.max(0, r7 - 1) * this.f10480b))) / 2.0f;
        float height = recyclerView.getHeight() - (this.f10479a / 2.0f);
        k(canvas, width, height, adapter.c());
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            linearLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        } else if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        } else {
            linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        }
        int X1 = linearLayoutManager.X1();
        if (X1 == -1 || recyclerView.getLayoutManager().C(X1) == null) {
            return;
        }
        j(canvas, width, height, X1);
    }
}
