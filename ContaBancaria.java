import java.util.Scanner;

class ContaBancaria {
    Scanner sc = new Scanner(System.in);    
    private double saldo = 10.0;
    protected double valor;
    public int opc;
    final double juros = 0.1;
    public String a = "Depósito";
    public String b = "Saque";    
    public String c= "Saldo";
    public String d = "Voltar";
    public String e = "Encerrar";
    public String f = "Sacar valor";
    
//DEPÓSITOS.....................................................
  public Double deposito(){     
    return saldo+=valor;
  }

//SAQUE/ DÉBITO..................................................
  public Double debito() {
    return saldo-=valor;
  }
    
//GET - CONTA RECEBE O SALDO...................................... 
  public Double getSaldo() {
    return saldo;
    } 

//SET - INSERINDO O SALDO.........................................
  public void setSaldo(double saldo) {
    this.saldo=saldo;
    }
  
//OPÇÃO DEPOSITAR.................................................
  public void depositar(){
    System.out.printf("DIGITE O VALOR DE DEPÓSITO -> R$ ");
    valor = sc.nextDouble(); 
   do{
      if(valor==0){
        System.out.printf(".................................%n('_') Você não digitou o valor.%n.................................%n");
        System.out.printf("DIGITE O VALOR DE DEPÓSITO -> R$ ");
        valor = sc.nextDouble(); 
      }else if(valor<0){        
        System.out.printf(".................................%n('_') Número Inválido. Digite um valor aceito:%n.................................%n");
        System.out.printf("DIGITE O VALOR DE DEPÓSITO -> R$ ");       
        valor = sc.nextDouble();
      }      
    }while(valor==0||valor<0);
    if(valor>0){
        deposito();
        avisoDeposito();
    } 
  }
  
//OPÇÃO SAQUE-DÉBITO.............................................
  public void debitando(){     
    System.out.printf("DIGITE O VALOR DO SAQUE -> R$ ");
    valor = sc.nextDouble();    
    do{
      if(valor==0){
        System.out.printf(".................................%n('_') Você não digitou o valor.%n.................................%n");
        System.out.printf("DIGITE O VALOR DO SAQUE -> R$ "); 
      }else if(valor<0){        
        System.out.printf(".................................%n('_') Número Inválido. Digite um valor aceito:%n.................................%n");
        System.out.printf("DIGITE O VALOR DO SAQUE -> R$ ");         
        valor = sc.nextDouble();
      }      
    }while(valor==0||valor<0);
    if(valor>saldo){        
      System.out.printf("............................%n('_') Saldo insuficiente.%n............................%n");  
        opc4e5();      
    }else if(valor>0 && valor<=saldo){
        debito();
        avisoSaque();
        opc4e5();
    } 
  }
  
//OPÇÃO SALDO - EXTRATO.........................................
    public void extrato(){
        System.out.printf(".......................... %n('_') Saldo atual -> R$ %.2f%n.......................... ",getSaldo());   
    } 


  //OPÇÃO VOLTAR OU ENCERRAR.......................................
  public void opc4e5(){
     System.out.printf("%n * 4 - %s%n * 5 - %s%n",d,e);
     int opc = sc.nextInt();
     while(opc!=4 && opc!=5){
     System.out.printf(".................................%n-> ERRO..escolha uma opção abaixo:%n.................................%n");
     System.out.printf(" * 4 - %s%n * 5 - %s%n",d,e);
     System.out.print(" -> ");
     opc = sc.nextInt();
    }
    if(opc==4){
      escolha();       
    }else{
      opc5();
    }
  }

  //OPÇÃO - VOLTAR - ENCERRAR - SACAR.................................. 
  public void opc4_5_6(){
    System.out.printf("%n * 4 - %s%n * 5 - %s%n * 6 - %s%n",d,e,f);
       int opc = sc.nextInt();
       while(opc!=4 && opc!=5 && opc!=6){
     System.out.printf(".................................%n-> ERRO..escolha uma opção abaixo:%n.................................%n");
     System.out.printf("%n * 4 - %s%n * 5 - %s%n * 6 - %s%n",d,e,f);
     System.out.print(" -> ");
     opc = sc.nextInt();
    }
    if(opc==4){
      escolha();
    }else if(opc==6){
      debitando();      
  }else{
    opc5();
  }
} 
  
//OPÇÃO - ENCERRAMENTO PROGRAMA.....................................
  public void opc5(){
    System.out.printf("%n ........: SISTEMA ENCERRADO :........%n");
    System.out.println("-> Para usar novamente clique em 'Run' <-");
    System.out.println("----------------------------------------");
    sc.close();   
  }

//AVISO DEPÓSITO...............................................
  public void avisoDeposito(){
    System.out.printf("............................. %n('_') Depósito realizado%n.............................");
  }
  
//AVISO SAQUE.............................................
  public void avisoSaque(){
    System.out.printf("............................. %n-> Saque de R$ %.2f realizado%n.............................",valor);    
  }
 //...............MENU PRINCIPAL ESCOLHA-1..................................
  public void escolha(){
        System.out.printf("%nESCOLHA UMA OPÇÃO -> [1 2 3 5]:%n");
          System.out.printf(" * 1 - %s%n * 2 - %s%n * 3 - %s%n * 5 - %s%n",a,b,c,e);
          int opc = sc.nextInt();
          while(opc!=1 && opc!=2 && opc!=3 && opc!=5){
             System.out.printf("...................................%n-> # ERRO # <-%nSelecione o ítem correto:%n...................................%n");
          System.out.printf("%nESCOLHA UMA OPÇÃO -> [1 2 3 5]:%n");
          System.out.printf(" * 1 - %s%n * 2 - %s%n * 3 - %s%n * 5 - %s%n",a,b,c,e);
             opc = sc.nextInt();
          }          
        switch (opc) {
//DEPÓSITO.............................
            case 1:
                depositar();
                avisoDeposito();
                opc4e5();
                break;
//SAQUE/ DÉBITO..................................
            case 2:
              debitando();              
            break;
        
//SALDO/EXTRATO..................................
            case 3:
               extrato();
               opc4_5_6();
            break;
//VOLTAR..................................
            case 4:
                escolha();
                break;
//ENCERRAMENTO..................................
            case 5:
              opc5();
               break;  
//CORREÇÃO..................................
            default:   
              System.out.println("Erro no programa.Reinicie");              
            break; 
            
      }         
}
}
 