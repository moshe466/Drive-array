package com.google.internal.firebase.inappmessaging.v1.sdkserving;

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
public final class ClientAppInfo extends GeneratedMessageLite<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int APP_INSTANCE_ID_TOKEN_FIELD_NUMBER = 3;
    private static final ClientAppInfo DEFAULT_INSTANCE = new ClientAppInfo();
    public static final int GMP_APP_ID_FIELD_NUMBER = 1;
    private static volatile Parser<ClientAppInfo> PARSER;
    private String gmpAppId_ = "";
    private String appInstanceId_ = "";
    private String appInstanceIdToken_ = "";

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
        private Builder() {
            super(ClientAppInfo.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAppInstanceId() {
            a();
            ((ClientAppInfo) this.a).clearAppInstanceId();
            return this;
        }

        public Builder clearAppInstanceIdToken() {
            a();
            ((ClientAppInfo) this.a).clearAppInstanceIdToken();
            return this;
        }

        public Builder clearGmpAppId() {
            a();
            ((ClientAppInfo) this.a).clearGmpAppId();
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public String getAppInstanceId() {
            return ((ClientAppInfo) this.a).getAppInstanceId();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public ByteString getAppInstanceIdBytes() {
            return ((ClientAppInfo) this.a).getAppInstanceIdBytes();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public String getAppInstanceIdToken() {
            return ((ClientAppInfo) this.a).getAppInstanceIdToken();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public ByteString getAppInstanceIdTokenBytes() {
            return ((ClientAppInfo) this.a).getAppInstanceIdTokenBytes();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public String getGmpAppId() {
            return ((ClientAppInfo) this.a).getGmpAppId();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public ByteString getGmpAppIdBytes() {
            return ((ClientAppInfo) this.a).getGmpAppIdBytes();
        }

        public Builder setAppInstanceId(String str) {
            a();
            ((ClientAppInfo) this.a).setAppInstanceId(str);
            return this;
        }

        public Builder setAppInstanceIdBytes(ByteString byteString) {
            a();
            ((ClientAppInfo) this.a).setAppInstanceIdBytes(byteString);
            return this;
        }

        public Builder setAppInstanceIdToken(String str) {
            a();
            ((ClientAppInfo) this.a).setAppInstanceIdToken(str);
            return this;
        }

        public Builder setAppInstanceIdTokenBytes(ByteString byteString) {
            a();
            ((ClientAppInfo) this.a).setAppInstanceIdTokenBytes(byteString);
            return this;
        }

        public Builder setGmpAppId(String str) {
            a();
            ((ClientAppInfo) this.a).setGmpAppId(str);
            return this;
        }

        public Builder setGmpAppIdBytes(ByteString byteString) {
            a();
            ((ClientAppInfo) this.a).setGmpAppIdBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ClientAppInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppInstanceId() {
        this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppInstanceIdToken() {
        this.appInstanceIdToken_ = getDefaultInstance().getAppInstanceIdToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGmpAppId() {
        this.gmpAppId_ = getDefaultInstance().getGmpAppId();
    }

    public static ClientAppInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ClientAppInfo clientAppInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) clientAppInfo);
    }

    public static ClientAppInfo parseDelimitedFrom(InputStream inputStream) {
        return (ClientAppInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientAppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientAppInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(ByteString byteString) {
        return (ClientAppInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ClientAppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientAppInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(CodedInputStream codedInputStream) {
        return (ClientAppInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientAppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientAppInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(InputStream inputStream) {
        return (ClientAppInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientAppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientAppInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(byte[] bArr) {
        return (ClientAppInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ClientAppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ClientAppInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ClientAppInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppInstanceId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.appInstanceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppInstanceIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.appInstanceId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppInstanceIdToken(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.appInstanceIdToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppInstanceIdTokenBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.appInstanceIdToken_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGmpAppId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.gmpAppId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGmpAppIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.gmpAppId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientAppInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ClientAppInfo clientAppInfo = (ClientAppInfo) obj2;
                this.gmpAppId_ = visitor.visitString(!this.gmpAppId_.isEmpty(), this.gmpAppId_, !clientAppInfo.gmpAppId_.isEmpty(), clientAppInfo.gmpAppId_);
                this.appInstanceId_ = visitor.visitString(!this.appInstanceId_.isEmpty(), this.appInstanceId_, !clientAppInfo.appInstanceId_.isEmpty(), clientAppInfo.appInstanceId_);
                this.appInstanceIdToken_ = visitor.visitString(!this.appInstanceIdToken_.isEmpty(), this.appInstanceIdToken_, true ^ clientAppInfo.appInstanceIdToken_.isEmpty(), clientAppInfo.appInstanceIdToken_);
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
                                this.gmpAppId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.appInstanceId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.appInstanceIdToken_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (ClientAppInfo.class) {
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

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public String getAppInstanceId() {
        return this.appInstanceId_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public ByteString getAppInstanceIdBytes() {
        return ByteString.copyFromUtf8(this.appInstanceId_);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public String getAppInstanceIdToken() {
        return this.appInstanceIdToken_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public ByteString getAppInstanceIdTokenBytes() {
        return ByteString.copyFromUtf8(this.appInstanceIdToken_);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public String getGmpAppId() {
        return this.gmpAppId_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public ByteString getGmpAppIdBytes() {
        return ByteString.copyFromUtf8(this.gmpAppId_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.gmpAppId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getGmpAppId());
        if (!this.appInstanceId_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getAppInstanceId());
        }
        if (!this.appInstanceIdToken_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getAppInstanceIdToken());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.gmpAppId_.isEmpty()) {
            codedOutputStream.writeString(1, getGmpAppId());
        }
        if (!this.appInstanceId_.isEmpty()) {
            codedOutputStream.writeString(2, getAppInstanceId());
        }
        if (this.appInstanceIdToken_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(3, getAppInstanceIdToken());
    }
}
