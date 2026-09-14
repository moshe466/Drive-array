package com.google.api;

import com.google.api.HttpRule;
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
public final class Http extends GeneratedMessageLite<Http, Builder> implements HttpOrBuilder {
    private static final Http DEFAULT_INSTANCE = new Http();
    public static final int FULLY_DECODE_RESERVED_EXPANSION_FIELD_NUMBER = 2;
    private static volatile Parser<Http> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean fullyDecodeReservedExpansion_;
    private Internal.ProtobufList<HttpRule> rules_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.Http$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Http, Builder> implements HttpOrBuilder {
        private Builder() {
            super(Http.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllRules(Iterable<? extends HttpRule> iterable) {
            a();
            ((Http) this.a).addAllRules(iterable);
            return this;
        }

        public Builder addRules(int i, HttpRule.Builder builder) {
            a();
            ((Http) this.a).addRules(i, builder);
            return this;
        }

        public Builder addRules(int i, HttpRule httpRule) {
            a();
            ((Http) this.a).addRules(i, httpRule);
            return this;
        }

        public Builder addRules(HttpRule.Builder builder) {
            a();
            ((Http) this.a).addRules(builder);
            return this;
        }

        public Builder addRules(HttpRule httpRule) {
            a();
            ((Http) this.a).addRules(httpRule);
            return this;
        }

        public Builder clearFullyDecodeReservedExpansion() {
            a();
            ((Http) this.a).clearFullyDecodeReservedExpansion();
            return this;
        }

        public Builder clearRules() {
            a();
            ((Http) this.a).clearRules();
            return this;
        }

        @Override // com.google.api.HttpOrBuilder
        public boolean getFullyDecodeReservedExpansion() {
            return ((Http) this.a).getFullyDecodeReservedExpansion();
        }

        @Override // com.google.api.HttpOrBuilder
        public HttpRule getRules(int i) {
            return ((Http) this.a).getRules(i);
        }

        @Override // com.google.api.HttpOrBuilder
        public int getRulesCount() {
            return ((Http) this.a).getRulesCount();
        }

        @Override // com.google.api.HttpOrBuilder
        public List<HttpRule> getRulesList() {
            return Collections.unmodifiableList(((Http) this.a).getRulesList());
        }

        public Builder removeRules(int i) {
            a();
            ((Http) this.a).removeRules(i);
            return this;
        }

        public Builder setFullyDecodeReservedExpansion(boolean z) {
            a();
            ((Http) this.a).setFullyDecodeReservedExpansion(z);
            return this;
        }

        public Builder setRules(int i, HttpRule.Builder builder) {
            a();
            ((Http) this.a).setRules(i, builder);
            return this;
        }

        public Builder setRules(int i, HttpRule httpRule) {
            a();
            ((Http) this.a).setRules(i, httpRule);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Http() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRules(Iterable<? extends HttpRule> iterable) {
        ensureRulesIsMutable();
        AbstractMessageLite.a(iterable, this.rules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, HttpRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, HttpRule httpRule) {
        if (httpRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.add(i, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(HttpRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(HttpRule httpRule) {
        if (httpRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.add(httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFullyDecodeReservedExpansion() {
        this.fullyDecodeReservedExpansion_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = GeneratedMessageLite.f();
    }

    private void ensureRulesIsMutable() {
        if (this.rules_.isModifiable()) {
            return;
        }
        this.rules_ = GeneratedMessageLite.a(this.rules_);
    }

    public static Http getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Http http) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) http);
    }

    public static Http parseDelimitedFrom(InputStream inputStream) {
        return (Http) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Http parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Http) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Http parseFrom(ByteString byteString) {
        return (Http) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Http parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Http) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Http parseFrom(CodedInputStream codedInputStream) {
        return (Http) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Http parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Http) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Http parseFrom(InputStream inputStream) {
        return (Http) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Http parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Http) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Http parseFrom(byte[] bArr) {
        return (Http) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Http parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Http) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Http> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRules(int i) {
        ensureRulesIsMutable();
        this.rules_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullyDecodeReservedExpansion(boolean z) {
        this.fullyDecodeReservedExpansion_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, HttpRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, HttpRule httpRule) {
        if (httpRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.set(i, httpRule);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Http();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Http http = (Http) obj2;
                this.rules_ = visitor.visitList(this.rules_, http.rules_);
                boolean z = this.fullyDecodeReservedExpansion_;
                boolean z2 = http.fullyDecodeReservedExpansion_;
                this.fullyDecodeReservedExpansion_ = visitor.visitBoolean(z, z, z2, z2);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= http.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z3 = false;
                while (!z3) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    if (!this.rules_.isModifiable()) {
                                        this.rules_ = GeneratedMessageLite.a(this.rules_);
                                    }
                                    this.rules_.add((HttpRule) codedInputStream.readMessage(HttpRule.parser(), extensionRegistryLite));
                                } else if (readTag == 16) {
                                    this.fullyDecodeReservedExpansion_ = codedInputStream.readBool();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z3 = true;
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
                    synchronized (Http.class) {
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

    @Override // com.google.api.HttpOrBuilder
    public boolean getFullyDecodeReservedExpansion() {
        return this.fullyDecodeReservedExpansion_;
    }

    @Override // com.google.api.HttpOrBuilder
    public HttpRule getRules(int i) {
        return this.rules_.get(i);
    }

    @Override // com.google.api.HttpOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.HttpOrBuilder
    public List<HttpRule> getRulesList() {
        return this.rules_;
    }

    public HttpRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    public List<? extends HttpRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.rules_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.rules_.get(i3));
        }
        boolean z = this.fullyDecodeReservedExpansion_;
        if (z) {
            i2 += CodedOutputStream.computeBoolSize(2, z);
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.rules_.size(); i++) {
            codedOutputStream.writeMessage(1, this.rules_.get(i));
        }
        boolean z = this.fullyDecodeReservedExpansion_;
        if (z) {
            codedOutputStream.writeBool(2, z);
        }
    }
}
