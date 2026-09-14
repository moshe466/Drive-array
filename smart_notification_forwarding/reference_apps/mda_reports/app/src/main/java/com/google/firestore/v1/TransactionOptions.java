package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class TransactionOptions extends GeneratedMessageLite<TransactionOptions, Builder> implements TransactionOptionsOrBuilder {
    private static final TransactionOptions DEFAULT_INSTANCE = new TransactionOptions();
    private static volatile Parser<TransactionOptions> PARSER = null;
    public static final int READ_ONLY_FIELD_NUMBER = 2;
    public static final int READ_WRITE_FIELD_NUMBER = 3;
    private int modeCase_ = 0;
    private Object mode_;

    /* renamed from: com.google.firestore.v1.TransactionOptions$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c = new int[ModeCase.values().length];

        static {
            try {
                c[ModeCase.READ_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[ModeCase.READ_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[ModeCase.MODE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            b = new int[ReadOnly.ConsistencySelectorCase.values().length];
            try {
                b[ReadOnly.ConsistencySelectorCase.READ_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[ReadOnly.ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            a = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<TransactionOptions, Builder> implements TransactionOptionsOrBuilder {
        private Builder() {
            super(TransactionOptions.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearMode() {
            a();
            ((TransactionOptions) this.a).clearMode();
            return this;
        }

        public Builder clearReadOnly() {
            a();
            ((TransactionOptions) this.a).clearReadOnly();
            return this;
        }

        public Builder clearReadWrite() {
            a();
            ((TransactionOptions) this.a).clearReadWrite();
            return this;
        }

        @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
        public ModeCase getModeCase() {
            return ((TransactionOptions) this.a).getModeCase();
        }

        @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
        public ReadOnly getReadOnly() {
            return ((TransactionOptions) this.a).getReadOnly();
        }

        @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
        public ReadWrite getReadWrite() {
            return ((TransactionOptions) this.a).getReadWrite();
        }

        public Builder mergeReadOnly(ReadOnly readOnly) {
            a();
            ((TransactionOptions) this.a).mergeReadOnly(readOnly);
            return this;
        }

        public Builder mergeReadWrite(ReadWrite readWrite) {
            a();
            ((TransactionOptions) this.a).mergeReadWrite(readWrite);
            return this;
        }

        public Builder setReadOnly(ReadOnly.Builder builder) {
            a();
            ((TransactionOptions) this.a).setReadOnly(builder);
            return this;
        }

        public Builder setReadOnly(ReadOnly readOnly) {
            a();
            ((TransactionOptions) this.a).setReadOnly(readOnly);
            return this;
        }

        public Builder setReadWrite(ReadWrite.Builder builder) {
            a();
            ((TransactionOptions) this.a).setReadWrite(builder);
            return this;
        }

        public Builder setReadWrite(ReadWrite readWrite) {
            a();
            ((TransactionOptions) this.a).setReadWrite(readWrite);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ModeCase implements Internal.EnumLite {
        READ_ONLY(2),
        READ_WRITE(3),
        MODE_NOT_SET(0);

        private final int value;

        ModeCase(int i) {
            this.value = i;
        }

        public static ModeCase forNumber(int i) {
            if (i == 0) {
                return MODE_NOT_SET;
            }
            if (i == 2) {
                return READ_ONLY;
            }
            if (i != 3) {
                return null;
            }
            return READ_WRITE;
        }

        @Deprecated
        public static ModeCase valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ReadOnly extends GeneratedMessageLite<ReadOnly, Builder> implements ReadOnlyOrBuilder {
        private static final ReadOnly DEFAULT_INSTANCE = new ReadOnly();
        private static volatile Parser<ReadOnly> PARSER = null;
        public static final int READ_TIME_FIELD_NUMBER = 2;
        private int consistencySelectorCase_ = 0;
        private Object consistencySelector_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadOnly, Builder> implements ReadOnlyOrBuilder {
            private Builder() {
                super(ReadOnly.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearConsistencySelector() {
                a();
                ((ReadOnly) this.a).clearConsistencySelector();
                return this;
            }

            public Builder clearReadTime() {
                a();
                ((ReadOnly) this.a).clearReadTime();
                return this;
            }

            @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
            public ConsistencySelectorCase getConsistencySelectorCase() {
                return ((ReadOnly) this.a).getConsistencySelectorCase();
            }

            @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
            public Timestamp getReadTime() {
                return ((ReadOnly) this.a).getReadTime();
            }

            public Builder mergeReadTime(Timestamp timestamp) {
                a();
                ((ReadOnly) this.a).mergeReadTime(timestamp);
                return this;
            }

            public Builder setReadTime(Timestamp.Builder builder) {
                a();
                ((ReadOnly) this.a).setReadTime(builder);
                return this;
            }

            public Builder setReadTime(Timestamp timestamp) {
                a();
                ((ReadOnly) this.a).setReadTime(timestamp);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum ConsistencySelectorCase implements Internal.EnumLite {
            READ_TIME(2),
            CONSISTENCYSELECTOR_NOT_SET(0);

            private final int value;

            ConsistencySelectorCase(int i) {
                this.value = i;
            }

            public static ConsistencySelectorCase forNumber(int i) {
                if (i == 0) {
                    return CONSISTENCYSELECTOR_NOT_SET;
                }
                if (i != 2) {
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

        private ReadOnly() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConsistencySelector() {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReadTime() {
            if (this.consistencySelectorCase_ == 2) {
                this.consistencySelectorCase_ = 0;
                this.consistencySelector_ = null;
            }
        }

        public static ReadOnly getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeReadTime(Timestamp timestamp) {
            if (this.consistencySelectorCase_ == 2 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
                timestamp = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
            }
            this.consistencySelector_ = timestamp;
            this.consistencySelectorCase_ = 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReadOnly readOnly) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) readOnly);
        }

        public static ReadOnly parseDelimitedFrom(InputStream inputStream) {
            return (ReadOnly) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadOnly parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadOnly) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(ByteString byteString) {
            return (ReadOnly) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ReadOnly parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadOnly) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(CodedInputStream codedInputStream) {
            return (ReadOnly) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadOnly parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadOnly) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(InputStream inputStream) {
            return (ReadOnly) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadOnly parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadOnly) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(byte[] bArr) {
            return (ReadOnly) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ReadOnly parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadOnly) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ReadOnly> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReadTime(Timestamp.Builder builder) {
            this.consistencySelector_ = builder.build();
            this.consistencySelectorCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReadTime(Timestamp timestamp) {
            if (timestamp == null) {
                throw new NullPointerException();
            }
            this.consistencySelector_ = timestamp;
            this.consistencySelectorCase_ = 2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadOnly();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ReadOnly readOnly = (ReadOnly) obj2;
                    int i2 = AnonymousClass1.b[readOnly.getConsistencySelectorCase().ordinal()];
                    if (i2 == 1) {
                        this.consistencySelector_ = visitor.visitOneofMessage(this.consistencySelectorCase_ == 2, this.consistencySelector_, readOnly.consistencySelector_);
                    } else if (i2 == 2) {
                        visitor.visitOneofNotSet(this.consistencySelectorCase_ != 0);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = readOnly.consistencySelectorCase_) != 0) {
                        this.consistencySelectorCase_ = i;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 18) {
                                    Timestamp.Builder builder = this.consistencySelectorCase_ == 2 ? ((Timestamp) this.consistencySelector_).toBuilder() : null;
                                    this.consistencySelector_ = codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Timestamp.Builder) this.consistencySelector_);
                                        this.consistencySelector_ = builder.buildPartial();
                                    }
                                    this.consistencySelectorCase_ = 2;
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r0 = true;
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
                        synchronized (ReadOnly.class) {
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

        @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
        }

        @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
        public Timestamp getReadTime() {
            return this.consistencySelectorCase_ == 2 ? (Timestamp) this.consistencySelector_ : Timestamp.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.consistencySelectorCase_ == 2 ? 0 + CodedOutputStream.computeMessageSize(2, (Timestamp) this.consistencySelector_) : 0;
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.consistencySelectorCase_ == 2) {
                codedOutputStream.writeMessage(2, (Timestamp) this.consistencySelector_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ReadOnlyOrBuilder extends MessageLiteOrBuilder {
        ReadOnly.ConsistencySelectorCase getConsistencySelectorCase();

        Timestamp getReadTime();
    }

    /* loaded from: classes2.dex */
    public static final class ReadWrite extends GeneratedMessageLite<ReadWrite, Builder> implements ReadWriteOrBuilder {
        private static final ReadWrite DEFAULT_INSTANCE = new ReadWrite();
        private static volatile Parser<ReadWrite> PARSER = null;
        public static final int RETRY_TRANSACTION_FIELD_NUMBER = 1;
        private ByteString retryTransaction_ = ByteString.EMPTY;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadWrite, Builder> implements ReadWriteOrBuilder {
            private Builder() {
                super(ReadWrite.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearRetryTransaction() {
                a();
                ((ReadWrite) this.a).clearRetryTransaction();
                return this;
            }

            @Override // com.google.firestore.v1.TransactionOptions.ReadWriteOrBuilder
            public ByteString getRetryTransaction() {
                return ((ReadWrite) this.a).getRetryTransaction();
            }

            public Builder setRetryTransaction(ByteString byteString) {
                a();
                ((ReadWrite) this.a).setRetryTransaction(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ReadWrite() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRetryTransaction() {
            this.retryTransaction_ = getDefaultInstance().getRetryTransaction();
        }

        public static ReadWrite getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReadWrite readWrite) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) readWrite);
        }

        public static ReadWrite parseDelimitedFrom(InputStream inputStream) {
            return (ReadWrite) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadWrite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadWrite) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(ByteString byteString) {
            return (ReadWrite) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ReadWrite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadWrite) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(CodedInputStream codedInputStream) {
            return (ReadWrite) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadWrite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadWrite) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(InputStream inputStream) {
            return (ReadWrite) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadWrite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadWrite) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(byte[] bArr) {
            return (ReadWrite) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ReadWrite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ReadWrite) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ReadWrite> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryTransaction(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.retryTransaction_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadWrite();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    ReadWrite readWrite = (ReadWrite) obj2;
                    this.retryTransaction_ = ((GeneratedMessageLite.Visitor) obj).visitByteString(this.retryTransaction_ != ByteString.EMPTY, this.retryTransaction_, readWrite.retryTransaction_ != ByteString.EMPTY, readWrite.retryTransaction_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.retryTransaction_ = codedInputStream.readBytes();
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
                        synchronized (ReadWrite.class) {
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

        @Override // com.google.firestore.v1.TransactionOptions.ReadWriteOrBuilder
        public ByteString getRetryTransaction() {
            return this.retryTransaction_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = this.retryTransaction_.isEmpty() ? 0 : 0 + CodedOutputStream.computeBytesSize(1, this.retryTransaction_);
            this.c = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.retryTransaction_.isEmpty()) {
                return;
            }
            codedOutputStream.writeBytes(1, this.retryTransaction_);
        }
    }

    /* loaded from: classes2.dex */
    public interface ReadWriteOrBuilder extends MessageLiteOrBuilder {
        ByteString getRetryTransaction();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private TransactionOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMode() {
        this.modeCase_ = 0;
        this.mode_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadOnly() {
        if (this.modeCase_ == 2) {
            this.modeCase_ = 0;
            this.mode_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadWrite() {
        if (this.modeCase_ == 3) {
            this.modeCase_ = 0;
            this.mode_ = null;
        }
    }

    public static TransactionOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReadOnly(ReadOnly readOnly) {
        if (this.modeCase_ == 2 && this.mode_ != ReadOnly.getDefaultInstance()) {
            readOnly = ReadOnly.newBuilder((ReadOnly) this.mode_).mergeFrom((ReadOnly.Builder) readOnly).buildPartial();
        }
        this.mode_ = readOnly;
        this.modeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReadWrite(ReadWrite readWrite) {
        if (this.modeCase_ == 3 && this.mode_ != ReadWrite.getDefaultInstance()) {
            readWrite = ReadWrite.newBuilder((ReadWrite) this.mode_).mergeFrom((ReadWrite.Builder) readWrite).buildPartial();
        }
        this.mode_ = readWrite;
        this.modeCase_ = 3;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TransactionOptions transactionOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) transactionOptions);
    }

    public static TransactionOptions parseDelimitedFrom(InputStream inputStream) {
        return (TransactionOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static TransactionOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransactionOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(ByteString byteString) {
        return (TransactionOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static TransactionOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TransactionOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(CodedInputStream codedInputStream) {
        return (TransactionOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TransactionOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransactionOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(InputStream inputStream) {
        return (TransactionOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static TransactionOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TransactionOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(byte[] bArr) {
        return (TransactionOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static TransactionOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TransactionOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<TransactionOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadOnly(ReadOnly.Builder builder) {
        this.mode_ = builder.build();
        this.modeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadOnly(ReadOnly readOnly) {
        if (readOnly == null) {
            throw new NullPointerException();
        }
        this.mode_ = readOnly;
        this.modeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadWrite(ReadWrite.Builder builder) {
        this.mode_ = builder.build();
        this.modeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadWrite(ReadWrite readWrite) {
        if (readWrite == null) {
            throw new NullPointerException();
        }
        this.mode_ = readWrite;
        this.modeCase_ = 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00ee, code lost:
    
        if (r6.modeCase_ == 3) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00f6, code lost:
    
        r6.mode_ = r8.visitOneofMessage(r0, r6.mode_, r9.mode_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00f5, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00f3, code lost:
    
        if (r6.modeCase_ == 2) goto L74;
     */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r7, java.lang.Object r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.TransactionOptions.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
    public ModeCase getModeCase() {
        return ModeCase.forNumber(this.modeCase_);
    }

    @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
    public ReadOnly getReadOnly() {
        return this.modeCase_ == 2 ? (ReadOnly) this.mode_ : ReadOnly.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
    public ReadWrite getReadWrite() {
        return this.modeCase_ == 3 ? (ReadWrite) this.mode_ : ReadWrite.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.modeCase_ == 2 ? 0 + CodedOutputStream.computeMessageSize(2, (ReadOnly) this.mode_) : 0;
        if (this.modeCase_ == 3) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, (ReadWrite) this.mode_);
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.modeCase_ == 2) {
            codedOutputStream.writeMessage(2, (ReadOnly) this.mode_);
        }
        if (this.modeCase_ == 3) {
            codedOutputStream.writeMessage(3, (ReadWrite) this.mode_);
        }
    }
}
