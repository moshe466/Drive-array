package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzds {
    private static Cipher zzwu;
    private static final Object zzwv = new Object();
    private static final Object zzww = new Object();
    private final SecureRandom zzwt = null;

    public zzds(SecureRandom secureRandom) {
    }

    private static Cipher getCipher() {
        Cipher cipher;
        synchronized (zzww) {
            if (zzwu == null) {
                zzwu = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zzwu;
        }
        return cipher;
    }

    public final byte[] zza(byte[] bArr, String str) {
        byte[] doFinal;
        if (bArr.length != 16) {
            throw new zzdv(this);
        }
        try {
            byte[] zza = zzci.zza(str, false);
            if (zza.length <= 16) {
                throw new zzdv(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(zza.length);
            allocate.put(zza);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[zza.length - 16];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzwv) {
                getCipher().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                doFinal = getCipher().doFinal(bArr3);
            }
            return doFinal;
        } catch (IllegalArgumentException e) {
            throw new zzdv(this, e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new zzdv(this, e2);
        } catch (InvalidKeyException e3) {
            throw new zzdv(this, e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new zzdv(this, e4);
        } catch (BadPaddingException e5) {
            throw new zzdv(this, e5);
        } catch (IllegalBlockSizeException e6) {
            throw new zzdv(this, e6);
        } catch (NoSuchPaddingException e7) {
            throw new zzdv(this, e7);
        }
    }

    public final byte[] zzar(String str) {
        try {
            byte[] zza = zzci.zza(str, false);
            if (zza.length != 32) {
                throw new zzdv(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(zza, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new zzdv(this, e);
        }
    }

    public final String zzb(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zzdv(this);
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzwv) {
                getCipher().init(1, secretKeySpec, (SecureRandom) null);
                doFinal = getCipher().doFinal(bArr2);
                iv = getCipher().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            byte[] bArr3 = new byte[length];
            allocate.get(bArr3);
            return zzci.zza(bArr3, false);
        } catch (InvalidKeyException e) {
            throw new zzdv(this, e);
        } catch (NoSuchAlgorithmException e2) {
            throw new zzdv(this, e2);
        } catch (BadPaddingException e3) {
            throw new zzdv(this, e3);
        } catch (IllegalBlockSizeException e4) {
            throw new zzdv(this, e4);
        } catch (NoSuchPaddingException e5) {
            throw new zzdv(this, e5);
        }
    }
}
