package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class u {
    private static final /* synthetic */ u[] $VALUES;
    public static final u DEFAULT;
    public static final u STRING;

    /* loaded from: classes.dex */
    enum a extends u {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.u
        public k serialize(Long l10) {
            return l10 == null ? m.f7516a : new q(l10);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        DEFAULT = aVar;
        u uVar = new u("STRING", 1) { // from class: com.google.gson.u.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.u
            public k serialize(Long l10) {
                return l10 == null ? m.f7516a : new q(l10.toString());
            }
        };
        STRING = uVar;
        $VALUES = new u[]{aVar, uVar};
    }

    private u(String str, int i10) {
    }

    /* synthetic */ u(String str, int i10, a aVar) {
        this(str, i10);
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) $VALUES.clone();
    }

    public abstract k serialize(Long l10);
}
