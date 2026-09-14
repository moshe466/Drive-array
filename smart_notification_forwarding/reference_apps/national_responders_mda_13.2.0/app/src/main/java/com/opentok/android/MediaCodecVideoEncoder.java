package com.opentok.android;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Surface;
import androidx.annotation.Keep;
import com.opentok.android.j;
import gc.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

@Keep
@TargetApi(19)
/* loaded from: classes.dex */
class MediaCodecVideoEncoder {
    private static final int BITRATE_ADJUSTMENT_FPS = 30;
    private static final double BITRATE_CORRECTION_MAX_SCALE = 4.0d;
    private static final double BITRATE_CORRECTION_SEC = 3.0d;
    private static final int BITRATE_CORRECTION_STEPS = 20;
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final String[] H264_BLACKLIST;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final l[] H264_SUPPORT;
    private static final SparseIntArray KeyFrameIntervalSecTbl;
    private static final int MAXIMUM_INITIAL_FPS = 30;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final SparseArray<Pair<String, l[]>> SupportedEncoderTbl;
    private static final int VIDEO_AVCLevel3 = 256;
    private static final int VIDEO_AVCProfileHigh = 8;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static final l[] VP9_SUPPORT;
    private static final int[] supportedColorList;
    private static final int[] supportedSurfaceColorList;
    private double bitrateAccumulator;
    private double bitrateAccumulatorMax;
    private int bitrateAdjustmentScaleExp;
    private double bitrateObservationTimeMs;
    private int colorFormat;
    private gc.c drawer;
    private gc.a eglBase;
    private long forcedKeyFrameMs;
    private int height;
    private Surface inputSurface;
    private long lastKeyFrameMs;
    private MediaCodec mediaCodec;
    private Thread mediaCodecThread;
    private ByteBuffer[] outputBuffers;
    private int profile;
    private int targetBitrateBps;
    private int targetFps;
    private m type;
    private int width;
    private static final j.a log = com.opentok.android.j.a("[MediaCodecEncoder]");
    private static MediaCodecVideoEncoder runningInstance = null;
    private static j errorCallback = null;
    private static int codecErrors = 0;
    private static Set<String> hwEncoderDisabledTypes = new HashSet();
    private static final l[] VP8_SUPPORT = new l[0];
    private g bitrateAdjustmentType = g.NO_ADJUSTMENT;
    private ByteBuffer configData = null;

    /* loaded from: classes.dex */
    static class a extends HashMap<String, Integer> {
        a() {
            put("HighProfile", 23);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        Exception f8500a;

        b(MediaCodecVideoEncoder mediaCodecVideoEncoder) {
        }
    }

    /* loaded from: classes.dex */
    static class c extends SparseArray<Pair<String, l[]>> {
        c() {
            append(m.VIDEO_CODEC_VP8.ordinal(), new Pair(MediaCodecVideoEncoder.VP8_MIME_TYPE, MediaCodecVideoEncoder.VP8_SUPPORT));
            append(m.VIDEO_CODEC_VP9.ordinal(), new Pair(MediaCodecVideoEncoder.VP9_MIME_TYPE, MediaCodecVideoEncoder.VP9_SUPPORT));
            append(m.VIDEO_CODEC_H264.ordinal(), new Pair(MediaCodecVideoEncoder.H264_MIME_TYPE, MediaCodecVideoEncoder.H264_SUPPORT));
        }
    }

    /* loaded from: classes.dex */
    static class d extends SparseIntArray {
        d() {
            append(m.VIDEO_CODEC_VP8.ordinal(), 100);
            append(m.VIDEO_CODEC_VP9.ordinal(), 100);
            append(m.VIDEO_CODEC_H264.ordinal(), 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e implements Comparator<Pair<h, l.a>> {
        e() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<h, l.a> pair, Pair<h, l.a> pair2) {
            return ((l.a) pair.second).ordinal() - ((l.a) pair2.second).ordinal();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f8501f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f8502g;

        f(b bVar, CountDownLatch countDownLatch) {
            this.f8501f = bVar;
            this.f8502g = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaCodecVideoEncoder.log.b("Java releaseEncoder on release thread", new Object[0]);
            try {
                MediaCodecVideoEncoder.this.mediaCodec.stop();
            } catch (Exception e10) {
                MediaCodecVideoEncoder.log.c("Media encoder stop failed", e10);
            }
            try {
                MediaCodecVideoEncoder.this.mediaCodec.release();
            } catch (Exception e11) {
                MediaCodecVideoEncoder.log.c("Media encoder release failed", e11);
                this.f8501f.f8500a = e11;
            }
            MediaCodecVideoEncoder.log.b("Java releaseEncoder on release thread done", new Object[0]);
            this.f8502g.countDown();
        }
    }

    /* loaded from: classes.dex */
    public enum g {
        NO_ADJUSTMENT,
        FRAMERATE_ADJUSTMENT,
        DYNAMIC_ADJUSTMENT
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public final String f8504a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8505b;

        /* renamed from: c, reason: collision with root package name */
        public final g f8506c;

        /* renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f8507d;

        public h(String str, int i10, g gVar, Map<String, Integer> map) {
            this.f8504a = str;
            this.f8505b = i10;
            this.f8506c = gVar;
            this.f8507d = map;
        }
    }

    /* loaded from: classes.dex */
    public enum i {
        CONSTRAINED_BASELINE(0),
        BASELINE(1),
        MAIN(2),
        CONSTRAINED_HIGH(3),
        HIGH(4);

        private final int value;

        i(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(int i10);
    }

    /* loaded from: classes.dex */
    static class k {
        public k(int i10, ByteBuffer byteBuffer, boolean z10, long j10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public final String f8508a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8509b;

        /* renamed from: c, reason: collision with root package name */
        public final a f8510c;

        /* renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f8511d;

        /* renamed from: e, reason: collision with root package name */
        public final g f8512e;

        /* loaded from: classes.dex */
        public enum a {
            HARDWARE(100),
            SOFTWARE(10);

            private final int priority;

            a(int i10) {
                this.priority = i10;
            }
        }

        public l(String str, int i10, a aVar, g gVar, Map<String, Integer> map) {
            this.f8508a = str;
            this.f8509b = i10;
            this.f8510c = aVar;
            this.f8512e = gVar;
            this.f8511d = map == null ? new HashMap<>() : map;
        }
    }

    /* loaded from: classes.dex */
    public enum m {
        VIDEO_CODEC_GENERIC,
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264
    }

    static {
        l.a aVar = l.a.HARDWARE;
        g gVar = g.NO_ADJUSTMENT;
        g gVar2 = g.FRAMERATE_ADJUSTMENT;
        VP9_SUPPORT = new l[]{new l("OMX.qcom.", 24, aVar, gVar, null), new l("OMX.Exynos.", 24, aVar, gVar2, null)};
        H264_SUPPORT = new l[]{new l("OMX.qcom.", 19, aVar, gVar, null), new l("OMX.Exynos.", 21, aVar, gVar2, new a()), new l("OMX.IMG.", 19, aVar, gVar, null), new l("OMX.MTK.", 19, aVar, gVar, null), new l("OMX.google.h264.", 23, l.a.SOFTWARE, gVar, null)};
        SupportedEncoderTbl = new c();
        KeyFrameIntervalSecTbl = new d();
        H264_BLACKLIST = new String[]{"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4"};
        supportedColorList = new int[]{19, 21, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m};
        supportedSurfaceColorList = new int[]{2130708361};
    }

    MediaCodecVideoEncoder() {
    }

    private void checkOnMediaCodecThread() {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new RuntimeException("MediaCodecVideoEncoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MediaCodec createByCodecName(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static List<Integer> createIntList(int[] iArr) {
        Vector vector = new Vector(iArr.length);
        for (int i10 : iArr) {
            vector.add(Integer.valueOf(i10));
        }
        return vector;
    }

    public static void disableH264HwCodec() {
        log.f("H.264 encoding is disabled by application.", new Object[0]);
        hwEncoderDisabledTypes.add(H264_MIME_TYPE);
    }

    public static void disableVp8HwCodec() {
        log.f("VP8 encoding is disabled by application.", new Object[0]);
        hwEncoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        log.f("VP9 encoding is disabled by application.", new Object[0]);
        hwEncoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    private static h[] findHwEncoder(String str, l[] lVarArr, int[] iArr) {
        MediaCodecInfo mediaCodecInfo;
        String str2 = str;
        int i10 = 0;
        log.b("Trying to find HW encoder for mime " + str2, new Object[0]);
        Vector vector = new Vector();
        MediaCodecInfo[] codecList = getCodecList();
        int length = codecList.length;
        int i11 = 0;
        while (i11 < length) {
            MediaCodecInfo mediaCodecInfo2 = codecList[i11];
            if (Arrays.asList(mediaCodecInfo2.getSupportedTypes()).contains(str2)) {
                if (str2.equals(H264_MIME_TYPE)) {
                    List asList = Arrays.asList(H264_BLACKLIST);
                    String str3 = Build.MODEL;
                    if (asList.contains(str3)) {
                        log.f("Model: " + str3 + " is blacklisted for H264.", new Object[i10]);
                    }
                }
                try {
                    List<Integer> createIntList = createIntList(mediaCodecInfo2.getCapabilitiesForType(str2).colorFormats);
                    int length2 = lVarArr.length;
                    int i12 = 0;
                    while (i12 < length2) {
                        l lVar = lVarArr[i12];
                        if (Build.VERSION.SDK_INT >= lVar.f8509b && mediaCodecInfo2.getName().startsWith(lVar.f8508a)) {
                            for (int i13 : iArr) {
                                if (createIntList.contains(Integer.valueOf(i13))) {
                                    log.b("Found target encoder " + mediaCodecInfo2.getName() + ". Color: 0x" + Integer.toHexString(i13) + ". Bitrate adjustment: " + lVar.f8512e, new Object[0]);
                                    mediaCodecInfo = mediaCodecInfo2;
                                    vector.add(new Pair(new h(mediaCodecInfo2.getName(), i13, lVar.f8512e, lVar.f8511d), lVar.f8510c));
                                    break;
                                }
                            }
                        }
                        mediaCodecInfo = mediaCodecInfo2;
                        i12++;
                        mediaCodecInfo2 = mediaCodecInfo;
                    }
                } catch (IllegalArgumentException e10) {
                    log.c("Cannot retreive decoder capabilities", e10);
                } catch (Exception e11) {
                    log.c("general error", e11);
                    e11.printStackTrace();
                }
            }
            i11++;
            str2 = str;
            i10 = 0;
        }
        Collections.sort(vector, new e());
        h[] hVarArr = new h[vector.size()];
        Iterator it = vector.iterator();
        int i14 = 0;
        while (it.hasNext()) {
            hVarArr[i14] = (h) ((Pair) it.next()).first;
            i14++;
        }
        return hVarArr;
    }

    private double getBitrateScale(int i10) {
        return Math.pow(BITRATE_CORRECTION_MAX_SCALE, i10 / 20.0d);
    }

    private static MediaCodecInfo[] getCodecList() {
        if (Build.VERSION.SDK_INT < 19) {
            return new MediaCodecInfo[0];
        }
        Vector vector = new Vector();
        for (int i10 = 0; i10 < MediaCodecList.getCodecCount(); i10++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
            if (codecInfoAt != null && codecInfoAt.isEncoder()) {
                vector.add(codecInfoAt);
            }
        }
        return (MediaCodecInfo[]) vector.toArray(new MediaCodecInfo[vector.size()]);
    }

    private boolean initEncoder(m mVar, h hVar, a.C0185a c0185a, String str) {
        int i10 = KeyFrameIntervalSecTbl.get(mVar.ordinal());
        boolean z10 = this.profile == i.CONSTRAINED_HIGH.getValue() && isH264HighProfileHwSupported();
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, this.width, this.height);
            createVideoFormat.setInteger("bitrate", this.targetBitrateBps);
            createVideoFormat.setInteger("bitrate-mode", 2);
            createVideoFormat.setInteger("color-format", hVar.f8505b);
            createVideoFormat.setInteger("frame-rate", this.targetFps);
            createVideoFormat.setInteger("i-frame-interval", i10);
            if (z10) {
                createVideoFormat.setInteger("profile", 8);
                createVideoFormat.setInteger("level", VIDEO_AVCLevel3);
            }
            j.a aVar = log;
            aVar.b("  Format: " + createVideoFormat, new Object[0]);
            MediaCodec createByCodecName = createByCodecName(hVar.f8504a);
            this.mediaCodec = createByCodecName;
            this.type = mVar;
            if (createByCodecName == null) {
                aVar.c("Can not create media encoder", new Object[0]);
                release();
                return false;
            }
            createByCodecName.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mediaCodec.start();
            this.outputBuffers = this.mediaCodec.getOutputBuffers();
            aVar.b("Output buffers: " + this.outputBuffers.length, new Object[0]);
            return true;
        } catch (Exception e10) {
            log.c("initEncode failed", e10);
            release();
            return false;
        }
    }

    public static boolean isH264HighProfileHwSupported() {
        h[] findHwEncoder = findHwEncoder(H264_MIME_TYPE, H264_SUPPORT, supportedColorList);
        return findHwEncoder.length > 0 && findHwEncoder[0].f8507d.containsKey("HighProfile") && Build.VERSION.SDK_INT >= findHwEncoder[0].f8507d.get("HighProfile").intValue();
    }

    public static boolean isH264HwSupported() {
        return !hwEncoderDisabledTypes.contains(H264_MIME_TYPE) && findHwEncoder(H264_MIME_TYPE, H264_SUPPORT, supportedColorList).length > 0;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        return !hwEncoderDisabledTypes.contains(H264_MIME_TYPE) && findHwEncoder(H264_MIME_TYPE, H264_SUPPORT, supportedSurfaceColorList).length > 0;
    }

    public static boolean isVp8HwSupported() {
        return !hwEncoderDisabledTypes.contains(VP8_MIME_TYPE) && findHwEncoder(VP8_MIME_TYPE, VP8_SUPPORT, supportedColorList).length > 0;
    }

    public static boolean isVp8HwSupportedUsingTextures() {
        return !hwEncoderDisabledTypes.contains(VP8_MIME_TYPE) && findHwEncoder(VP8_MIME_TYPE, VP8_SUPPORT, supportedSurfaceColorList).length > 0;
    }

    public static boolean isVp9HwSupported() {
        return !hwEncoderDisabledTypes.contains(VP9_MIME_TYPE) && findHwEncoder(VP9_MIME_TYPE, VP9_SUPPORT, supportedColorList).length > 0;
    }

    public static boolean isVp9HwSupportedUsingTextures() {
        return !hwEncoderDisabledTypes.contains(VP9_MIME_TYPE) && findHwEncoder(VP9_MIME_TYPE, VP9_SUPPORT, supportedSurfaceColorList).length > 0;
    }

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoEncoder mediaCodecVideoEncoder = runningInstance;
        if (mediaCodecVideoEncoder == null || (thread = mediaCodecVideoEncoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            log.b("MediaCodecVideoEncoder stacks trace:", new Object[0]);
            for (StackTraceElement stackTraceElement : stackTrace) {
                log.b(stackTraceElement.toString(), new Object[0]);
            }
        }
    }

    private void reportEncodedFrame(int i10) {
        int i11 = this.targetFps;
        if (i11 == 0 || this.bitrateAdjustmentType != g.DYNAMIC_ADJUSTMENT) {
            return;
        }
        double d10 = i11;
        double d11 = this.bitrateAccumulator + (i10 - (this.targetBitrateBps / (8.0d * d10)));
        this.bitrateAccumulator = d11;
        this.bitrateObservationTimeMs += 1000.0d / d10;
        double d12 = this.bitrateAccumulatorMax * BITRATE_CORRECTION_SEC;
        double min = Math.min(d11, d12);
        this.bitrateAccumulator = min;
        this.bitrateAccumulator = Math.max(min, -d12);
        if (this.bitrateObservationTimeMs > 3000.0d) {
            j.a aVar = log;
            aVar.b("Acc: " + ((int) this.bitrateAccumulator) + ". Max: " + ((int) this.bitrateAccumulatorMax) + ". ExpScale: " + this.bitrateAdjustmentScaleExp, new Object[0]);
            double d13 = this.bitrateAccumulator;
            double d14 = this.bitrateAccumulatorMax;
            boolean z10 = true;
            if (d13 > d14) {
                this.bitrateAdjustmentScaleExp -= (int) ((d13 / d14) + 0.5d);
                this.bitrateAccumulator = d14;
            } else {
                double d15 = -d14;
                if (d13 < d15) {
                    this.bitrateAdjustmentScaleExp += (int) (((-d13) / d14) + 0.5d);
                    this.bitrateAccumulator = d15;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                int min2 = Math.min(this.bitrateAdjustmentScaleExp, 20);
                this.bitrateAdjustmentScaleExp = min2;
                this.bitrateAdjustmentScaleExp = Math.max(min2, -20);
                aVar.b("Adjusting bitrate scale to " + this.bitrateAdjustmentScaleExp + ". Value: " + getBitrateScale(this.bitrateAdjustmentScaleExp), new Object[0]);
                setRates(this.targetBitrateBps / 1000, this.targetFps);
            }
            this.bitrateObservationTimeMs = 0.0d;
        }
    }

    public static void setErrorCallback(j jVar) {
        log.b("Set error callback", new Object[0]);
        errorCallback = jVar;
    }

    private boolean setRates(int i10, int i11) {
        checkOnMediaCodecThread();
        int i12 = i10 * 1000;
        g gVar = this.bitrateAdjustmentType;
        g gVar2 = g.DYNAMIC_ADJUSTMENT;
        if (gVar == gVar2) {
            double d10 = i12;
            this.bitrateAccumulatorMax = d10 / 8.0d;
            int i13 = this.targetBitrateBps;
            if (i13 > 0 && i12 < i13) {
                this.bitrateAccumulator = (this.bitrateAccumulator * d10) / i13;
            }
        }
        this.targetBitrateBps = i12;
        this.targetFps = i11;
        if (gVar != g.FRAMERATE_ADJUSTMENT || i11 <= 0) {
            j.a aVar = log;
            if (gVar == gVar2) {
                aVar.e("setRates: " + i10 + " kbps. Fps: " + this.targetFps + ". ExpScale: " + this.bitrateAdjustmentScaleExp, new Object[0]);
                int i14 = this.bitrateAdjustmentScaleExp;
                if (i14 != 0) {
                    i12 = (int) (i12 * getBitrateScale(i14));
                }
            } else {
                aVar.e("setRates: " + i10 + " kbps. Fps: " + this.targetFps, new Object[0]);
            }
        } else {
            i12 = (i12 * 30) / i11;
            log.e("setRates: " + i10 + " -> " + (i12 / 1000) + " kbps. Fps: " + this.targetFps, new Object[0]);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i12);
            this.mediaCodec.setParameters(bundle);
            return true;
        } catch (IllegalStateException e10) {
            log.c("setRates failed", e10);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void checkKeyFrameRequired(boolean r7, long r8) {
        /*
            r6 = this;
            r0 = 500(0x1f4, double:2.47E-321)
            long r8 = r8 + r0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 / r0
            long r0 = r6.lastKeyFrameMs
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L10
            r6.lastKeyFrameMs = r8
        L10:
            r0 = 0
            if (r7 != 0) goto L22
            long r4 = r6.forcedKeyFrameMs
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 <= 0) goto L22
            long r1 = r6.lastKeyFrameMs
            long r1 = r1 + r4
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 <= 0) goto L22
            r1 = 1
            goto L23
        L22:
            r1 = 0
        L23:
            if (r7 != 0) goto L27
            if (r1 == 0) goto L4d
        L27:
            if (r7 == 0) goto L33
            com.opentok.android.j$a r7 = com.opentok.android.MediaCodecVideoEncoder.log
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "Sync frame request"
            r7.b(r2, r1)
            goto L3c
        L33:
            com.opentok.android.j$a r7 = com.opentok.android.MediaCodecVideoEncoder.log
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "Sync frame forced"
            r7.b(r2, r1)
        L3c:
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r1 = "request-sync"
            r7.putInt(r1, r0)
            android.media.MediaCodec r0 = r6.mediaCodec
            r0.setParameters(r7)
            r6.lastKeyFrameMs = r8
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opentok.android.MediaCodecVideoEncoder.checkKeyFrameRequired(boolean, long):void");
    }

    int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(0L);
        } catch (IllegalStateException e10) {
            log.c("dequeueIntputBuffer failed", e10);
            return -2;
        }
    }

    k dequeueOutputBuffer() {
        checkOnMediaCodecThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    log.b("Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size, new Object[0]);
                    this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                    this.outputBuffers[dequeueOutputBuffer].position(bufferInfo.offset);
                    this.outputBuffers[dequeueOutputBuffer].limit(bufferInfo.offset + bufferInfo.size);
                    this.configData.put(this.outputBuffers[dequeueOutputBuffer]);
                    String str = "";
                    int i10 = 0;
                    while (true) {
                        int i11 = bufferInfo.size;
                        if (i11 >= 8) {
                            i11 = 8;
                        }
                        if (i10 >= i11) {
                            break;
                        }
                        str = str + Integer.toHexString(this.configData.get(i10) & 255) + " ";
                        i10++;
                    }
                    log.b(str, new Object[0]);
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                }
            }
            int i12 = dequeueOutputBuffer;
            if (i12 < 0) {
                if (i12 == -3) {
                    this.outputBuffers = this.mediaCodec.getOutputBuffers();
                    return dequeueOutputBuffer();
                }
                if (i12 == -2) {
                    return dequeueOutputBuffer();
                }
                if (i12 == -1) {
                    return null;
                }
                throw new RuntimeException("dequeueOutputBuffer: " + i12);
            }
            ByteBuffer duplicate = this.outputBuffers[i12].duplicate();
            duplicate.position(bufferInfo.offset);
            duplicate.limit(bufferInfo.offset + bufferInfo.size);
            reportEncodedFrame(bufferInfo.size);
            boolean z10 = (bufferInfo.flags & 1) != 0;
            if (z10) {
                log.b("Sync frame generated", new Object[0]);
            }
            if (!z10 || this.type != m.VIDEO_CODEC_H264) {
                return new k(i12, duplicate.slice(), z10, bufferInfo.presentationTimeUs);
            }
            log.b("Appending config frame of size " + this.configData.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size, new Object[0]);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.configData.capacity() + bufferInfo.size);
            this.configData.rewind();
            allocateDirect.put(this.configData);
            allocateDirect.put(duplicate);
            allocateDirect.position(0);
            return new k(i12, allocateDirect, z10, bufferInfo.presentationTimeUs);
        } catch (IllegalStateException e10) {
            log.c("dequeueOutputBuffer failed", e10);
            return new k(-1, null, false, -1L);
        }
    }

    boolean encodeBuffer(boolean z10, int i10, int i11, long j10) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z10, j10);
            this.mediaCodec.queueInputBuffer(i10, 0, i11, j10, 0);
            return true;
        } catch (IllegalStateException e10) {
            log.c("encodeBuffer failed", e10);
            return false;
        }
    }

    boolean encodeTexture(boolean z10, int i10, float[] fArr, long j10) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z10, j10);
            throw null;
        } catch (RuntimeException e10) {
            log.c("encodeTexture failed", e10);
            return false;
        }
    }

    ByteBuffer[] getInputBuffers() {
        ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        log.b("Input buffers: " + inputBuffers.length, new Object[0]);
        return inputBuffers;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00cf, code lost:
    
        if (r11 > 23) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean initEncode(com.opentok.android.MediaCodecVideoEncoder.m r7, int r8, int r9, int r10, int r11, int r12, gc.a.C0185a r13) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opentok.android.MediaCodecVideoEncoder.initEncode(com.opentok.android.MediaCodecVideoEncoder$m, int, int, int, int, int, gc.a$a):boolean");
    }

    void release() {
        boolean z10;
        j.a aVar = log;
        aVar.b("Java releaseEncoder", new Object[0]);
        checkOnMediaCodecThread();
        b bVar = new b(this);
        if (this.mediaCodec != null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new f(bVar, countDownLatch)).start();
            if (gc.e.a(countDownLatch, 5000L)) {
                z10 = false;
            } else {
                aVar.c("Media encoder release timeout", new Object[0]);
                z10 = true;
            }
            this.mediaCodec = null;
        } else {
            z10 = false;
        }
        this.mediaCodecThread = null;
        gc.c cVar = this.drawer;
        if (cVar != null) {
            cVar.a();
            this.drawer = null;
        }
        Surface surface = this.inputSurface;
        if (surface != null) {
            surface.release();
            this.inputSurface = null;
        }
        runningInstance = null;
        if (!z10) {
            if (bVar.f8500a != null) {
                throw new RuntimeException(bVar.f8500a);
            }
            aVar.b("Java releaseEncoder done", new Object[0]);
            return;
        }
        codecErrors++;
        if (errorCallback != null) {
            aVar.c("Invoke codec error callback. Errors: " + codecErrors, new Object[0]);
            errorCallback.a(codecErrors);
        }
        throw new RuntimeException("Media encoder release timeout.");
    }

    boolean releaseOutputBuffer(int i10) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i10, false);
            return true;
        } catch (IllegalStateException e10) {
            log.c("releaseOutputBuffer failed", e10);
            return false;
        }
    }
}
