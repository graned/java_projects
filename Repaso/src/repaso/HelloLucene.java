/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repaso;

/**
 *
 * @author jose.villagrana
 */
import java.io.File;
import org.apache.lucene.*;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;

public class HelloLucene {
  public static void main(String[] args){
      IndexWriter writer = null;
      File dir = new File("C:\\Users\\jose.villagrana\\Desktop\\LuceneTextSearchFiles");
      Document doc = null;
      try {
          //CREAMOS UN  INDICE Y LO ALMACENAMOS EN UN DIRECTORIO
          writer = new IndexWriter(new File("C:\\Users\\jose.villagrana\\Desktop\\LuceneTextSearchFiles\\my_first_index"), new StandardAnalyzer(), true);
      } catch (Exception e) {
      }
  }
}
