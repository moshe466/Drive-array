package ya;

import java.io.InputStream;
import y8.k;

/* loaded from: classes.dex */
public final class d {
    public final InputStream a(String str) {
        k.e(str, "path");
        ClassLoader classLoader = d.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(str);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
