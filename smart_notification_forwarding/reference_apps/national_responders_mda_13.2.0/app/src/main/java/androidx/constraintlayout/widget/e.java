package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.f;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f1810d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    private static SparseIntArray f1811e = new SparseIntArray();

    /* renamed from: f, reason: collision with root package name */
    private static SparseIntArray f1812f = new SparseIntArray();

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, androidx.constraintlayout.widget.b> f1813a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f1814b = true;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<Integer, a> f1815c = new HashMap<>();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f1816a;

        /* renamed from: b, reason: collision with root package name */
        public final d f1817b = new d();

        /* renamed from: c, reason: collision with root package name */
        public final c f1818c = new c();

        /* renamed from: d, reason: collision with root package name */
        public final b f1819d = new b();

        /* renamed from: e, reason: collision with root package name */
        public final C0026e f1820e = new C0026e();

        /* renamed from: f, reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.b> f1821f = new HashMap<>();

        /* renamed from: g, reason: collision with root package name */
        C0025a f1822g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.constraintlayout.widget.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0025a {

            /* renamed from: a, reason: collision with root package name */
            int[] f1823a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            int[] f1824b = new int[10];

            /* renamed from: c, reason: collision with root package name */
            int f1825c = 0;

            /* renamed from: d, reason: collision with root package name */
            int[] f1826d = new int[10];

            /* renamed from: e, reason: collision with root package name */
            float[] f1827e = new float[10];

            /* renamed from: f, reason: collision with root package name */
            int f1828f = 0;

            /* renamed from: g, reason: collision with root package name */
            int[] f1829g = new int[5];

            /* renamed from: h, reason: collision with root package name */
            String[] f1830h = new String[5];

            /* renamed from: i, reason: collision with root package name */
            int f1831i = 0;

            /* renamed from: j, reason: collision with root package name */
            int[] f1832j = new int[4];

            /* renamed from: k, reason: collision with root package name */
            boolean[] f1833k = new boolean[4];

            /* renamed from: l, reason: collision with root package name */
            int f1834l = 0;

            C0025a() {
            }

            void a(int i10, float f10) {
                int i11 = this.f1828f;
                int[] iArr = this.f1826d;
                if (i11 >= iArr.length) {
                    this.f1826d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f1827e;
                    this.f1827e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f1826d;
                int i12 = this.f1828f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f1827e;
                this.f1828f = i12 + 1;
                fArr2[i12] = f10;
            }

            void b(int i10, int i11) {
                int i12 = this.f1825c;
                int[] iArr = this.f1823a;
                if (i12 >= iArr.length) {
                    this.f1823a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f1824b;
                    this.f1824b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f1823a;
                int i13 = this.f1825c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f1824b;
                this.f1825c = i13 + 1;
                iArr4[i13] = i11;
            }

            void c(int i10, String str) {
                int i11 = this.f1831i;
                int[] iArr = this.f1829g;
                if (i11 >= iArr.length) {
                    this.f1829g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f1830h;
                    this.f1830h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f1829g;
                int i12 = this.f1831i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f1830h;
                this.f1831i = i12 + 1;
                strArr2[i12] = str;
            }

            void d(int i10, boolean z10) {
                int i11 = this.f1834l;
                int[] iArr = this.f1832j;
                if (i11 >= iArr.length) {
                    this.f1832j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f1833k;
                    this.f1833k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f1832j;
                int i12 = this.f1834l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f1833k;
                this.f1834l = i12 + 1;
                zArr2[i12] = z10;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i10, ConstraintLayout.b bVar) {
            this.f1816a = i10;
            b bVar2 = this.f1819d;
            bVar2.f1852i = bVar.f1727e;
            bVar2.f1854j = bVar.f1729f;
            bVar2.f1856k = bVar.f1731g;
            bVar2.f1858l = bVar.f1733h;
            bVar2.f1860m = bVar.f1735i;
            bVar2.f1862n = bVar.f1737j;
            bVar2.f1864o = bVar.f1739k;
            bVar2.f1866p = bVar.f1741l;
            bVar2.f1868q = bVar.f1743m;
            bVar2.f1869r = bVar.f1745n;
            bVar2.f1870s = bVar.f1747o;
            bVar2.f1871t = bVar.f1755s;
            bVar2.f1872u = bVar.f1756t;
            bVar2.f1873v = bVar.f1757u;
            bVar2.f1874w = bVar.f1758v;
            bVar2.f1875x = bVar.E;
            bVar2.f1876y = bVar.F;
            bVar2.f1877z = bVar.G;
            bVar2.A = bVar.f1749p;
            bVar2.B = bVar.f1751q;
            bVar2.C = bVar.f1753r;
            bVar2.D = bVar.T;
            bVar2.E = bVar.U;
            bVar2.F = bVar.V;
            bVar2.f1848g = bVar.f1723c;
            bVar2.f1844e = bVar.f1719a;
            bVar2.f1846f = bVar.f1721b;
            bVar2.f1840c = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f1842d = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.G = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.H = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.I = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.J = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.M = bVar.D;
            bVar2.U = bVar.I;
            bVar2.V = bVar.H;
            bVar2.X = bVar.K;
            bVar2.W = bVar.J;
            bVar2.f1861m0 = bVar.W;
            bVar2.f1863n0 = bVar.X;
            bVar2.Y = bVar.L;
            bVar2.Z = bVar.M;
            bVar2.f1837a0 = bVar.P;
            bVar2.f1839b0 = bVar.Q;
            bVar2.f1841c0 = bVar.N;
            bVar2.f1843d0 = bVar.O;
            bVar2.f1845e0 = bVar.R;
            bVar2.f1847f0 = bVar.S;
            bVar2.f1859l0 = bVar.Y;
            bVar2.O = bVar.f1760x;
            bVar2.Q = bVar.f1762z;
            bVar2.N = bVar.f1759w;
            bVar2.P = bVar.f1761y;
            bVar2.S = bVar.A;
            bVar2.R = bVar.B;
            bVar2.T = bVar.C;
            bVar2.f1867p0 = bVar.Z;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar2.K = bVar.getMarginEnd();
                this.f1819d.L = bVar.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i10, f.a aVar) {
            f(i10, aVar);
            this.f1817b.f1896d = aVar.f1914s0;
            C0026e c0026e = this.f1820e;
            c0026e.f1900b = aVar.f1917v0;
            c0026e.f1901c = aVar.f1918w0;
            c0026e.f1902d = aVar.f1919x0;
            c0026e.f1903e = aVar.f1920y0;
            c0026e.f1904f = aVar.f1921z0;
            c0026e.f1905g = aVar.A0;
            c0026e.f1906h = aVar.B0;
            c0026e.f1908j = aVar.C0;
            c0026e.f1909k = aVar.D0;
            c0026e.f1910l = aVar.E0;
            c0026e.f1912n = aVar.f1916u0;
            c0026e.f1911m = aVar.f1915t0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(androidx.constraintlayout.widget.c cVar, int i10, f.a aVar) {
            g(i10, aVar);
            if (cVar instanceof androidx.constraintlayout.widget.a) {
                b bVar = this.f1819d;
                bVar.f1853i0 = 1;
                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) cVar;
                bVar.f1849g0 = aVar2.getType();
                this.f1819d.f1855j0 = aVar2.getReferencedIds();
                this.f1819d.f1851h0 = aVar2.getMargin();
            }
        }

        public void d(ConstraintLayout.b bVar) {
            b bVar2 = this.f1819d;
            bVar.f1727e = bVar2.f1852i;
            bVar.f1729f = bVar2.f1854j;
            bVar.f1731g = bVar2.f1856k;
            bVar.f1733h = bVar2.f1858l;
            bVar.f1735i = bVar2.f1860m;
            bVar.f1737j = bVar2.f1862n;
            bVar.f1739k = bVar2.f1864o;
            bVar.f1741l = bVar2.f1866p;
            bVar.f1743m = bVar2.f1868q;
            bVar.f1745n = bVar2.f1869r;
            bVar.f1747o = bVar2.f1870s;
            bVar.f1755s = bVar2.f1871t;
            bVar.f1756t = bVar2.f1872u;
            bVar.f1757u = bVar2.f1873v;
            bVar.f1758v = bVar2.f1874w;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.G;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.H;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.I;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.J;
            bVar.A = bVar2.S;
            bVar.B = bVar2.R;
            bVar.f1760x = bVar2.O;
            bVar.f1762z = bVar2.Q;
            bVar.E = bVar2.f1875x;
            bVar.F = bVar2.f1876y;
            bVar.f1749p = bVar2.A;
            bVar.f1751q = bVar2.B;
            bVar.f1753r = bVar2.C;
            bVar.G = bVar2.f1877z;
            bVar.T = bVar2.D;
            bVar.U = bVar2.E;
            bVar.I = bVar2.U;
            bVar.H = bVar2.V;
            bVar.K = bVar2.X;
            bVar.J = bVar2.W;
            bVar.W = bVar2.f1861m0;
            bVar.X = bVar2.f1863n0;
            bVar.L = bVar2.Y;
            bVar.M = bVar2.Z;
            bVar.P = bVar2.f1837a0;
            bVar.Q = bVar2.f1839b0;
            bVar.N = bVar2.f1841c0;
            bVar.O = bVar2.f1843d0;
            bVar.R = bVar2.f1845e0;
            bVar.S = bVar2.f1847f0;
            bVar.V = bVar2.F;
            bVar.f1723c = bVar2.f1848g;
            bVar.f1719a = bVar2.f1844e;
            bVar.f1721b = bVar2.f1846f;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f1840c;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f1842d;
            String str = bVar2.f1859l0;
            if (str != null) {
                bVar.Y = str;
            }
            bVar.Z = bVar2.f1867p0;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar.setMarginStart(bVar2.L);
                bVar.setMarginEnd(this.f1819d.K);
            }
            bVar.a();
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f1819d.a(this.f1819d);
            aVar.f1818c.a(this.f1818c);
            aVar.f1817b.a(this.f1817b);
            aVar.f1820e.a(this.f1820e);
            aVar.f1816a = this.f1816a;
            aVar.f1822g = this.f1822g;
            return aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: q0, reason: collision with root package name */
        private static SparseIntArray f1835q0;

        /* renamed from: c, reason: collision with root package name */
        public int f1840c;

        /* renamed from: d, reason: collision with root package name */
        public int f1842d;

        /* renamed from: j0, reason: collision with root package name */
        public int[] f1855j0;

        /* renamed from: k0, reason: collision with root package name */
        public String f1857k0;

        /* renamed from: l0, reason: collision with root package name */
        public String f1859l0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f1836a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1838b = false;

        /* renamed from: e, reason: collision with root package name */
        public int f1844e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f1846f = -1;

        /* renamed from: g, reason: collision with root package name */
        public float f1848g = -1.0f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f1850h = true;

        /* renamed from: i, reason: collision with root package name */
        public int f1852i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f1854j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f1856k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f1858l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f1860m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f1862n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f1864o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f1866p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f1868q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f1869r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f1870s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f1871t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f1872u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f1873v = -1;

        /* renamed from: w, reason: collision with root package name */
        public int f1874w = -1;

        /* renamed from: x, reason: collision with root package name */
        public float f1875x = 0.5f;

        /* renamed from: y, reason: collision with root package name */
        public float f1876y = 0.5f;

        /* renamed from: z, reason: collision with root package name */
        public String f1877z = null;
        public int A = -1;
        public int B = 0;
        public float C = 0.0f;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public float U = -1.0f;
        public float V = -1.0f;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        public int f1837a0 = 0;

        /* renamed from: b0, reason: collision with root package name */
        public int f1839b0 = 0;

        /* renamed from: c0, reason: collision with root package name */
        public int f1841c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public int f1843d0 = 0;

        /* renamed from: e0, reason: collision with root package name */
        public float f1845e0 = 1.0f;

        /* renamed from: f0, reason: collision with root package name */
        public float f1847f0 = 1.0f;

        /* renamed from: g0, reason: collision with root package name */
        public int f1849g0 = -1;

        /* renamed from: h0, reason: collision with root package name */
        public int f1851h0 = 0;

        /* renamed from: i0, reason: collision with root package name */
        public int f1853i0 = -1;

        /* renamed from: m0, reason: collision with root package name */
        public boolean f1861m0 = false;

        /* renamed from: n0, reason: collision with root package name */
        public boolean f1863n0 = false;

        /* renamed from: o0, reason: collision with root package name */
        public boolean f1865o0 = true;

        /* renamed from: p0, reason: collision with root package name */
        public int f1867p0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1835q0 = sparseIntArray;
            sparseIntArray.append(j.f1939b5, 24);
            f1835q0.append(j.f1947c5, 25);
            f1835q0.append(j.f1963e5, 28);
            f1835q0.append(j.f1971f5, 29);
            f1835q0.append(j.f2011k5, 35);
            f1835q0.append(j.f2003j5, 34);
            f1835q0.append(j.L4, 4);
            f1835q0.append(j.K4, 3);
            f1835q0.append(j.I4, 1);
            f1835q0.append(j.f2057q5, 6);
            f1835q0.append(j.f2064r5, 7);
            f1835q0.append(j.S4, 17);
            f1835q0.append(j.T4, 18);
            f1835q0.append(j.U4, 19);
            f1835q0.append(j.E4, 90);
            f1835q0.append(j.f2056q4, 26);
            f1835q0.append(j.f1979g5, 31);
            f1835q0.append(j.f1987h5, 32);
            f1835q0.append(j.R4, 10);
            f1835q0.append(j.Q4, 9);
            f1835q0.append(j.f2085u5, 13);
            f1835q0.append(j.f2106x5, 16);
            f1835q0.append(j.f2092v5, 14);
            f1835q0.append(j.f2071s5, 11);
            f1835q0.append(j.f2099w5, 15);
            f1835q0.append(j.f2078t5, 12);
            f1835q0.append(j.f2035n5, 38);
            f1835q0.append(j.Z4, 37);
            f1835q0.append(j.Y4, 39);
            f1835q0.append(j.f2027m5, 40);
            f1835q0.append(j.X4, 20);
            f1835q0.append(j.f2019l5, 36);
            f1835q0.append(j.P4, 5);
            f1835q0.append(j.f1931a5, 91);
            f1835q0.append(j.f1995i5, 91);
            f1835q0.append(j.f1955d5, 91);
            f1835q0.append(j.J4, 91);
            f1835q0.append(j.H4, 91);
            f1835q0.append(j.f2077t4, 23);
            f1835q0.append(j.f2091v4, 27);
            f1835q0.append(j.f2105x4, 30);
            f1835q0.append(j.f2112y4, 8);
            f1835q0.append(j.f2084u4, 33);
            f1835q0.append(j.f2098w4, 2);
            f1835q0.append(j.f2063r4, 22);
            f1835q0.append(j.f2070s4, 21);
            f1835q0.append(j.f2043o5, 41);
            f1835q0.append(j.V4, 42);
            f1835q0.append(j.G4, 41);
            f1835q0.append(j.F4, 42);
            f1835q0.append(j.f2113y5, 76);
            f1835q0.append(j.M4, 61);
            f1835q0.append(j.O4, 62);
            f1835q0.append(j.N4, 63);
            f1835q0.append(j.f2050p5, 69);
            f1835q0.append(j.W4, 70);
            f1835q0.append(j.C4, 71);
            f1835q0.append(j.A4, 72);
            f1835q0.append(j.B4, 73);
            f1835q0.append(j.D4, 74);
            f1835q0.append(j.f2119z4, 75);
        }

        public void a(b bVar) {
            this.f1836a = bVar.f1836a;
            this.f1840c = bVar.f1840c;
            this.f1838b = bVar.f1838b;
            this.f1842d = bVar.f1842d;
            this.f1844e = bVar.f1844e;
            this.f1846f = bVar.f1846f;
            this.f1848g = bVar.f1848g;
            this.f1850h = bVar.f1850h;
            this.f1852i = bVar.f1852i;
            this.f1854j = bVar.f1854j;
            this.f1856k = bVar.f1856k;
            this.f1858l = bVar.f1858l;
            this.f1860m = bVar.f1860m;
            this.f1862n = bVar.f1862n;
            this.f1864o = bVar.f1864o;
            this.f1866p = bVar.f1866p;
            this.f1868q = bVar.f1868q;
            this.f1869r = bVar.f1869r;
            this.f1870s = bVar.f1870s;
            this.f1871t = bVar.f1871t;
            this.f1872u = bVar.f1872u;
            this.f1873v = bVar.f1873v;
            this.f1874w = bVar.f1874w;
            this.f1875x = bVar.f1875x;
            this.f1876y = bVar.f1876y;
            this.f1877z = bVar.f1877z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f1837a0 = bVar.f1837a0;
            this.f1839b0 = bVar.f1839b0;
            this.f1841c0 = bVar.f1841c0;
            this.f1843d0 = bVar.f1843d0;
            this.f1845e0 = bVar.f1845e0;
            this.f1847f0 = bVar.f1847f0;
            this.f1849g0 = bVar.f1849g0;
            this.f1851h0 = bVar.f1851h0;
            this.f1853i0 = bVar.f1853i0;
            this.f1859l0 = bVar.f1859l0;
            int[] iArr = bVar.f1855j0;
            if (iArr == null || bVar.f1857k0 != null) {
                this.f1855j0 = null;
            } else {
                this.f1855j0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f1857k0 = bVar.f1857k0;
            this.f1861m0 = bVar.f1861m0;
            this.f1863n0 = bVar.f1863n0;
            this.f1865o0 = bVar.f1865o0;
            this.f1867p0 = bVar.f1867p0;
        }

        void b(Context context, AttributeSet attributeSet) {
            StringBuilder sb2;
            String str;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f2049p4);
            this.f1838b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = f1835q0.get(index);
                switch (i11) {
                    case 1:
                        this.f1868q = e.l(obtainStyledAttributes, index, this.f1868q);
                        break;
                    case 2:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 3:
                        this.f1866p = e.l(obtainStyledAttributes, index, this.f1866p);
                        break;
                    case 4:
                        this.f1864o = e.l(obtainStyledAttributes, index, this.f1864o);
                        break;
                    case 5:
                        this.f1877z = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.D = obtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                        break;
                    case 7:
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 8:
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        this.f1874w = e.l(obtainStyledAttributes, index, this.f1874w);
                        break;
                    case 10:
                        this.f1873v = e.l(obtainStyledAttributes, index, this.f1873v);
                        break;
                    case 11:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 12:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 13:
                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 14:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 15:
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 16:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 17:
                        this.f1844e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1844e);
                        break;
                    case 18:
                        this.f1846f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1846f);
                        break;
                    case 19:
                        this.f1848g = obtainStyledAttributes.getFloat(index, this.f1848g);
                        break;
                    case 20:
                        this.f1875x = obtainStyledAttributes.getFloat(index, this.f1875x);
                        break;
                    case 21:
                        this.f1842d = obtainStyledAttributes.getLayoutDimension(index, this.f1842d);
                        break;
                    case 22:
                        this.f1840c = obtainStyledAttributes.getLayoutDimension(index, this.f1840c);
                        break;
                    case 23:
                        this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 24:
                        this.f1852i = e.l(obtainStyledAttributes, index, this.f1852i);
                        break;
                    case 25:
                        this.f1854j = e.l(obtainStyledAttributes, index, this.f1854j);
                        break;
                    case 26:
                        this.F = obtainStyledAttributes.getInt(index, this.F);
                        break;
                    case 27:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 28:
                        this.f1856k = e.l(obtainStyledAttributes, index, this.f1856k);
                        break;
                    case 29:
                        this.f1858l = e.l(obtainStyledAttributes, index, this.f1858l);
                        break;
                    case 30:
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } else {
                            break;
                        }
                    case 31:
                        this.f1871t = e.l(obtainStyledAttributes, index, this.f1871t);
                        break;
                    case 32:
                        this.f1872u = e.l(obtainStyledAttributes, index, this.f1872u);
                        break;
                    case 33:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 34:
                        this.f1862n = e.l(obtainStyledAttributes, index, this.f1862n);
                        break;
                    case 35:
                        this.f1860m = e.l(obtainStyledAttributes, index, this.f1860m);
                        break;
                    case j.f1983h1 /* 36 */:
                        this.f1876y = obtainStyledAttributes.getFloat(index, this.f1876y);
                        break;
                    case 37:
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case j.W4 /* 38 */:
                        this.U = obtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case j.X4 /* 39 */:
                        this.W = obtainStyledAttributes.getInt(index, this.W);
                        break;
                    case j.Y4 /* 40 */:
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    case j.Z4 /* 41 */:
                        e.m(this, obtainStyledAttributes, index, 0);
                        break;
                    case j.f1931a5 /* 42 */:
                        e.m(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.A = e.l(obtainStyledAttributes, index, this.A);
                                break;
                            case 62:
                                this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                break;
                            case 63:
                                this.C = obtainStyledAttributes.getFloat(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f1845e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 70:
                                        this.f1847f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 71:
                                        break;
                                    case 72:
                                        this.f1849g0 = obtainStyledAttributes.getInt(index, this.f1849g0);
                                        continue;
                                    case 73:
                                        this.f1851h0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1851h0);
                                        continue;
                                    case 74:
                                        this.f1857k0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 75:
                                        this.f1865o0 = obtainStyledAttributes.getBoolean(index, this.f1865o0);
                                        continue;
                                    case 76:
                                        this.f1867p0 = obtainStyledAttributes.getInt(index, this.f1867p0);
                                        continue;
                                    case 77:
                                        this.f1869r = e.l(obtainStyledAttributes, index, this.f1869r);
                                        continue;
                                    case 78:
                                        this.f1870s = e.l(obtainStyledAttributes, index, this.f1870s);
                                        continue;
                                    case 79:
                                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                                        continue;
                                    case 80:
                                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                                        continue;
                                    case 81:
                                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                        continue;
                                    case 82:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        continue;
                                    case 83:
                                        this.f1839b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1839b0);
                                        continue;
                                    case 84:
                                        this.f1837a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1837a0);
                                        continue;
                                    case 85:
                                        this.f1843d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1843d0);
                                        continue;
                                    case 86:
                                        this.f1841c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1841c0);
                                        continue;
                                    case 87:
                                        this.f1861m0 = obtainStyledAttributes.getBoolean(index, this.f1861m0);
                                        continue;
                                    case 88:
                                        this.f1863n0 = obtainStyledAttributes.getBoolean(index, this.f1863n0);
                                        continue;
                                    case 89:
                                        this.f1859l0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 90:
                                        this.f1850h = obtainStyledAttributes.getBoolean(index, this.f1850h);
                                        continue;
                                    case 91:
                                        sb2 = new StringBuilder();
                                        str = "unused attribute 0x";
                                        break;
                                    default:
                                        sb2 = new StringBuilder();
                                        str = "Unknown attribute 0x";
                                        break;
                                }
                                sb2.append(str);
                                sb2.append(Integer.toHexString(index));
                                sb2.append("   ");
                                sb2.append(f1835q0.get(index));
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f1878o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f1879a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f1880b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f1881c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f1882d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f1883e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f1884f = 0;

        /* renamed from: g, reason: collision with root package name */
        public float f1885g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public int f1886h = -1;

        /* renamed from: i, reason: collision with root package name */
        public float f1887i = Float.NaN;

        /* renamed from: j, reason: collision with root package name */
        public float f1888j = Float.NaN;

        /* renamed from: k, reason: collision with root package name */
        public int f1889k = -1;

        /* renamed from: l, reason: collision with root package name */
        public String f1890l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f1891m = -3;

        /* renamed from: n, reason: collision with root package name */
        public int f1892n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1878o = sparseIntArray;
            sparseIntArray.append(j.D5, 1);
            f1878o.append(j.F5, 2);
            f1878o.append(j.J5, 3);
            f1878o.append(j.C5, 4);
            f1878o.append(j.B5, 5);
            f1878o.append(j.A5, 6);
            f1878o.append(j.E5, 7);
            f1878o.append(j.I5, 8);
            f1878o.append(j.H5, 9);
            f1878o.append(j.G5, 10);
        }

        public void a(c cVar) {
            this.f1879a = cVar.f1879a;
            this.f1880b = cVar.f1880b;
            this.f1882d = cVar.f1882d;
            this.f1883e = cVar.f1883e;
            this.f1884f = cVar.f1884f;
            this.f1887i = cVar.f1887i;
            this.f1885g = cVar.f1885g;
            this.f1886h = cVar.f1886h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f2120z5);
            this.f1879a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f1878o.get(index)) {
                    case 1:
                        this.f1887i = obtainStyledAttributes.getFloat(index, this.f1887i);
                        break;
                    case 2:
                        this.f1883e = obtainStyledAttributes.getInt(index, this.f1883e);
                        break;
                    case 3:
                        this.f1882d = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : n.b.f12134c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f1884f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1880b = e.l(obtainStyledAttributes, index, this.f1880b);
                        break;
                    case 6:
                        this.f1881c = obtainStyledAttributes.getInteger(index, this.f1881c);
                        break;
                    case 7:
                        this.f1885g = obtainStyledAttributes.getFloat(index, this.f1885g);
                        break;
                    case 8:
                        this.f1889k = obtainStyledAttributes.getInteger(index, this.f1889k);
                        break;
                    case 9:
                        this.f1888j = obtainStyledAttributes.getFloat(index, this.f1888j);
                        break;
                    case 10:
                        int i11 = obtainStyledAttributes.peekValue(index).type;
                        if (i11 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f1892n = resourceId;
                            if (resourceId == -1) {
                                break;
                            }
                            this.f1891m = -2;
                            break;
                        } else if (i11 != 3) {
                            this.f1891m = obtainStyledAttributes.getInteger(index, this.f1892n);
                            break;
                        } else {
                            String string = obtainStyledAttributes.getString(index);
                            this.f1890l = string;
                            if (string.indexOf("/") <= 0) {
                                this.f1891m = -1;
                                break;
                            } else {
                                this.f1892n = obtainStyledAttributes.getResourceId(index, -1);
                                this.f1891m = -2;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1893a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f1894b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f1895c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f1896d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f1897e = Float.NaN;

        public void a(d dVar) {
            this.f1893a = dVar.f1893a;
            this.f1894b = dVar.f1894b;
            this.f1896d = dVar.f1896d;
            this.f1897e = dVar.f1897e;
            this.f1895c = dVar.f1895c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.N5);
            this.f1893a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == j.P5) {
                    this.f1896d = obtainStyledAttributes.getFloat(index, this.f1896d);
                } else if (index == j.O5) {
                    this.f1894b = obtainStyledAttributes.getInt(index, this.f1894b);
                    this.f1894b = e.f1810d[this.f1894b];
                } else if (index == j.R5) {
                    this.f1895c = obtainStyledAttributes.getInt(index, this.f1895c);
                } else if (index == j.Q5) {
                    this.f1897e = obtainStyledAttributes.getFloat(index, this.f1897e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0026e {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f1898o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f1899a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f1900b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f1901c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f1902d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f1903e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f1904f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f1905g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f1906h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public int f1907i = -1;

        /* renamed from: j, reason: collision with root package name */
        public float f1908j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f1909k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public float f1910l = 0.0f;

        /* renamed from: m, reason: collision with root package name */
        public boolean f1911m = false;

        /* renamed from: n, reason: collision with root package name */
        public float f1912n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1898o = sparseIntArray;
            sparseIntArray.append(j.f1948c6, 1);
            f1898o.append(j.f1956d6, 2);
            f1898o.append(j.f1964e6, 3);
            f1898o.append(j.f1932a6, 4);
            f1898o.append(j.f1940b6, 5);
            f1898o.append(j.W5, 6);
            f1898o.append(j.X5, 7);
            f1898o.append(j.Y5, 8);
            f1898o.append(j.Z5, 9);
            f1898o.append(j.f1972f6, 10);
            f1898o.append(j.f1980g6, 11);
            f1898o.append(j.f1988h6, 12);
        }

        public void a(C0026e c0026e) {
            this.f1899a = c0026e.f1899a;
            this.f1900b = c0026e.f1900b;
            this.f1901c = c0026e.f1901c;
            this.f1902d = c0026e.f1902d;
            this.f1903e = c0026e.f1903e;
            this.f1904f = c0026e.f1904f;
            this.f1905g = c0026e.f1905g;
            this.f1906h = c0026e.f1906h;
            this.f1907i = c0026e.f1907i;
            this.f1908j = c0026e.f1908j;
            this.f1909k = c0026e.f1909k;
            this.f1910l = c0026e.f1910l;
            this.f1911m = c0026e.f1911m;
            this.f1912n = c0026e.f1912n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.V5);
            this.f1899a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f1898o.get(index)) {
                    case 1:
                        this.f1900b = obtainStyledAttributes.getFloat(index, this.f1900b);
                        break;
                    case 2:
                        this.f1901c = obtainStyledAttributes.getFloat(index, this.f1901c);
                        break;
                    case 3:
                        this.f1902d = obtainStyledAttributes.getFloat(index, this.f1902d);
                        break;
                    case 4:
                        this.f1903e = obtainStyledAttributes.getFloat(index, this.f1903e);
                        break;
                    case 5:
                        this.f1904f = obtainStyledAttributes.getFloat(index, this.f1904f);
                        break;
                    case 6:
                        this.f1905g = obtainStyledAttributes.getDimension(index, this.f1905g);
                        break;
                    case 7:
                        this.f1906h = obtainStyledAttributes.getDimension(index, this.f1906h);
                        break;
                    case 8:
                        this.f1908j = obtainStyledAttributes.getDimension(index, this.f1908j);
                        break;
                    case 9:
                        this.f1909k = obtainStyledAttributes.getDimension(index, this.f1909k);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f1910l = obtainStyledAttributes.getDimension(index, this.f1910l);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f1911m = true;
                            this.f1912n = obtainStyledAttributes.getDimension(index, this.f1912n);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.f1907i = e.l(obtainStyledAttributes, index, this.f1907i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f1811e.append(j.f1982h0, 25);
        f1811e.append(j.f1990i0, 26);
        f1811e.append(j.f2006k0, 29);
        f1811e.append(j.f2014l0, 30);
        f1811e.append(j.f2059r0, 36);
        f1811e.append(j.f2052q0, 35);
        f1811e.append(j.O, 4);
        f1811e.append(j.N, 3);
        f1811e.append(j.J, 1);
        f1811e.append(j.L, 91);
        f1811e.append(j.K, 92);
        f1811e.append(j.A0, 6);
        f1811e.append(j.B0, 7);
        f1811e.append(j.V, 17);
        f1811e.append(j.W, 18);
        f1811e.append(j.X, 19);
        f1811e.append(j.F, 99);
        f1811e.append(j.f1933b, 27);
        f1811e.append(j.f2022m0, 32);
        f1811e.append(j.f2030n0, 33);
        f1811e.append(j.U, 10);
        f1811e.append(j.T, 9);
        f1811e.append(j.E0, 13);
        f1811e.append(j.H0, 16);
        f1811e.append(j.F0, 14);
        f1811e.append(j.C0, 11);
        f1811e.append(j.G0, 15);
        f1811e.append(j.D0, 12);
        f1811e.append(j.f2080u0, 40);
        f1811e.append(j.f1966f0, 39);
        f1811e.append(j.f1958e0, 41);
        f1811e.append(j.f2073t0, 42);
        f1811e.append(j.f1950d0, 20);
        f1811e.append(j.f2066s0, 37);
        f1811e.append(j.S, 5);
        f1811e.append(j.f1974g0, 87);
        f1811e.append(j.f2045p0, 87);
        f1811e.append(j.f1998j0, 87);
        f1811e.append(j.M, 87);
        f1811e.append(j.I, 87);
        f1811e.append(j.f1973g, 24);
        f1811e.append(j.f1989i, 28);
        f1811e.append(j.f2079u, 31);
        f1811e.append(j.f2086v, 8);
        f1811e.append(j.f1981h, 34);
        f1811e.append(j.f1997j, 2);
        f1811e.append(j.f1957e, 23);
        f1811e.append(j.f1965f, 21);
        f1811e.append(j.f2087v0, 95);
        f1811e.append(j.Y, 96);
        f1811e.append(j.f1949d, 22);
        f1811e.append(j.f2005k, 43);
        f1811e.append(j.f2100x, 44);
        f1811e.append(j.f2065s, 45);
        f1811e.append(j.f2072t, 46);
        f1811e.append(j.f2058r, 60);
        f1811e.append(j.f2044p, 47);
        f1811e.append(j.f2051q, 48);
        f1811e.append(j.f2013l, 49);
        f1811e.append(j.f2021m, 50);
        f1811e.append(j.f2029n, 51);
        f1811e.append(j.f2037o, 52);
        f1811e.append(j.f2093w, 53);
        f1811e.append(j.f2094w0, 54);
        f1811e.append(j.Z, 55);
        f1811e.append(j.f2101x0, 56);
        f1811e.append(j.f1926a0, 57);
        f1811e.append(j.f2108y0, 58);
        f1811e.append(j.f1934b0, 59);
        f1811e.append(j.P, 61);
        f1811e.append(j.R, 62);
        f1811e.append(j.Q, 63);
        f1811e.append(j.f2107y, 64);
        f1811e.append(j.R0, 65);
        f1811e.append(j.E, 66);
        f1811e.append(j.S0, 67);
        f1811e.append(j.K0, 79);
        f1811e.append(j.f1941c, 38);
        f1811e.append(j.J0, 68);
        f1811e.append(j.f2115z0, 69);
        f1811e.append(j.f1942c0, 70);
        f1811e.append(j.I0, 97);
        f1811e.append(j.C, 71);
        f1811e.append(j.A, 72);
        f1811e.append(j.B, 73);
        f1811e.append(j.D, 74);
        f1811e.append(j.f2114z, 75);
        f1811e.append(j.L0, 76);
        f1811e.append(j.f2038o0, 77);
        f1811e.append(j.T0, 78);
        f1811e.append(j.H, 80);
        f1811e.append(j.G, 81);
        f1811e.append(j.M0, 82);
        f1811e.append(j.Q0, 83);
        f1811e.append(j.P0, 84);
        f1811e.append(j.O0, 85);
        f1811e.append(j.N0, 86);
        SparseIntArray sparseIntArray = f1812f;
        int i10 = j.f2097w3;
        sparseIntArray.append(i10, 6);
        f1812f.append(i10, 7);
        f1812f.append(j.f2061r2, 27);
        f1812f.append(j.f2118z3, 13);
        f1812f.append(j.C3, 16);
        f1812f.append(j.A3, 14);
        f1812f.append(j.f2104x3, 11);
        f1812f.append(j.B3, 15);
        f1812f.append(j.f2111y3, 12);
        f1812f.append(j.f2055q3, 40);
        f1812f.append(j.f2001j3, 39);
        f1812f.append(j.f1993i3, 41);
        f1812f.append(j.f2048p3, 42);
        f1812f.append(j.f1985h3, 20);
        f1812f.append(j.f2041o3, 37);
        f1812f.append(j.f1937b3, 5);
        f1812f.append(j.f2009k3, 87);
        f1812f.append(j.f2033n3, 87);
        f1812f.append(j.f2017l3, 87);
        f1812f.append(j.Y2, 87);
        f1812f.append(j.X2, 87);
        f1812f.append(j.f2096w2, 24);
        f1812f.append(j.f2110y2, 28);
        f1812f.append(j.K2, 31);
        f1812f.append(j.L2, 8);
        f1812f.append(j.f2103x2, 34);
        f1812f.append(j.f2117z2, 2);
        f1812f.append(j.f2082u2, 23);
        f1812f.append(j.f2089v2, 21);
        f1812f.append(j.f2062r3, 95);
        f1812f.append(j.f1945c3, 96);
        f1812f.append(j.f2075t2, 22);
        f1812f.append(j.A2, 43);
        f1812f.append(j.N2, 44);
        f1812f.append(j.I2, 45);
        f1812f.append(j.J2, 46);
        f1812f.append(j.H2, 60);
        f1812f.append(j.F2, 47);
        f1812f.append(j.G2, 48);
        f1812f.append(j.B2, 49);
        f1812f.append(j.C2, 50);
        f1812f.append(j.D2, 51);
        f1812f.append(j.E2, 52);
        f1812f.append(j.M2, 53);
        f1812f.append(j.f2069s3, 54);
        f1812f.append(j.f1953d3, 55);
        f1812f.append(j.f2076t3, 56);
        f1812f.append(j.f1961e3, 57);
        f1812f.append(j.f2083u3, 58);
        f1812f.append(j.f1969f3, 59);
        f1812f.append(j.f1929a3, 62);
        f1812f.append(j.Z2, 63);
        f1812f.append(j.O2, 64);
        f1812f.append(j.N3, 65);
        f1812f.append(j.U2, 66);
        f1812f.append(j.O3, 67);
        f1812f.append(j.F3, 79);
        f1812f.append(j.f2068s2, 38);
        f1812f.append(j.G3, 98);
        f1812f.append(j.E3, 68);
        f1812f.append(j.f2090v3, 69);
        f1812f.append(j.f1977g3, 70);
        f1812f.append(j.S2, 71);
        f1812f.append(j.Q2, 72);
        f1812f.append(j.R2, 73);
        f1812f.append(j.T2, 74);
        f1812f.append(j.P2, 75);
        f1812f.append(j.H3, 76);
        f1812f.append(j.f2025m3, 77);
        f1812f.append(j.P3, 78);
        f1812f.append(j.W2, 80);
        f1812f.append(j.V2, 81);
        f1812f.append(j.I3, 82);
        f1812f.append(j.M3, 83);
        f1812f.append(j.L3, 84);
        f1812f.append(j.K3, 85);
        f1812f.append(j.J3, 86);
        f1812f.append(j.D3, 97);
    }

    private int[] h(View view, String str) {
        int i10;
        Object g10;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            try {
                i10 = i.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (g10 = ((ConstraintLayout) view.getParent()).g(0, trim)) != null && (g10 instanceof Integer)) {
                i10 = ((Integer) g10).intValue();
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        return i12 != split.length ? Arrays.copyOf(iArr, i12) : iArr;
    }

    private a i(Context context, AttributeSet attributeSet, boolean z10) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? j.f2054q2 : j.f1925a);
        p(context, aVar, obtainStyledAttributes, z10);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(Object obj, TypedArray typedArray, int i10, int i11) {
        int i12;
        if (obj == null) {
            return;
        }
        int i13 = typedArray.peekValue(i10).type;
        if (i13 == 3) {
            n(obj, typedArray.getString(i10), i11);
            return;
        }
        int i14 = -2;
        boolean z10 = false;
        if (i13 != 5) {
            int i15 = typedArray.getInt(i10, 0);
            if (i15 != -4) {
                i14 = (i15 == -3 || !(i15 == -2 || i15 == -1)) ? 0 : i15;
            } else {
                z10 = true;
            }
        } else {
            i14 = typedArray.getDimensionPixelSize(i10, 0);
        }
        if (obj instanceof ConstraintLayout.b) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
            if (i11 == 0) {
                ((ViewGroup.MarginLayoutParams) bVar).width = i14;
                bVar.W = z10;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) bVar).height = i14;
                bVar.X = z10;
                return;
            }
        }
        if (obj instanceof b) {
            b bVar2 = (b) obj;
            if (i11 == 0) {
                bVar2.f1840c = i14;
                bVar2.f1861m0 = z10;
                return;
            } else {
                bVar2.f1842d = i14;
                bVar2.f1863n0 = z10;
                return;
            }
        }
        if (obj instanceof a.C0025a) {
            a.C0025a c0025a = (a.C0025a) obj;
            if (i11 == 0) {
                c0025a.b(23, i14);
                i12 = 80;
            } else {
                c0025a.b(21, i14);
                i12 = 81;
            }
            c0025a.d(i12, z10);
        }
    }

    static void n(Object obj, String str, int i10) {
        int i11;
        int i12;
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(61);
        int length = str.length();
        if (indexOf <= 0 || indexOf >= length - 1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        if (substring2.length() > 0) {
            String trim = substring.trim();
            String trim2 = substring2.trim();
            if ("ratio".equalsIgnoreCase(trim)) {
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i10 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    o(bVar, trim2);
                    return;
                }
                if (obj instanceof b) {
                    ((b) obj).f1877z = trim2;
                    return;
                } else {
                    if (obj instanceof a.C0025a) {
                        ((a.C0025a) obj).c(5, trim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(trim)) {
                    float parseFloat = Float.parseFloat(trim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.H = parseFloat;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.I = parseFloat;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar3 = (b) obj;
                        if (i10 == 0) {
                            bVar3.f1840c = 0;
                            bVar3.V = parseFloat;
                            return;
                        } else {
                            bVar3.f1842d = 0;
                            bVar3.U = parseFloat;
                            return;
                        }
                    }
                    if (obj instanceof a.C0025a) {
                        a.C0025a c0025a = (a.C0025a) obj;
                        if (i10 == 0) {
                            c0025a.b(23, 0);
                            i12 = 39;
                        } else {
                            c0025a.b(21, 0);
                            i12 = 40;
                        }
                        c0025a.a(i12, parseFloat);
                        return;
                    }
                    return;
                }
                if ("parent".equalsIgnoreCase(trim)) {
                    float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                            bVar4.R = max;
                            bVar4.L = 2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                            bVar4.S = max;
                            bVar4.M = 2;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar5 = (b) obj;
                        if (i10 == 0) {
                            bVar5.f1840c = 0;
                            bVar5.f1845e0 = max;
                            bVar5.Y = 2;
                            return;
                        } else {
                            bVar5.f1842d = 0;
                            bVar5.f1847f0 = max;
                            bVar5.Z = 2;
                            return;
                        }
                    }
                    if (obj instanceof a.C0025a) {
                        a.C0025a c0025a2 = (a.C0025a) obj;
                        if (i10 == 0) {
                            c0025a2.b(23, 0);
                            i11 = 54;
                        } else {
                            c0025a2.b(21, 0);
                            i11 = 55;
                        }
                        c0025a2.b(i11, 2);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o(ConstraintLayout.b bVar, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i10 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                i10 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
                r2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(r2);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(r2, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i10 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.G = str;
    }

    private void p(Context context, a aVar, TypedArray typedArray, boolean z10) {
        c cVar;
        String str;
        c cVar2;
        StringBuilder sb2;
        String str2;
        if (z10) {
            q(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index != j.f1941c && j.f2079u != index && j.f2086v != index) {
                aVar.f1818c.f1879a = true;
                aVar.f1819d.f1838b = true;
                aVar.f1817b.f1893a = true;
                aVar.f1820e.f1899a = true;
            }
            switch (f1811e.get(index)) {
                case 1:
                    b bVar = aVar.f1819d;
                    bVar.f1868q = l(typedArray, index, bVar.f1868q);
                    continue;
                case 2:
                    b bVar2 = aVar.f1819d;
                    bVar2.J = typedArray.getDimensionPixelSize(index, bVar2.J);
                    continue;
                case 3:
                    b bVar3 = aVar.f1819d;
                    bVar3.f1866p = l(typedArray, index, bVar3.f1866p);
                    continue;
                case 4:
                    b bVar4 = aVar.f1819d;
                    bVar4.f1864o = l(typedArray, index, bVar4.f1864o);
                    continue;
                case 5:
                    aVar.f1819d.f1877z = typedArray.getString(index);
                    continue;
                case 6:
                    b bVar5 = aVar.f1819d;
                    bVar5.D = typedArray.getDimensionPixelOffset(index, bVar5.D);
                    continue;
                case 7:
                    b bVar6 = aVar.f1819d;
                    bVar6.E = typedArray.getDimensionPixelOffset(index, bVar6.E);
                    continue;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = aVar.f1819d;
                        bVar7.K = typedArray.getDimensionPixelSize(index, bVar7.K);
                        break;
                    } else {
                        continue;
                    }
                case 9:
                    b bVar8 = aVar.f1819d;
                    bVar8.f1874w = l(typedArray, index, bVar8.f1874w);
                    continue;
                case 10:
                    b bVar9 = aVar.f1819d;
                    bVar9.f1873v = l(typedArray, index, bVar9.f1873v);
                    continue;
                case 11:
                    b bVar10 = aVar.f1819d;
                    bVar10.Q = typedArray.getDimensionPixelSize(index, bVar10.Q);
                    continue;
                case 12:
                    b bVar11 = aVar.f1819d;
                    bVar11.R = typedArray.getDimensionPixelSize(index, bVar11.R);
                    continue;
                case 13:
                    b bVar12 = aVar.f1819d;
                    bVar12.N = typedArray.getDimensionPixelSize(index, bVar12.N);
                    continue;
                case 14:
                    b bVar13 = aVar.f1819d;
                    bVar13.P = typedArray.getDimensionPixelSize(index, bVar13.P);
                    continue;
                case 15:
                    b bVar14 = aVar.f1819d;
                    bVar14.S = typedArray.getDimensionPixelSize(index, bVar14.S);
                    continue;
                case 16:
                    b bVar15 = aVar.f1819d;
                    bVar15.O = typedArray.getDimensionPixelSize(index, bVar15.O);
                    continue;
                case 17:
                    b bVar16 = aVar.f1819d;
                    bVar16.f1844e = typedArray.getDimensionPixelOffset(index, bVar16.f1844e);
                    continue;
                case 18:
                    b bVar17 = aVar.f1819d;
                    bVar17.f1846f = typedArray.getDimensionPixelOffset(index, bVar17.f1846f);
                    continue;
                case 19:
                    b bVar18 = aVar.f1819d;
                    bVar18.f1848g = typedArray.getFloat(index, bVar18.f1848g);
                    continue;
                case 20:
                    b bVar19 = aVar.f1819d;
                    bVar19.f1875x = typedArray.getFloat(index, bVar19.f1875x);
                    continue;
                case 21:
                    b bVar20 = aVar.f1819d;
                    bVar20.f1842d = typedArray.getLayoutDimension(index, bVar20.f1842d);
                    continue;
                case 22:
                    d dVar = aVar.f1817b;
                    dVar.f1894b = typedArray.getInt(index, dVar.f1894b);
                    d dVar2 = aVar.f1817b;
                    dVar2.f1894b = f1810d[dVar2.f1894b];
                    continue;
                case 23:
                    b bVar21 = aVar.f1819d;
                    bVar21.f1840c = typedArray.getLayoutDimension(index, bVar21.f1840c);
                    continue;
                case 24:
                    b bVar22 = aVar.f1819d;
                    bVar22.G = typedArray.getDimensionPixelSize(index, bVar22.G);
                    continue;
                case 25:
                    b bVar23 = aVar.f1819d;
                    bVar23.f1852i = l(typedArray, index, bVar23.f1852i);
                    continue;
                case 26:
                    b bVar24 = aVar.f1819d;
                    bVar24.f1854j = l(typedArray, index, bVar24.f1854j);
                    continue;
                case 27:
                    b bVar25 = aVar.f1819d;
                    bVar25.F = typedArray.getInt(index, bVar25.F);
                    continue;
                case 28:
                    b bVar26 = aVar.f1819d;
                    bVar26.H = typedArray.getDimensionPixelSize(index, bVar26.H);
                    continue;
                case 29:
                    b bVar27 = aVar.f1819d;
                    bVar27.f1856k = l(typedArray, index, bVar27.f1856k);
                    continue;
                case 30:
                    b bVar28 = aVar.f1819d;
                    bVar28.f1858l = l(typedArray, index, bVar28.f1858l);
                    continue;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = aVar.f1819d;
                        bVar29.L = typedArray.getDimensionPixelSize(index, bVar29.L);
                        break;
                    } else {
                        continue;
                    }
                case 32:
                    b bVar30 = aVar.f1819d;
                    bVar30.f1871t = l(typedArray, index, bVar30.f1871t);
                    continue;
                case 33:
                    b bVar31 = aVar.f1819d;
                    bVar31.f1872u = l(typedArray, index, bVar31.f1872u);
                    continue;
                case 34:
                    b bVar32 = aVar.f1819d;
                    bVar32.I = typedArray.getDimensionPixelSize(index, bVar32.I);
                    continue;
                case 35:
                    b bVar33 = aVar.f1819d;
                    bVar33.f1862n = l(typedArray, index, bVar33.f1862n);
                    continue;
                case j.f1983h1 /* 36 */:
                    b bVar34 = aVar.f1819d;
                    bVar34.f1860m = l(typedArray, index, bVar34.f1860m);
                    continue;
                case 37:
                    b bVar35 = aVar.f1819d;
                    bVar35.f1876y = typedArray.getFloat(index, bVar35.f1876y);
                    continue;
                case j.W4 /* 38 */:
                    aVar.f1816a = typedArray.getResourceId(index, aVar.f1816a);
                    continue;
                case j.X4 /* 39 */:
                    b bVar36 = aVar.f1819d;
                    bVar36.V = typedArray.getFloat(index, bVar36.V);
                    continue;
                case j.Y4 /* 40 */:
                    b bVar37 = aVar.f1819d;
                    bVar37.U = typedArray.getFloat(index, bVar37.U);
                    continue;
                case j.Z4 /* 41 */:
                    b bVar38 = aVar.f1819d;
                    bVar38.W = typedArray.getInt(index, bVar38.W);
                    continue;
                case j.f1931a5 /* 42 */:
                    b bVar39 = aVar.f1819d;
                    bVar39.X = typedArray.getInt(index, bVar39.X);
                    continue;
                case j.f1939b5 /* 43 */:
                    d dVar3 = aVar.f1817b;
                    dVar3.f1896d = typedArray.getFloat(index, dVar3.f1896d);
                    continue;
                case j.f1947c5 /* 44 */:
                    if (Build.VERSION.SDK_INT >= 21) {
                        C0026e c0026e = aVar.f1820e;
                        c0026e.f1911m = true;
                        c0026e.f1912n = typedArray.getDimension(index, c0026e.f1912n);
                        break;
                    } else {
                        continue;
                    }
                case j.f1955d5 /* 45 */:
                    C0026e c0026e2 = aVar.f1820e;
                    c0026e2.f1901c = typedArray.getFloat(index, c0026e2.f1901c);
                    continue;
                case j.f1963e5 /* 46 */:
                    C0026e c0026e3 = aVar.f1820e;
                    c0026e3.f1902d = typedArray.getFloat(index, c0026e3.f1902d);
                    continue;
                case j.f1971f5 /* 47 */:
                    C0026e c0026e4 = aVar.f1820e;
                    c0026e4.f1903e = typedArray.getFloat(index, c0026e4.f1903e);
                    continue;
                case j.f1979g5 /* 48 */:
                    C0026e c0026e5 = aVar.f1820e;
                    c0026e5.f1904f = typedArray.getFloat(index, c0026e5.f1904f);
                    continue;
                case j.f1987h5 /* 49 */:
                    C0026e c0026e6 = aVar.f1820e;
                    c0026e6.f1905g = typedArray.getDimension(index, c0026e6.f1905g);
                    continue;
                case j.f1995i5 /* 50 */:
                    C0026e c0026e7 = aVar.f1820e;
                    c0026e7.f1906h = typedArray.getDimension(index, c0026e7.f1906h);
                    continue;
                case j.f2003j5 /* 51 */:
                    C0026e c0026e8 = aVar.f1820e;
                    c0026e8.f1908j = typedArray.getDimension(index, c0026e8.f1908j);
                    continue;
                case j.f2011k5 /* 52 */:
                    C0026e c0026e9 = aVar.f1820e;
                    c0026e9.f1909k = typedArray.getDimension(index, c0026e9.f1909k);
                    continue;
                case j.f2019l5 /* 53 */:
                    if (Build.VERSION.SDK_INT >= 21) {
                        C0026e c0026e10 = aVar.f1820e;
                        c0026e10.f1910l = typedArray.getDimension(index, c0026e10.f1910l);
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    b bVar40 = aVar.f1819d;
                    bVar40.Y = typedArray.getInt(index, bVar40.Y);
                    continue;
                case 55:
                    b bVar41 = aVar.f1819d;
                    bVar41.Z = typedArray.getInt(index, bVar41.Z);
                    continue;
                case 56:
                    b bVar42 = aVar.f1819d;
                    bVar42.f1837a0 = typedArray.getDimensionPixelSize(index, bVar42.f1837a0);
                    continue;
                case 57:
                    b bVar43 = aVar.f1819d;
                    bVar43.f1839b0 = typedArray.getDimensionPixelSize(index, bVar43.f1839b0);
                    continue;
                case 58:
                    b bVar44 = aVar.f1819d;
                    bVar44.f1841c0 = typedArray.getDimensionPixelSize(index, bVar44.f1841c0);
                    continue;
                case 59:
                    b bVar45 = aVar.f1819d;
                    bVar45.f1843d0 = typedArray.getDimensionPixelSize(index, bVar45.f1843d0);
                    continue;
                case 60:
                    C0026e c0026e11 = aVar.f1820e;
                    c0026e11.f1900b = typedArray.getFloat(index, c0026e11.f1900b);
                    continue;
                case 61:
                    b bVar46 = aVar.f1819d;
                    bVar46.A = l(typedArray, index, bVar46.A);
                    continue;
                case 62:
                    b bVar47 = aVar.f1819d;
                    bVar47.B = typedArray.getDimensionPixelSize(index, bVar47.B);
                    continue;
                case 63:
                    b bVar48 = aVar.f1819d;
                    bVar48.C = typedArray.getFloat(index, bVar48.C);
                    continue;
                case 64:
                    c cVar3 = aVar.f1818c;
                    cVar3.f1880b = l(typedArray, index, cVar3.f1880b);
                    continue;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        cVar = aVar.f1818c;
                        str = typedArray.getString(index);
                    } else {
                        cVar = aVar.f1818c;
                        str = n.b.f12134c[typedArray.getInteger(index, 0)];
                    }
                    cVar.f1882d = str;
                    continue;
                case 66:
                    aVar.f1818c.f1884f = typedArray.getInt(index, 0);
                    continue;
                case 67:
                    c cVar4 = aVar.f1818c;
                    cVar4.f1887i = typedArray.getFloat(index, cVar4.f1887i);
                    continue;
                case 68:
                    d dVar4 = aVar.f1817b;
                    dVar4.f1897e = typedArray.getFloat(index, dVar4.f1897e);
                    continue;
                case 69:
                    aVar.f1819d.f1845e0 = typedArray.getFloat(index, 1.0f);
                    continue;
                case 70:
                    aVar.f1819d.f1847f0 = typedArray.getFloat(index, 1.0f);
                    continue;
                case 71:
                    break;
                case 72:
                    b bVar49 = aVar.f1819d;
                    bVar49.f1849g0 = typedArray.getInt(index, bVar49.f1849g0);
                    continue;
                case 73:
                    b bVar50 = aVar.f1819d;
                    bVar50.f1851h0 = typedArray.getDimensionPixelSize(index, bVar50.f1851h0);
                    continue;
                case 74:
                    aVar.f1819d.f1857k0 = typedArray.getString(index);
                    continue;
                case 75:
                    b bVar51 = aVar.f1819d;
                    bVar51.f1865o0 = typedArray.getBoolean(index, bVar51.f1865o0);
                    continue;
                case 76:
                    c cVar5 = aVar.f1818c;
                    cVar5.f1883e = typedArray.getInt(index, cVar5.f1883e);
                    continue;
                case 77:
                    aVar.f1819d.f1859l0 = typedArray.getString(index);
                    continue;
                case 78:
                    d dVar5 = aVar.f1817b;
                    dVar5.f1895c = typedArray.getInt(index, dVar5.f1895c);
                    continue;
                case 79:
                    c cVar6 = aVar.f1818c;
                    cVar6.f1885g = typedArray.getFloat(index, cVar6.f1885g);
                    continue;
                case 80:
                    b bVar52 = aVar.f1819d;
                    bVar52.f1861m0 = typedArray.getBoolean(index, bVar52.f1861m0);
                    continue;
                case 81:
                    b bVar53 = aVar.f1819d;
                    bVar53.f1863n0 = typedArray.getBoolean(index, bVar53.f1863n0);
                    continue;
                case 82:
                    c cVar7 = aVar.f1818c;
                    cVar7.f1881c = typedArray.getInteger(index, cVar7.f1881c);
                    continue;
                case 83:
                    C0026e c0026e12 = aVar.f1820e;
                    c0026e12.f1907i = l(typedArray, index, c0026e12.f1907i);
                    continue;
                case 84:
                    c cVar8 = aVar.f1818c;
                    cVar8.f1889k = typedArray.getInteger(index, cVar8.f1889k);
                    continue;
                case 85:
                    c cVar9 = aVar.f1818c;
                    cVar9.f1888j = typedArray.getFloat(index, cVar9.f1888j);
                    continue;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f1818c.f1892n = typedArray.getResourceId(index, -1);
                        cVar2 = aVar.f1818c;
                        if (cVar2.f1892n == -1) {
                            continue;
                        }
                        cVar2.f1891m = -2;
                        break;
                    } else if (i11 != 3) {
                        c cVar10 = aVar.f1818c;
                        cVar10.f1891m = typedArray.getInteger(index, cVar10.f1892n);
                        break;
                    } else {
                        aVar.f1818c.f1890l = typedArray.getString(index);
                        if (aVar.f1818c.f1890l.indexOf("/") <= 0) {
                            aVar.f1818c.f1891m = -1;
                            break;
                        } else {
                            aVar.f1818c.f1892n = typedArray.getResourceId(index, -1);
                            cVar2 = aVar.f1818c;
                            cVar2.f1891m = -2;
                        }
                    }
                case 87:
                    sb2 = new StringBuilder();
                    str2 = "unused attribute 0x";
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    sb2 = new StringBuilder();
                    str2 = "Unknown attribute 0x";
                    break;
                case 91:
                    b bVar54 = aVar.f1819d;
                    bVar54.f1869r = l(typedArray, index, bVar54.f1869r);
                    continue;
                case 92:
                    b bVar55 = aVar.f1819d;
                    bVar55.f1870s = l(typedArray, index, bVar55.f1870s);
                    continue;
                case 93:
                    b bVar56 = aVar.f1819d;
                    bVar56.M = typedArray.getDimensionPixelSize(index, bVar56.M);
                    continue;
                case 94:
                    b bVar57 = aVar.f1819d;
                    bVar57.T = typedArray.getDimensionPixelSize(index, bVar57.T);
                    continue;
                case 95:
                    m(aVar.f1819d, typedArray, index, 0);
                    continue;
                case 96:
                    m(aVar.f1819d, typedArray, index, 1);
                    continue;
                case 97:
                    b bVar58 = aVar.f1819d;
                    bVar58.f1867p0 = typedArray.getInt(index, bVar58.f1867p0);
                    continue;
            }
            sb2.append(str2);
            sb2.append(Integer.toHexString(index));
            sb2.append("   ");
            sb2.append(f1811e.get(index));
        }
        b bVar59 = aVar.f1819d;
        if (bVar59.f1857k0 != null) {
            bVar59.f1855j0 = null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0034. Please report as an issue. */
    private static void q(Context context, a aVar, TypedArray typedArray) {
        int i10;
        int i11;
        int i12;
        int i13;
        int dimensionPixelOffset;
        int i14;
        int layoutDimension;
        int i15;
        float f10;
        float dimension;
        int i16;
        int i17;
        boolean z10;
        int i18;
        c cVar;
        StringBuilder sb2;
        String str;
        int indexCount = typedArray.getIndexCount();
        a.C0025a c0025a = new a.C0025a();
        aVar.f1822g = c0025a;
        aVar.f1818c.f1879a = false;
        aVar.f1819d.f1838b = false;
        aVar.f1817b.f1893a = false;
        aVar.f1820e.f1899a = false;
        for (int i19 = 0; i19 < indexCount; i19++) {
            int index = typedArray.getIndex(i19);
            float f11 = 1.0f;
            int i20 = 21;
            switch (f1812f.get(index)) {
                case 2:
                    i10 = 2;
                    i11 = aVar.f1819d.J;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case j.f1983h1 /* 36 */:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    sb2 = new StringBuilder();
                    str = "Unknown attribute 0x";
                    sb2.append(str);
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(f1811e.get(index));
                    break;
                case 5:
                    i12 = 5;
                    c0025a.c(i12, typedArray.getString(index));
                    break;
                case 6:
                    i10 = 6;
                    i13 = aVar.f1819d.D;
                    dimensionPixelOffset = typedArray.getDimensionPixelOffset(index, i13);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 7:
                    i10 = 7;
                    i13 = aVar.f1819d.E;
                    dimensionPixelOffset = typedArray.getDimensionPixelOffset(index, i13);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        i10 = 8;
                        i11 = aVar.f1819d.K;
                        dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                        c0025a.b(i10, dimensionPixelOffset);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    i10 = 11;
                    i11 = aVar.f1819d.Q;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 12:
                    i10 = 12;
                    i11 = aVar.f1819d.R;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 13:
                    i10 = 13;
                    i11 = aVar.f1819d.N;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 14:
                    i10 = 14;
                    i11 = aVar.f1819d.P;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 15:
                    i10 = 15;
                    i11 = aVar.f1819d.S;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 16:
                    i10 = 16;
                    i11 = aVar.f1819d.O;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 17:
                    c0025a.b(17, typedArray.getDimensionPixelOffset(index, aVar.f1819d.f1844e));
                    break;
                case 18:
                    i10 = 18;
                    i13 = aVar.f1819d.f1846f;
                    dimensionPixelOffset = typedArray.getDimensionPixelOffset(index, i13);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 19:
                    i14 = 19;
                    f11 = aVar.f1819d.f1848g;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 20:
                    i14 = 20;
                    f11 = aVar.f1819d.f1875x;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 21:
                    layoutDimension = typedArray.getLayoutDimension(index, aVar.f1819d.f1842d);
                    c0025a.b(i20, layoutDimension);
                    break;
                case 22:
                    i10 = 22;
                    dimensionPixelOffset = f1810d[typedArray.getInt(index, aVar.f1817b.f1894b)];
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 23:
                    i10 = 23;
                    dimensionPixelOffset = typedArray.getLayoutDimension(index, aVar.f1819d.f1840c);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 24:
                    i10 = 24;
                    i11 = aVar.f1819d.G;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 27:
                    i10 = 27;
                    i15 = aVar.f1819d.F;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 28:
                    i10 = 28;
                    i11 = aVar.f1819d.H;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        i10 = 31;
                        i11 = aVar.f1819d.L;
                        dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                        c0025a.b(i10, dimensionPixelOffset);
                        break;
                    } else {
                        break;
                    }
                case 34:
                    i10 = 34;
                    i11 = aVar.f1819d.I;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 37:
                    i14 = 37;
                    f11 = aVar.f1819d.f1876y;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case j.W4 /* 38 */:
                    dimensionPixelOffset = typedArray.getResourceId(index, aVar.f1816a);
                    aVar.f1816a = dimensionPixelOffset;
                    i10 = 38;
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case j.X4 /* 39 */:
                    i14 = 39;
                    f11 = aVar.f1819d.V;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case j.Y4 /* 40 */:
                    i14 = 40;
                    f11 = aVar.f1819d.U;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case j.Z4 /* 41 */:
                    i10 = 41;
                    i15 = aVar.f1819d.W;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case j.f1931a5 /* 42 */:
                    i10 = 42;
                    i15 = aVar.f1819d.X;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case j.f1939b5 /* 43 */:
                    i14 = 43;
                    f11 = aVar.f1817b.f1896d;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case j.f1947c5 /* 44 */:
                    if (Build.VERSION.SDK_INT >= 21) {
                        i14 = 44;
                        c0025a.d(44, true);
                        f10 = aVar.f1820e.f1912n;
                        dimension = typedArray.getDimension(index, f10);
                        c0025a.a(i14, dimension);
                        break;
                    } else {
                        break;
                    }
                case j.f1955d5 /* 45 */:
                    i14 = 45;
                    f11 = aVar.f1820e.f1901c;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case j.f1963e5 /* 46 */:
                    i14 = 46;
                    f11 = aVar.f1820e.f1902d;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case j.f1971f5 /* 47 */:
                    i14 = 47;
                    f11 = aVar.f1820e.f1903e;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case j.f1979g5 /* 48 */:
                    i14 = 48;
                    f11 = aVar.f1820e.f1904f;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case j.f1987h5 /* 49 */:
                    i14 = 49;
                    f10 = aVar.f1820e.f1905g;
                    dimension = typedArray.getDimension(index, f10);
                    c0025a.a(i14, dimension);
                    break;
                case j.f1995i5 /* 50 */:
                    i14 = 50;
                    f10 = aVar.f1820e.f1906h;
                    dimension = typedArray.getDimension(index, f10);
                    c0025a.a(i14, dimension);
                    break;
                case j.f2003j5 /* 51 */:
                    i14 = 51;
                    f10 = aVar.f1820e.f1908j;
                    dimension = typedArray.getDimension(index, f10);
                    c0025a.a(i14, dimension);
                    break;
                case j.f2011k5 /* 52 */:
                    i14 = 52;
                    f10 = aVar.f1820e.f1909k;
                    dimension = typedArray.getDimension(index, f10);
                    c0025a.a(i14, dimension);
                    break;
                case j.f2019l5 /* 53 */:
                    if (Build.VERSION.SDK_INT >= 21) {
                        i14 = 53;
                        f10 = aVar.f1820e.f1910l;
                        dimension = typedArray.getDimension(index, f10);
                        c0025a.a(i14, dimension);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    i10 = 54;
                    i15 = aVar.f1819d.Y;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 55:
                    i10 = 55;
                    i15 = aVar.f1819d.Z;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 56:
                    i10 = 56;
                    i11 = aVar.f1819d.f1837a0;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 57:
                    i10 = 57;
                    i11 = aVar.f1819d.f1839b0;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 58:
                    i10 = 58;
                    i11 = aVar.f1819d.f1841c0;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 59:
                    i10 = 59;
                    i11 = aVar.f1819d.f1843d0;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 60:
                    i14 = 60;
                    f11 = aVar.f1820e.f1900b;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 62:
                    i10 = 62;
                    i11 = aVar.f1819d.B;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 63:
                    i14 = 63;
                    f11 = aVar.f1819d.C;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 64:
                    i10 = 64;
                    i16 = aVar.f1818c.f1880b;
                    dimensionPixelOffset = l(typedArray, index, i16);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 65:
                    c0025a.c(65, typedArray.peekValue(index).type == 3 ? typedArray.getString(index) : n.b.f12134c[typedArray.getInteger(index, 0)]);
                    break;
                case 66:
                    i10 = 66;
                    dimensionPixelOffset = typedArray.getInt(index, 0);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 67:
                    i14 = 67;
                    f11 = aVar.f1818c.f1887i;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 68:
                    i14 = 68;
                    f11 = aVar.f1817b.f1897e;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 69:
                    i14 = 69;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 70:
                    i14 = 70;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 71:
                    break;
                case 72:
                    i10 = 72;
                    i15 = aVar.f1819d.f1849g0;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 73:
                    i10 = 73;
                    i11 = aVar.f1819d.f1851h0;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 74:
                    i12 = 74;
                    c0025a.c(i12, typedArray.getString(index));
                    break;
                case 75:
                    i17 = 75;
                    z10 = aVar.f1819d.f1865o0;
                    c0025a.d(i17, typedArray.getBoolean(index, z10));
                    break;
                case 76:
                    i10 = 76;
                    i15 = aVar.f1818c.f1883e;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 77:
                    i12 = 77;
                    c0025a.c(i12, typedArray.getString(index));
                    break;
                case 78:
                    i10 = 78;
                    i15 = aVar.f1817b.f1895c;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 79:
                    i14 = 79;
                    f11 = aVar.f1818c.f1885g;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 80:
                    i17 = 80;
                    z10 = aVar.f1819d.f1861m0;
                    c0025a.d(i17, typedArray.getBoolean(index, z10));
                    break;
                case 81:
                    i17 = 81;
                    z10 = aVar.f1819d.f1863n0;
                    c0025a.d(i17, typedArray.getBoolean(index, z10));
                    break;
                case 82:
                    i10 = 82;
                    i18 = aVar.f1818c.f1881c;
                    dimensionPixelOffset = typedArray.getInteger(index, i18);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 83:
                    i10 = 83;
                    i16 = aVar.f1820e.f1907i;
                    dimensionPixelOffset = l(typedArray, index, i16);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 84:
                    i10 = 84;
                    i18 = aVar.f1818c.f1889k;
                    dimensionPixelOffset = typedArray.getInteger(index, i18);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 85:
                    i14 = 85;
                    f11 = aVar.f1818c.f1888j;
                    dimension = typedArray.getFloat(index, f11);
                    c0025a.a(i14, dimension);
                    break;
                case 86:
                    int i21 = typedArray.peekValue(index).type;
                    i20 = 88;
                    if (i21 == 1) {
                        aVar.f1818c.f1892n = typedArray.getResourceId(index, -1);
                        c0025a.b(89, aVar.f1818c.f1892n);
                        cVar = aVar.f1818c;
                        if (cVar.f1892n == -1) {
                            break;
                        }
                        cVar.f1891m = -2;
                        c0025a.b(88, -2);
                        break;
                    } else if (i21 != 3) {
                        c cVar2 = aVar.f1818c;
                        cVar2.f1891m = typedArray.getInteger(index, cVar2.f1892n);
                        layoutDimension = aVar.f1818c.f1891m;
                        c0025a.b(i20, layoutDimension);
                        break;
                    } else {
                        aVar.f1818c.f1890l = typedArray.getString(index);
                        c0025a.c(90, aVar.f1818c.f1890l);
                        if (aVar.f1818c.f1890l.indexOf("/") <= 0) {
                            aVar.f1818c.f1891m = -1;
                            c0025a.b(88, -1);
                            break;
                        } else {
                            aVar.f1818c.f1892n = typedArray.getResourceId(index, -1);
                            c0025a.b(89, aVar.f1818c.f1892n);
                            cVar = aVar.f1818c;
                            cVar.f1891m = -2;
                            c0025a.b(88, -2);
                        }
                    }
                case 87:
                    sb2 = new StringBuilder();
                    str = "unused attribute 0x";
                    sb2.append(str);
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(f1811e.get(index));
                    break;
                case 93:
                    i10 = 93;
                    i11 = aVar.f1819d.M;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 94:
                    i10 = 94;
                    i11 = aVar.f1819d.T;
                    dimensionPixelOffset = typedArray.getDimensionPixelSize(index, i11);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 95:
                    m(c0025a, typedArray, index, 0);
                    break;
                case 96:
                    m(c0025a, typedArray, index, 1);
                    break;
                case 97:
                    i10 = 97;
                    i15 = aVar.f1819d.f1867p0;
                    dimensionPixelOffset = typedArray.getInt(index, i15);
                    c0025a.b(i10, dimensionPixelOffset);
                    break;
                case 98:
                    if (androidx.constraintlayout.motion.widget.j.f1650w0) {
                        int resourceId = typedArray.getResourceId(index, aVar.f1816a);
                        aVar.f1816a = resourceId;
                        if (resourceId != -1) {
                            break;
                        }
                        typedArray.getString(index);
                        break;
                    } else {
                        if (typedArray.peekValue(index).type != 3) {
                            aVar.f1816a = typedArray.getResourceId(index, aVar.f1816a);
                            break;
                        }
                        typedArray.getString(index);
                    }
                case 99:
                    i17 = 99;
                    z10 = aVar.f1819d.f1850h;
                    c0025a.d(i17, typedArray.getBoolean(index, z10));
                    break;
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ConstraintLayout constraintLayout, boolean z10) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1815c.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (!this.f1815c.containsKey(Integer.valueOf(id))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id unknown ");
                sb2.append(androidx.constraintlayout.motion.widget.a.b(childAt));
            } else {
                if (this.f1814b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f1815c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f1815c.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof androidx.constraintlayout.widget.a) {
                                aVar.f1819d.f1853i0 = 1;
                                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                                aVar2.setId(id);
                                aVar2.setType(aVar.f1819d.f1849g0);
                                aVar2.setMargin(aVar.f1819d.f1851h0);
                                aVar2.setAllowsGoneWidget(aVar.f1819d.f1865o0);
                                b bVar = aVar.f1819d;
                                int[] iArr = bVar.f1855j0;
                                if (iArr != null) {
                                    aVar2.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f1857k0;
                                    if (str != null) {
                                        bVar.f1855j0 = h(aVar2, str);
                                        aVar2.setReferencedIds(aVar.f1819d.f1855j0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.a();
                            aVar.d(bVar2);
                            if (z10) {
                                androidx.constraintlayout.widget.b.e(childAt, aVar.f1821f);
                            }
                            childAt.setLayoutParams(bVar2);
                            d dVar = aVar.f1817b;
                            if (dVar.f1895c == 0) {
                                childAt.setVisibility(dVar.f1894b);
                            }
                            int i11 = Build.VERSION.SDK_INT;
                            if (i11 >= 17) {
                                childAt.setAlpha(aVar.f1817b.f1896d);
                                childAt.setRotation(aVar.f1820e.f1900b);
                                childAt.setRotationX(aVar.f1820e.f1901c);
                                childAt.setRotationY(aVar.f1820e.f1902d);
                                childAt.setScaleX(aVar.f1820e.f1903e);
                                childAt.setScaleY(aVar.f1820e.f1904f);
                                C0026e c0026e = aVar.f1820e;
                                if (c0026e.f1907i != -1) {
                                    if (((View) childAt.getParent()).findViewById(aVar.f1820e.f1907i) != null) {
                                        float top = (r6.getTop() + r6.getBottom()) / 2.0f;
                                        float left = (r6.getLeft() + r6.getRight()) / 2.0f;
                                        if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                            childAt.setPivotX(left - childAt.getLeft());
                                            childAt.setPivotY(top - childAt.getTop());
                                        }
                                    }
                                } else {
                                    if (!Float.isNaN(c0026e.f1905g)) {
                                        childAt.setPivotX(aVar.f1820e.f1905g);
                                    }
                                    if (!Float.isNaN(aVar.f1820e.f1906h)) {
                                        childAt.setPivotY(aVar.f1820e.f1906h);
                                    }
                                }
                                childAt.setTranslationX(aVar.f1820e.f1908j);
                                childAt.setTranslationY(aVar.f1820e.f1909k);
                                if (i11 >= 21) {
                                    childAt.setTranslationZ(aVar.f1820e.f1910l);
                                    C0026e c0026e2 = aVar.f1820e;
                                    if (c0026e2.f1911m) {
                                        childAt.setElevation(c0026e2.f1912n);
                                    }
                                }
                            }
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("WARNING NO CONSTRAINTS for view ");
                        sb3.append(id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar3 = this.f1815c.get(num);
            if (aVar3 != null) {
                if (aVar3.f1819d.f1853i0 == 1) {
                    androidx.constraintlayout.widget.a aVar4 = new androidx.constraintlayout.widget.a(constraintLayout.getContext());
                    aVar4.setId(num.intValue());
                    b bVar3 = aVar3.f1819d;
                    int[] iArr2 = bVar3.f1855j0;
                    if (iArr2 != null) {
                        aVar4.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f1857k0;
                        if (str2 != null) {
                            bVar3.f1855j0 = h(aVar4, str2);
                            aVar4.setReferencedIds(aVar3.f1819d.f1855j0);
                        }
                    }
                    aVar4.setType(aVar3.f1819d.f1849g0);
                    aVar4.setMargin(aVar3.f1819d.f1851h0);
                    ConstraintLayout.b generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    aVar4.s();
                    aVar3.d(generateDefaultLayoutParams);
                    constraintLayout.addView(aVar4, generateDefaultLayoutParams);
                }
                if (aVar3.f1819d.f1836a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar3.d(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = constraintLayout.getChildAt(i12);
            if (childAt2 instanceof androidx.constraintlayout.widget.c) {
                ((androidx.constraintlayout.widget.c) childAt2).i(constraintLayout);
            }
        }
    }

    public void e(Context context, int i10) {
        f((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void f(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f1815c.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f1814b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1815c.containsKey(Integer.valueOf(id))) {
                this.f1815c.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f1815c.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.f1821f = androidx.constraintlayout.widget.b.a(this.f1813a, childAt);
                aVar.f(id, bVar);
                aVar.f1817b.f1894b = childAt.getVisibility();
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 17) {
                    aVar.f1817b.f1896d = childAt.getAlpha();
                    aVar.f1820e.f1900b = childAt.getRotation();
                    aVar.f1820e.f1901c = childAt.getRotationX();
                    aVar.f1820e.f1902d = childAt.getRotationY();
                    aVar.f1820e.f1903e = childAt.getScaleX();
                    aVar.f1820e.f1904f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        C0026e c0026e = aVar.f1820e;
                        c0026e.f1905g = pivotX;
                        c0026e.f1906h = pivotY;
                    }
                    aVar.f1820e.f1908j = childAt.getTranslationX();
                    aVar.f1820e.f1909k = childAt.getTranslationY();
                    if (i11 >= 21) {
                        aVar.f1820e.f1910l = childAt.getTranslationZ();
                        C0026e c0026e2 = aVar.f1820e;
                        if (c0026e2.f1911m) {
                            c0026e2.f1912n = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof androidx.constraintlayout.widget.a) {
                    androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                    aVar.f1819d.f1865o0 = aVar2.getAllowsGoneWidget();
                    aVar.f1819d.f1855j0 = aVar2.getReferencedIds();
                    aVar.f1819d.f1849g0 = aVar2.getType();
                    aVar.f1819d.f1851h0 = aVar2.getMargin();
                }
            }
        }
    }

    public void g(f fVar) {
        int childCount = fVar.getChildCount();
        this.f1815c.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = fVar.getChildAt(i10);
            f.a aVar = (f.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f1814b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1815c.containsKey(Integer.valueOf(id))) {
                this.f1815c.put(Integer.valueOf(id), new a());
            }
            a aVar2 = this.f1815c.get(Integer.valueOf(id));
            if (aVar2 != null) {
                if (childAt instanceof androidx.constraintlayout.widget.c) {
                    aVar2.h((androidx.constraintlayout.widget.c) childAt, id, aVar);
                }
                aVar2.g(id, aVar);
            }
        }
    }

    public void j(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a i11 = i(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        i11.f1819d.f1836a = true;
                    }
                    this.f1815c.put(Integer.valueOf(i11.f1816a), i11);
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01cb, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:42:0x00db. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.e.k(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
