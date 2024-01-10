package net.moistymonsoon.monsooncraft.util;

import java.io.FileWriter;
import java.io.IOException;

public class FlowerJsonGenerator {

    public static void main(String[] args) {
        String[] flowers = {
                "acacia_sapling", "allium", "azalea_bush", "azure_bluet", "bamboo",
                "birch_sapling", "blue_orchid", "brown_mushroom", "cactus",
                "cherry_sapling", "crimson_fungus", "crimson_roots",
                "dandelion", "dark_oak_sapling", "dead_bush", "fern",
                "flowering_azalea_bush", "jungle_sapling", "lily_of_the_valley",
                "mangrove_propagule", "oak_sapling", "orange_tulip", "oxeye_daisy",
                "pink_tulip", "poppy", "red_mushroom", "red_tulip", "spruce_sapling",
                "torchflower", "warped_fungus", "warped_roots", "white_tulip", "wither_rose"
        };

        for (String flower : flowers) {
            generateJsonFile(flower);
        }
    }

    private static void generateJsonFile(String flower) {
        String fileName = "tinned_" + flower + ".json";
        String jsonContent = String.format(
                "{\n" +
                        "  \"parent\": \"monsooncraft:block/tin_can_cross\",\n" +
                        "  \"textures\": {\n" +
                        "    \"plant\": \"minecraft:block/%s\"\n" +
                        "  }\n" +
                        "}", flower);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(jsonContent);
            System.out.println("Created: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing file: " + fileName);
        }
    }
}
