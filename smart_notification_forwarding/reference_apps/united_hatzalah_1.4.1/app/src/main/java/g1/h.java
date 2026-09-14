package g1;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f4693a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4694b;

    public h(String str, String vendor) {
        kotlin.jvm.internal.j.e(vendor, "vendor");
        this.f4693a = str;
        this.f4694b = vendor;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (kotlin.jvm.internal.j.a(this.f4693a, hVar.f4693a) && kotlin.jvm.internal.j.a(this.f4694b, hVar.f4694b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f4694b.hashCode() + (this.f4693a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InputDeviceData(name=");
        sb.append(this.f4693a);
        sb.append(", vendor=");
        return AbstractC0008a.s(sb, this.f4694b, ')');
    }
}
