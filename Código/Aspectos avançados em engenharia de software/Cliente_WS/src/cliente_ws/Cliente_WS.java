/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_ws;

import ws_idade.Idade;

/**
 *
 * @author Leo
 */
public class Cliente_WS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Idade idade = new Idade();
        idade = executa("24/05/1999");
        System.out.println("Sua idade é:" + idade.getIdade() +"\n" + "Maior de idade:" + idade.isEMaior());
    }

    private static Idade executa(java.lang.String data) {
        ws_idade.WebServiceIdade_Service service = new ws_idade.WebServiceIdade_Service();
        ws_idade.WebServiceIdade port = service.getWebServiceIdadePort();
        return port.executa(data);
    }
    
}
