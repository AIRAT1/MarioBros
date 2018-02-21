package de.android.ayrathairullin.mariobros.sprites.items;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;

import de.android.ayrathairullin.mariobros.MarioBros;
import de.android.ayrathairullin.mariobros.scenes.Hud;
import de.android.ayrathairullin.mariobros.screens.PlayScreen;
import de.android.ayrathairullin.mariobros.sprites.tileObjects.InteractiveTileObject;

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Brick", "Collision");
        setCategoryFilter(MarioBros.DESTROYED_BIT);
        getCell().setTile(null);
        Hud.addScore(200);
        MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
    }
}
