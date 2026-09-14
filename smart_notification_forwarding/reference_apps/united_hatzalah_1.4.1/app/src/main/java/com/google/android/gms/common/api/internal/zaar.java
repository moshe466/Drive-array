package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class zaar implements zaba {
    private final zabd zaa;
    private final Lock zab;
    private final Context zac;
    private final GoogleApiAvailabilityLight zad;
    private ConnectionResult zae;
    private int zaf;
    private int zah;
    private com.google.android.gms.signin.zae zak;
    private boolean zal;
    private boolean zam;
    private boolean zan;
    private IAccountAccessor zao;
    private boolean zap;
    private boolean zaq;
    private final ClientSettings zar;
    private final Map zas;
    private final Api.AbstractClientBuilder zat;
    private int zag = 0;
    private final Bundle zai = new Bundle();
    private final Set zaj = new HashSet();
    private final ArrayList zau = new ArrayList();

    public zaar(zabd zabdVar, ClientSettings clientSettings, Map map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zabdVar;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaA, reason: merged with bridge method [inline-methods] */
    public final void zak() {
        if (this.zah == 0) {
            if (!this.zam || this.zan) {
                ArrayList arrayList = new ArrayList();
                this.zag = 1;
                zabd zabdVar = this.zaa;
                Map map = zabdVar.zaa;
                this.zah = map.size();
                for (Api.AnyClientKey anyClientKey : map.keySet()) {
                    if (zabdVar.zab.containsKey(anyClientKey)) {
                        if (zai()) {
                            zaB();
                        }
                    } else {
                        arrayList.add((Api.Client) map.get(anyClientKey));
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zau.add(zabe.zaa().submit(new zaam(this, arrayList)));
                }
            }
        }
    }

    private final void zaB() {
        zabd zabdVar = this.zaa;
        zabdVar.zap();
        zabe.zaa().execute(new zaah(this));
        com.google.android.gms.signin.zae zaeVar = this.zak;
        if (zaeVar != null) {
            if (this.zap) {
                zaeVar.zab((IAccountAccessor) Preconditions.checkNotNull(this.zao), this.zaq);
            }
            zaG(false);
        }
        Iterator it = zabdVar.zab.keySet().iterator();
        while (it.hasNext()) {
            ((Api.Client) Preconditions.checkNotNull((Api.Client) zabdVar.zaa.get((Api.AnyClientKey) it.next()))).disconnect();
        }
        Bundle bundle = this.zai;
        if (true == bundle.isEmpty()) {
            bundle = null;
        }
        zabdVar.zah.zaa(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaC, reason: merged with bridge method [inline-methods] */
    public final void zal(ConnectionResult connectionResult, Api api, boolean z3) {
        int priority = api.zaa().getPriority();
        if ((!z3 || connectionResult.hasResolution() || this.zad.getErrorResolutionIntent(connectionResult.getErrorCode()) != null) && (this.zae == null || priority < this.zaf)) {
            this.zae = connectionResult;
            this.zaf = priority;
        }
        zabd zabdVar = this.zaa;
        zabdVar.zab.put(api.zac(), connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaD, reason: merged with bridge method [inline-methods] */
    public final void zam() {
        this.zam = false;
        zabd zabdVar = this.zaa;
        zabdVar.zag.zad = Collections.EMPTY_SET;
        for (Api.AnyClientKey anyClientKey : this.zaj) {
            Map map = zabdVar.zab;
            if (!map.containsKey(anyClientKey)) {
                map.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaE, reason: merged with bridge method [inline-methods] */
    public final boolean zan(ConnectionResult connectionResult) {
        if (this.zal && !connectionResult.hasResolution()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaF, reason: merged with bridge method [inline-methods] */
    public final void zao(ConnectionResult connectionResult) {
        zaH();
        zaG(!connectionResult.hasResolution());
        zabd zabdVar = this.zaa;
        zabdVar.zaq(connectionResult);
        zabdVar.zah.zab(connectionResult);
    }

    private final void zaG(boolean z3) {
        com.google.android.gms.signin.zae zaeVar = this.zak;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z3) {
                zaeVar.zac();
            }
            zaeVar.disconnect();
            this.zao = null;
        }
    }

    private final void zaH() {
        ArrayList arrayList = this.zau;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Future) arrayList.get(i)).cancel(true);
        }
        arrayList.clear();
    }

    private final boolean zaI(int i) {
        if (this.zag != i) {
            this.zaa.zag.zae();
            "Unexpected callback in ".concat(toString());
            new StringBuilder(String.valueOf(this.zah).length() + 22);
            String zaJ = zaJ(this.zag);
            String zaJ2 = zaJ(i);
            StringBuilder sb = new StringBuilder(zaJ2.length() + zaJ.length() + 70);
            sb.append("GoogleApiClient connecting is in step ");
            sb.append(zaJ);
            sb.append(" but received callback for step ");
            sb.append(zaJ2);
            Log.e("GACConnecting", sb.toString(), new Exception());
            zao(new ConnectionResult(8, null));
            return false;
        }
        return true;
    }

    private static final String zaJ(int i) {
        return i != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaz, reason: merged with bridge method [inline-methods] */
    public final boolean zai() {
        int i = this.zah - 1;
        this.zah = i;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            this.zaa.zag.zae();
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zao(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.zae;
        if (connectionResult != null) {
            this.zaa.zaf = this.zaf;
            zao(connectionResult);
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaa() {
        boolean z3;
        zabd zabdVar = this.zaa;
        zabdVar.zab.clear();
        this.zam = false;
        byte[] bArr = null;
        this.zae = null;
        this.zag = 0;
        this.zal = true;
        this.zan = false;
        this.zap = false;
        HashMap hashMap = new HashMap();
        Map map = this.zas;
        boolean z4 = false;
        for (Api api : map.keySet()) {
            Api.Client client = (Api.Client) Preconditions.checkNotNull((Api.Client) zabdVar.zaa.get(api.zac()));
            if (api.zaa().getPriority() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 |= z3;
            boolean booleanValue = ((Boolean) map.get(api)).booleanValue();
            if (client.requiresSignIn()) {
                this.zam = true;
                if (booleanValue) {
                    this.zaj.add(api.zac());
                } else {
                    this.zal = false;
                }
            }
            hashMap.put(client, new zaai(this, api, booleanValue));
        }
        if (z4) {
            this.zam = false;
        }
        if (this.zam) {
            ClientSettings clientSettings = this.zar;
            Preconditions.checkNotNull(clientSettings);
            Api.AbstractClientBuilder abstractClientBuilder = this.zat;
            Preconditions.checkNotNull(abstractClientBuilder);
            zaaz zaazVar = zabdVar.zag;
            clientSettings.zae(Integer.valueOf(System.identityHashCode(zaazVar)));
            zaap zaapVar = new zaap(this, bArr);
            this.zak = (com.google.android.gms.signin.zae) abstractClientBuilder.buildClient(this.zac, zaazVar.getLooper(), clientSettings, (ClientSettings) clientSettings.zac(), (GoogleApiClient.ConnectionCallbacks) zaapVar, (GoogleApiClient.OnConnectionFailedListener) zaapVar);
        }
        this.zah = zabdVar.zaa.size();
        this.zau.add(zabe.zaa().submit(new zaal(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.zaa.zag.zaa.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final BaseImplementation.ApiMethodImpl zac(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final boolean zad() {
        zaH();
        zaG(true);
        this.zaa.zaq(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zae() {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaf(Bundle bundle) {
        if (zaI(1)) {
            if (bundle != null) {
                this.zai.putAll(bundle);
            }
            if (zai()) {
                zaB();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zag(ConnectionResult connectionResult, Api api, boolean z3) {
        if (zaI(1)) {
            zal(connectionResult, api, z3);
            if (zai()) {
                zaB();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zah(int i) {
        zao(new ConnectionResult(8, null));
    }

    public final /* synthetic */ void zaj(com.google.android.gms.signin.internal.zak zakVar) {
        if (!zaI(0)) {
            return;
        }
        ConnectionResult zaa = zakVar.zaa();
        if (zaa.isSuccess()) {
            com.google.android.gms.common.internal.zaaa zaaaVar = (com.google.android.gms.common.internal.zaaa) Preconditions.checkNotNull(zakVar.zab());
            ConnectionResult zab = zaaaVar.zab();
            if (!zab.isSuccess()) {
                String valueOf = String.valueOf(zab);
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                zao(zab);
                return;
            }
            this.zan = true;
            this.zao = (IAccountAccessor) Preconditions.checkNotNull(zaaaVar.zaa());
            this.zap = zaaaVar.zac();
            this.zaq = zaaaVar.zad();
            zak();
            return;
        }
        if (zan(zaa)) {
            zam();
            zak();
        } else {
            zao(zaa);
        }
    }

    public final /* synthetic */ Set zap() {
        ClientSettings clientSettings = this.zar;
        if (clientSettings == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
        Map zaa = clientSettings.zaa();
        for (Api api : zaa.keySet()) {
            zabd zabdVar = this.zaa;
            if (!zabdVar.zab.containsKey(api.zac())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zae) zaa.get(api)).zaa);
            }
        }
        return hashSet;
    }

    public final /* synthetic */ boolean zaq(int i) {
        return zaI(0);
    }

    public final /* synthetic */ zabd zar() {
        return this.zaa;
    }

    public final /* synthetic */ Lock zas() {
        return this.zab;
    }

    public final /* synthetic */ Context zat() {
        return this.zac;
    }

    public final /* synthetic */ GoogleApiAvailabilityLight zau() {
        return this.zad;
    }

    public final /* synthetic */ com.google.android.gms.signin.zae zav() {
        return this.zak;
    }

    public final /* synthetic */ boolean zaw() {
        return this.zam;
    }

    public final /* synthetic */ IAccountAccessor zax() {
        return this.zao;
    }

    public final /* synthetic */ ClientSettings zay() {
        return this.zar;
    }
}
