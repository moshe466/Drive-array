package com.google.rpc;

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
public final class RequestInfo extends GeneratedMessageLite<RequestInfo, Builder> implements RequestInfoOrBuilder {
    private static final RequestInfo DEFAULT_INSTANCE = new RequestInfo();
    private static volatile Parser<RequestInfo> PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int SERVING_DATA_FIELD_NUMBER = 2;
    private String requestId_ = "";
    private String servingData_ = "";

    /* renamed from: com.google.rpc.RequestInfo$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<RequestInfo, Builder> implements RequestInfoOrBuilder {
        private Builder() {
            super(RequestInfo.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRequestId() {
            a();
            ((RequestInfo) this.a).clearRequestId();
            return this;
        }

        public Builder clearServingData() {
            a();
            ((RequestInfo) this.a).clearServingData();
            return this;
        }

        @Override // com.google.rpc.RequestInfoOrBuilder
        public String getRequestId() {
            return ((RequestInfo) this.a).getRequestId();
        }

        @Override // com.google.rpc.RequestInfoOrBuilder
        public ByteString getRequestIdBytes() {
            return ((RequestInfo) this.a).getRequestIdBytes();
        }

        @Override // com.google.rpc.RequestInfoOrBuilder
        public String getServingData() {
            return ((RequestInfo) this.a).getServingData();
        }

        @Override // com.google.rpc.RequestInfoOrBuilder
        public ByteString getServingDataBytes() {
            return ((RequestInfo) this.a).getServingDataBytes();
        }

        public Builder setRequestId(String str) {
            a();
            ((RequestInfo) this.a).setRequestId(str);
            return this;
        }

        public Builder setRequestIdBytes(ByteString byteString) {
            a();
            ((RequestInfo) this.a).setRequestIdBytes(byteString);
            return this;
        }

        public Builder setServingData(String str) {
            a();
            ((RequestInfo) this.a).setServingData(str);
            return this;
        }

        public Builder setServingDataBytes(ByteString byteString) {
            a();
            ((RequestInfo) this.a).setServingDataBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private RequestInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServingData() {
        this.servingData_ = getDefaultInstance().getServingData();
    }

    public static RequestInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RequestInfo requestInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) requestInfo);
    }

    public static RequestInfo parseDelimitedFrom(InputStream inputStream) {
        return (RequestInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestInfo parseFrom(ByteString byteString) {
        return (RequestInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static RequestInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RequestInfo parseFrom(CodedInputStream codedInputStream) {
        return (RequestInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RequestInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static RequestInfo parseFrom(InputStream inputStream) {
        return (RequestInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestInfo parseFrom(byte[] bArr) {
        return (RequestInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static RequestInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RequestInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<RequestInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.requestId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.requestId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServingData(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.servingData_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServingDataBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.servingData_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new RequestInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                RequestInfo requestInfo = (RequestInfo) obj2;
                this.requestId_ = visitor.visitString(!this.requestId_.isEmpty(), this.requestId_, !requestInfo.requestId_.isEmpty(), requestInfo.requestId_);
                this.servingData_ = visitor.visitString(!this.servingData_.isEmpty(), this.servingData_, true ^ requestInfo.servingData_.isEmpty(), requestInfo.servingData_);
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
                                this.requestId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.servingData_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (RequestInfo.class) {
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

    @Override // com.google.rpc.RequestInfoOrBuilder
    public String getRequestId() {
        return this.requestId_;
    }

    @Override // com.google.rpc.RequestInfoOrBuilder
    public ByteString getRequestIdBytes() {
        return ByteString.copyFromUtf8(this.requestId_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.requestId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getRequestId());
        if (!this.servingData_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getServingData());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.rpc.RequestInfoOrBuilder
    public String getServingData() {
        return this.servingData_;
    }

    @Override // com.google.rpc.RequestInfoOrBuilder
    public ByteString getServingDataBytes() {
        return ByteString.copyFromUtf8(this.servingData_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.requestId_.isEmpty()) {
            codedOutputStream.writeString(1, getRequestId());
        }
        if (this.servingData_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getServingData());
    }
}
