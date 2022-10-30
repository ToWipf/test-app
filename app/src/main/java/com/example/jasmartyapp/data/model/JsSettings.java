package com.example.jasmartyapp.data.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class JsSettings {

    private String sUrl;
    private String sCo1_key;
    private String sCo1_val;
    private String sCo2_key;
    private String sCo2_val;

    public JsSettings(String sUrl, String sCo1_key, String sCo1_val, String sCo2_key, String sCo2_val) {
        this.sUrl = sUrl;
        this.sCo1_key = sCo1_key;
        this.sCo1_val = sCo1_val;
        this.sCo2_key = sCo2_key;
        this.sCo2_val = sCo2_val;
    }

    public JsSettings(JSONObject o) {
        try {
            sUrl = o.getString("url");
            sCo1_key = o.getString("c1k");
            sCo1_val = o.getString("c1v");
            sCo2_key = o.getString("c2k");
            sCo2_val = o.getString("c2v");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject toJson() {
        JSONObject o = new JSONObject();
        try {
            o.put("url", sUrl);
            o.put("c1k", sCo1_key);
            o.put("c1v", sCo1_val);
            o.put("c2k", sCo2_key);
            o.put("c2v", sCo2_val);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return o;
    }

    public String getsCo1_key() {
        return sCo1_key.trim();
    }

    public String getsUrl() {
        return sUrl.trim();
    }

    public String getsCo1_val() {
        return sCo1_val.trim();
    }

    public String getsCo2_key() {
        return sCo2_key.trim();
    }

    public String getsCo2_val() {
        return sCo2_val.trim();
    }
}