package com.google.firebase.firestore.proto;

import com.google.firebase.firestore.proto.NoDocument;
import com.google.firebase.firestore.proto.UnknownDocument;
import com.google.firestore.v1.Document;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class MaybeDocument extends GeneratedMessageLite<MaybeDocument, Builder> implements MaybeDocumentOrBuilder {
    private static final MaybeDocument DEFAULT_INSTANCE = new MaybeDocument();
    public static final int DOCUMENT_FIELD_NUMBER = 2;
    public static final int HAS_COMMITTED_MUTATIONS_FIELD_NUMBER = 4;
    public static final int NO_DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<MaybeDocument> PARSER = null;
    public static final int UNKNOWN_DOCUMENT_FIELD_NUMBER = 3;
    private int documentTypeCase_ = 0;
    private Object documentType_;
    private boolean hasCommittedMutations_;

    /* renamed from: com.google.firebase.firestore.proto.MaybeDocument$1, reason: invalid class name */
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
            a = new int[DocumentTypeCase.values().length];
            try {
                a[DocumentTypeCase.NO_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[DocumentTypeCase.DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[DocumentTypeCase.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[DocumentTypeCase.DOCUMENTTYPE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MaybeDocument, Builder> implements MaybeDocumentOrBuilder {
        private Builder() {
            super(MaybeDocument.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocument() {
            a();
            ((MaybeDocument) this.a).clearDocument();
            return this;
        }

        public Builder clearDocumentType() {
            a();
            ((MaybeDocument) this.a).clearDocumentType();
            return this;
        }

        public Builder clearHasCommittedMutations() {
            a();
            ((MaybeDocument) this.a).clearHasCommittedMutations();
            return this;
        }

        public Builder clearNoDocument() {
            a();
            ((MaybeDocument) this.a).clearNoDocument();
            return this;
        }

        public Builder clearUnknownDocument() {
            a();
            ((MaybeDocument) this.a).clearUnknownDocument();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
        public Document getDocument() {
            return ((MaybeDocument) this.a).getDocument();
        }

        @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
        public DocumentTypeCase getDocumentTypeCase() {
            return ((MaybeDocument) this.a).getDocumentTypeCase();
        }

        @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
        public boolean getHasCommittedMutations() {
            return ((MaybeDocument) this.a).getHasCommittedMutations();
        }

        @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
        public NoDocument getNoDocument() {
            return ((MaybeDocument) this.a).getNoDocument();
        }

        @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
        public UnknownDocument getUnknownDocument() {
            return ((MaybeDocument) this.a).getUnknownDocument();
        }

        public Builder mergeDocument(Document document) {
            a();
            ((MaybeDocument) this.a).mergeDocument(document);
            return this;
        }

        public Builder mergeNoDocument(NoDocument noDocument) {
            a();
            ((MaybeDocument) this.a).mergeNoDocument(noDocument);
            return this;
        }

        public Builder mergeUnknownDocument(UnknownDocument unknownDocument) {
            a();
            ((MaybeDocument) this.a).mergeUnknownDocument(unknownDocument);
            return this;
        }

        public Builder setDocument(Document.Builder builder) {
            a();
            ((MaybeDocument) this.a).setDocument(builder);
            return this;
        }

        public Builder setDocument(Document document) {
            a();
            ((MaybeDocument) this.a).setDocument(document);
            return this;
        }

        public Builder setHasCommittedMutations(boolean z) {
            a();
            ((MaybeDocument) this.a).setHasCommittedMutations(z);
            return this;
        }

        public Builder setNoDocument(NoDocument.Builder builder) {
            a();
            ((MaybeDocument) this.a).setNoDocument(builder);
            return this;
        }

        public Builder setNoDocument(NoDocument noDocument) {
            a();
            ((MaybeDocument) this.a).setNoDocument(noDocument);
            return this;
        }

        public Builder setUnknownDocument(UnknownDocument.Builder builder) {
            a();
            ((MaybeDocument) this.a).setUnknownDocument(builder);
            return this;
        }

        public Builder setUnknownDocument(UnknownDocument unknownDocument) {
            a();
            ((MaybeDocument) this.a).setUnknownDocument(unknownDocument);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum DocumentTypeCase implements Internal.EnumLite {
        NO_DOCUMENT(1),
        DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        DOCUMENTTYPE_NOT_SET(0);

        private final int value;

        DocumentTypeCase(int i) {
            this.value = i;
        }

        public static DocumentTypeCase forNumber(int i) {
            if (i == 0) {
                return DOCUMENTTYPE_NOT_SET;
            }
            if (i == 1) {
                return NO_DOCUMENT;
            }
            if (i == 2) {
                return DOCUMENT;
            }
            if (i != 3) {
                return null;
            }
            return UNKNOWN_DOCUMENT;
        }

        @Deprecated
        public static DocumentTypeCase valueOf(int i) {
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

    private MaybeDocument() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocument() {
        if (this.documentTypeCase_ == 2) {
            this.documentTypeCase_ = 0;
            this.documentType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentType() {
        this.documentTypeCase_ = 0;
        this.documentType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHasCommittedMutations() {
        this.hasCommittedMutations_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNoDocument() {
        if (this.documentTypeCase_ == 1) {
            this.documentTypeCase_ = 0;
            this.documentType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnknownDocument() {
        if (this.documentTypeCase_ == 3) {
            this.documentTypeCase_ = 0;
            this.documentType_ = null;
        }
    }

    public static MaybeDocument getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocument(Document document) {
        if (this.documentTypeCase_ == 2 && this.documentType_ != Document.getDefaultInstance()) {
            document = Document.newBuilder((Document) this.documentType_).mergeFrom((Document.Builder) document).buildPartial();
        }
        this.documentType_ = document;
        this.documentTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeNoDocument(NoDocument noDocument) {
        if (this.documentTypeCase_ == 1 && this.documentType_ != NoDocument.getDefaultInstance()) {
            noDocument = NoDocument.newBuilder((NoDocument) this.documentType_).mergeFrom((NoDocument.Builder) noDocument).buildPartial();
        }
        this.documentType_ = noDocument;
        this.documentTypeCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUnknownDocument(UnknownDocument unknownDocument) {
        if (this.documentTypeCase_ == 3 && this.documentType_ != UnknownDocument.getDefaultInstance()) {
            unknownDocument = UnknownDocument.newBuilder((UnknownDocument) this.documentType_).mergeFrom((UnknownDocument.Builder) unknownDocument).buildPartial();
        }
        this.documentType_ = unknownDocument;
        this.documentTypeCase_ = 3;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MaybeDocument maybeDocument) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) maybeDocument);
    }

    public static MaybeDocument parseDelimitedFrom(InputStream inputStream) {
        return (MaybeDocument) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static MaybeDocument parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MaybeDocument) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MaybeDocument parseFrom(ByteString byteString) {
        return (MaybeDocument) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static MaybeDocument parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MaybeDocument) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MaybeDocument parseFrom(CodedInputStream codedInputStream) {
        return (MaybeDocument) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MaybeDocument parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MaybeDocument) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MaybeDocument parseFrom(InputStream inputStream) {
        return (MaybeDocument) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static MaybeDocument parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MaybeDocument) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MaybeDocument parseFrom(byte[] bArr) {
        return (MaybeDocument) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static MaybeDocument parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MaybeDocument) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MaybeDocument> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocument(Document.Builder builder) {
        this.documentType_ = builder.build();
        this.documentTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocument(Document document) {
        if (document == null) {
            throw new NullPointerException();
        }
        this.documentType_ = document;
        this.documentTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHasCommittedMutations(boolean z) {
        this.hasCommittedMutations_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoDocument(NoDocument.Builder builder) {
        this.documentType_ = builder.build();
        this.documentTypeCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoDocument(NoDocument noDocument) {
        if (noDocument == null) {
            throw new NullPointerException();
        }
        this.documentType_ = noDocument;
        this.documentTypeCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnknownDocument(UnknownDocument.Builder builder) {
        this.documentType_ = builder.build();
        this.documentTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnknownDocument(UnknownDocument unknownDocument) {
        if (unknownDocument == null) {
            throw new NullPointerException();
        }
        this.documentType_ = unknownDocument;
        this.documentTypeCase_ = 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0139, code lost:
    
        if (r6.documentTypeCase_ == 3) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0146, code lost:
    
        r6.documentType_ = r8.visitOneofMessage(r2, r6.documentType_, r9.documentType_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0145, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x013e, code lost:
    
        if (r6.documentTypeCase_ == 2) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0143, code lost:
    
        if (r6.documentTypeCase_ == 1) goto L92;
     */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r7, java.lang.Object r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.proto.MaybeDocument.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
    public Document getDocument() {
        return this.documentTypeCase_ == 2 ? (Document) this.documentType_ : Document.getDefaultInstance();
    }

    @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
    public DocumentTypeCase getDocumentTypeCase() {
        return DocumentTypeCase.forNumber(this.documentTypeCase_);
    }

    @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
    public boolean getHasCommittedMutations() {
        return this.hasCommittedMutations_;
    }

    @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
    public NoDocument getNoDocument() {
        return this.documentTypeCase_ == 1 ? (NoDocument) this.documentType_ : NoDocument.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.documentTypeCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (NoDocument) this.documentType_) : 0;
        if (this.documentTypeCase_ == 2) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, (Document) this.documentType_);
        }
        if (this.documentTypeCase_ == 3) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, (UnknownDocument) this.documentType_);
        }
        boolean z = this.hasCommittedMutations_;
        if (z) {
            computeMessageSize += CodedOutputStream.computeBoolSize(4, z);
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firebase.firestore.proto.MaybeDocumentOrBuilder
    public UnknownDocument getUnknownDocument() {
        return this.documentTypeCase_ == 3 ? (UnknownDocument) this.documentType_ : UnknownDocument.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.documentTypeCase_ == 1) {
            codedOutputStream.writeMessage(1, (NoDocument) this.documentType_);
        }
        if (this.documentTypeCase_ == 2) {
            codedOutputStream.writeMessage(2, (Document) this.documentType_);
        }
        if (this.documentTypeCase_ == 3) {
            codedOutputStream.writeMessage(3, (UnknownDocument) this.documentType_);
        }
        boolean z = this.hasCommittedMutations_;
        if (z) {
            codedOutputStream.writeBool(4, z);
        }
    }
}
