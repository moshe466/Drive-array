package com.google.api;

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
public final class Endpoint extends GeneratedMessageLite<Endpoint, Builder> implements EndpointOrBuilder {
    public static final int ALIASES_FIELD_NUMBER = 2;
    public static final int ALLOW_CORS_FIELD_NUMBER = 5;
    public static final int APIS_FIELD_NUMBER = 3;
    private static final Endpoint DEFAULT_INSTANCE = new Endpoint();
    public static final int FEATURES_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Endpoint> PARSER = null;
    public static final int TARGET_FIELD_NUMBER = 101;
    private boolean allowCors_;
    private int bitField0_;
    private String name_ = "";
    private Internal.ProtobufList<String> aliases_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<String> apis_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<String> features_ = GeneratedMessageLite.f();
    private String target_ = "";

    /* renamed from: com.google.api.Endpoint$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Endpoint, Builder> implements EndpointOrBuilder {
        private Builder() {
            super(Endpoint.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAliases(String str) {
            a();
            ((Endpoint) this.a).addAliases(str);
            return this;
        }

        public Builder addAliasesBytes(ByteString byteString) {
            a();
            ((Endpoint) this.a).addAliasesBytes(byteString);
            return this;
        }

        public Builder addAllAliases(Iterable<String> iterable) {
            a();
            ((Endpoint) this.a).addAllAliases(iterable);
            return this;
        }

        public Builder addAllApis(Iterable<String> iterable) {
            a();
            ((Endpoint) this.a).addAllApis(iterable);
            return this;
        }

        public Builder addAllFeatures(Iterable<String> iterable) {
            a();
            ((Endpoint) this.a).addAllFeatures(iterable);
            return this;
        }

        public Builder addApis(String str) {
            a();
            ((Endpoint) this.a).addApis(str);
            return this;
        }

        public Builder addApisBytes(ByteString byteString) {
            a();
            ((Endpoint) this.a).addApisBytes(byteString);
            return this;
        }

        public Builder addFeatures(String str) {
            a();
            ((Endpoint) this.a).addFeatures(str);
            return this;
        }

        public Builder addFeaturesBytes(ByteString byteString) {
            a();
            ((Endpoint) this.a).addFeaturesBytes(byteString);
            return this;
        }

        public Builder clearAliases() {
            a();
            ((Endpoint) this.a).clearAliases();
            return this;
        }

        public Builder clearAllowCors() {
            a();
            ((Endpoint) this.a).clearAllowCors();
            return this;
        }

        public Builder clearApis() {
            a();
            ((Endpoint) this.a).clearApis();
            return this;
        }

        public Builder clearFeatures() {
            a();
            ((Endpoint) this.a).clearFeatures();
            return this;
        }

        public Builder clearName() {
            a();
            ((Endpoint) this.a).clearName();
            return this;
        }

        public Builder clearTarget() {
            a();
            ((Endpoint) this.a).clearTarget();
            return this;
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getAliases(int i) {
            return ((Endpoint) this.a).getAliases(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getAliasesBytes(int i) {
            return ((Endpoint) this.a).getAliasesBytes(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public int getAliasesCount() {
            return ((Endpoint) this.a).getAliasesCount();
        }

        @Override // com.google.api.EndpointOrBuilder
        public List<String> getAliasesList() {
            return Collections.unmodifiableList(((Endpoint) this.a).getAliasesList());
        }

        @Override // com.google.api.EndpointOrBuilder
        public boolean getAllowCors() {
            return ((Endpoint) this.a).getAllowCors();
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getApis(int i) {
            return ((Endpoint) this.a).getApis(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getApisBytes(int i) {
            return ((Endpoint) this.a).getApisBytes(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public int getApisCount() {
            return ((Endpoint) this.a).getApisCount();
        }

        @Override // com.google.api.EndpointOrBuilder
        public List<String> getApisList() {
            return Collections.unmodifiableList(((Endpoint) this.a).getApisList());
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getFeatures(int i) {
            return ((Endpoint) this.a).getFeatures(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getFeaturesBytes(int i) {
            return ((Endpoint) this.a).getFeaturesBytes(i);
        }

        @Override // com.google.api.EndpointOrBuilder
        public int getFeaturesCount() {
            return ((Endpoint) this.a).getFeaturesCount();
        }

        @Override // com.google.api.EndpointOrBuilder
        public List<String> getFeaturesList() {
            return Collections.unmodifiableList(((Endpoint) this.a).getFeaturesList());
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getName() {
            return ((Endpoint) this.a).getName();
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getNameBytes() {
            return ((Endpoint) this.a).getNameBytes();
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getTarget() {
            return ((Endpoint) this.a).getTarget();
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getTargetBytes() {
            return ((Endpoint) this.a).getTargetBytes();
        }

        public Builder setAliases(int i, String str) {
            a();
            ((Endpoint) this.a).setAliases(i, str);
            return this;
        }

        public Builder setAllowCors(boolean z) {
            a();
            ((Endpoint) this.a).setAllowCors(z);
            return this;
        }

        public Builder setApis(int i, String str) {
            a();
            ((Endpoint) this.a).setApis(i, str);
            return this;
        }

        public Builder setFeatures(int i, String str) {
            a();
            ((Endpoint) this.a).setFeatures(i, str);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Endpoint) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Endpoint) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setTarget(String str) {
            a();
            ((Endpoint) this.a).setTarget(str);
            return this;
        }

        public Builder setTargetBytes(ByteString byteString) {
            a();
            ((Endpoint) this.a).setTargetBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Endpoint() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAliases(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureAliasesIsMutable();
        this.aliases_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAliasesBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureAliasesIsMutable();
        this.aliases_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAliases(Iterable<String> iterable) {
        ensureAliasesIsMutable();
        AbstractMessageLite.a(iterable, this.aliases_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllApis(Iterable<String> iterable) {
        ensureApisIsMutable();
        AbstractMessageLite.a(iterable, this.apis_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFeatures(Iterable<String> iterable) {
        ensureFeaturesIsMutable();
        AbstractMessageLite.a(iterable, this.features_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addApis(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureApisIsMutable();
        this.apis_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addApisBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureApisIsMutable();
        this.apis_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFeatures(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureFeaturesIsMutable();
        this.features_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFeaturesBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureFeaturesIsMutable();
        this.features_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAliases() {
        this.aliases_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowCors() {
        this.allowCors_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearApis() {
        this.apis_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFeatures() {
        this.features_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTarget() {
        this.target_ = getDefaultInstance().getTarget();
    }

    private void ensureAliasesIsMutable() {
        if (this.aliases_.isModifiable()) {
            return;
        }
        this.aliases_ = GeneratedMessageLite.a(this.aliases_);
    }

    private void ensureApisIsMutable() {
        if (this.apis_.isModifiable()) {
            return;
        }
        this.apis_ = GeneratedMessageLite.a(this.apis_);
    }

    private void ensureFeaturesIsMutable() {
        if (this.features_.isModifiable()) {
            return;
        }
        this.features_ = GeneratedMessageLite.a(this.features_);
    }

    public static Endpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Endpoint endpoint) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) endpoint);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream) {
        return (Endpoint) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Endpoint) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(ByteString byteString) {
        return (Endpoint) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Endpoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Endpoint) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream) {
        return (Endpoint) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Endpoint) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(InputStream inputStream) {
        return (Endpoint) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Endpoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Endpoint) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(byte[] bArr) {
        return (Endpoint) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Endpoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Endpoint) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Endpoint> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAliases(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureAliasesIsMutable();
        this.aliases_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowCors(boolean z) {
        this.allowCors_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApis(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureApisIsMutable();
        this.apis_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFeatures(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureFeaturesIsMutable();
        this.features_.set(i, str);
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
    public void setTarget(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.target_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.target_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        String readStringRequireUtf8;
        Internal.ProtobufList<String> protobufList;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Endpoint();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.aliases_.makeImmutable();
                this.apis_.makeImmutable();
                this.features_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Endpoint endpoint = (Endpoint) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !endpoint.name_.isEmpty(), endpoint.name_);
                this.aliases_ = visitor.visitList(this.aliases_, endpoint.aliases_);
                this.apis_ = visitor.visitList(this.apis_, endpoint.apis_);
                this.features_ = visitor.visitList(this.features_, endpoint.features_);
                this.target_ = visitor.visitString(!this.target_.isEmpty(), this.target_, true ^ endpoint.target_.isEmpty(), endpoint.target_);
                boolean z = this.allowCors_;
                boolean z2 = endpoint.allowCors_;
                this.allowCors_ = visitor.visitBoolean(z, z, z2, z2);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= endpoint.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z3 = false;
                while (!z3) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (readTag == 18) {
                                    readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.aliases_.isModifiable()) {
                                        this.aliases_ = GeneratedMessageLite.a(this.aliases_);
                                    }
                                    protobufList = this.aliases_;
                                } else if (readTag == 26) {
                                    readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.apis_.isModifiable()) {
                                        this.apis_ = GeneratedMessageLite.a(this.apis_);
                                    }
                                    protobufList = this.apis_;
                                } else if (readTag == 34) {
                                    readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.features_.isModifiable()) {
                                        this.features_ = GeneratedMessageLite.a(this.features_);
                                    }
                                    protobufList = this.features_;
                                } else if (readTag == 40) {
                                    this.allowCors_ = codedInputStream.readBool();
                                } else if (readTag == 810) {
                                    this.target_ = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                                protobufList.add(readStringRequireUtf8);
                            } else {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            }
                        }
                        z3 = true;
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
                    synchronized (Endpoint.class) {
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

    @Override // com.google.api.EndpointOrBuilder
    public String getAliases(int i) {
        return this.aliases_.get(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getAliasesBytes(int i) {
        return ByteString.copyFromUtf8(this.aliases_.get(i));
    }

    @Override // com.google.api.EndpointOrBuilder
    public int getAliasesCount() {
        return this.aliases_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    public List<String> getAliasesList() {
        return this.aliases_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public boolean getAllowCors() {
        return this.allowCors_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getApis(int i) {
        return this.apis_.get(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getApisBytes(int i) {
        return ByteString.copyFromUtf8(this.apis_.get(i));
    }

    @Override // com.google.api.EndpointOrBuilder
    public int getApisCount() {
        return this.apis_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    public List<String> getApisList() {
        return this.apis_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getFeatures(int i) {
        return this.features_.get(i);
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getFeaturesBytes(int i) {
        return ByteString.copyFromUtf8(this.features_.get(i));
    }

    @Override // com.google.api.EndpointOrBuilder
    public int getFeaturesCount() {
        return this.features_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    public List<String> getFeaturesList() {
        return this.features_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.aliases_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag(this.aliases_.get(i3));
        }
        int size = computeStringSize + i2 + (getAliasesList().size() * 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.apis_.size(); i5++) {
            i4 += CodedOutputStream.computeStringSizeNoTag(this.apis_.get(i5));
        }
        int size2 = size + i4 + (getApisList().size() * 1);
        int i6 = 0;
        for (int i7 = 0; i7 < this.features_.size(); i7++) {
            i6 += CodedOutputStream.computeStringSizeNoTag(this.features_.get(i7));
        }
        int size3 = size2 + i6 + (getFeaturesList().size() * 1);
        boolean z = this.allowCors_;
        if (z) {
            size3 += CodedOutputStream.computeBoolSize(5, z);
        }
        if (!this.target_.isEmpty()) {
            size3 += CodedOutputStream.computeStringSize(101, getTarget());
        }
        this.c = size3;
        return size3;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getTarget() {
        return this.target_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getTargetBytes() {
        return ByteString.copyFromUtf8(this.target_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        for (int i = 0; i < this.aliases_.size(); i++) {
            codedOutputStream.writeString(2, this.aliases_.get(i));
        }
        for (int i2 = 0; i2 < this.apis_.size(); i2++) {
            codedOutputStream.writeString(3, this.apis_.get(i2));
        }
        for (int i3 = 0; i3 < this.features_.size(); i3++) {
            codedOutputStream.writeString(4, this.features_.get(i3));
        }
        boolean z = this.allowCors_;
        if (z) {
            codedOutputStream.writeBool(5, z);
        }
        if (this.target_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(101, getTarget());
    }
}
