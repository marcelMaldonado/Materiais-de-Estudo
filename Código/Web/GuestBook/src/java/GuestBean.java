// Fig. 27.20: GuestBean.java
// JavaBean para armazenar dados de um convidado no livro de convidados.
package com.ufjf.si.lab4;

public class GuestBean 
{
   private String firstName;
   private String lastName;
   private String email;

   // configura o nome do convidado
   public void setFirstName( String name )
   {
      firstName = name;  
   } // fim do m�todo setFirstName
   
   // obt�m o nome do convidado
   public String getFirstName()
   {
      return firstName;  
   } // fim do m�todo getFirstName

   // configura o sobrenome do convidado
   public void setLastName( String name )
   {
      lastName = name;  
   } // fim do m�todo setLastName

   // obt�m o sobrenome do convidado
   public String getLastName()
   {
      return lastName;  
   } // fim do m�todo getLastName

   // configura o endere�o de correio eletr�nico do convidado
   public void setEmail( String address )
   {
      email = address;
   } // fim do m�todo setEmail 

   // obt�m o endere�o de correio eletr�nico do convidado
   public String getEmail()
   {
      return email;  
   } // fim do m�todo getEmail 
} // fim da classe GuestBean 


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