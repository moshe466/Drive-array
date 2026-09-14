package v9;

import java.util.EnumMap;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final EnumMap<a, s> f14810a;

    public w(EnumMap<a, s> enumMap) {
        y8.k.e(enumMap, "defaultQualifiers");
        this.f14810a = enumMap;
    }

    public final s a(a aVar) {
        return this.f14810a.get(aVar);
    }

    public final EnumMap<a, s> b() {
        return this.f14810a;
    }
}
