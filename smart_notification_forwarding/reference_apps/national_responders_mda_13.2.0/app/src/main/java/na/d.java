package na;

import bb.b0;
import bb.c1;
import bb.d0;
import bb.t0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import n9.a0;
import n9.b;
import n9.e1;
import n9.g0;
import n9.l0;
import n9.p;
import n9.q;
import n9.r0;
import n9.s0;
import n9.t;
import n9.u;
import n9.w0;

/* loaded from: classes.dex */
public class d {
    static {
        new la.b("kotlin.jvm.JvmName");
    }

    public static boolean A(n9.m mVar) {
        return D(mVar, n9.f.ENUM_CLASS);
    }

    public static boolean B(n9.m mVar) {
        if (mVar == null) {
            a(34);
        }
        return D(mVar, n9.f.ENUM_ENTRY);
    }

    public static boolean C(n9.m mVar) {
        return D(mVar, n9.f.INTERFACE);
    }

    private static boolean D(n9.m mVar, n9.f fVar) {
        if (fVar == null) {
            a(35);
        }
        return (mVar instanceof n9.e) && ((n9.e) mVar).r() == fVar;
    }

    public static boolean E(n9.m mVar) {
        if (mVar == null) {
            a(1);
        }
        while (mVar != null) {
            if (u(mVar) || y(mVar)) {
                return true;
            }
            mVar = mVar.d();
        }
        return false;
    }

    private static boolean F(b0 b0Var, n9.m mVar) {
        if (b0Var == null) {
            a(28);
        }
        if (mVar == null) {
            a(29);
        }
        n9.h A = b0Var.W0().A();
        if (A == null) {
            return false;
        }
        n9.m a10 = A.a();
        return (a10 instanceof n9.h) && (mVar instanceof n9.h) && ((n9.h) mVar).o().equals(((n9.h) a10).o());
    }

    public static boolean G(n9.m mVar) {
        return (D(mVar, n9.f.CLASS) || D(mVar, n9.f.INTERFACE)) && ((n9.e) mVar).p() == a0.SEALED;
    }

    public static boolean H(n9.e eVar, n9.e eVar2) {
        if (eVar == null) {
            a(26);
        }
        if (eVar2 == null) {
            a(27);
        }
        return I(eVar.s(), eVar2.a());
    }

    public static boolean I(b0 b0Var, n9.m mVar) {
        if (b0Var == null) {
            a(30);
        }
        if (mVar == null) {
            a(31);
        }
        if (F(b0Var, mVar)) {
            return true;
        }
        Iterator<b0> it = b0Var.W0().x().iterator();
        while (it.hasNext()) {
            if (I(it.next(), mVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(n9.m mVar) {
        return mVar != null && (mVar.d() instanceof g0);
    }

    public static boolean K(e1 e1Var, b0 b0Var) {
        if (e1Var == null) {
            a(61);
        }
        if (b0Var == null) {
            a(62);
        }
        if (e1Var.P() || d0.a(b0Var)) {
            return false;
        }
        if (c1.b(b0Var)) {
            return true;
        }
        k9.h g10 = ra.a.g(e1Var);
        if (!k9.h.y0(b0Var)) {
            kotlin.reflect.jvm.internal.impl.types.checker.f fVar = kotlin.reflect.jvm.internal.impl.types.checker.f.f11565a;
            if (!fVar.c(g10.V(), b0Var) && !fVar.c(g10.K().s(), b0Var) && !fVar.c(g10.i(), b0Var)) {
                k9.o oVar = k9.o.f11295a;
                if (!k9.o.d(b0Var)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <D extends n9.b> D L(D d10) {
        if (d10 == null) {
            a(57);
        }
        while (d10.r() == b.a.FAKE_OVERRIDE) {
            Collection<? extends n9.b> g10 = d10.g();
            if (g10.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d10);
            }
            d10 = (D) g10.iterator().next();
        }
        return d10;
    }

    public static <D extends q> D M(D d10) {
        if (d10 == null) {
            a(59);
        }
        if (d10 instanceof n9.b) {
            return L((n9.b) d10);
        }
        if (d10 == null) {
            a(60);
        }
        return d10;
    }

    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 21:
            case 22:
            case 32:
            case 33:
            case 34:
            case 55:
            case 56:
            case 57:
            case 59:
            case 77:
            case 90:
            case 92:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 14:
                objArr[0] = "first";
                break;
            case 15:
                objArr[0] = "second";
                break;
            case 16:
            case 17:
                objArr[0] = "aClass";
                break;
            case 18:
                objArr[0] = "kotlinType";
                break;
            case 23:
                objArr[0] = "declarationDescriptor";
                break;
            case 24:
            case 26:
                objArr[0] = "subClass";
                break;
            case 25:
            case 27:
            case 31:
                objArr[0] = "superClass";
                break;
            case 28:
            case 30:
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
            case 62:
                objArr[0] = "type";
                break;
            case 29:
                objArr[0] = "other";
                break;
            case 35:
                objArr[0] = "classKind";
                break;
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
            case 37:
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
            case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
            case 63:
            case 64:
            case 65:
            case 72:
            case 73:
                objArr[0] = "classDescriptor";
                break;
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
                objArr[0] = "typeConstructor";
                break;
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
                objArr[0] = "innerClassName";
                break;
            case 54:
                objArr[0] = "location";
                break;
            case 61:
                objArr[0] = "variable";
                break;
            case 66:
                objArr[0] = "f";
                break;
            case 68:
                objArr[0] = "current";
                break;
            case 69:
                objArr[0] = "result";
                break;
            case 70:
                objArr[0] = "memberDescriptor";
                break;
            case 74:
            case 75:
            case 76:
                objArr[0] = "annotated";
                break;
            case 80:
            case 82:
            case 85:
            case 87:
                objArr[0] = "scope";
                break;
            case 83:
            case 86:
            case 88:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 20:
                objArr[1] = "getContainingModule";
                break;
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
                objArr[1] = "getSuperClassType";
                break;
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 58:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 67:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 71:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 78:
            case 79:
                objArr[1] = "getContainingSourceFile";
                break;
            case 81:
                objArr[1] = "getAllDescriptors";
                break;
            case 84:
                objArr[1] = "getFunctionByName";
                break;
            case 89:
                objArr[1] = "getPropertyByName";
                break;
            case 91:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "isExtension";
                break;
            case 12:
                objArr[2] = "isOverride";
                break;
            case 13:
                objArr[2] = "isStaticDeclaration";
                break;
            case 14:
            case 15:
                objArr[2] = "areInSameModule";
                break;
            case 16:
            case 17:
                objArr[2] = "getParentOfType";
                break;
            case 18:
            case 21:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 19:
                objArr[2] = "getContainingModule";
                break;
            case 22:
                objArr[2] = "getContainingClass";
                break;
            case 23:
                objArr[2] = "isAncestor";
                break;
            case 24:
            case 25:
                objArr[2] = "isDirectSubclass";
                break;
            case 26:
            case 27:
                objArr[2] = "isSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSameClass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 32:
                objArr[2] = "isAnonymousObject";
                break;
            case 33:
                objArr[2] = "isAnonymousFunction";
                break;
            case 34:
                objArr[2] = "isEnumEntry";
                break;
            case 35:
                objArr[2] = "isKindOf";
                break;
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                objArr[2] = "hasAbstractMembers";
                break;
            case 37:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
                objArr[2] = "getSuperClassType";
                break;
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
                objArr[2] = "getClassDescriptorForType";
                break;
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case androidx.constraintlayout.widget.j.f1963e5 /* 46 */:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case androidx.constraintlayout.widget.j.f2011k5 /* 52 */:
            case androidx.constraintlayout.widget.j.f2019l5 /* 53 */:
            case 54:
                objArr[2] = "getInnerClassByName";
                break;
            case 55:
                objArr[2] = "isStaticNestedClass";
                break;
            case 56:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 57:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 61:
            case 62:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 63:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 64:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 65:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 66:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 68:
            case 69:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 70:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 72:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 73:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 74:
                objArr[2] = "getJvmName";
                break;
            case 75:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 76:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 77:
                objArr[2] = "getContainingSourceFile";
                break;
            case 80:
                objArr[2] = "getAllDescriptors";
                break;
            case 82:
            case 83:
                objArr[2] = "getFunctionByName";
                break;
            case 85:
            case 86:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 87:
            case 88:
                objArr[2] = "getPropertyByName";
                break;
            case 90:
                objArr[2] = "getDirectMember";
                break;
            case 92:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
            case androidx.constraintlayout.widget.j.f1971f5 /* 47 */:
            case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
            case androidx.constraintlayout.widget.j.f1987h5 /* 49 */:
            case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
            case androidx.constraintlayout.widget.j.f2003j5 /* 51 */:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean b(n9.m mVar, n9.m mVar2) {
        if (mVar == null) {
            a(14);
        }
        if (mVar2 == null) {
            a(15);
        }
        return g(mVar).equals(g(mVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends n9.a> void c(D d10, Set<D> set) {
        if (d10 == null) {
            a(68);
        }
        if (set == 0) {
            a(69);
        }
        if (set.contains(d10)) {
            return;
        }
        Iterator<? extends n9.a> it = d10.a().g().iterator();
        while (it.hasNext()) {
            n9.a a10 = it.next().a();
            c(a10, set);
            set.add(a10);
        }
    }

    public static <D extends n9.a> Set<D> d(D d10) {
        if (d10 == null) {
            a(66);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d10.a(), linkedHashSet);
        return linkedHashSet;
    }

    public static n9.e e(b0 b0Var) {
        if (b0Var == null) {
            a(43);
        }
        return f(b0Var.W0());
    }

    public static n9.e f(t0 t0Var) {
        if (t0Var == null) {
            a(44);
        }
        n9.e eVar = (n9.e) t0Var.A();
        if (eVar == null) {
            a(45);
        }
        return eVar;
    }

    public static n9.d0 g(n9.m mVar) {
        if (mVar == null) {
            a(19);
        }
        n9.d0 i10 = i(mVar);
        if (i10 == null) {
            a(20);
        }
        return i10;
    }

    public static n9.d0 h(b0 b0Var) {
        if (b0Var == null) {
            a(18);
        }
        n9.h A = b0Var.W0().A();
        if (A == null) {
            return null;
        }
        return i(A);
    }

    public static n9.d0 i(n9.m mVar) {
        if (mVar == null) {
            a(21);
        }
        while (mVar != null) {
            if (mVar instanceof n9.d0) {
                return (n9.d0) mVar;
            }
            if (mVar instanceof l0) {
                return ((l0) mVar).n0();
            }
            mVar = mVar.d();
        }
        return null;
    }

    public static w0 j(n9.m mVar) {
        if (mVar == null) {
            a(77);
        }
        if (mVar instanceof r0) {
            mVar = ((r0) mVar).y0();
        }
        if (mVar instanceof p) {
            w0 a10 = ((p) mVar).k().a();
            if (a10 == null) {
                a(78);
            }
            return a10;
        }
        w0 w0Var = w0.f12327a;
        if (w0Var == null) {
            a(79);
        }
        return w0Var;
    }

    public static u k(n9.e eVar, boolean z10) {
        if (eVar == null) {
            a(46);
        }
        n9.f r10 = eVar.r();
        if (r10 == n9.f.ENUM_CLASS || r10.isSingleton()) {
            u uVar = t.f12299a;
            if (uVar == null) {
                a(47);
            }
            return uVar;
        }
        if (G(eVar)) {
            if (z10) {
                u uVar2 = t.f12302d;
                if (uVar2 == null) {
                    a(48);
                }
                return uVar2;
            }
            u uVar3 = t.f12299a;
            if (uVar3 == null) {
                a(49);
            }
            return uVar3;
        }
        if (u(eVar)) {
            u uVar4 = t.f12309k;
            if (uVar4 == null) {
                a(50);
            }
            return uVar4;
        }
        u uVar5 = t.f12303e;
        if (uVar5 == null) {
            a(51);
        }
        return uVar5;
    }

    public static s0 l(n9.m mVar) {
        if (mVar == null) {
            a(0);
        }
        if (mVar instanceof n9.e) {
            return ((n9.e) mVar).T0();
        }
        return null;
    }

    public static la.c m(n9.m mVar) {
        if (mVar == null) {
            a(2);
        }
        la.b o10 = o(mVar);
        return o10 != null ? o10.j() : p(mVar);
    }

    public static la.b n(n9.m mVar) {
        if (mVar == null) {
            a(3);
        }
        la.b o10 = o(mVar);
        if (o10 == null) {
            o10 = p(mVar).l();
        }
        if (o10 == null) {
            a(4);
        }
        return o10;
    }

    private static la.b o(n9.m mVar) {
        if (mVar == null) {
            a(5);
        }
        if ((mVar instanceof n9.d0) || bb.t.r(mVar)) {
            return la.b.f11846c;
        }
        if (mVar instanceof l0) {
            return ((l0) mVar).f();
        }
        if (mVar instanceof g0) {
            return ((g0) mVar).f();
        }
        return null;
    }

    private static la.c p(n9.m mVar) {
        if (mVar == null) {
            a(6);
        }
        la.c c10 = m(mVar.d()).c(mVar.c());
        if (c10 == null) {
            a(7);
        }
        return c10;
    }

    public static <D extends n9.m> D q(n9.m mVar, Class<D> cls) {
        if (cls == null) {
            a(16);
        }
        return (D) r(mVar, cls, true);
    }

    public static <D extends n9.m> D r(n9.m mVar, Class<D> cls, boolean z10) {
        if (cls == null) {
            a(17);
        }
        if (mVar == null) {
            return null;
        }
        if (z10) {
            mVar = (D) mVar.d();
        }
        while (mVar != null) {
            if (cls.isInstance(mVar)) {
                return (D) mVar;
            }
            mVar = (D) mVar.d();
        }
        return null;
    }

    public static n9.e s(n9.e eVar) {
        if (eVar == null) {
            a(42);
        }
        Iterator<b0> it = eVar.o().x().iterator();
        while (it.hasNext()) {
            n9.e e10 = e(it.next());
            if (e10.r() != n9.f.INTERFACE) {
                return e10;
            }
        }
        return null;
    }

    public static boolean t(n9.m mVar) {
        return D(mVar, n9.f.ANNOTATION_CLASS);
    }

    public static boolean u(n9.m mVar) {
        if (mVar == null) {
            a(32);
        }
        return v(mVar) && mVar.c().equals(la.g.f11860a);
    }

    public static boolean v(n9.m mVar) {
        return D(mVar, n9.f.CLASS);
    }

    public static boolean w(n9.m mVar) {
        return v(mVar) || A(mVar);
    }

    public static boolean x(n9.m mVar) {
        return D(mVar, n9.f.OBJECT) && ((n9.e) mVar).N();
    }

    public static boolean y(n9.m mVar) {
        return (mVar instanceof q) && ((q) mVar).h() == t.f12304f;
    }

    public static boolean z(n9.e eVar, n9.e eVar2) {
        if (eVar == null) {
            a(24);
        }
        if (eVar2 == null) {
            a(25);
        }
        Iterator<b0> it = eVar.o().x().iterator();
        while (it.hasNext()) {
            if (F(it.next(), eVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
