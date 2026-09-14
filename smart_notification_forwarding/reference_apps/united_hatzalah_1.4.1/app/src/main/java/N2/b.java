package N2;

import F0.AbstractC0008a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public int f1510a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f1511b;

    /* renamed from: c, reason: collision with root package name */
    public int f1512c;

    /* renamed from: d, reason: collision with root package name */
    public K2.f f1513d;

    /* renamed from: e, reason: collision with root package name */
    public int f1514e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f1515f;

    public b(c cVar) {
        this.f1515f = cVar;
        int length = cVar.f1516a.length();
        if (length >= 0) {
            length = length >= 0 ? 0 : length;
            this.f1511b = length;
            this.f1512c = length;
            return;
        }
        throw new IllegalArgumentException(AbstractC0008a.j(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r6 < r3) goto L10;
     */
    /* JADX WARN: Type inference failed for: r0v7, types: [K2.f, K2.d] */
    /* JADX WARN: Type inference failed for: r0v8, types: [K2.f, K2.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r7 = this;
            int r0 = r7.f1512c
            r1 = 0
            if (r0 >= 0) goto Lb
            r7.f1510a = r1
            r0 = 0
            r7.f1513d = r0
            return
        Lb:
            N2.c r2 = r7.f1515f
            int r3 = r2.f1517b
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L1a
            int r6 = r7.f1514e
            int r6 = r6 + r5
            r7.f1514e = r6
            if (r6 >= r3) goto L22
        L1a:
            java.lang.CharSequence r3 = r2.f1516a
            int r3 = r3.length()
            if (r0 <= r3) goto L34
        L22:
            K2.f r0 = new K2.f
            int r1 = r7.f1511b
            java.lang.CharSequence r2 = r2.f1516a
            int r2 = N2.f.Q(r2)
            r0.<init>(r1, r2, r5)
            r7.f1513d = r0
            r7.f1512c = r4
            goto L79
        L34:
            F2.p r0 = r2.f1518c
            java.lang.CharSequence r3 = r2.f1516a
            int r6 = r7.f1512c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.invoke(r3, r6)
            s2.d r0 = (s2.C0679d) r0
            if (r0 != 0) goto L58
            K2.f r0 = new K2.f
            int r1 = r7.f1511b
            java.lang.CharSequence r2 = r2.f1516a
            int r2 = N2.f.Q(r2)
            r0.<init>(r1, r2, r5)
            r7.f1513d = r0
            r7.f1512c = r4
            goto L79
        L58:
            java.lang.Object r2 = r0.f6332a
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.f6333b
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.f1511b
            K2.f r3 = T.b.Q(r3, r2)
            r7.f1513d = r3
            int r2 = r2 + r0
            r7.f1511b = r2
            if (r0 != 0) goto L76
            r1 = r5
        L76:
            int r2 = r2 + r1
            r7.f1512c = r2
        L79:
            r7.f1510a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.b.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1510a == -1) {
            a();
        }
        if (this.f1510a == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f1510a == -1) {
            a();
        }
        if (this.f1510a != 0) {
            K2.f fVar = this.f1513d;
            kotlin.jvm.internal.j.c(fVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f1513d = null;
            this.f1510a = -1;
            return fVar;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
