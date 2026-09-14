package com.opentok.android;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.Keep;
import com.opentok.android.j;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
@Keep
/* loaded from: classes.dex */
public class MediaCodecVideoDecoder {
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    private static final int DEQUEUE_INPUT_TIMEOUT = 500000;
    private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String FORMAT_KEY_STRIDE = "stride";
    private static final String H264_MIME_TYPE = "video/avc";
    private static final j[] H264_SUPPORT;
    private static final long MAX_DECODE_TIME_MS = 200;
    private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final SparseArray<Pair<String, j[]>> SupportedDecoderTbl;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static final j[] VP9_SUPPORT;
    private static final List<Integer> supportedColorList;
    private int colorFormat;
    private int droppedFrames;
    private boolean hasDecodedFirstFrame;
    private int height;
    private ByteBuffer[] inputBuffers;
    private MediaCodec mediaCodec;
    private Thread mediaCodecThread;
    private ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;
    private k textureListener;
    private boolean useSurface;
    private int width;
    private static final j.a log = com.opentok.android.j.a("[MediaCodecDecoder]");
    private static MediaCodecVideoDecoder runningInstance = null;
    private static i errorCallback = null;
    private static int codecErrors = 0;
    private static Set<String> hwDecoderDisabledTypes = new HashSet();
    private static final j[] VP8_SUPPORT = new j[0];
    private final Queue<l> decodeStartTimeMs = new LinkedList();
    private Surface surface = null;
    private final Queue<f> dequeuedSurfaceOutputBuffers = new LinkedList();

    /* loaded from: classes.dex */
    static class a extends HashMap<String, Integer> {
        a() {
            put("HighProfile", 21);
        }
    }

    /* loaded from: classes.dex */
    static class b extends HashMap<String, Integer> {
        b() {
            put("HighProfile", 23);
        }
    }

    /* loaded from: classes.dex */
    static class c extends SparseArray<Pair<String, j[]>> {
        c() {
            append(m.VIDEO_CODEC_VP8.ordinal(), new Pair(MediaCodecVideoDecoder.VP8_MIME_TYPE, MediaCodecVideoDecoder.VP8_SUPPORT));
            append(m.VIDEO_CODEC_VP9.ordinal(), new Pair(MediaCodecVideoDecoder.VP9_MIME_TYPE, MediaCodecVideoDecoder.VP9_SUPPORT));
            append(m.VIDEO_CODEC_H264.ordinal(), new Pair(MediaCodecVideoDecoder.H264_MIME_TYPE, MediaCodecVideoDecoder.H264_SUPPORT));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements Comparator<Pair<h, j.a>> {
        d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<h, j.a> pair, Pair<h, j.a> pair2) {
            return ((j.a) pair.second).ordinal() - ((j.a) pair2.second).ordinal();
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f8479f;

        e(CountDownLatch countDownLatch) {
            this.f8479f = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MediaCodecVideoDecoder.log.b("Java releaseDecoder on release thread", new Object[0]);
                MediaCodecVideoDecoder.this.mediaCodec.stop();
                MediaCodecVideoDecoder.this.mediaCodec.release();
                MediaCodecVideoDecoder.log.b("Java releaseDecoder on release thread done", new Object[0]);
            } catch (Exception e10) {
                MediaCodecVideoDecoder.log.c("Media decoder release failed", e10);
            }
            this.f8479f.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final int f8481a;

        /* renamed from: b, reason: collision with root package name */
        private final long f8482b;

        /* renamed from: c, reason: collision with root package name */
        private final long f8483c;

        /* renamed from: d, reason: collision with root package name */
        private final long f8484d;

        /* renamed from: e, reason: collision with root package name */
        private final long f8485e;

        /* renamed from: f, reason: collision with root package name */
        private final long f8486f;

        public f(int i10, int i11, int i12, long j10, long j11, long j12, long j13, long j14) {
            this.f8481a = i10;
            this.f8482b = j10;
            this.f8483c = j11;
            this.f8484d = j12;
            this.f8485e = j13;
            this.f8486f = j14;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        public g(int i10, float[] fArr, long j10, long j11, long j12, long j13, long j14) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public final String f8487a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8488b;

        /* renamed from: c, reason: collision with root package name */
        public final Map<String, Integer> f8489c;

        public h(String str, int i10, Map<String, Integer> map) {
            this.f8487a = str;
            this.f8488b = i10;
            this.f8489c = map;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public final String f8490a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8491b;

        /* renamed from: c, reason: collision with root package name */
        public final a f8492c;

        /* renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f8493d;

        /* loaded from: classes.dex */
        public enum a {
            HARDWARE(100),
            SOFTWARE(10);

            private final int priority;

            a(int i10) {
                this.priority = i10;
            }
        }

        public j(String str, int i10, a aVar, Map<String, Integer> map) {
            this.f8490a = str;
            this.f8491b = i10;
            this.f8492c = aVar;
            this.f8493d = map == null ? new HashMap<>() : map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private final Object f8494a = new Object();

        /* renamed from: b, reason: collision with root package name */
        private f f8495b;

        /* renamed from: c, reason: collision with root package name */
        private g f8496c;

        public k(gc.d dVar) {
            throw null;
        }

        public void a(f fVar) {
            if (this.f8495b == null) {
                this.f8495b = fVar;
            } else {
                MediaCodecVideoDecoder.log.c("Unexpected addBufferToRender() called while waiting for a texture.", new Object[0]);
                throw new IllegalStateException("Waiting for a texture.");
            }
        }

        public g b(int i10) {
            g gVar;
            synchronized (this.f8494a) {
                if (this.f8496c == null && i10 > 0 && c()) {
                    try {
                        this.f8494a.wait(i10);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                gVar = this.f8496c;
                this.f8496c = null;
            }
            return gVar;
        }

        public boolean c() {
            boolean z10;
            synchronized (this.f8494a) {
                z10 = this.f8495b != null;
            }
            return z10;
        }

        public void d() {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private final long f8497a;

        /* renamed from: b, reason: collision with root package name */
        private final long f8498b;

        /* renamed from: c, reason: collision with root package name */
        private final long f8499c;

        public l(long j10, long j11, long j12) {
            this.f8497a = j10;
            this.f8498b = j11;
            this.f8499c = j12;
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
        j.a aVar = j.a.HARDWARE;
        VP9_SUPPORT = new j[]{new j("OMX.qcom.", 19, aVar, null), new j("OMX.Exynos.", 19, aVar, null)};
        H264_SUPPORT = new j[]{new j("OMX.qcom.", 19, aVar, new a()), new j("OMX.Intel.", 19, aVar, null), new j("OMX.Exynos.", 19, aVar, new b()), new j("OMX.IMG.", 19, aVar, null), new j("OMX.MTK.", 19, aVar, null), new j("OMX.google.h264.", 23, j.a.SOFTWARE, null)};
        SupportedDecoderTbl = new c();
        supportedColorList = Arrays.asList(19, 21, 2141391872, Integer.valueOf(COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka), Integer.valueOf(COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka), Integer.valueOf(COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka), Integer.valueOf(COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m));
    }

    MediaCodecVideoDecoder() {
    }

    private void MaybeRenderDecodedTextureBuffer() {
        if (this.dequeuedSurfaceOutputBuffers.isEmpty() || this.textureListener.c()) {
            return;
        }
        f remove = this.dequeuedSurfaceOutputBuffers.remove();
        this.textureListener.a(remove);
        this.mediaCodec.releaseOutputBuffer(remove.f8481a, true);
    }

    private void checkOnMediaCodecThread() {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new IllegalStateException("MediaCodecVideoDecoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    private static List<Integer> createIntList(int[] iArr) {
        Vector vector = new Vector(iArr.length);
        for (int i10 : iArr) {
            vector.add(Integer.valueOf(i10));
        }
        return vector;
    }

    private int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(500000L);
        } catch (IllegalStateException e10) {
            log.c("dequeueIntputBuffer failed", e10);
            return -2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0137, code lost:
    
        throw new java.lang.RuntimeException("Unexpected size change. Configured " + r22.width + "*" + r22.height + ". New " + r9 + "*" + r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.opentok.android.MediaCodecVideoDecoder.f dequeueOutputBuffer(int r23) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opentok.android.MediaCodecVideoDecoder.dequeueOutputBuffer(int):com.opentok.android.MediaCodecVideoDecoder$f");
    }

    private g dequeueTextureBuffer(int i10) {
        checkOnMediaCodecThread();
        if (!this.useSurface) {
            throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
        }
        f dequeueOutputBuffer = dequeueOutputBuffer(i10);
        if (dequeueOutputBuffer != null) {
            this.dequeuedSurfaceOutputBuffers.add(dequeueOutputBuffer);
        }
        MaybeRenderDecodedTextureBuffer();
        g b10 = this.textureListener.b(i10);
        if (b10 != null) {
            MaybeRenderDecodedTextureBuffer();
            return b10;
        }
        if (this.dequeuedSurfaceOutputBuffers.size() < Math.min(3, this.outputBuffers.length) && (i10 <= 0 || this.dequeuedSurfaceOutputBuffers.isEmpty())) {
            return null;
        }
        this.droppedFrames++;
        f remove = this.dequeuedSurfaceOutputBuffers.remove();
        if (i10 > 0) {
            log.f("Draining decoder. Dropping frame with TS: " + remove.f8482b + ". Total number of dropped frames: " + this.droppedFrames, new Object[0]);
        } else {
            log.f("Too many output buffers " + this.dequeuedSurfaceOutputBuffers.size() + ". Dropping frame with TS: " + remove.f8482b + ". Total number of dropped frames: " + this.droppedFrames, new Object[0]);
        }
        this.mediaCodec.releaseOutputBuffer(remove.f8481a, false);
        return new g(0, null, remove.f8482b, remove.f8483c, remove.f8484d, remove.f8485e, SystemClock.elapsedRealtime() - remove.f8486f);
    }

    public static void disableH264HwCodec() {
        log.f("H.264 decoding is disabled by application.", new Object[0]);
        hwDecoderDisabledTypes.add(H264_MIME_TYPE);
    }

    public static void disableVp8HwCodec() {
        log.f("VP8 decoding is disabled by application.", new Object[0]);
        hwDecoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        log.f("VP9 decoding is disabled by application.", new Object[0]);
        hwDecoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    private static h[] findDecoder(String str, j[] jVarArr) {
        int i10 = 0;
        log.b("Trying to find HW decoder for mime " + str, new Object[0]);
        Vector vector = new Vector();
        MediaCodecInfo[] codecList = getCodecList();
        int length = codecList.length;
        int i11 = 0;
        while (i11 < length) {
            MediaCodecInfo mediaCodecInfo = codecList[i11];
            if (Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                log.b("Found candidate decoder " + mediaCodecInfo.getName(), new Object[i10]);
                try {
                    List<Integer> createIntList = createIntList(mediaCodecInfo.getCapabilitiesForType(str).colorFormats);
                    int length2 = jVarArr.length;
                    int i12 = 0;
                    while (i12 < length2) {
                        j jVar = jVarArr[i12];
                        if (Build.VERSION.SDK_INT >= jVar.f8491b && mediaCodecInfo.getName().startsWith(jVar.f8490a)) {
                            Iterator<Integer> it = supportedColorList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    int intValue = it.next().intValue();
                                    if (createIntList.contains(Integer.valueOf(intValue))) {
                                        log.b("Found target decoder " + mediaCodecInfo.getName() + ". Color: 0x" + Integer.toHexString(intValue), new Object[i10]);
                                        vector.add(new Pair(new h(mediaCodecInfo.getName(), intValue, jVar.f8493d), jVar.f8492c));
                                        break;
                                    }
                                }
                            }
                        }
                        i12++;
                        i10 = 0;
                    }
                } catch (IllegalArgumentException e10) {
                    log.c("Cannot retreive decoder capabilities", e10);
                } catch (Exception e11) {
                    log.c("general error", e11);
                    e11.printStackTrace();
                }
            }
            i11++;
            i10 = 0;
        }
        Collections.sort(vector, new d());
        h[] hVarArr = new h[vector.size()];
        Iterator it2 = vector.iterator();
        int i13 = 0;
        while (it2.hasNext()) {
            hVarArr[i13] = (h) ((Pair) it2.next()).first;
            i13++;
        }
        return hVarArr;
    }

    private static MediaCodecInfo[] getCodecList() {
        if (Build.VERSION.SDK_INT < 19) {
            return new MediaCodecInfo[0];
        }
        Vector vector = new Vector();
        for (int i10 = 0; i10 < MediaCodecList.getCodecCount(); i10++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
            if (codecInfoAt != null && !codecInfoAt.isEncoder()) {
                vector.add(codecInfoAt);
            }
        }
        return (MediaCodecInfo[]) vector.toArray(new MediaCodecInfo[vector.size()]);
    }

    private boolean initDecode(m mVar, int i10, int i11, gc.d dVar) {
        if (this.mediaCodecThread != null) {
            throw new RuntimeException("initDecode: Forgot to release()?");
        }
        this.useSurface = false;
        Pair<String, j[]> pair = SupportedDecoderTbl.get(mVar.ordinal());
        h[] findDecoder = findDecoder((String) pair.first, (j[]) pair.second);
        if (findDecoder == null || findDecoder.length == 0) {
            throw new RuntimeException("Cannot find HW decoder for " + mVar);
        }
        log.b("Java initDecode: " + mVar + " : " + i10 + " x " + i11 + ". Color: 0x" + Integer.toHexString(findDecoder[0].f8488b) + ". Use Surface: " + this.useSurface, new Object[0]);
        runningInstance = this;
        this.mediaCodecThread = Thread.currentThread();
        this.width = i10;
        this.height = i11;
        this.stride = i10;
        this.sliceHeight = i11;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat((String) pair.first, i10, i11);
        int length = findDecoder.length;
        int i12 = 0;
        boolean z10 = false;
        while (true) {
            if (i12 >= length) {
                break;
            }
            h hVar = findDecoder[i12];
            if (this.useSurface) {
                this.textureListener = new k(dVar);
                throw null;
            }
            createVideoFormat.setInteger("color-format", hVar.f8488b);
            j.a aVar = log;
            aVar.b("  Format: " + createVideoFormat, new Object[0]);
            z10 = initDecoder(hVar, createVideoFormat);
            if (true == z10) {
                aVar.b("using decoder: " + hVar.f8487a, new Object[0]);
                break;
            }
            i12++;
        }
        return z10;
    }

    private boolean initDecoder(h hVar, MediaFormat mediaFormat) {
        try {
            MediaCodec createByCodecName = MediaCodecVideoEncoder.createByCodecName(hVar.f8487a);
            this.mediaCodec = createByCodecName;
            if (createByCodecName == null) {
                log.c("Can not create media decoder", new Object[0]);
                return false;
            }
            createByCodecName.configure(mediaFormat, this.surface, (MediaCrypto) null, 0);
            this.mediaCodec.start();
            this.colorFormat = hVar.f8488b;
            this.outputBuffers = this.mediaCodec.getOutputBuffers();
            this.inputBuffers = this.mediaCodec.getInputBuffers();
            this.decodeStartTimeMs.clear();
            this.hasDecodedFirstFrame = false;
            this.dequeuedSurfaceOutputBuffers.clear();
            this.droppedFrames = 0;
            log.b("Input buffers: " + this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length, new Object[0]);
            return true;
        } catch (IllegalStateException e10) {
            log.c("initDecode failed", e10);
            return false;
        }
    }

    public static boolean isH264HighProfileHwSupported() {
        h[] findDecoder = findDecoder(H264_MIME_TYPE, H264_SUPPORT);
        return findDecoder.length > 0 && findDecoder[0].f8489c.containsKey("HighProfile") && Build.VERSION.SDK_INT >= findDecoder[0].f8489c.get("HighProfile").intValue();
    }

    public static boolean isH264HwSupported() {
        return !hwDecoderDisabledTypes.contains(H264_MIME_TYPE) && findDecoder(H264_MIME_TYPE, H264_SUPPORT).length > 0;
    }

    public static boolean isVp8HwSupported() {
        return !hwDecoderDisabledTypes.contains(VP8_MIME_TYPE) && findDecoder(VP8_MIME_TYPE, VP8_SUPPORT).length > 0;
    }

    public static boolean isVp9HwSupported() {
        return !hwDecoderDisabledTypes.contains(VP9_MIME_TYPE) && findDecoder(VP9_MIME_TYPE, VP9_SUPPORT).length > 0;
    }

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoDecoder mediaCodecVideoDecoder = runningInstance;
        if (mediaCodecVideoDecoder == null || (thread = mediaCodecVideoDecoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            log.b("MediaCodecVideoDecoder stacks trace:", new Object[0]);
            for (StackTraceElement stackTraceElement : stackTrace) {
                log.b(stackTraceElement.toString(), new Object[0]);
            }
        }
    }

    private boolean queueInputBuffer(int i10, int i11, long j10, long j11, long j12) {
        checkOnMediaCodecThread();
        try {
            this.inputBuffers[i10].position(0);
            this.inputBuffers[i10].limit(i11);
            this.decodeStartTimeMs.add(new l(SystemClock.elapsedRealtime(), j11, j12));
            this.mediaCodec.queueInputBuffer(i10, 0, i11, j10, 0);
            return true;
        } catch (IllegalStateException e10) {
            log.c("decode failed", e10);
            return false;
        }
    }

    private void release() {
        j.a aVar = log;
        aVar.b("Java releaseDecoder. Total number of dropped frames: " + this.droppedFrames, new Object[0]);
        checkOnMediaCodecThread();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new e(countDownLatch)).start();
        if (!gc.e.a(countDownLatch, 5000L)) {
            aVar.c("Media decoder release timeout", new Object[0]);
            codecErrors++;
            if (errorCallback != null) {
                aVar.c("Invoke codec error callback. Errors: " + codecErrors, new Object[0]);
                errorCallback.a(codecErrors);
            }
        }
        this.mediaCodec = null;
        this.mediaCodecThread = null;
        runningInstance = null;
        if (this.useSurface) {
            this.surface.release();
            this.surface = null;
            this.textureListener.d();
        }
        aVar.b("Java releaseDecoder done", new Object[0]);
    }

    private void reset(int i10, int i11) {
        if (this.mediaCodecThread == null || this.mediaCodec == null) {
            throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
        }
        log.b("Java reset: " + i10 + " x " + i11, new Object[0]);
        this.mediaCodec.flush();
        this.width = i10;
        this.height = i11;
        this.decodeStartTimeMs.clear();
        this.dequeuedSurfaceOutputBuffers.clear();
        this.hasDecodedFirstFrame = false;
        this.droppedFrames = 0;
    }

    private void returnDecodedOutputBuffer(int i10) {
        checkOnMediaCodecThread();
        if (this.useSurface) {
            throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
        }
        this.mediaCodec.releaseOutputBuffer(i10, false);
    }

    public static void setErrorCallback(i iVar) {
        log.b("Set error callback", new Object[0]);
        errorCallback = iVar;
    }
}
