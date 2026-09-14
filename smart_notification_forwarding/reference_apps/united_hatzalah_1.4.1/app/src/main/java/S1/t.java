package s1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class t extends AbstractC0655F {

    /* renamed from: a, reason: collision with root package name */
    public final long f6311a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f6312b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0651B f6313c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6314d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f6315e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6316f;

    /* renamed from: g, reason: collision with root package name */
    public final long f6317g;

    /* renamed from: h, reason: collision with root package name */
    public final AbstractC0659J f6318h;
    public final AbstractC0652C i;

    public t(long j2, Integer num, AbstractC0651B abstractC0651B, long j3, byte[] bArr, String str, long j4, AbstractC0659J abstractC0659J, AbstractC0652C abstractC0652C) {
        this.f6311a = j2;
        this.f6312b = num;
        this.f6313c = abstractC0651B;
        this.f6314d = j3;
        this.f6315e = bArr;
        this.f6316f = str;
        this.f6317g = j4;
        this.f6318h = abstractC0659J;
        this.i = abstractC0652C;
    }

    public final boolean equals(Object obj) {
        Integer num;
        AbstractC0651B abstractC0651B;
        byte[] bArr;
        String str;
        AbstractC0659J abstractC0659J;
        AbstractC0652C abstractC0652C;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0655F) {
            AbstractC0655F abstractC0655F = (AbstractC0655F) obj;
            if (this.f6311a == ((t) abstractC0655F).f6311a && ((num = this.f6312b) != null ? num.equals(((t) abstractC0655F).f6312b) : ((t) abstractC0655F).f6312b == null) && ((abstractC0651B = this.f6313c) != null ? abstractC0651B.equals(((t) abstractC0655F).f6313c) : ((t) abstractC0655F).f6313c == null)) {
                t tVar = (t) abstractC0655F;
                AbstractC0652C abstractC0652C2 = tVar.i;
                AbstractC0659J abstractC0659J2 = tVar.f6318h;
                String str2 = tVar.f6316f;
                if (this.f6314d == tVar.f6314d) {
                    if (abstractC0655F instanceof t) {
                        bArr = ((t) abstractC0655F).f6315e;
                    } else {
                        bArr = tVar.f6315e;
                    }
                    if (Arrays.equals(this.f6315e, bArr) && ((str = this.f6316f) != null ? str.equals(str2) : str2 == null) && this.f6317g == tVar.f6317g && ((abstractC0659J = this.f6318h) != null ? abstractC0659J.equals(abstractC0659J2) : abstractC0659J2 == null) && ((abstractC0652C = this.i) != null ? abstractC0652C.equals(abstractC0652C2) : abstractC0652C2 == null)) {
                        return true;
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
        long j2 = this.f6311a;
        int i = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        int i3 = 0;
        Integer num = this.f6312b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i4 = (i ^ hashCode) * 1000003;
        AbstractC0651B abstractC0651B = this.f6313c;
        if (abstractC0651B == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = abstractC0651B.hashCode();
        }
        int i5 = (i4 ^ hashCode2) * 1000003;
        long j3 = this.f6314d;
        int hashCode5 = (((i5 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f6315e)) * 1000003;
        String str = this.f6316f;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int i6 = (hashCode5 ^ hashCode3) * 1000003;
        long j4 = this.f6317g;
        int i7 = (i6 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        AbstractC0659J abstractC0659J = this.f6318h;
        if (abstractC0659J == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = abstractC0659J.hashCode();
        }
        int i8 = (i7 ^ hashCode4) * 1000003;
        AbstractC0652C abstractC0652C = this.i;
        if (abstractC0652C != null) {
            i3 = abstractC0652C.hashCode();
        }
        return i8 ^ i3;
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f6311a + ", eventCode=" + this.f6312b + ", complianceData=" + this.f6313c + ", eventUptimeMs=" + this.f6314d + ", sourceExtension=" + Arrays.toString(this.f6315e) + ", sourceExtensionJsonProto3=" + this.f6316f + ", timezoneOffsetSeconds=" + this.f6317g + ", networkConnectionInfo=" + this.f6318h + ", experimentIds=" + this.i + "}";
    }
}
