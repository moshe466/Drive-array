package com.google.firebase.sessions;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$2 extends k implements F2.a {
    final /* synthetic */ Context $appContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$2(Context context) {
        super(0);
        this.$appContext = context;
    }

    @Override // F2.a
    public final File invoke() {
        return m3.b.G(this.$appContext, SessionDataStoreConfigs.INSTANCE.getSESSIONS_CONFIG_NAME());
    }
}
