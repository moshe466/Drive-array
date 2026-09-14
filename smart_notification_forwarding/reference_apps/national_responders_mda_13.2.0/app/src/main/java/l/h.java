package l;

/* loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f11763j = new Object();

    /* renamed from: f, reason: collision with root package name */
    private boolean f11764f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f11765g;

    /* renamed from: h, reason: collision with root package name */
    private Object[] f11766h;

    /* renamed from: i, reason: collision with root package name */
    private int f11767i;

    public h() {
        this(10);
    }

    public h(int i10) {
        this.f11764f = false;
        if (i10 == 0) {
            this.f11765g = c.f11725a;
            this.f11766h = c.f11727c;
        } else {
            int e10 = c.e(i10);
            this.f11765g = new int[e10];
            this.f11766h = new Object[e10];
        }
    }

    private void e() {
        int i10 = this.f11767i;
        int[] iArr = this.f11765g;
        Object[] objArr = this.f11766h;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f11763j) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f11764f = false;
        this.f11767i = i11;
    }

    public void a(int i10, E e10) {
        int i11 = this.f11767i;
        if (i11 != 0 && i10 <= this.f11765g[i11 - 1]) {
            l(i10, e10);
            return;
        }
        if (this.f11764f && i11 >= this.f11765g.length) {
            e();
        }
        int i12 = this.f11767i;
        if (i12 >= this.f11765g.length) {
            int e11 = c.e(i12 + 1);
            int[] iArr = new int[e11];
            Object[] objArr = new Object[e11];
            int[] iArr2 = this.f11765g;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f11766h;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f11765g = iArr;
            this.f11766h = objArr;
        }
        this.f11765g[i12] = i10;
        this.f11766h[i12] = e10;
        this.f11767i = i12 + 1;
    }

    public void b() {
        int i10 = this.f11767i;
        Object[] objArr = this.f11766h;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f11767i = 0;
        this.f11764f = false;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f11765g = (int[]) this.f11765g.clone();
            hVar.f11766h = (Object[]) this.f11766h.clone();
            return hVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public E h(int i10) {
        return i(i10, null);
    }

    public E i(int i10, E e10) {
        int a10 = c.a(this.f11765g, this.f11767i, i10);
        if (a10 >= 0) {
            Object[] objArr = this.f11766h;
            if (objArr[a10] != f11763j) {
                return (E) objArr[a10];
            }
        }
        return e10;
    }

    public int k(int i10) {
        if (this.f11764f) {
            e();
        }
        return this.f11765g[i10];
    }

    public void l(int i10, E e10) {
        int a10 = c.a(this.f11765g, this.f11767i, i10);
        if (a10 >= 0) {
            this.f11766h[a10] = e10;
            return;
        }
        int i11 = ~a10;
        int i12 = this.f11767i;
        if (i11 < i12) {
            Object[] objArr = this.f11766h;
            if (objArr[i11] == f11763j) {
                this.f11765g[i11] = i10;
                objArr[i11] = e10;
                return;
            }
        }
        if (this.f11764f && i12 >= this.f11765g.length) {
            e();
            i11 = ~c.a(this.f11765g, this.f11767i, i10);
        }
        int i13 = this.f11767i;
        if (i13 >= this.f11765g.length) {
            int e11 = c.e(i13 + 1);
            int[] iArr = new int[e11];
            Object[] objArr2 = new Object[e11];
            int[] iArr2 = this.f11765g;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f11766h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f11765g = iArr;
            this.f11766h = objArr2;
        }
        int i14 = this.f11767i;
        if (i14 - i11 != 0) {
            int[] iArr3 = this.f11765g;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr4 = this.f11766h;
            System.arraycopy(objArr4, i11, objArr4, i15, this.f11767i - i11);
        }
        this.f11765g[i11] = i10;
        this.f11766h[i11] = e10;
        this.f11767i++;
    }

    public int m() {
        if (this.f11764f) {
            e();
        }
        return this.f11767i;
    }

    public E n(int i10) {
        if (this.f11764f) {
            e();
        }
        return (E) this.f11766h[i10];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11767i * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f11767i; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(k(i10));
            sb2.append('=');
            E n10 = n(i10);
            if (n10 != this) {
                sb2.append(n10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
