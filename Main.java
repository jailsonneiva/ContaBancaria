
public class Main {
     
    public static void main(String[] args) {
      
  ContaBancaria conta = new ContaBancaria();
    conta.insiraNome();
    System.out.println("--------------------------------------");
    System.out.println("********** SISTEMA BANCÁRIO **********");
    System.out.println("--------------------------------------");
    System.out.printf("SEJA BEM-VINDO %s%n",conta.getInsiraNome());
        System.out.println("--------------------------------------");
        System.out.printf("Você tem um saldo inicial -> R$ %.2f%n",conta.getSaldo());
        System.out.println("--------------------------------------");
        conta.Menu();
    }
  
}
