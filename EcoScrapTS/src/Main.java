import java.security.Timestamp;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.InputMismatchException;



public class Main {
    private static MySQL bd;
    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sdfBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
    private static boolean usuarioLogado = false;
    private static boolean ferroVelhoLogado = false;
    private static int idUsuario = -1;
    private static int idFerroVelho = -1;
    
    
    public static void main(String[] args) {
        bd = new MySQL(
                "localhost:3306", // servidor do banco de dados
                "ecoscrap", // nome do banco de dados
                "root",  // usuario do banco de dados
                "facens"); // senha do banco de dados
        if (!bd.conectaBanco()) {
            System.exit(1);
        }
    
        while (true) {
        System.out.println("Menu:");
        
        if (!usuarioLogado && !ferroVelhoLogado) {
            System.out.println("1. Realizar Cadastro de Usuário");
            System.out.println("2. Realizar Cadastro de Ferro Velho");
            System.out.println("3. Fazer Login Usuario");
            System.out.println("4. Fazer Login Ferro Velho");
            System.out.println("5. Ver cotacão");
            System.out.println("6. Realizar denuncia");
            System.out.println("7. Sair");
        } else if (usuarioLogado && !ferroVelhoLogado) {
            System.out.println("1. Ver cotacao");
            System.out.println("2. Realizar Denúncia");
            System.out.println("3. Deslogar");
            System.out.println("4. Sair");
        } else if(ferroVelhoLogado && !usuarioLogado){
            System.out.println("1. Ver cotacao");
            System.out.println("2. Inserir material reciclavel"); 
            System.out.println("3. Inserir material no estoque");
            System.out.println("4. Atualizar material reciclavel");
            System.out.println("5. Atualizar material no estoque");
            System.out.println("6. Deslogar");
            System.out.println("7. Sair");
        }
        
        System.out.print("Informe a sua opção:");
        int opcao = leInteiro();
        
        if (!usuarioLogado && !ferroVelhoLogado) {
            switch (opcao) {
                case 1:
                    realizarCadastroUsuario();
                    break;
                case 2:
                    realizarCadastroFerroVelho();
                    break;
                case 3:
                    idUsuario = fazerLogin();
                    if (idUsuario != -1) {
                        usuarioLogado = true;
                    }
                    break;
                case 4:
                    idFerroVelho = fazerLoginFerroVelho();
                    if (idFerroVelho != -1) {        
                    ferroVelhoLogado = true;
                    }
                    break;
                case 5:
                    verCotacao();
                    break;
                case 6:
                    fazerDenuncia();
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } else if (usuarioLogado) {
            switch (opcao) {
                case 1:
                    verCotacao();
                    break;
                case 2:
                    fazerDenuncia();
                    break;
                case 3:
                    break;
                case 4:
                    usuarioLogado = false;
                    idUsuario = -1;
                case 5:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } else if (ferroVelhoLogado){
            switch(opcao){
                case 1:
                    verCotacao();
                    break;
                case 2:
                    inserirMaterialReciclavel();
                    break;
                case 3:
                    inserirEstoqueFerroVelho(idFerroVelho);
                    break;
                case 4:
                    atualizarMaterial();
                    break;
                case 5:
                    alterarMaterialEstoque();
                    break;
                case 6:
                    ferroVelhoLogado = false;
                    idFerroVelho = -1;
                    break;  
                case 7:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
            
        }
    }
}
    
    public static Integer leInteiro() {
    Integer resultado = null;
    try {
        resultado = sc.nextInt();
        sc.nextLine();
    } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Por favor, insira um número inteiro válido.");
    }
    return resultado;
}
    
    public static double leDouble(){
        double resultado = sc.nextDouble();
        sc.nextLine();
        return resultado;
    }
    
    public static float leFloat(){
        float resultado = sc.nextFloat();
        sc.nextLine();
        return resultado;
    }
    
    public static String leString(){
        String resultado = sc.nextLine();
        return resultado;
    }
    
    public static char leChar(){
        char resultado = sc.next().charAt(0);
        return resultado;
    }
    
    public static Date leData() throws ParseException {
        Date date = sdf.parse(sc.next());
        return date;
    }
    
    public static void realizarCadastroUsuario() {
    Usuario usuario = new Usuario();
    System.out.println("Informe o nome completo");
    usuario.setNome_completo(leString());
    System.out.println("Informe o endereço");
    usuario.setEndereco(leString());
    System.out.println("Informe o nome do bairro");
    usuario.setBairro(leString());
    System.out.println("Informe o email");
    usuario.setEmail(leString());
    System.out.println("Informe a senha");
    usuario.setSenha(leString());
    System.out.println("Informe a data de nascimento");
    try {
          usuario.setDatanascimento(leData());
        } catch (ParseException e) {
            System.out.println("Erro ao ler data de nascimento: " + e.getMessage());
            return;
        }
    Date dataNascimento = usuario.getDatanascimento();
    SimpleDateFormat sdfBancoDados = new SimpleDateFormat("yyyy-MM-dd");
    String dataFormatadaBanco = sdfBancoDados.format(dataNascimento);

    System.out.println("Informe o sexo (M/F)");
    usuario.setSexo(leChar());
    
    System.out.println("É um vendedor (S/N)");
    usuario.setVendedor(leChar());
    
    String query = "INSERT INTO Usuario (nome_completo, endereco, bairro, email, senha, datanascimento, sexo, vendedor)"
                + " VALUES ("
                + "'" + usuario.getNome_completo()+ "', "
                + "'" + usuario.getEndereco() + "', "
                + "'" + usuario.getBairro() + "', "
                + "'" + usuario.getEmail()+ "', "
                + "'" + usuario.getSenha() + "', "
                + "'" + dataFormatadaBanco + "', "
                + "'" + usuario.getSexo() + "', "
                + "'" + usuario.getVendedor() + "'"
                + ")";
        if (bd.insert(query)) {
            System.out.println("Usuario cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar.");
        }
    }  
    
    public static void realizarCadastroFerroVelho(){
        FerroVelho ferrovelho = new FerroVelho();
        System.out.println("Informe o nome do ferro velho");
        ferrovelho.setNome(leString());
        System.out.println("Informe o cnpj");
        ferrovelho.setCnpj(leInteiro());
        System.out.println("Informe o endereço do ferro velho");
        ferrovelho.setEndereco(leString());
        System.out.println("Informe o bairro");
        ferrovelho.setBairro(leString());
        System.out.println("Informe o email");
        ferrovelho.setEmail(leString());
        System.out.println("Informe a senha");
        ferrovelho.setSenha(leString());
        
        String query = "INSERT INTO FERROVELHO (nome, cnpj, endereco, bairro, email, senha)"
                + " VALUES ("
                + "'" + ferrovelho.getNome() + "', "
                + ferrovelho.getCnpj() + ", "
                + "'" + ferrovelho.getEndereco() + "', "
                + "'" + ferrovelho.getBairro() + "', "
                + "'" + ferrovelho.getEmail() + "', "
                + "'" + ferrovelho.getSenha() + "'"
                + ")";
        if (bd.insert(query)) {
            System.out.println("Ferro velho cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar.");
        }
        
    }
    
    public static void inserirMaterialReciclavel() {
        MaterialReciclavel mr = new MaterialReciclavel();
        System.out.println("Informe o reciclável");
        mr.setReciclavel(leString());
        System.out.println("Informe o preço/kg");
        mr.setPreco_kg(leFloat());
        System.out.println("Informe a categoria");
        mr.setCategoria(leString());
        mr.setId_ferrovelho(idFerroVelho);
        
        String queryMaterial = "INSERT INTO MATERIALRECICLAVEL (id_ferrovelho, reciclavel, preco_kg, categoria) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatementMaterial = bd.prepareStatement(queryMaterial, Statement.RETURN_GENERATED_KEYS);
            preparedStatementMaterial.setInt(1, mr.getId_ferrovelho());
            preparedStatementMaterial.setString(2, mr.getReciclavel());
            preparedStatementMaterial.setFloat(3, mr.getPreco_kg());
            preparedStatementMaterial.setString(4, mr.getCategoria());
    
            int rowsAffected = preparedStatementMaterial.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = preparedStatementMaterial.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idMaterial = generatedKeys.getInt(1);
                    
                    String queryCotacao = "INSERT INTO COTACAO (id_ferrovelho, id_material, peso, valor_total) VALUES (?, ?, ?, ?)";
                    try {
                        PreparedStatement preparedStatementCotacao = bd.prepareStatement(queryCotacao);
                        System.out.println("Informe o peso para cotação");
                        float peso = leFloat();
                        float valorTotal = mr.getPreco_kg() * peso;
    
                        preparedStatementCotacao.setInt(1, idFerroVelho);
                        preparedStatementCotacao.setInt(2, idMaterial);
                        preparedStatementCotacao.setFloat(3, peso);
                        preparedStatementCotacao.setFloat(4, valorTotal);
    
                        int rowsAffectedCotacao = preparedStatementCotacao.executeUpdate();
                        if (rowsAffectedCotacao == 1) {
                            System.out.println("Material reciclável inserido com sucesso, junto com a cotação.");
                        } else {
                            System.out.println("Erro ao inserir cotação.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Erro ao recuperar o ID do material reciclável.");
                }
            } else {
                System.out.println("Erro ao inserir material reciclável.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public static void fazerDenuncia() {
        Denuncia denuncia = new Denuncia();
        System.out.println("Informe o endereço do ocorrido");
        denuncia.setEndereco(leString());
        System.out.println("Informe o bairro do ocorrido");
        denuncia.setBairro(leString());
        System.out.println("Informe a data do ocorrido (dd/MM/yyyy)");
        try {
            denuncia.setDataOcorrido(leData());
        } catch (ParseException e) {
            System.out.println("Erro ao ler data do ocorrido: " + e.getMessage());
            return;
        }
        System.out.println("Informe a descrição da ocorrência");
        denuncia.setDescricao(leString());

        String query;
        if (usuarioLogado) {
            query = "INSERT INTO DENUNCIA (id_usuario, endereco, bairro, data_ocorrido, descricao) VALUES (?, ?, ?, ?, ?)";
        } else {
            query = "INSERT INTO DENUNCIA (endereco, bairro, data_ocorrido, descricao) VALUES (?, ?, ?, ?)";
        }

        try (PreparedStatement preparedStatement = bd.prepareStatement(query)) {
            if (usuarioLogado) {
                preparedStatement.setInt(1, idUsuario);
                preparedStatement.setString(2, denuncia.getEndereco());
                preparedStatement.setString(3, denuncia.getBairro());
                preparedStatement.setDate(4, new java.sql.Date(denuncia.getDataOcorrido().getTime()));
                preparedStatement.setString(5, denuncia.getDescricao());
            } else {
                preparedStatement.setString(1, denuncia.getEndereco());
                preparedStatement.setString(2, denuncia.getBairro());
                preparedStatement.setDate(3, new java.sql.Date(denuncia.getDataOcorrido().getTime()));
                preparedStatement.setString(4, denuncia.getDescricao());
            }

            if (bd.insert(preparedStatement)) {
                System.out.println("Denúncia feita com sucesso.");
            } else {
                System.out.println("Erro ao cadastrar a denúncia.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao preparar a consulta SQL: " + e.getMessage());
        }
    }
    
    public static void inserirEstoqueFerroVelho(int id_ferrovelho) {
    List<MaterialReciclavel> materiais = getMateriaisCadastrados(idFerroVelho);
    if (materiais.isEmpty()) {
        System.out.println("Não há materiais cadastrados no sistema.");
        return;
    }

    System.out.println("Materiais cadastrados:");
    for (MaterialReciclavel material : materiais) {
        System.out.println("ID: " + material.getId_material() + ", Reciclavel: " + material.getReciclavel() + ", Preço/Kg: " + material.getPreco_kg() + ", Categoria: " + material.getCategoria());
    }

    System.out.println("Informe o id do material");
    int idMaterial = leInteiro();

    System.out.println("Informe quantos KG no estoque");
    int kg = leInteiro();

    String query = "INSERT INTO ESTOQUEFERROVELHO (id_ferrovelho, id_material, kg)" +
                   " VALUES (?, ?, ?)";
    try (PreparedStatement preparedStatement = bd.prepareStatement(query)) {
        preparedStatement.setInt(1, id_ferrovelho);
        preparedStatement.setInt(2, idMaterial);
        preparedStatement.setInt(3, kg);

        if (bd.insert(preparedStatement)) {
            System.out.println("Estoque adicionado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
    }
}
    
    public static List<MaterialReciclavel> getMateriaisCadastrados(int idFerroVelho) {
    List<MaterialReciclavel> materiais = new ArrayList<>();
    
    String query = "SELECT * FROM MATERIALRECICLAVEL WHERE id_ferrovelho = ?";
    ResultSet rs = bd.query(query, idFerroVelho);
    try {
        if (rs != null) {
            while (rs.next()) {
                MaterialReciclavel material = new MaterialReciclavel();
                material.setId_material(rs.getInt("Id_material"));  
                material.setId_ferrovelho(rs.getInt("id_ferrovelho"));
                material.setReciclavel(rs.getString("reciclavel"));
                material.setPreco_kg(rs.getFloat("preco_kg"));
                material.setCategoria(rs.getString("categoria"));
                materiais.add(material);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        bd.closeResultSet(rs);
    }
    return materiais;
}
    
    public static List<EstoqueFerroVelho> getEstoqueFerroVelho(int idFerroVelho) {
    List<EstoqueFerroVelho> estoquesFerrosVelhos = new ArrayList<>();
    
    String query = "SELECT * FROM ESTOQUEFERROVELHO WHERE id_ferrovelho = ?";
    ResultSet rs = bd.query(query, idFerroVelho);
    try {
        if (rs != null) {
            while (rs.next()) {
                EstoqueFerroVelho estoqueFerroVelho = new EstoqueFerroVelho();
                estoqueFerroVelho.setId_ferrovelho(rs.getInt("id_ferrovelho"));
                estoqueFerroVelho.setId_material(rs.getInt("id_material"));
                estoqueFerroVelho.setKg(rs.getInt("kg"));
                estoquesFerrosVelhos.add(estoqueFerroVelho);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        bd.closeResultSet(rs);
    }
    return estoquesFerrosVelhos;
}

    public static int fazerLogin() {
    System.out.print("Email: ");
    String email = leString();
    System.out.print("Senha: ");
    String senha = leString();

    if (!email.isEmpty() && !senha.isEmpty()) {
        String query = "SELECT * FROM USUARIO WHERE email = ? AND senha = ?";
        ResultSet rs = bd.query(query, email, senha);
        try {
            if (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                System.out.println("Logado com sucesso");
                return idUsuario;
            } else {
                System.out.println("Email ou senha incorretos");
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.closeResultSet(rs);
        }
    }
    return -1;
}

    public static int fazerLoginFerroVelho() {
    System.out.print("Email: ");
    String email = leString();
    System.out.print("Senha: ");
    String senha = leString();

    if (!email.isEmpty() && !senha.isEmpty()) {
        String query = "SELECT id_ferrovelho FROM FERROVELHO WHERE email = ? AND senha = ?";
        ResultSet rs = bd.query(query, email, senha);
        try {
            if (rs.next()) {
                int idFerroVelho = rs.getInt("id_ferrovelho");
                System.out.println("Ferro velho logado com sucesso");
                return idFerroVelho;
            } else {
                System.out.println("Email ou senha incorretos");
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.closeResultSet(rs);
        }
    }
    return -1;
}
    
    public static void atualizarMaterial() {
    List<MaterialReciclavel> materiais = getMateriaisCadastrados(idFerroVelho);
    System.out.println("Materiais cadastrados pelo seu ferro velho: ");
    for (MaterialReciclavel material : materiais) {
        System.out.println("ID: " + material.getId_material() + ", Reciclavel: " + material.getReciclavel() + ", Preço/Kg: " + material.getPreco_kg() + ", Categoria: " + material.getCategoria());
    }
    
    System.out.println("Informe o ID do material selecionado: ");
    int idMaterialSelecionado = leInteiro();
    
    MaterialReciclavel materialSelecionado = null;
    for (MaterialReciclavel material : materiais) {
        if (material.getId_material() == idMaterialSelecionado) {
            materialSelecionado = material;
            break;
        }
    }
    
    if (materialSelecionado != null) {
        System.out.println("Informe o novo valor para Reciclavel: ");
        float novoPrecoReciclavel = leFloat();
        
        String queryMaterial = "UPDATE MATERIALRECICLAVEL SET preco_kg = ? WHERE id_ferrovelho = ? AND id_material = ?";
        try (PreparedStatement preparedStatementMaterial = bd.prepareStatement(queryMaterial)) {
            preparedStatementMaterial.setFloat(1, novoPrecoReciclavel);
            preparedStatementMaterial.setInt(2, idFerroVelho);
            preparedStatementMaterial.setInt(3, idMaterialSelecionado);

            int rowsAffectedMaterial = preparedStatementMaterial.executeUpdate();

            if (rowsAffectedMaterial > 0) {
                System.out.println("Material atualizado com sucesso.");
            } else {
                System.out.println("Nenhum material foi atualizado. Verifique se o ID do ferro velho e/ou o novo preço são válidos.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta SQL para atualizar o preço do material: " + e.getMessage());
        }
        
        String queryCotacao = "UPDATE COTACAO SET peso = ?, valor_total = ? WHERE id_material = ?";
        try (PreparedStatement preparedStatementCotacao = bd.prepareStatement(queryCotacao)) {
            System.out.println("Informe o novo peso para cotação: ");
            float novoPeso = leFloat();
            float novoValorTotal = novoPrecoReciclavel * novoPeso;

            preparedStatementCotacao.setFloat(1, novoPeso);
            preparedStatementCotacao.setFloat(2, novoValorTotal);
            preparedStatementCotacao.setInt(3, idMaterialSelecionado);

            int rowsAffectedCotacao = preparedStatementCotacao.executeUpdate();
            if (rowsAffectedCotacao > 0) {
                System.out.println("Peso e valor total atualizados com sucesso na cotação.");
            } else {
                System.out.println("Nenhuma cotação foi atualizada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta SQL para atualizar a cotação: " + e.getMessage());
        }
    } else {
        System.out.println("Material não encontrado.");
    }
}
    
    public static void alterarMaterialEstoque() {
    List<EstoqueFerroVelho> estoquesFerrosVelhos = getEstoqueFerroVelho(idFerroVelho);
    System.out.println("Materiais em seu estoque: ");
    for (EstoqueFerroVelho estoque : estoquesFerrosVelhos) {
        System.out.println("ID material: " + estoque.getId_material() + ", Nome: " + getNomeMaterial(estoque.getId_material()) + ", KG: " + estoque.getKg());
    }

    System.out.println("Informe o material que deseja alterar: ");
    int idMaterialSelecionado = leInteiro();
    
    EstoqueFerroVelho materialSelecionado = null;
    for (EstoqueFerroVelho estoque : estoquesFerrosVelhos) {
        if (estoque.getId_material() == idMaterialSelecionado) {
            materialSelecionado = estoque;
            break;
        }
    }

    if (materialSelecionado != null) {
        System.out.println("Informe o novo peso do Material: ");
        int novoPeso = leInteiro();
        
        String query = "UPDATE ESTOQUEFERROVELHO SET kg = ? WHERE id_ferrovelho = ? AND id_material = ?";
        try (PreparedStatement preparedStatement = bd.prepareStatement(query)) {
            preparedStatement.setInt(1, novoPeso);
            preparedStatement.setInt(2, idFerroVelho);
            preparedStatement.setInt(3, idMaterialSelecionado);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Estoque atualizado com sucesso.");
            } else {
                System.out.println("Nenhum material foi atualizado. Verifique se o ID do material é válido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
        }
    } else {
        System.out.println("Material não encontrado.");
    }
}
  
    public static String getNomeMaterial(int idMaterial) {
    String query = "SELECT reciclavel FROM MATERIALRECICLAVEL WHERE id_material = ?";
    ResultSet rs = bd.query(query, idMaterial);
    try {
        if (rs != null && rs.next()) {
            return rs.getString("reciclavel");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        bd.closeResultSet(rs);
    }
    return "Não encontrado";
}
    
    public static void verCotacao() {
    String query = "SELECT MR.reciclavel, C.peso, C.data_cotacao, C.valor_total " +
                   "FROM COTACAO C " +
                   "INNER JOIN MATERIALRECICLAVEL MR ON C.id_material = MR.id_material";

    ResultSet rs = bd.query(query);
    try {
        boolean hasCotacoes = false;
        if (rs != null) {
            System.out.println("Cotações:");
            while (rs.next()) {
                String material = rs.getString("reciclavel");
                double peso = rs.getDouble("peso");
                java.sql.Timestamp dataCotacao = rs.getTimestamp("data_cotacao");
                float valorTotal = rs.getFloat("valor_total");

                System.out.println("Material: " + material + ", Peso: " + peso + ", Data da Cotação: " + dataCotacao + ", Valor Total: " + valorTotal);
                hasCotacoes = true;
            }
        }
        if (!hasCotacoes) {
            System.out.println("Não há cotações disponíveis no momento.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        bd.closeResultSet(rs);
    }
}

    
}

