package w3;

import java.util.Arrays;
import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class e extends v.c.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f14951a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f14952b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.c.b.a {

        /* renamed from: a, reason: collision with root package name */
        private String f14953a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f14954b;

        @Override // w3.v.c.b.a
        public v.c.b a() {
            String str = "";
            if (this.f14953a == null) {
                str = " filename";
            }
            if (this.f14954b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new e(this.f14953a, this.f14954b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.c.b.a
        public v.c.b.a b(byte[] bArr) {
            Objects.requireNonNull(bArr, "Null contents");
            this.f14954b = bArr;
            return this;
        }

        @Override // w3.v.c.b.a
        public v.c.b.a c(String str) {
            Objects.requireNonNull(str, "Null filename");
            this.f14953a = str;
            return this;
        }
    }

    private e(String str, byte[] bArr) {
        this.f14951a = str;
        this.f14952b = bArr;
    }

    @Override // w3.v.c.b
    public byte[] b() {
        return this.f14952b;
    }

    @Override // w3.v.c.b
    public String c() {
        return this.f14951a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.c.b)) {
            return false;
        }
        v.c.b bVar = (v.c.b) obj;
        if (this.f14951a.equals(bVar.c())) {
            if (Arrays.equals(this.f14952b, bVar instanceof e ? ((e) bVar).f14952b : bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f14951a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f14952b);
    }

    public String toString() {
        return "File{filename=" + this.f14951a + ", contents=" + Arrays.toString(this.f14952b) + "}";
    }
}
