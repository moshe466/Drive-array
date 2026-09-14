package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am implements ad {
    @Override // com.google.android.play.core.internal.ad
    public final void a(ClassLoader classLoader, Set<File> set) {
        af.b(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.ad
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return af.a(classLoader, file, file2, z, new ai(), "zip", new ah());
    }
}
