package com.google.android.recaptcha.internal;

import P2.C0169t;
import P2.G;
import P2.InterfaceC0168s;
import T.b;
import android.app.Application;
import android.webkit.WebView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.TimeoutCancellationException;
import s2.C0682g;
import s2.C0684i;
import s2.InterfaceC0678c;
import t2.AbstractC0707i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public final class zzja extends zze {
    public InterfaceC0168s zza;
    public zzfo zzb;
    private final zzek zzc;
    private zzsc zzf;
    private final zzek zzj;
    private final InterfaceC0678c zzk;
    private final InterfaceC0678c zzl;
    private final InterfaceC0678c zzm;
    private final InterfaceC0678c zzn;
    private final InterfaceC0678c zzo;
    private zzen zzp;
    private final zzbi zzq;
    private final Map zzd = zzjb.zza();
    private final Map zze = new LinkedHashMap();
    private final zzcb zzg = new zzcb(zzje.zza);
    private final zzjh zzh = zzjh.zzc();
    private final zzij zzi = new zzij(this);

    public zzja(zzek zzekVar, zzbi zzbiVar) {
        this.zzc = zzekVar;
        this.zzq = zzbiVar;
        zzek zza = zzekVar.zza();
        zza.zzc(zzekVar.zzd());
        this.zzj = zza;
        int i = zzav.zza;
        this.zzk = b.A(zzis.zza);
        this.zzl = b.A(zzit.zza);
        this.zzm = b.A(zziu.zza);
        this.zzn = b.A(zziv.zza);
        this.zzo = b.A(zziw.zza);
    }

    private final Application zzD() {
        return (Application) ((C0682g) this.zzo).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzE(com.google.android.recaptcha.internal.zzsc r5, w2.InterfaceC0763d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzim
            if (r0 == 0) goto L13
            r0 = r6
            com.google.android.recaptcha.internal.zzim r0 = (com.google.android.recaptcha.internal.zzim) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzim r0 = new com.google.android.recaptcha.internal.zzim
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            com.google.android.recaptcha.internal.zzja r5 = r0.zzd
            a.AbstractC0228a.C(r6)     // Catch: com.google.android.recaptcha.internal.zzbd -> L29
            goto L4e
        L29:
            r6 = move-exception
            goto L64
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            a.AbstractC0228a.C(r6)
            s2.c r6 = r4.zzn     // Catch: com.google.android.recaptcha.internal.zzbd -> L61
            s2.g r6 = (s2.C0682g) r6     // Catch: com.google.android.recaptcha.internal.zzbd -> L61
            java.lang.Object r6 = r6.a()     // Catch: com.google.android.recaptcha.internal.zzbd -> L61
            com.google.android.recaptcha.internal.zzff r6 = (com.google.android.recaptcha.internal.zzff) r6     // Catch: com.google.android.recaptcha.internal.zzbd -> L61
            com.google.android.recaptcha.internal.zzek r2 = r4.zzj     // Catch: com.google.android.recaptcha.internal.zzbd -> L61
            r0.zzd = r4     // Catch: com.google.android.recaptcha.internal.zzbd -> L61
            r0.zzc = r3     // Catch: com.google.android.recaptcha.internal.zzbd -> L61
            java.lang.Object r6 = r6.zzd(r5, r2, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> L61
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r5 = r4
        L4e:
            java.lang.String r6 = (java.lang.String) r6     // Catch: com.google.android.recaptcha.internal.zzbd -> L29
            com.google.android.recaptcha.internal.zzbi r0 = r5.zzq     // Catch: com.google.android.recaptcha.internal.zzbd -> L29
            P2.E r0 = r0.zzb()     // Catch: com.google.android.recaptcha.internal.zzbd -> L29
            com.google.android.recaptcha.internal.zzin r1 = new com.google.android.recaptcha.internal.zzin     // Catch: com.google.android.recaptcha.internal.zzbd -> L29
            r2 = 0
            r1.<init>(r5, r6, r2)     // Catch: com.google.android.recaptcha.internal.zzbd -> L29
            r6 = 3
            P2.G.r(r0, r2, r1, r6)     // Catch: com.google.android.recaptcha.internal.zzbd -> L29
            goto L6d
        L61:
            r5 = move-exception
            r6 = r5
            r5 = r4
        L64:
            P2.s r5 = r5.zzA()
            P2.t r5 = (P2.C0169t) r5
            r5.P(r6)
        L6d:
            s2.i r5 = s2.C0684i.f6340a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzE(com.google.android.recaptcha.internal.zzsc, w2.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(4:9|10|11|12)(2:28|29))(4:30|31|32|(1:34)(1:35))|13|14|15|16))|39|6|(0)(0)|13|14|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        r2 = r9;
        r9 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzF(java.lang.String r9, w2.InterfaceC0763d r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.google.android.recaptcha.internal.zzio
            if (r0 == 0) goto L13
            r0 = r10
            com.google.android.recaptcha.internal.zzio r0 = (com.google.android.recaptcha.internal.zzio) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzio r0 = new com.google.android.recaptcha.internal.zzio
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.String r9 = r0.zzf
            java.lang.String r1 = r0.zze
            com.google.android.recaptcha.internal.zzja r2 = r0.zzd
            a.AbstractC0228a.C(r10)     // Catch: java.lang.Exception -> L30
            r3 = r9
            r4 = r1
            r9 = r2
            goto L68
        L30:
            r0 = move-exception
            r9 = r0
            goto L7d
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            a.AbstractC0228a.C(r10)
            com.google.android.recaptcha.internal.zzek r10 = r8.zzj
            r2 = 26
            com.google.android.recaptcha.internal.zzen r10 = r10.zzf(r2)
            r8.zzp = r10
            s2.c r10 = r8.zzl     // Catch: java.lang.Exception -> L7a
            s2.g r10 = (s2.C0682g) r10     // Catch: java.lang.Exception -> L7a
            java.lang.Object r10 = r10.a()     // Catch: java.lang.Exception -> L7a
            com.google.android.recaptcha.internal.zzbr r10 = (com.google.android.recaptcha.internal.zzbr) r10     // Catch: java.lang.Exception -> L7a
            java.lang.String r10 = r10.zza()     // Catch: java.lang.Exception -> L7a
            r0.zzd = r8     // Catch: java.lang.Exception -> L7a
            r0.zze = r9     // Catch: java.lang.Exception -> L7a
            r0.zzf = r10     // Catch: java.lang.Exception -> L7a
            r0.zzc = r3     // Catch: java.lang.Exception -> L7a
            java.lang.Object r0 = r8.zzw(r0)     // Catch: java.lang.Exception -> L7a
            if (r0 == r1) goto L79
            r4 = r9
            r3 = r10
            r10 = r0
            r9 = r8
        L68:
            r2 = r10
            android.webkit.WebView r2 = (android.webkit.WebView) r2     // Catch: java.lang.Exception -> L74
            java.lang.String r5 = "text/html"
            java.lang.String r6 = "utf-8"
            r7 = 0
            r2.loadDataWithBaseURL(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L74
            goto L9d
        L74:
            r0 = move-exception
            r10 = r0
            r2 = r9
            r9 = r10
            goto L7d
        L79:
            return r1
        L7a:
            r0 = move-exception
            r9 = r0
            r2 = r8
        L7d:
            com.google.android.recaptcha.internal.zzbd r10 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r0 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r1 = com.google.android.recaptcha.internal.zzba.zzU
            java.lang.String r9 = r9.getMessage()
            r10.<init>(r0, r1, r9)
            com.google.android.recaptcha.internal.zzen r9 = r2.zzp
            if (r9 == 0) goto L91
            r9.zzb(r10)
        L91:
            r9 = 0
            r2.zzp = r9
            P2.s r9 = r2.zzA()
            P2.t r9 = (P2.C0169t) r9
            r9.P(r10)
        L9d:
            s2.i r9 = s2.C0684i.f6340a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzF(java.lang.String, w2.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzG(java.lang.String r9, w2.InterfaceC0763d r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.google.android.recaptcha.internal.zzix
            if (r0 == 0) goto L13
            r0 = r10
            com.google.android.recaptcha.internal.zzix r0 = (com.google.android.recaptcha.internal.zzix) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzix r0 = new com.google.android.recaptcha.internal.zzix
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            s2.i r3 = s2.C0684i.f6340a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L40
            if (r2 == r5) goto L38
            if (r2 != r4) goto L30
            java.lang.String r9 = r0.zze
            com.google.android.recaptcha.internal.zzja r0 = r0.zzd
            a.AbstractC0228a.C(r10)
            goto L77
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            java.lang.String r9 = r0.zze
            com.google.android.recaptcha.internal.zzja r2 = r0.zzd
            a.AbstractC0228a.C(r10)
            goto L5c
        L40:
            a.AbstractC0228a.C(r10)
            com.google.android.recaptcha.internal.zzcb r10 = r8.zzg
            com.google.android.recaptcha.internal.zzje r2 = com.google.android.recaptcha.internal.zzje.zzd
            com.google.android.recaptcha.internal.zzje r6 = com.google.android.recaptcha.internal.zzje.zzc
            com.google.android.recaptcha.internal.zzje r7 = com.google.android.recaptcha.internal.zzje.zzb
            com.google.android.recaptcha.internal.zzje[] r2 = new com.google.android.recaptcha.internal.zzje[]{r2, r6, r7}
            r0.zzd = r8
            r0.zze = r9
            r0.zzc = r5
            java.lang.Object r10 = r10.zzb(r2, r0)
            if (r10 == r1) goto L99
            r2 = r8
        L5c:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L65
            return r3
        L65:
            com.google.android.recaptcha.internal.zzcb r10 = r2.zzg
            com.google.android.recaptcha.internal.zzje r5 = com.google.android.recaptcha.internal.zzje.zzb
            r0.zzd = r2
            r0.zze = r9
            r0.zzc = r4
            java.lang.Object r10 = r10.zzc(r5, r0)
            if (r10 != r1) goto L76
            goto L99
        L76:
            r0 = r2
        L77:
            P2.t r10 = P2.G.a()
            r0.zza = r10
            com.google.android.recaptcha.internal.zzek r10 = r0.zzj
            r10.zzc(r9)
            r9 = 42
            com.google.android.recaptcha.internal.zzen r9 = r10.zzf(r9)
            com.google.android.recaptcha.internal.zzbi r10 = r0.zzq
            P2.E r10 = r10.zza()
            com.google.android.recaptcha.internal.zziz r1 = new com.google.android.recaptcha.internal.zziz
            r2 = 0
            r1.<init>(r0, r9, r2)
            r9 = 3
            P2.G.r(r10, r2, r1, r9)
            return r3
        L99:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzG(java.lang.String, w2.d):java.lang.Object");
    }

    public static final /* synthetic */ zzfk zzp(zzja zzjaVar) {
        return (zzfk) ((C0682g) zzjaVar.zzm).a();
    }

    public final InterfaceC0168s zzA() {
        InterfaceC0168s interfaceC0168s = this.zza;
        if (interfaceC0168s != null) {
            return interfaceC0168s;
        }
        return null;
    }

    public final zzft zzC(zzsc zzscVar, zzcg zzcgVar, WebView webView) {
        zzfw zzfwVar = new zzfw(webView, this.zzq.zzb());
        zzhy zzhyVar = new zzhy();
        zzhyVar.zzb(AbstractC0707i.r0(zzscVar.zzP()));
        zzgf zzgfVar = new zzgf(zzfwVar, zzcgVar, new zzbo());
        zzhz zzhzVar = new zzhz(zzhyVar, new zzhw());
        zzgfVar.zze(3, zzD());
        zzgfVar.zze(5, zzig.zza());
        zzgfVar.zze(6, new zzia(zzD()));
        zzgfVar.zze(7, new zzic());
        zzgfVar.zze(8, new zzii(zzD()));
        zzgfVar.zze(9, new zzid(zzD()));
        zzgfVar.zze(10, new zzib(zzD()));
        return new zzft(this.zzq.zzd(), zzgfVar, zzhzVar, zzfn.zza());
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final zzen zza(String str) {
        zzek zzekVar = this.zzc;
        zzekVar.zzc(str);
        return zzekVar.zzf(33);
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final zzen zzb() {
        zzek zzekVar = this.zzc;
        zzekVar.zzc(zzekVar.zzd());
        return zzekVar.zzf(32);
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzd(String str, InterfaceC0763d interfaceC0763d) {
        zzsh zzf = zzsi.zzf();
        zzf.zze(str);
        return zzf.zzk();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c7, code lost:
    
        if (((P2.C0169t) r12).j(r0) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
    
        if (r12 != r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a1, code lost:
    
        if (r12 != r1) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.google.android.recaptcha.internal.zzja] */
    @Override // com.google.android.recaptcha.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzf(java.lang.String r11, w2.InterfaceC0763d r12) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzf(java.lang.String, w2.d):java.lang.Object");
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzg(zzbd zzbdVar, InterfaceC0763d interfaceC0763d) {
        if (j.a(zzbdVar.zza(), zzba.zzb)) {
            zzen zzenVar = this.zzp;
            if (zzenVar != null) {
                zzenVar.zzb(zzbdVar);
            }
            this.zzp = null;
        }
        return C0684i.f6340a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        if (zzG(r6, r0) != r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        if (r6.zzc(r7, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.google.android.recaptcha.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzh(com.google.android.recaptcha.internal.zzsc r6, w2.InterfaceC0763d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzir
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzir r0 = (com.google.android.recaptcha.internal.zzir) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzir r0 = new com.google.android.recaptcha.internal.zzir
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            a.AbstractC0228a.C(r7)
            goto L5c
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            a.AbstractC0228a.C(r7)
            goto L6c
        L36:
            a.AbstractC0228a.C(r7)
            boolean r7 = r6.zzT()
            if (r7 == 0) goto L5f
            boolean r7 = r6.zzR()
            if (r7 == 0) goto L5f
            boolean r7 = r6.zzQ()
            if (r7 != 0) goto L4c
            goto L5f
        L4c:
            r5.zzf = r6
            com.google.android.recaptcha.internal.zzek r6 = r5.zzc
            java.lang.String r6 = r6.zzd()
            r0.zzc = r3
            java.lang.Object r6 = r5.zzG(r6, r0)
            if (r6 == r1) goto L6b
        L5c:
            s2.i r6 = s2.C0684i.f6340a
            return r6
        L5f:
            com.google.android.recaptcha.internal.zzcb r6 = r5.zzg
            com.google.android.recaptcha.internal.zzje r7 = com.google.android.recaptcha.internal.zzje.zzd
            r0.zzc = r4
            java.lang.Object r6 = r6.zzc(r7, r0)
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            com.google.android.recaptcha.internal.zzbd r6 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r7 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzav
            r1 = 0
            r6.<init>(r7, r0, r1)
            s2.e r6 = a.AbstractC0228a.g(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzh(com.google.android.recaptcha.internal.zzsc, w2.d):java.lang.Object");
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzi(String str, long j2, Exception exc, InterfaceC0763d interfaceC0763d) {
        exc.getMessage();
        InterfaceC0168s interfaceC0168s = (InterfaceC0168s) this.zze.remove(str);
        if (interfaceC0168s != null) {
            ((C0169t) interfaceC0168s).P(exc);
        }
        return C0684i.f6340a;
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzj(Exception exc, InterfaceC0763d interfaceC0763d) {
        Long zza = this.zzi.zza();
        if ((exc instanceof TimeoutCancellationException) && zza == null) {
            return new zzbd(zzbb.zzc, zzba.zzH, null);
        }
        return zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzV, exc.getMessage()));
    }

    public final zzcb zzm() {
        return this.zzg;
    }

    public final zzij zzq() {
        return this.zzi;
    }

    public final Object zzw(InterfaceC0763d interfaceC0763d) {
        return G.z(this.zzq.zzb().a(), new zzjc((zzjd) ((C0682g) this.zzk).a(), zzD(), null), interfaceC0763d);
    }

    public final Object zzx(InterfaceC0763d interfaceC0763d) {
        Object z3 = G.z(this.zzq.zzb().a(), new zzil(this, null), interfaceC0763d);
        if (z3 == EnumC0779a.f6740a) {
            return z3;
        }
        return C0684i.f6340a;
    }
}
