package vb;

import okhttp3.b0;
import okhttp3.t;

/* loaded from: classes.dex */
public final class h extends b0 {

    /* renamed from: f, reason: collision with root package name */
    private final String f14868f;

    /* renamed from: g, reason: collision with root package name */
    private final long f14869g;

    /* renamed from: h, reason: collision with root package name */
    private final bc.e f14870h;

    public h(String str, long j10, bc.e eVar) {
        this.f14868f = str;
        this.f14869g = j10;
        this.f14870h = eVar;
    }

    @Override // okhttp3.b0
    public long d() {
        return this.f14869g;
    }

    @Override // okhttp3.b0
    public t f() {
        String str = this.f14868f;
        if (str != null) {
            return t.d(str);
        }
        return null;
    }

    @Override // okhttp3.b0
    public bc.e v() {
        return this.f14870h;
    }
}
