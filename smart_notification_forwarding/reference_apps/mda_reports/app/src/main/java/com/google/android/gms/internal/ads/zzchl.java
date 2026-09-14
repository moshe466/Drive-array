package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzchl implements zzdby<zzcho, zzchn> {
    private final String zzdjj;
    private final zzarb zzfwb;
    private final String zzfwn;
    private final Context zzup;

    public zzchl(Context context, String str, zzarb zzarbVar, String str2) {
        this.zzup = context;
        this.zzfwn = str;
        this.zzfwb = zzarbVar;
        this.zzdjj = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0246, code lost:
    
        r2 = new java.lang.StringBuilder(46);
        r2.append("Received error HTTP response code: ");
        r2.append(r8);
        com.google.android.gms.internal.ads.zzayu.zzez(r2.toString());
        r4 = new java.lang.StringBuilder(46);
        r4.append("Received error HTTP response code: ");
        r4.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x026e, code lost:
    
        throw new com.google.android.gms.internal.ads.zzcgt(r4.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.ads.zzchn zza(java.lang.String r21, com.google.android.gms.internal.ads.zzaqq r22, org.json.JSONObject r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchl.zza(java.lang.String, com.google.android.gms.internal.ads.zzaqq, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzchn");
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final /* synthetic */ zzchn apply(zzcho zzchoVar) {
        zzaqq zzaqqVar;
        zzaqq zzaqqVar2;
        JSONObject jSONObject;
        zzcho zzchoVar2 = zzchoVar;
        zzaqqVar = zzchoVar2.zzfwi;
        String url = zzaqqVar.getUrl();
        zzaqqVar2 = zzchoVar2.zzfwi;
        jSONObject = zzchoVar2.zzfwj;
        return zza(url, zzaqqVar2, jSONObject, this.zzdjj);
    }
}
