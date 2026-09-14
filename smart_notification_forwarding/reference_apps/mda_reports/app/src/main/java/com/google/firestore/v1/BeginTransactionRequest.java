package com.google.firestore.v1;

import com.google.firestore.v1.TransactionOptions;
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
public final class BeginTransactionRequest extends GeneratedMessageLite<BeginTransactionRequest, Builder> implements BeginTransactionRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final BeginTransactionRequest DEFAULT_INSTANCE = new BeginTransactionRequest();
    public static final int OPTIONS_FIELD_NUMBER = 2;
    private static volatile Parser<BeginTransactionRequest> PARSER;
    private String database_ = "";
    private TransactionOptions options_;

    /* renamed from: com.google.firestore.v1.BeginTransactionRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<BeginTransactionRequest, Builder> implements BeginTransactionRequestOrBuilder {
        private Builder() {
            super(BeginTransactionRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDatabase() {
            a();
            ((BeginTransactionRequest) this.a).clearDatabase();
            return this;
        }

        public Builder clearOptions() {
            a();
            ((BeginTransactionRequest) this.a).clearOptions();
            return this;
        }

        @Override // com.google.firestore.v1.BeginTransactionRequestOrBuilder
        public String getDatabase() {
            return ((BeginTransactionRequest) this.a).getDatabase();
        }

        @Override // com.google.firestore.v1.BeginTransactionRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((BeginTransactionRequest) this.a).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.BeginTransactionRequestOrBuilder
        public TransactionOptions getOptions() {
            return ((BeginTransactionRequest) this.a).getOptions();
        }

        @Override // com.google.firestore.v1.BeginTransactionRequestOrBuilder
        public boolean hasOptions() {
            return ((BeginTransactionRequest) this.a).hasOptions();
        }

        public Builder mergeOptions(TransactionOptions transactionOptions) {
            a();
            ((BeginTransactionRequest) this.a).mergeOptions(transactionOptions);
            return this;
        }

        public Builder setDatabase(String str) {
            a();
            ((BeginTransactionRequest) this.a).setDatabase(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            a();
            ((BeginTransactionRequest) this.a).setDatabaseBytes(byteString);
            return this;
        }

        public Builder setOptions(TransactionOptions.Builder builder) {
            a();
            ((BeginTransactionRequest) this.a).setOptions(builder);
            return this;
        }

        public Builder setOptions(TransactionOptions transactionOptions) {
            a();
            ((BeginTransactionRequest) this.a).setOptions(transactionOptions);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private BeginTransactionRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDatabase() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = null;
    }

    public static BeginTransactionRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOptions(TransactionOptions transactionOptions) {
        TransactionOptions transactionOptions2 = this.options_;
        if (transactionOptions2 != null && transactionOptions2 != TransactionOptions.getDefaultInstance()) {
            transactionOptions = TransactionOptions.newBuilder(this.options_).mergeFrom((TransactionOptions.Builder) transactionOptions).buildPartial();
        }
        this.options_ = transactionOptions;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BeginTransactionRequest beginTransactionRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) beginTransactionRequest);
    }

    public static BeginTransactionRequest parseDelimitedFrom(InputStream inputStream) {
        return (BeginTransactionRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static BeginTransactionRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BeginTransactionRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BeginTransactionRequest parseFrom(ByteString byteString) {
        return (BeginTransactionRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static BeginTransactionRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BeginTransactionRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BeginTransactionRequest parseFrom(CodedInputStream codedInputStream) {
        return (BeginTransactionRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BeginTransactionRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BeginTransactionRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static BeginTransactionRequest parseFrom(InputStream inputStream) {
        return (BeginTransactionRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static BeginTransactionRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BeginTransactionRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BeginTransactionRequest parseFrom(byte[] bArr) {
        return (BeginTransactionRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static BeginTransactionRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BeginTransactionRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<BeginTransactionRequest> parser() {
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
    public void setOptions(TransactionOptions.Builder builder) {
        this.options_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(TransactionOptions transactionOptions) {
        if (transactionOptions == null) {
            throw new NullPointerException();
        }
        this.options_ = transactionOptions;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new BeginTransactionRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                BeginTransactionRequest beginTransactionRequest = (BeginTransactionRequest) obj2;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, true ^ beginTransactionRequest.database_.isEmpty(), beginTransactionRequest.database_);
                this.options_ = (TransactionOptions) visitor.visitMessage(this.options_, beginTransactionRequest.options_);
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
                                this.database_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                TransactionOptions.Builder builder = this.options_ != null ? this.options_.toBuilder() : null;
                                this.options_ = (TransactionOptions) codedInputStream.readMessage(TransactionOptions.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((TransactionOptions.Builder) this.options_);
                                    this.options_ = builder.buildPartial();
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
                    synchronized (BeginTransactionRequest.class) {
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

    @Override // com.google.firestore.v1.BeginTransactionRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.BeginTransactionRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.firestore.v1.BeginTransactionRequestOrBuilder
    public TransactionOptions getOptions() {
        TransactionOptions transactionOptions = this.options_;
        return transactionOptions == null ? TransactionOptions.getDefaultInstance() : transactionOptions;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.database_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getDatabase());
        if (this.options_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getOptions());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.BeginTransactionRequestOrBuilder
    public boolean hasOptions() {
        return this.options_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.database_.isEmpty()) {
            codedOutputStream.writeString(1, getDatabase());
        }
        if (this.options_ != null) {
            codedOutputStream.writeMessage(2, getOptions());
        }
    }
}
