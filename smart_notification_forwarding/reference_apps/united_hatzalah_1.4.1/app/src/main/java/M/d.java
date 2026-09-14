package M;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import com.google.firebase.messaging.ServiceStarter;
import m.C0576w0;

/* loaded from: classes.dex */
public final class d implements View.OnTouchListener {

    /* renamed from: u, reason: collision with root package name */
    public static final int f1362u = ViewConfiguration.getTapTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final a f1363a;

    /* renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f1364b;

    /* renamed from: c, reason: collision with root package name */
    public final C0576w0 f1365c;

    /* renamed from: d, reason: collision with root package name */
    public G.a f1366d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f1367e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f1368f;

    /* renamed from: j, reason: collision with root package name */
    public final int f1369j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1370k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f1371l;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f1372m;

    /* renamed from: n, reason: collision with root package name */
    public final float[] f1373n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1374o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1375q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1376r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1377s;

    /* renamed from: t, reason: collision with root package name */
    public final C0576w0 f1378t;

    /* JADX WARN: Type inference failed for: r0v0, types: [M.a, java.lang.Object] */
    public d(C0576w0 c0576w0) {
        ?? obj = new Object();
        obj.f1358e = Long.MIN_VALUE;
        obj.f1360g = -1L;
        obj.f1359f = 0L;
        this.f1363a = obj;
        this.f1364b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f1367e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1368f = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f1371l = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f1372m = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1373n = fArr5;
        this.f1365c = c0576w0;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        float f5 = ((int) ((1575.0f * f4) + 0.5f)) / 1000.0f;
        fArr5[0] = f5;
        fArr5[1] = f5;
        float f6 = ((int) ((f4 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f6;
        fArr4[1] = f6;
        this.f1369j = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f1370k = f1362u;
        obj.f1354a = ServiceStarter.ERROR_UNKNOWN;
        obj.f1355b = ServiceStarter.ERROR_UNKNOWN;
        this.f1378t = c0576w0;
    }

    public static float b(float f4, float f5, float f6) {
        if (f4 > f6) {
            return f6;
        }
        if (f4 < f5) {
            return f5;
        }
        return f4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f1367e
            r0 = r0[r4]
            float[] r1 = r3.f1368f
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f1364b
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f1371l
            r0 = r0[r4]
            float[] r1 = r3.f1372m
            r1 = r1[r4]
            float[] r2 = r3.f1373n
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L51:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: M.d.a(int, float, float, float):float");
    }

    public final float c(float f4, float f5) {
        if (f5 != 0.0f) {
            int i = this.f1369j;
            if (i != 0 && i != 1) {
                if (i == 2 && f4 < 0.0f) {
                    return f4 / (-f5);
                }
            } else if (f4 < f5) {
                if (f4 >= 0.0f) {
                    return 1.0f - (f4 / f5);
                }
                if (this.f1376r && i == 1) {
                    return 1.0f;
                }
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.p) {
            this.f1376r = false;
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        a aVar = this.f1363a;
        int i3 = (int) (currentAnimationTimeMillis - aVar.f1358e);
        int i4 = aVar.f1355b;
        if (i3 > i4) {
            i = i4;
        } else if (i3 >= 0) {
            i = i3;
        }
        aVar.i = i;
        aVar.f1361h = aVar.a(currentAnimationTimeMillis);
        aVar.f1360g = currentAnimationTimeMillis;
    }

    public final boolean e() {
        C0576w0 c0576w0;
        int count;
        a aVar = this.f1363a;
        float f4 = aVar.f1357d;
        int abs = (int) (f4 / Math.abs(f4));
        Math.abs(aVar.f1356c);
        if (abs != 0 && (count = (c0576w0 = this.f1378t).getCount()) != 0) {
            int childCount = c0576w0.getChildCount();
            int firstVisiblePosition = c0576w0.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && c0576w0.getChildAt(0).getTop() >= 0)) : !(i >= count && c0576w0.getChildAt(childCount - 1).getBottom() <= c0576w0.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f1377s
            r1 = 0
            if (r0 != 0) goto L7
            goto L7c
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7c
        L17:
            r7.d()
            return r1
        L1b:
            r7.f1375q = r2
            r7.f1374o = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            m.w0 r4 = r7.f1365c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            M.a r9 = r7.f1363a
            r9.f1356c = r0
            r9.f1357d = r8
            boolean r8 = r7.f1376r
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            G.a r8 = r7.f1366d
            if (r8 != 0) goto L60
            G.a r8 = new G.a
            r8.<init>(r7, r2)
            r7.f1366d = r8
        L60:
            r7.f1376r = r2
            r7.p = r2
            boolean r8 = r7.f1374o
            if (r8 != 0) goto L75
            int r8 = r7.f1370k
            if (r8 <= 0) goto L75
            G.a r9 = r7.f1366d
            long r5 = (long) r8
            java.util.WeakHashMap r8 = J.S.f954a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            G.a r8 = r7.f1366d
            r8.run()
        L7a:
            r7.f1374o = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: M.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
