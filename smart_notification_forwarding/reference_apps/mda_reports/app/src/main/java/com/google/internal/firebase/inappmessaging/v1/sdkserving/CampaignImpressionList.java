package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
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
public final class CampaignImpressionList extends GeneratedMessageLite<CampaignImpressionList, Builder> implements CampaignImpressionListOrBuilder {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 1;
    private static final CampaignImpressionList DEFAULT_INSTANCE = new CampaignImpressionList();
    private static volatile Parser<CampaignImpressionList> PARSER;
    private Internal.ProtobufList<CampaignImpression> alreadySeenCampaigns_ = GeneratedMessageLite.f();

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignImpressionList, Builder> implements CampaignImpressionListOrBuilder {
        private Builder() {
            super(CampaignImpressionList.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
            a();
            ((CampaignImpressionList) this.a).addAllAlreadySeenCampaigns(iterable);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            a();
            ((CampaignImpressionList) this.a).addAlreadySeenCampaigns(i, builder);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            a();
            ((CampaignImpressionList) this.a).addAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression.Builder builder) {
            a();
            ((CampaignImpressionList) this.a).addAlreadySeenCampaigns(builder);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
            a();
            ((CampaignImpressionList) this.a).addAlreadySeenCampaigns(campaignImpression);
            return this;
        }

        public Builder clearAlreadySeenCampaigns() {
            a();
            ((CampaignImpressionList) this.a).clearAlreadySeenCampaigns();
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
        public CampaignImpression getAlreadySeenCampaigns(int i) {
            return ((CampaignImpressionList) this.a).getAlreadySeenCampaigns(i);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
        public int getAlreadySeenCampaignsCount() {
            return ((CampaignImpressionList) this.a).getAlreadySeenCampaignsCount();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
        public List<CampaignImpression> getAlreadySeenCampaignsList() {
            return Collections.unmodifiableList(((CampaignImpressionList) this.a).getAlreadySeenCampaignsList());
        }

        public Builder removeAlreadySeenCampaigns(int i) {
            a();
            ((CampaignImpressionList) this.a).removeAlreadySeenCampaigns(i);
            return this;
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            a();
            ((CampaignImpressionList) this.a).setAlreadySeenCampaigns(i, builder);
            return this;
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            a();
            ((CampaignImpressionList) this.a).setAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private CampaignImpressionList() {
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

    private void ensureAlreadySeenCampaignsIsMutable() {
        if (this.alreadySeenCampaigns_.isModifiable()) {
            return;
        }
        this.alreadySeenCampaigns_ = GeneratedMessageLite.a(this.alreadySeenCampaigns_);
    }

    public static CampaignImpressionList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CampaignImpressionList campaignImpressionList) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) campaignImpressionList);
    }

    public static CampaignImpressionList parseDelimitedFrom(InputStream inputStream) {
        return (CampaignImpressionList) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpressionList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpressionList) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(ByteString byteString) {
        return (CampaignImpressionList) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static CampaignImpressionList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpressionList) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(CodedInputStream codedInputStream) {
        return (CampaignImpressionList) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CampaignImpressionList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpressionList) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(InputStream inputStream) {
        return (CampaignImpressionList) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpressionList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpressionList) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(byte[] bArr) {
        return (CampaignImpressionList) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static CampaignImpressionList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpressionList) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<CampaignImpressionList> parser() {
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignImpressionList();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.alreadySeenCampaigns_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.alreadySeenCampaigns_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.alreadySeenCampaigns_, ((CampaignImpressionList) obj2).alreadySeenCampaigns_);
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
                                if (readTag == 10) {
                                    if (!this.alreadySeenCampaigns_.isModifiable()) {
                                        this.alreadySeenCampaigns_ = GeneratedMessageLite.a(this.alreadySeenCampaigns_);
                                    }
                                    this.alreadySeenCampaigns_.add((CampaignImpression) codedInputStream.readMessage(CampaignImpression.parser(), extensionRegistryLite));
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
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
                    synchronized (CampaignImpressionList.class) {
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

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
    public CampaignImpression getAlreadySeenCampaigns(int i) {
        return this.alreadySeenCampaigns_.get(i);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
    public int getAlreadySeenCampaignsCount() {
        return this.alreadySeenCampaigns_.size();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
    public List<CampaignImpression> getAlreadySeenCampaignsList() {
        return this.alreadySeenCampaigns_;
    }

    public CampaignImpressionOrBuilder getAlreadySeenCampaignsOrBuilder(int i) {
        return this.alreadySeenCampaigns_.get(i);
    }

    public List<? extends CampaignImpressionOrBuilder> getAlreadySeenCampaignsOrBuilderList() {
        return this.alreadySeenCampaigns_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.alreadySeenCampaigns_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.alreadySeenCampaigns_.get(i3));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.alreadySeenCampaigns_.size(); i++) {
            codedOutputStream.writeMessage(1, this.alreadySeenCampaigns_.get(i));
        }
    }
}
