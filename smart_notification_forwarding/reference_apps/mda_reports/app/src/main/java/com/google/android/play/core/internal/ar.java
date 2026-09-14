package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ar implements ad {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ClassLoader classLoader, Set<File> set) {
        al.a(classLoader, set, new au());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return af.a(classLoader, file, file2, z, new ao(), "path", new at());
    }

    @Override // com.google.android.play.core.internal.ad
    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.ad
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return b(classLoader, file, file2, z);
    }
}
