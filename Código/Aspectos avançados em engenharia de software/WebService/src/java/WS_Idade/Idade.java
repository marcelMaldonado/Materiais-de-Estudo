/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS_Idade;

import java.util.Calendar;

/**
 *
 * @author Leo
 */
public class Idade {

    private int idade;
    private boolean eMaior;

    public Idade() {
        this.idade = 0;
        this.eMaior = false;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean iseMaior() {
        return eMaior;
    }

    public void seteMaior(boolean eMaior) {
        this.eMaior = eMaior;
    }
    
    public void calculaIdade(String data){
        Calendar cal = Calendar.getInstance();
        
        int dia = cal.get(Calendar.DATE);
        int mes = cal.get(Calendar.MONTH + 1);
        int ano = cal.get(Calendar.YEAR);
        
        String[] dt = data.split("/");
        
        if(((dia > Integer.parseInt(dt[0])) && (mes == Integer.parseInt(dt[1])))||(mes > Integer.parseInt(dt[1]))){
            setIdade(ano - Integer.parseInt(dt[2]));
        }
        else{
            setIdade(ano - Integer.parseInt(dt[2]) - 1);
        }
        verifica(getIdade());
    }
    
    public void verifica(int idade){
        if(idade < 18){
            seteMaior(false);
        }
        else{
            seteMaior(true);
        }
    }
}
