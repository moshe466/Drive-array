package v3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Closeable {

    /* renamed from: l, reason: collision with root package name */
    private static final Logger f14637l = Logger.getLogger(c.class.getName());

    /* renamed from: f, reason: collision with root package name */
    private final RandomAccessFile f14638f;

    /* renamed from: g, reason: collision with root package name */
    int f14639g;

    /* renamed from: h, reason: collision with root package name */
    private int f14640h;

    /* renamed from: i, reason: collision with root package name */
    private b f14641i;

    /* renamed from: j, reason: collision with root package name */
    private b f14642j;

    /* renamed from: k, reason: collision with root package name */
    private final byte[] f14643k = new byte[16];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        boolean f14644a = true;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f14645b;

        a(c cVar, StringBuilder sb2) {
            this.f14645b = sb2;
        }

        @Override // v3.c.d
        public void a(InputStream inputStream, int i10) {
            if (this.f14644a) {
                this.f14644a = false;
            } else {
                this.f14645b.append(", ");
            }
            this.f14645b.append(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        static final b f14646c = new b(0, 0);

        /* renamed from: a, reason: collision with root package name */
        final int f14647a;

        /* renamed from: b, reason: collision with root package name */
        final int f14648b;

        b(int i10, int i11) {
            this.f14647a = i10;
            this.f14648b = i11;
        }

        public String toString() {
            return b.class.getSimpleName() + "[position = " + this.f14647a + ", length = " + this.f14648b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v3.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0302c extends InputStream {

        /* renamed from: f, reason: collision with root package name */
        private int f14649f;

        /* renamed from: g, reason: collision with root package name */
        private int f14650g;

        private C0302c(b bVar) {
            this.f14649f = c.this.l0(bVar.f14647a + 4);
            this.f14650g = bVar.f14648b;
        }

        /* synthetic */ C0302c(c cVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f14650g == 0) {
                return -1;
            }
            c.this.f14638f.seek(this.f14649f);
            int read = c.this.f14638f.read();
            this.f14649f = c.this.l0(this.f14649f + 1);
            this.f14650g--;
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            c.a0(bArr, "buffer");
            if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i12 = this.f14650g;
            if (i12 <= 0) {
                return -1;
            }
            if (i11 > i12) {
                i11 = i12;
            }
            c.this.h0(this.f14649f, bArr, i10, i11);
            this.f14649f = c.this.l0(this.f14649f + i11);
            this.f14650g -= i11;
            return i11;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(InputStream inputStream, int i10);
    }

    public c(File file) {
        if (!file.exists()) {
            N(file);
        }
        this.f14638f = b0(file);
        d0();
    }

    private void H(int i10) {
        int i11 = i10 + 4;
        int f02 = f0();
        if (f02 >= i11) {
            return;
        }
        int i12 = this.f14639g;
        do {
            f02 += i12;
            i12 <<= 1;
        } while (f02 < i11);
        j0(i12);
        b bVar = this.f14642j;
        int l02 = l0(bVar.f14647a + 4 + bVar.f14648b);
        if (l02 < this.f14641i.f14647a) {
            FileChannel channel = this.f14638f.getChannel();
            channel.position(this.f14639g);
            long j10 = l02 - 4;
            if (channel.transferTo(16L, j10, channel) != j10) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i13 = this.f14642j.f14647a;
        int i14 = this.f14641i.f14647a;
        if (i13 < i14) {
            int i15 = (this.f14639g + i13) - 16;
            m0(i12, this.f14640h, i14, i15);
            this.f14642j = new b(i15, this.f14642j.f14648b);
        } else {
            m0(i12, this.f14640h, i14, i13);
        }
        this.f14639g = i12;
    }

    private static void N(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b02 = b0(file2);
        try {
            b02.setLength(4096L);
            b02.seek(0L);
            byte[] bArr = new byte[16];
            o0(bArr, 4096, 0, 0, 0);
            b02.write(bArr);
            b02.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            b02.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T a0(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    private static RandomAccessFile b0(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private b c0(int i10) {
        if (i10 == 0) {
            return b.f14646c;
        }
        this.f14638f.seek(i10);
        return new b(i10, this.f14638f.readInt());
    }

    private void d0() {
        this.f14638f.seek(0L);
        this.f14638f.readFully(this.f14643k);
        int e02 = e0(this.f14643k, 0);
        this.f14639g = e02;
        if (e02 <= this.f14638f.length()) {
            this.f14640h = e0(this.f14643k, 4);
            int e03 = e0(this.f14643k, 8);
            int e04 = e0(this.f14643k, 12);
            this.f14641i = c0(e03);
            this.f14642j = c0(e04);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f14639g + ", Actual length: " + this.f14638f.length());
    }

    private static int e0(byte[] bArr, int i10) {
        return ((bArr[i10] & 255) << 24) + ((bArr[i10 + 1] & 255) << 16) + ((bArr[i10 + 2] & 255) << 8) + (bArr[i10 + 3] & 255);
    }

    private int f0() {
        return this.f14639g - k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(int i10, byte[] bArr, int i11, int i12) {
        RandomAccessFile randomAccessFile;
        int l02 = l0(i10);
        int i13 = l02 + i12;
        int i14 = this.f14639g;
        if (i13 <= i14) {
            this.f14638f.seek(l02);
            randomAccessFile = this.f14638f;
        } else {
            int i15 = i14 - l02;
            this.f14638f.seek(l02);
            this.f14638f.readFully(bArr, i11, i15);
            this.f14638f.seek(16L);
            randomAccessFile = this.f14638f;
            i11 += i15;
            i12 -= i15;
        }
        randomAccessFile.readFully(bArr, i11, i12);
    }

    private void i0(int i10, byte[] bArr, int i11, int i12) {
        RandomAccessFile randomAccessFile;
        int l02 = l0(i10);
        int i13 = l02 + i12;
        int i14 = this.f14639g;
        if (i13 <= i14) {
            this.f14638f.seek(l02);
            randomAccessFile = this.f14638f;
        } else {
            int i15 = i14 - l02;
            this.f14638f.seek(l02);
            this.f14638f.write(bArr, i11, i15);
            this.f14638f.seek(16L);
            randomAccessFile = this.f14638f;
            i11 += i15;
            i12 -= i15;
        }
        randomAccessFile.write(bArr, i11, i12);
    }

    private void j0(int i10) {
        this.f14638f.setLength(i10);
        this.f14638f.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l0(int i10) {
        int i11 = this.f14639g;
        return i10 < i11 ? i10 : (i10 + 16) - i11;
    }

    private void m0(int i10, int i11, int i12, int i13) {
        o0(this.f14643k, i10, i11, i12, i13);
        this.f14638f.seek(0L);
        this.f14638f.write(this.f14643k);
    }

    private static void n0(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >> 24);
        bArr[i10 + 1] = (byte) (i11 >> 16);
        bArr[i10 + 2] = (byte) (i11 >> 8);
        bArr[i10 + 3] = (byte) i11;
    }

    private static void o0(byte[] bArr, int... iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            n0(bArr, i10, i11);
            i10 += 4;
        }
    }

    public synchronized void D() {
        m0(4096, 0, 0, 0);
        this.f14640h = 0;
        b bVar = b.f14646c;
        this.f14641i = bVar;
        this.f14642j = bVar;
        if (this.f14639g > 4096) {
            j0(4096);
        }
        this.f14639g = 4096;
    }

    public synchronized void M(d dVar) {
        int i10 = this.f14641i.f14647a;
        for (int i11 = 0; i11 < this.f14640h; i11++) {
            b c02 = c0(i10);
            dVar.a(new C0302c(this, c02, null), c02.f14648b);
            i10 = l0(c02.f14647a + 4 + c02.f14648b);
        }
    }

    public synchronized boolean O() {
        return this.f14640h == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f14638f.close();
    }

    public synchronized void g0() {
        if (O()) {
            throw new NoSuchElementException();
        }
        if (this.f14640h == 1) {
            D();
        } else {
            b bVar = this.f14641i;
            int l02 = l0(bVar.f14647a + 4 + bVar.f14648b);
            h0(l02, this.f14643k, 0, 4);
            int e02 = e0(this.f14643k, 0);
            m0(this.f14639g, this.f14640h - 1, l02, this.f14642j.f14647a);
            this.f14640h--;
            this.f14641i = new b(l02, e02);
        }
    }

    public void j(byte[] bArr) {
        v(bArr, 0, bArr.length);
    }

    public int k0() {
        if (this.f14640h == 0) {
            return 16;
        }
        b bVar = this.f14642j;
        int i10 = bVar.f14647a;
        int i11 = this.f14641i.f14647a;
        return i10 >= i11 ? (i10 - i11) + 4 + bVar.f14648b + 16 : (((i10 + 4) + bVar.f14648b) + this.f14639g) - i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c.class.getSimpleName());
        sb2.append('[');
        sb2.append("fileLength=");
        sb2.append(this.f14639g);
        sb2.append(", size=");
        sb2.append(this.f14640h);
        sb2.append(", first=");
        sb2.append(this.f14641i);
        sb2.append(", last=");
        sb2.append(this.f14642j);
        sb2.append(", element lengths=[");
        try {
            M(new a(this, sb2));
        } catch (IOException e10) {
            f14637l.log(Level.WARNING, "read error", (Throwable) e10);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public synchronized void v(byte[] bArr, int i10, int i11) {
        int l02;
        a0(bArr, "buffer");
        if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
            throw new IndexOutOfBoundsException();
        }
        H(i11);
        boolean O = O();
        if (O) {
            l02 = 16;
        } else {
            b bVar = this.f14642j;
            l02 = l0(bVar.f14647a + 4 + bVar.f14648b);
        }
        b bVar2 = new b(l02, i11);
        n0(this.f14643k, 0, i11);
        i0(bVar2.f14647a, this.f14643k, 0, 4);
        i0(bVar2.f14647a + 4, bArr, i10, i11);
        m0(this.f14639g, this.f14640h + 1, O ? bVar2.f14647a : this.f14641i.f14647a, bVar2.f14647a);
        this.f14642j = bVar2;
        this.f14640h++;
        if (O) {
            this.f14641i = bVar2;
        }
    }
}
