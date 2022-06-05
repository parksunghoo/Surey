package kr.ac.dgist.surey;

import kr.ac.dgist.surey.controller.MmsekController;

public class test_MmsekXML {

    public static void main(String[] args) {
        System.out.println("[HttpURLConnection 사용해 GET body is XML 방식 데이터 요청 및 응답 값 확인]");

        MmsekController mmsekxml = new MmsekController();

        mmsekxml.setURL("http://210.104.190.225:42502/xmlto/MmsekXmlTo");
        System.out.println("URL : " + mmsekxml.getURL());
        String token = "2f48f241-9d64-4d16-bf56-70b9d4e0e79a";

        /**
         * GET_LIST
         * */
//        mmsekxml.xml_drp_get_list(token, mmsekxml.getURL());

        /**
         * GET_ID
         * */
        String primary_key = "kim36";
        mmsekxml.xml_drp_get(token, mmsekxml.getURL(), primary_key);
    }
}
