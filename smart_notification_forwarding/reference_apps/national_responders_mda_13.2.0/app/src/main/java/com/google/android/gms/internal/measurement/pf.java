package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import j2.a;

/* loaded from: classes.dex */
public abstract class pf extends v0 implements qf {
    public pf() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static qf asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof qf ? (qf) queryLocalInterface : new sf(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.v0
    protected final boolean i(int i10, Parcel parcel, Parcel parcel2, int i11) {
        rf tfVar;
        rf rfVar = null;
        rf rfVar2 = null;
        rf rfVar3 = null;
        c cVar = null;
        c cVar2 = null;
        c cVar3 = null;
        rf rfVar4 = null;
        rf rfVar5 = null;
        rf rfVar6 = null;
        rf rfVar7 = null;
        rf rfVar8 = null;
        rf rfVar9 = null;
        d dVar = null;
        rf rfVar10 = null;
        rf rfVar11 = null;
        rf rfVar12 = null;
        rf rfVar13 = null;
        switch (i10) {
            case 1:
                initialize(a.AbstractBinderC0212a.n(parcel.readStrongBinder()), (f) v.a(parcel, f.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) v.a(parcel, Bundle.CREATOR), v.e(parcel), v.e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) v.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    tfVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    tfVar = queryLocalInterface instanceof rf ? (rf) queryLocalInterface : new tf(readStrongBinder);
                }
                logEventAndBundle(readString, readString2, bundle, tfVar, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), a.AbstractBinderC0212a.n(parcel.readStrongBinder()), v.e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean e10 = v.e(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar = queryLocalInterface2 instanceof rf ? (rf) queryLocalInterface2 : new tf(readStrongBinder2);
                }
                getUserProperties(readString3, readString4, e10, rfVar);
                parcel2.writeNoException();
                return true;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar13 = queryLocalInterface3 instanceof rf ? (rf) queryLocalInterface3 : new tf(readStrongBinder3);
                }
                getMaxUserProperties(readString5, rfVar13);
                parcel2.writeNoException();
                return true;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 8:
                setConditionalUserProperty((Bundle) v.a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) v.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar12 = queryLocalInterface4 instanceof rf ? (rf) queryLocalInterface4 : new tf(readStrongBinder4);
                }
                getConditionalUserProperties(readString6, readString7, rfVar12);
                parcel2.writeNoException();
                return true;
            case 11:
                setMeasurementEnabled(v.e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 12:
                resetAnalyticsData(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 15:
                setCurrentScreen(a.AbstractBinderC0212a.n(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar11 = queryLocalInterface5 instanceof rf ? (rf) queryLocalInterface5 : new tf(readStrongBinder5);
                }
                getCurrentScreenName(rfVar11);
                parcel2.writeNoException();
                return true;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar10 = queryLocalInterface6 instanceof rf ? (rf) queryLocalInterface6 : new tf(readStrongBinder6);
                }
                getCurrentScreenClass(rfVar10);
                parcel2.writeNoException();
                return true;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    dVar = queryLocalInterface7 instanceof d ? (d) queryLocalInterface7 : new g(readStrongBinder7);
                }
                setInstanceIdProvider(dVar);
                parcel2.writeNoException();
                return true;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar9 = queryLocalInterface8 instanceof rf ? (rf) queryLocalInterface8 : new tf(readStrongBinder8);
                }
                getCachedAppInstanceId(rfVar9);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar8 = queryLocalInterface9 instanceof rf ? (rf) queryLocalInterface9 : new tf(readStrongBinder9);
                }
                getAppInstanceId(rfVar8);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar7 = queryLocalInterface10 instanceof rf ? (rf) queryLocalInterface10 : new tf(readStrongBinder10);
                }
                getGmpAppId(rfVar7);
                parcel2.writeNoException();
                return true;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar6 = queryLocalInterface11 instanceof rf ? (rf) queryLocalInterface11 : new tf(readStrongBinder11);
                }
                generateEventId(rfVar6);
                parcel2.writeNoException();
                return true;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 25:
                onActivityStarted(a.AbstractBinderC0212a.n(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 26:
                onActivityStopped(a.AbstractBinderC0212a.n(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 27:
                onActivityCreated(a.AbstractBinderC0212a.n(parcel.readStrongBinder()), (Bundle) v.a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 28:
                onActivityDestroyed(a.AbstractBinderC0212a.n(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 29:
                onActivityPaused(a.AbstractBinderC0212a.n(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 30:
                onActivityResumed(a.AbstractBinderC0212a.n(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 31:
                j2.a n10 = a.AbstractBinderC0212a.n(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar5 = queryLocalInterface12 instanceof rf ? (rf) queryLocalInterface12 : new tf(readStrongBinder12);
                }
                onActivitySaveInstanceState(n10, rfVar5, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 32:
                Bundle bundle2 = (Bundle) v.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar4 = queryLocalInterface13 instanceof rf ? (rf) queryLocalInterface13 : new tf(readStrongBinder13);
                }
                performAction(bundle2, rfVar4, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), a.AbstractBinderC0212a.n(parcel.readStrongBinder()), a.AbstractBinderC0212a.n(parcel.readStrongBinder()), a.AbstractBinderC0212a.n(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    cVar3 = queryLocalInterface14 instanceof c ? (c) queryLocalInterface14 : new e(readStrongBinder14);
                }
                setEventInterceptor(cVar3);
                parcel2.writeNoException();
                return true;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    cVar2 = queryLocalInterface15 instanceof c ? (c) queryLocalInterface15 : new e(readStrongBinder15);
                }
                registerOnMeasurementEventListener(cVar2);
                parcel2.writeNoException();
                return true;
            case androidx.constraintlayout.widget.j.f1983h1 /* 36 */:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    cVar = queryLocalInterface16 instanceof c ? (c) queryLocalInterface16 : new e(readStrongBinder16);
                }
                unregisterOnMeasurementEventListener(cVar);
                parcel2.writeNoException();
                return true;
            case 37:
                initForTests(v.f(parcel));
                parcel2.writeNoException();
                return true;
            case androidx.constraintlayout.widget.j.W4 /* 38 */:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar3 = queryLocalInterface17 instanceof rf ? (rf) queryLocalInterface17 : new tf(readStrongBinder17);
                }
                getTestFlag(rfVar3, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case androidx.constraintlayout.widget.j.X4 /* 39 */:
                setDataCollectionEnabled(v.e(parcel));
                parcel2.writeNoException();
                return true;
            case androidx.constraintlayout.widget.j.Y4 /* 40 */:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    rfVar2 = queryLocalInterface18 instanceof rf ? (rf) queryLocalInterface18 : new tf(readStrongBinder18);
                }
                isDataCollectionEnabled(rfVar2);
                parcel2.writeNoException();
                return true;
            case androidx.constraintlayout.widget.j.Z4 /* 41 */:
            default:
                return false;
            case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
                setDefaultEventParameters((Bundle) v.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case androidx.constraintlayout.widget.j.f1939b5 /* 43 */:
                clearMeasurementEnabled(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case androidx.constraintlayout.widget.j.f1947c5 /* 44 */:
                setConsent((Bundle) v.a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case androidx.constraintlayout.widget.j.f1955d5 /* 45 */:
                setConsentThirdParty((Bundle) v.a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
        }
    }
}
