package com.google.api;

import com.google.api.SystemParameter;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class SystemParameterRule extends GeneratedMessageLite<SystemParameterRule, Builder> implements SystemParameterRuleOrBuilder {
    private static final SystemParameterRule DEFAULT_INSTANCE = new SystemParameterRule();
    public static final int PARAMETERS_FIELD_NUMBER = 2;
    private static volatile Parser<SystemParameterRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private int bitField0_;
    private String selector_ = "";
    private Internal.ProtobufList<SystemParameter> parameters_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.SystemParameterRule$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<SystemParameterRule, Builder> implements SystemParameterRuleOrBuilder {
        private Builder() {
            super(SystemParameterRule.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllParameters(Iterable<? extends SystemParameter> iterable) {
            a();
            ((SystemParameterRule) this.a).addAllParameters(iterable);
            return this;
        }

        public Builder addParameters(int i, SystemParameter.Builder builder) {
            a();
            ((SystemParameterRule) this.a).addParameters(i, builder);
            return this;
        }

        public Builder addParameters(int i, SystemParameter systemParameter) {
            a();
            ((SystemParameterRule) this.a).addParameters(i, systemParameter);
            return this;
        }

        public Builder addParameters(SystemParameter.Builder builder) {
            a();
            ((SystemParameterRule) this.a).addParameters(builder);
            return this;
        }

        public Builder addParameters(SystemParameter systemParameter) {
            a();
            ((SystemParameterRule) this.a).addParameters(systemParameter);
            return this;
        }

        public Builder clearParameters() {
            a();
            ((SystemParameterRule) this.a).clearParameters();
            return this;
        }

        public Builder clearSelector() {
            a();
            ((SystemParameterRule) this.a).clearSelector();
            return this;
        }

        @Override // com.google.api.SystemParameterRuleOrBuilder
        public SystemParameter getParameters(int i) {
            return ((SystemParameterRule) this.a).getParameters(i);
        }

        @Override // com.google.api.SystemParameterRuleOrBuilder
        public int getParametersCount() {
            return ((SystemParameterRule) this.a).getParametersCount();
        }

        @Override // com.google.api.SystemParameterRuleOrBuilder
        public List<SystemParameter> getParametersList() {
            return Collections.unmodifiableList(((SystemParameterRule) this.a).getParametersList());
        }

        @Override // com.google.api.SystemParameterRuleOrBuilder
        public String getSelector() {
            return ((SystemParameterRule) this.a).getSelector();
        }

        @Override // com.google.api.SystemParameterRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((SystemParameterRule) this.a).getSelectorBytes();
        }

        public Builder removeParameters(int i) {
            a();
            ((SystemParameterRule) this.a).removeParameters(i);
            return this;
        }

        public Builder setParameters(int i, SystemParameter.Builder builder) {
            a();
            ((SystemParameterRule) this.a).setParameters(i, builder);
            return this;
        }

        public Builder setParameters(int i, SystemParameter systemParameter) {
            a();
            ((SystemParameterRule) this.a).setParameters(i, systemParameter);
            return this;
        }

        public Builder setSelector(String str) {
            a();
            ((SystemParameterRule) this.a).setSelector(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            a();
            ((SystemParameterRule) this.a).setSelectorBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private SystemParameterRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllParameters(Iterable<? extends SystemParameter> iterable) {
        ensureParametersIsMutable();
        AbstractMessageLite.a(iterable, this.parameters_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParameters(int i, SystemParameter.Builder builder) {
        ensureParametersIsMutable();
        this.parameters_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParameters(int i, SystemParameter systemParameter) {
        if (systemParameter == null) {
            throw new NullPointerException();
        }
        ensureParametersIsMutable();
        this.parameters_.add(i, systemParameter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParameters(SystemParameter.Builder builder) {
        ensureParametersIsMutable();
        this.parameters_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParameters(SystemParameter systemParameter) {
        if (systemParameter == null) {
            throw new NullPointerException();
        }
        ensureParametersIsMutable();
        this.parameters_.add(systemParameter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParameters() {
        this.parameters_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    private void ensureParametersIsMutable() {
        if (this.parameters_.isModifiable()) {
            return;
        }
        this.parameters_ = GeneratedMessageLite.a(this.parameters_);
    }

    public static SystemParameterRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SystemParameterRule systemParameterRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) systemParameterRule);
    }

    public static SystemParameterRule parseDelimitedFrom(InputStream inputStream) {
        return (SystemParameterRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static SystemParameterRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SystemParameterRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SystemParameterRule parseFrom(ByteString byteString) {
        return (SystemParameterRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static SystemParameterRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SystemParameterRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SystemParameterRule parseFrom(CodedInputStream codedInputStream) {
        return (SystemParameterRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SystemParameterRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SystemParameterRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static SystemParameterRule parseFrom(InputStream inputStream) {
        return (SystemParameterRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static SystemParameterRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SystemParameterRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SystemParameterRule parseFrom(byte[] bArr) {
        return (SystemParameterRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static SystemParameterRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SystemParameterRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<SystemParameterRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeParameters(int i) {
        ensureParametersIsMutable();
        this.parameters_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParameters(int i, SystemParameter.Builder builder) {
        ensureParametersIsMutable();
        this.parameters_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParameters(int i, SystemParameter systemParameter) {
        if (systemParameter == null) {
            throw new NullPointerException();
        }
        ensureParametersIsMutable();
        this.parameters_.set(i, systemParameter);
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
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new SystemParameterRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.parameters_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                SystemParameterRule systemParameterRule = (SystemParameterRule) obj2;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, true ^ systemParameterRule.selector_.isEmpty(), systemParameterRule.selector_);
                this.parameters_ = visitor.visitList(this.parameters_, systemParameterRule.parameters_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= systemParameterRule.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.selector_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    if (!this.parameters_.isModifiable()) {
                                        this.parameters_ = GeneratedMessageLite.a(this.parameters_);
                                    }
                                    this.parameters_.add((SystemParameter) codedInputStream.readMessage(SystemParameter.parser(), extensionRegistryLite));
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (SystemParameterRule.class) {
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

    @Override // com.google.api.SystemParameterRuleOrBuilder
    public SystemParameter getParameters(int i) {
        return this.parameters_.get(i);
    }

    @Override // com.google.api.SystemParameterRuleOrBuilder
    public int getParametersCount() {
        return this.parameters_.size();
    }

    @Override // com.google.api.SystemParameterRuleOrBuilder
    public List<SystemParameter> getParametersList() {
        return this.parameters_;
    }

    public SystemParameterOrBuilder getParametersOrBuilder(int i) {
        return this.parameters_.get(i);
    }

    public List<? extends SystemParameterOrBuilder> getParametersOrBuilderList() {
        return this.parameters_;
    }

    @Override // com.google.api.SystemParameterRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.SystemParameterRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.selector_.isEmpty() ? CodedOutputStream.computeStringSize(1, getSelector()) + 0 : 0;
        for (int i2 = 0; i2 < this.parameters_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.parameters_.get(i2));
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.selector_.isEmpty()) {
            codedOutputStream.writeString(1, getSelector());
        }
        for (int i = 0; i < this.parameters_.size(); i++) {
            codedOutputStream.writeMessage(2, this.parameters_.get(i));
        }
    }
}
