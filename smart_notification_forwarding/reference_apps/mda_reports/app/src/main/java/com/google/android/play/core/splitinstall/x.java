package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.bc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends com.google.android.play.core.internal.r {
    private final /* synthetic */ List a;
    private final /* synthetic */ com.google.android.play.core.tasks.h b;
    private final /* synthetic */ r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(r rVar, com.google.android.play.core.tasks.h hVar, List list, com.google.android.play.core.tasks.h hVar2) {
        super(hVar);
        this.c = rVar;
        this.a = list;
        this.b = hVar2;
    }

    @Override // com.google.android.play.core.internal.r
    protected final void a() {
        String str;
        ArrayList c;
        Bundle d;
        try {
            bc b = this.c.a.b();
            str = this.c.d;
            c = r.c((Collection<String>) this.a);
            d = r.d();
            b.e(str, c, d, new ac(this.c, this.b));
        } catch (RemoteException e) {
            r.b.a(e, "deferredLanguageUninstall(%s)", this.a);
            this.b.a((Exception) new RuntimeException(e));
        }
    }
}
