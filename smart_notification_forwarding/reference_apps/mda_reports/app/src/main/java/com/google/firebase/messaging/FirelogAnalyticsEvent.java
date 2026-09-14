package com.google.firebase.messaging;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: Access modifiers changed from: package-private */
@KeepForSdk
/* loaded from: classes2.dex */
public final class FirelogAnalyticsEvent {
    private final String zza;
    private final Intent zzb;

    /* loaded from: classes2.dex */
    static class zza implements ObjectEncoder<FirelogAnalyticsEvent> {
        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        public final /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
            FirelogAnalyticsEvent firelogAnalyticsEvent = (FirelogAnalyticsEvent) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            Intent a = firelogAnalyticsEvent.a();
            objectEncoderContext2.add("ttl", zzo.a(a));
            objectEncoderContext2.add(NotificationCompat.CATEGORY_EVENT, firelogAnalyticsEvent.b());
            objectEncoderContext2.add("instanceId", zzo.c());
            objectEncoderContext2.add("priority", zzo.h(a));
            objectEncoderContext2.add("packageName", zzo.b());
            objectEncoderContext2.add("sdkPlatform", "ANDROID");
            objectEncoderContext2.add("messageType", zzo.f(a));
            String e = zzo.e(a);
            if (e != null) {
                objectEncoderContext2.add("messageId", e);
            }
            String g = zzo.g(a);
            if (g != null) {
                objectEncoderContext2.add("topic", g);
            }
            String b = zzo.b(a);
            if (b != null) {
                objectEncoderContext2.add("collapseKey", b);
            }
            if (zzo.d(a) != null) {
                objectEncoderContext2.add("analyticsLabel", zzo.d(a));
            }
            if (zzo.c(a) != null) {
                objectEncoderContext2.add("composerLabel", zzo.c(a));
            }
            String d = zzo.d();
            if (d != null) {
                objectEncoderContext2.add("projectNumber", d);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class zzb implements ObjectEncoder<zzc> {
        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        public final /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("messaging_client_event", ((zzc) obj).a());
        }
    }

    /* loaded from: classes2.dex */
    static final class zzc {
        private final FirelogAnalyticsEvent zza;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzc(@NonNull FirelogAnalyticsEvent firelogAnalyticsEvent) {
            this.zza = (FirelogAnalyticsEvent) Preconditions.checkNotNull(firelogAnalyticsEvent);
        }

        @NonNull
        final FirelogAnalyticsEvent a() {
            return this.zza;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirelogAnalyticsEvent(@NonNull String str, @NonNull Intent intent) {
        this.zza = Preconditions.checkNotEmpty(str, "evenType must be non-null");
        this.zzb = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }

    @NonNull
    final Intent a() {
        return this.zzb;
    }

    @NonNull
    final String b() {
        return this.zza;
    }
}
