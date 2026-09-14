package com.google.firebase.inappmessaging;

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
    private static final ClientAppInfo DEFAULT_INSTANCE = new ClientAppInfo();
    public static final int FIREBASE_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    private static volatile Parser<ClientAppInfo> PARSER;
    private int bitField0_;
    private String googleAppId_ = "";
    private String firebaseInstanceId_ = "";

    /* renamed from: com.google.firebase.inappmessaging.ClientAppInfo$1, reason: invalid class name */
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

        public Builder clearFirebaseInstanceId() {
            a();
            ((ClientAppInfo) this.a).clearFirebaseInstanceId();
            return this;
        }

        public Builder clearGoogleAppId() {
            a();
            ((ClientAppInfo) this.a).clearGoogleAppId();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public String getFirebaseInstanceId() {
            return ((ClientAppInfo) this.a).getFirebaseInstanceId();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public ByteString getFirebaseInstanceIdBytes() {
            return ((ClientAppInfo) this.a).getFirebaseInstanceIdBytes();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public String getGoogleAppId() {
            return ((ClientAppInfo) this.a).getGoogleAppId();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public ByteString getGoogleAppIdBytes() {
            return ((ClientAppInfo) this.a).getGoogleAppIdBytes();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public boolean hasFirebaseInstanceId() {
            return ((ClientAppInfo) this.a).hasFirebaseInstanceId();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public boolean hasGoogleAppId() {
            return ((ClientAppInfo) this.a).hasGoogleAppId();
        }

        public Builder setFirebaseInstanceId(String str) {
            a();
            ((ClientAppInfo) this.a).setFirebaseInstanceId(str);
            return this;
        }

        public Builder setFirebaseInstanceIdBytes(ByteString byteString) {
            a();
            ((ClientAppInfo) this.a).setFirebaseInstanceIdBytes(byteString);
            return this;
        }

        public Builder setGoogleAppId(String str) {
            a();
            ((ClientAppInfo) this.a).setGoogleAppId(str);
            return this;
        }

        public Builder setGoogleAppIdBytes(ByteString byteString) {
            a();
            ((ClientAppInfo) this.a).setGoogleAppIdBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ClientAppInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFirebaseInstanceId() {
        this.bitField0_ &= -3;
        this.firebaseInstanceId_ = getDefaultInstance().getFirebaseInstanceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGoogleAppId() {
        this.bitField0_ &= -2;
        this.googleAppId_ = getDefaultInstance().getGoogleAppId();
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
    public void setFirebaseInstanceId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.firebaseInstanceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirebaseInstanceIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.firebaseInstanceId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoogleAppId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.googleAppId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoogleAppIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.googleAppId_ = byteString.toStringUtf8();
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
                this.googleAppId_ = visitor.visitString(hasGoogleAppId(), this.googleAppId_, clientAppInfo.hasGoogleAppId(), clientAppInfo.googleAppId_);
                this.firebaseInstanceId_ = visitor.visitString(hasFirebaseInstanceId(), this.firebaseInstanceId_, clientAppInfo.hasFirebaseInstanceId(), clientAppInfo.firebaseInstanceId_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= clientAppInfo.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                String readString = codedInputStream.readString();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.googleAppId_ = readString;
                            } else if (readTag == 18) {
                                String readString2 = codedInputStream.readString();
                                this.bitField0_ |= 2;
                                this.firebaseInstanceId_ = readString2;
                            } else if (!a(readTag, codedInputStream)) {
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

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public String getFirebaseInstanceId() {
        return this.firebaseInstanceId_;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public ByteString getFirebaseInstanceIdBytes() {
        return ByteString.copyFromUtf8(this.firebaseInstanceId_);
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public String getGoogleAppId() {
        return this.googleAppId_;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public ByteString getGoogleAppIdBytes() {
        return ByteString.copyFromUtf8(this.googleAppId_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getGoogleAppId()) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getFirebaseInstanceId());
        }
        int serializedSize = computeStringSize + this.b.getSerializedSize();
        this.c = serializedSize;
        return serializedSize;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public boolean hasFirebaseInstanceId() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public boolean hasGoogleAppId() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeString(1, getGoogleAppId());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeString(2, getFirebaseInstanceId());
        }
        this.b.writeTo(codedOutputStream);
    }
}
