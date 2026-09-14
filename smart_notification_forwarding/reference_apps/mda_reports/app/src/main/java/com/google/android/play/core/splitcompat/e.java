package com.google.android.play.core.splitcompat;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements i {
    final /* synthetic */ Set a;
    final /* synthetic */ AtomicBoolean b;
    private final /* synthetic */ q c;
    private final /* synthetic */ f d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar, q qVar, Set set, AtomicBoolean atomicBoolean) {
        this.d = fVar;
        this.c = qVar;
        this.a = set;
        this.b = atomicBoolean;
    }

    @Override // com.google.android.play.core.splitcompat.i
    public final void a(ZipFile zipFile, Set<k> set) {
        this.d.a(this.c, (Set<k>) set, new h(this));
    }
}
