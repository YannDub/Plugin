/**
 * 
 */
package plugins;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author orieux
 * 
 */
public class PluginFilter implements FilenameFilter {

	/** accept(File dit, String name)
	 * try if this file is a plugin
	 * return boolean : true if this file is a plug-in
	 * @param construct 
	 */
	@Override
	public boolean accept(File dir, String name) {
		boolean test = false;
		boolean construct = false;
		
		try {
			Class<?> plugin = Class.forName("plugins." + name.replace(".class",""));
			test = Plugin.class.isAssignableFrom(plugin);
			construct = plugin.getConstructor().getParameterCount() == 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println(name.endsWith(".class") + " ; " + test + " ; " + construct);
		return name.endsWith(".class") && test && construct;
	}

}
