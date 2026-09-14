package com.google.type;

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
public final class Date extends GeneratedMessageLite<Date, Builder> implements DateOrBuilder {
    public static final int DAY_FIELD_NUMBER = 3;
    private static final Date DEFAULT_INSTANCE = new Date();
    public static final int MONTH_FIELD_NUMBER = 2;
    private static volatile Parser<Date> PARSER = null;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int day_;
    private int month_;
    private int year_;

    /* renamed from: com.google.type.Date$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Date, Builder> implements DateOrBuilder {
        private Builder() {
            super(Date.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDay() {
            a();
            ((Date) this.a).clearDay();
            return this;
        }

        public Builder clearMonth() {
            a();
            ((Date) this.a).clearMonth();
            return this;
        }

        public Builder clearYear() {
            a();
            ((Date) this.a).clearYear();
            return this;
        }

        @Override // com.google.type.DateOrBuilder
        public int getDay() {
            return ((Date) this.a).getDay();
        }

        @Override // com.google.type.DateOrBuilder
        public int getMonth() {
            return ((Date) this.a).getMonth();
        }

        @Override // com.google.type.DateOrBuilder
        public int getYear() {
            return ((Date) this.a).getYear();
        }

        public Builder setDay(int i) {
            a();
            ((Date) this.a).setDay(i);
            return this;
        }

        public Builder setMonth(int i) {
            a();
            ((Date) this.a).setMonth(i);
            return this;
        }

        public Builder setYear(int i) {
            a();
            ((Date) this.a).setYear(i);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Date() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDay() {
        this.day_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMonth() {
        this.month_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearYear() {
        this.year_ = 0;
    }

    public static Date getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Date date) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) date);
    }

    public static Date parseDelimitedFrom(InputStream inputStream) {
        return (Date) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Date parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Date) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Date parseFrom(ByteString byteString) {
        return (Date) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Date parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Date) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Date parseFrom(CodedInputStream codedInputStream) {
        return (Date) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Date parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Date) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Date parseFrom(InputStream inputStream) {
        return (Date) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Date parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Date) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Date parseFrom(byte[] bArr) {
        return (Date) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Date parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Date) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Date> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDay(int i) {
        this.day_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonth(int i) {
        this.month_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setYear(int i) {
        this.year_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Date();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Date date = (Date) obj2;
                this.year_ = visitor.visitInt(this.year_ != 0, this.year_, date.year_ != 0, date.year_);
                this.month_ = visitor.visitInt(this.month_ != 0, this.month_, date.month_ != 0, date.month_);
                this.day_ = visitor.visitInt(this.day_ != 0, this.day_, date.day_ != 0, date.day_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.year_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.month_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.day_ = codedInputStream.readInt32();
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
                    synchronized (Date.class) {
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

    @Override // com.google.type.DateOrBuilder
    public int getDay() {
        return this.day_;
    }

    @Override // com.google.type.DateOrBuilder
    public int getMonth() {
        return this.month_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.year_;
        int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
        int i3 = this.month_;
        if (i3 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
        }
        int i4 = this.day_;
        if (i4 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
        }
        this.c = computeInt32Size;
        return computeInt32Size;
    }

    @Override // com.google.type.DateOrBuilder
    public int getYear() {
        return this.year_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.year_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        int i2 = this.month_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(2, i2);
        }
        int i3 = this.day_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(3, i3);
        }
    }
}
