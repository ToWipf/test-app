package com.example.jasmartyapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class SaveSettings {
// TODO fix path
//Environment.getDataDirectory().getAbsolutePath()  + File.separator

    public String read() {
        String sOut = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("/data/data/com.example.jasmartyapp/settings.txt"));
            sOut = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sOut;
    }

    public void write(String sData) {
        File file = new File("/data/data/com.example.jasmartyapp/settings.txt");
        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(sData.getBytes());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
