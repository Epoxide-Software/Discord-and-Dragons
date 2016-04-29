package net.epoxide.discordanddragons;

import net.epoxide.discordanddragons.util.NamedRegistry;

public class ResourceHandler {
    
    public static NamedRegistry<String> RESOURCES = new NamedRegistry<String>();
    
    public static void initTextures () {
        
        RESOURCES.registerValue("Command_Syntax", "http://i.imgur.com/lqocx7O.png");
    }
}
