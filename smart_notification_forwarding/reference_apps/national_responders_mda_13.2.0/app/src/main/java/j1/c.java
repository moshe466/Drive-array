package j1;

import j1.a;

/* loaded from: classes.dex */
final class c extends j1.a {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f10902a;

    /* renamed from: b, reason: collision with root package name */
    private final String f10903b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10904c;

    /* renamed from: d, reason: collision with root package name */
    private final String f10905d;

    /* renamed from: e, reason: collision with root package name */
    private final String f10906e;

    /* renamed from: f, reason: collision with root package name */
    private final String f10907f;

    /* renamed from: g, reason: collision with root package name */
    private final String f10908g;

    /* renamed from: h, reason: collision with root package name */
    private final String f10909h;

    /* renamed from: i, reason: collision with root package name */
    private final String f10910i;

    /* renamed from: j, reason: collision with root package name */
    private final String f10911j;

    /* renamed from: k, reason: collision with root package name */
    private final String f10912k;

    /* renamed from: l, reason: collision with root package name */
    private final String f10913l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends a.AbstractC0210a {

        /* renamed from: a, reason: collision with root package name */
        private Integer f10914a;

        /* renamed from: b, reason: collision with root package name */
        private String f10915b;

        /* renamed from: c, reason: collision with root package name */
        private String f10916c;

        /* renamed from: d, reason: collision with root package name */
        private String f10917d;

        /* renamed from: e, reason: collision with root package name */
        private String f10918e;

        /* renamed from: f, reason: collision with root package name */
        private String f10919f;

        /* renamed from: g, reason: collision with root package name */
        private String f10920g;

        /* renamed from: h, reason: collision with root package name */
        private String f10921h;

        /* renamed from: i, reason: collision with root package name */
        private String f10922i;

        /* renamed from: j, reason: collision with root package name */
        private String f10923j;

        /* renamed from: k, reason: collision with root package name */
        private String f10924k;

        /* renamed from: l, reason: collision with root package name */
        private String f10925l;

        @Override // j1.a.AbstractC0210a
        public j1.a a() {
            return new c(this.f10914a, this.f10915b, this.f10916c, this.f10917d, this.f10918e, this.f10919f, this.f10920g, this.f10921h, this.f10922i, this.f10923j, this.f10924k, this.f10925l);
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a b(String str) {
            this.f10925l = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a c(String str) {
            this.f10923j = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a d(String str) {
            this.f10917d = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a e(String str) {
            this.f10921h = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a f(String str) {
            this.f10916c = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a g(String str) {
            this.f10922i = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a h(String str) {
            this.f10920g = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a i(String str) {
            this.f10924k = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a j(String str) {
            this.f10915b = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a k(String str) {
            this.f10919f = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a l(String str) {
            this.f10918e = str;
            return this;
        }

        @Override // j1.a.AbstractC0210a
        public a.AbstractC0210a m(Integer num) {
            this.f10914a = num;
            return this;
        }
    }

    private c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f10902a = num;
        this.f10903b = str;
        this.f10904c = str2;
        this.f10905d = str3;
        this.f10906e = str4;
        this.f10907f = str5;
        this.f10908g = str6;
        this.f10909h = str7;
        this.f10910i = str8;
        this.f10911j = str9;
        this.f10912k = str10;
        this.f10913l = str11;
    }

    @Override // j1.a
    public String b() {
        return this.f10913l;
    }

    @Override // j1.a
    public String c() {
        return this.f10911j;
    }

    @Override // j1.a
    public String d() {
        return this.f10905d;
    }

    @Override // j1.a
    public String e() {
        return this.f10909h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j1.a)) {
            return false;
        }
        j1.a aVar = (j1.a) obj;
        Integer num = this.f10902a;
        if (num != null ? num.equals(aVar.m()) : aVar.m() == null) {
            String str = this.f10903b;
            if (str != null ? str.equals(aVar.j()) : aVar.j() == null) {
                String str2 = this.f10904c;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f10905d;
                    if (str3 != null ? str3.equals(aVar.d()) : aVar.d() == null) {
                        String str4 = this.f10906e;
                        if (str4 != null ? str4.equals(aVar.l()) : aVar.l() == null) {
                            String str5 = this.f10907f;
                            if (str5 != null ? str5.equals(aVar.k()) : aVar.k() == null) {
                                String str6 = this.f10908g;
                                if (str6 != null ? str6.equals(aVar.h()) : aVar.h() == null) {
                                    String str7 = this.f10909h;
                                    if (str7 != null ? str7.equals(aVar.e()) : aVar.e() == null) {
                                        String str8 = this.f10910i;
                                        if (str8 != null ? str8.equals(aVar.g()) : aVar.g() == null) {
                                            String str9 = this.f10911j;
                                            if (str9 != null ? str9.equals(aVar.c()) : aVar.c() == null) {
                                                String str10 = this.f10912k;
                                                if (str10 != null ? str10.equals(aVar.i()) : aVar.i() == null) {
                                                    String str11 = this.f10913l;
                                                    String b10 = aVar.b();
                                                    if (str11 == null) {
                                                        if (b10 == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(b10)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // j1.a
    public String f() {
        return this.f10904c;
    }

    @Override // j1.a
    public String g() {
        return this.f10910i;
    }

    @Override // j1.a
    public String h() {
        return this.f10908g;
    }

    public int hashCode() {
        Integer num = this.f10902a;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f10903b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f10904c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10905d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f10906e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f10907f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f10908g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f10909h;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f10910i;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f10911j;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f10912k;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f10913l;
        return hashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // j1.a
    public String i() {
        return this.f10912k;
    }

    @Override // j1.a
    public String j() {
        return this.f10903b;
    }

    @Override // j1.a
    public String k() {
        return this.f10907f;
    }

    @Override // j1.a
    public String l() {
        return this.f10906e;
    }

    @Override // j1.a
    public Integer m() {
        return this.f10902a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f10902a + ", model=" + this.f10903b + ", hardware=" + this.f10904c + ", device=" + this.f10905d + ", product=" + this.f10906e + ", osBuild=" + this.f10907f + ", manufacturer=" + this.f10908g + ", fingerprint=" + this.f10909h + ", locale=" + this.f10910i + ", country=" + this.f10911j + ", mccMnc=" + this.f10912k + ", applicationBuild=" + this.f10913l + "}";
    }
}
