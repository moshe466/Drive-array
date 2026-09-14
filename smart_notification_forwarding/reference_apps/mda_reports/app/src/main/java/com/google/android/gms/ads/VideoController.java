package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzxb;
import com.google.android.gms.internal.ads.zzyt;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class VideoController {

    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;

    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;

    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();

    @Nullable
    @GuardedBy("lock")
    private zzxb zzabt;

    @Nullable
    @GuardedBy("lock")
    private VideoLifecycleCallbacks zzabu;

    /* loaded from: classes.dex */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final float getAspectRatio() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return 0.0f;
            }
            try {
                return this.zzabt.getAspectRatio();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return 0;
            }
            try {
                return this.zzabt.getPlaybackState();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return 0.0f;
            }
            try {
                return this.zzabt.zzpl();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call getCurrentTime on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return 0.0f;
            }
            try {
                return this.zzabt.zzpk();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call getDuration on video controller.", e);
                return 0.0f;
            }
        }
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzabu;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzabt != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return false;
            }
            try {
                return this.zzabt.isClickToExpandEnabled();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return false;
            }
            try {
                return this.zzabt.isCustomControlsEnabled();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return true;
            }
            try {
                return this.zzabt.isMuted();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return;
            }
            try {
                this.zzabt.mute(z);
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call mute on video controller.", e);
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return;
            }
            try {
                this.zzabt.pause();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call pause on video controller.", e);
            }
        }
    }

    public final void play() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return;
            }
            try {
                this.zzabt.play();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call play on video controller.", e);
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzabu = videoLifecycleCallbacks;
            if (this.zzabt == null) {
                return;
            }
            try {
                this.zzabt.zza(new zzyt(videoLifecycleCallbacks));
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            if (this.zzabt == null) {
                return;
            }
            try {
                this.zzabt.stop();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call stop on video controller.", e);
            }
        }
    }

    public final void zza(zzxb zzxbVar) {
        synchronized (this.lock) {
            this.zzabt = zzxbVar;
            if (this.zzabu != null) {
                setVideoLifecycleCallbacks(this.zzabu);
            }
        }
    }

    public final zzxb zzdl() {
        zzxb zzxbVar;
        synchronized (this.lock) {
            zzxbVar = this.zzabt;
        }
        return zzxbVar;
    }
}
