package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class t extends v.d.e {

    /* renamed from: a, reason: collision with root package name */
    private final int f15090a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15091b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15092c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f15093d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.e.a {

        /* renamed from: a, reason: collision with root package name */
        private Integer f15094a;

        /* renamed from: b, reason: collision with root package name */
        private String f15095b;

        /* renamed from: c, reason: collision with root package name */
        private String f15096c;

        /* renamed from: d, reason: collision with root package name */
        private Boolean f15097d;

        @Override // w3.v.d.e.a
        public v.d.e a() {
            String str = "";
            if (this.f15094a == null) {
                str = " platform";
            }
            if (this.f15095b == null) {
                str = str + " version";
            }
            if (this.f15096c == null) {
                str = str + " buildVersion";
            }
            if (this.f15097d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new t(this.f15094a.intValue(), this.f15095b, this.f15096c, this.f15097d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.e.a
        public v.d.e.a b(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.f15096c = str;
            return this;
        }

        @Override // w3.v.d.e.a
        public v.d.e.a c(boolean z10) {
            this.f15097d = Boolean.valueOf(z10);
            return this;
        }

        @Override // w3.v.d.e.a
        public v.d.e.a d(int i10) {
            this.f15094a = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.e.a
        public v.d.e.a e(String str) {
            Objects.requireNonNull(str, "Null version");
            this.f15095b = str;
            return this;
        }
    }

    private t(int i10, String str, String str2, boolean z10) {
        this.f15090a = i10;
        this.f15091b = str;
        this.f15092c = str2;
        this.f15093d = z10;
    }

    @Override // w3.v.d.e
    public String b() {
        return this.f15092c;
    }

    @Override // w3.v.d.e
    public int c() {
        return this.f15090a;
    }

    @Override // w3.v.d.e
    public String d() {
        return this.f15091b;
    }

    @Override // w3.v.d.e
    public boolean e() {
        return this.f15093d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.e)) {
            return false;
        }
        v.d.e eVar = (v.d.e) obj;
        return this.f15090a == eVar.c() && this.f15091b.equals(eVar.d()) && this.f15092c.equals(eVar.b()) && this.f15093d == eVar.e();
    }

    public int hashCode() {
        return ((((((this.f15090a ^ 1000003) * 1000003) ^ this.f15091b.hashCode()) * 1000003) ^ this.f15092c.hashCode()) * 1000003) ^ (this.f15093d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f15090a + ", version=" + this.f15091b + ", buildVersion=" + this.f15092c + ", jailbroken=" + this.f15093d + "}";
    }
}
