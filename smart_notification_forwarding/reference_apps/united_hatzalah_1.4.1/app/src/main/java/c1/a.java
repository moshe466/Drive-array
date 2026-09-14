package c1;

import F0.AbstractC0008a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f3863a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3864b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3865c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3866d;

    public a(String deviceId, String str, String androidId, String str2) {
        j.e(deviceId, "deviceId");
        j.e(androidId, "androidId");
        this.f3863a = deviceId;
        this.f3864b = str;
        this.f3865c = androidId;
        this.f3866d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (j.a(this.f3863a, aVar.f3863a) && j.a(this.f3864b, aVar.f3864b) && j.a(this.f3865c, aVar.f3865c) && j.a(this.f3866d, aVar.f3866d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f3866d.hashCode() + AbstractC0008a.g(this.f3865c, AbstractC0008a.g(this.f3864b, this.f3863a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceIdResult(deviceId=");
        sb.append(this.f3863a);
        sb.append(", gsfId=");
        sb.append(this.f3864b);
        sb.append(", androidId=");
        sb.append(this.f3865c);
        sb.append(", mediaDrmId=");
        return AbstractC0008a.s(sb, this.f3866d, ')');
    }
}
