package com.kss.stripe.utils;

import com.stripe.Stripe;
import com.stripe.model.Account;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StripeConnectUtils {

    private static final String CLIENTID = "<Enter your Client ID here>";
    private static final String CLIENTSECRETE = "<Enter Your Clienty Secrete here>";
    private static final String REDIRECTURL = "https://<your-domain>/stripe.html";
    private static final String SCOPE = "read_write";

    public static String authorizationUrl() {
        return "https://connect.stripe.com/oauth/authorize?response_type=code&client_id=" + CLIENTID + "&scope=read_write&redirect_uri=" + REDIRECTURL;
    }

    public static Account getAccountDetails(String accId) throws Exception {
        Stripe.apiKey = CLIENTSECRETE;
        return Account.retrieve(accId, null);
    }

    public static String generateTokenFromCode(String code) throws Exception {
        String url = "https://connect.stripe.com/oauth/token";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("grant_type", "authorization_code"));
        urlParameters.add(new BasicNameValuePair("code", code));
        urlParameters.add(new BasicNameValuePair("client_secret", CLIENTSECRETE));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        //Set response type
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    public static String deauthorizeStripe(String stripeUserId) throws Exception {
        String url = "https://connect.stripe.com/oauth/deauthorize";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Bearer " + CLIENTSECRETE);
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("client_id", CLIENTID));
        urlParameters.add(new BasicNameValuePair("stripe_user_id", stripeUserId));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        //Set response type
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        String code = "<Enter obtained code here>";
        String stripeUserId = "<Enter Stripe User ID here>";
        String s = "";
        // uncomment below methods one by one on getting successfull results
        s = authorizationUrl();
        //s = generateTokenFromCode(code);
        //s = deauthorizeStripe(stripeUSerId);
        System.out.println("Result:   " + s);

    }
}
