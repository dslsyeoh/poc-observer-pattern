package com.dsl.poc;

import com.dsl.poc.controllers.GlobalAttackController;
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
        GlobalAttackController globalAttackController = applicationContext.getBean(GlobalAttackController.class);
        globalAttackController.addListeners();
        OneAttackController oneAttackController = applicationContext.getBean(OneAttackController.class);
        oneAttackController.fire("handleOnePunch");
        oneAttackController.fire("handleOneKick");

        globalAttackController.disableListener();
        TwoAttackController twoAttackController = applicationContext.getBean(TwoAttackController.class);
        twoAttackController.fire("handleTwoPunches");
        twoAttackController.fire("handleTwoKicks");

        globalAttackController.enableListener();
        TripleAttackController threePunchController = applicationContext.getBean(TripleAttackController.class);
        threePunchController.fire("handleThreePunches");
        threePunchController.fire("handleThreeKicks");
    }
}
