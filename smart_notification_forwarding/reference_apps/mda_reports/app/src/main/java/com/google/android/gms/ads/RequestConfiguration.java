package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzayu;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class RequestConfiguration {
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    public static final List<String> zzabs = Arrays.asList("MA", "T", "PG", "G");
    private final int zzabo;
    private final int zzabp;
    private final String zzabq;
    private final List<String> zzabr;

    /* loaded from: classes.dex */
    public static class Builder {
        private int zzabo = -1;
        private int zzabp = -1;
        private String zzabq = null;
        private final List<String> zzabr = new ArrayList();

        public RequestConfiguration build() {
            return new RequestConfiguration(this.zzabo, this.zzabp, this.zzabq, this.zzabr);
        }

        public Builder setMaxAdContentRating(String str) {
            if (str == null || "".equals(str)) {
                str = null;
            } else if (!"G".equals(str) && !"PG".equals(str) && !"T".equals(str) && !"MA".equals(str)) {
                String valueOf = String.valueOf(str);
                zzayu.zzez(valueOf.length() != 0 ? "Invalid value passed to setMaxAdContentRating: ".concat(valueOf) : new String("Invalid value passed to setMaxAdContentRating: "));
                return this;
            }
            this.zzabq = str;
            return this;
        }

        public Builder setTagForChildDirectedTreatment(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzabo = i;
            } else {
                StringBuilder sb = new StringBuilder(68);
                sb.append("Invalid value passed to setTagForChildDirectedTreatment: ");
                sb.append(i);
                zzayu.zzez(sb.toString());
            }
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzabp = i;
            } else {
                StringBuilder sb = new StringBuilder(63);
                sb.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
                sb.append(i);
                zzayu.zzez(sb.toString());
            }
            return this;
        }

        public Builder setTestDeviceIds(@Nullable List<String> list) {
            this.zzabr.clear();
            if (list != null) {
                this.zzabr.addAll(list);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TagForUnderAgeOfConsent {
    }

    private RequestConfiguration(int i, int i2, String str, List<String> list) {
        this.zzabo = i;
        this.zzabp = i2;
        this.zzabq = str;
        this.zzabr = list;
    }

    public String getMaxAdContentRating() {
        String str = this.zzabq;
        return str == null ? "" : str;
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzabo;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzabp;
    }

    public List<String> getTestDeviceIds() {
        return new ArrayList(this.zzabr);
    }

    public Builder toBuilder() {
        return new Builder().setTagForChildDirectedTreatment(this.zzabo).setTagForUnderAgeOfConsent(this.zzabp).setMaxAdContentRating(this.zzabq).setTestDeviceIds(this.zzabr);
    }
}
