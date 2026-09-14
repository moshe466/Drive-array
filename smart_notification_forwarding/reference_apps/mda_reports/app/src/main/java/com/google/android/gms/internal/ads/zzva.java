package com.google.android.gms.internal.ads;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzva extends zzvb<zzacm> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzup zzcdi;
    private final /* synthetic */ FrameLayout zzcdn;
    private final /* synthetic */ FrameLayout zzcdo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzva(zzup zzupVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzcdi = zzupVar;
        this.zzcdn = frameLayout;
        this.zzcdo = frameLayout2;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzacm zza(zzwd zzwdVar) {
        return zzwdVar.zza(ObjectWrapper.wrap(this.zzcdn), ObjectWrapper.wrap(this.zzcdo));
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    protected final /* synthetic */ zzacm zzop() {
        zzup.zza(this.val$context, "native_ad_view_delegate");
        return new zzyh();
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzacm zzoq() {
        zzaej zzaejVar;
        zzaejVar = this.zzcdi.zzcda;
        return zzaejVar.zzb(this.val$context, this.zzcdn, this.zzcdo);
    }
}
