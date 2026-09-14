package k9;

import bb.b0;
import bb.c0;
import bb.c1;
import bb.h1;
import bb.i0;
import bb.t0;
import bb.x0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k9.k;
import n9.d0;
import n9.g0;
import n9.l0;
import n9.p0;
import n9.q0;
import n9.r0;
import n9.s;
import n9.w;
import o9.a;
import o9.c;
import p9.x;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: e, reason: collision with root package name */
    public static final la.e f11213e = la.e.u("<built-ins module>");

    /* renamed from: a, reason: collision with root package name */
    private x f11214a;

    /* renamed from: b, reason: collision with root package name */
    private final ab.i<e> f11215b;

    /* renamed from: c, reason: collision with root package name */
    private final ab.g<la.e, n9.e> f11216c;

    /* renamed from: d, reason: collision with root package name */
    private final ab.n f11217d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements x8.a<Collection<l0>> {
        a() {
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<l0> b() {
            return Arrays.asList(h.this.f11214a.C(k.f11246l), h.this.f11214a.C(k.f11248n), h.this.f11214a.C(k.f11249o), h.this.f11214a.C(k.f11247m));
        }
    }

    /* loaded from: classes.dex */
    class b implements x8.a<e> {
        b() {
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e b() {
            EnumMap enumMap = new EnumMap(i.class);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (i iVar : i.valuesCustom()) {
                i0 q10 = h.this.q(iVar.getTypeName().k());
                i0 q11 = h.this.q(iVar.getArrayTypeName().k());
                enumMap.put((EnumMap) iVar, (i) q11);
                hashMap.put(q10, q11);
                hashMap2.put(q11, q10);
            }
            return new e(enumMap, hashMap, hashMap2, null);
        }
    }

    /* loaded from: classes.dex */
    class c implements x8.l<la.e, n9.e> {
        c() {
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n9.e h(la.e eVar) {
            n9.h g10 = h.this.s().g(eVar, u9.d.FROM_BUILTINS);
            if (g10 == null) {
                throw new AssertionError("Built-in class " + k.f11246l.c(eVar) + " is not found");
            }
            if (g10 instanceof n9.e) {
                return (n9.e) g10;
            }
            throw new AssertionError("Must be a class descriptor " + eVar + ", but was " + g10);
        }
    }

    /* loaded from: classes.dex */
    class d implements x8.a<Void> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f11221f;

        d(x xVar) {
            this.f11221f = xVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void b() {
            if (h.this.f11214a == null) {
                h.this.f11214a = this.f11221f;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + h.this.f11214a + " (attempting to reset to " + this.f11221f + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final Map<i, i0> f11223a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<b0, i0> f11224b;

        /* renamed from: c, reason: collision with root package name */
        public final Map<i0, i0> f11225c;

        private e(Map<i, i0> map, Map<b0, i0> map2, Map<i0, i0> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.f11223a = map;
            this.f11224b = map2;
            this.f11225c = map3;
        }

        /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i10 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(ab.n nVar) {
        if (nVar == null) {
            a(0);
        }
        this.f11217d = nVar;
        nVar.a(new a());
        this.f11215b = nVar.a(new b());
        this.f11216c = nVar.i(new c());
    }

    private static b0 A(b0 b0Var, d0 d0Var) {
        la.a h10;
        la.a a10;
        n9.e a11;
        if (b0Var == null) {
            a(70);
        }
        if (d0Var == null) {
            a(71);
        }
        n9.h A = b0Var.W0().A();
        if (A == null) {
            return null;
        }
        o oVar = o.f11295a;
        if (!oVar.b(A.c()) || (h10 = ra.a.h(A)) == null || (a10 = oVar.a(h10)) == null || (a11 = w.a(d0Var, a10)) == null) {
            return null;
        }
        return a11.s();
    }

    public static boolean A0(b0 b0Var) {
        if (b0Var == null) {
            a(119);
        }
        return i0(b0Var, k.a.f11273l);
    }

    public static boolean B0(n9.e eVar) {
        if (eVar == null) {
            a(106);
        }
        return e(eVar, k.a.f11253b) || e(eVar, k.a.f11255c);
    }

    public static boolean C0(b0 b0Var) {
        return b0Var != null && s0(b0Var, k.a.f11263g);
    }

    public static boolean D0(t0 t0Var, la.c cVar) {
        if (t0Var == null) {
            a(100);
        }
        if (cVar == null) {
            a(101);
        }
        n9.h A = t0Var.A();
        return (A instanceof n9.e) && e(A, cVar);
    }

    public static boolean E0(b0 b0Var) {
        if (b0Var == null) {
            a(127);
        }
        return i0(b0Var, k.a.f11268i0.j());
    }

    public static boolean F0(b0 b0Var) {
        if (b0Var == null) {
            a(129);
        }
        return i0(b0Var, k.a.f11272k0.j());
    }

    public static boolean G0(b0 b0Var) {
        if (b0Var == null) {
            a(130);
        }
        return i0(b0Var, k.a.f11274l0.j());
    }

    public static boolean H0(b0 b0Var) {
        if (b0Var == null) {
            a(128);
        }
        return i0(b0Var, k.a.f11270j0.j());
    }

    public static boolean I0(n9.m mVar) {
        if (mVar == null) {
            a(9);
        }
        while (mVar != null) {
            if (mVar instanceof g0) {
                return ((g0) mVar).f().i(k.f11245k);
            }
            mVar = mVar.d();
        }
        return false;
    }

    public static boolean J0(b0 b0Var) {
        if (b0Var == null) {
            a(141);
        }
        return s0(b0Var, k.a.f11259e);
    }

    public static boolean K0(b0 b0Var) {
        if (b0Var == null) {
            a(131);
        }
        return E0(b0Var) || H0(b0Var) || F0(b0Var) || G0(b0Var);
    }

    public static i O(n9.m mVar) {
        if (mVar == null) {
            a(76);
        }
        if (k.a.f11278n0.contains(mVar.c())) {
            return k.a.f11282p0.get(na.d.m(mVar));
        }
        return null;
    }

    private n9.e P(i iVar) {
        if (iVar == null) {
            a(15);
        }
        return p(iVar.getTypeName().k());
    }

    public static i R(n9.m mVar) {
        if (mVar == null) {
            a(75);
        }
        if (k.a.f11276m0.contains(mVar.c())) {
            return k.a.f11280o0.get(na.d.m(mVar));
        }
        return null;
    }

    public static boolean Z(n9.e eVar) {
        if (eVar == null) {
            a(107);
        }
        return e(eVar, k.a.f11253b);
    }

    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
            case 37:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
            case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
            case 37:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
            case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                i11 = 2;
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 71:
                objArr[0] = "module";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
            case 37:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
            case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 8:
            case 9:
            case 75:
            case 76:
            case 88:
            case 95:
            case 102:
            case 106:
            case 107:
            case 144:
            case 145:
            case 147:
            case 155:
            case 156:
            case 157:
                objArr[0] = "descriptor";
                break;
            case 11:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 134:
                objArr[0] = "fqName";
                break;
            case 13:
                objArr[0] = "simpleName";
                break;
            case 15:
            case 16:
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
            case 87:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 98:
            case 104:
            case 108:
            case 109:
            case androidx.constraintlayout.widget.j.f2016l2 /* 110 */:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case e.j.H0 /* 124 */:
            case e.j.I0 /* 125 */:
            case e.j.J0 /* 126 */:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 146:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 159:
                objArr[0] = "type";
                break;
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
                objArr[0] = "classSimpleName";
                break;
            case 66:
                objArr[0] = "arrayType";
                break;
            case 70:
                objArr[0] = "notNullArrayType";
                break;
            case 72:
                objArr[0] = "primitiveType";
                break;
            case 74:
                objArr[0] = "kotlinType";
                break;
            case 77:
            case 81:
                objArr[0] = "projectionType";
                break;
            case 78:
            case 82:
            case 84:
                objArr[0] = "argument";
                break;
            case 79:
                objArr[0] = "annotations";
                break;
            case 100:
                objArr[0] = "typeConstructor";
                break;
            case 111:
                objArr[0] = "classDescriptor";
                break;
            case 158:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i10) {
            case 2:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 5:
                objArr[1] = "getStorageManager";
                break;
            case 6:
                objArr[1] = "getBuiltInsModule";
                break;
            case 7:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 10:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 12:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 17:
                objArr[1] = "getSuspendFunction";
                break;
            case 18:
                objArr[1] = "getKFunction";
                break;
            case 19:
                objArr[1] = "getKSuspendFunction";
                break;
            case 20:
                objArr[1] = "getKClass";
                break;
            case 21:
                objArr[1] = "getKCallable";
                break;
            case 22:
                objArr[1] = "getKProperty";
                break;
            case 23:
                objArr[1] = "getKProperty0";
                break;
            case 24:
                objArr[1] = "getKProperty1";
                break;
            case 25:
                objArr[1] = "getKProperty2";
                break;
            case 26:
                objArr[1] = "getKMutableProperty0";
                break;
            case 27:
                objArr[1] = "getKMutableProperty1";
                break;
            case 28:
                objArr[1] = "getKMutableProperty2";
                break;
            case 29:
                objArr[1] = "getIterator";
                break;
            case 30:
                objArr[1] = "getIterable";
                break;
            case 31:
                objArr[1] = "getMutableIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterator";
                break;
            case 33:
                objArr[1] = "getCollection";
                break;
            case 34:
                objArr[1] = "getMutableCollection";
                break;
            case 35:
                objArr[1] = "getList";
                break;
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                objArr[1] = "getMutableList";
                break;
            case 37:
                objArr[1] = "getSet";
                break;
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
                objArr[1] = "getMutableSet";
                break;
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
                objArr[1] = "getMap";
                break;
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
                objArr[1] = "getMutableMap";
                break;
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
                objArr[1] = "getMapEntry";
                break;
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
                objArr[1] = "getMutableMapEntry";
                break;
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
                objArr[1] = "getListIterator";
                break;
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
                objArr[1] = "getMutableListIterator";
                break;
            case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
                objArr[1] = "getNothingType";
                break;
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
                objArr[1] = "getNullableNothingType";
                break;
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
                objArr[1] = "getAnyType";
                break;
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
                objArr[1] = "getNullableAnyType";
                break;
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
                objArr[1] = "getDefaultBound";
                break;
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 54:
                objArr[1] = "getNumberType";
                break;
            case 55:
                objArr[1] = "getByteType";
                break;
            case 56:
                objArr[1] = "getShortType";
                break;
            case 57:
                objArr[1] = "getIntType";
                break;
            case 58:
                objArr[1] = "getLongType";
                break;
            case 59:
                objArr[1] = "getFloatType";
                break;
            case 60:
                objArr[1] = "getDoubleType";
                break;
            case 61:
                objArr[1] = "getCharType";
                break;
            case 62:
                objArr[1] = "getBooleanType";
                break;
            case 63:
                objArr[1] = "getUnitType";
                break;
            case 64:
                objArr[1] = "getStringType";
                break;
            case 65:
                objArr[1] = "getIterableType";
                break;
            case 67:
            case 68:
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case 73:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 80:
            case 83:
                objArr[1] = "getArrayType";
                break;
            case 85:
                objArr[1] = "getEnumType";
                break;
            case 86:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
            case 37:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
            case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                break;
            case 8:
                objArr[2] = "isBuiltIn";
                break;
            case 9:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 11:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 13:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 15:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 16:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 66:
                objArr[2] = "getArrayElementType";
                break;
            case 70:
            case 71:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 72:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 75:
            case 92:
                objArr[2] = "getPrimitiveType";
                break;
            case 76:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
                objArr[2] = "getArrayType";
                break;
            case 84:
                objArr[2] = "getEnumType";
                break;
            case 87:
                objArr[2] = "isArray";
                break;
            case 88:
            case 89:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 90:
                objArr[2] = "isPrimitiveArray";
                break;
            case 91:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 93:
                objArr[2] = "isPrimitiveType";
                break;
            case 94:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveClass";
                break;
            case 96:
            case 97:
            case 98:
            case 99:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 100:
            case 101:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 102:
            case 103:
                objArr[2] = "classFqNameEquals";
                break;
            case 104:
            case 105:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 106:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 107:
            case 108:
                objArr[2] = "isAny";
                break;
            case 109:
            case 111:
                objArr[2] = "isBoolean";
                break;
            case androidx.constraintlayout.widget.j.f2016l2 /* 110 */:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 112:
                objArr[2] = "isNumber";
                break;
            case 113:
                objArr[2] = "isChar";
                break;
            case 114:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 115:
                objArr[2] = "isInt";
                break;
            case 116:
                objArr[2] = "isByte";
                break;
            case 117:
                objArr[2] = "isLong";
                break;
            case 118:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 119:
                objArr[2] = "isShort";
                break;
            case 120:
                objArr[2] = "isFloat";
                break;
            case 121:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 122:
                objArr[2] = "isDouble";
                break;
            case 123:
                objArr[2] = "isUByte";
                break;
            case e.j.H0 /* 124 */:
                objArr[2] = "isUShort";
                break;
            case e.j.I0 /* 125 */:
                objArr[2] = "isUInt";
                break;
            case e.j.J0 /* 126 */:
                objArr[2] = "isULong";
                break;
            case 127:
                objArr[2] = "isUByteArray";
                break;
            case 128:
                objArr[2] = "isUShortArray";
                break;
            case 129:
                objArr[2] = "isUIntArray";
                break;
            case 130:
                objArr[2] = "isULongArray";
                break;
            case 131:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 132:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 133:
            case 134:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 135:
                objArr[2] = "isNothing";
                break;
            case 136:
                objArr[2] = "isNullableNothing";
                break;
            case 137:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 138:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 139:
                objArr[2] = "isNullableAny";
                break;
            case 140:
                objArr[2] = "isDefaultBound";
                break;
            case 141:
                objArr[2] = "isUnit";
                break;
            case 142:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 143:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 144:
                objArr[2] = "isMemberOfAny";
                break;
            case 145:
            case 146:
                objArr[2] = "isEnum";
                break;
            case 147:
            case 148:
                objArr[2] = "isComparable";
                break;
            case 149:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 150:
                objArr[2] = "isListOrNullableList";
                break;
            case 151:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 152:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 153:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 154:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 155:
                objArr[2] = "isKClass";
                break;
            case 156:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 157:
                objArr[2] = "isCloneable";
                break;
            case 158:
                objArr[2] = "isDeprecated";
                break;
            case 159:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
            case 37:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
            case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                throw new IllegalStateException(format);
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean a0(b0 b0Var) {
        if (b0Var == null) {
            a(138);
        }
        return h0(b0Var, k.a.f11253b);
    }

    public static boolean b0(b0 b0Var) {
        if (b0Var == null) {
            a(87);
        }
        return h0(b0Var, k.a.f11265h);
    }

    public static boolean c0(n9.e eVar) {
        if (eVar == null) {
            a(88);
        }
        return e(eVar, k.a.f11265h) || O(eVar) != null;
    }

    public static boolean d0(b0 b0Var) {
        if (b0Var == null) {
            a(109);
        }
        return i0(b0Var, k.a.f11267i);
    }

    private static boolean e(n9.h hVar, la.c cVar) {
        if (hVar == null) {
            a(102);
        }
        if (cVar == null) {
            a(103);
        }
        return hVar.c().equals(cVar.i()) && cVar.equals(na.d.m(hVar));
    }

    public static boolean e0(n9.m mVar) {
        if (mVar == null) {
            a(8);
        }
        return na.d.r(mVar, k9.b.class, false) != null;
    }

    public static boolean f0(b0 b0Var) {
        if (b0Var == null) {
            a(116);
        }
        return i0(b0Var, k.a.f11271k);
    }

    public static boolean g0(b0 b0Var) {
        if (b0Var == null) {
            a(113);
        }
        return i0(b0Var, k.a.f11269j);
    }

    private static boolean h0(b0 b0Var, la.c cVar) {
        if (b0Var == null) {
            a(96);
        }
        if (cVar == null) {
            a(97);
        }
        return D0(b0Var.W0(), cVar);
    }

    private static boolean i0(b0 b0Var, la.c cVar) {
        if (b0Var == null) {
            a(133);
        }
        if (cVar == null) {
            a(134);
        }
        return h0(b0Var, cVar) && !b0Var.X0();
    }

    public static boolean j0(b0 b0Var) {
        if (b0Var == null) {
            a(140);
        }
        return v0(b0Var);
    }

    public static boolean k0(n9.m mVar) {
        if (mVar == null) {
            a(158);
        }
        if (mVar.a().u().r(k.a.f11287u)) {
            return true;
        }
        if (!(mVar instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) mVar;
        boolean P = p0Var.P();
        q0 t10 = p0Var.t();
        r0 M0 = p0Var.M0();
        if (t10 != null && k0(t10)) {
            if (!P) {
                return true;
            }
            if (M0 != null && k0(M0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean l0(b0 b0Var) {
        if (b0Var == null) {
            a(122);
        }
        return m0(b0Var) && !b0Var.X0();
    }

    public static boolean m0(b0 b0Var) {
        if (b0Var == null) {
            a(132);
        }
        return h0(b0Var, k.a.f11281p);
    }

    public static boolean n0(b0 b0Var) {
        if (b0Var == null) {
            a(120);
        }
        return o0(b0Var) && !b0Var.X0();
    }

    public static boolean o0(b0 b0Var) {
        if (b0Var == null) {
            a(121);
        }
        return h0(b0Var, k.a.f11279o);
    }

    private n9.e p(String str) {
        if (str == null) {
            a(13);
        }
        n9.e h10 = this.f11216c.h(la.e.r(str));
        if (h10 == null) {
            a(14);
        }
        return h10;
    }

    public static boolean p0(b0 b0Var) {
        if (b0Var == null) {
            a(115);
        }
        return i0(b0Var, k.a.f11275m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i0 q(String str) {
        if (str == null) {
            a(45);
        }
        i0 s10 = p(str).s();
        if (s10 == null) {
            a(46);
        }
        return s10;
    }

    public static boolean q0(n9.e eVar) {
        if (eVar == null) {
            a(155);
        }
        return e(eVar, k.a.X);
    }

    public static boolean r0(b0 b0Var) {
        if (b0Var == null) {
            a(117);
        }
        return i0(b0Var, k.a.f11277n);
    }

    private static boolean s0(b0 b0Var, la.c cVar) {
        if (b0Var == null) {
            a(104);
        }
        if (cVar == null) {
            a(105);
        }
        return !b0Var.X0() && h0(b0Var, cVar);
    }

    public static boolean t0(b0 b0Var) {
        if (b0Var == null) {
            a(135);
        }
        return u0(b0Var) && !c1.l(b0Var);
    }

    public static boolean u0(b0 b0Var) {
        if (b0Var == null) {
            a(137);
        }
        return h0(b0Var, k.a.f11255c);
    }

    public static boolean v0(b0 b0Var) {
        if (b0Var == null) {
            a(139);
        }
        return a0(b0Var) && b0Var.X0();
    }

    public static boolean w0(b0 b0Var) {
        if (b0Var == null) {
            a(90);
        }
        n9.h A = b0Var.W0().A();
        return (A == null || O(A) == null) ? false : true;
    }

    public static boolean x0(n9.e eVar) {
        if (eVar == null) {
            a(95);
        }
        return R(eVar) != null;
    }

    public static boolean y0(b0 b0Var) {
        if (b0Var == null) {
            a(93);
        }
        return !b0Var.X0() && z0(b0Var);
    }

    public static boolean z0(b0 b0Var) {
        if (b0Var == null) {
            a(94);
        }
        n9.h A = b0Var.W0().A();
        return (A instanceof n9.e) && x0((n9.e) A);
    }

    public i0 B() {
        i0 Q = Q(i.FLOAT);
        if (Q == null) {
            a(59);
        }
        return Q;
    }

    public n9.e C(int i10) {
        return p(k.b(i10));
    }

    public i0 D() {
        i0 Q = Q(i.INT);
        if (Q == null) {
            a(57);
        }
        return Q;
    }

    public n9.e E() {
        n9.e o10 = o(k.a.X.l());
        if (o10 == null) {
            a(20);
        }
        return o10;
    }

    public i0 F() {
        i0 Q = Q(i.LONG);
        if (Q == null) {
            a(58);
        }
        return Q;
    }

    public n9.e G() {
        return p("Nothing");
    }

    public i0 H() {
        i0 s10 = G().s();
        if (s10 == null) {
            a(47);
        }
        return s10;
    }

    public i0 I() {
        i0 a12 = i().a1(true);
        if (a12 == null) {
            a(50);
        }
        return a12;
    }

    public i0 J() {
        i0 a12 = H().a1(true);
        if (a12 == null) {
            a(48);
        }
        return a12;
    }

    public n9.e K() {
        return p("Number");
    }

    public i0 L() {
        i0 s10 = K().s();
        if (s10 == null) {
            a(54);
        }
        return s10;
    }

    public void L0(x xVar) {
        if (xVar == null) {
            a(1);
        }
        this.f11217d.d(new d(xVar));
    }

    protected o9.c M() {
        c.b bVar = c.b.f12631a;
        if (bVar == null) {
            a(3);
        }
        return bVar;
    }

    public i0 N(i iVar) {
        if (iVar == null) {
            a(72);
        }
        i0 i0Var = this.f11215b.b().f11223a.get(iVar);
        if (i0Var == null) {
            a(73);
        }
        return i0Var;
    }

    public i0 Q(i iVar) {
        if (iVar == null) {
            a(52);
        }
        i0 s10 = P(iVar).s();
        if (s10 == null) {
            a(53);
        }
        return s10;
    }

    public i0 S() {
        i0 Q = Q(i.SHORT);
        if (Q == null) {
            a(56);
        }
        return Q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ab.n T() {
        ab.n nVar = this.f11217d;
        if (nVar == null) {
            a(5);
        }
        return nVar;
    }

    public n9.e U() {
        return p("String");
    }

    public i0 V() {
        i0 s10 = U().s();
        if (s10 == null) {
            a(64);
        }
        return s10;
    }

    public n9.e W(int i10) {
        n9.e o10 = o(k.f11238d.c(la.e.r(k.d(i10))));
        if (o10 == null) {
            a(17);
        }
        return o10;
    }

    public n9.e X() {
        return p("Unit");
    }

    public i0 Y() {
        i0 s10 = X().s();
        if (s10 == null) {
            a(63);
        }
        return s10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(boolean z10) {
        x xVar = new x(f11213e, this.f11217d, this, null);
        this.f11214a = xVar;
        xVar.c1(k9.a.f11205a.a().a(this.f11217d, this.f11214a, v(), M(), g(), z10));
        x xVar2 = this.f11214a;
        xVar2.i1(xVar2);
    }

    protected o9.a g() {
        a.C0266a c0266a = a.C0266a.f12629a;
        if (c0266a == null) {
            a(2);
        }
        return c0266a;
    }

    public n9.e h() {
        return p("Any");
    }

    public i0 i() {
        i0 s10 = h().s();
        if (s10 == null) {
            a(49);
        }
        return s10;
    }

    public n9.e j() {
        return p("Array");
    }

    public b0 k(b0 b0Var) {
        b0 A;
        if (b0Var == null) {
            a(66);
        }
        if (b0(b0Var)) {
            if (b0Var.V0().size() != 1) {
                throw new IllegalStateException();
            }
            b0 b10 = b0Var.V0().get(0).b();
            if (b10 == null) {
                a(67);
            }
            return b10;
        }
        b0 n10 = c1.n(b0Var);
        i0 i0Var = this.f11215b.b().f11225c.get(n10);
        if (i0Var != null) {
            return i0Var;
        }
        d0 h10 = na.d.h(n10);
        if (h10 != null && (A = A(n10, h10)) != null) {
            return A;
        }
        throw new IllegalStateException("not array: " + b0Var);
    }

    public i0 l(h1 h1Var, b0 b0Var) {
        if (h1Var == null) {
            a(81);
        }
        if (b0Var == null) {
            a(82);
        }
        i0 m10 = m(h1Var, b0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b());
        if (m10 == null) {
            a(83);
        }
        return m10;
    }

    public i0 m(h1 h1Var, b0 b0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (h1Var == null) {
            a(77);
        }
        if (b0Var == null) {
            a(78);
        }
        if (gVar == null) {
            a(79);
        }
        i0 g10 = c0.g(gVar, j(), Collections.singletonList(new x0(h1Var, b0Var)));
        if (g10 == null) {
            a(80);
        }
        return g10;
    }

    public i0 n() {
        i0 Q = Q(i.BOOLEAN);
        if (Q == null) {
            a(62);
        }
        return Q;
    }

    public n9.e o(la.b bVar) {
        if (bVar == null) {
            a(11);
        }
        n9.e a10 = s.a(this.f11214a, bVar, u9.d.FROM_BUILTINS);
        if (a10 == null) {
            a(12);
        }
        return a10;
    }

    public x r() {
        x xVar = this.f11214a;
        if (xVar == null) {
            a(6);
        }
        return xVar;
    }

    public ua.h s() {
        ua.h A = this.f11214a.C(k.f11246l).A();
        if (A == null) {
            a(10);
        }
        return A;
    }

    public i0 t() {
        i0 Q = Q(i.BYTE);
        if (Q == null) {
            a(55);
        }
        return Q;
    }

    public i0 u() {
        i0 Q = Q(i.CHAR);
        if (Q == null) {
            a(61);
        }
        return Q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Iterable<o9.b> v() {
        List singletonList = Collections.singletonList(new l9.a(this.f11217d, this.f11214a));
        if (singletonList == null) {
            a(4);
        }
        return singletonList;
    }

    public n9.e w() {
        n9.e o10 = o(k.a.J);
        if (o10 == null) {
            a(33);
        }
        return o10;
    }

    public n9.e x() {
        return p("Comparable");
    }

    public i0 y() {
        i0 I = I();
        if (I == null) {
            a(51);
        }
        return I;
    }

    public i0 z() {
        i0 Q = Q(i.DOUBLE);
        if (Q == null) {
            a(60);
        }
        return Q;
    }
}
