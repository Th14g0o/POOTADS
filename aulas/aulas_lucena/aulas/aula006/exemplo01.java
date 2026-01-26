class exemplo01{
    public static void main(String[] args){
        System.out.println("algo");
    }

    void ordernar(Teste lista){// não precisa criar varias funções pois qualquer classa que implemente a interface funciona aqui

    }
    
    // T eséra um tipo
    interface Teste<T>{
        // public T get();
        T get(); // public é implicito
    }
    
    class AlgoTeste<T> implements Teste<T>{
        // @Override // boa pratica em interface mais veremos mais em herança
        public T get(){
            return null;
        }
    }

    interface Importes<T>{
        public class Pessoa{} // pode servir para agurpar cvlasses em um arquivo só
    }
}


