package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class TargetChange extends GeneratedMessageLite<TargetChange, Builder> implements TargetChangeOrBuilder {
    public static final int CAUSE_FIELD_NUMBER = 3;
    private static final TargetChange DEFAULT_INSTANCE = new TargetChange();
    private static volatile Parser<TargetChange> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private Status cause_;
    private Timestamp readTime_;
    private int targetChangeType_;
    private Internal.IntList targetIds_ = GeneratedMessageLite.d();
    private ByteString resumeToken_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.TargetChange$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<TargetChange, Builder> implements TargetChangeOrBuilder {
        private Builder() {
            super(TargetChange.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTargetIds(Iterable<? extends Integer> iterable) {
            a();
            ((TargetChange) this.a).addAllTargetIds(iterable);
            return this;
        }

        public Builder addTargetIds(int i) {
            a();
            ((TargetChange) this.a).addTargetIds(i);
            return this;
        }

        public Builder clearCause() {
            a();
            ((TargetChange) this.a).clearCause();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((TargetChange) this.a).clearReadTime();
            return this;
        }

        public Builder clearResumeToken() {
            a();
            ((TargetChange) this.a).clearResumeToken();
            return this;
        }

        public Builder clearTargetChangeType() {
            a();
            ((TargetChange) this.a).clearTargetChangeType();
            return this;
        }

        public Builder clearTargetIds() {
            a();
            ((TargetChange) this.a).clearTargetIds();
            return this;
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public Status getCause() {
            return ((TargetChange) this.a).getCause();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public Timestamp getReadTime() {
            return ((TargetChange) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public ByteString getResumeToken() {
            return ((TargetChange) this.a).getResumeToken();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public TargetChangeType getTargetChangeType() {
            return ((TargetChange) this.a).getTargetChangeType();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public int getTargetChangeTypeValue() {
            return ((TargetChange) this.a).getTargetChangeTypeValue();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public int getTargetIds(int i) {
            return ((TargetChange) this.a).getTargetIds(i);
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public int getTargetIdsCount() {
            return ((TargetChange) this.a).getTargetIdsCount();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public List<Integer> getTargetIdsList() {
            return Collections.unmodifiableList(((TargetChange) this.a).getTargetIdsList());
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public boolean hasCause() {
            return ((TargetChange) this.a).hasCause();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public boolean hasReadTime() {
            return ((TargetChange) this.a).hasReadTime();
        }

        public Builder mergeCause(Status status) {
            a();
            ((TargetChange) this.a).mergeCause(status);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((TargetChange) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder setCause(Status.Builder builder) {
            a();
            ((TargetChange) this.a).setCause(builder);
            return this;
        }

        public Builder setCause(Status status) {
            a();
            ((TargetChange) this.a).setCause(status);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((TargetChange) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((TargetChange) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setResumeToken(ByteString byteString) {
            a();
            ((TargetChange) this.a).setResumeToken(byteString);
            return this;
        }

        public Builder setTargetChangeType(TargetChangeType targetChangeType) {
            a();
            ((TargetChange) this.a).setTargetChangeType(targetChangeType);
            return this;
        }

        public Builder setTargetChangeTypeValue(int i) {
            a();
            ((TargetChange) this.a).setTargetChangeTypeValue(i);
            return this;
        }

        public Builder setTargetIds(int i, int i2) {
            a();
            ((TargetChange) this.a).setTargetIds(i, i2);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum TargetChangeType implements Internal.EnumLite {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);

        public static final int ADD_VALUE = 1;
        public static final int CURRENT_VALUE = 3;
        public static final int NO_CHANGE_VALUE = 0;
        public static final int REMOVE_VALUE = 2;
        public static final int RESET_VALUE = 4;
        private static final Internal.EnumLiteMap<TargetChangeType> internalValueMap = new Internal.EnumLiteMap<TargetChangeType>() { // from class: com.google.firestore.v1.TargetChange.TargetChangeType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public TargetChangeType findValueByNumber(int i) {
                return TargetChangeType.forNumber(i);
            }
        };
        private final int value;

        TargetChangeType(int i) {
            this.value = i;
        }

        public static TargetChangeType forNumber(int i) {
            if (i == 0) {
                return NO_CHANGE;
            }
            if (i == 1) {
                return ADD;
            }
            if (i == 2) {
                return REMOVE;
            }
            if (i == 3) {
                return CURRENT;
            }
            if (i != 4) {
                return null;
            }
            return RESET;
        }

        public static Internal.EnumLiteMap<TargetChangeType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static TargetChangeType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private TargetChange() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTargetIds(Iterable<? extends Integer> iterable) {
        ensureTargetIdsIsMutable();
        AbstractMessageLite.a(iterable, this.targetIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTargetIds(int i) {
        ensureTargetIdsIsMutable();
        this.targetIds_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCause() {
        this.cause_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResumeToken() {
        this.resumeToken_ = getDefaultInstance().getResumeToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetChangeType() {
        this.targetChangeType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetIds() {
        this.targetIds_ = GeneratedMessageLite.d();
    }

    private void ensureTargetIdsIsMutable() {
        if (this.targetIds_.isModifiable()) {
            return;
        }
        this.targetIds_ = GeneratedMessageLite.a(this.targetIds_);
    }

    public static TargetChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCause(Status status) {
        Status status2 = this.cause_;
        if (status2 != null && status2 != Status.getDefaultInstance()) {
            status = Status.newBuilder(this.cause_).mergeFrom((Status.Builder) status).buildPartial();
        }
        this.cause_ = status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.readTime_ = timestamp;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TargetChange targetChange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) targetChange);
    }

    public static TargetChange parseDelimitedFrom(InputStream inputStream) {
        return (TargetChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetChange parseFrom(ByteString byteString) {
        return (TargetChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static TargetChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TargetChange parseFrom(CodedInputStream codedInputStream) {
        return (TargetChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TargetChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static TargetChange parseFrom(InputStream inputStream) {
        return (TargetChange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetChange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetChange parseFrom(byte[] bArr) {
        return (TargetChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static TargetChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TargetChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<TargetChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCause(Status.Builder builder) {
        this.cause_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCause(Status status) {
        if (status == null) {
            throw new NullPointerException();
        }
        this.cause_ = status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builder) {
        this.readTime_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.readTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResumeToken(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.resumeToken_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetChangeType(TargetChangeType targetChangeType) {
        if (targetChangeType == null) {
            throw new NullPointerException();
        }
        this.targetChangeType_ = targetChangeType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetChangeTypeValue(int i) {
        this.targetChangeType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetIds(int i, int i2) {
        ensureTargetIdsIsMutable();
        this.targetIds_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new TargetChange();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.targetIds_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                TargetChange targetChange = (TargetChange) obj2;
                this.targetChangeType_ = visitor.visitInt(this.targetChangeType_ != 0, this.targetChangeType_, targetChange.targetChangeType_ != 0, targetChange.targetChangeType_);
                this.targetIds_ = visitor.visitIntList(this.targetIds_, targetChange.targetIds_);
                this.cause_ = (Status) visitor.visitMessage(this.cause_, targetChange.cause_);
                this.resumeToken_ = visitor.visitByteString(this.resumeToken_ != ByteString.EMPTY, this.resumeToken_, targetChange.resumeToken_ != ByteString.EMPTY, targetChange.resumeToken_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, targetChange.readTime_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= targetChange.bitField0_;
                }
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
                                    this.targetChangeType_ = codedInputStream.readEnum();
                                } else if (readTag == 16) {
                                    if (!this.targetIds_.isModifiable()) {
                                        this.targetIds_ = GeneratedMessageLite.a(this.targetIds_);
                                    }
                                    this.targetIds_.addInt(codedInputStream.readInt32());
                                } else if (readTag == 18) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.targetIds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.targetIds_ = GeneratedMessageLite.a(this.targetIds_);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.targetIds_.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag == 26) {
                                    Status.Builder builder = this.cause_ != null ? this.cause_.toBuilder() : null;
                                    this.cause_ = (Status) codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Status.Builder) this.cause_);
                                        this.cause_ = builder.buildPartial();
                                    }
                                } else if (readTag == 34) {
                                    this.resumeToken_ = codedInputStream.readBytes();
                                } else if (readTag == 50) {
                                    Timestamp.Builder builder2 = this.readTime_ != null ? this.readTime_.toBuilder() : null;
                                    this.readTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((Timestamp.Builder) this.readTime_);
                                        this.readTime_ = builder2.buildPartial();
                                    }
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r1 = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (TargetChange.class) {
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

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public Status getCause() {
        Status status = this.cause_;
        return status == null ? Status.getDefaultInstance() : status;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public ByteString getResumeToken() {
        return this.resumeToken_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeEnumSize = this.targetChangeType_ != TargetChangeType.NO_CHANGE.getNumber() ? CodedOutputStream.computeEnumSize(1, this.targetChangeType_) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.targetIds_.size(); i3++) {
            i2 += CodedOutputStream.computeInt32SizeNoTag(this.targetIds_.getInt(i3));
        }
        int size = computeEnumSize + i2 + (getTargetIdsList().size() * 1);
        if (this.cause_ != null) {
            size += CodedOutputStream.computeMessageSize(3, getCause());
        }
        if (!this.resumeToken_.isEmpty()) {
            size += CodedOutputStream.computeBytesSize(4, this.resumeToken_);
        }
        if (this.readTime_ != null) {
            size += CodedOutputStream.computeMessageSize(6, getReadTime());
        }
        this.c = size;
        return size;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public TargetChangeType getTargetChangeType() {
        TargetChangeType forNumber = TargetChangeType.forNumber(this.targetChangeType_);
        return forNumber == null ? TargetChangeType.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public int getTargetChangeTypeValue() {
        return this.targetChangeType_;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public int getTargetIds(int i) {
        return this.targetIds_.getInt(i);
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public int getTargetIdsCount() {
        return this.targetIds_.size();
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public List<Integer> getTargetIdsList() {
        return this.targetIds_;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public boolean hasCause() {
        return this.cause_ != null;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public boolean hasReadTime() {
        return this.readTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        if (this.targetChangeType_ != TargetChangeType.NO_CHANGE.getNumber()) {
            codedOutputStream.writeEnum(1, this.targetChangeType_);
        }
        for (int i = 0; i < this.targetIds_.size(); i++) {
            codedOutputStream.writeInt32(2, this.targetIds_.getInt(i));
        }
        if (this.cause_ != null) {
            codedOutputStream.writeMessage(3, getCause());
        }
        if (!this.resumeToken_.isEmpty()) {
            codedOutputStream.writeBytes(4, this.resumeToken_);
        }
        if (this.readTime_ != null) {
            codedOutputStream.writeMessage(6, getReadTime());
        }
    }
}
