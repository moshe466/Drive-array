package com.google.android.gms.common.config;

import com.google.android.gms.common.config.GservicesValue;

/* loaded from: classes.dex */
final class zzb extends GservicesValue<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(String str, Long l) {
        super(str, l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.config.GservicesValue
    protected final /* synthetic */ Long a(String str) {
        GservicesValue.zza zzaVar = null;
        return zzaVar.getLong(this.a, (Long) this.b);
    }
}
