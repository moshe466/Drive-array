package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class CampaignAnalytics extends GeneratedMessageLite<CampaignAnalytics, Builder> implements CampaignAnalyticsOrBuilder {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 2;
    public static final int CLIENT_APP_FIELD_NUMBER = 3;
    public static final int CLIENT_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
    private static final CampaignAnalytics DEFAULT_INSTANCE = new CampaignAnalytics();
    public static final int DISMISS_TYPE_FIELD_NUMBER = 6;
    public static final int ENGAGEMENTMETRICS_DELIVERY_RETRY_COUNT_FIELD_NUMBER = 10;
    public static final int EVENT_TYPE_FIELD_NUMBER = 5;
    public static final int FETCH_ERROR_REASON_FIELD_NUMBER = 8;
    public static final int FIAM_SDK_VERSION_FIELD_NUMBER = 9;
    private static volatile Parser<CampaignAnalytics> PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int RENDER_ERROR_REASON_FIELD_NUMBER = 7;
    private int bitField0_;
    private ClientAppInfo clientApp_;
    private long clientTimestampMillis_;
    private int engagementMetricsDeliveryRetryCount_;
    private Object event_;
    private int eventCase_ = 0;
    private String projectNumber_ = "";
    private String campaignId_ = "";
    private String fiamSdkVersion_ = "";

    /* renamed from: com.google.firebase.inappmessaging.CampaignAnalytics$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = new int[EventCase.values().length];
            try {
                a[EventCase.EVENT_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[EventCase.DISMISS_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[EventCase.RENDER_ERROR_REASON.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[EventCase.FETCH_ERROR_REASON.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[EventCase.EVENT_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignAnalytics, Builder> implements CampaignAnalyticsOrBuilder {
        private Builder() {
            super(CampaignAnalytics.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCampaignId() {
            a();
            ((CampaignAnalytics) this.a).clearCampaignId();
            return this;
        }

        public Builder clearClientApp() {
            a();
            ((CampaignAnalytics) this.a).clearClientApp();
            return this;
        }

        public Builder clearClientTimestampMillis() {
            a();
            ((CampaignAnalytics) this.a).clearClientTimestampMillis();
            return this;
        }

        public Builder clearDismissType() {
            a();
            ((CampaignAnalytics) this.a).clearDismissType();
            return this;
        }

        public Builder clearEngagementMetricsDeliveryRetryCount() {
            a();
            ((CampaignAnalytics) this.a).clearEngagementMetricsDeliveryRetryCount();
            return this;
        }

        public Builder clearEvent() {
            a();
            ((CampaignAnalytics) this.a).clearEvent();
            return this;
        }

        public Builder clearEventType() {
            a();
            ((CampaignAnalytics) this.a).clearEventType();
            return this;
        }

        public Builder clearFetchErrorReason() {
            a();
            ((CampaignAnalytics) this.a).clearFetchErrorReason();
            return this;
        }

        public Builder clearFiamSdkVersion() {
            a();
            ((CampaignAnalytics) this.a).clearFiamSdkVersion();
            return this;
        }

        public Builder clearProjectNumber() {
            a();
            ((CampaignAnalytics) this.a).clearProjectNumber();
            return this;
        }

        public Builder clearRenderErrorReason() {
            a();
            ((CampaignAnalytics) this.a).clearRenderErrorReason();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public String getCampaignId() {
            return ((CampaignAnalytics) this.a).getCampaignId();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public ByteString getCampaignIdBytes() {
            return ((CampaignAnalytics) this.a).getCampaignIdBytes();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public ClientAppInfo getClientApp() {
            return ((CampaignAnalytics) this.a).getClientApp();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public long getClientTimestampMillis() {
            return ((CampaignAnalytics) this.a).getClientTimestampMillis();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public DismissType getDismissType() {
            return ((CampaignAnalytics) this.a).getDismissType();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public int getEngagementMetricsDeliveryRetryCount() {
            return ((CampaignAnalytics) this.a).getEngagementMetricsDeliveryRetryCount();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public EventCase getEventCase() {
            return ((CampaignAnalytics) this.a).getEventCase();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public EventType getEventType() {
            return ((CampaignAnalytics) this.a).getEventType();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public FetchErrorReason getFetchErrorReason() {
            return ((CampaignAnalytics) this.a).getFetchErrorReason();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public String getFiamSdkVersion() {
            return ((CampaignAnalytics) this.a).getFiamSdkVersion();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public ByteString getFiamSdkVersionBytes() {
            return ((CampaignAnalytics) this.a).getFiamSdkVersionBytes();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public String getProjectNumber() {
            return ((CampaignAnalytics) this.a).getProjectNumber();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public ByteString getProjectNumberBytes() {
            return ((CampaignAnalytics) this.a).getProjectNumberBytes();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public RenderErrorReason getRenderErrorReason() {
            return ((CampaignAnalytics) this.a).getRenderErrorReason();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasCampaignId() {
            return ((CampaignAnalytics) this.a).hasCampaignId();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasClientApp() {
            return ((CampaignAnalytics) this.a).hasClientApp();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasClientTimestampMillis() {
            return ((CampaignAnalytics) this.a).hasClientTimestampMillis();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasDismissType() {
            return ((CampaignAnalytics) this.a).hasDismissType();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasEngagementMetricsDeliveryRetryCount() {
            return ((CampaignAnalytics) this.a).hasEngagementMetricsDeliveryRetryCount();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasEventType() {
            return ((CampaignAnalytics) this.a).hasEventType();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasFetchErrorReason() {
            return ((CampaignAnalytics) this.a).hasFetchErrorReason();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasFiamSdkVersion() {
            return ((CampaignAnalytics) this.a).hasFiamSdkVersion();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasProjectNumber() {
            return ((CampaignAnalytics) this.a).hasProjectNumber();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasRenderErrorReason() {
            return ((CampaignAnalytics) this.a).hasRenderErrorReason();
        }

        public Builder mergeClientApp(ClientAppInfo clientAppInfo) {
            a();
            ((CampaignAnalytics) this.a).mergeClientApp(clientAppInfo);
            return this;
        }

        public Builder setCampaignId(String str) {
            a();
            ((CampaignAnalytics) this.a).setCampaignId(str);
            return this;
        }

        public Builder setCampaignIdBytes(ByteString byteString) {
            a();
            ((CampaignAnalytics) this.a).setCampaignIdBytes(byteString);
            return this;
        }

        public Builder setClientApp(ClientAppInfo.Builder builder) {
            a();
            ((CampaignAnalytics) this.a).setClientApp(builder);
            return this;
        }

        public Builder setClientApp(ClientAppInfo clientAppInfo) {
            a();
            ((CampaignAnalytics) this.a).setClientApp(clientAppInfo);
            return this;
        }

        public Builder setClientTimestampMillis(long j) {
            a();
            ((CampaignAnalytics) this.a).setClientTimestampMillis(j);
            return this;
        }

        public Builder setDismissType(DismissType dismissType) {
            a();
            ((CampaignAnalytics) this.a).setDismissType(dismissType);
            return this;
        }

        public Builder setEngagementMetricsDeliveryRetryCount(int i) {
            a();
            ((CampaignAnalytics) this.a).setEngagementMetricsDeliveryRetryCount(i);
            return this;
        }

        public Builder setEventType(EventType eventType) {
            a();
            ((CampaignAnalytics) this.a).setEventType(eventType);
            return this;
        }

        public Builder setFetchErrorReason(FetchErrorReason fetchErrorReason) {
            a();
            ((CampaignAnalytics) this.a).setFetchErrorReason(fetchErrorReason);
            return this;
        }

        public Builder setFiamSdkVersion(String str) {
            a();
            ((CampaignAnalytics) this.a).setFiamSdkVersion(str);
            return this;
        }

        public Builder setFiamSdkVersionBytes(ByteString byteString) {
            a();
            ((CampaignAnalytics) this.a).setFiamSdkVersionBytes(byteString);
            return this;
        }

        public Builder setProjectNumber(String str) {
            a();
            ((CampaignAnalytics) this.a).setProjectNumber(str);
            return this;
        }

        public Builder setProjectNumberBytes(ByteString byteString) {
            a();
            ((CampaignAnalytics) this.a).setProjectNumberBytes(byteString);
            return this;
        }

        public Builder setRenderErrorReason(RenderErrorReason renderErrorReason) {
            a();
            ((CampaignAnalytics) this.a).setRenderErrorReason(renderErrorReason);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum EventCase implements Internal.EnumLite {
        EVENT_TYPE(5),
        DISMISS_TYPE(6),
        RENDER_ERROR_REASON(7),
        FETCH_ERROR_REASON(8),
        EVENT_NOT_SET(0);

        private final int value;

        EventCase(int i) {
            this.value = i;
        }

        public static EventCase forNumber(int i) {
            if (i == 0) {
                return EVENT_NOT_SET;
            }
            if (i == 5) {
                return EVENT_TYPE;
            }
            if (i == 6) {
                return DISMISS_TYPE;
            }
            if (i == 7) {
                return RENDER_ERROR_REASON;
            }
            if (i != 8) {
                return null;
            }
            return FETCH_ERROR_REASON;
        }

        @Deprecated
        public static EventCase valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private CampaignAnalytics() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCampaignId() {
        this.bitField0_ &= -3;
        this.campaignId_ = getDefaultInstance().getCampaignId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientApp() {
        this.clientApp_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientTimestampMillis() {
        this.bitField0_ &= -9;
        this.clientTimestampMillis_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDismissType() {
        if (this.eventCase_ == 6) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEngagementMetricsDeliveryRetryCount() {
        this.bitField0_ &= -513;
        this.engagementMetricsDeliveryRetryCount_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEvent() {
        this.eventCase_ = 0;
        this.event_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventType() {
        if (this.eventCase_ == 5) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFetchErrorReason() {
        if (this.eventCase_ == 8) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFiamSdkVersion() {
        this.bitField0_ &= -257;
        this.fiamSdkVersion_ = getDefaultInstance().getFiamSdkVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProjectNumber() {
        this.bitField0_ &= -2;
        this.projectNumber_ = getDefaultInstance().getProjectNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRenderErrorReason() {
        if (this.eventCase_ == 7) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    public static CampaignAnalytics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeClientApp(ClientAppInfo clientAppInfo) {
        ClientAppInfo clientAppInfo2 = this.clientApp_;
        if (clientAppInfo2 != null && clientAppInfo2 != ClientAppInfo.getDefaultInstance()) {
            clientAppInfo = ClientAppInfo.newBuilder(this.clientApp_).mergeFrom((ClientAppInfo.Builder) clientAppInfo).buildPartial();
        }
        this.clientApp_ = clientAppInfo;
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CampaignAnalytics campaignAnalytics) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) campaignAnalytics);
    }

    public static CampaignAnalytics parseDelimitedFrom(InputStream inputStream) {
        return (CampaignAnalytics) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignAnalytics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignAnalytics) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignAnalytics parseFrom(ByteString byteString) {
        return (CampaignAnalytics) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static CampaignAnalytics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignAnalytics) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CampaignAnalytics parseFrom(CodedInputStream codedInputStream) {
        return (CampaignAnalytics) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CampaignAnalytics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignAnalytics) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CampaignAnalytics parseFrom(InputStream inputStream) {
        return (CampaignAnalytics) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignAnalytics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignAnalytics) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignAnalytics parseFrom(byte[] bArr) {
        return (CampaignAnalytics) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static CampaignAnalytics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignAnalytics) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<CampaignAnalytics> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampaignId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.campaignId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampaignIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.campaignId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientApp(ClientAppInfo.Builder builder) {
        this.clientApp_ = builder.build();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientApp(ClientAppInfo clientAppInfo) {
        if (clientAppInfo == null) {
            throw new NullPointerException();
        }
        this.clientApp_ = clientAppInfo;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientTimestampMillis(long j) {
        this.bitField0_ |= 8;
        this.clientTimestampMillis_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDismissType(DismissType dismissType) {
        if (dismissType == null) {
            throw new NullPointerException();
        }
        this.eventCase_ = 6;
        this.event_ = Integer.valueOf(dismissType.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEngagementMetricsDeliveryRetryCount(int i) {
        this.bitField0_ |= 512;
        this.engagementMetricsDeliveryRetryCount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventType(EventType eventType) {
        if (eventType == null) {
            throw new NullPointerException();
        }
        this.eventCase_ = 5;
        this.event_ = Integer.valueOf(eventType.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFetchErrorReason(FetchErrorReason fetchErrorReason) {
        if (fetchErrorReason == null) {
            throw new NullPointerException();
        }
        this.eventCase_ = 8;
        this.event_ = Integer.valueOf(fetchErrorReason.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFiamSdkVersion(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 256;
        this.fiamSdkVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFiamSdkVersionBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 256;
        this.fiamSdkVersion_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectNumber(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.projectNumber_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectNumberBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.projectNumber_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRenderErrorReason(RenderErrorReason renderErrorReason) {
        if (renderErrorReason == null) {
            throw new NullPointerException();
        }
        this.eventCase_ = 7;
        this.event_ = Integer.valueOf(renderErrorReason.getNumber());
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x01d7, code lost:
    
        if (r18.eventCase_ == 8) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01eb, code lost:
    
        r18.event_ = r0.visitOneofInt(r9, r18.event_, r5.event_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01ea, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01dd, code lost:
    
        if (r18.eventCase_ == 7) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01e3, code lost:
    
        if (r18.eventCase_ == 6) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01e8, code lost:
    
        if (r18.eventCase_ == 5) goto L93;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0047. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r19, java.lang.Object r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.CampaignAnalytics.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public String getCampaignId() {
        return this.campaignId_;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public ByteString getCampaignIdBytes() {
        return ByteString.copyFromUtf8(this.campaignId_);
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public ClientAppInfo getClientApp() {
        ClientAppInfo clientAppInfo = this.clientApp_;
        return clientAppInfo == null ? ClientAppInfo.getDefaultInstance() : clientAppInfo;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public long getClientTimestampMillis() {
        return this.clientTimestampMillis_;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public DismissType getDismissType() {
        DismissType forNumber;
        return (this.eventCase_ != 6 || (forNumber = DismissType.forNumber(((Integer) this.event_).intValue())) == null) ? DismissType.UNKNOWN_DISMISS_TYPE : forNumber;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public int getEngagementMetricsDeliveryRetryCount() {
        return this.engagementMetricsDeliveryRetryCount_;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public EventCase getEventCase() {
        return EventCase.forNumber(this.eventCase_);
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public EventType getEventType() {
        EventType forNumber;
        return (this.eventCase_ != 5 || (forNumber = EventType.forNumber(((Integer) this.event_).intValue())) == null) ? EventType.UNKNOWN_EVENT_TYPE : forNumber;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public FetchErrorReason getFetchErrorReason() {
        FetchErrorReason forNumber;
        return (this.eventCase_ != 8 || (forNumber = FetchErrorReason.forNumber(((Integer) this.event_).intValue())) == null) ? FetchErrorReason.UNSPECIFIED_FETCH_ERROR : forNumber;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public String getFiamSdkVersion() {
        return this.fiamSdkVersion_;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public ByteString getFiamSdkVersionBytes() {
        return ByteString.copyFromUtf8(this.fiamSdkVersion_);
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public String getProjectNumber() {
        return this.projectNumber_;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public ByteString getProjectNumberBytes() {
        return ByteString.copyFromUtf8(this.projectNumber_);
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public RenderErrorReason getRenderErrorReason() {
        RenderErrorReason forNumber;
        return (this.eventCase_ != 7 || (forNumber = RenderErrorReason.forNumber(((Integer) this.event_).intValue())) == null) ? RenderErrorReason.UNSPECIFIED_RENDER_ERROR : forNumber;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getProjectNumber()) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getCampaignId());
        }
        if ((this.bitField0_ & 4) == 4) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, getClientApp());
        }
        if ((this.bitField0_ & 8) == 8) {
            computeStringSize += CodedOutputStream.computeInt64Size(4, this.clientTimestampMillis_);
        }
        if (this.eventCase_ == 5) {
            computeStringSize += CodedOutputStream.computeEnumSize(5, ((Integer) this.event_).intValue());
        }
        if (this.eventCase_ == 6) {
            computeStringSize += CodedOutputStream.computeEnumSize(6, ((Integer) this.event_).intValue());
        }
        if (this.eventCase_ == 7) {
            computeStringSize += CodedOutputStream.computeEnumSize(7, ((Integer) this.event_).intValue());
        }
        if (this.eventCase_ == 8) {
            computeStringSize += CodedOutputStream.computeEnumSize(8, ((Integer) this.event_).intValue());
        }
        if ((this.bitField0_ & 256) == 256) {
            computeStringSize += CodedOutputStream.computeStringSize(9, getFiamSdkVersion());
        }
        if ((this.bitField0_ & 512) == 512) {
            computeStringSize += CodedOutputStream.computeInt32Size(10, this.engagementMetricsDeliveryRetryCount_);
        }
        int serializedSize = computeStringSize + this.b.getSerializedSize();
        this.c = serializedSize;
        return serializedSize;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasCampaignId() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasClientApp() {
        return (this.bitField0_ & 4) == 4;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasClientTimestampMillis() {
        return (this.bitField0_ & 8) == 8;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasDismissType() {
        return this.eventCase_ == 6;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasEngagementMetricsDeliveryRetryCount() {
        return (this.bitField0_ & 512) == 512;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasEventType() {
        return this.eventCase_ == 5;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasFetchErrorReason() {
        return this.eventCase_ == 8;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasFiamSdkVersion() {
        return (this.bitField0_ & 256) == 256;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasProjectNumber() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasRenderErrorReason() {
        return this.eventCase_ == 7;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeString(1, getProjectNumber());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeString(2, getCampaignId());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, getClientApp());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt64(4, this.clientTimestampMillis_);
        }
        if (this.eventCase_ == 5) {
            codedOutputStream.writeEnum(5, ((Integer) this.event_).intValue());
        }
        if (this.eventCase_ == 6) {
            codedOutputStream.writeEnum(6, ((Integer) this.event_).intValue());
        }
        if (this.eventCase_ == 7) {
            codedOutputStream.writeEnum(7, ((Integer) this.event_).intValue());
        }
        if (this.eventCase_ == 8) {
            codedOutputStream.writeEnum(8, ((Integer) this.event_).intValue());
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeString(9, getFiamSdkVersion());
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(10, this.engagementMetricsDeliveryRetryCount_);
        }
        this.b.writeTo(codedOutputStream);
    }
}
