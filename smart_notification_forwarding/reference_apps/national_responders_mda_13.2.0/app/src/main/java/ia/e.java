package ia;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import y8.k;

/* loaded from: classes.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends i.d<M>, T> T a(i.d<M> dVar, i.f<M, T> fVar) {
        k.e(dVar, "<this>");
        k.e(fVar, "extension");
        if (dVar.y(fVar)) {
            return (T) dVar.v(fVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends i.d<M>, T> T b(i.d<M> dVar, i.f<M, List<T>> fVar, int i10) {
        k.e(dVar, "<this>");
        k.e(fVar, "extension");
        if (i10 < dVar.x(fVar)) {
            return (T) dVar.w(fVar, i10);
        }
        return null;
    }
}
