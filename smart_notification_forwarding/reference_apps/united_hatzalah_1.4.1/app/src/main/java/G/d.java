package G;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f771a;

    /* renamed from: b, reason: collision with root package name */
    public final String f772b;

    /* renamed from: c, reason: collision with root package name */
    public final String f773c;

    /* renamed from: d, reason: collision with root package name */
    public final List f774d;

    /* renamed from: e, reason: collision with root package name */
    public final String f775e;

    /* renamed from: f, reason: collision with root package name */
    public final String f776f;

    /* renamed from: g, reason: collision with root package name */
    public final String f777g;

    public d(String str, String str2, String str3, List list, String str4, String str5) {
        str.getClass();
        this.f771a = str;
        str2.getClass();
        this.f772b = str2;
        this.f773c = str3;
        list.getClass();
        this.f774d = list;
        this.f775e = str4;
        this.f776f = str5;
        this.f777g = str + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f771a + ", mProviderPackage: " + this.f772b + ", mQuery: " + this.f773c + ", mSystemFont: " + this.f775e + ", mVariationSettings: " + this.f776f + ", mCertificates:");
        int i = 0;
        while (true) {
            List list = this.f774d;
            if (i < list.size()) {
                sb.append(" [");
                List list2 = (List) list.get(i);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    sb.append(" \"");
                    sb.append(Base64.encodeToString((byte[]) list2.get(i3), 0));
                    sb.append("\"");
                }
                sb.append(" ]");
                i++;
            } else {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
        }
    }
}
