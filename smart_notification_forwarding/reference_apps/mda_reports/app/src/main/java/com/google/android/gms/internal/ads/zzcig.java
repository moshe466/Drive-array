package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzsy;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcig implements zzdgt<Bundle> {
    final /* synthetic */ zzcid a;
    private final /* synthetic */ boolean zzfxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcig(zzcid zzcidVar, boolean z) {
        this.a = zzcidVar;
        this.zzfxw = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(Bundle bundle) {
        final ArrayList zzl;
        final zzsy.zzj.zzc zzk;
        final zzsy.zzh zzj;
        zzcht zzchtVar;
        Bundle bundle2 = bundle;
        zzcid zzcidVar = this.a;
        zzl = zzcid.zzl(bundle2);
        zzcid zzcidVar2 = this.a;
        zzk = zzcid.zzk(bundle2);
        zzj = this.a.zzj(bundle2);
        zzchtVar = this.a.zzfxo;
        final boolean z = this.zzfxw;
        zzchtVar.zza(new zzdby(this, z, zzl, zzj, zzk) { // from class: com.google.android.gms.internal.ads.zzcif
            private final boolean zzdym;
            private final zzcig zzfxs;
            private final ArrayList zzfxt;
            private final zzsy.zzh zzfxu;
            private final zzsy.zzj.zzc zzfxv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfxs = this;
                this.zzdym = z;
                this.zzfxt = zzl;
                this.zzfxu = zzj;
                this.zzfxv = zzk;
            }

            @Override // com.google.android.gms.internal.ads.zzdby
            public final Object apply(Object obj) {
                byte[] zza;
                zzcig zzcigVar = this.zzfxs;
                boolean z2 = this.zzdym;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                zza = zzcigVar.a.zza(z2, this.zzfxt, this.zzfxu, this.zzfxv);
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", Long.valueOf(com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis()));
                contentValues.put("serialized_proto_data", zza);
                sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
                if (!z2) {
                    sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "failed_requests"));
                }
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        zzayu.zzex("Failed to get signals bundle");
    }
}
