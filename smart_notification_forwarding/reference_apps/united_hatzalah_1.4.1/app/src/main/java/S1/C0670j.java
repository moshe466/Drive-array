package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0670j implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0670j f6281a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6282b = FieldDescriptor.of("requestTimeMs");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6283c = FieldDescriptor.of("requestUptimeMs");

    /* renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f6284d = FieldDescriptor.of("clientInfo");

    /* renamed from: e, reason: collision with root package name */
    public static final FieldDescriptor f6285e = FieldDescriptor.of("logSource");

    /* renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f6286f = FieldDescriptor.of("logSourceName");

    /* renamed from: g, reason: collision with root package name */
    public static final FieldDescriptor f6287g = FieldDescriptor.of("logEvent");

    /* renamed from: h, reason: collision with root package name */
    public static final FieldDescriptor f6288h = FieldDescriptor.of("qosTier");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        u uVar = (u) ((AbstractC0656G) obj);
        objectEncoderContext2.add(f6282b, uVar.f6319a);
        objectEncoderContext2.add(f6283c, uVar.f6320b);
        objectEncoderContext2.add(f6284d, uVar.f6321c);
        objectEncoderContext2.add(f6285e, uVar.f6322d);
        objectEncoderContext2.add(f6286f, uVar.f6323e);
        objectEncoderContext2.add(f6287g, uVar.f6324f);
        objectEncoderContext2.add(f6288h, EnumC0660K.f6243a);
    }
}
