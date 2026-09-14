package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.Precondition;
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
public final class UpdateDocumentRequest extends GeneratedMessageLite<UpdateDocumentRequest, Builder> implements UpdateDocumentRequestOrBuilder {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final UpdateDocumentRequest DEFAULT_INSTANCE = new UpdateDocumentRequest();
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int MASK_FIELD_NUMBER = 3;
    private static volatile Parser<UpdateDocumentRequest> PARSER = null;
    public static final int UPDATE_MASK_FIELD_NUMBER = 2;
    private Precondition currentDocument_;
    private Document document_;
    private DocumentMask mask_;
    private DocumentMask updateMask_;

    /* renamed from: com.google.firestore.v1.UpdateDocumentRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<UpdateDocumentRequest, Builder> implements UpdateDocumentRequestOrBuilder {
        private Builder() {
            super(UpdateDocumentRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCurrentDocument() {
            a();
            ((UpdateDocumentRequest) this.a).clearCurrentDocument();
            return this;
        }

        public Builder clearDocument() {
            a();
            ((UpdateDocumentRequest) this.a).clearDocument();
            return this;
        }

        public Builder clearMask() {
            a();
            ((UpdateDocumentRequest) this.a).clearMask();
            return this;
        }

        public Builder clearUpdateMask() {
            a();
            ((UpdateDocumentRequest) this.a).clearUpdateMask();
            return this;
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public Precondition getCurrentDocument() {
            return ((UpdateDocumentRequest) this.a).getCurrentDocument();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public Document getDocument() {
            return ((UpdateDocumentRequest) this.a).getDocument();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public DocumentMask getMask() {
            return ((UpdateDocumentRequest) this.a).getMask();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public DocumentMask getUpdateMask() {
            return ((UpdateDocumentRequest) this.a).getUpdateMask();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public boolean hasCurrentDocument() {
            return ((UpdateDocumentRequest) this.a).hasCurrentDocument();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public boolean hasDocument() {
            return ((UpdateDocumentRequest) this.a).hasDocument();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public boolean hasMask() {
            return ((UpdateDocumentRequest) this.a).hasMask();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public boolean hasUpdateMask() {
            return ((UpdateDocumentRequest) this.a).hasUpdateMask();
        }

        public Builder mergeCurrentDocument(Precondition precondition) {
            a();
            ((UpdateDocumentRequest) this.a).mergeCurrentDocument(precondition);
            return this;
        }

        public Builder mergeDocument(Document document) {
            a();
            ((UpdateDocumentRequest) this.a).mergeDocument(document);
            return this;
        }

        public Builder mergeMask(DocumentMask documentMask) {
            a();
            ((UpdateDocumentRequest) this.a).mergeMask(documentMask);
            return this;
        }

        public Builder mergeUpdateMask(DocumentMask documentMask) {
            a();
            ((UpdateDocumentRequest) this.a).mergeUpdateMask(documentMask);
            return this;
        }

        public Builder setCurrentDocument(Precondition.Builder builder) {
            a();
            ((UpdateDocumentRequest) this.a).setCurrentDocument(builder);
            return this;
        }

        public Builder setCurrentDocument(Precondition precondition) {
            a();
            ((UpdateDocumentRequest) this.a).setCurrentDocument(precondition);
            return this;
        }

        public Builder setDocument(Document.Builder builder) {
            a();
            ((UpdateDocumentRequest) this.a).setDocument(builder);
            return this;
        }

        public Builder setDocument(Document document) {
            a();
            ((UpdateDocumentRequest) this.a).setDocument(document);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builder) {
            a();
            ((UpdateDocumentRequest) this.a).setMask(builder);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            a();
            ((UpdateDocumentRequest) this.a).setMask(documentMask);
            return this;
        }

        public Builder setUpdateMask(DocumentMask.Builder builder) {
            a();
            ((UpdateDocumentRequest) this.a).setUpdateMask(builder);
            return this;
        }

        public Builder setUpdateMask(DocumentMask documentMask) {
            a();
            ((UpdateDocumentRequest) this.a).setUpdateMask(documentMask);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private UpdateDocumentRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurrentDocument() {
        this.currentDocument_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMask() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateMask() {
        this.updateMask_ = null;
    }

    public static UpdateDocumentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCurrentDocument(Precondition precondition) {
        Precondition precondition2 = this.currentDocument_;
        if (precondition2 != null && precondition2 != Precondition.getDefaultInstance()) {
            precondition = Precondition.newBuilder(this.currentDocument_).mergeFrom((Precondition.Builder) precondition).buildPartial();
        }
        this.currentDocument_ = precondition;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateMask(DocumentMask documentMask) {
        DocumentMask documentMask2 = this.updateMask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            documentMask = DocumentMask.newBuilder(this.updateMask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        }
        this.updateMask_ = documentMask;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UpdateDocumentRequest updateDocumentRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) updateDocumentRequest);
    }

    public static UpdateDocumentRequest parseDelimitedFrom(InputStream inputStream) {
        return (UpdateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateDocumentRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(ByteString byteString) {
        return (UpdateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static UpdateDocumentRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(CodedInputStream codedInputStream) {
        return (UpdateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UpdateDocumentRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(InputStream inputStream) {
        return (UpdateDocumentRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateDocumentRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateDocumentRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(byte[] bArr) {
        return (UpdateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateDocumentRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UpdateDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<UpdateDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentDocument(Precondition.Builder builder) {
        this.currentDocument_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentDocument(Precondition precondition) {
        if (precondition == null) {
            throw new NullPointerException();
        }
        this.currentDocument_ = precondition;
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
    public void setUpdateMask(DocumentMask.Builder builder) {
        this.updateMask_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateMask(DocumentMask documentMask) {
        if (documentMask == null) {
            throw new NullPointerException();
        }
        this.updateMask_ = documentMask;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new UpdateDocumentRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                UpdateDocumentRequest updateDocumentRequest = (UpdateDocumentRequest) obj2;
                this.document_ = (Document) visitor.visitMessage(this.document_, updateDocumentRequest.document_);
                this.updateMask_ = (DocumentMask) visitor.visitMessage(this.updateMask_, updateDocumentRequest.updateMask_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, updateDocumentRequest.mask_);
                this.currentDocument_ = (Precondition) visitor.visitMessage(this.currentDocument_, updateDocumentRequest.currentDocument_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
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
                                    DocumentMask.Builder builder2 = this.updateMask_ != null ? this.updateMask_.toBuilder() : null;
                                    this.updateMask_ = (DocumentMask) codedInputStream.readMessage(DocumentMask.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((DocumentMask.Builder) this.updateMask_);
                                        this.updateMask_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    DocumentMask.Builder builder3 = this.mask_ != null ? this.mask_.toBuilder() : null;
                                    this.mask_ = (DocumentMask) codedInputStream.readMessage(DocumentMask.parser(), extensionRegistryLite);
                                    if (builder3 != null) {
                                        builder3.mergeFrom((DocumentMask.Builder) this.mask_);
                                        this.mask_ = builder3.buildPartial();
                                    }
                                } else if (readTag == 34) {
                                    Precondition.Builder builder4 = this.currentDocument_ != null ? this.currentDocument_.toBuilder() : null;
                                    this.currentDocument_ = (Precondition) codedInputStream.readMessage(Precondition.parser(), extensionRegistryLite);
                                    if (builder4 != null) {
                                        builder4.mergeFrom((Precondition.Builder) this.currentDocument_);
                                        this.currentDocument_ = builder4.buildPartial();
                                    }
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
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
                    synchronized (UpdateDocumentRequest.class) {
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

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public Precondition getCurrentDocument() {
        Precondition precondition = this.currentDocument_;
        return precondition == null ? Precondition.getDefaultInstance() : precondition;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public Document getDocument() {
        Document document = this.document_;
        return document == null ? Document.getDefaultInstance() : document;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.document_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getDocument()) : 0;
        if (this.updateMask_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, getUpdateMask());
        }
        if (this.mask_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getMask());
        }
        if (this.currentDocument_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, getCurrentDocument());
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public DocumentMask getUpdateMask() {
        DocumentMask documentMask = this.updateMask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public boolean hasCurrentDocument() {
        return this.currentDocument_ != null;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public boolean hasDocument() {
        return this.document_ != null;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public boolean hasMask() {
        return this.mask_ != null;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public boolean hasUpdateMask() {
        return this.updateMask_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.document_ != null) {
            codedOutputStream.writeMessage(1, getDocument());
        }
        if (this.updateMask_ != null) {
            codedOutputStream.writeMessage(2, getUpdateMask());
        }
        if (this.mask_ != null) {
            codedOutputStream.writeMessage(3, getMask());
        }
        if (this.currentDocument_ != null) {
            codedOutputStream.writeMessage(4, getCurrentDocument());
        }
    }
}
