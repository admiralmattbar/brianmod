/*
 * THis class registers information about your mod and creates a method that can automatically register the registry of your items and
 * assign them an unlocalized name.
 */

package org.educraft.brianface;

public class Reference {

	public static final String MOD_ID = "brianface";
	public static final String NAME = "Brian Face";
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_VERSIONS = "[1.11],[1.11.1],[1.11.2]";
	
	public static final String CLIENT_PROXY_CLASS = "org.educraft.brianface.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "org.educraft.brianface.proxy.ServerProxy";
}