package com.earth2me.essentials.commands;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import com.earth2me.essentials.User;
import com.earth2me.essentials.Util;


public class Commandhelpop extends EssentialsCommand
{
	public Commandhelpop()
	{
		super("helpop");
	}

	@Override
	public void run(Server server, User user, String commandLabel, String[] args) throws Exception
	{
		if (args.length < 1)
		{
			throw new NotEnoughArgumentsException();
		}

		charge(user);
		for (Player p : server.getOnlinePlayers())
		{
			User u = ess.getUser(p);
			if (!u.isAuthorized("essentials.helpop.receive"))
			{
				continue;
			}
			u.sendMessage(Util.format("helpOp", user.getDisplayName(), getFinalArg(args, 0)));
		}
	}
}
