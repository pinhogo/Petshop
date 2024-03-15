import java.util.Arrays;
public class Pet
{
    private String nome;
    private String tipo;
    private String raca;
    private int idade;
    private String dono;
    private String telefone;
    private int [][] agenda;
    private int [] servutil;

    public Pet(String nome, String tipo, String raca, int idade, String dono, String telefone)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.idade = 0;
        this.dono = dono;
        this.telefone = telefone;
        this.agenda = new int[6][7];
        this.servutil = new int[6];
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String sNome) {
        nome = sNome;    
    }
   
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String sTipo) {
        tipo = sTipo;
    }

    public String getRaca() {
        return raca;
    }
    public void setRaca(String sRaca) {
        raca = sRaca;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int sIdade) {
        idade = sIdade;
    }

    public String getDono() {
        return dono;
    }
    public void setDono(String sDono) {
        dono = sDono;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String sTelefone) {
        telefone = sTelefone;
    }

    public int[][] getAgenda() {//getter para acessar a agenda completa
            return agenda;
    }
    public int getAgendaE(int linha, int coluna) { //getter para acessar uma posicao especifica na agenda
        if (linha >= 0 && coluna < agenda.length && coluna >= 0 && coluna < agenda[linha].length) {
            return agenda[linha][coluna];
         }
        return -1;
    } 
    public int[] getServ(int linha) {//acesso aos servicos em cada linha
        if (linha >= 0 && linha < agenda.length) {
            return agenda[linha]; 
        }
        return null;
    } 
    
    public void setAgenda(int[][] sAgenda) {//setter para definir uma agenda inteira
            agenda = sAgenda;
    }
    public void setAgendaE(int serv, int dia, int valor) { //setter para definir um valor a uma posicao especifica da agenda
        if (serv >= 0 && serv < agenda.length && dia >= 0 && dia < agenda[serv].length) {
                agenda[serv][dia] = valor;
       }
    }
            
        public int[] getServutil() { //getter para acessar o mes todo
        return servutil;
    }
    public int getServutilE(int i) {//getter para um indice especifico
        if (i >= 0 && i < servutil.length) {
              return servutil[i];
        }
        return -1;
    }
    public void setServutil(int[] sServutil) {//setter para definir um mes inteiro
            servutil = sServutil;
    }
    
    public void setServutilE(int indice, int valor) {//setter para definir um valor a uma posicao especifica
        if (indice >= 0 && indice < servutil.length) {
            servutil[indice] = valor;
            }
    }
    
    
    public int Agendados(){
         int soma = 0; 
            for(int i=0; i<agenda.length; i++ ){
                for(int j=0; j<agenda[i].length; j++ ){
             soma += agenda[i][j];
            }}
        return soma;
    }
    
    public int total(){
        int semana = 0; 
            for(int i=0; i<agenda.length; i++ ){
                for(int j=0; j<agenda[i].length; j++ ){
             semana += agenda[i][j];
            }
        }
        int mes = 0; 
        for(int i=0; i<servutil.length; i++ ){
             mes += servutil[i];
            }
        int total = semana+mes;
        return total;
        
        }

    public int totalBanhos() {
        int soma = 0; 
            for (int j = 0; j < agenda[0].length; j++) {
                soma += agenda[0][j];
            }
            return soma;
    }
    public int totalTosa() {
        int soma = 0; 
            for (int j = 0; j < agenda[0].length; j++) {
                soma += agenda[1][j];
            }
            return soma;
    }
    public int totalBanhoTosa() {
        int soma = 0; 
            for (int j = 0; j < agenda[0].length; j++) {
                soma += agenda[2][j];
            }
            return soma;
    }
    public int totalUnhas() {
        int soma = 0; 
            for (int j = 0; j < agenda[0].length; j++) {
                soma += agenda[3][j];
            }
            return soma;
    }
    public int totalHidrata() {
        int soma = 0; 
            for (int j = 0; j < agenda[0].length; j++) {
                soma += agenda[4][j];
            }
            return soma;
    }
    public int totalCompleto() {
        int soma = 0; 
            for (int j = 0; j < agenda[0].length; j++) {
                soma += agenda[5][j];
            }
            return soma;
    }
    
    public int totalBanhosM() {
        int soma = 0; 
                soma += servutil[0];
            return soma;
    }
    public int totalTosaM() {
        int soma = 0; 
                   soma += servutil[1];
            return soma;
    }
    public int totalBanhoTosaM() {
        int soma = 0; 
                  soma += servutil[2];
            return soma;
    }
    public int totalUnhasM() {
        int soma = 0; 
                  soma += servutil[3];
            return soma;
    }
    public int totalHidrataM() {
        int soma = 0; 
                 soma += servutil[4];
            return soma;
    }
    public int totalCompletoM() {
        int soma = 0; 
                  soma += servutil[5];
            return soma;
    }
    
      public int[] FecharSemana(){
        for (int i = 0; i < agenda.length; i++) {
                int[] soma = new int[6];
                int[] mesanterior = Arrays.copyOf(servutil, servutil.length);  
    
                soma[0] += agenda[0][i];
                soma[1] += agenda[1][i];
                soma[2] += agenda[2][i];
                soma[3] += agenda[3][i];
                soma[4] += agenda[4][i];
                soma[5] += agenda[5][i];

                for (int j = 0; j < soma.length; j++) {
                    servutil[j] = mesanterior[j] + soma[j];
                }
        }
            return servutil;
    }
    
    public int totalservmes() {
        int soma = 0; 
        for (int j = 0; j < servutil.length; j++) {
                soma += servutil[j];
            }
            return soma;
        }
    
    public String toString(){
        return 
        ("\n"+"Nome: " + getNome() +
        "\nTipo: " + getTipo() +
        "\nRaça: " + getRaca() +
        "\nIdade: " + getIdade() +
        "\nNome do Dono: " + getDono() +
        "\nTelefone do dono: " + getTelefone() +
        "\nServicos agendados na semana: " + Agendados() +
        "\nServicos usados no mes: " + totalservmes());

        
    }

     public String toStringDados(){
        return
        ("\n"+"Nome: " + getNome() +
        "\nServicos da Semana: " + Agendados() +
        "\nTotal de servicos utilizados no mes: "); //+ TotalMensal() +
        //"\nTotal de servicos" + total());
        
     }
}