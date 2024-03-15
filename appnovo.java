import java.util.*;

public class appnovo
{
    public static void main(String[] args) {
    
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    CadastroPet cadastro = new CadastroPet(20); // Número máximo de pets a serem cadastrados
    System.out.println("\f");
    boolean open = true;
    
    while (open) {
        System.out.println("\nEscolha uma opção:");
        System.out.println("[1] Cadastrar novo pet");
        System.out.println("[2] Editar/Excluir");
        System.out.println("[3] Resumos");  
        System.out.println("[4] Nome dos pets em ordem alfabetica");
        System.out.println("[5] Agendar um servico");
        System.out.println("[6] Remarcar/Consultar"); 
        System.out.println("[7] Estatisticas");
        System.out.println("[8] Consultar a conta"); 
        System.out.println("[9] Sair");
        
        int opcao = sc.nextInt();
        sc.nextLine();
        
        switch (opcao) {
            case 1:
                System.out.println("\f");
                String nome;
                System.out.println();
                System.out.println("\nDigite o nome do Pet");
                nome = sc.nextLine();

                
                String[] tipos = {"Cachorro", "Gato", "Pássaro", "Coelho", "Furao","Porquinho da India"};
                System.out.println("\nSelecione a Especies: [1-6] ");
                for(int i=0; i<tipos.length; i++){
                    System.out.println("["+(i+1)+"] " + tipos[i]);
                }
                int s = sc.nextInt();
                String tipo = tipos[s-1]; 
                System.out.println("\f");
                System.out.println("Selecionado "+tipo);

                    //utilizei preenchimentos aleatorios e automaticos para nao perder tempo testando
                String[] racas = {"Golden Retriever", "Siamese", "Labrador", "Persian", "Chihuahua"};  //System.out.println("\nDigite a raca do Pet");
                String raca = racas[random.nextInt(racas.length)];

                    
                String[] donos = {"João", "Maria", "Carlos", "Ana", "Pedro"};
                String dono = donos[random.nextInt(donos.length)];
                int idade = random.nextInt(10) + 1;
                
                 sc.nextLine();
                System.out.println("\nDigite o seu telefone");
                String numero = sc.nextLine();
                String telefone = cadastro.formatarTelefone(numero);

                Pet novoPet = new Pet(nome, tipo, raca, idade, dono, telefone);
                cadastro.adicionarPet(novoPet);
                System.out.println("\nPet cadastrado com sucesso!");
                break;
            case 2:
                System.out.println("\f");
                System.out.print("Informe o nome do pet");
                nome = sc.nextLine();
                System.out.println("[1] Excluir da Lista");
                System.out.println("[2] Editar");
                int jk = sc.nextInt();
                    switch(jk){
                        case 1:  
                        cadastro.removePet(nome);
                        break;
                        case 2: 
                        System.out.println("O que voce gostaria de editar?");
                        System.out.println("[1] Nome do pet");
                        System.out.println("[2] Especie");
                        System.out.println("[3] Raca");
                        System.out.println("[4] Idade");
                        System.out.println("[5] Nome do dono");
                        System.out.println("[6] Telefone");
                        int x = sc.nextInt();
                        cadastro.Editar(nome, x);
                        break;
            }
                break;
            case 3:
                System.out.print("\f");
                System.out.println("[1] PET`s");
                System.out.println("[2] Servicos");
                System.out.println("[3] Posicao de cada pet");
                int lm = sc.nextInt();
                switch(lm){
                    case 1:  
                    cadastro.escreverPets();
                        break;
                    case 2:
                        cadastro.MediaGeral();
                        break;
                    case 3:
                    System.out.println("\fNome e posicao de cada pet:");
                            cadastro.posicao();
                        break;
                }
                break;
            case 4:
                cadastro.nomesabc();
                break;
            case 5:
                System.out.println("\f");
                System.out.print("Informe o nome do pet que gostaria de agendar um servico: ");
                nome = sc.nextLine();
                System.out.println("\nDigite o servico (1-6):");
                System.out.println("[1] BANHO");
                System.out.println("[2] TOSA");
                System.out.println("[3] BANHO/TOSA");
                System.out.println("[4] CORTAR UNHAS");
                System.out.println("[5] HIDRATA");
                System.out.println("[6] COMPLETO");
                int servico = sc.nextInt();
                System.out.println("Digite o dia que gostaria de agendar o servico (1-7):");
                System.out.println("[1] DOMINGO");
                System.out.println("[2] SEGUNDA");
                System.out.println("[3] TERCA");
                System.out.println("[4] QUARTA");
                System.out.println("[5] QUINTA");
                System.out.println("[6] SEXTA");
                System.out.println("[7] SABADO");
                int dia = sc.nextInt();
                sc.nextLine();
                cadastro.Agendar(nome, (servico-1), (dia-1), 1);
                break;
            case 6:
                System.out.println("\f");
                System.out.println("[1] Agenda da Semana");
                System.out.println("[2] Servicos Realizados no mes");
                System.out.println("[3] Fechar semana");
                System.out.println("[4] Voltar");
                int op = sc.nextInt();
                switch (op){
                    case 1:
                    System.out.println("\f");
                    System.out.println("Digite o nome do pet que gostaria de consultar");
                    nome = sc.nextLine();
                    nome = sc.nextLine();
                    cadastro.ConsultaSemanal(nome);
                    System.out.println("----   Agenda da Semana   ----");
                    System.out.println("[1] Cancelar Servicos");
                    System.out.println("[2] Remarcar Servicos");
                    System.out.println("[3] Voltar");
                    int op1 = sc.nextInt();
                        switch(op1){
                        case 1:
                        cadastro.CancelarAg(nome);
                                break;
                        case 2:
                        cadastro.CancelarAg(nome);
                        System.out.println("\nSelecione o servico novamente (1-6):");
                        System.out.println("[1] BANHO");
                        System.out.println("[2] TOSA");
                        System.out.println("[3] BANHO/TOSA");
                        System.out.println("[4] CORTAR UNHAS");
                        System.out.println("[5] HIDRATA");
                        System.out.println("[6] COMPLETO");
                        int servico1 = sc.nextInt();
                        System.out.println("Digite o dia que gostaria de agendar o servico (1-7):");
                        System.out.println("[1] DOMINGO");
                        System.out.println("[2] SEGUNDA");
                        System.out.println("[3] TERCA");
                        System.out.println("[4] QUARTA");
                        System.out.println("[5] QUINTA");
                        System.out.println("[6] SEXTA");
                        System.out.println("[7] SABADO");
                        int dia1 = sc.nextInt();
                        sc.nextLine();
                        cadastro.Agendar(nome, (servico1-1), (dia1-1), 1);
                                break;
                        case 3:
                                System.out.println("\f");
                            break;
                    }
                        break;
                    case 2:
                    System.out.println("Digite o nome do pet que gostaria de consultar");
                    nome = sc.nextLine();
                    cadastro.ConsultaMes(nome);
                    case 3:
                        cadastro.fecharSemana();
                        System.out.println("Semana Finalizada, dados salvos!");
                        break;
                    case 4:
                        System.out.println("\f");
                         break;
                }
                break;
            case 7:
                cadastro.Estatisticas();
                break;
            case 8:
                System.out.println("\nDigite o nome do pet para fazer a consulta:");
                nome = sc.nextLine();
                cadastro.Caixa(nome);
                break;
            case 9:
                open = false;
                System.out.println("Saindo do programa.");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");

             
        }
    }
}   
}