package com.google.android.play.core.splitcompat;

import java.io.File;

/* loaded from: classes.dex */
final class h implements l {
    private final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.a = eVar;
    }

    @Override // com.google.android.play.core.splitcompat.l
    public final void a(k kVar, File file, boolean z) {
        this.a.a.add(file);
        if (z) {
            return;
        }
        this.a.b.set(false);
    }
}
