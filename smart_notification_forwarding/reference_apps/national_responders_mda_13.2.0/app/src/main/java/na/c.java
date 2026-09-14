package na;

import bb.b0;
import bb.h1;
import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import n9.a0;
import n9.b;
import n9.p0;
import n9.s0;
import n9.t;
import n9.u;
import n9.u0;
import n9.v0;
import n9.x;
import p9.c0;
import p9.d0;
import p9.e0;
import p9.f0;
import p9.k0;

/* loaded from: classes.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends p9.f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n9.e eVar, v0 v0Var, boolean z10) {
            super(eVar, null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), true, b.a.DECLARATION, v0Var);
            if (eVar == null) {
                e0(0);
            }
            if (v0Var == null) {
                e0(1);
            }
            A1(Collections.emptyList(), d.k(eVar, z10));
        }

        private static /* synthetic */ void e0(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    private static /* synthetic */ void a(int i10) {
        String str = (i10 == 12 || i10 == 23 || i10 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 12 || i10 == 23 || i10 == 25) ? 2 : 3];
        switch (i10) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        if (i10 == 12) {
            objArr[1] = "createSetter";
        } else if (i10 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i10 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 12 && i10 != 23 && i10 != 25) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static c0 b(p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (p0Var == null) {
            a(13);
        }
        if (gVar == null) {
            a(14);
        }
        return g(p0Var, gVar, true, false, false);
    }

    public static d0 c(p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        if (p0Var == null) {
            a(0);
        }
        if (gVar == null) {
            a(1);
        }
        if (gVar2 == null) {
            a(2);
        }
        return k(p0Var, gVar, gVar2, true, false, false, p0Var.k());
    }

    public static u0 d(n9.e eVar) {
        if (eVar == null) {
            a(24);
        }
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b;
        f0 w12 = f0.w1(eVar, aVar.b(), k9.k.f11237c, b.a.SYNTHESIZED, eVar.k());
        f0 c12 = w12.c1(null, null, Collections.emptyList(), Collections.singletonList(new k0(w12, null, 0, aVar.b(), la.e.r("value"), ra.a.g(eVar).V(), false, false, false, null, eVar.k())), eVar.s(), a0.FINAL, t.f12303e);
        if (c12 == null) {
            a(25);
        }
        return c12;
    }

    public static u0 e(n9.e eVar) {
        if (eVar == null) {
            a(22);
        }
        f0 c12 = f0.w1(eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), k9.k.f11236b, b.a.SYNTHESIZED, eVar.k()).c1(null, null, Collections.emptyList(), Collections.emptyList(), ra.a.g(eVar).l(h1.INVARIANT, eVar.s()), a0.FINAL, t.f12303e);
        if (c12 == null) {
            a(23);
        }
        return c12;
    }

    public static s0 f(n9.a aVar, b0 b0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (aVar == null) {
            a(29);
        }
        if (gVar == null) {
            a(30);
        }
        if (b0Var == null) {
            return null;
        }
        return new e0(aVar, new va.b(aVar, b0Var, null), gVar);
    }

    public static c0 g(p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, boolean z11, boolean z12) {
        if (p0Var == null) {
            a(15);
        }
        if (gVar == null) {
            a(16);
        }
        return h(p0Var, gVar, z10, z11, z12, p0Var.k());
    }

    public static c0 h(p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, boolean z11, boolean z12, v0 v0Var) {
        if (p0Var == null) {
            a(17);
        }
        if (gVar == null) {
            a(18);
        }
        if (v0Var == null) {
            a(19);
        }
        return new c0(p0Var, gVar, p0Var.p(), p0Var.h(), z10, z11, z12, b.a.DECLARATION, null, v0Var);
    }

    public static p9.f i(n9.e eVar, v0 v0Var) {
        if (eVar == null) {
            a(20);
        }
        if (v0Var == null) {
            a(21);
        }
        return new a(eVar, v0Var, false);
    }

    public static d0 j(p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2, boolean z10, boolean z11, boolean z12, u uVar, v0 v0Var) {
        if (p0Var == null) {
            a(7);
        }
        if (gVar == null) {
            a(8);
        }
        if (gVar2 == null) {
            a(9);
        }
        if (uVar == null) {
            a(10);
        }
        if (v0Var == null) {
            a(11);
        }
        d0 d0Var = new d0(p0Var, gVar, p0Var.p(), uVar, z10, z11, z12, b.a.DECLARATION, null, v0Var);
        d0Var.c1(d0.a1(d0Var, p0Var.b(), gVar2));
        return d0Var;
    }

    public static d0 k(p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2, boolean z10, boolean z11, boolean z12, v0 v0Var) {
        if (p0Var == null) {
            a(3);
        }
        if (gVar == null) {
            a(4);
        }
        if (gVar2 == null) {
            a(5);
        }
        if (v0Var == null) {
            a(6);
        }
        return j(p0Var, gVar, gVar2, z10, z11, z12, p0Var.h(), v0Var);
    }

    private static boolean l(x xVar) {
        if (xVar == null) {
            a(28);
        }
        return xVar.r() == b.a.SYNTHESIZED && d.A(xVar.d());
    }

    public static boolean m(x xVar) {
        if (xVar == null) {
            a(27);
        }
        return xVar.c().equals(k9.k.f11237c) && l(xVar);
    }

    public static boolean n(x xVar) {
        if (xVar == null) {
            a(26);
        }
        return xVar.c().equals(k9.k.f11236b) && l(xVar);
    }
}
