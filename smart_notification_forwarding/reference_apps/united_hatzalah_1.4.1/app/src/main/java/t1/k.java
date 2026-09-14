package t1;

import F0.AbstractC0008a;
import F0.C0110z2;
import android.util.Base64;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f6431a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f6432b;

    /* renamed from: c, reason: collision with root package name */
    public final q1.d f6433c;

    public k(String str, byte[] bArr, q1.d dVar) {
        this.f6431a = str;
        this.f6432b = bArr;
        this.f6433c = dVar;
    }

    public static C0110z2 a() {
        C0110z2 c0110z2 = new C0110z2(13);
        c0110z2.f731d = q1.d.f6150a;
        return c0110z2;
    }

    public final k b(q1.d dVar) {
        C0110z2 a2 = a();
        a2.v(this.f6431a);
        if (dVar != null) {
            a2.f731d = dVar;
            a2.f730c = this.f6432b;
            return a2.g();
        }
        throw new NullPointerException("Null priority");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f6431a.equals(kVar.f6431a) && Arrays.equals(this.f6432b, kVar.f6432b) && this.f6433c.equals(kVar.f6433c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f6431a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6432b)) * 1000003) ^ this.f6433c.hashCode();
    }

    public final String toString() {
        String encodeToString;
        byte[] bArr = this.f6432b;
        if (bArr == null) {
            encodeToString = "";
        } else {
            encodeToString = Base64.encodeToString(bArr, 2);
        }
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(this.f6431a);
        sb.append(", ");
        sb.append(this.f6433c);
        sb.append(", ");
        return AbstractC0008a.u(sb, encodeToString, ")");
    }
}
