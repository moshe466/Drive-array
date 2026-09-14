package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* loaded from: classes.dex */
public abstract class a implements q {

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0232a<BuilderType extends AbstractC0232a> implements q.a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0233a extends FilterInputStream {

            /* renamed from: f, reason: collision with root package name */
            private int f11377f;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0233a(InputStream inputStream, int i10) {
                super(inputStream);
                this.f11377f = i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f11377f);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.f11377f <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f11377f--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) {
                int i12 = this.f11377f;
                if (i12 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i10, Math.min(i11, i12));
                if (read >= 0) {
                    this.f11377f -= read;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j10) {
                long skip = super.skip(Math.min(j10, this.f11377f));
                if (skip >= 0) {
                    this.f11377f = (int) (this.f11377f - skip);
                }
                return skip;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static w m(q qVar) {
            return new w(qVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        public abstract BuilderType l(e eVar, g gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w f() {
        return new w(this);
    }

    public void g(OutputStream outputStream) {
        int a10 = a();
        f J = f.J(outputStream, f.u(f.v(a10) + a10));
        J.o0(a10);
        e(J);
        J.I();
    }
}
