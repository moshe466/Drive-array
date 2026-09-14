package developers.mobile.abt;

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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class FirebaseAbt {

    /* renamed from: developers.mobile.abt.FirebaseAbt$1, reason: invalid class name */
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
    public static final class ExperimentLite extends GeneratedMessageLite<ExperimentLite, Builder> implements ExperimentLiteOrBuilder {
        private static final ExperimentLite DEFAULT_INSTANCE = new ExperimentLite();
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        private static volatile Parser<ExperimentLite> PARSER;
        private String experimentId_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentLite, Builder> implements ExperimentLiteOrBuilder {
            private Builder() {
                super(ExperimentLite.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearExperimentId() {
                a();
                ((ExperimentLite) this.a).clearExperimentId();
                return this;
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentLiteOrBuilder
            public String getExperimentId() {
                return ((ExperimentLite) this.a).getExperimentId();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentLiteOrBuilder
            public ByteString getExperimentIdBytes() {
                return ((ExperimentLite) this.a).getExperimentIdBytes();
            }

            public Builder setExperimentId(String str) {
                a();
                ((ExperimentLite) this.a).setExperimentId(str);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                a();
                ((ExperimentLite) this.a).setExperimentIdBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ExperimentLite() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentId() {
            this.experimentId_ = getDefaultInstance().getExperimentId();
        }

        public static ExperimentLite getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExperimentLite experimentLite) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) experimentLite);
        }

        public static ExperimentLite parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentLite) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentLite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(ByteString byteString) {
            return (ExperimentLite) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentLite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentLite) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentLite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(InputStream inputStream) {
            return (ExperimentLite) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentLite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(byte[] bArr) {
            return (ExperimentLite) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentLite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ExperimentLite> parser() {
            return DEFAULT_INSTANCE.getParserForType();
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

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentLite();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    ExperimentLite experimentLite = (ExperimentLite) obj2;
                    this.experimentId_ = ((GeneratedMessageLite.Visitor) obj).visitString(!this.experimentId_.isEmpty(), this.experimentId_, true ^ experimentLite.experimentId_.isEmpty(), experimentLite.experimentId_);
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
                                    this.experimentId_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (ExperimentLite.class) {
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

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentLiteOrBuilder
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentLiteOrBuilder
        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8(this.experimentId_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.experimentId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getExperimentId());
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.experimentId_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(1, getExperimentId());
        }
    }

    /* loaded from: classes2.dex */
    public interface ExperimentLiteOrBuilder extends MessageLiteOrBuilder {
        String getExperimentId();

        ByteString getExperimentIdBytes();
    }

    /* loaded from: classes2.dex */
    public static final class ExperimentPayload extends GeneratedMessageLite<ExperimentPayload, Builder> implements ExperimentPayloadOrBuilder {
        public static final int ACTIVATE_EVENT_TO_LOG_FIELD_NUMBER = 8;
        public static final int CLEAR_EVENT_TO_LOG_FIELD_NUMBER = 9;
        private static final ExperimentPayload DEFAULT_INSTANCE = new ExperimentPayload();
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        public static final int EXPERIMENT_START_TIME_MILLIS_FIELD_NUMBER = 3;
        public static final int ONGOING_EXPERIMENTS_FIELD_NUMBER = 13;
        public static final int OVERFLOW_POLICY_FIELD_NUMBER = 12;
        private static volatile Parser<ExperimentPayload> PARSER = null;
        public static final int SET_EVENT_TO_LOG_FIELD_NUMBER = 7;
        public static final int TIMEOUT_EVENT_TO_LOG_FIELD_NUMBER = 10;
        public static final int TIME_TO_LIVE_MILLIS_FIELD_NUMBER = 6;
        public static final int TRIGGER_EVENT_FIELD_NUMBER = 4;
        public static final int TRIGGER_TIMEOUT_MILLIS_FIELD_NUMBER = 5;
        public static final int TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER = 11;
        public static final int VARIANT_ID_FIELD_NUMBER = 2;
        private int bitField0_;
        private long experimentStartTimeMillis_;
        private int overflowPolicy_;
        private long timeToLiveMillis_;
        private long triggerTimeoutMillis_;
        private String experimentId_ = "";
        private String variantId_ = "";
        private String triggerEvent_ = "";
        private String setEventToLog_ = "";
        private String activateEventToLog_ = "";
        private String clearEventToLog_ = "";
        private String timeoutEventToLog_ = "";
        private String ttlExpiryEventToLog_ = "";
        private Internal.ProtobufList<ExperimentLite> ongoingExperiments_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentPayload, Builder> implements ExperimentPayloadOrBuilder {
            private Builder() {
                super(ExperimentPayload.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllOngoingExperiments(Iterable<? extends ExperimentLite> iterable) {
                a();
                ((ExperimentPayload) this.a).addAllOngoingExperiments(iterable);
                return this;
            }

            public Builder addOngoingExperiments(int i, ExperimentLite.Builder builder) {
                a();
                ((ExperimentPayload) this.a).addOngoingExperiments(i, builder);
                return this;
            }

            public Builder addOngoingExperiments(int i, ExperimentLite experimentLite) {
                a();
                ((ExperimentPayload) this.a).addOngoingExperiments(i, experimentLite);
                return this;
            }

            public Builder addOngoingExperiments(ExperimentLite.Builder builder) {
                a();
                ((ExperimentPayload) this.a).addOngoingExperiments(builder);
                return this;
            }

            public Builder addOngoingExperiments(ExperimentLite experimentLite) {
                a();
                ((ExperimentPayload) this.a).addOngoingExperiments(experimentLite);
                return this;
            }

            public Builder clearActivateEventToLog() {
                a();
                ((ExperimentPayload) this.a).clearActivateEventToLog();
                return this;
            }

            public Builder clearClearEventToLog() {
                a();
                ((ExperimentPayload) this.a).clearClearEventToLog();
                return this;
            }

            public Builder clearExperimentId() {
                a();
                ((ExperimentPayload) this.a).clearExperimentId();
                return this;
            }

            public Builder clearExperimentStartTimeMillis() {
                a();
                ((ExperimentPayload) this.a).clearExperimentStartTimeMillis();
                return this;
            }

            public Builder clearOngoingExperiments() {
                a();
                ((ExperimentPayload) this.a).clearOngoingExperiments();
                return this;
            }

            public Builder clearOverflowPolicy() {
                a();
                ((ExperimentPayload) this.a).clearOverflowPolicy();
                return this;
            }

            public Builder clearSetEventToLog() {
                a();
                ((ExperimentPayload) this.a).clearSetEventToLog();
                return this;
            }

            public Builder clearTimeToLiveMillis() {
                a();
                ((ExperimentPayload) this.a).clearTimeToLiveMillis();
                return this;
            }

            public Builder clearTimeoutEventToLog() {
                a();
                ((ExperimentPayload) this.a).clearTimeoutEventToLog();
                return this;
            }

            public Builder clearTriggerEvent() {
                a();
                ((ExperimentPayload) this.a).clearTriggerEvent();
                return this;
            }

            public Builder clearTriggerTimeoutMillis() {
                a();
                ((ExperimentPayload) this.a).clearTriggerTimeoutMillis();
                return this;
            }

            public Builder clearTtlExpiryEventToLog() {
                a();
                ((ExperimentPayload) this.a).clearTtlExpiryEventToLog();
                return this;
            }

            public Builder clearVariantId() {
                a();
                ((ExperimentPayload) this.a).clearVariantId();
                return this;
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public String getActivateEventToLog() {
                return ((ExperimentPayload) this.a).getActivateEventToLog();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ByteString getActivateEventToLogBytes() {
                return ((ExperimentPayload) this.a).getActivateEventToLogBytes();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public String getClearEventToLog() {
                return ((ExperimentPayload) this.a).getClearEventToLog();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ByteString getClearEventToLogBytes() {
                return ((ExperimentPayload) this.a).getClearEventToLogBytes();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public String getExperimentId() {
                return ((ExperimentPayload) this.a).getExperimentId();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ByteString getExperimentIdBytes() {
                return ((ExperimentPayload) this.a).getExperimentIdBytes();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public long getExperimentStartTimeMillis() {
                return ((ExperimentPayload) this.a).getExperimentStartTimeMillis();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ExperimentLite getOngoingExperiments(int i) {
                return ((ExperimentPayload) this.a).getOngoingExperiments(i);
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public int getOngoingExperimentsCount() {
                return ((ExperimentPayload) this.a).getOngoingExperimentsCount();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public List<ExperimentLite> getOngoingExperimentsList() {
                return Collections.unmodifiableList(((ExperimentPayload) this.a).getOngoingExperimentsList());
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ExperimentOverflowPolicy getOverflowPolicy() {
                return ((ExperimentPayload) this.a).getOverflowPolicy();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public int getOverflowPolicyValue() {
                return ((ExperimentPayload) this.a).getOverflowPolicyValue();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public String getSetEventToLog() {
                return ((ExperimentPayload) this.a).getSetEventToLog();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ByteString getSetEventToLogBytes() {
                return ((ExperimentPayload) this.a).getSetEventToLogBytes();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public long getTimeToLiveMillis() {
                return ((ExperimentPayload) this.a).getTimeToLiveMillis();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public String getTimeoutEventToLog() {
                return ((ExperimentPayload) this.a).getTimeoutEventToLog();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ByteString getTimeoutEventToLogBytes() {
                return ((ExperimentPayload) this.a).getTimeoutEventToLogBytes();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public String getTriggerEvent() {
                return ((ExperimentPayload) this.a).getTriggerEvent();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ByteString getTriggerEventBytes() {
                return ((ExperimentPayload) this.a).getTriggerEventBytes();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public long getTriggerTimeoutMillis() {
                return ((ExperimentPayload) this.a).getTriggerTimeoutMillis();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public String getTtlExpiryEventToLog() {
                return ((ExperimentPayload) this.a).getTtlExpiryEventToLog();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ByteString getTtlExpiryEventToLogBytes() {
                return ((ExperimentPayload) this.a).getTtlExpiryEventToLogBytes();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public String getVariantId() {
                return ((ExperimentPayload) this.a).getVariantId();
            }

            @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
            public ByteString getVariantIdBytes() {
                return ((ExperimentPayload) this.a).getVariantIdBytes();
            }

            public Builder removeOngoingExperiments(int i) {
                a();
                ((ExperimentPayload) this.a).removeOngoingExperiments(i);
                return this;
            }

            public Builder setActivateEventToLog(String str) {
                a();
                ((ExperimentPayload) this.a).setActivateEventToLog(str);
                return this;
            }

            public Builder setActivateEventToLogBytes(ByteString byteString) {
                a();
                ((ExperimentPayload) this.a).setActivateEventToLogBytes(byteString);
                return this;
            }

            public Builder setClearEventToLog(String str) {
                a();
                ((ExperimentPayload) this.a).setClearEventToLog(str);
                return this;
            }

            public Builder setClearEventToLogBytes(ByteString byteString) {
                a();
                ((ExperimentPayload) this.a).setClearEventToLogBytes(byteString);
                return this;
            }

            public Builder setExperimentId(String str) {
                a();
                ((ExperimentPayload) this.a).setExperimentId(str);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                a();
                ((ExperimentPayload) this.a).setExperimentIdBytes(byteString);
                return this;
            }

            public Builder setExperimentStartTimeMillis(long j) {
                a();
                ((ExperimentPayload) this.a).setExperimentStartTimeMillis(j);
                return this;
            }

            public Builder setOngoingExperiments(int i, ExperimentLite.Builder builder) {
                a();
                ((ExperimentPayload) this.a).setOngoingExperiments(i, builder);
                return this;
            }

            public Builder setOngoingExperiments(int i, ExperimentLite experimentLite) {
                a();
                ((ExperimentPayload) this.a).setOngoingExperiments(i, experimentLite);
                return this;
            }

            public Builder setOverflowPolicy(ExperimentOverflowPolicy experimentOverflowPolicy) {
                a();
                ((ExperimentPayload) this.a).setOverflowPolicy(experimentOverflowPolicy);
                return this;
            }

            public Builder setOverflowPolicyValue(int i) {
                a();
                ((ExperimentPayload) this.a).setOverflowPolicyValue(i);
                return this;
            }

            public Builder setSetEventToLog(String str) {
                a();
                ((ExperimentPayload) this.a).setSetEventToLog(str);
                return this;
            }

            public Builder setSetEventToLogBytes(ByteString byteString) {
                a();
                ((ExperimentPayload) this.a).setSetEventToLogBytes(byteString);
                return this;
            }

            public Builder setTimeToLiveMillis(long j) {
                a();
                ((ExperimentPayload) this.a).setTimeToLiveMillis(j);
                return this;
            }

            public Builder setTimeoutEventToLog(String str) {
                a();
                ((ExperimentPayload) this.a).setTimeoutEventToLog(str);
                return this;
            }

            public Builder setTimeoutEventToLogBytes(ByteString byteString) {
                a();
                ((ExperimentPayload) this.a).setTimeoutEventToLogBytes(byteString);
                return this;
            }

            public Builder setTriggerEvent(String str) {
                a();
                ((ExperimentPayload) this.a).setTriggerEvent(str);
                return this;
            }

            public Builder setTriggerEventBytes(ByteString byteString) {
                a();
                ((ExperimentPayload) this.a).setTriggerEventBytes(byteString);
                return this;
            }

            public Builder setTriggerTimeoutMillis(long j) {
                a();
                ((ExperimentPayload) this.a).setTriggerTimeoutMillis(j);
                return this;
            }

            public Builder setTtlExpiryEventToLog(String str) {
                a();
                ((ExperimentPayload) this.a).setTtlExpiryEventToLog(str);
                return this;
            }

            public Builder setTtlExpiryEventToLogBytes(ByteString byteString) {
                a();
                ((ExperimentPayload) this.a).setTtlExpiryEventToLogBytes(byteString);
                return this;
            }

            public Builder setVariantId(String str) {
                a();
                ((ExperimentPayload) this.a).setVariantId(str);
                return this;
            }

            public Builder setVariantIdBytes(ByteString byteString) {
                a();
                ((ExperimentPayload) this.a).setVariantIdBytes(byteString);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum ExperimentOverflowPolicy implements Internal.EnumLite {
            POLICY_UNSPECIFIED(0),
            DISCARD_OLDEST(1),
            IGNORE_NEWEST(2),
            UNRECOGNIZED(-1);

            public static final int DISCARD_OLDEST_VALUE = 1;
            public static final int IGNORE_NEWEST_VALUE = 2;
            public static final int POLICY_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<ExperimentOverflowPolicy> internalValueMap = new Internal.EnumLiteMap<ExperimentOverflowPolicy>() { // from class: developers.mobile.abt.FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ExperimentOverflowPolicy findValueByNumber(int i) {
                    return ExperimentOverflowPolicy.forNumber(i);
                }
            };
            private final int value;

            ExperimentOverflowPolicy(int i) {
                this.value = i;
            }

            public static ExperimentOverflowPolicy forNumber(int i) {
                if (i == 0) {
                    return POLICY_UNSPECIFIED;
                }
                if (i == 1) {
                    return DISCARD_OLDEST;
                }
                if (i != 2) {
                    return null;
                }
                return IGNORE_NEWEST;
            }

            public static Internal.EnumLiteMap<ExperimentOverflowPolicy> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static ExperimentOverflowPolicy valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ExperimentPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllOngoingExperiments(Iterable<? extends ExperimentLite> iterable) {
            ensureOngoingExperimentsIsMutable();
            AbstractMessageLite.a(iterable, this.ongoingExperiments_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOngoingExperiments(int i, ExperimentLite.Builder builder) {
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOngoingExperiments(int i, ExperimentLite experimentLite) {
            if (experimentLite == null) {
                throw new NullPointerException();
            }
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(i, experimentLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOngoingExperiments(ExperimentLite.Builder builder) {
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOngoingExperiments(ExperimentLite experimentLite) {
            if (experimentLite == null) {
                throw new NullPointerException();
            }
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(experimentLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearActivateEventToLog() {
            this.activateEventToLog_ = getDefaultInstance().getActivateEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClearEventToLog() {
            this.clearEventToLog_ = getDefaultInstance().getClearEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentId() {
            this.experimentId_ = getDefaultInstance().getExperimentId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentStartTimeMillis() {
            this.experimentStartTimeMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOngoingExperiments() {
            this.ongoingExperiments_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOverflowPolicy() {
            this.overflowPolicy_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSetEventToLog() {
            this.setEventToLog_ = getDefaultInstance().getSetEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeToLiveMillis() {
            this.timeToLiveMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeoutEventToLog() {
            this.timeoutEventToLog_ = getDefaultInstance().getTimeoutEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggerEvent() {
            this.triggerEvent_ = getDefaultInstance().getTriggerEvent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggerTimeoutMillis() {
            this.triggerTimeoutMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTtlExpiryEventToLog() {
            this.ttlExpiryEventToLog_ = getDefaultInstance().getTtlExpiryEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVariantId() {
            this.variantId_ = getDefaultInstance().getVariantId();
        }

        private void ensureOngoingExperimentsIsMutable() {
            if (this.ongoingExperiments_.isModifiable()) {
                return;
            }
            this.ongoingExperiments_ = GeneratedMessageLite.a(this.ongoingExperiments_);
        }

        public static ExperimentPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExperimentPayload experimentPayload) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) experimentPayload);
        }

        public static ExperimentPayload parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(ByteString byteString) {
            return (ExperimentPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(InputStream inputStream) {
            return (ExperimentPayload) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(byte[] bArr) {
            return (ExperimentPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ExperimentPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeOngoingExperiments(int i) {
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActivateEventToLog(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.activateEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActivateEventToLogBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.activateEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClearEventToLog(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.clearEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClearEventToLogBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.clearEventToLog_ = byteString.toStringUtf8();
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
        public void setExperimentStartTimeMillis(long j) {
            this.experimentStartTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOngoingExperiments(int i, ExperimentLite.Builder builder) {
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOngoingExperiments(int i, ExperimentLite experimentLite) {
            if (experimentLite == null) {
                throw new NullPointerException();
            }
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.set(i, experimentLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOverflowPolicy(ExperimentOverflowPolicy experimentOverflowPolicy) {
            if (experimentOverflowPolicy == null) {
                throw new NullPointerException();
            }
            this.overflowPolicy_ = experimentOverflowPolicy.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOverflowPolicyValue(int i) {
            this.overflowPolicy_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSetEventToLog(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.setEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSetEventToLogBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.setEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeToLiveMillis(long j) {
            this.timeToLiveMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutEventToLog(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.timeoutEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutEventToLogBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.timeoutEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerEvent(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.triggerEvent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerEventBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.triggerEvent_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerTimeoutMillis(long j) {
            this.triggerTimeoutMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtlExpiryEventToLog(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.ttlExpiryEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtlExpiryEventToLogBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.ttlExpiryEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVariantId(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.variantId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVariantIdBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.variantId_ = byteString.toStringUtf8();
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentPayload();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.ongoingExperiments_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ExperimentPayload experimentPayload = (ExperimentPayload) obj2;
                    this.experimentId_ = visitor.visitString(!this.experimentId_.isEmpty(), this.experimentId_, !experimentPayload.experimentId_.isEmpty(), experimentPayload.experimentId_);
                    this.variantId_ = visitor.visitString(!this.variantId_.isEmpty(), this.variantId_, !experimentPayload.variantId_.isEmpty(), experimentPayload.variantId_);
                    this.experimentStartTimeMillis_ = visitor.visitLong(this.experimentStartTimeMillis_ != 0, this.experimentStartTimeMillis_, experimentPayload.experimentStartTimeMillis_ != 0, experimentPayload.experimentStartTimeMillis_);
                    this.triggerEvent_ = visitor.visitString(!this.triggerEvent_.isEmpty(), this.triggerEvent_, !experimentPayload.triggerEvent_.isEmpty(), experimentPayload.triggerEvent_);
                    this.triggerTimeoutMillis_ = visitor.visitLong(this.triggerTimeoutMillis_ != 0, this.triggerTimeoutMillis_, experimentPayload.triggerTimeoutMillis_ != 0, experimentPayload.triggerTimeoutMillis_);
                    this.timeToLiveMillis_ = visitor.visitLong(this.timeToLiveMillis_ != 0, this.timeToLiveMillis_, experimentPayload.timeToLiveMillis_ != 0, experimentPayload.timeToLiveMillis_);
                    this.setEventToLog_ = visitor.visitString(!this.setEventToLog_.isEmpty(), this.setEventToLog_, !experimentPayload.setEventToLog_.isEmpty(), experimentPayload.setEventToLog_);
                    this.activateEventToLog_ = visitor.visitString(!this.activateEventToLog_.isEmpty(), this.activateEventToLog_, !experimentPayload.activateEventToLog_.isEmpty(), experimentPayload.activateEventToLog_);
                    this.clearEventToLog_ = visitor.visitString(!this.clearEventToLog_.isEmpty(), this.clearEventToLog_, !experimentPayload.clearEventToLog_.isEmpty(), experimentPayload.clearEventToLog_);
                    this.timeoutEventToLog_ = visitor.visitString(!this.timeoutEventToLog_.isEmpty(), this.timeoutEventToLog_, !experimentPayload.timeoutEventToLog_.isEmpty(), experimentPayload.timeoutEventToLog_);
                    this.ttlExpiryEventToLog_ = visitor.visitString(!this.ttlExpiryEventToLog_.isEmpty(), this.ttlExpiryEventToLog_, !experimentPayload.ttlExpiryEventToLog_.isEmpty(), experimentPayload.ttlExpiryEventToLog_);
                    this.overflowPolicy_ = visitor.visitInt(this.overflowPolicy_ != 0, this.overflowPolicy_, experimentPayload.overflowPolicy_ != 0, experimentPayload.overflowPolicy_);
                    this.ongoingExperiments_ = visitor.visitList(this.ongoingExperiments_, experimentPayload.ongoingExperiments_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= experimentPayload.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r1) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    r1 = true;
                                case 10:
                                    this.experimentId_ = codedInputStream.readStringRequireUtf8();
                                case 18:
                                    this.variantId_ = codedInputStream.readStringRequireUtf8();
                                case 24:
                                    this.experimentStartTimeMillis_ = codedInputStream.readInt64();
                                case 34:
                                    this.triggerEvent_ = codedInputStream.readStringRequireUtf8();
                                case 40:
                                    this.triggerTimeoutMillis_ = codedInputStream.readInt64();
                                case 48:
                                    this.timeToLiveMillis_ = codedInputStream.readInt64();
                                case 58:
                                    this.setEventToLog_ = codedInputStream.readStringRequireUtf8();
                                case 66:
                                    this.activateEventToLog_ = codedInputStream.readStringRequireUtf8();
                                case 74:
                                    this.clearEventToLog_ = codedInputStream.readStringRequireUtf8();
                                case 82:
                                    this.timeoutEventToLog_ = codedInputStream.readStringRequireUtf8();
                                case 90:
                                    this.ttlExpiryEventToLog_ = codedInputStream.readStringRequireUtf8();
                                case 96:
                                    this.overflowPolicy_ = codedInputStream.readEnum();
                                case 106:
                                    if (!this.ongoingExperiments_.isModifiable()) {
                                        this.ongoingExperiments_ = GeneratedMessageLite.a(this.ongoingExperiments_);
                                    }
                                    this.ongoingExperiments_.add((ExperimentLite) codedInputStream.readMessage(ExperimentLite.parser(), extensionRegistryLite));
                                default:
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                            }
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
                        synchronized (ExperimentPayload.class) {
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

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public String getActivateEventToLog() {
            return this.activateEventToLog_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ByteString getActivateEventToLogBytes() {
            return ByteString.copyFromUtf8(this.activateEventToLog_);
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public String getClearEventToLog() {
            return this.clearEventToLog_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ByteString getClearEventToLogBytes() {
            return ByteString.copyFromUtf8(this.clearEventToLog_);
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8(this.experimentId_);
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public long getExperimentStartTimeMillis() {
            return this.experimentStartTimeMillis_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ExperimentLite getOngoingExperiments(int i) {
            return this.ongoingExperiments_.get(i);
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public int getOngoingExperimentsCount() {
            return this.ongoingExperiments_.size();
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public List<ExperimentLite> getOngoingExperimentsList() {
            return this.ongoingExperiments_;
        }

        public ExperimentLiteOrBuilder getOngoingExperimentsOrBuilder(int i) {
            return this.ongoingExperiments_.get(i);
        }

        public List<? extends ExperimentLiteOrBuilder> getOngoingExperimentsOrBuilderList() {
            return this.ongoingExperiments_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ExperimentOverflowPolicy getOverflowPolicy() {
            ExperimentOverflowPolicy forNumber = ExperimentOverflowPolicy.forNumber(this.overflowPolicy_);
            return forNumber == null ? ExperimentOverflowPolicy.UNRECOGNIZED : forNumber;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public int getOverflowPolicyValue() {
            return this.overflowPolicy_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !this.experimentId_.isEmpty() ? CodedOutputStream.computeStringSize(1, getExperimentId()) + 0 : 0;
            if (!this.variantId_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getVariantId());
            }
            long j = this.experimentStartTimeMillis_;
            if (j != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(3, j);
            }
            if (!this.triggerEvent_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(4, getTriggerEvent());
            }
            long j2 = this.triggerTimeoutMillis_;
            if (j2 != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(5, j2);
            }
            long j3 = this.timeToLiveMillis_;
            if (j3 != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(6, j3);
            }
            if (!this.setEventToLog_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(7, getSetEventToLog());
            }
            if (!this.activateEventToLog_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(8, getActivateEventToLog());
            }
            if (!this.clearEventToLog_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(9, getClearEventToLog());
            }
            if (!this.timeoutEventToLog_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(10, getTimeoutEventToLog());
            }
            if (!this.ttlExpiryEventToLog_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(11, getTtlExpiryEventToLog());
            }
            if (this.overflowPolicy_ != ExperimentOverflowPolicy.POLICY_UNSPECIFIED.getNumber()) {
                computeStringSize += CodedOutputStream.computeEnumSize(12, this.overflowPolicy_);
            }
            for (int i2 = 0; i2 < this.ongoingExperiments_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(13, this.ongoingExperiments_.get(i2));
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public String getSetEventToLog() {
            return this.setEventToLog_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ByteString getSetEventToLogBytes() {
            return ByteString.copyFromUtf8(this.setEventToLog_);
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public long getTimeToLiveMillis() {
            return this.timeToLiveMillis_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public String getTimeoutEventToLog() {
            return this.timeoutEventToLog_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ByteString getTimeoutEventToLogBytes() {
            return ByteString.copyFromUtf8(this.timeoutEventToLog_);
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public String getTriggerEvent() {
            return this.triggerEvent_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ByteString getTriggerEventBytes() {
            return ByteString.copyFromUtf8(this.triggerEvent_);
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public long getTriggerTimeoutMillis() {
            return this.triggerTimeoutMillis_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public String getTtlExpiryEventToLog() {
            return this.ttlExpiryEventToLog_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ByteString getTtlExpiryEventToLogBytes() {
            return ByteString.copyFromUtf8(this.ttlExpiryEventToLog_);
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public String getVariantId() {
            return this.variantId_;
        }

        @Override // developers.mobile.abt.FirebaseAbt.ExperimentPayloadOrBuilder
        public ByteString getVariantIdBytes() {
            return ByteString.copyFromUtf8(this.variantId_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.experimentId_.isEmpty()) {
                codedOutputStream.writeString(1, getExperimentId());
            }
            if (!this.variantId_.isEmpty()) {
                codedOutputStream.writeString(2, getVariantId());
            }
            long j = this.experimentStartTimeMillis_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            if (!this.triggerEvent_.isEmpty()) {
                codedOutputStream.writeString(4, getTriggerEvent());
            }
            long j2 = this.triggerTimeoutMillis_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(5, j2);
            }
            long j3 = this.timeToLiveMillis_;
            if (j3 != 0) {
                codedOutputStream.writeInt64(6, j3);
            }
            if (!this.setEventToLog_.isEmpty()) {
                codedOutputStream.writeString(7, getSetEventToLog());
            }
            if (!this.activateEventToLog_.isEmpty()) {
                codedOutputStream.writeString(8, getActivateEventToLog());
            }
            if (!this.clearEventToLog_.isEmpty()) {
                codedOutputStream.writeString(9, getClearEventToLog());
            }
            if (!this.timeoutEventToLog_.isEmpty()) {
                codedOutputStream.writeString(10, getTimeoutEventToLog());
            }
            if (!this.ttlExpiryEventToLog_.isEmpty()) {
                codedOutputStream.writeString(11, getTtlExpiryEventToLog());
            }
            if (this.overflowPolicy_ != ExperimentOverflowPolicy.POLICY_UNSPECIFIED.getNumber()) {
                codedOutputStream.writeEnum(12, this.overflowPolicy_);
            }
            for (int i = 0; i < this.ongoingExperiments_.size(); i++) {
                codedOutputStream.writeMessage(13, this.ongoingExperiments_.get(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ExperimentPayloadOrBuilder extends MessageLiteOrBuilder {
        String getActivateEventToLog();

        ByteString getActivateEventToLogBytes();

        String getClearEventToLog();

        ByteString getClearEventToLogBytes();

        String getExperimentId();

        ByteString getExperimentIdBytes();

        long getExperimentStartTimeMillis();

        ExperimentLite getOngoingExperiments(int i);

        int getOngoingExperimentsCount();

        List<ExperimentLite> getOngoingExperimentsList();

        ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy();

        int getOverflowPolicyValue();

        String getSetEventToLog();

        ByteString getSetEventToLogBytes();

        long getTimeToLiveMillis();

        String getTimeoutEventToLog();

        ByteString getTimeoutEventToLogBytes();

        String getTriggerEvent();

        ByteString getTriggerEventBytes();

        long getTriggerTimeoutMillis();

        String getTtlExpiryEventToLog();

        ByteString getTtlExpiryEventToLogBytes();

        String getVariantId();

        ByteString getVariantIdBytes();
    }

    private FirebaseAbt() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
