package com.google.api;

import com.google.api.MetricRule;
import com.google.api.QuotaLimit;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Quota extends GeneratedMessageLite<Quota, Builder> implements QuotaOrBuilder {
    private static final Quota DEFAULT_INSTANCE = new Quota();
    public static final int LIMITS_FIELD_NUMBER = 3;
    public static final int METRIC_RULES_FIELD_NUMBER = 4;
    private static volatile Parser<Quota> PARSER;
    private Internal.ProtobufList<QuotaLimit> limits_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<MetricRule> metricRules_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.Quota$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Quota, Builder> implements QuotaOrBuilder {
        private Builder() {
            super(Quota.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLimits(Iterable<? extends QuotaLimit> iterable) {
            a();
            ((Quota) this.a).addAllLimits(iterable);
            return this;
        }

        public Builder addAllMetricRules(Iterable<? extends MetricRule> iterable) {
            a();
            ((Quota) this.a).addAllMetricRules(iterable);
            return this;
        }

        public Builder addLimits(int i, QuotaLimit.Builder builder) {
            a();
            ((Quota) this.a).addLimits(i, builder);
            return this;
        }

        public Builder addLimits(int i, QuotaLimit quotaLimit) {
            a();
            ((Quota) this.a).addLimits(i, quotaLimit);
            return this;
        }

        public Builder addLimits(QuotaLimit.Builder builder) {
            a();
            ((Quota) this.a).addLimits(builder);
            return this;
        }

        public Builder addLimits(QuotaLimit quotaLimit) {
            a();
            ((Quota) this.a).addLimits(quotaLimit);
            return this;
        }

        public Builder addMetricRules(int i, MetricRule.Builder builder) {
            a();
            ((Quota) this.a).addMetricRules(i, builder);
            return this;
        }

        public Builder addMetricRules(int i, MetricRule metricRule) {
            a();
            ((Quota) this.a).addMetricRules(i, metricRule);
            return this;
        }

        public Builder addMetricRules(MetricRule.Builder builder) {
            a();
            ((Quota) this.a).addMetricRules(builder);
            return this;
        }

        public Builder addMetricRules(MetricRule metricRule) {
            a();
            ((Quota) this.a).addMetricRules(metricRule);
            return this;
        }

        public Builder clearLimits() {
            a();
            ((Quota) this.a).clearLimits();
            return this;
        }

        public Builder clearMetricRules() {
            a();
            ((Quota) this.a).clearMetricRules();
            return this;
        }

        @Override // com.google.api.QuotaOrBuilder
        public QuotaLimit getLimits(int i) {
            return ((Quota) this.a).getLimits(i);
        }

        @Override // com.google.api.QuotaOrBuilder
        public int getLimitsCount() {
            return ((Quota) this.a).getLimitsCount();
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<QuotaLimit> getLimitsList() {
            return Collections.unmodifiableList(((Quota) this.a).getLimitsList());
        }

        @Override // com.google.api.QuotaOrBuilder
        public MetricRule getMetricRules(int i) {
            return ((Quota) this.a).getMetricRules(i);
        }

        @Override // com.google.api.QuotaOrBuilder
        public int getMetricRulesCount() {
            return ((Quota) this.a).getMetricRulesCount();
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<MetricRule> getMetricRulesList() {
            return Collections.unmodifiableList(((Quota) this.a).getMetricRulesList());
        }

        public Builder removeLimits(int i) {
            a();
            ((Quota) this.a).removeLimits(i);
            return this;
        }

        public Builder removeMetricRules(int i) {
            a();
            ((Quota) this.a).removeMetricRules(i);
            return this;
        }

        public Builder setLimits(int i, QuotaLimit.Builder builder) {
            a();
            ((Quota) this.a).setLimits(i, builder);
            return this;
        }

        public Builder setLimits(int i, QuotaLimit quotaLimit) {
            a();
            ((Quota) this.a).setLimits(i, quotaLimit);
            return this;
        }

        public Builder setMetricRules(int i, MetricRule.Builder builder) {
            a();
            ((Quota) this.a).setMetricRules(i, builder);
            return this;
        }

        public Builder setMetricRules(int i, MetricRule metricRule) {
            a();
            ((Quota) this.a).setMetricRules(i, metricRule);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Quota() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLimits(Iterable<? extends QuotaLimit> iterable) {
        ensureLimitsIsMutable();
        AbstractMessageLite.a(iterable, this.limits_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMetricRules(Iterable<? extends MetricRule> iterable) {
        ensureMetricRulesIsMutable();
        AbstractMessageLite.a(iterable, this.metricRules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLimits(int i, QuotaLimit.Builder builder) {
        ensureLimitsIsMutable();
        this.limits_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLimits(int i, QuotaLimit quotaLimit) {
        if (quotaLimit == null) {
            throw new NullPointerException();
        }
        ensureLimitsIsMutable();
        this.limits_.add(i, quotaLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLimits(QuotaLimit.Builder builder) {
        ensureLimitsIsMutable();
        this.limits_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLimits(QuotaLimit quotaLimit) {
        if (quotaLimit == null) {
            throw new NullPointerException();
        }
        ensureLimitsIsMutable();
        this.limits_.add(quotaLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetricRules(int i, MetricRule.Builder builder) {
        ensureMetricRulesIsMutable();
        this.metricRules_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetricRules(int i, MetricRule metricRule) {
        if (metricRule == null) {
            throw new NullPointerException();
        }
        ensureMetricRulesIsMutable();
        this.metricRules_.add(i, metricRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetricRules(MetricRule.Builder builder) {
        ensureMetricRulesIsMutable();
        this.metricRules_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetricRules(MetricRule metricRule) {
        if (metricRule == null) {
            throw new NullPointerException();
        }
        ensureMetricRulesIsMutable();
        this.metricRules_.add(metricRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLimits() {
        this.limits_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetricRules() {
        this.metricRules_ = GeneratedMessageLite.f();
    }

    private void ensureLimitsIsMutable() {
        if (this.limits_.isModifiable()) {
            return;
        }
        this.limits_ = GeneratedMessageLite.a(this.limits_);
    }

    private void ensureMetricRulesIsMutable() {
        if (this.metricRules_.isModifiable()) {
            return;
        }
        this.metricRules_ = GeneratedMessageLite.a(this.metricRules_);
    }

    public static Quota getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Quota quota) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) quota);
    }

    public static Quota parseDelimitedFrom(InputStream inputStream) {
        return (Quota) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Quota parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Quota) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(ByteString byteString) {
        return (Quota) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Quota parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Quota) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Quota parseFrom(CodedInputStream codedInputStream) {
        return (Quota) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Quota parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Quota) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(InputStream inputStream) {
        return (Quota) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Quota parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Quota) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(byte[] bArr) {
        return (Quota) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Quota parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Quota) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Quota> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLimits(int i) {
        ensureLimitsIsMutable();
        this.limits_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMetricRules(int i) {
        ensureMetricRulesIsMutable();
        this.metricRules_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimits(int i, QuotaLimit.Builder builder) {
        ensureLimitsIsMutable();
        this.limits_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimits(int i, QuotaLimit quotaLimit) {
        if (quotaLimit == null) {
            throw new NullPointerException();
        }
        ensureLimitsIsMutable();
        this.limits_.set(i, quotaLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricRules(int i, MetricRule.Builder builder) {
        ensureMetricRulesIsMutable();
        this.metricRules_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricRules(int i, MetricRule metricRule) {
        if (metricRule == null) {
            throw new NullPointerException();
        }
        ensureMetricRulesIsMutable();
        this.metricRules_.set(i, metricRule);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        List list;
        MessageLite messageLite;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Quota();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.limits_.makeImmutable();
                this.metricRules_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Quota quota = (Quota) obj2;
                this.limits_ = visitor.visitList(this.limits_, quota.limits_);
                this.metricRules_ = visitor.visitList(this.metricRules_, quota.metricRules_);
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
                            if (readTag == 26) {
                                if (!this.limits_.isModifiable()) {
                                    this.limits_ = GeneratedMessageLite.a(this.limits_);
                                }
                                list = this.limits_;
                                messageLite = (QuotaLimit) codedInputStream.readMessage(QuotaLimit.parser(), extensionRegistryLite);
                            } else if (readTag == 34) {
                                if (!this.metricRules_.isModifiable()) {
                                    this.metricRules_ = GeneratedMessageLite.a(this.metricRules_);
                                }
                                list = this.metricRules_;
                                messageLite = (MetricRule) codedInputStream.readMessage(MetricRule.parser(), extensionRegistryLite);
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                            list.add(messageLite);
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
                    synchronized (Quota.class) {
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

    @Override // com.google.api.QuotaOrBuilder
    public QuotaLimit getLimits(int i) {
        return this.limits_.get(i);
    }

    @Override // com.google.api.QuotaOrBuilder
    public int getLimitsCount() {
        return this.limits_.size();
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<QuotaLimit> getLimitsList() {
        return this.limits_;
    }

    public QuotaLimitOrBuilder getLimitsOrBuilder(int i) {
        return this.limits_.get(i);
    }

    public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
        return this.limits_;
    }

    @Override // com.google.api.QuotaOrBuilder
    public MetricRule getMetricRules(int i) {
        return this.metricRules_.get(i);
    }

    @Override // com.google.api.QuotaOrBuilder
    public int getMetricRulesCount() {
        return this.metricRules_.size();
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<MetricRule> getMetricRulesList() {
        return this.metricRules_;
    }

    public MetricRuleOrBuilder getMetricRulesOrBuilder(int i) {
        return this.metricRules_.get(i);
    }

    public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
        return this.metricRules_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.limits_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(3, this.limits_.get(i3));
        }
        for (int i4 = 0; i4 < this.metricRules_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(4, this.metricRules_.get(i4));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.limits_.size(); i++) {
            codedOutputStream.writeMessage(3, this.limits_.get(i));
        }
        for (int i2 = 0; i2 < this.metricRules_.size(); i2++) {
            codedOutputStream.writeMessage(4, this.metricRules_.get(i2));
        }
    }
}
