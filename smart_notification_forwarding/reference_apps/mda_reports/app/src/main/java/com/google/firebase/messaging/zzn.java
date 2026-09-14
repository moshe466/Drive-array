package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zzn {

    @NonNull
    private final Bundle zza;

    public zzn(@NonNull Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.zza = new Bundle(bundle);
    }

    public static boolean zza(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(zzi("gcm.n.e"))) || bundle.getString("gcm.n.icon") != null || bundle.getString(zzi("gcm.n.icon")) != null;
    }

    @Nullable
    private final String zzb(Resources resources, String str, String str2) {
        String zze = zze(str2);
        if (TextUtils.isEmpty(zze)) {
            return null;
        }
        int identifier = resources.getIdentifier(zze, "string", str);
        if (identifier == 0) {
            String valueOf = String.valueOf(str2);
            String zzh = zzh("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
            StringBuilder sb = new StringBuilder(String.valueOf(zzh).length() + 49 + String.valueOf(str2).length());
            sb.append(zzh);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
        Object[] zzf = zzf(str2);
        if (zzf == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, zzf);
        } catch (MissingFormatArgumentException e) {
            String zzh2 = zzh(str2);
            String arrays = Arrays.toString(zzf);
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzh2).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(zzh2);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("NotificationParams", sb2.toString(), e);
            return null;
        }
    }

    @Nullable
    private final JSONArray zzg(String str) {
        String zza = zza(str);
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        try {
            return new JSONArray(zza);
        } catch (JSONException unused) {
            String zzh = zzh(str);
            StringBuilder sb = new StringBuilder(String.valueOf(zzh).length() + 50 + String.valueOf(zza).length());
            sb.append("Malformed JSON for key ");
            sb.append(zzh);
            sb.append(": ");
            sb.append(zza);
            sb.append(", falling back to default");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    private static String zzh(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    private static String zzi(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final int[] a() {
        String sb;
        JSONArray zzg = zzg("gcm.n.light_settings");
        if (zzg == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (zzg.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            int parseColor = Color.parseColor(zzg.optString(0));
            if (parseColor == -16777216) {
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            iArr[0] = parseColor;
            iArr[1] = zzg.optInt(1);
            iArr[2] = zzg.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e) {
            String valueOf = String.valueOf(zzg);
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 60 + String.valueOf(message).length());
            sb2.append("LightSettings is invalid: ");
            sb2.append(valueOf);
            sb2.append(". ");
            sb2.append(message);
            sb2.append(". Skipping setting LightSettings");
            sb = sb2.toString();
            Log.w("NotificationParams", sb);
            return null;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(zzg);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 58);
            sb3.append("LightSettings is invalid: ");
            sb3.append(valueOf2);
            sb3.append(". Skipping setting LightSettings");
            sb = sb3.toString();
            Log.w("NotificationParams", sb);
            return null;
        }
    }

    @Nullable
    public final Uri zza() {
        String zza = zza("gcm.n.link_android");
        if (TextUtils.isEmpty(zza)) {
            zza = zza("gcm.n.link");
        }
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        return Uri.parse(zza);
    }

    public final String zza(Resources resources, String str, String str2) {
        String zza = zza(str2);
        return !TextUtils.isEmpty(zza) ? zza : zzb(resources, str, str2);
    }

    public final String zza(String str) {
        Bundle bundle = this.zza;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String zzi = zzi(str);
            if (this.zza.containsKey(zzi)) {
                str = zzi;
            }
        }
        return bundle.getString(str);
    }

    @Nullable
    public final String zzb() {
        String zza = zza("gcm.n.sound2");
        return TextUtils.isEmpty(zza) ? zza("gcm.n.sound") : zza;
    }

    public final boolean zzb(String str) {
        String zza = zza(str);
        return "1".equals(zza) || Boolean.parseBoolean(zza);
    }

    public final Integer zzc(String str) {
        String zza = zza(str);
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(zza));
        } catch (NumberFormatException unused) {
            String zzh = zzh(str);
            StringBuilder sb = new StringBuilder(String.valueOf(zzh).length() + 38 + String.valueOf(zza).length());
            sb.append("Couldn't parse value of ");
            sb.append(zzh);
            sb.append("(");
            sb.append(zza);
            sb.append(") into an int");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    @Nullable
    public final long[] zzc() {
        JSONArray zzg = zzg("gcm.n.vibrate_timings");
        if (zzg == null) {
            return null;
        }
        try {
            if (zzg.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            long[] jArr = new long[zzg.length()];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = zzg.optLong(i);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            String valueOf = String.valueOf(zzg);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting vibrateTimings.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final Long zzd(String str) {
        String zza = zza(str);
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(zza));
        } catch (NumberFormatException unused) {
            String zzh = zzh(str);
            StringBuilder sb = new StringBuilder(String.valueOf(zzh).length() + 38 + String.valueOf(zza).length());
            sb.append("Couldn't parse value of ");
            sb.append(zzh);
            sb.append("(");
            sb.append(zza);
            sb.append(") into a long");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final Bundle zze() {
        Bundle bundle = new Bundle(this.zza);
        for (String str : this.zza.keySet()) {
            if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    @Nullable
    public final String zze(String str) {
        String valueOf = String.valueOf(str);
        return zza("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    public final Bundle zzf() {
        Bundle bundle = new Bundle(this.zza);
        for (String str : this.zza.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    @Nullable
    public final Object[] zzf(String str) {
        String valueOf = String.valueOf(str);
        JSONArray zzg = zzg("_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (zzg == null) {
            return null;
        }
        String[] strArr = new String[zzg.length()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = zzg.optString(i);
        }
        return strArr;
    }
}
