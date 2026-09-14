package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class Message {
    public String HtmlContent;
    public int HtmlOpen;
    public int HtmlType;
    public String HtmlURL;
    public boolean IsNew;
    public String MessageID;
    public String MessageText;
    public boolean ZoomEnable;

    /* loaded from: classes.dex */
    public static class HTMLUrlTypes {
        public static final int ExternalUrl = 6;
        public static final int GET_CONTENT = 3;
        public static final int HTML_CONTENT = 1;
        public static final int PDF = 4;
        public static final int PTT = 8;
        public static final int URL = 2;
        public static final int Upload = 7;
        public static final int Video = 5;
    }

    /* loaded from: classes.dex */
    public static class MessageWindowTypes {
        public static final int FULL_WINDOW = 2;
        public static final int NO_WINDOW = 0;
        public static final int POPUP_WINDOW = 1;
    }
}
