/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufpr.tads.sis.ui.datamanager;

import br.ufpr.tads.sis.model.Curso;

/**
 *
 * @author User
 */
public interface ControleDadosObserver<E> {

    void remove(ControleDados control);

    void adiciona(Curso curso, ControleDados control);

    void editaHelper();

    void moveProximo(ControleDados control);

    void moveAnterior(ControleDados control);

    void moveUltimo(ControleDados control);

    void movePrimeiro(ControleDados control);

    void cancela();

    void antesDeAdicionar();

    void consultaHelper();

    void defineBotoesDeConsulta();
}
