package br.com.gerenciadorescolar.ge.DTO;

import lombok.Data;

/**
 * Returns an Image object that can then be painted on the screen. 
 * The url argument must specify an absolute {@link URL}. The name
 * argument is a specifier that is relative to the url argument. 
 * <p>
 * This method always returns immediately, whether or not the 
 * image exists. When this applet attempts to draw the image on
 * the screen, the data will be loaded. The graphics primitives 
 * that draw the image will incrementally paint on the screen. 
 *
 * @param  url  an absolute URL giving the base location of the image
 * @param  name the location of the image, relative to the url argument
 * @return      the image at the specified URL
 * @see         Image
 */

@Data
public class JogoDto {
    
    //declarar variáveis
    private String id;
    private String modalidade;
    private String dtJogo;
    private String hrJogo;
    private String informacoes;

    //instanciar as variáveis
    public JogoDto() {

        this.id = id;
        this.modalidade = modalidade;
        this.dtJogo = dtJogo;
        this.hrJogo = hrJogo;
        this.informacoes = informacoes;
        
    }

    //get e set    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getModalidade() {
        return modalidade;
    }
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getDtJogo() {
        return dtJogo;
    }
    public void setDtJogo(String dtJogo) {
        this.dtJogo = dtJogo;
    }

    public String getHrJogo() {
        return hrJogo;
    }
    public void setHrJogo(String hrJogo) {
        this.hrJogo = hrJogo;
    }

    public String getInformacoes() {
        return informacoes;
    }
    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

}
