package com.google.firebase.sessions.settings;

import F2.p;
import org.json.JSONObject;
import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {132, 135, 138, 140, 141, 143}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteSettings$updateSettings$2$1 extends AbstractC0793i implements p {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = remoteSettings;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, interfaceC0763d);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0166, code lost:
    
        if (r13.updateSessionCacheDuration(r0, r12) == r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0143, code lost:
    
        if (r13.updateSessionCacheDuration(r0, r12) == r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0123, code lost:
    
        if (r13.updateSamplingRate(r1, r12) == r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0102, code lost:
    
        if (r13.updateSessionRestartTimeout(r2, r12) == r4) goto L66;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0188 A[RETURN] */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.jvm.internal.r, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.jvm.internal.r, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.internal.r, java.lang.Object] */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // F2.p
    public final Object invoke(JSONObject jSONObject, InterfaceC0763d interfaceC0763d) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }
}
