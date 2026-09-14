package com.google.api;

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
public final class BackendRule extends GeneratedMessageLite<BackendRule, Builder> implements BackendRuleOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int DEADLINE_FIELD_NUMBER = 3;
    private static final BackendRule DEFAULT_INSTANCE = new BackendRule();
    private static volatile Parser<BackendRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private double deadline_;
    private String selector_ = "";
    private String address_ = "";

    /* renamed from: com.google.api.BackendRule$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<BackendRule, Builder> implements BackendRuleOrBuilder {
        private Builder() {
            super(BackendRule.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAddress() {
            a();
            ((BackendRule) this.a).clearAddress();
            return this;
        }

        public Builder clearDeadline() {
            a();
            ((BackendRule) this.a).clearDeadline();
            return this;
        }

        public Builder clearSelector() {
            a();
            ((BackendRule) this.a).clearSelector();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getAddress() {
            return ((BackendRule) this.a).getAddress();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getAddressBytes() {
            return ((BackendRule) this.a).getAddressBytes();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public double getDeadline() {
            return ((BackendRule) this.a).getDeadline();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getSelector() {
            return ((BackendRule) this.a).getSelector();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((BackendRule) this.a).getSelectorBytes();
        }

        public Builder setAddress(String str) {
            a();
            ((BackendRule) this.a).setAddress(str);
            return this;
        }

        public Builder setAddressBytes(ByteString byteString) {
            a();
            ((BackendRule) this.a).setAddressBytes(byteString);
            return this;
        }

        public Builder setDeadline(double d) {
            a();
            ((BackendRule) this.a).setDeadline(d);
            return this;
        }

        public Builder setSelector(String str) {
            a();
            ((BackendRule) this.a).setSelector(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            a();
            ((BackendRule) this.a).setSelectorBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private BackendRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeadline() {
        this.deadline_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    public static BackendRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BackendRule backendRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) backendRule);
    }

    public static BackendRule parseDelimitedFrom(InputStream inputStream) {
        return (BackendRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static BackendRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BackendRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BackendRule parseFrom(ByteString byteString) {
        return (BackendRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static BackendRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BackendRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BackendRule parseFrom(CodedInputStream codedInputStream) {
        return (BackendRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BackendRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BackendRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static BackendRule parseFrom(InputStream inputStream) {
        return (BackendRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static BackendRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BackendRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BackendRule parseFrom(byte[] bArr) {
        return (BackendRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static BackendRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BackendRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<BackendRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddress(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.address_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddressBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.address_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeadline(double d) {
        this.deadline_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelector(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectorBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new BackendRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                BackendRule backendRule = (BackendRule) obj2;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !backendRule.selector_.isEmpty(), backendRule.selector_);
                this.address_ = visitor.visitString(!this.address_.isEmpty(), this.address_, !backendRule.address_.isEmpty(), backendRule.address_);
                this.deadline_ = visitor.visitDouble(this.deadline_ != 0.0d, this.deadline_, backendRule.deadline_ != 0.0d, backendRule.deadline_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.address_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 25) {
                                this.deadline_ = codedInputStream.readDouble();
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
                    synchronized (BackendRule.class) {
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

    @Override // com.google.api.BackendRuleOrBuilder
    public String getAddress() {
        return this.address_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getAddressBytes() {
        return ByteString.copyFromUtf8(this.address_);
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public double getDeadline() {
        return this.deadline_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.selector_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getSelector());
        if (!this.address_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getAddress());
        }
        double d = this.deadline_;
        if (d != 0.0d) {
            computeStringSize += CodedOutputStream.computeDoubleSize(3, d);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.selector_.isEmpty()) {
            codedOutputStream.writeString(1, getSelector());
        }
        if (!this.address_.isEmpty()) {
            codedOutputStream.writeString(2, getAddress());
        }
        double d = this.deadline_;
        if (d != 0.0d) {
            codedOutputStream.writeDouble(3, d);
        }
    }
}
