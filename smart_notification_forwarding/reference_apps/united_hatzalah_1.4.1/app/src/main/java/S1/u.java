package s1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u extends AbstractC0656G {

    /* renamed from: a, reason: collision with root package name */
    public final long f6319a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6320b;

    /* renamed from: c, reason: collision with root package name */
    public final C0675o f6321c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f6322d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6323e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f6324f;

    public u(long j2, long j3, C0675o c0675o, Integer num, String str, ArrayList arrayList) {
        EnumC0660K enumC0660K = EnumC0660K.f6243a;
        this.f6319a = j2;
        this.f6320b = j3;
        this.f6321c = c0675o;
        this.f6322d = num;
        this.f6323e = str;
        this.f6324f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof AbstractC0656G) {
                u uVar = (u) ((AbstractC0656G) obj);
                if (this.f6319a == uVar.f6319a) {
                    uVar.getClass();
                    Object obj2 = EnumC0660K.f6243a;
                    ArrayList arrayList = uVar.f6324f;
                    String str = uVar.f6323e;
                    Integer num = uVar.f6322d;
                    C0675o c0675o = uVar.f6321c;
                    if (this.f6320b == uVar.f6320b && this.f6321c.equals(c0675o)) {
                        Integer num2 = this.f6322d;
                        if (num2 == null) {
                            if (num != null) {
                                return false;
                            }
                        } else if (!num2.equals(num)) {
                            return false;
                        }
                        String str2 = this.f6323e;
                        if (str2 == null) {
                            if (str != null) {
                                return false;
                            }
                        } else if (!str2.equals(str)) {
                            return false;
                        }
                        if (this.f6324f.equals(arrayList) && obj2.equals(obj2)) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        long j2 = this.f6319a;
        long j3 = this.f6320b;
        int hashCode2 = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f6321c.hashCode()) * 1000003;
        int i = 0;
        Integer num = this.f6322d;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i3 = (hashCode2 ^ hashCode) * 1000003;
        String str = this.f6323e;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((i3 ^ i) * 1000003) ^ this.f6324f.hashCode()) * 1000003) ^ EnumC0660K.f6243a.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f6319a + ", requestUptimeMs=" + this.f6320b + ", clientInfo=" + this.f6321c + ", logSource=" + this.f6322d + ", logSourceName=" + this.f6323e + ", logEvents=" + this.f6324f + ", qosTier=" + EnumC0660K.f6243a + "}";
    }
}
