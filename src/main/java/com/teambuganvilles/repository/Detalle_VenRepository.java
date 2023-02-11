package com.teambuganvilles.repository;

import com.teambuganvilles.model.Detalle_Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_VenRepository extends JpaRepository<Detalle_Venta, Integer> {
}
