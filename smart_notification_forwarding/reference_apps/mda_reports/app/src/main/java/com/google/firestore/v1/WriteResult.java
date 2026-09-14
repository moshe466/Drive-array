package com.google.firestore.v1;

import com.google.firestore.v1.Value;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class WriteResult extends GeneratedMessageLite<WriteResult, Builder> implements WriteResultOrBuilder {
    private static final WriteResult DEFAULT_INSTANCE = new WriteResult();
    private static volatile Parser<WriteResult> PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private int bitField0_;
    private Internal.ProtobufList<Value> transformResults_ = GeneratedMessageLite.f();
    private Timestamp updateTime_;

    /* renamed from: com.google.firestore.v1.WriteResult$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<WriteResult, Builder> implements WriteResultOrBuilder {
        private Builder() {
            super(WriteResult.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTransformResults(Iterable<? extends Value> iterable) {
            a();
            ((WriteResult) this.a).addAllTransformResults(iterable);
            return this;
        }

        public Builder addTransformResults(int i, Value.Builder builder) {
            a();
            ((WriteResult) this.a).addTransformResults(i, builder);
            return this;
        }

        public Builder addTransformResults(int i, Value value) {
            a();
            ((WriteResult) this.a).addTransformResults(i, value);
            return this;
        }

        public Builder addTransformResults(Value.Builder builder) {
            a();
            ((WriteResult) this.a).addTransformResults(builder);
            return this;
        }

        public Builder addTransformResults(Value value) {
            a();
            ((WriteResult) this.a).addTransformResults(value);
            return this;
        }

        public Builder clearTransformResults() {
            a();
            ((WriteResult) this.a).clearTransformResults();
            return this;
        }

        public Builder clearUpdateTime() {
            a();
            ((WriteResult) this.a).clearUpdateTime();
            return this;
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public Value getTransformResults(int i) {
            return ((WriteResult) this.a).getTransformResults(i);
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public int getTransformResultsCount() {
            return ((WriteResult) this.a).getTransformResultsCount();
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public List<Value> getTransformResultsList() {
            return Collections.unmodifiableList(((WriteResult) this.a).getTransformResultsList());
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public Timestamp getUpdateTime() {
            return ((WriteResult) this.a).getUpdateTime();
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public boolean hasUpdateTime() {
            return ((WriteResult) this.a).hasUpdateTime();
        }

        public Builder mergeUpdateTime(Timestamp timestamp) {
            a();
            ((WriteResult) this.a).mergeUpdateTime(timestamp);
            return this;
        }

        public Builder removeTransformResults(int i) {
            a();
            ((WriteResult) this.a).removeTransformResults(i);
            return this;
        }

        public Builder setTransformResults(int i, Value.Builder builder) {
            a();
            ((WriteResult) this.a).setTransformResults(i, builder);
            return this;
        }

        public Builder setTransformResults(int i, Value value) {
            a();
            ((WriteResult) this.a).setTransformResults(i, value);
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builder) {
            a();
            ((WriteResult) this.a).setUpdateTime(builder);
            return this;
        }

        public Builder setUpdateTime(Timestamp timestamp) {
            a();
            ((WriteResult) this.a).setUpdateTime(timestamp);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private WriteResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTransformResults(Iterable<? extends Value> iterable) {
        ensureTransformResultsIsMutable();
        AbstractMessageLite.a(iterable, this.transformResults_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTransformResults(int i, Value.Builder builder) {
        ensureTransformResultsIsMutable();
        this.transformResults_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTransformResults(int i, Value value) {
        if (value == null) {
            throw new NullPointerException();
        }
        ensureTransformResultsIsMutable();
        this.transformResults_.add(i, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTransformResults(Value.Builder builder) {
        ensureTransformResultsIsMutable();
        this.transformResults_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTransformResults(Value value) {
        if (value == null) {
            throw new NullPointerException();
        }
        ensureTransformResultsIsMutable();
        this.transformResults_.add(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransformResults() {
        this.transformResults_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateTime() {
        this.updateTime_ = null;
    }

    private void ensureTransformResultsIsMutable() {
        if (this.transformResults_.isModifiable()) {
            return;
        }
        this.transformResults_ = GeneratedMessageLite.a(this.transformResults_);
    }

    public static WriteResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.updateTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.updateTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.updateTime_ = timestamp;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteResult writeResult) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) writeResult);
    }

    public static WriteResult parseDelimitedFrom(InputStream inputStream) {
        return (WriteResult) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResult) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResult parseFrom(ByteString byteString) {
        return (WriteResult) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static WriteResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResult) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteResult parseFrom(CodedInputStream codedInputStream) {
        return (WriteResult) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResult) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static WriteResult parseFrom(InputStream inputStream) {
        return (WriteResult) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResult) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResult parseFrom(byte[] bArr) {
        return (WriteResult) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static WriteResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteResult) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<WriteResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTransformResults(int i) {
        ensureTransformResultsIsMutable();
        this.transformResults_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransformResults(int i, Value.Builder builder) {
        ensureTransformResultsIsMutable();
        this.transformResults_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransformResults(int i, Value value) {
        if (value == null) {
            throw new NullPointerException();
        }
        ensureTransformResultsIsMutable();
        this.transformResults_.set(i, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateTime(Timestamp.Builder builder) {
        this.updateTime_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.updateTime_ = timestamp;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new WriteResult();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.transformResults_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                WriteResult writeResult = (WriteResult) obj2;
                this.updateTime_ = (Timestamp) visitor.visitMessage(this.updateTime_, writeResult.updateTime_);
                this.transformResults_ = visitor.visitList(this.transformResults_, writeResult.transformResults_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= writeResult.bitField0_;
                }
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
                                Timestamp.Builder builder = this.updateTime_ != null ? this.updateTime_.toBuilder() : null;
                                this.updateTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Timestamp.Builder) this.updateTime_);
                                    this.updateTime_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                if (!this.transformResults_.isModifiable()) {
                                    this.transformResults_ = GeneratedMessageLite.a(this.transformResults_);
                                }
                                this.transformResults_.add((Value) codedInputStream.readMessage(Value.parser(), extensionRegistryLite));
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
                    synchronized (WriteResult.class) {
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
        int computeMessageSize = this.updateTime_ != null ? CodedOutputStream.computeMessageSize(1, getUpdateTime()) + 0 : 0;
        for (int i2 = 0; i2 < this.transformResults_.size(); i2++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, this.transformResults_.get(i2));
        }
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public Value getTransformResults(int i) {
        return this.transformResults_.get(i);
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public int getTransformResultsCount() {
        return this.transformResults_.size();
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public List<Value> getTransformResultsList() {
        return this.transformResults_;
    }

    public ValueOrBuilder getTransformResultsOrBuilder(int i) {
        return this.transformResults_.get(i);
    }

    public List<? extends ValueOrBuilder> getTransformResultsOrBuilderList() {
        return this.transformResults_;
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public Timestamp getUpdateTime() {
        Timestamp timestamp = this.updateTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public boolean hasUpdateTime() {
        return this.updateTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.updateTime_ != null) {
            codedOutputStream.writeMessage(1, getUpdateTime());
        }
        for (int i = 0; i < this.transformResults_.size(); i++) {
            codedOutputStream.writeMessage(2, this.transformResults_.get(i));
        }
    }
}
