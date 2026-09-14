package com.google.android.gms.ads.rewarded;

/* loaded from: classes.dex */
public class ServerSideVerificationOptions {
    private final String zzdnv;
    private final String zzdnw;

    /* loaded from: classes.dex */
    public static final class Builder {
        private String zzdnv = "";
        private String zzdnw = "";

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public final Builder setCustomData(String str) {
            this.zzdnw = str;
            return this;
        }

        public final Builder setUserId(String str) {
            this.zzdnv = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.zzdnv = builder.zzdnv;
        this.zzdnw = builder.zzdnw;
    }

    public String getCustomData() {
        return this.zzdnw;
    }

    public String getUserId() {
        return this.zzdnv;
    }
}
