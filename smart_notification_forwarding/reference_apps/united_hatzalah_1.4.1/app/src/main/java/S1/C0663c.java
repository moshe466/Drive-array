package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0663c implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0663c f6257a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6258b = FieldDescriptor.of("logRequest");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(f6258b, ((C0674n) ((x) obj)).f6304a);
    }
}
