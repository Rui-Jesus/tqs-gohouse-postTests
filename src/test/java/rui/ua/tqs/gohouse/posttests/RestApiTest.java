/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rui.ua.tqs.gohouse.posttests;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author demo
 */
public class RestApiTest {
    private String URLPath;
    
    @Before
    public void setUp(){
        URLPath = "http://192.168.160.224:8080/tqs-gohouse-1.0-SNAPSHOT/REST";
    }
    
    @Test
    public void testGetUsersReturnsAnything(){
        try {
            OkHttpClient client = new OkHttpClient();
            
            Request request = new Request.Builder()
                    .url(URLPath + "/users")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "6fc989f2-fecf-eb44-3049-a4af8616e1c2")
                    .build();
            
            Response response = client.newCall(request).execute();
            System.out.println("Resultado: " + response.body().string());
            assertTrue("Deverá dar o OK...",response.isSuccessful());
        } catch (IOException ex) {
            Logger.getLogger(RestApiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testGetPropertiesReturnsAnything(){
        try {
            OkHttpClient client = new OkHttpClient();
            
            Request request = new Request.Builder()
                    .url(URLPath + "/properties")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "6fc989f2-fecf-eb44-3049-a4af8616e1c2")
                    .build();
            
            Response response = client.newCall(request).execute();
            System.out.println("Resultado: " + response.body().string());
            assertTrue("testGetPropertiesReturnsAnything",response.isSuccessful());
        } catch (IOException ex) {
            Logger.getLogger(RestApiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testGetUnverifiedPropertiesReturnsAnything(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
          .url(URLPath
                  + "/properties/unverified")
          .get()
          .addHeader("cache-control", "no-cache")
          .addHeader("postman-token", "6fc989f2-fecf-eb44-3049-a4af8616e1c2")
          .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Resultado: " + response.body().string());
            assertTrue("testGetUnverifiedPropertiesReturnsAnything",response.isSuccessful());
        } catch (IOException ex) {
            Logger.getLogger(RestApiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        @Test
    public void testPOSTDummyUser(){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"email\" : \"asdf\",\n\t\"password\" : \"aaa\",\n\t\"isDelegate\" : \"true\",\n\t\"name\" : \"Bill\"\n}");
        Request request = new Request.Builder()
          .url(URLPath + "/users")
          .post(body)
          .addHeader("content-type", "application/json")
          .addHeader("cache-control", "no-cache")
          .addHeader("postman-token", "3d9b96a6-6de0-aa88-4655-911358ab257a")
          .build();

        Response response;
        try {
            response = client.newCall(request).execute();  
            System.out.println("Resultado: " + response.body().string());
            assertTrue("testPOSTDummyUser",response.isSuccessful());
        } catch (IOException ex) {
            Logger.getLogger(RestApiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetUserByEmailReturnsAnything(){
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(URLPath + "/users/dummyMan@dummy.dum")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "6fc989f2-fecf-eb44-3049-a4af8616e1c2")
                    .build();
            
            Response response = client.newCall(request).execute();
            System.out.println("Resultado: " + response.body().string());
            assertTrue("Deverá dar o OK...",response.isSuccessful());
        } catch (IOException ex) {
            Logger.getLogger(RestApiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testGetNPopularUsersReturnsAnything(){
        try {
            OkHttpClient client = new OkHttpClient();
            
            Request request = new Request.Builder()
                    .url(URLPath + "/users/popular:3")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "6fc989f2-fecf-eb44-3049-a4af8616e1c2")
                    .build();
            
            Response response = client.newCall(request).execute();
            System.out.println("Resultado: " + response.body().string());
            assertTrue("Deverá dar o OK...",response.isSuccessful());
        } catch (IOException ex) {
            Logger.getLogger(RestApiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testRatePropertyWorks(){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"delegate\" :1,\n\t\"id\" : 1,\n\t\"rate\" : 2\n}");
        Request request = new Request.Builder()
          .url("http://localhost:8080/tqs-gohouse-1.0-SNAPSHOT/REST/properties/rate")
          .post(body)
          .addHeader("content-type", "application/json")
          .addHeader("cache-control", "no-cache")
          .addHeader("postman-token", "0f726959-9e9f-bfe0-687c-811118a60238")
          .build();

        Response response;
        try {
            response = client.newCall(request).execute();  
            System.out.println("Resultado: " + response.body().string());
            assertTrue("testRatePropertyWorks",response.isSuccessful());
        } catch (IOException ex) {
            Logger.getLogger(RestApiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
