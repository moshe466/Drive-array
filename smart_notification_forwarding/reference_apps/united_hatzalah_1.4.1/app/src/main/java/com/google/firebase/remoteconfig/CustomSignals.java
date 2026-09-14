package com.google.firebase.remoteconfig;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CustomSignals {
    final Map<String, String> customSignals;

    /* loaded from: classes.dex */
    public static class Builder {
        private Map<String, String> customSignals = new HashMap();

        public CustomSignals build() {
            return new CustomSignals(this);
        }

        public Builder put(String str, String str2) {
            this.customSignals.put(str, str2);
            return this;
        }

        public Builder put(String str, long j2) {
            this.customSignals.put(str, Long.toString(j2));
            return this;
        }

        public Builder put(String str, double d2) {
            this.customSignals.put(str, Double.toString(d2));
            return this;
        }
    }

    public CustomSignals(Builder builder) {
        this.customSignals = builder.customSignals;
    }
}
