package com.google.firestore.v1;

import com.google.firestore.v1.DocumentMask;
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
public final class ListDocumentsRequest extends GeneratedMessageLite<ListDocumentsRequest, Builder> implements ListDocumentsRequestOrBuilder {
    public static final int COLLECTION_ID_FIELD_NUMBER = 2;
    private static final ListDocumentsRequest DEFAULT_INSTANCE = new ListDocumentsRequest();
    public static final int MASK_FIELD_NUMBER = 7;
    public static final int ORDER_BY_FIELD_NUMBER = 6;
    public static final int PAGE_SIZE_FIELD_NUMBER = 3;
    public static final int PAGE_TOKEN_FIELD_NUMBER = 4;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<ListDocumentsRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 10;
    public static final int SHOW_MISSING_FIELD_NUMBER = 12;
    public static final int TRANSACTION_FIELD_NUMBER = 8;
    private Object consistencySelector_;
    private DocumentMask mask_;
    private int pageSize_;
    private boolean showMissing_;
    private int consistencySelectorCase_ = 0;
    private String parent_ = "";
    private String collectionId_ = "";
    private String pageToken_ = "";
    private String orderBy_ = "";

    /* renamed from: com.google.firestore.v1.ListDocumentsRequest$1, reason: invalid class name */
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
                a[ConsistencySelectorCase.READ_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsRequest, Builder> implements ListDocumentsRequestOrBuilder {
        private Builder() {
            super(ListDocumentsRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCollectionId() {
            a();
            ((ListDocumentsRequest) this.a).clearCollectionId();
            return this;
        }

        public Builder clearConsistencySelector() {
            a();
            ((ListDocumentsRequest) this.a).clearConsistencySelector();
            return this;
        }

        public Builder clearMask() {
            a();
            ((ListDocumentsRequest) this.a).clearMask();
            return this;
        }

        public Builder clearOrderBy() {
            a();
            ((ListDocumentsRequest) this.a).clearOrderBy();
            return this;
        }

        public Builder clearPageSize() {
            a();
            ((ListDocumentsRequest) this.a).clearPageSize();
            return this;
        }

        public Builder clearPageToken() {
            a();
            ((ListDocumentsRequest) this.a).clearPageToken();
            return this;
        }

        public Builder clearParent() {
            a();
            ((ListDocumentsRequest) this.a).clearParent();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((ListDocumentsRequest) this.a).clearReadTime();
            return this;
        }

        public Builder clearShowMissing() {
            a();
            ((ListDocumentsRequest) this.a).clearShowMissing();
            return this;
        }

        public Builder clearTransaction() {
            a();
            ((ListDocumentsRequest) this.a).clearTransaction();
            return this;
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public String getCollectionId() {
            return ((ListDocumentsRequest) this.a).getCollectionId();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getCollectionIdBytes() {
            return ((ListDocumentsRequest) this.a).getCollectionIdBytes();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((ListDocumentsRequest) this.a).getConsistencySelectorCase();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public DocumentMask getMask() {
            return ((ListDocumentsRequest) this.a).getMask();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public String getOrderBy() {
            return ((ListDocumentsRequest) this.a).getOrderBy();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getOrderByBytes() {
            return ((ListDocumentsRequest) this.a).getOrderByBytes();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public int getPageSize() {
            return ((ListDocumentsRequest) this.a).getPageSize();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public String getPageToken() {
            return ((ListDocumentsRequest) this.a).getPageToken();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getPageTokenBytes() {
            return ((ListDocumentsRequest) this.a).getPageTokenBytes();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public String getParent() {
            return ((ListDocumentsRequest) this.a).getParent();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getParentBytes() {
            return ((ListDocumentsRequest) this.a).getParentBytes();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public Timestamp getReadTime() {
            return ((ListDocumentsRequest) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public boolean getShowMissing() {
            return ((ListDocumentsRequest) this.a).getShowMissing();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getTransaction() {
            return ((ListDocumentsRequest) this.a).getTransaction();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public boolean hasMask() {
            return ((ListDocumentsRequest) this.a).hasMask();
        }

        public Builder mergeMask(DocumentMask documentMask) {
            a();
            ((ListDocumentsRequest) this.a).mergeMask(documentMask);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((ListDocumentsRequest) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder setCollectionId(String str) {
            a();
            ((ListDocumentsRequest) this.a).setCollectionId(str);
            return this;
        }

        public Builder setCollectionIdBytes(ByteString byteString) {
            a();
            ((ListDocumentsRequest) this.a).setCollectionIdBytes(byteString);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builder) {
            a();
            ((ListDocumentsRequest) this.a).setMask(builder);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            a();
            ((ListDocumentsRequest) this.a).setMask(documentMask);
            return this;
        }

        public Builder setOrderBy(String str) {
            a();
            ((ListDocumentsRequest) this.a).setOrderBy(str);
            return this;
        }

        public Builder setOrderByBytes(ByteString byteString) {
            a();
            ((ListDocumentsRequest) this.a).setOrderByBytes(byteString);
            return this;
        }

        public Builder setPageSize(int i) {
            a();
            ((ListDocumentsRequest) this.a).setPageSize(i);
            return this;
        }

        public Builder setPageToken(String str) {
            a();
            ((ListDocumentsRequest) this.a).setPageToken(str);
            return this;
        }

        public Builder setPageTokenBytes(ByteString byteString) {
            a();
            ((ListDocumentsRequest) this.a).setPageTokenBytes(byteString);
            return this;
        }

        public Builder setParent(String str) {
            a();
            ((ListDocumentsRequest) this.a).setParent(str);
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            a();
            ((ListDocumentsRequest) this.a).setParentBytes(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((ListDocumentsRequest) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((ListDocumentsRequest) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setShowMissing(boolean z) {
            a();
            ((ListDocumentsRequest) this.a).setShowMissing(z);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            a();
            ((ListDocumentsRequest) this.a).setTransaction(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(8),
        READ_TIME(10),
        CONSISTENCYSELECTOR_NOT_SET(0);

        private final int value;

        ConsistencySelectorCase(int i) {
            this.value = i;
        }

        public static ConsistencySelectorCase forNumber(int i) {
            if (i == 0) {
                return CONSISTENCYSELECTOR_NOT_SET;
            }
            if (i == 8) {
                return TRANSACTION;
            }
            if (i != 10) {
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

    static {
        DEFAULT_INSTANCE.b();
    }

    private ListDocumentsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCollectionId() {
        this.collectionId_ = getDefaultInstance().getCollectionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConsistencySelector() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMask() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOrderBy() {
        this.orderBy_ = getDefaultInstance().getOrderBy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageSize() {
        this.pageSize_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageToken() {
        this.pageToken_ = getDefaultInstance().getPageToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParent() {
        this.parent_ = getDefaultInstance().getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        if (this.consistencySelectorCase_ == 10) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearShowMissing() {
        this.showMissing_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 8) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public static ListDocumentsRequest getDefaultInstance() {
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
    public void mergeReadTime(Timestamp timestamp) {
        if (this.consistencySelectorCase_ == 10 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 10;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListDocumentsRequest listDocumentsRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) listDocumentsRequest);
    }

    public static ListDocumentsRequest parseDelimitedFrom(InputStream inputStream) {
        return (ListDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(ByteString byteString) {
        return (ListDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ListDocumentsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(CodedInputStream codedInputStream) {
        return (ListDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListDocumentsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(InputStream inputStream) {
        return (ListDocumentsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(byte[] bArr) {
        return (ListDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ListDocumentsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListDocumentsRequest> parser() {
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
    public void setOrderBy(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.orderBy_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrderByBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.orderBy_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageSize(int i) {
        this.pageSize_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageToken(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.pageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageTokenBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.pageToken_ = byteString.toStringUtf8();
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
        this.consistencySelectorCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowMissing(boolean z) {
        this.showMissing_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransaction(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.consistencySelectorCase_ = 8;
        this.consistencySelector_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Object visitOneofByteString;
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
            case 1:
                return new ListDocumentsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListDocumentsRequest listDocumentsRequest = (ListDocumentsRequest) obj2;
                this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !listDocumentsRequest.parent_.isEmpty(), listDocumentsRequest.parent_);
                this.collectionId_ = visitor.visitString(!this.collectionId_.isEmpty(), this.collectionId_, !listDocumentsRequest.collectionId_.isEmpty(), listDocumentsRequest.collectionId_);
                this.pageSize_ = visitor.visitInt(this.pageSize_ != 0, this.pageSize_, listDocumentsRequest.pageSize_ != 0, listDocumentsRequest.pageSize_);
                this.pageToken_ = visitor.visitString(!this.pageToken_.isEmpty(), this.pageToken_, !listDocumentsRequest.pageToken_.isEmpty(), listDocumentsRequest.pageToken_);
                this.orderBy_ = visitor.visitString(!this.orderBy_.isEmpty(), this.orderBy_, !listDocumentsRequest.orderBy_.isEmpty(), listDocumentsRequest.orderBy_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, listDocumentsRequest.mask_);
                boolean z = this.showMissing_;
                boolean z2 = listDocumentsRequest.showMissing_;
                this.showMissing_ = visitor.visitBoolean(z, z, z2, z2);
                int i2 = AnonymousClass1.a[listDocumentsRequest.getConsistencySelectorCase().ordinal()];
                if (i2 == 1) {
                    visitOneofByteString = visitor.visitOneofByteString(this.consistencySelectorCase_ == 8, this.consistencySelector_, listDocumentsRequest.consistencySelector_);
                } else {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            visitor.visitOneofNotSet(this.consistencySelectorCase_ != 0);
                        }
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = listDocumentsRequest.consistencySelectorCase_) != 0) {
                            this.consistencySelectorCase_ = i;
                        }
                        return this;
                    }
                    visitOneofByteString = visitor.visitOneofMessage(this.consistencySelectorCase_ == 10, this.consistencySelector_, listDocumentsRequest.consistencySelector_);
                }
                this.consistencySelector_ = visitOneofByteString;
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.consistencySelectorCase_ = i;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r3) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.parent_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.collectionId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.pageSize_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                this.pageToken_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 50) {
                                this.orderBy_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 58) {
                                DocumentMask.Builder builder = this.mask_ != null ? this.mask_.toBuilder() : null;
                                this.mask_ = (DocumentMask) codedInputStream.readMessage(DocumentMask.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((DocumentMask.Builder) this.mask_);
                                    this.mask_ = builder.buildPartial();
                                }
                            } else if (readTag == 66) {
                                this.consistencySelectorCase_ = 8;
                                this.consistencySelector_ = codedInputStream.readBytes();
                            } else if (readTag == 82) {
                                Timestamp.Builder builder2 = this.consistencySelectorCase_ == 10 ? ((Timestamp) this.consistencySelector_).toBuilder() : null;
                                this.consistencySelector_ = codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((Timestamp.Builder) this.consistencySelector_);
                                    this.consistencySelector_ = builder2.buildPartial();
                                }
                                this.consistencySelectorCase_ = 10;
                            } else if (readTag == 96) {
                                this.showMissing_ = codedInputStream.readBool();
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        r3 = true;
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
                    synchronized (ListDocumentsRequest.class) {
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

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public String getCollectionId() {
        return this.collectionId_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getCollectionIdBytes() {
        return ByteString.copyFromUtf8(this.collectionId_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public String getOrderBy() {
        return this.orderBy_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getOrderByBytes() {
        return ByteString.copyFromUtf8(this.orderBy_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public int getPageSize() {
        return this.pageSize_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public String getPageToken() {
        return this.pageToken_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getPageTokenBytes() {
        return ByteString.copyFromUtf8(this.pageToken_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public String getParent() {
        return this.parent_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public Timestamp getReadTime() {
        return this.consistencySelectorCase_ == 10 ? (Timestamp) this.consistencySelector_ : Timestamp.getDefaultInstance();
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
        int i2 = this.pageSize_;
        if (i2 != 0) {
            computeStringSize += CodedOutputStream.computeInt32Size(3, i2);
        }
        if (!this.pageToken_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(4, getPageToken());
        }
        if (!this.orderBy_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(6, getOrderBy());
        }
        if (this.mask_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(7, getMask());
        }
        if (this.consistencySelectorCase_ == 8) {
            computeStringSize += CodedOutputStream.computeBytesSize(8, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 10) {
            computeStringSize += CodedOutputStream.computeMessageSize(10, (Timestamp) this.consistencySelector_);
        }
        boolean z = this.showMissing_;
        if (z) {
            computeStringSize += CodedOutputStream.computeBoolSize(12, z);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public boolean getShowMissing() {
        return this.showMissing_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getTransaction() {
        return this.consistencySelectorCase_ == 8 ? (ByteString) this.consistencySelector_ : ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
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
        int i = this.pageSize_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        if (!this.pageToken_.isEmpty()) {
            codedOutputStream.writeString(4, getPageToken());
        }
        if (!this.orderBy_.isEmpty()) {
            codedOutputStream.writeString(6, getOrderBy());
        }
        if (this.mask_ != null) {
            codedOutputStream.writeMessage(7, getMask());
        }
        if (this.consistencySelectorCase_ == 8) {
            codedOutputStream.writeBytes(8, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 10) {
            codedOutputStream.writeMessage(10, (Timestamp) this.consistencySelector_);
        }
        boolean z = this.showMissing_;
        if (z) {
            codedOutputStream.writeBool(12, z);
        }
    }
}
