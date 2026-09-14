package com.google.cloud.audit;

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
public final class AuthorizationInfo extends GeneratedMessageLite<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
    private static final AuthorizationInfo DEFAULT_INSTANCE = new AuthorizationInfo();
    public static final int GRANTED_FIELD_NUMBER = 3;
    private static volatile Parser<AuthorizationInfo> PARSER = null;
    public static final int PERMISSION_FIELD_NUMBER = 2;
    public static final int RESOURCE_FIELD_NUMBER = 1;
    private boolean granted_;
    private String resource_ = "";
    private String permission_ = "";

    /* renamed from: com.google.cloud.audit.AuthorizationInfo$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
        private Builder() {
            super(AuthorizationInfo.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearGranted() {
            a();
            ((AuthorizationInfo) this.a).clearGranted();
            return this;
        }

        public Builder clearPermission() {
            a();
            ((AuthorizationInfo) this.a).clearPermission();
            return this;
        }

        public Builder clearResource() {
            a();
            ((AuthorizationInfo) this.a).clearResource();
            return this;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public boolean getGranted() {
            return ((AuthorizationInfo) this.a).getGranted();
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public String getPermission() {
            return ((AuthorizationInfo) this.a).getPermission();
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public ByteString getPermissionBytes() {
            return ((AuthorizationInfo) this.a).getPermissionBytes();
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public String getResource() {
            return ((AuthorizationInfo) this.a).getResource();
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public ByteString getResourceBytes() {
            return ((AuthorizationInfo) this.a).getResourceBytes();
        }

        public Builder setGranted(boolean z) {
            a();
            ((AuthorizationInfo) this.a).setGranted(z);
            return this;
        }

        public Builder setPermission(String str) {
            a();
            ((AuthorizationInfo) this.a).setPermission(str);
            return this;
        }

        public Builder setPermissionBytes(ByteString byteString) {
            a();
            ((AuthorizationInfo) this.a).setPermissionBytes(byteString);
            return this;
        }

        public Builder setResource(String str) {
            a();
            ((AuthorizationInfo) this.a).setResource(str);
            return this;
        }

        public Builder setResourceBytes(ByteString byteString) {
            a();
            ((AuthorizationInfo) this.a).setResourceBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private AuthorizationInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGranted() {
        this.granted_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPermission() {
        this.permission_ = getDefaultInstance().getPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResource() {
        this.resource_ = getDefaultInstance().getResource();
    }

    public static AuthorizationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthorizationInfo authorizationInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) authorizationInfo);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream inputStream) {
        return (AuthorizationInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(ByteString byteString) {
        return (AuthorizationInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static AuthorizationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream codedInputStream) {
        return (AuthorizationInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(InputStream inputStream) {
        return (AuthorizationInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthorizationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(byte[] bArr) {
        return (AuthorizationInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static AuthorizationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AuthorizationInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<AuthorizationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGranted(boolean z) {
        this.granted_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermission(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.permission_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermissionBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.permission_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResource(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.resource_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.resource_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthorizationInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuthorizationInfo authorizationInfo = (AuthorizationInfo) obj2;
                this.resource_ = visitor.visitString(!this.resource_.isEmpty(), this.resource_, !authorizationInfo.resource_.isEmpty(), authorizationInfo.resource_);
                this.permission_ = visitor.visitString(!this.permission_.isEmpty(), this.permission_, true ^ authorizationInfo.permission_.isEmpty(), authorizationInfo.permission_);
                boolean z = this.granted_;
                boolean z2 = authorizationInfo.granted_;
                this.granted_ = visitor.visitBoolean(z, z, z2, z2);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z3 = false;
                while (!z3) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.resource_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.permission_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.granted_ = codedInputStream.readBool();
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
                    synchronized (AuthorizationInfo.class) {
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

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public boolean getGranted() {
        return this.granted_;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public String getPermission() {
        return this.permission_;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public ByteString getPermissionBytes() {
        return ByteString.copyFromUtf8(this.permission_);
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public String getResource() {
        return this.resource_;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public ByteString getResourceBytes() {
        return ByteString.copyFromUtf8(this.resource_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.resource_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getResource());
        if (!this.permission_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getPermission());
        }
        boolean z = this.granted_;
        if (z) {
            computeStringSize += CodedOutputStream.computeBoolSize(3, z);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.resource_.isEmpty()) {
            codedOutputStream.writeString(1, getResource());
        }
        if (!this.permission_.isEmpty()) {
            codedOutputStream.writeString(2, getPermission());
        }
        boolean z = this.granted_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
    }
}
