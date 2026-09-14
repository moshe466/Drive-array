package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0666f implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0666f f6265a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6266b = FieldDescriptor.of("clearBlob");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6267c = FieldDescriptor.of("encryptedBlob");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        q qVar = (q) ((AbstractC0652C) obj);
        objectEncoderContext2.add(f6266b, qVar.f6307a);
        objectEncoderContext2.add(f6267c, qVar.f6308b);
    }
}
