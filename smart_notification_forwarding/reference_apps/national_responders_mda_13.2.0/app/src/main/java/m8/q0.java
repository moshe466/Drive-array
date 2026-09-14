package m8;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q0 {
    public static <T> Set<T> a(T t10) {
        Set<T> singleton = Collections.singleton(t10);
        y8.k.d(singleton, "singleton(element)");
        return singleton;
    }
}
