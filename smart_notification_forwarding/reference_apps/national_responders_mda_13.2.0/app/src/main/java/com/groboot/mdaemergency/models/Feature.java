package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class Feature<T> {
    public int Badge;
    public int Close;
    public String Content;
    public String Data;
    public String Description;
    public String FeatureID;
    public int FeatureType;
    public int HtmlOpen;
    public int HtmlType;
    public int IconID;
    public String MessageID;
    public int Refresh;
    public String URL;
    public boolean isAdded;
    public boolean isLocally;
    public T object;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7717a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f7718b;

        static {
            int[] iArr = new int[eRefresh.values().length];
            f7718b = iArr;
            try {
                iArr[eRefresh.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7718b[eRefresh.SyncWithAnswer.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7718b[eRefresh.SyncWithoutAnswer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[eClose.values().length];
            f7717a = iArr2;
            try {
                iArr2[eClose.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7717a[eClose.CloseMenue.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7717a[eClose.CloseApp.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum eClose {
        None,
        CloseMenue,
        CloseApp;

        public int toInt() {
            int i10 = a.f7717a[ordinal()];
            if (i10 != 2) {
                return i10 != 3 ? 0 : 2;
            }
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public enum eFeatureType {
        GetMessage(1),
        ReportMessage(2),
        Disabled(3),
        PTT(4),
        FileExplorer(5),
        WhatsNew(6),
        Home(7),
        Availability(8, "11"),
        Settings(9, "12"),
        Bike(10, ""),
        Events(11, ""),
        Zoom(12, ""),
        CoronaBarcode(13, ""),
        CoronaTester(14, ""),
        PrintCoronaBarcode(16, ""),
        SamplesSummeryCorona(17, ""),
        WhatApp(18, ""),
        EligibilityCheck(19, ""),
        ReportCovidIsolation(20, "");

        int id;
        String shortcutId;

        eFeatureType(int i10) {
            this.shortcutId = null;
            this.id = i10;
        }

        eFeatureType(int i10, String str) {
            this.shortcutId = null;
            this.id = i10;
            this.shortcutId = str;
        }

        public static eFeatureType getById(int i10) {
            for (eFeatureType efeaturetype : values()) {
                if (efeaturetype.id == i10) {
                    return efeaturetype;
                }
            }
            return null;
        }

        public int getId() {
            return this.id;
        }
    }

    /* loaded from: classes.dex */
    public enum eRefresh {
        None,
        SyncWithAnswer,
        SyncWithoutAnswer;

        public int toInt() {
            int i10 = a.f7718b[ordinal()];
            int i11 = 1;
            if (i10 != 1) {
                i11 = 2;
                if (i10 != 2) {
                    i11 = 3;
                    if (i10 != 3) {
                        return 0;
                    }
                }
            }
            return i11;
        }
    }

    public Feature() {
        this.MessageID = "";
        this.Description = "";
        this.HtmlOpen = 0;
        this.HtmlType = 0;
        this.Content = "";
        this.URL = "";
        this.isAdded = false;
        this.isLocally = false;
        this.Badge = -1;
    }

    public Feature(int i10) {
        this.MessageID = "";
        this.Description = "";
        this.HtmlOpen = 0;
        this.HtmlType = 0;
        this.Content = "";
        this.URL = "";
        this.isAdded = false;
        this.isLocally = false;
        this.Badge = -1;
        this.FeatureType = i10;
    }

    public Feature(String str, int i10) {
        this.MessageID = "";
        this.Description = "";
        this.HtmlOpen = 0;
        this.HtmlType = 0;
        this.Content = "";
        this.URL = "";
        this.isAdded = false;
        this.isLocally = false;
        this.Badge = -1;
        this.Description = str;
        this.IconID = i10;
        this.isAdded = true;
        this.isLocally = true;
    }

    public Feature(String str, int i10, int i11) {
        this.MessageID = "";
        this.Description = "";
        this.HtmlOpen = 0;
        this.HtmlType = 0;
        this.Content = "";
        this.URL = "";
        this.isAdded = false;
        this.isLocally = false;
        this.Badge = -1;
        this.MessageID = str;
        this.HtmlType = i10;
        this.HtmlOpen = i11;
    }

    public Feature(String str, int i10, eFeatureType efeaturetype) {
        this.MessageID = "";
        this.Description = "";
        this.HtmlOpen = 0;
        this.HtmlType = 0;
        this.Content = "";
        this.URL = "";
        this.isAdded = false;
        this.isLocally = false;
        this.Badge = -1;
        this.Description = str;
        this.IconID = i10;
        this.FeatureType = efeaturetype.getId();
        this.isAdded = true;
    }

    public Feature(String str, String str2, int i10, eFeatureType efeaturetype, boolean z10) {
        this.MessageID = "";
        this.Description = "";
        this.HtmlOpen = 0;
        this.HtmlType = 0;
        this.Content = "";
        this.URL = "";
        this.isAdded = false;
        this.isLocally = false;
        this.Badge = -1;
        this.FeatureID = str;
        this.Description = str2;
        this.IconID = i10;
        this.FeatureType = efeaturetype.getId();
        this.isAdded = z10;
    }

    public Feature(String str, String str2, eFeatureType efeaturetype, int i10, T t10) {
        this.MessageID = "";
        this.Description = "";
        this.HtmlOpen = 0;
        this.HtmlType = 0;
        this.Content = "";
        this.URL = "";
        this.isAdded = false;
        this.isLocally = false;
        this.Badge = -1;
        this.FeatureID = str;
        this.Description = str2;
        this.IconID = i10;
        this.FeatureType = efeaturetype.getId();
        this.object = t10;
        this.isAdded = true;
        this.isLocally = true;
    }

    public String getContent() {
        return this.Content;
    }

    public String getDescription() {
        return this.Description;
    }

    public int getHtmlOpen() {
        return this.HtmlOpen;
    }

    public int getHtmlType() {
        return this.HtmlType;
    }

    public String getMessageID() {
        return this.MessageID;
    }

    public void setIsAdded(boolean z10) {
        this.isAdded = z10;
    }

    public Message toMessage() {
        Message message = new Message();
        message.HtmlContent = getContent();
        message.HtmlType = getHtmlType();
        message.HtmlOpen = getHtmlOpen();
        message.MessageID = getMessageID();
        return message;
    }
}
