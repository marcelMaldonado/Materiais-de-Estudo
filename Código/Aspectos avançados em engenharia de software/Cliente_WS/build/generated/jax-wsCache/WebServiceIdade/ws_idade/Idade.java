
package ws_idade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de idade complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="idade">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idade" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="eMaior" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "idade", propOrder = {
    "idade",
    "eMaior"
})
public class Idade {

    protected int idade;
    protected boolean eMaior;

    /**
     * Obtém o valor da propriedade idade.
     * 
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define o valor da propriedade idade.
     * 
     */
    public void setIdade(int value) {
        this.idade = value;
    }

    /**
     * Obtém o valor da propriedade eMaior.
     * 
     */
    public boolean isEMaior() {
        return eMaior;
    }

    /**
     * Define o valor da propriedade eMaior.
     * 
     */
    public void setEMaior(boolean value) {
        this.eMaior = value;
    }

}
