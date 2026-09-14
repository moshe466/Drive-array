package f5;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* renamed from: o, reason: collision with root package name */
    private static final String[] f9385o = new String[128];

    /* renamed from: p, reason: collision with root package name */
    private static final String[] f9386p;

    /* renamed from: f, reason: collision with root package name */
    private final Writer f9387f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f9388g = new int[32];

    /* renamed from: h, reason: collision with root package name */
    private int f9389h = 0;

    /* renamed from: i, reason: collision with root package name */
    private String f9390i;

    /* renamed from: j, reason: collision with root package name */
    private String f9391j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9392k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f9393l;

    /* renamed from: m, reason: collision with root package name */
    private String f9394m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f9395n;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f9385o[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f9385o;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f9386p = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        e0(6);
        this.f9391j = ":";
        this.f9395n = true;
        Objects.requireNonNull(writer, "out == null");
        this.f9387f = writer;
    }

    private void a0() {
        if (this.f9390i == null) {
            return;
        }
        this.f9387f.write(10);
        int i10 = this.f9389h;
        for (int i11 = 1; i11 < i10; i11++) {
            this.f9387f.write(this.f9390i);
        }
    }

    private void c() {
        int d02 = d0();
        if (d02 == 5) {
            this.f9387f.write(44);
        } else if (d02 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        a0();
        f0(4);
    }

    private c c0(int i10, char c10) {
        d();
        e0(i10);
        this.f9387f.write(c10);
        return this;
    }

    private void d() {
        int d02 = d0();
        if (d02 == 1) {
            f0(2);
        } else {
            if (d02 != 2) {
                if (d02 == 4) {
                    this.f9387f.append((CharSequence) this.f9391j);
                    f0(5);
                    return;
                }
                if (d02 != 6) {
                    if (d02 != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    }
                    if (!this.f9392k) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                f0(7);
                return;
            }
            this.f9387f.append(',');
        }
        a0();
    }

    private int d0() {
        int i10 = this.f9389h;
        if (i10 != 0) {
            return this.f9388g[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void e0(int i10) {
        int i11 = this.f9389h;
        int[] iArr = this.f9388g;
        if (i11 == iArr.length) {
            this.f9388g = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f9388g;
        int i12 = this.f9389h;
        this.f9389h = i12 + 1;
        iArr2[i12] = i10;
    }

    private void f0(int i10) {
        this.f9388g[this.f9389h - 1] = i10;
    }

    private c j(int i10, int i11, char c10) {
        int d02 = d0();
        if (d02 != i11 && d02 != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f9394m != null) {
            throw new IllegalStateException("Dangling name: " + this.f9394m);
        }
        this.f9389h--;
        if (d02 == i11) {
            a0();
        }
        this.f9387f.write(c10);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k0(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f9393l
            if (r0 == 0) goto L7
            java.lang.String[] r0 = f5.c.f9386p
            goto L9
        L7:
            java.lang.String[] r0 = f5.c.f9385o
        L9:
            java.io.Writer r1 = r8.f9387f
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f9387f
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f9387f
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f9387f
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f9387f
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.c.k0(java.lang.String):void");
    }

    private void q0() {
        if (this.f9394m != null) {
            c();
            k0(this.f9394m);
            this.f9394m = null;
        }
    }

    public c D() {
        return j(3, 5, '}');
    }

    public final boolean H() {
        return this.f9395n;
    }

    public final boolean M() {
        return this.f9393l;
    }

    public boolean N() {
        return this.f9392k;
    }

    public c O(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f9394m != null) {
            throw new IllegalStateException();
        }
        if (this.f9389h == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f9394m = str;
        return this;
    }

    public c b0() {
        if (this.f9394m != null) {
            if (!this.f9395n) {
                this.f9394m = null;
                return this;
            }
            q0();
        }
        d();
        this.f9387f.write("null");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9387f.close();
        int i10 = this.f9389h;
        if (i10 > 1 || (i10 == 1 && this.f9388g[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f9389h = 0;
    }

    public c f() {
        q0();
        return c0(1, '[');
    }

    public void flush() {
        if (this.f9389h == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f9387f.flush();
    }

    public c g() {
        q0();
        return c0(3, '{');
    }

    public final void g0(boolean z10) {
        this.f9393l = z10;
    }

    public final void h0(String str) {
        String str2;
        if (str.length() == 0) {
            this.f9390i = null;
            str2 = ":";
        } else {
            this.f9390i = str;
            str2 = ": ";
        }
        this.f9391j = str2;
    }

    public final void i0(boolean z10) {
        this.f9392k = z10;
    }

    public final void j0(boolean z10) {
        this.f9395n = z10;
    }

    public c l0(long j10) {
        q0();
        d();
        this.f9387f.write(Long.toString(j10));
        return this;
    }

    public c m0(Boolean bool) {
        if (bool == null) {
            return b0();
        }
        q0();
        d();
        this.f9387f.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c n0(Number number) {
        if (number == null) {
            return b0();
        }
        q0();
        String obj = number.toString();
        if (this.f9392k || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            d();
            this.f9387f.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public c o0(String str) {
        if (str == null) {
            return b0();
        }
        q0();
        d();
        k0(str);
        return this;
    }

    public c p0(boolean z10) {
        q0();
        d();
        this.f9387f.write(z10 ? "true" : "false");
        return this;
    }

    public c v() {
        return j(1, 2, ']');
    }
}
