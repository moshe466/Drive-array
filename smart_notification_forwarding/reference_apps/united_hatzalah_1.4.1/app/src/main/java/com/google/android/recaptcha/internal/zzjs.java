package com.google.android.recaptcha.internal;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzjs implements zzjw {
    @Override // com.google.android.recaptcha.internal.zzjw
    public final zzjv zza(CharSequence charSequence, Charset charset) {
        zzjx zzb = zzb();
        byte[] bytes = charSequence.toString().getBytes(charset);
        bytes.getClass();
        ((zzjr) zzb).zza(bytes, 0, bytes.length);
        return zzb.zzb();
    }
}
