package io.grpc.okhttp;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.okhttp.internal.framed.FrameWriter;
import java.io.IOException;
import javax.annotation.Nullable;
import okio.Buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class OutboundFlowController {
    private final OutboundFlowState connectionState;
    private final FrameWriter frameWriter;
    private int initialWindowSize;
    private final OkHttpClientTransport transport;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class OutboundFlowState {
        final Buffer a;
        final int b;
        int c;
        int d;
        OkHttpClientStream e;
        boolean f;

        OutboundFlowState(int i, int i2) {
            this.f = false;
            this.b = i;
            this.c = i2;
            this.a = new Buffer();
        }

        OutboundFlowState(OutboundFlowController outboundFlowController, OkHttpClientStream okHttpClientStream, int i) {
            this(okHttpClientStream.id(), i);
            this.e = okHttpClientStream;
        }

        int a() {
            return this.d;
        }

        int a(int i, WriteStatus writeStatus) {
            int min = Math.min(i, g());
            int i2 = 0;
            while (c() && min > 0) {
                if (min >= this.a.size()) {
                    i2 += (int) this.a.size();
                    Buffer buffer = this.a;
                    b(buffer, (int) buffer.size(), this.f);
                } else {
                    i2 += min;
                    b(this.a, min, false);
                }
                writeStatus.b();
                min = Math.min(i - i2, g());
            }
            return i2;
        }

        void a(int i) {
            this.d += i;
        }

        void a(Buffer buffer, int i, boolean z) {
            this.a.write(buffer, i);
            this.f |= z;
        }

        int b(int i) {
            if (i <= 0 || Integer.MAX_VALUE - i >= this.c) {
                this.c += i;
                return this.c;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.b);
        }

        void b() {
            this.d = 0;
        }

        void b(Buffer buffer, int i, boolean z) {
            do {
                int min = Math.min(i, OutboundFlowController.this.frameWriter.maxDataLength());
                int i2 = -min;
                OutboundFlowController.this.connectionState.b(i2);
                b(i2);
                try {
                    OutboundFlowController.this.frameWriter.data(buffer.size() == ((long) min) && z, this.b, buffer, min);
                    this.e.c().onSentBytes(min);
                    i -= min;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } while (i > 0);
        }

        boolean c() {
            return this.a.size() > 0;
        }

        int d() {
            return Math.max(0, Math.min(this.c, (int) this.a.size()));
        }

        int e() {
            return d() - this.d;
        }

        int f() {
            return this.c;
        }

        int g() {
            return Math.min(this.c, OutboundFlowController.this.connectionState.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class WriteStatus {
        int a;

        private WriteStatus() {
        }

        boolean a() {
            return this.a > 0;
        }

        void b() {
            this.a++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutboundFlowController(OkHttpClientTransport okHttpClientTransport, FrameWriter frameWriter, int i) {
        this.transport = (OkHttpClientTransport) Preconditions.checkNotNull(okHttpClientTransport, NotificationCompat.CATEGORY_TRANSPORT);
        this.frameWriter = (FrameWriter) Preconditions.checkNotNull(frameWriter, "frameWriter");
        this.initialWindowSize = i;
        this.connectionState = new OutboundFlowState(0, i);
    }

    private OutboundFlowState state(OkHttpClientStream okHttpClientStream) {
        OutboundFlowState outboundFlowState = (OutboundFlowState) okHttpClientStream.g();
        if (outboundFlowState != null) {
            return outboundFlowState;
        }
        OutboundFlowState outboundFlowState2 = new OutboundFlowState(this, okHttpClientStream, this.initialWindowSize);
        okHttpClientStream.a(outboundFlowState2);
        return outboundFlowState2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(@Nullable OkHttpClientStream okHttpClientStream, int i) {
        if (okHttpClientStream == null) {
            int b = this.connectionState.b(i);
            b();
            return b;
        }
        OutboundFlowState state = state(okHttpClientStream);
        int b2 = state.b(i);
        WriteStatus writeStatus = new WriteStatus();
        state.a(state.g(), writeStatus);
        if (writeStatus.a()) {
            a();
        }
        return b2;
    }

    void a() {
        try {
            this.frameWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, Buffer buffer, boolean z2) {
        Preconditions.checkNotNull(buffer, FirebaseAnalytics.Param.SOURCE);
        OkHttpClientStream a = this.transport.a(i);
        if (a == null) {
            return;
        }
        OutboundFlowState state = state(a);
        int g = state.g();
        boolean c = state.c();
        int size = (int) buffer.size();
        if (c || g < size) {
            if (!c && g > 0) {
                state.b(buffer, g, false);
            }
            state.a(buffer, (int) buffer.size(), z);
        } else {
            state.b(buffer, size, z);
        }
        if (z2) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i);
        }
        int i2 = i - this.initialWindowSize;
        this.initialWindowSize = i;
        for (OkHttpClientStream okHttpClientStream : this.transport.a()) {
            OutboundFlowState outboundFlowState = (OutboundFlowState) okHttpClientStream.g();
            if (outboundFlowState == null) {
                okHttpClientStream.a(new OutboundFlowState(this, okHttpClientStream, this.initialWindowSize));
            } else {
                outboundFlowState.b(i2);
            }
        }
        return i2 > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i;
        OkHttpClientStream[] a = this.transport.a();
        int f = this.connectionState.f();
        int length = a.length;
        while (true) {
            i = 0;
            if (length <= 0 || f <= 0) {
                break;
            }
            int ceil = (int) Math.ceil(f / length);
            int i2 = 0;
            while (i < length && f > 0) {
                OkHttpClientStream okHttpClientStream = a[i];
                OutboundFlowState state = state(okHttpClientStream);
                int min = Math.min(f, Math.min(state.e(), ceil));
                if (min > 0) {
                    state.a(min);
                    f -= min;
                }
                if (state.e() > 0) {
                    a[i2] = okHttpClientStream;
                    i2++;
                }
                i++;
            }
            length = i2;
        }
        WriteStatus writeStatus = new WriteStatus();
        OkHttpClientStream[] a2 = this.transport.a();
        int length2 = a2.length;
        while (i < length2) {
            OutboundFlowState state2 = state(a2[i]);
            state2.a(state2.a(), writeStatus);
            state2.b();
            i++;
        }
        if (writeStatus.a()) {
            a();
        }
    }
}
