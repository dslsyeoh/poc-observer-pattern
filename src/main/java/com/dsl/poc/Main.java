/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.poc;

import com.dsl.poc.controllers.NormalPersonController;
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
        NormalPersonController normalPersonController = applicationContext.getBean(NormalPersonController.class);
        normalPersonController.register("normal_guy_punch", "normal_guy_kick");
        normalPersonController.test("normal_guy_punch", "punch", 1);
        normalPersonController.test("normal_guy_kick", "kick", 1);

        KingKongController kingKongController = applicationContext.getBean(KingKongController.class);
        kingKongController.register("king_kong_punch", "king_kong_kick");
        kingKongController.test("king_kong_punch", "punch", 2);
        kingKongController.test("king_kong_kick", "kick", 2);

        ProWrestlerController proWrestlerController = applicationContext.getBean(ProWrestlerController.class);
        proWrestlerController.register("wrestler_punch", "wrestler_kick");
        proWrestlerController.test("wrestler_punch", "punch", 3);
        proWrestlerController.test("wrestler_kick", "kick", 3);
    }
}
