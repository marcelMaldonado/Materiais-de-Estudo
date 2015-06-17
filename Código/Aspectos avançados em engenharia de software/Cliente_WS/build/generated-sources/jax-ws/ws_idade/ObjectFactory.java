
package ws_idade;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws_idade package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Executa_QNAME = new QName("http://WS_Idade/", "executa");
    private final static QName _ExecutaResponse_QNAME = new QName("http://WS_Idade/", "executaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws_idade
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Executa }
     * 
     */
    public Executa createExecuta() {
        return new Executa();
    }

    /**
     * Create an instance of {@link ExecutaResponse }
     * 
     */
    public ExecutaResponse createExecutaResponse() {
        return new ExecutaResponse();
    }

    /**
     * Create an instance of {@link Idade }
     * 
     */
    public Idade createIdade() {
        return new Idade();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Executa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS_Idade/", name = "executa")
    public JAXBElement<Executa> createExecuta(Executa value) {
        return new JAXBElement<Executa>(_Executa_QNAME, Executa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecutaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS_Idade/", name = "executaResponse")
    public JAXBElement<ExecutaResponse> createExecutaResponse(ExecutaResponse value) {
        return new JAXBElement<ExecutaResponse>(_ExecutaResponse_QNAME, ExecutaResponse.class, null, value);
    }

}
