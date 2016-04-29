package net.epoxide.discordanddragons.commands;

import net.epoxide.discordanddragons.util.Utilities;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.HTTP429Exception;
import sx.blah.discord.util.MissingPermissionsException;

public class CommandClear implements Command {
    
    public static boolean isClearing = false;
    
    @Override
    public boolean isValidUsage (IMessage message) {
        
        final String username = message.getAuthor().getName();
        return (username.equals("Darkhax") || username.equals("lclc98"));
    }
    
    @Override
    public void proccessCommand (IMessage message, String[] params) {
        
        if (isClearing) {
            
            Utilities.sendMessage(message.getChannel(), "Please wait, I can only clear one room at a time.");
            return;
        }
        
        boolean isSilent = false;
        for (String param : params)
            if (param.equalsIgnoreCase("silent") || param.equalsIgnoreCase("silence"))
                isSilent = true;
                
        isClearing = true;
        
        for (IMessage entry : message.getChannel().getMessages())
            
            try {
                
                entry.delete();
            }
            
            catch (MissingPermissionsException | HTTP429Exception | DiscordException e) {
                
                e.printStackTrace();
            }
            
        isClearing = false;
        
        if (!isSilent)
            Utilities.sendMessage(message.getChannel(), "The room has been cleared.");
    }
    
    @Override
    public String getDescription () {
        
        return "Clears all messages in the chat.";
    }
    
    @Override
    public String getThoroughDescription () {
        
        return "Clears all messages in the chat, however only one room can be cleared at a time. When the room is finished being cleared, a message will be sent to the chat saying that the room has been cleared. You can add silent or silence to the end of the command to prevent that. Example: !clear silent";
    }
}
