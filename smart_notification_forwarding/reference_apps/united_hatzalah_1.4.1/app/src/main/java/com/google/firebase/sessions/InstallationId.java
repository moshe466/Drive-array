package com.google.firebase.sessions;

import kotlin.jvm.internal.f;

/* loaded from: classes.dex */
public final class InstallationId {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "InstallationId";
    private final String authToken;
    private final String fid;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:(6:11|12|13|14|15|16)(2:19|20))(2:21|22))(3:29|30|(2:32|27))|23|24|25))|35|6|7|(0)(0)|23|24|25) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
        
            if (r9 != r1) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        
            r9 = r8;
            r8 = "";
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /* JADX WARN: Type inference failed for: r8v0, types: [com.google.firebase.installations.FirebaseInstallationsApi, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object create(com.google.firebase.installations.FirebaseInstallationsApi r8, w2.InterfaceC0763d r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof com.google.firebase.sessions.InstallationId$Companion$create$1
                if (r0 == 0) goto L13
                r0 = r9
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = (com.google.firebase.sessions.InstallationId$Companion$create$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = new com.google.firebase.sessions.InstallationId$Companion$create$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.result
                x2.a r1 = x2.EnumC0779a.f6740a
                int r2 = r0.label
                java.lang.String r3 = ""
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L40
                if (r2 == r5) goto L38
                if (r2 != r4) goto L30
                java.lang.Object r8 = r0.L$0
                java.lang.String r8 = (java.lang.String) r8
                a.AbstractC0228a.C(r9)     // Catch: java.lang.Exception -> L85
                goto L7d
            L30:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L38:
                java.lang.Object r8 = r0.L$0
                com.google.firebase.installations.FirebaseInstallationsApi r8 = (com.google.firebase.installations.FirebaseInstallationsApi) r8
                a.AbstractC0228a.C(r9)     // Catch: java.lang.Exception -> L67
                goto L58
            L40:
                a.AbstractC0228a.C(r9)
                r9 = 0
                com.google.android.gms.tasks.Task r9 = r8.getToken(r9)     // Catch: java.lang.Exception -> L67
                java.lang.String r2 = "firebaseInstallations.getToken(false)"
                kotlin.jvm.internal.j.d(r9, r2)     // Catch: java.lang.Exception -> L67
                r0.L$0 = r8     // Catch: java.lang.Exception -> L67
                r0.label = r5     // Catch: java.lang.Exception -> L67
                java.lang.Object r9 = E1.b.c(r9, r0)     // Catch: java.lang.Exception -> L67
                if (r9 != r1) goto L58
                goto L7c
            L58:
                com.google.firebase.installations.InstallationTokenResult r9 = (com.google.firebase.installations.InstallationTokenResult) r9     // Catch: java.lang.Exception -> L67
                java.lang.String r9 = r9.getToken()     // Catch: java.lang.Exception -> L67
                java.lang.String r2 = "{\n          firebaseInst…).await().token\n        }"
                kotlin.jvm.internal.j.d(r9, r2)     // Catch: java.lang.Exception -> L67
                r6 = r9
                r9 = r8
                r8 = r6
                goto L69
            L67:
                r9 = r8
                r8 = r3
            L69:
                com.google.android.gms.tasks.Task r9 = r9.getId()     // Catch: java.lang.Exception -> L85
                java.lang.String r2 = "firebaseInstallations.id"
                kotlin.jvm.internal.j.d(r9, r2)     // Catch: java.lang.Exception -> L85
                r0.L$0 = r8     // Catch: java.lang.Exception -> L85
                r0.label = r4     // Catch: java.lang.Exception -> L85
                java.lang.Object r9 = E1.b.c(r9, r0)     // Catch: java.lang.Exception -> L85
                if (r9 != r1) goto L7d
            L7c:
                return r1
            L7d:
                java.lang.String r0 = "{\n          firebaseInst…ions.id.await()\n        }"
                kotlin.jvm.internal.j.d(r9, r0)     // Catch: java.lang.Exception -> L85
                java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Exception -> L85
                r3 = r9
            L85:
                com.google.firebase.sessions.InstallationId r9 = new com.google.firebase.sessions.InstallationId
                r0 = 0
                r9.<init>(r3, r8, r0)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.InstallationId.Companion.create(com.google.firebase.installations.FirebaseInstallationsApi, w2.d):java.lang.Object");
        }

        private Companion() {
        }
    }

    public /* synthetic */ InstallationId(String str, String str2, f fVar) {
        this(str, str2);
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getFid() {
        return this.fid;
    }

    private InstallationId(String str, String str2) {
        this.fid = str;
        this.authToken = str2;
    }
}
