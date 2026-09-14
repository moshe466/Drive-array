package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c implements L2.b, Serializable {
    public static final Object NO_RECEIVER = b.f5305a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient L2.b reflected;
    private final String signature;

    public c(Object obj, Class cls, String str, String str2, boolean z3) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z3;
    }

    @Override // L2.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // L2.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public L2.b compute() {
        L2.b bVar = this.reflected;
        if (bVar == null) {
            L2.b computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return bVar;
    }

    public abstract L2.b computeReflected();

    @Override // L2.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // L2.b
    public String getName() {
        return this.name;
    }

    public L2.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            s.f5313a.getClass();
            return new l(cls);
        }
        return s.a(cls);
    }

    @Override // L2.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract L2.b getReflected();

    @Override // L2.b
    public L2.j getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // L2.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // L2.b
    public L2.k getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // L2.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // L2.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // L2.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // L2.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
