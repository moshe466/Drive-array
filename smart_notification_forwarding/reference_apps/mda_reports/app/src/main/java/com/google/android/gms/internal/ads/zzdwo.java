package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class zzdwo extends zzdwq implements zzbf {
    private String type;
    private long zzauq;
    private zzbi zzhyp;
    private boolean zzhzg;

    public zzdwo(String str) {
        this.type = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final void zza(zzbi zzbiVar) {
        this.zzhyp = zzbiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwq
    public final void zza(zzdws zzdwsVar, long j, zzbe zzbeVar) {
        this.b = zzdwsVar;
        this.c = zzdwsVar.position();
        if (!this.zzhzg) {
            int i = ((8 + j) > 4294967296L ? 1 : ((8 + j) == 4294967296L ? 0 : -1));
        }
        zzdwsVar.zzfc(zzdwsVar.position() + j);
        this.d = zzdwsVar.position();
        this.a = zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final void zza(zzdws zzdwsVar, ByteBuffer byteBuffer, long j, zzbe zzbeVar) {
        this.zzauq = zzdwsVar.position() - byteBuffer.remaining();
        this.zzhzg = byteBuffer.remaining() == 16;
        zza(zzdwsVar, j, zzbeVar);
    }
}
