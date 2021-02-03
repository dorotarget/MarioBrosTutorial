package de.doro.mariobros.Sprites.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

//import java.awt.Rectangle;

import de.doro.mariobros.MarioBros;
import de.doro.mariobros.Screens.PlayScreen;
import de.doro.mariobros.Scenes.Hud;
import de.doro.mariobros.Sprites.InteractiveTileObject;
import de.doro.mariobros.Sprites.Mario;


public class Coin extends InteractiveTileObject {

    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28; //Index bei tileset graphik plus eins

    public Coin(PlayScreen screen, MapObject object){
        super(screen, object);
        fixture.setUserData(this);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        setCategoryFilter(MarioBros.COIN_BIT);
        setCategoryFilter((MarioBros.COIN_BIT));



    }

    @Override
    public void onHeadHit(Mario mario) {
        Gdx.app.log("Coin", "Collision");

        //---------------PROBLEM mit getCell()
      /*  if(getCell().getTile().getId()==BLANK_COIN)
            MarioBros.manager.get("audio/sounds/smb_bump.wav", Sound.class).play();
        else*/
        if(object.getProperties().containsKey("mushroom")){
            MarioBros.manager.get("audio/sounds/smb_powerup_appears.wav", Sound.class).play();
        screen.spawnItem(new ItemDef(new Vector2(body.getPosition().x, body.getPosition().y + 16/MarioBros.PPM),
                Mushroom.class));
        } else {
            MarioBros.manager.get("audio/sounds/smb_coin.wav", Sound.class).play();

        }




        //getCell().setTile(tileSet.getTile(BLANK_COIN));
        setCategoryFilter(MarioBros.DESTROYED_BIT);
        Hud.addScore(100);

    }
}
