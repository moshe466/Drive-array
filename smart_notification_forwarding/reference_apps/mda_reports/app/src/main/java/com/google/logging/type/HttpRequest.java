package com.google.logging.type;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class HttpRequest extends GeneratedMessageLite<HttpRequest, Builder> implements HttpRequestOrBuilder {
    public static final int CACHE_FILL_BYTES_FIELD_NUMBER = 12;
    public static final int CACHE_HIT_FIELD_NUMBER = 9;
    public static final int CACHE_LOOKUP_FIELD_NUMBER = 11;
    public static final int CACHE_VALIDATED_WITH_ORIGIN_SERVER_FIELD_NUMBER = 10;
    private static final HttpRequest DEFAULT_INSTANCE = new HttpRequest();
    public static final int LATENCY_FIELD_NUMBER = 14;
    private static volatile Parser<HttpRequest> PARSER = null;
    public static final int PROTOCOL_FIELD_NUMBER = 15;
    public static final int REFERER_FIELD_NUMBER = 8;
    public static final int REMOTE_IP_FIELD_NUMBER = 7;
    public static final int REQUEST_METHOD_FIELD_NUMBER = 1;
    public static final int REQUEST_SIZE_FIELD_NUMBER = 3;
    public static final int REQUEST_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_SIZE_FIELD_NUMBER = 5;
    public static final int SERVER_IP_FIELD_NUMBER = 13;
    public static final int STATUS_FIELD_NUMBER = 4;
    public static final int USER_AGENT_FIELD_NUMBER = 6;
    private long cacheFillBytes_;
    private boolean cacheHit_;
    private boolean cacheLookup_;
    private boolean cacheValidatedWithOriginServer_;
    private Duration latency_;
    private long requestSize_;
    private long responseSize_;
    private int status_;
    private String requestMethod_ = "";
    private String requestUrl_ = "";
    private String userAgent_ = "";
    private String remoteIp_ = "";
    private String serverIp_ = "";
    private String referer_ = "";
    private String protocol_ = "";

    /* renamed from: com.google.logging.type.HttpRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRequest, Builder> implements HttpRequestOrBuilder {
        private Builder() {
            super(HttpRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCacheFillBytes() {
            a();
            ((HttpRequest) this.a).clearCacheFillBytes();
            return this;
        }

        public Builder clearCacheHit() {
            a();
            ((HttpRequest) this.a).clearCacheHit();
            return this;
        }

        public Builder clearCacheLookup() {
            a();
            ((HttpRequest) this.a).clearCacheLookup();
            return this;
        }

        public Builder clearCacheValidatedWithOriginServer() {
            a();
            ((HttpRequest) this.a).clearCacheValidatedWithOriginServer();
            return this;
        }

        public Builder clearLatency() {
            a();
            ((HttpRequest) this.a).clearLatency();
            return this;
        }

        public Builder clearProtocol() {
            a();
            ((HttpRequest) this.a).clearProtocol();
            return this;
        }

        public Builder clearReferer() {
            a();
            ((HttpRequest) this.a).clearReferer();
            return this;
        }

        public Builder clearRemoteIp() {
            a();
            ((HttpRequest) this.a).clearRemoteIp();
            return this;
        }

        public Builder clearRequestMethod() {
            a();
            ((HttpRequest) this.a).clearRequestMethod();
            return this;
        }

        public Builder clearRequestSize() {
            a();
            ((HttpRequest) this.a).clearRequestSize();
            return this;
        }

        public Builder clearRequestUrl() {
            a();
            ((HttpRequest) this.a).clearRequestUrl();
            return this;
        }

        public Builder clearResponseSize() {
            a();
            ((HttpRequest) this.a).clearResponseSize();
            return this;
        }

        public Builder clearServerIp() {
            a();
            ((HttpRequest) this.a).clearServerIp();
            return this;
        }

        public Builder clearStatus() {
            a();
            ((HttpRequest) this.a).clearStatus();
            return this;
        }

        public Builder clearUserAgent() {
            a();
            ((HttpRequest) this.a).clearUserAgent();
            return this;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getCacheFillBytes() {
            return ((HttpRequest) this.a).getCacheFillBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheHit() {
            return ((HttpRequest) this.a).getCacheHit();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheLookup() {
            return ((HttpRequest) this.a).getCacheLookup();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheValidatedWithOriginServer() {
            return ((HttpRequest) this.a).getCacheValidatedWithOriginServer();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public Duration getLatency() {
            return ((HttpRequest) this.a).getLatency();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getProtocol() {
            return ((HttpRequest) this.a).getProtocol();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getProtocolBytes() {
            return ((HttpRequest) this.a).getProtocolBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getReferer() {
            return ((HttpRequest) this.a).getReferer();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRefererBytes() {
            return ((HttpRequest) this.a).getRefererBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRemoteIp() {
            return ((HttpRequest) this.a).getRemoteIp();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRemoteIpBytes() {
            return ((HttpRequest) this.a).getRemoteIpBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRequestMethod() {
            return ((HttpRequest) this.a).getRequestMethod();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRequestMethodBytes() {
            return ((HttpRequest) this.a).getRequestMethodBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getRequestSize() {
            return ((HttpRequest) this.a).getRequestSize();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRequestUrl() {
            return ((HttpRequest) this.a).getRequestUrl();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRequestUrlBytes() {
            return ((HttpRequest) this.a).getRequestUrlBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getResponseSize() {
            return ((HttpRequest) this.a).getResponseSize();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getServerIp() {
            return ((HttpRequest) this.a).getServerIp();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getServerIpBytes() {
            return ((HttpRequest) this.a).getServerIpBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public int getStatus() {
            return ((HttpRequest) this.a).getStatus();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getUserAgent() {
            return ((HttpRequest) this.a).getUserAgent();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getUserAgentBytes() {
            return ((HttpRequest) this.a).getUserAgentBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean hasLatency() {
            return ((HttpRequest) this.a).hasLatency();
        }

        public Builder mergeLatency(Duration duration) {
            a();
            ((HttpRequest) this.a).mergeLatency(duration);
            return this;
        }

        public Builder setCacheFillBytes(long j) {
            a();
            ((HttpRequest) this.a).setCacheFillBytes(j);
            return this;
        }

        public Builder setCacheHit(boolean z) {
            a();
            ((HttpRequest) this.a).setCacheHit(z);
            return this;
        }

        public Builder setCacheLookup(boolean z) {
            a();
            ((HttpRequest) this.a).setCacheLookup(z);
            return this;
        }

        public Builder setCacheValidatedWithOriginServer(boolean z) {
            a();
            ((HttpRequest) this.a).setCacheValidatedWithOriginServer(z);
            return this;
        }

        public Builder setLatency(Duration.Builder builder) {
            a();
            ((HttpRequest) this.a).setLatency(builder);
            return this;
        }

        public Builder setLatency(Duration duration) {
            a();
            ((HttpRequest) this.a).setLatency(duration);
            return this;
        }

        public Builder setProtocol(String str) {
            a();
            ((HttpRequest) this.a).setProtocol(str);
            return this;
        }

        public Builder setProtocolBytes(ByteString byteString) {
            a();
            ((HttpRequest) this.a).setProtocolBytes(byteString);
            return this;
        }

        public Builder setReferer(String str) {
            a();
            ((HttpRequest) this.a).setReferer(str);
            return this;
        }

        public Builder setRefererBytes(ByteString byteString) {
            a();
            ((HttpRequest) this.a).setRefererBytes(byteString);
            return this;
        }

        public Builder setRemoteIp(String str) {
            a();
            ((HttpRequest) this.a).setRemoteIp(str);
            return this;
        }

        public Builder setRemoteIpBytes(ByteString byteString) {
            a();
            ((HttpRequest) this.a).setRemoteIpBytes(byteString);
            return this;
        }

        public Builder setRequestMethod(String str) {
            a();
            ((HttpRequest) this.a).setRequestMethod(str);
            return this;
        }

        public Builder setRequestMethodBytes(ByteString byteString) {
            a();
            ((HttpRequest) this.a).setRequestMethodBytes(byteString);
            return this;
        }

        public Builder setRequestSize(long j) {
            a();
            ((HttpRequest) this.a).setRequestSize(j);
            return this;
        }

        public Builder setRequestUrl(String str) {
            a();
            ((HttpRequest) this.a).setRequestUrl(str);
            return this;
        }

        public Builder setRequestUrlBytes(ByteString byteString) {
            a();
            ((HttpRequest) this.a).setRequestUrlBytes(byteString);
            return this;
        }

        public Builder setResponseSize(long j) {
            a();
            ((HttpRequest) this.a).setResponseSize(j);
            return this;
        }

        public Builder setServerIp(String str) {
            a();
            ((HttpRequest) this.a).setServerIp(str);
            return this;
        }

        public Builder setServerIpBytes(ByteString byteString) {
            a();
            ((HttpRequest) this.a).setServerIpBytes(byteString);
            return this;
        }

        public Builder setStatus(int i) {
            a();
            ((HttpRequest) this.a).setStatus(i);
            return this;
        }

        public Builder setUserAgent(String str) {
            a();
            ((HttpRequest) this.a).setUserAgent(str);
            return this;
        }

        public Builder setUserAgentBytes(ByteString byteString) {
            a();
            ((HttpRequest) this.a).setUserAgentBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private HttpRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCacheFillBytes() {
        this.cacheFillBytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCacheHit() {
        this.cacheHit_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCacheLookup() {
        this.cacheLookup_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCacheValidatedWithOriginServer() {
        this.cacheValidatedWithOriginServer_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLatency() {
        this.latency_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProtocol() {
        this.protocol_ = getDefaultInstance().getProtocol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReferer() {
        this.referer_ = getDefaultInstance().getReferer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRemoteIp() {
        this.remoteIp_ = getDefaultInstance().getRemoteIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestMethod() {
        this.requestMethod_ = getDefaultInstance().getRequestMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestSize() {
        this.requestSize_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestUrl() {
        this.requestUrl_ = getDefaultInstance().getRequestUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseSize() {
        this.responseSize_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerIp() {
        this.serverIp_ = getDefaultInstance().getServerIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUserAgent() {
        this.userAgent_ = getDefaultInstance().getUserAgent();
    }

    public static HttpRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLatency(Duration duration) {
        Duration duration2 = this.latency_;
        if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
            duration = Duration.newBuilder(this.latency_).mergeFrom((Duration.Builder) duration).buildPartial();
        }
        this.latency_ = duration;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HttpRequest httpRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) httpRequest);
    }

    public static HttpRequest parseDelimitedFrom(InputStream inputStream) {
        return (HttpRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(ByteString byteString) {
        return (HttpRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static HttpRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(CodedInputStream codedInputStream) {
        return (HttpRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HttpRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(InputStream inputStream) {
        return (HttpRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(byte[] bArr) {
        return (HttpRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static HttpRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HttpRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<HttpRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheFillBytes(long j) {
        this.cacheFillBytes_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheHit(boolean z) {
        this.cacheHit_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheLookup(boolean z) {
        this.cacheLookup_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheValidatedWithOriginServer(boolean z) {
        this.cacheValidatedWithOriginServer_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLatency(Duration.Builder builder) {
        this.latency_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLatency(Duration duration) {
        if (duration == null) {
            throw new NullPointerException();
        }
        this.latency_ = duration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocol(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.protocol_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocolBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.protocol_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReferer(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.referer_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefererBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.referer_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemoteIp(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.remoteIp_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemoteIpBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.remoteIp_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestMethod(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.requestMethod_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestMethodBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.requestMethod_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestSize(long j) {
        this.requestSize_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestUrl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.requestUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.requestUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseSize(long j) {
        this.responseSize_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerIp(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.serverIp_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerIpBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.serverIp_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        this.status_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserAgent(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.userAgent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserAgentBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.userAgent_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new HttpRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                HttpRequest httpRequest = (HttpRequest) obj2;
                this.requestMethod_ = visitor.visitString(!this.requestMethod_.isEmpty(), this.requestMethod_, !httpRequest.requestMethod_.isEmpty(), httpRequest.requestMethod_);
                this.requestUrl_ = visitor.visitString(!this.requestUrl_.isEmpty(), this.requestUrl_, !httpRequest.requestUrl_.isEmpty(), httpRequest.requestUrl_);
                this.requestSize_ = visitor.visitLong(this.requestSize_ != 0, this.requestSize_, httpRequest.requestSize_ != 0, httpRequest.requestSize_);
                this.status_ = visitor.visitInt(this.status_ != 0, this.status_, httpRequest.status_ != 0, httpRequest.status_);
                this.responseSize_ = visitor.visitLong(this.responseSize_ != 0, this.responseSize_, httpRequest.responseSize_ != 0, httpRequest.responseSize_);
                this.userAgent_ = visitor.visitString(!this.userAgent_.isEmpty(), this.userAgent_, !httpRequest.userAgent_.isEmpty(), httpRequest.userAgent_);
                this.remoteIp_ = visitor.visitString(!this.remoteIp_.isEmpty(), this.remoteIp_, !httpRequest.remoteIp_.isEmpty(), httpRequest.remoteIp_);
                this.serverIp_ = visitor.visitString(!this.serverIp_.isEmpty(), this.serverIp_, !httpRequest.serverIp_.isEmpty(), httpRequest.serverIp_);
                this.referer_ = visitor.visitString(!this.referer_.isEmpty(), this.referer_, !httpRequest.referer_.isEmpty(), httpRequest.referer_);
                this.latency_ = (Duration) visitor.visitMessage(this.latency_, httpRequest.latency_);
                boolean z2 = this.cacheLookup_;
                boolean z3 = httpRequest.cacheLookup_;
                this.cacheLookup_ = visitor.visitBoolean(z2, z2, z3, z3);
                boolean z4 = this.cacheHit_;
                boolean z5 = httpRequest.cacheHit_;
                this.cacheHit_ = visitor.visitBoolean(z4, z4, z5, z5);
                boolean z6 = this.cacheValidatedWithOriginServer_;
                boolean z7 = httpRequest.cacheValidatedWithOriginServer_;
                this.cacheValidatedWithOriginServer_ = visitor.visitBoolean(z6, z6, z7, z7);
                this.cacheFillBytes_ = visitor.visitLong(this.cacheFillBytes_ != 0, this.cacheFillBytes_, httpRequest.cacheFillBytes_ != 0, httpRequest.cacheFillBytes_);
                this.protocol_ = visitor.visitString(!this.protocol_.isEmpty(), this.protocol_, !httpRequest.protocol_.isEmpty(), httpRequest.protocol_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                case 10:
                                    this.requestMethod_ = codedInputStream.readStringRequireUtf8();
                                case 18:
                                    this.requestUrl_ = codedInputStream.readStringRequireUtf8();
                                case 24:
                                    this.requestSize_ = codedInputStream.readInt64();
                                case 32:
                                    this.status_ = codedInputStream.readInt32();
                                case 40:
                                    this.responseSize_ = codedInputStream.readInt64();
                                case 50:
                                    this.userAgent_ = codedInputStream.readStringRequireUtf8();
                                case 58:
                                    this.remoteIp_ = codedInputStream.readStringRequireUtf8();
                                case 66:
                                    this.referer_ = codedInputStream.readStringRequireUtf8();
                                case 72:
                                    this.cacheHit_ = codedInputStream.readBool();
                                case 80:
                                    this.cacheValidatedWithOriginServer_ = codedInputStream.readBool();
                                case 88:
                                    this.cacheLookup_ = codedInputStream.readBool();
                                case 96:
                                    this.cacheFillBytes_ = codedInputStream.readInt64();
                                case 106:
                                    this.serverIp_ = codedInputStream.readStringRequireUtf8();
                                case 114:
                                    Duration.Builder builder = this.latency_ != null ? this.latency_.toBuilder() : null;
                                    this.latency_ = (Duration) codedInputStream.readMessage(Duration.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Duration.Builder) this.latency_);
                                        this.latency_ = builder.buildPartial();
                                    }
                                case 122:
                                    this.protocol_ = codedInputStream.readStringRequireUtf8();
                                default:
                                    if (!codedInputStream.skipField(readTag)) {
                                        z = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (HttpRequest.class) {
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

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getCacheFillBytes() {
        return this.cacheFillBytes_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheHit() {
        return this.cacheHit_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheLookup() {
        return this.cacheLookup_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheValidatedWithOriginServer() {
        return this.cacheValidatedWithOriginServer_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public Duration getLatency() {
        Duration duration = this.latency_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getProtocol() {
        return this.protocol_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getProtocolBytes() {
        return ByteString.copyFromUtf8(this.protocol_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getReferer() {
        return this.referer_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRefererBytes() {
        return ByteString.copyFromUtf8(this.referer_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRemoteIp() {
        return this.remoteIp_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRemoteIpBytes() {
        return ByteString.copyFromUtf8(this.remoteIp_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRequestMethod() {
        return this.requestMethod_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRequestMethodBytes() {
        return ByteString.copyFromUtf8(this.requestMethod_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getRequestSize() {
        return this.requestSize_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRequestUrl() {
        return this.requestUrl_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRequestUrlBytes() {
        return ByteString.copyFromUtf8(this.requestUrl_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getResponseSize() {
        return this.responseSize_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.requestMethod_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getRequestMethod());
        if (!this.requestUrl_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getRequestUrl());
        }
        long j = this.requestSize_;
        if (j != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(3, j);
        }
        int i2 = this.status_;
        if (i2 != 0) {
            computeStringSize += CodedOutputStream.computeInt32Size(4, i2);
        }
        long j2 = this.responseSize_;
        if (j2 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(5, j2);
        }
        if (!this.userAgent_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(6, getUserAgent());
        }
        if (!this.remoteIp_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(7, getRemoteIp());
        }
        if (!this.referer_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(8, getReferer());
        }
        boolean z = this.cacheHit_;
        if (z) {
            computeStringSize += CodedOutputStream.computeBoolSize(9, z);
        }
        boolean z2 = this.cacheValidatedWithOriginServer_;
        if (z2) {
            computeStringSize += CodedOutputStream.computeBoolSize(10, z2);
        }
        boolean z3 = this.cacheLookup_;
        if (z3) {
            computeStringSize += CodedOutputStream.computeBoolSize(11, z3);
        }
        long j3 = this.cacheFillBytes_;
        if (j3 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(12, j3);
        }
        if (!this.serverIp_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(13, getServerIp());
        }
        if (this.latency_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(14, getLatency());
        }
        if (!this.protocol_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(15, getProtocol());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getServerIp() {
        return this.serverIp_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getServerIpBytes() {
        return ByteString.copyFromUtf8(this.serverIp_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getUserAgent() {
        return this.userAgent_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getUserAgentBytes() {
        return ByteString.copyFromUtf8(this.userAgent_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean hasLatency() {
        return this.latency_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.requestMethod_.isEmpty()) {
            codedOutputStream.writeString(1, getRequestMethod());
        }
        if (!this.requestUrl_.isEmpty()) {
            codedOutputStream.writeString(2, getRequestUrl());
        }
        long j = this.requestSize_;
        if (j != 0) {
            codedOutputStream.writeInt64(3, j);
        }
        int i = this.status_;
        if (i != 0) {
            codedOutputStream.writeInt32(4, i);
        }
        long j2 = this.responseSize_;
        if (j2 != 0) {
            codedOutputStream.writeInt64(5, j2);
        }
        if (!this.userAgent_.isEmpty()) {
            codedOutputStream.writeString(6, getUserAgent());
        }
        if (!this.remoteIp_.isEmpty()) {
            codedOutputStream.writeString(7, getRemoteIp());
        }
        if (!this.referer_.isEmpty()) {
            codedOutputStream.writeString(8, getReferer());
        }
        boolean z = this.cacheHit_;
        if (z) {
            codedOutputStream.writeBool(9, z);
        }
        boolean z2 = this.cacheValidatedWithOriginServer_;
        if (z2) {
            codedOutputStream.writeBool(10, z2);
        }
        boolean z3 = this.cacheLookup_;
        if (z3) {
            codedOutputStream.writeBool(11, z3);
        }
        long j3 = this.cacheFillBytes_;
        if (j3 != 0) {
            codedOutputStream.writeInt64(12, j3);
        }
        if (!this.serverIp_.isEmpty()) {
            codedOutputStream.writeString(13, getServerIp());
        }
        if (this.latency_ != null) {
            codedOutputStream.writeMessage(14, getLatency());
        }
        if (this.protocol_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(15, getProtocol());
    }
}
