package com.google.android.play.core.splitcompat;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements com.google.android.play.core.splitinstall.k {
    private final /* synthetic */ SplitCompat a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SplitCompat splitCompat) {
        this.a = splitCompat;
    }

    @Override // com.google.android.play.core.splitinstall.k
    public final Set<String> a() {
        Set<String> c;
        c = this.a.c();
        return c;
    }
}
