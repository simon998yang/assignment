package assignment.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import assignment.model.Organisation;

@Service("webUtil")
public class WebUtil {

	// TODO:assume ABN are correct and not need to verify it's length is 11
	public String formatNameWithABN(Organisation org) {
		if (org != null)
			return org.getName() + " (" + formatABN(org.getAbn()) + ")";
		else
			return "";
	}

	public String formatABN(String abn) {
		if (abn == null || abn.length() < 11)
			return "";
		return abn.substring(0, 2) + " " + abn.substring(2, 5) + " " + abn.substring(5, 8) + " " + abn.substring(8);
	}

	public String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	public String formatDateTime(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dateFormat.format(date);
	}
}
