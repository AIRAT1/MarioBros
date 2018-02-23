package de.android.ayrathairullin.mariobros.sprites.items;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;

import de.android.ayrathairullin.mariobros.MarioBros;
import de.android.ayrathairullin.mariobros.scenes.Hud;
import de.android.ayrathairullin.mariobros.screens.PlayScreen;
import de.android.ayrathairullin.mariobros.sprites.Mario;
import de.android.ayrathairullin.mariobros.sprites.tileObjects.InteractiveTileObject;

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, MapObject object) {
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if (mario.isBig()) {
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }
}
