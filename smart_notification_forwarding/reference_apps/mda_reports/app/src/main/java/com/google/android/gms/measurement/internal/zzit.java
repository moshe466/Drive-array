package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzit extends zzaf {
    private final /* synthetic */ zzij zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzit(zzij zzijVar, zzgt zzgtVar) {
        super(zzgtVar);
        this.zza = zzijVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaf
    public final void zza() {
        this.zza.zzr().zzi().zza("Tasks have been queued for a long time");
    }
}
