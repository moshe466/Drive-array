package c4;

import java.io.File;
import java.util.Map;

/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public enum a {
        JAVA,
        NATIVE
    }

    Map<String, String> a();

    a b();

    File[] c();

    String d();

    String e();

    File f();

    void remove();
}
