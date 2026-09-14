package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzapz;
import com.google.android.gms.internal.ads.zzato;
import com.google.android.gms.internal.ads.zzawb;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzc {
    private boolean zzbks;
    private zzato zzbkt;
    private zzapz zzbku;
    private final Context zzup;

    public zzc(Context context, zzato zzatoVar, zzapz zzapzVar) {
        this.zzup = context;
        this.zzbkt = zzatoVar;
        this.zzbku = null;
        if (this.zzbku == null) {
            this.zzbku = new zzapz();
        }
    }

    private final boolean zzjp() {
        zzato zzatoVar = this.zzbkt;
        return (zzatoVar != null && zzatoVar.zzuk().zzdox) || this.zzbku.zzdln;
    }

    public final void recordClick() {
        this.zzbks = true;
    }

    public final void zzbq(@Nullable String str) {
        List<String> list;
        if (zzjp()) {
            if (str == null) {
                str = "";
            }
            zzato zzatoVar = this.zzbkt;
            if (zzatoVar != null) {
                zzatoVar.zza(str, null, 3);
                return;
            }
            zzapz zzapzVar = this.zzbku;
            if (!zzapzVar.zzdln || (list = zzapzVar.zzdlo) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    zzq.zzkq();
                    zzawb.zzb(this.zzup, "", replace);
                }
            }
        }
    }

    public final boolean zzjq() {
        return !zzjp() || this.zzbks;
    }
}
