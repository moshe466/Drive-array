package ia;

import ga.c;
import ga.k;
import ga.x;
import kotlin.reflect.jvm.internal.impl.protobuf.j;

/* loaded from: classes.dex */
public class b {
    public static final C0207b A;
    public static final C0207b B;
    public static final C0207b C;
    public static final C0207b D;
    public static final C0207b E;
    public static final C0207b F;
    public static final C0207b G;
    public static final C0207b H;
    public static final C0207b I;
    public static final C0207b J;
    public static final C0207b K;
    public static final C0207b L;
    public static final C0207b M;

    /* renamed from: a, reason: collision with root package name */
    public static final C0207b f10795a = d.c();

    /* renamed from: b, reason: collision with root package name */
    public static final C0207b f10796b;

    /* renamed from: c, reason: collision with root package name */
    public static final d<x> f10797c;

    /* renamed from: d, reason: collision with root package name */
    public static final d<k> f10798d;

    /* renamed from: e, reason: collision with root package name */
    public static final d<c.EnumC0180c> f10799e;

    /* renamed from: f, reason: collision with root package name */
    public static final C0207b f10800f;

    /* renamed from: g, reason: collision with root package name */
    public static final C0207b f10801g;

    /* renamed from: h, reason: collision with root package name */
    public static final C0207b f10802h;

    /* renamed from: i, reason: collision with root package name */
    public static final C0207b f10803i;

    /* renamed from: j, reason: collision with root package name */
    public static final C0207b f10804j;

    /* renamed from: k, reason: collision with root package name */
    public static final C0207b f10805k;

    /* renamed from: l, reason: collision with root package name */
    public static final C0207b f10806l;

    /* renamed from: m, reason: collision with root package name */
    public static final C0207b f10807m;

    /* renamed from: n, reason: collision with root package name */
    public static final d<ga.j> f10808n;

    /* renamed from: o, reason: collision with root package name */
    public static final C0207b f10809o;

    /* renamed from: p, reason: collision with root package name */
    public static final C0207b f10810p;

    /* renamed from: q, reason: collision with root package name */
    public static final C0207b f10811q;

    /* renamed from: r, reason: collision with root package name */
    public static final C0207b f10812r;

    /* renamed from: s, reason: collision with root package name */
    public static final C0207b f10813s;

    /* renamed from: t, reason: collision with root package name */
    public static final C0207b f10814t;

    /* renamed from: u, reason: collision with root package name */
    public static final C0207b f10815u;

    /* renamed from: v, reason: collision with root package name */
    public static final C0207b f10816v;

    /* renamed from: w, reason: collision with root package name */
    public static final C0207b f10817w;

    /* renamed from: x, reason: collision with root package name */
    public static final C0207b f10818x;

    /* renamed from: y, reason: collision with root package name */
    public static final C0207b f10819y;

    /* renamed from: z, reason: collision with root package name */
    public static final C0207b f10820z;

    /* renamed from: ia.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0207b extends d<Boolean> {
        public C0207b(int i10) {
            super(i10, 1);
        }

        private static /* synthetic */ void f(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        @Override // ia.b.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i10) {
            Boolean valueOf = Boolean.valueOf((i10 & (1 << this.f10822a)) != 0);
            if (valueOf == null) {
                f(0);
            }
            return valueOf;
        }

        @Override // ia.b.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f10822a;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c<E extends j.a> extends d<E> {

        /* renamed from: c, reason: collision with root package name */
        private final E[] f10821c;

        public c(int i10, E[] eArr) {
            super(i10, g(eArr));
            this.f10821c = eArr;
        }

        private static /* synthetic */ void f(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i10 = 31; i10 >= 0; i10--) {
                if (((1 << i10) & length) != 0) {
                    return i10 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // ia.b.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public E d(int i10) {
            int i11 = (1 << this.f10823b) - 1;
            int i12 = this.f10822a;
            int i13 = (i10 & (i11 << i12)) >> i12;
            for (E e10 : this.f10821c) {
                if (e10.getNumber() == i13) {
                    return e10;
                }
            }
            return null;
        }

        @Override // ia.b.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(E e10) {
            return e10.getNumber() << this.f10822a;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d<E> {

        /* renamed from: a, reason: collision with root package name */
        public final int f10822a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10823b;

        private d(int i10, int i11) {
            this.f10822a = i10;
            this.f10823b = i11;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/j$a;>(Lia/b$d<*>;[TE;)Lia/b$d<TE;>; */
        public static d a(d dVar, j.a[] aVarArr) {
            return new c(dVar.f10822a + dVar.f10823b, aVarArr);
        }

        public static C0207b b(d<?> dVar) {
            return new C0207b(dVar.f10822a + dVar.f10823b);
        }

        public static C0207b c() {
            return new C0207b(0);
        }

        public abstract E d(int i10);

        public abstract int e(E e10);
    }

    static {
        C0207b c10 = d.c();
        f10796b = c10;
        d<x> a10 = d.a(c10, x.values());
        f10797c = a10;
        d<k> a11 = d.a(a10, k.values());
        f10798d = a11;
        d<c.EnumC0180c> a12 = d.a(a11, c.EnumC0180c.values());
        f10799e = a12;
        C0207b b10 = d.b(a12);
        f10800f = b10;
        C0207b b11 = d.b(b10);
        f10801g = b11;
        C0207b b12 = d.b(b11);
        f10802h = b12;
        C0207b b13 = d.b(b12);
        f10803i = b13;
        C0207b b14 = d.b(b13);
        f10804j = b14;
        f10805k = d.b(b14);
        C0207b b15 = d.b(a10);
        f10806l = b15;
        f10807m = d.b(b15);
        d<ga.j> a13 = d.a(a11, ga.j.values());
        f10808n = a13;
        C0207b b16 = d.b(a13);
        f10809o = b16;
        C0207b b17 = d.b(b16);
        f10810p = b17;
        C0207b b18 = d.b(b17);
        f10811q = b18;
        C0207b b19 = d.b(b18);
        f10812r = b19;
        C0207b b20 = d.b(b19);
        f10813s = b20;
        C0207b b21 = d.b(b20);
        f10814t = b21;
        C0207b b22 = d.b(b21);
        f10815u = b22;
        f10816v = d.b(b22);
        C0207b b23 = d.b(a13);
        f10817w = b23;
        C0207b b24 = d.b(b23);
        f10818x = b24;
        C0207b b25 = d.b(b24);
        f10819y = b25;
        C0207b b26 = d.b(b25);
        f10820z = b26;
        C0207b b27 = d.b(b26);
        A = b27;
        C0207b b28 = d.b(b27);
        B = b28;
        C0207b b29 = d.b(b28);
        C = b29;
        C0207b b30 = d.b(b29);
        D = b30;
        E = d.b(b30);
        C0207b b31 = d.b(c10);
        F = b31;
        C0207b b32 = d.b(b31);
        G = b32;
        H = d.b(b32);
        C0207b b33 = d.b(a11);
        I = b33;
        C0207b b34 = d.b(b33);
        J = b34;
        K = d.b(b34);
        C0207b c11 = d.c();
        L = c11;
        d.b(c11);
        M = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 1
            r2 = 0
            r3 = 2
            if (r5 == r1) goto L2b
            if (r5 == r3) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r2] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r2] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r2] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r2] = r4
        L2f:
            java.lang.String r2 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r1] = r2
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r3] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r3] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r3] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r3] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r3] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.b.a(int):void");
    }

    public static int b(boolean z10, x xVar, k kVar, boolean z11, boolean z12, boolean z13) {
        if (xVar == null) {
            a(10);
        }
        if (kVar == null) {
            a(11);
        }
        return f10796b.e(Boolean.valueOf(z10)) | f10798d.e(kVar) | f10797c.e(xVar) | I.e(Boolean.valueOf(z11)) | J.e(Boolean.valueOf(z12)) | K.e(Boolean.valueOf(z13));
    }
}
