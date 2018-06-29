package zk.gradle.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModel {
	public static final String SUBMIT_COMMAND = "submit";
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponse() {
		return String.format("Hello %s!", name);
	}

	@Command(SUBMIT_COMMAND)
	@NotifyChange("response")
	public void submit() {
	}
}
