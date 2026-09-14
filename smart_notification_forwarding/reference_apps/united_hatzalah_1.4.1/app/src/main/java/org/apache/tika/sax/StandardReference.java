package org.apache.tika.sax;

import F0.AbstractC0008a;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class StandardReference {
    private String identifier;
    private String mainOrganization;
    private double score;
    private String secondOrganization;
    private String separator;

    /* loaded from: classes.dex */
    public static class StandardReferenceBuilder {
        private final String identifier;
        private final String mainOrganization;
        private String separator = null;
        private String secondOrganization = null;
        private double score = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

        public StandardReferenceBuilder(String str, String str2) {
            this.mainOrganization = str;
            this.identifier = str2;
        }

        public StandardReference build() {
            return new StandardReference(this.mainOrganization, this.separator, this.secondOrganization, this.identifier, this.score, 0);
        }

        public StandardReferenceBuilder setScore(double d2) {
            this.score = d2;
            return this;
        }

        public StandardReferenceBuilder setSecondOrganization(String str, String str2) {
            this.separator = str;
            this.secondOrganization = str2;
            return this;
        }
    }

    public /* synthetic */ StandardReference(String str, String str2, String str3, String str4, double d2, int i) {
        this(str, str2, str3, str4, d2);
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getMainOrganizationAcronym() {
        return this.mainOrganization;
    }

    public double getScore() {
        return this.score;
    }

    public String getSecondOrganizationAcronym() {
        return this.secondOrganization;
    }

    public String getSeparator() {
        return this.separator;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setMainOrganizationAcronym(String str) {
        this.mainOrganization = str;
    }

    public void setScore(double d2) {
        this.score = d2;
    }

    public void setSecondOrganizationAcronym(String str) {
        this.secondOrganization = str;
    }

    public void setSeparator(String str) {
        this.separator = str;
    }

    public String toString() {
        String str = this.mainOrganization;
        String str2 = this.separator;
        if (str2 != null && !str2.isEmpty()) {
            str = AbstractC0008a.o(str, this.separator, this.secondOrganization);
        }
        return AbstractC0008a.o(str, StringUtils.SPACE, this.identifier);
    }

    private StandardReference(String str, String str2, String str3, String str4, double d2) {
        this.mainOrganization = str;
        this.separator = str2;
        this.secondOrganization = str3;
        this.identifier = str4;
        this.score = d2;
    }
}
