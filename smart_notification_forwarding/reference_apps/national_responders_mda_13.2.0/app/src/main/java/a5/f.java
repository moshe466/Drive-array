package a5;

import com.google.gson.q;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class f extends f5.a {

    /* renamed from: y, reason: collision with root package name */
    private static final Object f204y;

    /* renamed from: u, reason: collision with root package name */
    private Object[] f205u;

    /* renamed from: v, reason: collision with root package name */
    private int f206v;

    /* renamed from: w, reason: collision with root package name */
    private String[] f207w;

    /* renamed from: x, reason: collision with root package name */
    private int[] f208x;

    /* loaded from: classes.dex */
    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    static {
        new a();
        f204y = new Object();
    }

    private Object A0() {
        return this.f205u[this.f206v - 1];
    }

    private Object B0() {
        Object[] objArr = this.f205u;
        int i10 = this.f206v - 1;
        this.f206v = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    private void D0(Object obj) {
        int i10 = this.f206v;
        Object[] objArr = this.f205u;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f205u = Arrays.copyOf(objArr, i11);
            this.f208x = Arrays.copyOf(this.f208x, i11);
            this.f207w = (String[]) Arrays.copyOf(this.f207w, i11);
        }
        Object[] objArr2 = this.f205u;
        int i12 = this.f206v;
        this.f206v = i12 + 1;
        objArr2[i12] = obj;
    }

    private String b0() {
        return " at path " + M();
    }

    private void y0(f5.b bVar) {
        if (m0() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + m0() + b0());
    }

    public void C0() {
        y0(f5.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) A0()).next();
        D0(entry.getValue());
        D0(new q((String) entry.getKey()));
    }

    @Override // f5.a
    public void D() {
        y0(f5.b.END_OBJECT);
        B0();
        B0();
        int i10 = this.f206v;
        if (i10 > 0) {
            int[] iArr = this.f208x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // f5.a
    public String M() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f206v;
            if (i10 >= i11) {
                return sb2.toString();
            }
            Object[] objArr = this.f205u;
            if (objArr[i10] instanceof com.google.gson.h) {
                i10++;
                if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                    sb2.append('[');
                    sb2.append(this.f208x[i10]);
                    sb2.append(']');
                }
            } else if ((objArr[i10] instanceof com.google.gson.n) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                sb2.append('.');
                String[] strArr = this.f207w;
                if (strArr[i10] != null) {
                    sb2.append(strArr[i10]);
                }
            }
            i10++;
        }
    }

    @Override // f5.a
    public boolean N() {
        f5.b m02 = m0();
        return (m02 == f5.b.END_OBJECT || m02 == f5.b.END_ARRAY) ? false : true;
    }

    @Override // f5.a
    public void c() {
        y0(f5.b.BEGIN_ARRAY);
        D0(((com.google.gson.h) A0()).iterator());
        this.f208x[this.f206v - 1] = 0;
    }

    @Override // f5.a
    public boolean c0() {
        y0(f5.b.BOOLEAN);
        boolean x10 = ((q) B0()).x();
        int i10 = this.f206v;
        if (i10 > 0) {
            int[] iArr = this.f208x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return x10;
    }

    @Override // f5.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f205u = new Object[]{f204y};
        this.f206v = 1;
    }

    @Override // f5.a
    public void d() {
        y0(f5.b.BEGIN_OBJECT);
        D0(((com.google.gson.n) A0()).A().iterator());
    }

    @Override // f5.a
    public double d0() {
        f5.b m02 = m0();
        f5.b bVar = f5.b.NUMBER;
        if (m02 != bVar && m02 != f5.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + m02 + b0());
        }
        double y10 = ((q) A0()).y();
        if (!O() && (Double.isNaN(y10) || Double.isInfinite(y10))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + y10);
        }
        B0();
        int i10 = this.f206v;
        if (i10 > 0) {
            int[] iArr = this.f208x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return y10;
    }

    @Override // f5.a
    public int e0() {
        f5.b m02 = m0();
        f5.b bVar = f5.b.NUMBER;
        if (m02 != bVar && m02 != f5.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + m02 + b0());
        }
        int c10 = ((q) A0()).c();
        B0();
        int i10 = this.f206v;
        if (i10 > 0) {
            int[] iArr = this.f208x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return c10;
    }

    @Override // f5.a
    public long f0() {
        f5.b m02 = m0();
        f5.b bVar = f5.b.NUMBER;
        if (m02 != bVar && m02 != f5.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + m02 + b0());
        }
        long l10 = ((q) A0()).l();
        B0();
        int i10 = this.f206v;
        if (i10 > 0) {
            int[] iArr = this.f208x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return l10;
    }

    @Override // f5.a
    public String g0() {
        y0(f5.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) A0()).next();
        String str = (String) entry.getKey();
        this.f207w[this.f206v - 1] = str;
        D0(entry.getValue());
        return str;
    }

    @Override // f5.a
    public void i0() {
        y0(f5.b.NULL);
        B0();
        int i10 = this.f206v;
        if (i10 > 0) {
            int[] iArr = this.f208x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // f5.a
    public String k0() {
        f5.b m02 = m0();
        f5.b bVar = f5.b.STRING;
        if (m02 == bVar || m02 == f5.b.NUMBER) {
            String s10 = ((q) B0()).s();
            int i10 = this.f206v;
            if (i10 > 0) {
                int[] iArr = this.f208x;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return s10;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + m02 + b0());
    }

    @Override // f5.a
    public f5.b m0() {
        if (this.f206v == 0) {
            return f5.b.END_DOCUMENT;
        }
        Object A0 = A0();
        if (A0 instanceof Iterator) {
            boolean z10 = this.f205u[this.f206v - 2] instanceof com.google.gson.n;
            Iterator it = (Iterator) A0;
            if (!it.hasNext()) {
                return z10 ? f5.b.END_OBJECT : f5.b.END_ARRAY;
            }
            if (z10) {
                return f5.b.NAME;
            }
            D0(it.next());
            return m0();
        }
        if (A0 instanceof com.google.gson.n) {
            return f5.b.BEGIN_OBJECT;
        }
        if (A0 instanceof com.google.gson.h) {
            return f5.b.BEGIN_ARRAY;
        }
        if (!(A0 instanceof q)) {
            if (A0 instanceof com.google.gson.m) {
                return f5.b.NULL;
            }
            if (A0 == f204y) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        q qVar = (q) A0;
        if (qVar.D()) {
            return f5.b.STRING;
        }
        if (qVar.A()) {
            return f5.b.BOOLEAN;
        }
        if (qVar.C()) {
            return f5.b.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // f5.a
    public String toString() {
        return f.class.getSimpleName() + b0();
    }

    @Override // f5.a
    public void v() {
        y0(f5.b.END_ARRAY);
        B0();
        B0();
        int i10 = this.f206v;
        if (i10 > 0) {
            int[] iArr = this.f208x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // f5.a
    public void w0() {
        if (m0() == f5.b.NAME) {
            g0();
            this.f207w[this.f206v - 2] = "null";
        } else {
            B0();
            int i10 = this.f206v;
            if (i10 > 0) {
                this.f207w[i10 - 1] = "null";
            }
        }
        int i11 = this.f206v;
        if (i11 > 0) {
            int[] iArr = this.f208x;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.gson.k z0() {
        f5.b m02 = m0();
        if (m02 != f5.b.NAME && m02 != f5.b.END_ARRAY && m02 != f5.b.END_OBJECT && m02 != f5.b.END_DOCUMENT) {
            com.google.gson.k kVar = (com.google.gson.k) A0();
            w0();
            return kVar;
        }
        throw new IllegalStateException("Unexpected " + m02 + " when reading a JsonElement.");
    }
}
