/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecall;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import sun.jdbc.odbc.ee.ConnectionPoolFactory;

/**
 *
 * @author jose.villagrana
 */
public class RemoteCall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "https://itsm-us-ps.accenture.com/arsys/BackChannel/?param=760/GetQBETableEntryList/12/itsmusps100013/HPD:Help%20Desk17/Default%20User%20View4/102012/itsmusps100013/HPD:Help%20Desk0/1/01/09/2/1/02/-10/2/0/2/0/2/0/239/22/9/3012910007/30009007/17142007/17146009/3012907007/17147009/30126690010/100000039710/10000003987/17154009/3012670007/171530010/100000068710/10000006887/171520010/100000512410/10000051257/30034007/10000317/171480010/10000001619/301399000251/22/29/AST:CMDBAssoc%20CI%20UA%20CMDBAssoc5/INCPS9/BMC.ASSET9/BMC.ASSET25/AST:AssetPeople_AssetBase17/BMC.ASSET.SANDBOX15/INCPS00004859701/01/35/0%20Yes5/INCPS5/0%20Yes5/180005/180005/0%20Yes5/180005/180009/BMC.ASSET11/0%20No%20Action4/1%20No15/INCPS00004859708/1%20Public69/22/1/41/41/41/41/41/41/41/21/21/61/41/61/71/71/61/71/71/41/61/61/41/60/9/3999900881/119/ARRoot14018414435320/2/0/2/0/";
        RemoteCall rc = new RemoteCall();
        /*if(rc.obtenerCodigoFuente(url).contains("Refresh"))
            System.out.println("contains");
        */
        System.out.println(rc.obtenerCodigoFuente(url));
    }

    public String obtenerCodigoFuente(String url) {
        URL urlpagina = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String linea;
        StringBuffer buffer = new StringBuffer();

        try {
            urlpagina = new URL(url);
            isr = new InputStreamReader(urlpagina.openStream());
            br = new BufferedReader(isr);
            while ((linea = br.readLine()) != null) {
                buffer.append(linea);
            }
            br.close();
            isr.close();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Error en la url, ejemplo http://www.java-elrincondetucasa.blogspot.com");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        return buffer.toString();
    }
}
