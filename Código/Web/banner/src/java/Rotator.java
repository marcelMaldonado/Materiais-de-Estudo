// Fig. 27.14: Rotator.Java
// Um JavaBean que faz rota��o de an�ncios.
package com.deitel.jhtp6.jsp.beans;

public class Rotator 
{
   private String images[] = { "images/globo.jpg",
      "images/flamengo.jpeg", "images/ufc.jpg"};
      
   private String links[] = {
      "http://www.globoesporte.globo.com/",
      "http://www.flamengo.com.br/",
      "http://www.ufc.com.br/"};
         
   private int selectedIndex = 0;

   // retorna o nome do arquivo de imagem ao an�ncio atual
   public String getImage()
   {
      return images[ selectedIndex ];
   } // fim do m�todo getImage 

   // retorna o URL ao site Web correspondente ao an�ncio
   public String getLink()
   {
      return links[ selectedIndex ];
   } // fim do m�todo getLink 

   // atualiza selectedIndex assim as pr�ximas chamadas para getImage e
   // getLink retornam um an�ncio diferente
   public void nextAd()
   {
      selectedIndex = ( selectedIndex + 1 ) % images.length;
   } // fim do m�todo nextAd 
} // fim da classe Rotator 


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