package com.example.endtermesportsirtay_aldiyar.factory;

import com.example.endtermesportsirtay_aldiyar.model.Fps;
import com.example.endtermesportsirtay_aldiyar.model.Game;
import com.example.endtermesportsirtay_aldiyar.model.Moba;
import com.example.endtermesportsirtay_aldiyar.model.*;

public class GameFactory {

    private GameFactory() {}

    public static Game createGame(int id, String name, String type) {

        return switch (type.toUpperCase()) {
            case "MOBA" -> new Moba(id, name);
            case "FPS" -> new Fps(id, name);
            default -> throw new IllegalArgumentException("Unknown game type");
        };
    }
}
