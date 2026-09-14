package t8;

import y8.k;

/* loaded from: classes.dex */
public class a extends s8.a {
    @Override // s8.a
    public void a(Throwable th, Throwable th2) {
        k.e(th, "cause");
        k.e(th2, "exception");
        th.addSuppressed(th2);
    }
}
