package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class SplitInstallRequest {
    private final List<String> a;
    private final List<Locale> b;

    /* loaded from: classes.dex */
    public static class Builder {
        private final List<String> a;
        private final List<Locale> b;

        private Builder() {
            this.a = new ArrayList();
            this.b = new ArrayList();
        }

        /* synthetic */ Builder(byte b) {
            this();
        }

        public Builder addLanguage(Locale locale) {
            this.b.add(locale);
            return this;
        }

        public Builder addModule(String str) {
            this.a.add(str);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest(this, (byte) 0);
        }
    }

    private SplitInstallRequest(Builder builder) {
        this.a = new ArrayList(builder.a);
        this.b = new ArrayList(builder.b);
    }

    /* synthetic */ SplitInstallRequest(Builder builder, byte b) {
        this(builder);
    }

    public static Builder newBuilder() {
        return new Builder((byte) 0);
    }

    public List<Locale> getLanguages() {
        return this.b;
    }

    public List<String> getModuleNames() {
        return this.a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.a, this.b);
    }
}
