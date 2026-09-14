package com.google.android.datatransport.cct.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes.dex */
public final class zzr implements ObjectEncoder<zzg> {
    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public void encode(@Nullable Object obj, @NonNull ObjectEncoderContext objectEncoderContext) {
        zzg zzgVar = (zzg) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        if (zzgVar.zzc() != null) {
            objectEncoderContext2.add("clientType", zzgVar.zzc().name());
        }
        if (zzgVar.zzb() != null) {
            objectEncoderContext2.add("androidClientInfo", zzgVar.zzb());
        }
    }
}
