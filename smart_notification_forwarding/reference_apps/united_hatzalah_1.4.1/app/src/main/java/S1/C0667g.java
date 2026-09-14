package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0667g implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0667g f6268a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6269b = FieldDescriptor.of("originAssociatedProductId");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(f6269b, ((r) ((AbstractC0653D) obj)).f6309a);
    }
}
