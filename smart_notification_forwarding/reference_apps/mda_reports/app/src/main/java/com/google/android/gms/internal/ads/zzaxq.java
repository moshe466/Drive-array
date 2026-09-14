package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzaxq extends zzq<zzo> {
    private final Map<String, String> zzab;
    private final zzazl<zzo> zzdul;
    private final zzayo zzdum;

    public zzaxq(String str, zzazl<zzo> zzazlVar) {
        this(str, null, zzazlVar);
    }

    private zzaxq(String str, Map<String, String> map, zzazl<zzo> zzazlVar) {
        super(0, str, new zzaxt(zzazlVar));
        this.zzab = null;
        this.zzdul = zzazlVar;
        this.zzdum = new zzayo();
        this.zzdum.zza(str, HttpRequest.METHOD_GET, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzq
    public final zzz<zzo> a(zzo zzoVar) {
        return zzz.zza(zzoVar, zzas.zzb(zzoVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzq
    public final /* synthetic */ void a(zzo zzoVar) {
        zzo zzoVar2 = zzoVar;
        this.zzdum.zza(zzoVar2.zzab, zzoVar2.statusCode);
        zzayo zzayoVar = this.zzdum;
        byte[] bArr = zzoVar2.data;
        if (zzayo.isEnabled() && bArr != null) {
            zzayoVar.zzi(bArr);
        }
        this.zzdul.set(zzoVar2);
    }
}
