package gts.com.mobile.models;

import java.io.Serializable;

public class Itineraire implements Serializable {
    private int id;
    private double lat;
    private double lon;
    private String address;

    public Itineraire(int id, double lat, double lon, String address) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
