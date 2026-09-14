package y8;

/* loaded from: classes.dex */
public final class a0 implements e9.l {

    /* renamed from: f, reason: collision with root package name */
    public static final a f15930f = new a(null);

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: y8.a0$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public /* synthetic */ class C0337a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15931a;

            static {
                int[] iArr = new int[e9.n.values().length];
                iArr[e9.n.INVARIANT.ordinal()] = 1;
                iArr[e9.n.IN.ordinal()] = 2;
                iArr[e9.n.OUT.ordinal()] = 3;
                f15931a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(e9.l lVar) {
            String str;
            k.e(lVar, "typeParameter");
            StringBuilder sb2 = new StringBuilder();
            int i10 = C0337a.f15931a[lVar.v().ordinal()];
            if (i10 != 2) {
                str = i10 == 3 ? "out " : "in ";
                sb2.append(lVar.c());
                String sb3 = sb2.toString();
                k.d(sb3, "StringBuilder().apply(builderAction).toString()");
                return sb3;
            }
            sb2.append(str);
            sb2.append(lVar.c());
            String sb32 = sb2.toString();
            k.d(sb32, "StringBuilder().apply(builderAction).toString()");
            return sb32;
        }
    }
}
