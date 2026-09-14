package j1;

import j1.k;

/* loaded from: classes.dex */
final class e extends k {

    /* renamed from: a, reason: collision with root package name */
    private final k.b f10927a;

    /* renamed from: b, reason: collision with root package name */
    private final j1.a f10928b;

    /* loaded from: classes.dex */
    static final class b extends k.a {

        /* renamed from: a, reason: collision with root package name */
        private k.b f10929a;

        /* renamed from: b, reason: collision with root package name */
        private j1.a f10930b;

        @Override // j1.k.a
        public k a() {
            return new e(this.f10929a, this.f10930b);
        }

        @Override // j1.k.a
        public k.a b(j1.a aVar) {
            this.f10930b = aVar;
            return this;
        }

        @Override // j1.k.a
        public k.a c(k.b bVar) {
            this.f10929a = bVar;
            return this;
        }
    }

    private e(k.b bVar, j1.a aVar) {
        this.f10927a = bVar;
        this.f10928b = aVar;
    }

    @Override // j1.k
    public j1.a b() {
        return this.f10928b;
    }

    @Override // j1.k
    public k.b c() {
        return this.f10927a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k.b bVar = this.f10927a;
        if (bVar != null ? bVar.equals(kVar.c()) : kVar.c() == null) {
            j1.a aVar = this.f10928b;
            j1.a b10 = kVar.b();
            if (aVar == null) {
                if (b10 == null) {
                    return true;
                }
            } else if (aVar.equals(b10)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k.b bVar = this.f10927a;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        j1.a aVar = this.f10928b;
        return hashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f10927a + ", androidClientInfo=" + this.f10928b + "}";
    }
}
