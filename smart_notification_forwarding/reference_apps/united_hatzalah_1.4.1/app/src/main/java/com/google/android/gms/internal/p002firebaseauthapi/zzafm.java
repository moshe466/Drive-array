package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.apache.tika.metadata.HttpHeaders;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class zzafm {
    private static final boolean zza(int i) {
        return i >= 200 && i < 300;
    }

    private static void zza(HttpURLConnection httpURLConnection, zzafn<?> zzafnVar, Type type) {
        InputStream errorStream;
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (zza(responseCode)) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else {
                            sb.append(readLine);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                if (!zza(responseCode)) {
                    zzafnVar.zza((String) zzaep.zza(sb2, String.class));
                } else {
                    zzafnVar.zza((zzafn<?>) zzaep.zza(sb2, type));
                }
                httpURLConnection.disconnect();
            } catch (zzaci e4) {
                e = e4;
                zzafnVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            } catch (SocketTimeoutException unused) {
                zzafnVar.zza("TIMEOUT");
                httpURLConnection.disconnect();
            } catch (IOException e5) {
                e = e5;
                zzafnVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    public static void zza(String str, zzafn<?> zzafnVar, Type type, zzaew zzaewVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzaewVar.zza(httpURLConnection);
            zza(httpURLConnection, zzafnVar, type);
        } catch (SocketTimeoutException unused) {
            zzafnVar.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzafnVar.zza("<<Network Error>>");
        } catch (IOException e4) {
            zzafnVar.zza(e4.getMessage());
        }
    }

    public static void zza(String str, zzaes zzaesVar, zzafn<?> zzafnVar, Type type, zzaew zzaewVar) {
        try {
            Preconditions.checkNotNull(zzaesVar);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzaesVar.zza().getBytes(Charset.defaultCharset());
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzaewVar.zza(httpURLConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), bytes.length);
            try {
                bufferedOutputStream.write(bytes, 0, bytes.length);
                bufferedOutputStream.close();
                zza(httpURLConnection, zzafnVar, type);
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            zzafnVar.zza("TIMEOUT");
        } catch (IOException e4) {
            e = e4;
            zzafnVar.zza(e.getMessage());
        } catch (NullPointerException e5) {
            e = e5;
            zzafnVar.zza(e.getMessage());
        } catch (UnknownHostException unused2) {
            zzafnVar.zza("<<Network Error>>");
        } catch (JSONException e6) {
            e = e6;
            zzafnVar.zza(e.getMessage());
        }
    }
}
