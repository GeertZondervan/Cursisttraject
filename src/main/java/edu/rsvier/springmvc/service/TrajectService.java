/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rsvier.springmvc.service;

import edu.rsvier.springmvc.model.Traject;
import java.util.List;

/**
 *
 * @author Geert
 */
public interface TrajectService {
        void create(Traject traject);

    void update(Traject traject);

    Traject read(int id);

    void delete(Traject traject);

    List<Traject> getAll();
}
