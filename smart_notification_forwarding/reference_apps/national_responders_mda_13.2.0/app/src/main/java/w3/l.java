package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class l extends v.d.AbstractC0312d.a.b {

    /* renamed from: a, reason: collision with root package name */
    private final w<v.d.AbstractC0312d.a.b.e> f15028a;

    /* renamed from: b, reason: collision with root package name */
    private final v.d.AbstractC0312d.a.b.c f15029b;

    /* renamed from: c, reason: collision with root package name */
    private final v.d.AbstractC0312d.a.b.AbstractC0318d f15030c;

    /* renamed from: d, reason: collision with root package name */
    private final w<v.d.AbstractC0312d.a.b.AbstractC0314a> f15031d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.a.b.AbstractC0316b {

        /* renamed from: a, reason: collision with root package name */
        private w<v.d.AbstractC0312d.a.b.e> f15032a;

        /* renamed from: b, reason: collision with root package name */
        private v.d.AbstractC0312d.a.b.c f15033b;

        /* renamed from: c, reason: collision with root package name */
        private v.d.AbstractC0312d.a.b.AbstractC0318d f15034c;

        /* renamed from: d, reason: collision with root package name */
        private w<v.d.AbstractC0312d.a.b.AbstractC0314a> f15035d;

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0316b
        public v.d.AbstractC0312d.a.b a() {
            String str = "";
            if (this.f15032a == null) {
                str = " threads";
            }
            if (this.f15033b == null) {
                str = str + " exception";
            }
            if (this.f15034c == null) {
                str = str + " signal";
            }
            if (this.f15035d == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new l(this.f15032a, this.f15033b, this.f15034c, this.f15035d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0316b
        public v.d.AbstractC0312d.a.b.AbstractC0316b b(w<v.d.AbstractC0312d.a.b.AbstractC0314a> wVar) {
            Objects.requireNonNull(wVar, "Null binaries");
            this.f15035d = wVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0316b
        public v.d.AbstractC0312d.a.b.AbstractC0316b c(v.d.AbstractC0312d.a.b.c cVar) {
            Objects.requireNonNull(cVar, "Null exception");
            this.f15033b = cVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0316b
        public v.d.AbstractC0312d.a.b.AbstractC0316b d(v.d.AbstractC0312d.a.b.AbstractC0318d abstractC0318d) {
            Objects.requireNonNull(abstractC0318d, "Null signal");
            this.f15034c = abstractC0318d;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0316b
        public v.d.AbstractC0312d.a.b.AbstractC0316b e(w<v.d.AbstractC0312d.a.b.e> wVar) {
            Objects.requireNonNull(wVar, "Null threads");
            this.f15032a = wVar;
            return this;
        }
    }

    private l(w<v.d.AbstractC0312d.a.b.e> wVar, v.d.AbstractC0312d.a.b.c cVar, v.d.AbstractC0312d.a.b.AbstractC0318d abstractC0318d, w<v.d.AbstractC0312d.a.b.AbstractC0314a> wVar2) {
        this.f15028a = wVar;
        this.f15029b = cVar;
        this.f15030c = abstractC0318d;
        this.f15031d = wVar2;
    }

    @Override // w3.v.d.AbstractC0312d.a.b
    public w<v.d.AbstractC0312d.a.b.AbstractC0314a> b() {
        return this.f15031d;
    }

    @Override // w3.v.d.AbstractC0312d.a.b
    public v.d.AbstractC0312d.a.b.c c() {
        return this.f15029b;
    }

    @Override // w3.v.d.AbstractC0312d.a.b
    public v.d.AbstractC0312d.a.b.AbstractC0318d d() {
        return this.f15030c;
    }

    @Override // w3.v.d.AbstractC0312d.a.b
    public w<v.d.AbstractC0312d.a.b.e> e() {
        return this.f15028a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d.a.b)) {
            return false;
        }
        v.d.AbstractC0312d.a.b bVar = (v.d.AbstractC0312d.a.b) obj;
        return this.f15028a.equals(bVar.e()) && this.f15029b.equals(bVar.c()) && this.f15030c.equals(bVar.d()) && this.f15031d.equals(bVar.b());
    }

    public int hashCode() {
        return ((((((this.f15028a.hashCode() ^ 1000003) * 1000003) ^ this.f15029b.hashCode()) * 1000003) ^ this.f15030c.hashCode()) * 1000003) ^ this.f15031d.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f15028a + ", exception=" + this.f15029b + ", signal=" + this.f15030c + ", binaries=" + this.f15031d + "}";
    }
}
