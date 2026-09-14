package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;
import io.flutter.BuildConfig;

/* loaded from: classes.dex */
public interface TextureRegistry {

    /* loaded from: classes.dex */
    public interface GLTextureConsumer {
        SurfaceTexture getSurfaceTexture();
    }

    /* loaded from: classes.dex */
    public interface ImageConsumer {
        Image acquireLatestImage();
    }

    /* loaded from: classes.dex */
    public interface ImageTextureEntry extends TextureEntry {
        void pushImage(Image image);
    }

    /* loaded from: classes.dex */
    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    /* loaded from: classes.dex */
    public interface OnTrimMemoryListener {
        void onTrimMemory(int i);
    }

    /* loaded from: classes.dex */
    public enum SurfaceLifecycle {
        manual,
        resetInBackground
    }

    /* loaded from: classes.dex */
    public interface SurfaceProducer extends TextureEntry {

        /* loaded from: classes.dex */
        public interface Callback {
            default void onSurfaceAvailable() {
                onSurfaceCreated();
            }

            default void onSurfaceCleanup() {
                onSurfaceDestroyed();
            }

            @Deprecated(forRemoval = BuildConfig.RELEASE, since = "Flutter 3.27")
            default void onSurfaceCreated() {
            }

            @Deprecated(forRemoval = BuildConfig.RELEASE, since = "Flutter 3.28")
            default void onSurfaceDestroyed() {
            }
        }

        Surface getForcedNewSurface();

        int getHeight();

        Surface getSurface();

        int getWidth();

        boolean handlesCropAndRotation();

        void scheduleFrame();

        void setCallback(Callback callback);

        void setSize(int i, int i3);
    }

    /* loaded from: classes.dex */
    public interface SurfaceTextureEntry extends TextureEntry {
        default void setOnFrameConsumedListener(OnFrameConsumedListener onFrameConsumedListener) {
        }

        default void setOnTrimMemoryListener(OnTrimMemoryListener onTrimMemoryListener) {
        }

        SurfaceTexture surfaceTexture();
    }

    /* loaded from: classes.dex */
    public interface TextureEntry {
        long id();

        void release();
    }

    ImageTextureEntry createImageTexture();

    default SurfaceProducer createSurfaceProducer() {
        return createSurfaceProducer(SurfaceLifecycle.manual);
    }

    SurfaceProducer createSurfaceProducer(SurfaceLifecycle surfaceLifecycle);

    SurfaceTextureEntry createSurfaceTexture();

    default void onTrimMemory(int i) {
    }

    SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture);
}
