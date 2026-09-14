package p9;

import bb.h1;
import bb.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import n9.a;
import n9.a1;
import n9.b;
import n9.d1;
import n9.e1;
import n9.s0;
import n9.v0;
import n9.x;
import p9.k0;

/* loaded from: classes.dex */
public abstract class p extends k implements n9.x {
    private boolean A;
    private boolean B;
    private Collection<? extends n9.x> C;
    private volatile x8.a<Collection<n9.x>> D;
    private final n9.x E;
    private final b.a F;
    private n9.x G;
    protected Map<a.InterfaceC0257a<?>, Object> H;

    /* renamed from: j, reason: collision with root package name */
    private List<a1> f13244j;

    /* renamed from: k, reason: collision with root package name */
    private List<d1> f13245k;

    /* renamed from: l, reason: collision with root package name */
    private bb.b0 f13246l;

    /* renamed from: m, reason: collision with root package name */
    private s0 f13247m;

    /* renamed from: n, reason: collision with root package name */
    private s0 f13248n;

    /* renamed from: o, reason: collision with root package name */
    private n9.a0 f13249o;

    /* renamed from: p, reason: collision with root package name */
    private n9.u f13250p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13251q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13252r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13253s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f13254t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f13255u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f13256v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f13257w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f13258x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f13259y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f13260z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements x8.a<Collection<n9.x>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ bb.a1 f13261f;

        a(bb.a1 a1Var) {
            this.f13261f = a1Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<n9.x> b() {
            jb.i iVar = new jb.i();
            Iterator<? extends n9.x> it = p.this.g().iterator();
            while (it.hasNext()) {
                iVar.add(it.next().e(this.f13261f));
            }
            return iVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements x8.a<List<e1>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f13263f;

        b(List list) {
            this.f13263f = list;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<e1> b() {
            return this.f13263f;
        }
    }

    /* loaded from: classes.dex */
    public class c implements x.a<n9.x> {

        /* renamed from: a, reason: collision with root package name */
        protected y0 f13264a;

        /* renamed from: b, reason: collision with root package name */
        protected n9.m f13265b;

        /* renamed from: c, reason: collision with root package name */
        protected n9.a0 f13266c;

        /* renamed from: d, reason: collision with root package name */
        protected n9.u f13267d;

        /* renamed from: e, reason: collision with root package name */
        protected n9.x f13268e;

        /* renamed from: f, reason: collision with root package name */
        protected b.a f13269f;

        /* renamed from: g, reason: collision with root package name */
        protected List<d1> f13270g;

        /* renamed from: h, reason: collision with root package name */
        protected s0 f13271h;

        /* renamed from: i, reason: collision with root package name */
        protected s0 f13272i;

        /* renamed from: j, reason: collision with root package name */
        protected bb.b0 f13273j;

        /* renamed from: k, reason: collision with root package name */
        protected la.e f13274k;

        /* renamed from: l, reason: collision with root package name */
        protected boolean f13275l;

        /* renamed from: m, reason: collision with root package name */
        protected boolean f13276m;

        /* renamed from: n, reason: collision with root package name */
        protected boolean f13277n;

        /* renamed from: o, reason: collision with root package name */
        protected boolean f13278o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f13279p;

        /* renamed from: q, reason: collision with root package name */
        private List<a1> f13280q;

        /* renamed from: r, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f13281r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f13282s;

        /* renamed from: t, reason: collision with root package name */
        private Map<a.InterfaceC0257a<?>, Object> f13283t;

        /* renamed from: u, reason: collision with root package name */
        private Boolean f13284u;

        /* renamed from: v, reason: collision with root package name */
        protected boolean f13285v;

        /* renamed from: w, reason: collision with root package name */
        final /* synthetic */ p f13286w;

        public c(p pVar, y0 y0Var, n9.m mVar, n9.a0 a0Var, n9.u uVar, b.a aVar, List<d1> list, s0 s0Var, bb.b0 b0Var, la.e eVar) {
            if (y0Var == null) {
                u(0);
            }
            if (mVar == null) {
                u(1);
            }
            if (a0Var == null) {
                u(2);
            }
            if (uVar == null) {
                u(3);
            }
            if (aVar == null) {
                u(4);
            }
            if (list == null) {
                u(5);
            }
            if (b0Var == null) {
                u(6);
            }
            this.f13286w = pVar;
            this.f13268e = null;
            this.f13272i = pVar.f13248n;
            this.f13275l = true;
            this.f13276m = false;
            this.f13277n = false;
            this.f13278o = false;
            this.f13279p = pVar.p0();
            this.f13280q = null;
            this.f13281r = null;
            this.f13282s = pVar.C0();
            this.f13283t = new LinkedHashMap();
            this.f13284u = null;
            this.f13285v = false;
            this.f13264a = y0Var;
            this.f13265b = mVar;
            this.f13266c = a0Var;
            this.f13267d = uVar;
            this.f13269f = aVar;
            this.f13270g = list;
            this.f13271h = s0Var;
            this.f13273j = b0Var;
            this.f13274k = eVar;
        }

        private static /* synthetic */ void u(int i10) {
            String str;
            int i11;
            switch (i10) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case androidx.constraintlayout.widget.j.W4 /* 38 */:
                case androidx.constraintlayout.widget.j.X4 /* 39 */:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i10) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case androidx.constraintlayout.widget.j.W4 /* 38 */:
                case androidx.constraintlayout.widget.j.X4 /* 39 */:
                    i11 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                default:
                    i11 = 3;
                    break;
            }
            Object[] objArr = new Object[i11];
            switch (i10) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case androidx.constraintlayout.widget.j.W4 /* 38 */:
                case androidx.constraintlayout.widget.j.X4 /* 39 */:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = "parameters";
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i10) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case androidx.constraintlayout.widget.j.W4 /* 38 */:
                    objArr[1] = "getSubstitution";
                    break;
                case androidx.constraintlayout.widget.j.X4 /* 39 */:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i10) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case androidx.constraintlayout.widget.j.W4 /* 38 */:
                case androidx.constraintlayout.widget.j.X4 /* 39 */:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i10) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case androidx.constraintlayout.widget.j.W4 /* 38 */:
                case androidx.constraintlayout.widget.j.X4 /* 39 */:
                    throw new IllegalStateException(format);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        @Override // n9.x.a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public c o(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
            if (gVar == null) {
                u(32);
            }
            this.f13281r = gVar;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public c s(boolean z10) {
            this.f13275l = z10;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public c b(s0 s0Var) {
            this.f13272i = s0Var;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public c a() {
            this.f13278o = true;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public c p(s0 s0Var) {
            this.f13271h = s0Var;
            return this;
        }

        public c G(boolean z10) {
            this.f13284u = Boolean.valueOf(z10);
            return this;
        }

        @Override // n9.x.a
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public c r() {
            this.f13282s = true;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public c m() {
            this.f13279p = true;
            return this;
        }

        public c J(boolean z10) {
            this.f13285v = z10;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public c q(b.a aVar) {
            if (aVar == null) {
                u(13);
            }
            this.f13269f = aVar;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public c i(n9.a0 a0Var) {
            if (a0Var == null) {
                u(9);
            }
            this.f13266c = a0Var;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public c j(la.e eVar) {
            if (eVar == null) {
                u(16);
            }
            this.f13274k = eVar;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public c h(n9.b bVar) {
            this.f13268e = (n9.x) bVar;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public c l(n9.m mVar) {
            if (mVar == null) {
                u(7);
            }
            this.f13265b = mVar;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public c n() {
            this.f13277n = true;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public c k(bb.b0 b0Var) {
            if (b0Var == null) {
                u(22);
            }
            this.f13273j = b0Var;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public c t() {
            this.f13276m = true;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: S, reason: merged with bridge method [inline-methods] */
        public c e(y0 y0Var) {
            if (y0Var == null) {
                u(34);
            }
            this.f13264a = y0Var;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: T, reason: merged with bridge method [inline-methods] */
        public c g(List<a1> list) {
            if (list == null) {
                u(20);
            }
            this.f13280q = list;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: U, reason: merged with bridge method [inline-methods] */
        public c f(List<d1> list) {
            if (list == null) {
                u(18);
            }
            this.f13270g = list;
            return this;
        }

        @Override // n9.x.a
        /* renamed from: V, reason: merged with bridge method [inline-methods] */
        public c d(n9.u uVar) {
            if (uVar == null) {
                u(11);
            }
            this.f13267d = uVar;
            return this;
        }

        @Override // n9.x.a
        public n9.x c() {
            return this.f13286w.X0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(n9.m mVar, n9.x xVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, b.a aVar, v0 v0Var) {
        super(mVar, gVar, eVar, v0Var);
        if (mVar == null) {
            e0(0);
        }
        if (gVar == null) {
            e0(1);
        }
        if (eVar == null) {
            e0(2);
        }
        if (aVar == null) {
            e0(3);
        }
        if (v0Var == null) {
            e0(4);
        }
        this.f13250p = n9.t.f12307i;
        this.f13251q = false;
        this.f13252r = false;
        this.f13253s = false;
        this.f13254t = false;
        this.f13255u = false;
        this.f13256v = false;
        this.f13257w = false;
        this.f13258x = false;
        this.f13259y = false;
        this.f13260z = false;
        this.A = true;
        this.B = false;
        this.C = null;
        this.D = null;
        this.G = null;
        this.H = null;
        this.E = xVar == null ? this : xVar;
        this.F = aVar;
    }

    private v0 Y0(boolean z10, n9.x xVar) {
        v0 v0Var;
        if (z10) {
            if (xVar == null) {
                xVar = a();
            }
            v0Var = xVar.k();
        } else {
            v0Var = v0.f12324a;
        }
        if (v0Var == null) {
            e0(25);
        }
        return v0Var;
    }

    public static List<d1> Z0(n9.x xVar, List<d1> list, bb.a1 a1Var) {
        if (list == null) {
            e0(26);
        }
        if (a1Var == null) {
            e0(27);
        }
        return a1(xVar, list, a1Var, false, false, null);
    }

    public static List<d1> a1(n9.x xVar, List<d1> list, bb.a1 a1Var, boolean z10, boolean z11, boolean[] zArr) {
        if (list == null) {
            e0(28);
        }
        if (a1Var == null) {
            e0(29);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (d1 d1Var : list) {
            bb.b0 b10 = d1Var.b();
            h1 h1Var = h1.IN_VARIANCE;
            bb.b0 p10 = a1Var.p(b10, h1Var);
            bb.b0 R = d1Var.R();
            bb.b0 p11 = R == null ? null : a1Var.p(R, h1Var);
            if (p10 == null) {
                return null;
            }
            if ((p10 != d1Var.b() || R != p11) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(k0.V0(xVar, z10 ? null : d1Var, d1Var.j(), d1Var.u(), d1Var.c(), p10, d1Var.k0(), d1Var.E(), d1Var.G0(), p11, z11 ? d1Var.k() : v0.f12324a, d1Var instanceof k0.b ? new b(((k0.b) d1Var).Y0()) : null));
        }
        return arrayList;
    }

    private static /* synthetic */ void e0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i11 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    private void e1() {
        x8.a<Collection<n9.x>> aVar = this.D;
        if (aVar != null) {
            this.C = aVar.b();
            this.D = null;
        }
    }

    private void l1(boolean z10) {
        this.f13259y = z10;
    }

    private void m1(boolean z10) {
        this.f13258x = z10;
    }

    private void o1(n9.x xVar) {
        this.G = xVar;
    }

    @Override // n9.x
    public boolean C0() {
        return this.f13259y;
    }

    public <V> V G(a.InterfaceC0257a<V> interfaceC0257a) {
        Map<a.InterfaceC0257a<?>, Object> map = this.H;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC0257a);
    }

    @Override // n9.x
    public n9.x H() {
        return this.G;
    }

    @Override // n9.z
    public boolean H0() {
        return this.f13257w;
    }

    public boolean I() {
        return this.f13253s;
    }

    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.f(this, d10);
    }

    @Override // n9.a
    public s0 K() {
        return this.f13248n;
    }

    @Override // n9.x
    public boolean N0() {
        if (this.f13252r) {
            return true;
        }
        Iterator<? extends n9.x> it = a().g().iterator();
        while (it.hasNext()) {
            if (it.next().N0()) {
                return true;
            }
        }
        return false;
    }

    @Override // n9.a
    public s0 U() {
        return this.f13247m;
    }

    @Override // n9.b
    public n9.x V0(n9.m mVar, n9.a0 a0Var, n9.u uVar, b.a aVar, boolean z10) {
        n9.x c10 = y().l(mVar).i(a0Var).d(uVar).q(aVar).s(z10).c();
        if (c10 == null) {
            e0(24);
        }
        return c10;
    }

    protected abstract p W0(n9.m mVar, n9.x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public n9.x X0(c cVar) {
        e0 e0Var;
        s0 s0Var;
        bb.b0 p10;
        x8.a<Collection<n9.x>> aVar;
        if (cVar == null) {
            e0(23);
        }
        boolean[] zArr = new boolean[1];
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a10 = cVar.f13281r != null ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.i.a(u(), cVar.f13281r) : u();
        n9.m mVar = cVar.f13265b;
        n9.x xVar = cVar.f13268e;
        p W0 = W0(mVar, xVar, cVar.f13269f, cVar.f13274k, a10, Y0(cVar.f13277n, xVar));
        List<a1> m10 = cVar.f13280q == null ? m() : cVar.f13280q;
        zArr[0] = zArr[0] | (!m10.isEmpty());
        ArrayList arrayList = new ArrayList(m10.size());
        bb.a1 c10 = bb.o.c(m10, cVar.f13264a, W0, arrayList, zArr);
        if (c10 == null) {
            return null;
        }
        s0 s0Var2 = cVar.f13271h;
        if (s0Var2 != null) {
            bb.b0 p11 = c10.p(s0Var2.b(), h1.IN_VARIANCE);
            if (p11 == null) {
                return null;
            }
            e0 e0Var2 = new e0(W0, new va.b(W0, p11, cVar.f13271h.getValue()), cVar.f13271h.u());
            zArr[0] = (p11 != cVar.f13271h.b()) | zArr[0];
            e0Var = e0Var2;
        } else {
            e0Var = null;
        }
        s0 s0Var3 = cVar.f13272i;
        if (s0Var3 != null) {
            s0 e10 = s0Var3.e(c10);
            if (e10 == null) {
                return null;
            }
            zArr[0] = zArr[0] | (e10 != cVar.f13272i);
            s0Var = e10;
        } else {
            s0Var = null;
        }
        List<d1> a12 = a1(W0, cVar.f13270g, c10, cVar.f13278o, cVar.f13277n, zArr);
        if (a12 == null || (p10 = c10.p(cVar.f13273j, h1.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (p10 != cVar.f13273j);
        if (!zArr[0] && cVar.f13285v) {
            return this;
        }
        W0.c1(e0Var, s0Var, arrayList, a12, p10, cVar.f13266c, cVar.f13267d);
        W0.q1(this.f13251q);
        W0.n1(this.f13252r);
        W0.i1(this.f13253s);
        W0.p1(this.f13254t);
        W0.t1(this.f13255u);
        W0.s1(this.f13260z);
        W0.h1(this.f13256v);
        W0.g1(this.f13257w);
        W0.j1(this.A);
        W0.m1(cVar.f13279p);
        W0.l1(cVar.f13282s);
        W0.k1(cVar.f13284u != null ? cVar.f13284u.booleanValue() : this.B);
        if (!cVar.f13283t.isEmpty() || this.H != null) {
            Map<a.InterfaceC0257a<?>, Object> map = cVar.f13283t;
            Map<a.InterfaceC0257a<?>, Object> map2 = this.H;
            if (map2 != null) {
                for (Map.Entry<a.InterfaceC0257a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                map = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            }
            W0.H = map;
        }
        if (cVar.f13276m || H() != null) {
            W0.o1((H() != null ? H() : this).e(c10));
        }
        if (cVar.f13275l && !a().g().isEmpty()) {
            if (cVar.f13264a.f()) {
                aVar = this.D;
                if (aVar == null) {
                    W0.r0(g());
                }
            } else {
                aVar = new a(c10);
            }
            W0.D = aVar;
        }
        return W0;
    }

    @Override // p9.k, p9.j, n9.m
    public n9.x a() {
        n9.x xVar = this.E;
        n9.x a10 = xVar == this ? this : xVar.a();
        if (a10 == null) {
            e0(18);
        }
        return a10;
    }

    public boolean b1() {
        return this.A;
    }

    @Override // n9.a
    public boolean c0() {
        return this.B;
    }

    public p c1(s0 s0Var, s0 s0Var2, List<? extends a1> list, List<d1> list2, bb.b0 b0Var, n9.a0 a0Var, n9.u uVar) {
        List<a1> n02;
        List<d1> n03;
        if (list == null) {
            e0(5);
        }
        if (list2 == null) {
            e0(6);
        }
        if (uVar == null) {
            e0(7);
        }
        n02 = m8.y.n0(list);
        this.f13244j = n02;
        n03 = m8.y.n0(list2);
        this.f13245k = n03;
        this.f13246l = b0Var;
        this.f13249o = a0Var;
        this.f13250p = uVar;
        this.f13247m = s0Var;
        this.f13248n = s0Var2;
        for (int i10 = 0; i10 < list.size(); i10++) {
            a1 a1Var = list.get(i10);
            if (a1Var.j() != i10) {
                throw new IllegalStateException(a1Var + " index is " + a1Var.j() + " but position is " + i10);
            }
        }
        for (int i11 = 0; i11 < list2.size(); i11++) {
            d1 d1Var = list2.get(i11);
            if (d1Var.j() != i11 + 0) {
                throw new IllegalStateException(d1Var + "index is " + d1Var.j() + " but position is " + i11);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c d1(bb.a1 a1Var) {
        if (a1Var == null) {
            e0(22);
        }
        return new c(this, a1Var.j(), d(), p(), h(), r(), l(), U(), i(), null);
    }

    @Override // n9.x, n9.x0
    public n9.x e(bb.a1 a1Var) {
        if (a1Var == null) {
            e0(20);
        }
        return a1Var.k() ? this : d1(a1Var).h(a()).n().J(true).c();
    }

    public <V> void f1(a.InterfaceC0257a<V> interfaceC0257a, Object obj) {
        if (this.H == null) {
            this.H = new LinkedHashMap();
        }
        this.H.put(interfaceC0257a, obj);
    }

    public Collection<? extends n9.x> g() {
        e1();
        Collection<? extends n9.x> collection = this.C;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            e0(12);
        }
        return collection;
    }

    public void g1(boolean z10) {
        this.f13257w = z10;
    }

    @Override // n9.q, n9.z
    public n9.u h() {
        n9.u uVar = this.f13250p;
        if (uVar == null) {
            e0(14);
        }
        return uVar;
    }

    public void h1(boolean z10) {
        this.f13256v = z10;
    }

    public bb.b0 i() {
        return this.f13246l;
    }

    public void i1(boolean z10) {
        this.f13253s = z10;
    }

    public void j1(boolean z10) {
        this.A = z10;
    }

    public void k1(boolean z10) {
        this.B = z10;
    }

    @Override // n9.a
    public List<d1> l() {
        List<d1> list = this.f13245k;
        if (list == null) {
            e0(17);
        }
        return list;
    }

    @Override // n9.z
    public boolean l0() {
        return this.f13256v;
    }

    @Override // n9.a
    public List<a1> m() {
        List<a1> list = this.f13244j;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    public void n1(boolean z10) {
        this.f13252r = z10;
    }

    @Override // n9.z
    public n9.a0 p() {
        n9.a0 a0Var = this.f13249o;
        if (a0Var == null) {
            e0(13);
        }
        return a0Var;
    }

    @Override // n9.x
    public boolean p0() {
        return this.f13258x;
    }

    public void p1(boolean z10) {
        this.f13254t = z10;
    }

    public boolean q0() {
        return this.f13260z;
    }

    public void q1(boolean z10) {
        this.f13251q = z10;
    }

    @Override // n9.b
    public b.a r() {
        b.a aVar = this.F;
        if (aVar == null) {
            e0(19);
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r0(Collection<? extends n9.b> collection) {
        if (collection == 0) {
            e0(15);
        }
        this.C = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((n9.x) it.next()).C0()) {
                this.f13259y = true;
                return;
            }
        }
    }

    public void r1(bb.b0 b0Var) {
        if (b0Var == null) {
            e0(10);
        }
        this.f13246l = b0Var;
    }

    public boolean s0() {
        return this.f13255u;
    }

    public void s1(boolean z10) {
        this.f13260z = z10;
    }

    @Override // n9.x
    public boolean t0() {
        if (this.f13251q) {
            return true;
        }
        Iterator<? extends n9.x> it = a().g().iterator();
        while (it.hasNext()) {
            if (it.next().t0()) {
                return true;
            }
        }
        return false;
    }

    public void t1(boolean z10) {
        this.f13255u = z10;
    }

    public void u1(n9.u uVar) {
        if (uVar == null) {
            e0(9);
        }
        this.f13250p = uVar;
    }

    public boolean x() {
        return this.f13254t;
    }

    public x.a<? extends n9.x> y() {
        c d12 = d1(bb.a1.f4159b);
        if (d12 == null) {
            e0(21);
        }
        return d12;
    }
}
