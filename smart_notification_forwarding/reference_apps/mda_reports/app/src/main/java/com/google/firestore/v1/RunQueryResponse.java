package com.google.firestore.v1;

import com.google.firestore.v1.Document;
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
public final class RunQueryResponse extends GeneratedMessageLite<RunQueryResponse, Builder> implements RunQueryResponseOrBuilder {
    private static final RunQueryResponse DEFAULT_INSTANCE = new RunQueryResponse();
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<RunQueryResponse> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 3;
    public static final int SKIPPED_RESULTS_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 2;
    private Document document_;
    private Timestamp readTime_;
    private int skippedResults_;
    private ByteString transaction_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.RunQueryResponse$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<RunQueryResponse, Builder> implements RunQueryResponseOrBuilder {
        private Builder() {
            super(RunQueryResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocument() {
            a();
            ((RunQueryResponse) this.a).clearDocument();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((RunQueryResponse) this.a).clearReadTime();
            return this;
        }

        public Builder clearSkippedResults() {
            a();
            ((RunQueryResponse) this.a).clearSkippedResults();
            return this;
        }

        public Builder clearTransaction() {
            a();
            ((RunQueryResponse) this.a).clearTransaction();
            return this;
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public Document getDocument() {
            return ((RunQueryResponse) this.a).getDocument();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public Timestamp getReadTime() {
            return ((RunQueryResponse) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public int getSkippedResults() {
            return ((RunQueryResponse) this.a).getSkippedResults();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public ByteString getTransaction() {
            return ((RunQueryResponse) this.a).getTransaction();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public boolean hasDocument() {
            return ((RunQueryResponse) this.a).hasDocument();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public boolean hasReadTime() {
            return ((RunQueryResponse) this.a).hasReadTime();
        }

        public Builder mergeDocument(Document document) {
            a();
            ((RunQueryResponse) this.a).mergeDocument(document);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((RunQueryResponse) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder setDocument(Document.Builder builder) {
            a();
            ((RunQueryResponse) this.a).setDocument(builder);
            return this;
        }

        public Builder setDocument(Document document) {
            a();
            ((RunQueryResponse) this.a).setDocument(document);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((RunQueryResponse) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((RunQueryResponse) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setSkippedResults(int i) {
            a();
            ((RunQueryResponse) this.a).setSkippedResults(i);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            a();
            ((RunQueryResponse) this.a).setTransaction(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private RunQueryResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSkippedResults() {
        this.skippedResults_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransaction() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    public static RunQueryResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocument(Document document) {
        Document document2 = this.document_;
        if (document2 != null && document2 != Document.getDefaultInstance()) {
            document = Document.newBuilder(this.document_).mergeFrom((Document.Builder) document).buildPartial();
        }
        this.document_ = document;
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

    public static Builder newBuilder(RunQueryResponse runQueryResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) runQueryResponse);
    }

    public static RunQueryResponse parseDelimitedFrom(InputStream inputStream) {
        return (RunQueryResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static RunQueryResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(ByteString byteString) {
        return (RunQueryResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static RunQueryResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(CodedInputStream codedInputStream) {
        return (RunQueryResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RunQueryResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(InputStream inputStream) {
        return (RunQueryResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static RunQueryResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(byte[] bArr) {
        return (RunQueryResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static RunQueryResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<RunQueryResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocument(Document.Builder builder) {
        this.document_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocument(Document document) {
        if (document == null) {
            throw new NullPointerException();
        }
        this.document_ = document;
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
    public void setSkippedResults(int i) {
        this.skippedResults_ = i;
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
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new RunQueryResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                RunQueryResponse runQueryResponse = (RunQueryResponse) obj2;
                this.transaction_ = visitor.visitByteString(this.transaction_ != ByteString.EMPTY, this.transaction_, runQueryResponse.transaction_ != ByteString.EMPTY, runQueryResponse.transaction_);
                this.document_ = (Document) visitor.visitMessage(this.document_, runQueryResponse.document_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, runQueryResponse.readTime_);
                this.skippedResults_ = visitor.visitInt(this.skippedResults_ != 0, this.skippedResults_, runQueryResponse.skippedResults_ != 0, runQueryResponse.skippedResults_);
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
                                if (readTag == 10) {
                                    Document.Builder builder = this.document_ != null ? this.document_.toBuilder() : null;
                                    this.document_ = (Document) codedInputStream.readMessage(Document.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Document.Builder) this.document_);
                                        this.document_ = builder.buildPartial();
                                    }
                                } else if (readTag == 18) {
                                    this.transaction_ = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    Timestamp.Builder builder2 = this.readTime_ != null ? this.readTime_.toBuilder() : null;
                                    this.readTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((Timestamp.Builder) this.readTime_);
                                        this.readTime_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 32) {
                                    this.skippedResults_ = codedInputStream.readInt32();
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
                    synchronized (RunQueryResponse.class) {
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

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public Document getDocument() {
        Document document = this.document_;
        return document == null ? Document.getDefaultInstance() : document;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.document_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getDocument()) : 0;
        if (!this.transaction_.isEmpty()) {
            computeMessageSize += CodedOutputStream.computeBytesSize(2, this.transaction_);
        }
        if (this.readTime_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getReadTime());
        }
        int i2 = this.skippedResults_;
        if (i2 != 0) {
            computeMessageSize += CodedOutputStream.computeInt32Size(4, i2);
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public int getSkippedResults() {
        return this.skippedResults_;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public ByteString getTransaction() {
        return this.transaction_;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public boolean hasDocument() {
        return this.document_ != null;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public boolean hasReadTime() {
        return this.readTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.document_ != null) {
            codedOutputStream.writeMessage(1, getDocument());
        }
        if (!this.transaction_.isEmpty()) {
            codedOutputStream.writeBytes(2, this.transaction_);
        }
        if (this.readTime_ != null) {
            codedOutputStream.writeMessage(3, getReadTime());
        }
        int i = this.skippedResults_;
        if (i != 0) {
            codedOutputStream.writeInt32(4, i);
        }
    }
}
