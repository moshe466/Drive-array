package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import e0.a;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class zzaew {
    private Context zza;
    private zzafp zzb;
    private String zzc;
    private final FirebaseApp zzd;
    private boolean zze;
    private String zzf;

    public zzaew(FirebaseApp firebaseApp, String str) {
        this(firebaseApp.getApplicationContext(), firebaseApp, str);
    }

    private static String zza(FirebaseApp firebaseApp) {
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = FirebaseAuth.getInstance(firebaseApp).zzc().get();
        if (interopAppCheckTokenProvider == null) {
            return null;
        }
        try {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) Tasks.await(interopAppCheckTokenProvider.getToken(false));
            if (appCheckTokenResult.getError() != null) {
                String.valueOf(appCheckTokenResult.getError());
            }
            return appCheckTokenResult.getToken();
        } catch (InterruptedException e4) {
            e = e4;
            AbstractC0008a.A("Unexpected error getting App Check token: ", e.getMessage(), "LocalRequestInterceptor");
            return null;
        } catch (ExecutionException e5) {
            e = e5;
            AbstractC0008a.A("Unexpected error getting App Check token: ", e.getMessage(), "LocalRequestInterceptor");
            return null;
        }
    }

    private static String zzb(FirebaseApp firebaseApp) {
        HeartBeatController heartBeatController = FirebaseAuth.getInstance(firebaseApp).zzd().get();
        if (heartBeatController != null) {
            try {
                return (String) Tasks.await(heartBeatController.getHeartBeatsHeader());
            } catch (InterruptedException | ExecutionException e4) {
                e4.getMessage();
            }
        }
        return null;
    }

    public zzaew(Context context, FirebaseApp firebaseApp, String str) {
        this.zze = false;
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzd = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzc = a.d("Android/Fallback/", str);
    }

    public final void zzb(String str) {
        this.zzf = str;
    }

    public final void zza(URLConnection uRLConnection) {
        String n4;
        if (this.zze) {
            n4 = AbstractC0008a.n(this.zzc, "/FirebaseUI-Android");
        } else {
            n4 = AbstractC0008a.n(this.zzc, "/FirebaseCore-Android");
        }
        if (this.zzb == null) {
            this.zzb = new zzafp(this.zza);
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zzb());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zza());
        uRLConnection.setRequestProperty("Accept-Language", zzaev.zza());
        uRLConnection.setRequestProperty("X-Client-Version", n4);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zzf);
        uRLConnection.setRequestProperty("X-Firebase-GMPID", this.zzd.getOptions().getApplicationId());
        uRLConnection.setRequestProperty("X-Firebase-Client", zzb(this.zzd));
        String zza = zza(this.zzd);
        if (!TextUtils.isEmpty(zza)) {
            uRLConnection.setRequestProperty("X-Firebase-AppCheck", zza);
        }
        this.zzf = null;
    }

    public final void zza(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }
}
