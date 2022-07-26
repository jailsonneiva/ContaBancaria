import java.util.*;
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
    protected String nome;
  
//COLOCAR O NOME DO USUÁRIO....................................  
 public void insiraNome(){
     System.out.print("Digite seu nome: ");
     nome=sc.nextLine().toUpperCase();
     }
 
 //RETORNA O NOME DO USUÁRIO....................................
 public String getInsiraNome(){
    return nome;
    } 
    
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
    System.out.printf("Você escolheu a opção 1 -  %s%n",a);
    System.out.printf("DIGITE O VALOR DE DEPÓSITO -> R$ ");
    valor = sc.nextDouble();    
    if(valor==0 || valor==-0 || valor<0){  
        while(valor==0 || valor==-0 || valor<0 || valor>0){
            if(valor==0 || valor==-0){
                System.out.println("..........................................");
                System.out.printf("[..ERRO..]%n -> Você não digitou o valor.%n");
                System.out.println("..........................................");
                System.out.print("DIGITE O VALOR DE DEPÓSITO -> R$ ");
                valor = sc.nextDouble();
                if(valor>0){
                    depositoRealizado();
                }
            }else if(valor<0){
                System.out.println(".........................................................");
                System.out.printf("[..ERRO..]%n -> Número Inválido. Digite um valor aceito:%n");
                System.out.println(".........................................................");        
                System.out.print("DIGITE O VALOR DE DEPÓSITO -> R$ ");       
                valor = sc.nextDouble();
                if(valor>0){
                    depositoRealizado();
                }
            }
        }                
    }else if(valor>0){
        depositoRealizado();
    }
 }
  
//OPÇÃO SAQUE-DÉBITO.............................................
public void debitando(){
    System.out.printf("Você escolheu a opção 2 -  %s%n",b);
    System.out.println(".....................................");
    System.out.printf("DIGITE O VALOR DO SAQUE -> R$ ");
    valor = sc.nextDouble();
    if(valor>saldo){ 
            System.out.println(".....................................");
            System.out.printf("### [ SALDO INSUFICIENTE ] ###%n");
            System.out.println(".....................................");
            System.out.println("Para continuar ou encerrar escolha uma opção:");
            voltarEncerrar(); 
    }else if(valor==0 || valor<0){    
        if(valor==0){
            System.out.println("...........................................");
            System.out.printf("[..ERRO..]%nDigite um valor maior que zero.%n");
            System.out.println("...........................................");
            voltarEncerrar();
        }else if(valor<0){  
            System.out.println("...................................................");
            System.out.println("[..ERRO..] -> NÚMERO INVÁLIDO");
            System.out.println("...................................................");
            System.out.println("Para continuar ou encerrar escolha uma opção:");
            voltarEncerrar();
        }
    }else if(valor>0 && valor<=saldo){
        if(valor<=50){ 
            debito();
            saqueRealizado();            
        }else if(valor>50){
            atencao();
            while(opc!=1 && opc!=2){
                System.out.println(".............................................");
                System.out.printf("[..ERRO..]%nDigite '1' para sim e '2' para não%n");
                System.out.println(".............................................");
                System.out.printf("-> "); 
                opc=sc.nextInt();
                
            }
            if(opc==1){
                System.out.println("Você escolheu a opção 1 - 'Sim'");
                saldo-=valor*0.1;        
                debito();
                saqueRealizado();
            }else{
                System.out.println("Você escolheu a opção 2 - 'Não'");
                System.out.println("...............................");
                System.out.println("('_') * SAQUE CANCELADO *");
                System.out.println("...............................");
            }  
        }
    System.out.println("Para continuar ou encerrar escolha uma opção:");
    saqueVoltaEncerra();
    } 
}

//AVISO DE DEPÓSITO REALIZADO.......................................
  public void depositoRealizado(){
    deposito();
    System.out.println(".............................................");
    System.out.println("('_') * DEPÓSITO REALIZADO COM SUCESSO");
    System.out.println(".............................................");
    System.out.println("Para continuar ou encerrar escolha uma opção:");
    System.out.printf(" * 1 - %s%n * 3 - %s%n * 4 - %s%n * 5 - %s%n",a,c,d,e);
    int opc = sc.nextInt();
    if(opc!=1 && opc!=3 && opc!=4 && opc!=5){
        while(opc!=1 && opc!=3 && opc!=4 && opc!=5){
            erroOpcao();
            System.out.printf("%n * 1 - %s%n * 3 - %s%n * 4 - %s%n * 5 - %s%n",a,c,d,e);
            System.out.print(" -> ");
            opc = sc.nextInt();
        }
    }else if(opc==1){
        depositar();
    }else if(opc==3){
        extrato();
    }else if(opc==4){
        escolha();
    }else{
        encerraPrograma();
    } 
} 
    
//AVISO DE SAQUE REALIZADO.......................................
  public void saqueRealizado(){
    System.out.println("..............................................");
    System.out.println("('_') * SAQUE REALIZADO COM SUCESSO");
    System.out.println("..............................................");
  }
  
  //ATENÇÃO PARA SAQUES ACIMA DE 50,00............................
  public void atencao(){
    System.out.println("....................................");  
            System.out.println("***** ATENÇÃO *****");
            System.out.println("PARA SAQUES ACIMA DE R$ 50,00");
            System.out.println("SERÁ COBRADO UMA TARIFA DE 10%");
            System.out.println("DESEJA CONTINUAR?");                                           
            System.out.println("....................................");        
            System.out.println("DIGITE '1' PARA SIM E '2' PARA NÃO");
            opc=sc.nextInt();
            System.out.println("..............................................");
}
  
//AVISO DE SALDO - EXTRATO.........................................
  public void extrato(){
    System.out.printf("Você escolheu a opção 3 - %s%n",c);
    System.out.println("..............................................");
    System.out.printf("-> O SALDO ATUAL = R$ %.2f%n",getSaldo());
    System.out.println("..............................................");
    System.out.println("Para continuar ou encerrar escolha uma opção:");
    System.out.printf(" * 1 - %s%n * 2 - %s%n * 4 - %s%n * 5 - %s%n",a,b,d,e);
    int opc = sc.nextInt();
       while(opc!=1 && opc!=2 && opc!=4 && opc!=5){
            erroOpcao();
            System.out.printf(" * 1 - %s%n * 2 - %s%n * 4 - %s%n * 5 - %s%n",a,b,d,e);
            System.out.print(" -> ");
            opc = sc.nextInt();
            System.out.println(".................................");
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
            case 5:
                encerraPrograma();
                break;
            default:
                System.out.println("Programa encerrado");
                break;
        }
  } 
  
//OPÇÃO VOLTAR-ENCERRAR.......................................
  public void voltarEncerrar(){
     System.out.printf(" * 4 - %s%n * 5 - %s%n",d,e);
     int opc = sc.nextInt();
     while(opc!=4 && opc!=5){
     erroOpcao();
     System.out.printf(" * 4 - %s%n * 5 - %s%n",d,e);
     System.out.print(" -> ");
     opc = sc.nextInt();
     System.out.println(".................................");
    }
    if(opc==4){
      escolha();
    }else{        
      encerraPrograma();
    }
  }
  
//OPÇÃO FAZER UM SAQUE - VOLTAR - ENCERRAR.................................. 
  public void saqueVoltaEncerra(){
    System.out.printf(" * 2 - %s%n * 4 - %s%n * 5 - %s%n",b,d,e);
    int opc = sc.nextInt();
    while(opc!=2 && opc!=4 && opc!=5){
    erroOpcao();
    System.out.printf(" * 2 - %s%n * 4 - %s%n * 5 - %s%n",b,d,e);
    System.out.print(" -> ");
    opc = sc.nextInt();
    System.out.println(".................................");
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
    System.out.println("-------------------------------------------");
    System.out.println("[........: SISTEMA ENCERRADO :........]");
    System.out.println("* Agradecemos por acessar. Volte sempre *");
    System.out.println("-------------------------------------------");
  }
  
  //ERRO DE OPÇÃO.................................................  
  protected void erroOpcao(){
       System.out.println("..........................................");
      System.out.printf("[..ERRO..]%n -> Escolha a opção correta:%n");
      System.out.println(".........................................."); 
  }
  
 //..................MENU PRINCIPAL..................................
  public void escolha(){
    System.out.println("MENU PRINCIPAL");
    System.out.println("...............................");
    System.out.printf("* 1 - %s%n* 2 - %s%n* 3 - %s%n* 5 - %s%n",a,b,c,e);
    opc = sc.nextInt();        
    if(opc!=1 && opc!=2 && opc!=3 && opc!=5){
        while(opc!=1 && opc!=2 && opc!=3 && opc!=5){
            erroOpcao();
            System.out.printf("* 1 - %s%n* 2 - %s%n* 3 - %s%n* 5 - %s%n",a,b,c,e);
            opc = sc.nextInt();
            System.out.println(".................................");
        }
    }else{
        switch (opc){
            //DEPÓSITO.......................................
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
            //VOLTAR..........................................
            case 4:
               escolha();
            break;
            //ENCERRAMENTO....................................
            case 5:   
              encerraPrograma();
              sc.close();
            break;
            //padrão....................................            
            default:   
                System.out.println("Sistema instável.Tente mais tarde");
            break; 
        } 
    } 
  } 
} 
 