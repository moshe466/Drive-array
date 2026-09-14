package com.opentok.android;

import com.opentok.android.i;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class BaseAudioDevice {

    /* renamed from: b, reason: collision with root package name */
    private static WeakHashMap<Integer, Object> f8475b = new WeakHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static WeakHashMap<Integer, PublisherKit> f8476c = new WeakHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private AudioBus f8477a;

    /* loaded from: classes.dex */
    public static class AudioBus {

        /* renamed from: a, reason: collision with root package name */
        private BaseAudioDevice f8478a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AudioBus(BaseAudioDevice baseAudioDevice) {
            this.f8478a = baseAudioDevice;
        }

        private int b(Buffer buffer, int i10) {
            if (!buffer.isDirect()) {
                throw new RuntimeException("ByteBuffer should be allocated using allocateDirect method");
            }
            try {
                return readDataNative(buffer, i10);
            } catch (Exception e10) {
                e10.printStackTrace();
                return 0;
            }
        }

        private void d(Buffer buffer, int i10) {
            try {
                if (!buffer.isDirect()) {
                    throw new RuntimeException("ByteBuffer should be allocated using allocateDirect method");
                }
                writeDataNative(buffer, i10);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        private native int readDataNative(Buffer buffer, int i10);

        private native void writeDataNative(Buffer buffer, int i10);

        public int a(ByteBuffer byteBuffer, int i10) {
            return b(byteBuffer, i10);
        }

        public void c(ByteBuffer byteBuffer, int i10) {
            d(byteBuffer, i10);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public a(int i10, int i11) {
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        Connected,
        Disconnected
    }

    /* loaded from: classes.dex */
    public enum c {
        SpeakerPhone,
        Handset
    }

    public BaseAudioDevice() {
        c cVar = c.SpeakerPhone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Exception exc) {
        for (PublisherKit publisherKit : f8476c.values()) {
            if (publisherKit != null) {
                publisherKit.k(new i(i.a.PublisherErrorDomain, i.b.PublisherInternalError.getErrorCode(), exc.getMessage()));
            }
        }
    }

    public AudioBus a() {
        return this.f8477a;
    }

    public abstract void b();

    public abstract void c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AudioBus audioBus) {
        this.f8477a = audioBus;
    }

    public boolean f(c cVar) {
        return true;
    }

    protected void finalize() {
        f8475b.clear();
        f8476c.clear();
        super.finalize();
    }
}
