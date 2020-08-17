package pers.byxiaobai.diedays.api.managers.config;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

/** 
* @author byxiaobai
* 数据结构
*/
public class Config {
	private File configFile;
	private YamlConfiguration configYaml;
	
	public Config(File configFile,YamlConfiguration configYaml) {
		this.setConfigFile(configFile);
		this.setConfigYaml(configYaml);
		
	}

	public YamlConfiguration getConfigYaml() {
		return configYaml;
	}

	public void setConfigYaml(YamlConfiguration configYaml) {
		this.configYaml = configYaml;
	}

	public File getConfigFile() {
		return configFile;
	}

	public void setConfigFile(File configFile) {
		this.configFile = configFile;
	}
	
	
}
