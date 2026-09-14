package androidx.constraintlayout.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ResolutionNode {
    public static final int REMOVED = 2;
    public static final int RESOLVED = 1;
    public static final int UNRESOLVED = 0;
    HashSet<ResolutionNode> a = new HashSet<>(2);
    int b = 0;

    public void addDependent(ResolutionNode resolutionNode) {
        this.a.add(resolutionNode);
    }

    public void didResolve() {
        this.b = 1;
        Iterator<ResolutionNode> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().resolve();
        }
    }

    public void invalidate() {
        this.b = 0;
        Iterator<ResolutionNode> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    public void invalidateAnchors() {
        if (this instanceof ResolutionAnchor) {
            this.b = 0;
        }
        Iterator<ResolutionNode> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().invalidateAnchors();
        }
    }

    public boolean isResolved() {
        return this.b == 1;
    }

    public void remove(ResolutionDimension resolutionDimension) {
    }

    public void reset() {
        this.b = 0;
        this.a.clear();
    }

    public void resolve() {
    }
}
