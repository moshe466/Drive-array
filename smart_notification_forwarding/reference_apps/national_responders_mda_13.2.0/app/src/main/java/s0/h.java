package s0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class h<T> extends Property<T, Float> {

    /* renamed from: a, reason: collision with root package name */
    private final Property<T, PointF> f13918a;

    /* renamed from: b, reason: collision with root package name */
    private final PathMeasure f13919b;

    /* renamed from: c, reason: collision with root package name */
    private final float f13920c;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f13921d;

    /* renamed from: e, reason: collision with root package name */
    private final PointF f13922e;

    /* renamed from: f, reason: collision with root package name */
    private float f13923f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f13921d = new float[2];
        this.f13922e = new PointF();
        this.f13918a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f13919b = pathMeasure;
        this.f13920c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t10) {
        return Float.valueOf(this.f13923f);
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T t10, Float f10) {
        this.f13923f = f10.floatValue();
        this.f13919b.getPosTan(this.f13920c * f10.floatValue(), this.f13921d, null);
        PointF pointF = this.f13922e;
        float[] fArr = this.f13921d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f13918a.set(t10, pointF);
    }
}
