package com.groboot.mdaemergency.models.location;

/* loaded from: classes.dex */
public class ReportLocationParams {
    public double Accuracy;
    public String City;
    public double Lat;
    public double Lon;
    public String Number;
    public String Provider;
    public int ServiceSender;
    public float Speed;
    public int Status;
    public String Street;

    public ReportLocationParams(android.location.Location location) {
        this.Lat = location.getLatitude();
        this.Lon = location.getLongitude();
        this.Accuracy = location.getAccuracy();
        this.Speed = location.getSpeed();
    }
}
