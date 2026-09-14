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
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeh;
import com.google.android.gms.internal.p002firebaseauthapi.zzaej;
import com.google.android.gms.internal.p002firebaseauthapi.zzaem;
import com.google.android.gms.internal.p002firebaseauthapi.zzaga;
import com.google.android.gms.internal.p002firebaseauthapi.zzagd;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.tika.utils.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import r.C0634i;
import r.C0635j;

/* loaded from: classes.dex */
public class GenericIdpActivity extends L implements zzaej {
    private static long zzb;
    private static final zzcg zzc = zzcg.zzc();
    private boolean zzd = false;

    private final void zzb() {
        zzb = 0L;
        this.zzd = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!zza(intent)) {
            zzbl.zza(this, zzao.zza("WEB_CONTEXT_CANCELED"));
        } else {
            zzc.zza(this);
        }
        finish();
    }

    @Override // androidx.fragment.app.L, c.m, w.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            AbstractC0008a.A("Could not do operation - unknown action: ", action, "GenericIdpActivity");
            zzb();
            return;
        }
        long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
        if (currentTimeMillis - zzb < 30000) {
            Log.e("GenericIdpActivity", "Could not start operation - already in progress");
            return;
        }
        zzb = currentTimeMillis;
        if (bundle != null) {
            this.zzd = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
        }
    }

    @Override // c.m, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.L, android.app.Activity
    public void onResume() {
        GenericIdpActivity genericIdpActivity;
        super.onResume();
        if ("android.intent.action.VIEW".equals(getIntent().getAction())) {
            Intent intent = getIntent();
            if (intent.hasExtra("firebaseError")) {
                zza(zzce.zza(intent.getStringExtra("firebaseError")));
                return;
            }
            if (intent.hasExtra("link") && intent.hasExtra("eventId")) {
                String stringExtra = intent.getStringExtra("link");
                String stringExtra2 = intent.getStringExtra("eventId");
                String packageName = getPackageName();
                boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
                zzr zza = zzo.zza().zza(this, packageName, stringExtra2);
                if (zza == null) {
                    zzb();
                }
                if (booleanExtra) {
                    stringExtra = zzq.zza(getApplicationContext(), FirebaseApp.getInstance(zza.zza()).getPersistenceKey()).zza(stringExtra);
                }
                zzait zzaitVar = new zzait(zza, stringExtra);
                String zze = zza.zze();
                String zzb2 = zza.zzb();
                zzaitVar.zzb(zze);
                if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(zzb2) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(zzb2) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(zzb2)) {
                    AbstractC0008a.A("unsupported operation: ", zzb2, "GenericIdpActivity");
                    zzb();
                    return;
                }
                zzb = 0L;
                this.zzd = false;
                Intent intent2 = new Intent();
                SafeParcelableSerializer.serializeToIntentExtra(zzaitVar, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", zzb2);
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!zza(intent2)) {
                    zzbl.zza(getApplicationContext(), zzaitVar, zzb2, zze);
                } else {
                    zzc.zza(this);
                }
                finish();
                return;
            }
            zzb();
            return;
        }
        if (!this.zzd) {
            String packageName2 = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName2)).toLowerCase(Locale.US);
                FirebaseApp firebaseApp = FirebaseApp.getInstance(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
                if (!zzagd.zza(firebaseApp)) {
                    genericIdpActivity = this;
                    new zzaeh(packageName2, lowerCase, getIntent(), firebaseApp, genericIdpActivity).executeOnExecutor(firebaseAuth.zze(), new Void[0]);
                } else {
                    genericIdpActivity = this;
                    zza(zza(Uri.parse(zzagd.zza(firebaseApp.getOptions().getApiKey())).buildUpon(), getIntent(), packageName2, lowerCase).build(), packageName2, firebaseAuth.zzc());
                }
            } catch (PackageManager.NameNotFoundException e4) {
                genericIdpActivity = this;
                Log.e("GenericIdpActivity", "Could not get package signature: " + packageName2 + StringUtils.SPACE + String.valueOf(e4));
                zzaem.zzb(this, packageName2);
            }
            genericIdpActivity.zzd = true;
            return;
        }
        zzb();
    }

    @Override // c.m, w.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final Context zza() {
        return getApplicationContext();
    }

    private final Uri.Builder zza(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        String zza = zza(intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS"));
        String uuid = UUID.randomUUID().toString();
        String zza2 = zzaem.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        zzo.zza().zza(getApplicationContext(), str, uuid, zza2, action, stringExtra2, stringExtra3, stringExtra4);
        String zza3 = zzq.zza(getApplicationContext(), FirebaseApp.getInstance(stringExtra4).getPersistenceKey()).zza();
        if (TextUtils.isEmpty(zza3)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            zza(zzao.zza("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        }
        if (zza2 == null) {
            return null;
        }
        builder.appendQueryParameter("eid", "p").appendQueryParameter("v", "X" + stringExtra5).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", zza2).appendQueryParameter("eventId", uuid).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zza3);
        if (!TextUtils.isEmpty(join)) {
            builder.appendQueryParameter("scopes", join);
        }
        if (!TextUtils.isEmpty(zza)) {
            builder.appendQueryParameter("customParameters", zza);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            builder.appendQueryParameter("tid", stringExtra3);
        }
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
            AbstractC0008a.A("Unexpected error getting App Check token: ", task.getException().getMessage(), "GenericIdpActivity");
        }
        return buildUpon.build();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final String zza(String str) {
        String zza = zzaga.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza)) {
            return zzagd.zzb(str);
        }
        AbstractC0008a.A("Found hermetic configuration for identityToolkit URL: ", zza, "GenericIdpActivity");
        return zza;
    }

    private static String zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(str, string);
                }
            }
        } catch (JSONException unused) {
            Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
        }
        return jSONObject.toString();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaej
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) com.google.android.gms.internal.p002firebaseauthapi.zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    public static void zza(GenericIdpActivity genericIdpActivity, String str, Task task) {
        if (genericIdpActivity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null) {
            List<ResolveInfo> queryIntentServices = genericIdpActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                C0635j a2 = new C0634i().a();
                Uri uri = (Uri) task.getResult();
                Intent intent = a2.f6192a;
                intent.setData(uri);
                genericIdpActivity.startActivity(intent, a2.f6193b);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
            intent2.putExtra("com.android.browser.application_id", str);
            intent2.addFlags(1073741824);
            intent2.addFlags(268435456);
            genericIdpActivity.startActivity(intent2);
            return;
        }
        Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
        zzaem.zzb(genericIdpActivity, str);
    }

    private final void zza(Status status) {
        zzb = 0L;
        this.zzd = false;
        Intent intent = new Intent();
        zzce.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!zza(intent)) {
            zzbl.zza(getApplicationContext(), status);
        } else {
            zzc.zza(this);
        }
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
            forResult = interopAppCheckTokenProvider.getToken(false).continueWith(new Continuation() { // from class: com.google.firebase.auth.internal.zzbf
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return GenericIdpActivity.zza(uri, task);
                }
            });
        } else {
            forResult = Tasks.forResult(uri);
        }
        forResult.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzbg
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                GenericIdpActivity.zza(GenericIdpActivity.this, str, task);
            }
        });
    }

    private final boolean zza(Intent intent) {
        return C0427c.a(this).c(intent);
    }
}
