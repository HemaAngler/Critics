package config;

public class Constants 
{
	public static String getObjectRepoPath = System.getProperty("user.dir")+ "\\src\\objectRepository\\object.properties";
	public static final String PATH_OBJECTREPO = getObjectRepoPath.replace("\\", "\\\\");
}
