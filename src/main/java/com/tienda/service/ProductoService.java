package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
//SE OBTIENE UN LISTADO DE PRODUCTOS EN UN LIST
       public List<Producto> getProductos(boolean activos);

   //SE OBTIENE UN PRODUCTO, A PARTIR DEL ID DE UN PRODUCTO
    public List<Producto> getProducto(Producto producto);
    
    //SE INSERTA UN NUEVO PRODUCTO SI EL ID DEL PRODUCTO ESTA VACIO
    //SE ACTUALIZA UN PRODUCTO SI EL ID DEL PRODUCTO NO ESTA VACIO
    public void save(Producto producto);
    
    //SE ELIMINA EL PRODUCTO QUE TIENE EL ID PASADO POR PARAMETRO
    public void delete(Producto producto);
    
// Lista de productos con precio entre pedidos por descripción ConsultaAmpliada
public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);


    //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
}
