package s0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends m {
    private static final String[] R = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> S = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> T = new C0286c(PointF.class, "topLeft");
    private static final Property<k, PointF> U = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> V = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> W = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> X = new g(PointF.class, "position");
    private static s0.k Y = new s0.k();
    private int[] O = new int[2];
    private boolean P = false;
    private boolean Q = false;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f13870a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f13871b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f13872c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f13873d;

        a(c cVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f13870a = viewGroup;
            this.f13871b = bitmapDrawable;
            this.f13872c = view;
            this.f13873d = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d0.c(this.f13870a).d(this.f13871b);
            d0.h(this.f13872c, this.f13873d);
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f13874a;

        b(Class cls, String str) {
            super(cls, str);
            this.f13874a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f13874a);
            Rect rect = this.f13874a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f13874a);
            this.f13874a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f13874a);
        }
    }

    /* renamed from: s0.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0286c extends Property<k, PointF> {
        C0286c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            d0.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            d0.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            d0.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f13875a;
        private k mViewBounds;

        h(c cVar, k kVar) {
            this.f13875a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f13876a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f13877b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f13878c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f13879d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f13880e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f13881f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f13882g;

        i(c cVar, View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f13877b = view;
            this.f13878c = rect;
            this.f13879d = i10;
            this.f13880e = i11;
            this.f13881f = i12;
            this.f13882g = i13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f13876a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f13876a) {
                return;
            }
            androidx.core.view.a0.q0(this.f13877b, this.f13878c);
            d0.g(this.f13877b, this.f13879d, this.f13880e, this.f13881f, this.f13882g);
        }
    }

    /* loaded from: classes.dex */
    class j extends n {

        /* renamed from: a, reason: collision with root package name */
        boolean f13883a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f13884b;

        j(c cVar, ViewGroup viewGroup) {
            this.f13884b = viewGroup;
        }

        @Override // s0.n, s0.m.f
        public void a(m mVar) {
            x.b(this.f13884b, false);
        }

        @Override // s0.m.f
        public void b(m mVar) {
            if (!this.f13883a) {
                x.b(this.f13884b, false);
            }
            mVar.X(this);
        }

        @Override // s0.n, s0.m.f
        public void d(m mVar) {
            x.b(this.f13884b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private int f13885a;

        /* renamed from: b, reason: collision with root package name */
        private int f13886b;

        /* renamed from: c, reason: collision with root package name */
        private int f13887c;

        /* renamed from: d, reason: collision with root package name */
        private int f13888d;

        /* renamed from: e, reason: collision with root package name */
        private View f13889e;

        /* renamed from: f, reason: collision with root package name */
        private int f13890f;

        /* renamed from: g, reason: collision with root package name */
        private int f13891g;

        k(View view) {
            this.f13889e = view;
        }

        private void b() {
            d0.g(this.f13889e, this.f13885a, this.f13886b, this.f13887c, this.f13888d);
            this.f13890f = 0;
            this.f13891g = 0;
        }

        void a(PointF pointF) {
            this.f13887c = Math.round(pointF.x);
            this.f13888d = Math.round(pointF.y);
            int i10 = this.f13891g + 1;
            this.f13891g = i10;
            if (this.f13890f == i10) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f13885a = Math.round(pointF.x);
            this.f13886b = Math.round(pointF.y);
            int i10 = this.f13890f + 1;
            this.f13890f = i10;
            if (i10 == this.f13891g) {
                b();
            }
        }
    }

    private void k0(s sVar) {
        View view = sVar.f13988b;
        if (!androidx.core.view.a0.S(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f13987a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f13987a.put("android:changeBounds:parent", sVar.f13988b.getParent());
        if (this.Q) {
            sVar.f13988b.getLocationInWindow(this.O);
            sVar.f13987a.put("android:changeBounds:windowX", Integer.valueOf(this.O[0]));
            sVar.f13987a.put("android:changeBounds:windowY", Integer.valueOf(this.O[1]));
        }
        if (this.P) {
            sVar.f13987a.put("android:changeBounds:clip", androidx.core.view.a0.r(view));
        }
    }

    private boolean l0(View view, View view2) {
        if (!this.Q) {
            return true;
        }
        s x10 = x(view, true);
        if (x10 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == x10.f13988b) {
            return true;
        }
        return false;
    }

    @Override // s0.m
    public String[] J() {
        return R;
    }

    @Override // s0.m
    public void i(s sVar) {
        k0(sVar);
    }

    @Override // s0.m
    public void m(s sVar) {
        k0(sVar);
    }

    @Override // s0.m
    public Animator q(ViewGroup viewGroup, s sVar, s sVar2) {
        int i10;
        View view;
        int i11;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c10;
        Path a10;
        Property<View, PointF> property;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f13987a;
        Map<String, Object> map2 = sVar2.f13987a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f13988b;
        if (!l0(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) sVar.f13987a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) sVar.f13987a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) sVar2.f13987a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) sVar2.f13987a.get("android:changeBounds:windowY")).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.O);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float d10 = d0.d(view2);
            d0.h(view2, 0.0f);
            d0.c(viewGroup).b(bitmapDrawable);
            s0.g z10 = z();
            int[] iArr = this.O;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, s0.i.a(S, z10.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
            ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, d10));
            return ofPropertyValuesHolder;
        }
        Rect rect2 = (Rect) sVar.f13987a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) sVar2.f13987a.get("android:changeBounds:bounds");
        int i12 = rect2.left;
        int i13 = rect3.left;
        int i14 = rect2.top;
        int i15 = rect3.top;
        int i16 = rect2.right;
        int i17 = rect3.right;
        int i18 = rect2.bottom;
        int i19 = rect3.bottom;
        int i20 = i16 - i12;
        int i21 = i18 - i14;
        int i22 = i17 - i13;
        int i23 = i19 - i15;
        Rect rect4 = (Rect) sVar.f13987a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) sVar2.f13987a.get("android:changeBounds:clip");
        if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
            i10 = 0;
        } else {
            i10 = (i12 == i13 && i14 == i15) ? 0 : 1;
            if (i16 != i17 || i18 != i19) {
                i10++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i10++;
        }
        if (i10 <= 0) {
            return null;
        }
        if (this.P) {
            view = view2;
            d0.g(view, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
            ObjectAnimator a11 = (i12 == i13 && i14 == i15) ? null : s0.f.a(view, X, z().a(i12, i14, i13, i15));
            if (rect4 == null) {
                i11 = 0;
                rect = new Rect(0, 0, i20, i21);
            } else {
                i11 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i11, i11, i22, i23) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                androidx.core.view.a0.q0(view, rect);
                s0.k kVar = Y;
                Object[] objArr = new Object[2];
                objArr[i11] = rect;
                objArr[1] = rect6;
                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", kVar, objArr);
                ofObject.addListener(new i(this, view, rect5, i13, i15, i17, i19));
                objectAnimator = ofObject;
            }
            c10 = r.c(a11, objectAnimator);
        } else {
            view = view2;
            d0.g(view, i12, i14, i16, i18);
            if (i10 == 2) {
                if (i20 == i22 && i21 == i23) {
                    a10 = z().a(i12, i14, i13, i15);
                    property = X;
                } else {
                    k kVar2 = new k(view);
                    ObjectAnimator a12 = s0.f.a(kVar2, T, z().a(i12, i14, i13, i15));
                    ObjectAnimator a13 = s0.f.a(kVar2, U, z().a(i16, i18, i17, i19));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(a12, a13);
                    animatorSet.addListener(new h(this, kVar2));
                    c10 = animatorSet;
                }
            } else if (i12 == i13 && i14 == i15) {
                a10 = z().a(i16, i18, i17, i19);
                property = V;
            } else {
                a10 = z().a(i12, i14, i13, i15);
                property = W;
            }
            c10 = s0.f.a(view, property, a10);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.b(viewGroup4, true);
            a(new j(this, viewGroup4));
        }
        return c10;
    }
}
