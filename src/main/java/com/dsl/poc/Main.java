package com.dsl.poc;

import com.dsl.poc.controllers.OneAttackController;
import com.dsl.poc.controllers.TripleAttackController;
import com.dsl.poc.controllers.TwoAttackController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class);
        OneAttackController oneAttackController = applicationContext.getBean(OneAttackController.class);
        oneAttackController.register();
        oneAttackController.test("OneAttackController_punch", "one punch", "disaster");
        oneAttackController.test("OneAttackController_kick", "one kick", "disaster");

        TwoAttackController twoAttackController = applicationContext.getBean(TwoAttackController.class);
        twoAttackController.register();
        twoAttackController.test("TwoAttackController_punch", "two punches", "weak");
        twoAttackController.test("TwoAttackController_kick", "two kicks", "weak");

        TripleAttackController tripleAttackController = applicationContext.getBean(TripleAttackController.class);
        tripleAttackController.register();
        tripleAttackController.test("TripleAttackController_punch", "three punches", "average");
        tripleAttackController.test("TripleAttackController_kick", "three kicks", "average");
    }
}
