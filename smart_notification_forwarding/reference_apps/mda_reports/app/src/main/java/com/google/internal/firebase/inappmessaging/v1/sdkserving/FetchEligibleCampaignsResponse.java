package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
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
public final class FetchEligibleCampaignsResponse extends GeneratedMessageLite<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {
    private static final FetchEligibleCampaignsResponse DEFAULT_INSTANCE = new FetchEligibleCampaignsResponse();
    public static final int EXPIRATION_EPOCH_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    public static final int MESSAGES_FIELD_NUMBER = 1;
    private static volatile Parser<FetchEligibleCampaignsResponse> PARSER;
    private int bitField0_;
    private long expirationEpochTimestampMillis_;
    private Internal.ProtobufList<CampaignProto.ThickContent> messages_ = GeneratedMessageLite.f();

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {
        private Builder() {
            super(FetchEligibleCampaignsResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllMessages(Iterable<? extends CampaignProto.ThickContent> iterable) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).addAllMessages(iterable);
            return this;
        }

        public Builder addMessages(int i, CampaignProto.ThickContent.Builder builder) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).addMessages(i, builder);
            return this;
        }

        public Builder addMessages(int i, CampaignProto.ThickContent thickContent) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).addMessages(i, thickContent);
            return this;
        }

        public Builder addMessages(CampaignProto.ThickContent.Builder builder) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).addMessages(builder);
            return this;
        }

        public Builder addMessages(CampaignProto.ThickContent thickContent) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).addMessages(thickContent);
            return this;
        }

        public Builder clearExpirationEpochTimestampMillis() {
            a();
            ((FetchEligibleCampaignsResponse) this.a).clearExpirationEpochTimestampMillis();
            return this;
        }

        public Builder clearMessages() {
            a();
            ((FetchEligibleCampaignsResponse) this.a).clearMessages();
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
        public long getExpirationEpochTimestampMillis() {
            return ((FetchEligibleCampaignsResponse) this.a).getExpirationEpochTimestampMillis();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
        public CampaignProto.ThickContent getMessages(int i) {
            return ((FetchEligibleCampaignsResponse) this.a).getMessages(i);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
        public int getMessagesCount() {
            return ((FetchEligibleCampaignsResponse) this.a).getMessagesCount();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
        public List<CampaignProto.ThickContent> getMessagesList() {
            return Collections.unmodifiableList(((FetchEligibleCampaignsResponse) this.a).getMessagesList());
        }

        public Builder removeMessages(int i) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).removeMessages(i);
            return this;
        }

        public Builder setExpirationEpochTimestampMillis(long j) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).setExpirationEpochTimestampMillis(j);
            return this;
        }

        public Builder setMessages(int i, CampaignProto.ThickContent.Builder builder) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).setMessages(i, builder);
            return this;
        }

        public Builder setMessages(int i, CampaignProto.ThickContent thickContent) {
            a();
            ((FetchEligibleCampaignsResponse) this.a).setMessages(i, thickContent);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private FetchEligibleCampaignsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMessages(Iterable<? extends CampaignProto.ThickContent> iterable) {
        ensureMessagesIsMutable();
        AbstractMessageLite.a(iterable, this.messages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(int i, CampaignProto.ThickContent.Builder builder) {
        ensureMessagesIsMutable();
        this.messages_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(int i, CampaignProto.ThickContent thickContent) {
        if (thickContent == null) {
            throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        this.messages_.add(i, thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(CampaignProto.ThickContent.Builder builder) {
        ensureMessagesIsMutable();
        this.messages_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(CampaignProto.ThickContent thickContent) {
        if (thickContent == null) {
            throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        this.messages_.add(thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExpirationEpochTimestampMillis() {
        this.expirationEpochTimestampMillis_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessages() {
        this.messages_ = GeneratedMessageLite.f();
    }

    private void ensureMessagesIsMutable() {
        if (this.messages_.isModifiable()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.a(this.messages_);
    }

    public static FetchEligibleCampaignsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fetchEligibleCampaignsResponse);
    }

    public static FetchEligibleCampaignsResponse parseDelimitedFrom(InputStream inputStream) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(ByteString byteString) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static FetchEligibleCampaignsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(CodedInputStream codedInputStream) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FetchEligibleCampaignsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(InputStream inputStream) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(byte[] bArr) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static FetchEligibleCampaignsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<FetchEligibleCampaignsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMessages(int i) {
        ensureMessagesIsMutable();
        this.messages_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpirationEpochTimestampMillis(long j) {
        this.expirationEpochTimestampMillis_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessages(int i, CampaignProto.ThickContent.Builder builder) {
        ensureMessagesIsMutable();
        this.messages_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessages(int i, CampaignProto.ThickContent thickContent) {
        if (thickContent == null) {
            throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        this.messages_.set(i, thickContent);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new FetchEligibleCampaignsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.messages_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse = (FetchEligibleCampaignsResponse) obj2;
                this.messages_ = visitor.visitList(this.messages_, fetchEligibleCampaignsResponse.messages_);
                this.expirationEpochTimestampMillis_ = visitor.visitLong(this.expirationEpochTimestampMillis_ != 0, this.expirationEpochTimestampMillis_, fetchEligibleCampaignsResponse.expirationEpochTimestampMillis_ != 0, fetchEligibleCampaignsResponse.expirationEpochTimestampMillis_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= fetchEligibleCampaignsResponse.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    if (!this.messages_.isModifiable()) {
                                        this.messages_ = GeneratedMessageLite.a(this.messages_);
                                    }
                                    this.messages_.add((CampaignProto.ThickContent) codedInputStream.readMessage(CampaignProto.ThickContent.parser(), extensionRegistryLite));
                                } else if (readTag == 16) {
                                    this.expirationEpochTimestampMillis_ = codedInputStream.readInt64();
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
                    synchronized (FetchEligibleCampaignsResponse.class) {
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

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
    public long getExpirationEpochTimestampMillis() {
        return this.expirationEpochTimestampMillis_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
    public CampaignProto.ThickContent getMessages(int i) {
        return this.messages_.get(i);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
    public int getMessagesCount() {
        return this.messages_.size();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
    public List<CampaignProto.ThickContent> getMessagesList() {
        return this.messages_;
    }

    public CampaignProto.ThickContentOrBuilder getMessagesOrBuilder(int i) {
        return this.messages_.get(i);
    }

    public List<? extends CampaignProto.ThickContentOrBuilder> getMessagesOrBuilderList() {
        return this.messages_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.messages_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.messages_.get(i3));
        }
        long j = this.expirationEpochTimestampMillis_;
        if (j != 0) {
            i2 += CodedOutputStream.computeInt64Size(2, j);
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.messages_.size(); i++) {
            codedOutputStream.writeMessage(1, this.messages_.get(i));
        }
        long j = this.expirationEpochTimestampMillis_;
        if (j != 0) {
            codedOutputStream.writeInt64(2, j);
        }
    }
}
