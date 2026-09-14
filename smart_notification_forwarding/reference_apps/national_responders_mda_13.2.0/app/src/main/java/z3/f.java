package z3;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
final /* synthetic */ class f implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    private static final f f16146a = new f();

    private f() {
    }

    public static FilenameFilter a() {
        return f16146a;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean startsWith;
        startsWith = str.startsWith("event");
        return startsWith;
    }
}
