package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Logging extends GeneratedMessageLite<Logging, Builder> implements LoggingOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    private static final Logging DEFAULT_INSTANCE = new Logging();
    private static volatile Parser<Logging> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<LoggingDestination> producerDestinations_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<LoggingDestination> consumerDestinations_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.Logging$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Logging, Builder> implements LoggingOrBuilder {
        private Builder() {
            super(Logging.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllConsumerDestinations(Iterable<? extends LoggingDestination> iterable) {
            a();
            ((Logging) this.a).addAllConsumerDestinations(iterable);
            return this;
        }

        public Builder addAllProducerDestinations(Iterable<? extends LoggingDestination> iterable) {
            a();
            ((Logging) this.a).addAllProducerDestinations(iterable);
            return this;
        }

        public Builder addConsumerDestinations(int i, LoggingDestination.Builder builder) {
            a();
            ((Logging) this.a).addConsumerDestinations(i, builder);
            return this;
        }

        public Builder addConsumerDestinations(int i, LoggingDestination loggingDestination) {
            a();
            ((Logging) this.a).addConsumerDestinations(i, loggingDestination);
            return this;
        }

        public Builder addConsumerDestinations(LoggingDestination.Builder builder) {
            a();
            ((Logging) this.a).addConsumerDestinations(builder);
            return this;
        }

        public Builder addConsumerDestinations(LoggingDestination loggingDestination) {
            a();
            ((Logging) this.a).addConsumerDestinations(loggingDestination);
            return this;
        }

        public Builder addProducerDestinations(int i, LoggingDestination.Builder builder) {
            a();
            ((Logging) this.a).addProducerDestinations(i, builder);
            return this;
        }

        public Builder addProducerDestinations(int i, LoggingDestination loggingDestination) {
            a();
            ((Logging) this.a).addProducerDestinations(i, loggingDestination);
            return this;
        }

        public Builder addProducerDestinations(LoggingDestination.Builder builder) {
            a();
            ((Logging) this.a).addProducerDestinations(builder);
            return this;
        }

        public Builder addProducerDestinations(LoggingDestination loggingDestination) {
            a();
            ((Logging) this.a).addProducerDestinations(loggingDestination);
            return this;
        }

        public Builder clearConsumerDestinations() {
            a();
            ((Logging) this.a).clearConsumerDestinations();
            return this;
        }

        public Builder clearProducerDestinations() {
            a();
            ((Logging) this.a).clearProducerDestinations();
            return this;
        }

        @Override // com.google.api.LoggingOrBuilder
        public LoggingDestination getConsumerDestinations(int i) {
            return ((Logging) this.a).getConsumerDestinations(i);
        }

        @Override // com.google.api.LoggingOrBuilder
        public int getConsumerDestinationsCount() {
            return ((Logging) this.a).getConsumerDestinationsCount();
        }

        @Override // com.google.api.LoggingOrBuilder
        public List<LoggingDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Logging) this.a).getConsumerDestinationsList());
        }

        @Override // com.google.api.LoggingOrBuilder
        public LoggingDestination getProducerDestinations(int i) {
            return ((Logging) this.a).getProducerDestinations(i);
        }

        @Override // com.google.api.LoggingOrBuilder
        public int getProducerDestinationsCount() {
            return ((Logging) this.a).getProducerDestinationsCount();
        }

        @Override // com.google.api.LoggingOrBuilder
        public List<LoggingDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Logging) this.a).getProducerDestinationsList());
        }

        public Builder removeConsumerDestinations(int i) {
            a();
            ((Logging) this.a).removeConsumerDestinations(i);
            return this;
        }

        public Builder removeProducerDestinations(int i) {
            a();
            ((Logging) this.a).removeProducerDestinations(i);
            return this;
        }

        public Builder setConsumerDestinations(int i, LoggingDestination.Builder builder) {
            a();
            ((Logging) this.a).setConsumerDestinations(i, builder);
            return this;
        }

        public Builder setConsumerDestinations(int i, LoggingDestination loggingDestination) {
            a();
            ((Logging) this.a).setConsumerDestinations(i, loggingDestination);
            return this;
        }

        public Builder setProducerDestinations(int i, LoggingDestination.Builder builder) {
            a();
            ((Logging) this.a).setProducerDestinations(i, builder);
            return this;
        }

        public Builder setProducerDestinations(int i, LoggingDestination loggingDestination) {
            a();
            ((Logging) this.a).setProducerDestinations(i, loggingDestination);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class LoggingDestination extends GeneratedMessageLite<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
        private static final LoggingDestination DEFAULT_INSTANCE = new LoggingDestination();
        public static final int LOGS_FIELD_NUMBER = 1;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 3;
        private static volatile Parser<LoggingDestination> PARSER;
        private int bitField0_;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> logs_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
            private Builder() {
                super(LoggingDestination.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllLogs(Iterable<String> iterable) {
                a();
                ((LoggingDestination) this.a).addAllLogs(iterable);
                return this;
            }

            public Builder addLogs(String str) {
                a();
                ((LoggingDestination) this.a).addLogs(str);
                return this;
            }

            public Builder addLogsBytes(ByteString byteString) {
                a();
                ((LoggingDestination) this.a).addLogsBytes(byteString);
                return this;
            }

            public Builder clearLogs() {
                a();
                ((LoggingDestination) this.a).clearLogs();
                return this;
            }

            public Builder clearMonitoredResource() {
                a();
                ((LoggingDestination) this.a).clearMonitoredResource();
                return this;
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public String getLogs(int i) {
                return ((LoggingDestination) this.a).getLogs(i);
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public ByteString getLogsBytes(int i) {
                return ((LoggingDestination) this.a).getLogsBytes(i);
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public int getLogsCount() {
                return ((LoggingDestination) this.a).getLogsCount();
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public List<String> getLogsList() {
                return Collections.unmodifiableList(((LoggingDestination) this.a).getLogsList());
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public String getMonitoredResource() {
                return ((LoggingDestination) this.a).getMonitoredResource();
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                return ((LoggingDestination) this.a).getMonitoredResourceBytes();
            }

            public Builder setLogs(int i, String str) {
                a();
                ((LoggingDestination) this.a).setLogs(i, str);
                return this;
            }

            public Builder setMonitoredResource(String str) {
                a();
                ((LoggingDestination) this.a).setMonitoredResource(str);
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString byteString) {
                a();
                ((LoggingDestination) this.a).setMonitoredResourceBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private LoggingDestination() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLogs(Iterable<String> iterable) {
            ensureLogsIsMutable();
            AbstractMessageLite.a(iterable, this.logs_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLogs(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureLogsIsMutable();
            this.logs_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLogsBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            ensureLogsIsMutable();
            this.logs_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLogs() {
            this.logs_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMonitoredResource() {
            this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
        }

        private void ensureLogsIsMutable() {
            if (this.logs_.isModifiable()) {
                return;
            }
            this.logs_ = GeneratedMessageLite.a(this.logs_);
        }

        public static LoggingDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LoggingDestination loggingDestination) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) loggingDestination);
        }

        public static LoggingDestination parseDelimitedFrom(InputStream inputStream) {
            return (LoggingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static LoggingDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LoggingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(ByteString byteString) {
            return (LoggingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static LoggingDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (LoggingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(CodedInputStream codedInputStream) {
            return (LoggingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LoggingDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LoggingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(InputStream inputStream) {
            return (LoggingDestination) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static LoggingDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LoggingDestination) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(byte[] bArr) {
            return (LoggingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static LoggingDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (LoggingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<LoggingDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogs(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureLogsIsMutable();
            this.logs_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMonitoredResource(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.monitoredResource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMonitoredResourceBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.monitoredResource_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new LoggingDestination();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.logs_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    LoggingDestination loggingDestination = (LoggingDestination) obj2;
                    this.monitoredResource_ = visitor.visitString(!this.monitoredResource_.isEmpty(), this.monitoredResource_, true ^ loggingDestination.monitoredResource_.isEmpty(), loggingDestination.monitoredResource_);
                    this.logs_ = visitor.visitList(this.logs_, loggingDestination.logs_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= loggingDestination.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.logs_.isModifiable()) {
                                        this.logs_ = GeneratedMessageLite.a(this.logs_);
                                    }
                                    this.logs_.add(readStringRequireUtf8);
                                } else if (readTag == 26) {
                                    this.monitoredResource_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (LoggingDestination.class) {
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

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public String getLogs(int i) {
            return this.logs_.get(i);
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public ByteString getLogsBytes(int i) {
            return ByteString.copyFromUtf8(this.logs_.get(i));
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public int getLogsCount() {
            return this.logs_.size();
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public List<String> getLogsList() {
            return this.logs_;
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public ByteString getMonitoredResourceBytes() {
            return ByteString.copyFromUtf8(this.monitoredResource_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.logs_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag(this.logs_.get(i3));
            }
            int size = 0 + i2 + (getLogsList().size() * 1);
            if (!this.monitoredResource_.isEmpty()) {
                size += CodedOutputStream.computeStringSize(3, getMonitoredResource());
            }
            this.c = size;
            return size;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.logs_.size(); i++) {
                codedOutputStream.writeString(1, this.logs_.get(i));
            }
            if (this.monitoredResource_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(3, getMonitoredResource());
        }
    }

    /* loaded from: classes2.dex */
    public interface LoggingDestinationOrBuilder extends MessageLiteOrBuilder {
        String getLogs(int i);

        ByteString getLogsBytes(int i);

        int getLogsCount();

        List<String> getLogsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Logging() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllConsumerDestinations(Iterable<? extends LoggingDestination> iterable) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.a(iterable, this.consumerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProducerDestinations(Iterable<? extends LoggingDestination> iterable) {
        ensureProducerDestinationsIsMutable();
        AbstractMessageLite.a(iterable, this.producerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(int i, LoggingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(int i, LoggingDestination loggingDestination) {
        if (loggingDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(LoggingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(LoggingDestination loggingDestination) {
        if (loggingDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(int i, LoggingDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(int i, LoggingDestination loggingDestination) {
        if (loggingDestination == null) {
            throw new NullPointerException();
        }
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(i, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(LoggingDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(LoggingDestination loggingDestination) {
        if (loggingDestination == null) {
            throw new NullPointerException();
        }
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConsumerDestinations() {
        this.consumerDestinations_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProducerDestinations() {
        this.producerDestinations_ = GeneratedMessageLite.f();
    }

    private void ensureConsumerDestinationsIsMutable() {
        if (this.consumerDestinations_.isModifiable()) {
            return;
        }
        this.consumerDestinations_ = GeneratedMessageLite.a(this.consumerDestinations_);
    }

    private void ensureProducerDestinationsIsMutable() {
        if (this.producerDestinations_.isModifiable()) {
            return;
        }
        this.producerDestinations_ = GeneratedMessageLite.a(this.producerDestinations_);
    }

    public static Logging getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Logging logging) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) logging);
    }

    public static Logging parseDelimitedFrom(InputStream inputStream) {
        return (Logging) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Logging parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Logging) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Logging parseFrom(ByteString byteString) {
        return (Logging) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Logging parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Logging) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Logging parseFrom(CodedInputStream codedInputStream) {
        return (Logging) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Logging parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Logging) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Logging parseFrom(InputStream inputStream) {
        return (Logging) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Logging parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Logging) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Logging parseFrom(byte[] bArr) {
        return (Logging) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Logging parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Logging) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Logging> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeConsumerDestinations(int i) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProducerDestinations(int i) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConsumerDestinations(int i, LoggingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConsumerDestinations(int i, LoggingDestination loggingDestination) {
        if (loggingDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerDestinations(int i, LoggingDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerDestinations(int i, LoggingDestination loggingDestination) {
        if (loggingDestination == null) {
            throw new NullPointerException();
        }
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(i, loggingDestination);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Internal.ProtobufList<LoggingDestination> protobufList;
        MessageLite readMessage;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Logging();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.producerDestinations_.makeImmutable();
                this.consumerDestinations_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Logging logging = (Logging) obj2;
                this.producerDestinations_ = visitor.visitList(this.producerDestinations_, logging.producerDestinations_);
                this.consumerDestinations_ = visitor.visitList(this.consumerDestinations_, logging.consumerDestinations_);
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
                                if (!this.producerDestinations_.isModifiable()) {
                                    this.producerDestinations_ = GeneratedMessageLite.a(this.producerDestinations_);
                                }
                                protobufList = this.producerDestinations_;
                                readMessage = codedInputStream.readMessage(LoggingDestination.parser(), extensionRegistryLite);
                            } else if (readTag == 18) {
                                if (!this.consumerDestinations_.isModifiable()) {
                                    this.consumerDestinations_ = GeneratedMessageLite.a(this.consumerDestinations_);
                                }
                                protobufList = this.consumerDestinations_;
                                readMessage = codedInputStream.readMessage(LoggingDestination.parser(), extensionRegistryLite);
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                            protobufList.add((LoggingDestination) readMessage);
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
                    synchronized (Logging.class) {
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

    @Override // com.google.api.LoggingOrBuilder
    public LoggingDestination getConsumerDestinations(int i) {
        return this.consumerDestinations_.get(i);
    }

    @Override // com.google.api.LoggingOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    @Override // com.google.api.LoggingOrBuilder
    public List<LoggingDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i) {
        return this.consumerDestinations_.get(i);
    }

    public List<? extends LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    @Override // com.google.api.LoggingOrBuilder
    public LoggingDestination getProducerDestinations(int i) {
        return this.producerDestinations_.get(i);
    }

    @Override // com.google.api.LoggingOrBuilder
    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    @Override // com.google.api.LoggingOrBuilder
    public List<LoggingDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    public LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int i) {
        return this.producerDestinations_.get(i);
    }

    public List<? extends LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.producerDestinations_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.producerDestinations_.get(i3));
        }
        for (int i4 = 0; i4 < this.consumerDestinations_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(2, this.consumerDestinations_.get(i4));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.producerDestinations_.size(); i++) {
            codedOutputStream.writeMessage(1, this.producerDestinations_.get(i));
        }
        for (int i2 = 0; i2 < this.consumerDestinations_.size(); i2++) {
            codedOutputStream.writeMessage(2, this.consumerDestinations_.get(i2));
        }
    }
}
