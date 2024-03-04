package ahiru.quackpost.repository;

import ahiru.quackpost.model.QuackPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuackPostRepository extends JpaRepository<QuackPost, Integer> {
}
