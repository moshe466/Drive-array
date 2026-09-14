package d9;

import y8.g;

/* loaded from: classes.dex */
public final class c extends d9.a {

    /* renamed from: j, reason: collision with root package name */
    public static final a f8753j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    private static final c f8754k = new c(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f8754k;
        }
    }

    public c(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // d9.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (c() != cVar.c() || f() != cVar.f()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d9.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + f();
    }

    @Override // d9.a
    public boolean isEmpty() {
        return c() > f();
    }

    public boolean t(int i10) {
        return c() <= i10 && i10 <= f();
    }

    @Override // d9.a
    public String toString() {
        return c() + ".." + f();
    }

    public Integer u() {
        return Integer.valueOf(c());
    }
}
