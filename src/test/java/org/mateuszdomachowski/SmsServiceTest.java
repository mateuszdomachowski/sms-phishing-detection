package org.mateuszdomachowski;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmsServiceTest {

    SmsService smsService = new SmsService();

    @Test
    void createJsonToSendTest(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sender", "234100200300");
        jsonObject.put("recipient", "48700800999");
        jsonObject.put("message", "Dzień dobry. W związku z audytem nadzór finansowy w naszym banku " +
                "proszą o potwierdzanie danych pod adresem: https://www.m-bonk.pl.ng/personal-data");

        assertEquals("https://www.m-bonk.pl.ng/personal-data", smsService.createJsonToSend(jsonObject).getString("uri"));

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("SOCIAL_ENGINEERING");
        jsonArray.put("MALWARE");
        jsonArray.put("UNWANTED_SOFTWARE");

        assertTrue(smsService.createJsonToSend(jsonObject).getJSONArray("threatTypes").similar(jsonArray));
    }

    @Test
    void createJsonToSendTest_IfNoUrl(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sender", "234100200300");
        jsonObject.put("recipient", "48700800999");
        jsonObject.put("message", "Dzień dobry. W związku z audytem nadzór finansowy w naszym banku " +
                "proszą o potwierdzanie danych pod adresem.");

        assertEquals(null, smsService.createJsonToSend(jsonObject));
    }

    @Test
    void getURLFromSMSTest_WithURL() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sender", "234100200300");
        jsonObject.put("recipient", "48700800999");
        jsonObject.put("message", "Dzień dobry. W związku z audytem nadzór finansowy w naszym banku " +
                "proszą o potwierdzanie danych pod adresem: https://www.m-bonk.pl.ng/personal-data");

        assertEquals("https://www.m-bonk.pl.ng/personal-data", smsService.getURLFromSMS(jsonObject));
    }
    @Test
    void getURLFromSMSTest_WithoutURL() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sender", "234100200300");
        jsonObject.put("recipient", "48700800999");
        jsonObject.put("message", "Dzień dobry. W związku z audytem nadzór finansowy w naszym banku " +
                "proszą o potwierdzanie danych pod adresem");

        assertEquals(null, smsService.getURLFromSMS(jsonObject));
    }
    @Test
    void getURLFromSMSTest_EmptyMessage() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sender", "234100200300");
        jsonObject.put("recipient", "48700800999");
        jsonObject.put("message", "");

        assertEquals(null, smsService.getURLFromSMS(jsonObject));
    }
    @Test
    void getRecipientNumberFromSmsTest() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sender", "234100200300");
        jsonObject.put("recipient", "48700800999");
        jsonObject.put("message", "Dzień dobry. W związku z audytem nadzór finansowy w naszym banku " +
                "proszą o potwierdzanie danych pod adresem: https://www.m-bonk.pl.ng/personal-data");

        assertEquals("48700800999", smsService.getRecipientNumberFromSms(jsonObject));
    }

    @Test
    void getRecipientNumberFromSmsTest_EmptyNumber() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sender", "234100200300");
        jsonObject.put("recipient", "");
        jsonObject.put("message", "Dzień dobry. W związku z audytem nadzór finansowy w naszym banku " +
                "proszą o potwierdzanie danych pod adresem: https://www.m-bonk.pl.ng/personal-data");

        assertEquals(null, smsService.getRecipientNumberFromSms(jsonObject));
    }
}