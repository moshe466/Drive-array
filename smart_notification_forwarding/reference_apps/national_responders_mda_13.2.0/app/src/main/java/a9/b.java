package a9;

import e9.j;
import y8.k;

/* loaded from: classes.dex */
public abstract class b<V> implements c<Object, V> {

    /* renamed from: a, reason: collision with root package name */
    private V f332a;

    public b(V v10) {
        this.f332a = v10;
    }

    @Override // a9.c
    public V a(Object obj, j<?> jVar) {
        k.e(jVar, "property");
        return this.f332a;
    }

    @Override // a9.c
    public void b(Object obj, j<?> jVar, V v10) {
        k.e(jVar, "property");
        V v11 = this.f332a;
        if (d(jVar, v11, v10)) {
            this.f332a = v10;
            c(jVar, v11, v10);
        }
    }

    protected void c(j<?> jVar, V v10, V v11) {
        k.e(jVar, "property");
    }

    protected boolean d(j<?> jVar, V v10, V v11) {
        k.e(jVar, "property");
        return true;
    }
}
