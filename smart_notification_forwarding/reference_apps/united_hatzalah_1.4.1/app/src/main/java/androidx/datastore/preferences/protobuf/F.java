package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class F {
    public static E a(Object obj, Object obj2) {
        E e4 = (E) obj;
        E e5 = (E) obj2;
        if (!e5.isEmpty()) {
            if (!e4.f3096a) {
                e4 = e4.b();
            }
            e4.a();
            if (!e5.isEmpty()) {
                e4.putAll(e5);
            }
        }
        return e4;
    }
}
