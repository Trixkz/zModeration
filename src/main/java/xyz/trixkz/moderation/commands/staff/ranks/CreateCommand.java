package xyz.trixkz.moderation.commands.staff.ranks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import xyz.trixkz.moderation.Main;
import xyz.trixkz.moderation.commands.BaseCommand;
import xyz.trixkz.moderation.managers.ranks.Rank;
import xyz.trixkz.moderation.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CreateCommand extends BaseCommand {

    private Main main = Main.getInstance();

    @Override
    public void executeAs(CommandSender sender, Command cmd, String label, String[] args) {
        String rankName = args[1];

        if (rankName == null) {
            return;
        }

        if (this.main.getRankManager().getRankByName(rankName) != null) {
            sender.sendMessage(Utils.translate(this.main.getMessagesConfig().getConfig().getString("rank-already-created")));

            return;
        }

        Rank rank = new Rank(rankName);
        rank.save();

        sender.sendMessage(Utils.translate(this.main.getMessagesConfig().getConfig().getString("rank-created")));
    }

    @Override
    public List<String> getTabCompletions(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> tabCompletions = new ArrayList<String>();

        return tabCompletions;
    }
}
