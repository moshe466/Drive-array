package com.google.android.gms.common.api;

import F0.AbstractC0008a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class ApiMetadata extends AbstractSafeParcelable {
    public static final ApiMetadata zza;
    private final ComplianceOptions zzc;
    private final boolean zzd;
    private boolean zze;
    public static final Parcelable.Creator<ApiMetadata> CREATOR = zza.zza();
    private static final ApiMetadata zzb = newBuilder().build();

    /* loaded from: classes.dex */
    public static final class Builder {
        private ComplianceOptions zza;
        private boolean zzb = false;
        private boolean zzc;

        public ApiMetadata build() {
            ApiMetadata apiMetadata = new ApiMetadata(this.zza, this.zzb);
            apiMetadata.zza(this.zzc);
            return apiMetadata;
        }

        public Builder setCallbackSupportEnabled(boolean z3) {
            this.zzb = z3;
            return this;
        }

        public Builder setComplianceOptions(ComplianceOptions complianceOptions) {
            this.zza = complianceOptions;
            return this;
        }

        public final /* synthetic */ Builder zza(boolean z3) {
            this.zzc = z3;
            return this;
        }
    }

    static {
        Builder newBuilder = newBuilder();
        newBuilder.zza(true);
        zza = newBuilder.build();
    }

    public ApiMetadata(ComplianceOptions complianceOptions, boolean z3) {
        this.zzc = complianceOptions;
        this.zzd = z3;
    }

    public static final ApiMetadata fromComplianceOptions(ComplianceOptions complianceOptions) {
        Builder newBuilder = newBuilder();
        newBuilder.setComplianceOptions(complianceOptions);
        return newBuilder.build();
    }

    public static final ApiMetadata getEmptyInstance() {
        return zzb;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ApiMetadata)) {
            return false;
        }
        ApiMetadata apiMetadata = (ApiMetadata) obj;
        if (!Objects.equal(this.zzc, apiMetadata.zzc) || this.zze != apiMetadata.zze || this.zzd != apiMetadata.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, Boolean.valueOf(this.zze), Boolean.valueOf(this.zzd));
    }

    public Builder toBuilder() {
        Builder newBuilder = newBuilder();
        newBuilder.setComplianceOptions(this.zzc);
        newBuilder.setCallbackSupportEnabled(this.zzd);
        newBuilder.zza(this.zze);
        return newBuilder;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        return AbstractC0008a.v(new StringBuilder(valueOf.length() + 31), "ApiMetadata(complianceOptions=", valueOf, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (this.zze) {
            parcel.setDataPosition(parcel.dataPosition() - 4);
            parcel.setDataSize(parcel.dataSize() - 4);
            return;
        }
        parcel.writeInt(-204102970);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzc, i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ void zza(boolean z3) {
        this.zze = z3;
    }
}
