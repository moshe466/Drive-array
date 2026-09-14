package l;

/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f11728j = new Object();

    /* renamed from: f, reason: collision with root package name */
    private boolean f11729f;

    /* renamed from: g, reason: collision with root package name */
    private long[] f11730g;

    /* renamed from: h, reason: collision with root package name */
    private Object[] f11731h;

    /* renamed from: i, reason: collision with root package name */
    private int f11732i;

    public d() {
        this(10);
    }

    public d(int i10) {
        this.f11729f = false;
        if (i10 == 0) {
            this.f11730g = c.f11726b;
            this.f11731h = c.f11727c;
        } else {
            int f10 = c.f(i10);
            this.f11730g = new long[f10];
            this.f11731h = new Object[f10];
        }
    }

    private void e() {
        int i10 = this.f11732i;
        long[] jArr = this.f11730g;
        Object[] objArr = this.f11731h;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f11728j) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f11729f = false;
        this.f11732i = i11;
    }

    public void a(long j10, E e10) {
        int i10 = this.f11732i;
        if (i10 != 0 && j10 <= this.f11730g[i10 - 1]) {
            m(j10, e10);
            return;
        }
        if (this.f11729f && i10 >= this.f11730g.length) {
            e();
        }
        int i11 = this.f11732i;
        if (i11 >= this.f11730g.length) {
            int f10 = c.f(i11 + 1);
            long[] jArr = new long[f10];
            Object[] objArr = new Object[f10];
            long[] jArr2 = this.f11730g;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f11731h;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f11730g = jArr;
            this.f11731h = objArr;
        }
        this.f11730g[i11] = j10;
        this.f11731h[i11] = e10;
        this.f11732i = i11 + 1;
    }

    public void b() {
        int i10 = this.f11732i;
        Object[] objArr = this.f11731h;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f11732i = 0;
        this.f11729f = false;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f11730g = (long[]) this.f11730g.clone();
            dVar.f11731h = (Object[]) this.f11731h.clone();
            return dVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public E h(long j10) {
        return i(j10, null);
    }

    public E i(long j10, E e10) {
        int b10 = c.b(this.f11730g, this.f11732i, j10);
        if (b10 >= 0) {
            Object[] objArr = this.f11731h;
            if (objArr[b10] != f11728j) {
                return (E) objArr[b10];
            }
        }
        return e10;
    }

    public int k(long j10) {
        if (this.f11729f) {
            e();
        }
        return c.b(this.f11730g, this.f11732i, j10);
    }

    public long l(int i10) {
        if (this.f11729f) {
            e();
        }
        return this.f11730g[i10];
    }

    public void m(long j10, E e10) {
        int b10 = c.b(this.f11730g, this.f11732i, j10);
        if (b10 >= 0) {
            this.f11731h[b10] = e10;
            return;
        }
        int i10 = ~b10;
        int i11 = this.f11732i;
        if (i10 < i11) {
            Object[] objArr = this.f11731h;
            if (objArr[i10] == f11728j) {
                this.f11730g[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.f11729f && i11 >= this.f11730g.length) {
            e();
            i10 = ~c.b(this.f11730g, this.f11732i, j10);
        }
        int i12 = this.f11732i;
        if (i12 >= this.f11730g.length) {
            int f10 = c.f(i12 + 1);
            long[] jArr = new long[f10];
            Object[] objArr2 = new Object[f10];
            long[] jArr2 = this.f11730g;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f11731h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f11730g = jArr;
            this.f11731h = objArr2;
        }
        int i13 = this.f11732i;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f11730g;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f11731h;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f11732i - i10);
        }
        this.f11730g[i10] = j10;
        this.f11731h[i10] = e10;
        this.f11732i++;
    }

    public void n(long j10) {
        int b10 = c.b(this.f11730g, this.f11732i, j10);
        if (b10 >= 0) {
            Object[] objArr = this.f11731h;
            Object obj = objArr[b10];
            Object obj2 = f11728j;
            if (obj != obj2) {
                objArr[b10] = obj2;
                this.f11729f = true;
            }
        }
    }

    public void o(int i10) {
        Object[] objArr = this.f11731h;
        Object obj = objArr[i10];
        Object obj2 = f11728j;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f11729f = true;
        }
    }

    public int p() {
        if (this.f11729f) {
            e();
        }
        return this.f11732i;
    }

    public E q(int i10) {
        if (this.f11729f) {
            e();
        }
        return (E) this.f11731h[i10];
    }

    public String toString() {
        if (p() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11732i * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f11732i; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(l(i10));
            sb2.append('=');
            E q10 = q(i10);
            if (q10 != this) {
                sb2.append(q10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
