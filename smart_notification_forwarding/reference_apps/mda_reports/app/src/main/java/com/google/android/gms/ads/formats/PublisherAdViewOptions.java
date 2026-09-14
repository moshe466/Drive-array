package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzadz;
import com.google.android.gms.internal.ads.zzaea;
import com.google.android.gms.internal.ads.zzul;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzyu;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
/* loaded from: classes.dex */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();

    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)
    private final boolean zzbkh;

    @Nullable
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", id = 2, type = "android.os.IBinder")
    private final zzwc zzbki;

    @Nullable
    private AppEventListener zzbkj;

    @Nullable
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 3)
    private final IBinder zzbkk;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzbkh = false;

        @Nullable
        private AppEventListener zzbkj;

        @Nullable
        private ShouldDelayBannerRenderingListener zzbkl;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzbkj = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbkh = z;
            return this;
        }

        @KeepForSdk
        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzbkl = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzbkh = builder.zzbkh;
        this.zzbkj = builder.zzbkj;
        AppEventListener appEventListener = this.zzbkj;
        this.zzbki = appEventListener != null ? new zzul(appEventListener) : null;
        this.zzbkk = builder.zzbkl != null ? new zzyu(builder.zzbkl) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PublisherAdViewOptions(@SafeParcelable.Param(id = 1) boolean z, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder2) {
        this.zzbkh = z;
        this.zzbki = iBinder != null ? zzwb.zze(iBinder) : null;
        this.zzbkk = iBinder2;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzbkj;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbkh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzwc zzwcVar = this.zzbki;
        SafeParcelWriter.writeIBinder(parcel, 2, zzwcVar == null ? null : zzwcVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzbkk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzwc zzjm() {
        return this.zzbki;
    }

    @Nullable
    public final zzaea zzjn() {
        return zzadz.zzw(this.zzbkk);
    }
}
