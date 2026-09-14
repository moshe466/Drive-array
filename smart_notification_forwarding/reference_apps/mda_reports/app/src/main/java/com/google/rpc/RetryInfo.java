package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class RetryInfo extends GeneratedMessageLite<RetryInfo, Builder> implements RetryInfoOrBuilder {
    private static final RetryInfo DEFAULT_INSTANCE = new RetryInfo();
    private static volatile Parser<RetryInfo> PARSER = null;
    public static final int RETRY_DELAY_FIELD_NUMBER = 1;
    private Duration retryDelay_;

    /* renamed from: com.google.rpc.RetryInfo$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<RetryInfo, Builder> implements RetryInfoOrBuilder {
        private Builder() {
            super(RetryInfo.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRetryDelay() {
            a();
            ((RetryInfo) this.a).clearRetryDelay();
            return this;
        }

        @Override // com.google.rpc.RetryInfoOrBuilder
        public Duration getRetryDelay() {
            return ((RetryInfo) this.a).getRetryDelay();
        }

        @Override // com.google.rpc.RetryInfoOrBuilder
        public boolean hasRetryDelay() {
            return ((RetryInfo) this.a).hasRetryDelay();
        }

        public Builder mergeRetryDelay(Duration duration) {
            a();
            ((RetryInfo) this.a).mergeRetryDelay(duration);
            return this;
        }

        public Builder setRetryDelay(Duration.Builder builder) {
            a();
            ((RetryInfo) this.a).setRetryDelay(builder);
            return this;
        }

        public Builder setRetryDelay(Duration duration) {
            a();
            ((RetryInfo) this.a).setRetryDelay(duration);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private RetryInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetryDelay() {
        this.retryDelay_ = null;
    }

    public static RetryInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRetryDelay(Duration duration) {
        Duration duration2 = this.retryDelay_;
        if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
            duration = Duration.newBuilder(this.retryDelay_).mergeFrom((Duration.Builder) duration).buildPartial();
        }
        this.retryDelay_ = duration;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RetryInfo retryInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) retryInfo);
    }

    public static RetryInfo parseDelimitedFrom(InputStream inputStream) {
        return (RetryInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static RetryInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RetryInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RetryInfo parseFrom(ByteString byteString) {
        return (RetryInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static RetryInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RetryInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RetryInfo parseFrom(CodedInputStream codedInputStream) {
        return (RetryInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RetryInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RetryInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static RetryInfo parseFrom(InputStream inputStream) {
        return (RetryInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static RetryInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RetryInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RetryInfo parseFrom(byte[] bArr) {
        return (RetryInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static RetryInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RetryInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<RetryInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetryDelay(Duration.Builder builder) {
        this.retryDelay_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetryDelay(Duration duration) {
        if (duration == null) {
            throw new NullPointerException();
        }
        this.retryDelay_ = duration;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new RetryInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.retryDelay_ = (Duration) ((GeneratedMessageLite.Visitor) obj).visitMessage(this.retryDelay_, ((RetryInfo) obj2).retryDelay_);
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
                                if (readTag == 10) {
                                    Duration.Builder builder = this.retryDelay_ != null ? this.retryDelay_.toBuilder() : null;
                                    this.retryDelay_ = (Duration) codedInputStream.readMessage(Duration.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Duration.Builder) this.retryDelay_);
                                        this.retryDelay_ = builder.buildPartial();
                                    }
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (RetryInfo.class) {
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

    @Override // com.google.rpc.RetryInfoOrBuilder
    public Duration getRetryDelay() {
        Duration duration = this.retryDelay_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.retryDelay_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getRetryDelay()) : 0;
        this.c = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.google.rpc.RetryInfoOrBuilder
    public boolean hasRetryDelay() {
        return this.retryDelay_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.retryDelay_ != null) {
            codedOutputStream.writeMessage(1, getRetryDelay());
        }
    }
}
