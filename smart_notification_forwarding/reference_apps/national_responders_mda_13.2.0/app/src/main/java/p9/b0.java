package p9;

import bb.h1;
import bb.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n9.a1;
import n9.b;
import n9.d1;
import n9.o0;
import n9.p0;
import n9.q0;
import n9.r0;
import n9.s0;
import n9.v0;

/* loaded from: classes.dex */
public class b0 extends m0 implements p0 {
    private c0 A;
    private r0 B;
    private boolean C;
    private n9.v D;
    private n9.v E;

    /* renamed from: m, reason: collision with root package name */
    private final n9.a0 f13145m;

    /* renamed from: n, reason: collision with root package name */
    private n9.u f13146n;

    /* renamed from: o, reason: collision with root package name */
    private Collection<? extends p0> f13147o;

    /* renamed from: p, reason: collision with root package name */
    private final p0 f13148p;

    /* renamed from: q, reason: collision with root package name */
    private final b.a f13149q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f13150r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f13151s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f13152t;

    /* renamed from: u, reason: collision with root package name */
    private final boolean f13153u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f13154v;

    /* renamed from: w, reason: collision with root package name */
    private final boolean f13155w;

    /* renamed from: x, reason: collision with root package name */
    private s0 f13156x;

    /* renamed from: y, reason: collision with root package name */
    private s0 f13157y;

    /* renamed from: z, reason: collision with root package name */
    private List<a1> f13158z;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private n9.m f13159a;

        /* renamed from: b, reason: collision with root package name */
        private n9.a0 f13160b;

        /* renamed from: c, reason: collision with root package name */
        private n9.u f13161c;

        /* renamed from: f, reason: collision with root package name */
        private b.a f13164f;

        /* renamed from: i, reason: collision with root package name */
        private s0 f13167i;

        /* renamed from: k, reason: collision with root package name */
        private la.e f13169k;

        /* renamed from: l, reason: collision with root package name */
        private bb.b0 f13170l;

        /* renamed from: d, reason: collision with root package name */
        private p0 f13162d = null;

        /* renamed from: e, reason: collision with root package name */
        private boolean f13163e = false;

        /* renamed from: g, reason: collision with root package name */
        private y0 f13165g = y0.f4281a;

        /* renamed from: h, reason: collision with root package name */
        private boolean f13166h = true;

        /* renamed from: j, reason: collision with root package name */
        private List<a1> f13168j = null;

        public a() {
            this.f13159a = b0.this.d();
            this.f13160b = b0.this.p();
            this.f13161c = b0.this.h();
            this.f13164f = b0.this.r();
            this.f13167i = b0.this.f13156x;
            this.f13169k = b0.this.c();
            this.f13170l = b0.this.b();
        }

        private static /* synthetic */ void a(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "setOwner";
            } else if (i10 == 2) {
                objArr[1] = "setOriginal";
            } else if (i10 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i10 == 5) {
                objArr[1] = "setReturnType";
            } else if (i10 == 7) {
                objArr[1] = "setModality";
            } else if (i10 == 9) {
                objArr[1] = "setVisibility";
            } else if (i10 == 11) {
                objArr[1] = "setKind";
            } else if (i10 == 19) {
                objArr[1] = "setName";
            } else if (i10 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i10 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i10 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i10 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 5 && i10 != 7 && i10 != 9 && i10 != 11 && i10 != 19 && i10 != 13 && i10 != 14 && i10 != 16 && i10 != 17) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public p0 n() {
            return b0.this.a1(this);
        }

        q0 o() {
            p0 p0Var = this.f13162d;
            if (p0Var == null) {
                return null;
            }
            return p0Var.t();
        }

        r0 p() {
            p0 p0Var = this.f13162d;
            if (p0Var == null) {
                return null;
            }
            return p0Var.M0();
        }

        public a q(boolean z10) {
            this.f13166h = z10;
            return this;
        }

        public a r(b.a aVar) {
            if (aVar == null) {
                a(10);
            }
            this.f13164f = aVar;
            return this;
        }

        public a s(n9.a0 a0Var) {
            if (a0Var == null) {
                a(6);
            }
            this.f13160b = a0Var;
            return this;
        }

        public a t(n9.b bVar) {
            this.f13162d = (p0) bVar;
            return this;
        }

        public a u(n9.m mVar) {
            if (mVar == null) {
                a(0);
            }
            this.f13159a = mVar;
            return this;
        }

        public a v(y0 y0Var) {
            if (y0Var == null) {
                a(15);
            }
            this.f13165g = y0Var;
            return this;
        }

        public a w(n9.u uVar) {
            if (uVar == null) {
                a(8);
            }
            this.f13161c = uVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(n9.m mVar, p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, n9.a0 a0Var, n9.u uVar, boolean z10, la.e eVar, b.a aVar, v0 v0Var, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        super(mVar, gVar, eVar, null, z10, v0Var);
        if (mVar == null) {
            e0(0);
        }
        if (gVar == null) {
            e0(1);
        }
        if (a0Var == null) {
            e0(2);
        }
        if (uVar == null) {
            e0(3);
        }
        if (eVar == null) {
            e0(4);
        }
        if (aVar == null) {
            e0(5);
        }
        if (v0Var == null) {
            e0(6);
        }
        this.f13147o = null;
        this.f13145m = a0Var;
        this.f13146n = uVar;
        this.f13148p = p0Var == null ? this : p0Var;
        this.f13149q = aVar;
        this.f13150r = z11;
        this.f13151s = z12;
        this.f13152t = z13;
        this.f13153u = z14;
        this.f13154v = z15;
        this.f13155w = z16;
    }

    public static b0 Y0(n9.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, n9.a0 a0Var, n9.u uVar, boolean z10, la.e eVar, b.a aVar, v0 v0Var, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        if (mVar == null) {
            e0(7);
        }
        if (gVar == null) {
            e0(8);
        }
        if (a0Var == null) {
            e0(9);
        }
        if (uVar == null) {
            e0(10);
        }
        if (eVar == null) {
            e0(11);
        }
        if (aVar == null) {
            e0(12);
        }
        if (v0Var == null) {
            e0(13);
        }
        return new b0(mVar, null, gVar, a0Var, uVar, z10, eVar, aVar, v0Var, z11, z12, z13, z14, z15, z16);
    }

    private v0 c1(boolean z10, p0 p0Var) {
        v0 v0Var;
        if (z10) {
            if (p0Var == null) {
                p0Var = a();
            }
            v0Var = p0Var.k();
        } else {
            v0Var = v0.f12324a;
        }
        if (v0Var == null) {
            e0(23);
        }
        return v0Var;
    }

    private static n9.x d1(bb.a1 a1Var, o0 o0Var) {
        if (a1Var == null) {
            e0(25);
        }
        if (o0Var == null) {
            e0(26);
        }
        if (o0Var.H() != null) {
            return o0Var.H().e(a1Var);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void e0(int r11) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.b0.e0(int):void");
    }

    private static n9.u i1(n9.u uVar, b.a aVar) {
        return (aVar == b.a.FAKE_OVERRIDE && n9.t.g(uVar.f())) ? n9.t.f12306h : uVar;
    }

    @Override // n9.p0
    public List<o0> D() {
        ArrayList arrayList = new ArrayList(2);
        c0 c0Var = this.A;
        if (c0Var != null) {
            arrayList.add(c0Var);
        }
        r0 r0Var = this.B;
        if (r0Var != null) {
            arrayList.add(r0Var);
        }
        return arrayList;
    }

    @Override // n9.z
    public boolean H0() {
        return this.f13153u;
    }

    @Override // n9.z
    public boolean I() {
        return this.f13154v;
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.j(this, d10);
    }

    @Override // p9.l0, n9.a
    public s0 K() {
        return this.f13156x;
    }

    @Override // n9.p0
    public r0 M0() {
        return this.B;
    }

    @Override // n9.e1
    public boolean O() {
        return this.f13151s;
    }

    @Override // p9.l0, n9.a
    public s0 U() {
        return this.f13157y;
    }

    @Override // n9.p0
    public n9.v X() {
        return this.E;
    }

    @Override // n9.b
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public p0 V0(n9.m mVar, n9.a0 a0Var, n9.u uVar, b.a aVar, boolean z10) {
        p0 n10 = h1().u(mVar).t(null).s(a0Var).w(uVar).r(aVar).q(z10).n();
        if (n10 == null) {
            e0(37);
        }
        return n10;
    }

    protected b0 Z0(n9.m mVar, n9.a0 a0Var, n9.u uVar, p0 p0Var, b.a aVar, la.e eVar, v0 v0Var) {
        if (mVar == null) {
            e0(27);
        }
        if (a0Var == null) {
            e0(28);
        }
        if (uVar == null) {
            e0(29);
        }
        if (aVar == null) {
            e0(30);
        }
        if (eVar == null) {
            e0(31);
        }
        if (v0Var == null) {
            e0(32);
        }
        return new b0(mVar, p0Var, u(), a0Var, uVar, P(), eVar, aVar, v0Var, h0(), O(), l0(), H0(), I(), o0());
    }

    @Override // p9.k, p9.j, n9.m
    public p0 a() {
        p0 p0Var = this.f13148p;
        p0 a10 = p0Var == this ? this : p0Var.a();
        if (a10 == null) {
            e0(33);
        }
        return a10;
    }

    protected p0 a1(a aVar) {
        s0 s0Var;
        e0 e0Var;
        ab.j<pa.g<?>> jVar;
        if (aVar == null) {
            e0(24);
        }
        b0 Z0 = Z0(aVar.f13159a, aVar.f13160b, aVar.f13161c, aVar.f13162d, aVar.f13164f, aVar.f13169k, c1(aVar.f13163e, aVar.f13162d));
        List<a1> m10 = aVar.f13168j == null ? m() : aVar.f13168j;
        ArrayList arrayList = new ArrayList(m10.size());
        bb.a1 b10 = bb.o.b(m10, aVar.f13165g, Z0, arrayList);
        bb.b0 b0Var = aVar.f13170l;
        h1 h1Var = h1.OUT_VARIANCE;
        bb.b0 p10 = b10.p(b0Var, h1Var);
        if (p10 == null) {
            return null;
        }
        s0 s0Var2 = aVar.f13167i;
        if (s0Var2 != null) {
            s0Var = s0Var2.e(b10);
            if (s0Var == null) {
                return null;
            }
        } else {
            s0Var = null;
        }
        s0 s0Var3 = this.f13157y;
        if (s0Var3 != null) {
            bb.b0 p11 = b10.p(s0Var3.b(), h1.IN_VARIANCE);
            if (p11 == null) {
                return null;
            }
            e0Var = new e0(Z0, new va.b(Z0, p11, this.f13157y.getValue()), this.f13157y.u());
        } else {
            e0Var = null;
        }
        Z0.k1(p10, arrayList, s0Var, e0Var);
        c0 c0Var = this.A == null ? null : new c0(Z0, this.A.u(), aVar.f13160b, i1(this.A.h(), aVar.f13164f), this.A.B0(), this.A.I(), this.A.x(), aVar.f13164f, aVar.o(), v0.f12324a);
        if (c0Var != null) {
            bb.b0 i10 = this.A.i();
            c0Var.Y0(d1(b10, this.A));
            c0Var.b1(i10 != null ? b10.p(i10, h1Var) : null);
        }
        d0 d0Var = this.B == null ? null : new d0(Z0, this.B.u(), aVar.f13160b, i1(this.B.h(), aVar.f13164f), this.B.B0(), this.B.I(), this.B.x(), aVar.f13164f, aVar.p(), v0.f12324a);
        if (d0Var != null) {
            List<d1> a12 = p.a1(d0Var, this.B.l(), b10, false, false, null);
            if (a12 == null) {
                Z0.j1(true);
                a12 = Collections.singletonList(d0.a1(d0Var, ra.a.g(aVar.f13159a).H(), this.B.l().get(0).u()));
            }
            if (a12.size() != 1) {
                throw new IllegalStateException();
            }
            d0Var.Y0(d1(b10, this.B));
            d0Var.c1(a12.get(0));
        }
        n9.v vVar = this.D;
        o oVar = vVar == null ? null : new o(vVar.u(), Z0);
        n9.v vVar2 = this.E;
        Z0.f1(c0Var, d0Var, oVar, vVar2 != null ? new o(vVar2.u(), Z0) : null);
        if (aVar.f13166h) {
            jb.j c10 = jb.j.c();
            Iterator<? extends p0> it = g().iterator();
            while (it.hasNext()) {
                c10.add(it.next().e(b10));
            }
            Z0.r0(c10);
        }
        if (O() && (jVar = this.f13230l) != null) {
            Z0.V0(jVar);
        }
        return Z0;
    }

    @Override // n9.p0
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public c0 t() {
        return this.A;
    }

    @Override // n9.p0
    public n9.v d0() {
        return this.D;
    }

    @Override // n9.x0
    public p0 e(bb.a1 a1Var) {
        if (a1Var == null) {
            e0(22);
        }
        return a1Var.k() ? this : h1().v(a1Var.j()).t(a()).n();
    }

    public void e1(c0 c0Var, r0 r0Var) {
        f1(c0Var, r0Var, null, null);
    }

    public void f1(c0 c0Var, r0 r0Var, n9.v vVar, n9.v vVar2) {
        this.A = c0Var;
        this.B = r0Var;
        this.D = vVar;
        this.E = vVar2;
    }

    @Override // n9.a
    public Collection<? extends p0> g() {
        Collection<? extends p0> collection = this.f13147o;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            e0(36);
        }
        return collection;
    }

    public boolean g1() {
        return this.C;
    }

    @Override // n9.q, n9.z
    public n9.u h() {
        n9.u uVar = this.f13146n;
        if (uVar == null) {
            e0(20);
        }
        return uVar;
    }

    @Override // n9.e1
    public boolean h0() {
        return this.f13150r;
    }

    public a h1() {
        return new a();
    }

    @Override // p9.l0, n9.a
    public bb.b0 i() {
        bb.b0 b10 = b();
        if (b10 == null) {
            e0(18);
        }
        return b10;
    }

    public void j1(boolean z10) {
        this.C = z10;
    }

    public void k1(bb.b0 b0Var, List<? extends a1> list, s0 s0Var, s0 s0Var2) {
        if (b0Var == null) {
            e0(14);
        }
        if (list == null) {
            e0(15);
        }
        U0(b0Var);
        this.f13158z = new ArrayList(list);
        this.f13157y = s0Var2;
        this.f13156x = s0Var;
    }

    @Override // n9.z
    public boolean l0() {
        return this.f13152t;
    }

    public void l1(n9.u uVar) {
        if (uVar == null) {
            e0(16);
        }
        this.f13146n = uVar;
    }

    @Override // p9.l0, n9.a
    public List<a1> m() {
        List<a1> list = this.f13158z;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // n9.f1
    public boolean o0() {
        return this.f13155w;
    }

    @Override // n9.z
    public n9.a0 p() {
        n9.a0 a0Var = this.f13145m;
        if (a0Var == null) {
            e0(19);
        }
        return a0Var;
    }

    @Override // n9.b
    public b.a r() {
        b.a aVar = this.f13149q;
        if (aVar == null) {
            e0(34);
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n9.b
    public void r0(Collection<? extends n9.b> collection) {
        if (collection == 0) {
            e0(35);
        }
        this.f13147o = collection;
    }
}
