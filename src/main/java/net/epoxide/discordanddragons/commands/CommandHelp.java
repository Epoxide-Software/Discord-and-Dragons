package net.epoxide.discordanddragons.commands;

import java.util.Map.Entry;

import net.epoxide.discordanddragons.CommandHandler;
import net.epoxide.discordanddragons.DiscordAndDragons;
import net.epoxide.discordanddragons.util.Utilities;
import sx.blah.discord.handle.obj.IMessage;

public class CommandHelp implements Command {
    
    @Override
    public void proccessCommand (IMessage message, String[] args) {
        
        String descriptions = "";
        
        if (args.length > 1) {
            for (int index = 1; index < args.length; index++) {
                
                Command cmd = CommandHandler.getCommand(args[index]);
                
                if (cmd != null && cmd.isValidUsage(message))
                    descriptions += DiscordAndDragons.COMMAND_KEY + args[index] + " - " + cmd.getThoroughDescription() + SEPERATOR + SEPERATOR;
            }
        }
        
        else
            for (Entry<String, Command> command : CommandHandler.getCommands().entrySet())
                if (command.getValue().isValidUsage(message))
                    descriptions += DiscordAndDragons.COMMAND_KEY + command.getKey() + " - " + command.getValue().getDescription() + SEPERATOR + SEPERATOR;
                    
        Utilities.sendPrivateMessage(message.getAuthor(), Utilities.makeMultiCodeBlock(descriptions));
    }
    
    @Override
    public String getDescription () {
        
        return "Lists all commands available to the user, along with a basic description of each command. You can run the command with other command names as additional arguments to get a more thorough description of the command.";
    }
    
    @Override
    public String getThoroughDescription () {
        
        return "Provides a list of all commands that the user can use, and their descriptions. The names of other commands can be added on to the end of the command to get a thorough explanation of those commands. Example: !help barcode";
    }
}