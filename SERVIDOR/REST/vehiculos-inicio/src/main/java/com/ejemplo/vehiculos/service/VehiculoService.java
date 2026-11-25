package com.ejemplo.vehiculos.service;

import com.ejemplo.vehiculos.entity.Vehiculo;
import java.util.List;

public interface VehiculoService {
    List<Vehiculo> listaVehiculos();
    Vehiculo buscaPorId(Long id);
    Vehiculo guarda(Vehiculo vehiculo);
    void borra(Long id);
}
