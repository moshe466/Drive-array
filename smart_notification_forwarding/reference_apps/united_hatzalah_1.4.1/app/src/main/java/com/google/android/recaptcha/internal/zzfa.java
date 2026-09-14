package com.google.android.recaptcha.internal;

import T.b;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.j;
import s2.C0682g;
import s2.InterfaceC0678c;

/* loaded from: classes.dex */
public final class zzfa implements zzey {
    private final InterfaceC0678c zza;

    public zzfa() {
        int i = zzav.zza;
        this.zza = b.A(zzez.zza);
    }

    @Override // com.google.android.recaptcha.internal.zzey
    public final zzsc zza(String str, zzto zztoVar) {
        zzew zzewVar = null;
        try {
            try {
                zzewVar = ((zzex) ((C0682g) this.zza).a()).zza(str);
                zzewVar.zzc();
                zzewVar.zze(zztoVar.zzd());
                zzsc zzscVar = (zzsc) zzewVar.zza(zzsc.zzi());
                zzewVar.zzd();
                return zzscVar;
            } catch (zzbd e4) {
                if (zzewVar != null) {
                    if (j.a(e4.zza(), zzba.zzau)) {
                        try {
                            throw zzbc.zza(zztu.zzg(zzewVar.zzb().getErrorStream()).zzi());
                        } catch (Exception e5) {
                            throw new zzbd(zzbb.zzc, zzba.zzG, e5.getMessage());
                        }
                    }
                    throw e4;
                }
                throw e4;
            } catch (Exception e6) {
                throw new zzbd(zzbb.zzc, zzba.zzF, e6.getMessage());
            }
        } catch (Throwable th) {
            if (zzewVar != null) {
                zzewVar.zzd();
            }
            throw th;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzey
    public final String zzb(String str) {
        InputStreamReader inputStreamReader;
        try {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                j.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Accept", "application/x-protobuffer");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    try {
                        if ("gzip".equals(httpURLConnection.getContentEncoding())) {
                            inputStreamReader = new InputStreamReader(new GZIPInputStream(httpURLConnection.getInputStream()));
                        } else {
                            inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                        }
                        return E1.b.y(inputStreamReader);
                    } catch (Exception unused) {
                        throw new zzbd(zzbb.zzc, zzba.zzP, null);
                    }
                }
                throw new zzbd(zzbb.zzc, new zzba(httpURLConnection.getResponseCode()), null);
            } catch (Exception unused2) {
                throw new zzbd(zzbb.zzc, zzba.zzO, null);
            }
        } catch (Exception unused3) {
            throw new zzbd(zzbb.zzb, zzba.zzN, null);
        }
    }
}
