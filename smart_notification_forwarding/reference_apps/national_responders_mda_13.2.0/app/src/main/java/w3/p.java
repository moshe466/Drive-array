package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class p extends v.d.AbstractC0312d.a.b.e {

    /* renamed from: a, reason: collision with root package name */
    private final String f15060a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15061b;

    /* renamed from: c, reason: collision with root package name */
    private final w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> f15062c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.a.b.e.AbstractC0320a {

        /* renamed from: a, reason: collision with root package name */
        private String f15063a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f15064b;

        /* renamed from: c, reason: collision with root package name */
        private w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> f15065c;

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0320a
        public v.d.AbstractC0312d.a.b.e a() {
            String str = "";
            if (this.f15063a == null) {
                str = " name";
            }
            if (this.f15064b == null) {
                str = str + " importance";
            }
            if (this.f15065c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new p(this.f15063a, this.f15064b.intValue(), this.f15065c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0320a
        public v.d.AbstractC0312d.a.b.e.AbstractC0320a b(w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> wVar) {
            Objects.requireNonNull(wVar, "Null frames");
            this.f15065c = wVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0320a
        public v.d.AbstractC0312d.a.b.e.AbstractC0320a c(int i10) {
            this.f15064b = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0320a
        public v.d.AbstractC0312d.a.b.e.AbstractC0320a d(String str) {
            Objects.requireNonNull(str, "Null name");
            this.f15063a = str;
            return this;
        }
    }

    private p(String str, int i10, w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> wVar) {
        this.f15060a = str;
        this.f15061b = i10;
        this.f15062c = wVar;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.e
    public w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> b() {
        return this.f15062c;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.e
    public int c() {
        return this.f15061b;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.e
    public String d() {
        return this.f15060a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d.a.b.e)) {
            return false;
        }
        v.d.AbstractC0312d.a.b.e eVar = (v.d.AbstractC0312d.a.b.e) obj;
        return this.f15060a.equals(eVar.d()) && this.f15061b == eVar.c() && this.f15062c.equals(eVar.b());
    }

    public int hashCode() {
        return ((((this.f15060a.hashCode() ^ 1000003) * 1000003) ^ this.f15061b) * 1000003) ^ this.f15062c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f15060a + ", importance=" + this.f15061b + ", frames=" + this.f15062c + "}";
    }
}
