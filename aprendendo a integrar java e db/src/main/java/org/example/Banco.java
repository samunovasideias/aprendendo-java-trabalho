package org.example;
//parametros_________________________________
public class Banco {
    private Integer numeroConta;
    private String tipodeConta;
    private Float saldo;
    private Boolean status;
//______________________________________________
 //-----------------metodos do banco-------------
@Override
public String toString() {
    return "contas{" +
            "numeroconta=" + numeroConta +
            ", saldo=" + saldo +
            ", status=" + status +
            ", tipodeConta='" + tipodeConta + '\'' +
            '}';
}
    public void consultar(){
     if(this.status==null){

         System.out.println("a conta foi excluida");

     }else if(this.status==false){
         System.out.println("a conta está inativa");
     }
       else{
            System.out.println("numero da conta: " + this.getNumeroConta());
            System.out.println("saldo da conta: " + this.getsaldo());
            System.out.println("tipo de conta" + this.getTipodeConta());
            System.out.println("Status da conta:" + this.getStatus());
        }
    }

    public static Banco abrirConta(){

        Banco conta=new Banco();

        return conta ;
    }

    public void excluirConta(){
        this.setStatus(null);
        this.setSaldo(null);
        this.setNumeroConta(null);
        this.setTipodeConta(null);
    }

    public void depositar(float valor){
       if(this.status==true) {
           this.setSaldo(this.saldo + valor);
       }else{
           System.out.println("conta inativa ou excluida");
       }
    }

    public void sacar(float valor){
        if(this.status==true ) {
           if(this.saldo>valor) {
               this.setSaldo(this.saldo - valor);
           }else{

               System.out.println("saldo induficiente");
           }
        }else{
            System.out.println("conta inativa ou excluida");
        }
    }



//-----------------metodos do banco-------------
    //inicio dos getters e setters__________________________________________________________

    public int getNumeroConta(){
        return this.numeroConta;
    }
    public void setNumeroConta(Integer novoNumero){
        this.numeroConta=novoNumero ;
    }

    public String getTipodeConta() {
        return this.tipodeConta;
    }

    public void setTipodeConta(String novoTipo){

        this.tipodeConta=novoTipo;
    }

    public float getsaldo(){
        return this.saldo;
    }
    public void setSaldo(Float novoSaldo){

        this.saldo=novoSaldo;
    }
    public String getStatus(){
        if(this.status==true){
            return ("conta ativa");
        }else{
            return ("conta inativa");
        }
    }
    public void setStatus(Boolean novoStatus){
        this.status=novoStatus;
    }

    //fim dos getters e setters________________________________________________________________
}
