package l9;

import y8.g;
import y8.k;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'KFunction' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class c {
    private static final /* synthetic */ c[] $VALUES;
    public static final a Companion;
    public static final c Function;
    public static final c KFunction;
    public static final c KSuspendFunction;
    public static final c SuspendFunction;
    private final String classNamePrefix;
    private final la.b packageFqName;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: l9.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0247a {

            /* renamed from: a, reason: collision with root package name */
            private final c f11840a;

            /* renamed from: b, reason: collision with root package name */
            private final int f11841b;

            public C0247a(c cVar, int i10) {
                k.e(cVar, "kind");
                this.f11840a = cVar;
                this.f11841b = i10;
            }

            public final c a() {
                return this.f11840a;
            }

            public final int b() {
                return this.f11841b;
            }

            public final c c() {
                return this.f11840a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0247a)) {
                    return false;
                }
                C0247a c0247a = (C0247a) obj;
                return this.f11840a == c0247a.f11840a && this.f11841b == c0247a.f11841b;
            }

            public int hashCode() {
                return (this.f11840a.hashCode() * 31) + this.f11841b;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.f11840a + ", arity=" + this.f11841b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                char charAt = str.charAt(i10);
                i10++;
                int i12 = charAt - '0';
                if (!(i12 >= 0 && i12 <= 9)) {
                    return null;
                }
                i11 = (i11 * 10) + i12;
            }
            return Integer.valueOf(i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[LOOP:0: B:2:0x0011->B:10:0x0032, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final l9.c a(la.b r9, java.lang.String r10) {
            /*
                r8 = this;
                java.lang.String r0 = "packageFqName"
                y8.k.e(r9, r0)
                java.lang.String r0 = "className"
                y8.k.e(r10, r0)
                l9.c[] r0 = l9.c.values()
                int r1 = r0.length
                r2 = 0
                r3 = 0
            L11:
                r4 = 0
                if (r3 >= r1) goto L35
                r5 = r0[r3]
                la.b r6 = r5.getPackageFqName()
                boolean r6 = y8.k.a(r6, r9)
                if (r6 == 0) goto L2d
                java.lang.String r6 = r5.getClassNamePrefix()
                r7 = 2
                boolean r4 = mb.i.w(r10, r6, r2, r7, r4)
                if (r4 == 0) goto L2d
                r4 = 1
                goto L2e
            L2d:
                r4 = 0
            L2e:
                if (r4 == 0) goto L32
                r4 = r5
                goto L35
            L32:
                int r3 = r3 + 1
                goto L11
            L35:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: l9.c.a.a(la.b, java.lang.String):l9.c");
        }

        public final c b(String str, la.b bVar) {
            k.e(str, "className");
            k.e(bVar, "packageFqName");
            C0247a c10 = c(str, bVar);
            if (c10 == null) {
                return null;
            }
            return c10.c();
        }

        public final C0247a c(String str, la.b bVar) {
            k.e(str, "className");
            k.e(bVar, "packageFqName");
            c a10 = a(bVar, str);
            if (a10 == null) {
                return null;
            }
            String substring = str.substring(a10.getClassNamePrefix().length());
            k.d(substring, "(this as java.lang.String).substring(startIndex)");
            Integer d10 = d(substring);
            if (d10 == null) {
                return null;
            }
            return new C0247a(a10, d10.intValue());
        }
    }

    static {
        c cVar = new c("Function", 0, k9.k.f11246l, "Function");
        Function = cVar;
        c cVar2 = new c("SuspendFunction", 1, k9.k.f11238d, "SuspendFunction");
        SuspendFunction = cVar2;
        la.b bVar = k9.k.f11243i;
        c cVar3 = new c("KFunction", 2, bVar, "KFunction");
        KFunction = cVar3;
        c cVar4 = new c("KSuspendFunction", 3, bVar, "KSuspendFunction");
        KSuspendFunction = cVar4;
        $VALUES = new c[]{cVar, cVar2, cVar3, cVar4};
        Companion = new a(null);
    }

    private c(String str, int i10, la.b bVar, String str2) {
        this.packageFqName = bVar;
        this.classNamePrefix = str2;
    }

    public static c valueOf(String str) {
        k.e(str, "value");
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        c[] cVarArr = $VALUES;
        c[] cVarArr2 = new c[cVarArr.length];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
        return cVarArr2;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final la.b getPackageFqName() {
        return this.packageFqName;
    }

    public final la.e numberedClassName(int i10) {
        la.e r10 = la.e.r(k.j(this.classNamePrefix, Integer.valueOf(i10)));
        k.d(r10, "identifier(\"$classNamePrefix$arity\")");
        return r10;
    }
}
