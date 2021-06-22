package builders.backendbuilders.persitance.mongo.dao;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.repository.UserRepository;
import builders.backendbuilders.persitance.mongo.document.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserMongoDao implements UserRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserMongoDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public User save(User user) {
        UserDocument userDocument = UserDocument.builder()
                .cpf(user.getCpf())
                .dataDeNascimento(user.getDataDeNascimento())
                .email(user.getEmail())
                .telefone(user.getTelefone())
                .name(user.getName())
                .build();

        UserDocument salvedUser = mongoTemplate.save(userDocument);

        user.setId(salvedUser.getId());

        return user;
    }

    @Override
    public List<User> findAll() {
        List<UserDocument> usersDocument = mongoTemplate.findAll(UserDocument.class);
        List<User> users = new ArrayList<>();

        usersDocument.forEach(userDocument -> {
            users.add(User.builder()
                    .cpf(userDocument.getCpf())
                    .dataDeNascimento(userDocument.getDataDeNascimento())
                    .email(userDocument.getEmail())
                    .id(userDocument.getId())
                    .name(userDocument.getName())
                    .telefone(userDocument.getTelefone())
                    .build());
        });

        return users;
    }

    @Override
    public User getById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        UserDocument userDocument = mongoTemplate.findOne(query, UserDocument.class);

        assert userDocument != null;
        return User.builder()
                .cpf(userDocument.getCpf())
                .dataDeNascimento(userDocument.getDataDeNascimento())
                .email(userDocument.getEmail())
                .id(userDocument.getId())
                .name(userDocument.getName())
                .telefone(userDocument.getTelefone())
                .build();

    }

    @Override
    public void delete(User user) {

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(user.getId()));
        mongoTemplate.findAndRemove(query, UserDocument.class);

    }
}
