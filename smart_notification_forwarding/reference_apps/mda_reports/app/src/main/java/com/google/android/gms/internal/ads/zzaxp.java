package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaxp extends zzax {
    private final /* synthetic */ byte[] zzdui;
    private final /* synthetic */ Map zzduj;
    private final /* synthetic */ zzayo zzduk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaxp(zzaxk zzaxkVar, int i, String str, zzab zzabVar, zzy zzyVar, byte[] bArr, Map map, zzayo zzayoVar) {
        super(i, str, zzabVar, zzyVar);
        this.zzdui = bArr;
        this.zzduj = map;
        this.zzduk = zzayoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzax, com.google.android.gms.internal.ads.zzq
    /* renamed from: b */
    public final void a(String str) {
        this.zzduk.zzeu(str);
        super.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzq
    public final Map<String, String> getHeaders() {
        Map<String, String> map = this.zzduj;
        return map == null ? super.getHeaders() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzq
    public final byte[] zzf() {
        byte[] bArr = this.zzdui;
        return bArr == null ? super.zzf() : bArr;
    }
}
