// Fig. 27.21: GuestDataBean.java
// Classe GuestDataBean faz uma conex�o de banco de dados e suporta
// inserir dados no banco de dados e recuper�-los.
package com.ufjf.si.lab4;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import com.sun.rowset.CachedRowSetImpl; // implementa��o CachedRowSet

public class GuestDataBean 
{
   private CachedRowSet rowSet;
   
   // constr�i objeto GuestDataBean 
   public GuestDataBean() throws Exception
   {
      // carrega o driver MySQL
      Class.forName( "com.mysql.jdbc.Driver" );
      
      // especifica propriedades de CachedRowSet
      rowSet = new CachedRowSetImpl();  
      rowSet.setUrl( "jdbc:mysql://localhost/pgmc?relaxAutoCommit=true" ); 
      rowSet.setUsername( "root" );
      rowSet.setPassword( "" );

      // obt�m a lista de t�tulos
      rowSet.setCommand( 
         "SELECT firstName, lastName, email FROM guests" );
      rowSet.execute();
   } // fim do construtor GuestDataBean

   // retorna um ArrayList de GuestBeans
   public ArrayList< GuestBean > getGuestList() throws SQLException
   {
      ArrayList< GuestBean > guestList = new ArrayList< GuestBean >();

      rowSet.beforeFirst(); // move cursor antes da primeira linha

      // obt�m dados da linha
      while ( rowSet.next() ) 
      {
         GuestBean guest = new GuestBean();

         guest.setFirstName( rowSet.getString( 1 ) );
         guest.setLastName( rowSet.getString( 2 ) );
         guest.setEmail( rowSet.getString( 3 ) );

         guestList.add( guest ); 
      } // fim do while

      return guestList;
   } // fim do m�todo getGuestList 
   
   // insere um convidado no banco de dados guestbook
   public void addGuest( GuestBean guest ) throws SQLException
   {
      rowSet.moveToInsertRow(); // move cursor para a linha de inser��o

      // atualiza as tr�s colunas da linha de inser��o
      rowSet.updateString( 1, guest.getFirstName() ); 
      rowSet.updateString( 2, guest.getLastName() ); 
      rowSet.updateString( 3, guest.getEmail() ); 
      rowSet.insertRow(); // insere linha a rowSet
      rowSet.moveToCurrentRow(); // move cursor para a linha atual
      rowSet.acceptChanges(); // propaga altera��es para o banco de dados
   } // fim do m�todo addGuest 
} // fim da classe GuestDataBean 


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/