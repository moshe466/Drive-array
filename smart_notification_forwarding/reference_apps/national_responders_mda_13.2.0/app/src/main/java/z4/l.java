package z4;

import a5.n;
import com.google.gson.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public final class l {

    /* loaded from: classes.dex */
    private static final class a extends Writer {

        /* renamed from: f, reason: collision with root package name */
        private final Appendable f16215f;

        /* renamed from: g, reason: collision with root package name */
        private final C0343a f16216g = new C0343a();

        /* renamed from: z4.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0343a implements CharSequence {

            /* renamed from: f, reason: collision with root package name */
            char[] f16217f;

            C0343a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f16217f[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f16217f.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f16217f, i10, i11 - i10);
            }
        }

        a(Appendable appendable) {
            this.f16215f = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i10) {
            this.f16215f.append((char) i10);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            C0343a c0343a = this.f16216g;
            c0343a.f16217f = cArr;
            this.f16215f.append(c0343a, i10, i11 + i10);
        }
    }

    public static com.google.gson.k a(f5.a aVar) {
        boolean z10;
        try {
            try {
                aVar.m0();
                z10 = false;
            } catch (EOFException e10) {
                e = e10;
                z10 = true;
            }
            try {
                return n.U.b(aVar);
            } catch (EOFException e11) {
                e = e11;
                if (z10) {
                    return com.google.gson.m.f7516a;
                }
                throw new t(e);
            }
        } catch (f5.d e12) {
            throw new t(e12);
        } catch (IOException e13) {
            throw new com.google.gson.l(e13);
        } catch (NumberFormatException e14) {
            throw new t(e14);
        }
    }

    public static void b(com.google.gson.k kVar, f5.c cVar) {
        n.U.d(cVar, kVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
