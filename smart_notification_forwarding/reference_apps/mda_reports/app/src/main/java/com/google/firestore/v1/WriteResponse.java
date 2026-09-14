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
public final class WriteResponse extends GeneratedMessageLite<WriteResponse, Builder> implements WriteResponseOrBuilder {
    public static final int COMMIT_TIME_FIELD_NUMBER = 4;
    private static final WriteResponse DEFAULT_INSTANCE = new WriteResponse();
    private static volatile Parser<WriteResponse> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 1;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 2;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 3;
    private int bitField0_;
    private Timestamp commitTime_;
    private String streamId_ = "";
    private ByteString streamToken_ = ByteString.EMPTY;
    private Internal.ProtobufList<WriteResult> writeResults_ = GeneratedMessageLite.f();

    /* renamed from: com.google.firestore.v1.WriteResponse$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<WriteResponse, Builder> implements WriteResponseOrBuilder {
        private Builder() {
            super(WriteResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWriteResults(Iterable<? extends WriteResult> iterable) {
            a();
            ((WriteResponse) this.a).addAllWriteResults(iterable);
            return this;
        }

        public Builder addWriteResults(int i, WriteResult.Builder builder) {
            a();
            ((WriteResponse) this.a).addWriteResults(i, builder);
            return this;
        }

        public Builder addWriteResults(int i, WriteResult writeResult) {
            a();
            ((WriteResponse) this.a).addWriteResults(i, writeResult);
            return this;
        }

        public Builder addWriteResults(WriteResult.Builder builder) {
            a();
            ((WriteResponse) this.a).addWriteResults(builder);
            return this;
        }

        public Builder addWriteResults(WriteResult writeResult) {
            a();
            ((WriteResponse) this.a).addWriteResults(writeResult);
            return this;
        }

        public Builder clearCommitTime() {
            a();
            ((WriteResponse) this.a).clearCommitTime();
            return this;
        }

        public Builder clearStreamId() {
            a();
            ((WriteResponse) this.a).clearStreamId();
            return this;
        }

        public Builder clearStreamToken() {
            a();
            ((WriteResponse) this.a).clearStreamToken();
            return this;
        }

        public Builder clearWriteResults() {
            a();
            ((WriteResponse) this.a).clearWriteResults();
            return this;
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public Timestamp getCommitTime() {
            return ((WriteResponse) this.a).getCommitTime();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public String getStreamId() {
            return ((WriteResponse) this.a).getStreamId();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public ByteString getStreamIdBytes() {
            return ((WriteResponse) this.a).getStreamIdBytes();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public ByteString getStreamToken() {
            return ((WriteResponse) this.a).getStreamToken();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public WriteResult getWriteResults(int i) {
            return ((WriteResponse) this.a).getWriteResults(i);
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public int getWriteResultsCount() {
            return ((WriteResponse) this.a).getWriteResultsCount();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public List<WriteResult> getWriteResultsList() {
            return Collections.unmodifiableList(((WriteResponse) this.a).getWriteResultsList());
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public boolean hasCommitTime() {
            return ((WriteResponse) this.a).hasCommitTime();
        }

        public Builder mergeCommitTime(Timestamp timestamp) {
            a();
            ((WriteResponse) this.a).mergeCommitTime(timestamp);
            return this;
        }

        public Builder removeWriteResults(int i) {
            a();
            ((WriteResponse) this.a).removeWriteResults(i);
            return this;
        }

        public Builder setCommitTime(Timestamp.Builder builder) {
            a();
            ((WriteResponse) this.a).setCommitTime(builder);
            return this;
        }

        public Builder setCommitTime(Timestamp timestamp) {
            a();
            ((WriteResponse) this.a).setCommitTime(timestamp);
            return this;
        }

        public Builder setStreamId(String str) {
            a();
            ((WriteResponse) this.a).setStreamId(str);
            return this;
        }

        public Builder setStreamIdBytes(ByteString byteString) {
            a();
            ((WriteResponse) this.a).setStreamIdBytes(byteString);
            return this;
        }

        public Builder setStreamToken(ByteString byteString) {
            a();
            ((WriteResponse) this.a).setStreamToken(byteString);
            return this;
        }

        public Builder setWriteResults(int i, WriteResult.Builder builder) {
            a();
            ((WriteResponse) this.a).setWriteResults(i, builder);
            return this;
        }

        public Builder setWriteResults(int i, WriteResult writeResult) {
            a();
            ((WriteResponse) this.a).setWriteResults(i, writeResult);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private WriteResponse() {
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
    public void clearStreamId() {
        this.streamId_ = getDefaultInstance().getStreamId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamToken() {
        this.streamToken_ = getDefaultInstance().getStreamToken();
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

    public static WriteResponse getDefaultInstance() {
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

    public static Builder newBuilder(WriteResponse writeResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) writeResponse);
    }

    public static WriteResponse parseDelimitedFrom(InputStream inputStream) {
        return (WriteResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(ByteString byteString) {
        return (WriteResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static WriteResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(CodedInputStream codedInputStream) {
        return (WriteResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(InputStream inputStream) {
        return (WriteResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(byte[] bArr) {
        return (WriteResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static WriteResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<WriteResponse> parser() {
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
    public void setStreamId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.streamId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.streamId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamToken(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.streamToken_ = byteString;
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
                return new WriteResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writeResults_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                WriteResponse writeResponse = (WriteResponse) obj2;
                this.streamId_ = visitor.visitString(!this.streamId_.isEmpty(), this.streamId_, !writeResponse.streamId_.isEmpty(), writeResponse.streamId_);
                this.streamToken_ = visitor.visitByteString(this.streamToken_ != ByteString.EMPTY, this.streamToken_, writeResponse.streamToken_ != ByteString.EMPTY, writeResponse.streamToken_);
                this.writeResults_ = visitor.visitList(this.writeResults_, writeResponse.writeResults_);
                this.commitTime_ = (Timestamp) visitor.visitMessage(this.commitTime_, writeResponse.commitTime_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= writeResponse.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r0) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.streamId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.streamToken_ = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                if (!this.writeResults_.isModifiable()) {
                                    this.writeResults_ = GeneratedMessageLite.a(this.writeResults_);
                                }
                                this.writeResults_.add((WriteResult) codedInputStream.readMessage(WriteResult.parser(), extensionRegistryLite));
                            } else if (readTag == 34) {
                                Timestamp.Builder builder = this.commitTime_ != null ? this.commitTime_.toBuilder() : null;
                                this.commitTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Timestamp.Builder) this.commitTime_);
                                    this.commitTime_ = builder.buildPartial();
                                }
                            } else if (!codedInputStream.skipField(readTag)) {
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
                    synchronized (WriteResponse.class) {
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

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
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
        int computeStringSize = !this.streamId_.isEmpty() ? CodedOutputStream.computeStringSize(1, getStreamId()) + 0 : 0;
        if (!this.streamToken_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeBytesSize(2, this.streamToken_);
        }
        for (int i2 = 0; i2 < this.writeResults_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.writeResults_.get(i2));
        }
        if (this.commitTime_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, getCommitTime());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public String getStreamId() {
        return this.streamId_;
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public ByteString getStreamIdBytes() {
        return ByteString.copyFromUtf8(this.streamId_);
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public ByteString getStreamToken() {
        return this.streamToken_;
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public WriteResult getWriteResults(int i) {
        return this.writeResults_.get(i);
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public int getWriteResultsCount() {
        return this.writeResults_.size();
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public List<WriteResult> getWriteResultsList() {
        return this.writeResults_;
    }

    public WriteResultOrBuilder getWriteResultsOrBuilder(int i) {
        return this.writeResults_.get(i);
    }

    public List<? extends WriteResultOrBuilder> getWriteResultsOrBuilderList() {
        return this.writeResults_;
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public boolean hasCommitTime() {
        return this.commitTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.streamId_.isEmpty()) {
            codedOutputStream.writeString(1, getStreamId());
        }
        if (!this.streamToken_.isEmpty()) {
            codedOutputStream.writeBytes(2, this.streamToken_);
        }
        for (int i = 0; i < this.writeResults_.size(); i++) {
            codedOutputStream.writeMessage(3, this.writeResults_.get(i));
        }
        if (this.commitTime_ != null) {
            codedOutputStream.writeMessage(4, getCommitTime());
        }
    }
}
