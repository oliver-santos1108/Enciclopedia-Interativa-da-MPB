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
ALTER TABLE artista ADD COLUMN foto LONGBLOB NULL;
