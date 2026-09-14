package v3;

import com.google.firebase.crashlytics.internal.common.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import v3.c;

/* loaded from: classes.dex */
class d implements v3.a {

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f14652d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final File f14653a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14654b;

    /* renamed from: c, reason: collision with root package name */
    private c f14655c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f14656a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int[] f14657b;

        a(d dVar, byte[] bArr, int[] iArr) {
            this.f14656a = bArr;
            this.f14657b = iArr;
        }

        @Override // v3.c.d
        public void a(InputStream inputStream, int i10) {
            try {
                inputStream.read(this.f14656a, this.f14657b[0], i10);
                int[] iArr = this.f14657b;
                iArr[0] = iArr[0] + i10;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f14658a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14659b;

        b(d dVar, byte[] bArr, int i10) {
            this.f14658a = bArr;
            this.f14659b = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(File file, int i10) {
        this.f14653a = file;
        this.f14654b = i10;
    }

    private void f(long j10, String str) {
        if (this.f14655c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i10 = this.f14654b / 4;
            if (str.length() > i10) {
                str = "..." + str.substring(str.length() - i10);
            }
            this.f14655c.j(String.format(Locale.US, "%d %s%n", Long.valueOf(j10), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f14652d));
            while (!this.f14655c.O() && this.f14655c.k0() > this.f14654b) {
                this.f14655c.g0();
            }
        } catch (IOException e10) {
            s3.b.f().e("There was a problem writing to the Crashlytics log.", e10);
        }
    }

    private b g() {
        if (!this.f14653a.exists()) {
            return null;
        }
        h();
        c cVar = this.f14655c;
        if (cVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[cVar.k0()];
        try {
            this.f14655c.M(new a(this, bArr, iArr));
        } catch (IOException e10) {
            s3.b.f().e("A problem occurred while reading the Crashlytics log file.", e10);
        }
        return new b(this, bArr, iArr[0]);
    }

    private void h() {
        if (this.f14655c == null) {
            try {
                this.f14655c = new c(this.f14653a);
            } catch (IOException e10) {
                s3.b.f().e("Could not open log file: " + this.f14653a, e10);
            }
        }
    }

    @Override // v3.a
    public void a() {
        h.e(this.f14655c, "There was a problem closing the Crashlytics log file.");
        this.f14655c = null;
    }

    @Override // v3.a
    public String b() {
        byte[] c10 = c();
        if (c10 != null) {
            return new String(c10, f14652d);
        }
        return null;
    }

    @Override // v3.a
    public byte[] c() {
        b g10 = g();
        if (g10 == null) {
            return null;
        }
        int i10 = g10.f14659b;
        byte[] bArr = new byte[i10];
        System.arraycopy(g10.f14658a, 0, bArr, 0, i10);
        return bArr;
    }

    @Override // v3.a
    public void d() {
        a();
        this.f14653a.delete();
    }

    @Override // v3.a
    public void e(long j10, String str) {
        h();
        f(j10, str);
    }
}
