package y8;

/* loaded from: classes.dex */
public abstract class u extends c implements e9.j {
    public u() {
    }

    public u(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            return k().equals(uVar.k()) && c().equals(uVar.c()) && m().equals(uVar.m()) && k.a(j(), uVar.j());
        }
        if (obj instanceof e9.j) {
            return obj.equals(d());
        }
        return false;
    }

    public int hashCode() {
        return (((k().hashCode() * 31) + c().hashCode()) * 31) + m().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e9.j n() {
        return (e9.j) super.l();
    }

    public String toString() {
        e9.a d10 = d();
        if (d10 != this) {
            return d10.toString();
        }
        return "property " + c() + " (Kotlin reflection is not available)";
    }
}
