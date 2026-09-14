package V;

import android.os.Trace;

/* loaded from: classes.dex */
public final class o implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        try {
            int i = F.h.f164a;
            Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
            if (k.f2396j != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                k.a().c();
            }
            Trace.endSection();
        } catch (Throwable th) {
            int i3 = F.h.f164a;
            Trace.endSection();
            throw th;
        }
    }
}
