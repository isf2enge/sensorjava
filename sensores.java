import java.util.Scanner; //bibliotecas para habilitar o array para pilha.
import java.util.*; 
import java.util.LinkedList; //para fila
import java.util.Queue;

import java.util.List;  //para lista
import java.util.ArrayList;

class Sensores{ //Classe Pai


    private String modelo; //instancias privadas
    private int distancia;

    public String getModelo(){ //Metodos get e set,para as respectivas instancias

        return this.modelo;
    };

    public void setModelo (String modelo){
        this.modelo = modelo;


    }

    public int getDistancia(){

        return this.distancia;
    };

    public void setDistancia(int distancia){
        this.distancia = distancia;


    }


    


}


class co2 extends Sensores { //sensor de co2,com armazenamento baseado em pilha.

    List<String> co2 = new ArrayList<String>(); //cria o array e armazena os dados.
    int tamanho = 24*60/30; //numero de dados catalogados a cada 30 minutos.

    public void aumentaPilha(float addd){ //EMPILHAR
        if(co2.size()<this.tamanho){

            co2.add(Float.toString(addd));
            
            System.out.println("Elemento adicionado com sucesso");

        }
        else{

            System.out.println("Esvazie a pilha!");
        }

    }

    public void diminuiPilha(){  //DESEMPILHAR apartir do ultimo elemento
        if(co2.size() >= this.tamanho){
            while(co2.size() > 0){
                this.tamanho--; 
                co2.remove(this.tamanho);
                 

            }
            
            
            System.out.println("Elemento removido com sucesso");

        }
        else{
            System.out.println(co2.size()); 
            System.out.println("pilha ainda dá para ser completada!,encha!");
        }

    }



}

class Temperatura extends Sensores {
    Queue<String> temperatura
            = new LinkedList<>();

    int tamanho = 24*60/30;
    
  
  
    public void aumentafila(float adicionar){ //adicionar dados

        if(temperatura.size()<this.tamanho){

            temperatura.add(Float.toString(adicionar));
            
            System.out.println("Elemento adicionado com sucesso");

        }
        else{

            System.out.println("Esvazie a fila!");
        }


    }

    public void removefila(){ // removendo as peças na fila do primeiro ao ultimo.

        if(temperatura.size()>=this.tamanho){
            while(temperatura.size() != 0){
                temperatura.remove(); //remove do primeiro ao ultimo.

            }
            
            
            System.out.println("Elementos removidos com sucesso");

        }
        else{

            System.out.println("fila ainda dá para ser completada!,encha!");


    }}
       
       
        
  
       
  
       
  
        

    
}


class umidade extends Sensores {

    List<String> umidade = new ArrayList<>();
    int tamanho = 24*60/30;
    
        

         
        public void  adiciona(float adict){ // Adicionando elementos à lista
            if(umidade.size()<this.tamanho){

                umidade.add(Float.toString(adict));
                
                System.out.println("Elemento adicionado com sucesso");
    
            }
            else{
    
                System.out.println("Esvazie a lista!");
            }

        }
        

        
        

        

        public void removelista(){ // removendo as peças na fila do primeiro ao ultimo.

            if(umidade.size()>=this.tamanho){
                while(umidade.size() != 0){
                    this.tamanho--;
                    umidade.remove(this.tamanho); //remove do primeiro ao ultimo,podendo ser feito do ultimo ao primeiro tb,por ser uma lista.
                    
                }
                
                
                System.out.println("Elementos removidos com sucesso");
    
            }
            else{
    
                System.out.println("lista ainda dá para ser completada!,encha!");
    
    
        }}

       
    }



    class mainn{ //Main


        public static void main(String[] args) { //os dados de recebimento dos sensores,vem aqui.

            //Descrição tecnica dos sensores,com dados encapsulados.
            co2 carbon = new co2();
            carbon.setModelo("carbon");
            carbon.setDistancia(20);
            Temperatura temp = new Temperatura();
            temp.setModelo("temp");
            temp.setDistancia(50);
            umidade umit = new umidade();
            umit.setModelo("umit");
            umit.setDistancia(15);

            /////////////////////////////////////////
            //Sensor de co2

            
            for (int i = 0; i <carbon.tamanho; i++) { //aumenta a pilha

                carbon.aumentaPilha(i);
                
            }

            
            System.out.println("Carbono: " + carbon.co2);
            carbon.diminuiPilha();//esvaziar a pilha,após os dados coletados para o outro dia.


        /////////////////////////////////////////
            //Sensor de Temperatura

            
            for (int i = 0; i <temp.tamanho; i++) { //aumenta a pilha

                temp.aumentafila(i);
                
            }

            
            System.out.println("TEMPERATURA: "+ temp.temperatura);
            temp.removefila();//esvaziar a fila,após os dados coletados para o outro dia.


            /////////////////////////////////////////
            //Sensor de umidade

            
            for (int i = 0; i <umit.tamanho; i++) { //aumenta a lista

                umit.adiciona(i);
                
            }

            
            System.out.println("Umidade: "+ temp.temperatura);
            umit.removelista();//esvaziar a lista,após os dados coletados para o outro dia.

            

            
            
        }


        
    }


