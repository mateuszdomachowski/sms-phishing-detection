package org.mateuszdomachowski;

import org.json.JSONObject;

import java.util.ArrayList;

public class Sms {


    private ArrayList<JSONObject> smsList = new ArrayList<>();

    public Sms() {
        fillArrayWithSMS();
    }

    public ArrayList<JSONObject> getSmsList() {
        return smsList;
    }

    private void fillArrayWithSMS(){

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("sender", "234100200300");
        jsonObject1.put("recipient", "48700800999");
        jsonObject1.put("message", "Dzień dobry. W związku z audytem nadzór finansowy w naszym banku " +
                "proszą o potwierdzanie danych pod adresem: https://www.m-bonk.pl.ng/personal-data");
        smsList.add(jsonObject1);

        JSONObject jsonObject2= new JSONObject();
        jsonObject2.put("sender", "111111111111");
        jsonObject2.put("recipient", "48700123456");
        jsonObject2.put("message", "Test wiadomości Sms. Kliknij w link: https://www.bonkmillenum.bank");
        smsList.add(jsonObject2);

        JSONObject jsonObject3= new JSONObject();
        jsonObject3.put("sender", "222222222222");
        jsonObject3.put("recipient", "48900200399");
        jsonObject3.put("message", "Test wiadomości Sms. Kliknij w link: https://www.nowybank.true/no_virus");
        smsList.add(jsonObject3);
    }



}
