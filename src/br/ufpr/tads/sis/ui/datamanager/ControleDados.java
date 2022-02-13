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

        EstadoControleDados aux = this.estado;
        if (estado == aux) {
            return;
        }
        switch (aux) {
            case INATIVO: {
                if (estado != EstadoControleDados.INCLUSAO) {
                    throw new Error("Alteração de estado inválida");
                }
                break;
            }

            case CANCELANDO: {
                if (estado == EstadoControleDados.SALVANDO) {
                    throw new Error("Alteração de estado inválida");
                }
                break;

            }

            case CONSULTA: {
                if (estado != EstadoControleDados.INCLUSAO && estado != EstadoControleDados.EDICAO && estado != EstadoControleDados.EXCLUINDO && estado != EstadoControleDados.CARREGANDO) {
                    throw new Error("Alteração de estado inválida");
                }
                break;

            }

            case EXCLUINDO: {
                if (estado == EstadoControleDados.SALVANDO) {
                    throw new Error("Alteração de estado inválida");
                }
                break;
            }

            case CARREGANDO: {
                if (estado == EstadoControleDados.SALVANDO || estado == EstadoControleDados.EDICAO || estado == EstadoControleDados.EXCLUINDO) {
                    throw new Error("Alteração de estado inválida");
                }
                break;
            }

            case EDICAO: {
                if (estado != EstadoControleDados.SALVANDO && estado != EstadoControleDados.CANCELANDO) {
                    throw new Error("Alteração de estado inválida");
                }
                break;
            }

            case INCLUSAO: {
                if (estado != EstadoControleDados.SALVANDO && estado != EstadoControleDados.CANCELANDO) {
                    throw new Error("Alteração de estado inválida");
                }
                break;
            }

            case SALVANDO: {
                if (estado == EstadoControleDados.CANCELANDO) {
                    throw new Error("Alteração de estado inválida");
                }
                break;
            }

        }
        this.estado = estado;
    }

    public void setEmFoco(int index) {
        this.emFoco = colecao.get(index);
    }

    public E getEmFoco() {

        return this.emFoco;

    }

    public void removeElement(int index) {
        this.colecao.remove(index);
    }

}
