package gr.mimedu.papyros.protocol.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

	public static Gson build(){
		//.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
		return  new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
	}
}
