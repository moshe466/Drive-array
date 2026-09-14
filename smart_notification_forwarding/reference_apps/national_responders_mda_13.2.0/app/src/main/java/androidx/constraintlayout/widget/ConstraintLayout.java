package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p.d;
import p.e;
import q.b;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: y, reason: collision with root package name */
    private static k f1698y;

    /* renamed from: f, reason: collision with root package name */
    SparseArray<View> f1699f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<androidx.constraintlayout.widget.c> f1700g;

    /* renamed from: h, reason: collision with root package name */
    protected p.f f1701h;

    /* renamed from: i, reason: collision with root package name */
    private int f1702i;

    /* renamed from: j, reason: collision with root package name */
    private int f1703j;

    /* renamed from: k, reason: collision with root package name */
    private int f1704k;

    /* renamed from: l, reason: collision with root package name */
    private int f1705l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f1706m;

    /* renamed from: n, reason: collision with root package name */
    private int f1707n;

    /* renamed from: o, reason: collision with root package name */
    private e f1708o;

    /* renamed from: p, reason: collision with root package name */
    protected d f1709p;

    /* renamed from: q, reason: collision with root package name */
    private int f1710q;

    /* renamed from: r, reason: collision with root package name */
    private HashMap<String, Integer> f1711r;

    /* renamed from: s, reason: collision with root package name */
    private int f1712s;

    /* renamed from: t, reason: collision with root package name */
    private int f1713t;

    /* renamed from: u, reason: collision with root package name */
    private SparseArray<p.e> f1714u;

    /* renamed from: v, reason: collision with root package name */
    c f1715v;

    /* renamed from: w, reason: collision with root package name */
    private int f1716w;

    /* renamed from: x, reason: collision with root package name */
    private int f1717x;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1718a;

        static {
            int[] iArr = new int[e.b.values().length];
            f1718a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1718a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1718a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1718a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;

        /* renamed from: a, reason: collision with root package name */
        public int f1719a;

        /* renamed from: a0, reason: collision with root package name */
        boolean f1720a0;

        /* renamed from: b, reason: collision with root package name */
        public int f1721b;

        /* renamed from: b0, reason: collision with root package name */
        boolean f1722b0;

        /* renamed from: c, reason: collision with root package name */
        public float f1723c;

        /* renamed from: c0, reason: collision with root package name */
        boolean f1724c0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1725d;

        /* renamed from: d0, reason: collision with root package name */
        boolean f1726d0;

        /* renamed from: e, reason: collision with root package name */
        public int f1727e;

        /* renamed from: e0, reason: collision with root package name */
        boolean f1728e0;

        /* renamed from: f, reason: collision with root package name */
        public int f1729f;

        /* renamed from: f0, reason: collision with root package name */
        boolean f1730f0;

        /* renamed from: g, reason: collision with root package name */
        public int f1731g;

        /* renamed from: g0, reason: collision with root package name */
        boolean f1732g0;

        /* renamed from: h, reason: collision with root package name */
        public int f1733h;

        /* renamed from: h0, reason: collision with root package name */
        int f1734h0;

        /* renamed from: i, reason: collision with root package name */
        public int f1735i;

        /* renamed from: i0, reason: collision with root package name */
        int f1736i0;

        /* renamed from: j, reason: collision with root package name */
        public int f1737j;

        /* renamed from: j0, reason: collision with root package name */
        int f1738j0;

        /* renamed from: k, reason: collision with root package name */
        public int f1739k;

        /* renamed from: k0, reason: collision with root package name */
        int f1740k0;

        /* renamed from: l, reason: collision with root package name */
        public int f1741l;

        /* renamed from: l0, reason: collision with root package name */
        int f1742l0;

        /* renamed from: m, reason: collision with root package name */
        public int f1743m;

        /* renamed from: m0, reason: collision with root package name */
        int f1744m0;

        /* renamed from: n, reason: collision with root package name */
        public int f1745n;

        /* renamed from: n0, reason: collision with root package name */
        float f1746n0;

        /* renamed from: o, reason: collision with root package name */
        public int f1747o;

        /* renamed from: o0, reason: collision with root package name */
        int f1748o0;

        /* renamed from: p, reason: collision with root package name */
        public int f1749p;

        /* renamed from: p0, reason: collision with root package name */
        int f1750p0;

        /* renamed from: q, reason: collision with root package name */
        public int f1751q;

        /* renamed from: q0, reason: collision with root package name */
        float f1752q0;

        /* renamed from: r, reason: collision with root package name */
        public float f1753r;

        /* renamed from: r0, reason: collision with root package name */
        p.e f1754r0;

        /* renamed from: s, reason: collision with root package name */
        public int f1755s;

        /* renamed from: t, reason: collision with root package name */
        public int f1756t;

        /* renamed from: u, reason: collision with root package name */
        public int f1757u;

        /* renamed from: v, reason: collision with root package name */
        public int f1758v;

        /* renamed from: w, reason: collision with root package name */
        public int f1759w;

        /* renamed from: x, reason: collision with root package name */
        public int f1760x;

        /* renamed from: y, reason: collision with root package name */
        public int f1761y;

        /* renamed from: z, reason: collision with root package name */
        public int f1762z;

        /* loaded from: classes.dex */
        private static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f1763a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1763a = sparseIntArray;
                sparseIntArray.append(j.Z1, 64);
                sparseIntArray.append(j.C1, 65);
                sparseIntArray.append(j.L1, 8);
                sparseIntArray.append(j.M1, 9);
                sparseIntArray.append(j.O1, 10);
                sparseIntArray.append(j.P1, 11);
                sparseIntArray.append(j.V1, 12);
                sparseIntArray.append(j.U1, 13);
                sparseIntArray.append(j.f2067s1, 14);
                sparseIntArray.append(j.f2060r1, 15);
                sparseIntArray.append(j.f2031n1, 16);
                sparseIntArray.append(j.f2046p1, 52);
                sparseIntArray.append(j.f2039o1, 53);
                sparseIntArray.append(j.f2074t1, 2);
                sparseIntArray.append(j.f2088v1, 3);
                sparseIntArray.append(j.f2081u1, 4);
                sparseIntArray.append(j.f1960e2, 49);
                sparseIntArray.append(j.f1968f2, 50);
                sparseIntArray.append(j.f2116z1, 5);
                sparseIntArray.append(j.A1, 6);
                sparseIntArray.append(j.B1, 7);
                sparseIntArray.append(j.f1991i1, 67);
                sparseIntArray.append(j.V0, 1);
                sparseIntArray.append(j.Q1, 17);
                sparseIntArray.append(j.R1, 18);
                sparseIntArray.append(j.f2109y1, 19);
                sparseIntArray.append(j.f2102x1, 20);
                sparseIntArray.append(j.f2000j2, 21);
                sparseIntArray.append(j.f2024m2, 22);
                sparseIntArray.append(j.f2008k2, 23);
                sparseIntArray.append(j.f1984h2, 24);
                sparseIntArray.append(j.f2016l2, 25);
                sparseIntArray.append(j.f1992i2, 26);
                sparseIntArray.append(j.f1976g2, 55);
                sparseIntArray.append(j.f2032n2, 54);
                sparseIntArray.append(j.H1, 29);
                sparseIntArray.append(j.W1, 30);
                sparseIntArray.append(j.f2095w1, 44);
                sparseIntArray.append(j.J1, 45);
                sparseIntArray.append(j.Y1, 46);
                sparseIntArray.append(j.I1, 47);
                sparseIntArray.append(j.X1, 48);
                sparseIntArray.append(j.f2015l1, 27);
                sparseIntArray.append(j.f2007k1, 28);
                sparseIntArray.append(j.f1928a2, 31);
                sparseIntArray.append(j.D1, 32);
                sparseIntArray.append(j.f1944c2, 33);
                sparseIntArray.append(j.f1936b2, 34);
                sparseIntArray.append(j.f1952d2, 35);
                sparseIntArray.append(j.F1, 36);
                sparseIntArray.append(j.E1, 37);
                sparseIntArray.append(j.G1, 38);
                sparseIntArray.append(j.K1, 39);
                sparseIntArray.append(j.T1, 40);
                sparseIntArray.append(j.N1, 41);
                sparseIntArray.append(j.f2053q1, 42);
                sparseIntArray.append(j.f2023m1, 43);
                sparseIntArray.append(j.S1, 51);
                sparseIntArray.append(j.f2047p2, 66);
            }
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f1719a = -1;
            this.f1721b = -1;
            this.f1723c = -1.0f;
            this.f1725d = true;
            this.f1727e = -1;
            this.f1729f = -1;
            this.f1731g = -1;
            this.f1733h = -1;
            this.f1735i = -1;
            this.f1737j = -1;
            this.f1739k = -1;
            this.f1741l = -1;
            this.f1743m = -1;
            this.f1745n = -1;
            this.f1747o = -1;
            this.f1749p = -1;
            this.f1751q = 0;
            this.f1753r = 0.0f;
            this.f1755s = -1;
            this.f1756t = -1;
            this.f1757u = -1;
            this.f1758v = -1;
            this.f1759w = Integer.MIN_VALUE;
            this.f1760x = Integer.MIN_VALUE;
            this.f1761y = Integer.MIN_VALUE;
            this.f1762z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1720a0 = true;
            this.f1722b0 = true;
            this.f1724c0 = false;
            this.f1726d0 = false;
            this.f1728e0 = false;
            this.f1730f0 = false;
            this.f1732g0 = false;
            this.f1734h0 = -1;
            this.f1736i0 = -1;
            this.f1738j0 = -1;
            this.f1740k0 = -1;
            this.f1742l0 = Integer.MIN_VALUE;
            this.f1744m0 = Integer.MIN_VALUE;
            this.f1746n0 = 0.5f;
            this.f1754r0 = new p.e();
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1719a = -1;
            this.f1721b = -1;
            this.f1723c = -1.0f;
            this.f1725d = true;
            this.f1727e = -1;
            this.f1729f = -1;
            this.f1731g = -1;
            this.f1733h = -1;
            this.f1735i = -1;
            this.f1737j = -1;
            this.f1739k = -1;
            this.f1741l = -1;
            this.f1743m = -1;
            this.f1745n = -1;
            this.f1747o = -1;
            this.f1749p = -1;
            this.f1751q = 0;
            this.f1753r = 0.0f;
            this.f1755s = -1;
            this.f1756t = -1;
            this.f1757u = -1;
            this.f1758v = -1;
            this.f1759w = Integer.MIN_VALUE;
            this.f1760x = Integer.MIN_VALUE;
            this.f1761y = Integer.MIN_VALUE;
            this.f1762z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1720a0 = true;
            this.f1722b0 = true;
            this.f1724c0 = false;
            this.f1726d0 = false;
            this.f1728e0 = false;
            this.f1730f0 = false;
            this.f1732g0 = false;
            this.f1734h0 = -1;
            this.f1736i0 = -1;
            this.f1738j0 = -1;
            this.f1740k0 = -1;
            this.f1742l0 = Integer.MIN_VALUE;
            this.f1744m0 = Integer.MIN_VALUE;
            this.f1746n0 = 0.5f;
            this.f1754r0 = new p.e();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.U0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = a.f1763a.get(index);
                switch (i11) {
                    case 1:
                        this.V = obtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1749p);
                        this.f1749p = resourceId;
                        if (resourceId == -1) {
                            this.f1749p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f1751q = obtainStyledAttributes.getDimensionPixelSize(index, this.f1751q);
                        break;
                    case 4:
                        float f10 = obtainStyledAttributes.getFloat(index, this.f1753r) % 360.0f;
                        this.f1753r = f10;
                        if (f10 < 0.0f) {
                            this.f1753r = (360.0f - f10) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f1719a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1719a);
                        break;
                    case 6:
                        this.f1721b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1721b);
                        break;
                    case 7:
                        this.f1723c = obtainStyledAttributes.getFloat(index, this.f1723c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1727e);
                        this.f1727e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1727e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1729f);
                        this.f1729f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1729f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1731g);
                        this.f1731g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1731g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1733h);
                        this.f1733h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1733h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1735i);
                        this.f1735i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1735i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1737j);
                        this.f1737j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1737j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1739k);
                        this.f1739k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1739k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1741l);
                        this.f1741l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1741l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f1743m);
                        this.f1743m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1743m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f1755s);
                        this.f1755s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1755s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1756t);
                        this.f1756t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1756t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f1757u);
                        this.f1757u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1757u = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f1758v);
                        this.f1758v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1758v = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f1759w = obtainStyledAttributes.getDimensionPixelSize(index, this.f1759w);
                        break;
                    case 22:
                        this.f1760x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1760x);
                        break;
                    case 23:
                        this.f1761y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1761y);
                        break;
                    case 24:
                        this.f1762z = obtainStyledAttributes.getDimensionPixelSize(index, this.f1762z);
                        break;
                    case 25:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.W = obtainStyledAttributes.getBoolean(index, this.W);
                        break;
                    case 28:
                        this.X = obtainStyledAttributes.getBoolean(index, this.X);
                        break;
                    case 29:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 30:
                        this.F = obtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 31:
                        this.L = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.M = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.P) == -2) {
                                this.P = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.R = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.R));
                        this.L = 2;
                        break;
                    case j.f1983h1 /* 36 */:
                        try {
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.O) == -2) {
                                this.O = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.Q) == -2) {
                                this.Q = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case j.W4 /* 38 */:
                        this.S = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.S));
                        this.M = 2;
                        break;
                    default:
                        switch (i11) {
                            case j.f1947c5 /* 44 */:
                                e.o(this, obtainStyledAttributes.getString(index));
                                break;
                            case j.f1955d5 /* 45 */:
                                this.H = obtainStyledAttributes.getFloat(index, this.H);
                                break;
                            case j.f1963e5 /* 46 */:
                                this.I = obtainStyledAttributes.getFloat(index, this.I);
                                break;
                            case j.f1971f5 /* 47 */:
                                this.J = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case j.f1979g5 /* 48 */:
                                this.K = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case j.f1987h5 /* 49 */:
                                this.T = obtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                                break;
                            case j.f1995i5 /* 50 */:
                                this.U = obtainStyledAttributes.getDimensionPixelOffset(index, this.U);
                                break;
                            case j.f2003j5 /* 51 */:
                                this.Y = obtainStyledAttributes.getString(index);
                                break;
                            case j.f2011k5 /* 52 */:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f1745n);
                                this.f1745n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f1745n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case j.f2019l5 /* 53 */:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f1747o);
                                this.f1747o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f1747o = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        e.m(this, obtainStyledAttributes, index, 0);
                                        break;
                                    case 65:
                                        e.m(this, obtainStyledAttributes, index, 1);
                                        break;
                                    case 66:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 67:
                                        this.f1725d = obtainStyledAttributes.getBoolean(index, this.f1725d);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1719a = -1;
            this.f1721b = -1;
            this.f1723c = -1.0f;
            this.f1725d = true;
            this.f1727e = -1;
            this.f1729f = -1;
            this.f1731g = -1;
            this.f1733h = -1;
            this.f1735i = -1;
            this.f1737j = -1;
            this.f1739k = -1;
            this.f1741l = -1;
            this.f1743m = -1;
            this.f1745n = -1;
            this.f1747o = -1;
            this.f1749p = -1;
            this.f1751q = 0;
            this.f1753r = 0.0f;
            this.f1755s = -1;
            this.f1756t = -1;
            this.f1757u = -1;
            this.f1758v = -1;
            this.f1759w = Integer.MIN_VALUE;
            this.f1760x = Integer.MIN_VALUE;
            this.f1761y = Integer.MIN_VALUE;
            this.f1762z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1720a0 = true;
            this.f1722b0 = true;
            this.f1724c0 = false;
            this.f1726d0 = false;
            this.f1728e0 = false;
            this.f1730f0 = false;
            this.f1732g0 = false;
            this.f1734h0 = -1;
            this.f1736i0 = -1;
            this.f1738j0 = -1;
            this.f1740k0 = -1;
            this.f1742l0 = Integer.MIN_VALUE;
            this.f1744m0 = Integer.MIN_VALUE;
            this.f1746n0 = 0.5f;
            this.f1754r0 = new p.e();
        }

        public void a() {
            this.f1726d0 = false;
            this.f1720a0 = true;
            this.f1722b0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.W) {
                this.f1720a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.X) {
                this.f1722b0 = false;
                if (this.M == 0) {
                    this.M = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f1720a0 = false;
                if (i10 == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.W = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f1722b0 = false;
                if (i11 == 0 && this.M == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.X = true;
                }
            }
            if (this.f1723c == -1.0f && this.f1719a == -1 && this.f1721b == -1) {
                return;
            }
            this.f1726d0 = true;
            this.f1720a0 = true;
            this.f1722b0 = true;
            if (!(this.f1754r0 instanceof p.g)) {
                this.f1754r0 = new p.g();
            }
            ((p.g) this.f1754r0).x1(this.V);
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00da, code lost:
        
            if (r1 > 0) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00dc, code lost:
        
            ((android.view.ViewGroup.MarginLayoutParams) r10).rightMargin = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x00e9, code lost:
        
            if (r1 > 0) goto L77;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.InterfaceC0278b {

        /* renamed from: a, reason: collision with root package name */
        ConstraintLayout f1764a;

        /* renamed from: b, reason: collision with root package name */
        int f1765b;

        /* renamed from: c, reason: collision with root package name */
        int f1766c;

        /* renamed from: d, reason: collision with root package name */
        int f1767d;

        /* renamed from: e, reason: collision with root package name */
        int f1768e;

        /* renamed from: f, reason: collision with root package name */
        int f1769f;

        /* renamed from: g, reason: collision with root package name */
        int f1770g;

        public c(ConstraintLayout constraintLayout) {
            this.f1764a = constraintLayout;
        }

        private boolean d(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i12 == size;
            }
            return false;
        }

        @Override // q.b.InterfaceC0278b
        public final void a() {
            int childCount = this.f1764a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f1764a.getChildAt(i10);
                if (childAt instanceof h) {
                    ((h) childAt).a(this.f1764a);
                }
            }
            int size = this.f1764a.f1700g.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((androidx.constraintlayout.widget.c) this.f1764a.f1700g.get(i11)).p(this.f1764a);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:152:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x018c  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01a3  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01c4  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01db  */
        @Override // q.b.InterfaceC0278b
        @android.annotation.SuppressLint({"WrongCall"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(p.e r18, q.b.a r19) {
            /*
                Method dump skipped, instructions count: 713
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c.b(p.e, q.b$a):void");
        }

        public void c(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f1765b = i12;
            this.f1766c = i13;
            this.f1767d = i14;
            this.f1768e = i15;
            this.f1769f = i10;
            this.f1770g = i11;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1699f = new SparseArray<>();
        this.f1700g = new ArrayList<>(4);
        this.f1701h = new p.f();
        this.f1702i = 0;
        this.f1703j = 0;
        this.f1704k = Integer.MAX_VALUE;
        this.f1705l = Integer.MAX_VALUE;
        this.f1706m = true;
        this.f1707n = 257;
        this.f1708o = null;
        this.f1709p = null;
        this.f1710q = -1;
        this.f1711r = new HashMap<>();
        this.f1712s = -1;
        this.f1713t = -1;
        this.f1714u = new SparseArray<>();
        this.f1715v = new c(this);
        this.f1716w = 0;
        this.f1717x = 0;
        p(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Build.VERSION.SDK_INT >= 17 ? Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart()) : 0;
        return max2 > 0 ? max2 : max;
    }

    public static k getSharedValues() {
        if (f1698y == null) {
            f1698y = new k();
        }
        return f1698y;
    }

    private final p.e h(int i10) {
        if (i10 == 0) {
            return this.f1701h;
        }
        View view = this.f1699f.get(i10);
        if (view == null && (view = findViewById(i10)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1701h;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f1754r0;
    }

    private void p(AttributeSet attributeSet, int i10, int i11) {
        this.f1701h.y0(this);
        this.f1701h.R1(this.f1715v);
        this.f1699f.put(getId(), this);
        this.f1708o = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.U0, i10, i11);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = obtainStyledAttributes.getIndex(i12);
                if (index == j.Z0) {
                    this.f1702i = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1702i);
                } else if (index == j.f1927a1) {
                    this.f1703j = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1703j);
                } else if (index == j.X0) {
                    this.f1704k = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1704k);
                } else if (index == j.Y0) {
                    this.f1705l = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1705l);
                } else if (index == j.f2040o2) {
                    this.f1707n = obtainStyledAttributes.getInt(index, this.f1707n);
                } else if (index == j.f1999j1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            s(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1709p = null;
                        }
                    }
                } else if (index == j.f1967f1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        e eVar = new e();
                        this.f1708o = eVar;
                        eVar.j(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1708o = null;
                    }
                    this.f1710q = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1701h.S1(this.f1707n);
    }

    private void r() {
        this.f1706m = true;
        this.f1712s = -1;
        this.f1713t = -1;
    }

    private void v() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            p.e l10 = l(getChildAt(i10));
            if (l10 != null) {
                l10.r0();
            }
        }
        if (isInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    w(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    h(childAt.getId()).z0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f1710q != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.f1710q && (childAt2 instanceof f)) {
                    this.f1708o = ((f) childAt2).getConstraintSet();
                }
            }
        }
        e eVar = this.f1708o;
        if (eVar != null) {
            eVar.d(this, true);
        }
        this.f1701h.r1();
        int size = this.f1700g.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.f1700g.get(i13).r(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof h) {
                ((h) childAt3).b(this);
            }
        }
        this.f1714u.clear();
        this.f1714u.put(0, this.f1701h);
        this.f1714u.put(getId(), this.f1701h);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.f1714u.put(childAt4.getId(), l(childAt4));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt5 = getChildAt(i16);
            p.e l11 = l(childAt5);
            if (l11 != null) {
                b bVar = (b) childAt5.getLayoutParams();
                this.f1701h.c(l11);
                d(isInEditMode, childAt5, l11, bVar, this.f1714u);
            }
        }
    }

    private void y(p.e eVar, b bVar, SparseArray<p.e> sparseArray, int i10, d.b bVar2) {
        View view = this.f1699f.get(i10);
        p.e eVar2 = sparseArray.get(i10);
        if (eVar2 == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        bVar.f1724c0 = true;
        d.b bVar3 = d.b.BASELINE;
        if (bVar2 == bVar3) {
            b bVar4 = (b) view.getLayoutParams();
            bVar4.f1724c0 = true;
            bVar4.f1754r0.H0(true);
        }
        eVar.m(bVar3).a(eVar2.m(bVar2), bVar.D, bVar.C, true);
        eVar.H0(true);
        eVar.m(d.b.TOP).p();
        eVar.m(d.b.BOTTOM).p();
    }

    private boolean z() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            v();
        }
        return z10;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void d(boolean r16, android.view.View r17, p.e r18, androidx.constraintlayout.widget.ConstraintLayout.b r19, android.util.SparseArray<p.e> r20) {
        /*
            Method dump skipped, instructions count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.d(boolean, android.view.View, p.e, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.c> arrayList = this.f1700g;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.f1700g.get(i10).q(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i12 = (int) ((parseInt / 1080.0f) * width);
                        int i13 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i12;
                        float f11 = i13;
                        float f12 = i12 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float parseInt4 = i13 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, parseInt4, paint);
                        canvas.drawLine(f12, parseInt4, f10, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f12, f11, paint);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void forceLayout() {
        r();
        super.forceLayout();
    }

    public Object g(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.f1711r;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f1711r.get(str);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public int getMaxHeight() {
        return this.f1705l;
    }

    public int getMaxWidth() {
        return this.f1704k;
    }

    public int getMinHeight() {
        return this.f1703j;
    }

    public int getMinWidth() {
        return this.f1702i;
    }

    public int getOptimizationLevel() {
        return this.f1701h.G1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb2 = new StringBuilder();
        if (this.f1701h.f12963l == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.f1701h.f12963l = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.f1701h.f12963l = "parent";
            }
        }
        if (this.f1701h.r() == null) {
            p.f fVar = this.f1701h;
            fVar.z0(fVar.f12963l);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" setDebugName ");
            sb3.append(this.f1701h.r());
        }
        Iterator<p.e> it = this.f1701h.o1().iterator();
        while (it.hasNext()) {
            p.e next = it.next();
            View view = (View) next.q();
            if (view != null) {
                if (next.f12963l == null && (id = view.getId()) != -1) {
                    next.f12963l = getContext().getResources().getResourceEntryName(id);
                }
                if (next.r() == null) {
                    next.z0(next.f12963l);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(" setDebugName ");
                    sb4.append(next.r());
                }
            }
        }
        this.f1701h.M(sb2);
        return sb2.toString();
    }

    public View k(int i10) {
        return this.f1699f.get(i10);
    }

    public final p.e l(View view) {
        if (view == this) {
            return this.f1701h;
        }
        if (view == null) {
            return null;
        }
        if (!(view.getLayoutParams() instanceof b)) {
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (!(view.getLayoutParams() instanceof b)) {
                return null;
            }
        }
        return ((b) view.getLayoutParams()).f1754r0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            b bVar = (b) childAt.getLayoutParams();
            p.e eVar = bVar.f1754r0;
            if ((childAt.getVisibility() != 8 || bVar.f1726d0 || bVar.f1728e0 || bVar.f1732g0 || isInEditMode) && !bVar.f1730f0) {
                int V = eVar.V();
                int W = eVar.W();
                int U = eVar.U() + V;
                int v10 = eVar.v() + W;
                childAt.layout(V, W, U, v10);
                if ((childAt instanceof h) && (content = ((h) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(V, W, U, v10);
                }
            }
        }
        int size = this.f1700g.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.f1700g.get(i15).o(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1716w == i10) {
            int i12 = this.f1717x;
        }
        if (!this.f1706m) {
            int childCount = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                }
                if (getChildAt(i13).isLayoutRequested()) {
                    this.f1706m = true;
                    break;
                }
                i13++;
            }
        }
        boolean z10 = this.f1706m;
        this.f1716w = i10;
        this.f1717x = i11;
        this.f1701h.U1(q());
        if (this.f1706m) {
            this.f1706m = false;
            if (z()) {
                this.f1701h.W1();
            }
        }
        u(this.f1701h, this.f1707n, i10, i11);
        t(i10, i11, this.f1701h.U(), this.f1701h.v(), this.f1701h.M1(), this.f1701h.K1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        p.e l10 = l(view);
        if ((view instanceof Guideline) && !(l10 instanceof p.g)) {
            b bVar = (b) view.getLayoutParams();
            p.g gVar = new p.g();
            bVar.f1754r0 = gVar;
            bVar.f1726d0 = true;
            gVar.x1(bVar.V);
        }
        if (view instanceof androidx.constraintlayout.widget.c) {
            androidx.constraintlayout.widget.c cVar = (androidx.constraintlayout.widget.c) view;
            cVar.s();
            ((b) view.getLayoutParams()).f1728e0 = true;
            if (!this.f1700g.contains(cVar)) {
                this.f1700g.add(cVar);
            }
        }
        this.f1699f.put(view.getId(), view);
        this.f1706m = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1699f.remove(view.getId());
        this.f1701h.q1(l(view));
        this.f1700g.remove(view);
        this.f1706m = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q() {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
        }
        return false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        r();
        super.requestLayout();
    }

    protected void s(int i10) {
        this.f1709p = new d(getContext(), this, i10);
    }

    public void setConstraintSet(e eVar) {
        this.f1708o = eVar;
    }

    @Override // android.view.View
    public void setId(int i10) {
        this.f1699f.remove(getId());
        super.setId(i10);
        this.f1699f.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.f1705l) {
            return;
        }
        this.f1705l = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.f1704k) {
            return;
        }
        this.f1704k = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.f1703j) {
            return;
        }
        this.f1703j = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.f1702i) {
            return;
        }
        this.f1702i = i10;
        requestLayout();
    }

    public void setOnConstraintsChanged(g gVar) {
        d dVar = this.f1709p;
        if (dVar != null) {
            dVar.c(gVar);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f1707n = i10;
        this.f1701h.S1(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected void t(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        c cVar = this.f1715v;
        int i14 = cVar.f1768e;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i12 + cVar.f1767d, i10, 0);
        int resolveSizeAndState2 = ViewGroup.resolveSizeAndState(i13 + i14, i11, 0) & 16777215;
        int min = Math.min(this.f1704k, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f1705l, resolveSizeAndState2);
        if (z10) {
            min |= 16777216;
        }
        if (z11) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.f1712s = min;
        this.f1713t = min2;
    }

    protected void u(p.f fVar, int i10, int i11, int i12) {
        int max;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int max2 = Math.max(0, getPaddingTop());
        int max3 = Math.max(0, getPaddingBottom());
        int i13 = max2 + max3;
        int paddingWidth = getPaddingWidth();
        this.f1715v.c(i11, i12, max2, max3, paddingWidth, i13);
        if (Build.VERSION.SDK_INT >= 17) {
            int max4 = Math.max(0, getPaddingStart());
            int max5 = Math.max(0, getPaddingEnd());
            if (max4 <= 0 && max5 <= 0) {
                max4 = Math.max(0, getPaddingLeft());
            } else if (q()) {
                max4 = max5;
            }
            max = max4;
        } else {
            max = Math.max(0, getPaddingLeft());
        }
        int i14 = size - paddingWidth;
        int i15 = size2 - i13;
        x(fVar, mode, i14, mode2, i15);
        fVar.N1(i10, mode, i14, mode2, i15, this.f1712s, this.f1713t, max, max2);
    }

    public void w(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1711r == null) {
                this.f1711r = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1711r.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r3 == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        r12 = java.lang.Math.max(0, r7.f1703j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
    
        if (r3 == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0025, code lost:
    
        if (r3 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002c, code lost:
    
        r10 = java.lang.Math.max(0, r7.f1702i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002a, code lost:
    
        if (r3 == 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void x(p.f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.f1715v
            int r1 = r0.f1768e
            int r0 = r0.f1767d
            p.e$b r2 = p.e.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L28
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = 0
            goto L32
        L1a:
            int r9 = r7.f1704k
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L32
        L23:
            p.e$b r9 = p.e.b.WRAP_CONTENT
            if (r3 != 0) goto L18
            goto L2c
        L28:
            p.e$b r9 = p.e.b.WRAP_CONTENT
            if (r3 != 0) goto L32
        L2c:
            int r10 = r7.f1702i
            int r10 = java.lang.Math.max(r6, r10)
        L32:
            if (r11 == r5) goto L47
            if (r11 == 0) goto L42
            if (r11 == r4) goto L3a
        L38:
            r12 = 0
            goto L51
        L3a:
            int r11 = r7.f1705l
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L51
        L42:
            p.e$b r2 = p.e.b.WRAP_CONTENT
            if (r3 != 0) goto L38
            goto L4b
        L47:
            p.e$b r2 = p.e.b.WRAP_CONTENT
            if (r3 != 0) goto L51
        L4b:
            int r11 = r7.f1703j
            int r12 = java.lang.Math.max(r6, r11)
        L51:
            int r11 = r8.U()
            if (r10 != r11) goto L5d
            int r11 = r8.v()
            if (r12 == r11) goto L60
        L5d:
            r8.J1()
        L60:
            r8.j1(r6)
            r8.k1(r6)
            int r11 = r7.f1704k
            int r11 = r11 - r0
            r8.U0(r11)
            int r11 = r7.f1705l
            int r11 = r11 - r1
            r8.T0(r11)
            r8.X0(r6)
            r8.W0(r6)
            r8.M0(r9)
            r8.h1(r10)
            r8.d1(r2)
            r8.I0(r12)
            int r9 = r7.f1702i
            int r9 = r9 - r0
            r8.X0(r9)
            int r9 = r7.f1703j
            int r9 = r9 - r1
            r8.W0(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.x(p.f, int, int, int, int):void");
    }
}
