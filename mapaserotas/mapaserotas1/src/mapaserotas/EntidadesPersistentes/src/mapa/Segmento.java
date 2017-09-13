package mapa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import grafo.Arco;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.hibernate.annotations.IndexColumn;
import java.util.List;

@Entity
public class Segmento {

    private java.lang.Integer Id;
    private java.lang.Integer IndicePontoInicial;
    private java.lang.Integer IndicePontoFinal;
    private java.lang.Double Custo;
    private java.lang.Integer Sentido;
    private java.lang.Double Largura;
    private Arco ArcoSentidoDireto;
    private Arco ArcoSentidoInverso;
    private List Localidades;
    

    public Segmento() {
    }
    
    public void setId(Integer id) {
        this.Id = id;
    }

    @Id
    @GeneratedValue 
    public Integer getId() {
        return Id;
    }

    public void setIndicePontoInicial(Integer indicePontoInicial) {
        this.IndicePontoInicial = indicePontoInicial;
    }

    public Integer getIndicePontoInicial() {
        return IndicePontoInicial;
    }

    public void setIndicePontoFinal(Integer indicePontoFinal) {
        this.IndicePontoFinal = indicePontoFinal;
    }

    public Integer getIndicePontoFinal() {
        return IndicePontoFinal;
    }

    public void setCusto(Double custo) {
        this.Custo = custo;
    }

    public Double getCusto() {
        return Custo;
    }

    public void setLargura(Double largura) {
        this.Largura = largura;
    }

    public Double getLargura() {
        return Largura;
    }

    public void setArcoSentidoDireto(Arco arcoSentidoDireto) {
        this.ArcoSentidoDireto = arcoSentidoDireto;
    }

    @OneToOne(cascade = {CascadeType.PERSIST})
    public Arco getArcoSentidoDireto() {
        return ArcoSentidoDireto;
    }

    public void setArcoSentidoInverso(Arco arcoSentidoInverso) {
        this.ArcoSentidoInverso = arcoSentidoInverso;
    }

    @OneToOne(cascade = {CascadeType.PERSIST})
    public Arco getArcoSentidoInverso() {
        return ArcoSentidoInverso;
    }

    public void setSentido(Integer sentido) {
        this.Sentido = sentido;
    }

    public Integer getSentido() {
        return Sentido;
    }

    public void setLocalidades(List localidades) {
        this.Localidades = localidades;
    }

    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity=Localidade.class)
    @IndexColumn(base=0, name="indice")
    public List getLocalidades() {
        return Localidades;
    }
}
