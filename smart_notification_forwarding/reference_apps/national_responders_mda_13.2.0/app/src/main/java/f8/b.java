package f8;

import y7.d;
import y7.f;

/* loaded from: classes.dex */
public enum b implements c8.a {
    INSTANCE,
    NEVER;

    public static void complete(y7.a aVar) {
        aVar.c(INSTANCE);
        aVar.b();
    }

    public static void complete(y7.b<?> bVar) {
        bVar.c(INSTANCE);
        bVar.b();
    }

    public static void complete(d<?> dVar) {
        dVar.c(INSTANCE);
        dVar.b();
    }

    public static void error(Throwable th, y7.a aVar) {
        aVar.c(INSTANCE);
        aVar.a(th);
    }

    public static void error(Throwable th, y7.b<?> bVar) {
        bVar.c(INSTANCE);
        bVar.a(th);
    }

    public static void error(Throwable th, d<?> dVar) {
        dVar.c(INSTANCE);
        dVar.a(th);
    }

    public static void error(Throwable th, f<?> fVar) {
        fVar.c(INSTANCE);
        fVar.a(th);
    }

    public void clear() {
    }

    @Override // c8.a
    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        return null;
    }

    public int requestFusion(int i10) {
        return i10 & 2;
    }
}
