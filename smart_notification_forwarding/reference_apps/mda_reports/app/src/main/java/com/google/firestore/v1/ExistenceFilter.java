package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class ExistenceFilter extends GeneratedMessageLite<ExistenceFilter, Builder> implements ExistenceFilterOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final ExistenceFilter DEFAULT_INSTANCE = new ExistenceFilter();
    private static volatile Parser<ExistenceFilter> PARSER = null;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private int count_;
    private int targetId_;

    /* renamed from: com.google.firestore.v1.ExistenceFilter$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ExistenceFilter, Builder> implements ExistenceFilterOrBuilder {
        private Builder() {
            super(ExistenceFilter.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCount() {
            a();
            ((ExistenceFilter) this.a).clearCount();
            return this;
        }

        public Builder clearTargetId() {
            a();
            ((ExistenceFilter) this.a).clearTargetId();
            return this;
        }

        @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
        public int getCount() {
            return ((ExistenceFilter) this.a).getCount();
        }

        @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
        public int getTargetId() {
            return ((ExistenceFilter) this.a).getTargetId();
        }

        public Builder setCount(int i) {
            a();
            ((ExistenceFilter) this.a).setCount(i);
            return this;
        }

        public Builder setTargetId(int i) {
            a();
            ((ExistenceFilter) this.a).setTargetId(i);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ExistenceFilter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCount() {
        this.count_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetId() {
        this.targetId_ = 0;
    }

    public static ExistenceFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ExistenceFilter existenceFilter) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) existenceFilter);
    }

    public static ExistenceFilter parseDelimitedFrom(InputStream inputStream) {
        return (ExistenceFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ExistenceFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExistenceFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(ByteString byteString) {
        return (ExistenceFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ExistenceFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ExistenceFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(CodedInputStream codedInputStream) {
        return (ExistenceFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ExistenceFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExistenceFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(InputStream inputStream) {
        return (ExistenceFilter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ExistenceFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExistenceFilter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(byte[] bArr) {
        return (ExistenceFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ExistenceFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ExistenceFilter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ExistenceFilter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCount(int i) {
        this.count_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetId(int i) {
        this.targetId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ExistenceFilter();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ExistenceFilter existenceFilter = (ExistenceFilter) obj2;
                this.targetId_ = visitor.visitInt(this.targetId_ != 0, this.targetId_, existenceFilter.targetId_ != 0, existenceFilter.targetId_);
                this.count_ = visitor.visitInt(this.count_ != 0, this.count_, existenceFilter.count_ != 0, existenceFilter.count_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.targetId_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
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
                    synchronized (ExistenceFilter.class) {
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

    @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
    public int getCount() {
        return this.count_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.targetId_;
        int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
        int i3 = this.count_;
        if (i3 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
        }
        this.c = computeInt32Size;
        return computeInt32Size;
    }

    @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
    public int getTargetId() {
        return this.targetId_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.targetId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        int i2 = this.count_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(2, i2);
        }
    }
}
