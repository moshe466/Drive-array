package J;

import F0.C0110z2;
import F0.G1;
import F0.b3;
import W1.C0204b;
import W1.C0210h;
import W1.C0225x;
import W1.u0;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import com.google.crypto.tink.shaded.protobuf.C0344p;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.lt.plugin.lt_plugin.utils.FirebaseHelper;
import io.flutter.Build;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Map;

/* renamed from: J.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0119g implements Y0.c, d3.a, LibraryVersionComponent.VersionExtractor, OnFailureListener, q1.e, ImmutableSortedMap.Builder.KeyTranslator, Continuation, SuccessContinuation, d3.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f993a;

    public /* synthetic */ C0119g(int i) {
        this.f993a = i;
    }

    private final K1.b b(R1.n nVar) {
        if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                C0204b D3 = C0204b.D((AbstractC0337i) nVar.f2004c, C0344p.a());
                if (D3.B() == 0) {
                    b3 b3Var = new b3(6);
                    b3Var.f469b = null;
                    b3Var.f470c = null;
                    b3Var.f471d = S1.c.f2120f;
                    b3Var.w(D3.z().size());
                    int y = D3.A().y();
                    if (y >= 10 && 16 >= y) {
                        b3Var.f470c = Integer.valueOf(y);
                        b3Var.f471d = S1.e.a((W1.r0) nVar.f2006e);
                        S1.d l3 = b3Var.l();
                        C0110z2 c0110z2 = new C0110z2(6);
                        c0110z2.f730c = null;
                        c0110z2.f731d = null;
                        c0110z2.f729b = l3;
                        c0110z2.f730c = new G1(Y1.a.a(D3.z().k()), 11);
                        c0110z2.f731d = (Integer) nVar.f2007f;
                        return c0110z2.e();
                    }
                    throw new GeneralSecurityException(e0.a.c(y, "Invalid tag size for AesCmacParameters: "));
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [F0.R2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v92, types: [K1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [K1.m, java.lang.Object] */
    public K1.b a(R1.n nVar) {
        L1.j jVar;
        L1.j jVar2;
        switch (this.f993a) {
            case 2:
                if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                    try {
                        C0210h D3 = C0210h.D((AbstractC0337i) nVar.f2004c, C0344p.a());
                        if (D3.B() == 0) {
                            ?? obj = new Object();
                            obj.f372a = null;
                            obj.f373b = null;
                            obj.f374c = null;
                            obj.f375d = null;
                            L1.j jVar3 = L1.j.f1299j;
                            obj.f376e = jVar3;
                            int size = D3.z().A().size();
                            if (size != 16 && size != 24 && size != 32) {
                                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size)));
                            }
                            obj.f372a = Integer.valueOf(size);
                            int size2 = D3.A().A().size();
                            if (size2 >= 16) {
                                obj.f373b = Integer.valueOf(size2);
                                int A3 = D3.A().B().A();
                                if (A3 >= 10) {
                                    obj.f374c = Integer.valueOf(A3);
                                    obj.f375d = L1.l.a(D3.A().B().z());
                                    W1.r0 r0Var = (W1.r0) nVar.f2006e;
                                    int ordinal = r0Var.ordinal();
                                    if (ordinal != 1) {
                                        if (ordinal != 2) {
                                            if (ordinal != 3) {
                                                if (ordinal != 4) {
                                                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var.b());
                                                }
                                            }
                                        }
                                        jVar3 = L1.j.i;
                                    } else {
                                        jVar3 = L1.j.f1298h;
                                    }
                                    obj.f376e = jVar3;
                                    L1.k f4 = obj.f();
                                    ?? obj2 = new Object();
                                    obj2.f1103b = null;
                                    obj2.f1104c = null;
                                    obj2.f1105d = null;
                                    obj2.f1102a = f4;
                                    obj2.f1103b = new G1(Y1.a.a(D3.z().A().k()), 11);
                                    obj2.f1104c = new G1(Y1.a.a(D3.A().A().k()), 11);
                                    obj2.f1105d = (Integer) nVar.f2007f;
                                    return obj2.c();
                                }
                                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(A3)));
                            }
                            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(size2)));
                        }
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    } catch (InvalidProtocolBufferException unused) {
                        throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
                    }
                }
                throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
            case 3:
                if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                    try {
                        W1.r D4 = W1.r.D((AbstractC0337i) nVar.f2004c, C0344p.a());
                        if (D4.B() == 0) {
                            L1.j jVar4 = L1.j.f1302m;
                            int size3 = D4.z().size();
                            if (size3 != 16 && size3 != 24 && size3 != 32) {
                                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size3)));
                            }
                            int y = D4.A().y();
                            if (y != 12 && y != 16) {
                                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(y)));
                            }
                            W1.r0 r0Var2 = (W1.r0) nVar.f2006e;
                            int ordinal2 = r0Var2.ordinal();
                            if (ordinal2 != 1) {
                                if (ordinal2 != 2) {
                                    if (ordinal2 != 3) {
                                        if (ordinal2 != 4) {
                                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var2.b());
                                        }
                                    }
                                }
                                jVar4 = L1.j.f1301l;
                            } else {
                                jVar4 = L1.j.f1300k;
                            }
                            L1.n nVar2 = new L1.n(size3, y, 16, jVar4);
                            C0110z2 c0110z2 = new C0110z2(4);
                            c0110z2.f730c = null;
                            c0110z2.f731d = null;
                            c0110z2.f729b = nVar2;
                            c0110z2.f730c = new G1(Y1.a.a(D4.z().k()), 11);
                            c0110z2.f731d = (Integer) nVar.f2007f;
                            return c0110z2.c();
                        }
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    } catch (InvalidProtocolBufferException unused2) {
                        throw new GeneralSecurityException("Parsing AesEaxcKey failed");
                    }
                }
                throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
            case 4:
                if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                    try {
                        C0225x B3 = C0225x.B((AbstractC0337i) nVar.f2004c, C0344p.a());
                        if (B3.z() == 0) {
                            L1.j jVar5 = L1.j.p;
                            int size4 = B3.y().size();
                            if (size4 != 16 && size4 != 24 && size4 != 32) {
                                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size4)));
                            }
                            W1.r0 r0Var3 = (W1.r0) nVar.f2006e;
                            int ordinal3 = r0Var3.ordinal();
                            if (ordinal3 != 1) {
                                if (ordinal3 != 2) {
                                    if (ordinal3 != 3) {
                                        if (ordinal3 != 4) {
                                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var3.b());
                                        }
                                    }
                                }
                                jVar5 = L1.j.f1304o;
                            } else {
                                jVar5 = L1.j.f1303n;
                            }
                            L1.q qVar = new L1.q(size4, 12, 16, jVar5);
                            b3 b3Var = new b3(4);
                            b3Var.f470c = null;
                            b3Var.f471d = null;
                            b3Var.f469b = qVar;
                            b3Var.f470c = new G1(Y1.a.a(B3.y().k()), 11);
                            b3Var.f471d = (Integer) nVar.f2007f;
                            return b3Var.j();
                        }
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    } catch (InvalidProtocolBufferException unused3) {
                        throw new GeneralSecurityException("Parsing AesGcmKey failed");
                    }
                }
                throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
            case 5:
                if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
                    try {
                        W1.B B4 = W1.B.B((AbstractC0337i) nVar.f2004c, C0344p.a());
                        if (B4.z() == 0) {
                            L1.j jVar6 = L1.j.f1307s;
                            int size5 = B4.y().size();
                            if (size5 != 16 && size5 != 32) {
                                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(size5)));
                            }
                            W1.r0 r0Var4 = (W1.r0) nVar.f2006e;
                            int ordinal4 = r0Var4.ordinal();
                            if (ordinal4 != 1) {
                                if (ordinal4 != 2) {
                                    if (ordinal4 != 3) {
                                        if (ordinal4 != 4) {
                                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var4.b());
                                        }
                                    }
                                }
                                jVar6 = L1.j.f1306r;
                            } else {
                                jVar6 = L1.j.f1305q;
                            }
                            L1.t tVar = new L1.t(size5, jVar6);
                            C0110z2 c0110z22 = new C0110z2(5);
                            c0110z22.f730c = null;
                            c0110z22.f731d = null;
                            c0110z22.f729b = tVar;
                            c0110z22.f730c = new G1(Y1.a.a(B4.y().k()), 11);
                            c0110z22.f731d = (Integer) nVar.f2007f;
                            return c0110z22.d();
                        }
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    } catch (InvalidProtocolBufferException unused4) {
                        throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
                    }
                }
                throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
            case 6:
                if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                    try {
                        W1.J B5 = W1.J.B((AbstractC0337i) nVar.f2004c, C0344p.a());
                        if (B5.z() == 0) {
                            W1.r0 r0Var5 = (W1.r0) nVar.f2006e;
                            int ordinal5 = r0Var5.ordinal();
                            if (ordinal5 != 1) {
                                if (ordinal5 != 2) {
                                    if (ordinal5 != 3) {
                                        if (ordinal5 != 4) {
                                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var5.b());
                                        }
                                    } else {
                                        jVar = L1.j.f1310v;
                                    }
                                }
                                jVar = L1.j.f1309u;
                            } else {
                                jVar = L1.j.f1308t;
                            }
                            return L1.v.b(jVar, new G1(Y1.a.a(B5.y().k()), 11), (Integer) nVar.f2007f);
                        }
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    } catch (InvalidProtocolBufferException unused5) {
                        throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
                    }
                }
                throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters");
            case 7:
                if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                    try {
                        u0 B6 = u0.B((AbstractC0337i) nVar.f2004c, C0344p.a());
                        if (B6.z() == 0) {
                            W1.r0 r0Var6 = (W1.r0) nVar.f2006e;
                            int ordinal6 = r0Var6.ordinal();
                            if (ordinal6 != 1) {
                                if (ordinal6 != 2) {
                                    if (ordinal6 != 3) {
                                        if (ordinal6 != 4) {
                                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var6.b());
                                        }
                                    } else {
                                        jVar2 = L1.j.y;
                                    }
                                }
                                jVar2 = L1.j.f1312x;
                            } else {
                                jVar2 = L1.j.f1311w;
                            }
                            return L1.z.b(jVar2, new G1(Y1.a.a(B6.y().k()), 11), (Integer) nVar.f2007f);
                        }
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    } catch (InvalidProtocolBufferException unused6) {
                        throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
                    }
                }
                throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters");
            case 8:
                if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
                    try {
                        W1.F B7 = W1.F.B((AbstractC0337i) nVar.f2004c, C0344p.a());
                        if (B7.z() == 0) {
                            int size6 = B7.y().size();
                            if (size6 != 32 && size6 != 48 && size6 != 64) {
                                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", Integer.valueOf(size6)));
                            }
                            W1.r0 r0Var7 = (W1.r0) nVar.f2006e;
                            Map map = P1.d.f1587e;
                            if (map.containsKey(r0Var7)) {
                                P1.b bVar = (P1.b) map.get(r0Var7);
                                if (bVar != null) {
                                    P1.c cVar = new P1.c(size6, bVar);
                                    b3 b3Var2 = new b3(5);
                                    b3Var2.f470c = null;
                                    b3Var2.f471d = null;
                                    b3Var2.f469b = cVar;
                                    b3Var2.f470c = new G1(Y1.a.a(B7.y().k()), 11);
                                    b3Var2.f471d = (Integer) nVar.f2007f;
                                    return b3Var2.k();
                                }
                                throw new GeneralSecurityException("Variant is not set");
                            }
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + r0Var7.b());
                        }
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    } catch (InvalidProtocolBufferException unused7) {
                        throw new GeneralSecurityException("Parsing AesSivKey failed");
                    }
                }
                throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
            case 9:
            default:
                if (((String) nVar.f2002a).equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                    try {
                        W1.Q E3 = W1.Q.E((AbstractC0337i) nVar.f2004c, C0344p.a());
                        if (E3.C() == 0) {
                            ?? obj3 = new Object();
                            obj3.f1102a = null;
                            obj3.f1103b = null;
                            obj3.f1104c = null;
                            obj3.f1105d = S1.c.f2128o;
                            obj3.f1102a = Integer.valueOf(E3.A().size());
                            obj3.f1103b = Integer.valueOf(E3.B().A());
                            obj3.f1104c = S1.k.a(E3.B().z());
                            obj3.f1105d = S1.k.b((W1.r0) nVar.f2006e);
                            S1.j f5 = obj3.f();
                            C0110z2 c0110z23 = new C0110z2(7);
                            c0110z23.f730c = null;
                            c0110z23.f731d = null;
                            c0110z23.f729b = f5;
                            c0110z23.f730c = new G1(Y1.a.a(E3.A().k()), 11);
                            c0110z23.f731d = (Integer) nVar.f2007f;
                            return c0110z23.f();
                        }
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    } catch (InvalidProtocolBufferException | IllegalArgumentException unused8) {
                        throw new GeneralSecurityException("Parsing HmacKey failed");
                    }
                }
                throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
            case 10:
                return b(nVar);
        }
    }

    @Override // d3.a
    public void accept(Object obj) {
        throw new IllegalArgumentException(String.format("Cannot read more than %,d into a byte array", Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER)));
    }

    @Override // q1.e
    public Object apply(Object obj) {
        switch (this.f993a) {
            case 20:
                return DataTransportCrashlyticsReportSender.a((CrashlyticsReport) obj);
            default:
                return ((MessagingClientEventExtension) obj).toByteArray();
        }
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.f993a) {
            case 15:
                return FirebaseCommonRegistrar.c(context);
            case 16:
                return FirebaseCommonRegistrar.b(context);
            case 17:
                return FirebaseCommonRegistrar.d(context);
            default:
                return FirebaseCommonRegistrar.a(context);
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        FirebaseCrashlytics.a(exc);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task lambda$fetch$3;
        Task lambda$setDefaultsWithStringsMapAsync$7;
        Task lambda$fetch$4;
        switch (this.f993a) {
            case Build.API_LEVELS.API_25 /* 25 */:
                lambda$fetch$3 = FirebaseRemoteConfig.lambda$fetch$3((ConfigFetchHandler.FetchResponse) obj);
                return lambda$fetch$3;
            case Build.API_LEVELS.API_26 /* 26 */:
                lambda$setDefaultsWithStringsMapAsync$7 = FirebaseRemoteConfig.lambda$setDefaultsWithStringsMapAsync$7((ConfigContainer) obj);
                return lambda$setDefaultsWithStringsMapAsync$7;
            default:
                lambda$fetch$4 = FirebaseRemoteConfig.lambda$fetch$4((ConfigFetchHandler.FetchResponse) obj);
                return lambda$fetch$4;
        }
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator
    public Object translate(Object obj) {
        return ImmutableSortedMap.Builder.a(obj);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f993a) {
            case 22:
                return FcmBroadcastProcessor.d(task);
            case 23:
                return FcmBroadcastProcessor.c(task);
            default:
                return FirebaseHelper.d(task);
        }
    }
}
