import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author 姜涛
 * @date 2023/5/8 17:35
 */
@Slf4j
public class test {

    public static class t1 {
        private final String X_APP_ID = "4f6a395318a5f2608b531a905ba8e366";

        private final String X_APP_KEY = "966c3ccc596a06d7f3eb58fd5f485cf8";

        private String nonce;

        private Long ts;

        private String sign;
    }


            public static String getSign(String appId, String appSecret, Long ts, String nonce) {
                return stringToSha256("ts=" + ts + "&nonce=" + nonce + "&appId=" + appId + "&appSecret=" + appSecret);
            }

            public static String stringToSha256(String inStr) {
                String secret = "gye723e8267";
                try {
                    Mac mac = Mac.getInstance("HmacSHA256");
                    SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
                    mac.init(secretKey);
                    byte[] hash = mac.doFinal(inStr.getBytes(StandardCharsets.UTF_8));
                    return Base64.encode(hash);
                    //return Base64.encodeBase64String(hash);
                } catch (Exception e) {
                    return inStr;
                }
            }

            public static void main(String[] args) {
                JSONObject reqJson = new JSONObject();
//                reqJson.put("page",0);
//                reqJson.put("pagesize",5);
//                String url = "http://10.128.86.64:8000/serviceAgent/rest/yan1/getPcmSomeInfo";
//                Map<String,String> headerMap = new HashMap<>();
//                headerMap.put("X-APP-ID","4f6a395318a5f2608b531a905ba8e366");
//                headerMap.put("X-APP-KEY","966c3ccc596a06d7f3eb58fd5f485cf8");
//
//                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), reqJson.toJSONString());
//                Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headerMap)).build();
//                System.out.println(request);
//                OkHttpClient okHttpClient = new OkHttpClient.Builder().sslSocketFactory(sslSocketFactory(), x509TrustManager())
//                        .retryOnConnectionFailure(false)//是否开启缓存
//                        .connectionPool(new ConnectionPool(200, 5, TimeUnit.MINUTES))//连接池
//                        .connectTimeout(4000, TimeUnit.SECONDS).readTimeout(4000, TimeUnit.SECONDS).build();
//                Response response = null;
//                try {
//                    response = okHttpClient.newCall(request).execute();
//                    log.info(JSONObject.toJSONString(response.body()));
//
//                    System.out.println(JSONObject.toJSONString(response));
//                } catch (IOException e) {
//                    log.error("错误异常",e);
//                }finally {
//                    if (response != null) {
//                        response.close();
//                    }
//                }


                String nonce = UUID.randomUUID().toString().replace("-", "");
                // appId对应页面AK
                String appId = "fvbdhsxi";
                // appSecret对应页面SK
                String appSecret = "SuXIv7vgsIWRxvX22gRBu1BLix4OrgJaS1yNf0KKXHjVaGJbCtiMsvEqlScLhTOL&&&&0HMdmNeHsHYGh0fMkly//Q==";
                Long ts = System.currentTimeMillis();
                System.out.println("nonce: " + nonce);
                log.info(nonce);
                System.out.println("ts: " + ts);
                log.error(ts.toString());
                String sign = getSign(appId, appSecret, ts, nonce);
                log.warn(sign);
                System.out.println("sign: " + sign);

            }





    }
