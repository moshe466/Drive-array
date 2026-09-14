package com.google.rpc;

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
public final class LocalizedMessage extends GeneratedMessageLite<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
    private static final LocalizedMessage DEFAULT_INSTANCE = new LocalizedMessage();
    public static final int LOCALE_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<LocalizedMessage> PARSER;
    private String locale_ = "";
    private String message_ = "";

    /* renamed from: com.google.rpc.LocalizedMessage$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
        private Builder() {
            super(LocalizedMessage.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearLocale() {
            a();
            ((LocalizedMessage) this.a).clearLocale();
            return this;
        }

        public Builder clearMessage() {
            a();
            ((LocalizedMessage) this.a).clearMessage();
            return this;
        }

        @Override // com.google.rpc.LocalizedMessageOrBuilder
        public String getLocale() {
            return ((LocalizedMessage) this.a).getLocale();
        }

        @Override // com.google.rpc.LocalizedMessageOrBuilder
        public ByteString getLocaleBytes() {
            return ((LocalizedMessage) this.a).getLocaleBytes();
        }

        @Override // com.google.rpc.LocalizedMessageOrBuilder
        public String getMessage() {
            return ((LocalizedMessage) this.a).getMessage();
        }

        @Override // com.google.rpc.LocalizedMessageOrBuilder
        public ByteString getMessageBytes() {
            return ((LocalizedMessage) this.a).getMessageBytes();
        }

        public Builder setLocale(String str) {
            a();
            ((LocalizedMessage) this.a).setLocale(str);
            return this;
        }

        public Builder setLocaleBytes(ByteString byteString) {
            a();
            ((LocalizedMessage) this.a).setLocaleBytes(byteString);
            return this;
        }

        public Builder setMessage(String str) {
            a();
            ((LocalizedMessage) this.a).setMessage(str);
            return this;
        }

        public Builder setMessageBytes(ByteString byteString) {
            a();
            ((LocalizedMessage) this.a).setMessageBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private LocalizedMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocale() {
        this.locale_ = getDefaultInstance().getLocale();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    public static LocalizedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LocalizedMessage localizedMessage) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) localizedMessage);
    }

    public static LocalizedMessage parseDelimitedFrom(InputStream inputStream) {
        return (LocalizedMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalizedMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocalizedMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocalizedMessage parseFrom(ByteString byteString) {
        return (LocalizedMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static LocalizedMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LocalizedMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LocalizedMessage parseFrom(CodedInputStream codedInputStream) {
        return (LocalizedMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static LocalizedMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocalizedMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LocalizedMessage parseFrom(InputStream inputStream) {
        return (LocalizedMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalizedMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocalizedMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocalizedMessage parseFrom(byte[] bArr) {
        return (LocalizedMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static LocalizedMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (LocalizedMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<LocalizedMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocale(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.locale_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocaleBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.locale_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.message_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new LocalizedMessage();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                LocalizedMessage localizedMessage = (LocalizedMessage) obj2;
                this.locale_ = visitor.visitString(!this.locale_.isEmpty(), this.locale_, !localizedMessage.locale_.isEmpty(), localizedMessage.locale_);
                this.message_ = visitor.visitString(!this.message_.isEmpty(), this.message_, true ^ localizedMessage.message_.isEmpty(), localizedMessage.message_);
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
                                this.locale_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.message_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (LocalizedMessage.class) {
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

    @Override // com.google.rpc.LocalizedMessageOrBuilder
    public String getLocale() {
        return this.locale_;
    }

    @Override // com.google.rpc.LocalizedMessageOrBuilder
    public ByteString getLocaleBytes() {
        return ByteString.copyFromUtf8(this.locale_);
    }

    @Override // com.google.rpc.LocalizedMessageOrBuilder
    public String getMessage() {
        return this.message_;
    }

    @Override // com.google.rpc.LocalizedMessageOrBuilder
    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.locale_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getLocale());
        if (!this.message_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getMessage());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.locale_.isEmpty()) {
            codedOutputStream.writeString(1, getLocale());
        }
        if (this.message_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getMessage());
    }
}
