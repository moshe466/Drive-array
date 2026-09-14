package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
final class zzchv implements zzdgt<SQLiteDatabase> {
    private final /* synthetic */ zzdby zzfww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchv(zzcht zzchtVar, zzdby zzdbyVar) {
        this.zzfww = zzdbyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(SQLiteDatabase sQLiteDatabase) {
        try {
            this.zzfww.apply(sQLiteDatabase);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzayu.zzex(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzayu.zzex(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }
}
