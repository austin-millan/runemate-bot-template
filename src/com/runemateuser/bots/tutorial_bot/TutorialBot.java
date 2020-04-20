package com.runemateuser.bots.tutorial_bot;

import com.runemate.game.api.script.framework.LoopingBot;


public class TutorialBot extends LoopingBot {

    @Override
    public void onLoop() {
        System.out.println("Hello, World");
        setLoopDelay(100);
    }
}
