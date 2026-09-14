package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SrCppModelJni.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0006\u0010\f\u001a\u00020\rJ6\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017JV\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J9\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0082 JY\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0082 J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u0014J!\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0014H\u0082 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/SrCppModelJni;", JsonProperty.USE_DEFAULT_NAME, "()V", "loadLock", "Ljava/util/concurrent/locks/ReentrantLock;", "modelAddress", JsonProperty.USE_DEFAULT_NAME, "translationLock", "clear", JsonProperty.USE_DEFAULT_NAME, "deleteInner", "interruptInner", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", "modelByteArray", JsonProperty.USE_DEFAULT_NAME, "hParamsByteArray", "isExynos", "maxInputLength", JsonProperty.USE_DEFAULT_NAME, "maxOutputLength", "modelType", JsonProperty.USE_DEFAULT_NAME, "modelFd", "modelOffset", "modelSize", "hParamsFd", "hParamsOffset", "hParamsSize", "loadModelByByteArrayInner", "loadModelByFileDescriptorInner", "translate", JsonProperty.USE_DEFAULT_NAME, "ids", "batchSizeInTokens", "translateInner", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SrCppModelJni {
    private static final long NULL_ADDRESS = -1;
    private long modelAddress = -1;
    private final ReentrantLock loadLock = new ReentrantLock();
    private final ReentrantLock translationLock = new ReentrantLock();

    private final native void deleteInner(long modelAddress);

    private final native void interruptInner(long modelAddress);

    private final native long loadModelByByteArrayInner(byte[] modelByteArray, byte[] hParamsByteArray, boolean isExynos, int maxInputLength, int maxOutputLength, String modelType);

    private final native long loadModelByFileDescriptorInner(int modelFd, long modelOffset, long modelSize, int hParamsFd, long hParamsOffset, long hParamsSize, boolean isExynos, int maxInputLength, int maxOutputLength, String modelType);

    private final native int[] translateInner(int[] ids, long modelAddress, int batchSizeInTokens);

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        throw r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void load(byte[] r7, byte[] r8, boolean r9, int r10, int r11, java.lang.String r12) {
        /*
            r6 = this;
            java.lang.String r0 = "modelByteArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "hParamsByteArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "modelType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r6.loadLock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            java.util.concurrent.locks.ReentrantLock r1 = r6.translationLock     // Catch: java.lang.Throwable -> L3b
            java.util.concurrent.locks.Lock r1 = (java.util.concurrent.locks.Lock) r1     // Catch: java.lang.Throwable -> L3b
            r1.lock()     // Catch: java.lang.Throwable -> L3b
            long r2 = r6.modelAddress     // Catch: java.lang.Throwable -> L36
            r4 = -1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L2b
            long r7 = r6.loadModelByByteArrayInner(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L36
            r6.modelAddress = r7     // Catch: java.lang.Throwable -> L36
        L2b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L36
            r1.unlock()     // Catch: java.lang.Throwable -> L3b
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L3b
            r0.unlock()
            return
        L36:
            r7 = move-exception
            r1.unlock()     // Catch: java.lang.Throwable -> L3b
            throw r7     // Catch: java.lang.Throwable -> L3b
        L3b:
            r7 = move-exception
            r0.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.SrCppModelJni.load(byte[], byte[], boolean, int, int, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void load(int r10, long r11, long r13, int r15, long r16, long r18, boolean r20, int r21, int r22, java.lang.String r23) {
        /*
            r9 = this;
            r1 = r9
            java.lang.String r0 = "modelType"
            r2 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r1.loadLock
            r3 = r0
            java.util.concurrent.locks.Lock r3 = (java.util.concurrent.locks.Lock) r3
            r3.lock()
            java.util.concurrent.locks.ReentrantLock r0 = r1.translationLock     // Catch: java.lang.Throwable -> L36
            r4 = r0
            java.util.concurrent.locks.Lock r4 = (java.util.concurrent.locks.Lock) r4     // Catch: java.lang.Throwable -> L36
            r4.lock()     // Catch: java.lang.Throwable -> L36
            long r5 = r1.modelAddress     // Catch: java.lang.Throwable -> L31
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L26
            long r5 = r9.loadModelByFileDescriptorInner(r10, r11, r13, r15, r16, r18, r20, r21, r22, r23)     // Catch: java.lang.Throwable -> L31
            r1.modelAddress = r5     // Catch: java.lang.Throwable -> L31
        L26:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L31
            r4.unlock()     // Catch: java.lang.Throwable -> L36
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L36
            r3.unlock()
            return
        L31:
            r0 = move-exception
            r4.unlock()     // Catch: java.lang.Throwable -> L36
            throw r0     // Catch: java.lang.Throwable -> L36
        L36:
            r0 = move-exception
            r3.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.SrCppModelJni.load(int, long, long, int, long, long, boolean, int, int, java.lang.String):void");
    }

    public static /* synthetic */ int[] translate$default(SrCppModelJni srCppModelJni, int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        return srCppModelJni.translate(iArr, i);
    }

    public final int[] translate(int[] ids, int batchSizeInTokens) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        ReentrantLock reentrantLock = this.loadLock;
        reentrantLock.lock();
        try {
            if (!(this.modelAddress != -1)) {
                throw new IllegalStateException("Model is not loaded".toString());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            this.translationLock.lock();
            try {
                long j = this.modelAddress;
                return j == -1 ? new int[0] : translateInner(ids, j, batchSizeInTokens);
            } finally {
            }
        } finally {
        }
    }

    public final void clear() {
        ReentrantLock reentrantLock = this.loadLock;
        reentrantLock.lock();
        try {
            long j = this.modelAddress;
            if (j != -1) {
                interruptInner(j);
                reentrantLock = this.translationLock;
                reentrantLock.lock();
                deleteInner(this.modelAddress);
                this.modelAddress = -1L;
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            }
            Unit unit2 = Unit.INSTANCE;
        } catch (Throwable th) {
            throw th;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isLoaded() {
        ReentrantLock reentrantLock = this.loadLock;
        reentrantLock.lock();
        try {
            return this.modelAddress != -1;
        } finally {
            reentrantLock.unlock();
        }
    }

    static {
        System.loadLibrary("cpp_infer_lib");
    }
}
