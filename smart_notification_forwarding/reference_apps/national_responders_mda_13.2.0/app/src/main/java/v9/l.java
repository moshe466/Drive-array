package v9;

import n9.b;
import n9.p0;

/* loaded from: classes.dex */
public final class l {
    private static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "companionObject";
        } else if (i10 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i10 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i10 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i10 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(n9.b bVar) {
        n9.v d02;
        if (bVar == null) {
            a(3);
        }
        if ((bVar instanceof p0) && (d02 = ((p0) bVar).d0()) != null && d02.u().r(x.f14812b)) {
            return true;
        }
        return bVar.u().r(x.f14812b);
    }

    public static boolean c(n9.m mVar) {
        if (mVar == null) {
            a(1);
        }
        return na.d.x(mVar) && na.d.w(mVar.d()) && !d((n9.e) mVar);
    }

    public static boolean d(n9.e eVar) {
        if (eVar == null) {
            a(2);
        }
        return k9.d.a(k9.c.f11209a, eVar);
    }

    public static boolean e(p0 p0Var) {
        if (p0Var == null) {
            a(0);
        }
        if (p0Var.r() == b.a.FAKE_OVERRIDE) {
            return false;
        }
        if (c(p0Var.d())) {
            return true;
        }
        return na.d.x(p0Var.d()) && b(p0Var);
    }
}
