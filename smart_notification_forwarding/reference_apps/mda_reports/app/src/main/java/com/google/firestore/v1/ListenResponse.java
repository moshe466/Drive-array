package com.google.firestore.v1;

import com.google.firestore.v1.DocumentChange;
import com.google.firestore.v1.DocumentDelete;
import com.google.firestore.v1.DocumentRemove;
import com.google.firestore.v1.ExistenceFilter;
import com.google.firestore.v1.TargetChange;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class ListenResponse extends GeneratedMessageLite<ListenResponse, Builder> implements ListenResponseOrBuilder {
    private static final ListenResponse DEFAULT_INSTANCE = new ListenResponse();
    public static final int DOCUMENT_CHANGE_FIELD_NUMBER = 3;
    public static final int DOCUMENT_DELETE_FIELD_NUMBER = 4;
    public static final int DOCUMENT_REMOVE_FIELD_NUMBER = 6;
    public static final int FILTER_FIELD_NUMBER = 5;
    private static volatile Parser<ListenResponse> PARSER = null;
    public static final int TARGET_CHANGE_FIELD_NUMBER = 2;
    private int responseTypeCase_ = 0;
    private Object responseType_;

    /* renamed from: com.google.firestore.v1.ListenResponse$1, reason: invalid class name */
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
            a = new int[ResponseTypeCase.values().length];
            try {
                a[ResponseTypeCase.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ResponseTypeCase.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ResponseTypeCase.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ResponseTypeCase.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[ResponseTypeCase.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[ResponseTypeCase.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListenResponse, Builder> implements ListenResponseOrBuilder {
        private Builder() {
            super(ListenResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocumentChange() {
            a();
            ((ListenResponse) this.a).clearDocumentChange();
            return this;
        }

        public Builder clearDocumentDelete() {
            a();
            ((ListenResponse) this.a).clearDocumentDelete();
            return this;
        }

        public Builder clearDocumentRemove() {
            a();
            ((ListenResponse) this.a).clearDocumentRemove();
            return this;
        }

        public Builder clearFilter() {
            a();
            ((ListenResponse) this.a).clearFilter();
            return this;
        }

        public Builder clearResponseType() {
            a();
            ((ListenResponse) this.a).clearResponseType();
            return this;
        }

        public Builder clearTargetChange() {
            a();
            ((ListenResponse) this.a).clearTargetChange();
            return this;
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public DocumentChange getDocumentChange() {
            return ((ListenResponse) this.a).getDocumentChange();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public DocumentDelete getDocumentDelete() {
            return ((ListenResponse) this.a).getDocumentDelete();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public DocumentRemove getDocumentRemove() {
            return ((ListenResponse) this.a).getDocumentRemove();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public ExistenceFilter getFilter() {
            return ((ListenResponse) this.a).getFilter();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public ResponseTypeCase getResponseTypeCase() {
            return ((ListenResponse) this.a).getResponseTypeCase();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public TargetChange getTargetChange() {
            return ((ListenResponse) this.a).getTargetChange();
        }

        public Builder mergeDocumentChange(DocumentChange documentChange) {
            a();
            ((ListenResponse) this.a).mergeDocumentChange(documentChange);
            return this;
        }

        public Builder mergeDocumentDelete(DocumentDelete documentDelete) {
            a();
            ((ListenResponse) this.a).mergeDocumentDelete(documentDelete);
            return this;
        }

        public Builder mergeDocumentRemove(DocumentRemove documentRemove) {
            a();
            ((ListenResponse) this.a).mergeDocumentRemove(documentRemove);
            return this;
        }

        public Builder mergeFilter(ExistenceFilter existenceFilter) {
            a();
            ((ListenResponse) this.a).mergeFilter(existenceFilter);
            return this;
        }

        public Builder mergeTargetChange(TargetChange targetChange) {
            a();
            ((ListenResponse) this.a).mergeTargetChange(targetChange);
            return this;
        }

        public Builder setDocumentChange(DocumentChange.Builder builder) {
            a();
            ((ListenResponse) this.a).setDocumentChange(builder);
            return this;
        }

        public Builder setDocumentChange(DocumentChange documentChange) {
            a();
            ((ListenResponse) this.a).setDocumentChange(documentChange);
            return this;
        }

        public Builder setDocumentDelete(DocumentDelete.Builder builder) {
            a();
            ((ListenResponse) this.a).setDocumentDelete(builder);
            return this;
        }

        public Builder setDocumentDelete(DocumentDelete documentDelete) {
            a();
            ((ListenResponse) this.a).setDocumentDelete(documentDelete);
            return this;
        }

        public Builder setDocumentRemove(DocumentRemove.Builder builder) {
            a();
            ((ListenResponse) this.a).setDocumentRemove(builder);
            return this;
        }

        public Builder setDocumentRemove(DocumentRemove documentRemove) {
            a();
            ((ListenResponse) this.a).setDocumentRemove(documentRemove);
            return this;
        }

        public Builder setFilter(ExistenceFilter.Builder builder) {
            a();
            ((ListenResponse) this.a).setFilter(builder);
            return this;
        }

        public Builder setFilter(ExistenceFilter existenceFilter) {
            a();
            ((ListenResponse) this.a).setFilter(existenceFilter);
            return this;
        }

        public Builder setTargetChange(TargetChange.Builder builder) {
            a();
            ((ListenResponse) this.a).setTargetChange(builder);
            return this;
        }

        public Builder setTargetChange(TargetChange targetChange) {
            a();
            ((ListenResponse) this.a).setTargetChange(targetChange);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ResponseTypeCase implements Internal.EnumLite {
        TARGET_CHANGE(2),
        DOCUMENT_CHANGE(3),
        DOCUMENT_DELETE(4),
        DOCUMENT_REMOVE(6),
        FILTER(5),
        RESPONSETYPE_NOT_SET(0);

        private final int value;

        ResponseTypeCase(int i) {
            this.value = i;
        }

        public static ResponseTypeCase forNumber(int i) {
            if (i == 0) {
                return RESPONSETYPE_NOT_SET;
            }
            if (i == 2) {
                return TARGET_CHANGE;
            }
            if (i == 3) {
                return DOCUMENT_CHANGE;
            }
            if (i == 4) {
                return DOCUMENT_DELETE;
            }
            if (i == 5) {
                return FILTER;
            }
            if (i != 6) {
                return null;
            }
            return DOCUMENT_REMOVE;
        }

        @Deprecated
        public static ResponseTypeCase valueOf(int i) {
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

    private ListenResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentChange() {
        if (this.responseTypeCase_ == 3) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentDelete() {
        if (this.responseTypeCase_ == 4) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentRemove() {
        if (this.responseTypeCase_ == 6) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilter() {
        if (this.responseTypeCase_ == 5) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseType() {
        this.responseTypeCase_ = 0;
        this.responseType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetChange() {
        if (this.responseTypeCase_ == 2) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    public static ListenResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocumentChange(DocumentChange documentChange) {
        if (this.responseTypeCase_ == 3 && this.responseType_ != DocumentChange.getDefaultInstance()) {
            documentChange = DocumentChange.newBuilder((DocumentChange) this.responseType_).mergeFrom((DocumentChange.Builder) documentChange).buildPartial();
        }
        this.responseType_ = documentChange;
        this.responseTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocumentDelete(DocumentDelete documentDelete) {
        if (this.responseTypeCase_ == 4 && this.responseType_ != DocumentDelete.getDefaultInstance()) {
            documentDelete = DocumentDelete.newBuilder((DocumentDelete) this.responseType_).mergeFrom((DocumentDelete.Builder) documentDelete).buildPartial();
        }
        this.responseType_ = documentDelete;
        this.responseTypeCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocumentRemove(DocumentRemove documentRemove) {
        if (this.responseTypeCase_ == 6 && this.responseType_ != DocumentRemove.getDefaultInstance()) {
            documentRemove = DocumentRemove.newBuilder((DocumentRemove) this.responseType_).mergeFrom((DocumentRemove.Builder) documentRemove).buildPartial();
        }
        this.responseType_ = documentRemove;
        this.responseTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFilter(ExistenceFilter existenceFilter) {
        if (this.responseTypeCase_ == 5 && this.responseType_ != ExistenceFilter.getDefaultInstance()) {
            existenceFilter = ExistenceFilter.newBuilder((ExistenceFilter) this.responseType_).mergeFrom((ExistenceFilter.Builder) existenceFilter).buildPartial();
        }
        this.responseType_ = existenceFilter;
        this.responseTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTargetChange(TargetChange targetChange) {
        if (this.responseTypeCase_ == 2 && this.responseType_ != TargetChange.getDefaultInstance()) {
            targetChange = TargetChange.newBuilder((TargetChange) this.responseType_).mergeFrom((TargetChange.Builder) targetChange).buildPartial();
        }
        this.responseType_ = targetChange;
        this.responseTypeCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListenResponse listenResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) listenResponse);
    }

    public static ListenResponse parseDelimitedFrom(InputStream inputStream) {
        return (ListenResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ListenResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(ByteString byteString) {
        return (ListenResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ListenResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(CodedInputStream codedInputStream) {
        return (ListenResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListenResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(InputStream inputStream) {
        return (ListenResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ListenResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(byte[] bArr) {
        return (ListenResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ListenResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListenResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListenResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentChange(DocumentChange.Builder builder) {
        this.responseType_ = builder.build();
        this.responseTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentChange(DocumentChange documentChange) {
        if (documentChange == null) {
            throw new NullPointerException();
        }
        this.responseType_ = documentChange;
        this.responseTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentDelete(DocumentDelete.Builder builder) {
        this.responseType_ = builder.build();
        this.responseTypeCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentDelete(DocumentDelete documentDelete) {
        if (documentDelete == null) {
            throw new NullPointerException();
        }
        this.responseType_ = documentDelete;
        this.responseTypeCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentRemove(DocumentRemove.Builder builder) {
        this.responseType_ = builder.build();
        this.responseTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentRemove(DocumentRemove documentRemove) {
        if (documentRemove == null) {
            throw new NullPointerException();
        }
        this.responseType_ = documentRemove;
        this.responseTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilter(ExistenceFilter.Builder builder) {
        this.responseType_ = builder.build();
        this.responseTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilter(ExistenceFilter existenceFilter) {
        if (existenceFilter == null) {
            throw new NullPointerException();
        }
        this.responseType_ = existenceFilter;
        this.responseTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetChange(TargetChange.Builder builder) {
        this.responseType_ = builder.build();
        this.responseTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetChange(TargetChange targetChange) {
        if (targetChange == null) {
            throw new NullPointerException();
        }
        this.responseType_ = targetChange;
        this.responseTypeCase_ = 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0183, code lost:
    
        if (r9.responseTypeCase_ == 5) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x019a, code lost:
    
        r9.responseType_ = r11.visitOneofMessage(r5, r9.responseType_, r12.responseType_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0199, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0188, code lost:
    
        if (r9.responseTypeCase_ == 6) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x018d, code lost:
    
        if (r9.responseTypeCase_ == 4) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0192, code lost:
    
        if (r9.responseTypeCase_ == 3) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0197, code lost:
    
        if (r9.responseTypeCase_ == 2) goto L111;
     */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r10, java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.ListenResponse.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public DocumentChange getDocumentChange() {
        return this.responseTypeCase_ == 3 ? (DocumentChange) this.responseType_ : DocumentChange.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public DocumentDelete getDocumentDelete() {
        return this.responseTypeCase_ == 4 ? (DocumentDelete) this.responseType_ : DocumentDelete.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public DocumentRemove getDocumentRemove() {
        return this.responseTypeCase_ == 6 ? (DocumentRemove) this.responseType_ : DocumentRemove.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public ExistenceFilter getFilter() {
        return this.responseTypeCase_ == 5 ? (ExistenceFilter) this.responseType_ : ExistenceFilter.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public ResponseTypeCase getResponseTypeCase() {
        return ResponseTypeCase.forNumber(this.responseTypeCase_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.responseTypeCase_ == 2 ? 0 + CodedOutputStream.computeMessageSize(2, (TargetChange) this.responseType_) : 0;
        if (this.responseTypeCase_ == 3) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, (DocumentChange) this.responseType_);
        }
        if (this.responseTypeCase_ == 4) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, (DocumentDelete) this.responseType_);
        }
        if (this.responseTypeCase_ == 5) {
            computeMessageSize += CodedOutputStream.computeMessageSize(5, (ExistenceFilter) this.responseType_);
        }
        if (this.responseTypeCase_ == 6) {
            computeMessageSize += CodedOutputStream.computeMessageSize(6, (DocumentRemove) this.responseType_);
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public TargetChange getTargetChange() {
        return this.responseTypeCase_ == 2 ? (TargetChange) this.responseType_ : TargetChange.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.responseTypeCase_ == 2) {
            codedOutputStream.writeMessage(2, (TargetChange) this.responseType_);
        }
        if (this.responseTypeCase_ == 3) {
            codedOutputStream.writeMessage(3, (DocumentChange) this.responseType_);
        }
        if (this.responseTypeCase_ == 4) {
            codedOutputStream.writeMessage(4, (DocumentDelete) this.responseType_);
        }
        if (this.responseTypeCase_ == 5) {
            codedOutputStream.writeMessage(5, (ExistenceFilter) this.responseType_);
        }
        if (this.responseTypeCase_ == 6) {
            codedOutputStream.writeMessage(6, (DocumentRemove) this.responseType_);
        }
    }
}
