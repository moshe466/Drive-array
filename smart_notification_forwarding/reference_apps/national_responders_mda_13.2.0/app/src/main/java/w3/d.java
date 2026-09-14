package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class d extends v.c {

    /* renamed from: a, reason: collision with root package name */
    private final w<v.c.b> f14947a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14948b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.c.a {

        /* renamed from: a, reason: collision with root package name */
        private w<v.c.b> f14949a;

        /* renamed from: b, reason: collision with root package name */
        private String f14950b;

        @Override // w3.v.c.a
        public v.c a() {
            String str = "";
            if (this.f14949a == null) {
                str = " files";
            }
            if (str.isEmpty()) {
                return new d(this.f14949a, this.f14950b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.c.a
        public v.c.a b(w<v.c.b> wVar) {
            Objects.requireNonNull(wVar, "Null files");
            this.f14949a = wVar;
            return this;
        }

        @Override // w3.v.c.a
        public v.c.a c(String str) {
            this.f14950b = str;
            return this;
        }
    }

    private d(w<v.c.b> wVar, String str) {
        this.f14947a = wVar;
        this.f14948b = str;
    }

    @Override // w3.v.c
    public w<v.c.b> b() {
        return this.f14947a;
    }

    @Override // w3.v.c
    public String c() {
        return this.f14948b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.c)) {
            return false;
        }
        v.c cVar = (v.c) obj;
        if (this.f14947a.equals(cVar.b())) {
            String str = this.f14948b;
            String c10 = cVar.c();
            if (str == null) {
                if (c10 == null) {
                    return true;
                }
            } else if (str.equals(c10)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f14947a.hashCode() ^ 1000003) * 1000003;
        String str = this.f14948b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f14947a + ", orgId=" + this.f14948b + "}";
    }
}
