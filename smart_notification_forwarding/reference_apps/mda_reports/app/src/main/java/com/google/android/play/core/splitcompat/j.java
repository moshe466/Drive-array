package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.io.File;
import java.util.Set;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements l {
    private final /* synthetic */ Set a;
    private final /* synthetic */ q b;
    private final /* synthetic */ ZipFile c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Set set, q qVar, ZipFile zipFile) {
        this.a = set;
        this.b = qVar;
        this.c = zipFile;
    }

    @Override // com.google.android.play.core.splitcompat.l
    public final void a(k kVar, File file, boolean z) {
        this.a.add(file);
        if (z) {
            return;
        }
        Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", this.b.b(), kVar.a, this.b.a().getAbsolutePath(), kVar.b.getName(), file.getAbsolutePath()));
        f.b(this.c, kVar.b, file);
    }
}
