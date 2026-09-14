package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class TargetGlobal extends GeneratedMessageLite<TargetGlobal, Builder> implements TargetGlobalOrBuilder {
    private static final TargetGlobal DEFAULT_INSTANCE = new TargetGlobal();
    public static final int HIGHEST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 2;
    public static final int HIGHEST_TARGET_ID_FIELD_NUMBER = 1;
    public static final int LAST_REMOTE_SNAPSHOT_VERSION_FIELD_NUMBER = 3;
    private static volatile Parser<TargetGlobal> PARSER = null;
    public static final int TARGET_COUNT_FIELD_NUMBER = 4;
    private long highestListenSequenceNumber_;
    private int highestTargetId_;
    private Timestamp lastRemoteSnapshotVersion_;
    private int targetCount_;

    /* renamed from: com.google.firebase.firestore.proto.TargetGlobal$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<TargetGlobal, Builder> implements TargetGlobalOrBuilder {
        private Builder() {
            super(TargetGlobal.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearHighestListenSequenceNumber() {
            a();
            ((TargetGlobal) this.a).clearHighestListenSequenceNumber();
            return this;
        }

        public Builder clearHighestTargetId() {
            a();
            ((TargetGlobal) this.a).clearHighestTargetId();
            return this;
        }

        public Builder clearLastRemoteSnapshotVersion() {
            a();
            ((TargetGlobal) this.a).clearLastRemoteSnapshotVersion();
            return this;
        }

        public Builder clearTargetCount() {
            a();
            ((TargetGlobal) this.a).clearTargetCount();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
        public long getHighestListenSequenceNumber() {
            return ((TargetGlobal) this.a).getHighestListenSequenceNumber();
        }

        @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
        public int getHighestTargetId() {
            return ((TargetGlobal) this.a).getHighestTargetId();
        }

        @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
        public Timestamp getLastRemoteSnapshotVersion() {
            return ((TargetGlobal) this.a).getLastRemoteSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
        public int getTargetCount() {
            return ((TargetGlobal) this.a).getTargetCount();
        }

        @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
        public boolean hasLastRemoteSnapshotVersion() {
            return ((TargetGlobal) this.a).hasLastRemoteSnapshotVersion();
        }

        public Builder mergeLastRemoteSnapshotVersion(Timestamp timestamp) {
            a();
            ((TargetGlobal) this.a).mergeLastRemoteSnapshotVersion(timestamp);
            return this;
        }

        public Builder setHighestListenSequenceNumber(long j) {
            a();
            ((TargetGlobal) this.a).setHighestListenSequenceNumber(j);
            return this;
        }

        public Builder setHighestTargetId(int i) {
            a();
            ((TargetGlobal) this.a).setHighestTargetId(i);
            return this;
        }

        public Builder setLastRemoteSnapshotVersion(Timestamp.Builder builder) {
            a();
            ((TargetGlobal) this.a).setLastRemoteSnapshotVersion(builder);
            return this;
        }

        public Builder setLastRemoteSnapshotVersion(Timestamp timestamp) {
            a();
            ((TargetGlobal) this.a).setLastRemoteSnapshotVersion(timestamp);
            return this;
        }

        public Builder setTargetCount(int i) {
            a();
            ((TargetGlobal) this.a).setTargetCount(i);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private TargetGlobal() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHighestListenSequenceNumber() {
        this.highestListenSequenceNumber_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHighestTargetId() {
        this.highestTargetId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastRemoteSnapshotVersion() {
        this.lastRemoteSnapshotVersion_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetCount() {
        this.targetCount_ = 0;
    }

    public static TargetGlobal getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLastRemoteSnapshotVersion(Timestamp timestamp) {
        Timestamp timestamp2 = this.lastRemoteSnapshotVersion_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.lastRemoteSnapshotVersion_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.lastRemoteSnapshotVersion_ = timestamp;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TargetGlobal targetGlobal) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) targetGlobal);
    }

    public static TargetGlobal parseDelimitedFrom(InputStream inputStream) {
        return (TargetGlobal) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetGlobal parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetGlobal) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetGlobal parseFrom(ByteString byteString) {
        return (TargetGlobal) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static TargetGlobal parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetGlobal) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TargetGlobal parseFrom(CodedInputStream codedInputStream) {
        return (TargetGlobal) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TargetGlobal parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetGlobal) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static TargetGlobal parseFrom(InputStream inputStream) {
        return (TargetGlobal) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetGlobal parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetGlobal) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetGlobal parseFrom(byte[] bArr) {
        return (TargetGlobal) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static TargetGlobal parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetGlobal) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<TargetGlobal> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHighestListenSequenceNumber(long j) {
        this.highestListenSequenceNumber_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHighestTargetId(int i) {
        this.highestTargetId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastRemoteSnapshotVersion(Timestamp.Builder builder) {
        this.lastRemoteSnapshotVersion_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastRemoteSnapshotVersion(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.lastRemoteSnapshotVersion_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetCount(int i) {
        this.targetCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new TargetGlobal();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                TargetGlobal targetGlobal = (TargetGlobal) obj2;
                this.highestTargetId_ = visitor.visitInt(this.highestTargetId_ != 0, this.highestTargetId_, targetGlobal.highestTargetId_ != 0, targetGlobal.highestTargetId_);
                this.highestListenSequenceNumber_ = visitor.visitLong(this.highestListenSequenceNumber_ != 0, this.highestListenSequenceNumber_, targetGlobal.highestListenSequenceNumber_ != 0, targetGlobal.highestListenSequenceNumber_);
                this.lastRemoteSnapshotVersion_ = (Timestamp) visitor.visitMessage(this.lastRemoteSnapshotVersion_, targetGlobal.lastRemoteSnapshotVersion_);
                this.targetCount_ = visitor.visitInt(this.targetCount_ != 0, this.targetCount_, targetGlobal.targetCount_ != 0, targetGlobal.targetCount_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.highestTargetId_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.highestListenSequenceNumber_ = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    Timestamp.Builder builder = this.lastRemoteSnapshotVersion_ != null ? this.lastRemoteSnapshotVersion_.toBuilder() : null;
                                    this.lastRemoteSnapshotVersion_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Timestamp.Builder) this.lastRemoteSnapshotVersion_);
                                        this.lastRemoteSnapshotVersion_ = builder.buildPartial();
                                    }
                                } else if (readTag == 32) {
                                    this.targetCount_ = codedInputStream.readInt32();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r1 = true;
                        } catch (IOException e) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (TargetGlobal.class) {
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

    @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
    public long getHighestListenSequenceNumber() {
        return this.highestListenSequenceNumber_;
    }

    @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
    public int getHighestTargetId() {
        return this.highestTargetId_;
    }

    @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
    public Timestamp getLastRemoteSnapshotVersion() {
        Timestamp timestamp = this.lastRemoteSnapshotVersion_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.highestTargetId_;
        int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
        long j = this.highestListenSequenceNumber_;
        if (j != 0) {
            computeInt32Size += CodedOutputStream.computeInt64Size(2, j);
        }
        if (this.lastRemoteSnapshotVersion_ != null) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, getLastRemoteSnapshotVersion());
        }
        int i3 = this.targetCount_;
        if (i3 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(4, i3);
        }
        this.c = computeInt32Size;
        return computeInt32Size;
    }

    @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
    public int getTargetCount() {
        return this.targetCount_;
    }

    @Override // com.google.firebase.firestore.proto.TargetGlobalOrBuilder
    public boolean hasLastRemoteSnapshotVersion() {
        return this.lastRemoteSnapshotVersion_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.highestTargetId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        long j = this.highestListenSequenceNumber_;
        if (j != 0) {
            codedOutputStream.writeInt64(2, j);
        }
        if (this.lastRemoteSnapshotVersion_ != null) {
            codedOutputStream.writeMessage(3, getLastRemoteSnapshotVersion());
        }
        int i2 = this.targetCount_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(4, i2);
        }
    }
}
