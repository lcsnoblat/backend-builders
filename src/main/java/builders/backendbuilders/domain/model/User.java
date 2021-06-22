package builders.backendbuilders.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    private String id;
    private String cpf;
    private String name;
    private String telefone;
    private String email;
    private int age;
    private Date dataDeNascimento;
}
