package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class u extends v.d.f {

    /* renamed from: a, reason: collision with root package name */
    private final String f15098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.f.a {

        /* renamed from: a, reason: collision with root package name */
        private String f15099a;

        @Override // w3.v.d.f.a
        public v.d.f a() {
            String str = "";
            if (this.f15099a == null) {
                str = " identifier";
            }
            if (str.isEmpty()) {
                return new u(this.f15099a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.f.a
        public v.d.f.a b(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.f15099a = str;
            return this;
        }
    }

    private u(String str) {
        this.f15098a = str;
    }

    @Override // w3.v.d.f
    public String b() {
        return this.f15098a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.f) {
            return this.f15098a.equals(((v.d.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f15098a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f15098a + "}";
    }
}
