package g1;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f4665a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4666b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4667c;

    public b(String cameraName, String str, String cameraOrientation) {
        kotlin.jvm.internal.j.e(cameraName, "cameraName");
        kotlin.jvm.internal.j.e(cameraOrientation, "cameraOrientation");
        this.f4665a = cameraName;
        this.f4666b = str;
        this.f4667c = cameraOrientation;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (kotlin.jvm.internal.j.a(this.f4665a, bVar.f4665a) && kotlin.jvm.internal.j.a(this.f4666b, bVar.f4666b) && kotlin.jvm.internal.j.a(this.f4667c, bVar.f4667c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f4667c.hashCode() + AbstractC0008a.g(this.f4666b, this.f4665a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CameraInfo(cameraName=");
        sb.append(this.f4665a);
        sb.append(", cameraType=");
        sb.append(this.f4666b);
        sb.append(", cameraOrientation=");
        return AbstractC0008a.s(sb, this.f4667c, ')');
    }
}
