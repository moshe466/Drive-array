package com.google.android.datatransport.cct.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes.dex */
public final class zzz implements ObjectEncoder<zzn> {
    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public void encode(@Nullable Object obj, @NonNull ObjectEncoderContext objectEncoderContext) {
        zzn zznVar = (zzn) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        if (zznVar.zzb() != null) {
            objectEncoderContext2.add("mobileSubtype", zznVar.zzb().name());
        }
        if (zznVar.zzc() != null) {
            objectEncoderContext2.add("networkType", zznVar.zzc().name());
        }
    }
}
