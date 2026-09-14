package bb;

/* loaded from: classes.dex */
public abstract class w0 implements v0 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return d() == v0Var.d() && c() == v0Var.c() && b().equals(v0Var.b());
    }

    public int hashCode() {
        int hashCode = c().hashCode() * 31;
        if (c1.v(b())) {
            return hashCode + 19;
        }
        return hashCode + (d() ? 17 : b().hashCode());
    }

    public String toString() {
        if (d()) {
            return "*";
        }
        if (c() == h1.INVARIANT) {
            return b().toString();
        }
        return c() + " " + b();
    }
}
