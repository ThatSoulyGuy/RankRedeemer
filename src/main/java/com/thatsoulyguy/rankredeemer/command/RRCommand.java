package com.thatsoulyguy.rankredeemer.command;

import org.bukkit.entity.Player;

public abstract class RRCommand
{
    public String name;

    public String description;

    public String syntax;

    public RRCommand()
    {
        RRCommandRegistration registration = Register();

        name = registration.name;
        description = registration.description;
        syntax = registration.syntax;
    }

    public abstract int Execute(Player player, String[] args);

    public abstract RRCommandRegistration Register();
}