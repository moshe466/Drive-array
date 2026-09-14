package bb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import n9.y0;

/* loaded from: classes.dex */
public class i extends b {

    /* renamed from: d, reason: collision with root package name */
    private final n9.e f4220d;

    /* renamed from: e, reason: collision with root package name */
    private final List<n9.a1> f4221e;

    /* renamed from: f, reason: collision with root package name */
    private final Collection<b0> f4222f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(n9.e eVar, List<? extends n9.a1> list, Collection<b0> collection, ab.n nVar) {
        super(nVar);
        if (eVar == null) {
            m(0);
        }
        if (list == null) {
            m(1);
        }
        if (collection == null) {
            m(2);
        }
        if (nVar == null) {
            m(3);
        }
        this.f4220d = eVar;
        this.f4221e = Collections.unmodifiableList(new ArrayList(list));
        this.f4222f = Collections.unmodifiableCollection(collection);
    }

    private static /* synthetic */ void m(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getParameters";
        } else if (i10 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i10 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i10 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // bb.t0
    public List<n9.a1> B() {
        List<n9.a1> list = this.f4221e;
        if (list == null) {
            m(4);
        }
        return list;
    }

    @Override // bb.g
    protected Collection<b0> d() {
        Collection<b0> collection = this.f4222f;
        if (collection == null) {
            m(6);
        }
        return collection;
    }

    @Override // bb.g
    protected n9.y0 h() {
        y0.a aVar = y0.a.f12328a;
        if (aVar == null) {
            m(7);
        }
        return aVar;
    }

    @Override // bb.g, bb.t0
    public n9.e o() {
        n9.e eVar = this.f4220d;
        if (eVar == null) {
            m(5);
        }
        return eVar;
    }

    public String toString() {
        return na.d.m(this.f4220d).b();
    }

    @Override // bb.t0
    public boolean z() {
        return true;
    }
}
