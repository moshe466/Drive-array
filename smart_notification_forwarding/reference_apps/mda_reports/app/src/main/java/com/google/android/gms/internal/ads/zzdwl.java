package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class zzdwl implements zzbf {
    private static zzdwy zzcr = zzdwy.zzn(zzdwl.class);
    private String type;
    private long zzauq;
    private zzbi zzhyp;
    private ByteBuffer zzhys;
    private long zzhyt;
    private zzdws zzhyv;
    private long zzhyu = -1;
    private ByteBuffer zzhyw = null;
    private boolean zzhyr = true;
    boolean a = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdwl(String str) {
        this.type = str;
    }

    private final synchronized void zzbdi() {
        if (!this.zzhyr) {
            try {
                zzdwy zzdwyVar = zzcr;
                String valueOf = String.valueOf(this.type);
                zzdwyVar.zzhp(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zzhys = this.zzhyv.zzh(this.zzhyt, this.zzhyu);
                this.zzhyr = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final void zza(zzbi zzbiVar) {
        this.zzhyp = zzbiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final void zza(zzdws zzdwsVar, ByteBuffer byteBuffer, long j, zzbe zzbeVar) {
        this.zzhyt = zzdwsVar.position();
        this.zzauq = this.zzhyt - byteBuffer.remaining();
        this.zzhyu = j;
        this.zzhyv = zzdwsVar;
        zzdwsVar.zzfc(zzdwsVar.position() + j);
        this.zzhyr = false;
        this.a = false;
        zzbdj();
    }

    public final synchronized void zzbdj() {
        zzbdi();
        zzdwy zzdwyVar = zzcr;
        String valueOf = String.valueOf(this.type);
        zzdwyVar.zzhp(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.zzhys != null) {
            ByteBuffer byteBuffer = this.zzhys;
            this.a = true;
            byteBuffer.rewind();
            zzg(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzhyw = byteBuffer.slice();
            }
            this.zzhys = null;
        }
    }

    protected abstract void zzg(ByteBuffer byteBuffer);
}
