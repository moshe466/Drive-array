package com.google.firestore.v1;

import com.google.firestore.v1.Document;
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

/* loaded from: classes2.dex */
public final class BatchGetDocumentsResponse extends GeneratedMessageLite<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
    private static final BatchGetDocumentsResponse DEFAULT_INSTANCE = new BatchGetDocumentsResponse();
    public static final int FOUND_FIELD_NUMBER = 1;
    public static final int MISSING_FIELD_NUMBER = 2;
    private static volatile Parser<BatchGetDocumentsResponse> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private Timestamp readTime_;
    private Object result_;
    private int resultCase_ = 0;
    private ByteString transaction_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.BatchGetDocumentsResponse$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = new int[ResultCase.values().length];
            try {
                a[ResultCase.FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ResultCase.MISSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ResultCase.RESULT_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
        private Builder() {
            super(BatchGetDocumentsResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFound() {
            a();
            ((BatchGetDocumentsResponse) this.a).clearFound();
            return this;
        }

        public Builder clearMissing() {
            a();
            ((BatchGetDocumentsResponse) this.a).clearMissing();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((BatchGetDocumentsResponse) this.a).clearReadTime();
            return this;
        }

        public Builder clearResult() {
            a();
            ((BatchGetDocumentsResponse) this.a).clearResult();
            return this;
        }

        public Builder clearTransaction() {
            a();
            ((BatchGetDocumentsResponse) this.a).clearTransaction();
            return this;
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public Document getFound() {
            return ((BatchGetDocumentsResponse) this.a).getFound();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public String getMissing() {
            return ((BatchGetDocumentsResponse) this.a).getMissing();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public ByteString getMissingBytes() {
            return ((BatchGetDocumentsResponse) this.a).getMissingBytes();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public Timestamp getReadTime() {
            return ((BatchGetDocumentsResponse) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public ResultCase getResultCase() {
            return ((BatchGetDocumentsResponse) this.a).getResultCase();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public ByteString getTransaction() {
            return ((BatchGetDocumentsResponse) this.a).getTransaction();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public boolean hasReadTime() {
            return ((BatchGetDocumentsResponse) this.a).hasReadTime();
        }

        public Builder mergeFound(Document document) {
            a();
            ((BatchGetDocumentsResponse) this.a).mergeFound(document);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((BatchGetDocumentsResponse) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder setFound(Document.Builder builder) {
            a();
            ((BatchGetDocumentsResponse) this.a).setFound(builder);
            return this;
        }

        public Builder setFound(Document document) {
            a();
            ((BatchGetDocumentsResponse) this.a).setFound(document);
            return this;
        }

        public Builder setMissing(String str) {
            a();
            ((BatchGetDocumentsResponse) this.a).setMissing(str);
            return this;
        }

        public Builder setMissingBytes(ByteString byteString) {
            a();
            ((BatchGetDocumentsResponse) this.a).setMissingBytes(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((BatchGetDocumentsResponse) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((BatchGetDocumentsResponse) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            a();
            ((BatchGetDocumentsResponse) this.a).setTransaction(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ResultCase implements Internal.EnumLite {
        FOUND(1),
        MISSING(2),
        RESULT_NOT_SET(0);

        private final int value;

        ResultCase(int i) {
            this.value = i;
        }

        public static ResultCase forNumber(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 1) {
                return FOUND;
            }
            if (i != 2) {
                return null;
            }
            return MISSING;
        }

        @Deprecated
        public static ResultCase valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private BatchGetDocumentsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFound() {
        if (this.resultCase_ == 1) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMissing() {
        if (this.resultCase_ == 2) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransaction() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    public static BatchGetDocumentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFound(Document document) {
        if (this.resultCase_ == 1 && this.result_ != Document.getDefaultInstance()) {
            document = Document.newBuilder((Document) this.result_).mergeFrom((Document.Builder) document).buildPartial();
        }
        this.result_ = document;
        this.resultCase_ = 1;
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

    public static Builder newBuilder(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) batchGetDocumentsResponse);
    }

    public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream inputStream) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(ByteString byteString) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static BatchGetDocumentsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(CodedInputStream codedInputStream) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BatchGetDocumentsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(InputStream inputStream) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(byte[] bArr) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static BatchGetDocumentsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<BatchGetDocumentsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFound(Document.Builder builder) {
        this.result_ = builder.build();
        this.resultCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFound(Document document) {
        if (document == null) {
            throw new NullPointerException();
        }
        this.result_ = document;
        this.resultCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMissing(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.resultCase_ = 2;
        this.result_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMissingBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.resultCase_ = 2;
        this.result_ = byteString.toStringUtf8();
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
    public void setTransaction(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.transaction_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Object visitOneofMessage;
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
            case 1:
                return new BatchGetDocumentsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                BatchGetDocumentsResponse batchGetDocumentsResponse = (BatchGetDocumentsResponse) obj2;
                this.transaction_ = visitor.visitByteString(this.transaction_ != ByteString.EMPTY, this.transaction_, batchGetDocumentsResponse.transaction_ != ByteString.EMPTY, batchGetDocumentsResponse.transaction_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, batchGetDocumentsResponse.readTime_);
                int i2 = AnonymousClass1.a[batchGetDocumentsResponse.getResultCase().ordinal()];
                if (i2 == 1) {
                    visitOneofMessage = visitor.visitOneofMessage(this.resultCase_ == 1, this.result_, batchGetDocumentsResponse.result_);
                } else {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            visitor.visitOneofNotSet(this.resultCase_ != 0);
                        }
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = batchGetDocumentsResponse.resultCase_) != 0) {
                            this.resultCase_ = i;
                        }
                        return this;
                    }
                    visitOneofMessage = visitor.visitOneofString(this.resultCase_ == 2, this.result_, batchGetDocumentsResponse.result_);
                }
                this.result_ = visitOneofMessage;
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.resultCase_ = i;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r2) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                Document.Builder builder = this.resultCase_ == 1 ? ((Document) this.result_).toBuilder() : null;
                                this.result_ = codedInputStream.readMessage(Document.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Document.Builder) this.result_);
                                    this.result_ = builder.buildPartial();
                                }
                                this.resultCase_ = 1;
                            } else if (readTag == 18) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                this.resultCase_ = 2;
                                this.result_ = readStringRequireUtf8;
                            } else if (readTag == 26) {
                                this.transaction_ = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                Timestamp.Builder builder2 = this.readTime_ != null ? this.readTime_.toBuilder() : null;
                                this.readTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((Timestamp.Builder) this.readTime_);
                                    this.readTime_ = builder2.buildPartial();
                                }
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        r2 = true;
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
                    synchronized (BatchGetDocumentsResponse.class) {
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

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public Document getFound() {
        return this.resultCase_ == 1 ? (Document) this.result_ : Document.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public String getMissing() {
        return this.resultCase_ == 2 ? (String) this.result_ : "";
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public ByteString getMissingBytes() {
        return ByteString.copyFromUtf8(this.resultCase_ == 2 ? (String) this.result_ : "");
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.resultCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (Document) this.result_) : 0;
        if (this.resultCase_ == 2) {
            computeMessageSize += CodedOutputStream.computeStringSize(2, getMissing());
        }
        if (!this.transaction_.isEmpty()) {
            computeMessageSize += CodedOutputStream.computeBytesSize(3, this.transaction_);
        }
        if (this.readTime_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, getReadTime());
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public ByteString getTransaction() {
        return this.transaction_;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public boolean hasReadTime() {
        return this.readTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.resultCase_ == 1) {
            codedOutputStream.writeMessage(1, (Document) this.result_);
        }
        if (this.resultCase_ == 2) {
            codedOutputStream.writeString(2, getMissing());
        }
        if (!this.transaction_.isEmpty()) {
            codedOutputStream.writeBytes(3, this.transaction_);
        }
        if (this.readTime_ != null) {
            codedOutputStream.writeMessage(4, getReadTime());
        }
    }
}
