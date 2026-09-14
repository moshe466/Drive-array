package j1;

import j1.o;

/* loaded from: classes.dex */
final class i extends o {

    /* renamed from: a, reason: collision with root package name */
    private final o.c f10960a;

    /* renamed from: b, reason: collision with root package name */
    private final o.b f10961b;

    /* loaded from: classes.dex */
    static final class b extends o.a {

        /* renamed from: a, reason: collision with root package name */
        private o.c f10962a;

        /* renamed from: b, reason: collision with root package name */
        private o.b f10963b;

        @Override // j1.o.a
        public o a() {
            return new i(this.f10962a, this.f10963b);
        }

        @Override // j1.o.a
        public o.a b(o.b bVar) {
            this.f10963b = bVar;
            return this;
        }

        @Override // j1.o.a
        public o.a c(o.c cVar) {
            this.f10962a = cVar;
            return this;
        }
    }

    private i(o.c cVar, o.b bVar) {
        this.f10960a = cVar;
        this.f10961b = bVar;
    }

    @Override // j1.o
    public o.b b() {
        return this.f10961b;
    }

    @Override // j1.o
    public o.c c() {
        return this.f10960a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.c cVar = this.f10960a;
        if (cVar != null ? cVar.equals(oVar.c()) : oVar.c() == null) {
            o.b bVar = this.f10961b;
            o.b b10 = oVar.b();
            if (bVar == null) {
                if (b10 == null) {
                    return true;
                }
            } else if (bVar.equals(b10)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.c cVar = this.f10960a;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        o.b bVar = this.f10961b;
        return hashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f10960a + ", mobileSubtype=" + this.f10961b + "}";
    }
}
