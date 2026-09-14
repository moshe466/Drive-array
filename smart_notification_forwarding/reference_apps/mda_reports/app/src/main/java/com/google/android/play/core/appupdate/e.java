package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.l;
import com.google.android.play.core.internal.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends r {
    private final /* synthetic */ String a;
    private final /* synthetic */ com.google.android.play.core.tasks.h b;
    private final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, com.google.android.play.core.tasks.h hVar, String str, com.google.android.play.core.tasks.h hVar2) {
        super(hVar);
        this.c = cVar;
        this.a = str;
        this.b = hVar2;
    }

    @Override // com.google.android.play.core.internal.r
    protected final void a() {
        com.google.android.play.core.splitcompat.a aVar;
        String str;
        Bundle c;
        try {
            l b = this.c.a.b();
            str = this.c.d;
            c = this.c.c(this.a);
            b.a(str, c, new i(this.c, this.b, this.a));
        } catch (RemoteException e) {
            aVar = c.b;
            aVar.a(e, "requestUpdateInfo(%s)", this.a);
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
