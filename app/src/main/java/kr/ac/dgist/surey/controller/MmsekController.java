package kr.ac.dgist.surey.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MmsekController {

    private String values; //서버로 전달할 변수  (XML, JSON)
    private String result; //서버에서 받아온 값을 저장할 변수
    private String token; //서버랑 통신하기 위한 인증키
    private String URL; //전송대상 URL
    private String API; //전송대상 API주소

    public String drp_get_list(String token, String URL) {
        //get 부분 구현
        //http 요청시 test_XmlApiPost 객체에서 셋팅된 URL 주소와 파라미터 데이터를 결합하기 위한 변수
        String totalUrl = "";
        totalUrl = URL.trim().toString();

        //http 통신을 하기위한 객체
        java.net.URL url = null;
        HttpURLConnection con = null;

        //http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
        String responseData = "";
        BufferedReader br = null;
        StringBuffer sb = null;

        String returnData = ""; //메소드 호출 결과값을 반환하기 위한 변수

        try {
            //파라미터로 들어온 url을 사용해 connection 실시
            url = new URL(totalUrl);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET"); //POST 요청방식 설정(POST, GET 설정가능)
            con.setDoOutput(true); //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션
            con.setDoInput(true); //InputStream으로 서버로 부터 응답을 받겠다는 옵션.

            //Request 헤더를 만들어주는 부분
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            con.connect(); //http 요청 실시

            System.out.println("http 요청 방식 : " + "GET BODY XML");
            System.out.println("http 요청 타입 : " + "application/json");
            System.out.println("http 요청 주소 : " + URL);
//                System.out.println("http 요청 데이터 : " + xml);
            System.out.println("");

            String responseCode = String.valueOf(con.getResponseCode());
            System.out.println("http 응답 코드 : " + responseCode); //요청응답 코드 확인

            //http 요청 후 서버로 부터 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(con.getInputStream())); //리턴 파람미터 출력
            sb = new StringBuffer();

            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer 에 응답받은 데이터 순차적으로 저장
            }
            returnData = sb.toString(); //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입

            //TODO
            System.out.println("http 응답 데이터 : " + returnData); //요청 응답데이터 확인


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //http 요청 및 응답 완료 후 BufferedReader 를 닫음
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 사전에 발급받은 token 값, 전송대상서버의 URL, get 대상 필드를 선택하기 위한 key값(예: token,
     * URL, primary_key)을 매개변수로 전달 반환값은 성공시 key값에
     * 해당하는 DB 테이블내의 필드값을 저장하고 있는 JSON 이 포함된 String 실패시 실패원인 반환(서버에서
     * Exception 을 통해 에러메시지 반환)
     * insert 와 update 처럼 파라미터를 만들어 주는 부분은 필요 없기때문에 파라미터 생성 구문은 생략
     * 단순 get을 하경우 Affiliation 등록된 모든 값이 출력되기 때문에 delete 함수와 동일한게 primary_key 매개변수를 만들어 URL뒤에 AID 값을 붙혀 특정 아이디 목록만 값을 나타낼 수 있도록 함.
     * @auther 박성훈
     */
    public String drp_get(String token, String URL, String primary_key) {
        //get 부분 구현
        //http 요청시 test_XmlApiPost 객체에서 셋팅된 URL 주소와 파라미터 데이터를 결합하기 위한 변수
        String totalUrl = "";
        URL = URL + "/" + primary_key;
        totalUrl = URL.trim().toString();

        //http 통신을 하기위한 객체
        java.net.URL url = null;
        HttpURLConnection con = null;

        //http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
        String responseData = "";
        BufferedReader br = null;
        StringBuffer sb = null;

        String returnData = ""; //메소드 호출 결과값을 반환하기 위한 변수

        try {
            //파라미터로 들어온 url을 사용해 connection 실시
            url = new URL(totalUrl);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET"); //POST 요청방식 설정(POST, GET 설정가능)
            con.setDoOutput(true); //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션
            con.setDoInput(true); //InputStream으로 서버로 부터 응답을 받겠다는 옵션.

            //Request 헤더를 만들어주는 부분
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            con.connect(); //http 요청 실시

            System.out.println("http 요청 방식 : " + "GET BODY XML");
            System.out.println("http 요청 타입 : " + "application/json");
            System.out.println("http 요청 주소 : " + URL);
            System.out.println("http 요청 데이터 : " + primary_key);
            System.out.println("");

            String responseCode = String.valueOf(con.getResponseCode());
            System.out.println("http 응답 코드 : " + responseCode); //요청응답 코드 확인

            //http 요청 후 서버로 부터 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(con.getInputStream())); //리턴 파람미터 출력
            sb = new StringBuffer();

            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer 에 응답받은 데이터 순차적으로 저장

            }
            returnData = sb.toString(); //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입

            //TODO
            System.out.println("http 응답 데이터 : " + returnData); //요청 응답데이터 확인


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //http 요청 및 응답 완료 후 BufferedReader 를 닫음
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 사전에 발급받은 token 값, 전송대상서버의 URL, get 대상 필드를 선택하기 위한 key값(예: token,
     * URL, primary_key)을 매개변수로 전달 반환값은 성공시 key값에
     * 해당하는 DB 테이블내의 필드값을 저장하고 있는 XML 이 포함된 String 실패시 실패원인 반환(서버에서
     * Exception 을 통해 에러메시지 반환)
     * insert 와 update 처럼 파라미터를 만들어 주는 부분은 필요 없기때문에 파라미터 생성 구문은 생략
     * 단순 get을 하경우 CognitiveTraining 등록된 모든 값이 출력되기 때문에 delete 함수와 동일한게 primary_key 매개변수를 만들어 URL뒤에 AID 값을 붙혀 특정 아이디 목록만 값을 나타낼 수 있도록 함.
     * @auther 박성훈
     */
    public String xml_drp_get(String token, String URL, String primary_key) {
        //get 부분 구현
        //http 요청시 test_XmlApiPost 객체에서 셋팅된 URL 주소와 파라미터 데이터를 결합하기 위한 변수
        String totalUrl = "";
        URL = URL + "/" + primary_key;
        totalUrl = URL.trim().toString();

        //http 통신을 하기위한 객체
        java.net.URL url = null;
        HttpURLConnection con = null;

        //http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
        String responseData = "";
        BufferedReader br = null;
        StringBuffer sb = null;

        String returnData = ""; //메소드 호출 결과값을 반환하기 위한 변수

        try {
            //파라미터로 들어온 url을 사용해 connection 실시
            url = new URL(totalUrl);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET"); //POST 요청방식 설정(POST, GET 설정가능)
            con.setDoOutput(true); //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션
            con.setDoInput(true); //InputStream으로 서버로 부터 응답을 받겠다는 옵션.

            //Request 헤더를 만들어주는 부분
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Accept-Charset", "UTF-8");
            con.setRequestProperty("Accept", "*/*");
            con.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            con.connect(); //http 요청 실시

            System.out.println("http 요청 방식 : " + "GET BODY XML");
            System.out.println("http 요청 타입 : " + "application/json");
            System.out.println("http 요청 주소 : " + URL);
            System.out.println("http 요청 데이터 : " + primary_key);
            System.out.println("");

            String responseCode = String.valueOf(con.getResponseCode());
            System.out.println("http 응답 코드 : " + responseCode); //요청응답 코드 확인

            //http 요청 후 서버로 부터 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(con.getInputStream())); //리턴 파람미터 출력
            sb = new StringBuffer();

            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer 에 응답받은 데이터 순차적으로 저장
            }
            returnData = sb.toString(); //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입

            //TODO
            System.out.println("http 응답 데이터 : " + returnData); //요청 응답데이터 확인


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //http 요청 및 응답 완료 후 BufferedReader 를 닫음
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 사전에 발급받은 token 값, 전송대상서버의 URL, get 대상 필드를 선택하기 위한 key값(예: token,
     * URL)을 매개변수로 전달 반환값은 성공시 key값에
     * 해당하는 DB 테이블내의 필드값을 저장하고 있는 XML 포함된 String 실패시 실패원인 반환(서버에서
     * Exception 을 통해 에러메시지 반환)
     * insert 와 update 처럼 파라미터를 만들어 주는 부분은 필요 없기때문에 파라미터 생성 구문 생략
     *
     * @auther 박성훈
     */
    public String xml_drp_get_list(String token, String URL) {
        //get 부분 구현
        //http 요청시 test_XmlApiPost 객체에서 셋팅된 URL 주소와 파라미터 데이터를 결합하기 위한 변수
        String totalUrl = "";
        totalUrl = URL.trim().toString();

        //http 통신을 하기위한 객체
        java.net.URL url = null;
        HttpURLConnection con = null;

        //http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
        String responseData = "";
        BufferedReader br = null;
        StringBuffer sb = null;

        String returnData = ""; //메소드 호출 결과값을 반환하기 위한 변수

        try {
            //파라미터로 들어온 url을 사용해 connection 실시
            url = new URL(totalUrl);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET"); //POST 요청방식 설정(POST, GET 설정가능)
            con.setDoOutput(true); //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션
            con.setDoInput(true); //InputStream으로 서버로 부터 응답을 받겠다는 옵션.

            //Request 헤더를 만들어주는 부분
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Accept-Charset", "UTF-8");
            con.setRequestProperty("Accept", "*/*");
            con.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            con.connect(); //http 요청 실시

            System.out.println("http 요청 방식 : " + "GET BODY XML");
            System.out.println("http 요청 타입 : " + "application/json");
            System.out.println("http 요청 주소 : " + URL);
//                System.out.println("http 요청 데이터 : " + xml);
            System.out.println("");

            String responseCode = String.valueOf(con.getResponseCode());
            System.out.println("http 응답 코드 : " + responseCode); //요청응답 코드 확인

            //http 요청 후 서버로 부터 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(con.getInputStream())); //리턴 파람미터 출력
            sb = new StringBuffer();

            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer 에 응답받은 데이터 순차적으로 저장
//                    System.out.println("http 응답 데이터 : \n" + sb.toString() + "\n"); //요청 응답데이터 확인
            }
            returnData = sb.toString(); //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입

            //TODO
            System.out.println("http 응답 데이터 : " + returnData); //요청 응답데이터 확인


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //http 요청 및 응답 완료 후 BufferedReader 를 닫음
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }
}
