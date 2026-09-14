package com.google.firebase.sessions.settings;

import F2.p;
import P2.E;
import java.util.Map;
import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", l = {73, 75, 78}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteSettingsFetcher$doConfigFetch$2 extends AbstractC0793i implements p {
    final /* synthetic */ Map<String, String> $headerOptions;
    final /* synthetic */ p $onFailure;
    final /* synthetic */ p $onSuccess;
    int label;
    final /* synthetic */ RemoteSettingsFetcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettingsFetcher$doConfigFetch$2(RemoteSettingsFetcher remoteSettingsFetcher, Map<String, String> map, p pVar, p pVar2, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = remoteSettingsFetcher;
        this.$headerOptions = map;
        this.$onSuccess = pVar;
        this.$onFailure = pVar2;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new RemoteSettingsFetcher$doConfigFetch$2(this.this$0, this.$headerOptions, this.$onSuccess, this.$onFailure, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((RemoteSettingsFetcher$doConfigFetch$2) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c2, code lost:
    
        if (r8.invoke(r1, r7) == r0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
    
        if (r1.invoke(r3, r7) != r0) goto L37;
     */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L24
            if (r1 == r4) goto L1c
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            a.AbstractC0228a.C(r8)
            goto Lda
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1c:
            a.AbstractC0228a.C(r8)     // Catch: java.lang.Exception -> L21
            goto Lda
        L21:
            r8 = move-exception
            goto Lc5
        L24:
            a.AbstractC0228a.C(r8)
            com.google.firebase.sessions.settings.RemoteSettingsFetcher r8 = r7.this$0     // Catch: java.lang.Exception -> L21
            java.net.URL r8 = com.google.firebase.sessions.settings.RemoteSettingsFetcher.access$settingsUrl(r8)     // Catch: java.lang.Exception -> L21
            java.net.URLConnection r8 = r8.openConnection()     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection"
            kotlin.jvm.internal.j.c(r8, r1)     // Catch: java.lang.Exception -> L21
            javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = "GET"
            r8.setRequestMethod(r1)     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = "Accept"
            java.lang.String r5 = "application/json"
            r8.setRequestProperty(r1, r5)     // Catch: java.lang.Exception -> L21
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.$headerOptions     // Catch: java.lang.Exception -> L21
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Exception -> L21
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L21
        L4e:
            boolean r5 = r1.hasNext()     // Catch: java.lang.Exception -> L21
            if (r5 == 0) goto L6a
            java.lang.Object r5 = r1.next()     // Catch: java.lang.Exception -> L21
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Exception -> L21
            java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Exception -> L21
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L21
            java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Exception -> L21
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L21
            r8.setRequestProperty(r6, r5)     // Catch: java.lang.Exception -> L21
            goto L4e
        L6a:
            int r1 = r8.getResponseCode()     // Catch: java.lang.Exception -> L21
            r5 = 200(0xc8, float:2.8E-43)
            if (r1 != r5) goto La9
            java.io.InputStream r8 = r8.getInputStream()     // Catch: java.lang.Exception -> L21
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L21
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L21
            r3.<init>(r8)     // Catch: java.lang.Exception -> L21
            r1.<init>(r3)     // Catch: java.lang.Exception -> L21
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L21
            r3.<init>()     // Catch: java.lang.Exception -> L21
        L85:
            java.lang.String r5 = r1.readLine()     // Catch: java.lang.Exception -> L21
            if (r5 == 0) goto L8f
            r3.append(r5)     // Catch: java.lang.Exception -> L21
            goto L85
        L8f:
            r1.close()     // Catch: java.lang.Exception -> L21
            r8.close()     // Catch: java.lang.Exception -> L21
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Exception -> L21
            r8.<init>(r1)     // Catch: java.lang.Exception -> L21
            F2.p r1 = r7.$onSuccess     // Catch: java.lang.Exception -> L21
            r7.label = r4     // Catch: java.lang.Exception -> L21
            java.lang.Object r8 = r1.invoke(r8, r7)     // Catch: java.lang.Exception -> L21
            if (r8 != r0) goto Lda
            goto Ld9
        La9:
            F2.p r8 = r7.$onFailure     // Catch: java.lang.Exception -> L21
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L21
            r4.<init>()     // Catch: java.lang.Exception -> L21
            java.lang.String r5 = "Bad response code: "
            r4.append(r5)     // Catch: java.lang.Exception -> L21
            r4.append(r1)     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L21
            r7.label = r3     // Catch: java.lang.Exception -> L21
            java.lang.Object r8 = r8.invoke(r1, r7)     // Catch: java.lang.Exception -> L21
            if (r8 != r0) goto Lda
            goto Ld9
        Lc5:
            F2.p r1 = r7.$onFailure
            java.lang.String r3 = r8.getMessage()
            if (r3 != 0) goto Ld1
            java.lang.String r3 = r8.toString()
        Ld1:
            r7.label = r2
            java.lang.Object r8 = r1.invoke(r3, r7)
            if (r8 != r0) goto Lda
        Ld9:
            return r0
        Lda:
            s2.i r8 = s2.C0684i.f6340a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
