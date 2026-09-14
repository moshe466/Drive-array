package q;

import android.os.CancellationSignal;

/* renamed from: q.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0603C {
    public static void a(CancellationSignal cancellationSignal) {
        cancellationSignal.cancel();
    }

    public static CancellationSignal b() {
        return new CancellationSignal();
    }
}
