package t1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f6422a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f6423b;

    /* renamed from: c, reason: collision with root package name */
    public final n f6424c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6425d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6426e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f6427f;

    /* renamed from: g, reason: collision with root package name */
    public final Integer f6428g;

    /* renamed from: h, reason: collision with root package name */
    public final String f6429h;
    public final byte[] i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f6430j;

    public j(String str, Integer num, n nVar, long j2, long j3, HashMap hashMap, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f6422a = str;
        this.f6423b = num;
        this.f6424c = nVar;
        this.f6425d = j2;
        this.f6426e = j3;
        this.f6427f = hashMap;
        this.f6428g = num2;
        this.f6429h = str2;
        this.i = bArr;
        this.f6430j = bArr2;
    }

    public final String a(String str) {
        String str2 = (String) this.f6427f.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f6427f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, t1.i] */
    public final i c() {
        ?? obj = new Object();
        String str = this.f6422a;
        if (str != null) {
            obj.f6413a = str;
            obj.f6414b = this.f6423b;
            obj.f6419g = this.f6428g;
            obj.f6420h = this.f6429h;
            obj.i = this.i;
            obj.f6421j = this.f6430j;
            n nVar = this.f6424c;
            if (nVar != null) {
                obj.f6415c = nVar;
                obj.f6416d = Long.valueOf(this.f6425d);
                obj.f6417e = Long.valueOf(this.f6426e);
                obj.f6418f = new HashMap(this.f6427f);
                return obj;
            }
            throw new NullPointerException("Null encodedPayload");
        }
        throw new NullPointerException("Null transportName");
    }

    public final boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            String str2 = jVar.f6422a;
            String str3 = jVar.f6429h;
            Integer num3 = jVar.f6428g;
            Integer num4 = jVar.f6423b;
            if (this.f6422a.equals(str2) && ((num = this.f6423b) != null ? num.equals(num4) : num4 == null) && this.f6424c.equals(jVar.f6424c) && this.f6425d == jVar.f6425d && this.f6426e == jVar.f6426e && this.f6427f.equals(jVar.f6427f) && ((num2 = this.f6428g) != null ? num2.equals(num3) : num3 == null) && ((str = this.f6429h) != null ? str.equals(str3) : str3 == null) && Arrays.equals(this.i, jVar.i) && Arrays.equals(this.f6430j, jVar.f6430j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = (this.f6422a.hashCode() ^ 1000003) * 1000003;
        int i = 0;
        Integer num = this.f6423b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode4 = (((hashCode3 ^ hashCode) * 1000003) ^ this.f6424c.hashCode()) * 1000003;
        long j2 = this.f6425d;
        int i3 = (hashCode4 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f6426e;
        int hashCode5 = (((i3 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f6427f.hashCode()) * 1000003;
        Integer num2 = this.f6428g;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i4 = (hashCode5 ^ hashCode2) * 1000003;
        String str = this.f6429h;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((i4 ^ i) * 1000003) ^ Arrays.hashCode(this.i)) * 1000003) ^ Arrays.hashCode(this.f6430j);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f6422a + ", code=" + this.f6423b + ", encodedPayload=" + this.f6424c + ", eventMillis=" + this.f6425d + ", uptimeMillis=" + this.f6426e + ", autoMetadata=" + this.f6427f + ", productId=" + this.f6428g + ", pseudonymousId=" + this.f6429h + ", experimentIdsClear=" + Arrays.toString(this.i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f6430j) + "}";
    }
}
