package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbvv implements zzdxg<zzbvr> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdda> zzepi;
    private final zzdxp<zzboq> zzesg;
    private final zzdxp<zzbpd> zzesj;
    private final zzdxp<JSONObject> zzety;
    private final zzdxp<zzbjd> zzeue;
    private final zzdxp<zzbst> zzeun;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<Clock> zzfcz;
    private final zzdxp<zzbwz> zzfeh;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzczl> zzffb;
    private final zzdxp<zzcaj> zzfkw;
    private final zzdxp<zzbws> zzfkx;
    private final zzdxp<zzdq> zzfky;
    private final zzdxp<zzbxq> zzfkz;

    public zzbvv(zzdxp<Context> zzdxpVar, zzdxp<zzbwz> zzdxpVar2, zzdxp<JSONObject> zzdxpVar3, zzdxp<zzcaj> zzdxpVar4, zzdxp<zzbws> zzdxpVar5, zzdxp<zzdq> zzdxpVar6, zzdxp<zzbpd> zzdxpVar7, zzdxp<zzboq> zzdxpVar8, zzdxp<zzczl> zzdxpVar9, zzdxp<zzazb> zzdxpVar10, zzdxp<zzczu> zzdxpVar11, zzdxp<zzbjd> zzdxpVar12, zzdxp<zzbxq> zzdxpVar13, zzdxp<Clock> zzdxpVar14, zzdxp<zzbst> zzdxpVar15, zzdxp<zzdda> zzdxpVar16) {
        this.zzejv = zzdxpVar;
        this.zzfeh = zzdxpVar2;
        this.zzety = zzdxpVar3;
        this.zzfkw = zzdxpVar4;
        this.zzfkx = zzdxpVar5;
        this.zzfky = zzdxpVar6;
        this.zzesj = zzdxpVar7;
        this.zzesg = zzdxpVar8;
        this.zzffb = zzdxpVar9;
        this.zzfav = zzdxpVar10;
        this.zzfep = zzdxpVar11;
        this.zzeue = zzdxpVar12;
        this.zzfkz = zzdxpVar13;
        this.zzfcz = zzdxpVar14;
        this.zzeun = zzdxpVar15;
        this.zzepi = zzdxpVar16;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbvr(this.zzejv.get(), this.zzfeh.get(), this.zzety.get(), this.zzfkw.get(), this.zzfkx.get(), this.zzfky.get(), this.zzesj.get(), this.zzesg.get(), this.zzffb.get(), this.zzfav.get(), this.zzfep.get(), this.zzeue.get(), this.zzfkz.get(), this.zzfcz.get(), this.zzeun.get(), this.zzepi.get());
    }
}
