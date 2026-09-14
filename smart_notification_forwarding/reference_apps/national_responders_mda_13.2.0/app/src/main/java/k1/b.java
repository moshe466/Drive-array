package k1;

import java.util.Objects;
import k1.l;

/* loaded from: classes.dex */
final class b extends l {

    /* renamed from: a, reason: collision with root package name */
    private final m f11140a;

    /* renamed from: b, reason: collision with root package name */
    private final String f11141b;

    /* renamed from: c, reason: collision with root package name */
    private final i1.c<?> f11142c;

    /* renamed from: d, reason: collision with root package name */
    private final i1.e<?, byte[]> f11143d;

    /* renamed from: e, reason: collision with root package name */
    private final i1.b f11144e;

    /* renamed from: k1.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0226b extends l.a {

        /* renamed from: a, reason: collision with root package name */
        private m f11145a;

        /* renamed from: b, reason: collision with root package name */
        private String f11146b;

        /* renamed from: c, reason: collision with root package name */
        private i1.c<?> f11147c;

        /* renamed from: d, reason: collision with root package name */
        private i1.e<?, byte[]> f11148d;

        /* renamed from: e, reason: collision with root package name */
        private i1.b f11149e;

        @Override // k1.l.a
        public l a() {
            String str = "";
            if (this.f11145a == null) {
                str = " transportContext";
            }
            if (this.f11146b == null) {
                str = str + " transportName";
            }
            if (this.f11147c == null) {
                str = str + " event";
            }
            if (this.f11148d == null) {
                str = str + " transformer";
            }
            if (this.f11149e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new b(this.f11145a, this.f11146b, this.f11147c, this.f11148d, this.f11149e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // k1.l.a
        l.a b(i1.b bVar) {
            Objects.requireNonNull(bVar, "Null encoding");
            this.f11149e = bVar;
            return this;
        }

        @Override // k1.l.a
        l.a c(i1.c<?> cVar) {
            Objects.requireNonNull(cVar, "Null event");
            this.f11147c = cVar;
            return this;
        }

        @Override // k1.l.a
        l.a d(i1.e<?, byte[]> eVar) {
            Objects.requireNonNull(eVar, "Null transformer");
            this.f11148d = eVar;
            return this;
        }

        @Override // k1.l.a
        public l.a e(m mVar) {
            Objects.requireNonNull(mVar, "Null transportContext");
            this.f11145a = mVar;
            return this;
        }

        @Override // k1.l.a
        public l.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f11146b = str;
            return this;
        }
    }

    private b(m mVar, String str, i1.c<?> cVar, i1.e<?, byte[]> eVar, i1.b bVar) {
        this.f11140a = mVar;
        this.f11141b = str;
        this.f11142c = cVar;
        this.f11143d = eVar;
        this.f11144e = bVar;
    }

    @Override // k1.l
    public i1.b b() {
        return this.f11144e;
    }

    @Override // k1.l
    i1.c<?> c() {
        return this.f11142c;
    }

    @Override // k1.l
    i1.e<?, byte[]> e() {
        return this.f11143d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f11140a.equals(lVar.f()) && this.f11141b.equals(lVar.g()) && this.f11142c.equals(lVar.c()) && this.f11143d.equals(lVar.e()) && this.f11144e.equals(lVar.b());
    }

    @Override // k1.l
    public m f() {
        return this.f11140a;
    }

    @Override // k1.l
    public String g() {
        return this.f11141b;
    }

    public int hashCode() {
        return ((((((((this.f11140a.hashCode() ^ 1000003) * 1000003) ^ this.f11141b.hashCode()) * 1000003) ^ this.f11142c.hashCode()) * 1000003) ^ this.f11143d.hashCode()) * 1000003) ^ this.f11144e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f11140a + ", transportName=" + this.f11141b + ", event=" + this.f11142c + ", transformer=" + this.f11143d + ", encoding=" + this.f11144e + "}";
    }
}
