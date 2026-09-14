package androidx.constraintlayout.motion.widget;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import r.c;
import r.d;
import r.e;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    boolean f1621a;

    /* renamed from: b, reason: collision with root package name */
    private k f1622b;

    /* renamed from: c, reason: collision with root package name */
    private k f1623c;

    /* renamed from: d, reason: collision with root package name */
    private f f1624d;

    /* renamed from: e, reason: collision with root package name */
    private f f1625e;

    /* renamed from: f, reason: collision with root package name */
    private n.a[] f1626f;

    /* renamed from: g, reason: collision with root package name */
    private n.a f1627g;

    /* renamed from: h, reason: collision with root package name */
    float f1628h;

    /* renamed from: i, reason: collision with root package name */
    float f1629i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f1630j;

    /* renamed from: k, reason: collision with root package name */
    private double[] f1631k;

    /* renamed from: l, reason: collision with root package name */
    private double[] f1632l;

    /* renamed from: m, reason: collision with root package name */
    private String[] f1633m;

    /* renamed from: n, reason: collision with root package name */
    private float[] f1634n;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList<k> f1635o;

    /* renamed from: p, reason: collision with root package name */
    private HashMap<String, r.e> f1636p;

    /* renamed from: q, reason: collision with root package name */
    private HashMap<String, r.d> f1637q;

    /* renamed from: r, reason: collision with root package name */
    private HashMap<String, r.c> f1638r;

    /* renamed from: s, reason: collision with root package name */
    private e[] f1639s;

    /* renamed from: t, reason: collision with root package name */
    private int f1640t;

    /* renamed from: u, reason: collision with root package name */
    private View f1641u;

    /* renamed from: v, reason: collision with root package name */
    private int f1642v;

    /* renamed from: w, reason: collision with root package name */
    private float f1643w;

    /* renamed from: x, reason: collision with root package name */
    private Interpolator f1644x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f1645y;

    private float a(float f10, float[] fArr) {
        float f11 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f12 = this.f1629i;
            if (f12 != 1.0d) {
                float f13 = this.f1628h;
                if (f10 < f13) {
                    f10 = 0.0f;
                }
                if (f10 > f13 && f10 < 1.0d) {
                    f10 = Math.min((f10 - f13) * f12, 1.0f);
                }
            }
        }
        n.b bVar = this.f1622b.f1682f;
        float f14 = Float.NaN;
        Iterator<k> it = this.f1635o.iterator();
        while (it.hasNext()) {
            k next = it.next();
            n.b bVar2 = next.f1682f;
            if (bVar2 != null) {
                float f15 = next.f1684h;
                if (f15 < f10) {
                    bVar = bVar2;
                    f11 = f15;
                } else if (Float.isNaN(f14)) {
                    f14 = next.f1684h;
                }
            }
        }
        if (bVar != null) {
            float f16 = (Float.isNaN(f14) ? 1.0f : f14) - f11;
            double d10 = (f10 - f11) / f16;
            f10 = (((float) bVar.a(d10)) * f16) + f11;
            if (fArr != null) {
                fArr[0] = (float) bVar.b(d10);
            }
        }
        return f10;
    }

    public void b(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f1626f[0].b(d10, dArr);
        this.f1626f[0].d(d10, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f1622b.k(d10, this.f1630j, dArr, fArr, dArr2, fArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view, float f10, long j10, n.c cVar) {
        e.a aVar;
        boolean z10;
        char c10;
        double d10;
        float a10 = a(f10, null);
        int i10 = this.f1642v;
        if (i10 != d.f1618a) {
            float f11 = 1.0f / i10;
            float floor = ((float) Math.floor(a10 / f11)) * f11;
            float f12 = (a10 % f11) / f11;
            if (!Float.isNaN(this.f1643w)) {
                f12 = (f12 + this.f1643w) % 1.0f;
            }
            Interpolator interpolator = this.f1644x;
            a10 = ((interpolator != null ? interpolator.getInterpolation(f12) : ((double) f12) > 0.5d ? 1.0f : 0.0f) * f11) + floor;
        }
        float f13 = a10;
        HashMap<String, r.d> hashMap = this.f1637q;
        if (hashMap != null) {
            Iterator<r.d> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().b(view, f13);
            }
        }
        HashMap<String, r.e> hashMap2 = this.f1636p;
        if (hashMap2 != null) {
            e.a aVar2 = null;
            boolean z11 = false;
            for (r.e eVar : hashMap2.values()) {
                if (eVar instanceof e.a) {
                    aVar2 = (e.a) eVar;
                } else {
                    z11 |= eVar.b(view, f13, j10, cVar);
                }
            }
            z10 = z11;
            aVar = aVar2;
        } else {
            aVar = null;
            z10 = false;
        }
        n.a[] aVarArr = this.f1626f;
        if (aVarArr != null) {
            double d11 = f13;
            aVarArr[0].b(d11, this.f1631k);
            this.f1626f[0].d(d11, this.f1632l);
            n.a aVar3 = this.f1627g;
            if (aVar3 != null) {
                double[] dArr = this.f1631k;
                if (dArr.length > 0) {
                    aVar3.b(d11, dArr);
                    this.f1627g.d(d11, this.f1632l);
                }
            }
            if (this.f1645y) {
                d10 = d11;
            } else {
                d10 = d11;
                this.f1622b.l(f13, view, this.f1630j, this.f1631k, this.f1632l, null, this.f1621a);
                this.f1621a = false;
            }
            if (this.f1640t != d.f1618a) {
                if (this.f1641u == null) {
                    this.f1641u = ((View) view.getParent()).findViewById(this.f1640t);
                }
                if (this.f1641u != null) {
                    float top = (r1.getTop() + this.f1641u.getBottom()) / 2.0f;
                    float left = (this.f1641u.getLeft() + this.f1641u.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap<String, r.d> hashMap3 = this.f1637q;
            if (hashMap3 != null) {
                for (r.d dVar : hashMap3.values()) {
                    if (dVar instanceof d.a) {
                        double[] dArr2 = this.f1632l;
                        if (dArr2.length > 1) {
                            ((d.a) dVar).c(view, f13, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (aVar != null) {
                double[] dArr3 = this.f1632l;
                c10 = 1;
                z10 |= aVar.c(view, cVar, f13, j10, dArr3[0], dArr3[1]);
            } else {
                c10 = 1;
            }
            int i11 = 1;
            while (true) {
                n.a[] aVarArr2 = this.f1626f;
                if (i11 >= aVarArr2.length) {
                    break;
                }
                aVarArr2[i11].c(d10, this.f1634n);
                r.a.b(this.f1622b.f1694r.get(this.f1633m[i11 - 1]), view, this.f1634n);
                i11++;
            }
            f fVar = this.f1624d;
            if (fVar.f1619f == 0) {
                if (f13 > 0.0f) {
                    if (f13 >= 1.0f) {
                        fVar = this.f1625e;
                    } else if (this.f1625e.f1620g != fVar.f1620g) {
                        view.setVisibility(0);
                    }
                }
                view.setVisibility(fVar.f1620g);
            }
            if (this.f1639s != null) {
                int i12 = 0;
                while (true) {
                    e[] eVarArr = this.f1639s;
                    if (i12 >= eVarArr.length) {
                        break;
                    }
                    eVarArr[i12].a(f13, view);
                    i12++;
                }
            }
        } else {
            c10 = 1;
            k kVar = this.f1622b;
            float f14 = kVar.f1686j;
            k kVar2 = this.f1623c;
            float f15 = f14 + ((kVar2.f1686j - f14) * f13);
            float f16 = kVar.f1687k;
            float f17 = f16 + ((kVar2.f1687k - f16) * f13);
            float f18 = kVar.f1688l;
            float f19 = kVar2.f1688l;
            float f20 = kVar.f1689m;
            float f21 = kVar2.f1689m;
            float f22 = f15 + 0.5f;
            int i13 = (int) f22;
            float f23 = f17 + 0.5f;
            int i14 = (int) f23;
            int i15 = (int) (f22 + ((f19 - f18) * f13) + f18);
            int i16 = (int) (f23 + ((f21 - f20) * f13) + f20);
            int i17 = i15 - i13;
            int i18 = i16 - i14;
            if (f19 != f18 || f21 != f20 || this.f1621a) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
                this.f1621a = false;
            }
            view.layout(i13, i14, i15, i16);
        }
        HashMap<String, r.c> hashMap4 = this.f1638r;
        if (hashMap4 != null) {
            for (r.c cVar2 : hashMap4.values()) {
                if (cVar2 instanceof c.a) {
                    double[] dArr4 = this.f1632l;
                    ((c.a) cVar2).c(view, f13, dArr4[0], dArr4[c10]);
                } else {
                    cVar2.b(view, f13);
                }
            }
        }
        return z10;
    }

    public String toString() {
        return " start: x: " + this.f1622b.f1686j + " y: " + this.f1622b.f1687k + " end: x: " + this.f1623c.f1686j + " y: " + this.f1623c.f1687k;
    }
}
