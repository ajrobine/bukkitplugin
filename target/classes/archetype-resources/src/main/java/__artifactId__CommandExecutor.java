#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

/*
    This file is part of ${artifactId}

    Foobar is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ${artifactId}CommandExecutor implements CommandExecutor {

    private ${artifactId} plugin;

    public ${artifactId}CommandExecutor(${artifactId} plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.getLogger().info("onCommand Reached in ${artifactId}");

        if (args.length == 0) {
        	return false;
        	} else if (!(sender instanceof Player)) {
        	return false;
        	// the cake will appear on the ground but not
        	// necessarily where the player is looking
        	} else if (args[0].equalsIgnoreCase("cake")) {
        	Player fred = (Player) sender;
        	Location loc = fred.getLocation();
        	World w = loc.getWorld();
        	loc.setX(loc.getX() + 1);
        	Block b = w.getBlockAt(loc);
        	b.setTypeId(92);
        	return true;
        	// the stored message now always begins with
        	// the word "message"--do you know how to easily
        	// fix that problem?
        	} else if (args[0].equalsIgnoreCase("message")
        	&& sender.hasPermission("plugin1.message")) {
        	this.plugin.getConfig().set("sample.message",
        	Joiner.on(' ').join(args));
        	return true;
        	} else {
        	return false;
    }
}
