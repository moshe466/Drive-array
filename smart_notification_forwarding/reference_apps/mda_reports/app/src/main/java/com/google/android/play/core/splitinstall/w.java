package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.bc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends com.google.android.play.core.internal.r {
    private final /* synthetic */ int a;
    private final /* synthetic */ com.google.android.play.core.tasks.h b;
    private final /* synthetic */ r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r rVar, com.google.android.play.core.tasks.h hVar, int i, com.google.android.play.core.tasks.h hVar2) {
        super(hVar);
        this.c = rVar;
        this.a = i;
        this.b = hVar2;
    }

    @Override // com.google.android.play.core.internal.r
    protected final void a() {
        String str;
        try {
            bc b = this.c.a.b();
            str = this.c.d;
            b.a(str, this.a, new ae(this.c, this.b));
        } catch (RemoteException e) {
            r.b.a(e, "getSessionState(%d)", Integer.valueOf(this.a));
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
