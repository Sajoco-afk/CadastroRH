# 💼 ProjetoRH — Sistema de Gerenciamento de Funcionários

Projeto desenvolvido em **Java** com o objetivo de praticar e aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** na construção de um sistema simples de Recursos Humanos.

O sistema permite cadastrar funcionários de diferentes tipos, calcular seus pagamentos, exibir seus dados e aplicar aumentos salariais de forma geral.

## 🚀 Funcionalidades

* Cadastro de até 10 funcionários;
* Cadastro de funcionários **assalariados** ou **horistas**;
* Armazenamento de informações como:

  * Nome;
  * CPF;
  * Endereço;
  * Telefone;
  * Setor;
* Cálculo automático do pagamento de cada funcionário;
* Aplicação de aumento percentual para todos os funcionários;
* Exibição dos dados antes e depois do aumento;
* Validação básica das entradas fornecidas pelo usuário;
* Aceitação de valores decimais utilizando `.` ou `,`.

## 🧠 Conceitos de Java aplicados

Este projeto foi desenvolvido principalmente para colocar em prática conceitos de **POO**, incluindo:

* **Classes e objetos**
* **Classe abstrata**
* **Herança**
* **Encapsulamento**
* **Polimorfismo**
* **Métodos abstratos**
* **Sobrescrita de métodos (`@Override`)**
* **Construtores**
* **Getters e Setters**
* **Collections (`List` e `ArrayList`)**
* **Entrada de dados com `Scanner`**
* **Tratamento de exceções**
* **Estruturas de repetição e condicionais**
* **Organização de código utilizando pacotes**

## 🏗️ Estrutura do projeto

```text
ProjetoRH/
├── src/
│   └── rh/
│       ├── Funcionario.java
│       ├── Assalariado.java
│       ├── Horista.java
│       └── Main.java
│
├── nbproject/
├── build.xml
└── manifest.mf
```

### 📌 `Funcionario.java`

Classe abstrata que representa um funcionário de forma genérica.

Ela concentra os atributos comuns aos funcionários e define métodos abstratos para:

* Calcular pagamento;
* Aplicar aumento;
* Identificar o tipo de funcionário.

### 📌 `Assalariado.java`

Representa funcionários que recebem um **salário mensal fixo**.

O cálculo do pagamento é baseado no salário mensal, e o aumento percentual é aplicado diretamente sobre esse valor.

### 📌 `Horista.java`

Representa funcionários remunerados de acordo com as **horas trabalhadas** e o **valor da hora**.

```text
Pagamento = Horas Trabalhadas × Valor da Hora
```

O aumento percentual é aplicado sobre o valor da hora.

### 📌 `Main.java`

Classe responsável pela execução do sistema.

Ela realiza:

1. Cadastro dos funcionários;
2. Identificação do tipo de funcionário;
3. Armazenamento dos funcionários em uma `List<Funcionario>`;
4. Exibição dos pagamentos;
5. Aplicação do aumento;
6. Exibição dos novos valores.

## 🔄 Polimorfismo na prática

Um dos principais objetivos do projeto é demonstrar o uso de **polimorfismo**.

Mesmo funcionários de tipos diferentes são armazenados na mesma lista:

```java
List<Funcionario> funcionarios = new ArrayList<>();
```

Assim, o sistema consegue trabalhar com objetos `Assalariado` e `Horista` através da referência da classe `Funcionario`, enquanto cada objeto executa sua própria implementação de:

```java
calcularPagamento()
aplicarAumento()
getTipo()
```

Isso permite que o código seja mais organizado e preparado para receber novos tipos de funcionários no futuro.

## 🛠️ Tecnologias utilizadas

* **Java**
* **Programação Orientada a Objetos**
* **ArrayList / List**
* **Scanner**
* **NetBeans**
* **JDK 11 ou superior**

## ▶️ Como executar

### 1. Clone o repositório

```bash
git clone URL_DO_SEU_REPOSITORIO
```

### 2. Abra o projeto no NetBeans

Abra o diretório:

```text
ProjetoRH
```

### 3. Execute a classe principal

A classe principal do projeto é:

```text
rh.Main
```

Também é possível compilar e executar pelo terminal, dependendo da configuração do ambiente Java.

## 📚 Objetivo do projeto

Este projeto faz parte da minha jornada de aprendizado em **Desenvolvimento de Sistemas** e representa uma etapa importante na minha evolução com Java.

Além de praticar a sintaxe da linguagem, o projeto ajudou a compreender melhor como estruturar classes, relacionar objetos e utilizar os princípios da Programação Orientada a Objetos para resolver um problema próximo de uma aplicação real.

> 🚧 Projeto desenvolvido para fins de estudo e aprendizado em Java.

## 👨‍💻 Autor

**Samuel Covalski**

Estudante de **Desenvolvimento de Sistemas**, em transição para a área de tecnologia e construindo projetos para desenvolver experiência prática em programação.

---

⭐ Se este projeto foi útil para você ou se tiver alguma sugestão de melhoria, fique à vontade para contribuir!
