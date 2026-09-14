package g8;

import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* loaded from: classes.dex */
    static class a {
        a() {
        }
    }

    static {
        new a();
    }

    public static <T> T a(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }
}
