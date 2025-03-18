package com.SpringLearning.Demo.LooseCoupling;

import org.springframework.stereotype.Component;


@Component("sciencecheat")
public class ScienceCheat implements Cheat{

    @Override
    public void cheat() {
        System.out.println("Science cheating");
    }
}
