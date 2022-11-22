package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.ItemPedidoDTO;
import org.ada.gestorgastronomico.entity.ItemPedido;
import org.ada.gestorgastronomico.entity.MateriaPrima;
import org.ada.gestorgastronomico.entity.PedidoAlProveedor;
import org.ada.gestorgastronomico.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final MateriaPrimaService materiaPrimaService;


    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, MateriaPrimaService materiaPrimaService) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.materiaPrimaService = materiaPrimaService;
    }

    public List<ItemPedido> create(List<ItemPedidoDTO> itemsDTO, PedidoAlProveedor pedidoAlProveedor) throws Exception{

        //Mapeo la lista de ítemsDTO a una lista de ítems entity
        List<ItemPedido> items = new ArrayList<>(); //Creo la lista de entidades
        for (ItemPedidoDTO itemPedidoDTO: itemsDTO) {
            Optional<MateriaPrima> materiaPrima = materiaPrimaService.findById(itemPedidoDTO.getMateriaPrima()); // Obtengo la materia prima
            if (materiaPrima.isEmpty()){ // Verifico si encontró esa materia prima o no
                throw new Exception("Materia prima no encontrada"); //Si no la encontró, lanzo una excepción
            }
            items.add(mapToEntity(itemPedidoDTO, pedidoAlProveedor, materiaPrima.get())); // Mapeo a entidad y si todo está OK, agrego el ítem a la lista de ítems del pedido
            materiaPrimaService.incrementarStock(itemPedidoDTO.getCantidad(), materiaPrima.get()); // Modifico el stock de la materia prima
        }
        itemPedidoRepository.saveAll(items); //Guardo la lista de ítems
        return items;
    }

    private ItemPedido mapToEntity(ItemPedidoDTO itemPedidoDTO, PedidoAlProveedor pedidoAlProveedor, MateriaPrima materiaPrima) {

        ItemPedido itemPedido = new ItemPedido(itemPedidoDTO.getCantidad(), itemPedidoDTO.getPrecioUnitario(), pedidoAlProveedor, materiaPrima);

        return itemPedido;
    }
}
