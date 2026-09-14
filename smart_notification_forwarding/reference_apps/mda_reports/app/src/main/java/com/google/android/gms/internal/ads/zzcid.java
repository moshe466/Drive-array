package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzsy;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzcid {
    private static final SparseArray<zzsy.zzj.zzc> zzfxq;
    private final zzchz zzfvf;
    private final zzdhe<Bundle> zzfxm;
    private final TelephonyManager zzfxn;
    private final zzcht zzfxo;
    private zzte zzfxp;
    private final Context zzup;

    static {
        SparseArray<zzsy.zzj.zzc> sparseArray = new SparseArray<>();
        zzfxq = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzsy.zzj.zzc.CONNECTED);
        zzfxq.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzsy.zzj.zzc.CONNECTING);
        zzfxq.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzsy.zzj.zzc.CONNECTING);
        zzfxq.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzsy.zzj.zzc.CONNECTING);
        zzfxq.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzsy.zzj.zzc.DISCONNECTING);
        zzfxq.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzsy.zzj.zzc.DISCONNECTED);
        zzfxq.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzsy.zzj.zzc.DISCONNECTED);
        zzfxq.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzsy.zzj.zzc.DISCONNECTED);
        zzfxq.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzsy.zzj.zzc.DISCONNECTED);
        zzfxq.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzsy.zzj.zzc.DISCONNECTED);
        zzfxq.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzsy.zzj.zzc.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            zzfxq.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzsy.zzj.zzc.CONNECTING);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            zzfxq.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzsy.zzj.zzc.CONNECTING);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcid(Context context, zzdhe<Bundle> zzdheVar, zzchz zzchzVar, zzcht zzchtVar) {
        this.zzup = context;
        this.zzfxm = zzdheVar;
        this.zzfvf = zzchzVar;
        this.zzfxo = zzchtVar;
        this.zzfxn = (TelephonyManager) context.getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzsy.zzb.zza> arrayList, zzsy.zzh zzhVar, zzsy.zzj.zzc zzcVar) {
        return ((zzsy.zzj.zza) zzsy.zzj.zza.zznr().zzd(arrayList).zzh(zzbi(com.google.android.gms.ads.internal.zzq.zzks().zzb(this.zzup.getContentResolver()) != 0)).zzi(com.google.android.gms.ads.internal.zzq.zzks().zza(this.zzup, this.zzfxn)).zzev(this.zzfvf.zzaly()).zzew(this.zzfvf.zzama()).zzcf(this.zzfvf.getResponseCode()).zzb(zzcVar).zzb(zzhVar).zzj(this.zzfxp).zzf(zzbi(z)).zzeu(com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis()).zzg(zzbi(com.google.android.gms.ads.internal.zzq.zzks().zza(this.zzup.getContentResolver()) != 0)).zzbaf()).toByteArray();
    }

    private static zzte zzbi(boolean z) {
        return z ? zzte.ENUM_TRUE : zzte.ENUM_FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzsy.zzh zzj(Bundle bundle) {
        zzsy.zzh.zza zzaVar;
        zzsy.zzh.zzb zznl = zzsy.zzh.zznl();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzfxp = zzte.ENUM_TRUE;
        } else {
            this.zzfxp = zzte.ENUM_FALSE;
            zznl.zzb(i != 0 ? i != 1 ? zzsy.zzh.zzc.NETWORKTYPE_UNSPECIFIED : zzsy.zzh.zzc.WIFI : zzsy.zzh.zzc.CELL);
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzaVar = zzsy.zzh.zza.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzaVar = zzsy.zzh.zza.THREE_G;
                    break;
                case 13:
                    zzaVar = zzsy.zzh.zza.LTE;
                    break;
                default:
                    zzaVar = zzsy.zzh.zza.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zznl.zzb(zzaVar);
        }
        return (zzsy.zzh) zznl.zzbaf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzsy.zzj.zzc zzk(Bundle bundle) {
        return zzfxq.get(zzdaa.zza(zzdaa.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzsy.zzj.zzc.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzsy.zzb.zza> zzl(android.os.Bundle r7) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r7 = r7.get(r0)
            boolean r0 = r7 instanceof java.util.List
            if (r0 == 0) goto Ld
            java.util.List r7 = (java.util.List) r7
            goto L17
        Ld:
            boolean r0 = r7 instanceof java.lang.String[]
            if (r0 == 0) goto L3d
            java.lang.String[] r7 = (java.lang.String[]) r7
            java.util.List r7 = java.util.Arrays.asList(r7)
        L17:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L24:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L38
            java.lang.Object r1 = r7.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L24
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L24
        L38:
            java.util.List r7 = java.util.Collections.unmodifiableList(r0)
            goto L41
        L3d:
            java.util.List r7 = java.util.Collections.emptyList()
        L41:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L4a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto La3
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1396342996: goto L80;
                case -1052618729: goto L76;
                case -239580146: goto L6c;
                case 604727084: goto L62;
                default: goto L61;
            }
        L61:
            goto L89
        L62:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L89
            r2 = 1
            goto L89
        L6c:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L89
            r2 = 3
            goto L89
        L76:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L89
            r2 = 2
            goto L89
        L80:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L89
            r2 = 0
        L89:
            if (r2 == 0) goto L9d
            if (r2 == r6) goto L9a
            if (r2 == r5) goto L97
            if (r2 == r4) goto L94
            com.google.android.gms.internal.ads.zzsy$zzb$zza r1 = com.google.android.gms.internal.ads.zzsy.zzb.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L9f
        L94:
            com.google.android.gms.internal.ads.zzsy$zzb$zza r1 = com.google.android.gms.internal.ads.zzsy.zzb.zza.REWARD_BASED_VIDEO_AD
            goto L9f
        L97:
            com.google.android.gms.internal.ads.zzsy$zzb$zza r1 = com.google.android.gms.internal.ads.zzsy.zzb.zza.NATIVE_APP_INSTALL
            goto L9f
        L9a:
            com.google.android.gms.internal.ads.zzsy$zzb$zza r1 = com.google.android.gms.internal.ads.zzsy.zzb.zza.INTERSTITIAL
            goto L9f
        L9d:
            com.google.android.gms.internal.ads.zzsy$zzb$zza r1 = com.google.android.gms.internal.ads.zzsy.zzb.zza.BANNER
        L9f:
            r0.add(r1)
            goto L4a
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcid.zzl(android.os.Bundle):java.util.ArrayList");
    }

    public final void zzbj(boolean z) {
        zzdgs.zza(this.zzfxm, new zzcig(this, z), zzazd.zzdwj);
    }
}
