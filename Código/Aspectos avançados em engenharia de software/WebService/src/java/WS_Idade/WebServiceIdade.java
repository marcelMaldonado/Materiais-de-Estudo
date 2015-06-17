/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS_Idade;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Leo
 */
@WebService(serviceName = "WebServiceIdade")
@Stateless
public class WebServiceIdade {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "executa")
    public Idade executa(@WebParam(name = "data") String data) {
        Idade idade = new Idade();
        idade.calculaIdade(data);
        return idade;
    }
}
