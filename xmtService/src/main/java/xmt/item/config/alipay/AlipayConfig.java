package xmt.item.config.alipay;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021002144687541";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCoFr88J3/FuBdG0yiJcZcvoHZKgsNYFzce5OhtKK+RlztrKdiaClEWgmwD854IPnurbkaqDMChajNsU9uDTYDCrdrE5fpOzNvWY6GLqpiqSshCv3D6itigf1zAMji94yRMjNYqA+Y83Jn2ZcsKhTnQRTziP1BgtK1/FIgZsVxHiUnADz6AGS7wbSd6bjGG4N5e+apAL0keerHovNYxkkGSdjm8nWxda4LHigTye9I2L7x+lrNvWjKYMwP2g5j2LgYW0HiuWCD9BYSb8yptsqOxiIdVANfXVpoDe+L5SqzXJYw0DNDh4sQMWQrzto17H4A4OwmRbdsE6WXTMo8cfg35AgMBAAECggEANw2kOvaQ8dhWv1q/xyyOIQpEVCk6A+suoY7F1aLixiOrUXEWQXWpk17KNA0hsH+Oj9qBiIa+vN+E0jExD3Nd/eVlZuIQNqkAQ9rD+XO5puTxbHM5dMXvJ7ovTb/lN8RiijQCnSZDzaFPSBWVB/AUvHNA+rVUBSiIPrwhy5B8sezpm1QJCk8YWSPn7WNlv+GgCPgfXThTwBjdtM/2/mKxF6fODVllnT/jh0bYyCxMCufb/aSBYUVVO50Ows0LbVOUWbQZPfM3VJOoxlrwWErLQdoVELtDXL7zE6K01THZuiI5UupW5kXJYKVuWVDC71iW2FmYVjKG/7Q1jVDv8rgRVQKBgQD+p+N7f86IvY6JrYhwjoYdyUuEB0WioUaUPoek83IWiUgj1PYmWZzFTPo0POdWuydNMdB0lmynAgDSFt+D2Pcg9hWCq6N7JAPyHiB+WfcbUbr5aOd7nohcut2yzilA17qIC3MilXU+J/FgRQjiMXyzuBpNOMr9BtTfnOgv/cPsLwKBgQCo+eHWacdnQqUqikvv/hk6zJyBlhjnL0f2t5TI4fA68QfB9AQGheH65c+0SdkUk8gIkmgcNz7IJkmKz3WLAIgIvJdKL7v3oSGRCUsn+kSeun/FfVKkPsn4y5uqhcNS1U54jvsAnn8/81/2W7qhTdDbNNrsIDbMvoKQ514kcj9WVwKBgBr4cwpYbepjkR4Zx/KL1b5/3ESedIyV4iC/QqSAuBuU7JQG8Q78vLLUxUcVEDdKWQ4+8WH3sIg7mRSnIYMYTowqI/sT7JuVI+nXsP9QzfARxui1aJbaIn0XuXU/inT4pCPWepo2FBXCKzlT9m3maduq6vY0xqLnv1Hzj0/N45s3AoGBAKFfYupdwu0+nHXv9W2RAY9B8QVgzw+Z++QGlrTx8XaY0YvM+jswiQwPhTjsfcBFEff9uieYKwECb6F9VwgUzdVqJiHXTG/FFkVo1rmrLPVZrsRwVwg8Xq6X5GYJsOvegj5obhW9SFFOoAqqt6Vsp1VxONHgQfVuy0qPazzrTsmpAoGAaR0OWJlVdi5pGjy6o+tZjcsyNkgBldPCCLt6d3J5OK57TPyM3/vWZp4Degke5/dFva4AJi8P7TAfrJBdgDLXgvOzzMX78rsZfYWBX/B3hrzoEMYfardee/Txyznx3utrQpR7xBb5DJRmyIh4HkmThPYcEgB1wuLL0zv6zXIkr3k=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqBa/PCd/xbgXRtMoiXGXL6B2SoLDWBc3HuTobSivkZc7aynYmgpRFoJsA/OeCD57q25GqgzAoWozbFPbg02Awq3axOX6Tszb1mOhi6qYqkrIQr9w+orYoH9cwDI4veMkTIzWKgPmPNyZ9mXLCoU50EU84j9QYLStfxSIGbFcR4lJwA8+gBku8G0nem4xhuDeXvmqQC9JHnqx6LzWMZJBknY5vJ1sXWuCx4oE8nvSNi+8fpazb1oymDMD9oOY9i4GFtB4rlgg/QWEm/MqbbKjsYiHVQDX11aaA3vi+Uqs1yWMNAzQ4eLEDFkK87aNex+AODsJkW3bBOll0zKPHH4N+QIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问（可以使用natapp内容穿透完成外网设置）
    public static String notify_url = "http://nnxybi.natappfree.cc/front/alipay/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问（可以使用natapp内容穿透完成外网设置第四部分讲解natapp使用配置）
    public static String return_url = "http://nnxybi.natappfree.cc/front/alipay/aliReturnPay";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "c:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
