package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.gass.AdShield2Logger;
import com.google.android.gms.gass.AdShieldVm;
import com.google.android.gms.gass.internal.Program;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzdc {
    private final Context zzup;
    private final com.google.android.gms.gass.internal.zzk zzuq;
    private final AdShieldVm zzur;
    private final AdShield2Logger zzus;
    private final Executor zzut;
    private boolean zzuu;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzdc(@NonNull Context context, @NonNull AdShield2Logger adShield2Logger, @NonNull com.google.android.gms.gass.internal.zzk zzkVar, @NonNull AdShieldVm adShieldVm, @NonNull Executor executor) {
        this.zzup = context;
        this.zzus = adShield2Logger;
        this.zzuq = zzkVar;
        this.zzur = adShieldVm;
        this.zzut = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbp() {
        String str;
        String str2;
        Program zzdr = this.zzuq.zzdr(com.google.android.gms.gass.internal.zzp.zzgtn);
        if (zzdr != null) {
            String zzcx = zzdr.getProgramMetadata().zzcx();
            str2 = zzdr.getProgramMetadata().zzcy();
            str = zzcx;
        } else {
            str = null;
            str2 = null;
        }
        try {
            com.google.android.gms.gass.internal.zzo zza = com.google.android.gms.gass.zzd.zza(this.zzup, 1, str, str2, "1", this.zzus);
            if (zza.zzgtm != null && zza.zzgtm.length != 0) {
                zzfy zza2 = zzfy.zza(zzdqk.zzu(zza.zzgtm), zzdrg.zzazi());
                if (((zza2.zzct().zzcx().isEmpty() || zza2.zzct().zzcy().isEmpty() || zza2.zzcv().toByteArray().length == 0) ? false : true) && this.zzuq.zza(zza2, null) && this.zzur.initializedVmAndProgram(this.zzuq.zzdr(com.google.android.gms.gass.internal.zzp.zzgtn)) == null) {
                    this.zzuu = true;
                }
            }
        } catch (zzdse e) {
            this.zzus.logException(AdShield2Logger.EVENTID_ERROR_GET_PROGRAM, 0L, e);
        }
    }

    private final void zzbq() {
        if (!this.zzuu || (this.zzur.getProgram() != null && this.zzur.getProgram().isAlmostExpired())) {
            zzbo();
        }
    }

    public final String zza(Context context, View view, Activity activity) {
        zzbq();
        if (!zzbn()) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String impressionSignals = this.zzur.getImpressionSignals(context, null, view, activity);
        this.zzus.logSignals(AdShield2Logger.EVENTID_VIEW_SIGNALS, System.currentTimeMillis() - currentTimeMillis, impressionSignals, null);
        return impressionSignals;
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        zzbq();
        if (!zzbn()) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String clickSignals = this.zzur.getClickSignals(context, null, str, view, activity);
        this.zzus.logSignals(AdShield2Logger.EVENTID_CLICK_SIGNALS, System.currentTimeMillis() - currentTimeMillis, clickSignals, null);
        return clickSignals;
    }

    public final void zza(MotionEvent motionEvent) {
        zzbq();
        if (zzbn()) {
            this.zzur.reportTouchEvent(null, motionEvent);
        }
    }

    public final String zzb(Context context) {
        zzbq();
        if (!zzbn()) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String querySignals = this.zzur.getQuerySignals(context, null);
        this.zzus.logSignals(AdShield2Logger.EVENTID_QUERY_SIGNALS, System.currentTimeMillis() - currentTimeMillis, querySignals, null);
        return querySignals;
    }

    public final synchronized boolean zzbn() {
        if (this.zzuu) {
            return true;
        }
        Program zzdr = this.zzuq.zzdr(com.google.android.gms.gass.internal.zzp.zzgtn);
        if (zzdr != null && !zzdr.isExpired() && this.zzur.initializedVmAndProgram(zzdr) == null) {
            this.zzuu = true;
        }
        return this.zzuu;
    }

    public final void zzbo() {
        this.zzut.execute(new zzdf(this));
    }
}
