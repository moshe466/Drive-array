package com.google.api;

import com.google.protobuf.AbstractMessageLite;
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
public final class CustomHttpPattern extends GeneratedMessageLite<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
    private static final CustomHttpPattern DEFAULT_INSTANCE = new CustomHttpPattern();
    public static final int KIND_FIELD_NUMBER = 1;
    private static volatile Parser<CustomHttpPattern> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 2;
    private String kind_ = "";
    private String path_ = "";

    /* renamed from: com.google.api.CustomHttpPattern$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
        private Builder() {
            super(CustomHttpPattern.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearKind() {
            a();
            ((CustomHttpPattern) this.a).clearKind();
            return this;
        }

        public Builder clearPath() {
            a();
            ((CustomHttpPattern) this.a).clearPath();
            return this;
        }

        @Override // com.google.api.CustomHttpPatternOrBuilder
        public String getKind() {
            return ((CustomHttpPattern) this.a).getKind();
        }

        @Override // com.google.api.CustomHttpPatternOrBuilder
        public ByteString getKindBytes() {
            return ((CustomHttpPattern) this.a).getKindBytes();
        }

        @Override // com.google.api.CustomHttpPatternOrBuilder
        public String getPath() {
            return ((CustomHttpPattern) this.a).getPath();
        }

        @Override // com.google.api.CustomHttpPatternOrBuilder
        public ByteString getPathBytes() {
            return ((CustomHttpPattern) this.a).getPathBytes();
        }

        public Builder setKind(String str) {
            a();
            ((CustomHttpPattern) this.a).setKind(str);
            return this;
        }

        public Builder setKindBytes(ByteString byteString) {
            a();
            ((CustomHttpPattern) this.a).setKindBytes(byteString);
            return this;
        }

        public Builder setPath(String str) {
            a();
            ((CustomHttpPattern) this.a).setPath(str);
            return this;
        }

        public Builder setPathBytes(ByteString byteString) {
            a();
            ((CustomHttpPattern) this.a).setPathBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private CustomHttpPattern() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = getDefaultInstance().getKind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPath() {
        this.path_ = getDefaultInstance().getPath();
    }

    public static CustomHttpPattern getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CustomHttpPattern customHttpPattern) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) customHttpPattern);
    }

    public static CustomHttpPattern parseDelimitedFrom(InputStream inputStream) {
        return (CustomHttpPattern) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static CustomHttpPattern parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CustomHttpPattern) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CustomHttpPattern parseFrom(ByteString byteString) {
        return (CustomHttpPattern) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static CustomHttpPattern parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CustomHttpPattern) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CustomHttpPattern parseFrom(CodedInputStream codedInputStream) {
        return (CustomHttpPattern) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CustomHttpPattern parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CustomHttpPattern) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CustomHttpPattern parseFrom(InputStream inputStream) {
        return (CustomHttpPattern) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static CustomHttpPattern parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CustomHttpPattern) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CustomHttpPattern parseFrom(byte[] bArr) {
        return (CustomHttpPattern) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static CustomHttpPattern parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CustomHttpPattern) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<CustomHttpPattern> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.kind_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.kind_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPath(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.path_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.path_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new CustomHttpPattern();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CustomHttpPattern customHttpPattern = (CustomHttpPattern) obj2;
                this.kind_ = visitor.visitString(!this.kind_.isEmpty(), this.kind_, !customHttpPattern.kind_.isEmpty(), customHttpPattern.kind_);
                this.path_ = visitor.visitString(!this.path_.isEmpty(), this.path_, true ^ customHttpPattern.path_.isEmpty(), customHttpPattern.path_);
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
                                this.kind_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.path_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (CustomHttpPattern.class) {
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

    @Override // com.google.api.CustomHttpPatternOrBuilder
    public String getKind() {
        return this.kind_;
    }

    @Override // com.google.api.CustomHttpPatternOrBuilder
    public ByteString getKindBytes() {
        return ByteString.copyFromUtf8(this.kind_);
    }

    @Override // com.google.api.CustomHttpPatternOrBuilder
    public String getPath() {
        return this.path_;
    }

    @Override // com.google.api.CustomHttpPatternOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.kind_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getKind());
        if (!this.path_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getPath());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.kind_.isEmpty()) {
            codedOutputStream.writeString(1, getKind());
        }
        if (this.path_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getPath());
    }
}
