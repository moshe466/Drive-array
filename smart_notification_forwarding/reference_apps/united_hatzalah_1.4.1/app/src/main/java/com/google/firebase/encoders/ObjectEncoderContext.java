package com.google.firebase.encoders;

/* loaded from: classes.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d2);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f4);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j2);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z3);

    @Deprecated
    ObjectEncoderContext add(String str, double d2);

    @Deprecated
    ObjectEncoderContext add(String str, int i);

    @Deprecated
    ObjectEncoderContext add(String str, long j2);

    @Deprecated
    ObjectEncoderContext add(String str, Object obj);

    @Deprecated
    ObjectEncoderContext add(String str, boolean z3);

    ObjectEncoderContext inline(Object obj);

    ObjectEncoderContext nested(FieldDescriptor fieldDescriptor);

    ObjectEncoderContext nested(String str);
}
