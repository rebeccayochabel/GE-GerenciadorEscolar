package br.com.gerenciadorescolar.ge.DTO;

import lombok.Data;

@Data
public class AtividadeDto {

    //Decarar variáveis
    private String id;
    private String assunto;
    private String valorAtv;
    private String orientacoes;
    private String dtEntrega;
    private String hrEntrega;
    private String turma;

    //instanciar as variáveis
    public AtividadeDto(){

        this.id = id;
        this.assunto = assunto;
        this.valorAtv = valorAtv;
        this.orientacoes = orientacoes;
        this.dtEntrega = dtEntrega;
        this.hrEntrega = hrEntrega;
        this.turma = turma;

    }

    //get e set das variáveis
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

    public String getValorAtv() {
        return valorAtv;
    }
    public void setValorAtv(String valorAtv) {
        this.valorAtv = valorAtv;
    }

    public String getOrientacoes() {
        return orientacoes;
    }
    public void setOrientaçoes(String orientacoes) {
        this.orientacoes = orientacoes;
    }

    public String getDtEntrega() {
        return dtEntrega;
    }
    public void setDtEntrega(String dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public String getHrEntrega() {
        return hrEntrega;
    }
    public void setHrEntrega(String hrEntrega) {
        this.hrEntrega = hrEntrega;
    }

    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
}
