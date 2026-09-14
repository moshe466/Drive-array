package io.flutter.embedding.engine.systemchannels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class PlatformViewCreationRequest {
    public final int direction;
    public final RequestedDisplayMode displayMode;
    public final double logicalHeight;
    public final double logicalLeft;
    public final double logicalTop;
    public final double logicalWidth;
    public final ByteBuffer params;
    public final int viewId;
    public final String viewType;

    /* loaded from: classes.dex */
    public enum RequestedDisplayMode {
        TEXTURE_WITH_VIRTUAL_FALLBACK,
        TEXTURE_WITH_HYBRID_FALLBACK,
        HYBRID_ONLY
    }

    public PlatformViewCreationRequest(int i, String str, double d2, double d4, double d5, double d6, int i3, ByteBuffer byteBuffer) {
        this(i, str, d2, d4, d5, d6, i3, RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBuffer);
    }

    public static PlatformViewCreationRequest createHCPPRequest(int i, String str, int i3, ByteBuffer byteBuffer) {
        return new PlatformViewCreationRequest(i, str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, i3, null, byteBuffer);
    }

    public static PlatformViewCreationRequest createHybridCompositionRequest(int i, String str, int i3, ByteBuffer byteBuffer) {
        return new PlatformViewCreationRequest(i, str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, i3, RequestedDisplayMode.HYBRID_ONLY, byteBuffer);
    }

    public static PlatformViewCreationRequest createTLHCWithFallbackRequest(int i, String str, double d2, double d4, double d5, double d6, int i3, boolean z3, ByteBuffer byteBuffer) {
        RequestedDisplayMode requestedDisplayMode;
        if (z3) {
            requestedDisplayMode = RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK;
        } else {
            requestedDisplayMode = RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK;
        }
        return new PlatformViewCreationRequest(i, str, d2, d4, d5, d6, i3, requestedDisplayMode, byteBuffer);
    }

    public PlatformViewCreationRequest(int i, String str, double d2, double d4, double d5, double d6, int i3, RequestedDisplayMode requestedDisplayMode, ByteBuffer byteBuffer) {
        this.viewId = i;
        this.viewType = str;
        this.logicalTop = d2;
        this.logicalLeft = d4;
        this.logicalWidth = d5;
        this.logicalHeight = d6;
        this.direction = i3;
        this.displayMode = requestedDisplayMode;
        this.params = byteBuffer;
    }
}
