package J0;

import F0.AbstractC0008a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1040a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1041b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1042c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1043d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1044e;

    public b(String str, String str2, String str3, String str4, String str5) {
        this.f1040a = str;
        this.f1041b = str2;
        this.f1042c = str3;
        this.f1043d = str4;
        this.f1044e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (j.a(this.f1040a, bVar.f1040a) && j.a(this.f1041b, bVar.f1041b) && j.a(this.f1042c, bVar.f1042c) && j.a(this.f1043d, bVar.f1043d) && j.a(this.f1044e, bVar.f1044e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = this.f1040a.hashCode() * 31;
        int i = 0;
        String str = this.f1041b;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = (hashCode4 + hashCode) * 31;
        String str2 = this.f1042c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i4 = (i3 + hashCode2) * 31;
        String str3 = this.f1043d;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i5 = (i4 + hashCode3) * 31;
        String str4 = this.f1044e;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i5 + i;
    }

    public final String toString() {
        StringBuilder y = AbstractC0008a.y("PackageInfo(packageName=", this.f1040a, ", appIcon=", this.f1041b, ", appName=");
        y.append(this.f1042c);
        y.append(", version=");
        y.append(this.f1043d);
        y.append(", installerStore=");
        return AbstractC0008a.u(y, this.f1044e, ")");
    }
}
