package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.a0;
import androidx.core.view.k0;
import androidx.core.view.u;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: k0, reason: collision with root package name */
    static final int[] f3847k0 = {R.attr.layout_gravity};

    /* renamed from: l0, reason: collision with root package name */
    private static final Comparator<f> f3848l0 = new a();

    /* renamed from: m0, reason: collision with root package name */
    private static final Interpolator f3849m0 = new b();

    /* renamed from: n0, reason: collision with root package name */
    private static final n f3850n0 = new n();
    private boolean A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private int L;
    private VelocityTracker M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private EdgeEffect S;
    private EdgeEffect T;
    private boolean U;
    private boolean V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private List<j> f3851a0;

    /* renamed from: b0, reason: collision with root package name */
    private j f3852b0;

    /* renamed from: c0, reason: collision with root package name */
    private j f3853c0;

    /* renamed from: d0, reason: collision with root package name */
    private List<i> f3854d0;

    /* renamed from: e0, reason: collision with root package name */
    private k f3855e0;

    /* renamed from: f, reason: collision with root package name */
    private int f3856f;

    /* renamed from: f0, reason: collision with root package name */
    private int f3857f0;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayList<f> f3858g;

    /* renamed from: g0, reason: collision with root package name */
    private int f3859g0;

    /* renamed from: h, reason: collision with root package name */
    private final f f3860h;

    /* renamed from: h0, reason: collision with root package name */
    private ArrayList<View> f3861h0;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f3862i;

    /* renamed from: i0, reason: collision with root package name */
    private final Runnable f3863i0;

    /* renamed from: j, reason: collision with root package name */
    androidx.viewpager.widget.a f3864j;

    /* renamed from: j0, reason: collision with root package name */
    private int f3865j0;

    /* renamed from: k, reason: collision with root package name */
    int f3866k;

    /* renamed from: l, reason: collision with root package name */
    private int f3867l;

    /* renamed from: m, reason: collision with root package name */
    private Parcelable f3868m;

    /* renamed from: n, reason: collision with root package name */
    private ClassLoader f3869n;

    /* renamed from: o, reason: collision with root package name */
    private Scroller f3870o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3871p;

    /* renamed from: q, reason: collision with root package name */
    private l f3872q;

    /* renamed from: r, reason: collision with root package name */
    private int f3873r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f3874s;

    /* renamed from: t, reason: collision with root package name */
    private int f3875t;

    /* renamed from: u, reason: collision with root package name */
    private int f3876u;

    /* renamed from: v, reason: collision with root package name */
    private float f3877v;

    /* renamed from: w, reason: collision with root package name */
    private float f3878w;

    /* renamed from: x, reason: collision with root package name */
    private int f3879x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f3880y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3881z;

    /* loaded from: classes.dex */
    static class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f3886b - fVar2.f3886b;
        }
    }

    /* loaded from: classes.dex */
    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements u {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f3883a = new Rect();

        d() {
        }

        @Override // androidx.core.view.u
        public k0 a(View view, k0 k0Var) {
            k0 a02 = a0.a0(view, k0Var);
            if (a02.n()) {
                return a02;
            }
            Rect rect = this.f3883a;
            rect.left = a02.i();
            rect.top = a02.k();
            rect.right = a02.j();
            rect.bottom = a02.h();
            int childCount = ViewPager.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                k0 g10 = a0.g(ViewPager.this.getChildAt(i10), a02);
                rect.left = Math.min(g10.i(), rect.left);
                rect.top = Math.min(g10.k(), rect.top);
                rect.right = Math.min(g10.j(), rect.right);
                rect.bottom = Math.min(g10.h(), rect.bottom);
            }
            return a02.o(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface e {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        Object f3885a;

        /* renamed from: b, reason: collision with root package name */
        int f3886b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3887c;

        /* renamed from: d, reason: collision with root package name */
        float f3888d;

        /* renamed from: e, reason: collision with root package name */
        float f3889e;

        f() {
        }
    }

    /* loaded from: classes.dex */
    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3890a;

        /* renamed from: b, reason: collision with root package name */
        public int f3891b;

        /* renamed from: c, reason: collision with root package name */
        float f3892c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3893d;

        /* renamed from: e, reason: collision with root package name */
        int f3894e;

        /* renamed from: f, reason: collision with root package name */
        int f3895f;

        public g() {
            super(-1, -1);
            this.f3892c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3892c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f3847k0);
            this.f3891b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends androidx.core.view.a {
        h() {
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar = ViewPager.this.f3864j;
            return aVar != null && aVar.c() > 1;
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.f3864j) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.c());
            accessibilityEvent.setFromIndex(ViewPager.this.f3866k);
            accessibilityEvent.setToIndex(ViewPager.this.f3866k);
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.accessibility.d dVar) {
            super.g(view, dVar);
            dVar.V(ViewPager.class.getName());
            dVar.m0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                dVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                dVar.a(8192);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            ViewPager viewPager;
            int i11;
            if (super.j(view, i10, bundle)) {
                return true;
            }
            if (i10 != 4096) {
                if (i10 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i11 = viewPager.f3866k - 1;
            } else {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i11 = viewPager.f3866k + 1;
            }
            viewPager.setCurrentItem(i11);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(int i10);

        void b(int i10, float f10, int i11);

        void c(int i10);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(View view, float f10);
    }

    /* loaded from: classes.dex */
    private class l extends DataSetObserver {
        l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.f();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.f();
        }
    }

    /* loaded from: classes.dex */
    public static class m extends y.a {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        int f3898h;

        /* renamed from: i, reason: collision with root package name */
        Parcelable f3899i;

        /* renamed from: j, reason: collision with root package name */
        ClassLoader f3900j;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<m> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public m[] newArray(int i10) {
                return new m[i10];
            }
        }

        m(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? m.class.getClassLoader() : classLoader;
            this.f3898h = parcel.readInt();
            this.f3899i = parcel.readParcelable(classLoader);
            this.f3900j = classLoader;
        }

        public m(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f3898h + "}";
        }

        @Override // y.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f3898h);
            parcel.writeParcelable(this.f3899i, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class n implements Comparator<View> {
        n() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z10 = gVar.f3890a;
            return z10 != gVar2.f3890a ? z10 ? 1 : -1 : gVar.f3894e - gVar2.f3894e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3858g = new ArrayList<>();
        this.f3860h = new f();
        this.f3862i = new Rect();
        this.f3867l = -1;
        this.f3868m = null;
        this.f3869n = null;
        this.f3877v = -3.4028235E38f;
        this.f3878w = Float.MAX_VALUE;
        this.B = 1;
        this.L = -1;
        this.U = true;
        this.f3863i0 = new c();
        this.f3865j0 = 0;
        t();
    }

    private boolean A(int i10) {
        if (this.f3858g.size() == 0) {
            if (this.U) {
                return false;
            }
            this.V = false;
            w(0, 0.0f, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f r10 = r();
        int clientWidth = getClientWidth();
        int i11 = this.f3873r;
        int i12 = clientWidth + i11;
        float f10 = clientWidth;
        int i13 = r10.f3886b;
        float f11 = ((i10 / f10) - r10.f3889e) / (r10.f3888d + (i11 / f10));
        this.V = false;
        w(i13, f11, (int) (i12 * f11));
        if (this.V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean B(float f10) {
        boolean z10;
        boolean z11;
        float f11 = this.H - f10;
        this.H = f10;
        float scrollX = getScrollX() + f11;
        float clientWidth = getClientWidth();
        float f12 = this.f3877v * clientWidth;
        float f13 = this.f3878w * clientWidth;
        boolean z12 = false;
        f fVar = this.f3858g.get(0);
        ArrayList<f> arrayList = this.f3858g;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f3886b != 0) {
            f12 = fVar.f3889e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (fVar2.f3886b != this.f3864j.c() - 1) {
            f13 = fVar2.f3889e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f12) {
            if (z10) {
                this.S.onPull(Math.abs(f12 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f12;
        } else if (scrollX > f13) {
            if (z11) {
                this.T.onPull(Math.abs(scrollX - f13) / clientWidth);
                z12 = true;
            }
            scrollX = f13;
        }
        int i10 = (int) scrollX;
        this.H += scrollX - i10;
        scrollTo(i10, getScrollY());
        A(i10);
        return z12;
    }

    private void E(int i10, int i11, int i12, int i13) {
        int min;
        if (i11 <= 0 || this.f3858g.isEmpty()) {
            f s10 = s(this.f3866k);
            min = (int) ((s10 != null ? Math.min(s10.f3889e, this.f3878w) : 0.0f) * ((i10 - getPaddingLeft()) - getPaddingRight()));
            if (min == getScrollX()) {
                return;
            } else {
                e(false);
            }
        } else if (!this.f3870o.isFinished()) {
            this.f3870o.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((getScrollX() / (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)) * (((i10 - getPaddingLeft()) - getPaddingRight()) + i12));
        }
        scrollTo(min, getScrollY());
    }

    private void F() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((g) getChildAt(i10).getLayoutParams()).f3890a) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void G(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private boolean H() {
        this.L = -1;
        m();
        this.S.onRelease();
        this.T.onRelease();
        return this.S.isFinished() || this.T.isFinished();
    }

    private void I(int i10, boolean z10, int i11, boolean z11) {
        f s10 = s(i10);
        int clientWidth = s10 != null ? (int) (getClientWidth() * Math.max(this.f3877v, Math.min(s10.f3889e, this.f3878w))) : 0;
        if (z10) {
            M(clientWidth, 0, i11);
            if (z11) {
                i(i10);
                return;
            }
            return;
        }
        if (z11) {
            i(i10);
        }
        e(false);
        scrollTo(clientWidth, 0);
        A(clientWidth);
    }

    private void N() {
        if (this.f3859g0 != 0) {
            ArrayList<View> arrayList = this.f3861h0;
            if (arrayList == null) {
                this.f3861h0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f3861h0.add(getChildAt(i10));
            }
            Collections.sort(this.f3861h0, f3850n0);
        }
    }

    private void c(f fVar, int i10, f fVar2) {
        int i11;
        int i12;
        f fVar3;
        f fVar4;
        int c10 = this.f3864j.c();
        int clientWidth = getClientWidth();
        float f10 = clientWidth > 0 ? this.f3873r / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i13 = fVar2.f3886b;
            int i14 = fVar.f3886b;
            if (i13 < i14) {
                int i15 = 0;
                float f11 = fVar2.f3889e + fVar2.f3888d + f10;
                while (true) {
                    i13++;
                    if (i13 > fVar.f3886b || i15 >= this.f3858g.size()) {
                        break;
                    }
                    while (true) {
                        fVar4 = this.f3858g.get(i15);
                        if (i13 <= fVar4.f3886b || i15 >= this.f3858g.size() - 1) {
                            break;
                        } else {
                            i15++;
                        }
                    }
                    while (i13 < fVar4.f3886b) {
                        f11 += this.f3864j.e(i13) + f10;
                        i13++;
                    }
                    fVar4.f3889e = f11;
                    f11 += fVar4.f3888d + f10;
                }
            } else if (i13 > i14) {
                int size = this.f3858g.size() - 1;
                float f12 = fVar2.f3889e;
                while (true) {
                    i13--;
                    if (i13 < fVar.f3886b || size < 0) {
                        break;
                    }
                    while (true) {
                        fVar3 = this.f3858g.get(size);
                        if (i13 >= fVar3.f3886b || size <= 0) {
                            break;
                        } else {
                            size--;
                        }
                    }
                    while (i13 > fVar3.f3886b) {
                        f12 -= this.f3864j.e(i13) + f10;
                        i13--;
                    }
                    f12 -= fVar3.f3888d + f10;
                    fVar3.f3889e = f12;
                }
            }
        }
        int size2 = this.f3858g.size();
        float f13 = fVar.f3889e;
        int i16 = fVar.f3886b;
        int i17 = i16 - 1;
        this.f3877v = i16 == 0 ? f13 : -3.4028235E38f;
        int i18 = c10 - 1;
        this.f3878w = i16 == i18 ? (fVar.f3888d + f13) - 1.0f : Float.MAX_VALUE;
        int i19 = i10 - 1;
        while (i19 >= 0) {
            f fVar5 = this.f3858g.get(i19);
            while (true) {
                i12 = fVar5.f3886b;
                if (i17 <= i12) {
                    break;
                }
                f13 -= this.f3864j.e(i17) + f10;
                i17--;
            }
            f13 -= fVar5.f3888d + f10;
            fVar5.f3889e = f13;
            if (i12 == 0) {
                this.f3877v = f13;
            }
            i19--;
            i17--;
        }
        float f14 = fVar.f3889e + fVar.f3888d + f10;
        int i20 = fVar.f3886b + 1;
        int i21 = i10 + 1;
        while (i21 < size2) {
            f fVar6 = this.f3858g.get(i21);
            while (true) {
                i11 = fVar6.f3886b;
                if (i20 >= i11) {
                    break;
                }
                f14 += this.f3864j.e(i20) + f10;
                i20++;
            }
            if (i11 == i18) {
                this.f3878w = (fVar6.f3888d + f14) - 1.0f;
            }
            fVar6.f3889e = f14;
            f14 += fVar6.f3888d + f10;
            i21++;
            i20++;
        }
    }

    private void e(boolean z10) {
        boolean z11 = this.f3865j0 == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            if (!this.f3870o.isFinished()) {
                this.f3870o.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f3870o.getCurrX();
                int currY = this.f3870o.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        A(currX);
                    }
                }
            }
        }
        this.A = false;
        for (int i10 = 0; i10 < this.f3858g.size(); i10++) {
            f fVar = this.f3858g.get(i10);
            if (fVar.f3887c) {
                fVar.f3887c = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                a0.e0(this, this.f3863i0);
            } else {
                this.f3863i0.run();
            }
        }
    }

    private int g(int i10, float f10, int i11, int i12) {
        if (Math.abs(i12) <= this.P || Math.abs(i11) <= this.N) {
            i10 += (int) (f10 + (i10 >= this.f3866k ? 0.4f : 0.6f));
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.f3858g.size() <= 0) {
            return i10;
        }
        return Math.max(this.f3858g.get(0).f3886b, Math.min(i10, this.f3858g.get(r4.size() - 1).f3886b));
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h(int i10, float f10, int i11) {
        j jVar = this.f3852b0;
        if (jVar != null) {
            jVar.b(i10, f10, i11);
        }
        List<j> list = this.f3851a0;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                j jVar2 = this.f3851a0.get(i12);
                if (jVar2 != null) {
                    jVar2.b(i10, f10, i11);
                }
            }
        }
        j jVar3 = this.f3853c0;
        if (jVar3 != null) {
            jVar3.b(i10, f10, i11);
        }
    }

    private void i(int i10) {
        j jVar = this.f3852b0;
        if (jVar != null) {
            jVar.a(i10);
        }
        List<j> list = this.f3851a0;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.f3851a0.get(i11);
                if (jVar2 != null) {
                    jVar2.a(i10);
                }
            }
        }
        j jVar3 = this.f3853c0;
        if (jVar3 != null) {
            jVar3.a(i10);
        }
    }

    private void j(int i10) {
        j jVar = this.f3852b0;
        if (jVar != null) {
            jVar.c(i10);
        }
        List<j> list = this.f3851a0;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.f3851a0.get(i11);
                if (jVar2 != null) {
                    jVar2.c(i10);
                }
            }
        }
        j jVar3 = this.f3853c0;
        if (jVar3 != null) {
            jVar3.c(i10);
        }
    }

    private void l(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setLayerType(z10 ? this.f3857f0 : 0, null);
        }
    }

    private void m() {
        this.C = false;
        this.D = false;
        VelocityTracker velocityTracker = this.M;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.M = null;
        }
    }

    private Rect o(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private f r() {
        int i10;
        int clientWidth = getClientWidth();
        float f10 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f11 = clientWidth > 0 ? this.f3873r / clientWidth : 0.0f;
        f fVar = null;
        float f12 = 0.0f;
        int i11 = -1;
        int i12 = 0;
        boolean z10 = true;
        while (i12 < this.f3858g.size()) {
            f fVar2 = this.f3858g.get(i12);
            if (!z10 && fVar2.f3886b != (i10 = i11 + 1)) {
                fVar2 = this.f3860h;
                fVar2.f3889e = f10 + f12 + f11;
                fVar2.f3886b = i10;
                fVar2.f3888d = this.f3864j.e(i10);
                i12--;
            }
            f10 = fVar2.f3889e;
            float f13 = fVar2.f3888d + f10 + f11;
            if (!z10 && scrollX < f10) {
                return fVar;
            }
            if (scrollX < f13 || i12 == this.f3858g.size() - 1) {
                return fVar2;
            }
            i11 = fVar2.f3886b;
            f12 = fVar2.f3888d;
            i12++;
            fVar = fVar2;
            z10 = false;
        }
        return fVar;
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.f3881z != z10) {
            this.f3881z = z10;
        }
    }

    private static boolean u(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean v(float f10, float f11) {
        return (f10 < ((float) this.F) && f11 > 0.0f) || (f10 > ((float) (getWidth() - this.F)) && f11 < 0.0f);
    }

    private void x(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.L) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.H = motionEvent.getX(i10);
            this.L = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.M;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    void C() {
        D(this.f3866k);
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x00ce, code lost:
    
        if (r10 >= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00dc, code lost:
    
        if (r10 >= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r9 == r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c0, code lost:
    
        if (r10 >= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e7, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00de, code lost:
    
        r5 = r17.f3858g.get(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void D(int r18) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.D(int):void");
    }

    public void J(int i10, boolean z10) {
        this.A = false;
        K(i10, z10, false);
    }

    void K(int i10, boolean z10, boolean z11) {
        L(i10, z10, z11, 0);
    }

    void L(int i10, boolean z10, boolean z11, int i11) {
        androidx.viewpager.widget.a aVar = this.f3864j;
        if (aVar == null || aVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z11 && this.f3866k == i10 && this.f3858g.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 >= this.f3864j.c()) {
            i10 = this.f3864j.c() - 1;
        }
        int i12 = this.B;
        int i13 = this.f3866k;
        if (i10 > i13 + i12 || i10 < i13 - i12) {
            for (int i14 = 0; i14 < this.f3858g.size(); i14++) {
                this.f3858g.get(i14).f3887c = true;
            }
        }
        boolean z12 = this.f3866k != i10;
        if (!this.U) {
            D(i10);
            I(i10, z10, i11, z12);
        } else {
            this.f3866k = i10;
            if (z12) {
                i(i10);
            }
            requestLayout();
        }
    }

    void M(int i10, int i11, int i12) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f3870o;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f3871p ? this.f3870o.getCurrX() : this.f3870o.getStartX();
            this.f3870o.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i13 = scrollX;
        int scrollY = getScrollY();
        int i14 = i10 - i13;
        int i15 = i11 - scrollY;
        if (i14 == 0 && i15 == 0) {
            e(false);
            C();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i16 = clientWidth / 2;
        float f10 = clientWidth;
        float f11 = i16;
        float k10 = f11 + (k(Math.min(1.0f, (Math.abs(i14) * 1.0f) / f10)) * f11);
        int abs = Math.abs(i12);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(k10 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i14) / ((f10 * this.f3864j.e(this.f3866k)) + this.f3873r)) + 1.0f) * 100.0f), 600);
        this.f3871p = false;
        this.f3870o.startScroll(i13, scrollY, i14, i15, min);
        a0.d0(this);
    }

    f a(int i10, int i11) {
        f fVar = new f();
        fVar.f3886b = i10;
        fVar.f3885a = this.f3864j.f(this, i10);
        fVar.f3888d = this.f3864j.e(i10);
        if (i11 < 0 || i11 >= this.f3858g.size()) {
            this.f3858g.add(fVar);
        } else {
            this.f3858g.add(i11, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        f q10;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (q10 = q(childAt)) != null && q10.f3886b == this.f3866k) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f q10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (q10 = q(childAt)) != null && q10.f3886b == this.f3866k) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean u10 = gVar.f3890a | u(view);
        gVar.f3890a = u10;
        if (!this.f3880y) {
            super.addView(view, i10, layoutParams);
        } else {
            if (u10) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.f3893d = true;
            addViewInLayout(view, i10, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto Lb
        L9:
            r0 = r3
            goto L60
        Lb:
            if (r0 == 0) goto L60
            android.view.ViewParent r4 = r0.getParent()
        L11:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1e
            if (r4 != r6) goto L19
            r4 = 1
            goto L1f
        L19:
            android.view.ViewParent r4 = r4.getParent()
            goto L11
        L1e:
            r4 = 0
        L1f:
            if (r4 != 0) goto L60
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L35:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L35
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            goto L9
        L60:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto Lac
            if (r3 == r0) goto Lac
            if (r7 != r5) goto L91
            android.graphics.Rect r1 = r6.f3862i
            android.graphics.Rect r1 = r6.o(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f3862i
            android.graphics.Rect r2 = r6.o(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L8b
            if (r1 < r2) goto L8b
            boolean r0 = r6.y()
            goto L8f
        L8b:
            boolean r0 = r3.requestFocus()
        L8f:
            r2 = r0
            goto Lbf
        L91:
            if (r7 != r4) goto Lbf
            android.graphics.Rect r1 = r6.f3862i
            android.graphics.Rect r1 = r6.o(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f3862i
            android.graphics.Rect r2 = r6.o(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L8b
            if (r1 > r2) goto L8b
            boolean r0 = r6.z()
            goto L8f
        Lac:
            if (r7 == r5) goto Lbb
            if (r7 != r1) goto Lb1
            goto Lbb
        Lb1:
            if (r7 == r4) goto Lb6
            r0 = 2
            if (r7 != r0) goto Lbf
        Lb6:
            boolean r2 = r6.z()
            goto Lbf
        Lbb:
            boolean r2 = r6.y()
        Lbf:
            if (r2 == 0) goto Lc8
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Lc8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.b(int):boolean");
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.f3864j == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i10 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f3877v)) : i10 > 0 && scrollX < ((int) (((float) clientWidth) * this.f3878w));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f3871p = true;
        if (this.f3870o.isFinished() || !this.f3870o.computeScrollOffset()) {
            e(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f3870o.getCurrX();
        int currY = this.f3870o.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!A(currX)) {
                this.f3870o.abortAnimation();
                scrollTo(0, currY);
            }
        }
        a0.d0(this);
    }

    protected boolean d(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && d(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && view.canScrollHorizontally(-i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || n(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f q10;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (q10 = q(childAt)) != null && q10.f3886b == this.f3866k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z10 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f3864j) != null && aVar.c() > 1)) {
            if (!this.S.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f3877v * width);
                this.S.setSize(height, width);
                z10 = false | this.S.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.T.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f3878w + 1.0f)) * width2);
                this.T.setSize(height2, width2);
                z10 |= this.T.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.S.finish();
            this.T.finish();
        }
        if (z10) {
            a0.d0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3874s;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    void f() {
        int c10 = this.f3864j.c();
        this.f3856f = c10;
        boolean z10 = this.f3858g.size() < (this.B * 2) + 1 && this.f3858g.size() < c10;
        int i10 = this.f3866k;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < this.f3858g.size()) {
            f fVar = this.f3858g.get(i11);
            int d10 = this.f3864j.d(fVar.f3885a);
            if (d10 != -1) {
                if (d10 == -2) {
                    this.f3858g.remove(i11);
                    i11--;
                    if (!z11) {
                        this.f3864j.l(this);
                        z11 = true;
                    }
                    this.f3864j.a(this, fVar.f3886b, fVar.f3885a);
                    int i12 = this.f3866k;
                    if (i12 == fVar.f3886b) {
                        i10 = Math.max(0, Math.min(i12, c10 - 1));
                    }
                } else {
                    int i13 = fVar.f3886b;
                    if (i13 != d10) {
                        if (i13 == this.f3866k) {
                            i10 = d10;
                        }
                        fVar.f3886b = d10;
                    }
                }
                z10 = true;
            }
            i11++;
        }
        if (z11) {
            this.f3864j.b(this);
        }
        Collections.sort(this.f3858g, f3848l0);
        if (z10) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                g gVar = (g) getChildAt(i14).getLayoutParams();
                if (!gVar.f3890a) {
                    gVar.f3892c = 0.0f;
                }
            }
            K(i10, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f3864j;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        if (this.f3859g0 == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((g) this.f3861h0.get(i11).getLayoutParams()).f3895f;
    }

    public int getCurrentItem() {
        return this.f3866k;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.f3873r;
    }

    float k(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public boolean n(KeyEvent keyEvent) {
        int i10;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return b(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return b(1);
                        }
                    }
                } else {
                    if (keyEvent.hasModifiers(2)) {
                        return z();
                    }
                    i10 = 66;
                }
            } else {
                if (keyEvent.hasModifiers(2)) {
                    return y();
                }
                i10 = 17;
            }
            return b(i10);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f3863i0);
        Scroller scroller = this.f3870o;
        if (scroller != null && !scroller.isFinished()) {
            this.f3870o.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.f3873r <= 0 || this.f3874s == null || this.f3858g.size() <= 0 || this.f3864j == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f12 = this.f3873r / width;
        int i11 = 0;
        f fVar = this.f3858g.get(0);
        float f13 = fVar.f3889e;
        int size = this.f3858g.size();
        int i12 = fVar.f3886b;
        int i13 = this.f3858g.get(size - 1).f3886b;
        while (i12 < i13) {
            while (true) {
                i10 = fVar.f3886b;
                if (i12 <= i10 || i11 >= size) {
                    break;
                }
                i11++;
                fVar = this.f3858g.get(i11);
            }
            if (i12 == i10) {
                float f14 = fVar.f3889e;
                float f15 = fVar.f3888d;
                f10 = (f14 + f15) * width;
                f13 = f14 + f15 + f12;
            } else {
                float e10 = this.f3864j.e(i12);
                f10 = (f13 + e10) * width;
                f13 += e10 + f12;
            }
            if (this.f3873r + f10 > scrollX) {
                f11 = f12;
                this.f3874s.setBounds(Math.round(f10), this.f3875t, Math.round(this.f3873r + f10), this.f3876u);
                this.f3874s.draw(canvas);
            } else {
                f11 = f12;
            }
            if (f10 > scrollX + r2) {
                return;
            }
            i12++;
            f12 = f11;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            H();
            return false;
        }
        if (action != 0) {
            if (this.C) {
                return true;
            }
            if (this.D) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.J = x10;
            this.H = x10;
            float y10 = motionEvent.getY();
            this.K = y10;
            this.I = y10;
            this.L = motionEvent.getPointerId(0);
            this.D = false;
            this.f3871p = true;
            this.f3870o.computeScrollOffset();
            if (this.f3865j0 != 2 || Math.abs(this.f3870o.getFinalX() - this.f3870o.getCurrX()) <= this.Q) {
                e(false);
                this.C = false;
            } else {
                this.f3870o.abortAnimation();
                this.A = false;
                C();
                this.C = true;
                G(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.L;
            if (i10 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i10);
                float x11 = motionEvent.getX(findPointerIndex);
                float f10 = x11 - this.H;
                float abs = Math.abs(f10);
                float y11 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y11 - this.K);
                if (f10 != 0.0f && !v(this.H, f10) && d(this, false, (int) f10, (int) x11, (int) y11)) {
                    this.H = x11;
                    this.I = y11;
                    this.D = true;
                    return false;
                }
                int i11 = this.G;
                if (abs > i11 && abs * 0.5f > abs2) {
                    this.C = true;
                    G(true);
                    setScrollState(1);
                    float f11 = this.J;
                    float f12 = this.G;
                    this.H = f10 > 0.0f ? f11 + f12 : f11 - f12;
                    this.I = y11;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > i11) {
                    this.D = true;
                }
                if (this.C && B(x11)) {
                    a0.d0(this);
                }
            }
        } else if (action == 6) {
            x(motionEvent);
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        return this.C;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        f q10;
        int childCount = getChildCount();
        int i13 = -1;
        if ((i10 & 2) != 0) {
            i13 = childCount;
            i11 = 0;
            i12 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
        }
        while (i11 != i13) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (q10 = q(childAt)) != null && q10.f3886b == this.f3866k && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i12;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof m)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        m mVar = (m) parcelable;
        super.onRestoreInstanceState(mVar.a());
        androidx.viewpager.widget.a aVar = this.f3864j;
        if (aVar != null) {
            aVar.h(mVar.f3899i, mVar.f3900j);
            K(mVar.f3898h, false, true);
        } else {
            this.f3867l = mVar.f3898h;
            this.f3868m = mVar.f3899i;
            this.f3869n = mVar.f3900j;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        m mVar = new m(super.onSaveInstanceState());
        mVar.f3898h = this.f3866k;
        androidx.viewpager.widget.a aVar = this.f3864j;
        if (aVar != null) {
            mVar.f3899i = aVar.i();
        }
        return mVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.f3873r;
            E(i10, i12, i14, i14);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0151  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    f p(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return q(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    f q(View view) {
        for (int i10 = 0; i10 < this.f3858g.size(); i10++) {
            f fVar = this.f3858g.get(i10);
            if (this.f3864j.g(view, fVar.f3885a)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f3880y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    f s(int i10) {
        for (int i11 = 0; i11 < this.f3858g.size(); i11++) {
            f fVar = this.f3858g.get(i11);
            if (fVar.f3886b == i10) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.f3864j;
        if (aVar2 != null) {
            aVar2.k(null);
            this.f3864j.l(this);
            for (int i10 = 0; i10 < this.f3858g.size(); i10++) {
                f fVar = this.f3858g.get(i10);
                this.f3864j.a(this, fVar.f3886b, fVar.f3885a);
            }
            this.f3864j.b(this);
            this.f3858g.clear();
            F();
            this.f3866k = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.f3864j;
        this.f3864j = aVar;
        this.f3856f = 0;
        if (aVar != null) {
            if (this.f3872q == null) {
                this.f3872q = new l();
            }
            this.f3864j.k(this.f3872q);
            this.A = false;
            boolean z10 = this.U;
            this.U = true;
            this.f3856f = this.f3864j.c();
            if (this.f3867l >= 0) {
                this.f3864j.h(this.f3868m, this.f3869n);
                K(this.f3867l, false, true);
                this.f3867l = -1;
                this.f3868m = null;
                this.f3869n = null;
            } else if (z10) {
                requestLayout();
            } else {
                C();
            }
        }
        List<i> list = this.f3854d0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f3854d0.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f3854d0.get(i11).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i10) {
        this.A = false;
        K(i10, !this.U, false);
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Requested offscreen page limit ");
            sb2.append(i10);
            sb2.append(" too small; defaulting to ");
            sb2.append(1);
            i10 = 1;
        }
        if (i10 != this.B) {
            this.B = i10;
            C();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.f3852b0 = jVar;
    }

    public void setPageMargin(int i10) {
        int i11 = this.f3873r;
        this.f3873r = i10;
        int width = getWidth();
        E(width, width, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(androidx.core.content.a.f(getContext(), i10));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f3874s = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i10) {
        if (this.f3865j0 == i10) {
            return;
        }
        this.f3865j0 = i10;
        if (this.f3855e0 != null) {
            l(i10 != 0);
        }
        j(i10);
    }

    void t() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f3870o = new Scroller(context, f3849m0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.G = viewConfiguration.getScaledPagingTouchSlop();
        this.N = (int) (400.0f * f10);
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.S = new EdgeEffect(context);
        this.T = new EdgeEffect(context);
        this.P = (int) (25.0f * f10);
        this.Q = (int) (2.0f * f10);
        this.E = (int) (f10 * 16.0f);
        a0.j0(this, new h());
        if (a0.x(this) == 0) {
            a0.u0(this, 1);
        }
        a0.w0(this, new d());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3874s;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void w(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.W
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r9 = (androidx.viewpager.widget.ViewPager.g) r9
            boolean r10 = r9.f3890a
            if (r10 != 0) goto L2c
            goto L68
        L2c:
            int r9 = r9.f3891b
            r9 = r9 & 7
            if (r9 == r2) goto L4d
            r10 = 3
            if (r9 == r10) goto L47
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5c
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L59
        L47:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L59:
            r11 = r9
            r9 = r3
            r3 = r11
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            r12.h(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$k r13 = r12.f3855e0
            if (r13 == 0) goto L9f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7a:
            if (r1 >= r14) goto L9f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r0 = (androidx.viewpager.widget.ViewPager.g) r0
            boolean r0 = r0.f3890a
            if (r0 == 0) goto L8b
            goto L9c
        L8b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$k r3 = r12.f3855e0
            r3.a(r15, r0)
        L9c:
            int r1 = r1 + 1
            goto L7a
        L9f:
            r12.V = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.w(int, float, int):void");
    }

    boolean y() {
        int i10 = this.f3866k;
        if (i10 <= 0) {
            return false;
        }
        J(i10 - 1, true);
        return true;
    }

    boolean z() {
        androidx.viewpager.widget.a aVar = this.f3864j;
        if (aVar == null || this.f3866k >= aVar.c() - 1) {
            return false;
        }
        J(this.f3866k + 1, true);
        return true;
    }
}
