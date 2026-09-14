package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class MutationQueue extends GeneratedMessageLite<MutationQueue, Builder> implements MutationQueueOrBuilder {
    private static final MutationQueue DEFAULT_INSTANCE = new MutationQueue();
    public static final int LAST_ACKNOWLEDGED_BATCH_ID_FIELD_NUMBER = 1;
    public static final int LAST_STREAM_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<MutationQueue> PARSER;
    private int lastAcknowledgedBatchId_;
    private ByteString lastStreamToken_ = ByteString.EMPTY;

    /* renamed from: com.google.firebase.firestore.proto.MutationQueue$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MutationQueue, Builder> implements MutationQueueOrBuilder {
        private Builder() {
            super(MutationQueue.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearLastAcknowledgedBatchId() {
            a();
            ((MutationQueue) this.a).clearLastAcknowledgedBatchId();
            return this;
        }

        public Builder clearLastStreamToken() {
            a();
            ((MutationQueue) this.a).clearLastStreamToken();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.MutationQueueOrBuilder
        public int getLastAcknowledgedBatchId() {
            return ((MutationQueue) this.a).getLastAcknowledgedBatchId();
        }

        @Override // com.google.firebase.firestore.proto.MutationQueueOrBuilder
        public ByteString getLastStreamToken() {
            return ((MutationQueue) this.a).getLastStreamToken();
        }

        public Builder setLastAcknowledgedBatchId(int i) {
            a();
            ((MutationQueue) this.a).setLastAcknowledgedBatchId(i);
            return this;
        }

        public Builder setLastStreamToken(ByteString byteString) {
            a();
            ((MutationQueue) this.a).setLastStreamToken(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private MutationQueue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastAcknowledgedBatchId() {
        this.lastAcknowledgedBatchId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastStreamToken() {
        this.lastStreamToken_ = getDefaultInstance().getLastStreamToken();
    }

    public static MutationQueue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MutationQueue mutationQueue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) mutationQueue);
    }

    public static MutationQueue parseDelimitedFrom(InputStream inputStream) {
        return (MutationQueue) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationQueue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationQueue) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationQueue parseFrom(ByteString byteString) {
        return (MutationQueue) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static MutationQueue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationQueue) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationQueue parseFrom(CodedInputStream codedInputStream) {
        return (MutationQueue) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationQueue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationQueue) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationQueue parseFrom(InputStream inputStream) {
        return (MutationQueue) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationQueue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationQueue) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationQueue parseFrom(byte[] bArr) {
        return (MutationQueue) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static MutationQueue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationQueue) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationQueue> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastAcknowledgedBatchId(int i) {
        this.lastAcknowledgedBatchId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastStreamToken(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.lastStreamToken_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationQueue();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                MutationQueue mutationQueue = (MutationQueue) obj2;
                this.lastAcknowledgedBatchId_ = visitor.visitInt(this.lastAcknowledgedBatchId_ != 0, this.lastAcknowledgedBatchId_, mutationQueue.lastAcknowledgedBatchId_ != 0, mutationQueue.lastAcknowledgedBatchId_);
                this.lastStreamToken_ = visitor.visitByteString(this.lastStreamToken_ != ByteString.EMPTY, this.lastStreamToken_, mutationQueue.lastStreamToken_ != ByteString.EMPTY, mutationQueue.lastStreamToken_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.lastAcknowledgedBatchId_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.lastStreamToken_ = codedInputStream.readBytes();
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        r1 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (MutationQueue.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.firebase.firestore.proto.MutationQueueOrBuilder
    public int getLastAcknowledgedBatchId() {
        return this.lastAcknowledgedBatchId_;
    }

    @Override // com.google.firebase.firestore.proto.MutationQueueOrBuilder
    public ByteString getLastStreamToken() {
        return this.lastStreamToken_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.lastAcknowledgedBatchId_;
        int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
        if (!this.lastStreamToken_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeBytesSize(2, this.lastStreamToken_);
        }
        this.c = computeInt32Size;
        return computeInt32Size;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.lastAcknowledgedBatchId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (this.lastStreamToken_.isEmpty()) {
            return;
        }
        codedOutputStream.writeBytes(2, this.lastStreamToken_);
    }
}
