package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class d implements Iterable<Byte> {

    /* renamed from: f, reason: collision with root package name */
    public static final d f11383f = new p(new byte[0]);

    /* loaded from: classes.dex */
    public interface a extends Iterator<Byte> {
        byte a();
    }

    /* loaded from: classes.dex */
    public static final class b extends OutputStream {

        /* renamed from: k, reason: collision with root package name */
        private static final byte[] f11384k = new byte[0];

        /* renamed from: f, reason: collision with root package name */
        private final int f11385f;

        /* renamed from: g, reason: collision with root package name */
        private final ArrayList<d> f11386g;

        /* renamed from: h, reason: collision with root package name */
        private int f11387h;

        /* renamed from: i, reason: collision with root package name */
        private byte[] f11388i;

        /* renamed from: j, reason: collision with root package name */
        private int f11389j;

        b(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f11385f = i10;
            this.f11386g = new ArrayList<>();
            this.f11388i = new byte[i10];
        }

        private byte[] c(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i10));
            return bArr2;
        }

        private void d(int i10) {
            this.f11386g.add(new p(this.f11388i));
            int length = this.f11387h + this.f11388i.length;
            this.f11387h = length;
            this.f11388i = new byte[Math.max(this.f11385f, Math.max(i10, length >>> 1))];
            this.f11389j = 0;
        }

        private void f() {
            int i10 = this.f11389j;
            byte[] bArr = this.f11388i;
            if (i10 >= bArr.length) {
                this.f11386g.add(new p(this.f11388i));
                this.f11388i = f11384k;
            } else if (i10 > 0) {
                this.f11386g.add(new p(c(bArr, i10)));
            }
            this.f11387h += this.f11389j;
            this.f11389j = 0;
        }

        public synchronized int g() {
            return this.f11387h + this.f11389j;
        }

        public synchronized d j() {
            f();
            return d.g(this.f11386g);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(g()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i10) {
            if (this.f11389j == this.f11388i.length) {
                d(1);
            }
            byte[] bArr = this.f11388i;
            int i11 = this.f11389j;
            this.f11389j = i11 + 1;
            bArr[i11] = (byte) i10;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = this.f11388i;
            int length = bArr2.length;
            int i12 = this.f11389j;
            if (i11 <= length - i12) {
                System.arraycopy(bArr, i10, bArr2, i12, i11);
                this.f11389j += i11;
            } else {
                int length2 = bArr2.length - i12;
                System.arraycopy(bArr, i10, bArr2, i12, length2);
                int i13 = i11 - length2;
                d(i13);
                System.arraycopy(bArr, i10 + length2, this.f11388i, 0, i13);
                this.f11389j = i13;
            }
        }
    }

    public static b A() {
        return new b(128);
    }

    private static d c(Iterator<d> it, int i10) {
        if (i10 == 1) {
            return it.next();
        }
        int i11 = i10 >>> 1;
        return c(it, i11).f(c(it, i10 - i11));
    }

    public static d g(Iterable<d> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = new ArrayList();
            Iterator<d> it = iterable.iterator();
            while (it.hasNext()) {
                collection.add(it.next());
            }
        }
        return collection.isEmpty() ? f11383f : c(collection.iterator(), collection.size());
    }

    public static d j(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static d l(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new p(bArr2);
    }

    public static d s(String str) {
        try {
            return new p(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int B(int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int C(int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int D();

    public byte[] E() {
        int size = size();
        if (size == 0) {
            return j.f11438a;
        }
        byte[] bArr = new byte[size];
        u(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String F(String str);

    public String G() {
        try {
            return F("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(OutputStream outputStream, int i10, int i11) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i12 = i10 + i11;
        if (i12 <= size()) {
            if (i11 > 0) {
                I(outputStream, i10, i11);
            }
        } else {
            StringBuilder sb4 = new StringBuilder(39);
            sb4.append("Source end offset exceeded: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void I(OutputStream outputStream, int i10, int i11);

    public d f(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (size + size2 < 2147483647L) {
            return u.M(this, dVar);
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("ByteString would be too long: ");
        sb2.append(size);
        sb2.append("+");
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public void t(byte[] bArr, int i10, int i11, int i12) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(30);
            sb3.append("Target offset < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        if (i12 < 0) {
            StringBuilder sb4 = new StringBuilder(23);
            sb4.append("Length < 0: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i13 = i10 + i12;
        if (i13 > size()) {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Source end offset < 0: ");
            sb5.append(i13);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
        int i14 = i11 + i12;
        if (i14 <= bArr.length) {
            if (i12 > 0) {
                u(bArr, i10, i11, i12);
            }
        } else {
            StringBuilder sb6 = new StringBuilder(34);
            sb6.append("Target end offset < 0: ");
            sb6.append(i14);
            throw new IndexOutOfBoundsException(sb6.toString());
        }
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void u(byte[] bArr, int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int v();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean w();

    public abstract boolean x();

    @Override // java.lang.Iterable
    /* renamed from: y */
    public abstract a iterator();

    public abstract e z();
}
