package f3;

import J.C0119g;
import J0.d;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class b extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final int f4614a = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: b, reason: collision with root package name */
    public final d3.a f4615b;

    /* renamed from: c, reason: collision with root package name */
    public final d3.b f4616c;

    /* renamed from: d, reason: collision with root package name */
    public long f4617d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4618e;

    public b(C0119g c0119g, d dVar) {
        this.f4615b = c0119g;
        this.f4616c = dVar;
    }

    public final void a(int i) {
        if (!this.f4618e && this.f4617d + i > this.f4614a) {
            this.f4618e = true;
            this.f4615b.accept(this);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
        } catch (IOException unused) {
        }
        ((OutputStream) this.f4616c.b(this)).close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        ((OutputStream) this.f4616c.b(this)).flush();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        a(bArr.length);
        ((OutputStream) this.f4616c.b(this)).write(bArr);
        this.f4617d += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i3) {
        a(i3);
        ((OutputStream) this.f4616c.b(this)).write(bArr, i, i3);
        this.f4617d += i3;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        a(1);
        ((OutputStream) this.f4616c.b(this)).write(i);
        this.f4617d++;
    }
}
