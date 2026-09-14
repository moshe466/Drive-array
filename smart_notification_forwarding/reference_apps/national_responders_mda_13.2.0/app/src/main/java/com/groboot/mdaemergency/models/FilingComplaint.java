package com.groboot.mdaemergency.models;

import java.util.Date;

/* loaded from: classes.dex */
public class FilingComplaint {
    Date birthDate;
    String conanCode;
    String description;
    String email;
    String firstName;
    String id;
    String lastName;
    String phone;

    public FilingComplaint(String str, String str2, String str3, String str4, Date date, String str5, String str6, String str7) {
        this.firstName = str;
        this.lastName = str2;
        this.id = str3;
        this.phone = str4;
        this.birthDate = date;
        this.email = str5;
        this.conanCode = str6;
        this.description = str7;
    }
}
