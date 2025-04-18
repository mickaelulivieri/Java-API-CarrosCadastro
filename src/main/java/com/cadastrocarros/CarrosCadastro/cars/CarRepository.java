package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {

    List<CarModel> findByClienteId(Long id);


}
