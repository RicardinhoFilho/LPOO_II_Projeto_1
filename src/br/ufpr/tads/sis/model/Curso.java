package br.ufpr.tads.sis.model;

import java.io.Serializable;
import java.util.Random;

public class Curso implements Serializable,Comparable<Curso> {
    private Integer id = null;
    private String nome;
    private String sigla;
    private String codigo;
    
    public Curso() {
    }
    
    public Curso( String nome, String sigla,String codigo) {
        this.id =  new Random(50).nextInt();
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public int compareTo(Curso o) {
        if( o != null ) {
            if( o.id != null && this.id != null ) {
                return this.id.compareTo(o.id);
            }
            if( o.codigo != null && this.codigo != null ) {
                return this.codigo.compareTo(o.codigo);
            }
            if( o.nome != null && this.nome != null ) {
                return this.nome.compareTo(o.nome);
            }
        }
        return -1;
    }

    @Override
    public int hashCode() {
        int hash = this.id.hashCode();
        hash = 97 * hash + this.codigo != null ? this.codigo.hashCode() : 0;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso)obj;
        if( !this.id.equals(other.id) ) {
            return false;
        }
        if( !this.codigo.equals(other.codigo) ) {
            return false;
        }
        return true;
    }

}
