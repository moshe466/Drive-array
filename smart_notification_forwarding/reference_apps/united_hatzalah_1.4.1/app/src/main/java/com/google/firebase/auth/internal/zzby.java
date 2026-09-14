package com.google.firebase.auth.internal;

import F0.AbstractC0008a;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzcn;
import com.google.android.gms.internal.p002firebaseauthapi.zzco;
import com.google.android.gms.internal.p002firebaseauthapi.zzcy;
import com.google.android.gms.internal.p002firebaseauthapi.zzmy;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzby {
    private static zzby zza;
    private final String zzb;
    private final zzmy zzc;

    private zzby(String str, zzmy zzmyVar) {
        this.zzb = str;
        this.zzc = zzmyVar;
    }

    public static zzby zza(Context context, String str) {
        zzby zzbyVar = zza;
        if (zzbyVar == null || !com.google.android.gms.internal.p002firebaseauthapi.zzp.zza(zzbyVar.zzb, str)) {
            zza = new zzby(str, zzb(context, str));
        }
        return zza;
    }

    private static zzmy zzb(Context context, String str) {
        try {
            zzco.zza();
            try {
                return new zzmy.zza().zza(context, "StorageCryptoKeyset", "com.google.firebase.auth.api.crypto." + str).zza(zzcy.zzb).zza("android-keystore://firebear_main_key_id_for_storage_crypto." + str).zza();
            } catch (IOException e4) {
                e = e4;
                AbstractC0008a.A("Exception encountered during crypto setup:\n", e.getMessage(), "FirebearStorageCryptoHelper");
                return null;
            }
        } catch (IOException | GeneralSecurityException e5) {
            e = e5;
        }
    }

    public final String zza(String str) {
        String str2;
        Preconditions.checkNotNull(str);
        zzmy zzmyVar = this.zzc;
        if (zzmyVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to decrypt data");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                str2 = new String(((com.google.android.gms.internal.p002firebaseauthapi.zzbe) this.zzc.zza().zza(zzcn.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzbe.class)).zza(Base64.decode(str, 2), null), StandardCharsets.UTF_8);
            }
            return str2;
        } catch (IllegalArgumentException | GeneralSecurityException e4) {
            AbstractC0008a.A("Exception encountered while decrypting bytes:\n", e4.getMessage(), "FirebearStorageCryptoHelper");
            return null;
        }
    }

    public final String zzb(String str) {
        String encodeToString;
        Preconditions.checkNotNull(str);
        zzmy zzmyVar = this.zzc;
        if (zzmyVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to encrypt data");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                encodeToString = Base64.encodeToString(((com.google.android.gms.internal.p002firebaseauthapi.zzbe) this.zzc.zza().zza(zzcn.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzbe.class)).zzb(str.getBytes(StandardCharsets.UTF_8), null), 2);
            }
            return encodeToString;
        } catch (GeneralSecurityException e4) {
            AbstractC0008a.A("Exception encountered while encrypting bytes:\n", e4.getMessage(), "FirebearStorageCryptoHelper");
            return null;
        }
    }
}
