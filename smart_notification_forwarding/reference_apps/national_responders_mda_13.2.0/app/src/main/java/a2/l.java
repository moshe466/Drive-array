package a2;

import a2.j;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class l<R extends j> implements k<R> {
    @Override // a2.k
    public final void a(R r10) {
        Status c10 = r10.c();
        if (c10.t()) {
            c(r10);
            return;
        }
        b(c10);
        if (r10 instanceof h) {
            try {
                ((h) r10).a();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(r10));
            }
        }
    }

    public abstract void b(Status status);

    public abstract void c(R r10);
}
