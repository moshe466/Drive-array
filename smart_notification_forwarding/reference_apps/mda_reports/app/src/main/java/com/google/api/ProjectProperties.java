package com.google.api;

import com.google.api.Property;
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
public final class ProjectProperties extends GeneratedMessageLite<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {
    private static final ProjectProperties DEFAULT_INSTANCE = new ProjectProperties();
    private static volatile Parser<ProjectProperties> PARSER = null;
    public static final int PROPERTIES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Property> properties_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.ProjectProperties$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {
        private Builder() {
            super(ProjectProperties.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllProperties(Iterable<? extends Property> iterable) {
            a();
            ((ProjectProperties) this.a).addAllProperties(iterable);
            return this;
        }

        public Builder addProperties(int i, Property.Builder builder) {
            a();
            ((ProjectProperties) this.a).addProperties(i, builder);
            return this;
        }

        public Builder addProperties(int i, Property property) {
            a();
            ((ProjectProperties) this.a).addProperties(i, property);
            return this;
        }

        public Builder addProperties(Property.Builder builder) {
            a();
            ((ProjectProperties) this.a).addProperties(builder);
            return this;
        }

        public Builder addProperties(Property property) {
            a();
            ((ProjectProperties) this.a).addProperties(property);
            return this;
        }

        public Builder clearProperties() {
            a();
            ((ProjectProperties) this.a).clearProperties();
            return this;
        }

        @Override // com.google.api.ProjectPropertiesOrBuilder
        public Property getProperties(int i) {
            return ((ProjectProperties) this.a).getProperties(i);
        }

        @Override // com.google.api.ProjectPropertiesOrBuilder
        public int getPropertiesCount() {
            return ((ProjectProperties) this.a).getPropertiesCount();
        }

        @Override // com.google.api.ProjectPropertiesOrBuilder
        public List<Property> getPropertiesList() {
            return Collections.unmodifiableList(((ProjectProperties) this.a).getPropertiesList());
        }

        public Builder removeProperties(int i) {
            a();
            ((ProjectProperties) this.a).removeProperties(i);
            return this;
        }

        public Builder setProperties(int i, Property.Builder builder) {
            a();
            ((ProjectProperties) this.a).setProperties(i, builder);
            return this;
        }

        public Builder setProperties(int i, Property property) {
            a();
            ((ProjectProperties) this.a).setProperties(i, property);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ProjectProperties() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProperties(Iterable<? extends Property> iterable) {
        ensurePropertiesIsMutable();
        AbstractMessageLite.a(iterable, this.properties_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProperties(int i, Property.Builder builder) {
        ensurePropertiesIsMutable();
        this.properties_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProperties(int i, Property property) {
        if (property == null) {
            throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        this.properties_.add(i, property);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProperties(Property.Builder builder) {
        ensurePropertiesIsMutable();
        this.properties_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProperties(Property property) {
        if (property == null) {
            throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        this.properties_.add(property);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProperties() {
        this.properties_ = GeneratedMessageLite.f();
    }

    private void ensurePropertiesIsMutable() {
        if (this.properties_.isModifiable()) {
            return;
        }
        this.properties_ = GeneratedMessageLite.a(this.properties_);
    }

    public static ProjectProperties getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ProjectProperties projectProperties) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) projectProperties);
    }

    public static ProjectProperties parseDelimitedFrom(InputStream inputStream) {
        return (ProjectProperties) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ProjectProperties parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ProjectProperties) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(ByteString byteString) {
        return (ProjectProperties) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ProjectProperties parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ProjectProperties) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(CodedInputStream codedInputStream) {
        return (ProjectProperties) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ProjectProperties parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ProjectProperties) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(InputStream inputStream) {
        return (ProjectProperties) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ProjectProperties parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ProjectProperties) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ProjectProperties parseFrom(byte[] bArr) {
        return (ProjectProperties) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ProjectProperties parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ProjectProperties) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ProjectProperties> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProperties(int i) {
        ensurePropertiesIsMutable();
        this.properties_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProperties(int i, Property.Builder builder) {
        ensurePropertiesIsMutable();
        this.properties_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProperties(int i, Property property) {
        if (property == null) {
            throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        this.properties_.set(i, property);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ProjectProperties();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.properties_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.properties_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.properties_, ((ProjectProperties) obj2).properties_);
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
                                    if (!this.properties_.isModifiable()) {
                                        this.properties_ = GeneratedMessageLite.a(this.properties_);
                                    }
                                    this.properties_.add((Property) codedInputStream.readMessage(Property.parser(), extensionRegistryLite));
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
                    synchronized (ProjectProperties.class) {
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

    @Override // com.google.api.ProjectPropertiesOrBuilder
    public Property getProperties(int i) {
        return this.properties_.get(i);
    }

    @Override // com.google.api.ProjectPropertiesOrBuilder
    public int getPropertiesCount() {
        return this.properties_.size();
    }

    @Override // com.google.api.ProjectPropertiesOrBuilder
    public List<Property> getPropertiesList() {
        return this.properties_;
    }

    public PropertyOrBuilder getPropertiesOrBuilder(int i) {
        return this.properties_.get(i);
    }

    public List<? extends PropertyOrBuilder> getPropertiesOrBuilderList() {
        return this.properties_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.properties_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.properties_.get(i3));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.properties_.size(); i++) {
            codedOutputStream.writeMessage(1, this.properties_.get(i));
        }
    }
}
