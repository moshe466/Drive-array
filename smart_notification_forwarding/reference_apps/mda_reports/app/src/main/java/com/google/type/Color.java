package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class Color extends GeneratedMessageLite<Color, Builder> implements ColorOrBuilder {
    public static final int ALPHA_FIELD_NUMBER = 4;
    public static final int BLUE_FIELD_NUMBER = 3;
    private static final Color DEFAULT_INSTANCE = new Color();
    public static final int GREEN_FIELD_NUMBER = 2;
    private static volatile Parser<Color> PARSER = null;
    public static final int RED_FIELD_NUMBER = 1;
    private FloatValue alpha_;
    private float blue_;
    private float green_;
    private float red_;

    /* renamed from: com.google.type.Color$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Color, Builder> implements ColorOrBuilder {
        private Builder() {
            super(Color.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAlpha() {
            a();
            ((Color) this.a).clearAlpha();
            return this;
        }

        public Builder clearBlue() {
            a();
            ((Color) this.a).clearBlue();
            return this;
        }

        public Builder clearGreen() {
            a();
            ((Color) this.a).clearGreen();
            return this;
        }

        public Builder clearRed() {
            a();
            ((Color) this.a).clearRed();
            return this;
        }

        @Override // com.google.type.ColorOrBuilder
        public FloatValue getAlpha() {
            return ((Color) this.a).getAlpha();
        }

        @Override // com.google.type.ColorOrBuilder
        public float getBlue() {
            return ((Color) this.a).getBlue();
        }

        @Override // com.google.type.ColorOrBuilder
        public float getGreen() {
            return ((Color) this.a).getGreen();
        }

        @Override // com.google.type.ColorOrBuilder
        public float getRed() {
            return ((Color) this.a).getRed();
        }

        @Override // com.google.type.ColorOrBuilder
        public boolean hasAlpha() {
            return ((Color) this.a).hasAlpha();
        }

        public Builder mergeAlpha(FloatValue floatValue) {
            a();
            ((Color) this.a).mergeAlpha(floatValue);
            return this;
        }

        public Builder setAlpha(FloatValue.Builder builder) {
            a();
            ((Color) this.a).setAlpha(builder);
            return this;
        }

        public Builder setAlpha(FloatValue floatValue) {
            a();
            ((Color) this.a).setAlpha(floatValue);
            return this;
        }

        public Builder setBlue(float f) {
            a();
            ((Color) this.a).setBlue(f);
            return this;
        }

        public Builder setGreen(float f) {
            a();
            ((Color) this.a).setGreen(f);
            return this;
        }

        public Builder setRed(float f) {
            a();
            ((Color) this.a).setRed(f);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Color() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlpha() {
        this.alpha_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBlue() {
        this.blue_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGreen() {
        this.green_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRed() {
        this.red_ = 0.0f;
    }

    public static Color getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAlpha(FloatValue floatValue) {
        FloatValue floatValue2 = this.alpha_;
        if (floatValue2 != null && floatValue2 != FloatValue.getDefaultInstance()) {
            floatValue = FloatValue.newBuilder(this.alpha_).mergeFrom((FloatValue.Builder) floatValue).buildPartial();
        }
        this.alpha_ = floatValue;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Color color) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) color);
    }

    public static Color parseDelimitedFrom(InputStream inputStream) {
        return (Color) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Color parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Color) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Color parseFrom(ByteString byteString) {
        return (Color) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Color parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Color) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Color parseFrom(CodedInputStream codedInputStream) {
        return (Color) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Color parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Color) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Color parseFrom(InputStream inputStream) {
        return (Color) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Color parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Color) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Color parseFrom(byte[] bArr) {
        return (Color) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Color parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Color) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Color> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlpha(FloatValue.Builder builder) {
        this.alpha_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlpha(FloatValue floatValue) {
        if (floatValue == null) {
            throw new NullPointerException();
        }
        this.alpha_ = floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBlue(float f) {
        this.blue_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGreen(float f) {
        this.green_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRed(float f) {
        this.red_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Color();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Color color = (Color) obj2;
                this.red_ = visitor.visitFloat(this.red_ != 0.0f, this.red_, color.red_ != 0.0f, color.red_);
                this.green_ = visitor.visitFloat(this.green_ != 0.0f, this.green_, color.green_ != 0.0f, color.green_);
                this.blue_ = visitor.visitFloat(this.blue_ != 0.0f, this.blue_, color.blue_ != 0.0f, color.blue_);
                this.alpha_ = (FloatValue) visitor.visitMessage(this.alpha_, color.alpha_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 13) {
                                    this.red_ = codedInputStream.readFloat();
                                } else if (readTag == 21) {
                                    this.green_ = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.blue_ = codedInputStream.readFloat();
                                } else if (readTag == 34) {
                                    FloatValue.Builder builder = this.alpha_ != null ? this.alpha_.toBuilder() : null;
                                    this.alpha_ = (FloatValue) codedInputStream.readMessage(FloatValue.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((FloatValue.Builder) this.alpha_);
                                        this.alpha_ = builder.buildPartial();
                                    }
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r1 = true;
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
                    synchronized (Color.class) {
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

    @Override // com.google.type.ColorOrBuilder
    public FloatValue getAlpha() {
        FloatValue floatValue = this.alpha_;
        return floatValue == null ? FloatValue.getDefaultInstance() : floatValue;
    }

    @Override // com.google.type.ColorOrBuilder
    public float getBlue() {
        return this.blue_;
    }

    @Override // com.google.type.ColorOrBuilder
    public float getGreen() {
        return this.green_;
    }

    @Override // com.google.type.ColorOrBuilder
    public float getRed() {
        return this.red_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        float f = this.red_;
        int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
        float f2 = this.green_;
        if (f2 != 0.0f) {
            computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
        }
        float f3 = this.blue_;
        if (f3 != 0.0f) {
            computeFloatSize += CodedOutputStream.computeFloatSize(3, f3);
        }
        if (this.alpha_ != null) {
            computeFloatSize += CodedOutputStream.computeMessageSize(4, getAlpha());
        }
        this.c = computeFloatSize;
        return computeFloatSize;
    }

    @Override // com.google.type.ColorOrBuilder
    public boolean hasAlpha() {
        return this.alpha_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        float f = this.red_;
        if (f != 0.0f) {
            codedOutputStream.writeFloat(1, f);
        }
        float f2 = this.green_;
        if (f2 != 0.0f) {
            codedOutputStream.writeFloat(2, f2);
        }
        float f3 = this.blue_;
        if (f3 != 0.0f) {
            codedOutputStream.writeFloat(3, f3);
        }
        if (this.alpha_ != null) {
            codedOutputStream.writeMessage(4, getAlpha());
        }
    }
}
