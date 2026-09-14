package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class Mixin extends GeneratedMessageLite<Mixin, Builder> implements MixinOrBuilder {
    private static final Mixin DEFAULT_INSTANCE = new Mixin();
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Mixin> PARSER = null;
    public static final int ROOT_FIELD_NUMBER = 2;
    private String name_ = "";
    private String root_ = "";

    /* renamed from: com.google.protobuf.Mixin$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Mixin, Builder> implements MixinOrBuilder {
        private Builder() {
            super(Mixin.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearName() {
            a();
            ((Mixin) this.a).clearName();
            return this;
        }

        public Builder clearRoot() {
            a();
            ((Mixin) this.a).clearRoot();
            return this;
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public String getName() {
            return ((Mixin) this.a).getName();
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public ByteString getNameBytes() {
            return ((Mixin) this.a).getNameBytes();
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public String getRoot() {
            return ((Mixin) this.a).getRoot();
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public ByteString getRootBytes() {
            return ((Mixin) this.a).getRootBytes();
        }

        public Builder setName(String str) {
            a();
            ((Mixin) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Mixin) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setRoot(String str) {
            a();
            ((Mixin) this.a).setRoot(str);
            return this;
        }

        public Builder setRootBytes(ByteString byteString) {
            a();
            ((Mixin) this.a).setRootBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Mixin() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoot() {
        this.root_ = getDefaultInstance().getRoot();
    }

    public static Mixin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Mixin mixin) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) mixin);
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream) {
        return (Mixin) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Mixin parseFrom(ByteString byteString) {
        return (Mixin) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Mixin parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Mixin parseFrom(CodedInputStream codedInputStream) {
        return (Mixin) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Mixin parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Mixin parseFrom(InputStream inputStream) {
        return (Mixin) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Mixin parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Mixin parseFrom(byte[] bArr) {
        return (Mixin) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Mixin parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Mixin> parser() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoot(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.root_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRootBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.root_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Mixin();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Mixin mixin = (Mixin) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !mixin.name_.isEmpty(), mixin.name_);
                this.root_ = visitor.visitString(!this.root_.isEmpty(), this.root_, true ^ mixin.root_.isEmpty(), mixin.root_);
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
                            } else if (readTag == 18) {
                                this.root_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (Mixin.class) {
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

    @Override // com.google.protobuf.MixinOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public String getRoot() {
        return this.root_;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public ByteString getRootBytes() {
        return ByteString.copyFromUtf8(this.root_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.name_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getName());
        if (!this.root_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getRoot());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (this.root_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getRoot());
    }
}
