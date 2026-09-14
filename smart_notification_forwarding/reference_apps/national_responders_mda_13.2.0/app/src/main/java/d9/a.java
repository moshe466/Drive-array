package d9;

import m8.g0;
import y8.g;

/* loaded from: classes.dex */
public class a implements Iterable<Integer>, z8.a {

    /* renamed from: i, reason: collision with root package name */
    public static final C0145a f8745i = new C0145a(null);

    /* renamed from: f, reason: collision with root package name */
    private final int f8746f;

    /* renamed from: g, reason: collision with root package name */
    private final int f8747g;

    /* renamed from: h, reason: collision with root package name */
    private final int f8748h;

    /* renamed from: d9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0145a {
        private C0145a() {
        }

        public /* synthetic */ C0145a(g gVar) {
            this();
        }

        public final a a(int i10, int i11, int i12) {
            return new a(i10, i11, i12);
        }
    }

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f8746f = i10;
        this.f8747g = s8.c.b(i10, i11, i12);
        this.f8748h = i12;
    }

    public final int c() {
        return this.f8746f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f8746f != aVar.f8746f || this.f8747g != aVar.f8747g || this.f8748h != aVar.f8748h) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f8747g;
    }

    public final int g() {
        return this.f8748h;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f8746f * 31) + this.f8747g) * 31) + this.f8748h;
    }

    public boolean isEmpty() {
        if (this.f8748h > 0) {
            if (this.f8746f > this.f8747g) {
                return true;
            }
        } else if (this.f8746f < this.f8747g) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public g0 iterator() {
        return new b(this.f8746f, this.f8747g, this.f8748h);
    }

    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f8748h > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f8746f);
            sb2.append("..");
            sb2.append(this.f8747g);
            sb2.append(" step ");
            i10 = this.f8748h;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f8746f);
            sb2.append(" downTo ");
            sb2.append(this.f8747g);
            sb2.append(" step ");
            i10 = -this.f8748h;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
