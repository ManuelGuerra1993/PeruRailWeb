@Todo
Feature: Como usuario final quiero validar las funciones del booking

  Background:
    Given El usuario ingresa a la web de PeruRail

  @Peru_rail
  Scenario Outline: Registro de ticket solo ida Puno a Cusco
    Given selecciono el tipo de viaje "<viaje>"
    When selecciono el destino "<destino>"
    And selecciono la ruta "<ruta>"
    And selecciono el tren "<tren>"
    And selecciono la fecha de salida "<Dia>" "<Mes>" "<Anio>"
    And hago click en el botón Find Train Ticket
    Then se muestra del paso_2 Elige tu cabina
    When selecciono la cabina "<cabina>" y la cantidad de pasajeros "<cantidad>"
    And hago clic en el boton X del popUp
    And hago clic en Purchase Summary en la pantalla 2
    And valido que los montos sean iguales en el paso 2
    And hago click en el botón continue en el paso 2
    Then se muestra del paso_3 Datos del Pasajero
    And ingreso los datos del pasajero "<cabina>" "<cantidad>"
    And hago click en el botón continue en el paso 3
    Then se muestra del paso_4 Confirmacion y Pago
    #When selecciono el metodo de pago "<pago>" en el paso 4
    #And hago click en el botón Ingresar Tarjeta del paso 4
    #And ingreso los datos de mi tarjeta "<pago>" "<nroTarjeta>" "<mesV>" "<anioV>" "<codSeguridad>" "<nombreTarjeta>"
    #And hago click en el botón continue en el paso 4
    Then cierro la aplicacion
    Examples:
      | viaje   | destino | ruta         | tren                             | Dia | Mes | Anio | cabina | cantidad | pago | nroTarjeta   | mesV | anioV | codSeguridad | nombreTarjeta |
      | One Way | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 20  | 7   | 2022 | suite  | 5        | visa | 454545454545 | 03   | 28    | 999          | Pruebas manu  |

  @Peru_rail
  Scenario Outline: Registro de ticket solo ida Puno a Cusco
    Given El usuario selecciona el tipo de viaje y la ruta "<viaje>" "<destino>" "<ruta>" "<tren>" "<Dia>" "<Mes>" "<Anio>"
    When El usuario selecciona la cabina "<cabina>", pasajeros "<cantidad>" y valida el monto a pagar
    And ingreso los datos del pasajero "<cabina>" "<cantidad>"
    And hago click en el botón continue en el paso 3
    Then se muestra del paso_4 Confirmacion y Pago
    And cierro la aplicacion
    Examples:
      | viaje   | destino | ruta         | tren                             | Dia | Mes | Anio | cabina | cantidad | pago | nroTarjeta   | mesV | anioV | codSeguridad | nombreTarjeta |
      | One Way | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 20  | 7   | 2022 | suite  | 5        | visa | 454545454545 | 03   | 28    | 999          | Pruebas manu  |



  @Peru_rail
  Scenario Outline: Buscar fecha para el caso que no se tiene cabinas disponibles
    Given selecciono el tipo de viaje "<viaje>"
    When selecciono el destino "<destino>"
    And selecciono la ruta "<ruta>"
    And selecciono el tren "<tren>"
    And selecciono la fecha de salida "<Dia>" "<Mes>" "<Anio>"
    And hago click en el botón Find Train Ticket
    Then se muestra del paso_2 Elige tu cabina
    And se muestra que la cabina no esta disponible

    Examples:
      | viaje   | destino | ruta         | tren                             | Dia | Mes | Anio |
      | One Way | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 30  | 3   | 2022 |
      #| One Way | Cusco   | Arequipa > Puno > Cusco | Andean Explorer, A Belmond Train | 20  | 7   | 2022 |


  @Peru_rail
  Scenario Outline: Validar que se considere minimo 1 adulto
    Given selecciono el tipo de viaje "<viaje>"
    When selecciono el destino "<destino>"
    And selecciono la ruta "<ruta>"
    And selecciono el tren "<tren>"
    And selecciono la fecha de salida "<Dia>" "<Mes>" "<Anio>"
    And hago click en el botón Find Train Ticket
    Then se muestra del paso_2 Elige tu cabina
    When selecciono la cabina "<cabina>" y la cantidad de pasajeros "<cantidad>"
    And hago clic en el boton X del popUp
    And selecciono la cantidad de mayores "<cantMayores>" de la cabina
    And selecciona la cantidad de menores "<cantMenores>" de la cabina
    And hago clic en Purchase Summary en la pantalla 2
    And valido que los montos sean iguales en el paso 2
    And hago click en el botón continue en el paso 2
    Then se muestra popUp validando que no se tiene mayores seleccionados
    And hago clic en el boton X del popUp

    Examples:
      | viaje   | destino | ruta         | tren                             | Dia | Mes | Anio | cabina | cantidad | cantMayores | cantMenores |
      | One Way | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 20  | 7   | 2022 | suite  | 1        | 0           | 1           |




  @Peru_rail_1
  Scenario Outline: Registro de ticket solo ida Arequipa a Puno a Cusco purchase summary
    Given selecciono el tipo de viaje "<viaje>"
    When selecciono el destino "<destino>"
    And selecciono la ruta "<ruta>"
    And selecciono la fecha de salida "<Dia>" "<Mes>" "<Anio>"
    And hago click en el botón Find Train Ticket
    Then se muestra del paso_2 Elige tu cabina
    When selecciono la cabina "<cabina>" y la cantidad de pasajeros "<cantidad>"
    And hago clic en el boton X del popUp
    And hago clic en Purchase Summary en la pantalla 2
    And valido que los montos sean iguales en el paso 2
    And hago click en el botón continue en el paso 2
    Then se muestra del paso_3 Datos del Pasajero
    And ingreso los datos del pasajero "<cabina>" "<cantidad>"
    And hago click en el botón continue en el paso 3
    Then se muestra del paso_4 Confirmacion y Pago
    When selecciono el metodo de pago "<pago>" en el paso 4
    And hago click en el botón Ingresar Tarjeta del paso 4
    And ingreso los datos de mi tarjeta "<pago>" "<nroTarjeta>" "<mesV>" "<anioV>" "<codSeguridad>" "<nombreTarjeta>"
    #And hago click en el botón continue en el paso 4
    Then cierro la aplicacion
    Examples:
      | viaje   | destino | ruta                    | Dia | Mes | Anio | cabina | cantidad | pago | nroTarjeta   | mesV | anioV | codSeguridad | nombreTarjeta |
      | One Way | Cusco   | Arequipa > Puno > Cusco | 20  | 8   | 2022 | suite  | 2        | visa | 454545454545 | 03   | 28    | 999          | Pruebas manu  |