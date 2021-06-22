package builders.backendbuilders.view.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {
    private String cpf;
    private String name;
    private String telefone;
    private String email;
    private Date dataDeNascimento;
    private int age;
}
