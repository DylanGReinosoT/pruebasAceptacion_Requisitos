Feature: Iniciar sesion
  Como administrador
  Quiero ingrear a la pagina
  Para poder revisar el inventario

  Scenario: Ingresar al inventario como administrador
    Given   El administrador ha iniciado sesión en la página web
    When    Ingresa su usuario y contraseña
    And     Hace click en el boton Iniciar Sesion
    Then    Se debe redirigir a la pantalla Inicio