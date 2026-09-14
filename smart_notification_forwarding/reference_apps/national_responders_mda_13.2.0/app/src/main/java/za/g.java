package za;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import n9.z;

/* loaded from: classes.dex */
public interface g extends n9.m, z {

    /* loaded from: classes.dex */
    public enum a {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            a[] aVarArr = new a[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, valuesCustom.length);
            return aVarArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static List<ia.h> a(g gVar) {
            y8.k.e(gVar, "this");
            return ia.h.f10828f.b(gVar.Y(), gVar.O0(), gVar.L0());
        }
    }

    f F();

    ia.i L0();

    ia.c O0();

    List<ia.h> S0();

    q Y();

    ia.g z0();
}
