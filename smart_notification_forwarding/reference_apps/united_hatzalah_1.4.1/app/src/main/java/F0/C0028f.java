package F0;

/* renamed from: F0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0028f implements InterfaceC0040i {

    /* renamed from: a, reason: collision with root package name */
    public static final C0028f f506a = new Object();

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0006. Please report as an issue. */
    public final boolean equals(Object obj) {
        Object obj2 = null;
        while (true) {
            char c4 = 32351;
            while (true) {
                switch (c4) {
                    case 48164:
                        return false;
                    case 32977:
                        return true;
                    case 36432:
                        c4 = 32977;
                        obj2 = obj;
                    case 8841:
                        return true;
                    case 16149:
                        if (!(obj instanceof C0028f)) {
                            c4 = 48164;
                        } else {
                            c4 = 36432;
                        }
                    case 32351:
                        if (this == obj) {
                            c4 = 8841;
                        } else {
                            c4 = 16149;
                        }
                }
            }
        }
    }

    public final int hashCode() {
        return 1581974999;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 1116
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C0028f.toString():java.lang.String");
    }
}
