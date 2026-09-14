package p8;

import java.io.Serializable;
import p8.f;
import x8.p;
import y8.k;

/* loaded from: classes.dex */
public final class g implements f, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final g f13128f = new g();

    private g() {
    }

    @Override // p8.f
    public <R> R fold(R r10, p<? super R, ? super f.b, ? extends R> pVar) {
        k.e(pVar, "operation");
        return r10;
    }

    @Override // p8.f
    public <E extends f.b> E get(f.c<E> cVar) {
        k.e(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // p8.f
    public f minusKey(f.c<?> cVar) {
        k.e(cVar, "key");
        return this;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
