package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.Precondition;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class Write extends GeneratedMessageLite<Write, Builder> implements WriteOrBuilder {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final Write DEFAULT_INSTANCE = new Write();
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile Parser<Write> PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    private Precondition currentDocument_;
    private int operationCase_ = 0;
    private Object operation_;
    private DocumentMask updateMask_;

    /* renamed from: com.google.firestore.v1.Write$1, reason: invalid class name */
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
            a = new int[OperationCase.values().length];
            try {
                a[OperationCase.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[OperationCase.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[OperationCase.TRANSFORM.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[OperationCase.OPERATION_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Write, Builder> implements WriteOrBuilder {
        private Builder() {
            super(Write.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCurrentDocument() {
            a();
            ((Write) this.a).clearCurrentDocument();
            return this;
        }

        public Builder clearDelete() {
            a();
            ((Write) this.a).clearDelete();
            return this;
        }

        public Builder clearOperation() {
            a();
            ((Write) this.a).clearOperation();
            return this;
        }

        public Builder clearTransform() {
            a();
            ((Write) this.a).clearTransform();
            return this;
        }

        public Builder clearUpdate() {
            a();
            ((Write) this.a).clearUpdate();
            return this;
        }

        public Builder clearUpdateMask() {
            a();
            ((Write) this.a).clearUpdateMask();
            return this;
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public Precondition getCurrentDocument() {
            return ((Write) this.a).getCurrentDocument();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public String getDelete() {
            return ((Write) this.a).getDelete();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public ByteString getDeleteBytes() {
            return ((Write) this.a).getDeleteBytes();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public OperationCase getOperationCase() {
            return ((Write) this.a).getOperationCase();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public DocumentTransform getTransform() {
            return ((Write) this.a).getTransform();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public Document getUpdate() {
            return ((Write) this.a).getUpdate();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public DocumentMask getUpdateMask() {
            return ((Write) this.a).getUpdateMask();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public boolean hasCurrentDocument() {
            return ((Write) this.a).hasCurrentDocument();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public boolean hasUpdateMask() {
            return ((Write) this.a).hasUpdateMask();
        }

        public Builder mergeCurrentDocument(Precondition precondition) {
            a();
            ((Write) this.a).mergeCurrentDocument(precondition);
            return this;
        }

        public Builder mergeTransform(DocumentTransform documentTransform) {
            a();
            ((Write) this.a).mergeTransform(documentTransform);
            return this;
        }

        public Builder mergeUpdate(Document document) {
            a();
            ((Write) this.a).mergeUpdate(document);
            return this;
        }

        public Builder mergeUpdateMask(DocumentMask documentMask) {
            a();
            ((Write) this.a).mergeUpdateMask(documentMask);
            return this;
        }

        public Builder setCurrentDocument(Precondition.Builder builder) {
            a();
            ((Write) this.a).setCurrentDocument(builder);
            return this;
        }

        public Builder setCurrentDocument(Precondition precondition) {
            a();
            ((Write) this.a).setCurrentDocument(precondition);
            return this;
        }

        public Builder setDelete(String str) {
            a();
            ((Write) this.a).setDelete(str);
            return this;
        }

        public Builder setDeleteBytes(ByteString byteString) {
            a();
            ((Write) this.a).setDeleteBytes(byteString);
            return this;
        }

        public Builder setTransform(DocumentTransform.Builder builder) {
            a();
            ((Write) this.a).setTransform(builder);
            return this;
        }

        public Builder setTransform(DocumentTransform documentTransform) {
            a();
            ((Write) this.a).setTransform(documentTransform);
            return this;
        }

        public Builder setUpdate(Document.Builder builder) {
            a();
            ((Write) this.a).setUpdate(builder);
            return this;
        }

        public Builder setUpdate(Document document) {
            a();
            ((Write) this.a).setUpdate(document);
            return this;
        }

        public Builder setUpdateMask(DocumentMask.Builder builder) {
            a();
            ((Write) this.a).setUpdateMask(builder);
            return this;
        }

        public Builder setUpdateMask(DocumentMask documentMask) {
            a();
            ((Write) this.a).setUpdateMask(documentMask);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum OperationCase implements Internal.EnumLite {
        UPDATE(1),
        DELETE(2),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);

        private final int value;

        OperationCase(int i) {
            this.value = i;
        }

        public static OperationCase forNumber(int i) {
            if (i == 0) {
                return OPERATION_NOT_SET;
            }
            if (i == 1) {
                return UPDATE;
            }
            if (i == 2) {
                return DELETE;
            }
            if (i != 6) {
                return null;
            }
            return TRANSFORM;
        }

        @Deprecated
        public static OperationCase valueOf(int i) {
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

    private Write() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurrentDocument() {
        this.currentDocument_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDelete() {
        if (this.operationCase_ == 2) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOperation() {
        this.operationCase_ = 0;
        this.operation_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransform() {
        if (this.operationCase_ == 6) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdate() {
        if (this.operationCase_ == 1) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateMask() {
        this.updateMask_ = null;
    }

    public static Write getDefaultInstance() {
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
    public void mergeTransform(DocumentTransform documentTransform) {
        if (this.operationCase_ == 6 && this.operation_ != DocumentTransform.getDefaultInstance()) {
            documentTransform = DocumentTransform.newBuilder((DocumentTransform) this.operation_).mergeFrom((DocumentTransform.Builder) documentTransform).buildPartial();
        }
        this.operation_ = documentTransform;
        this.operationCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdate(Document document) {
        if (this.operationCase_ == 1 && this.operation_ != Document.getDefaultInstance()) {
            document = Document.newBuilder((Document) this.operation_).mergeFrom((Document.Builder) document).buildPartial();
        }
        this.operation_ = document;
        this.operationCase_ = 1;
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

    public static Builder newBuilder(Write write) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) write);
    }

    public static Write parseDelimitedFrom(InputStream inputStream) {
        return (Write) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Write parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Write) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Write parseFrom(ByteString byteString) {
        return (Write) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Write parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Write) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Write parseFrom(CodedInputStream codedInputStream) {
        return (Write) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Write parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Write) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Write parseFrom(InputStream inputStream) {
        return (Write) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Write parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Write) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Write parseFrom(byte[] bArr) {
        return (Write) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Write parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Write) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Write> parser() {
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
    public void setDelete(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.operationCase_ = 2;
        this.operation_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.operationCase_ = 2;
        this.operation_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransform(DocumentTransform.Builder builder) {
        this.operation_ = builder.build();
        this.operationCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransform(DocumentTransform documentTransform) {
        if (documentTransform == null) {
            throw new NullPointerException();
        }
        this.operation_ = documentTransform;
        this.operationCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdate(Document.Builder builder) {
        this.operation_ = builder.build();
        this.operationCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdate(Document document) {
        if (document == null) {
            throw new NullPointerException();
        }
        this.operation_ = document;
        this.operationCase_ = 1;
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

    /* JADX WARN: Code restructure failed: missing block: B:126:0x0178, code lost:
    
        if (r6.operationCase_ == 6) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x018e, code lost:
    
        r7 = r8.visitOneofMessage(r2, r6.operation_, r9.operation_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x018d, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x018b, code lost:
    
        if (r6.operationCase_ == 1) goto L102;
     */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r7, java.lang.Object r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Write.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public Precondition getCurrentDocument() {
        Precondition precondition = this.currentDocument_;
        return precondition == null ? Precondition.getDefaultInstance() : precondition;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public String getDelete() {
        return this.operationCase_ == 2 ? (String) this.operation_ : "";
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public ByteString getDeleteBytes() {
        return ByteString.copyFromUtf8(this.operationCase_ == 2 ? (String) this.operation_ : "");
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public OperationCase getOperationCase() {
        return OperationCase.forNumber(this.operationCase_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.operationCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (Document) this.operation_) : 0;
        if (this.operationCase_ == 2) {
            computeMessageSize += CodedOutputStream.computeStringSize(2, getDelete());
        }
        if (this.updateMask_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getUpdateMask());
        }
        if (this.currentDocument_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, getCurrentDocument());
        }
        if (this.operationCase_ == 6) {
            computeMessageSize += CodedOutputStream.computeMessageSize(6, (DocumentTransform) this.operation_);
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public DocumentTransform getTransform() {
        return this.operationCase_ == 6 ? (DocumentTransform) this.operation_ : DocumentTransform.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public Document getUpdate() {
        return this.operationCase_ == 1 ? (Document) this.operation_ : Document.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public DocumentMask getUpdateMask() {
        DocumentMask documentMask = this.updateMask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public boolean hasCurrentDocument() {
        return this.currentDocument_ != null;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public boolean hasUpdateMask() {
        return this.updateMask_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.operationCase_ == 1) {
            codedOutputStream.writeMessage(1, (Document) this.operation_);
        }
        if (this.operationCase_ == 2) {
            codedOutputStream.writeString(2, getDelete());
        }
        if (this.updateMask_ != null) {
            codedOutputStream.writeMessage(3, getUpdateMask());
        }
        if (this.currentDocument_ != null) {
            codedOutputStream.writeMessage(4, getCurrentDocument());
        }
        if (this.operationCase_ == 6) {
            codedOutputStream.writeMessage(6, (DocumentTransform) this.operation_);
        }
    }
}
