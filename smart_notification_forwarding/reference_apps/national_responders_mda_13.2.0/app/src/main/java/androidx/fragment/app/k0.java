package androidx.fragment.app;

import java.io.Writer;

/* loaded from: classes.dex */
final class k0 extends Writer {

    /* renamed from: f, reason: collision with root package name */
    private final String f3059f;

    /* renamed from: g, reason: collision with root package name */
    private StringBuilder f3060g = new StringBuilder(128);

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(String str) {
        this.f3059f = str;
    }

    private void c() {
        if (this.f3060g.length() > 0) {
            this.f3060g.toString();
            StringBuilder sb2 = this.f3060g;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        c();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                c();
            } else {
                this.f3060g.append(c10);
            }
        }
    }
}
