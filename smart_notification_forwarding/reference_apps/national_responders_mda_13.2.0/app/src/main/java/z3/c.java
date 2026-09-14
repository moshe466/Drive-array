package z3;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    private static final c f16143a = new c();

    private c() {
    }

    public static FilenameFilter a() {
        return f16143a;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean s10;
        s10 = g.s(file, str);
        return s10;
    }
}
