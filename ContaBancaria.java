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
  
  public void insiraNome(){ //inserindo o nome usuário.....
      System.out.print("Digite seu nome: ");
      nome=sc.nextLine().toUpperCase();
  }
 
  public String getInsiraNome(){ //recebe nome usuário.....
      return nome;
  } 

  public Double deposito(){ //depósito.........   
      return saldo+=valor;
  }

  public Double debito() { //débito.........
      return saldo-=valor;
  }
    
  public Double getSaldo() {//recebe saldo.....
      return saldo;
  } 

  public void setSaldo(double saldo) { //inserindo o saldo
    this.saldo=saldo;
  }

  //..................MENU PRINCIPAL..................................
  public void Menu(){
    System.out.println(" MENU PRINCIPAL ");
    System.out.println("...............................");
    System.out.printf("* 1 - %s%n* 2 - %s%n* 3 - %s%n* 5 - %s%n",a,b,c,e);
    opc = sc.nextInt();        
    if(opc!=1 && opc!=2 && opc!=3 && opc!=5){
        while(opc!=1 && opc!=2 && opc!=3 && opc!=5){
            Erro();
            System.out.printf("* 1 - %s%n* 2 - %s%n* 3 - %s%n* 5 - %s%n",a,b,c,e);
            opc = sc.nextInt();
            if(opc==1 || opc==2 || opc==3 || opc==5){
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
                    Saldo();
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
        }else if(opc==1 || opc==2 || opc==3 || opc==5){
          switch (opc){
          case 1: //DEPÓSITO.......................................
             depositar();              
          break; 
          case 2: //SAQUE/ DÉBITO..................................
             debitando();              
          break;        
          case 3: //SALDO/EXTRATO..................................
             Saldo();
          break;
          case 5: //ENCERRAMENTO....................................   
            encerraPrograma();
            sc.close();
          break;      
          default://padrão....................................   
              System.out.println("Sistema instável.Tente mais tarde");
          break;
        }
    } 
  } 

  public void depositar(){ //efetuando depósito....................
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
                  MenuDepositar();
              }
            }else if(valor<0){
                System.out.println(".........................................................");
                System.out.printf("[..ERRO..]%n -> Número Inválido. Digite um valor aceito:%n");
                System.out.println(".........................................................");        
                System.out.print("DIGITE O VALOR DE DEPÓSITO -> R$ ");       
                valor = sc.nextDouble();
                if(valor>0){
                    depositoRealizado();
                    MenuDepositar();
                }
            }
        }                
    }else if(valor>0){
        depositoRealizado();
        MenuDepositar();
    }
  }

  public void debitando(){ //efetuando saque..............................
    System.out.printf("Você escolheu a opção 2 -  %s%n",b);
      System.out.println(".....................................");
        System.out.printf("DIGITE O VALOR DO SAQUE -> R$ ");
          valor = sc.nextDouble();    
            if(valor>saldo){
              System.out.println(".....................................");
            System.out.printf("### [ SALDO INSUFICIENTE ] ###%n");
          System.out.println("....................................."); 
        opcaoVoltarEncerrar();
      }else if(valor==0 || valor<0){
    while(valor==0 || valor<0){    
      if(valor==0){
        System.out.println("...........................................");
          System.out.printf("[..ERRO..]%nDigite um valor maior que zero.%n");
            System.out.println("...........................................");
              opcaoVoltarEncerrar();
            }else if(valor<0){  
          System.out.println("...................................................");
        System.out.println("[..ERRO..] -> NÚMERO INVÁLIDO");
      System.out.println("...................................................");
    opcaoVoltarEncerrar();
      }
        }
          }else if(valor>0 && valor<=saldo){
            if(valor<=50){ 
              debito();
            saqueRealizado();
          opcaoVoltarEncerrar();
        }else if(valor>50){ //se valor maior do que 50
      atencao();
    if(opc!=1 && opc!=2){
      while(opc!=1 && opc!=2){
        System.out.printf("[..ERRO..]%nDigite '1' para SACAR e '2' para CANCELAR%n");
          System.out.println(".............................................");
            System.out.printf("-> "); 
              opc=sc.nextInt();                
            if(opc==1){
          System.out.println("Você escolheu a opção 1 - 'Sacar'");
        saldo-=valor*0.1;        
      debito();
    saqueRealizado();
      opcaoVoltarEncerrar();
        }else if(opc==2){
          System.out.println("Você escolheu a opção 2 - 'Cancelar'");
            System.out.println("...............................");
              System.out.println("('_') * SAQUE CANCELADO *");
            System.out.println("...............................");
          opcaoVoltarEncerrar();
        }  
      }
    }else if(opc==1 || opc==2){
      if(opc==1){
        System.out.println("Você escolheu a opção 1 - 'Sacar'");
          saldo-=valor*0.1;        
            debito();
              saqueRealizado();
            opcaoVoltarEncerrar();
          }
        else if(opc==2){
      System.out.println("Você escolheu a opção 2 - 'Cancelar'");
    System.out.println("...............................");
      System.out.println("('_') * SAQUE CANCELADO *");
        System.out.println("...............................");
          opcaoVoltarEncerrar();
            }
              }   
          }    
      }
  }
  
  public void depositoRealizado(){ //Depósito realizado
    deposito();
    System.out.println(".............................................");
    System.out.println("('_') * DEPÓSITO REALIZADO COM SUCESSO");
    System.out.println(".............................................");
  } 

  public void saqueRealizado(){ //Saque realizado.....
    System.out.println("..............................................");
    System.out.println("('_') * SAQUE REALIZADO COM SUCESSO");
    System.out.println("..............................................");
  }

  public void atencao(){ //Saques acima de 50,00.....
    System.out.println("....................................");  
            System.out.println("***** ATENÇÃO *****");
            System.out.println("PARA SAQUES ACIMA DE R$ 50,00");
            System.out.println("SERÁ COBRADO UMA TARIFA DE 10%");
            System.out.println("DESEJA CONTINUAR?");
            System.out.println("....................................");        
            System.out.println("Digite '1' para sacar e '2' para cancelar");
            opc=sc.nextInt();
            System.out.println("..............................................");
  }

  public void Saldo(){ //Saldo............
    System.out.println("..............................................");
    System.out.printf("Você escolheu a opção 3 - %s%n",c);
    System.out.println("..............................................");
    System.out.printf("-> O SALDO ATUAL = R$ %.2f%n",getSaldo());
    System.out.println("..............................................");
    System.out.println("Para continuar ou encerrar escolha uma opção:");
    System.out.printf(" * 1 - %s%n * 2 - %s%n * 4 - %s%n * 5 - %s%n",a,b,d,e);
    int opc = sc.nextInt();
       while(opc!=1 && opc!=2 && opc!=4 && opc!=5){
            Erro();
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
                Menu();
                break;
            case 5:
                encerraPrograma();
                break;
            default:
                System.out.println("Programa encerrado");
                break;
        }
  } 
  
  public void MenuDepositar(){ // opção restauração menu depositar
    System.out.println("Para continuar ou encerrar escolha uma opção:");
    System.out.printf(" * 1 - %s%n * 3 - %s%n * 4 - %s%n * 5 - %s%n",a,c,d,e);
    int opc = sc.nextInt();
      while(opc!=1 && opc!=3 && opc!=4 && opc!=5){
          if(opc!=1 && opc!=3 && opc!=4 && opc!=5){
              Erro();
              System.out.printf("%n * 1 - %s%n * 3 - %s%n * 4 - %s%n * 5 - %s%n",a,c,d,e);
              System.out.print(" -> ");
              opc = sc.nextInt();
          }else if(opc==1){
              depositar();
          }else if(opc==3){
              Saldo();
          }else if(opc==4){
              Menu();
          }else{
              encerraPrograma();
          } 
      }
      if(opc==1){
          depositar();
      }else if(opc==3){
          Saldo();
      }else if(opc==4){
          Menu();
      }else{
          encerraPrograma();
      } 
  } 
  
  protected void Erro(){ //erro digitação................................
    System.out.println("..........................................");
    System.out.printf("[..ERRO..]%n -> Escolha a opção correta:%n");
    System.out.println("..........................................");
  }

public void opcaoVoltarEncerrar(){ //voltar - encerrar..................
  System.out.println("Para continuar ou encerrar escolha uma opção:");
     System.out.printf(" * 4 - %s%n * 5 - %s%n",d,e);
        int opc = sc.nextInt();
          if (opc!=4 && opc!=5){
            while(opc!=4 && opc!=5){
               Erro();
                System.out.printf(" * 4 - %s%n * 5 - %s%n",d,e);
                System.out.print(" -> ");
                opc = sc.nextInt();
              }
            }else if(opc==4){
          Menu();
        }else if(opc==5){        
      encerraPrograma();
    }
  }
  
  public void encerraPrograma(){ //encerramento programa..................
    System.out.println("-------------------------------------------");
    System.out.println("[........: SISTEMA ENCERRADO :........]");
    System.out.println("* Agradecemos por acessar. Volte sempre *");
    System.out.println("-------------------------------------------");
  }
  //..........................Fim da classe................................
}