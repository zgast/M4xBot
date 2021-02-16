package at.markus;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {
    private URLChecker urlChecker = new URLChecker();
    private String channelName = "foodporn";
    private static Boolean pause = true;
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equals(".twitch")){
            event.getTextChannel().sendMessage("https://www.twitch.tv/wubbl0rz").queue();
        }else if(event.getMessage().getContentRaw().equals(".youtube")){
            event.getTextChannel().sendMessage("https://www.youtube.com/user/m4xFPS").queue();
        } else if(event.getMessage().getContentRaw().equals(".twitter")){
            event.getTextChannel().sendMessage("https://twitter.com/m4xfps").queue();
        } else if(event.getMessage().getContentRaw().contains(".channel")&&event.getMember().hasPermission(Permission.ADMINISTRATOR)){
            channelName = event.getMessage().getContentRaw().split(" ")[1];
            event.getTextChannel().sendMessage("updated").queue();
        } else if(event.getMessage().getContentRaw().contains(".pause")&&event.getMember().hasPermission(Permission.ADMINISTRATOR)){
            if(pause){
                pause=false;
                event.getTextChannel().sendMessage("pause activated").queue();
            }else{
                pause = true;
                event.getTextChannel().sendMessage("pause stopped").queue();
            }
        }else if(pause&&event.getTextChannel().getName().equals(channelName)&&!event.getAuthor().isBot()){
            if(!(event.getMessage().getAttachments().size() != 0||urlChecker.checkURL(event.getMessage().getContentRaw()))){
                event.getMessage().delete().queue();
            }
        }
    }
}
