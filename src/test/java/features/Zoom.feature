#Author: Milton Denys

@inm_test
Feature: Validar pagina de buscas do zoom

  Scenario: Validar se é possivel buscar produtos pelo site zoom

    Given que preencho o campo de busca com o produto "celular"
    When eu clico no botao de buscar