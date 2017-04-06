package net.chengqiao.maventest;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class Entry 
{
	private static Logger logger = Logger.getLogger(Entry.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        logger.debug("test");
    }
}
