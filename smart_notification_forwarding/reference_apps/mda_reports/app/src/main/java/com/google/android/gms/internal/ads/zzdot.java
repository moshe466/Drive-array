package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzdot {
    private ECPublicKey zzhfu;

    public zzdot(ECPublicKey eCPublicKey) {
        this.zzhfu = eCPublicKey;
    }

    public final zzdos zza(String str, byte[] bArr, byte[] bArr2, int i, zzdow zzdowVar) {
        byte[] bArr3;
        KeyPair zza = zzdov.zza(this.zzhfu.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) zza.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) zza.getPrivate();
        ECPublicKey eCPublicKey2 = this.zzhfu;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            int i2 = 1;
            if (!(params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor())) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            byte[] zza2 = zzdov.zza(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            zzdov.a(w, curve);
            int bitLength = (zzdov.zza(curve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
            int i3 = zzdou.a[zzdowVar.ordinal()];
            if (i3 == 1) {
                int i4 = (bitLength * 2) + 1;
                bArr3 = new byte[i4];
                byte[] byteArray = w.getAffineX().toByteArray();
                byte[] byteArray2 = w.getAffineY().toByteArray();
                System.arraycopy(byteArray2, 0, bArr3, i4 - byteArray2.length, byteArray2.length);
                System.arraycopy(byteArray, 0, bArr3, (bitLength + 1) - byteArray.length, byteArray.length);
                bArr3[0] = 4;
            } else if (i3 != 2) {
                if (i3 != 3) {
                    String valueOf = String.valueOf(zzdowVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
                    sb.append("invalid format:");
                    sb.append(valueOf);
                    throw new GeneralSecurityException(sb.toString());
                }
                int i5 = bitLength + 1;
                byte[] bArr4 = new byte[i5];
                byte[] byteArray3 = w.getAffineX().toByteArray();
                System.arraycopy(byteArray3, 0, bArr4, i5 - byteArray3.length, byteArray3.length);
                bArr4[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                bArr3 = bArr4;
            } else {
                int i6 = bitLength * 2;
                bArr3 = new byte[i6];
                byte[] byteArray4 = w.getAffineX().toByteArray();
                if (byteArray4.length > bitLength) {
                    byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - bitLength, byteArray4.length);
                }
                byte[] byteArray5 = w.getAffineY().toByteArray();
                if (byteArray5.length > bitLength) {
                    byteArray5 = Arrays.copyOfRange(byteArray5, byteArray5.length - bitLength, byteArray5.length);
                }
                System.arraycopy(byteArray5, 0, bArr3, i6 - byteArray5.length, byteArray5.length);
                System.arraycopy(byteArray4, 0, bArr3, bitLength - byteArray4.length, byteArray4.length);
            }
            byte[] zza3 = zzdoi.zza(bArr3, zza2);
            Mac zzhd = zzdoy.zzhgh.zzhd(str);
            if (i > zzhd.getMacLength() * 255) {
                throw new GeneralSecurityException("size too large");
            }
            if (bArr == null || bArr.length == 0) {
                zzhd.init(new SecretKeySpec(new byte[zzhd.getMacLength()], str));
            } else {
                zzhd.init(new SecretKeySpec(bArr, str));
            }
            byte[] doFinal = zzhd.doFinal(zza3);
            byte[] bArr5 = new byte[i];
            zzhd.init(new SecretKeySpec(doFinal, str));
            byte[] bArr6 = new byte[0];
            int i7 = 0;
            while (true) {
                zzhd.update(bArr6);
                zzhd.update(bArr2);
                zzhd.update((byte) i2);
                bArr6 = zzhd.doFinal();
                if (bArr6.length + i7 >= i) {
                    System.arraycopy(bArr6, 0, bArr5, i7, i - i7);
                    return new zzdos(bArr3, bArr5);
                }
                System.arraycopy(bArr6, 0, bArr5, i7, bArr6.length);
                i7 += bArr6.length;
                i2++;
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }
}
