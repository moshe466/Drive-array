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
public final class CampaignImpression extends GeneratedMessageLite<CampaignImpression, Builder> implements CampaignImpressionOrBuilder {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    private static final CampaignImpression DEFAULT_INSTANCE = new CampaignImpression();
    public static final int IMPRESSION_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    private static volatile Parser<CampaignImpression> PARSER;
    private String campaignId_ = "";
    private long impressionTimestampMillis_;

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignImpression, Builder> implements CampaignImpressionOrBuilder {
        private Builder() {
            super(CampaignImpression.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCampaignId() {
            a();
            ((CampaignImpression) this.a).clearCampaignId();
            return this;
        }

        public Builder clearImpressionTimestampMillis() {
            a();
            ((CampaignImpression) this.a).clearImpressionTimestampMillis();
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionOrBuilder
        public String getCampaignId() {
            return ((CampaignImpression) this.a).getCampaignId();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionOrBuilder
        public ByteString getCampaignIdBytes() {
            return ((CampaignImpression) this.a).getCampaignIdBytes();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionOrBuilder
        public long getImpressionTimestampMillis() {
            return ((CampaignImpression) this.a).getImpressionTimestampMillis();
        }

        public Builder setCampaignId(String str) {
            a();
            ((CampaignImpression) this.a).setCampaignId(str);
            return this;
        }

        public Builder setCampaignIdBytes(ByteString byteString) {
            a();
            ((CampaignImpression) this.a).setCampaignIdBytes(byteString);
            return this;
        }

        public Builder setImpressionTimestampMillis(long j) {
            a();
            ((CampaignImpression) this.a).setImpressionTimestampMillis(j);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private CampaignImpression() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCampaignId() {
        this.campaignId_ = getDefaultInstance().getCampaignId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImpressionTimestampMillis() {
        this.impressionTimestampMillis_ = 0L;
    }

    public static CampaignImpression getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CampaignImpression campaignImpression) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) campaignImpression);
    }

    public static CampaignImpression parseDelimitedFrom(InputStream inputStream) {
        return (CampaignImpression) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpression parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpression) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpression parseFrom(ByteString byteString) {
        return (CampaignImpression) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static CampaignImpression parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpression) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CampaignImpression parseFrom(CodedInputStream codedInputStream) {
        return (CampaignImpression) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CampaignImpression parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpression) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CampaignImpression parseFrom(InputStream inputStream) {
        return (CampaignImpression) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpression parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpression) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpression parseFrom(byte[] bArr) {
        return (CampaignImpression) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static CampaignImpression parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CampaignImpression) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<CampaignImpression> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampaignId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.campaignId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampaignIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.campaignId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImpressionTimestampMillis(long j) {
        this.impressionTimestampMillis_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignImpression();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CampaignImpression campaignImpression = (CampaignImpression) obj2;
                this.campaignId_ = visitor.visitString(!this.campaignId_.isEmpty(), this.campaignId_, !campaignImpression.campaignId_.isEmpty(), campaignImpression.campaignId_);
                this.impressionTimestampMillis_ = visitor.visitLong(this.impressionTimestampMillis_ != 0, this.impressionTimestampMillis_, campaignImpression.impressionTimestampMillis_ != 0, campaignImpression.impressionTimestampMillis_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.campaignId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.impressionTimestampMillis_ = codedInputStream.readInt64();
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
                    synchronized (CampaignImpression.class) {
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

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionOrBuilder
    public String getCampaignId() {
        return this.campaignId_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionOrBuilder
    public ByteString getCampaignIdBytes() {
        return ByteString.copyFromUtf8(this.campaignId_);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionOrBuilder
    public long getImpressionTimestampMillis() {
        return this.impressionTimestampMillis_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.campaignId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getCampaignId());
        long j = this.impressionTimestampMillis_;
        if (j != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(2, j);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.campaignId_.isEmpty()) {
            codedOutputStream.writeString(1, getCampaignId());
        }
        long j = this.impressionTimestampMillis_;
        if (j != 0) {
            codedOutputStream.writeInt64(2, j);
        }
    }
}
