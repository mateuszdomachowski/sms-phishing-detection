package org.mateuszdomachowski;

public class Main {
    public static void main(String[] args) {


        //1. zapętl funkcję wysłania
        //2. sprawdź czy dany numer ma włączoną funkcję filtrowania zewnętrznych URLi
        //3. jeśli ma to wyślij reqest z body
        //4. jeśli dany URL nie jest phishingiem to pozwól wysłać smsa do odbiorcy, jeśli nie jest to nie wysyłaj

        //1. zaimplementować metodę która pozwala użytkownikowi aktywować usługę filtracji URli

    }

    static Sms sms = new Sms();
    static HttpRequest httpRequest = new HttpRequest();

    public static void runApplication(){
        sms.getSmsList(){
            httpRequest.sendHttpPostRequest();
        }

    }

}