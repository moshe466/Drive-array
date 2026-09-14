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
public final class AuthProvider extends GeneratedMessageLite<AuthProvider, Builder> implements AuthProviderOrBuilder {
    public static final int AUDIENCES_FIELD_NUMBER = 4;
    public static final int AUTHORIZATION_URL_FIELD_NUMBER = 5;
    private static final AuthProvider DEFAULT_INSTANCE = new AuthProvider();
    public static final int ID_FIELD_NUMBER = 1;
    public static final int ISSUER_FIELD_NUMBER = 2;
    public static final int JWKS_URI_FIELD_NUMBER = 3;
    private static volatile Parser<AuthProvider> PARSER;
    private String id_ = "";
    private String issuer_ = "";
    private String jwksUri_ = "";
    private String audiences_ = "";
    private String authorizationUrl_ = "";

    /* renamed from: com.google.api.AuthProvider$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<AuthProvider, Builder> implements AuthProviderOrBuilder {
        private Builder() {
            super(AuthProvider.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAudiences() {
            a();
            ((AuthProvider) this.a).clearAudiences();
            return this;
        }

        public Builder clearAuthorizationUrl() {
            a();
            ((AuthProvider) this.a).clearAuthorizationUrl();
            return this;
        }

        public Builder clearId() {
            a();
            ((AuthProvider) this.a).clearId();
            return this;
        }

        public Builder clearIssuer() {
            a();
            ((AuthProvider) this.a).clearIssuer();
            return this;
        }

        public Builder clearJwksUri() {
            a();
            ((AuthProvider) this.a).clearJwksUri();
            return this;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getAudiences() {
            return ((AuthProvider) this.a).getAudiences();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getAudiencesBytes() {
            return ((AuthProvider) this.a).getAudiencesBytes();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getAuthorizationUrl() {
            return ((AuthProvider) this.a).getAuthorizationUrl();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getAuthorizationUrlBytes() {
            return ((AuthProvider) this.a).getAuthorizationUrlBytes();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getId() {
            return ((AuthProvider) this.a).getId();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getIdBytes() {
            return ((AuthProvider) this.a).getIdBytes();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getIssuer() {
            return ((AuthProvider) this.a).getIssuer();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getIssuerBytes() {
            return ((AuthProvider) this.a).getIssuerBytes();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public String getJwksUri() {
            return ((AuthProvider) this.a).getJwksUri();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public ByteString getJwksUriBytes() {
            return ((AuthProvider) this.a).getJwksUriBytes();
        }

        public Builder setAudiences(String str) {
            a();
            ((AuthProvider) this.a).setAudiences(str);
            return this;
        }

        public Builder setAudiencesBytes(ByteString byteString) {
            a();
            ((AuthProvider) this.a).setAudiencesBytes(byteString);
            return this;
        }

        public Builder setAuthorizationUrl(String str) {
            a();
            ((AuthProvider) this.a).setAuthorizationUrl(str);
            return this;
        }

        public Builder setAuthorizationUrlBytes(ByteString byteString) {
            a();
            ((AuthProvider) this.a).setAuthorizationUrlBytes(byteString);
            return this;
        }

        public Builder setId(String str) {
            a();
            ((AuthProvider) this.a).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            a();
            ((AuthProvider) this.a).setIdBytes(byteString);
            return this;
        }

        public Builder setIssuer(String str) {
            a();
            ((AuthProvider) this.a).setIssuer(str);
            return this;
        }

        public Builder setIssuerBytes(ByteString byteString) {
            a();
            ((AuthProvider) this.a).setIssuerBytes(byteString);
            return this;
        }

        public Builder setJwksUri(String str) {
            a();
            ((AuthProvider) this.a).setJwksUri(str);
            return this;
        }

        public Builder setJwksUriBytes(ByteString byteString) {
            a();
            ((AuthProvider) this.a).setJwksUriBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private AuthProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudiences() {
        this.audiences_ = getDefaultInstance().getAudiences();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthorizationUrl() {
        this.authorizationUrl_ = getDefaultInstance().getAuthorizationUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIssuer() {
        this.issuer_ = getDefaultInstance().getIssuer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJwksUri() {
        this.jwksUri_ = getDefaultInstance().getJwksUri();
    }

    public static AuthProvider getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthProvider authProvider) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) authProvider);
    }

    public static AuthProvider parseDelimitedFrom(InputStream inputStream) {
        return (AuthProvider) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthProvider parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthProvider) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(ByteString byteString) {
        return (AuthProvider) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static AuthProvider parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthProvider) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(CodedInputStream codedInputStream) {
        return (AuthProvider) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthProvider parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthProvider) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(InputStream inputStream) {
        return (AuthProvider) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthProvider parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthProvider) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(byte[] bArr) {
        return (AuthProvider) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static AuthProvider parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthProvider) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<AuthProvider> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudiences(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.audiences_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudiencesBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.audiences_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorizationUrl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.authorizationUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorizationUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.authorizationUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIssuer(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.issuer_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIssuerBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.issuer_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJwksUri(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.jwksUri_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJwksUriBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.jwksUri_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthProvider();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuthProvider authProvider = (AuthProvider) obj2;
                this.id_ = visitor.visitString(!this.id_.isEmpty(), this.id_, !authProvider.id_.isEmpty(), authProvider.id_);
                this.issuer_ = visitor.visitString(!this.issuer_.isEmpty(), this.issuer_, !authProvider.issuer_.isEmpty(), authProvider.issuer_);
                this.jwksUri_ = visitor.visitString(!this.jwksUri_.isEmpty(), this.jwksUri_, !authProvider.jwksUri_.isEmpty(), authProvider.jwksUri_);
                this.audiences_ = visitor.visitString(!this.audiences_.isEmpty(), this.audiences_, !authProvider.audiences_.isEmpty(), authProvider.audiences_);
                this.authorizationUrl_ = visitor.visitString(!this.authorizationUrl_.isEmpty(), this.authorizationUrl_, true ^ authProvider.authorizationUrl_.isEmpty(), authProvider.authorizationUrl_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.id_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.issuer_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.jwksUri_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.audiences_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.authorizationUrl_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (AuthProvider.class) {
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

    @Override // com.google.api.AuthProviderOrBuilder
    public String getAudiences() {
        return this.audiences_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getAudiencesBytes() {
        return ByteString.copyFromUtf8(this.audiences_);
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getAuthorizationUrl() {
        return this.authorizationUrl_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getAuthorizationUrlBytes() {
        return ByteString.copyFromUtf8(this.authorizationUrl_);
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getIssuer() {
        return this.issuer_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getIssuerBytes() {
        return ByteString.copyFromUtf8(this.issuer_);
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public String getJwksUri() {
        return this.jwksUri_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public ByteString getJwksUriBytes() {
        return ByteString.copyFromUtf8(this.jwksUri_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.id_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getId());
        if (!this.issuer_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getIssuer());
        }
        if (!this.jwksUri_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getJwksUri());
        }
        if (!this.audiences_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(4, getAudiences());
        }
        if (!this.authorizationUrl_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(5, getAuthorizationUrl());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.id_.isEmpty()) {
            codedOutputStream.writeString(1, getId());
        }
        if (!this.issuer_.isEmpty()) {
            codedOutputStream.writeString(2, getIssuer());
        }
        if (!this.jwksUri_.isEmpty()) {
            codedOutputStream.writeString(3, getJwksUri());
        }
        if (!this.audiences_.isEmpty()) {
            codedOutputStream.writeString(4, getAudiences());
        }
        if (this.authorizationUrl_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(5, getAuthorizationUrl());
    }
}
