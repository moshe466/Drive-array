package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class OkHttpFrameLogger {
    private static final int BUFFER_LENGTH_THRESHOLD = 64;
    private final Level level;
    private final Logger logger;

    /* loaded from: classes2.dex */
    enum Direction {
        INBOUND,
        OUTBOUND
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum SettingParams {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);

        private final int bit;

        SettingParams(int i) {
            this.bit = i;
        }

        public int getBit() {
            return this.bit;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpFrameLogger(Level level, Class<?> cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    @VisibleForTesting
    OkHttpFrameLogger(Level level, Logger logger) {
        this.level = (Level) Preconditions.checkNotNull(level, FirebaseAnalytics.Param.LEVEL);
        this.logger = (Logger) Preconditions.checkNotNull(logger, "logger");
    }

    private boolean isEnabled() {
        return this.logger.isLoggable(this.level);
    }

    private static String toString(Settings settings) {
        EnumMap enumMap = new EnumMap(SettingParams.class);
        for (SettingParams settingParams : SettingParams.values()) {
            if (settings.isSet(settingParams.getBit())) {
                enumMap.put((EnumMap) settingParams, (SettingParams) Integer.valueOf(settings.get(settingParams.getBit())));
            }
        }
        return enumMap.toString();
    }

    private static String toString(Buffer buffer) {
        if (buffer.size() <= 64) {
            return buffer.snapshot().hex();
        }
        return buffer.snapshot((int) Math.min(buffer.size(), 64L)).hex() + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " SETTINGS: ack=true");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction, int i, int i2, List<Header> list) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " PUSH_PROMISE: streamId=" + i + " promisedStreamId=" + i2 + " headers=" + list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction, int i, long j) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " WINDOW_UPDATE: streamId=" + i + " windowSizeIncrement=" + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction, int i, ErrorCode errorCode) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " RST_STREAM: streamId=" + i + " errorCode=" + errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction, int i, ErrorCode errorCode, ByteString byteString) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " GO_AWAY: lastStreamId=" + i + " errorCode=" + errorCode + " length=" + byteString.size() + " bytes=" + toString(new Buffer().write(byteString)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction, int i, List<Header> list, boolean z) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " HEADERS: streamId=" + i + " headers=" + list + " endStream=" + z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction, int i, Buffer buffer, int i2, boolean z) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " DATA: streamId=" + i + " endStream=" + z + " length=" + i2 + " bytes=" + toString(buffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction, long j) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " PING: ack=false bytes=" + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Direction direction, Settings settings) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " SETTINGS: ack=false settings=" + toString(settings));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Direction direction, long j) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " PING: ack=true bytes=" + j);
        }
    }

    public void logPriority(Direction direction, int i, int i2, int i3, boolean z) {
        if (isEnabled()) {
            this.logger.log(this.level, direction + " PRIORITY: streamId=" + i + " streamDependency=" + i2 + " weight=" + i3 + " exclusive=" + z);
        }
    }
}
