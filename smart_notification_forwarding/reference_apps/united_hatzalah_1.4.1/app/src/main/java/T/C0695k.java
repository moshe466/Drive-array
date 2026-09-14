package t;

import java.util.Arrays;
import t2.AbstractC0705g;
import u.AbstractC0717a;

/* renamed from: t.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0695k implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ int[] f6367a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object[] f6368b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f6369c;

    public C0695k() {
        int i;
        int i3 = 4;
        while (true) {
            i = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i = i4;
                break;
            }
            i3++;
        }
        int i5 = i / 4;
        this.f6367a = new int[i5];
        this.f6368b = new Object[i5];
    }

    public final void a(int i, Object obj) {
        int i3 = this.f6369c;
        if (i3 != 0 && i <= this.f6367a[i3 - 1]) {
            c(i, obj);
            return;
        }
        if (i3 >= this.f6367a.length) {
            int i4 = (i3 + 1) * 4;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 4;
            int[] copyOf = Arrays.copyOf(this.f6367a, i7);
            kotlin.jvm.internal.j.d(copyOf, "copyOf(this, newSize)");
            this.f6367a = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f6368b, i7);
            kotlin.jvm.internal.j.d(copyOf2, "copyOf(this, newSize)");
            this.f6368b = copyOf2;
        }
        this.f6367a[i3] = i;
        this.f6368b[i3] = obj;
        this.f6369c = i3 + 1;
    }

    public final Object b(int i) {
        Object obj;
        int a2 = AbstractC0717a.a(this.f6369c, i, this.f6367a);
        if (a2 >= 0 && (obj = this.f6368b[a2]) != AbstractC0692h.f6363b) {
            return obj;
        }
        return null;
    }

    public final void c(int i, Object obj) {
        int a2 = AbstractC0717a.a(this.f6369c, i, this.f6367a);
        if (a2 >= 0) {
            this.f6368b[a2] = obj;
            return;
        }
        int i3 = ~a2;
        int i4 = this.f6369c;
        if (i3 < i4) {
            Object[] objArr = this.f6368b;
            if (objArr[i3] == AbstractC0692h.f6363b) {
                this.f6367a[i3] = i;
                objArr[i3] = obj;
                return;
            }
        }
        if (i4 >= this.f6367a.length) {
            int i5 = (i4 + 1) * 4;
            int i6 = 4;
            while (true) {
                if (i6 >= 32) {
                    break;
                }
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
            int i8 = i5 / 4;
            int[] copyOf = Arrays.copyOf(this.f6367a, i8);
            kotlin.jvm.internal.j.d(copyOf, "copyOf(this, newSize)");
            this.f6367a = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f6368b, i8);
            kotlin.jvm.internal.j.d(copyOf2, "copyOf(this, newSize)");
            this.f6368b = copyOf2;
        }
        int i9 = this.f6369c;
        if (i9 - i3 != 0) {
            int[] iArr = this.f6367a;
            int i10 = i3 + 1;
            AbstractC0705g.D(i10, i3, iArr, iArr, i9);
            Object[] objArr2 = this.f6368b;
            AbstractC0705g.E(objArr2, i10, objArr2, i3, this.f6369c);
        }
        this.f6367a[i3] = i;
        this.f6368b[i3] = obj;
        this.f6369c++;
    }

    public final Object clone() {
        Object clone = super.clone();
        kotlin.jvm.internal.j.c(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        C0695k c0695k = (C0695k) clone;
        c0695k.f6367a = (int[]) this.f6367a.clone();
        c0695k.f6368b = (Object[]) this.f6368b.clone();
        return c0695k;
    }

    public final String toString() {
        int i = this.f6369c;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        int i3 = this.f6369c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(this.f6367a[i4]);
            sb.append('=');
            Object obj = this.f6368b[i4];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "buffer.toString()");
        return sb2;
    }
}
