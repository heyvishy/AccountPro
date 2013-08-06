package accountpro.util;

import java.util.Locale;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

/**
 * MessageLoader class to load the properties of the message resource file.
 * This property file has the list of all the messages that can be displayed on the UI.
 */
public class MessageLoader {
	
	private MessageSource messages;

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public String getMessage(String key) {
		if (StringUtils.isBlank(key)) {
			return "";
		} else {
			return messages.getMessage(key, null, Locale.getDefault());
		}
	}

	public String getMessage(String key, String[] arguments) {
		if (StringUtils.isBlank(key)) {
			return "";
		} else {
			return messages.getMessage(key, arguments, Locale.getDefault());
		}
	}

}
