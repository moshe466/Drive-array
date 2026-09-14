package R;

import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class m0 extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final FileOutputStream f1923a;

    public m0(FileOutputStream fileOutputStream) {
        this.f1923a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f1923a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f1923a.write(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] b4) {
        kotlin.jvm.internal.j.e(b4, "b");
        this.f1923a.write(b4);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bytes, int i, int i3) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        this.f1923a.write(bytes, i, i3);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
