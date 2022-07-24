import java.util.Scanner;
class ContaBancaria {
    Scanner sc = new Scanner(System.in);    
    private double saldo = 100.00;
    protected double valor;
    public int opc;
    public String a = "Depósito";
    public String b = "Saque";    
    public String c= "Saldo";
    public String d = "Voltar";
    public String e = "Encerrar";
    
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
    if(valor==0){
      do{
        System.out.printf(".................................%n");
        System.out.printf("[..ERRO.. ]%n -> Você não digitou o valor.%n");
        System.out.printf(".................................%n");
        System.out.printf("DIGITE O VALOR DE DEPÓSITO -> R$ ");
        valor = sc.nextDouble(); 
      }while(valor==0);
    }else if(valor<0){        
      do{
        System.out.printf(".................................%n");
        System.out.printf("[..ERRO.. ]%n -> Número Inválido. Digite um valor aceito:%n");
        System.out.printf(".................................%n");        
        System.out.printf("DIGITE O VALOR DE DEPÓSITO -> R$ ");       
        valor = sc.nextDouble();
      }while(valor<0);    
    }else if(valor>0){
      deposito();
      System.out.printf("............................. %n");
      System.out.printf("('_') * DEPÓSITO REALIZADO COM SUCESSO%n");
      System.out.printf("............................. %n");
      System.out.println("Para continuar ou encerrar escolha uma opção:");      
      System.out.printf("%n * 1 - %s%n * 3 - %s%n * 4 - %s%n * 5 - %s%n",a,c,d,e);
       int opc = sc.nextInt();
       while(opc!=1 && opc!=3 && opc!=4 && opc!=5){
            erroOpcao();
            System.out.printf("%n * 1 - %s%n * 3 - %s%n * 4 - %s%n * 5 - %s%n",a,c,d,e);
            System.out.print(" -> ");
            opc = sc.nextInt();
        }
        if(opc==1){
            depositar();
        }else if(opc==3){
            extrato();
        }else if(opc==4){
            escolha();
        }else{
            encerraPrograma();
        }
   } 
    
  }
  
//OPÇÃO SAQUE-DÉBITO.............................................
public void debitando(){     
    System.out.printf("DIGITE O VALOR DO SAQUE -> R$ ");
    valor = sc.nextDouble();
    if(valor>saldo){  
            System.out.printf("............................%n");        
            System.out.printf("### [ SALDO INSUFICIENTE ] ###%n");
            System.out.printf("............................%n");
            voltarEncerrar(); 
    }else if(valor==0 || valor<0){    
        while(valor==0){
            System.out.printf(".................................%n");
            System.out.printf("[..ERRO.. ]%n-> DIGITE UM VALOR MAIOR QUE ZERO.%n");
            System.out.printf(".................................%n");
            System.out.printf("DIGITE O VALOR DO SAQUE -> R$ "); 
            valor = sc.nextDouble(); 
        }
        while(valor<0){  
            System.out.printf(".................................%n");
            System.out.printf("[..ERRO.. ]%n-> NÚMERO INVÁLIDO. DIGITE UM VALOR ACEITO:");
            System.out.printf(".................................%n");
            System.out.printf("DIGITE O VALOR DO SAQUE -> R$ ");
            valor = sc.nextDouble();
        }
    }else if(valor>0 && valor<=saldo){
        while(valor<=50){ 
            debito();
            saqueRealizado();            
            voltarEncerrar();            
        }
        while(valor>50){
            System.out.println(".............................");
            System.out.println("***** ATENÇÃO *****");
            System.out.println("PARA SAQUES ACIMA DE R$ 50,00");
            System.out.println("SERÁ COBRADO UMA TARIFA DE 10%");
            System.out.println("DESEJA CONTINUAR?");                                           
            System.out.println(".............................");        
            System.out.printf("-> DIGITE '1' PARA SIM E '2' PARA NÃO%n");
            opc=sc.nextInt();
            while(opc!=1 && opc!=2){
                System.out.println(".................................");
                System.out.printf("[..ERRO.. ]%n-> DIGITE '1' PARA SIM E '2' PARA NÃO");
                System.out.println(".................................");
                System.out.print(" -> ");
                opc=sc.nextInt();
            }
            if(opc==1){
                saldo-=valor*0.1;        
                debito();
                saqueRealizado();
                voltarEncerrar();
            }else{ 
                System.out.println("('_') * SAQUE CANCELADO");
                voltarEncerrar();
            }
            
        }
    } 
}
    
//AVISO DE SAQUE REALIZADO
  public void saqueRealizado(){
    System.out.printf(".............................%n");
    System.out.printf("('_') * SAQUE DE R$ %.2f REALIZADO%n",valor);
    System.out.printf(".............................%n");
    
  }
  
//AVISO DE SALDO - EXTRATO.........................................
  public void extrato(){
    System.out.println("..........................");
    System.out.printf("-> SALDO ATUAL = R$ %.2f%n",getSaldo());
    System.out.println("..........................");
    System.out.println("Para continuar ou encerrar escolha uma opção:");
    System.out.println("..........................");
    System.out.printf(" * 1 - %s%n * 2 - %s%n * 4 - %s%n * 5 - %s%n",a,b,d,e);
    int opc = sc.nextInt();
       while(opc!=1 && opc!=2 && opc!=4 && opc!=5){
            erroOpcao();
            System.out.printf("%n * 1 - %s%n * 2 - %s%n * 4 - %s%n * 5 - %s%n",a,b,d,e);
            System.out.print(" -> ");
            opc = sc.nextInt();
        }
        switch (opc) {
            case 1:
                depositar();
                break;
            case 2:
                debitando();
                break;
            case 4:
                escolha();
                break;
            default:
                encerraPrograma();
                break;
        }
  } 
  
//OPÇÃO VOLTAR-ENCERRAR.......................................
  public void voltarEncerrar(){
     System.out.printf("%n * 4 - %s%n * 5 - %s%n",d,e);
     int opc = sc.nextInt();
     while(opc!=4 && opc!=5){
     erroOpcao();
     System.out.printf(" * 4 - %s%n * 5 - %s%n",d,e);
     System.out.print(" -> ");
     opc = sc.nextInt();
    }
    if(opc==4){
      escolha();
    }else{        
      encerraPrograma();
    }
  }
  
//OPÇÃO FAZER UM SAQUE - VOLTAR - ENCERRAR.................................. 
  public void saqueVoltaEncerra(){
    System.out.printf("%n * 2 - %s%n * 4 - %s%n * 5- %s%n",b,d,e);
    int opc = sc.nextInt();
    while(opc!=2 && opc!=4 && opc!=5){
    erroOpcao();
    System.out.printf("%n * 2 - %s%n * 4 - %s%n * 5 - %s%n",b,d,e);
    System.out.print(" -> ");
    opc = sc.nextInt();
    }
    if(opc==2){
      debitando();
    }else if(opc==4){
      escolha();
    }else{        
      encerraPrograma();
    }
} 
  
//OPÇÃO - ENCERRAMENTO PROGRAMA.....................................
  public void encerraPrograma(){
    System.out.printf("%n [........: SISTEMA ENCERRADO :........]%n");
    System.out.println("-> Agradecemos por acessar. Volte sempre <-");
    System.out.println("----------------------------------------");
  }
  
  //ERRO DE OPÇÃO.................................................  
  protected void erroOpcao(){
      System.out.printf(".................................%n"); 
      System.out.printf("[..ERRO.. ]%n -> ESCOLHA UMA OPÇÃO ABAIXO:%n");
      System.out.printf(".................................%n"); 
  }
  
 //..................MENU PRINCIPAL ESCOLHA-1..................................
  public void escolha(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("...............................");
        System.out.printf("* 1 - %s%n* 2 - %s%n* 3 - %s%n* 5 - %s%n",a,b,c,e);
        int opc = sc.nextInt();
        while(opc!=1 && opc!=2 && opc!=3 && opc!=5){
             erroOpcao();
             System.out.printf("* 1 - %s%n* 2 - %s%n* 3 - %s%n* 5 - %s%n",a,b,c,e);
             opc = sc.nextInt();
          }          
        switch (opc) {
//DEPÓSITO.............................
            case 1:
               depositar();              
            break;
//SAQUE/ DÉBITO..................................
            case 2:
               debitando();              
            break;        
//SALDO/EXTRATO..................................
            case 3:
               extrato();
            break;
//VOLTAR..................................
            case 4:
               escolha();
            break;
//ENCERRAMENTO..................................
            default:   
              encerraPrograma();             
            break;
      }         
}
}
 