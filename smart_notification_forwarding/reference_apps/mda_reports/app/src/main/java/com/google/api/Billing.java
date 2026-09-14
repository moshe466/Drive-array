package com.google.api;

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
public final class Billing extends GeneratedMessageLite<Billing, Builder> implements BillingOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 8;
    private static final Billing DEFAULT_INSTANCE = new Billing();
    private static volatile Parser<Billing> PARSER;
    private Internal.ProtobufList<BillingDestination> consumerDestinations_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.Billing$1, reason: invalid class name */
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
    public static final class BillingDestination extends GeneratedMessageLite<BillingDestination, Builder> implements BillingDestinationOrBuilder {
        private static final BillingDestination DEFAULT_INSTANCE = new BillingDestination();
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static volatile Parser<BillingDestination> PARSER;
        private int bitField0_;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BillingDestination, Builder> implements BillingDestinationOrBuilder {
            private Builder() {
                super(BillingDestination.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllMetrics(Iterable<String> iterable) {
                a();
                ((BillingDestination) this.a).addAllMetrics(iterable);
                return this;
            }

            public Builder addMetrics(String str) {
                a();
                ((BillingDestination) this.a).addMetrics(str);
                return this;
            }

            public Builder addMetricsBytes(ByteString byteString) {
                a();
                ((BillingDestination) this.a).addMetricsBytes(byteString);
                return this;
            }

            public Builder clearMetrics() {
                a();
                ((BillingDestination) this.a).clearMetrics();
                return this;
            }

            public Builder clearMonitoredResource() {
                a();
                ((BillingDestination) this.a).clearMonitoredResource();
                return this;
            }

            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public String getMetrics(int i) {
                return ((BillingDestination) this.a).getMetrics(i);
            }

            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public ByteString getMetricsBytes(int i) {
                return ((BillingDestination) this.a).getMetricsBytes(i);
            }

            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public int getMetricsCount() {
                return ((BillingDestination) this.a).getMetricsCount();
            }

            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public List<String> getMetricsList() {
                return Collections.unmodifiableList(((BillingDestination) this.a).getMetricsList());
            }

            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public String getMonitoredResource() {
                return ((BillingDestination) this.a).getMonitoredResource();
            }

            @Override // com.google.api.Billing.BillingDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                return ((BillingDestination) this.a).getMonitoredResourceBytes();
            }

            public Builder setMetrics(int i, String str) {
                a();
                ((BillingDestination) this.a).setMetrics(i, str);
                return this;
            }

            public Builder setMonitoredResource(String str) {
                a();
                ((BillingDestination) this.a).setMonitoredResource(str);
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString byteString) {
                a();
                ((BillingDestination) this.a).setMonitoredResourceBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private BillingDestination() {
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

        public static BillingDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BillingDestination billingDestination) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) billingDestination);
        }

        public static BillingDestination parseDelimitedFrom(InputStream inputStream) {
            return (BillingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static BillingDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BillingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BillingDestination parseFrom(ByteString byteString) {
            return (BillingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static BillingDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (BillingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BillingDestination parseFrom(CodedInputStream codedInputStream) {
            return (BillingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BillingDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BillingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static BillingDestination parseFrom(InputStream inputStream) {
            return (BillingDestination) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static BillingDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BillingDestination) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BillingDestination parseFrom(byte[] bArr) {
            return (BillingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static BillingDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (BillingDestination) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<BillingDestination> parser() {
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
                    return new BillingDestination();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.metrics_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    BillingDestination billingDestination = (BillingDestination) obj2;
                    this.monitoredResource_ = visitor.visitString(!this.monitoredResource_.isEmpty(), this.monitoredResource_, true ^ billingDestination.monitoredResource_.isEmpty(), billingDestination.monitoredResource_);
                    this.metrics_ = visitor.visitList(this.metrics_, billingDestination.metrics_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= billingDestination.bitField0_;
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
                        synchronized (BillingDestination.class) {
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

        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public String getMetrics(int i) {
            return this.metrics_.get(i);
        }

        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public ByteString getMetricsBytes(int i) {
            return ByteString.copyFromUtf8(this.metrics_.get(i));
        }

        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public int getMetricsCount() {
            return this.metrics_.size();
        }

        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public List<String> getMetricsList() {
            return this.metrics_;
        }

        @Override // com.google.api.Billing.BillingDestinationOrBuilder
        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        @Override // com.google.api.Billing.BillingDestinationOrBuilder
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
    public interface BillingDestinationOrBuilder extends MessageLiteOrBuilder {
        String getMetrics(int i);

        ByteString getMetricsBytes(int i);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Billing, Builder> implements BillingOrBuilder {
        private Builder() {
            super(Billing.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllConsumerDestinations(Iterable<? extends BillingDestination> iterable) {
            a();
            ((Billing) this.a).addAllConsumerDestinations(iterable);
            return this;
        }

        public Builder addConsumerDestinations(int i, BillingDestination.Builder builder) {
            a();
            ((Billing) this.a).addConsumerDestinations(i, builder);
            return this;
        }

        public Builder addConsumerDestinations(int i, BillingDestination billingDestination) {
            a();
            ((Billing) this.a).addConsumerDestinations(i, billingDestination);
            return this;
        }

        public Builder addConsumerDestinations(BillingDestination.Builder builder) {
            a();
            ((Billing) this.a).addConsumerDestinations(builder);
            return this;
        }

        public Builder addConsumerDestinations(BillingDestination billingDestination) {
            a();
            ((Billing) this.a).addConsumerDestinations(billingDestination);
            return this;
        }

        public Builder clearConsumerDestinations() {
            a();
            ((Billing) this.a).clearConsumerDestinations();
            return this;
        }

        @Override // com.google.api.BillingOrBuilder
        public BillingDestination getConsumerDestinations(int i) {
            return ((Billing) this.a).getConsumerDestinations(i);
        }

        @Override // com.google.api.BillingOrBuilder
        public int getConsumerDestinationsCount() {
            return ((Billing) this.a).getConsumerDestinationsCount();
        }

        @Override // com.google.api.BillingOrBuilder
        public List<BillingDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Billing) this.a).getConsumerDestinationsList());
        }

        public Builder removeConsumerDestinations(int i) {
            a();
            ((Billing) this.a).removeConsumerDestinations(i);
            return this;
        }

        public Builder setConsumerDestinations(int i, BillingDestination.Builder builder) {
            a();
            ((Billing) this.a).setConsumerDestinations(i, builder);
            return this;
        }

        public Builder setConsumerDestinations(int i, BillingDestination billingDestination) {
            a();
            ((Billing) this.a).setConsumerDestinations(i, billingDestination);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Billing() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllConsumerDestinations(Iterable<? extends BillingDestination> iterable) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.a(iterable, this.consumerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(int i, BillingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(int i, BillingDestination billingDestination) {
        if (billingDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, billingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(BillingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(BillingDestination billingDestination) {
        if (billingDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(billingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConsumerDestinations() {
        this.consumerDestinations_ = GeneratedMessageLite.f();
    }

    private void ensureConsumerDestinationsIsMutable() {
        if (this.consumerDestinations_.isModifiable()) {
            return;
        }
        this.consumerDestinations_ = GeneratedMessageLite.a(this.consumerDestinations_);
    }

    public static Billing getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Billing billing) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) billing);
    }

    public static Billing parseDelimitedFrom(InputStream inputStream) {
        return (Billing) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Billing parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Billing) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Billing parseFrom(ByteString byteString) {
        return (Billing) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Billing parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Billing) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Billing parseFrom(CodedInputStream codedInputStream) {
        return (Billing) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Billing parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Billing) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Billing parseFrom(InputStream inputStream) {
        return (Billing) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Billing parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Billing) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Billing parseFrom(byte[] bArr) {
        return (Billing) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Billing parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Billing) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Billing> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeConsumerDestinations(int i) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConsumerDestinations(int i, BillingDestination.Builder builder) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConsumerDestinations(int i, BillingDestination billingDestination) {
        if (billingDestination == null) {
            throw new NullPointerException();
        }
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, billingDestination);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Billing();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.consumerDestinations_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.consumerDestinations_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.consumerDestinations_, ((Billing) obj2).consumerDestinations_);
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
                                if (readTag == 66) {
                                    if (!this.consumerDestinations_.isModifiable()) {
                                        this.consumerDestinations_ = GeneratedMessageLite.a(this.consumerDestinations_);
                                    }
                                    this.consumerDestinations_.add((BillingDestination) codedInputStream.readMessage(BillingDestination.parser(), extensionRegistryLite));
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
                    synchronized (Billing.class) {
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

    @Override // com.google.api.BillingOrBuilder
    public BillingDestination getConsumerDestinations(int i) {
        return this.consumerDestinations_.get(i);
    }

    @Override // com.google.api.BillingOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    @Override // com.google.api.BillingOrBuilder
    public List<BillingDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i) {
        return this.consumerDestinations_.get(i);
    }

    public List<? extends BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.consumerDestinations_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(8, this.consumerDestinations_.get(i3));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.consumerDestinations_.size(); i++) {
            codedOutputStream.writeMessage(8, this.consumerDestinations_.get(i));
        }
    }
}
