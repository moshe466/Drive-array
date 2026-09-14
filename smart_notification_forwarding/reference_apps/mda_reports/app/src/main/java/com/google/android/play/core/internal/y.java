package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class y extends r {
    private final /* synthetic */ IBinder a;
    private final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(z zVar, IBinder iBinder) {
        this.b = zVar;
        this.a = iBinder;
    }

    @Override // com.google.android.play.core.internal.r
    public final void a() {
        w wVar;
        List list;
        List list2;
        t tVar = this.b.a;
        wVar = tVar.h;
        tVar.l = (IInterface) wVar.a(this.a);
        this.b.a.e();
        t.a(this.b.a, false);
        list = this.b.a.e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        list2 = this.b.a.e;
        list2.clear();
    }
}
