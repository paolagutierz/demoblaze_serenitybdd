package co.com.devco.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickNavBar implements Interaction {
    private Target tab;

    public ClickNavBar(Target tab) {
        this.tab = tab;
    }

    public static ClickNavBar enTab(Target tab) {
        return new ClickNavBar(tab);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(tab));
    }
}
