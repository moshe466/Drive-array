package com.google.developers.mobile.targeting.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class ClientSignalsProto {

    /* renamed from: com.google.developers.mobile.targeting.proto.ClientSignalsProto$1, reason: invalid class name */
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
    public static final class AppInstanceClaim extends GeneratedMessageLite<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder {
        public static final int APP_INSTANCE_ID_FIELD_NUMBER = 1;
        public static final int APP_INSTANCE_TOKEN_FIELD_NUMBER = 2;
        private static final AppInstanceClaim DEFAULT_INSTANCE = new AppInstanceClaim();
        public static final int GMP_APP_ID_FIELD_NUMBER = 3;
        private static volatile Parser<AppInstanceClaim> PARSER;
        private String appInstanceId_ = "";
        private String appInstanceToken_ = "";
        private String gmpAppId_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder {
            private Builder() {
                super(AppInstanceClaim.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppInstanceId() {
                a();
                ((AppInstanceClaim) this.a).clearAppInstanceId();
                return this;
            }

            public Builder clearAppInstanceToken() {
                a();
                ((AppInstanceClaim) this.a).clearAppInstanceToken();
                return this;
            }

            public Builder clearGmpAppId() {
                a();
                ((AppInstanceClaim) this.a).clearGmpAppId();
                return this;
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public String getAppInstanceId() {
                return ((AppInstanceClaim) this.a).getAppInstanceId();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public ByteString getAppInstanceIdBytes() {
                return ((AppInstanceClaim) this.a).getAppInstanceIdBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public String getAppInstanceToken() {
                return ((AppInstanceClaim) this.a).getAppInstanceToken();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public ByteString getAppInstanceTokenBytes() {
                return ((AppInstanceClaim) this.a).getAppInstanceTokenBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public String getGmpAppId() {
                return ((AppInstanceClaim) this.a).getGmpAppId();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public ByteString getGmpAppIdBytes() {
                return ((AppInstanceClaim) this.a).getGmpAppIdBytes();
            }

            public Builder setAppInstanceId(String str) {
                a();
                ((AppInstanceClaim) this.a).setAppInstanceId(str);
                return this;
            }

            public Builder setAppInstanceIdBytes(ByteString byteString) {
                a();
                ((AppInstanceClaim) this.a).setAppInstanceIdBytes(byteString);
                return this;
            }

            public Builder setAppInstanceToken(String str) {
                a();
                ((AppInstanceClaim) this.a).setAppInstanceToken(str);
                return this;
            }

            public Builder setAppInstanceTokenBytes(ByteString byteString) {
                a();
                ((AppInstanceClaim) this.a).setAppInstanceTokenBytes(byteString);
                return this;
            }

            public Builder setGmpAppId(String str) {
                a();
                ((AppInstanceClaim) this.a).setGmpAppId(str);
                return this;
            }

            public Builder setGmpAppIdBytes(ByteString byteString) {
                a();
                ((AppInstanceClaim) this.a).setGmpAppIdBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private AppInstanceClaim() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppInstanceId() {
            this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppInstanceToken() {
            this.appInstanceToken_ = getDefaultInstance().getAppInstanceToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGmpAppId() {
            this.gmpAppId_ = getDefaultInstance().getGmpAppId();
        }

        public static AppInstanceClaim getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AppInstanceClaim appInstanceClaim) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) appInstanceClaim);
        }

        public static AppInstanceClaim parseDelimitedFrom(InputStream inputStream) {
            return (AppInstanceClaim) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static AppInstanceClaim parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(ByteString byteString) {
            return (AppInstanceClaim) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static AppInstanceClaim parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(CodedInputStream codedInputStream) {
            return (AppInstanceClaim) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AppInstanceClaim parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(InputStream inputStream) {
            return (AppInstanceClaim) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static AppInstanceClaim parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(byte[] bArr) {
            return (AppInstanceClaim) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static AppInstanceClaim parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<AppInstanceClaim> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInstanceId(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.appInstanceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInstanceIdBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.appInstanceId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInstanceToken(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.appInstanceToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInstanceTokenBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.appInstanceToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGmpAppId(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.gmpAppId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGmpAppIdBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.gmpAppId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AppInstanceClaim();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AppInstanceClaim appInstanceClaim = (AppInstanceClaim) obj2;
                    this.appInstanceId_ = visitor.visitString(!this.appInstanceId_.isEmpty(), this.appInstanceId_, !appInstanceClaim.appInstanceId_.isEmpty(), appInstanceClaim.appInstanceId_);
                    this.appInstanceToken_ = visitor.visitString(!this.appInstanceToken_.isEmpty(), this.appInstanceToken_, !appInstanceClaim.appInstanceToken_.isEmpty(), appInstanceClaim.appInstanceToken_);
                    this.gmpAppId_ = visitor.visitString(!this.gmpAppId_.isEmpty(), this.gmpAppId_, true ^ appInstanceClaim.gmpAppId_.isEmpty(), appInstanceClaim.gmpAppId_);
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
                                    this.appInstanceId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.appInstanceToken_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 26) {
                                    this.gmpAppId_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (AppInstanceClaim.class) {
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

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public String getAppInstanceId() {
            return this.appInstanceId_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public ByteString getAppInstanceIdBytes() {
            return ByteString.copyFromUtf8(this.appInstanceId_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public String getAppInstanceToken() {
            return this.appInstanceToken_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public ByteString getAppInstanceTokenBytes() {
            return ByteString.copyFromUtf8(this.appInstanceToken_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public String getGmpAppId() {
            return this.gmpAppId_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public ByteString getGmpAppIdBytes() {
            return ByteString.copyFromUtf8(this.gmpAppId_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.appInstanceId_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getAppInstanceId());
            if (!this.appInstanceToken_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getAppInstanceToken());
            }
            if (!this.gmpAppId_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(3, getGmpAppId());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.appInstanceId_.isEmpty()) {
                codedOutputStream.writeString(1, getAppInstanceId());
            }
            if (!this.appInstanceToken_.isEmpty()) {
                codedOutputStream.writeString(2, getAppInstanceToken());
            }
            if (this.gmpAppId_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(3, getGmpAppId());
        }
    }

    /* loaded from: classes2.dex */
    public interface AppInstanceClaimOrBuilder extends MessageLiteOrBuilder {
        String getAppInstanceId();

        ByteString getAppInstanceIdBytes();

        String getAppInstanceToken();

        ByteString getAppInstanceTokenBytes();

        String getGmpAppId();

        ByteString getGmpAppIdBytes();
    }

    /* loaded from: classes2.dex */
    public static final class ClientSignals extends GeneratedMessageLite<ClientSignals, Builder> implements ClientSignalsOrBuilder {
        public static final int APP_VERSION_FIELD_NUMBER = 1;
        private static final ClientSignals DEFAULT_INSTANCE = new ClientSignals();
        public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
        private static volatile Parser<ClientSignals> PARSER = null;
        public static final int PLATFORM_VERSION_FIELD_NUMBER = 2;
        public static final int TIME_ZONE_FIELD_NUMBER = 4;
        private String appVersion_ = "";
        private String platformVersion_ = "";
        private String languageCode_ = "";
        private String timeZone_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ClientSignals, Builder> implements ClientSignalsOrBuilder {
            private Builder() {
                super(ClientSignals.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppVersion() {
                a();
                ((ClientSignals) this.a).clearAppVersion();
                return this;
            }

            public Builder clearLanguageCode() {
                a();
                ((ClientSignals) this.a).clearLanguageCode();
                return this;
            }

            public Builder clearPlatformVersion() {
                a();
                ((ClientSignals) this.a).clearPlatformVersion();
                return this;
            }

            public Builder clearTimeZone() {
                a();
                ((ClientSignals) this.a).clearTimeZone();
                return this;
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public String getAppVersion() {
                return ((ClientSignals) this.a).getAppVersion();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public ByteString getAppVersionBytes() {
                return ((ClientSignals) this.a).getAppVersionBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public String getLanguageCode() {
                return ((ClientSignals) this.a).getLanguageCode();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public ByteString getLanguageCodeBytes() {
                return ((ClientSignals) this.a).getLanguageCodeBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public String getPlatformVersion() {
                return ((ClientSignals) this.a).getPlatformVersion();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public ByteString getPlatformVersionBytes() {
                return ((ClientSignals) this.a).getPlatformVersionBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public String getTimeZone() {
                return ((ClientSignals) this.a).getTimeZone();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public ByteString getTimeZoneBytes() {
                return ((ClientSignals) this.a).getTimeZoneBytes();
            }

            public Builder setAppVersion(String str) {
                a();
                ((ClientSignals) this.a).setAppVersion(str);
                return this;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                a();
                ((ClientSignals) this.a).setAppVersionBytes(byteString);
                return this;
            }

            public Builder setLanguageCode(String str) {
                a();
                ((ClientSignals) this.a).setLanguageCode(str);
                return this;
            }

            public Builder setLanguageCodeBytes(ByteString byteString) {
                a();
                ((ClientSignals) this.a).setLanguageCodeBytes(byteString);
                return this;
            }

            public Builder setPlatformVersion(String str) {
                a();
                ((ClientSignals) this.a).setPlatformVersion(str);
                return this;
            }

            public Builder setPlatformVersionBytes(ByteString byteString) {
                a();
                ((ClientSignals) this.a).setPlatformVersionBytes(byteString);
                return this;
            }

            public Builder setTimeZone(String str) {
                a();
                ((ClientSignals) this.a).setTimeZone(str);
                return this;
            }

            public Builder setTimeZoneBytes(ByteString byteString) {
                a();
                ((ClientSignals) this.a).setTimeZoneBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ClientSignals() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppVersion() {
            this.appVersion_ = getDefaultInstance().getAppVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLanguageCode() {
            this.languageCode_ = getDefaultInstance().getLanguageCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlatformVersion() {
            this.platformVersion_ = getDefaultInstance().getPlatformVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeZone() {
            this.timeZone_ = getDefaultInstance().getTimeZone();
        }

        public static ClientSignals getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ClientSignals clientSignals) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) clientSignals);
        }

        public static ClientSignals parseDelimitedFrom(InputStream inputStream) {
            return (ClientSignals) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientSignals parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(ByteString byteString) {
            return (ClientSignals) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ClientSignals parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(CodedInputStream codedInputStream) {
            return (ClientSignals) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ClientSignals parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(InputStream inputStream) {
            return (ClientSignals) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientSignals parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(byte[] bArr) {
            return (ClientSignals) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ClientSignals parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ClientSignals> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersion(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.appVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersionBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.appVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLanguageCode(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.languageCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLanguageCodeBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.languageCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatformVersion(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.platformVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatformVersionBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.platformVersion_ = byteString.toStringUtf8();
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
                    return new ClientSignals();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ClientSignals clientSignals = (ClientSignals) obj2;
                    this.appVersion_ = visitor.visitString(!this.appVersion_.isEmpty(), this.appVersion_, !clientSignals.appVersion_.isEmpty(), clientSignals.appVersion_);
                    this.platformVersion_ = visitor.visitString(!this.platformVersion_.isEmpty(), this.platformVersion_, !clientSignals.platformVersion_.isEmpty(), clientSignals.platformVersion_);
                    this.languageCode_ = visitor.visitString(!this.languageCode_.isEmpty(), this.languageCode_, !clientSignals.languageCode_.isEmpty(), clientSignals.languageCode_);
                    this.timeZone_ = visitor.visitString(!this.timeZone_.isEmpty(), this.timeZone_, true ^ clientSignals.timeZone_.isEmpty(), clientSignals.timeZone_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        this.appVersion_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 18) {
                                        this.platformVersion_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 26) {
                                        this.languageCode_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 34) {
                                        this.timeZone_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (ClientSignals.class) {
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

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public String getAppVersion() {
            return this.appVersion_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public ByteString getAppVersionBytes() {
            return ByteString.copyFromUtf8(this.appVersion_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public String getLanguageCode() {
            return this.languageCode_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public ByteString getLanguageCodeBytes() {
            return ByteString.copyFromUtf8(this.languageCode_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public String getPlatformVersion() {
            return this.platformVersion_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public ByteString getPlatformVersionBytes() {
            return ByteString.copyFromUtf8(this.platformVersion_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.appVersion_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getAppVersion());
            if (!this.platformVersion_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getPlatformVersion());
            }
            if (!this.languageCode_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(3, getLanguageCode());
            }
            if (!this.timeZone_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(4, getTimeZone());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public String getTimeZone() {
            return this.timeZone_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public ByteString getTimeZoneBytes() {
            return ByteString.copyFromUtf8(this.timeZone_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.appVersion_.isEmpty()) {
                codedOutputStream.writeString(1, getAppVersion());
            }
            if (!this.platformVersion_.isEmpty()) {
                codedOutputStream.writeString(2, getPlatformVersion());
            }
            if (!this.languageCode_.isEmpty()) {
                codedOutputStream.writeString(3, getLanguageCode());
            }
            if (this.timeZone_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(4, getTimeZone());
        }
    }

    /* loaded from: classes2.dex */
    public interface ClientSignalsOrBuilder extends MessageLiteOrBuilder {
        String getAppVersion();

        ByteString getAppVersionBytes();

        String getLanguageCode();

        ByteString getLanguageCodeBytes();

        String getPlatformVersion();

        ByteString getPlatformVersionBytes();

        String getTimeZone();

        ByteString getTimeZoneBytes();
    }

    private ClientSignalsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
