package at.markus;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getAttachments().size() != 0){
            // hat irgendeine datei mithochgeladen
            event.getTextChannel().sendMessage("Yes").queue();
        }else{
            event.getMessage().delete().queue();
        }
    }
}
