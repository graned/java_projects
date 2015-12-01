/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testPackage;

/**
 *
 * @author jose.villagrana
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SimpleHTTPRequest {

  /**
   * @param args
   */
  public static void main(String[] args) {
      HttpURLConnection connection = null;
      OutputStreamWriter wr = null;
      BufferedReader rd  = null;
      StringBuilder sb = null;
      String line = null;
    
      URL serverAddress = null;
    
      String page = "https://login.microsoftonline.com/login.srf?wa=wsignin1.0&rpsnv=3&ct=1402443103&rver=6.1.6206.0&wp=MBI_SSL&wreply=https:%2F%2Fpod51041.outlook.com%2Fowa%2F&id=260563&whr=calheers.ca.gov&CBCXT=out";
      try {
          serverAddress = new URL("https://www.linkedin.com/nhome/");
          //set up out communications stuff
          connection = null;
        
          //Set up the initial connection
          connection = (HttpURLConnection)serverAddress.openConnection();
          connection.setRequestMethod("GET");
          connection.setDoOutput(true);
          connection.setReadTimeout(10000);
                    
          connection.connect();
        
          //get the output stream writer and write the output to the server
          //not needed in this example
          //wr = new OutputStreamWriter(connection.getOutputStream());
          //wr.write("");
          //wr.flush();
        
          //read the result from the server
          rd  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          sb = new StringBuilder();
        
          while ((line = rd.readLine()) != null)
          {
              sb.append(line + '\n');
          }
        
          System.out.println(sb.toString());
                    
      } catch (MalformedURLException e) {
          e.printStackTrace();
      } catch (ProtocolException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
      finally
      {
          //close the connection, set all objects to null
          connection.disconnect();
          rd = null;
          sb = null;
          wr = null;
          connection = null;
      }
  }
}