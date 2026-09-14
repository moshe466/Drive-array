package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.l;
import com.google.android.play.core.internal.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends r {
    private final /* synthetic */ com.google.android.play.core.tasks.h a;
    private final /* synthetic */ String b;
    private final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c cVar, com.google.android.play.core.tasks.h hVar, com.google.android.play.core.tasks.h hVar2, String str) {
        super(hVar);
        this.c = cVar;
        this.a = hVar2;
        this.b = str;
    }

    @Override // com.google.android.play.core.internal.r
    protected final void a() {
        com.google.android.play.core.splitcompat.a aVar;
        String str;
        Bundle c;
        try {
            l b = this.c.a.b();
            str = this.c.d;
            c = c.c();
            b.b(str, c, new j(this.c, this.a));
        } catch (RemoteException e) {
            aVar = c.b;
            aVar.a(e, "completeUpdate(%s)", this.b);
            this.a.a((Exception) new RuntimeException(e));
        }
    }
}
