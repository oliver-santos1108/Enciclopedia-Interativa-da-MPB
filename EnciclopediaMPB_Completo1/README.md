# Enciclopédia Interativa da MPB - versão completa

Projeto Java Swing (Java 8+) com MVC, JDBC e MySQL, preparado para importar no Eclipse.

## 1. Banco de dados

Execute no MySQL:

```sql
CREATE DATABASE IF NOT EXISTS mpb CHARACTER SET utf8mb4;
CREATE USER IF NOT EXISTS 'aluno_cd'@'localhost' IDENTIFIED BY 'aluno_pw';
GRANT ALL PRIVILEGES ON mpb.* TO 'aluno_cd'@'localhost';
FLUSH PRIVILEGES;

USE mpb;

CREATE TABLE IF NOT EXISTS artista (
  id_artista INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  data_nascimento INT NOT NULL,
  quant_albuns INT NOT NULL,
  albuns VARCHAR(1200) NOT NULL,
  data_falecimento INT,
  local_nascimento VARCHAR(1200)
);

-- Necessário para a funcionalidade de fotografias:
ALTER TABLE artista ADD COLUMN foto LONGBLOB NULL;
```

Se a coluna `foto` já existir, não execute novamente o `ALTER TABLE`.

## 2. Abrir no Eclipse

1. Descompacte a pasta.
2. Eclipse: **File > Import > Existing Projects into Workspace**.
3. Selecione a pasta `EnciclopediaMPB_Completo`.
4. Baixe o **MySQL Connector/J** compatível com sua instalação do MySQL.
5. No Eclipse, botão direito no projeto > **Build Path > Configure Build Path > Libraries > Add External JARs** e selecione o arquivo `mysql-connector-j-....jar`.
6. Confira se o projeto está usando Java 8 ou superior.
7. Execute `src/Main.java` como **Java Application**.

## 3. Conexão

As configurações estão centralizadas em `src/model/Conexao.java`:

- URL: `jdbc:mysql://localhost:3306/mpb`
- usuário: `aluno_cd`
- senha: `aluno_pw`

Se você alterar as credenciais no MySQL, altere somente essa classe.

## 4. Organização MVC

- `model`: entidade Artista, conexão, repositório JDBC e processamento de imagens.
- `view`: janela principal, modelo da JTable e diálogos Sobre/Manual.
- `controller`: eventos e regras de coordenação.
- `util`: informações centralizadas do software.
- `manual`: manual HTML carregado pela janela de ajuda.
- `img`: recursos visuais (logo e ícone).

## 5. Funcionalidades

- Inserir, listar, pesquisar, editar e excluir artistas.
- Ordenação da tabela pelo cabeçalho.
- Seleção de registro para edição (a conversão de índice da linha ordenada é feita no getter da View).
- Fotografia opcional: JFileChooser, redução proporcional para até 600 px, armazenamento LONGBLOB.
- A listagem não carrega BLOB; a foto é consultada sob demanda.
- Navegação com CardLayout, layouts adaptáveis e menu Ajuda.

## 6. Dados do Sobre

Edite `src/util/InfoApp.java` para preencher o nome do professor e ajustar autores, disciplina ou ano.

## 7. WindowBuilder

As janelas são componentes Swing padrão e o código pode ser aberto na aba **Source** do WindowBuilder. A interface foi construída por código Java com layouts gerenciados (não usa `setBounds`/AbsoluteLayout). O WindowBuilder pode não representar visualmente todos os painéis criados por métodos auxiliares; nesse caso, use a aba Source para editar e execute o programa para validar.

## 8. Observação sobre o repositório original

Esta entrega é um projeto Eclipse completo e autocontido, baseado no esquema SQL e nos roteiros fornecidos. Como a leitura dos arquivos internos do repositório GitHub não ficou disponível nesta sessão, não substitui automaticamente os arquivos já existentes do seu repositório. Compare/mescle os arquivos antes de sobrescrever sua versão em andamento.
