package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import developers.mobile.abt.FirebaseAbt;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class CampaignProto {

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.CampaignProto$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[ThickContent.PayloadCase.values().length];

        static {
            try {
                b[ThickContent.PayloadCase.VANILLA_PAYLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ThickContent.PayloadCase.PAYLOAD_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ExperimentalCampaignPayload extends GeneratedMessageLite<ExperimentalCampaignPayload, Builder> implements ExperimentalCampaignPayloadOrBuilder {
        public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
        private static final ExperimentalCampaignPayload DEFAULT_INSTANCE = new ExperimentalCampaignPayload();
        public static final int EXPERIMENT_PAYLOAD_FIELD_NUMBER = 2;
        private static volatile Parser<ExperimentalCampaignPayload> PARSER;
        private String campaignId_ = "";
        private FirebaseAbt.ExperimentPayload experimentPayload_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignPayload, Builder> implements ExperimentalCampaignPayloadOrBuilder {
            private Builder() {
                super(ExperimentalCampaignPayload.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCampaignId() {
                a();
                ((ExperimentalCampaignPayload) this.a).clearCampaignId();
                return this;
            }

            public Builder clearExperimentPayload() {
                a();
                ((ExperimentalCampaignPayload) this.a).clearExperimentPayload();
                return this;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public String getCampaignId() {
                return ((ExperimentalCampaignPayload) this.a).getCampaignId();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public ByteString getCampaignIdBytes() {
                return ((ExperimentalCampaignPayload) this.a).getCampaignIdBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public FirebaseAbt.ExperimentPayload getExperimentPayload() {
                return ((ExperimentalCampaignPayload) this.a).getExperimentPayload();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public boolean hasExperimentPayload() {
                return ((ExperimentalCampaignPayload) this.a).hasExperimentPayload();
            }

            public Builder mergeExperimentPayload(FirebaseAbt.ExperimentPayload experimentPayload) {
                a();
                ((ExperimentalCampaignPayload) this.a).mergeExperimentPayload(experimentPayload);
                return this;
            }

            public Builder setCampaignId(String str) {
                a();
                ((ExperimentalCampaignPayload) this.a).setCampaignId(str);
                return this;
            }

            public Builder setCampaignIdBytes(ByteString byteString) {
                a();
                ((ExperimentalCampaignPayload) this.a).setCampaignIdBytes(byteString);
                return this;
            }

            public Builder setExperimentPayload(FirebaseAbt.ExperimentPayload.Builder builder) {
                a();
                ((ExperimentalCampaignPayload) this.a).setExperimentPayload(builder);
                return this;
            }

            public Builder setExperimentPayload(FirebaseAbt.ExperimentPayload experimentPayload) {
                a();
                ((ExperimentalCampaignPayload) this.a).setExperimentPayload(experimentPayload);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ExperimentalCampaignPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignId() {
            this.campaignId_ = getDefaultInstance().getCampaignId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentPayload() {
            this.experimentPayload_ = null;
        }

        public static ExperimentalCampaignPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExperimentPayload(FirebaseAbt.ExperimentPayload experimentPayload) {
            FirebaseAbt.ExperimentPayload experimentPayload2 = this.experimentPayload_;
            if (experimentPayload2 != null && experimentPayload2 != FirebaseAbt.ExperimentPayload.getDefaultInstance()) {
                experimentPayload = FirebaseAbt.ExperimentPayload.newBuilder(this.experimentPayload_).mergeFrom((FirebaseAbt.ExperimentPayload.Builder) experimentPayload).buildPartial();
            }
            this.experimentPayload_ = experimentPayload;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExperimentalCampaignPayload experimentalCampaignPayload) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) experimentalCampaignPayload);
        }

        public static ExperimentalCampaignPayload parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentalCampaignPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(ByteString byteString) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentalCampaignPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentalCampaignPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(InputStream inputStream) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentalCampaignPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(byte[] bArr) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentalCampaignPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ExperimentalCampaignPayload> parser() {
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
        public void setExperimentPayload(FirebaseAbt.ExperimentPayload.Builder builder) {
            this.experimentPayload_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentPayload(FirebaseAbt.ExperimentPayload experimentPayload) {
            if (experimentPayload == null) {
                throw new NullPointerException();
            }
            this.experimentPayload_ = experimentPayload;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentalCampaignPayload();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ExperimentalCampaignPayload experimentalCampaignPayload = (ExperimentalCampaignPayload) obj2;
                    this.campaignId_ = visitor.visitString(!this.campaignId_.isEmpty(), this.campaignId_, true ^ experimentalCampaignPayload.campaignId_.isEmpty(), experimentalCampaignPayload.campaignId_);
                    this.experimentPayload_ = (FirebaseAbt.ExperimentPayload) visitor.visitMessage(this.experimentPayload_, experimentalCampaignPayload.experimentPayload_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.campaignId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    FirebaseAbt.ExperimentPayload.Builder builder = this.experimentPayload_ != null ? this.experimentPayload_.toBuilder() : null;
                                    this.experimentPayload_ = (FirebaseAbt.ExperimentPayload) codedInputStream.readMessage(FirebaseAbt.ExperimentPayload.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((FirebaseAbt.ExperimentPayload.Builder) this.experimentPayload_);
                                        this.experimentPayload_ = builder.buildPartial();
                                    }
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
                        synchronized (ExperimentalCampaignPayload.class) {
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

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public String getCampaignId() {
            return this.campaignId_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public ByteString getCampaignIdBytes() {
            return ByteString.copyFromUtf8(this.campaignId_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public FirebaseAbt.ExperimentPayload getExperimentPayload() {
            FirebaseAbt.ExperimentPayload experimentPayload = this.experimentPayload_;
            return experimentPayload == null ? FirebaseAbt.ExperimentPayload.getDefaultInstance() : experimentPayload;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.campaignId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getCampaignId());
            if (this.experimentPayload_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, getExperimentPayload());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public boolean hasExperimentPayload() {
            return this.experimentPayload_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.campaignId_.isEmpty()) {
                codedOutputStream.writeString(1, getCampaignId());
            }
            if (this.experimentPayload_ != null) {
                codedOutputStream.writeMessage(2, getExperimentPayload());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ExperimentalCampaignPayloadOrBuilder extends MessageLiteOrBuilder {
        String getCampaignId();

        ByteString getCampaignIdBytes();

        FirebaseAbt.ExperimentPayload getExperimentPayload();

        boolean hasExperimentPayload();
    }

    /* loaded from: classes2.dex */
    public static final class ExperimentalCampaignRollout extends GeneratedMessageLite<ExperimentalCampaignRollout, Builder> implements ExperimentalCampaignRolloutOrBuilder {
        private static final ExperimentalCampaignRollout DEFAULT_INSTANCE = new ExperimentalCampaignRollout();
        public static final int END_TIME_FIELD_NUMBER = 5;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        private static volatile Parser<ExperimentalCampaignRollout> PARSER = null;
        public static final int PRIORITY_FIELD_NUMBER = 3;
        public static final int SELECTED_VARIANT_INDEX_FIELD_NUMBER = 2;
        public static final int START_TIME_FIELD_NUMBER = 4;
        private CommonTypesProto.CampaignTime endTime_;
        private String experimentId_ = "";
        private CommonTypesProto.Priority priority_;
        private int selectedVariantIndex_;
        private CommonTypesProto.CampaignTime startTime_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignRollout, Builder> implements ExperimentalCampaignRolloutOrBuilder {
            private Builder() {
                super(ExperimentalCampaignRollout.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearEndTime() {
                a();
                ((ExperimentalCampaignRollout) this.a).clearEndTime();
                return this;
            }

            public Builder clearExperimentId() {
                a();
                ((ExperimentalCampaignRollout) this.a).clearExperimentId();
                return this;
            }

            public Builder clearPriority() {
                a();
                ((ExperimentalCampaignRollout) this.a).clearPriority();
                return this;
            }

            public Builder clearSelectedVariantIndex() {
                a();
                ((ExperimentalCampaignRollout) this.a).clearSelectedVariantIndex();
                return this;
            }

            public Builder clearStartTime() {
                a();
                ((ExperimentalCampaignRollout) this.a).clearStartTime();
                return this;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public CommonTypesProto.CampaignTime getEndTime() {
                return ((ExperimentalCampaignRollout) this.a).getEndTime();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public String getExperimentId() {
                return ((ExperimentalCampaignRollout) this.a).getExperimentId();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public ByteString getExperimentIdBytes() {
                return ((ExperimentalCampaignRollout) this.a).getExperimentIdBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public CommonTypesProto.Priority getPriority() {
                return ((ExperimentalCampaignRollout) this.a).getPriority();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public int getSelectedVariantIndex() {
                return ((ExperimentalCampaignRollout) this.a).getSelectedVariantIndex();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public CommonTypesProto.CampaignTime getStartTime() {
                return ((ExperimentalCampaignRollout) this.a).getStartTime();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public boolean hasEndTime() {
                return ((ExperimentalCampaignRollout) this.a).hasEndTime();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public boolean hasPriority() {
                return ((ExperimentalCampaignRollout) this.a).hasPriority();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public boolean hasStartTime() {
                return ((ExperimentalCampaignRollout) this.a).hasStartTime();
            }

            public Builder mergeEndTime(CommonTypesProto.CampaignTime campaignTime) {
                a();
                ((ExperimentalCampaignRollout) this.a).mergeEndTime(campaignTime);
                return this;
            }

            public Builder mergePriority(CommonTypesProto.Priority priority) {
                a();
                ((ExperimentalCampaignRollout) this.a).mergePriority(priority);
                return this;
            }

            public Builder mergeStartTime(CommonTypesProto.CampaignTime campaignTime) {
                a();
                ((ExperimentalCampaignRollout) this.a).mergeStartTime(campaignTime);
                return this;
            }

            public Builder setEndTime(CommonTypesProto.CampaignTime.Builder builder) {
                a();
                ((ExperimentalCampaignRollout) this.a).setEndTime(builder);
                return this;
            }

            public Builder setEndTime(CommonTypesProto.CampaignTime campaignTime) {
                a();
                ((ExperimentalCampaignRollout) this.a).setEndTime(campaignTime);
                return this;
            }

            public Builder setExperimentId(String str) {
                a();
                ((ExperimentalCampaignRollout) this.a).setExperimentId(str);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                a();
                ((ExperimentalCampaignRollout) this.a).setExperimentIdBytes(byteString);
                return this;
            }

            public Builder setPriority(CommonTypesProto.Priority.Builder builder) {
                a();
                ((ExperimentalCampaignRollout) this.a).setPriority(builder);
                return this;
            }

            public Builder setPriority(CommonTypesProto.Priority priority) {
                a();
                ((ExperimentalCampaignRollout) this.a).setPriority(priority);
                return this;
            }

            public Builder setSelectedVariantIndex(int i) {
                a();
                ((ExperimentalCampaignRollout) this.a).setSelectedVariantIndex(i);
                return this;
            }

            public Builder setStartTime(CommonTypesProto.CampaignTime.Builder builder) {
                a();
                ((ExperimentalCampaignRollout) this.a).setStartTime(builder);
                return this;
            }

            public Builder setStartTime(CommonTypesProto.CampaignTime campaignTime) {
                a();
                ((ExperimentalCampaignRollout) this.a).setStartTime(campaignTime);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ExperimentalCampaignRollout() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTime() {
            this.endTime_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentId() {
            this.experimentId_ = getDefaultInstance().getExperimentId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPriority() {
            this.priority_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSelectedVariantIndex() {
            this.selectedVariantIndex_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTime() {
            this.startTime_ = null;
        }

        public static ExperimentalCampaignRollout getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEndTime(CommonTypesProto.CampaignTime campaignTime) {
            CommonTypesProto.CampaignTime campaignTime2 = this.endTime_;
            if (campaignTime2 != null && campaignTime2 != CommonTypesProto.CampaignTime.getDefaultInstance()) {
                campaignTime = CommonTypesProto.CampaignTime.newBuilder(this.endTime_).mergeFrom((CommonTypesProto.CampaignTime.Builder) campaignTime).buildPartial();
            }
            this.endTime_ = campaignTime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePriority(CommonTypesProto.Priority priority) {
            CommonTypesProto.Priority priority2 = this.priority_;
            if (priority2 != null && priority2 != CommonTypesProto.Priority.getDefaultInstance()) {
                priority = CommonTypesProto.Priority.newBuilder(this.priority_).mergeFrom((CommonTypesProto.Priority.Builder) priority).buildPartial();
            }
            this.priority_ = priority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStartTime(CommonTypesProto.CampaignTime campaignTime) {
            CommonTypesProto.CampaignTime campaignTime2 = this.startTime_;
            if (campaignTime2 != null && campaignTime2 != CommonTypesProto.CampaignTime.getDefaultInstance()) {
                campaignTime = CommonTypesProto.CampaignTime.newBuilder(this.startTime_).mergeFrom((CommonTypesProto.CampaignTime.Builder) campaignTime).buildPartial();
            }
            this.startTime_ = campaignTime;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExperimentalCampaignRollout experimentalCampaignRollout) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) experimentalCampaignRollout);
        }

        public static ExperimentalCampaignRollout parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentalCampaignRollout parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(ByteString byteString) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentalCampaignRollout parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentalCampaignRollout parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(InputStream inputStream) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentalCampaignRollout parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(byte[] bArr) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentalCampaignRollout parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ExperimentalCampaignRollout> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTime(CommonTypesProto.CampaignTime.Builder builder) {
            this.endTime_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTime(CommonTypesProto.CampaignTime campaignTime) {
            if (campaignTime == null) {
                throw new NullPointerException();
            }
            this.endTime_ = campaignTime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentId(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.experimentId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentIdBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.experimentId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPriority(CommonTypesProto.Priority.Builder builder) {
            this.priority_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPriority(CommonTypesProto.Priority priority) {
            if (priority == null) {
                throw new NullPointerException();
            }
            this.priority_ = priority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSelectedVariantIndex(int i) {
            this.selectedVariantIndex_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTime(CommonTypesProto.CampaignTime.Builder builder) {
            this.startTime_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTime(CommonTypesProto.CampaignTime campaignTime) {
            if (campaignTime == null) {
                throw new NullPointerException();
            }
            this.startTime_ = campaignTime;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentalCampaignRollout();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ExperimentalCampaignRollout experimentalCampaignRollout = (ExperimentalCampaignRollout) obj2;
                    this.experimentId_ = visitor.visitString(!this.experimentId_.isEmpty(), this.experimentId_, !experimentalCampaignRollout.experimentId_.isEmpty(), experimentalCampaignRollout.experimentId_);
                    this.selectedVariantIndex_ = visitor.visitInt(this.selectedVariantIndex_ != 0, this.selectedVariantIndex_, experimentalCampaignRollout.selectedVariantIndex_ != 0, experimentalCampaignRollout.selectedVariantIndex_);
                    this.priority_ = (CommonTypesProto.Priority) visitor.visitMessage(this.priority_, experimentalCampaignRollout.priority_);
                    this.startTime_ = (CommonTypesProto.CampaignTime) visitor.visitMessage(this.startTime_, experimentalCampaignRollout.startTime_);
                    this.endTime_ = (CommonTypesProto.CampaignTime) visitor.visitMessage(this.endTime_, experimentalCampaignRollout.endTime_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.experimentId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.selectedVariantIndex_ = codedInputStream.readInt32();
                                } else if (readTag == 26) {
                                    CommonTypesProto.Priority.Builder builder = this.priority_ != null ? this.priority_.toBuilder() : null;
                                    this.priority_ = (CommonTypesProto.Priority) codedInputStream.readMessage(CommonTypesProto.Priority.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((CommonTypesProto.Priority.Builder) this.priority_);
                                        this.priority_ = builder.buildPartial();
                                    }
                                } else if (readTag == 34) {
                                    CommonTypesProto.CampaignTime.Builder builder2 = this.startTime_ != null ? this.startTime_.toBuilder() : null;
                                    this.startTime_ = (CommonTypesProto.CampaignTime) codedInputStream.readMessage(CommonTypesProto.CampaignTime.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((CommonTypesProto.CampaignTime.Builder) this.startTime_);
                                        this.startTime_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 42) {
                                    CommonTypesProto.CampaignTime.Builder builder3 = this.endTime_ != null ? this.endTime_.toBuilder() : null;
                                    this.endTime_ = (CommonTypesProto.CampaignTime) codedInputStream.readMessage(CommonTypesProto.CampaignTime.parser(), extensionRegistryLite);
                                    if (builder3 != null) {
                                        builder3.mergeFrom((CommonTypesProto.CampaignTime.Builder) this.endTime_);
                                        this.endTime_ = builder3.buildPartial();
                                    }
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r0 = true;
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
                        synchronized (ExperimentalCampaignRollout.class) {
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

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public CommonTypesProto.CampaignTime getEndTime() {
            CommonTypesProto.CampaignTime campaignTime = this.endTime_;
            return campaignTime == null ? CommonTypesProto.CampaignTime.getDefaultInstance() : campaignTime;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8(this.experimentId_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public CommonTypesProto.Priority getPriority() {
            CommonTypesProto.Priority priority = this.priority_;
            return priority == null ? CommonTypesProto.Priority.getDefaultInstance() : priority;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public int getSelectedVariantIndex() {
            return this.selectedVariantIndex_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.experimentId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getExperimentId());
            int i2 = this.selectedVariantIndex_;
            if (i2 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(2, i2);
            }
            if (this.priority_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, getPriority());
            }
            if (this.startTime_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(4, getStartTime());
            }
            if (this.endTime_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(5, getEndTime());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public CommonTypesProto.CampaignTime getStartTime() {
            CommonTypesProto.CampaignTime campaignTime = this.startTime_;
            return campaignTime == null ? CommonTypesProto.CampaignTime.getDefaultInstance() : campaignTime;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public boolean hasEndTime() {
            return this.endTime_ != null;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public boolean hasPriority() {
            return this.priority_ != null;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public boolean hasStartTime() {
            return this.startTime_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.experimentId_.isEmpty()) {
                codedOutputStream.writeString(1, getExperimentId());
            }
            int i = this.selectedVariantIndex_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            if (this.priority_ != null) {
                codedOutputStream.writeMessage(3, getPriority());
            }
            if (this.startTime_ != null) {
                codedOutputStream.writeMessage(4, getStartTime());
            }
            if (this.endTime_ != null) {
                codedOutputStream.writeMessage(5, getEndTime());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ExperimentalCampaignRolloutOrBuilder extends MessageLiteOrBuilder {
        CommonTypesProto.CampaignTime getEndTime();

        String getExperimentId();

        ByteString getExperimentIdBytes();

        CommonTypesProto.Priority getPriority();

        int getSelectedVariantIndex();

        CommonTypesProto.CampaignTime getStartTime();

        boolean hasEndTime();

        boolean hasPriority();

        boolean hasStartTime();
    }

    /* loaded from: classes2.dex */
    public static final class ThickContent extends GeneratedMessageLite<ThickContent, Builder> implements ThickContentOrBuilder {
        public static final int CONTENT_FIELD_NUMBER = 3;
        private static final ThickContent DEFAULT_INSTANCE = new ThickContent();
        public static final int EXPERIMENTAL_PAYLOAD_FIELD_NUMBER = 2;
        public static final int IS_TEST_CAMPAIGN_FIELD_NUMBER = 7;
        private static volatile Parser<ThickContent> PARSER = null;
        public static final int PRIORITY_FIELD_NUMBER = 4;
        public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 5;
        public static final int VANILLA_PAYLOAD_FIELD_NUMBER = 1;
        private int bitField0_;
        private MessagesProto.Content content_;
        private boolean isTestCampaign_;
        private Object payload_;
        private CommonTypesProto.Priority priority_;
        private int payloadCase_ = 0;
        private Internal.ProtobufList<CommonTypesProto.TriggeringCondition> triggeringConditions_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ThickContent, Builder> implements ThickContentOrBuilder {
            private Builder() {
                super(ThickContent.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> iterable) {
                a();
                ((ThickContent) this.a).addAllTriggeringConditions(iterable);
                return this;
            }

            public Builder addTriggeringConditions(int i, CommonTypesProto.TriggeringCondition.Builder builder) {
                a();
                ((ThickContent) this.a).addTriggeringConditions(i, builder);
                return this;
            }

            public Builder addTriggeringConditions(int i, CommonTypesProto.TriggeringCondition triggeringCondition) {
                a();
                ((ThickContent) this.a).addTriggeringConditions(i, triggeringCondition);
                return this;
            }

            public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder builder) {
                a();
                ((ThickContent) this.a).addTriggeringConditions(builder);
                return this;
            }

            public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition triggeringCondition) {
                a();
                ((ThickContent) this.a).addTriggeringConditions(triggeringCondition);
                return this;
            }

            public Builder clearContent() {
                a();
                ((ThickContent) this.a).clearContent();
                return this;
            }

            public Builder clearExperimentalPayload() {
                a();
                ((ThickContent) this.a).clearExperimentalPayload();
                return this;
            }

            public Builder clearIsTestCampaign() {
                a();
                ((ThickContent) this.a).clearIsTestCampaign();
                return this;
            }

            public Builder clearPayload() {
                a();
                ((ThickContent) this.a).clearPayload();
                return this;
            }

            public Builder clearPriority() {
                a();
                ((ThickContent) this.a).clearPriority();
                return this;
            }

            public Builder clearTriggeringConditions() {
                a();
                ((ThickContent) this.a).clearTriggeringConditions();
                return this;
            }

            public Builder clearVanillaPayload() {
                a();
                ((ThickContent) this.a).clearVanillaPayload();
                return this;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public MessagesProto.Content getContent() {
                return ((ThickContent) this.a).getContent();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public ExperimentalCampaignPayload getExperimentalPayload() {
                return ((ThickContent) this.a).getExperimentalPayload();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean getIsTestCampaign() {
                return ((ThickContent) this.a).getIsTestCampaign();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public PayloadCase getPayloadCase() {
                return ((ThickContent) this.a).getPayloadCase();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public CommonTypesProto.Priority getPriority() {
                return ((ThickContent) this.a).getPriority();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public CommonTypesProto.TriggeringCondition getTriggeringConditions(int i) {
                return ((ThickContent) this.a).getTriggeringConditions(i);
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public int getTriggeringConditionsCount() {
                return ((ThickContent) this.a).getTriggeringConditionsCount();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
                return Collections.unmodifiableList(((ThickContent) this.a).getTriggeringConditionsList());
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public VanillaCampaignPayload getVanillaPayload() {
                return ((ThickContent) this.a).getVanillaPayload();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean hasContent() {
                return ((ThickContent) this.a).hasContent();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean hasPriority() {
                return ((ThickContent) this.a).hasPriority();
            }

            public Builder mergeContent(MessagesProto.Content content) {
                a();
                ((ThickContent) this.a).mergeContent(content);
                return this;
            }

            public Builder mergeExperimentalPayload(ExperimentalCampaignPayload experimentalCampaignPayload) {
                a();
                ((ThickContent) this.a).mergeExperimentalPayload(experimentalCampaignPayload);
                return this;
            }

            public Builder mergePriority(CommonTypesProto.Priority priority) {
                a();
                ((ThickContent) this.a).mergePriority(priority);
                return this;
            }

            public Builder mergeVanillaPayload(VanillaCampaignPayload vanillaCampaignPayload) {
                a();
                ((ThickContent) this.a).mergeVanillaPayload(vanillaCampaignPayload);
                return this;
            }

            public Builder removeTriggeringConditions(int i) {
                a();
                ((ThickContent) this.a).removeTriggeringConditions(i);
                return this;
            }

            public Builder setContent(MessagesProto.Content.Builder builder) {
                a();
                ((ThickContent) this.a).setContent(builder);
                return this;
            }

            public Builder setContent(MessagesProto.Content content) {
                a();
                ((ThickContent) this.a).setContent(content);
                return this;
            }

            public Builder setExperimentalPayload(ExperimentalCampaignPayload.Builder builder) {
                a();
                ((ThickContent) this.a).setExperimentalPayload(builder);
                return this;
            }

            public Builder setExperimentalPayload(ExperimentalCampaignPayload experimentalCampaignPayload) {
                a();
                ((ThickContent) this.a).setExperimentalPayload(experimentalCampaignPayload);
                return this;
            }

            public Builder setIsTestCampaign(boolean z) {
                a();
                ((ThickContent) this.a).setIsTestCampaign(z);
                return this;
            }

            public Builder setPriority(CommonTypesProto.Priority.Builder builder) {
                a();
                ((ThickContent) this.a).setPriority(builder);
                return this;
            }

            public Builder setPriority(CommonTypesProto.Priority priority) {
                a();
                ((ThickContent) this.a).setPriority(priority);
                return this;
            }

            public Builder setTriggeringConditions(int i, CommonTypesProto.TriggeringCondition.Builder builder) {
                a();
                ((ThickContent) this.a).setTriggeringConditions(i, builder);
                return this;
            }

            public Builder setTriggeringConditions(int i, CommonTypesProto.TriggeringCondition triggeringCondition) {
                a();
                ((ThickContent) this.a).setTriggeringConditions(i, triggeringCondition);
                return this;
            }

            public Builder setVanillaPayload(VanillaCampaignPayload.Builder builder) {
                a();
                ((ThickContent) this.a).setVanillaPayload(builder);
                return this;
            }

            public Builder setVanillaPayload(VanillaCampaignPayload vanillaCampaignPayload) {
                a();
                ((ThickContent) this.a).setVanillaPayload(vanillaCampaignPayload);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum PayloadCase implements Internal.EnumLite {
            VANILLA_PAYLOAD(1),
            EXPERIMENTAL_PAYLOAD(2),
            PAYLOAD_NOT_SET(0);

            private final int value;

            PayloadCase(int i) {
                this.value = i;
            }

            public static PayloadCase forNumber(int i) {
                if (i == 0) {
                    return PAYLOAD_NOT_SET;
                }
                if (i == 1) {
                    return VANILLA_PAYLOAD;
                }
                if (i != 2) {
                    return null;
                }
                return EXPERIMENTAL_PAYLOAD;
            }

            @Deprecated
            public static PayloadCase valueOf(int i) {
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

        private ThickContent() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> iterable) {
            ensureTriggeringConditionsIsMutable();
            AbstractMessageLite.a(iterable, this.triggeringConditions_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggeringConditions(int i, CommonTypesProto.TriggeringCondition.Builder builder) {
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggeringConditions(int i, CommonTypesProto.TriggeringCondition triggeringCondition) {
            if (triggeringCondition == null) {
                throw new NullPointerException();
            }
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.add(i, triggeringCondition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder builder) {
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggeringConditions(CommonTypesProto.TriggeringCondition triggeringCondition) {
            if (triggeringCondition == null) {
                throw new NullPointerException();
            }
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.add(triggeringCondition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.content_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentalPayload() {
            if (this.payloadCase_ == 2) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsTestCampaign() {
            this.isTestCampaign_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPayload() {
            this.payloadCase_ = 0;
            this.payload_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPriority() {
            this.priority_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggeringConditions() {
            this.triggeringConditions_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVanillaPayload() {
            if (this.payloadCase_ == 1) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        private void ensureTriggeringConditionsIsMutable() {
            if (this.triggeringConditions_.isModifiable()) {
                return;
            }
            this.triggeringConditions_ = GeneratedMessageLite.a(this.triggeringConditions_);
        }

        public static ThickContent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeContent(MessagesProto.Content content) {
            MessagesProto.Content content2 = this.content_;
            if (content2 != null && content2 != MessagesProto.Content.getDefaultInstance()) {
                content = MessagesProto.Content.newBuilder(this.content_).mergeFrom((MessagesProto.Content.Builder) content).buildPartial();
            }
            this.content_ = content;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExperimentalPayload(ExperimentalCampaignPayload experimentalCampaignPayload) {
            if (this.payloadCase_ == 2 && this.payload_ != ExperimentalCampaignPayload.getDefaultInstance()) {
                experimentalCampaignPayload = ExperimentalCampaignPayload.newBuilder((ExperimentalCampaignPayload) this.payload_).mergeFrom((ExperimentalCampaignPayload.Builder) experimentalCampaignPayload).buildPartial();
            }
            this.payload_ = experimentalCampaignPayload;
            this.payloadCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePriority(CommonTypesProto.Priority priority) {
            CommonTypesProto.Priority priority2 = this.priority_;
            if (priority2 != null && priority2 != CommonTypesProto.Priority.getDefaultInstance()) {
                priority = CommonTypesProto.Priority.newBuilder(this.priority_).mergeFrom((CommonTypesProto.Priority.Builder) priority).buildPartial();
            }
            this.priority_ = priority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeVanillaPayload(VanillaCampaignPayload vanillaCampaignPayload) {
            if (this.payloadCase_ == 1 && this.payload_ != VanillaCampaignPayload.getDefaultInstance()) {
                vanillaCampaignPayload = VanillaCampaignPayload.newBuilder((VanillaCampaignPayload) this.payload_).mergeFrom((VanillaCampaignPayload.Builder) vanillaCampaignPayload).buildPartial();
            }
            this.payload_ = vanillaCampaignPayload;
            this.payloadCase_ = 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ThickContent thickContent) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) thickContent);
        }

        public static ThickContent parseDelimitedFrom(InputStream inputStream) {
            return (ThickContent) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ThickContent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ThickContent parseFrom(ByteString byteString) {
            return (ThickContent) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ThickContent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ThickContent parseFrom(CodedInputStream codedInputStream) {
            return (ThickContent) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ThickContent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ThickContent parseFrom(InputStream inputStream) {
            return (ThickContent) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ThickContent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ThickContent parseFrom(byte[] bArr) {
            return (ThickContent) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ThickContent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ThickContent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeTriggeringConditions(int i) {
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(MessagesProto.Content.Builder builder) {
            this.content_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(MessagesProto.Content content) {
            if (content == null) {
                throw new NullPointerException();
            }
            this.content_ = content;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentalPayload(ExperimentalCampaignPayload.Builder builder) {
            this.payload_ = builder.build();
            this.payloadCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentalPayload(ExperimentalCampaignPayload experimentalCampaignPayload) {
            if (experimentalCampaignPayload == null) {
                throw new NullPointerException();
            }
            this.payload_ = experimentalCampaignPayload;
            this.payloadCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsTestCampaign(boolean z) {
            this.isTestCampaign_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPriority(CommonTypesProto.Priority.Builder builder) {
            this.priority_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPriority(CommonTypesProto.Priority priority) {
            if (priority == null) {
                throw new NullPointerException();
            }
            this.priority_ = priority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggeringConditions(int i, CommonTypesProto.TriggeringCondition.Builder builder) {
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggeringConditions(int i, CommonTypesProto.TriggeringCondition triggeringCondition) {
            if (triggeringCondition == null) {
                throw new NullPointerException();
            }
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.set(i, triggeringCondition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanillaPayload(VanillaCampaignPayload.Builder builder) {
            this.payload_ = builder.build();
            this.payloadCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanillaPayload(VanillaCampaignPayload vanillaCampaignPayload) {
            if (vanillaCampaignPayload == null) {
                throw new NullPointerException();
            }
            this.payload_ = vanillaCampaignPayload;
            this.payloadCase_ = 1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:134:0x01aa, code lost:
        
            if (r5.payloadCase_ == 2) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x01b2, code lost:
        
            r5.payload_ = r7.visitOneofMessage(r1, r5.payload_, r8.payload_);
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x01b1, code lost:
        
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x01af, code lost:
        
            if (r5.payloadCase_ == 1) goto L102;
         */
        @Override // com.google.protobuf.GeneratedMessageLite
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r6, java.lang.Object r7, java.lang.Object r8) {
            /*
                Method dump skipped, instructions count: 504
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContent.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public MessagesProto.Content getContent() {
            MessagesProto.Content content = this.content_;
            return content == null ? MessagesProto.Content.getDefaultInstance() : content;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public ExperimentalCampaignPayload getExperimentalPayload() {
            return this.payloadCase_ == 2 ? (ExperimentalCampaignPayload) this.payload_ : ExperimentalCampaignPayload.getDefaultInstance();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean getIsTestCampaign() {
            return this.isTestCampaign_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public PayloadCase getPayloadCase() {
            return PayloadCase.forNumber(this.payloadCase_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public CommonTypesProto.Priority getPriority() {
            CommonTypesProto.Priority priority = this.priority_;
            return priority == null ? CommonTypesProto.Priority.getDefaultInstance() : priority;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.payloadCase_ == 1 ? CodedOutputStream.computeMessageSize(1, (VanillaCampaignPayload) this.payload_) + 0 : 0;
            if (this.payloadCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (ExperimentalCampaignPayload) this.payload_);
            }
            if (this.content_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, getContent());
            }
            if (this.priority_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, getPriority());
            }
            for (int i2 = 0; i2 < this.triggeringConditions_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(5, this.triggeringConditions_.get(i2));
            }
            boolean z = this.isTestCampaign_;
            if (z) {
                computeMessageSize += CodedOutputStream.computeBoolSize(7, z);
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public CommonTypesProto.TriggeringCondition getTriggeringConditions(int i) {
            return this.triggeringConditions_.get(i);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public int getTriggeringConditionsCount() {
            return this.triggeringConditions_.size();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
            return this.triggeringConditions_;
        }

        public CommonTypesProto.TriggeringConditionOrBuilder getTriggeringConditionsOrBuilder(int i) {
            return this.triggeringConditions_.get(i);
        }

        public List<? extends CommonTypesProto.TriggeringConditionOrBuilder> getTriggeringConditionsOrBuilderList() {
            return this.triggeringConditions_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public VanillaCampaignPayload getVanillaPayload() {
            return this.payloadCase_ == 1 ? (VanillaCampaignPayload) this.payload_ : VanillaCampaignPayload.getDefaultInstance();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean hasContent() {
            return this.content_ != null;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean hasPriority() {
            return this.priority_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.payloadCase_ == 1) {
                codedOutputStream.writeMessage(1, (VanillaCampaignPayload) this.payload_);
            }
            if (this.payloadCase_ == 2) {
                codedOutputStream.writeMessage(2, (ExperimentalCampaignPayload) this.payload_);
            }
            if (this.content_ != null) {
                codedOutputStream.writeMessage(3, getContent());
            }
            if (this.priority_ != null) {
                codedOutputStream.writeMessage(4, getPriority());
            }
            for (int i = 0; i < this.triggeringConditions_.size(); i++) {
                codedOutputStream.writeMessage(5, this.triggeringConditions_.get(i));
            }
            boolean z = this.isTestCampaign_;
            if (z) {
                codedOutputStream.writeBool(7, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ThickContentOrBuilder extends MessageLiteOrBuilder {
        MessagesProto.Content getContent();

        ExperimentalCampaignPayload getExperimentalPayload();

        boolean getIsTestCampaign();

        ThickContent.PayloadCase getPayloadCase();

        CommonTypesProto.Priority getPriority();

        CommonTypesProto.TriggeringCondition getTriggeringConditions(int i);

        int getTriggeringConditionsCount();

        List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList();

        VanillaCampaignPayload getVanillaPayload();

        boolean hasContent();

        boolean hasPriority();
    }

    /* loaded from: classes2.dex */
    public static final class VanillaCampaignPayload extends GeneratedMessageLite<VanillaCampaignPayload, Builder> implements VanillaCampaignPayloadOrBuilder {
        public static final int CAMPAIGN_END_TIME_MILLIS_FIELD_NUMBER = 4;
        public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
        public static final int CAMPAIGN_NAME_FIELD_NUMBER = 5;
        public static final int CAMPAIGN_START_TIME_MILLIS_FIELD_NUMBER = 3;
        private static final VanillaCampaignPayload DEFAULT_INSTANCE = new VanillaCampaignPayload();
        public static final int EXPERIMENTAL_CAMPAIGN_ID_FIELD_NUMBER = 2;
        private static volatile Parser<VanillaCampaignPayload> PARSER;
        private long campaignEndTimeMillis_;
        private long campaignStartTimeMillis_;
        private String campaignId_ = "";
        private String experimentalCampaignId_ = "";
        private String campaignName_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<VanillaCampaignPayload, Builder> implements VanillaCampaignPayloadOrBuilder {
            private Builder() {
                super(VanillaCampaignPayload.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCampaignEndTimeMillis() {
                a();
                ((VanillaCampaignPayload) this.a).clearCampaignEndTimeMillis();
                return this;
            }

            public Builder clearCampaignId() {
                a();
                ((VanillaCampaignPayload) this.a).clearCampaignId();
                return this;
            }

            public Builder clearCampaignName() {
                a();
                ((VanillaCampaignPayload) this.a).clearCampaignName();
                return this;
            }

            public Builder clearCampaignStartTimeMillis() {
                a();
                ((VanillaCampaignPayload) this.a).clearCampaignStartTimeMillis();
                return this;
            }

            public Builder clearExperimentalCampaignId() {
                a();
                ((VanillaCampaignPayload) this.a).clearExperimentalCampaignId();
                return this;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public long getCampaignEndTimeMillis() {
                return ((VanillaCampaignPayload) this.a).getCampaignEndTimeMillis();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public String getCampaignId() {
                return ((VanillaCampaignPayload) this.a).getCampaignId();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public ByteString getCampaignIdBytes() {
                return ((VanillaCampaignPayload) this.a).getCampaignIdBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public String getCampaignName() {
                return ((VanillaCampaignPayload) this.a).getCampaignName();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public ByteString getCampaignNameBytes() {
                return ((VanillaCampaignPayload) this.a).getCampaignNameBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public long getCampaignStartTimeMillis() {
                return ((VanillaCampaignPayload) this.a).getCampaignStartTimeMillis();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public String getExperimentalCampaignId() {
                return ((VanillaCampaignPayload) this.a).getExperimentalCampaignId();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public ByteString getExperimentalCampaignIdBytes() {
                return ((VanillaCampaignPayload) this.a).getExperimentalCampaignIdBytes();
            }

            public Builder setCampaignEndTimeMillis(long j) {
                a();
                ((VanillaCampaignPayload) this.a).setCampaignEndTimeMillis(j);
                return this;
            }

            public Builder setCampaignId(String str) {
                a();
                ((VanillaCampaignPayload) this.a).setCampaignId(str);
                return this;
            }

            public Builder setCampaignIdBytes(ByteString byteString) {
                a();
                ((VanillaCampaignPayload) this.a).setCampaignIdBytes(byteString);
                return this;
            }

            public Builder setCampaignName(String str) {
                a();
                ((VanillaCampaignPayload) this.a).setCampaignName(str);
                return this;
            }

            public Builder setCampaignNameBytes(ByteString byteString) {
                a();
                ((VanillaCampaignPayload) this.a).setCampaignNameBytes(byteString);
                return this;
            }

            public Builder setCampaignStartTimeMillis(long j) {
                a();
                ((VanillaCampaignPayload) this.a).setCampaignStartTimeMillis(j);
                return this;
            }

            public Builder setExperimentalCampaignId(String str) {
                a();
                ((VanillaCampaignPayload) this.a).setExperimentalCampaignId(str);
                return this;
            }

            public Builder setExperimentalCampaignIdBytes(ByteString byteString) {
                a();
                ((VanillaCampaignPayload) this.a).setExperimentalCampaignIdBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private VanillaCampaignPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignEndTimeMillis() {
            this.campaignEndTimeMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignId() {
            this.campaignId_ = getDefaultInstance().getCampaignId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignName() {
            this.campaignName_ = getDefaultInstance().getCampaignName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignStartTimeMillis() {
            this.campaignStartTimeMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentalCampaignId() {
            this.experimentalCampaignId_ = getDefaultInstance().getExperimentalCampaignId();
        }

        public static VanillaCampaignPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VanillaCampaignPayload vanillaCampaignPayload) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) vanillaCampaignPayload);
        }

        public static VanillaCampaignPayload parseDelimitedFrom(InputStream inputStream) {
            return (VanillaCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static VanillaCampaignPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(ByteString byteString) {
            return (VanillaCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static VanillaCampaignPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(CodedInputStream codedInputStream) {
            return (VanillaCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static VanillaCampaignPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(InputStream inputStream) {
            return (VanillaCampaignPayload) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static VanillaCampaignPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(byte[] bArr) {
            return (VanillaCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static VanillaCampaignPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<VanillaCampaignPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignEndTimeMillis(long j) {
            this.campaignEndTimeMillis_ = j;
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
        public void setCampaignName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.campaignName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.campaignName_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignStartTimeMillis(long j) {
            this.campaignStartTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentalCampaignId(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.experimentalCampaignId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentalCampaignIdBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.experimentalCampaignId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            boolean z = false;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new VanillaCampaignPayload();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    VanillaCampaignPayload vanillaCampaignPayload = (VanillaCampaignPayload) obj2;
                    this.campaignId_ = visitor.visitString(!this.campaignId_.isEmpty(), this.campaignId_, !vanillaCampaignPayload.campaignId_.isEmpty(), vanillaCampaignPayload.campaignId_);
                    this.experimentalCampaignId_ = visitor.visitString(!this.experimentalCampaignId_.isEmpty(), this.experimentalCampaignId_, !vanillaCampaignPayload.experimentalCampaignId_.isEmpty(), vanillaCampaignPayload.experimentalCampaignId_);
                    this.campaignStartTimeMillis_ = visitor.visitLong(this.campaignStartTimeMillis_ != 0, this.campaignStartTimeMillis_, vanillaCampaignPayload.campaignStartTimeMillis_ != 0, vanillaCampaignPayload.campaignStartTimeMillis_);
                    this.campaignEndTimeMillis_ = visitor.visitLong(this.campaignEndTimeMillis_ != 0, this.campaignEndTimeMillis_, vanillaCampaignPayload.campaignEndTimeMillis_ != 0, vanillaCampaignPayload.campaignEndTimeMillis_);
                    this.campaignName_ = visitor.visitString(!this.campaignName_.isEmpty(), this.campaignName_, !vanillaCampaignPayload.campaignName_.isEmpty(), vanillaCampaignPayload.campaignName_);
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
                                } else if (readTag == 18) {
                                    this.experimentalCampaignId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.campaignStartTimeMillis_ = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.campaignEndTimeMillis_ = codedInputStream.readInt64();
                                } else if (readTag == 42) {
                                    this.campaignName_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (VanillaCampaignPayload.class) {
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

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public long getCampaignEndTimeMillis() {
            return this.campaignEndTimeMillis_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public String getCampaignId() {
            return this.campaignId_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public ByteString getCampaignIdBytes() {
            return ByteString.copyFromUtf8(this.campaignId_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public String getCampaignName() {
            return this.campaignName_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public ByteString getCampaignNameBytes() {
            return ByteString.copyFromUtf8(this.campaignName_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public long getCampaignStartTimeMillis() {
            return this.campaignStartTimeMillis_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public String getExperimentalCampaignId() {
            return this.experimentalCampaignId_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public ByteString getExperimentalCampaignIdBytes() {
            return ByteString.copyFromUtf8(this.experimentalCampaignId_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.campaignId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getCampaignId());
            if (!this.experimentalCampaignId_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getExperimentalCampaignId());
            }
            long j = this.campaignStartTimeMillis_;
            if (j != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(3, j);
            }
            long j2 = this.campaignEndTimeMillis_;
            if (j2 != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(4, j2);
            }
            if (!this.campaignName_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(5, getCampaignName());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.campaignId_.isEmpty()) {
                codedOutputStream.writeString(1, getCampaignId());
            }
            if (!this.experimentalCampaignId_.isEmpty()) {
                codedOutputStream.writeString(2, getExperimentalCampaignId());
            }
            long j = this.campaignStartTimeMillis_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            long j2 = this.campaignEndTimeMillis_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(4, j2);
            }
            if (this.campaignName_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(5, getCampaignName());
        }
    }

    /* loaded from: classes2.dex */
    public interface VanillaCampaignPayloadOrBuilder extends MessageLiteOrBuilder {
        long getCampaignEndTimeMillis();

        String getCampaignId();

        ByteString getCampaignIdBytes();

        String getCampaignName();

        ByteString getCampaignNameBytes();

        long getCampaignStartTimeMillis();

        String getExperimentalCampaignId();

        ByteString getExperimentalCampaignIdBytes();
    }

    private CampaignProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
