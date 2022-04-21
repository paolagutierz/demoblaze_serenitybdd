package co.com.devco.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.LINK_DELETE_PRODUCTO;

public class ClickDeleteCarrito implements Interaction {
    private String elemento;

    private  ClickDeleteCarrito(String elemento) {
        this.elemento = elemento;
    }

    public static ClickDeleteCarrito elemento(String elemento){
        return new ClickDeleteCarrito(elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LINK_DELETE_PRODUCTO.of(elemento)));
    }
}

