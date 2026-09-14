package kotlinx.coroutines.scheduling;

import nb.u0;

/* loaded from: classes.dex */
public class f extends u0 {

    /* renamed from: g, reason: collision with root package name */
    private final int f11690g;

    /* renamed from: h, reason: collision with root package name */
    private final int f11691h;

    /* renamed from: i, reason: collision with root package name */
    private final long f11692i;

    /* renamed from: j, reason: collision with root package name */
    private final String f11693j;

    /* renamed from: k, reason: collision with root package name */
    private a f11694k = c0();

    public f(int i10, int i11, long j10, String str) {
        this.f11690g = i10;
        this.f11691h = i11;
        this.f11692i = j10;
        this.f11693j = str;
    }

    private final a c0() {
        return new a(this.f11690g, this.f11691h, this.f11692i, this.f11693j);
    }

    @Override // nb.u
    public void c(p8.f fVar, Runnable runnable) {
        a.v(this.f11694k, runnable, null, false, 6, null);
    }

    public final void d0(Runnable runnable, i iVar, boolean z10) {
        this.f11694k.j(runnable, iVar, z10);
    }
}
