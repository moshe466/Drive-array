package com.google.firestore.v1;

import com.google.firestore.v1.Value;
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
public final class Cursor extends GeneratedMessageLite<Cursor, Builder> implements CursorOrBuilder {
    public static final int BEFORE_FIELD_NUMBER = 2;
    private static final Cursor DEFAULT_INSTANCE = new Cursor();
    private static volatile Parser<Cursor> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private int bitField0_;
    private Internal.ProtobufList<Value> values_ = GeneratedMessageLite.f();

    /* renamed from: com.google.firestore.v1.Cursor$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Cursor, Builder> implements CursorOrBuilder {
        private Builder() {
            super(Cursor.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllValues(Iterable<? extends Value> iterable) {
            a();
            ((Cursor) this.a).addAllValues(iterable);
            return this;
        }

        public Builder addValues(int i, Value.Builder builder) {
            a();
            ((Cursor) this.a).addValues(i, builder);
            return this;
        }

        public Builder addValues(int i, Value value) {
            a();
            ((Cursor) this.a).addValues(i, value);
            return this;
        }

        public Builder addValues(Value.Builder builder) {
            a();
            ((Cursor) this.a).addValues(builder);
            return this;
        }

        public Builder addValues(Value value) {
            a();
            ((Cursor) this.a).addValues(value);
            return this;
        }

        public Builder clearBefore() {
            a();
            ((Cursor) this.a).clearBefore();
            return this;
        }

        public Builder clearValues() {
            a();
            ((Cursor) this.a).clearValues();
            return this;
        }

        @Override // com.google.firestore.v1.CursorOrBuilder
        public boolean getBefore() {
            return ((Cursor) this.a).getBefore();
        }

        @Override // com.google.firestore.v1.CursorOrBuilder
        public Value getValues(int i) {
            return ((Cursor) this.a).getValues(i);
        }

        @Override // com.google.firestore.v1.CursorOrBuilder
        public int getValuesCount() {
            return ((Cursor) this.a).getValuesCount();
        }

        @Override // com.google.firestore.v1.CursorOrBuilder
        public List<Value> getValuesList() {
            return Collections.unmodifiableList(((Cursor) this.a).getValuesList());
        }

        public Builder removeValues(int i) {
            a();
            ((Cursor) this.a).removeValues(i);
            return this;
        }

        public Builder setBefore(boolean z) {
            a();
            ((Cursor) this.a).setBefore(z);
            return this;
        }

        public Builder setValues(int i, Value.Builder builder) {
            a();
            ((Cursor) this.a).setValues(i, builder);
            return this;
        }

        public Builder setValues(int i, Value value) {
            a();
            ((Cursor) this.a).setValues(i, value);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Cursor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllValues(Iterable<? extends Value> iterable) {
        ensureValuesIsMutable();
        AbstractMessageLite.a(iterable, this.values_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValues(int i, Value.Builder builder) {
        ensureValuesIsMutable();
        this.values_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValues(int i, Value value) {
        if (value == null) {
            throw new NullPointerException();
        }
        ensureValuesIsMutable();
        this.values_.add(i, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValues(Value.Builder builder) {
        ensureValuesIsMutable();
        this.values_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValues(Value value) {
        if (value == null) {
            throw new NullPointerException();
        }
        ensureValuesIsMutable();
        this.values_.add(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBefore() {
        this.before_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValues() {
        this.values_ = GeneratedMessageLite.f();
    }

    private void ensureValuesIsMutable() {
        if (this.values_.isModifiable()) {
            return;
        }
        this.values_ = GeneratedMessageLite.a(this.values_);
    }

    public static Cursor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Cursor cursor) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) cursor);
    }

    public static Cursor parseDelimitedFrom(InputStream inputStream) {
        return (Cursor) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Cursor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Cursor) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Cursor parseFrom(ByteString byteString) {
        return (Cursor) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Cursor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Cursor) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Cursor parseFrom(CodedInputStream codedInputStream) {
        return (Cursor) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Cursor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Cursor) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Cursor parseFrom(InputStream inputStream) {
        return (Cursor) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Cursor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Cursor) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Cursor parseFrom(byte[] bArr) {
        return (Cursor) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Cursor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Cursor) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Cursor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValues(int i) {
        ensureValuesIsMutable();
        this.values_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBefore(boolean z) {
        this.before_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValues(int i, Value.Builder builder) {
        ensureValuesIsMutable();
        this.values_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValues(int i, Value value) {
        if (value == null) {
            throw new NullPointerException();
        }
        ensureValuesIsMutable();
        this.values_.set(i, value);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Cursor();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.values_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Cursor cursor = (Cursor) obj2;
                this.values_ = visitor.visitList(this.values_, cursor.values_);
                boolean z = this.before_;
                boolean z2 = cursor.before_;
                this.before_ = visitor.visitBoolean(z, z, z2, z2);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= cursor.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z3 = false;
                while (!z3) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    if (!this.values_.isModifiable()) {
                                        this.values_ = GeneratedMessageLite.a(this.values_);
                                    }
                                    this.values_.add((Value) codedInputStream.readMessage(Value.parser(), extensionRegistryLite));
                                } else if (readTag == 16) {
                                    this.before_ = codedInputStream.readBool();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z3 = true;
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
                    synchronized (Cursor.class) {
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

    @Override // com.google.firestore.v1.CursorOrBuilder
    public boolean getBefore() {
        return this.before_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.values_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.values_.get(i3));
        }
        boolean z = this.before_;
        if (z) {
            i2 += CodedOutputStream.computeBoolSize(2, z);
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.firestore.v1.CursorOrBuilder
    public Value getValues(int i) {
        return this.values_.get(i);
    }

    @Override // com.google.firestore.v1.CursorOrBuilder
    public int getValuesCount() {
        return this.values_.size();
    }

    @Override // com.google.firestore.v1.CursorOrBuilder
    public List<Value> getValuesList() {
        return this.values_;
    }

    public ValueOrBuilder getValuesOrBuilder(int i) {
        return this.values_.get(i);
    }

    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.values_.size(); i++) {
            codedOutputStream.writeMessage(1, this.values_.get(i));
        }
        boolean z = this.before_;
        if (z) {
            codedOutputStream.writeBool(2, z);
        }
    }
}
