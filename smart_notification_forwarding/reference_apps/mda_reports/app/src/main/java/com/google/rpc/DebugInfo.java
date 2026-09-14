package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
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
public final class DebugInfo extends GeneratedMessageLite<DebugInfo, Builder> implements DebugInfoOrBuilder {
    private static final DebugInfo DEFAULT_INSTANCE = new DebugInfo();
    public static final int DETAIL_FIELD_NUMBER = 2;
    private static volatile Parser<DebugInfo> PARSER = null;
    public static final int STACK_ENTRIES_FIELD_NUMBER = 1;
    private int bitField0_;
    private Internal.ProtobufList<String> stackEntries_ = GeneratedMessageLite.f();
    private String detail_ = "";

    /* renamed from: com.google.rpc.DebugInfo$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<DebugInfo, Builder> implements DebugInfoOrBuilder {
        private Builder() {
            super(DebugInfo.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllStackEntries(Iterable<String> iterable) {
            a();
            ((DebugInfo) this.a).addAllStackEntries(iterable);
            return this;
        }

        public Builder addStackEntries(String str) {
            a();
            ((DebugInfo) this.a).addStackEntries(str);
            return this;
        }

        public Builder addStackEntriesBytes(ByteString byteString) {
            a();
            ((DebugInfo) this.a).addStackEntriesBytes(byteString);
            return this;
        }

        public Builder clearDetail() {
            a();
            ((DebugInfo) this.a).clearDetail();
            return this;
        }

        public Builder clearStackEntries() {
            a();
            ((DebugInfo) this.a).clearStackEntries();
            return this;
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public String getDetail() {
            return ((DebugInfo) this.a).getDetail();
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public ByteString getDetailBytes() {
            return ((DebugInfo) this.a).getDetailBytes();
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public String getStackEntries(int i) {
            return ((DebugInfo) this.a).getStackEntries(i);
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public ByteString getStackEntriesBytes(int i) {
            return ((DebugInfo) this.a).getStackEntriesBytes(i);
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public int getStackEntriesCount() {
            return ((DebugInfo) this.a).getStackEntriesCount();
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public List<String> getStackEntriesList() {
            return Collections.unmodifiableList(((DebugInfo) this.a).getStackEntriesList());
        }

        public Builder setDetail(String str) {
            a();
            ((DebugInfo) this.a).setDetail(str);
            return this;
        }

        public Builder setDetailBytes(ByteString byteString) {
            a();
            ((DebugInfo) this.a).setDetailBytes(byteString);
            return this;
        }

        public Builder setStackEntries(int i, String str) {
            a();
            ((DebugInfo) this.a).setStackEntries(i, str);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private DebugInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStackEntries(Iterable<String> iterable) {
        ensureStackEntriesIsMutable();
        AbstractMessageLite.a(iterable, this.stackEntries_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStackEntries(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureStackEntriesIsMutable();
        this.stackEntries_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStackEntriesBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureStackEntriesIsMutable();
        this.stackEntries_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDetail() {
        this.detail_ = getDefaultInstance().getDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStackEntries() {
        this.stackEntries_ = GeneratedMessageLite.f();
    }

    private void ensureStackEntriesIsMutable() {
        if (this.stackEntries_.isModifiable()) {
            return;
        }
        this.stackEntries_ = GeneratedMessageLite.a(this.stackEntries_);
    }

    public static DebugInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DebugInfo debugInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) debugInfo);
    }

    public static DebugInfo parseDelimitedFrom(InputStream inputStream) {
        return (DebugInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static DebugInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DebugInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DebugInfo parseFrom(ByteString byteString) {
        return (DebugInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static DebugInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DebugInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DebugInfo parseFrom(CodedInputStream codedInputStream) {
        return (DebugInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DebugInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DebugInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DebugInfo parseFrom(InputStream inputStream) {
        return (DebugInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static DebugInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DebugInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DebugInfo parseFrom(byte[] bArr) {
        return (DebugInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static DebugInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DebugInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<DebugInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetail(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.detail_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.detail_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStackEntries(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureStackEntriesIsMutable();
        this.stackEntries_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new DebugInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.stackEntries_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DebugInfo debugInfo = (DebugInfo) obj2;
                this.stackEntries_ = visitor.visitList(this.stackEntries_, debugInfo.stackEntries_);
                this.detail_ = visitor.visitString(!this.detail_.isEmpty(), this.detail_, true ^ debugInfo.detail_.isEmpty(), debugInfo.detail_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= debugInfo.bitField0_;
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
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if (!this.stackEntries_.isModifiable()) {
                                    this.stackEntries_ = GeneratedMessageLite.a(this.stackEntries_);
                                }
                                this.stackEntries_.add(readStringRequireUtf8);
                            } else if (readTag == 18) {
                                this.detail_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (DebugInfo.class) {
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

    @Override // com.google.rpc.DebugInfoOrBuilder
    public String getDetail() {
        return this.detail_;
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public ByteString getDetailBytes() {
        return ByteString.copyFromUtf8(this.detail_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.stackEntries_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag(this.stackEntries_.get(i3));
        }
        int size = 0 + i2 + (getStackEntriesList().size() * 1);
        if (!this.detail_.isEmpty()) {
            size += CodedOutputStream.computeStringSize(2, getDetail());
        }
        this.c = size;
        return size;
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public String getStackEntries(int i) {
        return this.stackEntries_.get(i);
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public ByteString getStackEntriesBytes(int i) {
        return ByteString.copyFromUtf8(this.stackEntries_.get(i));
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public int getStackEntriesCount() {
        return this.stackEntries_.size();
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public List<String> getStackEntriesList() {
        return this.stackEntries_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.stackEntries_.size(); i++) {
            codedOutputStream.writeString(1, this.stackEntries_.get(i));
        }
        if (this.detail_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getDetail());
    }
}
