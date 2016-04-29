package net.epoxide.discordanddragons.commands;

import net.epoxide.discordanddragons.util.Utilities;
import sx.blah.discord.handle.obj.IMessage;

public interface Command {
    
    public static final String SEPERATOR = System.lineSeparator();
    
    /**
     * Checks if a command is valid. If not, it will not be executed.
     * 
     * @param message The message which contains all the command information.
     * @return boolean Whether or not the command should execute.
     */
    default public boolean isValidUsage (IMessage message) {
        
        return true;
    }
    
    /**
     * Processes a command once it has been confirmed to be valid. This is where a command is
     * executed.
     * 
     * @param message The message which contains all of the command information.
     */
    public void proccessCommand (IMessage message, String[] params);
    
    /**
     * Provides a description of what the command does.
     * 
     * @return String A description of the command being registered.
     */
    public String getDescription ();
    
    /**
     * Provides a description of how the command works. This is a in finer detail.
     * 
     * @return String A description of how the command works.
     */
    public String getThoroughDescription ();
    
    /**
     * Can be called whenever the command fails. By default this is used for sending the in
     * depth argument description when a command is not entered properly.
     * 
     * @param message The message which contains all of the command information.
     */
    default public void onFail (IMessage message) {
        
        Utilities.sendPrivateMessage(message.getAuthor(), Utilities.makeMultiCodeBlock("The command failed!" + System.lineSeparator() + getThoroughDescription()));
    }
}
