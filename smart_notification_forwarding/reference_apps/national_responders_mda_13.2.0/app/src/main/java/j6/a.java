package j6;

/* loaded from: classes.dex */
public enum a {
    ADD_COVID_TEST("AddCovidTest"),
    UPDATE_COVID_TEST("UpdateCovidTest"),
    ADD_EXPOSURE("AddExposure"),
    UPDATE_EXPOSURE("UpdateExposure"),
    ADD_VERIFIED_PATIENT("AddVerifiedCovidPatient"),
    UPDATE_VERIFIED_PATIENT("UpdateVerifiedCovidPatient"),
    GET_USER_REPORTS("GetUserReports");

    private final String val;

    a(String str) {
        this.val = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.val;
    }
}
