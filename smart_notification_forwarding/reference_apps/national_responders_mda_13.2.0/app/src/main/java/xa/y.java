package xa;

import bb.h1;
import ga.c;
import ga.q;
import ga.s;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f15666a = new y();

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15667a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15668b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f15669c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f15670d;

        static {
            int[] iArr = new int[ga.k.values().length];
            iArr[ga.k.FINAL.ordinal()] = 1;
            iArr[ga.k.OPEN.ordinal()] = 2;
            iArr[ga.k.ABSTRACT.ordinal()] = 3;
            iArr[ga.k.SEALED.ordinal()] = 4;
            f15667a = iArr;
            int[] iArr2 = new int[n9.a0.valuesCustom().length];
            iArr2[n9.a0.FINAL.ordinal()] = 1;
            iArr2[n9.a0.OPEN.ordinal()] = 2;
            iArr2[n9.a0.ABSTRACT.ordinal()] = 3;
            iArr2[n9.a0.SEALED.ordinal()] = 4;
            int[] iArr3 = new int[ga.x.values().length];
            iArr3[ga.x.INTERNAL.ordinal()] = 1;
            iArr3[ga.x.PRIVATE.ordinal()] = 2;
            iArr3[ga.x.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ga.x.PROTECTED.ordinal()] = 4;
            iArr3[ga.x.PUBLIC.ordinal()] = 5;
            iArr3[ga.x.LOCAL.ordinal()] = 6;
            int[] iArr4 = new int[c.EnumC0180c.values().length];
            iArr4[c.EnumC0180c.CLASS.ordinal()] = 1;
            iArr4[c.EnumC0180c.INTERFACE.ordinal()] = 2;
            iArr4[c.EnumC0180c.ENUM_CLASS.ordinal()] = 3;
            iArr4[c.EnumC0180c.ENUM_ENTRY.ordinal()] = 4;
            iArr4[c.EnumC0180c.ANNOTATION_CLASS.ordinal()] = 5;
            iArr4[c.EnumC0180c.OBJECT.ordinal()] = 6;
            iArr4[c.EnumC0180c.COMPANION_OBJECT.ordinal()] = 7;
            f15668b = iArr4;
            int[] iArr5 = new int[n9.f.values().length];
            iArr5[n9.f.CLASS.ordinal()] = 1;
            iArr5[n9.f.INTERFACE.ordinal()] = 2;
            iArr5[n9.f.ENUM_CLASS.ordinal()] = 3;
            iArr5[n9.f.ENUM_ENTRY.ordinal()] = 4;
            iArr5[n9.f.ANNOTATION_CLASS.ordinal()] = 5;
            iArr5[n9.f.OBJECT.ordinal()] = 6;
            int[] iArr6 = new int[s.c.values().length];
            iArr6[s.c.IN.ordinal()] = 1;
            iArr6[s.c.OUT.ordinal()] = 2;
            iArr6[s.c.INV.ordinal()] = 3;
            f15669c = iArr6;
            int[] iArr7 = new int[q.b.c.values().length];
            iArr7[q.b.c.IN.ordinal()] = 1;
            iArr7[q.b.c.OUT.ordinal()] = 2;
            iArr7[q.b.c.INV.ordinal()] = 3;
            iArr7[q.b.c.STAR.ordinal()] = 4;
            f15670d = iArr7;
            int[] iArr8 = new int[h1.valuesCustom().length];
            iArr8[h1.IN_VARIANCE.ordinal()] = 1;
            iArr8[h1.OUT_VARIANCE.ordinal()] = 2;
            iArr8[h1.INVARIANT.ordinal()] = 3;
        }
    }

    private y() {
    }

    public final n9.f a(c.EnumC0180c enumC0180c) {
        switch (enumC0180c == null ? -1 : a.f15668b[enumC0180c.ordinal()]) {
            case 1:
            default:
                return n9.f.CLASS;
            case 2:
                return n9.f.INTERFACE;
            case 3:
                return n9.f.ENUM_CLASS;
            case 4:
                return n9.f.ENUM_ENTRY;
            case 5:
                return n9.f.ANNOTATION_CLASS;
            case 6:
            case 7:
                return n9.f.OBJECT;
        }
    }

    public final n9.a0 b(ga.k kVar) {
        int i10 = kVar == null ? -1 : a.f15667a[kVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return n9.a0.OPEN;
            }
            if (i10 == 3) {
                return n9.a0.ABSTRACT;
            }
            if (i10 == 4) {
                return n9.a0.SEALED;
            }
        }
        return n9.a0.FINAL;
    }

    public final h1 c(q.b.c cVar) {
        y8.k.e(cVar, "projection");
        int i10 = a.f15670d[cVar.ordinal()];
        if (i10 == 1) {
            return h1.IN_VARIANCE;
        }
        if (i10 == 2) {
            return h1.OUT_VARIANCE;
        }
        if (i10 == 3) {
            return h1.INVARIANT;
        }
        if (i10 != 4) {
            throw new l8.l();
        }
        throw new IllegalArgumentException(y8.k.j("Only IN, OUT and INV are supported. Actual argument: ", cVar));
    }

    public final h1 d(s.c cVar) {
        y8.k.e(cVar, "variance");
        int i10 = a.f15669c[cVar.ordinal()];
        if (i10 == 1) {
            return h1.IN_VARIANCE;
        }
        if (i10 == 2) {
            return h1.OUT_VARIANCE;
        }
        if (i10 == 3) {
            return h1.INVARIANT;
        }
        throw new l8.l();
    }
}
