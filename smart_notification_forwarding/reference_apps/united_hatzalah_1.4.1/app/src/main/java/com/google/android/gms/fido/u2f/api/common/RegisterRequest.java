package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes.dex */
public class RegisterRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RegisterRequest> CREATOR = new zzg();
    public static final int U2F_V1_CHALLENGE_BYTE_LENGTH = 65;
    private final int zza;
    private final ProtocolVersion zzb;
    private final byte[] zzc;
    private final String zzd;

    public RegisterRequest(int i, String str, byte[] bArr, String str2) {
        this.zza = i;
        try {
            this.zzb = ProtocolVersion.fromString(str);
            this.zzc = bArr;
            this.zzd = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static RegisterRequest parseFromJson(JSONObject jSONObject) {
        String str;
        String str2 = null;
        if (jSONObject.has("version")) {
            str = jSONObject.getString("version");
        } else {
            str = null;
        }
        try {
            ProtocolVersion fromString = ProtocolVersion.fromString(str);
            try {
                byte[] decode = Base64.decode(jSONObject.getString(ClientData.KEY_CHALLENGE), 8);
                if (jSONObject.has(RemoteConfigConstants.RequestFieldKey.APP_ID)) {
                    str2 = jSONObject.getString(RemoteConfigConstants.RequestFieldKey.APP_ID);
                }
                try {
                    return new RegisterRequest(fromString, decode, str2);
                } catch (IllegalArgumentException e4) {
                    throw new JSONException(e4.getMessage());
                }
            } catch (IllegalArgumentException e5) {
                throw new JSONException(e5.toString());
            }
        } catch (ProtocolVersion.UnsupportedProtocolException e6) {
            throw new JSONException(e6.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        if (!Arrays.equals(this.zzc, registerRequest.zzc) || this.zzb != registerRequest.zzb) {
            return false;
        }
        String str = this.zzd;
        if (str == null) {
            if (registerRequest.zzd != null) {
                return false;
            }
        } else if (!str.equals(registerRequest.zzd)) {
            return false;
        }
        return true;
    }

    public String getAppId() {
        return this.zzd;
    }

    public byte[] getChallengeValue() {
        return this.zzc;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.zzb;
    }

    public int getVersionCode() {
        return this.zza;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((Arrays.hashCode(this.zzc) + 31) * 31) + this.zzb.hashCode();
        String str = this.zzd;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return (hashCode2 * 31) + hashCode;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.zzb.toString());
            jSONObject.put(ClientData.KEY_CHALLENGE, Base64.encodeToString(this.zzc, 11));
            String str = this.zzd;
            if (str != null) {
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_ID, str);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
        SafeParcelWriter.writeString(parcel, 2, this.zzb.toString(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getChallengeValue(), false);
        SafeParcelWriter.writeString(parcel, 4, getAppId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public RegisterRequest(ProtocolVersion protocolVersion, byte[] bArr, String str) {
        this.zza = 1;
        this.zzb = (ProtocolVersion) Preconditions.checkNotNull(protocolVersion);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
        if (protocolVersion == ProtocolVersion.V1) {
            Preconditions.checkArgument(bArr.length == 65, "invalid challengeValue length for V1");
        }
        this.zzd = str;
    }
}
