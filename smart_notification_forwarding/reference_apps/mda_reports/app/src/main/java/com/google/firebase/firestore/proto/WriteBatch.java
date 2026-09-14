package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteOrBuilder;
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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class WriteBatch extends GeneratedMessageLite<WriteBatch, Builder> implements WriteBatchOrBuilder {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final WriteBatch DEFAULT_INSTANCE = new WriteBatch();
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile Parser<WriteBatch> PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int batchId_;
    private int bitField0_;
    private Timestamp localWriteTime_;
    private Internal.ProtobufList<Write> writes_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<Write> baseWrites_ = GeneratedMessageLite.f();

    /* renamed from: com.google.firebase.firestore.proto.WriteBatch$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<WriteBatch, Builder> implements WriteBatchOrBuilder {
        private Builder() {
            super(WriteBatch.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllBaseWrites(Iterable<? extends Write> iterable) {
            a();
            ((WriteBatch) this.a).addAllBaseWrites(iterable);
            return this;
        }

        public Builder addAllWrites(Iterable<? extends Write> iterable) {
            a();
            ((WriteBatch) this.a).addAllWrites(iterable);
            return this;
        }

        public Builder addBaseWrites(int i, Write.Builder builder) {
            a();
            ((WriteBatch) this.a).addBaseWrites(i, builder);
            return this;
        }

        public Builder addBaseWrites(int i, Write write) {
            a();
            ((WriteBatch) this.a).addBaseWrites(i, write);
            return this;
        }

        public Builder addBaseWrites(Write.Builder builder) {
            a();
            ((WriteBatch) this.a).addBaseWrites(builder);
            return this;
        }

        public Builder addBaseWrites(Write write) {
            a();
            ((WriteBatch) this.a).addBaseWrites(write);
            return this;
        }

        public Builder addWrites(int i, Write.Builder builder) {
            a();
            ((WriteBatch) this.a).addWrites(i, builder);
            return this;
        }

        public Builder addWrites(int i, Write write) {
            a();
            ((WriteBatch) this.a).addWrites(i, write);
            return this;
        }

        public Builder addWrites(Write.Builder builder) {
            a();
            ((WriteBatch) this.a).addWrites(builder);
            return this;
        }

        public Builder addWrites(Write write) {
            a();
            ((WriteBatch) this.a).addWrites(write);
            return this;
        }

        public Builder clearBaseWrites() {
            a();
            ((WriteBatch) this.a).clearBaseWrites();
            return this;
        }

        public Builder clearBatchId() {
            a();
            ((WriteBatch) this.a).clearBatchId();
            return this;
        }

        public Builder clearLocalWriteTime() {
            a();
            ((WriteBatch) this.a).clearLocalWriteTime();
            return this;
        }

        public Builder clearWrites() {
            a();
            ((WriteBatch) this.a).clearWrites();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public Write getBaseWrites(int i) {
            return ((WriteBatch) this.a).getBaseWrites(i);
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getBaseWritesCount() {
            return ((WriteBatch) this.a).getBaseWritesCount();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public List<Write> getBaseWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.a).getBaseWritesList());
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getBatchId() {
            return ((WriteBatch) this.a).getBatchId();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public Timestamp getLocalWriteTime() {
            return ((WriteBatch) this.a).getLocalWriteTime();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public Write getWrites(int i) {
            return ((WriteBatch) this.a).getWrites(i);
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getWritesCount() {
            return ((WriteBatch) this.a).getWritesCount();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.a).getWritesList());
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public boolean hasLocalWriteTime() {
            return ((WriteBatch) this.a).hasLocalWriteTime();
        }

        public Builder mergeLocalWriteTime(Timestamp timestamp) {
            a();
            ((WriteBatch) this.a).mergeLocalWriteTime(timestamp);
            return this;
        }

        public Builder removeBaseWrites(int i) {
            a();
            ((WriteBatch) this.a).removeBaseWrites(i);
            return this;
        }

        public Builder removeWrites(int i) {
            a();
            ((WriteBatch) this.a).removeWrites(i);
            return this;
        }

        public Builder setBaseWrites(int i, Write.Builder builder) {
            a();
            ((WriteBatch) this.a).setBaseWrites(i, builder);
            return this;
        }

        public Builder setBaseWrites(int i, Write write) {
            a();
            ((WriteBatch) this.a).setBaseWrites(i, write);
            return this;
        }

        public Builder setBatchId(int i) {
            a();
            ((WriteBatch) this.a).setBatchId(i);
            return this;
        }

        public Builder setLocalWriteTime(Timestamp.Builder builder) {
            a();
            ((WriteBatch) this.a).setLocalWriteTime(builder);
            return this;
        }

        public Builder setLocalWriteTime(Timestamp timestamp) {
            a();
            ((WriteBatch) this.a).setLocalWriteTime(timestamp);
            return this;
        }

        public Builder setWrites(int i, Write.Builder builder) {
            a();
            ((WriteBatch) this.a).setWrites(i, builder);
            return this;
        }

        public Builder setWrites(int i, Write write) {
            a();
            ((WriteBatch) this.a).setWrites(i, write);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private WriteBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllBaseWrites(Iterable<? extends Write> iterable) {
        ensureBaseWritesIsMutable();
        AbstractMessageLite.a(iterable, this.baseWrites_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllWrites(Iterable<? extends Write> iterable) {
        ensureWritesIsMutable();
        AbstractMessageLite.a(iterable, this.writes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBaseWrites(int i, Write.Builder builder) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBaseWrites(int i, Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(i, write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBaseWrites(Write.Builder builder) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBaseWrites(Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(int i, Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(int i, Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureWritesIsMutable();
        this.writes_.add(i, write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureWritesIsMutable();
        this.writes_.add(write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBaseWrites() {
        this.baseWrites_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBatchId() {
        this.batchId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocalWriteTime() {
        this.localWriteTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWrites() {
        this.writes_ = GeneratedMessageLite.f();
    }

    private void ensureBaseWritesIsMutable() {
        if (this.baseWrites_.isModifiable()) {
            return;
        }
        this.baseWrites_ = GeneratedMessageLite.a(this.baseWrites_);
    }

    private void ensureWritesIsMutable() {
        if (this.writes_.isModifiable()) {
            return;
        }
        this.writes_ = GeneratedMessageLite.a(this.writes_);
    }

    public static WriteBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLocalWriteTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.localWriteTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.localWriteTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.localWriteTime_ = timestamp;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteBatch writeBatch) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) writeBatch);
    }

    public static WriteBatch parseDelimitedFrom(InputStream inputStream) {
        return (WriteBatch) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteBatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteBatch) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(ByteString byteString) {
        return (WriteBatch) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static WriteBatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteBatch) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(CodedInputStream codedInputStream) {
        return (WriteBatch) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteBatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteBatch) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(InputStream inputStream) {
        return (WriteBatch) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteBatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteBatch) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(byte[] bArr) {
        return (WriteBatch) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static WriteBatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteBatch) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<WriteBatch> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeBaseWrites(int i) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWrites(int i) {
        ensureWritesIsMutable();
        this.writes_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseWrites(int i, Write.Builder builder) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseWrites(int i, Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureBaseWritesIsMutable();
        this.baseWrites_.set(i, write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBatchId(int i) {
        this.batchId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalWriteTime(Timestamp.Builder builder) {
        this.localWriteTime_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalWriteTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.localWriteTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWrites(int i, Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWrites(int i, Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureWritesIsMutable();
        this.writes_.set(i, write);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Internal.ProtobufList<Write> protobufList;
        Write write;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new WriteBatch();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writes_.makeImmutable();
                this.baseWrites_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                WriteBatch writeBatch = (WriteBatch) obj2;
                this.batchId_ = visitor.visitInt(this.batchId_ != 0, this.batchId_, writeBatch.batchId_ != 0, writeBatch.batchId_);
                this.writes_ = visitor.visitList(this.writes_, writeBatch.writes_);
                this.localWriteTime_ = (Timestamp) visitor.visitMessage(this.localWriteTime_, writeBatch.localWriteTime_);
                this.baseWrites_ = visitor.visitList(this.baseWrites_, writeBatch.baseWrites_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= writeBatch.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r0) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 8) {
                                if (readTag == 18) {
                                    if (!this.writes_.isModifiable()) {
                                        this.writes_ = GeneratedMessageLite.a(this.writes_);
                                    }
                                    protobufList = this.writes_;
                                    write = (Write) codedInputStream.readMessage(Write.parser(), extensionRegistryLite);
                                } else if (readTag == 26) {
                                    Timestamp.Builder builder = this.localWriteTime_ != null ? this.localWriteTime_.toBuilder() : null;
                                    this.localWriteTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Timestamp.Builder) this.localWriteTime_);
                                        this.localWriteTime_ = builder.buildPartial();
                                    }
                                } else if (readTag == 34) {
                                    if (!this.baseWrites_.isModifiable()) {
                                        this.baseWrites_ = GeneratedMessageLite.a(this.baseWrites_);
                                    }
                                    protobufList = this.baseWrites_;
                                    write = (Write) codedInputStream.readMessage(Write.parser(), extensionRegistryLite);
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                                protobufList.add(write);
                            } else {
                                this.batchId_ = codedInputStream.readInt32();
                            }
                        }
                        r0 = true;
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
                    synchronized (WriteBatch.class) {
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

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public Write getBaseWrites(int i) {
        return this.baseWrites_.get(i);
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getBaseWritesCount() {
        return this.baseWrites_.size();
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public List<Write> getBaseWritesList() {
        return this.baseWrites_;
    }

    public WriteOrBuilder getBaseWritesOrBuilder(int i) {
        return this.baseWrites_.get(i);
    }

    public List<? extends WriteOrBuilder> getBaseWritesOrBuilderList() {
        return this.baseWrites_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getBatchId() {
        return this.batchId_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public Timestamp getLocalWriteTime() {
        Timestamp timestamp = this.localWriteTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.batchId_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        for (int i3 = 0; i3 < this.writes_.size(); i3++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, this.writes_.get(i3));
        }
        if (this.localWriteTime_ != null) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, getLocalWriteTime());
        }
        for (int i4 = 0; i4 < this.baseWrites_.size(); i4++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, this.baseWrites_.get(i4));
        }
        this.c = computeInt32Size;
        return computeInt32Size;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public Write getWrites(int i) {
        return this.writes_.get(i);
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getWritesCount() {
        return this.writes_.size();
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public List<Write> getWritesList() {
        return this.writes_;
    }

    public WriteOrBuilder getWritesOrBuilder(int i) {
        return this.writes_.get(i);
    }

    public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
        return this.writes_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public boolean hasLocalWriteTime() {
        return this.localWriteTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.batchId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        for (int i2 = 0; i2 < this.writes_.size(); i2++) {
            codedOutputStream.writeMessage(2, this.writes_.get(i2));
        }
        if (this.localWriteTime_ != null) {
            codedOutputStream.writeMessage(3, getLocalWriteTime());
        }
        for (int i3 = 0; i3 < this.baseWrites_.size(); i3++) {
            codedOutputStream.writeMessage(4, this.baseWrites_.get(i3));
        }
    }
}
