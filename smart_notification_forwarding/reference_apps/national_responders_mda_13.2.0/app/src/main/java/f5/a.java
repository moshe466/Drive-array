package f5;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import z4.f;

/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private final Reader f9370f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9371g = false;

    /* renamed from: h, reason: collision with root package name */
    private final char[] f9372h = new char[1024];

    /* renamed from: i, reason: collision with root package name */
    private int f9373i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f9374j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f9375k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f9376l = 0;

    /* renamed from: m, reason: collision with root package name */
    int f9377m = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f9378n;

    /* renamed from: o, reason: collision with root package name */
    private int f9379o;

    /* renamed from: p, reason: collision with root package name */
    private String f9380p;

    /* renamed from: q, reason: collision with root package name */
    private int[] f9381q;

    /* renamed from: r, reason: collision with root package name */
    private int f9382r;

    /* renamed from: s, reason: collision with root package name */
    private String[] f9383s;

    /* renamed from: t, reason: collision with root package name */
    private int[] f9384t;

    /* renamed from: f5.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0157a extends f {
        C0157a() {
        }

        @Override // z4.f
        public void a(a aVar) {
            int i10;
            if (aVar instanceof a5.f) {
                ((a5.f) aVar).C0();
                return;
            }
            int i11 = aVar.f9377m;
            if (i11 == 0) {
                i11 = aVar.j();
            }
            if (i11 == 13) {
                i10 = 9;
            } else if (i11 == 12) {
                i10 = 8;
            } else {
                if (i11 != 14) {
                    throw new IllegalStateException("Expected a name but was " + aVar.m0() + aVar.b0());
                }
                i10 = 10;
            }
            aVar.f9377m = i10;
        }
    }

    static {
        f.f16191a = new C0157a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f9381q = iArr;
        this.f9382r = 0;
        this.f9382r = 0 + 1;
        iArr[0] = 6;
        this.f9383s = new String[32];
        this.f9384t = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f9370f = reader;
    }

    private boolean H(int i10) {
        int i11;
        int i12;
        char[] cArr = this.f9372h;
        int i13 = this.f9376l;
        int i14 = this.f9373i;
        this.f9376l = i13 - i14;
        int i15 = this.f9374j;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f9374j = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f9374j = 0;
        }
        this.f9373i = 0;
        do {
            Reader reader = this.f9370f;
            int i17 = this.f9374j;
            int read = reader.read(cArr, i17, cArr.length - i17);
            if (read == -1) {
                return false;
            }
            i11 = this.f9374j + read;
            this.f9374j = i11;
            if (this.f9375k == 0 && (i12 = this.f9376l) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f9373i++;
                this.f9376l = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    private boolean a0(char c10) {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        f();
        return false;
    }

    private void f() {
        if (!this.f9371g) {
            throw x0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void g() {
        h0(true);
        int i10 = this.f9373i - 1;
        this.f9373i = i10;
        if (i10 + 5 <= this.f9374j || H(5)) {
            char[] cArr = this.f9372h;
            if (cArr[i10] == ')' && cArr[i10 + 1] == ']' && cArr[i10 + 2] == '}' && cArr[i10 + 3] == '\'' && cArr[i10 + 4] == '\n') {
                this.f9373i += 5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        if (r1 != '/') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        r7.f9373i = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        if (r4 != r2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r7.f9373i = r4 - 1;
        r2 = H(2);
        r7.f9373i++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r2 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
    
        f();
        r2 = r7.f9373i;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
    
        if (r3 == '*') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
    
        r7.f9373i = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
    
        if (t0("*\/") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
    
        throw x0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0075, code lost:
    
        if (r3 == '/') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0078, code lost:
    
        r7.f9373i = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0077, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0098, code lost:
    
        r7.f9373i = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009c, code lost:
    
        if (r1 != '#') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009e, code lost:
    
        f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a2, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int h0(boolean r8) {
        /*
            r7 = this;
            char[] r0 = r7.f9372h
        L2:
            int r1 = r7.f9373i
        L4:
            int r2 = r7.f9374j
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r7.f9373i = r1
            boolean r1 = r7.H(r3)
            if (r1 != 0) goto L30
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r7.b0()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L30:
            int r1 = r7.f9373i
            int r2 = r7.f9374j
        L34:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L44
            int r1 = r7.f9375k
            int r1 = r1 + r3
            r7.f9375k = r1
            r7.f9376l = r4
            goto La3
        L44:
            r5 = 32
            if (r1 == r5) goto La3
            r5 = 13
            if (r1 == r5) goto La3
            r5 = 9
            if (r1 != r5) goto L51
            goto La3
        L51:
            r5 = 47
            if (r1 != r5) goto L98
            r7.f9373i = r4
            r6 = 2
            if (r4 != r2) goto L6a
            int r4 = r4 + (-1)
            r7.f9373i = r4
            boolean r2 = r7.H(r6)
            int r4 = r7.f9373i
            int r4 = r4 + r3
            r7.f9373i = r4
            if (r2 != 0) goto L6a
            return r1
        L6a:
            r7.f()
            int r2 = r7.f9373i
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L80
            if (r3 == r5) goto L78
            return r1
        L78:
            int r2 = r2 + 1
            r7.f9373i = r2
        L7c:
            r7.u0()
            goto L2
        L80:
            int r2 = r2 + 1
            r7.f9373i = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.t0(r1)
            if (r1 == 0) goto L91
            int r1 = r7.f9373i
            int r1 = r1 + r6
            goto L4
        L91:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.x0(r8)
            throw r8
        L98:
            r2 = 35
            r7.f9373i = r4
            if (r1 != r2) goto La2
            r7.f()
            goto L7c
        La2:
            return r1
        La3:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.a.h0(boolean):int");
    }

    private String j0(char c10) {
        char[] cArr = this.f9372h;
        StringBuilder sb2 = null;
        while (true) {
            int i10 = this.f9373i;
            int i11 = this.f9374j;
            while (true) {
                if (i10 < i11) {
                    int i12 = i10 + 1;
                    char c11 = cArr[i10];
                    if (c11 == c10) {
                        this.f9373i = i12;
                        int i13 = (i12 - i10) - 1;
                        if (sb2 == null) {
                            return new String(cArr, i10, i13);
                        }
                        sb2.append(cArr, i10, i13);
                        return sb2.toString();
                    }
                    if (c11 == '\\') {
                        this.f9373i = i12;
                        int i14 = (i12 - i10) - 1;
                        if (sb2 == null) {
                            sb2 = new StringBuilder(Math.max((i14 + 1) * 2, 16));
                        }
                        sb2.append(cArr, i10, i14);
                        sb2.append(q0());
                    } else {
                        if (c11 == '\n') {
                            this.f9375k++;
                            this.f9376l = i12;
                        }
                        i10 = i12;
                    }
                } else {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max((i10 - i10) * 2, 16));
                    }
                    sb2.append(cArr, i10, i10 - i10);
                    this.f9373i = i10;
                    if (!H(1)) {
                        throw x0("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        f();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String l0() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.f9373i
            int r4 = r3 + r2
            int r5 = r6.f9374j
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f9372h
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.f()
            goto L5c
        L4e:
            char[] r3 = r6.f9372h
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.H(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L7e
        L5e:
            if (r1 != 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L6b:
            char[] r3 = r6.f9372h
            int r4 = r6.f9373i
            r1.append(r3, r4, r2)
            int r3 = r6.f9373i
            int r3 = r3 + r2
            r6.f9373i = r3
            r2 = 1
            boolean r2 = r6.H(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r1 != 0) goto L8a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f9372h
            int r3 = r6.f9373i
            r1.<init>(r2, r3, r0)
            goto L95
        L8a:
            char[] r2 = r6.f9372h
            int r3 = r6.f9373i
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L95:
            int r2 = r6.f9373i
            int r2 = r2 + r0
            r6.f9373i = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.a.l0():java.lang.String");
    }

    private int n0() {
        int i10;
        String str;
        String str2;
        char c10 = this.f9372h[this.f9373i];
        if (c10 == 't' || c10 == 'T') {
            i10 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c10 == 'f' || c10 == 'F') {
            i10 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (c10 != 'n' && c10 != 'N') {
                return 0;
            }
            i10 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f9373i + i11 >= this.f9374j && !H(i11 + 1)) {
                return 0;
            }
            char c11 = this.f9372h[this.f9373i + i11];
            if (c11 != str.charAt(i11) && c11 != str2.charAt(i11)) {
                return 0;
            }
        }
        if ((this.f9373i + length < this.f9374j || H(length + 1)) && a0(this.f9372h[this.f9373i + length])) {
            return 0;
        }
        this.f9373i += length;
        this.f9377m = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0097, code lost:
    
        if (r9 != 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0099, code lost:
    
        if (r10 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009f, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a1, code lost:
    
        if (r13 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:
    
        if (r11 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
    
        if (r13 != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ae, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00af, code lost:
    
        r18.f9378n = r11;
        r18.f9373i += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b8, code lost:
    
        r18.f9377m = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ba, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bb, code lost:
    
        if (r9 == 2) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00be, code lost:
    
        if (r9 == 4) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c1, code lost:
    
        if (r9 != 7) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c4, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
    
        r18.f9379o = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0095, code lost:
    
        if (a0(r14) != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00cb, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int o0() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.a.o0():int");
    }

    private void p0(int i10) {
        int i11 = this.f9382r;
        int[] iArr = this.f9381q;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f9381q = Arrays.copyOf(iArr, i12);
            this.f9384t = Arrays.copyOf(this.f9384t, i12);
            this.f9383s = (String[]) Arrays.copyOf(this.f9383s, i12);
        }
        int[] iArr2 = this.f9381q;
        int i13 = this.f9382r;
        this.f9382r = i13 + 1;
        iArr2[i13] = i10;
    }

    private char q0() {
        int i10;
        int i11;
        if (this.f9373i == this.f9374j && !H(1)) {
            throw x0("Unterminated escape sequence");
        }
        char[] cArr = this.f9372h;
        int i12 = this.f9373i;
        int i13 = i12 + 1;
        this.f9373i = i13;
        char c10 = cArr[i12];
        if (c10 == '\n') {
            this.f9375k++;
            this.f9376l = i13;
        } else if (c10 != '\"' && c10 != '\'' && c10 != '/' && c10 != '\\') {
            if (c10 == 'b') {
                return '\b';
            }
            if (c10 == 'f') {
                return '\f';
            }
            if (c10 == 'n') {
                return '\n';
            }
            if (c10 == 'r') {
                return '\r';
            }
            if (c10 == 't') {
                return '\t';
            }
            if (c10 != 'u') {
                throw x0("Invalid escape sequence");
            }
            if (i13 + 4 > this.f9374j && !H(4)) {
                throw x0("Unterminated escape sequence");
            }
            char c11 = 0;
            int i14 = this.f9373i;
            int i15 = i14 + 4;
            while (i14 < i15) {
                char c12 = this.f9372h[i14];
                char c13 = (char) (c11 << 4);
                if (c12 < '0' || c12 > '9') {
                    if (c12 >= 'a' && c12 <= 'f') {
                        i10 = c12 - 'a';
                    } else {
                        if (c12 < 'A' || c12 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f9372h, this.f9373i, 4));
                        }
                        i10 = c12 - 'A';
                    }
                    i11 = i10 + 10;
                } else {
                    i11 = c12 - '0';
                }
                c11 = (char) (c13 + i11);
                i14++;
            }
            this.f9373i += 4;
            return c11;
        }
        return c10;
    }

    private void s0(char c10) {
        char[] cArr = this.f9372h;
        while (true) {
            int i10 = this.f9373i;
            int i11 = this.f9374j;
            while (true) {
                if (i10 < i11) {
                    int i12 = i10 + 1;
                    char c11 = cArr[i10];
                    if (c11 == c10) {
                        this.f9373i = i12;
                        return;
                    }
                    if (c11 == '\\') {
                        this.f9373i = i12;
                        q0();
                        break;
                    } else {
                        if (c11 == '\n') {
                            this.f9375k++;
                            this.f9376l = i12;
                        }
                        i10 = i12;
                    }
                } else {
                    this.f9373i = i10;
                    if (!H(1)) {
                        throw x0("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean t0(String str) {
        int length = str.length();
        while (true) {
            if (this.f9373i + length > this.f9374j && !H(length)) {
                return false;
            }
            char[] cArr = this.f9372h;
            int i10 = this.f9373i;
            if (cArr[i10] != '\n') {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.f9372h[this.f9373i + i11] != str.charAt(i11)) {
                        break;
                    }
                }
                return true;
            }
            this.f9375k++;
            this.f9376l = i10 + 1;
            this.f9373i++;
        }
    }

    private void u0() {
        char c10;
        do {
            if (this.f9373i >= this.f9374j && !H(1)) {
                return;
            }
            char[] cArr = this.f9372h;
            int i10 = this.f9373i;
            int i11 = i10 + 1;
            this.f9373i = i11;
            c10 = cArr[i10];
            if (c10 == '\n') {
                this.f9375k++;
                this.f9376l = i11;
                return;
            }
        } while (c10 != '\r');
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:242)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private void v0() {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f9373i
            int r2 = r1 + r0
            int r3 = r4.f9374j
            if (r2 >= r3) goto L51
            char[] r2 = r4.f9372h
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.f()
        L4b:
            int r1 = r4.f9373i
            int r1 = r1 + r0
            r4.f9373i = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f9373i = r1
            r0 = 1
            boolean r0 = r4.H(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.a.v0():void");
    }

    private IOException x0(String str) {
        throw new d(str + b0());
    }

    public void D() {
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + m0() + b0());
        }
        int i11 = this.f9382r - 1;
        this.f9382r = i11;
        this.f9383s[i11] = null;
        int[] iArr = this.f9384t;
        int i12 = i11 - 1;
        iArr[i12] = iArr[i12] + 1;
        this.f9377m = 0;
    }

    public String M() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = this.f9382r;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f9381q[i11];
            if (i12 == 1 || i12 == 2) {
                sb2.append('[');
                sb2.append(this.f9384t[i11]);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append('.');
                String[] strArr = this.f9383s;
                if (strArr[i11] != null) {
                    sb2.append(strArr[i11]);
                }
            }
        }
        return sb2.toString();
    }

    public boolean N() {
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        return (i10 == 2 || i10 == 4) ? false : true;
    }

    public final boolean O() {
        return this.f9371g;
    }

    String b0() {
        return " at line " + (this.f9375k + 1) + " column " + ((this.f9373i - this.f9376l) + 1) + " path " + M();
    }

    public void c() {
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 3) {
            p0(1);
            this.f9384t[this.f9382r - 1] = 0;
            this.f9377m = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + m0() + b0());
        }
    }

    public boolean c0() {
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 5) {
            this.f9377m = 0;
            int[] iArr = this.f9384t;
            int i11 = this.f9382r - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        }
        if (i10 == 6) {
            this.f9377m = 0;
            int[] iArr2 = this.f9384t;
            int i12 = this.f9382r - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + m0() + b0());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9377m = 0;
        this.f9381q[0] = 8;
        this.f9382r = 1;
        this.f9370f.close();
    }

    public void d() {
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 1) {
            p0(3);
            this.f9377m = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + m0() + b0());
        }
    }

    public double d0() {
        String j02;
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 15) {
            this.f9377m = 0;
            int[] iArr = this.f9384t;
            int i11 = this.f9382r - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f9378n;
        }
        if (i10 == 16) {
            this.f9380p = new String(this.f9372h, this.f9373i, this.f9379o);
            this.f9373i += this.f9379o;
        } else {
            if (i10 == 8 || i10 == 9) {
                j02 = j0(i10 == 8 ? '\'' : '\"');
            } else if (i10 == 10) {
                j02 = l0();
            } else if (i10 != 11) {
                throw new IllegalStateException("Expected a double but was " + m0() + b0());
            }
            this.f9380p = j02;
        }
        this.f9377m = 11;
        double parseDouble = Double.parseDouble(this.f9380p);
        if (!this.f9371g && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + b0());
        }
        this.f9380p = null;
        this.f9377m = 0;
        int[] iArr2 = this.f9384t;
        int i12 = this.f9382r - 1;
        iArr2[i12] = iArr2[i12] + 1;
        return parseDouble;
    }

    public int e0() {
        String j02;
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 15) {
            long j10 = this.f9378n;
            int i11 = (int) j10;
            if (j10 == i11) {
                this.f9377m = 0;
                int[] iArr = this.f9384t;
                int i12 = this.f9382r - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new NumberFormatException("Expected an int but was " + this.f9378n + b0());
        }
        if (i10 == 16) {
            this.f9380p = new String(this.f9372h, this.f9373i, this.f9379o);
            this.f9373i += this.f9379o;
        } else {
            if (i10 != 8 && i10 != 9 && i10 != 10) {
                throw new IllegalStateException("Expected an int but was " + m0() + b0());
            }
            if (i10 == 10) {
                j02 = l0();
            } else {
                j02 = j0(i10 == 8 ? '\'' : '\"');
            }
            this.f9380p = j02;
            try {
                int parseInt = Integer.parseInt(this.f9380p);
                this.f9377m = 0;
                int[] iArr2 = this.f9384t;
                int i13 = this.f9382r - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f9377m = 11;
        double parseDouble = Double.parseDouble(this.f9380p);
        int i14 = (int) parseDouble;
        if (i14 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f9380p + b0());
        }
        this.f9380p = null;
        this.f9377m = 0;
        int[] iArr3 = this.f9384t;
        int i15 = this.f9382r - 1;
        iArr3[i15] = iArr3[i15] + 1;
        return i14;
    }

    public long f0() {
        String j02;
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 15) {
            this.f9377m = 0;
            int[] iArr = this.f9384t;
            int i11 = this.f9382r - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f9378n;
        }
        if (i10 == 16) {
            this.f9380p = new String(this.f9372h, this.f9373i, this.f9379o);
            this.f9373i += this.f9379o;
        } else {
            if (i10 != 8 && i10 != 9 && i10 != 10) {
                throw new IllegalStateException("Expected a long but was " + m0() + b0());
            }
            if (i10 == 10) {
                j02 = l0();
            } else {
                j02 = j0(i10 == 8 ? '\'' : '\"');
            }
            this.f9380p = j02;
            try {
                long parseLong = Long.parseLong(this.f9380p);
                this.f9377m = 0;
                int[] iArr2 = this.f9384t;
                int i12 = this.f9382r - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f9377m = 11;
        double parseDouble = Double.parseDouble(this.f9380p);
        long j10 = (long) parseDouble;
        if (j10 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f9380p + b0());
        }
        this.f9380p = null;
        this.f9377m = 0;
        int[] iArr3 = this.f9384t;
        int i13 = this.f9382r - 1;
        iArr3[i13] = iArr3[i13] + 1;
        return j10;
    }

    public String g0() {
        char c10;
        String j02;
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 14) {
            j02 = l0();
        } else {
            if (i10 == 12) {
                c10 = '\'';
            } else {
                if (i10 != 13) {
                    throw new IllegalStateException("Expected a name but was " + m0() + b0());
                }
                c10 = '\"';
            }
            j02 = j0(c10);
        }
        this.f9377m = 0;
        this.f9383s[this.f9382r - 1] = j02;
        return j02;
    }

    public void i0() {
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 7) {
            this.f9377m = 0;
            int[] iArr = this.f9384t;
            int i11 = this.f9382r - 1;
            iArr[i11] = iArr[i11] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + m0() + b0());
    }

    int j() {
        int i10;
        int h02;
        int[] iArr = this.f9381q;
        int i11 = this.f9382r;
        int i12 = iArr[i11 - 1];
        if (i12 == 1) {
            iArr[i11 - 1] = 2;
        } else {
            if (i12 != 2) {
                if (i12 == 3 || i12 == 5) {
                    iArr[i11 - 1] = 4;
                    if (i12 == 5 && (h02 = h0(true)) != 44) {
                        if (h02 != 59) {
                            if (h02 != 125) {
                                throw x0("Unterminated object");
                            }
                            this.f9377m = 2;
                            return 2;
                        }
                        f();
                    }
                    int h03 = h0(true);
                    if (h03 == 34) {
                        i10 = 13;
                    } else if (h03 == 39) {
                        f();
                        i10 = 12;
                    } else {
                        if (h03 == 125) {
                            if (i12 == 5) {
                                throw x0("Expected name");
                            }
                            this.f9377m = 2;
                            return 2;
                        }
                        f();
                        this.f9373i--;
                        if (!a0((char) h03)) {
                            throw x0("Expected name");
                        }
                        i10 = 14;
                    }
                } else if (i12 == 4) {
                    iArr[i11 - 1] = 5;
                    int h04 = h0(true);
                    if (h04 != 58) {
                        if (h04 != 61) {
                            throw x0("Expected ':'");
                        }
                        f();
                        if (this.f9373i < this.f9374j || H(1)) {
                            char[] cArr = this.f9372h;
                            int i13 = this.f9373i;
                            if (cArr[i13] == '>') {
                                this.f9373i = i13 + 1;
                            }
                        }
                    }
                } else if (i12 == 6) {
                    if (this.f9371g) {
                        g();
                    }
                    this.f9381q[this.f9382r - 1] = 7;
                } else if (i12 == 7) {
                    if (h0(false) == -1) {
                        i10 = 17;
                    } else {
                        f();
                        this.f9373i--;
                    }
                } else if (i12 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.f9377m = i10;
                return i10;
            }
            int h05 = h0(true);
            if (h05 != 44) {
                if (h05 != 59) {
                    if (h05 != 93) {
                        throw x0("Unterminated array");
                    }
                    this.f9377m = 4;
                    return 4;
                }
                f();
            }
        }
        int h06 = h0(true);
        if (h06 != 34) {
            if (h06 == 39) {
                f();
                this.f9377m = 8;
                return 8;
            }
            if (h06 != 44 && h06 != 59) {
                if (h06 == 91) {
                    this.f9377m = 3;
                    return 3;
                }
                if (h06 != 93) {
                    if (h06 == 123) {
                        this.f9377m = 1;
                        return 1;
                    }
                    this.f9373i--;
                    int n02 = n0();
                    if (n02 != 0) {
                        return n02;
                    }
                    int o02 = o0();
                    if (o02 != 0) {
                        return o02;
                    }
                    if (!a0(this.f9372h[this.f9373i])) {
                        throw x0("Expected value");
                    }
                    f();
                    i10 = 10;
                } else if (i12 == 1) {
                    this.f9377m = 4;
                    return 4;
                }
            }
            if (i12 != 1 && i12 != 2) {
                throw x0("Unexpected value");
            }
            f();
            this.f9373i--;
            this.f9377m = 7;
            return 7;
        }
        i10 = 9;
        this.f9377m = i10;
        return i10;
    }

    public String k0() {
        String str;
        char c10;
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 == 10) {
            str = l0();
        } else {
            if (i10 == 8) {
                c10 = '\'';
            } else if (i10 == 9) {
                c10 = '\"';
            } else if (i10 == 11) {
                str = this.f9380p;
                this.f9380p = null;
            } else if (i10 == 15) {
                str = Long.toString(this.f9378n);
            } else {
                if (i10 != 16) {
                    throw new IllegalStateException("Expected a string but was " + m0() + b0());
                }
                str = new String(this.f9372h, this.f9373i, this.f9379o);
                this.f9373i += this.f9379o;
            }
            str = j0(c10);
        }
        this.f9377m = 0;
        int[] iArr = this.f9384t;
        int i11 = this.f9382r - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public b m0() {
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        switch (i10) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void r0(boolean z10) {
        this.f9371g = z10;
    }

    public String toString() {
        return getClass().getSimpleName() + b0();
    }

    public void v() {
        int i10 = this.f9377m;
        if (i10 == 0) {
            i10 = j();
        }
        if (i10 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + m0() + b0());
        }
        int i11 = this.f9382r - 1;
        this.f9382r = i11;
        int[] iArr = this.f9384t;
        int i12 = i11 - 1;
        iArr[i12] = iArr[i12] + 1;
        this.f9377m = 0;
    }

    public void w0() {
        char c10;
        int i10 = 0;
        do {
            int i11 = this.f9377m;
            if (i11 == 0) {
                i11 = j();
            }
            if (i11 == 3) {
                p0(1);
            } else if (i11 == 1) {
                p0(3);
            } else {
                if (i11 == 4 || i11 == 2) {
                    this.f9382r--;
                    i10--;
                } else if (i11 == 14 || i11 == 10) {
                    v0();
                } else {
                    if (i11 == 8 || i11 == 12) {
                        c10 = '\'';
                    } else if (i11 == 9 || i11 == 13) {
                        c10 = '\"';
                    } else if (i11 == 16) {
                        this.f9373i += this.f9379o;
                    }
                    s0(c10);
                }
                this.f9377m = 0;
            }
            i10++;
            this.f9377m = 0;
        } while (i10 != 0);
        int[] iArr = this.f9384t;
        int i12 = this.f9382r;
        int i13 = i12 - 1;
        iArr[i13] = iArr[i13] + 1;
        this.f9383s[i12 - 1] = "null";
    }
}
