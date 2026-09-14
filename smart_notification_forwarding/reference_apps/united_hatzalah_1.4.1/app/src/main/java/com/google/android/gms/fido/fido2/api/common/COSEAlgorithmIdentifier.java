package com.google.android.gms.fido.fido2.api.common;

import F0.AbstractC0008a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class COSEAlgorithmIdentifier implements Parcelable {
    public static final Parcelable.Creator<COSEAlgorithmIdentifier> CREATOR = new zzp();
    private final Algorithm zza;

    /* loaded from: classes.dex */
    public static class UnsupportedAlgorithmIdentifierException extends Exception {
        public UnsupportedAlgorithmIdentifierException(int i) {
            super(AbstractC0008a.j(i, "Algorithm with COSE value ", " not supported"));
        }
    }

    public COSEAlgorithmIdentifier(Algorithm algorithm) {
        this.zza = (Algorithm) Preconditions.checkNotNull(algorithm);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static COSEAlgorithmIdentifier fromCoseValue(int i) {
        RSAAlgorithm rSAAlgorithm;
        if (i == RSAAlgorithm.LEGACY_RS1.getAlgoValue()) {
            rSAAlgorithm = RSAAlgorithm.RS1;
        } else {
            RSAAlgorithm[] values = RSAAlgorithm.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    RSAAlgorithm rSAAlgorithm2 = values[i3];
                    if (rSAAlgorithm2.getAlgoValue() == i) {
                        rSAAlgorithm = rSAAlgorithm2;
                        break;
                    }
                    i3++;
                } else {
                    for (RSAAlgorithm rSAAlgorithm3 : EC2Algorithm.values()) {
                        if (rSAAlgorithm3.getAlgoValue() == i) {
                            rSAAlgorithm = rSAAlgorithm3;
                        }
                    }
                    throw new UnsupportedAlgorithmIdentifierException(i);
                }
            }
        }
        return new COSEAlgorithmIdentifier(rSAAlgorithm);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof COSEAlgorithmIdentifier) || this.zza.getAlgoValue() != ((COSEAlgorithmIdentifier) obj).zza.getAlgoValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public int toCoseValue() {
        return this.zza.getAlgoValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza.getAlgoValue());
    }
}
