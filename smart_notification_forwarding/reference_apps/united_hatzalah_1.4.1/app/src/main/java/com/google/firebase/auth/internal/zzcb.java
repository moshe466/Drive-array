package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.google.firebase.auth.TotpMultiFactorInfo;
import e0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcb {
    private Context zza;
    private String zzb;
    private SharedPreferences zzc;
    private Logger zzd;

    public zzcb(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zza = context.getApplicationContext();
        this.zzc = this.zza.getSharedPreferences(a.d("com.google.firebase.auth.api.Store.", this.zzb), 0);
        this.zzd = new Logger("StorageHelpers", new String[0]);
    }

    private final void zzb(String str) {
        this.zzc.edit().remove(str).apply();
    }

    private final String zzd(FirebaseUser firebaseUser) {
        boolean z3;
        JSONObject jSONObject = new JSONObject();
        if (zzaf.class.isAssignableFrom(firebaseUser.getClass())) {
            zzaf zzafVar = (zzaf) firebaseUser;
            try {
                jSONObject.put("cachedTokenState", zzafVar.zze());
                jSONObject.put("applicationName", zzafVar.zza().getName());
                jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (zzafVar.zzj() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List<zzab> zzj = zzafVar.zzj();
                    int size = zzj.size();
                    if (zzj.size() > 30) {
                        this.zzd.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(zzj.size()));
                        size = 30;
                    }
                    int i = 0;
                    boolean z4 = false;
                    while (true) {
                        z3 = true;
                        if (i >= size) {
                            break;
                        }
                        zzab zzabVar = zzj.get(i);
                        if (zzabVar.getProviderId().equals("firebase")) {
                            z4 = true;
                        }
                        if (i == size - 1 && !z4) {
                            break;
                        }
                        jSONArray.put(zzabVar.zzb());
                        i++;
                    }
                    if (!z4) {
                        for (int i3 = size - 1; i3 < zzj.size() && i3 >= 0; i3++) {
                            zzab zzabVar2 = zzj.get(i3);
                            if (zzabVar2.getProviderId().equals("firebase")) {
                                jSONArray.put(zzabVar2.zzb());
                                break;
                            }
                            if (i3 == zzj.size() - 1) {
                                jSONArray.put(zzabVar2.zzb());
                            }
                        }
                        z3 = z4;
                        if (!z3) {
                            this.zzd.w("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(zzj.size()), Integer.valueOf(size));
                            if (zzj.size() < 5) {
                                StringBuilder sb = new StringBuilder("Provider user info list:\n");
                                Iterator<zzab> it = zzj.iterator();
                                while (it.hasNext()) {
                                    sb.append("Provider - " + it.next().getProviderId() + "\n");
                                }
                                this.zzd.w(sb.toString(), new Object[0]);
                            }
                        }
                    }
                    jSONObject.put("userInfos", jSONArray);
                }
                jSONObject.put("anonymous", zzafVar.isAnonymous());
                jSONObject.put("version", "2");
                if (zzafVar.getMetadata() != null) {
                    jSONObject.put("userMetadata", ((zzah) zzafVar.getMetadata()).zza());
                }
                List<MultiFactorInfo> enrolledFactors = ((zzaj) zzafVar.getMultiFactor()).getEnrolledFactors();
                if (enrolledFactors != null && !enrolledFactors.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < enrolledFactors.size(); i4++) {
                        jSONArray2.put(enrolledFactors.get(i4).toJson());
                    }
                    jSONObject.put("userMultiFactorInfo", jSONArray2);
                }
                List<com.google.firebase.auth.zzal> zzf = zzafVar.zzf();
                if (zzf != null && !zzf.isEmpty()) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (int i5 = 0; i5 < zzf.size(); i5++) {
                        jSONArray3.put(com.google.firebase.auth.zzal.zza(zzf.get(i5)));
                    }
                    jSONObject.put("passkeyInfo", jSONArray3);
                }
                return jSONObject.toString();
            } catch (Exception e4) {
                this.zzd.wtf("Failed to turn object into JSON", e4, new Object[0]);
                throw new zzaag(e4);
            }
        }
        return null;
    }

    public final FirebaseUser zza() {
        String zza = zza("com.google.firebase.auth.FIREBASE_USER");
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(zza);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zza(jSONObject);
            }
        } catch (Exception unused) {
            this.zzd.i("Failed to restore user data from persistent storage.", new Object[0]);
        }
        return null;
    }

    public final void zzc(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String zzd = zzd(firebaseUser);
        if (!TextUtils.isEmpty(zzd)) {
            zza("com.google.firebase.auth.FIREBASE_USER", zzd);
        }
    }

    public final void zzb() {
        zzb("com.google.firebase.auth.FIREBASE_USER");
    }

    public final void zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        zzb(a.d("com.google.firebase.auth.GET_TOKEN_RESPONSE.", firebaseUser.getUid()));
    }

    public final zzahn zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String zza = zza(a.d("com.google.firebase.auth.GET_TOKEN_RESPONSE.", firebaseUser.getUid()));
        if (zza == null) {
            return null;
        }
        try {
            return zzahn.zzb(zza);
        } catch (zzaag unused) {
            this.zzd.i("Failed to restore token data from persistent storage.", new Object[0]);
            return null;
        }
    }

    private final zzaf zza(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        SafeParcelable zza;
        zzah zza2;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z3 = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzab.zza(jSONArray3.getString(i)));
            }
            zzaf zzafVar = new zzaf(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzafVar.zza(zzahn.zzb(string));
            }
            if (!z3) {
                zzafVar.zzb();
            }
            zzafVar.zza(str);
            if (jSONObject.has("userMetadata") && (zza2 = zzah.zza(jSONObject.getJSONObject("userMetadata"))) != null) {
                zzafVar.zza(zza2);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i3));
                    String optString = jSONObject2.optString(MultiFactorInfo.FACTOR_ID_KEY);
                    if ("phone".equals(optString)) {
                        zza = PhoneMultiFactorInfo.zza(jSONObject2);
                    } else {
                        zza = Objects.equals(optString, TotpMultiFactorGenerator.FACTOR_ID) ? TotpMultiFactorInfo.zza(jSONObject2) : null;
                    }
                    arrayList2.add(zza);
                }
                zzafVar.zzc(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    arrayList3.add(com.google.firebase.auth.zzal.zza(new JSONObject(jSONArray.getString(i4))));
                }
                zzafVar.zzb(arrayList3);
            }
            return zzafVar;
        } catch (zzaag e4) {
            e = e4;
            this.zzd.wtf(e);
            return null;
        } catch (ArrayIndexOutOfBoundsException e5) {
            e = e5;
            this.zzd.wtf(e);
            return null;
        } catch (IllegalArgumentException e6) {
            e = e6;
            this.zzd.wtf(e);
            return null;
        } catch (JSONException e7) {
            e = e7;
            this.zzd.wtf(e);
            return null;
        }
    }

    private final String zza(String str) {
        String string = this.zzc.getString(str, null);
        if (string != null) {
            return string.startsWith("ENCRYPTED:") ? zzby.zza(this.zza, this.zzb).zza(string.substring(10)) : string;
        }
        return null;
    }

    private final void zza(String str, String str2) {
        String zzb = zzby.zza(this.zza, this.zzb).zzb(str2);
        if (zzb != null) {
            this.zzc.edit().putString(str, "ENCRYPTED:".concat(zzb)).apply();
        }
    }

    public final void zza(FirebaseUser firebaseUser, zzahn zzahnVar) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzahnVar);
        zza(a.d("com.google.firebase.auth.GET_TOKEN_RESPONSE.", firebaseUser.getUid()), zzahnVar.zzf());
    }
}
