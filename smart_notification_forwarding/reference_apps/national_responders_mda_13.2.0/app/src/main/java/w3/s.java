package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class s extends v.d.AbstractC0312d.AbstractC0323d {

    /* renamed from: a, reason: collision with root package name */
    private final String f15088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.AbstractC0323d.a {

        /* renamed from: a, reason: collision with root package name */
        private String f15089a;

        @Override // w3.v.d.AbstractC0312d.AbstractC0323d.a
        public v.d.AbstractC0312d.AbstractC0323d a() {
            String str = "";
            if (this.f15089a == null) {
                str = " content";
            }
            if (str.isEmpty()) {
                return new s(this.f15089a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.AbstractC0323d.a
        public v.d.AbstractC0312d.AbstractC0323d.a b(String str) {
            Objects.requireNonNull(str, "Null content");
            this.f15089a = str;
            return this;
        }
    }

    private s(String str) {
        this.f15088a = str;
    }

    @Override // w3.v.d.AbstractC0312d.AbstractC0323d
    public String b() {
        return this.f15088a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0312d.AbstractC0323d) {
            return this.f15088a.equals(((v.d.AbstractC0312d.AbstractC0323d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f15088a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f15088a + "}";
    }
}
