package s1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: s1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0669i implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0669i f6272a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f6273b = FieldDescriptor.of("eventTimeMs");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f6274c = FieldDescriptor.of("eventCode");

    /* renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f6275d = FieldDescriptor.of("complianceData");

    /* renamed from: e, reason: collision with root package name */
    public static final FieldDescriptor f6276e = FieldDescriptor.of("eventUptimeMs");

    /* renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f6277f = FieldDescriptor.of("sourceExtension");

    /* renamed from: g, reason: collision with root package name */
    public static final FieldDescriptor f6278g = FieldDescriptor.of("sourceExtensionJsonProto3");

    /* renamed from: h, reason: collision with root package name */
    public static final FieldDescriptor f6279h = FieldDescriptor.of("timezoneOffsetSeconds");
    public static final FieldDescriptor i = FieldDescriptor.of("networkConnectionInfo");

    /* renamed from: j, reason: collision with root package name */
    public static final FieldDescriptor f6280j = FieldDescriptor.of("experimentIds");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        t tVar = (t) ((AbstractC0655F) obj);
        objectEncoderContext2.add(f6273b, tVar.f6311a);
        objectEncoderContext2.add(f6274c, tVar.f6312b);
        objectEncoderContext2.add(f6275d, tVar.f6313c);
        objectEncoderContext2.add(f6276e, tVar.f6314d);
        objectEncoderContext2.add(f6277f, tVar.f6315e);
        objectEncoderContext2.add(f6278g, tVar.f6316f);
        objectEncoderContext2.add(f6279h, tVar.f6317g);
        objectEncoderContext2.add(i, tVar.f6318h);
        objectEncoderContext2.add(f6280j, tVar.i);
    }
}
