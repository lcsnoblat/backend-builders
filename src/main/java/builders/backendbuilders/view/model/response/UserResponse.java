package builders.backendbuilders.view.model.response;

import lombok.*;

import java.net.URI;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class UserResponse {
    private String cpf;
    private String name;
    private String telefone;
    private String email;
    private int age;
    private Date dataDeNascimento;
    private URI uri;
}
