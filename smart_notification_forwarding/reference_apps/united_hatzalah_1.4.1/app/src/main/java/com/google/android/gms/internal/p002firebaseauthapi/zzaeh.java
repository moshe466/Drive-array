package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzao;
import e0.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public final class zzaeh extends AsyncTask<Void, Void, zzaek> {
    private static final Logger zza = new Logger("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference<zzaej> zzd;
    private final Uri.Builder zze;
    private final String zzf;
    private final FirebaseApp zzg;

    public zzaeh(String str, String str2, Intent intent, FirebaseApp firebaseApp, zzaej zzaejVar) {
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zzg = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(intent);
        String checkNotEmpty = Preconditions.checkNotEmpty(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder buildUpon = Uri.parse(zzaejVar.zza(checkNotEmpty)).buildUpon();
        buildUpon.appendPath("getProjectConfig").appendQueryParameter("key", checkNotEmpty).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) Preconditions.checkNotNull(str2));
        this.zzc = buildUpon.build().toString();
        this.zzd = new WeakReference<>(zzaejVar);
        this.zze = zzaejVar.zza(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzaek doInBackground(Void... voidArr) {
        try {
            URL url = new URL(this.zzc);
            zzaej zzaejVar = this.zzd.get();
            HttpURLConnection zza2 = zzaejVar.zza(url);
            zza2.addRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
            zza2.setConnectTimeout(60000);
            new zzaew(zzaejVar.zza(), this.zzg, zzaeu.zza().zzb()).zza(zza2);
            int responseCode = zza2.getResponseCode();
            if (responseCode != 200) {
                String zza3 = zza(zza2);
                zza.e("Error getting project config. Failed with " + zza3 + StringUtils.SPACE + responseCode, new Object[0]);
                return zzaek.zzb(zza3);
            }
            zzahi zzahiVar = new zzahi();
            zzahiVar.zza(new String(zza(zza2.getInputStream(), 128)));
            if (!TextUtils.isEmpty(this.zzf)) {
                if (!zzahiVar.zza().contains(this.zzf)) {
                    return zzaek.zzb("UNAUTHORIZED_DOMAIN");
                }
                return zzaek.zza(this.zzf);
            }
            for (String str : zzahiVar.zza()) {
                if (zza(str)) {
                    return zzaek.zza(str);
                }
            }
            return null;
        } catch (zzaci e4) {
            zza.e(a.d("ConversionException encountered: ", e4.getMessage()), new Object[0]);
            return null;
        } catch (IOException e5) {
            zza.e(a.d("IOException occurred: ", e5.getMessage()), new Object[0]);
            return null;
        } catch (NullPointerException e6) {
            zza.e(a.d("Null pointer encountered: ", e6.getMessage()), new Object[0]);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onCancelled(zzaek zzaekVar) {
        onPostExecute((zzaek) null);
    }

    private static String zza(HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getResponseCode() < 400) {
                return null;
            }
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream == null) {
                return "WEB_INTERNAL_ERROR:Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again.";
            }
            return (String) zzaep.zza(new String(zza(errorStream, 128)), String.class);
        } catch (IOException e4) {
            zza.w("Error parsing error message from response body in getErrorMessageFromBody. ".concat(String.valueOf(e4)), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final void onPostExecute(zzaek zzaekVar) {
        String str;
        String str2;
        Uri.Builder builder;
        zzaej zzaejVar = this.zzd.get();
        if (zzaekVar != null) {
            str = zzaekVar.zza();
            str2 = zzaekVar.zzb();
        } else {
            str = null;
            str2 = null;
        }
        if (zzaejVar == null) {
            zza.e("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (!TextUtils.isEmpty(str) && (builder = this.zze) != null) {
            builder.authority(str);
            zzaejVar.zza(this.zze.build(), this.zzb, FirebaseAuth.getInstance(this.zzg).zzc());
        } else {
            zzaejVar.zza(this.zzb, zzao.zza(str2));
        }
    }

    private static boolean zza(String str) {
        try {
            String host = new URI("https://" + str).getHost();
            if (host != null) {
                if (host.endsWith("firebaseapp.com")) {
                    return true;
                }
                if (host.endsWith("web.app")) {
                    return true;
                }
            }
        } catch (URISyntaxException e4) {
            zza.e(a.f("Error parsing URL for auth domain check: ", str, ". ", e4.getMessage()), new Object[0]);
        }
        return false;
    }

    private static byte[] zza(InputStream inputStream, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
