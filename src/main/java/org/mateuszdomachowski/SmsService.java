package org.mateuszdomachowski;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsService {

    public JSONObject createJsonToSend(JSONObject smsJson){

        if (getURLFromSMS(smsJson) !=null){

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("uri", getURLFromSMS(smsJson));

            JSONArray jsonArray = new JSONArray();
            jsonArray.put("SOCIAL_ENGINEERING");
            jsonArray.put("MALWARE");
            jsonArray.put("UNWANTED_SOFTWARE");

            jsonObject.put("threatTypes", jsonArray);

            return jsonObject;
        }else {
            return null;
        }
    }

    public String getURLFromSMS(JSONObject jsonObject){

        Pattern pattern = Pattern.compile("\\b(?:https?):\\/\\/[-A-Za-z0-9+&@#\\/%?=~_|!:,.;]*[-A-Za-z0-9+&@#\\/%=~_|]");
        Matcher matcher = pattern.matcher(jsonObject.getString("message"));
        return matcher.find() ? matcher.group() : null;
    }

    public String getRecipientNumberFromSms(JSONObject jsonObject){

        String recipientNumber = jsonObject.getString("recipient");
        return recipientNumber.isEmpty() ? null : recipientNumber;
    }
}
