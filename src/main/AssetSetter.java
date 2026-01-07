package main;

import entity.NPC1;

public class AssetSetter {
  Gamepanel gp;

  public AssetSetter(Gamepanel gp) {
    this.gp = gp;
  }

  public void setObject() {
    gp.obj[0] = new object.OBJ_hoe();
    gp.obj[0].worldX = gp.tileSize * 14;
    gp.obj[0].worldY = gp.tileSize * 28;

    gp.obj[1] = new object.OBJ_seed();
    gp.obj[1].worldX = gp.tileSize * 15;
    gp.obj[1].worldY = gp.tileSize * 28;
  }

  public void setNPC() {
    gp.npc[0] = new NPC1(gp);
  }
}
 