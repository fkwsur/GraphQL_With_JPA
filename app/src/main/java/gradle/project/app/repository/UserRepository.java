package gradle.project.app.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;
import gradle.project.app.model.User;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;

@GraphQlRepository
public interface UserRepository  extends JpaRepository<User, String>{
    
}
