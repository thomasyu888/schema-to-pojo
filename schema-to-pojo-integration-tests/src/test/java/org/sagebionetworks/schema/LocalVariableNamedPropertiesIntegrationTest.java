package org.sagebionetworks.schema;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sagebionetworks.LocalVariableNamedProperties;
import org.sagebionetworks.schema.adapter.JSONObjectAdapterException;
import org.sagebionetworks.schema.adapter.org.json.EntityFactory;

public class LocalVariableNamedPropertiesIntegrationTest {

	@Test
	public void testRoundTrip() throws JSONObjectAdapterException {
		LocalVariableNamedProperties properties = new LocalVariableNamedProperties();
		properties.setResult(true);
		properties.setPrime(31L);
		properties.setObj("obj");
		properties.setOther("other");

		String jsonString = EntityFactory.createJSONStringForEntity(properties);
		String expectedJson = "{" +
				"\"result\":true," +
				"\"prime\":31," +
				"\"obj\":\"obj\"," +
				"\"other\":\"other\"" +
				"}";
		assertEquals(expectedJson, jsonString);

		LocalVariableNamedProperties clone = EntityFactory.createEntityFromJSONString(jsonString, LocalVariableNamedProperties.class);
		assertEquals(properties, clone);
		assertEquals(properties.hashCode(), clone.hashCode());
	}
}
