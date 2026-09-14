package ka;

import y8.k;

/* loaded from: classes.dex */
public abstract class e {

    /* loaded from: classes.dex */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name */
        private final String f11307a;

        /* renamed from: b, reason: collision with root package name */
        private final String f11308b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(null);
            k.e(str, "name");
            k.e(str2, "desc");
            this.f11307a = str;
            this.f11308b = str2;
        }

        @Override // ka.e
        public String a() {
            return c() + ':' + b();
        }

        @Override // ka.e
        public String b() {
            return this.f11308b;
        }

        @Override // ka.e
        public String c() {
            return this.f11307a;
        }

        public final String d() {
            return this.f11307a;
        }

        public final String e() {
            return this.f11308b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k.a(this.f11307a, aVar.f11307a) && k.a(this.f11308b, aVar.f11308b);
        }

        public int hashCode() {
            return (this.f11307a.hashCode() * 31) + this.f11308b.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e {

        /* renamed from: a, reason: collision with root package name */
        private final String f11309a;

        /* renamed from: b, reason: collision with root package name */
        private final String f11310b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            k.e(str, "name");
            k.e(str2, "desc");
            this.f11309a = str;
            this.f11310b = str2;
        }

        @Override // ka.e
        public String a() {
            return k.j(c(), b());
        }

        @Override // ka.e
        public String b() {
            return this.f11310b;
        }

        @Override // ka.e
        public String c() {
            return this.f11309a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return k.a(this.f11309a, bVar.f11309a) && k.a(this.f11310b, bVar.f11310b);
        }

        public int hashCode() {
            return (this.f11309a.hashCode() * 31) + this.f11310b.hashCode();
        }
    }

    private e() {
    }

    public /* synthetic */ e(y8.g gVar) {
        this();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public final String toString() {
        return a();
    }
}
