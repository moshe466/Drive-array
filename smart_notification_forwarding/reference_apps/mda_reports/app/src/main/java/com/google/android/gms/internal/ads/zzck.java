package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzck {
    private static boolean zzmq = false;
    private static MessageDigest zzmr;
    private static final Object zzms = new Object();
    private static final Object zzmt = new Object();
    static CountDownLatch a = new CountDownLatch(1);

    public static String a(zzbs.zza zzaVar, String str) {
        byte[] zza;
        zzdte zzbaf;
        byte[] byteArray = zzaVar.toByteArray();
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzclj)).booleanValue()) {
            Vector<byte[]> zza2 = zza(byteArray, 255);
            if (zza2 == null || zza2.size() == 0) {
                zza = zza(zza(zzbs.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
                return zzci.zza(zza, true);
            }
            zzbs.zzf.zza zzbi = zzbs.zzf.zzbi();
            Iterator<byte[]> it = zza2.iterator();
            while (it.hasNext()) {
                zzbi.zzi(zzdqk.zzu(zza(it.next(), str, false)));
            }
            zzbi.zzj(zzdqk.zzu(zzb(byteArray)));
            zzbaf = zzbi.zzbaf();
        } else {
            if (zzeo.a == null) {
                throw new GeneralSecurityException();
            }
            zzbaf = zzbs.zzf.zzbi().zzi(zzdqk.zzu(zzeo.a.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zza(zzbz.TINK_HYBRID).zzbaf();
        }
        zza = ((zzbs.zzf) zzbaf).toByteArray();
        return zzci.zza(zza, true);
    }

    public static void a() {
        synchronized (zzmt) {
            if (!zzmq) {
                zzmq = true;
                new Thread(new zzcm()).start();
            }
        }
    }

    private static zzbs.zza zza(zzbs.zza.zzd zzdVar) {
        zzbs.zza.zzb zzan = zzbs.zza.zzan();
        zzan.zzau(zzdVar.zzae());
        return (zzbs.zza) zzan.zzbaf();
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) {
        ByteBuffer put;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzbs.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2);
        } else {
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr);
        }
        byte[] array = put.array();
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (zzcr zzcrVar : new zzcp().N2) {
            zzcrVar.zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzdpx(str.getBytes(HttpRequest.CHARSET_UTF8)).zzt(bArr3);
        }
        return bArr3;
    }

    public static byte[] zzb(byte[] bArr) {
        byte[] digest;
        synchronized (zzms) {
            MessageDigest zzbm = zzbm();
            if (zzbm == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzbm.reset();
            zzbm.update(bArr);
            digest = zzmr.digest();
        }
        return digest;
    }

    private static MessageDigest zzbm() {
        boolean z;
        MessageDigest messageDigest;
        a();
        try {
            z = a.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = zzmr) != null) {
            return messageDigest;
        }
        return null;
    }
}
