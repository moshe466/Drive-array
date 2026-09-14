package com.google.firestore.v1;

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
public final class DocumentMask extends GeneratedMessageLite<DocumentMask, Builder> implements DocumentMaskOrBuilder {
    private static final DocumentMask DEFAULT_INSTANCE = new DocumentMask();
    public static final int FIELD_PATHS_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentMask> PARSER;
    private Internal.ProtobufList<String> fieldPaths_ = GeneratedMessageLite.f();

    /* renamed from: com.google.firestore.v1.DocumentMask$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentMask, Builder> implements DocumentMaskOrBuilder {
        private Builder() {
            super(DocumentMask.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFieldPaths(Iterable<String> iterable) {
            a();
            ((DocumentMask) this.a).addAllFieldPaths(iterable);
            return this;
        }

        public Builder addFieldPaths(String str) {
            a();
            ((DocumentMask) this.a).addFieldPaths(str);
            return this;
        }

        public Builder addFieldPathsBytes(ByteString byteString) {
            a();
            ((DocumentMask) this.a).addFieldPathsBytes(byteString);
            return this;
        }

        public Builder clearFieldPaths() {
            a();
            ((DocumentMask) this.a).clearFieldPaths();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentMaskOrBuilder
        public String getFieldPaths(int i) {
            return ((DocumentMask) this.a).getFieldPaths(i);
        }

        @Override // com.google.firestore.v1.DocumentMaskOrBuilder
        public ByteString getFieldPathsBytes(int i) {
            return ((DocumentMask) this.a).getFieldPathsBytes(i);
        }

        @Override // com.google.firestore.v1.DocumentMaskOrBuilder
        public int getFieldPathsCount() {
            return ((DocumentMask) this.a).getFieldPathsCount();
        }

        @Override // com.google.firestore.v1.DocumentMaskOrBuilder
        public List<String> getFieldPathsList() {
            return Collections.unmodifiableList(((DocumentMask) this.a).getFieldPathsList());
        }

        public Builder setFieldPaths(int i, String str) {
            a();
            ((DocumentMask) this.a).setFieldPaths(i, str);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private DocumentMask() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFieldPaths(Iterable<String> iterable) {
        ensureFieldPathsIsMutable();
        AbstractMessageLite.a(iterable, this.fieldPaths_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldPaths(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureFieldPathsIsMutable();
        this.fieldPaths_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldPathsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureFieldPathsIsMutable();
        this.fieldPaths_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFieldPaths() {
        this.fieldPaths_ = GeneratedMessageLite.f();
    }

    private void ensureFieldPathsIsMutable() {
        if (this.fieldPaths_.isModifiable()) {
            return;
        }
        this.fieldPaths_ = GeneratedMessageLite.a(this.fieldPaths_);
    }

    public static DocumentMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentMask documentMask) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) documentMask);
    }

    public static DocumentMask parseDelimitedFrom(InputStream inputStream) {
        return (DocumentMask) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentMask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentMask) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(ByteString byteString) {
        return (DocumentMask) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentMask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentMask) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(CodedInputStream codedInputStream) {
        return (DocumentMask) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentMask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentMask) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(InputStream inputStream) {
        return (DocumentMask) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentMask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentMask) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(byte[] bArr) {
        return (DocumentMask) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentMask parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentMask) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<DocumentMask> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFieldPaths(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureFieldPathsIsMutable();
        this.fieldPaths_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentMask();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fieldPaths_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.fieldPaths_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.fieldPaths_, ((DocumentMask) obj2).fieldPaths_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.fieldPaths_.isModifiable()) {
                                        this.fieldPaths_ = GeneratedMessageLite.a(this.fieldPaths_);
                                    }
                                    this.fieldPaths_.add(readStringRequireUtf8);
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
                    synchronized (DocumentMask.class) {
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

    @Override // com.google.firestore.v1.DocumentMaskOrBuilder
    public String getFieldPaths(int i) {
        return this.fieldPaths_.get(i);
    }

    @Override // com.google.firestore.v1.DocumentMaskOrBuilder
    public ByteString getFieldPathsBytes(int i) {
        return ByteString.copyFromUtf8(this.fieldPaths_.get(i));
    }

    @Override // com.google.firestore.v1.DocumentMaskOrBuilder
    public int getFieldPathsCount() {
        return this.fieldPaths_.size();
    }

    @Override // com.google.firestore.v1.DocumentMaskOrBuilder
    public List<String> getFieldPathsList() {
        return this.fieldPaths_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.fieldPaths_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag(this.fieldPaths_.get(i3));
        }
        int size = 0 + i2 + (getFieldPathsList().size() * 1);
        this.c = size;
        return size;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.fieldPaths_.size(); i++) {
            codedOutputStream.writeString(1, this.fieldPaths_.get(i));
        }
    }
}
