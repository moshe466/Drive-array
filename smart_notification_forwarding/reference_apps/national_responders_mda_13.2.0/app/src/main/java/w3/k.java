package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class k extends v.d.AbstractC0312d.a {

    /* renamed from: a, reason: collision with root package name */
    private final v.d.AbstractC0312d.a.b f15020a;

    /* renamed from: b, reason: collision with root package name */
    private final w<v.b> f15021b;

    /* renamed from: c, reason: collision with root package name */
    private final Boolean f15022c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15023d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.a.AbstractC0313a {

        /* renamed from: a, reason: collision with root package name */
        private v.d.AbstractC0312d.a.b f15024a;

        /* renamed from: b, reason: collision with root package name */
        private w<v.b> f15025b;

        /* renamed from: c, reason: collision with root package name */
        private Boolean f15026c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f15027d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(v.d.AbstractC0312d.a aVar) {
            this.f15024a = aVar.d();
            this.f15025b = aVar.c();
            this.f15026c = aVar.b();
            this.f15027d = Integer.valueOf(aVar.e());
        }

        @Override // w3.v.d.AbstractC0312d.a.AbstractC0313a
        public v.d.AbstractC0312d.a a() {
            String str = "";
            if (this.f15024a == null) {
                str = " execution";
            }
            if (this.f15027d == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new k(this.f15024a, this.f15025b, this.f15026c, this.f15027d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.a.AbstractC0313a
        public v.d.AbstractC0312d.a.AbstractC0313a b(Boolean bool) {
            this.f15026c = bool;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.AbstractC0313a
        public v.d.AbstractC0312d.a.AbstractC0313a c(w<v.b> wVar) {
            this.f15025b = wVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.AbstractC0313a
        public v.d.AbstractC0312d.a.AbstractC0313a d(v.d.AbstractC0312d.a.b bVar) {
            Objects.requireNonNull(bVar, "Null execution");
            this.f15024a = bVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.AbstractC0313a
        public v.d.AbstractC0312d.a.AbstractC0313a e(int i10) {
            this.f15027d = Integer.valueOf(i10);
            return this;
        }
    }

    private k(v.d.AbstractC0312d.a.b bVar, w<v.b> wVar, Boolean bool, int i10) {
        this.f15020a = bVar;
        this.f15021b = wVar;
        this.f15022c = bool;
        this.f15023d = i10;
    }

    @Override // w3.v.d.AbstractC0312d.a
    public Boolean b() {
        return this.f15022c;
    }

    @Override // w3.v.d.AbstractC0312d.a
    public w<v.b> c() {
        return this.f15021b;
    }

    @Override // w3.v.d.AbstractC0312d.a
    public v.d.AbstractC0312d.a.b d() {
        return this.f15020a;
    }

    @Override // w3.v.d.AbstractC0312d.a
    public int e() {
        return this.f15023d;
    }

    public boolean equals(Object obj) {
        w<v.b> wVar;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d.a)) {
            return false;
        }
        v.d.AbstractC0312d.a aVar = (v.d.AbstractC0312d.a) obj;
        return this.f15020a.equals(aVar.d()) && ((wVar = this.f15021b) != null ? wVar.equals(aVar.c()) : aVar.c() == null) && ((bool = this.f15022c) != null ? bool.equals(aVar.b()) : aVar.b() == null) && this.f15023d == aVar.e();
    }

    @Override // w3.v.d.AbstractC0312d.a
    public v.d.AbstractC0312d.a.AbstractC0313a f() {
        return new b(this);
    }

    public int hashCode() {
        int hashCode = (this.f15020a.hashCode() ^ 1000003) * 1000003;
        w<v.b> wVar = this.f15021b;
        int hashCode2 = (hashCode ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        Boolean bool = this.f15022c;
        return ((hashCode2 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.f15023d;
    }

    public String toString() {
        return "Application{execution=" + this.f15020a + ", customAttributes=" + this.f15021b + ", background=" + this.f15022c + ", uiOrientation=" + this.f15023d + "}";
    }
}
