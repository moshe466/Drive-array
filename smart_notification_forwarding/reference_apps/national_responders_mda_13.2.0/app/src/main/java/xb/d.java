package xb;

import bc.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    static final c[] f15682a;

    /* renamed from: b, reason: collision with root package name */
    static final Map<bc.f, Integer> f15683b;

    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f15684a;

        /* renamed from: b, reason: collision with root package name */
        private final bc.e f15685b;

        /* renamed from: c, reason: collision with root package name */
        private final int f15686c;

        /* renamed from: d, reason: collision with root package name */
        private int f15687d;

        /* renamed from: e, reason: collision with root package name */
        c[] f15688e;

        /* renamed from: f, reason: collision with root package name */
        int f15689f;

        /* renamed from: g, reason: collision with root package name */
        int f15690g;

        /* renamed from: h, reason: collision with root package name */
        int f15691h;

        a(int i10, int i11, s sVar) {
            this.f15684a = new ArrayList();
            this.f15688e = new c[8];
            this.f15689f = r0.length - 1;
            this.f15690g = 0;
            this.f15691h = 0;
            this.f15686c = i10;
            this.f15687d = i11;
            this.f15685b = bc.l.b(sVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10, s sVar) {
            this(i10, i10, sVar);
        }

        private void a() {
            int i10 = this.f15687d;
            int i11 = this.f15691h;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        private void b() {
            Arrays.fill(this.f15688e, (Object) null);
            this.f15689f = this.f15688e.length - 1;
            this.f15690g = 0;
            this.f15691h = 0;
        }

        private int c(int i10) {
            return this.f15689f + 1 + i10;
        }

        private int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f15688e.length;
                while (true) {
                    length--;
                    i11 = this.f15689f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f15688e;
                    i10 -= cVarArr[length].f15681c;
                    this.f15691h -= cVarArr[length].f15681c;
                    this.f15690g--;
                    i12++;
                }
                c[] cVarArr2 = this.f15688e;
                System.arraycopy(cVarArr2, i11 + 1, cVarArr2, i11 + 1 + i12, this.f15690g);
                this.f15689f += i12;
            }
            return i12;
        }

        private bc.f f(int i10) {
            c cVar;
            if (!h(i10)) {
                int c10 = c(i10 - d.f15682a.length);
                if (c10 >= 0) {
                    c[] cVarArr = this.f15688e;
                    if (c10 < cVarArr.length) {
                        cVar = cVarArr[c10];
                    }
                }
                throw new IOException("Header index too large " + (i10 + 1));
            }
            cVar = d.f15682a[i10];
            return cVar.f15679a;
        }

        private void g(int i10, c cVar) {
            this.f15684a.add(cVar);
            int i11 = cVar.f15681c;
            if (i10 != -1) {
                i11 -= this.f15688e[c(i10)].f15681c;
            }
            int i12 = this.f15687d;
            if (i11 > i12) {
                b();
                return;
            }
            int d10 = d((this.f15691h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f15690g + 1;
                c[] cVarArr = this.f15688e;
                if (i13 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f15689f = this.f15688e.length - 1;
                    this.f15688e = cVarArr2;
                }
                int i14 = this.f15689f;
                this.f15689f = i14 - 1;
                this.f15688e[i14] = cVar;
                this.f15690g++;
            } else {
                this.f15688e[i10 + c(i10) + d10] = cVar;
            }
            this.f15691h += i11;
        }

        private boolean h(int i10) {
            return i10 >= 0 && i10 <= d.f15682a.length - 1;
        }

        private int i() {
            return this.f15685b.Z() & 255;
        }

        private void l(int i10) {
            if (h(i10)) {
                this.f15684a.add(d.f15682a[i10]);
                return;
            }
            int c10 = c(i10 - d.f15682a.length);
            if (c10 >= 0) {
                c[] cVarArr = this.f15688e;
                if (c10 < cVarArr.length) {
                    this.f15684a.add(cVarArr[c10]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private void n(int i10) {
            g(-1, new c(f(i10), j()));
        }

        private void o() {
            g(-1, new c(d.a(j()), j()));
        }

        private void p(int i10) {
            this.f15684a.add(new c(f(i10), j()));
        }

        private void q() {
            this.f15684a.add(new c(d.a(j()), j()));
        }

        public List<c> e() {
            ArrayList arrayList = new ArrayList(this.f15684a);
            this.f15684a.clear();
            return arrayList;
        }

        bc.f j() {
            int i10 = i();
            boolean z10 = (i10 & 128) == 128;
            int m10 = m(i10, 127);
            return z10 ? bc.f.w(k.f().c(this.f15685b.B(m10))) : this.f15685b.p(m10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void k() {
            while (!this.f15685b.z()) {
                int Z = this.f15685b.Z() & 255;
                if (Z == 128) {
                    throw new IOException("index == 0");
                }
                if ((Z & 128) == 128) {
                    l(m(Z, 127) - 1);
                } else if (Z == 64) {
                    o();
                } else if ((Z & 64) == 64) {
                    n(m(Z, 63) - 1);
                } else if ((Z & 32) == 32) {
                    int m10 = m(Z, 31);
                    this.f15687d = m10;
                    if (m10 < 0 || m10 > this.f15686c) {
                        throw new IOException("Invalid dynamic table size update " + this.f15687d);
                    }
                    a();
                } else if (Z == 16 || Z == 0) {
                    q();
                } else {
                    p(m(Z, 15) - 1);
                }
            }
        }

        int m(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int i14 = i();
                if ((i14 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (i14 & 127) << i13;
                i13 += 7;
            }
        }
    }

    /* loaded from: classes.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final bc.c f15692a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f15693b;

        /* renamed from: c, reason: collision with root package name */
        private int f15694c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f15695d;

        /* renamed from: e, reason: collision with root package name */
        int f15696e;

        /* renamed from: f, reason: collision with root package name */
        c[] f15697f;

        /* renamed from: g, reason: collision with root package name */
        int f15698g;

        /* renamed from: h, reason: collision with root package name */
        int f15699h;

        /* renamed from: i, reason: collision with root package name */
        int f15700i;

        b(int i10, boolean z10, bc.c cVar) {
            this.f15694c = Integer.MAX_VALUE;
            this.f15697f = new c[8];
            this.f15698g = r0.length - 1;
            this.f15699h = 0;
            this.f15700i = 0;
            this.f15696e = i10;
            this.f15693b = z10;
            this.f15692a = cVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(bc.c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            int i10 = this.f15696e;
            int i11 = this.f15700i;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    c(i11 - i10);
                }
            }
        }

        private void b() {
            Arrays.fill(this.f15697f, (Object) null);
            this.f15698g = this.f15697f.length - 1;
            this.f15699h = 0;
            this.f15700i = 0;
        }

        private int c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f15697f.length;
                while (true) {
                    length--;
                    i11 = this.f15698g;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f15697f;
                    i10 -= cVarArr[length].f15681c;
                    this.f15700i -= cVarArr[length].f15681c;
                    this.f15699h--;
                    i12++;
                }
                c[] cVarArr2 = this.f15697f;
                System.arraycopy(cVarArr2, i11 + 1, cVarArr2, i11 + 1 + i12, this.f15699h);
                c[] cVarArr3 = this.f15697f;
                int i13 = this.f15698g;
                Arrays.fill(cVarArr3, i13 + 1, i13 + 1 + i12, (Object) null);
                this.f15698g += i12;
            }
            return i12;
        }

        private void d(c cVar) {
            int i10 = cVar.f15681c;
            int i11 = this.f15696e;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.f15700i + i10) - i11);
            int i12 = this.f15699h + 1;
            c[] cVarArr = this.f15697f;
            if (i12 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f15698g = this.f15697f.length - 1;
                this.f15697f = cVarArr2;
            }
            int i13 = this.f15698g;
            this.f15698g = i13 - 1;
            this.f15697f[i13] = cVar;
            this.f15699h++;
            this.f15700i += i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(int i10) {
            int min = Math.min(i10, 16384);
            int i11 = this.f15696e;
            if (i11 == min) {
                return;
            }
            if (min < i11) {
                this.f15694c = Math.min(this.f15694c, min);
            }
            this.f15695d = true;
            this.f15696e = min;
            a();
        }

        void f(bc.f fVar) {
            int B;
            int i10;
            if (!this.f15693b || k.f().e(fVar) >= fVar.B()) {
                B = fVar.B();
                i10 = 0;
            } else {
                bc.c cVar = new bc.c();
                k.f().d(fVar, cVar);
                fVar = cVar.i0();
                B = fVar.B();
                i10 = 128;
            }
            h(B, 127, i10);
            this.f15692a.K(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void g(List<c> list) {
            int i10;
            int i11;
            if (this.f15695d) {
                int i12 = this.f15694c;
                if (i12 < this.f15696e) {
                    h(i12, 31, 32);
                }
                this.f15695d = false;
                this.f15694c = Integer.MAX_VALUE;
                h(this.f15696e, 31, 32);
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                c cVar = list.get(i13);
                bc.f E = cVar.f15679a.E();
                bc.f fVar = cVar.f15680b;
                Integer num = d.f15683b.get(E);
                if (num != null) {
                    i10 = num.intValue() + 1;
                    if (i10 > 1 && i10 < 8) {
                        c[] cVarArr = d.f15682a;
                        if (sb.c.q(cVarArr[i10 - 1].f15680b, fVar)) {
                            i11 = i10;
                        } else if (sb.c.q(cVarArr[i10].f15680b, fVar)) {
                            i11 = i10;
                            i10++;
                        }
                    }
                    i11 = i10;
                    i10 = -1;
                } else {
                    i10 = -1;
                    i11 = -1;
                }
                if (i10 == -1) {
                    int i14 = this.f15698g + 1;
                    int length = this.f15697f.length;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        }
                        if (sb.c.q(this.f15697f[i14].f15679a, E)) {
                            if (sb.c.q(this.f15697f[i14].f15680b, fVar)) {
                                i10 = d.f15682a.length + (i14 - this.f15698g);
                                break;
                            } else if (i11 == -1) {
                                i11 = (i14 - this.f15698g) + d.f15682a.length;
                            }
                        }
                        i14++;
                    }
                }
                if (i10 != -1) {
                    h(i10, 127, 128);
                } else {
                    if (i11 == -1) {
                        this.f15692a.A(64);
                        f(E);
                    } else if (!E.C(c.f15673d) || c.f15678i.equals(E)) {
                        h(i11, 63, 64);
                    } else {
                        h(i11, 15, 0);
                        f(fVar);
                    }
                    f(fVar);
                    d(cVar);
                }
            }
        }

        void h(int i10, int i11, int i12) {
            int i13;
            bc.c cVar;
            if (i10 < i11) {
                cVar = this.f15692a;
                i13 = i10 | i12;
            } else {
                this.f15692a.A(i12 | i11);
                i13 = i10 - i11;
                while (i13 >= 128) {
                    this.f15692a.A(128 | (i13 & 127));
                    i13 >>>= 7;
                }
                cVar = this.f15692a;
            }
            cVar.A(i13);
        }
    }

    static {
        bc.f fVar = c.f15675f;
        bc.f fVar2 = c.f15676g;
        bc.f fVar3 = c.f15677h;
        bc.f fVar4 = c.f15674e;
        f15682a = new c[]{new c(c.f15678i, ""), new c(fVar, "GET"), new c(fVar, "POST"), new c(fVar2, "/"), new c(fVar2, "/index.html"), new c(fVar3, "http"), new c(fVar3, "https"), new c(fVar4, "200"), new c(fVar4, "204"), new c(fVar4, "206"), new c(fVar4, "304"), new c(fVar4, "400"), new c(fVar4, "404"), new c(fVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f15683b = b();
    }

    static bc.f a(bc.f fVar) {
        int B = fVar.B();
        for (int i10 = 0; i10 < B; i10++) {
            byte u10 = fVar.u(i10);
            if (u10 >= 65 && u10 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.G());
            }
        }
        return fVar;
    }

    private static Map<bc.f, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f15682a.length);
        int i10 = 0;
        while (true) {
            c[] cVarArr = f15682a;
            if (i10 >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i10].f15679a)) {
                linkedHashMap.put(cVarArr[i10].f15679a, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
