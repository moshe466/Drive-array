package com.google.android.material.transformation;

import a3.f;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import b3.h;
import b3.i;
import b3.j;
import c3.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    private final Rect f7026c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f7027d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f7028e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f7029f;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7030a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f7031b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f7032c;

        a(FabTransformationBehavior fabTransformationBehavior, boolean z10, View view, View view2) {
            this.f7030a = z10;
            this.f7031b = view;
            this.f7032c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f7030a) {
                return;
            }
            this.f7031b.setVisibility(4);
            this.f7032c.setAlpha(1.0f);
            this.f7032c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f7030a) {
                this.f7031b.setVisibility(0);
                this.f7032c.setAlpha(0.0f);
                this.f7032c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7033a;

        b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.f7033a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7033a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c3.d f7034a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f7035b;

        c(FabTransformationBehavior fabTransformationBehavior, c3.d dVar, Drawable drawable) {
            this.f7034a = dVar;
            this.f7035b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7034a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f7034a.setCircularRevealOverlayDrawable(this.f7035b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c3.d f7036a;

        d(FabTransformationBehavior fabTransformationBehavior, c3.d dVar) {
            this.f7036a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.f7036a.getRevealInfo();
            revealInfo.f4382c = Float.MAX_VALUE;
            this.f7036a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public h f7037a;

        /* renamed from: b, reason: collision with root package name */
        public j f7038b;
    }

    public FabTransformationBehavior() {
        this.f7026c = new Rect();
        this.f7027d = new RectF();
        this.f7028e = new RectF();
        this.f7029f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7026c = new Rect();
        this.f7027d = new RectF();
        this.f7028e = new RectF();
        this.f7029f = new int[2];
    }

    private ViewGroup J(View view) {
        View findViewById = view.findViewById(f.f121c);
        return findViewById != null ? b0(findViewById) : ((view instanceof l3.b) || (view instanceof l3.a)) ? b0(((ViewGroup) view).getChildAt(0)) : b0(view);
    }

    private void K(View view, e eVar, i iVar, i iVar2, float f10, float f11, float f12, float f13, RectF rectF) {
        float P = P(eVar, iVar, f10, f12);
        float P2 = P(eVar, iVar2, f11, f13);
        Rect rect = this.f7026c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f7027d;
        rectF2.set(rect);
        RectF rectF3 = this.f7028e;
        Q(view, rectF3);
        rectF3.offset(P, P2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float L(View view, View view2, j jVar) {
        RectF rectF = this.f7027d;
        RectF rectF2 = this.f7028e;
        Q(view, rectF);
        Q(view2, rectF2);
        rectF2.offset(-N(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float M(View view, View view2, j jVar) {
        RectF rectF = this.f7027d;
        RectF rectF2 = this.f7028e;
        Q(view, rectF);
        Q(view2, rectF2);
        rectF2.offset(0.0f, -O(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float N(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f10;
        RectF rectF = this.f7027d;
        RectF rectF2 = this.f7028e;
        Q(view, rectF);
        Q(view2, rectF2);
        int i10 = jVar.f4108a & 7;
        if (i10 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i10 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else {
            if (i10 != 5) {
                f10 = 0.0f;
                return f10 + jVar.f4109b;
            }
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f10 = centerX - centerX2;
        return f10 + jVar.f4109b;
    }

    private float O(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f10;
        RectF rectF = this.f7027d;
        RectF rectF2 = this.f7028e;
        Q(view, rectF);
        Q(view2, rectF2);
        int i10 = jVar.f4108a & 112;
        if (i10 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i10 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else {
            if (i10 != 80) {
                f10 = 0.0f;
                return f10 + jVar.f4110c;
            }
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f10 = centerY - centerY2;
        return f10 + jVar.f4110c;
    }

    private float P(e eVar, i iVar, float f10, float f11) {
        long c10 = iVar.c();
        long d10 = iVar.d();
        i d11 = eVar.f7037a.d("expansion");
        return b3.a.a(f10, f11, iVar.e().getInterpolation(((float) (((d11.c() + d11.d()) + 17) - c10)) / ((float) d10)));
    }

    private void Q(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f7029f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void R(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup J;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof c3.d) && c3.c.f4375a == 0) || (J = J(view2)) == null) {
                return;
            }
            if (z10) {
                if (!z11) {
                    b3.d.f4095a.set(J, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(J, b3.d.f4095a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(J, b3.d.f4095a, 0.0f);
            }
            eVar.f7037a.d("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void S(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof c3.d) {
            c3.d dVar = (c3.d) view2;
            int Z = Z(view);
            int i10 = 16777215 & Z;
            if (z10) {
                if (!z11) {
                    dVar.setCircularRevealScrimColor(Z);
                }
                ofInt = ObjectAnimator.ofInt(dVar, d.C0077d.f4379a, i10);
            } else {
                ofInt = ObjectAnimator.ofInt(dVar, d.C0077d.f4379a, Z);
            }
            ofInt.setEvaluator(b3.c.b());
            eVar.f7037a.d("color").a(ofInt);
            list.add(ofInt);
        }
    }

    @TargetApi(21)
    private void T(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float t10 = a0.t(view2) - a0.t(view);
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-t10);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -t10);
        }
        eVar.f7037a.d("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void U(View view, View view2, boolean z10, boolean z11, e eVar, float f10, float f11, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof c3.d) {
            c3.d dVar = (c3.d) view2;
            float L = L(view, view2, eVar.f7038b);
            float M = M(view, view2, eVar.f7038b);
            ((FloatingActionButton) view).h(this.f7026c);
            float width = this.f7026c.width() / 2.0f;
            i d10 = eVar.f7037a.d("expansion");
            if (z10) {
                if (!z11) {
                    dVar.setRevealInfo(new d.e(L, M, width));
                }
                if (z11) {
                    width = dVar.getRevealInfo().f4382c;
                }
                animator = c3.a.a(dVar, L, M, f3.a.b(L, M, 0.0f, 0.0f, f10, f11));
                animator.addListener(new d(this, dVar));
                X(view2, d10.c(), (int) L, (int) M, width, list);
            } else {
                float f12 = dVar.getRevealInfo().f4382c;
                Animator a10 = c3.a.a(dVar, L, M, width);
                int i10 = (int) L;
                int i11 = (int) M;
                X(view2, d10.c(), i10, i11, f12, list);
                W(view2, d10.c(), d10.d(), eVar.f7037a.e(), i10, i11, width, list);
                animator = a10;
            }
            d10.a(animator);
            list.add(animator);
            list2.add(c3.a.b(dVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof c3.d) && (view instanceof ImageView)) {
            c3.d dVar = (c3.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z10) {
                if (!z11) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, b3.e.f4096b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, b3.e.f4096b, 255);
            }
            ofInt.addUpdateListener(new b(this, view2));
            eVar.f7037a.d("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(this, dVar, drawable));
        }
    }

    private void W(View view, long j10, long j11, long j12, int i10, int i11, float f10, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j13 = j10 + j11;
            if (j13 < j12) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
                createCircularReveal.setStartDelay(j13);
                createCircularReveal.setDuration(j12 - j13);
                list.add(createCircularReveal);
            }
        }
    }

    private void X(View view, long j10, int i10, int i11, float f10, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j10 <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j10);
        list.add(createCircularReveal);
    }

    private void Y(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i d10;
        h hVar;
        String str;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float N = N(view, view2, eVar.f7038b);
        float O = O(view, view2, eVar.f7038b);
        if (N == 0.0f || O == 0.0f) {
            d10 = eVar.f7037a.d("translationXLinear");
            hVar = eVar.f7037a;
            str = "translationYLinear";
        } else if ((!z10 || O >= 0.0f) && (z10 || O <= 0.0f)) {
            d10 = eVar.f7037a.d("translationXCurveDownwards");
            hVar = eVar.f7037a;
            str = "translationYCurveDownwards";
        } else {
            d10 = eVar.f7037a.d("translationXCurveUpwards");
            hVar = eVar.f7037a;
            str = "translationYCurveUpwards";
        }
        i d11 = hVar.d(str);
        i iVar = d10;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-N);
                view2.setTranslationY(-O);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            K(view2, eVar, iVar, d11, -N, -O, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -N);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -O);
        }
        iVar.a(ofFloat);
        d11.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int Z(View view) {
        ColorStateList p10 = a0.p(view);
        if (p10 != null) {
            return p10.getColorForState(view.getDrawableState(), p10.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup b0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet I(View view, View view2, boolean z10, boolean z11) {
        e a02 = a0(view2.getContext(), z10);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            T(view, view2, z10, z11, a02, arrayList, arrayList2);
        }
        RectF rectF = this.f7027d;
        Y(view, view2, z10, z11, a02, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        V(view, view2, z10, z11, a02, arrayList, arrayList2);
        U(view, view2, z10, z11, a02, width, height, arrayList, arrayList2);
        S(view, view2, z10, z11, a02, arrayList, arrayList2);
        R(view, view2, z10, z11, a02, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        b3.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener(arrayList2.get(i10));
        }
        return animatorSet;
    }

    protected abstract e a0(Context context, boolean z10);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f2153h == 0) {
            fVar.f2153h = 80;
        }
    }
}
