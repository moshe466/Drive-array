package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
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

/* loaded from: classes2.dex */
public final class RunQueryRequest extends GeneratedMessageLite<RunQueryRequest, Builder> implements RunQueryRequestOrBuilder {
    private static final RunQueryRequest DEFAULT_INSTANCE = new RunQueryRequest();
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 6;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<RunQueryRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    public static final int TRANSACTION_FIELD_NUMBER = 5;
    private Object consistencySelector_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private int consistencySelectorCase_ = 0;
    private String parent_ = "";

    /* renamed from: com.google.firestore.v1.RunQueryRequest$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                c[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            b = new int[ConsistencySelectorCase.values().length];
            try {
                b[ConsistencySelectorCase.TRANSACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[ConsistencySelectorCase.NEW_TRANSACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[ConsistencySelectorCase.READ_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            a = new int[QueryTypeCase.values().length];
            try {
                a[QueryTypeCase.STRUCTURED_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[QueryTypeCase.QUERYTYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RunQueryRequest, Builder> implements RunQueryRequestOrBuilder {
        private Builder() {
            super(RunQueryRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConsistencySelector() {
            a();
            ((RunQueryRequest) this.a).clearConsistencySelector();
            return this;
        }

        public Builder clearNewTransaction() {
            a();
            ((RunQueryRequest) this.a).clearNewTransaction();
            return this;
        }

        public Builder clearParent() {
            a();
            ((RunQueryRequest) this.a).clearParent();
            return this;
        }

        public Builder clearQueryType() {
            a();
            ((RunQueryRequest) this.a).clearQueryType();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((RunQueryRequest) this.a).clearReadTime();
            return this;
        }

        public Builder clearStructuredQuery() {
            a();
            ((RunQueryRequest) this.a).clearStructuredQuery();
            return this;
        }

        public Builder clearTransaction() {
            a();
            ((RunQueryRequest) this.a).clearTransaction();
            return this;
        }

        @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((RunQueryRequest) this.a).getConsistencySelectorCase();
        }

        @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
        public TransactionOptions getNewTransaction() {
            return ((RunQueryRequest) this.a).getNewTransaction();
        }

        @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
        public String getParent() {
            return ((RunQueryRequest) this.a).getParent();
        }

        @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
        public ByteString getParentBytes() {
            return ((RunQueryRequest) this.a).getParentBytes();
        }

        @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
        public QueryTypeCase getQueryTypeCase() {
            return ((RunQueryRequest) this.a).getQueryTypeCase();
        }

        @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
        public Timestamp getReadTime() {
            return ((RunQueryRequest) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
        public StructuredQuery getStructuredQuery() {
            return ((RunQueryRequest) this.a).getStructuredQuery();
        }

        @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
        public ByteString getTransaction() {
            return ((RunQueryRequest) this.a).getTransaction();
        }

        public Builder mergeNewTransaction(TransactionOptions transactionOptions) {
            a();
            ((RunQueryRequest) this.a).mergeNewTransaction(transactionOptions);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((RunQueryRequest) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder mergeStructuredQuery(StructuredQuery structuredQuery) {
            a();
            ((RunQueryRequest) this.a).mergeStructuredQuery(structuredQuery);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions.Builder builder) {
            a();
            ((RunQueryRequest) this.a).setNewTransaction(builder);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions transactionOptions) {
            a();
            ((RunQueryRequest) this.a).setNewTransaction(transactionOptions);
            return this;
        }

        public Builder setParent(String str) {
            a();
            ((RunQueryRequest) this.a).setParent(str);
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            a();
            ((RunQueryRequest) this.a).setParentBytes(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((RunQueryRequest) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((RunQueryRequest) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setStructuredQuery(StructuredQuery.Builder builder) {
            a();
            ((RunQueryRequest) this.a).setStructuredQuery(builder);
            return this;
        }

        public Builder setStructuredQuery(StructuredQuery structuredQuery) {
            a();
            ((RunQueryRequest) this.a).setStructuredQuery(structuredQuery);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            a();
            ((RunQueryRequest) this.a).setTransaction(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(5),
        NEW_TRANSACTION(6),
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
            if (i == 5) {
                return TRANSACTION;
            }
            if (i == 6) {
                return NEW_TRANSACTION;
            }
            if (i != 7) {
                return null;
            }
            return READ_TIME;
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

    /* loaded from: classes2.dex */
    public enum QueryTypeCase implements Internal.EnumLite {
        STRUCTURED_QUERY(2),
        QUERYTYPE_NOT_SET(0);

        private final int value;

        QueryTypeCase(int i) {
            this.value = i;
        }

        public static QueryTypeCase forNumber(int i) {
            if (i == 0) {
                return QUERYTYPE_NOT_SET;
            }
            if (i != 2) {
                return null;
            }
            return STRUCTURED_QUERY;
        }

        @Deprecated
        public static QueryTypeCase valueOf(int i) {
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

    private RunQueryRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConsistencySelector() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNewTransaction() {
        if (this.consistencySelectorCase_ == 6) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParent() {
        this.parent_ = getDefaultInstance().getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQueryType() {
        this.queryTypeCase_ = 0;
        this.queryType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        if (this.consistencySelectorCase_ == 7) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStructuredQuery() {
        if (this.queryTypeCase_ == 2) {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public static RunQueryRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeNewTransaction(TransactionOptions transactionOptions) {
        if (this.consistencySelectorCase_ == 6 && this.consistencySelector_ != TransactionOptions.getDefaultInstance()) {
            transactionOptions = TransactionOptions.newBuilder((TransactionOptions) this.consistencySelector_).mergeFrom((TransactionOptions.Builder) transactionOptions).buildPartial();
        }
        this.consistencySelector_ = transactionOptions;
        this.consistencySelectorCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        if (this.consistencySelectorCase_ == 7 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStructuredQuery(StructuredQuery structuredQuery) {
        if (this.queryTypeCase_ == 2 && this.queryType_ != StructuredQuery.getDefaultInstance()) {
            structuredQuery = StructuredQuery.newBuilder((StructuredQuery) this.queryType_).mergeFrom((StructuredQuery.Builder) structuredQuery).buildPartial();
        }
        this.queryType_ = structuredQuery;
        this.queryTypeCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RunQueryRequest runQueryRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) runQueryRequest);
    }

    public static RunQueryRequest parseDelimitedFrom(InputStream inputStream) {
        return (RunQueryRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static RunQueryRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunQueryRequest parseFrom(ByteString byteString) {
        return (RunQueryRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static RunQueryRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RunQueryRequest parseFrom(CodedInputStream codedInputStream) {
        return (RunQueryRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RunQueryRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static RunQueryRequest parseFrom(InputStream inputStream) {
        return (RunQueryRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static RunQueryRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunQueryRequest parseFrom(byte[] bArr) {
        return (RunQueryRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static RunQueryRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RunQueryRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<RunQueryRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions.Builder builder) {
        this.consistencySelector_ = builder.build();
        this.consistencySelectorCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions transactionOptions) {
        if (transactionOptions == null) {
            throw new NullPointerException();
        }
        this.consistencySelector_ = transactionOptions;
        this.consistencySelectorCase_ = 6;
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
    public void setStructuredQuery(StructuredQuery.Builder builder) {
        this.queryType_ = builder.build();
        this.queryTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStructuredQuery(StructuredQuery structuredQuery) {
        if (structuredQuery == null) {
            throw new NullPointerException();
        }
        this.queryType_ = structuredQuery;
        this.queryTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransaction(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.consistencySelectorCase_ = 5;
        this.consistencySelector_ = byteString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0186, code lost:
    
        if (r9.consistencySelectorCase_ == 7) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x018e, code lost:
    
        r10 = r11.visitOneofMessage(r5, r9.consistencySelector_, r12.consistencySelector_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x018d, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x018b, code lost:
    
        if (r9.consistencySelectorCase_ == 6) goto L107;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01aa  */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r10, java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.RunQueryRequest.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
    public TransactionOptions getNewTransaction() {
        return this.consistencySelectorCase_ == 6 ? (TransactionOptions) this.consistencySelector_ : TransactionOptions.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
    public String getParent() {
        return this.parent_;
    }

    @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
    public QueryTypeCase getQueryTypeCase() {
        return QueryTypeCase.forNumber(this.queryTypeCase_);
    }

    @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
    public Timestamp getReadTime() {
        return this.consistencySelectorCase_ == 7 ? (Timestamp) this.consistencySelector_ : Timestamp.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.parent_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getParent());
        if (this.queryTypeCase_ == 2) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, (StructuredQuery) this.queryType_);
        }
        if (this.consistencySelectorCase_ == 5) {
            computeStringSize += CodedOutputStream.computeBytesSize(5, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 6) {
            computeStringSize += CodedOutputStream.computeMessageSize(6, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            computeStringSize += CodedOutputStream.computeMessageSize(7, (Timestamp) this.consistencySelector_);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
    public StructuredQuery getStructuredQuery() {
        return this.queryTypeCase_ == 2 ? (StructuredQuery) this.queryType_ : StructuredQuery.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.RunQueryRequestOrBuilder
    public ByteString getTransaction() {
        return this.consistencySelectorCase_ == 5 ? (ByteString) this.consistencySelector_ : ByteString.EMPTY;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.parent_.isEmpty()) {
            codedOutputStream.writeString(1, getParent());
        }
        if (this.queryTypeCase_ == 2) {
            codedOutputStream.writeMessage(2, (StructuredQuery) this.queryType_);
        }
        if (this.consistencySelectorCase_ == 5) {
            codedOutputStream.writeBytes(5, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 6) {
            codedOutputStream.writeMessage(6, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            codedOutputStream.writeMessage(7, (Timestamp) this.consistencySelector_);
        }
    }
}
