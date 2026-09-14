package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzdda {
    private final Executor executor;
    private final String zzbma;
    private final Clock zzbmq;
    private final String zzcdu;
    private final String zzdir;
    private final zzdq zzfbt;
    private final zzczs zzfhh;
    private final zzclp zzfil;
    private final zzayy zzgrm;
    private final Context zzup;

    public zzdda(Executor executor, zzayy zzayyVar, zzclp zzclpVar, zzazb zzazbVar, String str, String str2, Context context, @Nullable zzczs zzczsVar, Clock clock, zzdq zzdqVar) {
        this.executor = executor;
        this.zzgrm = zzayyVar;
        this.zzfil = zzclpVar;
        this.zzbma = zzazbVar.zzbma;
        this.zzdir = str;
        this.zzcdu = str2;
        this.zzup = context;
        this.zzfhh = zzczsVar;
        this.zzbmq = clock;
        this.zzfbt = zzdqVar;
    }

    private static String zzc(String str, String str2, @Nullable String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    @Nullable
    private static String zzgo(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzayo.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        this.zzgrm.zzen(str);
    }

    public final void zza(zzczt zzcztVar, zzczl zzczlVar, List<String> list) {
        zza(zzcztVar, zzczlVar, false, "", list);
    }

    public final void zza(zzczt zzcztVar, zzczl zzczlVar, List<String> list, zzare zzareVar) {
        long currentTimeMillis = this.zzbmq.currentTimeMillis();
        try {
            String type = zzareVar.getType();
            String num = Integer.toString(zzareVar.getAmount());
            ArrayList arrayList = new ArrayList();
            zzczs zzczsVar = this.zzfhh;
            String zzgo = zzczsVar == null ? "" : zzgo(zzczsVar.zzdnv);
            zzczs zzczsVar2 = this.zzfhh;
            String zzgo2 = zzczsVar2 != null ? zzgo(zzczsVar2.zzdnw) : "";
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzauk.zzb(zzc(zzc(zzc(zzc(zzc(zzc(it.next(), "@gw_rwd_userid@", Uri.encode(zzgo)), "@gw_rwd_custom_data@", Uri.encode(zzgo2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzbma), this.zzup, zzczlVar.zzdll));
            }
            zzg(arrayList);
        } catch (RemoteException unused) {
        }
    }

    public final void zza(zzczt zzcztVar, @Nullable zzczl zzczlVar, boolean z, String str, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str2 = z ? "1" : "0";
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String zzc = zzc(zzc(zzc(it.next(), "@gw_adlocid@", zzcztVar.zzgmh.zzfgl.zzgmm), "@gw_adnetrefresh@", str2), "@gw_sdkver@", this.zzbma);
            if (zzczlVar != null) {
                zzc = zzauk.zzb(zzc(zzc(zzc(zzc, "@gw_qdata@", zzczlVar.zzdbw), "@gw_adnetid@", zzczlVar.zzaez), "@gw_allocid@", zzczlVar.zzdcm), this.zzup, zzczlVar.zzdll);
            }
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adnetstatus@", this.zzfil.zzamh()), "@gw_seqnum@", this.zzdir), "@gw_sessid@", this.zzcdu);
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcls)).booleanValue() && !TextUtils.isEmpty(str)) {
                if (this.zzfbt.zzb(Uri.parse(zzc2))) {
                    zzc2 = Uri.parse(zzc2).buildUpon().appendQueryParameter("ms", str).build().toString();
                }
            }
            arrayList.add(zzc2);
        }
        zzg(arrayList);
    }

    public final void zzen(final String str) {
        this.executor.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzddd
            private final String zzcyr;
            private final zzdda zzgrp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrp = this;
                this.zzcyr = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgrp.a(this.zzcyr);
            }
        });
    }

    public final void zzg(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            zzen(it.next());
        }
    }
}
