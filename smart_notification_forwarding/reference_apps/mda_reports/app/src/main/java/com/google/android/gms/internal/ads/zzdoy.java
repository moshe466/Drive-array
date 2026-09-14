package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpb;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class zzdoy<T_WRAPPER extends zzdpb<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzdoy.class.getName());
    private static final List<Provider> zzhgf;
    public static final zzdoy<zzdpa, Cipher> zzhgg;
    public static final zzdoy<zzdpe, Mac> zzhgh;
    private static final zzdoy<zzdpg, Signature> zzhgi;
    private static final zzdoy<zzdph, MessageDigest> zzhgj;
    public static final zzdoy<zzdpd, KeyAgreement> zzhgk;
    public static final zzdoy<zzdpf, KeyPairGenerator> zzhgl;
    public static final zzdoy<zzdpc, KeyFactory> zzhgm;
    private T_WRAPPER zzhgn;
    private List<Provider> zzhgo = zzhgf;
    private boolean zzhgp = true;

    static {
        if (zzdpp.zzaxh()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            zzhgf = arrayList;
        } else {
            zzhgf = new ArrayList();
        }
        zzhgg = new zzdoy<>(new zzdpa());
        zzhgh = new zzdoy<>(new zzdpe());
        zzhgi = new zzdoy<>(new zzdpg());
        zzhgj = new zzdoy<>(new zzdph());
        zzhgk = new zzdoy<>(new zzdpd());
        zzhgl = new zzdoy<>(new zzdpf());
        zzhgm = new zzdoy<>(new zzdpc());
    }

    private zzdoy(T_WRAPPER t_wrapper) {
        this.zzhgn = t_wrapper;
    }

    public final T_ENGINE zzhd(String str) {
        Iterator<Provider> it = this.zzhgo.iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return (T_ENGINE) this.zzhgn.zza(str, it.next());
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.zzhgp) {
            return (T_ENGINE) this.zzhgn.zza(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
