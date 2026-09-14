package kotlinx.coroutines.internal;

import nb.i1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends i1 implements nb.h0 {

    /* renamed from: g, reason: collision with root package name */
    private final Throwable f11662g;

    /* renamed from: h, reason: collision with root package name */
    private final String f11663h;

    public v(Throwable th, String str) {
        this.f11662g = th;
        this.f11663h = str;
    }

    private final Void f0() {
        String j10;
        if (this.f11662g == null) {
            u.d();
            throw new l8.e();
        }
        String str = this.f11663h;
        String str2 = "";
        if (str != null && (j10 = y8.k.j(". ", str)) != null) {
            str2 = j10;
        }
        throw new IllegalStateException(y8.k.j("Module with the Main dispatcher had failed to initialize", str2), this.f11662g);
    }

    @Override // nb.u
    public boolean a0(p8.f fVar) {
        f0();
        throw new l8.e();
    }

    @Override // nb.i1
    public i1 c0() {
        return this;
    }

    @Override // nb.u
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public Void c(p8.f fVar, Runnable runnable) {
        f0();
        throw new l8.e();
    }

    @Override // nb.i1, nb.u
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Dispatchers.Main[missing");
        Throwable th = this.f11662g;
        sb2.append(th != null ? y8.k.j(", cause=", th) : "");
        sb2.append(']');
        return sb2.toString();
    }
}
