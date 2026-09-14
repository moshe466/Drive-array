package e3;

import java.io.FilterInputStream;

/* loaded from: classes.dex */
public final class a extends d {
    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((FilterInputStream) this).in = b.f4460a;
    }
}
