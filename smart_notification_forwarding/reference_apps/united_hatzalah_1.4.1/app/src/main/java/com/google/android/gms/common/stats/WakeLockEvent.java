package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    final int zza;
    private final long zzb;
    private final int zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final List zzh;
    private final String zzi;
    private final long zzj;
    private final int zzk;
    private final String zzl;
    private final float zzm;
    private final long zzn;
    private final boolean zzo;

    public WakeLockEvent(int i, long j2, int i3, String str, int i4, List list, String str2, long j3, int i5, String str3, String str4, float f4, long j4, String str5, boolean z3) {
        this.zza = i;
        this.zzb = j2;
        this.zzc = i3;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i4;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j3;
        this.zzk = i5;
        this.zzl = str4;
        this.zzm = f4;
        this.zzn = j4;
        this.zzo = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzc);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzc() {
        String join;
        List list = this.zzh;
        String str = "";
        if (list == null) {
            join = "";
        } else {
            join = TextUtils.join(",", list);
        }
        int i = this.zzk;
        String str2 = this.zze;
        String str3 = this.zzl;
        float f4 = this.zzm;
        String str4 = this.zzf;
        int i3 = this.zzg;
        String str5 = this.zzd;
        boolean z3 = this.zzo;
        int length = String.valueOf(str5).length();
        int length2 = String.valueOf(i3).length() + length + 2;
        int length3 = String.valueOf(i).length() + length2 + 1 + String.valueOf(join).length() + 1;
        if (str2 == null) {
            str2 = "";
        }
        int length4 = str2.length() + length3 + 1 + 1;
        if (str3 == null) {
            str3 = "";
        }
        int length5 = String.valueOf(f4).length() + str3.length() + length4 + 1 + 1;
        if (str4 != null) {
            str = str4;
        }
        StringBuilder sb = new StringBuilder(str.length() + length5 + 1 + String.valueOf(z3).length());
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f4);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(z3);
        return sb.toString();
    }
}
