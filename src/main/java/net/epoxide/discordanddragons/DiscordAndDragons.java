package net.epoxide.discordanddragons;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.EventSubscriber;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;

public class DiscordAndDragons {
    
    public static final String COMMAND_KEY = "!";
    public static IDiscordClient instance;
    
    public static void main (String... args) {
        
        try {
            
            instance = new ClientBuilder().withToken(args[0]).login();
            instance.getDispatcher().registerListener(new DiscordAndDragons());
            
            CommandHandler.initCommands();
            ResourceHandler.initTextures();
        }
        
        catch (final DiscordException e) {
            
            e.printStackTrace();
        }
    }
    
    @EventSubscriber
    public void onMessageRecieved (MessageReceivedEvent event) {
        
        if (event.getMessage().getContent().startsWith(COMMAND_KEY))
            CommandHandler.attemptCommandTriggers(event.getMessage());
    }
}