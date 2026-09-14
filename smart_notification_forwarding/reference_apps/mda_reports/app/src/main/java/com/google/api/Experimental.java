package com.google.api;

import com.google.api.AuthorizationConfig;
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
public final class Experimental extends GeneratedMessageLite<Experimental, Builder> implements ExperimentalOrBuilder {
    public static final int AUTHORIZATION_FIELD_NUMBER = 8;
    private static final Experimental DEFAULT_INSTANCE = new Experimental();
    private static volatile Parser<Experimental> PARSER;
    private AuthorizationConfig authorization_;

    /* renamed from: com.google.api.Experimental$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Experimental, Builder> implements ExperimentalOrBuilder {
        private Builder() {
            super(Experimental.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAuthorization() {
            a();
            ((Experimental) this.a).clearAuthorization();
            return this;
        }

        @Override // com.google.api.ExperimentalOrBuilder
        public AuthorizationConfig getAuthorization() {
            return ((Experimental) this.a).getAuthorization();
        }

        @Override // com.google.api.ExperimentalOrBuilder
        public boolean hasAuthorization() {
            return ((Experimental) this.a).hasAuthorization();
        }

        public Builder mergeAuthorization(AuthorizationConfig authorizationConfig) {
            a();
            ((Experimental) this.a).mergeAuthorization(authorizationConfig);
            return this;
        }

        public Builder setAuthorization(AuthorizationConfig.Builder builder) {
            a();
            ((Experimental) this.a).setAuthorization(builder);
            return this;
        }

        public Builder setAuthorization(AuthorizationConfig authorizationConfig) {
            a();
            ((Experimental) this.a).setAuthorization(authorizationConfig);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Experimental() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthorization() {
        this.authorization_ = null;
    }

    public static Experimental getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAuthorization(AuthorizationConfig authorizationConfig) {
        AuthorizationConfig authorizationConfig2 = this.authorization_;
        if (authorizationConfig2 != null && authorizationConfig2 != AuthorizationConfig.getDefaultInstance()) {
            authorizationConfig = AuthorizationConfig.newBuilder(this.authorization_).mergeFrom((AuthorizationConfig.Builder) authorizationConfig).buildPartial();
        }
        this.authorization_ = authorizationConfig;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Experimental experimental) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) experimental);
    }

    public static Experimental parseDelimitedFrom(InputStream inputStream) {
        return (Experimental) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Experimental parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Experimental) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Experimental parseFrom(ByteString byteString) {
        return (Experimental) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Experimental parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Experimental) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Experimental parseFrom(CodedInputStream codedInputStream) {
        return (Experimental) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Experimental parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Experimental) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Experimental parseFrom(InputStream inputStream) {
        return (Experimental) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Experimental parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Experimental) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Experimental parseFrom(byte[] bArr) {
        return (Experimental) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Experimental parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Experimental) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Experimental> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorization(AuthorizationConfig.Builder builder) {
        this.authorization_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorization(AuthorizationConfig authorizationConfig) {
        if (authorizationConfig == null) {
            throw new NullPointerException();
        }
        this.authorization_ = authorizationConfig;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Experimental();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.authorization_ = (AuthorizationConfig) ((GeneratedMessageLite.Visitor) obj).visitMessage(this.authorization_, ((Experimental) obj2).authorization_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                if (readTag == 66) {
                                    AuthorizationConfig.Builder builder = this.authorization_ != null ? this.authorization_.toBuilder() : null;
                                    this.authorization_ = (AuthorizationConfig) codedInputStream.readMessage(AuthorizationConfig.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((AuthorizationConfig.Builder) this.authorization_);
                                        this.authorization_ = builder.buildPartial();
                                    }
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
                    synchronized (Experimental.class) {
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

    @Override // com.google.api.ExperimentalOrBuilder
    public AuthorizationConfig getAuthorization() {
        AuthorizationConfig authorizationConfig = this.authorization_;
        return authorizationConfig == null ? AuthorizationConfig.getDefaultInstance() : authorizationConfig;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.authorization_ != null ? 0 + CodedOutputStream.computeMessageSize(8, getAuthorization()) : 0;
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.api.ExperimentalOrBuilder
    public boolean hasAuthorization() {
        return this.authorization_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.authorization_ != null) {
            codedOutputStream.writeMessage(8, getAuthorization());
        }
    }
}
