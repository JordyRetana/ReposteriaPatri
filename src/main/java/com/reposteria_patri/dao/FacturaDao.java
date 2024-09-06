/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reposteria_patri.dao;
import com.reposteria_patri.domain.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FacturaDao 
        extends JpaRepository<Factura, Long> {


}