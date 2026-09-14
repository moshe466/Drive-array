package com.google.firestore.v1;

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
public final class RollbackRequest extends GeneratedMessageLite<RollbackRequest, Builder> implements RollbackRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final RollbackRequest DEFAULT_INSTANCE = new RollbackRequest();
    private static volatile Parser<RollbackRequest> PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 2;
    private String database_ = "";
    private ByteString transaction_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.RollbackRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<RollbackRequest, Builder> implements RollbackRequestOrBuilder {
        private Builder() {
            super(RollbackRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDatabase() {
            a();
            ((RollbackRequest) this.a).clearDatabase();
            return this;
        }

        public Builder clearTransaction() {
            a();
            ((RollbackRequest) this.a).clearTransaction();
            return this;
        }

        @Override // com.google.firestore.v1.RollbackRequestOrBuilder
        public String getDatabase() {
            return ((RollbackRequest) this.a).getDatabase();
        }

        @Override // com.google.firestore.v1.RollbackRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((RollbackRequest) this.a).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.RollbackRequestOrBuilder
        public ByteString getTransaction() {
            return ((RollbackRequest) this.a).getTransaction();
        }

        public Builder setDatabase(String str) {
            a();
            ((RollbackRequest) this.a).setDatabase(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            a();
            ((RollbackRequest) this.a).setDatabaseBytes(byteString);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            a();
            ((RollbackRequest) this.a).setTransaction(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private RollbackRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDatabase() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransaction() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    public static RollbackRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RollbackRequest rollbackRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) rollbackRequest);
    }

    public static RollbackRequest parseDelimitedFrom(InputStream inputStream) {
        return (RollbackRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static RollbackRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RollbackRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RollbackRequest parseFrom(ByteString byteString) {
        return (RollbackRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static RollbackRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RollbackRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RollbackRequest parseFrom(CodedInputStream codedInputStream) {
        return (RollbackRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RollbackRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RollbackRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static RollbackRequest parseFrom(InputStream inputStream) {
        return (RollbackRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static RollbackRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RollbackRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RollbackRequest parseFrom(byte[] bArr) {
        return (RollbackRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static RollbackRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RollbackRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<RollbackRequest> parser() {
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
                return new RollbackRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                RollbackRequest rollbackRequest = (RollbackRequest) obj2;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, !rollbackRequest.database_.isEmpty(), rollbackRequest.database_);
                this.transaction_ = visitor.visitByteString(this.transaction_ != ByteString.EMPTY, this.transaction_, rollbackRequest.transaction_ != ByteString.EMPTY, rollbackRequest.transaction_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.database_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.transaction_ = codedInputStream.readBytes();
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        r1 = true;
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
                    synchronized (RollbackRequest.class) {
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

    @Override // com.google.firestore.v1.RollbackRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.RollbackRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.database_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getDatabase());
        if (!this.transaction_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeBytesSize(2, this.transaction_);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.RollbackRequestOrBuilder
    public ByteString getTransaction() {
        return this.transaction_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.database_.isEmpty()) {
            codedOutputStream.writeString(1, getDatabase());
        }
        if (this.transaction_.isEmpty()) {
            return;
        }
        codedOutputStream.writeBytes(2, this.transaction_);
    }
}
