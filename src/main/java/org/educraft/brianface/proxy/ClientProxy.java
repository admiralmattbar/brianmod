/* 
 * This class covers your textures when you are running the client version of Minecraft. Your textures will not render on a server 
 * because they simply do not do that.
 */

package org.educraft.brianface.proxy;

import org.educraft.brianface.init.ModBlocks;
import org.educraft.brianface.init.ModItems;

public class ClientProxy implements CommonProxy {
	
	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
}