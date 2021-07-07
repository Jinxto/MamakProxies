package com.discord;



import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LoginException
    {
    	
       JDA jda = JDABuilder.createDefault("NjM1Mzc2MzIyOTAxOTY2ODQ4.XawKUA.tyy-G04J9Rw73oHhnF7Js6KOSYY").build();
       jda.addEventListener(new bot());
       jda.getPresence().setActivity(Activity.listening("$help in DMs	"));

    }
}
