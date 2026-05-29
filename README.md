# Batalha Naval P2P

Projeto de Batalha Naval desenvolvido em Java utilizando comunicação distribuída Peer-to-Peer (P2P) através do protocolo UDP.

O jogo funciona em dois terminais independentes, onde cada jogador envia e recebe ataques diretamente pela rede sem a necessidade de um servidor central.

---

## Tecnologias Utilizadas

* Java
* UDP Sockets
* Programação Multithread
* Comunicação P2P

---

## Funcionalidades

* Comunicação em tempo real utilizando UDP
* Sistema de turnos
* Posicionamento de navios
* Detecção de acertos e erros
* Verificação de derrota
* Execução simultânea utilizando Threads

---

## Estrutura do Projeto

```bash
Main.java
GerenciadorDeRede.java
Mapa.java
RecebeThread.java
```

---

## Como Compilar

No terminal, dentro da pasta do projeto:

```bash
javac *.java
```

---

## Como Executar

Abra dois terminais diferentes.

### Jogador 1

```bash
java Main 5000
```

### Jogador 2

```bash
java Main 5001
```

---

## Configuração da Conexão

Ao iniciar o jogo, informe:

### IP do inimigo

Para jogar na mesma máquina:

```bash
localhost
```

ou:

```bash
127.0.0.1
```

### Porta do inimigo

* Jogador da porta `5000` conecta na `5001`
* Jogador da porta `5001` conecta na `5000`

---

## Exemplo

### Terminal 1

```bash
java Main 5000
```

IP inimigo:

```bash
localhost
```

Porta inimiga:

```bash
5001
```

---

### Terminal 2

```bash
java Main 5001
```

IP inimigo:

```bash
localhost
```

Porta inimiga:

```bash
5000
```

---

## Conceitos Aplicados

Este projeto utiliza conceitos importantes de Sistemas Distribuídos, como:

* Comunicação P2P
* Sockets UDP
* Concorrência com Threads
* Comunicação assíncrona
* Sincronização entre jogadores

---

## Autor

Lucas Villas
