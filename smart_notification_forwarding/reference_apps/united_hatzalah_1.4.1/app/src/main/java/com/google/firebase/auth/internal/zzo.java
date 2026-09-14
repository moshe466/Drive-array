package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzo {
    private static zzo zza = new zzo();

    private zzo() {
    }

    private static SharedPreferences zza(Context context, String str) {
        return context.getSharedPreferences("com.google.firebase.auth.internal.browserSignInSessionStore." + str, 0);
    }

    public final synchronized String zzb(Context context, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        SharedPreferences zza2 = zza(context, str);
        String str3 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".OPERATION";
        String string = zza2.getString(str3, null);
        String str4 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".FIREBASE_APP_NAME";
        String string2 = zza2.getString(str4, null);
        SharedPreferences.Editor edit = zza2.edit();
        edit.remove(str3);
        edit.remove(str4);
        edit.apply();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string2;
    }

    public final synchronized zzr zza(Context context, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        SharedPreferences zza2 = zza(context, str);
        String str3 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".SESSION_ID";
        String str4 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".OPERATION";
        String str5 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".PROVIDER_ID";
        String str6 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".FIREBASE_APP_NAME";
        String string = zza2.getString(str3, null);
        String string2 = zza2.getString(str4, null);
        String string3 = zza2.getString(str5, null);
        String string4 = zza2.getString("com.google.firebase.auth.api.gms.config.tenant.id", null);
        String string5 = zza2.getString(str6, null);
        SharedPreferences.Editor edit = zza2.edit();
        edit.remove(str3);
        edit.remove(str4);
        edit.remove(str5);
        edit.remove(str6);
        edit.apply();
        if (string == null || string2 == null || string3 == null) {
            return null;
        }
        return new zzr(string, string2, string3, string4, string5);
    }

    public static zzo zza() {
        return zza;
    }

    private static void zza(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Iterator<String> it = sharedPreferences.getAll().keySet().iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.apply();
    }

    public final synchronized void zza(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotEmpty(str7);
        SharedPreferences zza2 = zza(context, str);
        zza(zza2);
        SharedPreferences.Editor edit = zza2.edit();
        edit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".SESSION_ID", str3);
        edit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".OPERATION", str4);
        edit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".PROVIDER_ID", str5);
        edit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".FIREBASE_APP_NAME", str7);
        edit.putString("com.google.firebase.auth.api.gms.config.tenant.id", str6);
        edit.apply();
    }

    public final synchronized void zza(Context context, String str, String str2, String str3, String str4) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        SharedPreferences zza2 = zza(context, str);
        zza(zza2);
        SharedPreferences.Editor edit = zza2.edit();
        edit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".OPERATION", str3);
        edit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".FIREBASE_APP_NAME", str4);
        edit.apply();
    }
}
