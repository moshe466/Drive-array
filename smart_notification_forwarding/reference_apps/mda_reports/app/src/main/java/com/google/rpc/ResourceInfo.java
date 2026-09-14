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
public final class ResourceInfo extends GeneratedMessageLite<ResourceInfo, Builder> implements ResourceInfoOrBuilder {
    private static final ResourceInfo DEFAULT_INSTANCE = new ResourceInfo();
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int OWNER_FIELD_NUMBER = 3;
    private static volatile Parser<ResourceInfo> PARSER = null;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 2;
    public static final int RESOURCE_TYPE_FIELD_NUMBER = 1;
    private String resourceType_ = "";
    private String resourceName_ = "";
    private String owner_ = "";
    private String description_ = "";

    /* renamed from: com.google.rpc.ResourceInfo$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ResourceInfo, Builder> implements ResourceInfoOrBuilder {
        private Builder() {
            super(ResourceInfo.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDescription() {
            a();
            ((ResourceInfo) this.a).clearDescription();
            return this;
        }

        public Builder clearOwner() {
            a();
            ((ResourceInfo) this.a).clearOwner();
            return this;
        }

        public Builder clearResourceName() {
            a();
            ((ResourceInfo) this.a).clearResourceName();
            return this;
        }

        public Builder clearResourceType() {
            a();
            ((ResourceInfo) this.a).clearResourceType();
            return this;
        }

        @Override // com.google.rpc.ResourceInfoOrBuilder
        public String getDescription() {
            return ((ResourceInfo) this.a).getDescription();
        }

        @Override // com.google.rpc.ResourceInfoOrBuilder
        public ByteString getDescriptionBytes() {
            return ((ResourceInfo) this.a).getDescriptionBytes();
        }

        @Override // com.google.rpc.ResourceInfoOrBuilder
        public String getOwner() {
            return ((ResourceInfo) this.a).getOwner();
        }

        @Override // com.google.rpc.ResourceInfoOrBuilder
        public ByteString getOwnerBytes() {
            return ((ResourceInfo) this.a).getOwnerBytes();
        }

        @Override // com.google.rpc.ResourceInfoOrBuilder
        public String getResourceName() {
            return ((ResourceInfo) this.a).getResourceName();
        }

        @Override // com.google.rpc.ResourceInfoOrBuilder
        public ByteString getResourceNameBytes() {
            return ((ResourceInfo) this.a).getResourceNameBytes();
        }

        @Override // com.google.rpc.ResourceInfoOrBuilder
        public String getResourceType() {
            return ((ResourceInfo) this.a).getResourceType();
        }

        @Override // com.google.rpc.ResourceInfoOrBuilder
        public ByteString getResourceTypeBytes() {
            return ((ResourceInfo) this.a).getResourceTypeBytes();
        }

        public Builder setDescription(String str) {
            a();
            ((ResourceInfo) this.a).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            a();
            ((ResourceInfo) this.a).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setOwner(String str) {
            a();
            ((ResourceInfo) this.a).setOwner(str);
            return this;
        }

        public Builder setOwnerBytes(ByteString byteString) {
            a();
            ((ResourceInfo) this.a).setOwnerBytes(byteString);
            return this;
        }

        public Builder setResourceName(String str) {
            a();
            ((ResourceInfo) this.a).setResourceName(str);
            return this;
        }

        public Builder setResourceNameBytes(ByteString byteString) {
            a();
            ((ResourceInfo) this.a).setResourceNameBytes(byteString);
            return this;
        }

        public Builder setResourceType(String str) {
            a();
            ((ResourceInfo) this.a).setResourceType(str);
            return this;
        }

        public Builder setResourceTypeBytes(ByteString byteString) {
            a();
            ((ResourceInfo) this.a).setResourceTypeBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ResourceInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOwner() {
        this.owner_ = getDefaultInstance().getOwner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResourceName() {
        this.resourceName_ = getDefaultInstance().getResourceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResourceType() {
        this.resourceType_ = getDefaultInstance().getResourceType();
    }

    public static ResourceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ResourceInfo resourceInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) resourceInfo);
    }

    public static ResourceInfo parseDelimitedFrom(InputStream inputStream) {
        return (ResourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ResourceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResourceInfo parseFrom(ByteString byteString) {
        return (ResourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ResourceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ResourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ResourceInfo parseFrom(CodedInputStream codedInputStream) {
        return (ResourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ResourceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ResourceInfo parseFrom(InputStream inputStream) {
        return (ResourceInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ResourceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResourceInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResourceInfo parseFrom(byte[] bArr) {
        return (ResourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ResourceInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ResourceInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ResourceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOwner(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.owner_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOwnerBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.owner_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.resourceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.resourceName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceType(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.resourceType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceTypeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.resourceType_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ResourceInfo();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ResourceInfo resourceInfo = (ResourceInfo) obj2;
                this.resourceType_ = visitor.visitString(!this.resourceType_.isEmpty(), this.resourceType_, !resourceInfo.resourceType_.isEmpty(), resourceInfo.resourceType_);
                this.resourceName_ = visitor.visitString(!this.resourceName_.isEmpty(), this.resourceName_, !resourceInfo.resourceName_.isEmpty(), resourceInfo.resourceName_);
                this.owner_ = visitor.visitString(!this.owner_.isEmpty(), this.owner_, !resourceInfo.owner_.isEmpty(), resourceInfo.owner_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, true ^ resourceInfo.description_.isEmpty(), resourceInfo.description_);
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
                                    this.resourceType_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.resourceName_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 26) {
                                    this.owner_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 34) {
                                    this.description_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (ResourceInfo.class) {
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

    @Override // com.google.rpc.ResourceInfoOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.google.rpc.ResourceInfoOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.google.rpc.ResourceInfoOrBuilder
    public String getOwner() {
        return this.owner_;
    }

    @Override // com.google.rpc.ResourceInfoOrBuilder
    public ByteString getOwnerBytes() {
        return ByteString.copyFromUtf8(this.owner_);
    }

    @Override // com.google.rpc.ResourceInfoOrBuilder
    public String getResourceName() {
        return this.resourceName_;
    }

    @Override // com.google.rpc.ResourceInfoOrBuilder
    public ByteString getResourceNameBytes() {
        return ByteString.copyFromUtf8(this.resourceName_);
    }

    @Override // com.google.rpc.ResourceInfoOrBuilder
    public String getResourceType() {
        return this.resourceType_;
    }

    @Override // com.google.rpc.ResourceInfoOrBuilder
    public ByteString getResourceTypeBytes() {
        return ByteString.copyFromUtf8(this.resourceType_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.resourceType_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getResourceType());
        if (!this.resourceName_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getResourceName());
        }
        if (!this.owner_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getOwner());
        }
        if (!this.description_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(4, getDescription());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.resourceType_.isEmpty()) {
            codedOutputStream.writeString(1, getResourceType());
        }
        if (!this.resourceName_.isEmpty()) {
            codedOutputStream.writeString(2, getResourceName());
        }
        if (!this.owner_.isEmpty()) {
            codedOutputStream.writeString(3, getOwner());
        }
        if (this.description_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(4, getDescription());
    }
}
