package com.google.api;

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
public final class SourceInfo extends GeneratedMessageLite<SourceInfo, Builder> implements SourceInfoOrBuilder {
    private static final SourceInfo DEFAULT_INSTANCE = new SourceInfo();
    private static volatile Parser<SourceInfo> PARSER = null;
    public static final int SOURCE_FILES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Any> sourceFiles_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.SourceInfo$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<SourceInfo, Builder> implements SourceInfoOrBuilder {
        private Builder() {
            super(SourceInfo.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllSourceFiles(Iterable<? extends Any> iterable) {
            a();
            ((SourceInfo) this.a).addAllSourceFiles(iterable);
            return this;
        }

        public Builder addSourceFiles(int i, Any.Builder builder) {
            a();
            ((SourceInfo) this.a).addSourceFiles(i, builder);
            return this;
        }

        public Builder addSourceFiles(int i, Any any) {
            a();
            ((SourceInfo) this.a).addSourceFiles(i, any);
            return this;
        }

        public Builder addSourceFiles(Any.Builder builder) {
            a();
            ((SourceInfo) this.a).addSourceFiles(builder);
            return this;
        }

        public Builder addSourceFiles(Any any) {
            a();
            ((SourceInfo) this.a).addSourceFiles(any);
            return this;
        }

        public Builder clearSourceFiles() {
            a();
            ((SourceInfo) this.a).clearSourceFiles();
            return this;
        }

        @Override // com.google.api.SourceInfoOrBuilder
        public Any getSourceFiles(int i) {
            return ((SourceInfo) this.a).getSourceFiles(i);
        }

        @Override // com.google.api.SourceInfoOrBuilder
        public int getSourceFilesCount() {
            return ((SourceInfo) this.a).getSourceFilesCount();
        }

        @Override // com.google.api.SourceInfoOrBuilder
        public List<Any> getSourceFilesList() {
            return Collections.unmodifiableList(((SourceInfo) this.a).getSourceFilesList());
        }

        public Builder removeSourceFiles(int i) {
            a();
            ((SourceInfo) this.a).removeSourceFiles(i);
            return this;
        }

        public Builder setSourceFiles(int i, Any.Builder builder) {
            a();
            ((SourceInfo) this.a).setSourceFiles(i, builder);
            return this;
        }

        public Builder setSourceFiles(int i, Any any) {
            a();
            ((SourceInfo) this.a).setSourceFiles(i, any);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private SourceInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSourceFiles(Iterable<? extends Any> iterable) {
        ensureSourceFilesIsMutable();
        AbstractMessageLite.a(iterable, this.sourceFiles_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSourceFiles(int i, Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSourceFiles(int i, Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(i, any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSourceFiles(Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSourceFiles(Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSourceFiles() {
        this.sourceFiles_ = GeneratedMessageLite.f();
    }

    private void ensureSourceFilesIsMutable() {
        if (this.sourceFiles_.isModifiable()) {
            return;
        }
        this.sourceFiles_ = GeneratedMessageLite.a(this.sourceFiles_);
    }

    public static SourceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SourceInfo sourceInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) sourceInfo);
    }

    public static SourceInfo parseDelimitedFrom(InputStream inputStream) {
        return (SourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static SourceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(ByteString byteString) {
        return (SourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static SourceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(CodedInputStream codedInputStream) {
        return (SourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SourceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(InputStream inputStream) {
        return (SourceInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static SourceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(byte[] bArr) {
        return (SourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static SourceInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<SourceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSourceFiles(int i) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceFiles(int i, Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceFiles(int i, Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        ensureSourceFilesIsMutable();
        this.sourceFiles_.set(i, any);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new SourceInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.sourceFiles_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.sourceFiles_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.sourceFiles_, ((SourceInfo) obj2).sourceFiles_);
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
                                    if (!this.sourceFiles_.isModifiable()) {
                                        this.sourceFiles_ = GeneratedMessageLite.a(this.sourceFiles_);
                                    }
                                    this.sourceFiles_.add((Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite));
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (SourceInfo.class) {
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
        int i2 = 0;
        for (int i3 = 0; i3 < this.sourceFiles_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.sourceFiles_.get(i3));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.api.SourceInfoOrBuilder
    public Any getSourceFiles(int i) {
        return this.sourceFiles_.get(i);
    }

    @Override // com.google.api.SourceInfoOrBuilder
    public int getSourceFilesCount() {
        return this.sourceFiles_.size();
    }

    @Override // com.google.api.SourceInfoOrBuilder
    public List<Any> getSourceFilesList() {
        return this.sourceFiles_;
    }

    public AnyOrBuilder getSourceFilesOrBuilder(int i) {
        return this.sourceFiles_.get(i);
    }

    public List<? extends AnyOrBuilder> getSourceFilesOrBuilderList() {
        return this.sourceFiles_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.sourceFiles_.size(); i++) {
            codedOutputStream.writeMessage(1, this.sourceFiles_.get(i));
        }
    }
}
