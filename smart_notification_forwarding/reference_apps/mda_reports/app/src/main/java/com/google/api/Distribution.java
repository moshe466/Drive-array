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
public final class Distribution extends GeneratedMessageLite<Distribution, Builder> implements DistributionOrBuilder {
    public static final int BUCKET_COUNTS_FIELD_NUMBER = 7;
    public static final int BUCKET_OPTIONS_FIELD_NUMBER = 6;
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final Distribution DEFAULT_INSTANCE = new Distribution();
    public static final int MEAN_FIELD_NUMBER = 2;
    private static volatile Parser<Distribution> PARSER = null;
    public static final int RANGE_FIELD_NUMBER = 4;
    public static final int SUM_OF_SQUARED_DEVIATION_FIELD_NUMBER = 3;
    private int bitField0_;
    private Internal.LongList bucketCounts_ = GeneratedMessageLite.e();
    private BucketOptions bucketOptions_;
    private long count_;
    private double mean_;
    private Range range_;
    private double sumOfSquaredDeviation_;

    /* renamed from: com.google.api.Distribution$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[BucketOptions.OptionsCase.values().length];

        static {
            try {
                b[BucketOptions.OptionsCase.LINEAR_BUCKETS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[BucketOptions.OptionsCase.EXPONENTIAL_BUCKETS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[BucketOptions.OptionsCase.EXPLICIT_BUCKETS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[BucketOptions.OptionsCase.OPTIONS_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class BucketOptions extends GeneratedMessageLite<BucketOptions, Builder> implements BucketOptionsOrBuilder {
        private static final BucketOptions DEFAULT_INSTANCE = new BucketOptions();
        public static final int EXPLICIT_BUCKETS_FIELD_NUMBER = 3;
        public static final int EXPONENTIAL_BUCKETS_FIELD_NUMBER = 2;
        public static final int LINEAR_BUCKETS_FIELD_NUMBER = 1;
        private static volatile Parser<BucketOptions> PARSER;
        private int optionsCase_ = 0;
        private Object options_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions, Builder> implements BucketOptionsOrBuilder {
            private Builder() {
                super(BucketOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearExplicitBuckets() {
                a();
                ((BucketOptions) this.a).clearExplicitBuckets();
                return this;
            }

            public Builder clearExponentialBuckets() {
                a();
                ((BucketOptions) this.a).clearExponentialBuckets();
                return this;
            }

            public Builder clearLinearBuckets() {
                a();
                ((BucketOptions) this.a).clearLinearBuckets();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((BucketOptions) this.a).clearOptions();
                return this;
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public Explicit getExplicitBuckets() {
                return ((BucketOptions) this.a).getExplicitBuckets();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public Exponential getExponentialBuckets() {
                return ((BucketOptions) this.a).getExponentialBuckets();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public Linear getLinearBuckets() {
                return ((BucketOptions) this.a).getLinearBuckets();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public OptionsCase getOptionsCase() {
                return ((BucketOptions) this.a).getOptionsCase();
            }

            public Builder mergeExplicitBuckets(Explicit explicit) {
                a();
                ((BucketOptions) this.a).mergeExplicitBuckets(explicit);
                return this;
            }

            public Builder mergeExponentialBuckets(Exponential exponential) {
                a();
                ((BucketOptions) this.a).mergeExponentialBuckets(exponential);
                return this;
            }

            public Builder mergeLinearBuckets(Linear linear) {
                a();
                ((BucketOptions) this.a).mergeLinearBuckets(linear);
                return this;
            }

            public Builder setExplicitBuckets(Explicit.Builder builder) {
                a();
                ((BucketOptions) this.a).setExplicitBuckets(builder);
                return this;
            }

            public Builder setExplicitBuckets(Explicit explicit) {
                a();
                ((BucketOptions) this.a).setExplicitBuckets(explicit);
                return this;
            }

            public Builder setExponentialBuckets(Exponential.Builder builder) {
                a();
                ((BucketOptions) this.a).setExponentialBuckets(builder);
                return this;
            }

            public Builder setExponentialBuckets(Exponential exponential) {
                a();
                ((BucketOptions) this.a).setExponentialBuckets(exponential);
                return this;
            }

            public Builder setLinearBuckets(Linear.Builder builder) {
                a();
                ((BucketOptions) this.a).setLinearBuckets(builder);
                return this;
            }

            public Builder setLinearBuckets(Linear linear) {
                a();
                ((BucketOptions) this.a).setLinearBuckets(linear);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public static final class Explicit extends GeneratedMessageLite<Explicit, Builder> implements ExplicitOrBuilder {
            public static final int BOUNDS_FIELD_NUMBER = 1;
            private static final Explicit DEFAULT_INSTANCE = new Explicit();
            private static volatile Parser<Explicit> PARSER;
            private Internal.DoubleList bounds_ = GeneratedMessageLite.c();

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Explicit, Builder> implements ExplicitOrBuilder {
                private Builder() {
                    super(Explicit.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder addAllBounds(Iterable<? extends Double> iterable) {
                    a();
                    ((Explicit) this.a).addAllBounds(iterable);
                    return this;
                }

                public Builder addBounds(double d) {
                    a();
                    ((Explicit) this.a).addBounds(d);
                    return this;
                }

                public Builder clearBounds() {
                    a();
                    ((Explicit) this.a).clearBounds();
                    return this;
                }

                @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
                public double getBounds(int i) {
                    return ((Explicit) this.a).getBounds(i);
                }

                @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
                public int getBoundsCount() {
                    return ((Explicit) this.a).getBoundsCount();
                }

                @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
                public List<Double> getBoundsList() {
                    return Collections.unmodifiableList(((Explicit) this.a).getBoundsList());
                }

                public Builder setBounds(int i, double d) {
                    a();
                    ((Explicit) this.a).setBounds(i, d);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private Explicit() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllBounds(Iterable<? extends Double> iterable) {
                ensureBoundsIsMutable();
                AbstractMessageLite.a(iterable, this.bounds_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addBounds(double d) {
                ensureBoundsIsMutable();
                this.bounds_.addDouble(d);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBounds() {
                this.bounds_ = GeneratedMessageLite.c();
            }

            private void ensureBoundsIsMutable() {
                if (this.bounds_.isModifiable()) {
                    return;
                }
                this.bounds_ = GeneratedMessageLite.a(this.bounds_);
            }

            public static Explicit getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Explicit explicit) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) explicit);
            }

            public static Explicit parseDelimitedFrom(InputStream inputStream) {
                return (Explicit) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static Explicit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Explicit) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Explicit parseFrom(ByteString byteString) {
                return (Explicit) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static Explicit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Explicit) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Explicit parseFrom(CodedInputStream codedInputStream) {
                return (Explicit) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Explicit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Explicit) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Explicit parseFrom(InputStream inputStream) {
                return (Explicit) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static Explicit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Explicit) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Explicit parseFrom(byte[] bArr) {
                return (Explicit) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static Explicit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Explicit) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<Explicit> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBounds(int i, double d) {
                ensureBoundsIsMutable();
                this.bounds_.setDouble(i, d);
            }

            /* JADX WARN: Type inference failed for: r6v11, types: [com.google.protobuf.Internal$DoubleList] */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Explicit();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        this.bounds_.makeImmutable();
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        this.bounds_ = ((GeneratedMessageLite.Visitor) obj).visitDoubleList(this.bounds_, ((Explicit) obj2).bounds_);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 9) {
                                        if (!this.bounds_.isModifiable()) {
                                            this.bounds_ = GeneratedMessageLite.a(this.bounds_);
                                        }
                                        this.bounds_.addDouble(codedInputStream.readDouble());
                                    } else if (readTag == 10) {
                                        int readRawVarint32 = codedInputStream.readRawVarint32();
                                        int pushLimit = codedInputStream.pushLimit(readRawVarint32);
                                        if (!this.bounds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.bounds_ = this.bounds_.mutableCopyWithCapacity2(this.bounds_.size() + (readRawVarint32 / 8));
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.bounds_.addDouble(codedInputStream.readDouble());
                                        }
                                        codedInputStream.popLimit(pushLimit);
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
                            synchronized (Explicit.class) {
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

            @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
            public double getBounds(int i) {
                return this.bounds_.getDouble(i);
            }

            @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
            public int getBoundsCount() {
                return this.bounds_.size();
            }

            @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
            public List<Double> getBoundsList() {
                return this.bounds_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int size = (getBoundsList().size() * 8) + 0 + (getBoundsList().size() * 1);
                this.c = size;
                return size;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                getSerializedSize();
                for (int i = 0; i < this.bounds_.size(); i++) {
                    codedOutputStream.writeDouble(1, this.bounds_.getDouble(i));
                }
            }
        }

        /* loaded from: classes2.dex */
        public interface ExplicitOrBuilder extends MessageLiteOrBuilder {
            double getBounds(int i);

            int getBoundsCount();

            List<Double> getBoundsList();
        }

        /* loaded from: classes2.dex */
        public static final class Exponential extends GeneratedMessageLite<Exponential, Builder> implements ExponentialOrBuilder {
            private static final Exponential DEFAULT_INSTANCE = new Exponential();
            public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            private static volatile Parser<Exponential> PARSER = null;
            public static final int SCALE_FIELD_NUMBER = 3;
            private double growthFactor_;
            private int numFiniteBuckets_;
            private double scale_;

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Exponential, Builder> implements ExponentialOrBuilder {
                private Builder() {
                    super(Exponential.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearGrowthFactor() {
                    a();
                    ((Exponential) this.a).clearGrowthFactor();
                    return this;
                }

                public Builder clearNumFiniteBuckets() {
                    a();
                    ((Exponential) this.a).clearNumFiniteBuckets();
                    return this;
                }

                public Builder clearScale() {
                    a();
                    ((Exponential) this.a).clearScale();
                    return this;
                }

                @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
                public double getGrowthFactor() {
                    return ((Exponential) this.a).getGrowthFactor();
                }

                @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
                public int getNumFiniteBuckets() {
                    return ((Exponential) this.a).getNumFiniteBuckets();
                }

                @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
                public double getScale() {
                    return ((Exponential) this.a).getScale();
                }

                public Builder setGrowthFactor(double d) {
                    a();
                    ((Exponential) this.a).setGrowthFactor(d);
                    return this;
                }

                public Builder setNumFiniteBuckets(int i) {
                    a();
                    ((Exponential) this.a).setNumFiniteBuckets(i);
                    return this;
                }

                public Builder setScale(double d) {
                    a();
                    ((Exponential) this.a).setScale(d);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private Exponential() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearGrowthFactor() {
                this.growthFactor_ = 0.0d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNumFiniteBuckets() {
                this.numFiniteBuckets_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearScale() {
                this.scale_ = 0.0d;
            }

            public static Exponential getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Exponential exponential) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) exponential);
            }

            public static Exponential parseDelimitedFrom(InputStream inputStream) {
                return (Exponential) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static Exponential parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exponential) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Exponential parseFrom(ByteString byteString) {
                return (Exponential) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static Exponential parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Exponential) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Exponential parseFrom(CodedInputStream codedInputStream) {
                return (Exponential) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Exponential parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exponential) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Exponential parseFrom(InputStream inputStream) {
                return (Exponential) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static Exponential parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exponential) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Exponential parseFrom(byte[] bArr) {
                return (Exponential) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static Exponential parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Exponential) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<Exponential> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setGrowthFactor(double d) {
                this.growthFactor_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNumFiniteBuckets(int i) {
                this.numFiniteBuckets_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setScale(double d) {
                this.scale_ = d;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                boolean z = false;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Exponential();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Exponential exponential = (Exponential) obj2;
                        this.numFiniteBuckets_ = visitor.visitInt(this.numFiniteBuckets_ != 0, this.numFiniteBuckets_, exponential.numFiniteBuckets_ != 0, exponential.numFiniteBuckets_);
                        this.growthFactor_ = visitor.visitDouble(this.growthFactor_ != 0.0d, this.growthFactor_, exponential.growthFactor_ != 0.0d, exponential.growthFactor_);
                        this.scale_ = visitor.visitDouble(this.scale_ != 0.0d, this.scale_, exponential.scale_ != 0.0d, exponential.scale_);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.numFiniteBuckets_ = codedInputStream.readInt32();
                                    } else if (readTag == 17) {
                                        this.growthFactor_ = codedInputStream.readDouble();
                                    } else if (readTag == 25) {
                                        this.scale_ = codedInputStream.readDouble();
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
                            synchronized (Exponential.class) {
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

            @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
            public double getGrowthFactor() {
                return this.growthFactor_;
            }

            @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
            public double getScale() {
                return this.scale_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int i2 = this.numFiniteBuckets_;
                int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
                double d = this.growthFactor_;
                if (d != 0.0d) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(2, d);
                }
                double d2 = this.scale_;
                if (d2 != 0.0d) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(3, d2);
                }
                this.c = computeInt32Size;
                return computeInt32Size;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                int i = this.numFiniteBuckets_;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                double d = this.growthFactor_;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(2, d);
                }
                double d2 = this.scale_;
                if (d2 != 0.0d) {
                    codedOutputStream.writeDouble(3, d2);
                }
            }
        }

        /* loaded from: classes2.dex */
        public interface ExponentialOrBuilder extends MessageLiteOrBuilder {
            double getGrowthFactor();

            int getNumFiniteBuckets();

            double getScale();
        }

        /* loaded from: classes2.dex */
        public static final class Linear extends GeneratedMessageLite<Linear, Builder> implements LinearOrBuilder {
            private static final Linear DEFAULT_INSTANCE = new Linear();
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            public static final int OFFSET_FIELD_NUMBER = 3;
            private static volatile Parser<Linear> PARSER = null;
            public static final int WIDTH_FIELD_NUMBER = 2;
            private int numFiniteBuckets_;
            private double offset_;
            private double width_;

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Linear, Builder> implements LinearOrBuilder {
                private Builder() {
                    super(Linear.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearNumFiniteBuckets() {
                    a();
                    ((Linear) this.a).clearNumFiniteBuckets();
                    return this;
                }

                public Builder clearOffset() {
                    a();
                    ((Linear) this.a).clearOffset();
                    return this;
                }

                public Builder clearWidth() {
                    a();
                    ((Linear) this.a).clearWidth();
                    return this;
                }

                @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
                public int getNumFiniteBuckets() {
                    return ((Linear) this.a).getNumFiniteBuckets();
                }

                @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
                public double getOffset() {
                    return ((Linear) this.a).getOffset();
                }

                @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
                public double getWidth() {
                    return ((Linear) this.a).getWidth();
                }

                public Builder setNumFiniteBuckets(int i) {
                    a();
                    ((Linear) this.a).setNumFiniteBuckets(i);
                    return this;
                }

                public Builder setOffset(double d) {
                    a();
                    ((Linear) this.a).setOffset(d);
                    return this;
                }

                public Builder setWidth(double d) {
                    a();
                    ((Linear) this.a).setWidth(d);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private Linear() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNumFiniteBuckets() {
                this.numFiniteBuckets_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOffset() {
                this.offset_ = 0.0d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearWidth() {
                this.width_ = 0.0d;
            }

            public static Linear getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Linear linear) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) linear);
            }

            public static Linear parseDelimitedFrom(InputStream inputStream) {
                return (Linear) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static Linear parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Linear) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Linear parseFrom(ByteString byteString) {
                return (Linear) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static Linear parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Linear) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Linear parseFrom(CodedInputStream codedInputStream) {
                return (Linear) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Linear parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Linear) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Linear parseFrom(InputStream inputStream) {
                return (Linear) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static Linear parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Linear) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Linear parseFrom(byte[] bArr) {
                return (Linear) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static Linear parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Linear) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<Linear> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNumFiniteBuckets(int i) {
                this.numFiniteBuckets_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOffset(double d) {
                this.offset_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setWidth(double d) {
                this.width_ = d;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                boolean z = false;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Linear();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Linear linear = (Linear) obj2;
                        this.numFiniteBuckets_ = visitor.visitInt(this.numFiniteBuckets_ != 0, this.numFiniteBuckets_, linear.numFiniteBuckets_ != 0, linear.numFiniteBuckets_);
                        this.width_ = visitor.visitDouble(this.width_ != 0.0d, this.width_, linear.width_ != 0.0d, linear.width_);
                        this.offset_ = visitor.visitDouble(this.offset_ != 0.0d, this.offset_, linear.offset_ != 0.0d, linear.offset_);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.numFiniteBuckets_ = codedInputStream.readInt32();
                                    } else if (readTag == 17) {
                                        this.width_ = codedInputStream.readDouble();
                                    } else if (readTag == 25) {
                                        this.offset_ = codedInputStream.readDouble();
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
                            synchronized (Linear.class) {
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

            @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
            public double getOffset() {
                return this.offset_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int i2 = this.numFiniteBuckets_;
                int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
                double d = this.width_;
                if (d != 0.0d) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(2, d);
                }
                double d2 = this.offset_;
                if (d2 != 0.0d) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(3, d2);
                }
                this.c = computeInt32Size;
                return computeInt32Size;
            }

            @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
            public double getWidth() {
                return this.width_;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                int i = this.numFiniteBuckets_;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                double d = this.width_;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(2, d);
                }
                double d2 = this.offset_;
                if (d2 != 0.0d) {
                    codedOutputStream.writeDouble(3, d2);
                }
            }
        }

        /* loaded from: classes2.dex */
        public interface LinearOrBuilder extends MessageLiteOrBuilder {
            int getNumFiniteBuckets();

            double getOffset();

            double getWidth();
        }

        /* loaded from: classes2.dex */
        public enum OptionsCase implements Internal.EnumLite {
            LINEAR_BUCKETS(1),
            EXPONENTIAL_BUCKETS(2),
            EXPLICIT_BUCKETS(3),
            OPTIONS_NOT_SET(0);

            private final int value;

            OptionsCase(int i) {
                this.value = i;
            }

            public static OptionsCase forNumber(int i) {
                if (i == 0) {
                    return OPTIONS_NOT_SET;
                }
                if (i == 1) {
                    return LINEAR_BUCKETS;
                }
                if (i == 2) {
                    return EXPONENTIAL_BUCKETS;
                }
                if (i != 3) {
                    return null;
                }
                return EXPLICIT_BUCKETS;
            }

            @Deprecated
            public static OptionsCase valueOf(int i) {
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

        private BucketOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExplicitBuckets() {
            if (this.optionsCase_ == 3) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExponentialBuckets() {
            if (this.optionsCase_ == 2) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLinearBuckets() {
            if (this.optionsCase_ == 1) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.optionsCase_ = 0;
            this.options_ = null;
        }

        public static BucketOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExplicitBuckets(Explicit explicit) {
            if (this.optionsCase_ == 3 && this.options_ != Explicit.getDefaultInstance()) {
                explicit = Explicit.newBuilder((Explicit) this.options_).mergeFrom((Explicit.Builder) explicit).buildPartial();
            }
            this.options_ = explicit;
            this.optionsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExponentialBuckets(Exponential exponential) {
            if (this.optionsCase_ == 2 && this.options_ != Exponential.getDefaultInstance()) {
                exponential = Exponential.newBuilder((Exponential) this.options_).mergeFrom((Exponential.Builder) exponential).buildPartial();
            }
            this.options_ = exponential;
            this.optionsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLinearBuckets(Linear linear) {
            if (this.optionsCase_ == 1 && this.options_ != Linear.getDefaultInstance()) {
                linear = Linear.newBuilder((Linear) this.options_).mergeFrom((Linear.Builder) linear).buildPartial();
            }
            this.options_ = linear;
            this.optionsCase_ = 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BucketOptions bucketOptions) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) bucketOptions);
        }

        public static BucketOptions parseDelimitedFrom(InputStream inputStream) {
            return (BucketOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static BucketOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BucketOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(ByteString byteString) {
            return (BucketOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static BucketOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (BucketOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(CodedInputStream codedInputStream) {
            return (BucketOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BucketOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BucketOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(InputStream inputStream) {
            return (BucketOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static BucketOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BucketOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(byte[] bArr) {
            return (BucketOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static BucketOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (BucketOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<BucketOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExplicitBuckets(Explicit.Builder builder) {
            this.options_ = builder.build();
            this.optionsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExplicitBuckets(Explicit explicit) {
            if (explicit == null) {
                throw new NullPointerException();
            }
            this.options_ = explicit;
            this.optionsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExponentialBuckets(Exponential.Builder builder) {
            this.options_ = builder.build();
            this.optionsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExponentialBuckets(Exponential exponential) {
            if (exponential == null) {
                throw new NullPointerException();
            }
            this.options_ = exponential;
            this.optionsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLinearBuckets(Linear.Builder builder) {
            this.options_ = builder.build();
            this.optionsCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLinearBuckets(Linear linear) {
            if (linear == null) {
                throw new NullPointerException();
            }
            this.options_ = linear;
            this.optionsCase_ = 1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:104:0x0124, code lost:
        
            if (r6.optionsCase_ == 3) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0131, code lost:
        
            r6.options_ = r8.visitOneofMessage(r2, r6.options_, r9.options_);
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0130, code lost:
        
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x0129, code lost:
        
            if (r6.optionsCase_ == 2) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x012e, code lost:
        
            if (r6.optionsCase_ == 1) goto L89;
         */
        @Override // com.google.protobuf.GeneratedMessageLite
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r7, java.lang.Object r8, java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 362
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.BucketOptions.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public Explicit getExplicitBuckets() {
            return this.optionsCase_ == 3 ? (Explicit) this.options_ : Explicit.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public Exponential getExponentialBuckets() {
            return this.optionsCase_ == 2 ? (Exponential) this.options_ : Exponential.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public Linear getLinearBuckets() {
            return this.optionsCase_ == 1 ? (Linear) this.options_ : Linear.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public OptionsCase getOptionsCase() {
            return OptionsCase.forNumber(this.optionsCase_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.optionsCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (Linear) this.options_) : 0;
            if (this.optionsCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (Exponential) this.options_);
            }
            if (this.optionsCase_ == 3) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, (Explicit) this.options_);
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.optionsCase_ == 1) {
                codedOutputStream.writeMessage(1, (Linear) this.options_);
            }
            if (this.optionsCase_ == 2) {
                codedOutputStream.writeMessage(2, (Exponential) this.options_);
            }
            if (this.optionsCase_ == 3) {
                codedOutputStream.writeMessage(3, (Explicit) this.options_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface BucketOptionsOrBuilder extends MessageLiteOrBuilder {
        BucketOptions.Explicit getExplicitBuckets();

        BucketOptions.Exponential getExponentialBuckets();

        BucketOptions.Linear getLinearBuckets();

        BucketOptions.OptionsCase getOptionsCase();
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Distribution, Builder> implements DistributionOrBuilder {
        private Builder() {
            super(Distribution.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllBucketCounts(Iterable<? extends Long> iterable) {
            a();
            ((Distribution) this.a).addAllBucketCounts(iterable);
            return this;
        }

        public Builder addBucketCounts(long j) {
            a();
            ((Distribution) this.a).addBucketCounts(j);
            return this;
        }

        public Builder clearBucketCounts() {
            a();
            ((Distribution) this.a).clearBucketCounts();
            return this;
        }

        public Builder clearBucketOptions() {
            a();
            ((Distribution) this.a).clearBucketOptions();
            return this;
        }

        public Builder clearCount() {
            a();
            ((Distribution) this.a).clearCount();
            return this;
        }

        public Builder clearMean() {
            a();
            ((Distribution) this.a).clearMean();
            return this;
        }

        public Builder clearRange() {
            a();
            ((Distribution) this.a).clearRange();
            return this;
        }

        public Builder clearSumOfSquaredDeviation() {
            a();
            ((Distribution) this.a).clearSumOfSquaredDeviation();
            return this;
        }

        @Override // com.google.api.DistributionOrBuilder
        public long getBucketCounts(int i) {
            return ((Distribution) this.a).getBucketCounts(i);
        }

        @Override // com.google.api.DistributionOrBuilder
        public int getBucketCountsCount() {
            return ((Distribution) this.a).getBucketCountsCount();
        }

        @Override // com.google.api.DistributionOrBuilder
        public List<Long> getBucketCountsList() {
            return Collections.unmodifiableList(((Distribution) this.a).getBucketCountsList());
        }

        @Override // com.google.api.DistributionOrBuilder
        public BucketOptions getBucketOptions() {
            return ((Distribution) this.a).getBucketOptions();
        }

        @Override // com.google.api.DistributionOrBuilder
        public long getCount() {
            return ((Distribution) this.a).getCount();
        }

        @Override // com.google.api.DistributionOrBuilder
        public double getMean() {
            return ((Distribution) this.a).getMean();
        }

        @Override // com.google.api.DistributionOrBuilder
        public Range getRange() {
            return ((Distribution) this.a).getRange();
        }

        @Override // com.google.api.DistributionOrBuilder
        public double getSumOfSquaredDeviation() {
            return ((Distribution) this.a).getSumOfSquaredDeviation();
        }

        @Override // com.google.api.DistributionOrBuilder
        public boolean hasBucketOptions() {
            return ((Distribution) this.a).hasBucketOptions();
        }

        @Override // com.google.api.DistributionOrBuilder
        public boolean hasRange() {
            return ((Distribution) this.a).hasRange();
        }

        public Builder mergeBucketOptions(BucketOptions bucketOptions) {
            a();
            ((Distribution) this.a).mergeBucketOptions(bucketOptions);
            return this;
        }

        public Builder mergeRange(Range range) {
            a();
            ((Distribution) this.a).mergeRange(range);
            return this;
        }

        public Builder setBucketCounts(int i, long j) {
            a();
            ((Distribution) this.a).setBucketCounts(i, j);
            return this;
        }

        public Builder setBucketOptions(BucketOptions.Builder builder) {
            a();
            ((Distribution) this.a).setBucketOptions(builder);
            return this;
        }

        public Builder setBucketOptions(BucketOptions bucketOptions) {
            a();
            ((Distribution) this.a).setBucketOptions(bucketOptions);
            return this;
        }

        public Builder setCount(long j) {
            a();
            ((Distribution) this.a).setCount(j);
            return this;
        }

        public Builder setMean(double d) {
            a();
            ((Distribution) this.a).setMean(d);
            return this;
        }

        public Builder setRange(Range.Builder builder) {
            a();
            ((Distribution) this.a).setRange(builder);
            return this;
        }

        public Builder setRange(Range range) {
            a();
            ((Distribution) this.a).setRange(range);
            return this;
        }

        public Builder setSumOfSquaredDeviation(double d) {
            a();
            ((Distribution) this.a).setSumOfSquaredDeviation(d);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Range extends GeneratedMessageLite<Range, Builder> implements RangeOrBuilder {
        private static final Range DEFAULT_INSTANCE = new Range();
        public static final int MAX_FIELD_NUMBER = 2;
        public static final int MIN_FIELD_NUMBER = 1;
        private static volatile Parser<Range> PARSER;
        private double max_;
        private double min_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Range, Builder> implements RangeOrBuilder {
            private Builder() {
                super(Range.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearMax() {
                a();
                ((Range) this.a).clearMax();
                return this;
            }

            public Builder clearMin() {
                a();
                ((Range) this.a).clearMin();
                return this;
            }

            @Override // com.google.api.Distribution.RangeOrBuilder
            public double getMax() {
                return ((Range) this.a).getMax();
            }

            @Override // com.google.api.Distribution.RangeOrBuilder
            public double getMin() {
                return ((Range) this.a).getMin();
            }

            public Builder setMax(double d) {
                a();
                ((Range) this.a).setMax(d);
                return this;
            }

            public Builder setMin(double d) {
                a();
                ((Range) this.a).setMin(d);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Range() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMax() {
            this.max_ = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMin() {
            this.min_ = 0.0d;
        }

        public static Range getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Range range) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) range);
        }

        public static Range parseDelimitedFrom(InputStream inputStream) {
            return (Range) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Range parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Range) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Range parseFrom(ByteString byteString) {
            return (Range) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Range parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Range) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Range parseFrom(CodedInputStream codedInputStream) {
            return (Range) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Range parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Range) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Range parseFrom(InputStream inputStream) {
            return (Range) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Range parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Range) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Range parseFrom(byte[] bArr) {
            return (Range) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Range parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Range) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Range> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMax(double d) {
            this.max_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMin(double d) {
            this.min_ = d;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            boolean z = false;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Range();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Range range = (Range) obj2;
                    this.min_ = visitor.visitDouble(this.min_ != 0.0d, this.min_, range.min_ != 0.0d, range.min_);
                    this.max_ = visitor.visitDouble(this.max_ != 0.0d, this.max_, range.max_ != 0.0d, range.max_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 9) {
                                    this.min_ = codedInputStream.readDouble();
                                } else if (readTag == 17) {
                                    this.max_ = codedInputStream.readDouble();
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
                        synchronized (Range.class) {
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

        @Override // com.google.api.Distribution.RangeOrBuilder
        public double getMax() {
            return this.max_;
        }

        @Override // com.google.api.Distribution.RangeOrBuilder
        public double getMin() {
            return this.min_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            double d = this.min_;
            int computeDoubleSize = d != 0.0d ? 0 + CodedOutputStream.computeDoubleSize(1, d) : 0;
            double d2 = this.max_;
            if (d2 != 0.0d) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(2, d2);
            }
            this.c = computeDoubleSize;
            return computeDoubleSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            double d = this.min_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(1, d);
            }
            double d2 = this.max_;
            if (d2 != 0.0d) {
                codedOutputStream.writeDouble(2, d2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface RangeOrBuilder extends MessageLiteOrBuilder {
        double getMax();

        double getMin();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Distribution() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllBucketCounts(Iterable<? extends Long> iterable) {
        ensureBucketCountsIsMutable();
        AbstractMessageLite.a(iterable, this.bucketCounts_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBucketCounts(long j) {
        ensureBucketCountsIsMutable();
        this.bucketCounts_.addLong(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBucketCounts() {
        this.bucketCounts_ = GeneratedMessageLite.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBucketOptions() {
        this.bucketOptions_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCount() {
        this.count_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMean() {
        this.mean_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRange() {
        this.range_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSumOfSquaredDeviation() {
        this.sumOfSquaredDeviation_ = 0.0d;
    }

    private void ensureBucketCountsIsMutable() {
        if (this.bucketCounts_.isModifiable()) {
            return;
        }
        this.bucketCounts_ = GeneratedMessageLite.a(this.bucketCounts_);
    }

    public static Distribution getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBucketOptions(BucketOptions bucketOptions) {
        BucketOptions bucketOptions2 = this.bucketOptions_;
        if (bucketOptions2 != null && bucketOptions2 != BucketOptions.getDefaultInstance()) {
            bucketOptions = BucketOptions.newBuilder(this.bucketOptions_).mergeFrom((BucketOptions.Builder) bucketOptions).buildPartial();
        }
        this.bucketOptions_ = bucketOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRange(Range range) {
        Range range2 = this.range_;
        if (range2 != null && range2 != Range.getDefaultInstance()) {
            range = Range.newBuilder(this.range_).mergeFrom((Range.Builder) range).buildPartial();
        }
        this.range_ = range;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Distribution distribution) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) distribution);
    }

    public static Distribution parseDelimitedFrom(InputStream inputStream) {
        return (Distribution) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Distribution parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Distribution) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Distribution parseFrom(ByteString byteString) {
        return (Distribution) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Distribution parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Distribution) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Distribution parseFrom(CodedInputStream codedInputStream) {
        return (Distribution) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Distribution parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Distribution) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Distribution parseFrom(InputStream inputStream) {
        return (Distribution) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Distribution parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Distribution) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Distribution parseFrom(byte[] bArr) {
        return (Distribution) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Distribution parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Distribution) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Distribution> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBucketCounts(int i, long j) {
        ensureBucketCountsIsMutable();
        this.bucketCounts_.setLong(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBucketOptions(BucketOptions.Builder builder) {
        this.bucketOptions_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBucketOptions(BucketOptions bucketOptions) {
        if (bucketOptions == null) {
            throw new NullPointerException();
        }
        this.bucketOptions_ = bucketOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCount(long j) {
        this.count_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMean(double d) {
        this.mean_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRange(Range.Builder builder) {
        this.range_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRange(Range range) {
        if (range == null) {
            throw new NullPointerException();
        }
        this.range_ = range;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSumOfSquaredDeviation(double d) {
        this.sumOfSquaredDeviation_ = d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Distribution();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.bucketCounts_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Distribution distribution = (Distribution) obj2;
                this.count_ = visitor.visitLong(this.count_ != 0, this.count_, distribution.count_ != 0, distribution.count_);
                this.mean_ = visitor.visitDouble(this.mean_ != 0.0d, this.mean_, distribution.mean_ != 0.0d, distribution.mean_);
                this.sumOfSquaredDeviation_ = visitor.visitDouble(this.sumOfSquaredDeviation_ != 0.0d, this.sumOfSquaredDeviation_, distribution.sumOfSquaredDeviation_ != 0.0d, distribution.sumOfSquaredDeviation_);
                this.range_ = (Range) visitor.visitMessage(this.range_, distribution.range_);
                this.bucketOptions_ = (BucketOptions) visitor.visitMessage(this.bucketOptions_, distribution.bucketOptions_);
                this.bucketCounts_ = visitor.visitLongList(this.bucketCounts_, distribution.bucketCounts_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= distribution.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.count_ = codedInputStream.readInt64();
                            } else if (readTag == 17) {
                                this.mean_ = codedInputStream.readDouble();
                            } else if (readTag == 25) {
                                this.sumOfSquaredDeviation_ = codedInputStream.readDouble();
                            } else if (readTag == 34) {
                                Range.Builder builder = this.range_ != null ? this.range_.toBuilder() : null;
                                this.range_ = (Range) codedInputStream.readMessage(Range.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Range.Builder) this.range_);
                                    this.range_ = builder.buildPartial();
                                }
                            } else if (readTag == 50) {
                                BucketOptions.Builder builder2 = this.bucketOptions_ != null ? this.bucketOptions_.toBuilder() : null;
                                this.bucketOptions_ = (BucketOptions) codedInputStream.readMessage(BucketOptions.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((BucketOptions.Builder) this.bucketOptions_);
                                    this.bucketOptions_ = builder2.buildPartial();
                                }
                            } else if (readTag == 56) {
                                if (!this.bucketCounts_.isModifiable()) {
                                    this.bucketCounts_ = GeneratedMessageLite.a(this.bucketCounts_);
                                }
                                this.bucketCounts_.addLong(codedInputStream.readInt64());
                            } else if (readTag == 58) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!this.bucketCounts_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.bucketCounts_ = GeneratedMessageLite.a(this.bucketCounts_);
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.bucketCounts_.addLong(codedInputStream.readInt64());
                                }
                                codedInputStream.popLimit(pushLimit);
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
                    synchronized (Distribution.class) {
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

    @Override // com.google.api.DistributionOrBuilder
    public long getBucketCounts(int i) {
        return this.bucketCounts_.getLong(i);
    }

    @Override // com.google.api.DistributionOrBuilder
    public int getBucketCountsCount() {
        return this.bucketCounts_.size();
    }

    @Override // com.google.api.DistributionOrBuilder
    public List<Long> getBucketCountsList() {
        return this.bucketCounts_;
    }

    @Override // com.google.api.DistributionOrBuilder
    public BucketOptions getBucketOptions() {
        BucketOptions bucketOptions = this.bucketOptions_;
        return bucketOptions == null ? BucketOptions.getDefaultInstance() : bucketOptions;
    }

    @Override // com.google.api.DistributionOrBuilder
    public long getCount() {
        return this.count_;
    }

    @Override // com.google.api.DistributionOrBuilder
    public double getMean() {
        return this.mean_;
    }

    @Override // com.google.api.DistributionOrBuilder
    public Range getRange() {
        Range range = this.range_;
        return range == null ? Range.getDefaultInstance() : range;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        long j = this.count_;
        int computeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) + 0 : 0;
        double d = this.mean_;
        if (d != 0.0d) {
            computeInt64Size += CodedOutputStream.computeDoubleSize(2, d);
        }
        double d2 = this.sumOfSquaredDeviation_;
        if (d2 != 0.0d) {
            computeInt64Size += CodedOutputStream.computeDoubleSize(3, d2);
        }
        if (this.range_ != null) {
            computeInt64Size += CodedOutputStream.computeMessageSize(4, getRange());
        }
        if (this.bucketOptions_ != null) {
            computeInt64Size += CodedOutputStream.computeMessageSize(6, getBucketOptions());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.bucketCounts_.size(); i3++) {
            i2 += CodedOutputStream.computeInt64SizeNoTag(this.bucketCounts_.getLong(i3));
        }
        int size = computeInt64Size + i2 + (getBucketCountsList().size() * 1);
        this.c = size;
        return size;
    }

    @Override // com.google.api.DistributionOrBuilder
    public double getSumOfSquaredDeviation() {
        return this.sumOfSquaredDeviation_;
    }

    @Override // com.google.api.DistributionOrBuilder
    public boolean hasBucketOptions() {
        return this.bucketOptions_ != null;
    }

    @Override // com.google.api.DistributionOrBuilder
    public boolean hasRange() {
        return this.range_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        long j = this.count_;
        if (j != 0) {
            codedOutputStream.writeInt64(1, j);
        }
        double d = this.mean_;
        if (d != 0.0d) {
            codedOutputStream.writeDouble(2, d);
        }
        double d2 = this.sumOfSquaredDeviation_;
        if (d2 != 0.0d) {
            codedOutputStream.writeDouble(3, d2);
        }
        if (this.range_ != null) {
            codedOutputStream.writeMessage(4, getRange());
        }
        if (this.bucketOptions_ != null) {
            codedOutputStream.writeMessage(6, getBucketOptions());
        }
        for (int i = 0; i < this.bucketCounts_.size(); i++) {
            codedOutputStream.writeInt64(7, this.bucketCounts_.getLong(i));
        }
    }
}
