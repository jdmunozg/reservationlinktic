package reservationlinktic.reservationlinktic.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Email(message = "El email debe ser válido")
    @NotNull(message = "El email es obligatorio")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "El número de teléfono debe tener 10 dígitos")
    @NotNull(message = "El teléfono es obligatorio")
    private String phone;
}
