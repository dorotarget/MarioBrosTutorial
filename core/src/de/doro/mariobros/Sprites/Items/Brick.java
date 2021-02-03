package de.doro.mariobros.Sprites.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import de.doro.mariobros.MarioBros;
import de.doro.mariobros.Scenes.Hud;
import de.doro.mariobros.Screens.PlayScreen;
import de.doro.mariobros.Sprites.InteractiveTileObject;
import de.doro.mariobros.Sprites.Mario;

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, MapObject object){
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if(mario.isBig()){
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            Hud.addScore(200);
            MarioBros.manager.get("audio/sounds/smb_breakblock.wav", Sound.class).play();

        }
        Gdx.app.log("Brick", "Collision");

        //------------PROBLEM:
       // getCell().setTile(null);

        MarioBros.manager.get("audio/sounds/smb_bump.wav", Sound.class).play();
    }

}
