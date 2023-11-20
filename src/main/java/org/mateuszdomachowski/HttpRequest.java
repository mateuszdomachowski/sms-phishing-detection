package org.mateuszdomachowski;

import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpRequest {

    private final String API_KEY = "any_api_key_google_may_generate";

    public String sendHttpPostRequest(String postJson){

        StringBuilder response = new StringBuilder();

        try {

            // Open a connection to the specified URL
            URL url = new URL("https://webrisk.googleapis.com/v1eap1:evaluateUri?key=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Enable input and output streams for reading/writing data
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Set request headers (optional)
            connection.setRequestProperty("Content-Type", "application/json");

            // Create the POST data (in this example, we're sending JSON data)


            // Get the output stream of the connection and write the data to it
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(postJson);
                outputStream.flush();
            }

            // Get the response code from the server
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the server
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Response: " + response);
            }

            // Close the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.toString();
    }
//    {
//  "scores": [
//    {
//      "threatType": "MALWARE",
//      "confidenceLevel": "EXTREMELY_HIGH"
//    }
//  ]
//}
}
