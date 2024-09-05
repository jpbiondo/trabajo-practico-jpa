package org.example;

import org.example.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Factura factura1 = Factura.builder()
                    .numero(12)
                    .fecha("04/09/2024")
                    .build();

            Domicilio dom = Domicilio.builder()
                    .nombreCalle("San Martin")
                    .numero(1222)
                    .build();

            Cliente cliente = Cliente.builder()
                    .nombre("Pablo")
                    .apellido("Muñoz")
                    .dni(15234353)
                    .domicilio(dom)
                    .build();

            factura1.setCliente(cliente);

            Categoria perecederos = Categoria.builder()
                    .denominacion("Perecederos")
                    .build();

            Categoria lacteos = Categoria.builder()
                    .denominacion("Lacteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacion("Limpieza")
                    .build();

            Articulo art1 = Articulo.builder()
                    .cantidad(200)
                    .denominacion("Yogurt Ser - Sabor frutilla")
                    .precio(20)
                    .build();

            Articulo art2 = Articulo.builder()
                    .cantidad(300)
                    .denominacion("Detergente Magistral")
                    .precio(80)
                    .build();

            //Setting Art1
            art1.getCategorias().add(lacteos);
            art1.getCategorias().add(perecederos);
            lacteos.getArticulos().add(art1);
            perecederos.getArticulos().add(art1);

            //Setting Art2
            art2.getCategorias().add(limpieza);
            limpieza.getArticulos().add(art2);

            DetalleFactura det1 = DetalleFactura.builder()
                    .articulo(art1)
                    .cantidad(2)
                    .subtotal(40)
                    .build();

            art1.getDetalleFacturas().add(det1);
            factura1.getDetalleFacturas().add(det1);
            det1.setFactura(factura1);

            DetalleFactura det2 = DetalleFactura.builder()
                    .articulo(art2)
                    .cantidad(1)
                    .subtotal(80)
                    .build();

            art2.getDetalleFacturas().add(det2);
            factura1.getDetalleFacturas().add(det2);
            det2.setFactura(factura1);

            factura1.setTotal(120);

            entityManager.persist(factura1);

            entityManager.flush();

            entityManager.getTransaction().commit();
        } catch(Exception e) {
            System.out.println("No se pudo realizar transacción: ");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
