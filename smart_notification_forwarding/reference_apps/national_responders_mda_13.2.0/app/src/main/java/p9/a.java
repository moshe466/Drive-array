package p9;

import bb.a1;
import bb.c1;
import bb.y0;
import n9.s0;
import n9.z0;

/* loaded from: classes.dex */
public abstract class a extends t {

    /* renamed from: g, reason: collision with root package name */
    private final la.e f13129g;

    /* renamed from: h, reason: collision with root package name */
    protected final ab.i<bb.i0> f13130h;

    /* renamed from: i, reason: collision with root package name */
    private final ab.i<ua.h> f13131i;

    /* renamed from: j, reason: collision with root package name */
    private final ab.i<s0> f13132j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0273a implements x8.a<bb.i0> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: p9.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0274a implements x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, bb.i0> {
            C0274a() {
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public bb.i0 h(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
                n9.h e10 = gVar.e(a.this);
                return e10 == null ? a.this.f13130h.b() : e10 instanceof z0 ? bb.c0.b((z0) e10, c1.g(e10.o().B())) : e10 instanceof t ? c1.t(e10.o().y(gVar), ((t) e10).v0(gVar), this) : e10.s();
            }
        }

        C0273a() {
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public bb.i0 b() {
            a aVar = a.this;
            return c1.u(aVar, aVar.E0(), new C0274a());
        }
    }

    /* loaded from: classes.dex */
    class b implements x8.a<ua.h> {
        b() {
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ua.h b() {
            return new ua.f(a.this.E0());
        }
    }

    /* loaded from: classes.dex */
    class c implements x8.a<s0> {
        c() {
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s0 b() {
            return new q(a.this);
        }
    }

    public a(ab.n nVar, la.e eVar) {
        if (nVar == null) {
            I0(0);
        }
        if (eVar == null) {
            I0(1);
        }
        this.f13129g = eVar;
        this.f13130h = nVar.a(new C0273a());
        this.f13131i = nVar.a(new b());
        this.f13132j = nVar.a(new c());
    }

    private static /* synthetic */ void I0(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8 || i10 == 11 || i10 == 13 || i10 == 15 || i10 == 16 || i10 == 18 || i10 == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8 || i10 == 11 || i10 == 13 || i10 == 15 || i10 == 16 || i10 == 18 || i10 == 19) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i10 == 2) {
            objArr[1] = "getName";
        } else if (i10 == 3) {
            objArr[1] = "getOriginal";
        } else if (i10 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i10 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i10 == 8 || i10 == 11 || i10 == 13 || i10 == 15) {
            objArr[1] = "getMemberScope";
        } else if (i10 == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i10 == 18) {
            objArr[1] = "substitute";
        } else if (i10 != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 8 && i10 != 11 && i10 != 13 && i10 != 15 && i10 != 16 && i10 != 18 && i10 != 19) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // n9.e
    public ua.h E0() {
        ua.h v02 = v0(ra.a.k(na.d.g(this)));
        if (v02 == null) {
            I0(16);
        }
        return v02;
    }

    @Override // n9.e
    public ua.h J(y0 y0Var) {
        if (y0Var == null) {
            I0(14);
        }
        ua.h e02 = e0(y0Var, ra.a.k(na.d.g(this)));
        if (e02 == null) {
            I0(15);
        }
        return e02;
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return oVar.e(this, d10);
    }

    @Override // n9.e
    public s0 T0() {
        s0 b10 = this.f13132j.b();
        if (b10 == null) {
            I0(5);
        }
        return b10;
    }

    @Override // n9.x0
    /* renamed from: U0 */
    public n9.e e(a1 a1Var) {
        if (a1Var == null) {
            I0(17);
        }
        return a1Var.k() ? this : new s(this, a1Var);
    }

    @Override // n9.m
    public n9.e a() {
        return this;
    }

    @Override // n9.e0
    public la.e c() {
        la.e eVar = this.f13129g;
        if (eVar == null) {
            I0(2);
        }
        return eVar;
    }

    @Override // p9.t
    public ua.h e0(y0 y0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (y0Var == null) {
            I0(9);
        }
        if (gVar == null) {
            I0(10);
        }
        if (!y0Var.f()) {
            return new ua.m(v0(gVar), a1.g(y0Var));
        }
        ua.h v02 = v0(gVar);
        if (v02 == null) {
            I0(11);
        }
        return v02;
    }

    @Override // n9.e, n9.h
    public bb.i0 s() {
        bb.i0 b10 = this.f13130h.b();
        if (b10 == null) {
            I0(19);
        }
        return b10;
    }

    @Override // n9.e
    public ua.h u0() {
        ua.h b10 = this.f13131i.b();
        if (b10 == null) {
            I0(4);
        }
        return b10;
    }
}
