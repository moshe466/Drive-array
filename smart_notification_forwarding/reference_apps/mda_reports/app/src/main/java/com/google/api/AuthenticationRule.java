package com.google.api;

import com.google.api.AuthRequirement;
import com.google.api.OAuthRequirements;
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
public final class AuthenticationRule extends GeneratedMessageLite<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
    public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
    private static final AuthenticationRule DEFAULT_INSTANCE = new AuthenticationRule();
    public static final int OAUTH_FIELD_NUMBER = 2;
    private static volatile Parser<AuthenticationRule> PARSER = null;
    public static final int REQUIREMENTS_FIELD_NUMBER = 7;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private boolean allowWithoutCredential_;
    private int bitField0_;
    private OAuthRequirements oauth_;
    private String selector_ = "";
    private Internal.ProtobufList<AuthRequirement> requirements_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.AuthenticationRule$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
        private Builder() {
            super(AuthenticationRule.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
            a();
            ((AuthenticationRule) this.a).addAllRequirements(iterable);
            return this;
        }

        public Builder addRequirements(int i, AuthRequirement.Builder builder) {
            a();
            ((AuthenticationRule) this.a).addRequirements(i, builder);
            return this;
        }

        public Builder addRequirements(int i, AuthRequirement authRequirement) {
            a();
            ((AuthenticationRule) this.a).addRequirements(i, authRequirement);
            return this;
        }

        public Builder addRequirements(AuthRequirement.Builder builder) {
            a();
            ((AuthenticationRule) this.a).addRequirements(builder);
            return this;
        }

        public Builder addRequirements(AuthRequirement authRequirement) {
            a();
            ((AuthenticationRule) this.a).addRequirements(authRequirement);
            return this;
        }

        public Builder clearAllowWithoutCredential() {
            a();
            ((AuthenticationRule) this.a).clearAllowWithoutCredential();
            return this;
        }

        public Builder clearOauth() {
            a();
            ((AuthenticationRule) this.a).clearOauth();
            return this;
        }

        public Builder clearRequirements() {
            a();
            ((AuthenticationRule) this.a).clearRequirements();
            return this;
        }

        public Builder clearSelector() {
            a();
            ((AuthenticationRule) this.a).clearSelector();
            return this;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public boolean getAllowWithoutCredential() {
            return ((AuthenticationRule) this.a).getAllowWithoutCredential();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public OAuthRequirements getOauth() {
            return ((AuthenticationRule) this.a).getOauth();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public AuthRequirement getRequirements(int i) {
            return ((AuthenticationRule) this.a).getRequirements(i);
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public int getRequirementsCount() {
            return ((AuthenticationRule) this.a).getRequirementsCount();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public List<AuthRequirement> getRequirementsList() {
            return Collections.unmodifiableList(((AuthenticationRule) this.a).getRequirementsList());
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public String getSelector() {
            return ((AuthenticationRule) this.a).getSelector();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((AuthenticationRule) this.a).getSelectorBytes();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public boolean hasOauth() {
            return ((AuthenticationRule) this.a).hasOauth();
        }

        public Builder mergeOauth(OAuthRequirements oAuthRequirements) {
            a();
            ((AuthenticationRule) this.a).mergeOauth(oAuthRequirements);
            return this;
        }

        public Builder removeRequirements(int i) {
            a();
            ((AuthenticationRule) this.a).removeRequirements(i);
            return this;
        }

        public Builder setAllowWithoutCredential(boolean z) {
            a();
            ((AuthenticationRule) this.a).setAllowWithoutCredential(z);
            return this;
        }

        public Builder setOauth(OAuthRequirements.Builder builder) {
            a();
            ((AuthenticationRule) this.a).setOauth(builder);
            return this;
        }

        public Builder setOauth(OAuthRequirements oAuthRequirements) {
            a();
            ((AuthenticationRule) this.a).setOauth(oAuthRequirements);
            return this;
        }

        public Builder setRequirements(int i, AuthRequirement.Builder builder) {
            a();
            ((AuthenticationRule) this.a).setRequirements(i, builder);
            return this;
        }

        public Builder setRequirements(int i, AuthRequirement authRequirement) {
            a();
            ((AuthenticationRule) this.a).setRequirements(i, authRequirement);
            return this;
        }

        public Builder setSelector(String str) {
            a();
            ((AuthenticationRule) this.a).setSelector(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            a();
            ((AuthenticationRule) this.a).setSelectorBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private AuthenticationRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.a(iterable, this.requirements_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequirements(int i, AuthRequirement.Builder builder) {
        ensureRequirementsIsMutable();
        this.requirements_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequirements(int i, AuthRequirement authRequirement) {
        if (authRequirement == null) {
            throw new NullPointerException();
        }
        ensureRequirementsIsMutable();
        this.requirements_.add(i, authRequirement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequirements(AuthRequirement.Builder builder) {
        ensureRequirementsIsMutable();
        this.requirements_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequirements(AuthRequirement authRequirement) {
        if (authRequirement == null) {
            throw new NullPointerException();
        }
        ensureRequirementsIsMutable();
        this.requirements_.add(authRequirement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowWithoutCredential() {
        this.allowWithoutCredential_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOauth() {
        this.oauth_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequirements() {
        this.requirements_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    private void ensureRequirementsIsMutable() {
        if (this.requirements_.isModifiable()) {
            return;
        }
        this.requirements_ = GeneratedMessageLite.a(this.requirements_);
    }

    public static AuthenticationRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOauth(OAuthRequirements oAuthRequirements) {
        OAuthRequirements oAuthRequirements2 = this.oauth_;
        if (oAuthRequirements2 != null && oAuthRequirements2 != OAuthRequirements.getDefaultInstance()) {
            oAuthRequirements = OAuthRequirements.newBuilder(this.oauth_).mergeFrom((OAuthRequirements.Builder) oAuthRequirements).buildPartial();
        }
        this.oauth_ = oAuthRequirements;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthenticationRule authenticationRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) authenticationRule);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream) {
        return (AuthenticationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthenticationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(ByteString byteString) {
        return (AuthenticationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static AuthenticationRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthenticationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream) {
        return (AuthenticationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthenticationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream) {
        return (AuthenticationRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthenticationRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(byte[] bArr) {
        return (AuthenticationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static AuthenticationRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthenticationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<AuthenticationRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRequirements(int i) {
        ensureRequirementsIsMutable();
        this.requirements_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowWithoutCredential(boolean z) {
        this.allowWithoutCredential_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOauth(OAuthRequirements.Builder builder) {
        this.oauth_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOauth(OAuthRequirements oAuthRequirements) {
        if (oAuthRequirements == null) {
            throw new NullPointerException();
        }
        this.oauth_ = oAuthRequirements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequirements(int i, AuthRequirement.Builder builder) {
        ensureRequirementsIsMutable();
        this.requirements_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequirements(int i, AuthRequirement authRequirement) {
        if (authRequirement == null) {
            throw new NullPointerException();
        }
        ensureRequirementsIsMutable();
        this.requirements_.set(i, authRequirement);
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
                return new AuthenticationRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.requirements_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuthenticationRule authenticationRule = (AuthenticationRule) obj2;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, true ^ authenticationRule.selector_.isEmpty(), authenticationRule.selector_);
                this.oauth_ = (OAuthRequirements) visitor.visitMessage(this.oauth_, authenticationRule.oauth_);
                boolean z = this.allowWithoutCredential_;
                boolean z2 = authenticationRule.allowWithoutCredential_;
                this.allowWithoutCredential_ = visitor.visitBoolean(z, z, z2, z2);
                this.requirements_ = visitor.visitList(this.requirements_, authenticationRule.requirements_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= authenticationRule.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z3 = false;
                while (!z3) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                OAuthRequirements.Builder builder = this.oauth_ != null ? this.oauth_.toBuilder() : null;
                                this.oauth_ = (OAuthRequirements) codedInputStream.readMessage(OAuthRequirements.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((OAuthRequirements.Builder) this.oauth_);
                                    this.oauth_ = builder.buildPartial();
                                }
                            } else if (readTag == 40) {
                                this.allowWithoutCredential_ = codedInputStream.readBool();
                            } else if (readTag == 58) {
                                if (!this.requirements_.isModifiable()) {
                                    this.requirements_ = GeneratedMessageLite.a(this.requirements_);
                                }
                                this.requirements_.add((AuthRequirement) codedInputStream.readMessage(AuthRequirement.parser(), extensionRegistryLite));
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z3 = true;
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
                    synchronized (AuthenticationRule.class) {
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

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public boolean getAllowWithoutCredential() {
        return this.allowWithoutCredential_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public OAuthRequirements getOauth() {
        OAuthRequirements oAuthRequirements = this.oauth_;
        return oAuthRequirements == null ? OAuthRequirements.getDefaultInstance() : oAuthRequirements;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public AuthRequirement getRequirements(int i) {
        return this.requirements_.get(i);
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public List<AuthRequirement> getRequirementsList() {
        return this.requirements_;
    }

    public AuthRequirementOrBuilder getRequirementsOrBuilder(int i) {
        return this.requirements_.get(i);
    }

    public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
        return this.requirements_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
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
        if (this.oauth_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getOauth());
        }
        boolean z = this.allowWithoutCredential_;
        if (z) {
            computeStringSize += CodedOutputStream.computeBoolSize(5, z);
        }
        for (int i2 = 0; i2 < this.requirements_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(7, this.requirements_.get(i2));
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public boolean hasOauth() {
        return this.oauth_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.selector_.isEmpty()) {
            codedOutputStream.writeString(1, getSelector());
        }
        if (this.oauth_ != null) {
            codedOutputStream.writeMessage(2, getOauth());
        }
        boolean z = this.allowWithoutCredential_;
        if (z) {
            codedOutputStream.writeBool(5, z);
        }
        for (int i = 0; i < this.requirements_.size(); i++) {
            codedOutputStream.writeMessage(7, this.requirements_.get(i));
        }
    }
}
