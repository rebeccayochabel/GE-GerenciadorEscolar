package br.com.gerenciadorescolar.ge.DTO;

public class NoticiaDto {
    
    //declarar
    private String id;
    private String assunto;
    private String area;
    private String orientacoes;
    private String dtPost;
    private String hrPost;

    //instanciar
    public NoticiaDto(){
        this.id = id;
        this.assunto = assunto;
        this.area = area;
        this.orientacoes = orientacoes;
        this.dtPost = dtPost;
        this.hrPost = hrPost;
    }

    //get e set
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getOrientacoes() {
        return orientacoes;
    }
    public void setOrientacoes(String orientacoes) {
        this.orientacoes = orientacoes;
    }

    public String getDtPost() {
        return dtPost;
    }
    public void setDtPost(String dtPost) {
        this.dtPost = dtPost;
    }

    public String getHrPost() {
        return hrPost;
    }
    public void setHrPost(String hrPost) {
        this.hrPost = hrPost;
    }

}
