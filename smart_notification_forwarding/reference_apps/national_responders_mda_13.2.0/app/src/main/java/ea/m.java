package ea;

/* loaded from: classes.dex */
public interface m extends xa.s {

    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: ea.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0155a extends a {

            /* renamed from: a, reason: collision with root package name */
            private final byte[] f9323a;

            public final byte[] b() {
                return this.f9323a;
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends a {

            /* renamed from: a, reason: collision with root package name */
            private final o f9324a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(o oVar, byte[] bArr) {
                super(null);
                y8.k.e(oVar, "kotlinJvmBinaryClass");
                this.f9324a = oVar;
            }

            public /* synthetic */ b(o oVar, byte[] bArr, int i10, y8.g gVar) {
                this(oVar, (i10 & 2) != 0 ? null : bArr);
            }

            public final o b() {
                return this.f9324a;
            }
        }

        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final o a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.b();
        }
    }

    a a(ca.g gVar);

    a c(la.a aVar);
}
