package com.google.api;

import com.google.api.AuthProvider;
import com.google.api.AuthenticationRule;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Authentication extends GeneratedMessageLite<Authentication, Builder> implements AuthenticationOrBuilder {
    private static final Authentication DEFAULT_INSTANCE = new Authentication();
    private static volatile Parser<Authentication> PARSER = null;
    public static final int PROVIDERS_FIELD_NUMBER = 4;
    public static final int RULES_FIELD_NUMBER = 3;
    private Internal.ProtobufList<AuthenticationRule> rules_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<AuthProvider> providers_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.Authentication$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Authentication, Builder> implements AuthenticationOrBuilder {
        private Builder() {
            super(Authentication.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllProviders(Iterable<? extends AuthProvider> iterable) {
            a();
            ((Authentication) this.a).addAllProviders(iterable);
            return this;
        }

        public Builder addAllRules(Iterable<? extends AuthenticationRule> iterable) {
            a();
            ((Authentication) this.a).addAllRules(iterable);
            return this;
        }

        public Builder addProviders(int i, AuthProvider.Builder builder) {
            a();
            ((Authentication) this.a).addProviders(i, builder);
            return this;
        }

        public Builder addProviders(int i, AuthProvider authProvider) {
            a();
            ((Authentication) this.a).addProviders(i, authProvider);
            return this;
        }

        public Builder addProviders(AuthProvider.Builder builder) {
            a();
            ((Authentication) this.a).addProviders(builder);
            return this;
        }

        public Builder addProviders(AuthProvider authProvider) {
            a();
            ((Authentication) this.a).addProviders(authProvider);
            return this;
        }

        public Builder addRules(int i, AuthenticationRule.Builder builder) {
            a();
            ((Authentication) this.a).addRules(i, builder);
            return this;
        }

        public Builder addRules(int i, AuthenticationRule authenticationRule) {
            a();
            ((Authentication) this.a).addRules(i, authenticationRule);
            return this;
        }

        public Builder addRules(AuthenticationRule.Builder builder) {
            a();
            ((Authentication) this.a).addRules(builder);
            return this;
        }

        public Builder addRules(AuthenticationRule authenticationRule) {
            a();
            ((Authentication) this.a).addRules(authenticationRule);
            return this;
        }

        public Builder clearProviders() {
            a();
            ((Authentication) this.a).clearProviders();
            return this;
        }

        public Builder clearRules() {
            a();
            ((Authentication) this.a).clearRules();
            return this;
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthProvider getProviders(int i) {
            return ((Authentication) this.a).getProviders(i);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public int getProvidersCount() {
            return ((Authentication) this.a).getProvidersCount();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<AuthProvider> getProvidersList() {
            return Collections.unmodifiableList(((Authentication) this.a).getProvidersList());
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthenticationRule getRules(int i) {
            return ((Authentication) this.a).getRules(i);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public int getRulesCount() {
            return ((Authentication) this.a).getRulesCount();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<AuthenticationRule> getRulesList() {
            return Collections.unmodifiableList(((Authentication) this.a).getRulesList());
        }

        public Builder removeProviders(int i) {
            a();
            ((Authentication) this.a).removeProviders(i);
            return this;
        }

        public Builder removeRules(int i) {
            a();
            ((Authentication) this.a).removeRules(i);
            return this;
        }

        public Builder setProviders(int i, AuthProvider.Builder builder) {
            a();
            ((Authentication) this.a).setProviders(i, builder);
            return this;
        }

        public Builder setProviders(int i, AuthProvider authProvider) {
            a();
            ((Authentication) this.a).setProviders(i, authProvider);
            return this;
        }

        public Builder setRules(int i, AuthenticationRule.Builder builder) {
            a();
            ((Authentication) this.a).setRules(i, builder);
            return this;
        }

        public Builder setRules(int i, AuthenticationRule authenticationRule) {
            a();
            ((Authentication) this.a).setRules(i, authenticationRule);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Authentication() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProviders(Iterable<? extends AuthProvider> iterable) {
        ensureProvidersIsMutable();
        AbstractMessageLite.a(iterable, this.providers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRules(Iterable<? extends AuthenticationRule> iterable) {
        ensureRulesIsMutable();
        AbstractMessageLite.a(iterable, this.rules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProviders(int i, AuthProvider.Builder builder) {
        ensureProvidersIsMutable();
        this.providers_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProviders(int i, AuthProvider authProvider) {
        if (authProvider == null) {
            throw new NullPointerException();
        }
        ensureProvidersIsMutable();
        this.providers_.add(i, authProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProviders(AuthProvider.Builder builder) {
        ensureProvidersIsMutable();
        this.providers_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProviders(AuthProvider authProvider) {
        if (authProvider == null) {
            throw new NullPointerException();
        }
        ensureProvidersIsMutable();
        this.providers_.add(authProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, AuthenticationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, AuthenticationRule authenticationRule) {
        if (authenticationRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.add(i, authenticationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(AuthenticationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(AuthenticationRule authenticationRule) {
        if (authenticationRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.add(authenticationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProviders() {
        this.providers_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = GeneratedMessageLite.f();
    }

    private void ensureProvidersIsMutable() {
        if (this.providers_.isModifiable()) {
            return;
        }
        this.providers_ = GeneratedMessageLite.a(this.providers_);
    }

    private void ensureRulesIsMutable() {
        if (this.rules_.isModifiable()) {
            return;
        }
        this.rules_ = GeneratedMessageLite.a(this.rules_);
    }

    public static Authentication getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Authentication authentication) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) authentication);
    }

    public static Authentication parseDelimitedFrom(InputStream inputStream) {
        return (Authentication) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Authentication parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Authentication) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(ByteString byteString) {
        return (Authentication) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Authentication parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Authentication) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Authentication parseFrom(CodedInputStream codedInputStream) {
        return (Authentication) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Authentication parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Authentication) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(InputStream inputStream) {
        return (Authentication) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Authentication parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Authentication) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(byte[] bArr) {
        return (Authentication) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Authentication parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Authentication) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Authentication> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProviders(int i) {
        ensureProvidersIsMutable();
        this.providers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRules(int i) {
        ensureRulesIsMutable();
        this.rules_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProviders(int i, AuthProvider.Builder builder) {
        ensureProvidersIsMutable();
        this.providers_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProviders(int i, AuthProvider authProvider) {
        if (authProvider == null) {
            throw new NullPointerException();
        }
        ensureProvidersIsMutable();
        this.providers_.set(i, authProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, AuthenticationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, AuthenticationRule authenticationRule) {
        if (authenticationRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.set(i, authenticationRule);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        List list;
        MessageLite messageLite;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Authentication();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.rules_.makeImmutable();
                this.providers_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Authentication authentication = (Authentication) obj2;
                this.rules_ = visitor.visitList(this.rules_, authentication.rules_);
                this.providers_ = visitor.visitList(this.providers_, authentication.providers_);
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
                            if (readTag == 26) {
                                if (!this.rules_.isModifiable()) {
                                    this.rules_ = GeneratedMessageLite.a(this.rules_);
                                }
                                list = this.rules_;
                                messageLite = (AuthenticationRule) codedInputStream.readMessage(AuthenticationRule.parser(), extensionRegistryLite);
                            } else if (readTag == 34) {
                                if (!this.providers_.isModifiable()) {
                                    this.providers_ = GeneratedMessageLite.a(this.providers_);
                                }
                                list = this.providers_;
                                messageLite = (AuthProvider) codedInputStream.readMessage(AuthProvider.parser(), extensionRegistryLite);
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                            list.add(messageLite);
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
                    synchronized (Authentication.class) {
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

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthProvider getProviders(int i) {
        return this.providers_.get(i);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public int getProvidersCount() {
        return this.providers_.size();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<AuthProvider> getProvidersList() {
        return this.providers_;
    }

    public AuthProviderOrBuilder getProvidersOrBuilder(int i) {
        return this.providers_.get(i);
    }

    public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
        return this.providers_;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthenticationRule getRules(int i) {
        return this.rules_.get(i);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<AuthenticationRule> getRulesList() {
        return this.rules_;
    }

    public AuthenticationRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
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
            i2 += CodedOutputStream.computeMessageSize(3, this.rules_.get(i3));
        }
        for (int i4 = 0; i4 < this.providers_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(4, this.providers_.get(i4));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.rules_.size(); i++) {
            codedOutputStream.writeMessage(3, this.rules_.get(i));
        }
        for (int i2 = 0; i2 < this.providers_.size(); i2++) {
            codedOutputStream.writeMessage(4, this.providers_.get(i2));
        }
    }
}
