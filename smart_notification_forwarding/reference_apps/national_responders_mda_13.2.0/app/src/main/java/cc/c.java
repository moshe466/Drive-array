package cc;

import java.util.Objects;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public class c {
    public static <T> T c(T t10, final String str, final Object... objArr) {
        Objects.requireNonNull(t10, (Supplier<String>) new Supplier() { // from class: cc.b
            @Override // java.util.function.Supplier
            public final Object get() {
                String format;
                format = String.format(str, objArr);
                return format;
            }
        });
        return t10;
    }
}
