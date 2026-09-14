package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaih implements zzaia, zzaif {
    private final zzbdi zzcza;
    private final Context zzup;

    public zzaih(Context context, zzazb zzazbVar, @Nullable zzdq zzdqVar, com.google.android.gms.ads.internal.zza zzaVar) {
        this.zzup = context;
        com.google.android.gms.ads.internal.zzq.zzkr();
        this.zzcza = zzbdr.zza(context, zzbey.zzabq(), "", false, false, zzdqVar, zzazbVar, null, null, null, zzsm.zzmt(), null, false);
        this.zzcza.getView().setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzve.zzou();
        if (zzayk.zzxe()) {
            runnable.run();
        } else {
            zzawb.zzdsr.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        this.zzcza.zzcy(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void destroy() {
        this.zzcza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final boolean isDestroyed() {
        return this.zzcza.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(zzaii zzaiiVar) {
        zzbev zzaaa = this.zzcza.zzaaa();
        zzaiiVar.getClass();
        zzaaa.zza(zzaim.a(zzaiiVar));
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void zza(String str, zzafn<? super zzajq> zzafnVar) {
        this.zzcza.zza(str, new zzaiq(this, zzafnVar));
    }

    @Override // com.google.android.gms.internal.ads.zzahs
    public final void zza(String str, Map map) {
        zzahz.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zza(String str, JSONObject jSONObject) {
        zzahz.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void zzb(String str, final zzafn<? super zzajq> zzafnVar) {
        this.zzcza.zza(str, new Predicate(zzafnVar) { // from class: com.google.android.gms.internal.ads.zzaij
            private final zzafn zzczb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzczb = zzafnVar;
            }

            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzafn zzafnVar2;
                zzafn zzafnVar3 = this.zzczb;
                zzafn zzafnVar4 = (zzafn) obj;
                if (!(zzafnVar4 instanceof zzaiq)) {
                    return false;
                }
                zzafnVar2 = ((zzaiq) zzafnVar4).zzczh;
                return zzafnVar2.equals(zzafnVar3);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzahs
    public final void zzb(String str, JSONObject jSONObject) {
        zzahz.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zzcv(String str) {
        runOnUiThread(new zzail(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zzcw(String str) {
        runOnUiThread(new zzaio(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zzcx(String str) {
        runOnUiThread(new zzain(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzaip
    public final void zzcy(final String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzaik
            private final String zzcyr;
            private final zzaih zzczc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzczc = this;
                this.zzcyr = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzczc.a(this.zzcyr);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zzj(String str, String str2) {
        zzahz.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final zzajp zzrz() {
        return new zzajs(this);
    }
}
