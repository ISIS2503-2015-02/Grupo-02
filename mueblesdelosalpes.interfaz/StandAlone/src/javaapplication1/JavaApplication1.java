/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author pa.sarmiento10
 */
public class JavaApplication1 {

    private  String url1 = "http://localhost:8080/mueblesdelosalpes.servicios/webresources/Tranvia/tranvias/cambiar/tranvia29/1/100";

  public  void principal(String idTranvia, String emergencia, String valor) {
   
      
      String r=idTranvia+"/"+emergencia+"/"+valor;
      url1="http://localhost:8080/mueblesdelosalpes.servicios/webresources/Tranvia/tranvias/cambiar/"+r;
      System.out.println(url1);
        try {
            hola();
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
//HttpClient client = new HttpClient();
//PutMethod put = new PutMethod(url);
//put.releaseConnection();
     
}
  
 public  void hola() throws java.net.ProtocolException, IOException
 {
     URL url = new URL(url1);
HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
httpCon.setDoOutput(true);
httpCon.setRequestMethod("PUT");
OutputStreamWriter out = new OutputStreamWriter(
    httpCon.getOutputStream());
out.write("Resource content");
out.close();
httpCon.getInputStream();
 }
          
}