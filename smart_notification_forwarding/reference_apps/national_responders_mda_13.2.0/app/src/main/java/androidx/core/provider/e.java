package androidx.core.provider;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f2436a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2437b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2438c;

    /* renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f2439d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2440e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f2441f;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2436a = (String) androidx.core.util.h.f(str);
        this.f2437b = (String) androidx.core.util.h.f(str2);
        this.f2438c = (String) androidx.core.util.h.f(str3);
        this.f2439d = (List) androidx.core.util.h.f(list);
        this.f2441f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f2439d;
    }

    public int c() {
        return this.f2440e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f2441f;
    }

    public String e() {
        return this.f2436a;
    }

    public String f() {
        return this.f2437b;
    }

    public String g() {
        return this.f2438c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f2436a + ", mProviderPackage: " + this.f2437b + ", mQuery: " + this.f2438c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f2439d.size(); i10++) {
            sb2.append(" [");
            List<byte[]> list = this.f2439d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f2440e);
        return sb2.toString();
    }
}
