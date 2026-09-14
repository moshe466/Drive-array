package q2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g1 extends f1 {

    /* renamed from: j, reason: collision with root package name */
    static final f1 f13494j = new g1(new Object[0], 0);

    /* renamed from: h, reason: collision with root package name */
    final transient Object[] f13495h;

    /* renamed from: i, reason: collision with root package name */
    private final transient int f13496i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(Object[] objArr, int i10) {
        this.f13495h = objArr;
        this.f13496i = i10;
    }

    @Override // q2.f1, q2.c1
    final int c(Object[] objArr, int i10) {
        System.arraycopy(this.f13495h, 0, objArr, 0, this.f13496i);
        return this.f13496i;
    }

    @Override // q2.c1
    final int f() {
        return this.f13496i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q2.c1
    public final int g() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        z0.a(i10, this.f13496i, "index");
        Object obj = this.f13495h[i10];
        obj.getClass();
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q2.c1
    public final boolean s() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13496i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q2.c1
    public final Object[] t() {
        return this.f13495h;
    }
}
