package com.google.android.gms.internal.location;

import N2.n;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.j;
import org.checkerframework.dataflow.qual.Pure;

@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({2, 5})
/* loaded from: classes.dex */
public final class zze extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getUid", id = 1)
    private final int zzb;

    @SafeParcelable.Field(getter = "getPackageName", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getAttributionTag", id = 4)
    private final String zzd;

    @SafeParcelable.Field(getter = "getListenerId", id = 6)
    private final String zze;

    @SafeParcelable.Field(getter = "getClientFeatures", id = 8)
    private final List zzf;

    @SafeParcelable.Field(getter = "getImpersonator", id = 7)
    private final zze zzg;
    public static final zzd zza = new zzd(null);
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    static {
        Process.myUid();
        Process.myPid();
    }

    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 3) String packageName, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 8) List list, @SafeParcelable.Param(id = 7) zze zzeVar) {
        j.e(packageName, "packageName");
        if (zzeVar != null && zzeVar.zza()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.zzb = i;
        this.zzc = packageName;
        this.zzd = str;
        if (str2 == null) {
            if (zzeVar != null) {
                str2 = zzeVar.zze;
            } else {
                str2 = null;
            }
        }
        this.zze = str2;
        if (list == null) {
            list = zzeVar != null ? zzeVar.zzf : null;
            if (list == null) {
                list = zzex.zzi();
                j.d(list, "of(...)");
            }
        }
        zzex zzj = zzex.zzj(list);
        j.d(zzj, "copyOf(...)");
        this.zzf = zzj;
        this.zzg = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (this.zzb == zzeVar.zzb && j.a(this.zzc, zzeVar.zzc) && j.a(this.zzd, zzeVar.zzd) && j.a(this.zze, zzeVar.zze) && j.a(this.zzg, zzeVar.zzg) && j.a(this.zzf, zzeVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzg});
    }

    public final String toString() {
        int i;
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        int i3 = 0;
        if (str != null) {
            i = str.length();
        } else {
            i = 0;
        }
        StringBuilder sb = new StringBuilder(length + i);
        sb.append(this.zzb);
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(this.zzc);
        String str2 = this.zzd;
        if (str2 != null) {
            sb.append("[");
            if (n.M(str2, this.zzc)) {
                sb.append((CharSequence) str2, this.zzc.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        if (this.zze != null) {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            String str3 = this.zze;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            sb.append(Integer.toHexString(i3));
        }
        String sb2 = sb.toString();
        j.d(sb2, "toString(...)");
        return sb2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        j.e(dest, "dest");
        int i3 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, i3);
        SafeParcelWriter.writeString(dest, 3, this.zzc, false);
        SafeParcelWriter.writeString(dest, 4, this.zzd, false);
        SafeParcelWriter.writeString(dest, 6, this.zze, false);
        SafeParcelWriter.writeParcelable(dest, 7, this.zzg, i, false);
        SafeParcelWriter.writeTypedList(dest, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    @Pure
    public final boolean zza() {
        return this.zzg != null;
    }
}
