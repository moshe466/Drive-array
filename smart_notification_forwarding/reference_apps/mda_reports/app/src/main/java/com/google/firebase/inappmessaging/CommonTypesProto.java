package com.google.firebase.inappmessaging;

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
import com.google.type.Date;
import com.google.type.TimeOfDay;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class CommonTypesProto {

    /* renamed from: com.google.firebase.inappmessaging.CommonTypesProto$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[TriggeringCondition.ConditionCase.values().length];

        static {
            try {
                b[TriggeringCondition.ConditionCase.FIAM_TRIGGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[TriggeringCondition.ConditionCase.EVENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[TriggeringCondition.ConditionCase.CONDITION_NOT_SET.ordinal()] = 3;
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
    public enum CampaignState implements Internal.EnumLite {
        UNKNOWN_CAMPAIGN_STATE(0),
        DRAFT(1),
        PUBLISHED(2),
        STOPPED(3),
        DELETED(4),
        UNRECOGNIZED(-1);

        public static final int DELETED_VALUE = 4;
        public static final int DRAFT_VALUE = 1;
        public static final int PUBLISHED_VALUE = 2;
        public static final int STOPPED_VALUE = 3;
        public static final int UNKNOWN_CAMPAIGN_STATE_VALUE = 0;
        private static final Internal.EnumLiteMap<CampaignState> internalValueMap = new Internal.EnumLiteMap<CampaignState>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.CampaignState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CampaignState findValueByNumber(int i) {
                return CampaignState.forNumber(i);
            }
        };
        private final int value;

        CampaignState(int i) {
            this.value = i;
        }

        public static CampaignState forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_CAMPAIGN_STATE;
            }
            if (i == 1) {
                return DRAFT;
            }
            if (i == 2) {
                return PUBLISHED;
            }
            if (i == 3) {
                return STOPPED;
            }
            if (i != 4) {
                return null;
            }
            return DELETED;
        }

        public static Internal.EnumLiteMap<CampaignState> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static CampaignState valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public static final class CampaignTime extends GeneratedMessageLite<CampaignTime, Builder> implements CampaignTimeOrBuilder {
        public static final int DATE_FIELD_NUMBER = 1;
        private static final CampaignTime DEFAULT_INSTANCE = new CampaignTime();
        private static volatile Parser<CampaignTime> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        public static final int TIME_ZONE_FIELD_NUMBER = 3;
        private Date date_;
        private String timeZone_ = "";
        private TimeOfDay time_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CampaignTime, Builder> implements CampaignTimeOrBuilder {
            private Builder() {
                super(CampaignTime.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDate() {
                a();
                ((CampaignTime) this.a).clearDate();
                return this;
            }

            public Builder clearTime() {
                a();
                ((CampaignTime) this.a).clearTime();
                return this;
            }

            public Builder clearTimeZone() {
                a();
                ((CampaignTime) this.a).clearTimeZone();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public Date getDate() {
                return ((CampaignTime) this.a).getDate();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public TimeOfDay getTime() {
                return ((CampaignTime) this.a).getTime();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public String getTimeZone() {
                return ((CampaignTime) this.a).getTimeZone();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public ByteString getTimeZoneBytes() {
                return ((CampaignTime) this.a).getTimeZoneBytes();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public boolean hasDate() {
                return ((CampaignTime) this.a).hasDate();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public boolean hasTime() {
                return ((CampaignTime) this.a).hasTime();
            }

            public Builder mergeDate(Date date) {
                a();
                ((CampaignTime) this.a).mergeDate(date);
                return this;
            }

            public Builder mergeTime(TimeOfDay timeOfDay) {
                a();
                ((CampaignTime) this.a).mergeTime(timeOfDay);
                return this;
            }

            public Builder setDate(Date.Builder builder) {
                a();
                ((CampaignTime) this.a).setDate(builder);
                return this;
            }

            public Builder setDate(Date date) {
                a();
                ((CampaignTime) this.a).setDate(date);
                return this;
            }

            public Builder setTime(TimeOfDay.Builder builder) {
                a();
                ((CampaignTime) this.a).setTime(builder);
                return this;
            }

            public Builder setTime(TimeOfDay timeOfDay) {
                a();
                ((CampaignTime) this.a).setTime(timeOfDay);
                return this;
            }

            public Builder setTimeZone(String str) {
                a();
                ((CampaignTime) this.a).setTimeZone(str);
                return this;
            }

            public Builder setTimeZoneBytes(ByteString byteString) {
                a();
                ((CampaignTime) this.a).setTimeZoneBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private CampaignTime() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDate() {
            this.date_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.time_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeZone() {
            this.timeZone_ = getDefaultInstance().getTimeZone();
        }

        public static CampaignTime getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDate(Date date) {
            Date date2 = this.date_;
            if (date2 != null && date2 != Date.getDefaultInstance()) {
                date = Date.newBuilder(this.date_).mergeFrom((Date.Builder) date).buildPartial();
            }
            this.date_ = date;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTime(TimeOfDay timeOfDay) {
            TimeOfDay timeOfDay2 = this.time_;
            if (timeOfDay2 != null && timeOfDay2 != TimeOfDay.getDefaultInstance()) {
                timeOfDay = TimeOfDay.newBuilder(this.time_).mergeFrom((TimeOfDay.Builder) timeOfDay).buildPartial();
            }
            this.time_ = timeOfDay;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CampaignTime campaignTime) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) campaignTime);
        }

        public static CampaignTime parseDelimitedFrom(InputStream inputStream) {
            return (CampaignTime) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static CampaignTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(ByteString byteString) {
            return (CampaignTime) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static CampaignTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(CodedInputStream codedInputStream) {
            return (CampaignTime) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CampaignTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(InputStream inputStream) {
            return (CampaignTime) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static CampaignTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(byte[] bArr) {
            return (CampaignTime) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static CampaignTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<CampaignTime> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDate(Date.Builder builder) {
            this.date_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDate(Date date) {
            if (date == null) {
                throw new NullPointerException();
            }
            this.date_ = date;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(TimeOfDay.Builder builder) {
            this.time_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(TimeOfDay timeOfDay) {
            if (timeOfDay == null) {
                throw new NullPointerException();
            }
            this.time_ = timeOfDay;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeZone(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.timeZone_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeZoneBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.timeZone_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CampaignTime();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CampaignTime campaignTime = (CampaignTime) obj2;
                    this.date_ = (Date) visitor.visitMessage(this.date_, campaignTime.date_);
                    this.time_ = (TimeOfDay) visitor.visitMessage(this.time_, campaignTime.time_);
                    this.timeZone_ = visitor.visitString(!this.timeZone_.isEmpty(), this.timeZone_, true ^ campaignTime.timeZone_.isEmpty(), campaignTime.timeZone_);
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
                                    Date.Builder builder = this.date_ != null ? this.date_.toBuilder() : null;
                                    this.date_ = (Date) codedInputStream.readMessage(Date.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Date.Builder) this.date_);
                                        this.date_ = builder.buildPartial();
                                    }
                                } else if (readTag == 18) {
                                    TimeOfDay.Builder builder2 = this.time_ != null ? this.time_.toBuilder() : null;
                                    this.time_ = (TimeOfDay) codedInputStream.readMessage(TimeOfDay.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((TimeOfDay.Builder) this.time_);
                                        this.time_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    this.timeZone_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (CampaignTime.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public Date getDate() {
            Date date = this.date_;
            return date == null ? Date.getDefaultInstance() : date;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.date_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getDate()) : 0;
            if (this.time_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getTime());
            }
            if (!this.timeZone_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(3, getTimeZone());
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public TimeOfDay getTime() {
            TimeOfDay timeOfDay = this.time_;
            return timeOfDay == null ? TimeOfDay.getDefaultInstance() : timeOfDay;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public String getTimeZone() {
            return this.timeZone_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public ByteString getTimeZoneBytes() {
            return ByteString.copyFromUtf8(this.timeZone_);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public boolean hasDate() {
            return this.date_ != null;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public boolean hasTime() {
            return this.time_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.date_ != null) {
                codedOutputStream.writeMessage(1, getDate());
            }
            if (this.time_ != null) {
                codedOutputStream.writeMessage(2, getTime());
            }
            if (this.timeZone_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(3, getTimeZone());
        }
    }

    /* loaded from: classes2.dex */
    public interface CampaignTimeOrBuilder extends MessageLiteOrBuilder {
        Date getDate();

        TimeOfDay getTime();

        String getTimeZone();

        ByteString getTimeZoneBytes();

        boolean hasDate();

        boolean hasTime();
    }

    /* loaded from: classes2.dex */
    public static final class DailyAnalyticsSummary extends GeneratedMessageLite<DailyAnalyticsSummary, Builder> implements DailyAnalyticsSummaryOrBuilder {
        public static final int CLICKS_FIELD_NUMBER = 3;
        private static final DailyAnalyticsSummary DEFAULT_INSTANCE = new DailyAnalyticsSummary();
        public static final int ERRORS_FIELD_NUMBER = 4;
        public static final int IMPRESSIONS_FIELD_NUMBER = 2;
        private static volatile Parser<DailyAnalyticsSummary> PARSER = null;
        public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
        private int clicks_;
        private int errors_;
        private int impressions_;
        private long startOfDayMillis_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DailyAnalyticsSummary, Builder> implements DailyAnalyticsSummaryOrBuilder {
            private Builder() {
                super(DailyAnalyticsSummary.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearClicks() {
                a();
                ((DailyAnalyticsSummary) this.a).clearClicks();
                return this;
            }

            public Builder clearErrors() {
                a();
                ((DailyAnalyticsSummary) this.a).clearErrors();
                return this;
            }

            public Builder clearImpressions() {
                a();
                ((DailyAnalyticsSummary) this.a).clearImpressions();
                return this;
            }

            public Builder clearStartOfDayMillis() {
                a();
                ((DailyAnalyticsSummary) this.a).clearStartOfDayMillis();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getClicks() {
                return ((DailyAnalyticsSummary) this.a).getClicks();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getErrors() {
                return ((DailyAnalyticsSummary) this.a).getErrors();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getImpressions() {
                return ((DailyAnalyticsSummary) this.a).getImpressions();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public long getStartOfDayMillis() {
                return ((DailyAnalyticsSummary) this.a).getStartOfDayMillis();
            }

            public Builder setClicks(int i) {
                a();
                ((DailyAnalyticsSummary) this.a).setClicks(i);
                return this;
            }

            public Builder setErrors(int i) {
                a();
                ((DailyAnalyticsSummary) this.a).setErrors(i);
                return this;
            }

            public Builder setImpressions(int i) {
                a();
                ((DailyAnalyticsSummary) this.a).setImpressions(i);
                return this;
            }

            public Builder setStartOfDayMillis(long j) {
                a();
                ((DailyAnalyticsSummary) this.a).setStartOfDayMillis(j);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private DailyAnalyticsSummary() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClicks() {
            this.clicks_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrors() {
            this.errors_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImpressions() {
            this.impressions_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartOfDayMillis() {
            this.startOfDayMillis_ = 0L;
        }

        public static DailyAnalyticsSummary getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DailyAnalyticsSummary dailyAnalyticsSummary) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) dailyAnalyticsSummary);
        }

        public static DailyAnalyticsSummary parseDelimitedFrom(InputStream inputStream) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyAnalyticsSummary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(ByteString byteString) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static DailyAnalyticsSummary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(CodedInputStream codedInputStream) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DailyAnalyticsSummary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(InputStream inputStream) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyAnalyticsSummary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(byte[] bArr) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static DailyAnalyticsSummary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<DailyAnalyticsSummary> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClicks(int i) {
            this.clicks_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrors(int i) {
            this.errors_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImpressions(int i) {
            this.impressions_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartOfDayMillis(long j) {
            this.startOfDayMillis_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DailyAnalyticsSummary();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DailyAnalyticsSummary dailyAnalyticsSummary = (DailyAnalyticsSummary) obj2;
                    this.startOfDayMillis_ = visitor.visitLong(this.startOfDayMillis_ != 0, this.startOfDayMillis_, dailyAnalyticsSummary.startOfDayMillis_ != 0, dailyAnalyticsSummary.startOfDayMillis_);
                    this.impressions_ = visitor.visitInt(this.impressions_ != 0, this.impressions_, dailyAnalyticsSummary.impressions_ != 0, dailyAnalyticsSummary.impressions_);
                    this.clicks_ = visitor.visitInt(this.clicks_ != 0, this.clicks_, dailyAnalyticsSummary.clicks_ != 0, dailyAnalyticsSummary.clicks_);
                    this.errors_ = visitor.visitInt(this.errors_ != 0, this.errors_, dailyAnalyticsSummary.errors_ != 0, dailyAnalyticsSummary.errors_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.startOfDayMillis_ = codedInputStream.readInt64();
                                    } else if (readTag == 16) {
                                        this.impressions_ = codedInputStream.readInt32();
                                    } else if (readTag == 24) {
                                        this.clicks_ = codedInputStream.readInt32();
                                    } else if (readTag == 32) {
                                        this.errors_ = codedInputStream.readInt32();
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                r1 = true;
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
                        synchronized (DailyAnalyticsSummary.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getClicks() {
            return this.clicks_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getErrors() {
            return this.errors_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getImpressions() {
            return this.impressions_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            long j = this.startOfDayMillis_;
            int computeInt64Size = j != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j) : 0;
            int i2 = this.impressions_;
            if (i2 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(2, i2);
            }
            int i3 = this.clicks_;
            if (i3 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(3, i3);
            }
            int i4 = this.errors_;
            if (i4 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(4, i4);
            }
            this.c = computeInt64Size;
            return computeInt64Size;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public long getStartOfDayMillis() {
            return this.startOfDayMillis_;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            long j = this.startOfDayMillis_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            int i = this.impressions_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            int i2 = this.clicks_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            int i3 = this.errors_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(4, i3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface DailyAnalyticsSummaryOrBuilder extends MessageLiteOrBuilder {
        int getClicks();

        int getErrors();

        int getImpressions();

        long getStartOfDayMillis();
    }

    /* loaded from: classes2.dex */
    public static final class DailyConversionSummary extends GeneratedMessageLite<DailyConversionSummary, Builder> implements DailyConversionSummaryOrBuilder {
        public static final int CONVERSIONS_FIELD_NUMBER = 2;
        private static final DailyConversionSummary DEFAULT_INSTANCE = new DailyConversionSummary();
        private static volatile Parser<DailyConversionSummary> PARSER = null;
        public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
        private int conversions_;
        private long startOfDayMillis_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DailyConversionSummary, Builder> implements DailyConversionSummaryOrBuilder {
            private Builder() {
                super(DailyConversionSummary.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearConversions() {
                a();
                ((DailyConversionSummary) this.a).clearConversions();
                return this;
            }

            public Builder clearStartOfDayMillis() {
                a();
                ((DailyConversionSummary) this.a).clearStartOfDayMillis();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
            public int getConversions() {
                return ((DailyConversionSummary) this.a).getConversions();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
            public long getStartOfDayMillis() {
                return ((DailyConversionSummary) this.a).getStartOfDayMillis();
            }

            public Builder setConversions(int i) {
                a();
                ((DailyConversionSummary) this.a).setConversions(i);
                return this;
            }

            public Builder setStartOfDayMillis(long j) {
                a();
                ((DailyConversionSummary) this.a).setStartOfDayMillis(j);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private DailyConversionSummary() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConversions() {
            this.conversions_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartOfDayMillis() {
            this.startOfDayMillis_ = 0L;
        }

        public static DailyConversionSummary getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DailyConversionSummary dailyConversionSummary) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) dailyConversionSummary);
        }

        public static DailyConversionSummary parseDelimitedFrom(InputStream inputStream) {
            return (DailyConversionSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyConversionSummary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(ByteString byteString) {
            return (DailyConversionSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static DailyConversionSummary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(CodedInputStream codedInputStream) {
            return (DailyConversionSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DailyConversionSummary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(InputStream inputStream) {
            return (DailyConversionSummary) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyConversionSummary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(byte[] bArr) {
            return (DailyConversionSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static DailyConversionSummary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<DailyConversionSummary> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConversions(int i) {
            this.conversions_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartOfDayMillis(long j) {
            this.startOfDayMillis_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DailyConversionSummary();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DailyConversionSummary dailyConversionSummary = (DailyConversionSummary) obj2;
                    this.startOfDayMillis_ = visitor.visitLong(this.startOfDayMillis_ != 0, this.startOfDayMillis_, dailyConversionSummary.startOfDayMillis_ != 0, dailyConversionSummary.startOfDayMillis_);
                    this.conversions_ = visitor.visitInt(this.conversions_ != 0, this.conversions_, dailyConversionSummary.conversions_ != 0, dailyConversionSummary.conversions_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.startOfDayMillis_ = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.conversions_ = codedInputStream.readInt32();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r1 = true;
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
                        synchronized (DailyConversionSummary.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
        public int getConversions() {
            return this.conversions_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            long j = this.startOfDayMillis_;
            int computeInt64Size = j != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j) : 0;
            int i2 = this.conversions_;
            if (i2 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(2, i2);
            }
            this.c = computeInt64Size;
            return computeInt64Size;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
        public long getStartOfDayMillis() {
            return this.startOfDayMillis_;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            long j = this.startOfDayMillis_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            int i = this.conversions_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface DailyConversionSummaryOrBuilder extends MessageLiteOrBuilder {
        int getConversions();

        long getStartOfDayMillis();
    }

    /* loaded from: classes2.dex */
    public static final class Event extends GeneratedMessageLite<Event, Builder> implements EventOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 5;
        private static final Event DEFAULT_INSTANCE = new Event();
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<Event> PARSER = null;
        public static final int PREVIOUS_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 3;
        public static final int TRIGGER_PARAMS_FIELD_NUMBER = 1;
        private int bitField0_;
        private int count_;
        private long previousTimestampMillis_;
        private long timestampMillis_;
        private Internal.ProtobufList<TriggerParam> triggerParams_ = GeneratedMessageLite.f();
        private String name_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Event, Builder> implements EventOrBuilder {
            private Builder() {
                super(Event.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllTriggerParams(Iterable<? extends TriggerParam> iterable) {
                a();
                ((Event) this.a).addAllTriggerParams(iterable);
                return this;
            }

            public Builder addTriggerParams(int i, TriggerParam.Builder builder) {
                a();
                ((Event) this.a).addTriggerParams(i, builder);
                return this;
            }

            public Builder addTriggerParams(int i, TriggerParam triggerParam) {
                a();
                ((Event) this.a).addTriggerParams(i, triggerParam);
                return this;
            }

            public Builder addTriggerParams(TriggerParam.Builder builder) {
                a();
                ((Event) this.a).addTriggerParams(builder);
                return this;
            }

            public Builder addTriggerParams(TriggerParam triggerParam) {
                a();
                ((Event) this.a).addTriggerParams(triggerParam);
                return this;
            }

            public Builder clearCount() {
                a();
                ((Event) this.a).clearCount();
                return this;
            }

            public Builder clearName() {
                a();
                ((Event) this.a).clearName();
                return this;
            }

            public Builder clearPreviousTimestampMillis() {
                a();
                ((Event) this.a).clearPreviousTimestampMillis();
                return this;
            }

            public Builder clearTimestampMillis() {
                a();
                ((Event) this.a).clearTimestampMillis();
                return this;
            }

            public Builder clearTriggerParams() {
                a();
                ((Event) this.a).clearTriggerParams();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public int getCount() {
                return ((Event) this.a).getCount();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public String getName() {
                return ((Event) this.a).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public ByteString getNameBytes() {
                return ((Event) this.a).getNameBytes();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public long getPreviousTimestampMillis() {
                return ((Event) this.a).getPreviousTimestampMillis();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public long getTimestampMillis() {
                return ((Event) this.a).getTimestampMillis();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public TriggerParam getTriggerParams(int i) {
                return ((Event) this.a).getTriggerParams(i);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public int getTriggerParamsCount() {
                return ((Event) this.a).getTriggerParamsCount();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public List<TriggerParam> getTriggerParamsList() {
                return Collections.unmodifiableList(((Event) this.a).getTriggerParamsList());
            }

            public Builder removeTriggerParams(int i) {
                a();
                ((Event) this.a).removeTriggerParams(i);
                return this;
            }

            public Builder setCount(int i) {
                a();
                ((Event) this.a).setCount(i);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((Event) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((Event) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setPreviousTimestampMillis(long j) {
                a();
                ((Event) this.a).setPreviousTimestampMillis(j);
                return this;
            }

            public Builder setTimestampMillis(long j) {
                a();
                ((Event) this.a).setTimestampMillis(j);
                return this;
            }

            public Builder setTriggerParams(int i, TriggerParam.Builder builder) {
                a();
                ((Event) this.a).setTriggerParams(i, builder);
                return this;
            }

            public Builder setTriggerParams(int i, TriggerParam triggerParam) {
                a();
                ((Event) this.a).setTriggerParams(i, triggerParam);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Event() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllTriggerParams(Iterable<? extends TriggerParam> iterable) {
            ensureTriggerParamsIsMutable();
            AbstractMessageLite.a(iterable, this.triggerParams_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggerParams(int i, TriggerParam.Builder builder) {
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggerParams(int i, TriggerParam triggerParam) {
            if (triggerParam == null) {
                throw new NullPointerException();
            }
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(i, triggerParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggerParams(TriggerParam.Builder builder) {
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggerParams(TriggerParam triggerParam) {
            if (triggerParam == null) {
                throw new NullPointerException();
            }
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(triggerParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCount() {
            this.count_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPreviousTimestampMillis() {
            this.previousTimestampMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestampMillis() {
            this.timestampMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggerParams() {
            this.triggerParams_ = GeneratedMessageLite.f();
        }

        private void ensureTriggerParamsIsMutable() {
            if (this.triggerParams_.isModifiable()) {
                return;
            }
            this.triggerParams_ = GeneratedMessageLite.a(this.triggerParams_);
        }

        public static Event getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Event event) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) event);
        }

        public static Event parseDelimitedFrom(InputStream inputStream) {
            return (Event) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(ByteString byteString) {
            return (Event) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Event parseFrom(CodedInputStream codedInputStream) {
            return (Event) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Event parseFrom(InputStream inputStream) {
            return (Event) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(byte[] bArr) {
            return (Event) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Event> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeTriggerParams(int i) {
            ensureTriggerParamsIsMutable();
            this.triggerParams_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCount(int i) {
            this.count_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPreviousTimestampMillis(long j) {
            this.previousTimestampMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestampMillis(long j) {
            this.timestampMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerParams(int i, TriggerParam.Builder builder) {
            ensureTriggerParamsIsMutable();
            this.triggerParams_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerParams(int i, TriggerParam triggerParam) {
            if (triggerParam == null) {
                throw new NullPointerException();
            }
            ensureTriggerParamsIsMutable();
            this.triggerParams_.set(i, triggerParam);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Event();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.triggerParams_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Event event = (Event) obj2;
                    this.triggerParams_ = visitor.visitList(this.triggerParams_, event.triggerParams_);
                    this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !event.name_.isEmpty(), event.name_);
                    this.timestampMillis_ = visitor.visitLong(this.timestampMillis_ != 0, this.timestampMillis_, event.timestampMillis_ != 0, event.timestampMillis_);
                    this.previousTimestampMillis_ = visitor.visitLong(this.previousTimestampMillis_ != 0, this.previousTimestampMillis_, event.previousTimestampMillis_ != 0, event.previousTimestampMillis_);
                    this.count_ = visitor.visitInt(this.count_ != 0, this.count_, event.count_ != 0, event.count_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= event.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r1) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    if (!this.triggerParams_.isModifiable()) {
                                        this.triggerParams_ = GeneratedMessageLite.a(this.triggerParams_);
                                    }
                                    this.triggerParams_.add((TriggerParam) codedInputStream.readMessage(TriggerParam.parser(), extensionRegistryLite));
                                } else if (readTag == 18) {
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.timestampMillis_ = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.previousTimestampMillis_ = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.count_ = codedInputStream.readInt32();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r1 = true;
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
                        synchronized (Event.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public long getPreviousTimestampMillis() {
            return this.previousTimestampMillis_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.triggerParams_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.triggerParams_.get(i3));
            }
            if (!this.name_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(2, getName());
            }
            long j = this.timestampMillis_;
            if (j != 0) {
                i2 += CodedOutputStream.computeInt64Size(3, j);
            }
            long j2 = this.previousTimestampMillis_;
            if (j2 != 0) {
                i2 += CodedOutputStream.computeInt64Size(4, j2);
            }
            int i4 = this.count_;
            if (i4 != 0) {
                i2 += CodedOutputStream.computeInt32Size(5, i4);
            }
            this.c = i2;
            return i2;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public long getTimestampMillis() {
            return this.timestampMillis_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public TriggerParam getTriggerParams(int i) {
            return this.triggerParams_.get(i);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public int getTriggerParamsCount() {
            return this.triggerParams_.size();
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public List<TriggerParam> getTriggerParamsList() {
            return this.triggerParams_;
        }

        public TriggerParamOrBuilder getTriggerParamsOrBuilder(int i) {
            return this.triggerParams_.get(i);
        }

        public List<? extends TriggerParamOrBuilder> getTriggerParamsOrBuilderList() {
            return this.triggerParams_;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.triggerParams_.size(); i++) {
                codedOutputStream.writeMessage(1, this.triggerParams_.get(i));
            }
            if (!this.name_.isEmpty()) {
                codedOutputStream.writeString(2, getName());
            }
            long j = this.timestampMillis_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            long j2 = this.previousTimestampMillis_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(4, j2);
            }
            int i2 = this.count_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(5, i2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface EventOrBuilder extends MessageLiteOrBuilder {
        int getCount();

        String getName();

        ByteString getNameBytes();

        long getPreviousTimestampMillis();

        long getTimestampMillis();

        TriggerParam getTriggerParams(int i);

        int getTriggerParamsCount();

        List<TriggerParam> getTriggerParamsList();
    }

    /* loaded from: classes2.dex */
    public static final class ExperimentVariant extends GeneratedMessageLite<ExperimentVariant, Builder> implements ExperimentVariantOrBuilder {
        public static final int CONTENT_FIELD_NUMBER = 2;
        private static final ExperimentVariant DEFAULT_INSTANCE = new ExperimentVariant();
        public static final int INDEX_FIELD_NUMBER = 1;
        private static volatile Parser<ExperimentVariant> PARSER;
        private MessagesProto.Content content_;
        private int index_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentVariant, Builder> implements ExperimentVariantOrBuilder {
            private Builder() {
                super(ExperimentVariant.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearContent() {
                a();
                ((ExperimentVariant) this.a).clearContent();
                return this;
            }

            public Builder clearIndex() {
                a();
                ((ExperimentVariant) this.a).clearIndex();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public MessagesProto.Content getContent() {
                return ((ExperimentVariant) this.a).getContent();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public int getIndex() {
                return ((ExperimentVariant) this.a).getIndex();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public boolean hasContent() {
                return ((ExperimentVariant) this.a).hasContent();
            }

            public Builder mergeContent(MessagesProto.Content content) {
                a();
                ((ExperimentVariant) this.a).mergeContent(content);
                return this;
            }

            public Builder setContent(MessagesProto.Content.Builder builder) {
                a();
                ((ExperimentVariant) this.a).setContent(builder);
                return this;
            }

            public Builder setContent(MessagesProto.Content content) {
                a();
                ((ExperimentVariant) this.a).setContent(content);
                return this;
            }

            public Builder setIndex(int i) {
                a();
                ((ExperimentVariant) this.a).setIndex(i);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ExperimentVariant() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.content_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndex() {
            this.index_ = 0;
        }

        public static ExperimentVariant getDefaultInstance() {
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

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExperimentVariant experimentVariant) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) experimentVariant);
        }

        public static ExperimentVariant parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentVariant) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentVariant parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(ByteString byteString) {
            return (ExperimentVariant) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentVariant parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentVariant) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentVariant parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(InputStream inputStream) {
            return (ExperimentVariant) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentVariant parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(byte[] bArr) {
            return (ExperimentVariant) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentVariant parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ExperimentVariant> parser() {
            return DEFAULT_INSTANCE.getParserForType();
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
        public void setIndex(int i) {
            this.index_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentVariant();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ExperimentVariant experimentVariant = (ExperimentVariant) obj2;
                    this.index_ = visitor.visitInt(this.index_ != 0, this.index_, experimentVariant.index_ != 0, experimentVariant.index_);
                    this.content_ = (MessagesProto.Content) visitor.visitMessage(this.content_, experimentVariant.content_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.index_ = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    MessagesProto.Content.Builder builder = this.content_ != null ? this.content_.toBuilder() : null;
                                    this.content_ = (MessagesProto.Content) codedInputStream.readMessage(MessagesProto.Content.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((MessagesProto.Content.Builder) this.content_);
                                        this.content_ = builder.buildPartial();
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
                        synchronized (ExperimentVariant.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public MessagesProto.Content getContent() {
            MessagesProto.Content content = this.content_;
            return content == null ? MessagesProto.Content.getDefaultInstance() : content;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = this.index_;
            int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            if (this.content_ != null) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, getContent());
            }
            this.c = computeInt32Size;
            return computeInt32Size;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public boolean hasContent() {
            return this.content_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            int i = this.index_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            if (this.content_ != null) {
                codedOutputStream.writeMessage(2, getContent());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ExperimentVariantOrBuilder extends MessageLiteOrBuilder {
        MessagesProto.Content getContent();

        int getIndex();

        boolean hasContent();
    }

    /* loaded from: classes2.dex */
    public enum ExperimentalCampaignState implements Internal.EnumLite {
        UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE(0),
        EXPERIMENT_DRAFT(1),
        EXPERIMENT_RUNNING(2),
        EXPERIMENT_STOPPED(3),
        EXPERIMENT_ROLLED_OUT(4),
        UNRECOGNIZED(-1);

        public static final int EXPERIMENT_DRAFT_VALUE = 1;
        public static final int EXPERIMENT_ROLLED_OUT_VALUE = 4;
        public static final int EXPERIMENT_RUNNING_VALUE = 2;
        public static final int EXPERIMENT_STOPPED_VALUE = 3;
        public static final int UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE_VALUE = 0;
        private static final Internal.EnumLiteMap<ExperimentalCampaignState> internalValueMap = new Internal.EnumLiteMap<ExperimentalCampaignState>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.ExperimentalCampaignState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ExperimentalCampaignState findValueByNumber(int i) {
                return ExperimentalCampaignState.forNumber(i);
            }
        };
        private final int value;

        ExperimentalCampaignState(int i) {
            this.value = i;
        }

        public static ExperimentalCampaignState forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE;
            }
            if (i == 1) {
                return EXPERIMENT_DRAFT;
            }
            if (i == 2) {
                return EXPERIMENT_RUNNING;
            }
            if (i == 3) {
                return EXPERIMENT_STOPPED;
            }
            if (i != 4) {
                return null;
            }
            return EXPERIMENT_ROLLED_OUT;
        }

        public static Internal.EnumLiteMap<ExperimentalCampaignState> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ExperimentalCampaignState valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Priority extends GeneratedMessageLite<Priority, Builder> implements PriorityOrBuilder {
        private static final Priority DEFAULT_INSTANCE = new Priority();
        private static volatile Parser<Priority> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 1;
        private int value_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Priority, Builder> implements PriorityOrBuilder {
            private Builder() {
                super(Priority.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearValue() {
                a();
                ((Priority) this.a).clearValue();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.PriorityOrBuilder
            public int getValue() {
                return ((Priority) this.a).getValue();
            }

            public Builder setValue(int i) {
                a();
                ((Priority) this.a).setValue(i);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Priority() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = 0;
        }

        public static Priority getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Priority priority) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) priority);
        }

        public static Priority parseDelimitedFrom(InputStream inputStream) {
            return (Priority) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Priority parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Priority parseFrom(ByteString byteString) {
            return (Priority) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Priority parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Priority parseFrom(CodedInputStream codedInputStream) {
            return (Priority) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Priority parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Priority parseFrom(InputStream inputStream) {
            return (Priority) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Priority parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Priority parseFrom(byte[] bArr) {
            return (Priority) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Priority parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Priority> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(int i) {
            this.value_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Priority();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    Priority priority = (Priority) obj2;
                    this.value_ = ((GeneratedMessageLite.Visitor) obj).visitInt(this.value_ != 0, this.value_, priority.value_ != 0, priority.value_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.value_ = codedInputStream.readInt32();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r1 = true;
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
                        synchronized (Priority.class) {
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = this.value_;
            int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            this.c = computeInt32Size;
            return computeInt32Size;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.PriorityOrBuilder
        public int getValue() {
            return this.value_;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            int i = this.value_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface PriorityOrBuilder extends MessageLiteOrBuilder {
        int getValue();
    }

    /* loaded from: classes2.dex */
    public static final class ScionConversionEvent extends GeneratedMessageLite<ScionConversionEvent, Builder> implements ScionConversionEventOrBuilder {
        private static final ScionConversionEvent DEFAULT_INSTANCE = new ScionConversionEvent();
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<ScionConversionEvent> PARSER;
        private String name_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ScionConversionEvent, Builder> implements ScionConversionEventOrBuilder {
            private Builder() {
                super(ScionConversionEvent.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearName() {
                a();
                ((ScionConversionEvent) this.a).clearName();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
            public String getName() {
                return ((ScionConversionEvent) this.a).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
            public ByteString getNameBytes() {
                return ((ScionConversionEvent) this.a).getNameBytes();
            }

            public Builder setName(String str) {
                a();
                ((ScionConversionEvent) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((ScionConversionEvent) this.a).setNameBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ScionConversionEvent() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        public static ScionConversionEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ScionConversionEvent scionConversionEvent) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) scionConversionEvent);
        }

        public static ScionConversionEvent parseDelimitedFrom(InputStream inputStream) {
            return (ScionConversionEvent) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ScionConversionEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(ByteString byteString) {
            return (ScionConversionEvent) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ScionConversionEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(CodedInputStream codedInputStream) {
            return (ScionConversionEvent) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ScionConversionEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(InputStream inputStream) {
            return (ScionConversionEvent) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ScionConversionEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(byte[] bArr) {
            return (ScionConversionEvent) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ScionConversionEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ScionConversionEvent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ScionConversionEvent();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    ScionConversionEvent scionConversionEvent = (ScionConversionEvent) obj2;
                    this.name_ = ((GeneratedMessageLite.Visitor) obj).visitString(!this.name_.isEmpty(), this.name_, true ^ scionConversionEvent.name_.isEmpty(), scionConversionEvent.name_);
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
                                    this.name_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (ScionConversionEvent.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.name_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getName());
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.name_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(1, getName());
        }
    }

    /* loaded from: classes2.dex */
    public interface ScionConversionEventOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();
    }

    /* loaded from: classes2.dex */
    public enum Trigger implements Internal.EnumLite {
        UNKNOWN_TRIGGER(0),
        APP_LAUNCH(1),
        ON_FOREGROUND(2),
        UNRECOGNIZED(-1);

        public static final int APP_LAUNCH_VALUE = 1;
        public static final int ON_FOREGROUND_VALUE = 2;
        public static final int UNKNOWN_TRIGGER_VALUE = 0;
        private static final Internal.EnumLiteMap<Trigger> internalValueMap = new Internal.EnumLiteMap<Trigger>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.Trigger.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Trigger findValueByNumber(int i) {
                return Trigger.forNumber(i);
            }
        };
        private final int value;

        Trigger(int i) {
            this.value = i;
        }

        public static Trigger forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_TRIGGER;
            }
            if (i == 1) {
                return APP_LAUNCH;
            }
            if (i != 2) {
                return null;
            }
            return ON_FOREGROUND;
        }

        public static Internal.EnumLiteMap<Trigger> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Trigger valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public static final class TriggerParam extends GeneratedMessageLite<TriggerParam, Builder> implements TriggerParamOrBuilder {
        private static final TriggerParam DEFAULT_INSTANCE = new TriggerParam();
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 5;
        public static final int FLOAT_VALUE_FIELD_NUMBER = 4;
        public static final int INT_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<TriggerParam> PARSER = null;
        public static final int STRING_VALUE_FIELD_NUMBER = 2;
        private double doubleValue_;
        private float floatValue_;
        private long intValue_;
        private String name_ = "";
        private String stringValue_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TriggerParam, Builder> implements TriggerParamOrBuilder {
            private Builder() {
                super(TriggerParam.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDoubleValue() {
                a();
                ((TriggerParam) this.a).clearDoubleValue();
                return this;
            }

            public Builder clearFloatValue() {
                a();
                ((TriggerParam) this.a).clearFloatValue();
                return this;
            }

            public Builder clearIntValue() {
                a();
                ((TriggerParam) this.a).clearIntValue();
                return this;
            }

            public Builder clearName() {
                a();
                ((TriggerParam) this.a).clearName();
                return this;
            }

            public Builder clearStringValue() {
                a();
                ((TriggerParam) this.a).clearStringValue();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public double getDoubleValue() {
                return ((TriggerParam) this.a).getDoubleValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public float getFloatValue() {
                return ((TriggerParam) this.a).getFloatValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public long getIntValue() {
                return ((TriggerParam) this.a).getIntValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public String getName() {
                return ((TriggerParam) this.a).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public ByteString getNameBytes() {
                return ((TriggerParam) this.a).getNameBytes();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public String getStringValue() {
                return ((TriggerParam) this.a).getStringValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public ByteString getStringValueBytes() {
                return ((TriggerParam) this.a).getStringValueBytes();
            }

            public Builder setDoubleValue(double d) {
                a();
                ((TriggerParam) this.a).setDoubleValue(d);
                return this;
            }

            public Builder setFloatValue(float f) {
                a();
                ((TriggerParam) this.a).setFloatValue(f);
                return this;
            }

            public Builder setIntValue(long j) {
                a();
                ((TriggerParam) this.a).setIntValue(j);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((TriggerParam) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((TriggerParam) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setStringValue(String str) {
                a();
                ((TriggerParam) this.a).setStringValue(str);
                return this;
            }

            public Builder setStringValueBytes(ByteString byteString) {
                a();
                ((TriggerParam) this.a).setStringValueBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private TriggerParam() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDoubleValue() {
            this.doubleValue_ = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFloatValue() {
            this.floatValue_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIntValue() {
            this.intValue_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStringValue() {
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        public static TriggerParam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TriggerParam triggerParam) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) triggerParam);
        }

        public static TriggerParam parseDelimitedFrom(InputStream inputStream) {
            return (TriggerParam) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggerParam parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(ByteString byteString) {
            return (TriggerParam) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static TriggerParam parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(CodedInputStream codedInputStream) {
            return (TriggerParam) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TriggerParam parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(InputStream inputStream) {
            return (TriggerParam) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggerParam parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(byte[] bArr) {
            return (TriggerParam) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static TriggerParam parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<TriggerParam> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDoubleValue(double d) {
            this.doubleValue_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(float f) {
            this.floatValue_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(long j) {
            this.intValue_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.stringValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValueBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.stringValue_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            boolean z = false;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TriggerParam();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    TriggerParam triggerParam = (TriggerParam) obj2;
                    this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !triggerParam.name_.isEmpty(), triggerParam.name_);
                    this.stringValue_ = visitor.visitString(!this.stringValue_.isEmpty(), this.stringValue_, !triggerParam.stringValue_.isEmpty(), triggerParam.stringValue_);
                    this.intValue_ = visitor.visitLong(this.intValue_ != 0, this.intValue_, triggerParam.intValue_ != 0, triggerParam.intValue_);
                    this.floatValue_ = visitor.visitFloat(this.floatValue_ != 0.0f, this.floatValue_, triggerParam.floatValue_ != 0.0f, triggerParam.floatValue_);
                    this.doubleValue_ = visitor.visitDouble(this.doubleValue_ != 0.0d, this.doubleValue_, triggerParam.doubleValue_ != 0.0d, triggerParam.doubleValue_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.stringValue_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.intValue_ = codedInputStream.readInt64();
                                } else if (readTag == 37) {
                                    this.floatValue_ = codedInputStream.readFloat();
                                } else if (readTag == 41) {
                                    this.doubleValue_ = codedInputStream.readDouble();
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
                        synchronized (TriggerParam.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public double getDoubleValue() {
            return this.doubleValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public float getFloatValue() {
            return this.floatValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public long getIntValue() {
            return this.intValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.name_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getName());
            if (!this.stringValue_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getStringValue());
            }
            long j = this.intValue_;
            if (j != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(3, j);
            }
            float f = this.floatValue_;
            if (f != 0.0f) {
                computeStringSize += CodedOutputStream.computeFloatSize(4, f);
            }
            double d = this.doubleValue_;
            if (d != 0.0d) {
                computeStringSize += CodedOutputStream.computeDoubleSize(5, d);
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public String getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public ByteString getStringValueBytes() {
            return ByteString.copyFromUtf8(this.stringValue_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.name_.isEmpty()) {
                codedOutputStream.writeString(1, getName());
            }
            if (!this.stringValue_.isEmpty()) {
                codedOutputStream.writeString(2, getStringValue());
            }
            long j = this.intValue_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            float f = this.floatValue_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(4, f);
            }
            double d = this.doubleValue_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(5, d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface TriggerParamOrBuilder extends MessageLiteOrBuilder {
        double getDoubleValue();

        float getFloatValue();

        long getIntValue();

        String getName();

        ByteString getNameBytes();

        String getStringValue();

        ByteString getStringValueBytes();
    }

    /* loaded from: classes2.dex */
    public static final class TriggeringCondition extends GeneratedMessageLite<TriggeringCondition, Builder> implements TriggeringConditionOrBuilder {
        private static final TriggeringCondition DEFAULT_INSTANCE = new TriggeringCondition();
        public static final int EVENT_FIELD_NUMBER = 2;
        public static final int FIAM_TRIGGER_FIELD_NUMBER = 1;
        private static volatile Parser<TriggeringCondition> PARSER;
        private int conditionCase_ = 0;
        private Object condition_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TriggeringCondition, Builder> implements TriggeringConditionOrBuilder {
            private Builder() {
                super(TriggeringCondition.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCondition() {
                a();
                ((TriggeringCondition) this.a).clearCondition();
                return this;
            }

            public Builder clearEvent() {
                a();
                ((TriggeringCondition) this.a).clearEvent();
                return this;
            }

            public Builder clearFiamTrigger() {
                a();
                ((TriggeringCondition) this.a).clearFiamTrigger();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public ConditionCase getConditionCase() {
                return ((TriggeringCondition) this.a).getConditionCase();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public Event getEvent() {
                return ((TriggeringCondition) this.a).getEvent();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public Trigger getFiamTrigger() {
                return ((TriggeringCondition) this.a).getFiamTrigger();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public int getFiamTriggerValue() {
                return ((TriggeringCondition) this.a).getFiamTriggerValue();
            }

            public Builder mergeEvent(Event event) {
                a();
                ((TriggeringCondition) this.a).mergeEvent(event);
                return this;
            }

            public Builder setEvent(Event.Builder builder) {
                a();
                ((TriggeringCondition) this.a).setEvent(builder);
                return this;
            }

            public Builder setEvent(Event event) {
                a();
                ((TriggeringCondition) this.a).setEvent(event);
                return this;
            }

            public Builder setFiamTrigger(Trigger trigger) {
                a();
                ((TriggeringCondition) this.a).setFiamTrigger(trigger);
                return this;
            }

            public Builder setFiamTriggerValue(int i) {
                a();
                ((TriggeringCondition) this.a).setFiamTriggerValue(i);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum ConditionCase implements Internal.EnumLite {
            FIAM_TRIGGER(1),
            EVENT(2),
            CONDITION_NOT_SET(0);

            private final int value;

            ConditionCase(int i) {
                this.value = i;
            }

            public static ConditionCase forNumber(int i) {
                if (i == 0) {
                    return CONDITION_NOT_SET;
                }
                if (i == 1) {
                    return FIAM_TRIGGER;
                }
                if (i != 2) {
                    return null;
                }
                return EVENT;
            }

            @Deprecated
            public static ConditionCase valueOf(int i) {
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

        private TriggeringCondition() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCondition() {
            this.conditionCase_ = 0;
            this.condition_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEvent() {
            if (this.conditionCase_ == 2) {
                this.conditionCase_ = 0;
                this.condition_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFiamTrigger() {
            if (this.conditionCase_ == 1) {
                this.conditionCase_ = 0;
                this.condition_ = null;
            }
        }

        public static TriggeringCondition getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEvent(Event event) {
            if (this.conditionCase_ == 2 && this.condition_ != Event.getDefaultInstance()) {
                event = Event.newBuilder((Event) this.condition_).mergeFrom((Event.Builder) event).buildPartial();
            }
            this.condition_ = event;
            this.conditionCase_ = 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TriggeringCondition triggeringCondition) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) triggeringCondition);
        }

        public static TriggeringCondition parseDelimitedFrom(InputStream inputStream) {
            return (TriggeringCondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggeringCondition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(ByteString byteString) {
            return (TriggeringCondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static TriggeringCondition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(CodedInputStream codedInputStream) {
            return (TriggeringCondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TriggeringCondition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(InputStream inputStream) {
            return (TriggeringCondition) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggeringCondition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(byte[] bArr) {
            return (TriggeringCondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static TriggeringCondition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<TriggeringCondition> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvent(Event.Builder builder) {
            this.condition_ = builder.build();
            this.conditionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvent(Event event) {
            if (event == null) {
                throw new NullPointerException();
            }
            this.condition_ = event;
            this.conditionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFiamTrigger(Trigger trigger) {
            if (trigger == null) {
                throw new NullPointerException();
            }
            this.conditionCase_ = 1;
            this.condition_ = Integer.valueOf(trigger.getNumber());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFiamTriggerValue(int i) {
            this.conditionCase_ = 1;
            this.condition_ = Integer.valueOf(i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Object visitOneofInt;
            int i;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TriggeringCondition();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    TriggeringCondition triggeringCondition = (TriggeringCondition) obj2;
                    int i2 = AnonymousClass1.b[triggeringCondition.getConditionCase().ordinal()];
                    if (i2 == 1) {
                        visitOneofInt = visitor.visitOneofInt(this.conditionCase_ == 1, this.condition_, triggeringCondition.condition_);
                    } else {
                        if (i2 != 2) {
                            if (i2 == 3) {
                                visitor.visitOneofNotSet(this.conditionCase_ != 0);
                            }
                            if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = triggeringCondition.conditionCase_) != 0) {
                                this.conditionCase_ = i;
                            }
                            return this;
                        }
                        visitOneofInt = visitor.visitOneofMessage(this.conditionCase_ == 2, this.condition_, triggeringCondition.condition_);
                    }
                    this.condition_ = visitOneofInt;
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.conditionCase_ = i;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r1) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    int readEnum = codedInputStream.readEnum();
                                    this.conditionCase_ = 1;
                                    this.condition_ = Integer.valueOf(readEnum);
                                } else if (readTag == 18) {
                                    Event.Builder builder = this.conditionCase_ == 2 ? ((Event) this.condition_).toBuilder() : null;
                                    this.condition_ = codedInputStream.readMessage(Event.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Event.Builder) this.condition_);
                                        this.condition_ = builder.buildPartial();
                                    }
                                    this.conditionCase_ = 2;
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r1 = true;
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
                        synchronized (TriggeringCondition.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public ConditionCase getConditionCase() {
            return ConditionCase.forNumber(this.conditionCase_);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public Event getEvent() {
            return this.conditionCase_ == 2 ? (Event) this.condition_ : Event.getDefaultInstance();
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public Trigger getFiamTrigger() {
            if (this.conditionCase_ != 1) {
                return Trigger.UNKNOWN_TRIGGER;
            }
            Trigger forNumber = Trigger.forNumber(((Integer) this.condition_).intValue());
            return forNumber == null ? Trigger.UNRECOGNIZED : forNumber;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public int getFiamTriggerValue() {
            if (this.conditionCase_ == 1) {
                return ((Integer) this.condition_).intValue();
            }
            return 0;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.conditionCase_ == 1 ? 0 + CodedOutputStream.computeEnumSize(1, ((Integer) this.condition_).intValue()) : 0;
            if (this.conditionCase_ == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, (Event) this.condition_);
            }
            this.c = computeEnumSize;
            return computeEnumSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.conditionCase_ == 1) {
                codedOutputStream.writeEnum(1, ((Integer) this.condition_).intValue());
            }
            if (this.conditionCase_ == 2) {
                codedOutputStream.writeMessage(2, (Event) this.condition_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface TriggeringConditionOrBuilder extends MessageLiteOrBuilder {
        TriggeringCondition.ConditionCase getConditionCase();

        Event getEvent();

        Trigger getFiamTrigger();

        int getFiamTriggerValue();
    }

    private CommonTypesProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
