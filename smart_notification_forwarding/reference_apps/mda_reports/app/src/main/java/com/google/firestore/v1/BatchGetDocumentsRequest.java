package com.google.firestore.v1;

import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.TransactionOptions;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class BatchGetDocumentsRequest extends GeneratedMessageLite<BatchGetDocumentsRequest, Builder> implements BatchGetDocumentsRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final BatchGetDocumentsRequest DEFAULT_INSTANCE = new BatchGetDocumentsRequest();
    public static final int DOCUMENTS_FIELD_NUMBER = 2;
    public static final int MASK_FIELD_NUMBER = 3;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    private static volatile Parser<BatchGetDocumentsRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private int bitField0_;
    private Object consistencySelector_;
    private DocumentMask mask_;
    private int consistencySelectorCase_ = 0;
    private String database_ = "";
    private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.f();

    /* renamed from: com.google.firestore.v1.BatchGetDocumentsRequest$1, reason: invalid class name */
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
            a = new int[ConsistencySelectorCase.values().length];
            try {
                a[ConsistencySelectorCase.TRANSACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ConsistencySelectorCase.NEW_TRANSACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ConsistencySelectorCase.READ_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsRequest, Builder> implements BatchGetDocumentsRequestOrBuilder {
        private Builder() {
            super(BatchGetDocumentsRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllDocuments(Iterable<String> iterable) {
            a();
            ((BatchGetDocumentsRequest) this.a).addAllDocuments(iterable);
            return this;
        }

        public Builder addDocuments(String str) {
            a();
            ((BatchGetDocumentsRequest) this.a).addDocuments(str);
            return this;
        }

        public Builder addDocumentsBytes(ByteString byteString) {
            a();
            ((BatchGetDocumentsRequest) this.a).addDocumentsBytes(byteString);
            return this;
        }

        public Builder clearConsistencySelector() {
            a();
            ((BatchGetDocumentsRequest) this.a).clearConsistencySelector();
            return this;
        }

        public Builder clearDatabase() {
            a();
            ((BatchGetDocumentsRequest) this.a).clearDatabase();
            return this;
        }

        public Builder clearDocuments() {
            a();
            ((BatchGetDocumentsRequest) this.a).clearDocuments();
            return this;
        }

        public Builder clearMask() {
            a();
            ((BatchGetDocumentsRequest) this.a).clearMask();
            return this;
        }

        public Builder clearNewTransaction() {
            a();
            ((BatchGetDocumentsRequest) this.a).clearNewTransaction();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((BatchGetDocumentsRequest) this.a).clearReadTime();
            return this;
        }

        public Builder clearTransaction() {
            a();
            ((BatchGetDocumentsRequest) this.a).clearTransaction();
            return this;
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((BatchGetDocumentsRequest) this.a).getConsistencySelectorCase();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public String getDatabase() {
            return ((BatchGetDocumentsRequest) this.a).getDatabase();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((BatchGetDocumentsRequest) this.a).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public String getDocuments(int i) {
            return ((BatchGetDocumentsRequest) this.a).getDocuments(i);
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public ByteString getDocumentsBytes(int i) {
            return ((BatchGetDocumentsRequest) this.a).getDocumentsBytes(i);
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public int getDocumentsCount() {
            return ((BatchGetDocumentsRequest) this.a).getDocumentsCount();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public List<String> getDocumentsList() {
            return Collections.unmodifiableList(((BatchGetDocumentsRequest) this.a).getDocumentsList());
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public DocumentMask getMask() {
            return ((BatchGetDocumentsRequest) this.a).getMask();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public TransactionOptions getNewTransaction() {
            return ((BatchGetDocumentsRequest) this.a).getNewTransaction();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public Timestamp getReadTime() {
            return ((BatchGetDocumentsRequest) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public ByteString getTransaction() {
            return ((BatchGetDocumentsRequest) this.a).getTransaction();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public boolean hasMask() {
            return ((BatchGetDocumentsRequest) this.a).hasMask();
        }

        public Builder mergeMask(DocumentMask documentMask) {
            a();
            ((BatchGetDocumentsRequest) this.a).mergeMask(documentMask);
            return this;
        }

        public Builder mergeNewTransaction(TransactionOptions transactionOptions) {
            a();
            ((BatchGetDocumentsRequest) this.a).mergeNewTransaction(transactionOptions);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((BatchGetDocumentsRequest) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder setDatabase(String str) {
            a();
            ((BatchGetDocumentsRequest) this.a).setDatabase(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            a();
            ((BatchGetDocumentsRequest) this.a).setDatabaseBytes(byteString);
            return this;
        }

        public Builder setDocuments(int i, String str) {
            a();
            ((BatchGetDocumentsRequest) this.a).setDocuments(i, str);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builder) {
            a();
            ((BatchGetDocumentsRequest) this.a).setMask(builder);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            a();
            ((BatchGetDocumentsRequest) this.a).setMask(documentMask);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions.Builder builder) {
            a();
            ((BatchGetDocumentsRequest) this.a).setNewTransaction(builder);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions transactionOptions) {
            a();
            ((BatchGetDocumentsRequest) this.a).setNewTransaction(transactionOptions);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((BatchGetDocumentsRequest) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((BatchGetDocumentsRequest) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            a();
            ((BatchGetDocumentsRequest) this.a).setTransaction(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(4),
        NEW_TRANSACTION(5),
        READ_TIME(7),
        CONSISTENCYSELECTOR_NOT_SET(0);

        private final int value;

        ConsistencySelectorCase(int i) {
            this.value = i;
        }

        public static ConsistencySelectorCase forNumber(int i) {
            if (i == 0) {
                return CONSISTENCYSELECTOR_NOT_SET;
            }
            if (i == 7) {
                return READ_TIME;
            }
            if (i == 4) {
                return TRANSACTION;
            }
            if (i != 5) {
                return null;
            }
            return NEW_TRANSACTION;
        }

        @Deprecated
        public static ConsistencySelectorCase valueOf(int i) {
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

    private BatchGetDocumentsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDocuments(Iterable<String> iterable) {
        ensureDocumentsIsMutable();
        AbstractMessageLite.a(iterable, this.documents_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDocuments(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureDocumentsIsMutable();
        this.documents_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDocumentsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureDocumentsIsMutable();
        this.documents_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConsistencySelector() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDatabase() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocuments() {
        this.documents_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMask() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNewTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        if (this.consistencySelectorCase_ == 7) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 4) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    private void ensureDocumentsIsMutable() {
        if (this.documents_.isModifiable()) {
            return;
        }
        this.documents_ = GeneratedMessageLite.a(this.documents_);
    }

    public static BatchGetDocumentsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
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
    public void mergeNewTransaction(TransactionOptions transactionOptions) {
        if (this.consistencySelectorCase_ == 5 && this.consistencySelector_ != TransactionOptions.getDefaultInstance()) {
            transactionOptions = TransactionOptions.newBuilder((TransactionOptions) this.consistencySelector_).mergeFrom((TransactionOptions.Builder) transactionOptions).buildPartial();
        }
        this.consistencySelector_ = transactionOptions;
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        if (this.consistencySelectorCase_ == 7 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 7;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BatchGetDocumentsRequest batchGetDocumentsRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) batchGetDocumentsRequest);
    }

    public static BatchGetDocumentsRequest parseDelimitedFrom(InputStream inputStream) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(ByteString byteString) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static BatchGetDocumentsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(CodedInputStream codedInputStream) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BatchGetDocumentsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(InputStream inputStream) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(byte[] bArr) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static BatchGetDocumentsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<BatchGetDocumentsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDatabase(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.database_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDatabaseBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.database_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocuments(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureDocumentsIsMutable();
        this.documents_.set(i, str);
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
    public void setNewTransaction(TransactionOptions.Builder builder) {
        this.consistencySelector_ = builder.build();
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions transactionOptions) {
        if (transactionOptions == null) {
            throw new NullPointerException();
        }
        this.consistencySelector_ = transactionOptions;
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builder) {
        this.consistencySelector_ = builder.build();
        this.consistencySelectorCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransaction(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.consistencySelectorCase_ = 4;
        this.consistencySelector_ = byteString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x018b, code lost:
    
        if (r8.consistencySelectorCase_ == 7) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0193, code lost:
    
        r9 = r10.visitOneofMessage(r3, r8.consistencySelector_, r11.consistencySelector_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0192, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0190, code lost:
    
        if (r8.consistencySelectorCase_ == 5) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01af  */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r9, java.lang.Object r10, java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.BatchGetDocumentsRequest.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public String getDocuments(int i) {
        return this.documents_.get(i);
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public ByteString getDocumentsBytes(int i) {
        return ByteString.copyFromUtf8(this.documents_.get(i));
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public int getDocumentsCount() {
        return this.documents_.size();
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public List<String> getDocumentsList() {
        return this.documents_;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public TransactionOptions getNewTransaction() {
        return this.consistencySelectorCase_ == 5 ? (TransactionOptions) this.consistencySelector_ : TransactionOptions.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public Timestamp getReadTime() {
        return this.consistencySelectorCase_ == 7 ? (Timestamp) this.consistencySelector_ : Timestamp.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.database_.isEmpty() ? CodedOutputStream.computeStringSize(1, getDatabase()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.documents_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag(this.documents_.get(i3));
        }
        int size = computeStringSize + i2 + (getDocumentsList().size() * 1);
        if (this.mask_ != null) {
            size += CodedOutputStream.computeMessageSize(3, getMask());
        }
        if (this.consistencySelectorCase_ == 4) {
            size += CodedOutputStream.computeBytesSize(4, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 5) {
            size += CodedOutputStream.computeMessageSize(5, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            size += CodedOutputStream.computeMessageSize(7, (Timestamp) this.consistencySelector_);
        }
        this.c = size;
        return size;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public ByteString getTransaction() {
        return this.consistencySelectorCase_ == 4 ? (ByteString) this.consistencySelector_ : ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public boolean hasMask() {
        return this.mask_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.database_.isEmpty()) {
            codedOutputStream.writeString(1, getDatabase());
        }
        for (int i = 0; i < this.documents_.size(); i++) {
            codedOutputStream.writeString(2, this.documents_.get(i));
        }
        if (this.mask_ != null) {
            codedOutputStream.writeMessage(3, getMask());
        }
        if (this.consistencySelectorCase_ == 4) {
            codedOutputStream.writeBytes(4, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 5) {
            codedOutputStream.writeMessage(5, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            codedOutputStream.writeMessage(7, (Timestamp) this.consistencySelector_);
        }
    }
}
