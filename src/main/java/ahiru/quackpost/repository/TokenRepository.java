package ahiru.quackpost.repository;

import ahiru.quackpost.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository  extends JpaRepository<Token, Integer> {
}
