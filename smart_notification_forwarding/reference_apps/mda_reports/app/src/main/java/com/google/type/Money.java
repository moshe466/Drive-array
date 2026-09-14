package com.google.type;

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
public final class Money extends GeneratedMessageLite<Money, Builder> implements MoneyOrBuilder {
    public static final int CURRENCY_CODE_FIELD_NUMBER = 1;
    private static final Money DEFAULT_INSTANCE = new Money();
    public static final int NANOS_FIELD_NUMBER = 3;
    private static volatile Parser<Money> PARSER = null;
    public static final int UNITS_FIELD_NUMBER = 2;
    private String currencyCode_ = "";
    private int nanos_;
    private long units_;

    /* renamed from: com.google.type.Money$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Money, Builder> implements MoneyOrBuilder {
        private Builder() {
            super(Money.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCurrencyCode() {
            a();
            ((Money) this.a).clearCurrencyCode();
            return this;
        }

        public Builder clearNanos() {
            a();
            ((Money) this.a).clearNanos();
            return this;
        }

        public Builder clearUnits() {
            a();
            ((Money) this.a).clearUnits();
            return this;
        }

        @Override // com.google.type.MoneyOrBuilder
        public String getCurrencyCode() {
            return ((Money) this.a).getCurrencyCode();
        }

        @Override // com.google.type.MoneyOrBuilder
        public ByteString getCurrencyCodeBytes() {
            return ((Money) this.a).getCurrencyCodeBytes();
        }

        @Override // com.google.type.MoneyOrBuilder
        public int getNanos() {
            return ((Money) this.a).getNanos();
        }

        @Override // com.google.type.MoneyOrBuilder
        public long getUnits() {
            return ((Money) this.a).getUnits();
        }

        public Builder setCurrencyCode(String str) {
            a();
            ((Money) this.a).setCurrencyCode(str);
            return this;
        }

        public Builder setCurrencyCodeBytes(ByteString byteString) {
            a();
            ((Money) this.a).setCurrencyCodeBytes(byteString);
            return this;
        }

        public Builder setNanos(int i) {
            a();
            ((Money) this.a).setNanos(i);
            return this;
        }

        public Builder setUnits(long j) {
            a();
            ((Money) this.a).setUnits(j);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Money() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurrencyCode() {
        this.currencyCode_ = getDefaultInstance().getCurrencyCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNanos() {
        this.nanos_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnits() {
        this.units_ = 0L;
    }

    public static Money getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Money money) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) money);
    }

    public static Money parseDelimitedFrom(InputStream inputStream) {
        return (Money) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Money parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Money) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Money parseFrom(ByteString byteString) {
        return (Money) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Money parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Money) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Money parseFrom(CodedInputStream codedInputStream) {
        return (Money) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Money parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Money) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Money parseFrom(InputStream inputStream) {
        return (Money) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Money parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Money) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Money parseFrom(byte[] bArr) {
        return (Money) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Money parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Money) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Money> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrencyCode(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.currencyCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrencyCodeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.currencyCode_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNanos(int i) {
        this.nanos_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnits(long j) {
        this.units_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Money();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Money money = (Money) obj2;
                this.currencyCode_ = visitor.visitString(!this.currencyCode_.isEmpty(), this.currencyCode_, !money.currencyCode_.isEmpty(), money.currencyCode_);
                this.units_ = visitor.visitLong(this.units_ != 0, this.units_, money.units_ != 0, money.units_);
                this.nanos_ = visitor.visitInt(this.nanos_ != 0, this.nanos_, money.nanos_ != 0, money.nanos_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.currencyCode_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.units_ = codedInputStream.readInt64();
                            } else if (readTag == 24) {
                                this.nanos_ = codedInputStream.readInt32();
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
                    synchronized (Money.class) {
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

    @Override // com.google.type.MoneyOrBuilder
    public String getCurrencyCode() {
        return this.currencyCode_;
    }

    @Override // com.google.type.MoneyOrBuilder
    public ByteString getCurrencyCodeBytes() {
        return ByteString.copyFromUtf8(this.currencyCode_);
    }

    @Override // com.google.type.MoneyOrBuilder
    public int getNanos() {
        return this.nanos_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.currencyCode_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getCurrencyCode());
        long j = this.units_;
        if (j != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(2, j);
        }
        int i2 = this.nanos_;
        if (i2 != 0) {
            computeStringSize += CodedOutputStream.computeInt32Size(3, i2);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.type.MoneyOrBuilder
    public long getUnits() {
        return this.units_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.currencyCode_.isEmpty()) {
            codedOutputStream.writeString(1, getCurrencyCode());
        }
        long j = this.units_;
        if (j != 0) {
            codedOutputStream.writeInt64(2, j);
        }
        int i = this.nanos_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
    }
}
