package io.grpc.perfmark;

import com.google.errorprone.annotations.CompileTimeConstant;
import io.grpc.perfmark.PerfTag;

/* loaded from: classes2.dex */
public final class PerfMark {
    private static final PerfTag NULL_PERF_TAG = PerfTag.TagFactory.a();

    /* loaded from: classes2.dex */
    private static final class NoopTask extends PerfMarkTask {
        private static final PerfMarkTask INSTANCE = new NoopTask();

        NoopTask() {
        }

        @Override // io.grpc.perfmark.PerfMarkTask, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    private PerfMark() {
        throw new AssertionError("nope");
    }

    public static PerfTag createTag(long j) {
        return NULL_PERF_TAG;
    }

    public static PerfTag createTag(long j, String str) {
        return NULL_PERF_TAG;
    }

    public static PerfTag createTag(String str) {
        return NULL_PERF_TAG;
    }

    public static void event(PerfTag perfTag, @CompileTimeConstant String str) {
    }

    public static void event(@CompileTimeConstant String str) {
    }

    public static PerfMarkTask task(PerfTag perfTag, @CompileTimeConstant String str) {
        return NoopTask.INSTANCE;
    }

    public static PerfMarkTask task(@CompileTimeConstant String str) {
        return NoopTask.INSTANCE;
    }

    public static void taskEnd(PerfTag perfTag, @CompileTimeConstant String str) {
    }

    public static void taskEnd(@CompileTimeConstant String str) {
    }

    public static void taskStart(PerfTag perfTag, @CompileTimeConstant String str) {
    }

    public static void taskStart(@CompileTimeConstant String str) {
    }
}
