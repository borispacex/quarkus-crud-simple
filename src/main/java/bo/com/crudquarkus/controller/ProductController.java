package bo.com.crudquarkus.controller;

import bo.com.crudquarkus.dto.ProductDto;
import bo.com.crudquarkus.entity.Product;
import bo.com.crudquarkus.service.ProductService;
// import javax.inject.Inject;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService service;

    @GET
    public Response listProducts() {
        List<Product> products = service.listProduct();
        return Response.ok(products).build();
    }
    @POST
    public Response saveProduct(ProductDto dto) {
        Product product = service.saveProduct(dto);
        return Response.ok(product).status(201).build();
    }
    @PUT
    @Path("{id}")
    public Response updateProduct(@PathParam("id") Long id, ProductDto dto) {
        Product product = service.updateProduct(id, dto);
        return Response.ok(product).status(201).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        service.removeProduct(id);
        return Response.status(204).build();
    }

}
