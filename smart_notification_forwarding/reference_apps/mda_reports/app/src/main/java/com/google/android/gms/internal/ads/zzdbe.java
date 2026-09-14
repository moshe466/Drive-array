package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "PoolConfigurationCreator")
/* loaded from: classes.dex */
public final class zzdbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdbe> CREATOR = new zzdbj();
    private final zzdbh[] zzgod;
    private final int[] zzgoe;
    private final int[] zzgof;

    @SafeParcelable.Field(getter = "getFormatInt", id = 1)
    private final int zzgog;
    public final zzdbh zzgoh;

    @SafeParcelable.Field(id = 2)
    public final int zzgoi;

    @SafeParcelable.Field(id = 3)
    public final int zzgoj;

    @SafeParcelable.Field(id = 4)
    public final int zzgok;

    @SafeParcelable.Field(id = 5)
    public final String zzgol;

    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", id = 6)
    private final int zzgom;
    public final int zzgon;

    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", id = 7)
    private final int zzgoo;
    private final int zzgop;

    @Nullable
    public final Context zzup;

    @SafeParcelable.Constructor
    public zzdbe(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i5, @SafeParcelable.Param(id = 7) int i6) {
        this.zzgod = zzdbh.values();
        this.zzgoe = zzdbg.zzapn();
        this.zzgof = zzdbg.zzapo();
        this.zzup = null;
        this.zzgog = i;
        this.zzgoh = this.zzgod[i];
        this.zzgoi = i2;
        this.zzgoj = i3;
        this.zzgok = i4;
        this.zzgol = str;
        this.zzgom = i5;
        this.zzgon = this.zzgoe[i5];
        this.zzgoo = i6;
        this.zzgop = this.zzgof[i6];
    }

    private zzdbe(@Nullable Context context, zzdbh zzdbhVar, int i, int i2, int i3, String str, String str2, String str3) {
        this.zzgod = zzdbh.values();
        this.zzgoe = zzdbg.zzapn();
        this.zzgof = zzdbg.zzapo();
        this.zzup = context;
        this.zzgog = zzdbhVar.ordinal();
        this.zzgoh = zzdbhVar;
        this.zzgoi = i;
        this.zzgoj = i2;
        this.zzgok = i3;
        this.zzgol = str;
        this.zzgon = "oldest".equals(str2) ? zzdbg.zzgos : ("lru".equals(str2) || !"lfu".equals(str2)) ? zzdbg.zzgot : zzdbg.zzgou;
        this.zzgom = this.zzgon - 1;
        "onAdClosed".equals(str3);
        this.zzgop = zzdbg.zzgow;
        this.zzgoo = this.zzgop - 1;
    }

    public static zzdbe zza(zzdbh zzdbhVar, Context context) {
        if (zzdbhVar == zzdbh.Rewarded) {
            return new zzdbe(context, zzdbhVar, ((Integer) zzve.zzoy().zzd(zzzn.zzcql)).intValue(), ((Integer) zzve.zzoy().zzd(zzzn.zzcqr)).intValue(), ((Integer) zzve.zzoy().zzd(zzzn.zzcqt)).intValue(), (String) zzve.zzoy().zzd(zzzn.zzcqv), (String) zzve.zzoy().zzd(zzzn.zzcqn), (String) zzve.zzoy().zzd(zzzn.zzcqp));
        }
        if (zzdbhVar == zzdbh.Interstitial) {
            return new zzdbe(context, zzdbhVar, ((Integer) zzve.zzoy().zzd(zzzn.zzcqm)).intValue(), ((Integer) zzve.zzoy().zzd(zzzn.zzcqs)).intValue(), ((Integer) zzve.zzoy().zzd(zzzn.zzcqu)).intValue(), (String) zzve.zzoy().zzd(zzzn.zzcqw), (String) zzve.zzoy().zzd(zzzn.zzcqo), (String) zzve.zzoy().zzd(zzzn.zzcqq));
        }
        if (zzdbhVar != zzdbh.AppOpen) {
            return null;
        }
        return new zzdbe(context, zzdbhVar, ((Integer) zzve.zzoy().zzd(zzzn.zzcqz)).intValue(), ((Integer) zzve.zzoy().zzd(zzzn.zzcrb)).intValue(), ((Integer) zzve.zzoy().zzd(zzzn.zzcrc)).intValue(), (String) zzve.zzoy().zzd(zzzn.zzcqx), (String) zzve.zzoy().zzd(zzzn.zzcqy), (String) zzve.zzoy().zzd(zzzn.zzcra));
    }

    public static boolean zzapl() {
        return ((Boolean) zzve.zzoy().zzd(zzzn.zzcqk)).booleanValue();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzgog);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgoi);
        SafeParcelWriter.writeInt(parcel, 3, this.zzgoj);
        SafeParcelWriter.writeInt(parcel, 4, this.zzgok);
        SafeParcelWriter.writeString(parcel, 5, this.zzgol, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzgom);
        SafeParcelWriter.writeInt(parcel, 7, this.zzgoo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
