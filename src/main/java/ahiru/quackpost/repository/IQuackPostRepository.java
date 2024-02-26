package ahiru.quackpost.repository;

import ahiru.quackpost.model.QuackPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IQuackPostRepository extends JpaRepository<QuackPost, UUID> {
}
