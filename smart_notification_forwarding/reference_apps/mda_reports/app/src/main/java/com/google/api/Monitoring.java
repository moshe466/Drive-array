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
public final class Monitoring extends GeneratedMessageLite<Monitoring, Builder> implements MonitoringOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    private static final Monitoring DEFAULT_INSTANCE = new Monitoring();
    private static volatile Parser<Monitoring> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<MonitoringDestination> producerDestinations_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<MonitoringDestination> consumerDestinations_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.Monitoring$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Monitoring, Builder> implements MonitoringOrBuilder {
        private Builder() {
            super(Monitoring.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllConsumerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            a();
            ((Monitoring) this.a).addAllConsumerDestinations(iterable);
            return this;
        }

        public Builder addAllProducerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            a();
            ((Monitoring) this.a).addAllProducerDestinations(iterable);
            return this;
        }

        public Builder addConsumerDestinations(int i, MonitoringDestination.Builder builder) {
            a();
            ((Monitoring) this.a).addConsumerDestinations(i, builder);
            return this;
        }

        public Builder addConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
            a();
            ((Monitoring) this.a).addConsumerDestinations(i, monitoringDestination);
            return this;
        }

        public Builder addConsumerDestinations(MonitoringDestination.Builder builder) {
            a();
            ((Monitoring) this.a).addConsumerDestinations(builder);
            return this;
        }

        public Builder addConsumerDestinations(MonitoringDestination monitoringDestination) {
            a();
            ((Monitoring) this.a).addConsumerDestinations(monitoringDestination);
            return this;
        }

        public Builder addProducerDestinations(int i, MonitoringDestination.Builder builder) {
            a();
            ((Monitoring) this.a).addProducerDestinations(i, builder);
            return this;
        }

        public Builder addProducerDestinations(int i, MonitoringDestination monitoringDestination) {
            a();
            ((Monitoring) this.a).addProducerDestinations(i, monitoringDestination);
            return this;
        }

        public Builder addProducerDestinations(MonitoringDestination.Builder builder) {
            a();
            ((Monitoring) this.a).addProducerDestinations(builder);
            return this;
        }

        public Builder addProducerDestinations(MonitoringDestination monitoringDestination) {
            a();
            ((Monitoring) this.a).addProducerDestinations(monitoringDestination);
            return this;
        }

        public Builder clearConsumerDestinations() {
            a();
            ((Monitoring) this.a).clearConsumerDestinations();
            return this;
        }

        public Builder clearProducerDestinations() {
            a();
            ((Monitoring) this.a).clearProducerDestinations();
            return this;
        }

        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestination getConsumerDestinations(int i) {
            return ((Monitoring) this.a).getConsumerDestinations(i);
        }

        @Override // com.google.api.MonitoringOrBuilder
        public int getConsumerDestinationsCount() {
            return ((Monitoring) this.a).getConsumerDestinationsCount();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public List<MonitoringDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.a).getConsumerDestinationsList());
        }

        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestination getProducerDestinations(int i) {
            return ((Monitoring) this.a).getProducerDestinations(i);
        }

        @Override // com.google.api.MonitoringOrBuilder
        public int getProducerDestinationsCount() {
            return ((Monitoring) this.a).getProducerDestinationsCount();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public List<MonitoringDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.a).getProducerDestinationsList());
        }

        public Builder removeConsumerDestinations(int i) {
            a();
            ((Monitoring) this.a).removeConsumerDestinations(i);
            return this;
        }

        public Builder removeProducerDestinations(int i) {
            a();
            ((Monitoring) this.a).removeProducerDestinations(i);
            return this;
        }

        public Builder setConsumerDestinations(int i, MonitoringDestination.Builder builder) {
            a();
            ((Monitoring) this.a).setConsumerDestinations(i, builder);
            return this;
        }

        public Builder setConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
            a();
            ((Monitoring) this.a).setConsumerDestinations(i, monitoringDestination);
            return this;
        }

        public Builder setProducerDestinations(int i, MonitoringDestination.Builder builder) {
            a();
            ((Monitoring) this.a).setProducerDestinations(i, builder);
            return this;
        }

        public Builder setProducerDestinations(int i, MonitoringDestination monitoringDestination) {
            a();
            ((Monitoring) this.a).setProducerDestinations(i, monitoringDestination);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class MonitoringDestination extends GeneratedMessageLite<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
        private static final MonitoringDestination DEFAULT_INSTANCE = new MonitoringDestination();
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static volatile Parser<MonitoringDestination> PARSER;
        private int bitField0_;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
            private Builder() {
                super(MonitoringDestination.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllMetrics(Iterable<String> iterable) {
                a();
                ((MonitoringDestination) this.a).addAllMetrics(iterable);
                return this;
            }

            public Builder addMetrics(String str) {
                a();
                ((MonitoringDestination) this.a).addMetrics(str);
                return this;
            }

            public Builder addMetricsBytes(ByteString byteString) {
                a();
                ((MonitoringDestination) this.a).addMetricsBytes(byteString);
                return this;
            }

            public Builder clearMetrics() {
                a();
                ((MonitoringDestination) this.a).clearMetrics();
                return this;
            }

            public Builder clearMonitoredResource() {
                a();
                ((MonitoringDestination) this.a).clearMonitoredResource();
                return this;
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public String getMetrics(int i) {
                return ((MonitoringDestination) this.a).getMetrics(i);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ByteString getMetricsBytes(int i) {
                return ((MonitoringDestination) this.a).getMetricsBytes(i);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public int getMetricsCount() {
                return ((MonitoringDestination) this.a).getMetricsCount();
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public List<String> getMetricsList() {
                return Collections.unmodifiableList(((MonitoringDestination) this.a).getMetricsList());
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public String getMonitoredResource() {
                return ((MonitoringDestination) this.a).getMonitoredResource();
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                return ((MonitoringDestination) this.a).getMonitoredResourceBytes();
            }

            public Builder setMetrics(int i, String str) {
                a();
                ((MonitoringDestination) this.a).setMetrics(i, str);
                return this;
            }

            public Builder setMonitoredResource(String str) {
                a();
                ((MonitoringDestination) this.a).setMonitoredResource(str);
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString byteString) {
                a();
                ((MonitoringDestination) this.a).setMonitoredResourceBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private MonitoringDestination() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMetrics(Iterable<String> iterable) {
            ensureMetricsIsMutable();
            AbstractMessageLite.a(iterable, this.metrics_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetrics(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureMetricsIsMutable();
            this.metrics_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetricsBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            ensureMetricsIsMutable();
            this.metrics_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetrics() {
            this.metrics_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMonitoredResource() {
            this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
        }

        private void ensureMetricsIsMutable() {
            if (this.metrics_.isModifiable()) {
                return;
            }
            this.metrics_ = GeneratedMessageLite.a(this.metrics_);
        }

        public static MonitoringDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MonitoringDestination monitoringDestination) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) monitoringDestination);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream) {
            return (MonitoringDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MonitoringDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(ByteString byteString) {
            return (MonitoringDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static MonitoringDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (MonitoringDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream) {
            return (MonitoringDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MonitoringDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(InputStream inputStream) {
            return (MonitoringDestination) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static MonitoringDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MonitoringDestination) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(byte[] bArr) {
            return (MonitoringDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static MonitoringDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (MonitoringDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<MonitoringDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetrics(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureMetricsIsMutable();
            this.metrics_.set(i, str);
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
                    return new MonitoringDestination();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.metrics_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MonitoringDestination monitoringDestination = (MonitoringDestination) obj2;
                    this.monitoredResource_ = visitor.visitString(!this.monitoredResource_.isEmpty(), this.monitoredResource_, true ^ monitoringDestination.monitoredResource_.isEmpty(), monitoringDestination.monitoredResource_);
                    this.metrics_ = visitor.visitList(this.metrics_, monitoringDestination.metrics_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= monitoringDestination.bitField0_;
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
                                    this.monitoredResource_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.metrics_.isModifiable()) {
                                        this.metrics_ = GeneratedMessageLite.a(this.metrics_);
                                    }
                                    this.metrics_.add(readStringRequireUtf8);
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
                        synchronized (MonitoringDestination.class) {
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

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public String getMetrics(int i) {
            return this.metrics_.get(i);
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ByteString getMetricsBytes(int i) {
            return ByteString.copyFromUtf8(this.metrics_.get(i));
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public int getMetricsCount() {
            return this.metrics_.size();
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public List<String> getMetricsList() {
            return this.metrics_;
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ByteString getMonitoredResourceBytes() {
            return ByteString.copyFromUtf8(this.monitoredResource_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !this.monitoredResource_.isEmpty() ? CodedOutputStream.computeStringSize(1, getMonitoredResource()) + 0 : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.metrics_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag(this.metrics_.get(i3));
            }
            int size = computeStringSize + i2 + (getMetricsList().size() * 1);
            this.c = size;
            return size;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.monitoredResource_.isEmpty()) {
                codedOutputStream.writeString(1, getMonitoredResource());
            }
            for (int i = 0; i < this.metrics_.size(); i++) {
                codedOutputStream.writeString(2, this.metrics_.get(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface MonitoringDestinationOrBuilder extends MessageLiteOrBuilder {
        String getMetrics(int i);

        ByteString getMetricsBytes(int i);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Monitoring() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllConsumerDestinations(Iterable<? extends MonitoringDestination> iterable) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.a(iterable, this.consumerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProducerDestinations(Iterable<? extends MonitoringDestination> iterable) {
        ensureProducerDestinationsIsMutable();
        AbstractMessageLite.a(iterable, this.producerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(int i, MonitoringDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
        if (monitoringDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(MonitoringDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(MonitoringDestination monitoringDestination) {
        if (monitoringDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(int i, MonitoringDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(int i, MonitoringDestination monitoringDestination) {
        if (monitoringDestination == null) {
            throw new NullPointerException();
        }
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(MonitoringDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(MonitoringDestination monitoringDestination) {
        if (monitoringDestination == null) {
            throw new NullPointerException();
        }
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(monitoringDestination);
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

    public static Monitoring getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Monitoring monitoring) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) monitoring);
    }

    public static Monitoring parseDelimitedFrom(InputStream inputStream) {
        return (Monitoring) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Monitoring parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Monitoring) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Monitoring parseFrom(ByteString byteString) {
        return (Monitoring) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Monitoring parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Monitoring) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Monitoring parseFrom(CodedInputStream codedInputStream) {
        return (Monitoring) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Monitoring parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Monitoring) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Monitoring parseFrom(InputStream inputStream) {
        return (Monitoring) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Monitoring parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Monitoring) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Monitoring parseFrom(byte[] bArr) {
        return (Monitoring) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Monitoring parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Monitoring) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Monitoring> parser() {
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
    public void setConsumerDestinations(int i, MonitoringDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
        if (monitoringDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerDestinations(int i, MonitoringDestination.Builder builder) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerDestinations(int i, MonitoringDestination monitoringDestination) {
        if (monitoringDestination == null) {
            throw new NullPointerException();
        }
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(i, monitoringDestination);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Internal.ProtobufList<MonitoringDestination> protobufList;
        MessageLite readMessage;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Monitoring();
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
                Monitoring monitoring = (Monitoring) obj2;
                this.producerDestinations_ = visitor.visitList(this.producerDestinations_, monitoring.producerDestinations_);
                this.consumerDestinations_ = visitor.visitList(this.consumerDestinations_, monitoring.consumerDestinations_);
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
                                readMessage = codedInputStream.readMessage(MonitoringDestination.parser(), extensionRegistryLite);
                            } else if (readTag == 18) {
                                if (!this.consumerDestinations_.isModifiable()) {
                                    this.consumerDestinations_ = GeneratedMessageLite.a(this.consumerDestinations_);
                                }
                                protobufList = this.consumerDestinations_;
                                readMessage = codedInputStream.readMessage(MonitoringDestination.parser(), extensionRegistryLite);
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                            protobufList.add((MonitoringDestination) readMessage);
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
                    synchronized (Monitoring.class) {
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

    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestination getConsumerDestinations(int i) {
        return this.consumerDestinations_.get(i);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public List<MonitoringDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int i) {
        return this.consumerDestinations_.get(i);
    }

    public List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestination getProducerDestinations(int i) {
        return this.producerDestinations_.get(i);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public List<MonitoringDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    public MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int i) {
        return this.producerDestinations_.get(i);
    }

    public List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
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
