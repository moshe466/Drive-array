package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class zzbtv {

    @Nullable
    private final zzbdi zzcza;
    private final zzbuv zzfjd;

    public zzbtv(zzbuv zzbuvVar) {
        this(zzbuvVar, null);
    }

    public zzbtv(zzbuv zzbuvVar, @Nullable zzbdi zzbdiVar) {
        this.zzfjd = zzbuvVar;
        this.zzcza = zzbdiVar;
    }

    public Set<zzbsu<zzbov>> zza(zzbva zzbvaVar) {
        return Collections.singleton(zzbsu.zzb(zzbvaVar, zzazd.zzdwj));
    }

    @Nullable
    public final zzbdi zzaft() {
        return this.zzcza;
    }

    public final zzbuv zzaie() {
        return this.zzfjd;
    }

    @Nullable
    public final View zzaif() {
        zzbdi zzbdiVar = this.zzcza;
        if (zzbdiVar != null) {
            return zzbdiVar.getWebView();
        }
        return null;
    }

    @Nullable
    public final View zzaig() {
        zzbdi zzbdiVar = this.zzcza;
        if (zzbdiVar == null) {
            return null;
        }
        return zzbdiVar.getWebView();
    }

    public final zzbsu<zzbrb> zzb(Executor executor) {
        final zzbdi zzbdiVar = this.zzcza;
        return new zzbsu<>(new zzbrb(zzbdiVar) { // from class: com.google.android.gms.internal.ads.zzbtx
            private final zzbdi zzehp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehp = zzbdiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrb
            public final void zzagj() {
                zzbdi zzbdiVar2 = this.zzehp;
                if (zzbdiVar2.zzzw() != null) {
                    zzbdiVar2.zzzw().close();
                }
            }
        }, executor);
    }
}
