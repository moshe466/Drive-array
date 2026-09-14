package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzxt extends zzagt {
    private final OnInitializationCompleteListener zzcff;
    private final /* synthetic */ zzxq zzcfg;

    private zzxt(zzxq zzxqVar, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zzcfg = zzxqVar;
        this.zzcff = onInitializationCompleteListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzxt(zzxq zzxqVar, OnInitializationCompleteListener onInitializationCompleteListener, zzxu zzxuVar) {
        this(zzxqVar, onInitializationCompleteListener);
    }

    @Override // com.google.android.gms.internal.ads.zzagu
    public final void zzc(List<zzagn> list) {
        InitializationStatus zzb;
        OnInitializationCompleteListener onInitializationCompleteListener = this.zzcff;
        zzxq zzxqVar = this.zzcfg;
        zzb = zzxq.zzb(list);
        onInitializationCompleteListener.onInitializationComplete(zzb);
    }
}
