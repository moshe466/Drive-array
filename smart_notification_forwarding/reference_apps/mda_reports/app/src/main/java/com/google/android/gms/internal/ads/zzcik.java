package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.internal.ads.zzso;
import com.google.android.gms.internal.ads.zzsy;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzcik {
    private zzazb zzdij;
    private zzcht zzfxo;
    private zzsm zzfya;
    private Context zzup;

    public zzcik(Context context, zzazb zzazbVar, zzsm zzsmVar, zzcht zzchtVar) {
        this.zzup = context;
        this.zzdij = zzazbVar;
        this.zzfya = zzsmVar;
        this.zzfxo = zzchtVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void a(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzsy.zzj.zza> zza = zzcih.zza(sQLiteDatabase);
        final zzsy.zzj zzjVar = (zzsy.zzj) zzsy.zzj.zzno().zzca(this.zzup.getPackageName()).zzcb(Build.MODEL).zzcd(zzcih.zza(sQLiteDatabase, 0)).zzc(zza).zzce(zzcih.zza(sQLiteDatabase, 1)).zzes(com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis()).zzet(zzcih.zzb(sQLiteDatabase, 2)).zzbaf();
        int size = zza.size();
        long j = 0;
        int i = 0;
        while (i < size) {
            zzsy.zzj.zza zzaVar = zza.get(i);
            i++;
            zzsy.zzj.zza zzaVar2 = zzaVar;
            if (zzaVar2.zznq() == zzte.ENUM_TRUE && zzaVar2.getTimestamp() > j) {
                j = zzaVar2.getTimestamp();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
        this.zzfya.zza(new zzsp(zzjVar) { // from class: com.google.android.gms.internal.ads.zzcim
            private final zzsy.zzj zzfyc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyc = zzjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzsp
            public final void zza(zztu zztuVar) {
                zztuVar.zzcaz = this.zzfyc;
            }
        });
        final zztt zzttVar = new zztt();
        zzttVar.zzcam = Integer.valueOf(this.zzdij.zzdvz);
        zzttVar.zzcan = Integer.valueOf(this.zzdij.zzdwa);
        zzttVar.zzcao = Integer.valueOf(this.zzdij.zzdwb ? 0 : 2);
        this.zzfya.zza(new zzsp(zzttVar) { // from class: com.google.android.gms.internal.ads.zzcil
            private final zztt zzfyb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyb = zzttVar;
            }

            @Override // com.google.android.gms.internal.ads.zzsp
            public final void zza(zztu zztuVar) {
                zztuVar.zzcav.zzcah = this.zzfyb;
            }
        });
        this.zzfya.zza(zzso.zza.EnumC0023zza.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues3, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }

    public final void zzamc() {
        try {
            this.zzfxo.zza(new zzdby(this) { // from class: com.google.android.gms.internal.ads.zzcij
                private final zzcik zzfxz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfxz = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdby
                public final Object apply(Object obj) {
                    return this.zzfxz.a((SQLiteDatabase) obj);
                }
            });
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzayu.zzex(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }
}
