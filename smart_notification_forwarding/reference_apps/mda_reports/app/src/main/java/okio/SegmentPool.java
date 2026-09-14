package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SegmentPool {

    @Nullable
    static Segment a;
    static long b;

    private SegmentPool() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Segment a() {
        synchronized (SegmentPool.class) {
            if (a == null) {
                return new Segment();
            }
            Segment segment = a;
            a = segment.f;
            segment.f = null;
            b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return segment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Segment segment) {
        if (segment.f != null || segment.g != null) {
            throw new IllegalArgumentException();
        }
        if (segment.d) {
            return;
        }
        synchronized (SegmentPool.class) {
            if (b + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            segment.f = a;
            segment.c = 0;
            segment.b = 0;
            a = segment;
        }
    }
}
