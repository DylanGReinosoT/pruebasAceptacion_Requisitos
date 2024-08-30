Feature: Iniciar Sesion
  Como administrador
  Quiero entrar a la pagina
  Para poder ver las opciones del inventario

  Scenario: Iniciar sesion con las credenciales correctas
    Given El administrador se encuentra en la pagina Inicio
    When  Ingrese su usuario y contraseña correctas
    And   Haga clic en el boton de Iniciar Sesion
    Then  Se debe redirigir a la pantalla del inventario