package m;

import F0.b3;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import g.AbstractC0424a;
import java.util.WeakHashMap;

/* renamed from: m.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0558n {

    /* renamed from: a, reason: collision with root package name */
    public final View f5724a;

    /* renamed from: d, reason: collision with root package name */
    public F.c f5727d;

    /* renamed from: e, reason: collision with root package name */
    public F.c f5728e;

    /* renamed from: f, reason: collision with root package name */
    public F.c f5729f;

    /* renamed from: c, reason: collision with root package name */
    public int f5726c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final C0567s f5725b = C0567s.a();

    public C0558n(View view) {
        this.f5724a = view;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, F.c] */
    public final void a() {
        View view = this.f5724a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.f5727d != null) {
                if (this.f5729f == null) {
                    this.f5729f = new Object();
                }
                F.c cVar = this.f5729f;
                cVar.f156c = null;
                cVar.f155b = false;
                cVar.f157d = null;
                cVar.f154a = false;
                WeakHashMap weakHashMap = J.S.f954a;
                ColorStateList c4 = J.J.c(view);
                if (c4 != null) {
                    cVar.f155b = true;
                    cVar.f156c = c4;
                }
                PorterDuff.Mode d2 = J.J.d(view);
                if (d2 != null) {
                    cVar.f154a = true;
                    cVar.f157d = d2;
                }
                if (cVar.f155b || cVar.f154a) {
                    C0567s.d(background, cVar, view.getDrawableState());
                    return;
                }
            }
            F.c cVar2 = this.f5728e;
            if (cVar2 != null) {
                C0567s.d(background, cVar2, view.getDrawableState());
                return;
            }
            F.c cVar3 = this.f5727d;
            if (cVar3 != null) {
                C0567s.d(background, cVar3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        F.c cVar = this.f5728e;
        if (cVar != null) {
            return (ColorStateList) cVar.f156c;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        F.c cVar = this.f5728e;
        if (cVar != null) {
            return (PorterDuff.Mode) cVar.f157d;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i) {
        ColorStateList f4;
        View view = this.f5724a;
        Context context = view.getContext();
        int[] iArr = AbstractC0424a.f4625A;
        b3 t3 = b3.t(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) t3.f470c;
        View view2 = this.f5724a;
        J.S.h(view2, view2.getContext(), iArr, attributeSet, (TypedArray) t3.f470c, i);
        try {
            if (typedArray.hasValue(0)) {
                this.f5726c = typedArray.getResourceId(0, -1);
                C0567s c0567s = this.f5725b;
                Context context2 = view.getContext();
                int i3 = this.f5726c;
                synchronized (c0567s) {
                    f4 = c0567s.f5767a.f(context2, i3);
                }
                if (f4 != null) {
                    g(f4);
                }
            }
            if (typedArray.hasValue(1)) {
                J.J.g(view, t3.n(1));
            }
            if (typedArray.hasValue(2)) {
                J.J.h(view, AbstractC0565q0.c(typedArray.getInt(2, -1), null));
            }
            t3.v();
        } catch (Throwable th) {
            t3.v();
            throw th;
        }
    }

    public final void e() {
        this.f5726c = -1;
        g(null);
        a();
    }

    public final void f(int i) {
        ColorStateList colorStateList;
        this.f5726c = i;
        C0567s c0567s = this.f5725b;
        if (c0567s != null) {
            Context context = this.f5724a.getContext();
            synchronized (c0567s) {
                colorStateList = c0567s.f5767a.f(context, i);
            }
        } else {
            colorStateList = null;
        }
        g(colorStateList);
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, F.c] */
    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f5727d == null) {
                this.f5727d = new Object();
            }
            F.c cVar = this.f5727d;
            cVar.f156c = colorStateList;
            cVar.f155b = true;
        } else {
            this.f5727d = null;
        }
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, F.c] */
    public final void h(ColorStateList colorStateList) {
        if (this.f5728e == null) {
            this.f5728e = new Object();
        }
        F.c cVar = this.f5728e;
        cVar.f156c = colorStateList;
        cVar.f155b = true;
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, F.c] */
    public final void i(PorterDuff.Mode mode) {
        if (this.f5728e == null) {
            this.f5728e = new Object();
        }
        F.c cVar = this.f5728e;
        cVar.f157d = mode;
        cVar.f154a = true;
        a();
    }
}
