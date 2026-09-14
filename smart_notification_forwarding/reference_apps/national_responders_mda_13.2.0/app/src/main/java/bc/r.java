package bc;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface r extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    t e();

    void flush();

    void l(c cVar, long j10);
}
