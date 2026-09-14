package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.uh.sf.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import r0.AbstractC0642a;
import t.AbstractC0692h;
import t.C0691g;
import t.C0693i;
import t.C0695k;
import u.AbstractC0717a;

/* loaded from: classes.dex */
public final class Q0 {

    /* renamed from: g, reason: collision with root package name */
    public static Q0 f5577g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f5579a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f5580b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f5581c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5582d;

    /* renamed from: e, reason: collision with root package name */
    public R1.n f5583e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f5576f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    public static final P0 f5578h = new C0693i(6);

    public static synchronized Q0 b() {
        Q0 q02;
        synchronized (Q0.class) {
            try {
                if (f5577g == null) {
                    f5577g = new Q0();
                }
                q02 = f5577g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return q02;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (Q0.class) {
            P0 p02 = f5578h;
            p02.getClass();
            int i3 = (31 + i) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) p02.get(Integer.valueOf(mode.hashCode() + i3));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            }
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i) {
        Drawable drawable;
        if (this.f5581c == null) {
            this.f5581c = new TypedValue();
        }
        TypedValue typedValue = this.f5581c;
        context.getResources().getValue(i, typedValue, true);
        long j2 = (typedValue.assetCookie << 32) | typedValue.data;
        synchronized (this) {
            C0691g c0691g = (C0691g) this.f5580b.get(context);
            drawable = null;
            if (c0691g != null) {
                WeakReference weakReference = (WeakReference) c0691g.b(j2);
                if (weakReference != null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                    if (constantState != null) {
                        drawable = constantState.newDrawable(context.getResources());
                    } else {
                        int b4 = AbstractC0717a.b(c0691g.f6359b, c0691g.f6361d, j2);
                        if (b4 >= 0) {
                            Object[] objArr = c0691g.f6360c;
                            Object obj = objArr[b4];
                            Object obj2 = AbstractC0692h.f6362a;
                            if (obj != obj2) {
                                objArr[b4] = obj2;
                                c0691g.f6358a = true;
                            }
                        }
                    }
                }
            }
        }
        if (drawable != null) {
            return drawable;
        }
        LayerDrawable layerDrawable = null;
        if (this.f5583e != null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, 2131230737)});
            } else if (i == R.drawable.abc_ratingbar_material) {
                layerDrawable = R1.n.d(this, context, R.dimen.abc_star_big);
            } else if (i == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawable = R1.n.d(this, context, R.dimen.abc_star_medium);
            } else if (i == R.drawable.abc_ratingbar_small_material) {
                layerDrawable = R1.n.d(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            synchronized (this) {
                try {
                    Drawable.ConstantState constantState2 = layerDrawable.getConstantState();
                    if (constantState2 != null) {
                        C0691g c0691g2 = (C0691g) this.f5580b.get(context);
                        if (c0691g2 == null) {
                            c0691g2 = new C0691g();
                            this.f5580b.put(context, c0691g2);
                        }
                        c0691g2.d(j2, new WeakReference(constantState2));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return layerDrawable;
        }
        return layerDrawable;
    }

    public final synchronized Drawable c(Context context, int i) {
        return d(context, i, false);
    }

    public final synchronized Drawable d(Context context, int i, boolean z3) {
        Drawable a2;
        try {
            if (!this.f5582d) {
                this.f5582d = true;
                Drawable c4 = c(context, R.drawable.abc_vector_test);
                if (c4 == null || (!(c4 instanceof AbstractC0642a) && !"android.graphics.drawable.VectorDrawable".equals(c4.getClass().getName()))) {
                    this.f5582d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            a2 = a(context, i);
            if (a2 == null) {
                a2 = context.getDrawable(i);
            }
            if (a2 != null) {
                a2 = g(context, i, z3, a2);
            }
            if (a2 != null) {
                AbstractC0565q0.a(a2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a2;
    }

    public final synchronized ColorStateList f(Context context, int i) {
        ColorStateList colorStateList;
        C0695k c0695k;
        WeakHashMap weakHashMap = this.f5579a;
        ColorStateList colorStateList2 = null;
        if (weakHashMap != null && (c0695k = (C0695k) weakHashMap.get(context)) != null) {
            colorStateList = (ColorStateList) c0695k.b(i);
        } else {
            colorStateList = null;
        }
        if (colorStateList == null) {
            R1.n nVar = this.f5583e;
            if (nVar != null) {
                colorStateList2 = nVar.f(context, i);
            }
            if (colorStateList2 != null) {
                if (this.f5579a == null) {
                    this.f5579a = new WeakHashMap();
                }
                C0695k c0695k2 = (C0695k) this.f5579a.get(context);
                if (c0695k2 == null) {
                    c0695k2 = new C0695k();
                    this.f5579a.put(context, c0695k2);
                }
                c0695k2.a(i, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r10, int r11, boolean r12, android.graphics.drawable.Drawable r13) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.Q0.g(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
