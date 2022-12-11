package br.com.jackson.user.Controller;

import br.com.jackson.user.model.Blog;
import br.com.jackson.user.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    final private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/buscar")
    public List<Blog> buscarTodos() {
        return blogService.buscarTodos();
    }

    @PostMapping("/inserir")
    public Blog inserir(@RequestBody Blog blog) {
        return blogService.inserir(blog);
    }

    @PutMapping("/alterar/{id}")
    public Blog atualizar(@RequestBody Blog blog, @PathVariable Long id) {
        return blogService.atualizar(blog, id);
    }

    @DeleteMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        return blogService.excluir(id);
    }
    @GetMapping("/buscar-id/{id}")
    public Blog buscarPorId(@PathVariable Long id) {
        return blogService.buscarPorId(id);
    }
}
