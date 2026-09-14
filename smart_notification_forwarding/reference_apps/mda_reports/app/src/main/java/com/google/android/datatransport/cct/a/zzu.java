package com.google.android.datatransport.cct.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes.dex */
public final class zzu implements ObjectEncoder<zzi> {
    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public void encode(@Nullable Object obj, @NonNull ObjectEncoderContext objectEncoderContext) {
        zzi zziVar = (zzi) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("eventTimeMs", zziVar.zza()).add("eventUptimeMs", zziVar.zzb()).add("timezoneOffsetSeconds", zziVar.zzc());
        if (zziVar.zzf() != null) {
            objectEncoderContext2.add("sourceExtension", zziVar.zzf());
        }
        if (zziVar.zzg() != null) {
            objectEncoderContext2.add("sourceExtensionJsonProto3", zziVar.zzg());
        }
        if (zziVar.zzd() != Integer.MIN_VALUE) {
            objectEncoderContext2.add("eventCode", zziVar.zzd());
        }
        if (zziVar.zze() != null) {
            objectEncoderContext2.add("networkConnectionInfo", zziVar.zze());
        }
    }
}
