package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* renamed from: m.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0567s {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f5765b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static C0567s f5766c;

    /* renamed from: a, reason: collision with root package name */
    public Q0 f5767a;

    public static synchronized C0567s a() {
        C0567s c0567s;
        synchronized (C0567s.class) {
            try {
                if (f5766c == null) {
                    c();
                }
                c0567s = f5766c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0567s;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [m.s, java.lang.Object] */
    public static synchronized void c() {
        synchronized (C0567s.class) {
            if (f5766c == null) {
                ?? obj = new Object();
                f5766c = obj;
                obj.f5767a = Q0.b();
                Q0 q02 = f5766c.f5767a;
                R1.n nVar = new R1.n();
                synchronized (q02) {
                    q02.f5583e = nVar;
                }
            }
        }
    }

    public static void d(Drawable drawable, F.c cVar, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = Q0.f5576f;
        int[] state = drawable.getState();
        int[] iArr2 = AbstractC0565q0.f5752a;
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z3 = cVar.f155b;
            if (!z3 && !cVar.f154a) {
                drawable.clearColorFilter();
                return;
            }
            PorterDuffColorFilter porterDuffColorFilter = null;
            if (z3) {
                colorStateList = (ColorStateList) cVar.f156c;
            } else {
                colorStateList = null;
            }
            if (cVar.f154a) {
                mode = (PorterDuff.Mode) cVar.f157d;
            } else {
                mode = Q0.f5576f;
            }
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = Q0.e(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        }
    }

    public final synchronized Drawable b(Context context, int i) {
        return this.f5767a.c(context, i);
    }
}
