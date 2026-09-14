package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends d {

    /* renamed from: g, reason: collision with root package name */
    protected final byte[] f11449g;

    /* renamed from: h, reason: collision with root package name */
    private int f11450h = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements d.a {

        /* renamed from: f, reason: collision with root package name */
        private int f11451f;

        /* renamed from: g, reason: collision with root package name */
        private final int f11452g;

        private b() {
            this.f11451f = 0;
            this.f11452g = p.this.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte a() {
            try {
                byte[] bArr = p.this.f11449g;
                int i10 = this.f11451f;
                this.f11451f = i10 + 1;
                return bArr[i10];
            } catch (ArrayIndexOutOfBoundsException e10) {
                throw new NoSuchElementException(e10.getMessage());
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11451f < this.f11452g;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(byte[] bArr) {
        this.f11449g = bArr;
    }

    static int M(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int B(int i10, int i11, int i12) {
        return M(i10, this.f11449g, L() + i11, i12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int C(int i10, int i11, int i12) {
        int L = L() + i11;
        return y.g(i10, this.f11449g, L, i12 + L);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int D() {
        return this.f11450h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String F(String str) {
        return new String(this.f11449g, L(), size(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void I(OutputStream outputStream, int i10, int i11) {
        outputStream.write(this.f11449g, L() + i10, i11);
    }

    public byte J(int i10) {
        return this.f11449g[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K(p pVar, int i10, int i11) {
        if (i11 > pVar.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i11);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i10 + i11 > pVar.size()) {
            int size2 = pVar.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: ");
            sb3.append(i10);
            sb3.append(", ");
            sb3.append(i11);
            sb3.append(", ");
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        }
        byte[] bArr = this.f11449g;
        byte[] bArr2 = pVar.f11449g;
        int L = L() + i11;
        int L2 = L();
        int L3 = pVar.L() + i10;
        while (L2 < L) {
            if (bArr[L2] != bArr2[L3]) {
                return false;
            }
            L2++;
            L3++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int L() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof p) {
            return K((p) obj, 0, size());
        }
        if (obj instanceof u) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
        sb2.append("Has a new type of ByteString been created? Found ");
        sb2.append(valueOf);
        throw new IllegalArgumentException(sb2.toString());
    }

    public int hashCode() {
        int i10 = this.f11450h;
        if (i10 == 0) {
            int size = size();
            i10 = B(size, 0, size);
            if (i10 == 0) {
                i10 = 1;
            }
            this.f11450h = i10;
        }
        return i10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f11449g.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void u(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f11449g, i10, bArr, i11, i12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int v() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean w() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean x() {
        int L = L();
        return y.f(this.f11449g, L, size() + L);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public e z() {
        return e.h(this);
    }
}
