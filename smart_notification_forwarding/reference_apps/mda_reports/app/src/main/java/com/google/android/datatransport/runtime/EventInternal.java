package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@AutoValue
/* loaded from: classes.dex */
public abstract class EventInternal {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        protected abstract Builder a(Map<String, String> map);

        protected abstract Map<String, String> a();

        public final Builder addMetadata(String str, int i) {
            a().put(str, String.valueOf(i));
            return this;
        }

        public final Builder addMetadata(String str, long j) {
            a().put(str, String.valueOf(j));
            return this;
        }

        public final Builder addMetadata(String str, String str2) {
            a().put(str, str2);
            return this;
        }

        public abstract EventInternal build();

        public abstract Builder setCode(Integer num);

        public abstract Builder setEncodedPayload(EncodedPayload encodedPayload);

        public abstract Builder setEventMillis(long j);

        public abstract Builder setTransportName(String str);

        public abstract Builder setUptimeMillis(long j);
    }

    public static Builder builder() {
        return new AutoValue_EventInternal.Builder().a(new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<String, String> a();

    public final String get(String str) {
        String str2 = a().get(str);
        return str2 == null ? "" : str2;
    }

    @Nullable
    public abstract Integer getCode();

    public abstract EncodedPayload getEncodedPayload();

    public abstract long getEventMillis();

    public final int getInteger(String str) {
        String str2 = a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long getLong(String str) {
        String str2 = a().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> getMetadata() {
        return Collections.unmodifiableMap(a());
    }

    public final String getOrDefault(String str, String str2) {
        String str3 = a().get(str);
        return str3 == null ? str2 : str3;
    }

    @Deprecated
    public byte[] getPayload() {
        return getEncodedPayload().getBytes();
    }

    public abstract String getTransportName();

    public abstract long getUptimeMillis();

    public Builder toBuilder() {
        return new AutoValue_EventInternal.Builder().setTransportName(getTransportName()).setCode(getCode()).setEncodedPayload(getEncodedPayload()).setEventMillis(getEventMillis()).setUptimeMillis(getUptimeMillis()).a(new HashMap(a()));
    }
}
