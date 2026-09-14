package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzbkm extends zzbkk {
    private final View view;

    @Nullable
    private final zzbdi zzcza;
    private final Executor zzfci;
    private final zzczk zzfdo;
    private final zzbme zzfdz;
    private final zzbwz zzfea;
    private final zzbsy zzfeb;
    private final zzdxa<zzcok> zzfec;
    private zzuj zzfed;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkm(zzbmg zzbmgVar, Context context, zzczk zzczkVar, View view, @Nullable zzbdi zzbdiVar, zzbme zzbmeVar, zzbwz zzbwzVar, zzbsy zzbsyVar, zzdxa<zzcok> zzdxaVar, Executor executor) {
        super(zzbmgVar);
        this.zzup = context;
        this.view = view;
        this.zzcza = zzbdiVar;
        this.zzfdo = zzczkVar;
        this.zzfdz = zzbmeVar;
        this.zzfea = zzbwzVar;
        this.zzfeb = zzbsyVar;
        this.zzfec = zzdxaVar;
        this.zzfci = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        if (this.zzfea.zzajs() != null) {
            try {
                this.zzfea.zzajs().zza(this.zzfec.get(), ObjectWrapper.wrap(this.zzup));
            } catch (RemoteException e) {
                zzayu.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final zzxb getVideoController() {
        try {
            return this.zzfdz.getVideoController();
        } catch (zzdab unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final void zza(ViewGroup viewGroup, zzuj zzujVar) {
        zzbdi zzbdiVar;
        if (viewGroup == null || (zzbdiVar = this.zzcza) == null) {
            return;
        }
        zzbdiVar.zza(zzbey.zzb(zzujVar));
        viewGroup.setMinimumHeight(zzujVar.heightPixels);
        viewGroup.setMinimumWidth(zzujVar.widthPixels);
        this.zzfed = zzujVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final zzczk zzafz() {
        boolean z;
        zzuj zzujVar = this.zzfed;
        if (zzujVar != null) {
            return zzczy.zze(zzujVar);
        }
        zzczl zzczlVar = this.b;
        if (zzczlVar.zzgma) {
            Iterator<String> it = zzczlVar.zzgli.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzczk(this.view.getWidth(), this.view.getHeight(), false);
            }
        }
        return zzczy.zza(this.b.zzgln, this.zzfdo);
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final View zzaga() {
        return this.view;
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final int zzage() {
        return this.a.zzgmi.zzgmf.zzgmb;
    }

    @Override // com.google.android.gms.internal.ads.zzbmd
    public final void zzagf() {
        this.zzfci.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbkl
            private final zzbkm zzfdy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfdy = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfdy.a();
            }
        });
        super.zzagf();
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final void zzjy() {
        this.zzfeb.zzaia();
    }
}
