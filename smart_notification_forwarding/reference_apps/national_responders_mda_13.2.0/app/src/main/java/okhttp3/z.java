package okhttp3;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f12902a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f12903b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f12904c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f12905d;

        a(t tVar, int i10, byte[] bArr, int i11) {
            this.f12902a = tVar;
            this.f12903b = i10;
            this.f12904c = bArr;
            this.f12905d = i11;
        }

        @Override // okhttp3.z
        public long a() {
            return this.f12903b;
        }

        @Override // okhttp3.z
        public t b() {
            return this.f12902a;
        }

        @Override // okhttp3.z
        public void g(bc.d dVar) {
            dVar.b(this.f12904c, this.f12905d, this.f12903b);
        }
    }

    /* loaded from: classes.dex */
    class b extends z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f12906a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f12907b;

        b(t tVar, File file) {
            this.f12906a = tVar;
            this.f12907b = file;
        }

        @Override // okhttp3.z
        public long a() {
            return this.f12907b.length();
        }

        @Override // okhttp3.z
        public t b() {
            return this.f12906a;
        }

        @Override // okhttp3.z
        public void g(bc.d dVar) {
            bc.s sVar = null;
            try {
                sVar = bc.l.f(this.f12907b);
                dVar.n(sVar);
            } finally {
                sb.c.g(sVar);
            }
        }
    }

    public static z c(t tVar, File file) {
        Objects.requireNonNull(file, "file == null");
        return new b(tVar, file);
    }

    public static z d(t tVar, String str) {
        Charset charset = sb.c.f14204i;
        if (tVar != null) {
            Charset a10 = tVar.a();
            if (a10 == null) {
                tVar = t.d(tVar + "; charset=utf-8");
            } else {
                charset = a10;
            }
        }
        return e(tVar, str.getBytes(charset));
    }

    public static z e(t tVar, byte[] bArr) {
        return f(tVar, bArr, 0, bArr.length);
    }

    public static z f(t tVar, byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "content == null");
        sb.c.f(bArr.length, i10, i11);
        return new a(tVar, i11, bArr, i10);
    }

    public abstract long a();

    public abstract t b();

    public abstract void g(bc.d dVar);
}
