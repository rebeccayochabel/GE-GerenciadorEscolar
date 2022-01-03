package br.com.gerenciadorescolar.ge.DTO;

import lombok.Data;

@Data
public class TurmaDto {
    
    //declarar
    private String id;
    private String nome;
    private String email;
    private String turno;

    //instanciar
    public TurmaDto(){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.turno = turno;
    }

    //get e set
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }

}
