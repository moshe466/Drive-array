package com.google.android.play.core.splitcompat;

import java.util.Set;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements i {
    private final /* synthetic */ Set a;
    private final /* synthetic */ q b;
    private final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Set set, q qVar) {
        this.c = fVar;
        this.a = set;
        this.b = qVar;
    }

    @Override // com.google.android.play.core.splitcompat.i
    public final void a(ZipFile zipFile, Set<k> set) {
        Set a;
        Set set2 = this.a;
        a = this.c.a((Set<k>) set, this.b, zipFile);
        set2.addAll(a);
    }
}
