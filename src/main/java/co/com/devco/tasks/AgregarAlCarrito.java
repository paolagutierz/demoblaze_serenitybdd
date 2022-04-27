package co.com.devco.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.TITULO_PRODUCTO_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeDetalleProductoPage.BOTON_AGREGAR_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_HOME;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class AgregarAlCarrito implements Task {
    private String producto;
    private boolean sonVarios;
    private int cantidad;

    public static Performable elProducto(String producto) {
        AgregarAlCarrito obj = new AgregarAlCarrito();
        obj.setProducto(producto);
        obj.setSonVarios(false);
        return obj;
    }

    public static Performable losProductos(String producto, int cantidad) {
        AgregarAlCarrito obj = new AgregarAlCarrito();
        obj.setProducto(producto);
        obj.setSonVarios(true);
        obj.setCantidad(cantidad);
        return obj;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setSonVarios(boolean sonVarios) {
        this.sonVarios = sonVarios;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (sonVarios) {
            for (int i = 0; i < cantidad; i++) {
                actor.attemptsTo(
                        Click.on(LINK_PRODUCTO.of(producto)),
                        WaitUntil.the(BOTON_AGREGAR_CARRITO, isEnabled()).forNoMoreThan(Duration.ofSeconds(6)),
                        Click.on(BOTON_AGREGAR_CARRITO),
                        WaitUntil.the(LINK_HOME, isEnabled()).forNoMoreThan(Duration.ofSeconds(10)),
                        Click.on(LINK_HOME),
                        WaitUntil.the(LINK_PRODUCTO.of(producto), isEnabled()).forNoMoreThan(Duration.ofSeconds(6))
                );
            }

            actor.attemptsTo(
                    Click.on(LINK_CARRITO),
                    WaitUntil.the(TITULO_PRODUCTO_CARRITO.of(producto), isEnabled()).forNoMoreThan(Duration.ofSeconds(10))
            );

        } else {
            actor.attemptsTo(
                    Click.on(LINK_PRODUCTO.of(producto)),
                    WaitUntil.the(BOTON_AGREGAR_CARRITO, isEnabled()).forNoMoreThan(Duration.ofSeconds(6)),
                    Click.on(BOTON_AGREGAR_CARRITO),
                    WaitUntil.the(LINK_CARRITO, isEnabled()).forNoMoreThan(Duration.ofSeconds(10)),
                    Click.on(LINK_CARRITO),
                    WaitUntil.the(TITULO_PRODUCTO_CARRITO.of(producto), isEnabled()).forNoMoreThan(Duration.ofSeconds(10))
            );

        }
    }
}
