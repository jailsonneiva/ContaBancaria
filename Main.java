
public class Main {
     
    public static void main(String[] args) {
     
    ContaBancaria conta = new ContaBancaria(); 
      System.out.println("----------------------------------------------------");
        System.out.println(" \n " + "  ........ SALDO INICIAL -> R$ "+conta.getSaldo()+" ........");
      System.out.println("----------------------------------------------------");
        conta.escolha();     
    }
}
