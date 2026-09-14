package k0;

import J.S;
import android.R;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: k0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0482f {

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f5217x = {R.attr.state_pressed};
    public static final int[] y = new int[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f5218a;

    /* renamed from: b, reason: collision with root package name */
    public final StateListDrawable f5219b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f5220c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5221d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5222e;

    /* renamed from: f, reason: collision with root package name */
    public final StateListDrawable f5223f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f5224g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5225h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public float f5226j;

    /* renamed from: k, reason: collision with root package name */
    public float f5227k;

    /* renamed from: n, reason: collision with root package name */
    public final RecyclerView f5230n;

    /* renamed from: u, reason: collision with root package name */
    public final ValueAnimator f5236u;

    /* renamed from: v, reason: collision with root package name */
    public int f5237v;

    /* renamed from: w, reason: collision with root package name */
    public final G.a f5238w;

    /* renamed from: l, reason: collision with root package name */
    public int f5228l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f5229m = 0;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f5231o = false;
    public final boolean p = false;

    /* renamed from: q, reason: collision with root package name */
    public int f5232q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f5233r = 0;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f5234s = new int[2];

    /* renamed from: t, reason: collision with root package name */
    public final int[] f5235t = new int[2];

    public C0482f(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i3, int i4) {
        boolean z3;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f5236u = ofFloat;
        this.f5237v = 0;
        G.a aVar = new G.a(this, 4);
        this.f5238w = aVar;
        Object obj = new Object();
        this.f5219b = stateListDrawable;
        this.f5220c = drawable;
        this.f5223f = stateListDrawable2;
        this.f5224g = drawable2;
        this.f5221d = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f5222e = Math.max(i, drawable.getIntrinsicWidth());
        this.f5225h = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.i = Math.max(i, drawable2.getIntrinsicWidth());
        this.f5218a = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new C0480d(this));
        ofFloat.addUpdateListener(new C0481e(this));
        RecyclerView recyclerView2 = this.f5230n;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.f3717m;
            t tVar = recyclerView2.f3716l;
            if (tVar != null) {
                tVar.a("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                if (recyclerView2.getOverScrollMode() == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                recyclerView2.setWillNotDraw(z3);
            }
            recyclerView2.m();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f5230n;
            recyclerView3.f3718n.remove(this);
            if (recyclerView3.f3719o == this) {
                recyclerView3.f3719o = null;
            }
            ArrayList arrayList2 = this.f5230n.f3701b0;
            if (arrayList2 != null) {
                arrayList2.remove(obj);
            }
            this.f5230n.removeCallbacks(aVar);
        }
        this.f5230n = recyclerView;
        ArrayList arrayList3 = recyclerView.f3717m;
        t tVar2 = recyclerView.f3716l;
        if (tVar2 != null) {
            tVar2.a("Cannot add item decoration during a scroll  or layout");
        }
        if (arrayList3.isEmpty()) {
            recyclerView.setWillNotDraw(false);
        }
        arrayList3.add(this);
        recyclerView.m();
        recyclerView.requestLayout();
        this.f5230n.f3718n.add(this);
        RecyclerView recyclerView4 = this.f5230n;
        if (recyclerView4.f3701b0 == null) {
            recyclerView4.f3701b0 = new ArrayList();
        }
        recyclerView4.f3701b0.add(obj);
    }

    public static int d(float f4, float f5, int[] iArr, int i, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 != 0) {
            int i6 = i - i4;
            int i7 = (int) (((f5 - f4) / i5) * i6);
            int i8 = i3 + i7;
            if (i8 < i6 && i8 >= 0) {
                return i7;
            }
        }
        return 0;
    }

    public final boolean a(float f4, float f5) {
        if (f5 >= this.f5229m - this.f5225h && f4 >= 0 - (0 / 2) && f4 <= (0 / 2) + 0) {
            return true;
        }
        return false;
    }

    public final boolean b(float f4, float f5) {
        WeakHashMap weakHashMap = S.f954a;
        int layoutDirection = this.f5230n.getLayoutDirection();
        int i = this.f5221d;
        if (layoutDirection != 1 ? f4 >= this.f5228l - i : f4 <= i / 2) {
            int i3 = 0 / 2;
            if (f5 >= 0 - i3 && f5 <= i3 + 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(MotionEvent motionEvent) {
        int i = this.f5232q;
        if (i == 1) {
            boolean b4 = b(motionEvent.getX(), motionEvent.getY());
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0) {
                if (b4 || a2) {
                    if (a2) {
                        this.f5233r = 1;
                        this.f5227k = (int) motionEvent.getX();
                    } else if (b4) {
                        this.f5233r = 2;
                        this.f5226j = (int) motionEvent.getY();
                    }
                    e(2);
                    return true;
                }
                return false;
            }
            return false;
        }
        if (i == 2) {
            return true;
        }
        return false;
    }

    public final void e(int i) {
        G.a aVar = this.f5238w;
        StateListDrawable stateListDrawable = this.f5219b;
        if (i == 2 && this.f5232q != 2) {
            stateListDrawable.setState(f5217x);
            this.f5230n.removeCallbacks(aVar);
        }
        if (i == 0) {
            this.f5230n.invalidate();
        } else {
            f();
        }
        if (this.f5232q == 2 && i != 2) {
            stateListDrawable.setState(y);
            this.f5230n.removeCallbacks(aVar);
            this.f5230n.postDelayed(aVar, 1200);
        } else if (i == 1) {
            this.f5230n.removeCallbacks(aVar);
            this.f5230n.postDelayed(aVar, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.f5232q = i;
    }

    public final void f() {
        int i = this.f5237v;
        ValueAnimator valueAnimator = this.f5236u;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f5237v = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
