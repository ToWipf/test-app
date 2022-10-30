package com.example.jasmartyapp.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class JsSettings {

    private final String sUrl;
    private final String sCo1_key;
    private final String sCo1_val;
    private final String sCo2_key;
    private final String sCo2_val;

    public JsSettings(String sUrl, String sCo1_key, String sCo1_val, String sCo2_key, String sCo2_val) {
        this.sUrl = sUrl;
        this.sCo1_key = sCo1_key;
        this.sCo1_val = sCo1_val;
        this.sCo2_key = sCo2_key;
        this.sCo2_val = sCo2_val;
    }

    public String toMyString(){
        return sUrl.toString();
    }

    public String getsCo1_key() {
        return sCo1_key;
    }

    public String getsUrl() {
        return sUrl;
    }

    public String getsCo1_val() {
        return sCo1_val;
    }

    public String getsCo2_key() {
        return sCo2_key;
    }

    public String getsCo2_val() {
        return sCo2_val;
    }
}