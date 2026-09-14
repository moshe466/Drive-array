package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Status extends GeneratedMessageLite<Status, Builder> implements StatusOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final Status DEFAULT_INSTANCE = new Status();
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<Status> PARSER;
    private int bitField0_;
    private int code_;
    private String message_ = "";
    private Internal.ProtobufList<Any> details_ = GeneratedMessageLite.f();

    /* renamed from: com.google.rpc.Status$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Status, Builder> implements StatusOrBuilder {
        private Builder() {
            super(Status.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllDetails(Iterable<? extends Any> iterable) {
            a();
            ((Status) this.a).addAllDetails(iterable);
            return this;
        }

        public Builder addDetails(int i, Any.Builder builder) {
            a();
            ((Status) this.a).addDetails(i, builder);
            return this;
        }

        public Builder addDetails(int i, Any any) {
            a();
            ((Status) this.a).addDetails(i, any);
            return this;
        }

        public Builder addDetails(Any.Builder builder) {
            a();
            ((Status) this.a).addDetails(builder);
            return this;
        }

        public Builder addDetails(Any any) {
            a();
            ((Status) this.a).addDetails(any);
            return this;
        }

        public Builder clearCode() {
            a();
            ((Status) this.a).clearCode();
            return this;
        }

        public Builder clearDetails() {
            a();
            ((Status) this.a).clearDetails();
            return this;
        }

        public Builder clearMessage() {
            a();
            ((Status) this.a).clearMessage();
            return this;
        }

        @Override // com.google.rpc.StatusOrBuilder
        public int getCode() {
            return ((Status) this.a).getCode();
        }

        @Override // com.google.rpc.StatusOrBuilder
        public Any getDetails(int i) {
            return ((Status) this.a).getDetails(i);
        }

        @Override // com.google.rpc.StatusOrBuilder
        public int getDetailsCount() {
            return ((Status) this.a).getDetailsCount();
        }

        @Override // com.google.rpc.StatusOrBuilder
        public List<Any> getDetailsList() {
            return Collections.unmodifiableList(((Status) this.a).getDetailsList());
        }

        @Override // com.google.rpc.StatusOrBuilder
        public String getMessage() {
            return ((Status) this.a).getMessage();
        }

        @Override // com.google.rpc.StatusOrBuilder
        public ByteString getMessageBytes() {
            return ((Status) this.a).getMessageBytes();
        }

        public Builder removeDetails(int i) {
            a();
            ((Status) this.a).removeDetails(i);
            return this;
        }

        public Builder setCode(int i) {
            a();
            ((Status) this.a).setCode(i);
            return this;
        }

        public Builder setDetails(int i, Any.Builder builder) {
            a();
            ((Status) this.a).setDetails(i, builder);
            return this;
        }

        public Builder setDetails(int i, Any any) {
            a();
            ((Status) this.a).setDetails(i, any);
            return this;
        }

        public Builder setMessage(String str) {
            a();
            ((Status) this.a).setMessage(str);
            return this;
        }

        public Builder setMessageBytes(ByteString byteString) {
            a();
            ((Status) this.a).setMessageBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Status() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDetails(Iterable<? extends Any> iterable) {
        ensureDetailsIsMutable();
        AbstractMessageLite.a(iterable, this.details_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDetails(int i, Any.Builder builder) {
        ensureDetailsIsMutable();
        this.details_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDetails(int i, Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        ensureDetailsIsMutable();
        this.details_.add(i, any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDetails(Any.Builder builder) {
        ensureDetailsIsMutable();
        this.details_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDetails(Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        ensureDetailsIsMutable();
        this.details_.add(any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDetails() {
        this.details_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    private void ensureDetailsIsMutable() {
        if (this.details_.isModifiable()) {
            return;
        }
        this.details_ = GeneratedMessageLite.a(this.details_);
    }

    public static Status getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Status status) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) status);
    }

    public static Status parseDelimitedFrom(InputStream inputStream) {
        return (Status) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Status parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Status) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Status parseFrom(ByteString byteString) {
        return (Status) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Status parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Status) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Status parseFrom(CodedInputStream codedInputStream) {
        return (Status) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Status parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Status) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Status parseFrom(InputStream inputStream) {
        return (Status) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Status parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Status) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Status parseFrom(byte[] bArr) {
        return (Status) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Status parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Status) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Status> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDetails(int i) {
        ensureDetailsIsMutable();
        this.details_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(int i) {
        this.code_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetails(int i, Any.Builder builder) {
        ensureDetailsIsMutable();
        this.details_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetails(int i, Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        ensureDetailsIsMutable();
        this.details_.set(i, any);
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
                return new Status();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.details_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Status status = (Status) obj2;
                this.code_ = visitor.visitInt(this.code_ != 0, this.code_, status.code_ != 0, status.code_);
                this.message_ = visitor.visitString(!this.message_.isEmpty(), this.message_, !status.message_.isEmpty(), status.message_);
                this.details_ = visitor.visitList(this.details_, status.details_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= status.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.code_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.message_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                if (!this.details_.isModifiable()) {
                                    this.details_ = GeneratedMessageLite.a(this.details_);
                                }
                                this.details_.add((Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite));
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
                    synchronized (Status.class) {
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

    @Override // com.google.rpc.StatusOrBuilder
    public int getCode() {
        return this.code_;
    }

    @Override // com.google.rpc.StatusOrBuilder
    public Any getDetails(int i) {
        return this.details_.get(i);
    }

    @Override // com.google.rpc.StatusOrBuilder
    public int getDetailsCount() {
        return this.details_.size();
    }

    @Override // com.google.rpc.StatusOrBuilder
    public List<Any> getDetailsList() {
        return this.details_;
    }

    public AnyOrBuilder getDetailsOrBuilder(int i) {
        return this.details_.get(i);
    }

    public List<? extends AnyOrBuilder> getDetailsOrBuilderList() {
        return this.details_;
    }

    @Override // com.google.rpc.StatusOrBuilder
    public String getMessage() {
        return this.message_;
    }

    @Override // com.google.rpc.StatusOrBuilder
    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.code_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        if (!this.message_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(2, getMessage());
        }
        for (int i3 = 0; i3 < this.details_.size(); i3++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, this.details_.get(i3));
        }
        this.c = computeInt32Size;
        return computeInt32Size;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.code_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (!this.message_.isEmpty()) {
            codedOutputStream.writeString(2, getMessage());
        }
        for (int i2 = 0; i2 < this.details_.size(); i2++) {
            codedOutputStream.writeMessage(3, this.details_.get(i2));
        }
    }
}
