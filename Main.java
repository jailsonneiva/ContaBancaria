
public class Main {
     
    public static void main(String[] args) {
     
    ContaBancaria conta = new ContaBancaria();
        System.out.println("SEJA BEM-VINDO");
      System.out.println("--------------------------------------");
        System.out.printf("Você tem um saldo inicial -> R$ %.2f%n ",conta.getSaldo());
      System.out.println("--------------------------------------");
        conta.escolha();     
    }
}
