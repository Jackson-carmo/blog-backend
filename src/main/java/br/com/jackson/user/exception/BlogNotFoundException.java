package br.com.jackson.user.exception;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException(Long id) {
        super("Não foi possível encontrar a postagem com id " + id);
    }
}
