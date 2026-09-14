package p2;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f13042a = Logger.getLogger(h.class.getName());

    private h() {
    }

    public static void a(@NullableDecl InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e10) {
            try {
                f13042a.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", (Throwable) e10);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
