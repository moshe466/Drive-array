package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends kotlin.reflect.jvm.internal.impl.protobuf.d {

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f11454m;

    /* renamed from: g, reason: collision with root package name */
    private final int f11455g;

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f11456h;

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f11457i;

    /* renamed from: j, reason: collision with root package name */
    private final int f11458j;

    /* renamed from: k, reason: collision with root package name */
    private final int f11459k;

    /* renamed from: l, reason: collision with root package name */
    private int f11460l;

    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Stack<kotlin.reflect.jvm.internal.impl.protobuf.d> f11461a;

        private b() {
            this.f11461a = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public kotlin.reflect.jvm.internal.impl.protobuf.d b(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
            c(dVar);
            c(dVar2);
            kotlin.reflect.jvm.internal.impl.protobuf.d pop = this.f11461a.pop();
            while (!this.f11461a.isEmpty()) {
                pop = new u(this.f11461a.pop(), pop);
            }
            return pop;
        }

        private void c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            if (dVar.w()) {
                e(dVar);
                return;
            }
            if (dVar instanceof u) {
                u uVar = (u) dVar;
                c(uVar.f11456h);
                c(uVar.f11457i);
            } else {
                String valueOf = String.valueOf(dVar.getClass());
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
                sb2.append("Has a new type of ByteString been created? Found ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        private int d(int i10) {
            int binarySearch = Arrays.binarySearch(u.f11454m, i10);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void e(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            int d10 = d(dVar.size());
            int i10 = u.f11454m[d10 + 1];
            if (this.f11461a.isEmpty() || this.f11461a.peek().size() >= i10) {
                this.f11461a.push(dVar);
                return;
            }
            int i11 = u.f11454m[d10];
            kotlin.reflect.jvm.internal.impl.protobuf.d pop = this.f11461a.pop();
            while (true) {
                if (this.f11461a.isEmpty() || this.f11461a.peek().size() >= i11) {
                    break;
                } else {
                    pop = new u(this.f11461a.pop(), pop);
                }
            }
            u uVar = new u(pop, dVar);
            while (!this.f11461a.isEmpty()) {
                if (this.f11461a.peek().size() >= u.f11454m[d(uVar.size()) + 1]) {
                    break;
                } else {
                    uVar = new u(this.f11461a.pop(), uVar);
                }
            }
            this.f11461a.push(uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements Iterator<p> {

        /* renamed from: f, reason: collision with root package name */
        private final Stack<u> f11462f;

        /* renamed from: g, reason: collision with root package name */
        private p f11463g;

        private c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f11462f = new Stack<>();
            this.f11463g = b(dVar);
        }

        private p b(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            while (dVar instanceof u) {
                u uVar = (u) dVar;
                this.f11462f.push(uVar);
                dVar = uVar.f11456h;
            }
            return (p) dVar;
        }

        private p c() {
            while (!this.f11462f.isEmpty()) {
                p b10 = b(this.f11462f.pop().f11457i);
                if (!b10.isEmpty()) {
                    return b10;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public p next() {
            p pVar = this.f11463g;
            if (pVar == null) {
                throw new NoSuchElementException();
            }
            this.f11463g = c();
            return pVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11463g != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements d.a {

        /* renamed from: f, reason: collision with root package name */
        private final c f11464f;

        /* renamed from: g, reason: collision with root package name */
        private d.a f11465g;

        /* renamed from: h, reason: collision with root package name */
        int f11466h;

        private d(u uVar) {
            c cVar = new c(uVar);
            this.f11464f = cVar;
            this.f11465g = cVar.next().iterator();
            this.f11466h = uVar.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte a() {
            if (!this.f11465g.hasNext()) {
                this.f11465g = this.f11464f.next().iterator();
            }
            this.f11466h--;
            return this.f11465g.a();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11466h > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    private class e extends InputStream {

        /* renamed from: f, reason: collision with root package name */
        private c f11467f;

        /* renamed from: g, reason: collision with root package name */
        private p f11468g;

        /* renamed from: h, reason: collision with root package name */
        private int f11469h;

        /* renamed from: i, reason: collision with root package name */
        private int f11470i;

        /* renamed from: j, reason: collision with root package name */
        private int f11471j;

        /* renamed from: k, reason: collision with root package name */
        private int f11472k;

        public e() {
            d();
        }

        private void c() {
            if (this.f11468g != null) {
                int i10 = this.f11470i;
                int i11 = this.f11469h;
                if (i10 == i11) {
                    this.f11471j += i11;
                    int i12 = 0;
                    this.f11470i = 0;
                    if (this.f11467f.hasNext()) {
                        p next = this.f11467f.next();
                        this.f11468g = next;
                        i12 = next.size();
                    } else {
                        this.f11468g = null;
                    }
                    this.f11469h = i12;
                }
            }
        }

        private void d() {
            c cVar = new c(u.this);
            this.f11467f = cVar;
            p next = cVar.next();
            this.f11468g = next;
            this.f11469h = next.size();
            this.f11470i = 0;
            this.f11471j = 0;
        }

        private int f(byte[] bArr, int i10, int i11) {
            int i12 = i11;
            while (true) {
                if (i12 <= 0) {
                    break;
                }
                c();
                if (this.f11468g != null) {
                    int min = Math.min(this.f11469h - this.f11470i, i12);
                    if (bArr != null) {
                        this.f11468g.t(bArr, this.f11470i, i10, min);
                        i10 += min;
                    }
                    this.f11470i += min;
                    i12 -= min;
                } else if (i12 == i11) {
                    return -1;
                }
            }
            return i11 - i12;
        }

        @Override // java.io.InputStream
        public int available() {
            return u.this.size() - (this.f11471j + this.f11470i);
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f11472k = this.f11471j + this.f11470i;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            c();
            p pVar = this.f11468g;
            if (pVar == null) {
                return -1;
            }
            int i10 = this.f11470i;
            this.f11470i = i10 + 1;
            return pVar.J(i10) & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            Objects.requireNonNull(bArr);
            if (i10 < 0 || i11 < 0 || i11 > bArr.length - i10) {
                throw new IndexOutOfBoundsException();
            }
            return f(bArr, i10, i11);
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            d();
            f(null, 0, this.f11472k);
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            if (j10 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j10 > 2147483647L) {
                j10 = 2147483647L;
            }
            return f(null, 0, (int) j10);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 1;
        while (i10 > 0) {
            arrayList.add(Integer.valueOf(i10));
            int i12 = i11 + i10;
            i11 = i10;
            i10 = i12;
        }
        arrayList.add(Integer.MAX_VALUE);
        f11454m = new int[arrayList.size()];
        int i13 = 0;
        while (true) {
            int[] iArr = f11454m;
            if (i13 >= iArr.length) {
                return;
            }
            iArr[i13] = ((Integer) arrayList.get(i13)).intValue();
            i13++;
        }
    }

    private u(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        this.f11460l = 0;
        this.f11456h = dVar;
        this.f11457i = dVar2;
        int size = dVar.size();
        this.f11458j = size;
        this.f11455g = size + dVar2.size();
        this.f11459k = Math.max(dVar.v(), dVar2.v()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static kotlin.reflect.jvm.internal.impl.protobuf.d M(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        u uVar = dVar instanceof u ? (u) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() != 0) {
            int size = dVar.size() + dVar2.size();
            if (size < 128) {
                return N(dVar, dVar2);
            }
            if (uVar != null && uVar.f11457i.size() + dVar2.size() < 128) {
                dVar2 = new u(uVar.f11456h, N(uVar.f11457i, dVar2));
            } else {
                if (uVar == null || uVar.f11456h.v() <= uVar.f11457i.v() || uVar.v() <= dVar2.v()) {
                    return size >= f11454m[Math.max(dVar.v(), dVar2.v()) + 1] ? new u(dVar, dVar2) : new b().b(dVar, dVar2);
                }
                dVar2 = new u(uVar.f11456h, new u(uVar.f11457i, dVar2));
            }
        }
        return dVar2;
    }

    private static p N(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.t(bArr, 0, 0, size);
        dVar2.t(bArr, 0, size, size2);
        return new p(bArr);
    }

    private boolean O(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
        c cVar = new c(this);
        p next = cVar.next();
        c cVar2 = new c(dVar);
        p next2 = cVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int size = next.size() - i10;
            int size2 = next2.size() - i11;
            int min = Math.min(size, size2);
            if (!(i10 == 0 ? next.K(next2, i11, min) : next2.K(next, i10, min))) {
                return false;
            }
            i12 += min;
            int i13 = this.f11455g;
            if (i12 >= i13) {
                if (i12 == i13) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = cVar.next();
                i10 = 0;
            } else {
                i10 += min;
            }
            if (min == size2) {
                next2 = cVar2.next();
                i11 = 0;
            } else {
                i11 += min;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int B(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f11458j;
        if (i13 <= i14) {
            return this.f11456h.B(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f11457i.B(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f11457i.B(this.f11456h.B(i10, i11, i15), 0, i12 - i15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int C(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f11458j;
        if (i13 <= i14) {
            return this.f11456h.C(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f11457i.C(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f11457i.C(this.f11456h.C(i10, i11, i15), 0, i12 - i15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int D() {
        return this.f11460l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String F(String str) {
        return new String(E(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void I(OutputStream outputStream, int i10, int i11) {
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar;
        int i12 = i10 + i11;
        int i13 = this.f11458j;
        if (i12 <= i13) {
            dVar = this.f11456h;
        } else {
            if (i10 < i13) {
                int i14 = i13 - i10;
                this.f11456h.I(outputStream, i10, i14);
                this.f11457i.I(outputStream, 0, i11 - i14);
                return;
            }
            dVar = this.f11457i;
            i10 -= i13;
        }
        dVar.I(outputStream, i10, i11);
    }

    public boolean equals(Object obj) {
        int D;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
        if (this.f11455g != dVar.size()) {
            return false;
        }
        if (this.f11455g == 0) {
            return true;
        }
        if (this.f11460l == 0 || (D = dVar.D()) == 0 || this.f11460l == D) {
            return O(dVar);
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.f11460l;
        if (i10 == 0) {
            int i11 = this.f11455g;
            i10 = B(i11, 0, i11);
            if (i10 == 0) {
                i10 = 1;
            }
            this.f11460l = i10;
        }
        return i10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f11455g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void u(byte[] bArr, int i10, int i11, int i12) {
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar;
        int i13 = i10 + i12;
        int i14 = this.f11458j;
        if (i13 <= i14) {
            dVar = this.f11456h;
        } else {
            if (i10 < i14) {
                int i15 = i14 - i10;
                this.f11456h.u(bArr, i10, i11, i15);
                this.f11457i.u(bArr, 0, i11 + i15, i12 - i15);
                return;
            }
            dVar = this.f11457i;
            i10 -= i14;
        }
        dVar.u(bArr, i10, i11, i12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int v() {
        return this.f11459k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean w() {
        return this.f11455g >= f11454m[this.f11459k];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean x() {
        int C = this.f11456h.C(0, 0, this.f11458j);
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = this.f11457i;
        return dVar.C(C, 0, dVar.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: y */
    public d.a iterator() {
        return new d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.e z() {
        return kotlin.reflect.jvm.internal.impl.protobuf.e.g(new e());
    }
}
