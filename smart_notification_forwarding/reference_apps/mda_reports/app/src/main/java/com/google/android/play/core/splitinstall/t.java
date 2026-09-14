package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.bc;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends com.google.android.play.core.internal.r {
    private final /* synthetic */ Collection a;
    private final /* synthetic */ Collection b;
    private final /* synthetic */ com.google.android.play.core.tasks.h c;
    private final /* synthetic */ r d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, com.google.android.play.core.tasks.h hVar, Collection collection, Collection collection2, com.google.android.play.core.tasks.h hVar2) {
        super(hVar);
        this.d = rVar;
        this.a = collection;
        this.b = collection2;
        this.c = hVar2;
    }

    @Override // com.google.android.play.core.internal.r
    protected final void a() {
        ArrayList d;
        ArrayList c;
        String str;
        Bundle d2;
        d = r.d((Collection<String>) this.a);
        c = r.c((Collection<String>) this.b);
        d.addAll(c);
        try {
            bc b = this.d.a.b();
            str = this.d.d;
            d2 = r.d();
            b.a(str, d, d2, new ag(this.d, this.c));
        } catch (RemoteException e) {
            r.b.a(e, "startInstall(%s,%s)", this.a, this.b);
            this.c.a((Exception) new RuntimeException(e));
        }
    }
}
