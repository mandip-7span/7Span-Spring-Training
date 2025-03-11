package com.SpringLearning.Demo.LooseCoupling;

import org.springframework.stereotype.Component;

@Component("mathcheat")
public class MathCheat implements Cheat{

    @Override
    public void cheat() {
        System.out.println("Maths cheating");
    }
}
