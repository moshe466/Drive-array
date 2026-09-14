package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class n extends v.d.AbstractC0312d.a.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f15044a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15045b;

    /* renamed from: c, reason: collision with root package name */
    private final w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> f15046c;

    /* renamed from: d, reason: collision with root package name */
    private final v.d.AbstractC0312d.a.b.c f15047d;

    /* renamed from: e, reason: collision with root package name */
    private final int f15048e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.a.b.c.AbstractC0317a {

        /* renamed from: a, reason: collision with root package name */
        private String f15049a;

        /* renamed from: b, reason: collision with root package name */
        private String f15050b;

        /* renamed from: c, reason: collision with root package name */
        private w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> f15051c;

        /* renamed from: d, reason: collision with root package name */
        private v.d.AbstractC0312d.a.b.c f15052d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f15053e;

        @Override // w3.v.d.AbstractC0312d.a.b.c.AbstractC0317a
        public v.d.AbstractC0312d.a.b.c a() {
            String str = "";
            if (this.f15049a == null) {
                str = " type";
            }
            if (this.f15051c == null) {
                str = str + " frames";
            }
            if (this.f15053e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new n(this.f15049a, this.f15050b, this.f15051c, this.f15052d, this.f15053e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.a.b.c.AbstractC0317a
        public v.d.AbstractC0312d.a.b.c.AbstractC0317a b(v.d.AbstractC0312d.a.b.c cVar) {
            this.f15052d = cVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.c.AbstractC0317a
        public v.d.AbstractC0312d.a.b.c.AbstractC0317a c(w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> wVar) {
            Objects.requireNonNull(wVar, "Null frames");
            this.f15051c = wVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.c.AbstractC0317a
        public v.d.AbstractC0312d.a.b.c.AbstractC0317a d(int i10) {
            this.f15053e = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.c.AbstractC0317a
        public v.d.AbstractC0312d.a.b.c.AbstractC0317a e(String str) {
            this.f15050b = str;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.c.AbstractC0317a
        public v.d.AbstractC0312d.a.b.c.AbstractC0317a f(String str) {
            Objects.requireNonNull(str, "Null type");
            this.f15049a = str;
            return this;
        }
    }

    private n(String str, String str2, w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> wVar, v.d.AbstractC0312d.a.b.c cVar, int i10) {
        this.f15044a = str;
        this.f15045b = str2;
        this.f15046c = wVar;
        this.f15047d = cVar;
        this.f15048e = i10;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.c
    public v.d.AbstractC0312d.a.b.c b() {
        return this.f15047d;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.c
    public w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> c() {
        return this.f15046c;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.c
    public int d() {
        return this.f15048e;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.c
    public String e() {
        return this.f15045b;
    }

    public boolean equals(Object obj) {
        String str;
        v.d.AbstractC0312d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d.a.b.c)) {
            return false;
        }
        v.d.AbstractC0312d.a.b.c cVar2 = (v.d.AbstractC0312d.a.b.c) obj;
        return this.f15044a.equals(cVar2.f()) && ((str = this.f15045b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f15046c.equals(cVar2.c()) && ((cVar = this.f15047d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f15048e == cVar2.d();
    }

    @Override // w3.v.d.AbstractC0312d.a.b.c
    public String f() {
        return this.f15044a;
    }

    public int hashCode() {
        int hashCode = (this.f15044a.hashCode() ^ 1000003) * 1000003;
        String str = this.f15045b;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f15046c.hashCode()) * 1000003;
        v.d.AbstractC0312d.a.b.c cVar = this.f15047d;
        return ((hashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f15048e;
    }

    public String toString() {
        return "Exception{type=" + this.f15044a + ", reason=" + this.f15045b + ", frames=" + this.f15046c + ", causedBy=" + this.f15047d + ", overflowCount=" + this.f15048e + "}";
    }
}
