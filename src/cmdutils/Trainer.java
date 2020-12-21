package cmdutils;

import java.util.Scanner;

public class Trainer {

     private final Scanner sc;

    public Trainer(Scanner sc) {
        this.sc = sc;
    }

    public models.Trainer askData() {
        Command cmd = new Command();
        models.Trainer trainer = new models.Trainer();
        trainer.setFirstName(cmd.getField(sc, "First name of trainer"));
        trainer.setLastName(cmd.getField(sc, "Last name of trainer"));
        trainer.setSubject(cmd.getField(sc, "Select trainer's specialization"));

        return (trainer);
    }
}
