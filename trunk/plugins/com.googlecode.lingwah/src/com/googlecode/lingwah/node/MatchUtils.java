package com.googlecode.lingwah.node;

import java.util.List;

public class MatchUtils {
	
	public static String toXML(Match element) {
		String xml= "<match start='"+element.getStart()+"' end='"+element.getEnd()+"' matcher="+element.getMatcher().getLabel()+">\n";
			xml+= "\t<text><![CDATA["+element.getText()+"]]></text>\n";
		List<Match> children= element.getChildren();
		if (!children.isEmpty()) {
			xml+= "\t<children>\n";
			for (Match childElement:children) {
				String childXML= toXML(childElement);
				String[] lines= childXML.split("\n");
				for (String line:lines) {
					xml+="\t\t"+line+"\n";
				}
			}
			xml+= "\t</children>\n";
		}
		xml+="</match>\n";

		return xml;
	}

}