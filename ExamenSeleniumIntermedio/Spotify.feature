Feature: Spotify Test

  Scenario Outline: Validate the user is able to see <planName> plan
    Given the user is at Spotify HomePage
    When the user clicks on "Premium" section
    Then the user to see the "<planName>" plan displayed

    Examples:
      | planName   |
      | Individual |
      | Premium    |
      | Familiar   |

  Scenario Outline: Validate that when using <emailInput> as email, <errorName> message is displayed
    Given the user is at Spotify HomePage
    When the user clicks on "Registrarse" section
    Then the user gets to Spotify Registration Page
    When the user completes the email field with "<emailInput>"
    And the user clicks on the confirm email field
    Then the user should see the "<errorName>" message displayed

    Examples:
      | emailInput    | errorName                                                                                            |
      |               | Es necesario que introduzcas tu correo electrónico.                                                  |
      | ffff          | Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com |
      | test@test.com | Este correo electrónico ya está conectado a una cuenta.                                              |


  Scenario Outline: Validate <linkName> link is displayed
    Given the user is at Spotify HomePage
    When the user navigates to "https://www.spotify.com/uy/legal/end-user-agreement/"
    Then the user should see the "<linkName>" displayed

    Examples:
      | linkName                                    |
      | Disfrutando Spotify                         |
      | Pagos, cancelaciones y periodo de reflexión |
      | Uso de nuestro servicio                     |








