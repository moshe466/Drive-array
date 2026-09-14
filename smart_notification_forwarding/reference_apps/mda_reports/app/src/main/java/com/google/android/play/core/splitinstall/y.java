package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.bc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends com.google.android.play.core.internal.r {
    private final /* synthetic */ int a;
    private final /* synthetic */ com.google.android.play.core.tasks.h b;
    private final /* synthetic */ r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(r rVar, com.google.android.play.core.tasks.h hVar, int i, com.google.android.play.core.tasks.h hVar2) {
        super(hVar);
        this.c = rVar;
        this.a = i;
        this.b = hVar2;
    }

    @Override // com.google.android.play.core.internal.r
    protected final void a() {
        String str;
        Bundle d;
        try {
            bc b = this.c.a.b();
            str = this.c.d;
            int i = this.a;
            d = r.d();
            b.a(str, i, d, new ab(this.c, this.b));
        } catch (RemoteException e) {
            r.b.a(e, "cancelInstall(%d)", Integer.valueOf(this.a));
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
