package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.gass.AdShield2Logger;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzayo {

    @GuardedBy("lock")
    private static boolean enabled = false;

    @GuardedBy("lock")
    private static boolean zzdvs = false;
    private final List<String> zzdvu;
    private static Object lock = new Object();
    private static Clock zzbmq = DefaultClock.getInstance();
    private static final Set<String> zzdvt = new HashSet(Arrays.asList(new String[0]));

    public zzayo() {
        this(null);
    }

    public zzayo(@Nullable String str) {
        List<String> asList;
        if (isEnabled()) {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            asList = Arrays.asList(strArr);
        } else {
            asList = new ArrayList<>();
        }
        this.zzdvu = asList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(int i, Map map, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(String str, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(byte[] bArr, JsonWriter jsonWriter) {
        String str;
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length >= 10000) {
            encode = zzayk.zzes(encode);
            str = encode != null ? "bodydigest" : "body";
            jsonWriter.name("bodylength").value(length);
            jsonWriter.endObject();
        }
        jsonWriter.name(str).value(encode);
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (lock) {
            z = zzdvs && enabled;
        }
        return z;
    }

    private static void zza(JsonWriter jsonWriter, @Nullable Map<String, ?> map) {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (!zzdvt.contains(key)) {
                if (!(next.getValue() instanceof List)) {
                    if (!(next.getValue() instanceof String)) {
                        zzayu.zzex("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                        break;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.NAME).value(key);
                    jsonWriter.name("value").value((String) next.getValue());
                    jsonWriter.endObject();
                } else {
                    for (String str : (List) next.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.NAME).value(key);
                        jsonWriter.name("value").value(str);
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void zza(String str, zzayv zzayvVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbmq.currentTimeMillis());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            Iterator<String> it = this.zzdvu.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next());
            }
            jsonWriter.endArray();
            zzayvVar.zzb(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzayu.zzc("unable to log", e);
        }
        zzew(stringWriter.toString());
    }

    public static void zzar(boolean z) {
        synchronized (lock) {
            zzdvs = true;
            enabled = z;
        }
    }

    private final void zzb(final String str, final String str2, @Nullable final Map<String, ?> map, @Nullable final byte[] bArr) {
        zza("onNetworkRequest", new zzayv(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.zzayr
            private final String zzcyr;
            private final Map zzcyw;
            private final String zzcyz;
            private final byte[] zzdvx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyz = str;
                this.zzcyr = str2;
                this.zzcyw = map;
                this.zzdvx = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzayv
            public final void zzb(JsonWriter jsonWriter) {
                zzayo.a(this.zzcyz, this.zzcyr, this.zzcyw, this.zzdvx, jsonWriter);
            }
        });
    }

    private final void zzb(@Nullable final Map<String, ?> map, final int i) {
        zza("onNetworkResponse", new zzayv(i, map) { // from class: com.google.android.gms.internal.ads.zzayq
            private final int zzdvv;
            private final Map zzdvw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdvv = i;
                this.zzdvw = map;
            }

            @Override // com.google.android.gms.internal.ads.zzayv
            public final void zzb(JsonWriter jsonWriter) {
                zzayo.a(this.zzdvv, this.zzdvw, jsonWriter);
            }
        });
    }

    public static boolean zzbo(Context context) {
        if (Build.VERSION.SDK_INT < 17 || !zzaax.zzctd.get().booleanValue()) {
            return false;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Exception e) {
            zzayu.zzd("Fail to determine debug setting.", e);
            return false;
        }
    }

    private final void zzev(@Nullable final String str) {
        zza("onNetworkRequestError", new zzayv(str) { // from class: com.google.android.gms.internal.ads.zzays
            private final String zzcyz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyz = str;
            }

            @Override // com.google.android.gms.internal.ads.zzayv
            public final void zzb(JsonWriter jsonWriter) {
                zzayo.a(this.zzcyz, jsonWriter);
            }
        });
    }

    private static synchronized void zzew(String str) {
        synchronized (zzayo.class) {
            zzayu.zzey("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + AdShield2Logger.EVENTID_ERROR_RUN_VM_INIT;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzayu.zzey(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzayu.zzey("GMA Debug FINISH");
        }
    }

    public static void zzxk() {
        synchronized (lock) {
            zzdvs = false;
            enabled = false;
            zzayu.zzez("Ad debug logging enablement is out of date.");
        }
    }

    public static boolean zzxl() {
        boolean z;
        synchronized (lock) {
            z = zzdvs;
        }
        return z;
    }

    public final void zza(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    zzayu.zzez(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzev(str);
            }
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        if (isEnabled()) {
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zza(@Nullable Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzev(null);
            }
        }
    }

    public final void zzeu(@Nullable String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(final byte[] bArr) {
        zza("onNetworkResponseBody", new zzayv(bArr) { // from class: com.google.android.gms.internal.ads.zzayt
            private final byte[] zzdvy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdvy = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzayv
            public final void zzb(JsonWriter jsonWriter) {
                zzayo.a(this.zzdvy, jsonWriter);
            }
        });
    }
}
