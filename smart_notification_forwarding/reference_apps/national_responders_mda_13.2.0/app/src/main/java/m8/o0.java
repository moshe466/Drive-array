package m8;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o0<T> extends d<T> {

    /* renamed from: f, reason: collision with root package name */
    private final List<T> f12047f;

    public o0(List<T> list) {
        y8.k.e(list, "delegate");
        this.f12047f = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, T t10) {
        int y10;
        List<T> list = this.f12047f;
        y10 = w.y(this, i10);
        list.add(y10, t10);
    }

    @Override // m8.d
    public int c() {
        return this.f12047f.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f12047f.clear();
    }

    @Override // m8.d
    public T f(int i10) {
        int x10;
        List<T> list = this.f12047f;
        x10 = w.x(this, i10);
        return list.remove(x10);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i10) {
        int x10;
        List<T> list = this.f12047f;
        x10 = w.x(this, i10);
        return list.get(x10);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i10, T t10) {
        int x10;
        List<T> list = this.f12047f;
        x10 = w.x(this, i10);
        return list.set(x10, t10);
    }
}
