package n9;

import java.util.Collection;

/* loaded from: classes.dex */
public interface b extends n9.a, z {

    /* loaded from: classes.dex */
    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    b P0(m mVar, a0 a0Var, u uVar, a aVar, boolean z10);

    @Override // n9.a, n9.m
    b a();

    @Override // n9.a
    Collection<? extends b> g();

    a r();

    void r0(Collection<? extends b> collection);
}
