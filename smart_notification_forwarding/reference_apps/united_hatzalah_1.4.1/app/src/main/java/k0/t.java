package k0;

import F0.C0035g2;
import F0.C0047j2;
import F0.C0084t0;
import F0.G1;
import F0.b3;
import J.S;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import j0.AbstractC0456a;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public b3 f5268a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f5269b;

    /* renamed from: c, reason: collision with root package name */
    public final C0084t0 f5270c;

    /* renamed from: d, reason: collision with root package name */
    public final C0084t0 f5271d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5272e;

    /* renamed from: f, reason: collision with root package name */
    public int f5273f;

    /* renamed from: g, reason: collision with root package name */
    public int f5274g;

    public t() {
        C0035g2 c0035g2 = new C0035g2(this, 16);
        C0047j2 c0047j2 = new C0047j2(this, 17);
        this.f5270c = new C0084t0(c0035g2);
        this.f5271d = new C0084t0(c0047j2);
        this.f5272e = false;
    }

    public static int e(int i, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                return Math.max(i3, i4);
            }
            return size;
        }
        return Math.min(size, Math.max(i3, i4));
    }

    public static void v(View view) {
        ((u) view.getLayoutParams()).getClass();
        throw null;
    }

    public static C0488l w(Context context, AttributeSet attributeSet, int i, int i3) {
        C0488l c0488l = new C0488l(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0456a.f5099a, i, i3);
        c0488l.f5256b = obtainStyledAttributes.getInt(0, 1);
        c0488l.f5257c = obtainStyledAttributes.getInt(9, 1);
        c0488l.f5258d = obtainStyledAttributes.getBoolean(8, false);
        c0488l.f5259e = obtainStyledAttributes.getBoolean(10, false);
        obtainStyledAttributes.recycle();
        return c0488l;
    }

    public void A(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f5269b;
        z zVar = recyclerView.f3698a;
        C0472C c0472c = recyclerView.f3699a0;
        if (recyclerView != null && accessibilityEvent != null) {
            boolean z3 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f5269b.canScrollVertically(-1) && !this.f5269b.canScrollHorizontally(-1) && !this.f5269b.canScrollHorizontally(1)) {
                z3 = false;
            }
            accessibilityEvent.setScrollable(z3);
            this.f5269b.getClass();
        }
    }

    public abstract void B(Parcelable parcelable);

    public abstract Parcelable C();

    public final void E() {
        int p = p() - 1;
        if (p < 0) {
            return;
        }
        RecyclerView.j(o(p));
        throw null;
    }

    public final void F(z zVar) {
        ArrayList arrayList = zVar.f5279a;
        int size = arrayList.size();
        int i = size - 1;
        if (i < 0) {
            arrayList.clear();
            if (size > 0) {
                this.f5269b.invalidate();
                return;
            }
            return;
        }
        throw e0.a.b(i, arrayList);
    }

    public final boolean G(RecyclerView recyclerView, View view, Rect rect, boolean z3, boolean z4) {
        boolean z5;
        boolean z6;
        int s3 = s();
        int u3 = u();
        int t3 = this.f5273f - t();
        int r3 = this.f5274g - r();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = rect.width() + left;
        int height = rect.height() + top;
        int i = left - s3;
        int min = Math.min(0, i);
        int i3 = top - u3;
        int min2 = Math.min(0, i3);
        int i4 = width - t3;
        int max = Math.max(0, i4);
        int max2 = Math.max(0, height - r3);
        RecyclerView recyclerView2 = this.f5269b;
        WeakHashMap weakHashMap = S.f954a;
        if (recyclerView2.getLayoutDirection() == 1) {
            if (max == 0) {
                max = Math.max(min, i4);
            }
        } else {
            if (min == 0) {
                min = Math.min(i, max);
            }
            max = min;
        }
        if (min2 == 0) {
            min2 = Math.min(i3, max2);
        }
        int[] iArr = {max, min2};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (z4) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int s4 = s();
            int u4 = u();
            int t4 = this.f5273f - t();
            int r4 = this.f5274g - r();
            Rect rect2 = this.f5269b.f3713j;
            int[] iArr2 = RecyclerView.f3671k0;
            u uVar = (u) focusedChild.getLayoutParams();
            Rect rect3 = uVar.f5275a;
            z5 = false;
            z6 = true;
            rect2.set((focusedChild.getLeft() - rect3.left) - ((ViewGroup.MarginLayoutParams) uVar).leftMargin, (focusedChild.getTop() - rect3.top) - ((ViewGroup.MarginLayoutParams) uVar).topMargin, focusedChild.getRight() + rect3.right + ((ViewGroup.MarginLayoutParams) uVar).rightMargin, focusedChild.getBottom() + rect3.bottom + ((ViewGroup.MarginLayoutParams) uVar).bottomMargin);
            if (rect2.left - i5 >= t4 || rect2.right - i5 <= s4 || rect2.top - i6 >= r4 || rect2.bottom - i6 <= u4) {
                return false;
            }
        } else {
            z5 = false;
            z6 = true;
        }
        if (i5 == 0 && i6 == 0) {
            return z5;
        }
        if (z3) {
            recyclerView.scrollBy(i5, i6);
            return z6;
        }
        recyclerView.r(i5, i6);
        return z6;
    }

    public final void H() {
        RecyclerView recyclerView = this.f5269b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public final void I(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f5269b = null;
            this.f5268a = null;
            this.f5273f = 0;
            this.f5274g = 0;
            return;
        }
        this.f5269b = recyclerView;
        this.f5268a = recyclerView.f3704d;
        this.f5273f = recyclerView.getWidth();
        this.f5274g = recyclerView.getHeight();
    }

    public abstract void a(String str);

    public abstract boolean b();

    public abstract boolean c();

    public boolean d(u uVar) {
        if (uVar != null) {
            return true;
        }
        return false;
    }

    public abstract int f(C0472C c0472c);

    public abstract void g(C0472C c0472c);

    public abstract int h(C0472C c0472c);

    public abstract int i(C0472C c0472c);

    public abstract void j(C0472C c0472c);

    public abstract int k(C0472C c0472c);

    public abstract u l();

    public u m(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    public u n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof u) {
            return new u((u) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new u((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new u(layoutParams);
    }

    public final View o(int i) {
        b3 b3Var = this.f5268a;
        if (b3Var != null) {
            M0.d dVar = (M0.d) b3Var.f470c;
            int i3 = -1;
            if (i >= 0) {
                int childCount = ((RecyclerView) ((G1) b3Var.f469b).f218b).getChildCount();
                int i4 = i;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    }
                    int a2 = i - (i4 - dVar.a(i4));
                    if (a2 == 0) {
                        i3 = i4;
                        while (dVar.b(i3)) {
                            i3++;
                        }
                    } else {
                        i4 += a2;
                    }
                }
            }
            return ((RecyclerView) ((G1) b3Var.f469b).f218b).getChildAt(i3);
        }
        return null;
    }

    public final int p() {
        b3 b3Var = this.f5268a;
        if (b3Var != null) {
            return ((RecyclerView) ((G1) b3Var.f469b).f218b).getChildCount() - ((ArrayList) b3Var.f471d).size();
        }
        return 0;
    }

    public int q(z zVar, C0472C c0472c) {
        RecyclerView recyclerView = this.f5269b;
        if (recyclerView != null) {
            recyclerView.getClass();
            return 1;
        }
        return 1;
    }

    public final int r() {
        RecyclerView recyclerView = this.f5269b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int s() {
        RecyclerView recyclerView = this.f5269b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int t() {
        RecyclerView recyclerView = this.f5269b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int u() {
        RecyclerView recyclerView = this.f5269b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int x(z zVar, C0472C c0472c) {
        RecyclerView recyclerView = this.f5269b;
        if (recyclerView != null) {
            recyclerView.getClass();
            return 1;
        }
        return 1;
    }

    public abstract boolean y();

    public abstract void z(RecyclerView recyclerView);

    public void D(int i) {
    }
}
