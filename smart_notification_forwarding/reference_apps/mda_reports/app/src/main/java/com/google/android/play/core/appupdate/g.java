package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.play.core.internal.o;

/* loaded from: classes.dex */
class g<T> extends o {
    private final com.google.android.play.core.splitcompat.a b;
    private final /* synthetic */ c c;
    final com.google.android.play.core.tasks.h<T> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, com.google.android.play.core.splitcompat.a aVar, com.google.android.play.core.tasks.h<T> hVar) {
        this.c = cVar;
        this.b = aVar;
        this.d = hVar;
    }

    @Override // com.google.android.play.core.internal.p
    public void a(Bundle bundle) {
        this.c.a.a();
        this.b.a("onRequestInfo", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.p
    public void b(Bundle bundle) {
        this.c.a.a();
        this.b.a("onCompleteUpdate", new Object[0]);
    }
}
