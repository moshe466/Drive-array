package com.google.firebase.auth.internal;

import F0.AbstractC0008a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.L;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeh;
import com.google.android.gms.internal.p002firebaseauthapi.zzaej;
import com.google.android.gms.internal.p002firebaseauthapi.zzaem;
import com.google.android.gms.internal.p002firebaseauthapi.zzaev;
import com.google.android.gms.internal.p002firebaseauthapi.zzaga;
import com.google.android.gms.internal.p002firebaseauthapi.zzagd;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.inject.Provider;
import g0.C0427c;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.tika.utils.StringUtils;
import r.C0634i;
import r.C0635j;

/* loaded from: classes.dex */
public class RecaptchaActivity extends L implements zzaej {
    private static final String zzb = "RecaptchaActivity";
    private static long zzc;
    private static final zzcg zzd = zzcg.zzc();
    private boolean zze = false;

    private final void zzb() {
        zzc = 0L;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        zza(intent);
        zzd.zza(this);
        finish();
    }

    @Override // androidx.fragment.app.L, c.m, w.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            AbstractC0008a.A("Could not do operation - unknown action: ", action, zzb);
            zzb();
            return;
        }
        long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
        if (currentTimeMillis - zzc < 30000) {
            Log.e(zzb, "Could not start operation - already in progress");
            return;
        }
        zzc = currentTimeMillis;
        if (bundle != null) {
            this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
        }
    }

    @Override // c.m, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.L, android.app.Activity
    public void onResume() {
        RecaptchaActivity recaptchaActivity;
        super.onResume();
        if ("android.intent.action.VIEW".equals(getIntent().getAction())) {
            Intent intent = getIntent();
            if (intent.hasExtra("firebaseError")) {
                zza(zzce.zza(intent.getStringExtra("firebaseError")));
                return;
            }
            if (intent.hasExtra("link") && intent.hasExtra("eventId")) {
                String stringExtra = intent.getStringExtra("link");
                String zzb2 = zzo.zza().zzb(getApplicationContext(), getPackageName(), intent.getStringExtra("eventId"));
                if (TextUtils.isEmpty(zzb2)) {
                    Log.e(zzb, "Failed to find registration for this event - failing to prevent session injection.");
                    zza(zzao.zza("Failed to find registration for this reCAPTCHA event"));
                }
                if (intent.getBooleanExtra("encryptionEnabled", true)) {
                    stringExtra = zzq.zza(getApplicationContext(), FirebaseApp.getInstance(zzb2).getPersistenceKey()).zza(stringExtra);
                }
                String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
                zzc = 0L;
                this.zze = false;
                Intent intent2 = new Intent();
                intent2.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!zza(intent2)) {
                    zzbl.zza(getApplicationContext(), queryParameter, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                } else {
                    zzd.zza(this);
                }
                finish();
                return;
            }
            zzb();
            return;
        }
        if (!this.zze) {
            Intent intent3 = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US);
                FirebaseApp firebaseApp = FirebaseApp.getInstance(intent3.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
                if (!zzagd.zza(firebaseApp)) {
                    recaptchaActivity = this;
                    new zzaeh(packageName, lowerCase, intent3, firebaseApp, recaptchaActivity).executeOnExecutor(firebaseAuth.zze(), new Void[0]);
                } else {
                    recaptchaActivity = this;
                    zza(zza(Uri.parse(zzagd.zza(firebaseApp.getOptions().getApiKey())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.zzc());
                }
            } catch (PackageManager.NameNotFoundException e4) {
                recaptchaActivity = this;
                Log.e(zzb, "Could not get package signature: " + packageName + StringUtils.SPACE + String.valueOf(e4));
                zzaem.zzb(this, packageName);
            }
            recaptchaActivity.zze = true;
            return;
        }
        zzb();
    }

    @Override // c.m, w.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.zze);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final Context zza() {
        return getApplicationContext();
    }

    private final Uri.Builder zza(Uri.Builder builder, Intent intent, String str, String str2) {
        String zza;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
        zzo.zza().zza(getApplicationContext(), str, uuid, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String zza2 = zzq.zza(getApplicationContext(), firebaseApp.getPersistenceKey()).zza();
        if (TextUtils.isEmpty(zza2)) {
            Log.e(zzb, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            zza(zzao.zza("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        if (!TextUtils.isEmpty(firebaseAuth.getLanguageCode())) {
            zza = firebaseAuth.getLanguageCode();
        } else {
            zza = zzaev.zza();
        }
        builder.appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", zza).appendQueryParameter("eventId", uuid).appendQueryParameter("v", "X" + stringExtra2).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zza2);
        return builder;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return zza(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    public static /* synthetic */ Uri zza(Uri uri, Task task) {
        Uri.Builder buildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.getError() != null) {
                String.valueOf(appCheckTokenResult.getError());
            }
            buildUpon.fragment("fac=" + appCheckTokenResult.getToken());
        } else {
            AbstractC0008a.A("Unexpected error getting App Check token: ", task.getException().getMessage(), zzb);
        }
        return buildUpon.build();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final String zza(String str) {
        String zza = zzaga.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza)) {
            return zzagd.zzb(str);
        }
        AbstractC0008a.A("Found hermetic configuration for identityToolkit URL: ", zza, zzb);
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) com.google.android.gms.internal.p002firebaseauthapi.zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            zzaej.zza.e("Error generating connection", new Object[0]);
            return null;
        }
    }

    public static void zza(RecaptchaActivity recaptchaActivity, String str, Task task) {
        if (recaptchaActivity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null) {
            List<ResolveInfo> queryIntentServices = recaptchaActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                C0635j a2 = new C0634i().a();
                Intent intent = a2.f6192a;
                intent.addFlags(1073741824);
                intent.addFlags(268435456);
                intent.setData((Uri) task.getResult());
                recaptchaActivity.startActivity(intent, a2.f6193b);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
            intent2.putExtra("com.android.browser.application_id", str);
            intent2.addFlags(1073741824);
            intent2.addFlags(268435456);
            recaptchaActivity.startActivity(intent2);
            return;
        }
        Log.e(zzb, "Device cannot resolve intent for: android.intent.action.VIEW");
        zzaem.zzb(recaptchaActivity, str);
    }

    private final void zza(Status status) {
        zzc = 0L;
        this.zze = false;
        Intent intent = new Intent();
        zzce.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        zza(intent);
        zzd.zza(this);
        finish();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final void zza(String str, Status status) {
        if (status == null) {
            zzb();
        } else {
            zza(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final void zza(final Uri uri, final String str, Provider<InteropAppCheckTokenProvider> provider) {
        Task forResult;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = provider.get();
        if (interopAppCheckTokenProvider != null) {
            forResult = interopAppCheckTokenProvider.getToken(false).continueWith(new Continuation() { // from class: com.google.firebase.auth.internal.zzbp
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return RecaptchaActivity.zza(uri, task);
                }
            });
        } else {
            forResult = Tasks.forResult(uri);
        }
        forResult.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzbn
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                RecaptchaActivity.zza(RecaptchaActivity.this, str, task);
            }
        });
    }

    private final boolean zza(Intent intent) {
        return C0427c.a(this).c(intent);
    }
}
