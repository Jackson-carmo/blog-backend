package br.com.jackson.user.Repository;

import br.com.jackson.user.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepositoy extends JpaRepository<Blog, Long> {
}
