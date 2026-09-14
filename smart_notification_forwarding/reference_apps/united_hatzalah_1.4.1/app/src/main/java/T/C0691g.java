package t;

import java.util.Arrays;
import t2.AbstractC0705g;
import u.AbstractC0717a;

/* renamed from: t.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0691g implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f6358a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f6359b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f6360c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f6361d;

    public C0691g() {
        int i;
        int i3 = 4;
        while (true) {
            i = 80;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (80 <= i4) {
                i = i4;
                break;
            }
            i3++;
        }
        int i5 = i / 8;
        this.f6359b = new long[i5];
        this.f6360c = new Object[i5];
    }

    public final void a() {
        int i = this.f6361d;
        Object[] objArr = this.f6360c;
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = null;
        }
        this.f6361d = 0;
        this.f6358a = false;
    }

    public final Object b(long j2) {
        Object obj;
        int b4 = AbstractC0717a.b(this.f6359b, this.f6361d, j2);
        if (b4 >= 0 && (obj = this.f6360c[b4]) != AbstractC0692h.f6362a) {
            return obj;
        }
        return null;
    }

    public final long c(int i) {
        int i3;
        if (i >= 0 && i < (i3 = this.f6361d)) {
            if (this.f6358a) {
                long[] jArr = this.f6359b;
                Object[] objArr = this.f6360c;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj = objArr[i5];
                    if (obj != AbstractC0692h.f6362a) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr[i4] = obj;
                            objArr[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f6358a = false;
                this.f6361d = i4;
            }
            return this.f6359b[i];
        }
        throw new IllegalArgumentException(e0.a.c(i, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final Object clone() {
        Object clone = super.clone();
        kotlin.jvm.internal.j.c(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        C0691g c0691g = (C0691g) clone;
        c0691g.f6359b = (long[]) this.f6359b.clone();
        c0691g.f6360c = (Object[]) this.f6360c.clone();
        return c0691g;
    }

    public final void d(long j2, Object obj) {
        Object obj2 = AbstractC0692h.f6362a;
        int b4 = AbstractC0717a.b(this.f6359b, this.f6361d, j2);
        if (b4 >= 0) {
            this.f6360c[b4] = obj;
            return;
        }
        int i = ~b4;
        int i3 = this.f6361d;
        if (i < i3) {
            Object[] objArr = this.f6360c;
            if (objArr[i] == obj2) {
                this.f6359b[i] = j2;
                objArr[i] = obj;
                return;
            }
        }
        if (this.f6358a) {
            long[] jArr = this.f6359b;
            if (i3 >= jArr.length) {
                Object[] objArr2 = this.f6360c;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj3 = objArr2[i5];
                    if (obj3 != obj2) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr2[i4] = obj3;
                            objArr2[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f6358a = false;
                this.f6361d = i4;
                i = ~AbstractC0717a.b(this.f6359b, i4, j2);
            }
        }
        int i6 = this.f6361d;
        if (i6 >= this.f6359b.length) {
            int i7 = (i6 + 1) * 8;
            int i8 = 4;
            while (true) {
                if (i8 >= 32) {
                    break;
                }
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
                i8++;
            }
            int i10 = i7 / 8;
            long[] copyOf = Arrays.copyOf(this.f6359b, i10);
            kotlin.jvm.internal.j.d(copyOf, "copyOf(this, newSize)");
            this.f6359b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f6360c, i10);
            kotlin.jvm.internal.j.d(copyOf2, "copyOf(this, newSize)");
            this.f6360c = copyOf2;
        }
        int i11 = this.f6361d - i;
        if (i11 != 0) {
            long[] jArr2 = this.f6359b;
            int i12 = i + 1;
            kotlin.jvm.internal.j.e(jArr2, "<this>");
            System.arraycopy(jArr2, i, jArr2, i12, i11);
            Object[] objArr3 = this.f6360c;
            AbstractC0705g.E(objArr3, i12, objArr3, i, this.f6361d);
        }
        this.f6359b[i] = j2;
        this.f6360c[i] = obj;
        this.f6361d++;
    }

    public final int e() {
        if (this.f6358a) {
            int i = this.f6361d;
            long[] jArr = this.f6359b;
            Object[] objArr = this.f6360c;
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                Object obj = objArr[i4];
                if (obj != AbstractC0692h.f6362a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f6358a = false;
            this.f6361d = i3;
        }
        return this.f6361d;
    }

    public final Object f(int i) {
        int i3;
        if (i >= 0 && i < (i3 = this.f6361d)) {
            if (this.f6358a) {
                long[] jArr = this.f6359b;
                Object[] objArr = this.f6360c;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj = objArr[i5];
                    if (obj != AbstractC0692h.f6362a) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr[i4] = obj;
                            objArr[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f6358a = false;
                this.f6361d = i4;
            }
            return this.f6360c[i];
        }
        throw new IllegalArgumentException(e0.a.c(i, "Expected index to be within 0..size()-1, but was ").toString());
    }

    public final String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6361d * 28);
        sb.append('{');
        int i = this.f6361d;
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(c(i3));
            sb.append('=');
            Object f4 = f(i3);
            if (f4 != sb) {
                sb.append(f4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
