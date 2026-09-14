package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class ah extends ai<List<SplitInstallSessionState>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(r rVar, com.google.android.play.core.tasks.h<List<SplitInstallSessionState>> hVar) {
        super(rVar, hVar);
    }

    @Override // com.google.android.play.core.splitinstall.ai, com.google.android.play.core.internal.bd
    public final void a(List<Bundle> list) {
        super.a(list);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Bundle> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(SplitInstallSessionState.a(it.next()));
        }
        this.c.a((com.google.android.play.core.tasks.h<T>) arrayList);
    }
}
