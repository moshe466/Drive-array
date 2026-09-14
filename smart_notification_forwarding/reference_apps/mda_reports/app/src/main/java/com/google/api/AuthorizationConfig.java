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
public final class AuthorizationConfig extends GeneratedMessageLite<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {
    private static final AuthorizationConfig DEFAULT_INSTANCE = new AuthorizationConfig();
    private static volatile Parser<AuthorizationConfig> PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 1;
    private String provider_ = "";

    /* renamed from: com.google.api.AuthorizationConfig$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {
        private Builder() {
            super(AuthorizationConfig.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearProvider() {
            a();
            ((AuthorizationConfig) this.a).clearProvider();
            return this;
        }

        @Override // com.google.api.AuthorizationConfigOrBuilder
        public String getProvider() {
            return ((AuthorizationConfig) this.a).getProvider();
        }

        @Override // com.google.api.AuthorizationConfigOrBuilder
        public ByteString getProviderBytes() {
            return ((AuthorizationConfig) this.a).getProviderBytes();
        }

        public Builder setProvider(String str) {
            a();
            ((AuthorizationConfig) this.a).setProvider(str);
            return this;
        }

        public Builder setProviderBytes(ByteString byteString) {
            a();
            ((AuthorizationConfig) this.a).setProviderBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private AuthorizationConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProvider() {
        this.provider_ = getDefaultInstance().getProvider();
    }

    public static AuthorizationConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthorizationConfig authorizationConfig) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) authorizationConfig);
    }

    public static AuthorizationConfig parseDelimitedFrom(InputStream inputStream) {
        return (AuthorizationConfig) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthorizationConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationConfig) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthorizationConfig parseFrom(ByteString byteString) {
        return (AuthorizationConfig) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static AuthorizationConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationConfig) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthorizationConfig parseFrom(CodedInputStream codedInputStream) {
        return (AuthorizationConfig) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthorizationConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationConfig) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static AuthorizationConfig parseFrom(InputStream inputStream) {
        return (AuthorizationConfig) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthorizationConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationConfig) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthorizationConfig parseFrom(byte[] bArr) {
        return (AuthorizationConfig) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static AuthorizationConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationConfig) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<AuthorizationConfig> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProvider(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.provider_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProviderBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.provider_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthorizationConfig();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                AuthorizationConfig authorizationConfig = (AuthorizationConfig) obj2;
                this.provider_ = ((GeneratedMessageLite.Visitor) obj).visitString(!this.provider_.isEmpty(), this.provider_, true ^ authorizationConfig.provider_.isEmpty(), authorizationConfig.provider_);
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
                                this.provider_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (AuthorizationConfig.class) {
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

    @Override // com.google.api.AuthorizationConfigOrBuilder
    public String getProvider() {
        return this.provider_;
    }

    @Override // com.google.api.AuthorizationConfigOrBuilder
    public ByteString getProviderBytes() {
        return ByteString.copyFromUtf8(this.provider_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.provider_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getProvider());
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.provider_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(1, getProvider());
    }
}
