package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* loaded from: classes.dex */
public final class zzmu implements zzms {
    private static final byte[] zza = {48, 46, 2, 1, 0, 48, 5, 6, 3, 43, 101, 110, 4, 34, 4, 32};
    private static final byte[] zzb = {48, 42, 48, 5, 6, 3, 43, 101, 110, 3, 33, 0};
    private final Provider zzc;

    private zzmu(Provider provider) {
        this.zzc = provider;
    }

    public static zzms zzb() {
        Provider zza2 = zzng.zza();
        if (zza2 != null) {
            KeyFactory.getInstance("XDH", zza2);
            KeyAgreement.getInstance("XDH", zza2);
            zzmu zzmuVar = new zzmu(zza2);
            zzmuVar.zza();
            return zzmuVar;
        }
        throw new GeneralSecurityException("Conscrypt is not available.");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzms
    public final zzmv zza() {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("XDH", this.zzc);
        keyPairGenerator.initialize(255);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        byte[] encoded = generateKeyPair.getPrivate().getEncoded();
        int length = encoded.length;
        byte[] bArr = zza;
        if (length == bArr.length + 32) {
            if (zzqq.zza(bArr, encoded)) {
                byte[] copyOfRange = Arrays.copyOfRange(encoded, bArr.length, encoded.length);
                byte[] encoded2 = generateKeyPair.getPublic().getEncoded();
                int length2 = encoded2.length;
                byte[] bArr2 = zzb;
                if (length2 == bArr2.length + 32) {
                    if (zzqq.zza(bArr2, encoded2)) {
                        return new zzmv(copyOfRange, Arrays.copyOfRange(encoded2, bArr2.length, encoded2.length));
                    }
                    throw new GeneralSecurityException("Invalid encoded public key prefix");
                }
                throw new GeneralSecurityException("Invalid encoded public key length");
            }
            throw new GeneralSecurityException("Invalid encoded private key prefix");
        }
        throw new GeneralSecurityException("Invalid encoded private key length");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzms
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        KeyFactory keyFactory = KeyFactory.getInstance("XDH", this.zzc);
        if (bArr.length == 32) {
            PrivateKey generatePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(zzyt.zza(zza, bArr)));
            if (bArr2.length == 32) {
                PublicKey generatePublic = keyFactory.generatePublic(new X509EncodedKeySpec(zzyt.zza(zzb, bArr2)));
                KeyAgreement keyAgreement = KeyAgreement.getInstance("XDH", this.zzc);
                keyAgreement.init(generatePrivate);
                keyAgreement.doPhase(generatePublic, true);
                return keyAgreement.generateSecret();
            }
            throw new InvalidKeyException("Invalid X25519 public key");
        }
        throw new InvalidKeyException("Invalid X25519 private key");
    }
}
