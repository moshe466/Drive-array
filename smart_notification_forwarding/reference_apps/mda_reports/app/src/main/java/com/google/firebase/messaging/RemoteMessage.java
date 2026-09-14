package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzq();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    @SafeParcelable.Field(id = 2)
    Bundle a;
    private Map<String, String> zzb;
    private Notification zzc;

    /* loaded from: classes2.dex */
    public static class Builder {
        private final Bundle zza = new Bundle();
        private final Map<String, String> zzb = new ArrayMap();

        public Builder(@NonNull String str) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid to: ".concat(valueOf) : new String("Invalid to: "));
            }
            this.zza.putString("google.to", str);
        }

        @NonNull
        public Builder addData(@NonNull String str, @Nullable String str2) {
            this.zzb.put(str, str2);
            return this;
        }

        @NonNull
        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : this.zzb.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            bundle.putAll(this.zza);
            this.zza.remove("from");
            return new RemoteMessage(bundle);
        }

        @NonNull
        public Builder clearData() {
            this.zzb.clear();
            return this;
        }

        @NonNull
        public Builder setCollapseKey(@Nullable String str) {
            this.zza.putString("collapse_key", str);
            return this;
        }

        @NonNull
        public Builder setData(@NonNull Map<String, String> map) {
            this.zzb.clear();
            this.zzb.putAll(map);
            return this;
        }

        @NonNull
        public Builder setMessageId(@NonNull String str) {
            this.zza.putString("google.message_id", str);
            return this;
        }

        @NonNull
        public Builder setMessageType(@Nullable String str) {
            this.zza.putString("message_type", str);
            return this;
        }

        @NonNull
        public Builder setTtl(@IntRange(from = 0, to = 86400) int i) {
            this.zza.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MessagePriority {
    }

    /* loaded from: classes2.dex */
    public static class Notification {
        private final String zza;
        private final String zzb;
        private final String[] zzc;
        private final String zzd;
        private final String zze;
        private final String[] zzf;
        private final String zzg;
        private final String zzh;
        private final String zzi;
        private final String zzj;
        private final String zzk;
        private final String zzl;
        private final String zzm;
        private final Uri zzn;
        private final String zzo;
        private final Integer zzp;
        private final Integer zzq;
        private final Integer zzr;
        private final int[] zzs;
        private final Long zzt;
        private final boolean zzu;
        private final boolean zzv;
        private final boolean zzw;
        private final boolean zzx;
        private final boolean zzy;
        private final long[] zzz;

        private Notification(zzn zznVar) {
            this.zza = zznVar.zza("gcm.n.title");
            this.zzb = zznVar.zze("gcm.n.title");
            this.zzc = zza(zznVar, "gcm.n.title");
            this.zzd = zznVar.zza("gcm.n.body");
            this.zze = zznVar.zze("gcm.n.body");
            this.zzf = zza(zznVar, "gcm.n.body");
            this.zzg = zznVar.zza("gcm.n.icon");
            this.zzi = zznVar.zzb();
            this.zzj = zznVar.zza("gcm.n.tag");
            this.zzk = zznVar.zza("gcm.n.color");
            this.zzl = zznVar.zza("gcm.n.click_action");
            this.zzm = zznVar.zza("gcm.n.android_channel_id");
            this.zzn = zznVar.zza();
            this.zzh = zznVar.zza("gcm.n.image");
            this.zzo = zznVar.zza("gcm.n.ticker");
            this.zzp = zznVar.zzc("gcm.n.notification_priority");
            this.zzq = zznVar.zzc("gcm.n.visibility");
            this.zzr = zznVar.zzc("gcm.n.notification_count");
            this.zzu = zznVar.zzb("gcm.n.sticky");
            this.zzv = zznVar.zzb("gcm.n.local_only");
            this.zzw = zznVar.zzb("gcm.n.default_sound");
            this.zzx = zznVar.zzb("gcm.n.default_vibrate_timings");
            this.zzy = zznVar.zzb("gcm.n.default_light_settings");
            this.zzt = zznVar.zzd("gcm.n.event_time");
            this.zzs = zznVar.a();
            this.zzz = zznVar.zzc();
        }

        private static String[] zza(zzn zznVar, String str) {
            Object[] zzf = zznVar.zzf(str);
            if (zzf == null) {
                return null;
            }
            String[] strArr = new String[zzf.length];
            for (int i = 0; i < zzf.length; i++) {
                strArr[i] = String.valueOf(zzf[i]);
            }
            return strArr;
        }

        @Nullable
        public String getBody() {
            return this.zzd;
        }

        @Nullable
        public String[] getBodyLocalizationArgs() {
            return this.zzf;
        }

        @Nullable
        public String getBodyLocalizationKey() {
            return this.zze;
        }

        @Nullable
        public String getChannelId() {
            return this.zzm;
        }

        @Nullable
        public String getClickAction() {
            return this.zzl;
        }

        @Nullable
        public String getColor() {
            return this.zzk;
        }

        public boolean getDefaultLightSettings() {
            return this.zzy;
        }

        public boolean getDefaultSound() {
            return this.zzw;
        }

        public boolean getDefaultVibrateSettings() {
            return this.zzx;
        }

        @Nullable
        public Long getEventTime() {
            return this.zzt;
        }

        @Nullable
        public String getIcon() {
            return this.zzg;
        }

        @Nullable
        public Uri getImageUrl() {
            String str = this.zzh;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        @Nullable
        public int[] getLightSettings() {
            return this.zzs;
        }

        @Nullable
        public Uri getLink() {
            return this.zzn;
        }

        public boolean getLocalOnly() {
            return this.zzv;
        }

        @Nullable
        public Integer getNotificationCount() {
            return this.zzr;
        }

        @Nullable
        public Integer getNotificationPriority() {
            return this.zzp;
        }

        @Nullable
        public String getSound() {
            return this.zzi;
        }

        public boolean getSticky() {
            return this.zzu;
        }

        @Nullable
        public String getTag() {
            return this.zzj;
        }

        @Nullable
        public String getTicker() {
            return this.zzo;
        }

        @Nullable
        public String getTitle() {
            return this.zza;
        }

        @Nullable
        public String[] getTitleLocalizationArgs() {
            return this.zzc;
        }

        @Nullable
        public String getTitleLocalizationKey() {
            return this.zzb;
        }

        @Nullable
        public long[] getVibrateTimings() {
            return this.zzz;
        }

        @Nullable
        public Integer getVisibility() {
            return this.zzq;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.a = bundle;
    }

    private static int zza(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public final String getCollapseKey() {
        return this.a.getString("collapse_key");
    }

    @NonNull
    public final Map<String, String> getData() {
        if (this.zzb == null) {
            Bundle bundle = this.a;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.zzb = arrayMap;
        }
        return this.zzb;
    }

    @Nullable
    public final String getFrom() {
        return this.a.getString("from");
    }

    @Nullable
    public final String getMessageId() {
        String string = this.a.getString("google.message_id");
        return string == null ? this.a.getString("message_id") : string;
    }

    @Nullable
    public final String getMessageType() {
        return this.a.getString("message_type");
    }

    @Nullable
    public final Notification getNotification() {
        if (this.zzc == null && zzn.zza(this.a)) {
            this.zzc = new Notification(new zzn(this.a));
        }
        return this.zzc;
    }

    public final int getOriginalPriority() {
        String string = this.a.getString("google.original_priority");
        if (string == null) {
            string = this.a.getString("google.priority");
        }
        return zza(string);
    }

    public final int getPriority() {
        String string = this.a.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.a.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.a.getString("google.priority");
        }
        return zza(string);
    }

    public final long getSentTime() {
        Object obj = this.a.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
            sb.append("Invalid sent time: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0L;
        }
    }

    @Nullable
    public final String getTo() {
        return this.a.getString("google.to");
    }

    public final int getTtl() {
        Object obj = this.a.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    @KeepForSdk
    public final Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.a);
        return intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
