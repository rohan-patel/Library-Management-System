package com.rohan.lms.jsondeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BookAuthorNameDeserializer extends JsonDeserializer<String> {

	@Override
	public String deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
		
		if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
			List<String> authors = new ArrayList<>();
			jsonParser.nextToken();
			
			while(jsonParser.hasCurrentToken() && jsonParser.currentToken() != JsonToken.END_ARRAY) {
				authors.add(jsonParser.getValueAsString());
				jsonParser.nextToken();
			}
			return String.join("#", authors);
		}
		return null;
	}

}
