package com.dsl.poc;

import com.dsl.poc.controllers.OnePunchManController;
import com.dsl.poc.controllers.KingKongController;
import com.dsl.poc.controllers.ProWrestlerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class);
        OnePunchManController opmController = applicationContext.getBean(OnePunchManController.class);
        opmController.register("opm_normal_punch", "opm_serious_punch");
        opmController.test("opm_normal_punch", "normal punch", "disaster");
        opmController.test("opm_serious_punch", "serious punch", "disaster");

        KingKongController kingKongController = applicationContext.getBean(KingKongController.class);
        kingKongController.register("king_kong_punch", "king_kong_kick");
        kingKongController.test("king_kong_punch", "punch", "extreme hard");
        kingKongController.test("king_kong_kick", "kick", "extreme hard");

        ProWrestlerController proWrestlerController = applicationContext.getBean(ProWrestlerController.class);
        proWrestlerController.register("wrestler_punch", "wrestler_kick");
        proWrestlerController.test("wrestler_punch", "punch", "hard");
        proWrestlerController.test("wrestler_kick", "kick", "hard");
    }
}
