package br.com.gerenciadorescolar.ge.DTO;

import lombok.Data;

@Data
public class ServDto {

    //declarar variáveis
	private String id;
    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private String email;
    private String tel;
    private String dtNasc;
    private String funcao;
 
    private String tpSangue;
    private String comorbidade;
    private String qualCom;
 
    private String cep;
    private String rua;
    private String numCs;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;

    //instanciar
    public ServDto(){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.email = email;
        this.tel = tel;
        this.dtNasc = dtNasc;
        this.funcao = funcao;

        this.tpSangue = tpSangue;
        this.comorbidade = comorbidade;
        this.qualCom = qualCom;
 
        this.cep = cep;
        this.rua = rua;
        this.numCs = numCs;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    //get e set
    //dados pessoais
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
 
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
 
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
 
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
     
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
      
    public String getDtNasc() {
        return dtNasc;
    }
    public void setDtNacs(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTpSangue() {
        return tpSangue;
    }
    public void setTpSangue(String tpSangue) {
        this.tpSangue = tpSangue;
    }
 
    public String getComorbidade() {
        return comorbidade;
    }
    public void setComorbidade(String comorbidade) {
        this.comorbidade = comorbidade;
    }
 
    public String getQualCom() {
        return qualCom;
    }
    public void setQualCom(String qualCom) {
        this.qualCom = qualCom;
    }
 
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
 
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
 
    public String getNumCs() {
        return numCs;
    }
    public void setNumCs(String numCs) {
        this.numCs = numCs;
    }
 
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
 
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
 
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
 
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
}
