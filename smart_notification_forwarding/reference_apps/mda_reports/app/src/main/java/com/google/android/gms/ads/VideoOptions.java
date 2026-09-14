package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzyw;

/* loaded from: classes.dex */
public final class VideoOptions {
    private final boolean zzabv;
    private final boolean zzabw;
    private final boolean zzabx;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzabv = true;
        private boolean zzabw = false;
        private boolean zzabx = false;

        public final VideoOptions build() {
            return new VideoOptions(this);
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.zzabx = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.zzabw = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.zzabv = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.zzabv = builder.zzabv;
        this.zzabw = builder.zzabw;
        this.zzabx = builder.zzabx;
    }

    public VideoOptions(zzyw zzywVar) {
        this.zzabv = zzywVar.zzabv;
        this.zzabw = zzywVar.zzabw;
        this.zzabx = zzywVar.zzabx;
    }

    public final boolean getClickToExpandRequested() {
        return this.zzabx;
    }

    public final boolean getCustomControlsRequested() {
        return this.zzabw;
    }

    public final boolean getStartMuted() {
        return this.zzabv;
    }
}
