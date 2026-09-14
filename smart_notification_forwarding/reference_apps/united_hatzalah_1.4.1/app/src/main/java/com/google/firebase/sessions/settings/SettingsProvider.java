package com.google.firebase.sessions.settings;

import O2.a;
import s2.C0684i;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public interface SettingsProvider {

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static boolean isSettingsStale(SettingsProvider settingsProvider) {
            return false;
        }

        public static Object updateSettings(SettingsProvider settingsProvider, InterfaceC0763d interfaceC0763d) {
            return C0684i.f6340a;
        }
    }

    Double getSamplingRate();

    Boolean getSessionEnabled();

    /* renamed from: getSessionRestartTimeout-FghU774 */
    a mo12getSessionRestartTimeoutFghU774();

    boolean isSettingsStale();

    Object updateSettings(InterfaceC0763d interfaceC0763d);
}
