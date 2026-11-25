package com.ejemplo.vehiculos.service;

import com.ejemplo.vehiculos.exception.VehiculoNoEncontradoException;
import com.ejemplo.vehiculos.entity.Vehiculo;
import com.ejemplo.vehiculos.repository.VehiculoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

// La capa de servicio no cambia por tener encima una API REST además de las vistas
// MVC: es la misma capa, con la misma interfaz, reutilizada por los dos controladores.
@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> listaVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo buscaPorId(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new VehiculoNoEncontradoException(id));
    }

    @Override
    public Vehiculo guarda(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public void borra(Long id) {
        vehiculoRepository.deleteById(id);
    }
}
