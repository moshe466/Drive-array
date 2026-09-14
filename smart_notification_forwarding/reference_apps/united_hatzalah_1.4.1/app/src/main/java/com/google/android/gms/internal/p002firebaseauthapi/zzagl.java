package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.Constants;
import e0.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzagl implements zzaer<zzagl> {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzagl";
    private String zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagl zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString(io.flutter.plugins.firebase.crashlytics.Constants.MESSAGE);
            return this;
        } catch (NullPointerException | JSONException e4) {
            Log.e(zza, "Failed to parse error for string [" + str + "] with exception: " + e4.getMessage());
            throw new zzaci(a.e("Failed to parse error for string [", str, "]"), e4);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
