package com.opentok.android;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    protected a f8593a;

    /* renamed from: b, reason: collision with root package name */
    protected b f8594b;

    /* renamed from: c, reason: collision with root package name */
    protected String f8595c;

    /* loaded from: classes.dex */
    public enum a {
        SessionErrorDomain,
        PublisherErrorDomain,
        SubscriberErrorDomain
    }

    /* loaded from: classes.dex */
    public enum b {
        UnknownError(-1),
        AuthorizationFailure(1004),
        InvalidSessionId(1005),
        ConnectionFailed(1006),
        NoMessagingServer(1503),
        ConnectionRefused(1023),
        SessionStateFailed(1020),
        P2PSessionMaxParticipants(1403),
        SessionConnectionTimeout(1021),
        SessionInternalError(2000),
        SessionInvalidSignalType(1461),
        SessionSignalDataTooLong(1413),
        SessionSignalTypeTooLong(1414),
        ConnectionDropped(1022),
        SessionDisconnected(1010),
        PublisherInternalError(2000),
        PublisherWebRTCError(1610),
        PublisherUnableToPublish(1500),
        PublisherUnexpectedPeerConnectionDisconnection(1710),
        PublisherCannotAccessCamera(1650),
        PublisherCameraAccessDenied(1670),
        ConnectionTimedOut(1542),
        SubscriberWebRTCError(1600),
        SubscriberServerCannotFindStream(1604),
        SubscriberStreamLimitExceeded(1605),
        SubscriberInternalError(2000),
        UnknownPublisherInstance(2003),
        UnknownSubscriberInstance(2004),
        SessionNullOrInvalidParameter(1011),
        VideoCaptureFailed(3000),
        CameraFailed(3010),
        VideoRenderFailed(4000),
        SessionSubscriberNotFound(1112),
        SessionPublisherNotFound(1113),
        PublisherTimeout(1541),
        SessionBlockedCountry(1026),
        SessionConnectionLimitExceeded(1027),
        SessionUnexpectedGetSessionInfoResponse(2001),
        SessionIllegalState(1015);

        private int code;

        b(int i10) {
            this.code = i10;
        }

        public static b fromTypeCode(int i10) {
            for (b bVar : values()) {
                if (bVar.getErrorCode() == i10) {
                    return bVar;
                }
            }
            return UnknownError;
        }

        public int getErrorCode() {
            return this.code;
        }
    }

    public i(a aVar, int i10, String str) {
        this.f8595c = str == null ? "(null description)" : str;
        this.f8593a = aVar;
        this.f8594b = b.fromTypeCode(i10);
    }

    public b a() {
        return this.f8594b;
    }

    public a b() {
        return this.f8593a;
    }

    public String c() {
        return this.f8595c;
    }
}
