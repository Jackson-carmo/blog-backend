package br.com.jackson.user.service;

import br.com.jackson.user.Repository.BlogRepositoy;
import br.com.jackson.user.exception.BlogNotFoundException;
import br.com.jackson.user.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    final
    private BlogRepositoy blogRepositoy;

    public BlogService(BlogRepositoy blogRepositoy) {
        this.blogRepositoy = blogRepositoy;
    }

    public List<Blog> buscarTodos() {
        return blogRepositoy.findAll();
    }

    public Blog buscarPorId(Long id) {
        return blogRepositoy.findById(id).orElseThrow(
                () -> new BlogNotFoundException(id)
        );
    }

    public Blog inserir(Blog blog) {
        return blogRepositoy.saveAndFlush(blog);
    }

    public Blog atualizar(Blog newBlog, Long id) {
        return blogRepositoy.findById(id).map(
                blog -> {
                    blog.setNome(newBlog.getNome());
                    blog.setTitulo(newBlog.getTitulo());
                    blog.setConteudo(newBlog.getConteudo());
                    return blogRepositoy.saveAndFlush(blog);
                }
        ).orElseThrow(() -> new BlogNotFoundException(id));
    }

    public String excluir(Long id) {
        if (!blogRepositoy.existsById(id)) {
            throw new BlogNotFoundException(id);
        }

        blogRepositoy.deleteById(id);
        return "Post apagado comm sucesso!";
    }
}
