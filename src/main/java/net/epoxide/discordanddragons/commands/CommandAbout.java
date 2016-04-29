package net.epoxide.discordanddragons.commands;

import net.epoxide.discordanddragons.util.Utilities;
import sx.blah.discord.handle.obj.IMessage;

public class CommandAbout implements Command {
    
    @Override
    public void proccessCommand (IMessage message, String[] args) {
        
        Utilities.sendPrivateMessage(message.getAuthor(), "TODO: Add an introduction! " + Utilities.makeMultiCodeBlock("Java Version: " + System.getProperty("java.version") + SEPERATOR + "OS Name: " + System.getProperty("os.name") + SEPERATOR + "Country: " + System.getProperty("user.country") + SEPERATOR + "Author: Darkhax" + SEPERATOR + "Birth Date: 2016-01-26"));
    }
    
    @Override
    public String getDescription () {
        
        return "Shares a list of information about the bot, including system specs and authorship info.";
    }
    
    @Override
    public String getThoroughDescription () {
        
        return "Provides information about the bot, and the hardware it is running on. There are no additional parameters.";
    }
}