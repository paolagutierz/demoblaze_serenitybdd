package co.com.devco.tasks;

import co.com.devco.interactions.ClickDeleteCarrito;
import co.com.devco.interactions.ClickPrimerDeleteCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.*;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_HOME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LimpiarCarrito implements Task {
    private String elemento;
    private boolean esCompleta;

    public static Performable unElemento(String elemento) {
        LimpiarCarrito obj = new LimpiarCarrito();
        obj.setEsCompleta(false);
        obj.setElemento(elemento);
        return obj;
    }

    public static Performable completamente() {
        LimpiarCarrito obj = new LimpiarCarrito();
        obj.setEsCompleta(true);
        return obj;
    }

    private void setEsCompleta(boolean esCompleta) {
        this.esCompleta = esCompleta;
    }

    private void setElemento(String elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (esCompleta) {
            actor.attemptsTo(
                    Click.on(LINK_CARRITO),
                    ClickPrimerDeleteCarrito.elementos(PRODUCTOS_CARRITO),
                    Click.on(LINK_HOME)
            );
        } else {
            actor.attemptsTo(
                    Click.on(LINK_CARRITO),
                    ClickDeleteCarrito.elemento(elemento),
                    Click.on(LINK_HOME)
            );

        }
    }
}
