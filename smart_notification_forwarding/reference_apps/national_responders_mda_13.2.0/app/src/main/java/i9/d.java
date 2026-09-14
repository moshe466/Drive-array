package i9;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import y8.k;

/* loaded from: classes.dex */
public interface d<M extends Member> {

    /* loaded from: classes.dex */
    public static final class a {
        public static <M extends Member> void a(d<? extends M> dVar, Object[] objArr) {
            k.e(objArr, "args");
            if (f.a(dVar) == objArr.length) {
                return;
            }
            throw new IllegalArgumentException("Callable expects " + f.a(dVar) + " arguments, but " + objArr.length + " were provided.");
        }
    }

    Object a(Object[] objArr);

    List<Type> b();

    M c();

    Type i();
}
