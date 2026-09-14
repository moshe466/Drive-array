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
public final class GetDocumentRequest extends GeneratedMessageLite<GetDocumentRequest, Builder> implements GetDocumentRequestOrBuilder {
    private static final GetDocumentRequest DEFAULT_INSTANCE = new GetDocumentRequest();
    public static final int MASK_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<GetDocumentRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 5;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private Object consistencySelector_;
    private DocumentMask mask_;
    private int consistencySelectorCase_ = 0;
    private String name_ = "";

    /* renamed from: com.google.firestore.v1.GetDocumentRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<GetDocumentRequest, Builder> implements GetDocumentRequestOrBuilder {
        private Builder() {
            super(GetDocumentRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConsistencySelector() {
            a();
            ((GetDocumentRequest) this.a).clearConsistencySelector();
            return this;
        }

        public Builder clearMask() {
            a();
            ((GetDocumentRequest) this.a).clearMask();
            return this;
        }

        public Builder clearName() {
            a();
            ((GetDocumentRequest) this.a).clearName();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((GetDocumentRequest) this.a).clearReadTime();
            return this;
        }

        public Builder clearTransaction() {
            a();
            ((GetDocumentRequest) this.a).clearTransaction();
            return this;
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((GetDocumentRequest) this.a).getConsistencySelectorCase();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public DocumentMask getMask() {
            return ((GetDocumentRequest) this.a).getMask();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public String getName() {
            return ((GetDocumentRequest) this.a).getName();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public ByteString getNameBytes() {
            return ((GetDocumentRequest) this.a).getNameBytes();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public Timestamp getReadTime() {
            return ((GetDocumentRequest) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public ByteString getTransaction() {
            return ((GetDocumentRequest) this.a).getTransaction();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public boolean hasMask() {
            return ((GetDocumentRequest) this.a).hasMask();
        }

        public Builder mergeMask(DocumentMask documentMask) {
            a();
            ((GetDocumentRequest) this.a).mergeMask(documentMask);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((GetDocumentRequest) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder setMask(DocumentMask.Builder builder) {
            a();
            ((GetDocumentRequest) this.a).setMask(builder);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            a();
            ((GetDocumentRequest) this.a).setMask(documentMask);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((GetDocumentRequest) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((GetDocumentRequest) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((GetDocumentRequest) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((GetDocumentRequest) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            a();
            ((GetDocumentRequest) this.a).setTransaction(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(3),
        READ_TIME(5),
        CONSISTENCYSELECTOR_NOT_SET(0);

        private final int value;

        ConsistencySelectorCase(int i) {
            this.value = i;
        }

        public static ConsistencySelectorCase forNumber(int i) {
            if (i == 0) {
                return CONSISTENCYSELECTOR_NOT_SET;
            }
            if (i == 3) {
                return TRANSACTION;
            }
            if (i != 5) {
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

    private GetDocumentRequest() {
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
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 3) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public static GetDocumentRequest getDefaultInstance() {
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
        if (this.consistencySelectorCase_ == 5 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 5;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GetDocumentRequest getDocumentRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) getDocumentRequest);
    }

    public static GetDocumentRequest parseDelimitedFrom(InputStream inputStream) {
        return (GetDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static GetDocumentRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(ByteString byteString) {
        return (GetDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static GetDocumentRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GetDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(CodedInputStream codedInputStream) {
        return (GetDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetDocumentRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(InputStream inputStream) {
        return (GetDocumentRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static GetDocumentRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetDocumentRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(byte[] bArr) {
        return (GetDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static GetDocumentRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GetDocumentRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<GetDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builder) {
        this.consistencySelector_ = builder.build();
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransaction(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.consistencySelectorCase_ = 3;
        this.consistencySelector_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Object visitOneofByteString;
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
            case 1:
                return new GetDocumentRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                GetDocumentRequest getDocumentRequest = (GetDocumentRequest) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !getDocumentRequest.name_.isEmpty(), getDocumentRequest.name_);
                this.mask_ = (DocumentMask) visitor.visitMessage(this.mask_, getDocumentRequest.mask_);
                int i2 = AnonymousClass1.a[getDocumentRequest.getConsistencySelectorCase().ordinal()];
                if (i2 == 1) {
                    visitOneofByteString = visitor.visitOneofByteString(this.consistencySelectorCase_ == 3, this.consistencySelector_, getDocumentRequest.consistencySelector_);
                } else {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            visitor.visitOneofNotSet(this.consistencySelectorCase_ != 0);
                        }
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = getDocumentRequest.consistencySelectorCase_) != 0) {
                            this.consistencySelectorCase_ = i;
                        }
                        return this;
                    }
                    visitOneofByteString = visitor.visitOneofMessage(this.consistencySelectorCase_ == 5, this.consistencySelector_, getDocumentRequest.consistencySelector_);
                }
                this.consistencySelector_ = visitOneofByteString;
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.consistencySelectorCase_ = i;
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
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                DocumentMask.Builder builder = this.mask_ != null ? this.mask_.toBuilder() : null;
                                this.mask_ = (DocumentMask) codedInputStream.readMessage(DocumentMask.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((DocumentMask.Builder) this.mask_);
                                    this.mask_ = builder.buildPartial();
                                }
                            } else if (readTag == 26) {
                                this.consistencySelectorCase_ = 3;
                                this.consistencySelector_ = codedInputStream.readBytes();
                            } else if (readTag == 42) {
                                Timestamp.Builder builder2 = this.consistencySelectorCase_ == 5 ? ((Timestamp) this.consistencySelector_).toBuilder() : null;
                                this.consistencySelector_ = codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((Timestamp.Builder) this.consistencySelector_);
                                    this.consistencySelector_ = builder2.buildPartial();
                                }
                                this.consistencySelectorCase_ = 5;
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
                    synchronized (GetDocumentRequest.class) {
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

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public Timestamp getReadTime() {
        return this.consistencySelectorCase_ == 5 ? (Timestamp) this.consistencySelector_ : Timestamp.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.name_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getName());
        if (this.mask_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getMask());
        }
        if (this.consistencySelectorCase_ == 3) {
            computeStringSize += CodedOutputStream.computeBytesSize(3, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 5) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, (Timestamp) this.consistencySelector_);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public ByteString getTransaction() {
        return this.consistencySelectorCase_ == 3 ? (ByteString) this.consistencySelector_ : ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public boolean hasMask() {
        return this.mask_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (this.mask_ != null) {
            codedOutputStream.writeMessage(2, getMask());
        }
        if (this.consistencySelectorCase_ == 3) {
            codedOutputStream.writeBytes(3, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 5) {
            codedOutputStream.writeMessage(5, (Timestamp) this.consistencySelector_);
        }
    }
}
