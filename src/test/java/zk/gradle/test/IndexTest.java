package zk.gradle.test;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.zkoss.zats.junit.AutoClient;
import org.zkoss.zats.junit.AutoEnvironment;
import org.zkoss.zats.mimic.ComponentAgent;
import org.zkoss.zats.mimic.DesktopAgent;
import org.zkoss.zats.mimic.operation.InputAgent;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

/**
 * example Zats Test case for index.zul see https://www.zkoss.org/wiki/ZATS_Essentials/Getting_Started
 */
public class IndexTest {
	//init/destroy a DefaultZatsEnvironment once for the whole test class
	@ClassRule
	public static AutoEnvironment env = new AutoEnvironment("./src/main/webapp/WEB-INF", "./src/main/webapp");

	//automatically creates/destroys a Zats Client around each @Test method
	@Rule
	public AutoClient client = env.autoClient();

	@Test
	public void testIndex() {
		DesktopAgent desktopAgent = client.connect("/index.zul");

		ComponentAgent nameInput = desktopAgent.query("#name");
		ComponentAgent submitButton = desktopAgent.query("#submit");
		ComponentAgent responseLabel = desktopAgent.query("#response");

		Assert.assertEquals("", nameInput.as(Textbox.class).getValue());
		nameInput.input("Tester");
		submitButton.click();

		Assert.assertEquals("Hello Tester!", responseLabel.as(Label.class).getValue());
	}

	@Test
	public void testIndexSomeMore() {
		//will use a fresh Zats Client instance but share the same ZatsEnvironment
		//DesktopAgent desktopAgent = client.connect("/index.zul");
		//more tests here
	}
}
