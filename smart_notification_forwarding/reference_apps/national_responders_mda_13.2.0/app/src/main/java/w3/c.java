package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class c extends v.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f14943a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14944b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.b.a {

        /* renamed from: a, reason: collision with root package name */
        private String f14945a;

        /* renamed from: b, reason: collision with root package name */
        private String f14946b;

        @Override // w3.v.b.a
        public v.b a() {
            String str = "";
            if (this.f14945a == null) {
                str = " key";
            }
            if (this.f14946b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new c(this.f14945a, this.f14946b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.b.a
        public v.b.a b(String str) {
            Objects.requireNonNull(str, "Null key");
            this.f14945a = str;
            return this;
        }

        @Override // w3.v.b.a
        public v.b.a c(String str) {
            Objects.requireNonNull(str, "Null value");
            this.f14946b = str;
            return this;
        }
    }

    private c(String str, String str2) {
        this.f14943a = str;
        this.f14944b = str2;
    }

    @Override // w3.v.b
    public String b() {
        return this.f14943a;
    }

    @Override // w3.v.b
    public String c() {
        return this.f14944b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.b)) {
            return false;
        }
        v.b bVar = (v.b) obj;
        return this.f14943a.equals(bVar.b()) && this.f14944b.equals(bVar.c());
    }

    public int hashCode() {
        return ((this.f14943a.hashCode() ^ 1000003) * 1000003) ^ this.f14944b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f14943a + ", value=" + this.f14944b + "}";
    }
}
