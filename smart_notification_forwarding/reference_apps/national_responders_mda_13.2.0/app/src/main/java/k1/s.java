package k1;

import android.content.Context;
import java.io.Closeable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class s implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        a a(Context context);

        s c();
    }

    abstract r1.c c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c().close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract r d();
}
