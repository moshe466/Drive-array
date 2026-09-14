package R;

import java.io.File;

/* loaded from: classes.dex */
public final class T extends kotlin.jvm.internal.k implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public static final T f1821a = new kotlin.jvm.internal.k(1);

    @Override // F2.l
    public final Object invoke(Object obj) {
        File it = (File) obj;
        kotlin.jvm.internal.j.e(it, "it");
        String absolutePath = it.getCanonicalFile().getAbsolutePath();
        kotlin.jvm.internal.j.d(absolutePath, "file.canonicalFile.absolutePath");
        return new j0(absolutePath);
    }
}
