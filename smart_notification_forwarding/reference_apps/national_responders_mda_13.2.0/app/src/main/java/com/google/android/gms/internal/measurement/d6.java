package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class d6 implements Serializable, Iterable<Byte> {

    /* renamed from: g, reason: collision with root package name */
    public static final d6 f5256g = new n6(o7.f5517b);

    /* renamed from: h, reason: collision with root package name */
    private static final j6 f5257h;

    /* renamed from: f, reason: collision with root package name */
    private int f5258f = 0;

    static {
        g6 g6Var = null;
        f5257h = a6.b() ? new r6(g6Var) : new h6(g6Var);
        new f6();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l6 A(int i10) {
        return new l6(i10, null);
    }

    public static d6 s(String str) {
        return new n6(str.getBytes(o7.f5516a));
    }

    public static d6 t(byte[] bArr, int i10, int i11) {
        y(i10, i10 + i11, bArr.length);
        return new n6(f5257h.a(bArr, i10, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x(byte b10) {
        return b10 & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Beginning index: ");
            sb2.append(i10);
            sb2.append(" < 0");
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < i10) {
            StringBuilder sb3 = new StringBuilder(66);
            sb3.append("Beginning index larger than ending index: ");
            sb3.append(i10);
            sb3.append(", ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        StringBuilder sb4 = new StringBuilder(37);
        sb4.append("End index: ");
        sb4.append(i11);
        sb4.append(" >= ");
        sb4.append(i12);
        throw new IndexOutOfBoundsException(sb4.toString());
    }

    public abstract boolean B();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int C() {
        return this.f5258f;
    }

    public abstract byte c(int i10);

    public abstract boolean equals(Object obj);

    public abstract int f();

    public final int hashCode() {
        int i10 = this.f5258f;
        if (i10 == 0) {
            int f10 = f();
            i10 = j(f10, 0, f10);
            if (i10 == 0) {
                i10 = 1;
            }
            this.f5258f = i10;
        }
        return i10;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new g6(this);
    }

    protected abstract int j(int i10, int i11, int i12);

    public abstract d6 l(int i10, int i11);

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(f());
        objArr[2] = f() <= 50 ? da.a(this) : String.valueOf(da.a(l(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    protected abstract String u(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void v(e6 e6Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte w(int i10);

    public final String z() {
        return f() == 0 ? "" : u(o7.f5516a);
    }
}
