package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.bc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z extends com.google.android.play.core.internal.r {
    private final /* synthetic */ com.google.android.play.core.tasks.h a;
    private final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(r rVar, com.google.android.play.core.tasks.h hVar, com.google.android.play.core.tasks.h hVar2) {
        super(hVar);
        this.b = rVar;
        this.a = hVar2;
    }

    @Override // com.google.android.play.core.internal.r
    protected final void a() {
        String str;
        try {
            bc b = this.b.a.b();
            str = this.b.d;
            b.a(str, new ah(this.b, this.a));
        } catch (RemoteException e) {
            r.b.a(e, "getSessionStates", new Object[0]);
            this.a.a((Exception) new RuntimeException(e));
        }
    }
}
