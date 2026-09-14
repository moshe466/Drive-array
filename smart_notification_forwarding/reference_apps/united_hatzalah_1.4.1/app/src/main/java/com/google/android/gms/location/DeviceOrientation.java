package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzer;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public class DeviceOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceOrientation> CREATOR = new zzm();
    private final float[] zza;
    private final float zzb;
    private final float zzc;
    private final long zzd;
    private final byte zze;
    private final float zzf;
    private final float zzg;

    public DeviceOrientation(float[] fArr, float f4, float f5, long j2, byte b4, float f6, float f7) {
        boolean z3;
        boolean z4;
        boolean z5;
        zzj(fArr);
        if (f4 >= 0.0f && f4 < 360.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzer.zza(z3);
        if (f5 >= 0.0f && f5 <= 180.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzer.zza(z4);
        if (f7 >= 0.0f && f7 <= 180.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        zzer.zza(z5);
        zzer.zza(j2 >= 0);
        this.zza = fArr;
        this.zzb = f4;
        this.zzc = f5;
        this.zzf = f6;
        this.zzg = f7;
        this.zzd = j2;
        this.zze = (byte) (((byte) (((byte) (b4 | 16)) | 4)) | 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzj(float[] fArr) {
        boolean z3;
        boolean z4 = true;
        if (fArr != null && fArr.length == 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzer.zzb(z3, "Input attitude array should be of length 4.");
        if (Float.isNaN(fArr[0]) || Float.isNaN(fArr[1]) || Float.isNaN(fArr[2]) || Float.isNaN(fArr[3])) {
            z4 = false;
        }
        zzer.zzb(z4, "Input attitude cannot contain NaNs.");
    }

    @Pure
    public boolean equals(Object obj) {
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceOrientation)) {
            return false;
        }
        DeviceOrientation deviceOrientation = (DeviceOrientation) obj;
        if (zza() == deviceOrientation.zza() && (!zza() || Float.compare(this.zzf, deviceOrientation.zzf) == 0)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (hasConservativeHeadingErrorDegrees() == deviceOrientation.hasConservativeHeadingErrorDegrees() && (!hasConservativeHeadingErrorDegrees() || Float.compare(getConservativeHeadingErrorDegrees(), deviceOrientation.getConservativeHeadingErrorDegrees()) == 0)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (Float.compare(this.zzb, deviceOrientation.zzb) == 0 && Float.compare(this.zzc, deviceOrientation.zzc) == 0 && z3 && z4 && this.zzd == deviceOrientation.zzd && Arrays.equals(this.zza, deviceOrientation.zza)) {
            return true;
        }
        return false;
    }

    @Pure
    public float[] getAttitude() {
        return (float[]) this.zza.clone();
    }

    @Pure
    public float getConservativeHeadingErrorDegrees() {
        return this.zzg;
    }

    @Pure
    public long getElapsedRealtimeNs() {
        return this.zzd;
    }

    @Pure
    public float getHeadingDegrees() {
        return this.zzb;
    }

    @Pure
    public float getHeadingErrorDegrees() {
        return this.zzc;
    }

    @Pure
    public boolean hasConservativeHeadingErrorDegrees() {
        return (this.zze & 64) != 0;
    }

    @Pure
    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzb), Float.valueOf(this.zzc), Float.valueOf(this.zzg), Long.valueOf(this.zzd), this.zza, Byte.valueOf(this.zze));
    }

    @Pure
    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceOrientation[attitude=");
        sb.append(Arrays.toString(this.zza));
        sb.append(", headingDegrees=");
        sb.append(this.zzb);
        sb.append(", headingErrorDegrees=");
        sb.append(this.zzc);
        if (hasConservativeHeadingErrorDegrees()) {
            sb.append(", conservativeHeadingErrorDegrees=");
            sb.append(this.zzg);
        }
        sb.append(", elapsedRealtimeNs=");
        sb.append(this.zzd);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloatArray(parcel, 1, getAttitude(), false);
        SafeParcelWriter.writeFloat(parcel, 4, getHeadingDegrees());
        SafeParcelWriter.writeFloat(parcel, 5, getHeadingErrorDegrees());
        SafeParcelWriter.writeLong(parcel, 6, getElapsedRealtimeNs());
        SafeParcelWriter.writeByte(parcel, 7, this.zze);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzf);
        SafeParcelWriter.writeFloat(parcel, 9, getConservativeHeadingErrorDegrees());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final boolean zza() {
        return (this.zze & 32) != 0;
    }

    public final /* synthetic */ float[] zzc() {
        return this.zza;
    }

    public final /* synthetic */ float zzd() {
        return this.zzb;
    }

    public final /* synthetic */ float zze() {
        return this.zzc;
    }

    public final /* synthetic */ long zzf() {
        return this.zzd;
    }

    public final /* synthetic */ byte zzg() {
        return this.zze;
    }

    public final /* synthetic */ float zzh() {
        return this.zzf;
    }

    public final /* synthetic */ float zzi() {
        return this.zzg;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final float[] zza;
        private float zzb;
        private float zzc;
        private long zzd;
        private byte zze;
        private float zzf;
        private float zzg;

        public Builder(DeviceOrientation deviceOrientation) {
            this.zze = (byte) 0;
            DeviceOrientation.zzj(deviceOrientation.zzc());
            this.zza = Arrays.copyOf(deviceOrientation.zzc(), deviceOrientation.zzc().length);
            setHeadingDegrees(deviceOrientation.zzd());
            setHeadingErrorDegrees(deviceOrientation.zze());
            setConservativeHeadingErrorDegrees(deviceOrientation.zzi());
            setElapsedRealtimeNs(deviceOrientation.zzf());
            this.zzf = deviceOrientation.zzh();
            this.zze = deviceOrientation.zzg();
        }

        public DeviceOrientation build() {
            return new DeviceOrientation(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        public Builder clearConservativeHeadingErrorDegrees() {
            this.zzg = 180.0f;
            int i = this.zze & (-65);
            this.zzf = 0.0f;
            this.zze = (byte) (((byte) i) & (-33));
            return this;
        }

        public Builder setAttitude(float[] fArr) {
            DeviceOrientation.zzj(fArr);
            System.arraycopy(fArr, 0, this.zza, 0, fArr.length);
            return this;
        }

        public Builder setConservativeHeadingErrorDegrees(float f4) {
            float f5 = 0.0f;
            boolean z3 = false;
            if (f4 >= 0.0f && f4 <= 180.0f) {
                z3 = true;
            }
            zzer.zzb(z3, "conservativeHeadingErrorDegrees should be between 0 and 180.");
            this.zzg = f4;
            this.zze = (byte) (this.zze | 64);
            Parcelable.Creator<DeviceOrientation> creator = DeviceOrientation.CREATOR;
            if (f4 < 180.0f) {
                f5 = (float) (2.0d / (1.0d - Math.cos(Math.toRadians(f4))));
            }
            this.zzf = f5;
            this.zze = (byte) (this.zze | 32);
            return this;
        }

        public Builder setElapsedRealtimeNs(long j2) {
            boolean z3;
            if (j2 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzer.zzb(z3, "elapsedRealtimeNs should be greater than or equal to 0.");
            this.zzd = j2;
            return this;
        }

        public Builder setHeadingDegrees(float f4) {
            boolean z3 = false;
            if (f4 >= 0.0f && f4 < 360.0f) {
                z3 = true;
            }
            zzer.zzb(z3, "headingDegrees should be greater than or equal to 0 and less than 360.");
            this.zzb = f4;
            return this;
        }

        public Builder setHeadingErrorDegrees(float f4) {
            boolean z3 = false;
            if (f4 >= 0.0f && f4 <= 180.0f) {
                z3 = true;
            }
            zzer.zzb(z3, "headingErrorDegrees should be between 0 and 180.");
            this.zzc = f4;
            return this;
        }

        public Builder(float[] fArr, float f4, float f5, long j2) {
            this.zze = (byte) 0;
            DeviceOrientation.zzj(fArr);
            this.zza = Arrays.copyOf(fArr, fArr.length);
            setHeadingDegrees(f4);
            setHeadingErrorDegrees(f5);
            setElapsedRealtimeNs(j2);
            this.zzf = 0.0f;
            this.zzg = 180.0f;
            this.zze = (byte) 0;
        }
    }
}
