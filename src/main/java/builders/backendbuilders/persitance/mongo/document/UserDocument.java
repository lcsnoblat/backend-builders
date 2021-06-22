package builders.backendbuilders.persitance.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class UserDocument {
    @Id
    private String id;

    private String cpf;

    private String name;
    private String telefone;

    private String email;

    private int age;
    private Date dataDeNascimento;
}
