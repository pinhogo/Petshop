import java.util.Arrays;
import java.util.Scanner;

public class CadastroPet {
    private Pet[] pets;
    private int indice;
  
    Scanner sc = new Scanner(System.in);    
    
    public CadastroPet(int tam) {
        pets = new Pet[tam];
        indice = 0;
    }
    
    public boolean adicionarPet(Pet x){
        if(indice >= pets.length){
            return false;
        } else {
            pets[indice] = x;
            indice++;
            return true;
        }
        }
    
    public Pet localizarPet(String nomePet) {
            for (int i = 0; i < indice; i++) {
            if (pets[i].getNome().equals(nomePet)) {
            return pets[i];  
            }
        }
        return null; 
        }
            
    public int localizarPet1(String nomePet) {//localiza pelo nome
        for (int i = 0; i < indice; i++) {
            if (pets[i].getNome().equals(nomePet)) {
            return i;  
                }
        }
        return -1; 
    }
    
    public boolean removePet(String nomePet) {
        int posicao = localizarPet1(nomePet); 
    
        if (posicao != -1) { 
            for (int i = posicao; i < indice - 1; i++) {
                    pets[i] = pets[i + 1]; 
            }
            pets[indice - 1] = null; 
            indice--; 
    
            return true; 
        } else {
            return false; 
        }
    }

    public void escreverPets() {
        for (int i = 0; i < indice; i++) {
            //System.out.println(pets[i]);
            System.out.println(pets[i].toString());
        }
    }
    
    public void nomesabc(){
        String[] nomes = new String[indice];
        
        for (int i = 0; i < indice; i++) {
                nomes[i] = pets[i].getNome();
            }
            Arrays.sort(nomes, String.CASE_INSENSITIVE_ORDER); //https://www.guj.com.br/t/case-insensitive-order/344720
            System.out.println("Nomes em ordem alfabética:");
        for (String eleme : nomes) {
                System.out.println(eleme);
            }
            }
    
    public void Agendar(String nomePet, int serv, int dia, int valor){
        Pet pet = localizarPet(nomePet);
        if(pet !=null){
            pet.setAgendaE(serv, dia, valor);
            String[] diasDaSemana = {"no Domingo", "na Segunda", "na Terça", "na Quarta", "na Quinta", "na Sexta", "no Sábado"};
            String[] nomeservicos = {"Banho agendado", "Tosa agendada", "Banho e tosa agendados", "Corte de unhas agendado", "Hidratacao agendada", "Servico completo agendado"};
            System.out.println(nomeservicos[serv] + " com sucesso " + diasDaSemana[dia]+ "!");
        }
    }
    
    
    
    public void ConsultaSemanal(String nomePet) {
        Pet pet = localizarPet(nomePet);
        int [][] consultar = pet.getAgenda();
        String[] servicos = {"Banho", "Tosa", "BANHO/TOSA", "corte de Unhas", "Hidratacao", "Completo"};
        String[] dias = {"no Domingo", "na Segunda", "na Terça", "na Quarta", "na Quinta", "na Sexta", "no Sábado"};
        for (int i = 0; i <consultar.length; i++) {
            for (int j = 0; j < consultar[i].length; j++) {
                if(consultar[i][j] == 1){
                    System.out.println("Voce tem servico de "+ servicos[i] + " agendado "+dias[j]);
                }
            }
        }
    }
    
    public void CancelarAg(String nomePet) {
        Pet pet = localizarPet(nomePet);
        int [][] apagar = new int [6][7]; //cria uma agenda vazia
        int [][] consultar = pet.getAgenda();
        String[] servicos = {"Banho", "Tosa", "BANHO/TOSA", "Unhas", "Hidratacao", "Completo"};
        String[] dias = {"no Domingo", "na Segunda", "na Terça", "na Quarta", "na Quinta", "na Sexta", "no Sábado"};
        for (int i = 0; i <consultar.length; i++) {
            for (int j = 0; j < consultar[i].length; j++) {
                if(consultar[i][j] == 1){
                    System.out.println("Voce cancelou o servico de "+ servicos[i] + " agendado "+dias[j]);
                    pet.setAgenda(apagar); //agenda vazia substitui a agenda com as informacoes
                }
            }
        }
    }
    
    public void fecharSemana() {
        int[][] zerar = new int [6][7];
        for (int i = 0; i < indice; i++) {
                pets[i].FecharSemana();
                pets[i].setAgenda(zerar);
            } 
        }
        

    public void Caixa(String nomePet) {
        Pet pet = localizarPet(nomePet);
        
        int banho = pet.totalBanhosM();
        int tosa = pet.totalTosaM();
        int banhotosa = pet.totalBanhoTosaM();
        int unhas = pet.totalUnhasM();
        int hidrata = pet.totalHidrataM();
        int completo = pet.totalCompletoM();
        
        double valorBanho = 25.0;
        double valorTosa = 30.0;
        double valorBanhoTosa = 50.0;
        double valorUnhas = 15.0;
        double valorHidrata = 20.0;
        double valorCompleto = 100.0;
    
        
        double totalBanho = 0.0;
            totalBanho = banho * valorBanho;
              System.out.print("\f");
        System.out.println("O pet gastou um total de R$ " + totalBanho+ " com banho no mes atual");
    
        double totalTosa = 0.0;
            totalTosa = tosa * valorTosa;
        System.out.println("O pet gastou um total de R$ " + totalTosa+ " com tosa no mes atual");
        
        
        double totalBanhoTosa = 0.0;
            totalBanhoTosa = banhotosa * valorBanhoTosa;
        System.out.println("O pet gastou um total de R$ " + totalBanhoTosa+ " com banho/tosa no mes atual");

        
        double totalUnhas = 0.0;
            totalUnhas =  unhas * valorUnhas;
        System.out.println("O pet gastou um total de R$ " + totalUnhas+ " com corte de unhas no mes atual");

        
        double totalHidrata = 0.0;
            totalHidrata = hidrata * valorHidrata;
        System.out.println("O pet gastou um total de R$ " + totalHidrata+ " com hidratacao no mes atual");

        
        double totalCompleto = 0.0;
            totalCompleto = completo * valorCompleto;
        System.out.println("O pet gastou um total de R$ " + totalCompleto+ " com servico completo no mes atual");

            }

    
    public void MediaGeral() {
        for (int i = 0; i < indice; i++) {
              System.out.print("\f");
        System.out.println("Media de servicos usados pelo Pet: " + pets[i].getNome());
        System.out.println("Banho: " + pets[i].getServutilE(0));
        System.out.println("Tosa: " + pets[i].getServutilE(1));
        System.out.println("Banho/Tosa: " + pets[i].getServutilE(2));
        System.out.println("Corte de Unhas: " + pets[i].getServutilE(3));
        System.out.println("Hidratacao: " + pets[i].getServutilE(4));
        System.out.println("Servico completo: " + pets[i].getServutilE(5));
        }
    }
    
    
    
    public void ConsultaMes(String nomePet) {
        Pet pet = localizarPet(nomePet);
        int [] consultar = pet.getServutil();
        String[] servicos = {"Banho", "Tosa", "BANHO/TOSA", "Unhas", "Hidratacao", "Completo"};
        for (int i = 0; i <consultar.length; i++) {
            int soma = 0;
                soma += consultar[i];
                if(consultar[i] >=1){
                    System.out.println("voce utilizou servicos de "+ servicos[i] + " " + soma + " vezes nesse Mes");                    
            }
        }
        }

    public void posicao(){
        for(int i=0; i<indice; i++){
            System.out.println("["+(i+1)+"] "+pets[i].getNome());

        }
    }

    
     public static String formatarTelefone(String numero) {
        // Remover caracteres não numéricos
        String numeroLimpo = numero.replaceAll("[^\\d]", "");

        // Verificar se o número tem a quantidade correta de dígitos
        if (numeroLimpo.length() != 11) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }

        // Usar StringBuilder para construir a formatação
        StringBuilder formatoTelefone = new StringBuilder("(");
        formatoTelefone.append(numeroLimpo, 0, 2)
                       .append(") ")
                       .append(numeroLimpo.charAt(2))
                       .append(" ")
                       .append(numeroLimpo, 3, 7)
                       .append("-")
                       .append(numeroLimpo, 7, 11);

        return formatoTelefone.toString();
    }
    
    public void Editar(String nomePet, int x) {
        Pet pet = localizarPet(nomePet);
        switch(x){
            case 1:
                System.out.println("\fDigite o novo nome: ");
                String nome = sc.nextLine();
                pet.setNome(nome);
                break;
            case 2:
                String[] tipos = {"Cachorro", "Gato", "Pássaro", "Coelho", "Furao","Porquinho da India"};
                System.out.println("\nSelecione a Especies: [1-6] ");
                for(int i=0; i<tipos.length; i++){
                    System.out.println("["+(i+1)+"] " + tipos[i]);
                }
                int s = sc.nextInt();
                String tipo = tipos[s-1]; 
                System.out.println("\fSelecionado "+tipo);
                pet.setTipo(tipo);
                break;
            case 3:
                System.out.println("\fDigite a nova especie: ");
                String especie = sc.nextLine();
                pet.setTipo(especie);
                break;
            case 4:
                System.out.println("\nDigite a nova idade: ");
                int idade = sc.nextInt();
                pet.setIdade(idade);
                break;
            case 5:
                System.out.println("\nDigite a nome do dono: ");
                String dono = sc.nextLine();
                pet.setDono(dono);
                break;
            case 6:
                System.out.println("\nDigite o numero do telefone: ");
                String numero = sc.nextLine();
                String telefone = formatarTelefone(numero);
                pet.setTelefone(telefone);
                break;
            default:
                 System.out.println("Opção inválida.");
                break;
        }
    }
    
    public void Estatisticas(){
        for(int i=0;i<indice;i++){
                int total = 0;
                int banhos = 0;
                int tosas = 0;
                int banhtos = 0;
                int unhas = 0;
                int hidrata = 0;
                int completo = 0;
            
             total += pets[i].totalservmes(); //100%
            
                //totalidades de servicos
                 banhos += pets[i].totalBanhosM();
                 tosas += pets[i].totalTosaM();
                 banhtos +=+ pets[i].totalBanhoTosaM();
                 unhas += pets[i].totalUnhasM();
                 hidrata += pets[i].totalHidrataM();
                 completo += pets[i].totalCompletoM();
                    
                //percents
                int bp = ((banhos/total)*100);
                int ts = ((tosas/total)*100);
                int bt = ((banhtos/total)*100);
                int un = ((unhas/total)*100);
                int hd = ((hidrata/total)*100);
                int cm = ((completo/total)*100);
                
                  System.out.print("\f");
                System.out.println("\nContamos com um total de " +indice+ " clientes");
                System.out.println("\nFizemos um total de " +total+ " servicos nesse mês");
                System.out.println("\nDemos um total " +banhos+ " banhos nesse mês,representando um porcentual de "+bp+" % nos nossos atendimentos");
                System.out.println("\nRealizamos um total de " +tosas+ " tosas neste mês, representando um percentual de "+ts+" % nos nossos atendimentos");
                System.out.println("\nRealizamos um total de " +banhtos+ " banhos com tosa neste mês, representando um percentual de "+bt+" % nos nossos atendimentos");
                System.out.println("\nCortamos as unhas de " +unhas+ " pets neste mês, representando um percentual de "+un+" % nos nossos atendimentos");
                System.out.println("\nRealizamos um total de " +hidrata+ " hidratações neste mês, representando um percentual de "+hd+" % nos nossos atendimentos");
                System.out.println("\nRealizamos um total de " +completo+ " serviços completos neste mês, representando um percentual de "+cm+" % nos nossos atendimentos");
            
            
            
        }
        }
    }
