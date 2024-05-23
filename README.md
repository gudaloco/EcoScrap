# ECOSCRAP

![ecoscrap](https://github.com/GustavoMedeirosBarros/EcoScrap-TelaAzul/assets/160978113/1d6edb7e-41e2-4253-9da5-1f62202d335c)

# Descrição:
EcoScrap é um sistema que mostra preços de materiais recicláveis e permite que as pessoas denunciem atividades ilegais em ferro-velhos. O objetivo do sistema é simplificar a negociação de materiais recicláveis, fornecendo valores atualizados de forma instantânea, além de ser uma ferramenta eficaz para prevenção de atividades ilegais no campo de reciclagem.

# Pré-requisitos:
## Linguagem:
[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)

## Bibliotecas usadas:
- JBDC

## IDE:
[![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)](https://www.eclipse.org)

# Estrutura do projeto:
## Classes utilizadas:
1. Usuario
2. Ferro Velho
3. Denuncia
4. Material Reciclavel
5. Cotacão
6. Estoque ferro velho

### 1. Usuário:
A classe Usuário permite que os indivíduos realizem cadastro ou façam login no sistema. Eles podem também registrar denúncias sobre ferros-velhos ilegais e visualizar a cotação dos materiais recicláveis.

### 2. Ferro Velho:
A classe Ferro Velho possibilita o cadastro ou login no sistema por parte dos estabelecimentos. Eles podem inserir materiais recicláveis no sistema, adicionar esses materiais ao seu estoque e ajustar os preços. Além disso, têm acesso à cotação desses materiais.

### 3. Denúncia:
A classe Denúncia é responsável pelo registro de denúncias relacionadas a ferros-velhos ilegais no sistema. Seus parâmetros incluem descrição, data do incidente e localização.

### 4. Material Reciclável:
A classe Material Reciclável é utilizada para cadastrar os diferentes tipos de materiais recicláveis no sistema, especificando-se sua natureza, preço por quilo e categoria.

### 5. Cotação:
A classe Cotação foi implementada para fornecer informações claras sobre a cotação dos materiais no sistema.

### 6. Estoque do Ferro Velho:
Esta classe armazena os materiais presentes no estoque dos ferros-velhos.

# Implementações:
### V1.0
Foi criado o banco de dados e o menu inicial.

### V1.1
Foi implementado o banco de dados e as classes,e os metodos fazerCadastro,fazerCadastroFerroVelho e realizarDenuncia.

### V1.2
Foram implementados o login do usuario e ferro velho.

### V1.3
Foram adicionados os metodos de registrar material reciclavel e o metodo do ferro velho fazer estoque.

### V1.4 
Foram adicionados os metodos de atualizar o material reciclavel e atualizar estoque do ferro velho

### V1.5
Foi adicionado o metodo de ver cotação.

# Versionamento:
V1.5

# Autores:
Integrantes, RA, responsabilidade, contato

Gustavo Galdino Alexandre Cavalcante 237052 - Programador Front-END - Email: gustavo.galdino.2005@gmail.com

Gustavo Medeiros Barros dos Santos 237321 - Banco de dados e programação Back-END - Email: gm7661830@gmail.com

Lucas Goulart Miranda 200192 - Documentação - Email: meoxplays@hotmail.com

Luccas Abreu Silva 237201 - Trello e planejamento - Email: luccas.silva31@outlook.com

Neemias Aguiar de Mello 237321 - Documentação e diagramas - Email: neemias.aguiar@hotmail.com
