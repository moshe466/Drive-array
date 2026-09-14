package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zziv implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zziv> CREATOR = new zziu();
    private int zzafx;
    private final zza[] zzamm;
    public final int zzamn;

    /* loaded from: classes.dex */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new zziw();
        private final byte[] data;
        private final String mimeType;
        private final UUID uuid;
        private int zzafx;
        public final boolean zzamo;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzamo = parcel.readByte() != 0;
        }

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        private zza(UUID uuid, String str, byte[] bArr, boolean z) {
            this.uuid = (UUID) zzoc.checkNotNull(uuid);
            this.mimeType = (String) zzoc.checkNotNull(str);
            this.data = (byte[]) zzoc.checkNotNull(bArr);
            this.zzamo = false;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return this.mimeType.equals(zzaVar.mimeType) && zzoq.zza(this.uuid, zzaVar.uuid) && Arrays.equals(this.data, zzaVar.data);
        }

        public final int hashCode() {
            if (this.zzafx == 0) {
                this.zzafx = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.zzafx;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzamo ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziv(Parcel parcel) {
        this.zzamm = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzamn = this.zzamm.length;
    }

    private zziv(boolean z, zza... zzaVarArr) {
        zza[] zzaVarArr2 = (zza[]) zzaVarArr.clone();
        Arrays.sort(zzaVarArr2, this);
        for (int i = 1; i < zzaVarArr2.length; i++) {
            if (zzaVarArr2[i - 1].uuid.equals(zzaVarArr2[i].uuid)) {
                String valueOf = String.valueOf(zzaVarArr2[i].uuid);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzamm = zzaVarArr2;
        this.zzamn = zzaVarArr2.length;
    }

    public zziv(zza... zzaVarArr) {
        this(true, zzaVarArr);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zzaVar, zza zzaVar2) {
        zza zzaVar3 = zzaVar;
        zza zzaVar4 = zzaVar2;
        return zzgi.zzacb.equals(zzaVar3.uuid) ? zzgi.zzacb.equals(zzaVar4.uuid) ? 0 : 1 : zzaVar3.uuid.compareTo(zzaVar4.uuid);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zziv.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzamm, ((zziv) obj).zzamm);
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = Arrays.hashCode(this.zzamm);
        }
        return this.zzafx;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzamm, 0);
    }

    public final zza zzaa(int i) {
        return this.zzamm[i];
    }
}
