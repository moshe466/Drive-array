package s1;

import F0.AbstractC0008a;

/* renamed from: s1.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0673m extends AbstractC0661a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6293a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6294b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6295c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6296d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6297e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6298f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6299g;

    /* renamed from: h, reason: collision with root package name */
    public final String f6300h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final String f6301j;

    /* renamed from: k, reason: collision with root package name */
    public final String f6302k;

    /* renamed from: l, reason: collision with root package name */
    public final String f6303l;

    public C0673m(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f6293a = num;
        this.f6294b = str;
        this.f6295c = str2;
        this.f6296d = str3;
        this.f6297e = str4;
        this.f6298f = str5;
        this.f6299g = str6;
        this.f6300h = str7;
        this.i = str8;
        this.f6301j = str9;
        this.f6302k = str10;
        this.f6303l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0661a) {
            AbstractC0661a abstractC0661a = (AbstractC0661a) obj;
            Integer num = this.f6293a;
            if (num != null ? num.equals(((C0673m) abstractC0661a).f6293a) : ((C0673m) abstractC0661a).f6293a == null) {
                String str = this.f6294b;
                if (str != null ? str.equals(((C0673m) abstractC0661a).f6294b) : ((C0673m) abstractC0661a).f6294b == null) {
                    String str2 = this.f6295c;
                    if (str2 != null ? str2.equals(((C0673m) abstractC0661a).f6295c) : ((C0673m) abstractC0661a).f6295c == null) {
                        String str3 = this.f6296d;
                        if (str3 != null ? str3.equals(((C0673m) abstractC0661a).f6296d) : ((C0673m) abstractC0661a).f6296d == null) {
                            String str4 = this.f6297e;
                            if (str4 != null ? str4.equals(((C0673m) abstractC0661a).f6297e) : ((C0673m) abstractC0661a).f6297e == null) {
                                String str5 = this.f6298f;
                                if (str5 != null ? str5.equals(((C0673m) abstractC0661a).f6298f) : ((C0673m) abstractC0661a).f6298f == null) {
                                    String str6 = this.f6299g;
                                    if (str6 != null ? str6.equals(((C0673m) abstractC0661a).f6299g) : ((C0673m) abstractC0661a).f6299g == null) {
                                        String str7 = this.f6300h;
                                        if (str7 != null ? str7.equals(((C0673m) abstractC0661a).f6300h) : ((C0673m) abstractC0661a).f6300h == null) {
                                            String str8 = this.i;
                                            if (str8 != null ? str8.equals(((C0673m) abstractC0661a).i) : ((C0673m) abstractC0661a).i == null) {
                                                String str9 = this.f6301j;
                                                if (str9 != null ? str9.equals(((C0673m) abstractC0661a).f6301j) : ((C0673m) abstractC0661a).f6301j == null) {
                                                    String str10 = this.f6302k;
                                                    if (str10 != null ? str10.equals(((C0673m) abstractC0661a).f6302k) : ((C0673m) abstractC0661a).f6302k == null) {
                                                        String str11 = this.f6303l;
                                                        if (str11 != null ? str11.equals(((C0673m) abstractC0661a).f6303l) : ((C0673m) abstractC0661a).f6303l == null) {
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
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int i = 0;
        Integer num = this.f6293a;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i3 = (hashCode ^ 1000003) * 1000003;
        String str = this.f6294b;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i4 = (i3 ^ hashCode2) * 1000003;
        String str2 = this.f6295c;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i5 = (i4 ^ hashCode3) * 1000003;
        String str3 = this.f6296d;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i6 = (i5 ^ hashCode4) * 1000003;
        String str4 = this.f6297e;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int i7 = (i6 ^ hashCode5) * 1000003;
        String str5 = this.f6298f;
        if (str5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str5.hashCode();
        }
        int i8 = (i7 ^ hashCode6) * 1000003;
        String str6 = this.f6299g;
        if (str6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str6.hashCode();
        }
        int i9 = (i8 ^ hashCode7) * 1000003;
        String str7 = this.f6300h;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int i10 = (i9 ^ hashCode8) * 1000003;
        String str8 = this.i;
        if (str8 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str8.hashCode();
        }
        int i11 = (i10 ^ hashCode9) * 1000003;
        String str9 = this.f6301j;
        if (str9 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str9.hashCode();
        }
        int i12 = (i11 ^ hashCode10) * 1000003;
        String str10 = this.f6302k;
        if (str10 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str10.hashCode();
        }
        int i13 = (i12 ^ hashCode11) * 1000003;
        String str11 = this.f6303l;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return i ^ i13;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f6293a);
        sb.append(", model=");
        sb.append(this.f6294b);
        sb.append(", hardware=");
        sb.append(this.f6295c);
        sb.append(", device=");
        sb.append(this.f6296d);
        sb.append(", product=");
        sb.append(this.f6297e);
        sb.append(", osBuild=");
        sb.append(this.f6298f);
        sb.append(", manufacturer=");
        sb.append(this.f6299g);
        sb.append(", fingerprint=");
        sb.append(this.f6300h);
        sb.append(", locale=");
        sb.append(this.i);
        sb.append(", country=");
        sb.append(this.f6301j);
        sb.append(", mccMnc=");
        sb.append(this.f6302k);
        sb.append(", applicationBuild=");
        return AbstractC0008a.u(sb, this.f6303l, "}");
    }
}
