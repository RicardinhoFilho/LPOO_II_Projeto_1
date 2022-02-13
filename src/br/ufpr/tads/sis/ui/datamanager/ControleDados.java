/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.tads.sis.ui.datamanager;

import br.ufpr.tads.sis.model.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ControleDados {

    private ArrayList<Curso> colecao;
    private Curso emFoco = null;
    private int index = -1;
    //
    private EstadoControleDados estado = EstadoControleDados.INATIVO;

    public ControleDados() {
        this.colecao = new ArrayList<Curso>();
    }

    public ArrayList<Curso> getList() {
        return colecao;
    }

    public void setCurso(int index, Curso curso) {
        this.colecao.get(index).setCodigo(curso.getCodigo());
        this.colecao.get(index).setNome(curso.getNome());
        this.colecao.get(index).setSigla(curso.getSigla());
    }

    public void addElement(Curso curso) {
        this.colecao.add(curso);
    }

    public EstadoControleDados getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoControleDados estado) {

        this.estado = estado;
    }

    public void setEmFoco(int index) {
        this.emFoco = colecao.get(index);
    }

    public Curso getEmFoco() {

        return this.emFoco;

    }

    public void removeElement(int index) {
        this.colecao.remove(index);
    }

}
