package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.o0;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f1387b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static k f1388c;

    /* renamed from: a, reason: collision with root package name */
    private o0 f1389a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements o0.f {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f1390a = {e.e.R, e.e.P, e.e.f8904a};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f1391b = {e.e.f8918o, e.e.B, e.e.f8923t, e.e.f8919p, e.e.f8920q, e.e.f8922s, e.e.f8921r};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f1392c = {e.e.O, e.e.Q, e.e.f8914k, e.e.K, e.e.L, e.e.M, e.e.N};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f1393d = {e.e.f8926w, e.e.f8912i, e.e.f8925v};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f1394e = {e.e.J, e.e.S};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f1395f = {e.e.f8906c, e.e.f8910g, e.e.f8907d, e.e.f8911h};

        a() {
        }

        private boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i10) {
            int c10 = t0.c(context, e.a.f8876w);
            return new ColorStateList(new int[][]{t0.f1522b, t0.f1524d, t0.f1523c, t0.f1526f}, new int[]{t0.b(context, e.a.f8874u), androidx.core.graphics.a.c(c10, i10), androidx.core.graphics.a.c(c10, i10), i10});
        }

        private ColorStateList i(Context context) {
            return h(context, t0.c(context, e.a.f8873t));
        }

        private ColorStateList j(Context context) {
            return h(context, t0.c(context, e.a.f8874u));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i10 = e.a.f8878y;
            ColorStateList e10 = t0.e(context, i10);
            if (e10 == null || !e10.isStateful()) {
                iArr[0] = t0.f1522b;
                iArr2[0] = t0.b(context, i10);
                iArr[1] = t0.f1525e;
                iArr2[1] = t0.c(context, e.a.f8875v);
                iArr[2] = t0.f1526f;
                iArr2[2] = t0.c(context, i10);
            } else {
                iArr[0] = t0.f1522b;
                iArr2[0] = e10.getColorForState(iArr[0], 0);
                iArr[1] = t0.f1525e;
                iArr2[1] = t0.c(context, e.a.f8875v);
                iArr[2] = t0.f1526f;
                iArr2[2] = e10.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(o0 o0Var, Context context, int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable j10 = o0Var.j(context, e.e.F);
            Drawable j11 = o0Var.j(context, e.e.G);
            if ((j10 instanceof BitmapDrawable) && j10.getIntrinsicWidth() == dimensionPixelSize && j10.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) j10;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                j10.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j10.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((j11 instanceof BitmapDrawable) && j11.getIntrinsicWidth() == dimensionPixelSize && j11.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) j11;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                j11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j11.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (g0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = k.f1387b;
            }
            drawable.setColorFilter(k.e(i10, mode));
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
        @Override // androidx.appcompat.widget.o0.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.k.a()
                int[] r1 = r6.f1390a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L17
                int r2 = e.a.f8877x
            L14:
                r8 = -1
            L15:
                r1 = 1
                goto L44
            L17:
                int[] r1 = r6.f1392c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L22
                int r2 = e.a.f8875v
                goto L14
            L22:
                int[] r1 = r6.f1393d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L2d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L14
            L2d:
                int r1 = e.e.f8924u
                if (r8 != r1) goto L3c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L15
            L3c:
                int r1 = e.e.f8915l
                if (r8 != r1) goto L41
                goto L14
            L41:
                r8 = -1
                r1 = 0
                r2 = 0
            L44:
                if (r1 == 0) goto L61
                boolean r1 = androidx.appcompat.widget.g0.a(r9)
                if (r1 == 0) goto L50
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L50:
                int r7 = androidx.appcompat.widget.t0.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.k.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L60
                r9.setAlpha(r8)
            L60:
                return r5
            L61:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.o0.f
        public PorterDuff.Mode b(int i10) {
            if (i10 == e.e.H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.o0.f
        public Drawable c(o0 o0Var, Context context, int i10) {
            int i11;
            if (i10 == e.e.f8913j) {
                return new LayerDrawable(new Drawable[]{o0Var.j(context, e.e.f8912i), o0Var.j(context, e.e.f8914k)});
            }
            if (i10 == e.e.f8928y) {
                i11 = e.d.f8897i;
            } else if (i10 == e.e.f8927x) {
                i11 = e.d.f8898j;
            } else {
                if (i10 != e.e.f8929z) {
                    return null;
                }
                i11 = e.d.f8899k;
            }
            return l(o0Var, context, i11);
        }

        @Override // androidx.appcompat.widget.o0.f
        public ColorStateList d(Context context, int i10) {
            if (i10 == e.e.f8916m) {
                return f.a.a(context, e.c.f8885e);
            }
            if (i10 == e.e.I) {
                return f.a.a(context, e.c.f8888h);
            }
            if (i10 == e.e.H) {
                return k(context);
            }
            if (i10 == e.e.f8909f) {
                return j(context);
            }
            if (i10 == e.e.f8905b) {
                return g(context);
            }
            if (i10 == e.e.f8908e) {
                return i(context);
            }
            if (i10 == e.e.D || i10 == e.e.E) {
                return f.a.a(context, e.c.f8887g);
            }
            if (f(this.f1391b, i10)) {
                return t0.e(context, e.a.f8877x);
            }
            if (f(this.f1394e, i10)) {
                return f.a.a(context, e.c.f8884d);
            }
            if (f(this.f1395f, i10)) {
                return f.a.a(context, e.c.f8883c);
            }
            if (i10 == e.e.A) {
                return f.a.a(context, e.c.f8886f);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.o0.f
        public boolean e(Context context, int i10, Drawable drawable) {
            Drawable findDrawableByLayerId;
            int c10;
            if (i10 == e.e.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(R.id.background);
                int i11 = e.a.f8877x;
                m(findDrawableByLayerId2, t0.c(context, i11), k.f1387b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), t0.c(context, i11), k.f1387b);
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.progress);
                c10 = t0.c(context, e.a.f8875v);
            } else {
                if (i10 != e.e.f8928y && i10 != e.e.f8927x && i10 != e.e.f8929z) {
                    return false;
                }
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                m(layerDrawable2.findDrawableByLayerId(R.id.background), t0.b(context, e.a.f8877x), k.f1387b);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
                int i12 = e.a.f8875v;
                m(findDrawableByLayerId3, t0.c(context, i12), k.f1387b);
                findDrawableByLayerId = layerDrawable2.findDrawableByLayerId(R.id.progress);
                c10 = t0.c(context, i12);
            }
            m(findDrawableByLayerId, c10, k.f1387b);
            return true;
        }
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            if (f1388c == null) {
                h();
            }
            kVar = f1388c;
        }
        return kVar;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter l10;
        synchronized (k.class) {
            l10 = o0.l(i10, mode);
        }
        return l10;
    }

    public static synchronized void h() {
        synchronized (k.class) {
            if (f1388c == null) {
                k kVar = new k();
                f1388c = kVar;
                kVar.f1389a = o0.h();
                f1388c.f1389a.u(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, w0 w0Var, int[] iArr) {
        o0.w(drawable, w0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i10) {
        return this.f1389a.j(context, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i10, boolean z10) {
        return this.f1389a.k(context, i10, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i10) {
        return this.f1389a.m(context, i10);
    }

    public synchronized void g(Context context) {
        this.f1389a.s(context);
    }
}
