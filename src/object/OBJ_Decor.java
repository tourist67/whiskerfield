package object;

public class OBJ_Decor extends SuperObject {

    public OBJ_Decor(String decorType) {
        name = decorType;
        pickupable = false; // Decorations cannot be picked up
        drawSize = 32; // Draw decorations smaller (32x32 instead of 48x48)
        
        try {
            switch(decorType) {
                case "pink_plant":
                    image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/tiles/decor/pink_plant.png"));
                    collision = false;
                    break;
                case "rock_1":
                    image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/tiles/decor/rock_1.png"));
                    collision = false;
                    break;
                case "rock_2":
                    image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/tiles/decor/rock_2.png"));
                    collision = false;
                    break;
                case "sunflower":
                    image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/tiles/decor/sunflower_1.png"));
                    collision = false;
                    break;
                case "tall_grass_1":
                    image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/tiles/decor/tall_grass_1.png"));
                    collision = false;
                    drawSize = 24; // Tall grass even smaller
                    break;
                case "tall_grass_2":
                    image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/tiles/decor/tall_grass_2.png"));
                    collision = false;
                    drawSize = 24; // Tall grass even smaller
                    break;
                case "tree":
                    image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/tiles/decor/tree.png"));
                    collision = true; // Trees have collision!
                    drawSize = 48; // Trees stay full size
                    break;
                case "tree_1":
                    image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/res/tiles/decor/tree_1.png"));
                    collision = true; // Trees have collision!
                    drawSize = 48; // Trees stay full size
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
