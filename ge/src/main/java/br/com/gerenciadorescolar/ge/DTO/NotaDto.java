package br.com.gerenciadorescolar.ge.DTO;

import lombok.Data;

@Data
public class NotaDto {

    //declarar
    private String id;
    private String codAtv;
    private String turma;
    private String aluno;
    private String pontuacao;
    

    //instanciar
    public NotaDto(){
        this.id = id;
        this.codAtv = codAtv;
        this.turma = turma;
        this.aluno = aluno;
        this.pontuacao = pontuacao;
    }

    //get e set
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCodAtv() {
        return codAtv;
    }
    public void setCodAtv(String codAtv) {
        this.codAtv = codAtv;
    }

    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getAluno() {
        return aluno;
    }
    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }

}
