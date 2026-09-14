package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.sentencepiece;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SentencePieceVocabJni.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0082 J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0082 J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fJ\u0019\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\fH\u0082 J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J\u0011\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0082 J!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0082 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;", JsonProperty.USE_DEFAULT_NAME, "()V", "objectAddress", JsonProperty.USE_DEFAULT_NAME, "readWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "clear", JsonProperty.USE_DEFAULT_NAME, "clearInner", "modelAddress", "decode", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, "decodeInner", "encode", "inputSequence", "encodeInner", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", "byteArray", JsonProperty.USE_DEFAULT_NAME, "modelFd", JsonProperty.USE_DEFAULT_NAME, "modelOffset", "modelSize", "loadInnerByByteArrayInner", "loadInnerByFileDescriptorInner", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SentencePieceVocabJni {
    public static final long NULL_ADDRESS = -1;
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private long objectAddress = -1;

    private final native void clearInner(long modelAddress);

    private final native String decodeInner(long modelAddress, int[] ids);

    private final native int[] encodeInner(long modelAddress, String inputSequence);

    private final native long loadInnerByByteArrayInner(byte[] byteArray);

    private final native long loadInnerByFileDescriptorInner(int modelFd, long modelOffset, long modelSize);

    public final void load(int modelFd, long modelOffset, long modelSize) {
        ReentrantReadWriteLock reentrantReadWriteLock = this.readWriteLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (!isLoaded()) {
                this.objectAddress = loadInnerByFileDescriptorInner(modelFd, modelOffset, modelSize);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final void load(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        ReentrantReadWriteLock reentrantReadWriteLock = this.readWriteLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (!isLoaded()) {
                this.objectAddress = loadInnerByByteArrayInner(byteArray);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final int[] encode(String inputSequence) {
        Intrinsics.checkNotNullParameter(inputSequence, "inputSequence");
        ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
        readLock.lock();
        try {
            if (!isLoaded()) {
                throw new IllegalStateException("Model should be loaded first".toString());
            }
            return encodeInner(this.objectAddress, inputSequence);
        } finally {
            readLock.unlock();
        }
    }

    public final String decode(int[] ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
        readLock.lock();
        try {
            if (!isLoaded()) {
                throw new IllegalStateException("Model should be loaded first".toString());
            }
            return decodeInner(this.objectAddress, ids);
        } finally {
            readLock.unlock();
        }
    }

    public final void clear() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.readWriteLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (isLoaded()) {
                clearInner(this.objectAddress);
                this.objectAddress = -1L;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final boolean isLoaded() {
        ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
        readLock.lock();
        try {
            return this.objectAddress != -1;
        } finally {
            readLock.unlock();
        }
    }

    static {
        System.loadLibrary("sentencepiece_lib");
    }
}
