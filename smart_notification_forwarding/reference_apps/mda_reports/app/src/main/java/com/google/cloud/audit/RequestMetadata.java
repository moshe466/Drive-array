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
public final class RequestMetadata extends GeneratedMessageLite<RequestMetadata, Builder> implements RequestMetadataOrBuilder {
    public static final int CALLER_IP_FIELD_NUMBER = 1;
    public static final int CALLER_SUPPLIED_USER_AGENT_FIELD_NUMBER = 2;
    private static final RequestMetadata DEFAULT_INSTANCE = new RequestMetadata();
    private static volatile Parser<RequestMetadata> PARSER;
    private String callerIp_ = "";
    private String callerSuppliedUserAgent_ = "";

    /* renamed from: com.google.cloud.audit.RequestMetadata$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<RequestMetadata, Builder> implements RequestMetadataOrBuilder {
        private Builder() {
            super(RequestMetadata.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCallerIp() {
            a();
            ((RequestMetadata) this.a).clearCallerIp();
            return this;
        }

        public Builder clearCallerSuppliedUserAgent() {
            a();
            ((RequestMetadata) this.a).clearCallerSuppliedUserAgent();
            return this;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public String getCallerIp() {
            return ((RequestMetadata) this.a).getCallerIp();
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public ByteString getCallerIpBytes() {
            return ((RequestMetadata) this.a).getCallerIpBytes();
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public String getCallerSuppliedUserAgent() {
            return ((RequestMetadata) this.a).getCallerSuppliedUserAgent();
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public ByteString getCallerSuppliedUserAgentBytes() {
            return ((RequestMetadata) this.a).getCallerSuppliedUserAgentBytes();
        }

        public Builder setCallerIp(String str) {
            a();
            ((RequestMetadata) this.a).setCallerIp(str);
            return this;
        }

        public Builder setCallerIpBytes(ByteString byteString) {
            a();
            ((RequestMetadata) this.a).setCallerIpBytes(byteString);
            return this;
        }

        public Builder setCallerSuppliedUserAgent(String str) {
            a();
            ((RequestMetadata) this.a).setCallerSuppliedUserAgent(str);
            return this;
        }

        public Builder setCallerSuppliedUserAgentBytes(ByteString byteString) {
            a();
            ((RequestMetadata) this.a).setCallerSuppliedUserAgentBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private RequestMetadata() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallerIp() {
        this.callerIp_ = getDefaultInstance().getCallerIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallerSuppliedUserAgent() {
        this.callerSuppliedUserAgent_ = getDefaultInstance().getCallerSuppliedUserAgent();
    }

    public static RequestMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RequestMetadata requestMetadata) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) requestMetadata);
    }

    public static RequestMetadata parseDelimitedFrom(InputStream inputStream) {
        return (RequestMetadata) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestMetadata) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(ByteString byteString) {
        return (RequestMetadata) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static RequestMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestMetadata) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(CodedInputStream codedInputStream) {
        return (RequestMetadata) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RequestMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestMetadata) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(InputStream inputStream) {
        return (RequestMetadata) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestMetadata) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(byte[] bArr) {
        return (RequestMetadata) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static RequestMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestMetadata) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<RequestMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerIp(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.callerIp_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerIpBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.callerIp_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerSuppliedUserAgent(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.callerSuppliedUserAgent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerSuppliedUserAgentBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.callerSuppliedUserAgent_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new RequestMetadata();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                RequestMetadata requestMetadata = (RequestMetadata) obj2;
                this.callerIp_ = visitor.visitString(!this.callerIp_.isEmpty(), this.callerIp_, !requestMetadata.callerIp_.isEmpty(), requestMetadata.callerIp_);
                this.callerSuppliedUserAgent_ = visitor.visitString(!this.callerSuppliedUserAgent_.isEmpty(), this.callerSuppliedUserAgent_, true ^ requestMetadata.callerSuppliedUserAgent_.isEmpty(), requestMetadata.callerSuppliedUserAgent_);
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
                                this.callerIp_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.callerSuppliedUserAgent_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (RequestMetadata.class) {
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

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public String getCallerIp() {
        return this.callerIp_;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public ByteString getCallerIpBytes() {
        return ByteString.copyFromUtf8(this.callerIp_);
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public String getCallerSuppliedUserAgent() {
        return this.callerSuppliedUserAgent_;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public ByteString getCallerSuppliedUserAgentBytes() {
        return ByteString.copyFromUtf8(this.callerSuppliedUserAgent_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.callerIp_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getCallerIp());
        if (!this.callerSuppliedUserAgent_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getCallerSuppliedUserAgent());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.callerIp_.isEmpty()) {
            codedOutputStream.writeString(1, getCallerIp());
        }
        if (this.callerSuppliedUserAgent_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getCallerSuppliedUserAgent());
    }
}
