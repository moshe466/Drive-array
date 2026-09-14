package com.google.android.recaptcha.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import kotlin.jvm.internal.j;
import m3.b;

/* loaded from: classes.dex */
public final class zzew {
    private final HttpURLConnection zza;

    public zzew(HttpURLConnection httpURLConnection) {
        this.zza = httpURLConnection;
    }

    private final InputStream zzf() {
        try {
            return this.zza.getInputStream();
        } catch (UnknownServiceException e4) {
            throw new zzbd(zzbb.zzc, zzba.zzaf, e4.getMessage());
        } catch (IOException e5) {
            throw new zzbd(zzbb.zzc, zzba.zzae, e5.getMessage());
        } catch (Exception e6) {
            throw new zzbd(zzbb.zzc, zzba.zzak, e6.getMessage());
        }
    }

    private final OutputStream zzg() {
        try {
            return this.zza.getOutputStream();
        } catch (UnknownServiceException e4) {
            throw new zzbd(zzbb.zzc, zzba.zzaf, e4.getMessage());
        } catch (IOException e5) {
            throw new zzbd(zzbb.zzc, zzba.zzae, e5.getMessage());
        } catch (Exception e6) {
            throw new zzbd(zzbb.zzc, zzba.zzak, e6.getMessage());
        }
    }

    public final zzoi zza(zzoi zzoiVar) {
        try {
            int responseCode = this.zza.getResponseCode();
            if (responseCode != 200) {
                if (responseCode != 400) {
                    if (responseCode != 503 && responseCode != 403) {
                        if (responseCode != 404) {
                            throw new zzbd(zzbb.zzc, zzba.zzK, null);
                        }
                        throw new zzbd(zzbb.zzc, zzba.zzi, null);
                    }
                    throw new zzbd(zzbb.zzi, zzba.zzJ, null);
                }
                throw new zzbd(zzbb.zzc, zzba.zzau, null);
            }
            InputStream zzf = zzf();
            j.e(zzf, "<this>");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(UserMetadata.MAX_INTERNAL_KEY_SIZE, zzf.available()));
            b.i(zzf, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            j.d(byteArray, "toByteArray(...)");
            if (byteArray.length != 0) {
                try {
                    Object zzb = zzoiVar.zzD().zzb(byteArray);
                    j.c(zzb, "null cannot be cast to non-null type T of com.google.android.libraries.abuse.recaptcha.network.CaptchaFeConnection.getResponse");
                    return (zzoi) zzb;
                } catch (Exception e4) {
                    throw new zzbd(zzbb.zzc, zzba.zzG, e4.getMessage());
                }
            }
            throw new zzbd(zzbb.zzc, zzba.zzat, null);
        } catch (Exception e5) {
            throw new zzbd(zzbb.zzc, zzba.zzah, e5.getMessage());
        }
    }

    public final HttpURLConnection zzb() {
        return this.zza;
    }

    public final void zzc() {
        try {
            this.zza.connect();
        } catch (SocketTimeoutException e4) {
            throw new zzbd(zzbb.zzc, zzba.zzac, e4.getMessage());
        } catch (IOException e5) {
            throw new zzbd(zzbb.zzc, zzba.zzad, e5.getMessage());
        } catch (Exception e6) {
            throw new zzbd(zzbb.zzc, zzba.zzaj, e6.getMessage());
        }
    }

    public final void zzd() {
        this.zza.disconnect();
    }

    public final void zze(byte[] bArr) {
        try {
            zzg().write(bArr);
        } catch (zzbd e4) {
            throw e4;
        } catch (IOException e5) {
            throw new zzbd(zzbb.zzc, zzba.zzag, e5.getMessage());
        } catch (Exception e6) {
            throw new zzbd(zzbb.zzc, zzba.zzal, e6.getMessage());
        }
    }
}
