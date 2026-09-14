package com.google.firestore.v1;

import com.google.firestore.v1.WriteResult;
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
public final class CommitResponse extends GeneratedMessageLite<CommitResponse, Builder> implements CommitResponseOrBuilder {
    public static final int COMMIT_TIME_FIELD_NUMBER = 2;
    private static final CommitResponse DEFAULT_INSTANCE = new CommitResponse();
    private static volatile Parser<CommitResponse> PARSER = null;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 1;
    private int bitField0_;
    private Timestamp commitTime_;
    private Internal.ProtobufList<WriteResult> writeResults_ = GeneratedMessageLite.f();

    /* renamed from: com.google.firestore.v1.CommitResponse$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<CommitResponse, Builder> implements CommitResponseOrBuilder {
        private Builder() {
            super(CommitResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWriteResults(Iterable<? extends WriteResult> iterable) {
            a();
            ((CommitResponse) this.a).addAllWriteResults(iterable);
            return this;
        }

        public Builder addWriteResults(int i, WriteResult.Builder builder) {
            a();
            ((CommitResponse) this.a).addWriteResults(i, builder);
            return this;
        }

        public Builder addWriteResults(int i, WriteResult writeResult) {
            a();
            ((CommitResponse) this.a).addWriteResults(i, writeResult);
            return this;
        }

        public Builder addWriteResults(WriteResult.Builder builder) {
            a();
            ((CommitResponse) this.a).addWriteResults(builder);
            return this;
        }

        public Builder addWriteResults(WriteResult writeResult) {
            a();
            ((CommitResponse) this.a).addWriteResults(writeResult);
            return this;
        }

        public Builder clearCommitTime() {
            a();
            ((CommitResponse) this.a).clearCommitTime();
            return this;
        }

        public Builder clearWriteResults() {
            a();
            ((CommitResponse) this.a).clearWriteResults();
            return this;
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public Timestamp getCommitTime() {
            return ((CommitResponse) this.a).getCommitTime();
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public WriteResult getWriteResults(int i) {
            return ((CommitResponse) this.a).getWriteResults(i);
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public int getWriteResultsCount() {
            return ((CommitResponse) this.a).getWriteResultsCount();
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public List<WriteResult> getWriteResultsList() {
            return Collections.unmodifiableList(((CommitResponse) this.a).getWriteResultsList());
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public boolean hasCommitTime() {
            return ((CommitResponse) this.a).hasCommitTime();
        }

        public Builder mergeCommitTime(Timestamp timestamp) {
            a();
            ((CommitResponse) this.a).mergeCommitTime(timestamp);
            return this;
        }

        public Builder removeWriteResults(int i) {
            a();
            ((CommitResponse) this.a).removeWriteResults(i);
            return this;
        }

        public Builder setCommitTime(Timestamp.Builder builder) {
            a();
            ((CommitResponse) this.a).setCommitTime(builder);
            return this;
        }

        public Builder setCommitTime(Timestamp timestamp) {
            a();
            ((CommitResponse) this.a).setCommitTime(timestamp);
            return this;
        }

        public Builder setWriteResults(int i, WriteResult.Builder builder) {
            a();
            ((CommitResponse) this.a).setWriteResults(i, builder);
            return this;
        }

        public Builder setWriteResults(int i, WriteResult writeResult) {
            a();
            ((CommitResponse) this.a).setWriteResults(i, writeResult);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private CommitResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllWriteResults(Iterable<? extends WriteResult> iterable) {
        ensureWriteResultsIsMutable();
        AbstractMessageLite.a(iterable, this.writeResults_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWriteResults(int i, WriteResult.Builder builder) {
        ensureWriteResultsIsMutable();
        this.writeResults_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWriteResults(int i, WriteResult writeResult) {
        if (writeResult == null) {
            throw new NullPointerException();
        }
        ensureWriteResultsIsMutable();
        this.writeResults_.add(i, writeResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWriteResults(WriteResult.Builder builder) {
        ensureWriteResultsIsMutable();
        this.writeResults_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWriteResults(WriteResult writeResult) {
        if (writeResult == null) {
            throw new NullPointerException();
        }
        ensureWriteResultsIsMutable();
        this.writeResults_.add(writeResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCommitTime() {
        this.commitTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWriteResults() {
        this.writeResults_ = GeneratedMessageLite.f();
    }

    private void ensureWriteResultsIsMutable() {
        if (this.writeResults_.isModifiable()) {
            return;
        }
        this.writeResults_ = GeneratedMessageLite.a(this.writeResults_);
    }

    public static CommitResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCommitTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.commitTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.commitTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.commitTime_ = timestamp;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CommitResponse commitResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) commitResponse);
    }

    public static CommitResponse parseDelimitedFrom(InputStream inputStream) {
        return (CommitResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static CommitResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(ByteString byteString) {
        return (CommitResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static CommitResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(CodedInputStream codedInputStream) {
        return (CommitResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CommitResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(InputStream inputStream) {
        return (CommitResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static CommitResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(byte[] bArr) {
        return (CommitResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static CommitResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<CommitResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWriteResults(int i) {
        ensureWriteResultsIsMutable();
        this.writeResults_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommitTime(Timestamp.Builder builder) {
        this.commitTime_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommitTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.commitTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWriteResults(int i, WriteResult.Builder builder) {
        ensureWriteResultsIsMutable();
        this.writeResults_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWriteResults(int i, WriteResult writeResult) {
        if (writeResult == null) {
            throw new NullPointerException();
        }
        ensureWriteResultsIsMutable();
        this.writeResults_.set(i, writeResult);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new CommitResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writeResults_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CommitResponse commitResponse = (CommitResponse) obj2;
                this.writeResults_ = visitor.visitList(this.writeResults_, commitResponse.writeResults_);
                this.commitTime_ = (Timestamp) visitor.visitMessage(this.commitTime_, commitResponse.commitTime_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= commitResponse.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                if (!this.writeResults_.isModifiable()) {
                                    this.writeResults_ = GeneratedMessageLite.a(this.writeResults_);
                                }
                                this.writeResults_.add((WriteResult) codedInputStream.readMessage(WriteResult.parser(), extensionRegistryLite));
                            } else if (readTag == 18) {
                                Timestamp.Builder builder = this.commitTime_ != null ? this.commitTime_.toBuilder() : null;
                                this.commitTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Timestamp.Builder) this.commitTime_);
                                    this.commitTime_ = builder.buildPartial();
                                }
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z = true;
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
                    synchronized (CommitResponse.class) {
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

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public Timestamp getCommitTime() {
        Timestamp timestamp = this.commitTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.writeResults_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.writeResults_.get(i3));
        }
        if (this.commitTime_ != null) {
            i2 += CodedOutputStream.computeMessageSize(2, getCommitTime());
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public WriteResult getWriteResults(int i) {
        return this.writeResults_.get(i);
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public int getWriteResultsCount() {
        return this.writeResults_.size();
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public List<WriteResult> getWriteResultsList() {
        return this.writeResults_;
    }

    public WriteResultOrBuilder getWriteResultsOrBuilder(int i) {
        return this.writeResults_.get(i);
    }

    public List<? extends WriteResultOrBuilder> getWriteResultsOrBuilderList() {
        return this.writeResults_;
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public boolean hasCommitTime() {
        return this.commitTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.writeResults_.size(); i++) {
            codedOutputStream.writeMessage(1, this.writeResults_.get(i));
        }
        if (this.commitTime_ != null) {
            codedOutputStream.writeMessage(2, getCommitTime());
        }
    }
}
