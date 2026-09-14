package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class A implements H {

    /* renamed from: a, reason: collision with root package name */
    public H[] f3087a;

    @Override // androidx.datastore.preferences.protobuf.H
    public final Q a(Class cls) {
        for (H h2 : this.f3087a) {
            if (h2.b(cls)) {
                return h2.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public final boolean b(Class cls) {
        for (H h2 : this.f3087a) {
            if (h2.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
