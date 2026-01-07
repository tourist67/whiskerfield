package main;

import entity.NPC1;
import object.OBJ_Decor;
import java.util.Random;

public class AssetSetter {
  Gamepanel gp;
  Random random = new Random();

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
    
    // Place decorations
    setDecorations();
  }
  
  public void setDecorations() {
    int objIndex = 2; // Start after hoe and seed
    
    // Place trees around the edges of the grassy area (inside fence)
    // Top edge trees - avoid house area (cols 16-26)
    int[] treePositionsTop = {14, 28, 32};
    for (int col : treePositionsTop) {
      if (objIndex < gp.obj.length) {
        gp.obj[objIndex] = new OBJ_Decor(random.nextBoolean() ? "tree" : "tree_1");
        gp.obj[objIndex].worldX = gp.tileSize * col;
        gp.obj[objIndex].worldY = gp.tileSize * 9;
        objIndex++;
      }
    }
    
    // Bottom edge trees
    int[] treePositionsBottom = {14, 18, 22, 26, 30, 34};
    for (int col : treePositionsBottom) {
      if (objIndex < gp.obj.length) {
        gp.obj[objIndex] = new OBJ_Decor(random.nextBoolean() ? "tree" : "tree_1");
        gp.obj[objIndex].worldX = gp.tileSize * col;
        gp.obj[objIndex].worldY = gp.tileSize * 37;
        objIndex++;
      }
    }
    
    // Left edge trees
    int[] treePositionsLeft = {11, 19, 23, 27, 31, 35};
    for (int row : treePositionsLeft) {
      if (objIndex < gp.obj.length) {
        gp.obj[objIndex] = new OBJ_Decor(random.nextBoolean() ? "tree" : "tree_1");
        gp.obj[objIndex].worldX = gp.tileSize * 13;
        gp.obj[objIndex].worldY = gp.tileSize * row;
        objIndex++;
      }
    }
    
    // Right edge trees
    int[] treePositionsRight = {11, 15, 19, 23, 27, 31, 35};
    for (int row : treePositionsRight) {
      if (objIndex < gp.obj.length) {
        gp.obj[objIndex] = new OBJ_Decor(random.nextBoolean() ? "tree" : "tree_1");
        gp.obj[objIndex].worldX = gp.tileSize * 35;
        gp.obj[objIndex].worldY = gp.tileSize * row;
        objIndex++;
      }
    }
    
    // Scatter sunflowers in clusters (avoid house: cols 16-26, rows 10-15)
    int[][] sunflowerPositions = {
      {27, 16}, {28, 17}, {29, 16},
      {32, 18}, {33, 19}, {31, 20},
      {27, 35}, {28, 36}, {29, 35}
    };
    for (int[] pos : sunflowerPositions) {
      if (objIndex < gp.obj.length) {
        gp.obj[objIndex] = new OBJ_Decor("sunflower");
        gp.obj[objIndex].worldX = gp.tileSize * pos[0];
        gp.obj[objIndex].worldY = gp.tileSize * pos[1];
        objIndex++;
      }
    }
    
    // Scatter pink plants in small groups (avoid house area)
    int[][] pinkPlantPositions = {
      {14, 17}, {15, 18},
      {32, 25}, {33, 26}, {31, 26},
      {25, 35}, {26, 36}
    };
    for (int[] pos : pinkPlantPositions) {
      if (objIndex < gp.obj.length) {
        gp.obj[objIndex] = new OBJ_Decor("pink_plant");
        gp.obj[objIndex].worldX = gp.tileSize * pos[0];
        gp.obj[objIndex].worldY = gp.tileSize * pos[1];
        objIndex++;
      }
    }
    
    // Scatter rocks naturally around the area (avoid house)
    int[][] rockPositions = {
      {15, 20}, {31, 22}, {17, 35},
      {33, 30}, {27, 18}
    };
    for (int[] pos : rockPositions) {
      if (objIndex < gp.obj.length) {
        gp.obj[objIndex] = new OBJ_Decor(random.nextBoolean() ? "rock_1" : "rock_2");
        gp.obj[objIndex].worldX = gp.tileSize * pos[0];
        gp.obj[objIndex].worldY = gp.tileSize * pos[1];
        objIndex++;
      }
    }
    
    // Scatter tall grass throughout to fill in spaces (avoid house)
    int[][] tallGrassPositions = {
      {14, 16}, {15, 17},
      {28, 17}, {29, 18}, {30, 17},
      {30, 20}, {31, 21}, {32, 20},
      {15, 35}, {16, 36}, {20, 35}, {21, 36},
      {28, 25}, {29, 26}, {30, 25},
      {14, 22}, {15, 23}
    };
    for (int[] pos : tallGrassPositions) {
      if (objIndex < gp.obj.length) {
        gp.obj[objIndex] = new OBJ_Decor(random.nextBoolean() ? "tall_grass_1" : "tall_grass_2");
        gp.obj[objIndex].worldX = gp.tileSize * pos[0];
        gp.obj[objIndex].worldY = gp.tileSize * pos[1];
        objIndex++;
      }
    }
  }

  public void setNPC() {
    gp.npc[0] = new NPC1(gp);
  }
}
 