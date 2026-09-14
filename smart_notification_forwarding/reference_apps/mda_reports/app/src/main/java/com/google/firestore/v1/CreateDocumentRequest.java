package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.protobuf.AbstractMessageLite;
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
public final class CreateDocumentRequest extends GeneratedMessageLite<CreateDocumentRequest, Builder> implements CreateDocumentRequestOrBuilder {
    public static final int COLLECTION_ID_FIELD_NUMBER = 2;
    private static final CreateDocumentRequest DEFAULT_INSTANCE = new CreateDocumentRequest();
    public static final int DOCUMENT_FIELD_NUMBER = 4;
    public static final int DOCUMENT_ID_FIELD_NUMBER = 3;
    public static final int MASK_FIELD_NUMBER = 5;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<CreateDocumentRequest> PARSER;
    private Document document_;
    private DocumentMask mask_;
    private String parent_ = "";
    private String collectionId_ = "";
    private String documentId_ = "";

    /* renamed from: com.google.firestore.v1.CreateDocumentRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<CreateDocumentRequest, Builder> implements CreateDocumentRequestOrBuilder {
        private Builder() {
            super(CreateDocumentRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCollectionId() {
            a();
            ((CreateDocumentRequest) this.a).clearCollectionId();
            return this;
        }

        public Builder clearDocument() {
            a();
            ((CreateDocumentRequest) this.a).clearDocument();
            return this;
        }

        public Builder clearDocumentId() {
            a();
            ((CreateDocumentRequest) this.a).clearDocumentId();
            return this;
        }

        public Builder clearMask() {
            a();
            ((CreateDocumentRequest) this.a).clearMask();
            return this;
        }

        public Builder clearParent() {
            a();
            ((CreateDocumentRequest) this.a).clearParent();
            return this;
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public String getCollectionId() {
            return ((CreateDocumentRequest) this.a).getCollectionId();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public ByteString getCollectionIdBytes() {
            return ((CreateDocumentRequest) this.a).getCollectionIdBytes();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public Document getDocument() {
            return ((CreateDocumentRequest) this.a).getDocument();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public String getDocumentId() {
            return ((CreateDocumentRequest) this.a).getDocumentId();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public ByteString getDocumentIdBytes() {
            return ((CreateDocumentRequest) this.a).getDocumentIdBytes();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public DocumentMask getMask() {
            return ((CreateDocumentRequest) this.a).getMask();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public String getParent() {
            return ((CreateDocumentRequest) this.a).getParent();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public ByteString getParentBytes() {
            return ((CreateDocumentRequest) this.a).getParentBytes();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public boolean hasDocument() {
            return ((CreateDocumentRequest) this.a).hasDocument();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public boolean hasMask() {
            return ((CreateDocumentRequest) this.a).hasMask();
        }

        public Builder mergeDocument(Document document) {
            a();
            ((CreateDocumentRequest) this.a).mergeDocument(document);
            return this;
        }

        public Builder mergeMask(DocumentMask documentMask) {
            a();
            ((CreateDocumentRequest) this.a).mergeMask(documentMask);
            return this;
        }

        public Builder setCollectionId(String str) {
            a();
            ((CreateDocumentRequest) this.a).setCollectionId(str);
            return this;
        }

        public Builder setCollectionIdBytes(ByteString byteString) {
            a();
            ((CreateDocumentRequest) this.a).setCollectionIdBytes(byteString);
            return this;
        }

        public Builder setDocument(Document.Builder builder) {
            a();
            ((CreateDocumentRequest) this.a).setDocument(builder);
            return this;
        }

        public Builder setDocument(Document document) {
            a();
            ((CreateDocumentRequest) this.a).setDocument(document);
            return this;
        }

        public Builder setDocumentId(String str) {
            a();
            ((CreateDocumentRequest) this.a).setDocumentId(str);
            return this;
        }

        public Builder setDocumentIdBytes(ByteString byteString) {
            a();
            ((CreateDocumentRequest) this.a).setDocumentIdBytes(byteString);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builder) {
            a();
            ((CreateDocumentRequest) this.a).setMask(builder);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            a();
            ((CreateDocumentRequest) this.a).setMask(documentMask);
            return this;
        }

        public Builder setParent(String str) {
            a();
            ((CreateDocumentRequest) this.a).setParent(str);
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            a();
            ((CreateDocumentRequest) this.a).setParentBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private CreateDocumentRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCollectionId() {
        this.collectionId_ = getDefaultInstance().getCollectionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentId() {
        this.documentId_ = getDefaultInstance().getDocumentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMask() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParent() {
        this.parent_ = getDefaultInstance().getParent();
    }

    public static CreateDocumentRequest getDefaultInstance() {
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
    public void mergeMask(DocumentMask documentMask) {
        DocumentMask documentMask2 = this.mask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            documentMask = DocumentMask.newBuilder(this.mask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        }
        this.mask_ = documentMask;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CreateDocumentRequest createDocumentRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) createDocumentRequest);
    }

    public static CreateDocumentRequest parseDelimitedFrom(InputStream inputStream) {
        return (CreateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static CreateDocumentRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CreateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(ByteString byteString) {
        return (CreateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static CreateDocumentRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CreateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(CodedInputStream codedInputStream) {
        return (CreateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CreateDocumentRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CreateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(InputStream inputStream) {
        return (CreateDocumentRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static CreateDocumentRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CreateDocumentRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(byte[] bArr) {
        return (CreateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static CreateDocumentRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CreateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<CreateDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCollectionId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.collectionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCollectionIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.collectionId_ = byteString.toStringUtf8();
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
    public void setDocumentId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.documentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.documentId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMask(DocumentMask.Builder builder) {
        this.mask_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMask(DocumentMask documentMask) {
        if (documentMask == null) {
            throw new NullPointerException();
        }
        this.mask_ = documentMask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParent(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.parent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParentBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.parent_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new CreateDocumentRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CreateDocumentRequest createDocumentRequest = (CreateDocumentRequest) obj2;
                this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !createDocumentRequest.parent_.isEmpty(), createDocumentRequest.parent_);
                this.collectionId_ = visitor.visitString(!this.collectionId_.isEmpty(), this.collectionId_, !createDocumentRequest.collectionId_.isEmpty(), createDocumentRequest.collectionId_);
                this.documentId_ = visitor.visitString(!this.documentId_.isEmpty(), this.documentId_, true ^ createDocumentRequest.documentId_.isEmpty(), createDocumentRequest.documentId_);
                this.document_ = (Document) visitor.visitMessage(this.document_, createDocumentRequest.document_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, createDocumentRequest.mask_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                this.parent_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.collectionId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.documentId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                Document.Builder builder = this.document_ != null ? this.document_.toBuilder() : null;
                                this.document_ = (Document) codedInputStream.readMessage(Document.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Document.Builder) this.document_);
                                    this.document_ = builder.buildPartial();
                                }
                            } else if (readTag == 42) {
                                DocumentMask.Builder builder2 = this.mask_ != null ? this.mask_.toBuilder() : null;
                                this.mask_ = (DocumentMask) codedInputStream.readMessage(DocumentMask.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((DocumentMask.Builder) this.mask_);
                                    this.mask_ = builder2.buildPartial();
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
                    synchronized (CreateDocumentRequest.class) {
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

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public String getCollectionId() {
        return this.collectionId_;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public ByteString getCollectionIdBytes() {
        return ByteString.copyFromUtf8(this.collectionId_);
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public Document getDocument() {
        Document document = this.document_;
        return document == null ? Document.getDefaultInstance() : document;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public String getDocumentId() {
        return this.documentId_;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public ByteString getDocumentIdBytes() {
        return ByteString.copyFromUtf8(this.documentId_);
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public String getParent() {
        return this.parent_;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.parent_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getParent());
        if (!this.collectionId_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getCollectionId());
        }
        if (!this.documentId_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getDocumentId());
        }
        if (this.document_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, getDocument());
        }
        if (this.mask_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, getMask());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public boolean hasDocument() {
        return this.document_ != null;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public boolean hasMask() {
        return this.mask_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.parent_.isEmpty()) {
            codedOutputStream.writeString(1, getParent());
        }
        if (!this.collectionId_.isEmpty()) {
            codedOutputStream.writeString(2, getCollectionId());
        }
        if (!this.documentId_.isEmpty()) {
            codedOutputStream.writeString(3, getDocumentId());
        }
        if (this.document_ != null) {
            codedOutputStream.writeMessage(4, getDocument());
        }
        if (this.mask_ != null) {
            codedOutputStream.writeMessage(5, getMask());
        }
    }
}
