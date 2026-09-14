package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class FetchEligibleCampaignsRequest extends GeneratedMessageLite<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 3;
    public static final int CLIENT_SIGNALS_FIELD_NUMBER = 4;
    private static final FetchEligibleCampaignsRequest DEFAULT_INSTANCE = new FetchEligibleCampaignsRequest();
    private static volatile Parser<FetchEligibleCampaignsRequest> PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int REQUESTING_CLIENT_APP_FIELD_NUMBER = 2;
    private int bitField0_;
    private ClientSignalsProto.ClientSignals clientSignals_;
    private ClientAppInfo requestingClientApp_;
    private String projectNumber_ = "";
    private Internal.ProtobufList<CampaignImpression> alreadySeenCampaigns_ = GeneratedMessageLite.f();

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {
        private Builder() {
            super(FetchEligibleCampaignsRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).addAllAlreadySeenCampaigns(iterable);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).addAlreadySeenCampaigns(i, builder);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).addAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression.Builder builder) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).addAlreadySeenCampaigns(builder);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).addAlreadySeenCampaigns(campaignImpression);
            return this;
        }

        public Builder clearAlreadySeenCampaigns() {
            a();
            ((FetchEligibleCampaignsRequest) this.a).clearAlreadySeenCampaigns();
            return this;
        }

        public Builder clearClientSignals() {
            a();
            ((FetchEligibleCampaignsRequest) this.a).clearClientSignals();
            return this;
        }

        public Builder clearProjectNumber() {
            a();
            ((FetchEligibleCampaignsRequest) this.a).clearProjectNumber();
            return this;
        }

        public Builder clearRequestingClientApp() {
            a();
            ((FetchEligibleCampaignsRequest) this.a).clearRequestingClientApp();
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public CampaignImpression getAlreadySeenCampaigns(int i) {
            return ((FetchEligibleCampaignsRequest) this.a).getAlreadySeenCampaigns(i);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public int getAlreadySeenCampaignsCount() {
            return ((FetchEligibleCampaignsRequest) this.a).getAlreadySeenCampaignsCount();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public List<CampaignImpression> getAlreadySeenCampaignsList() {
            return Collections.unmodifiableList(((FetchEligibleCampaignsRequest) this.a).getAlreadySeenCampaignsList());
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public ClientSignalsProto.ClientSignals getClientSignals() {
            return ((FetchEligibleCampaignsRequest) this.a).getClientSignals();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public String getProjectNumber() {
            return ((FetchEligibleCampaignsRequest) this.a).getProjectNumber();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public ByteString getProjectNumberBytes() {
            return ((FetchEligibleCampaignsRequest) this.a).getProjectNumberBytes();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public ClientAppInfo getRequestingClientApp() {
            return ((FetchEligibleCampaignsRequest) this.a).getRequestingClientApp();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public boolean hasClientSignals() {
            return ((FetchEligibleCampaignsRequest) this.a).hasClientSignals();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public boolean hasRequestingClientApp() {
            return ((FetchEligibleCampaignsRequest) this.a).hasRequestingClientApp();
        }

        public Builder mergeClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).mergeClientSignals(clientSignals);
            return this;
        }

        public Builder mergeRequestingClientApp(ClientAppInfo clientAppInfo) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).mergeRequestingClientApp(clientAppInfo);
            return this;
        }

        public Builder removeAlreadySeenCampaigns(int i) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).removeAlreadySeenCampaigns(i);
            return this;
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).setAlreadySeenCampaigns(i, builder);
            return this;
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).setAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder setClientSignals(ClientSignalsProto.ClientSignals.Builder builder) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).setClientSignals(builder);
            return this;
        }

        public Builder setClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).setClientSignals(clientSignals);
            return this;
        }

        public Builder setProjectNumber(String str) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).setProjectNumber(str);
            return this;
        }

        public Builder setProjectNumberBytes(ByteString byteString) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).setProjectNumberBytes(byteString);
            return this;
        }

        public Builder setRequestingClientApp(ClientAppInfo.Builder builder) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).setRequestingClientApp(builder);
            return this;
        }

        public Builder setRequestingClientApp(ClientAppInfo clientAppInfo) {
            a();
            ((FetchEligibleCampaignsRequest) this.a).setRequestingClientApp(clientAppInfo);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private FetchEligibleCampaignsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
        ensureAlreadySeenCampaignsIsMutable();
        AbstractMessageLite.a(iterable, this.alreadySeenCampaigns_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
        if (campaignImpression == null) {
            throw new NullPointerException();
        }
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.add(i, campaignImpression);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlreadySeenCampaigns(CampaignImpression.Builder builder) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
        if (campaignImpression == null) {
            throw new NullPointerException();
        }
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.add(campaignImpression);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlreadySeenCampaigns() {
        this.alreadySeenCampaigns_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientSignals() {
        this.clientSignals_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProjectNumber() {
        this.projectNumber_ = getDefaultInstance().getProjectNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestingClientApp() {
        this.requestingClientApp_ = null;
    }

    private void ensureAlreadySeenCampaignsIsMutable() {
        if (this.alreadySeenCampaigns_.isModifiable()) {
            return;
        }
        this.alreadySeenCampaigns_ = GeneratedMessageLite.a(this.alreadySeenCampaigns_);
    }

    public static FetchEligibleCampaignsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
        ClientSignalsProto.ClientSignals clientSignals2 = this.clientSignals_;
        if (clientSignals2 != null && clientSignals2 != ClientSignalsProto.ClientSignals.getDefaultInstance()) {
            clientSignals = ClientSignalsProto.ClientSignals.newBuilder(this.clientSignals_).mergeFrom((ClientSignalsProto.ClientSignals.Builder) clientSignals).buildPartial();
        }
        this.clientSignals_ = clientSignals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequestingClientApp(ClientAppInfo clientAppInfo) {
        ClientAppInfo clientAppInfo2 = this.requestingClientApp_;
        if (clientAppInfo2 != null && clientAppInfo2 != ClientAppInfo.getDefaultInstance()) {
            clientAppInfo = ClientAppInfo.newBuilder(this.requestingClientApp_).mergeFrom((ClientAppInfo.Builder) clientAppInfo).buildPartial();
        }
        this.requestingClientApp_ = clientAppInfo;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fetchEligibleCampaignsRequest);
    }

    public static FetchEligibleCampaignsRequest parseDelimitedFrom(InputStream inputStream) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(ByteString byteString) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static FetchEligibleCampaignsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(CodedInputStream codedInputStream) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FetchEligibleCampaignsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(InputStream inputStream) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(byte[] bArr) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static FetchEligibleCampaignsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<FetchEligibleCampaignsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAlreadySeenCampaigns(int i) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
        if (campaignImpression == null) {
            throw new NullPointerException();
        }
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.set(i, campaignImpression);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientSignals(ClientSignalsProto.ClientSignals.Builder builder) {
        this.clientSignals_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
        if (clientSignals == null) {
            throw new NullPointerException();
        }
        this.clientSignals_ = clientSignals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectNumber(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.projectNumber_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectNumberBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.projectNumber_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestingClientApp(ClientAppInfo.Builder builder) {
        this.requestingClientApp_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestingClientApp(ClientAppInfo clientAppInfo) {
        if (clientAppInfo == null) {
            throw new NullPointerException();
        }
        this.requestingClientApp_ = clientAppInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new FetchEligibleCampaignsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.alreadySeenCampaigns_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest = (FetchEligibleCampaignsRequest) obj2;
                this.projectNumber_ = visitor.visitString(!this.projectNumber_.isEmpty(), this.projectNumber_, true ^ fetchEligibleCampaignsRequest.projectNumber_.isEmpty(), fetchEligibleCampaignsRequest.projectNumber_);
                this.requestingClientApp_ = (ClientAppInfo) visitor.visitMessage(this.requestingClientApp_, fetchEligibleCampaignsRequest.requestingClientApp_);
                this.alreadySeenCampaigns_ = visitor.visitList(this.alreadySeenCampaigns_, fetchEligibleCampaignsRequest.alreadySeenCampaigns_);
                this.clientSignals_ = (ClientSignalsProto.ClientSignals) visitor.visitMessage(this.clientSignals_, fetchEligibleCampaignsRequest.clientSignals_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= fetchEligibleCampaignsRequest.bitField0_;
                }
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
                                if (readTag == 10) {
                                    this.projectNumber_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    ClientAppInfo.Builder builder = this.requestingClientApp_ != null ? this.requestingClientApp_.toBuilder() : null;
                                    this.requestingClientApp_ = (ClientAppInfo) codedInputStream.readMessage(ClientAppInfo.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((ClientAppInfo.Builder) this.requestingClientApp_);
                                        this.requestingClientApp_ = builder.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    if (!this.alreadySeenCampaigns_.isModifiable()) {
                                        this.alreadySeenCampaigns_ = GeneratedMessageLite.a(this.alreadySeenCampaigns_);
                                    }
                                    this.alreadySeenCampaigns_.add((CampaignImpression) codedInputStream.readMessage(CampaignImpression.parser(), extensionRegistryLite));
                                } else if (readTag == 34) {
                                    ClientSignalsProto.ClientSignals.Builder builder2 = this.clientSignals_ != null ? this.clientSignals_.toBuilder() : null;
                                    this.clientSignals_ = (ClientSignalsProto.ClientSignals) codedInputStream.readMessage(ClientSignalsProto.ClientSignals.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((ClientSignalsProto.ClientSignals.Builder) this.clientSignals_);
                                        this.clientSignals_ = builder2.buildPartial();
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
                    synchronized (FetchEligibleCampaignsRequest.class) {
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

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public CampaignImpression getAlreadySeenCampaigns(int i) {
        return this.alreadySeenCampaigns_.get(i);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public int getAlreadySeenCampaignsCount() {
        return this.alreadySeenCampaigns_.size();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public List<CampaignImpression> getAlreadySeenCampaignsList() {
        return this.alreadySeenCampaigns_;
    }

    public CampaignImpressionOrBuilder getAlreadySeenCampaignsOrBuilder(int i) {
        return this.alreadySeenCampaigns_.get(i);
    }

    public List<? extends CampaignImpressionOrBuilder> getAlreadySeenCampaignsOrBuilderList() {
        return this.alreadySeenCampaigns_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public ClientSignalsProto.ClientSignals getClientSignals() {
        ClientSignalsProto.ClientSignals clientSignals = this.clientSignals_;
        return clientSignals == null ? ClientSignalsProto.ClientSignals.getDefaultInstance() : clientSignals;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public String getProjectNumber() {
        return this.projectNumber_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public ByteString getProjectNumberBytes() {
        return ByteString.copyFromUtf8(this.projectNumber_);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public ClientAppInfo getRequestingClientApp() {
        ClientAppInfo clientAppInfo = this.requestingClientApp_;
        return clientAppInfo == null ? ClientAppInfo.getDefaultInstance() : clientAppInfo;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.projectNumber_.isEmpty() ? CodedOutputStream.computeStringSize(1, getProjectNumber()) + 0 : 0;
        if (this.requestingClientApp_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getRequestingClientApp());
        }
        for (int i2 = 0; i2 < this.alreadySeenCampaigns_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.alreadySeenCampaigns_.get(i2));
        }
        if (this.clientSignals_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, getClientSignals());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public boolean hasClientSignals() {
        return this.clientSignals_ != null;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public boolean hasRequestingClientApp() {
        return this.requestingClientApp_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.projectNumber_.isEmpty()) {
            codedOutputStream.writeString(1, getProjectNumber());
        }
        if (this.requestingClientApp_ != null) {
            codedOutputStream.writeMessage(2, getRequestingClientApp());
        }
        for (int i = 0; i < this.alreadySeenCampaigns_.size(); i++) {
            codedOutputStream.writeMessage(3, this.alreadySeenCampaigns_.get(i));
        }
        if (this.clientSignals_ != null) {
            codedOutputStream.writeMessage(4, getClientSignals());
        }
    }
}
