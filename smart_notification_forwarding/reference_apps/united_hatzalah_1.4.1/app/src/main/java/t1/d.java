package t1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import w1.C0757e;

/* loaded from: classes.dex */
public final class d implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6402a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6403b = e0.a.a(1, FieldDescriptor.builder("logSource"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6404c = e0.a.a(2, FieldDescriptor.builder("logEventDropped"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        C0757e c0757e = (C0757e) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f6403b, c0757e.f6722a);
        objectEncoderContext2.add(f6404c, c0757e.f6723b);
    }
}
