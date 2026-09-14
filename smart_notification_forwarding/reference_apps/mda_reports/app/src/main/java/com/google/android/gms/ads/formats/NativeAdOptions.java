package com.google.android.gms.ads.formats;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;

/* loaded from: classes.dex */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;

    @Deprecated
    public static final int ORIENTATION_ANY = 0;

    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;

    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzbjv;
    private final int zzbjw;
    private final int zzbjx;
    private final boolean zzbjy;
    private final int zzbjz;
    private final VideoOptions zzbka;
    private final boolean zzbkb;

    /* loaded from: classes.dex */
    public @interface AdChoicesPlacement {
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private VideoOptions zzbka;
        private boolean zzbjv = false;
        private int zzbjw = -1;
        private int zzbjx = 0;
        private boolean zzbjy = false;
        private int zzbjz = 1;
        private boolean zzbkb = false;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzbjz = i;
            return this;
        }

        @Deprecated
        public final Builder setImageOrientation(int i) {
            this.zzbjw = i;
            return this;
        }

        public final Builder setMediaAspectRatio(@NativeMediaAspectRatio int i) {
            this.zzbjx = i;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzbkb = z;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzbjy = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzbjv = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzbka = videoOptions;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.zzbjv = builder.zzbjv;
        this.zzbjw = builder.zzbjw;
        this.zzbjx = builder.zzbjx;
        this.zzbjy = builder.zzbjy;
        this.zzbjz = builder.zzbjz;
        this.zzbka = builder.zzbka;
        this.zzbkb = builder.zzbkb;
    }

    public final int getAdChoicesPlacement() {
        return this.zzbjz;
    }

    @Deprecated
    public final int getImageOrientation() {
        return this.zzbjw;
    }

    public final int getMediaAspectRatio() {
        return this.zzbjx;
    }

    @Nullable
    public final VideoOptions getVideoOptions() {
        return this.zzbka;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzbjy;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzbjv;
    }

    public final boolean zzjk() {
        return this.zzbkb;
    }
}
