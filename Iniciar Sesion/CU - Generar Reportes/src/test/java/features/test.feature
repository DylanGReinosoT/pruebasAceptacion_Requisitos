Feature: Generar Reporte
  Como administrador
  Quiero generar un reporte de inventario
  Para revisar el estado de la materia prima dentro de un rango de fechas

  Scenario: Generar reporte por fecha
    Given El administrador se encuentra en la pantalla principal del inventario
    When  Selecciona la opción "Generar Reporte"
    And   Ingresa la fecha de inicio "2024-01-01"
    And   Ingresa la fecha de fin "2024-01-31"
    And   Hace clic en el botón de "Generar Reporte"
    Then  El reporte debe generarse y mostrar la información correspondiente al rango de fechas seleccionado
    And   El administrador debe poder descargar el reporte en formato PDF