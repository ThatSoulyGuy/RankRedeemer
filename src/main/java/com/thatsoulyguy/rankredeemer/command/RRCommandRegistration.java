package com.thatsoulyguy.rankredeemer.command;

public class RRCommandRegistration
{
    public String name;
    public String description;
    public String syntax;

    public static RRCommandRegistration Register(String name, String description, String syntax)
    {
        RRCommandRegistration out = new RRCommandRegistration();

        out.name = name;
        out.description = description;
        out.syntax = syntax;

        return out;
    }
}