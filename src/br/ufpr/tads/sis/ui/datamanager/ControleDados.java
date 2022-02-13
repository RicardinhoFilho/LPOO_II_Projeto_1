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
public class ControleDados<E> {

    private ArrayList<E> colecao;
    private E emFoco = null;
    private int index = -1;
    //
    private EstadoControleDados estado = EstadoControleDados.INATIVO;

    public ControleDados() {
        this.colecao = new ArrayList<E>();
    }

    public ArrayList<E> getList() {
        return colecao;
    }

    public void setCurso(int index, E element) {
        this.colecao.set(index, element);
    }

    public void addElement(E element) {
          this.colecao.add(element);
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

    public E getEmFoco() {

        return   this.emFoco;

    }

    public void removeElement(int index) {
        this.colecao.remove(index);
    }

}
