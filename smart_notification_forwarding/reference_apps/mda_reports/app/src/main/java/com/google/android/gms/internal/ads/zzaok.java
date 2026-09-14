package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzaok {
    private final boolean zzdfz;
    private final boolean zzdga;
    private final boolean zzdgb;
    private final boolean zzdgc;
    private final boolean zzdgd;

    private zzaok(zzaom zzaomVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        z = zzaomVar.zzdfz;
        this.zzdfz = z;
        z2 = zzaomVar.zzdga;
        this.zzdga = z2;
        z3 = zzaomVar.zzdgb;
        this.zzdgb = z3;
        z4 = zzaomVar.zzdgc;
        this.zzdgc = z4;
        z5 = zzaomVar.zzdgd;
        this.zzdgd = z5;
    }

    public final JSONObject zzth() {
        try {
            return new JSONObject().put("sms", this.zzdfz).put("tel", this.zzdga).put("calendar", this.zzdgb).put("storePicture", this.zzdgc).put("inlineVideo", this.zzdgd);
        } catch (JSONException e) {
            zzayu.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
