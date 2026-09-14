package androidx.loader.app;

import androidx.lifecycle.f0;
import androidx.lifecycle.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {
    public static <T extends l & f0> a b(T t10) {
        return new b(t10, t10.F());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
