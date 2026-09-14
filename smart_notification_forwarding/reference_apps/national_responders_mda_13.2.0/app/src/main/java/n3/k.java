package n3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final class k {
    static {
        Logger.getLogger(k.class.getName());
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(Object[] objArr, int i10, int i11, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i10, i11, tArr.getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] b(T[] tArr, int i10) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
    }
}
