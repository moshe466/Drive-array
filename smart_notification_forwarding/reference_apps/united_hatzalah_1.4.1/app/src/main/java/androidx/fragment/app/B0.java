package androidx.fragment.app;

import java.io.Writer;

/* loaded from: classes.dex */
public final class B0 extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f3261a = new StringBuilder(128);

    public final void a() {
        StringBuilder sb = this.f3261a;
        if (sb.length() > 0) {
            sb.toString();
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c4 = cArr[i + i4];
            if (c4 == '\n') {
                a();
            } else {
                this.f3261a.append(c4);
            }
        }
    }
}
