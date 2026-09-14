package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes.dex */
final class zam {
    static final Handler zaa;

    static {
        Context context;
        context = zan.zab;
        zaa = GoogleApiManager.zaa(context).zap();
    }
}
