package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class m extends g implements l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    @Override // com.google.android.play.core.internal.l
    public final void a(String str, Bundle bundle, p pVar) {
        Parcel a = a();
        a.writeString(str);
        i.a(a, bundle);
        i.a(a, pVar);
        a(2, a);
    }

    @Override // com.google.android.play.core.internal.l
    public final void b(String str, Bundle bundle, p pVar) {
        Parcel a = a();
        a.writeString(str);
        i.a(a, bundle);
        i.a(a, pVar);
        a(3, a);
    }
}
